$(function () {
    // totalRecord:总记录数
    // currentPage:当前页
   var totalRecord,currentPage;
   //显示第一页
   to_Page(1);
   //添加标签
   addArticleTag();
   //删除标签
   deleteTag();


    /**
     *
     */
    function to_Page(pageNo) {
        $.ajax({
            url:"/all",
            data:"pageNo="+pageNo,
            // data:{pageNo:pageNo,_method:"GET"},
            type:"GET",
            success:function (all) {
                //显示标签表信息数据
                articleTagAll(all);
                //显示分页信息
                build_page_info(all);
                //显示分页条数据
                build_page_nav(all);
            }
        })
    }
    function articleTagAll(all) {
        $("#articleTag_table tbody").empty();
        var articleTagList= all.extend.pageInfo.list;
        //遍历获取到的标签
        $.each(articleTagList,function (index, item) {
            /**
             * private Integer tag_id;
             private Integer tag_cid;//标签类别
             private String tag_name;
             private String tag_content;
             * @type {jQuery}
             */
           var id=$("<td></td>").append(item.tag_id);
           var name=$("<td></td>").append(item.tag_name);
           var content=$("<td></td>").append(item.tag_content);
           var cid=$("<td align='center'></td>").append(item.tag_cid);
           //$("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append
           var button_bj=$("<button></button>").addClass("layui-btn layui-btn-mini ").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("编辑");
           //($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append
           var button_sc=$("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-mini delete_tag").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("删除");
           var td_button=$("<td></td>").append(button_bj).append(button_sc);
           $("<tr></tr>").append(name).append(content).append(cid).append(td_button).append(id).appendTo("#articleTag_table tbody");

        })
    }
    function build_page_info(all) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+all.extend.pageInfo.pageNum
            +"页,总共"+all.extend.pageInfo.pages+"页，总共"
            +all.extend.pageInfo.total + "条记录");
        totalRecord=all.extend.pageInfo.total;
        currentPage=all.extend.pageInfo.pageNum;
    }
//解析显示分页导航条
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination pagination-sm");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        //如果没有前一页，前一页和首页就不能点
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //首页
            firstPageLi.click(function () {
                to_Page(1);
            });
            prePageLi.click(function () {
                to_Page(result.extend.pageInfo.pageNum - 1);
            });
        }
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            //构建点击事件

            nextPageLi.click(function () {
                to_Page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_Page(result.extend.pageInfo.lastPage);
            })
        }
        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        //遍历添加页码
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
            //如果是当前选中页面，添加active标识
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            //给每个页码添加点击就跳转
            numLi.click(function () {
                to_Page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }







    /**
     * 删除操作
     */
    function deleteTag() {
        $(document).on("click",".delete_tag",function () {
            // var name=$(this).parents("tr").find("td:eq(2)").text;
            var id = $(this).parents("tr").find("td:eq(4)").html();

            alert(id);
            if (confirm("确定删除吗?")){
                $.ajax({
                    url:"/deletetag/"+id,
                    Type:"POST",
                    type:"delete",
                    /*contentType:"application/json;charset=utf-8",*/
                    data:{_method:"DELETE"},
                    dataType:"json",
                    success:function (all) {
                            alert(all.message);
                        to_Page(currentPage);
                    }
                })
            }
        })
    }


});