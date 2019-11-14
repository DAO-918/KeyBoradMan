$(function () {
    var totalRecord,currentPage;
    to_Page(1);
    //删除文章
    deleteArticle();

    function to_Page(pageNo){
        $.ajax({
            url:"/userid",
            //data:"user_id=1"+"&pageNo="+pageNo,
            data:{user_id:1,pageNo:pageNo},
            Type:"GET",
            dateType:"json",
            success:function (result) {
                $("#testJson").append(JSON.stringify(result))
                //显示文章表信息
                build_article_all(result);
                //显示分页
                build_page_info(result);
                //显示分页条数据
                build_page_nav(result);
            }
        })
    }
    function build_article_all(result) {
        $("#article_table tbody").empty();
        var articleList=result.extend.pageInfo.list;
        // 遍历
        /**
         * private Integer art_id;
         private Integer art_user_id;
         private String art_theme;
         private String art_title;
         private Integer art_tag_id;
         private Integer art_category_id;
         private String art_content;
         private String art_img;
         private Date art_create_time;
         private Integer art_com_num;
         private Integer art_hot_num;
         private Integer art_like_num;
         */
        $.each(articleList,function (index, item) {
            var checkbox=$("<td><input type='checkbox' name='checkbox' class='check_item' lay-skin='primary' lay-filter='allChoose'/></td>");
            var id = $("<td></td>").append(item.art_id);
            var userid=$("<td></td>").append(item.art_user_id);
            var art_theme=$("<td></td>").append(item.art_theme);
            var art_title=$("<td></td>").append(item.art_title);
            var art_tag_id=$("<td></td>").append(item.art_tag_id);
            var art_category_id=$("<td></td>").append(item.art_category_id);
            var art_content=$("<td></td>").append(item.art_content);
            var art_img=$("<td></td>").append(item.art_img);
            var art_create_time=$("<td></td>").append(item.art_create_time);
            var art_com_num=$("<td></td>").append(item.art_com_num);
            var art_hot_num=$("<td></td>").append(item.art_hot_num);
            var art_like_num=$("<td></td>").append(item.art_like_num);
            // var button1=$("<button></button>").addClass("layui-btn layui-btn-small layui-btn-normal go-btn").addData-id("1").addData-url("article-detail.html").append("<i></i>").addClass("layui-icon").append("&#xe642;");
             var button1=$("<button></button>").addClass("layui-btn layui-btn-mini ").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("编辑");
            // var button2=$("<button></button>").addClass("layui-btn layui-btn-small layui-btn-danger del-btn").addData-id("1").addData-url("article-detail.html").append("<i></i>").addClass("layui-icon").append("&#xe640;");
             var button2=$("<button></button>").addClass("layui-btn layui-btn-danger layui-btn-mini del-btn").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("删除");
            var butttd=$("<td></td>").append(button1).append(button2);
            $("<tr></tr>").append(checkbox).append(id).append(userid)
                .append(art_title).append(art_tag_id).append(art_category_id).append(art_content)
                .append(art_img).append(art_create_time).append(art_com_num).append(art_hot_num).append(art_like_num).append(butttd).appendTo("#article_table tbody")

        })
    }
    //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总共" + result.extend.pageInfo.pages +
            "页，总共" + result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage=result.extend.pageInfo.pageNum;
    }

//解析显示分页导航条
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
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
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            //构建点击事件

            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.lastPage);
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
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    /**
     * 删除
     */

    function deleteArticle() {
        $(document).on("click",".del-btn",function () {
            //1.弹出确认删除对话框
            /**
             * $("tr:eq(1)  td:eq(2)"):这代表了要选中表格的第二行中的第三个单元格

             如果在后面再加上.text() 代表要取出这个单元格中的文本。

             注意以下三种情况用法

             .text()

             .html()

             .val()
             */
            var name=$(this).parents("tr").find("td:eq(1)").text;
            var id=$(this).parents("tr").find("td:eq(5)").text;
            if (confirm("确定删除【"+name+"】吗？")){
                alert(id);
                //确定删除后发送ajax请求
                $.ajax({
                    url:"/deleteArticle/"+id,
                    Type:"POST",
                    type:"delete",
                    data:{_method:"DELETE"},
                    dataType:"json",
                    success:function (result) {
                        alert(result.message);
                        to_Page(currentPage)
                    }
                })
            }
        })
    }




});