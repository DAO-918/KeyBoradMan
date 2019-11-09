//1.页面加载完成之后发送Ajax请求，要到分页数据

$(function () {
    var totalRecord,currentPage;
    //显示第一页
    to_page(1);

    /**
     * 1.实现文章展示
     * @param pn
     */
    //显示全部文章
    function to_page(pageNo) {

        $.ajax({
            url: "/article",
            data: "pageNo=" + pageNo,
            type: "GET",
            success: function (result) {
                //1.解析并显示文章
                build_article_table(result);
                //2.解析并显示分页信息
                build_page_info(result);
                //3.解析并显示分页条数据
                build_page_nav(result);

            }
        })
    }

    //解析并显示文章
    function build_article_table(result) {
        //清空table表格
        $("#article_div").empty();
        var articleList = result.extend.pageInfo.list;
        $.each(articleList, function (index, item) {
            var str = "    <div class=\"col-lg-12\">\n" +
                "            <div class=\"ibox\" >\n" +
                "                <div class=\"ibox-content\">\n" +
                "                    <a href=\"article.html\" class=\"btn-link\">\n" +
                "                        <h2>\n" + item.art_title +
                "                        </h2>\n" +
                "                    </a>\n" +
                "                    <div class=\"small m-b-xs\">\n" +
                "                        <strong>"+ item.user.user_name+ "</strong> <span class=\"text-muted\"><i class=\"fa fa-clock-o\"></i>"+ result.time+"</span>\n" +
                "                    </div>\n" +
                "                    <p>\n" + item.art_content +
                "                    </p>\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-6\">\n" +
                "                            <h5>标签：</h5>\n" +
                "                            <button class=\"btn btn-primary btn-xs\" type=\"button\">"+ item.article_tag.tag_name+"</button>\n" +
                "                            <!--<button class=\"btn btn-white btn-xs\" type=\"button\">速比涛</button>-->\n" +
                "                        </div>\n" +
                "                        <div class=\"col-md-6\">\n" +
                "                            <div class=\"small text-right\">\n" +
                "                                <h5>状态：</h5>\n" +
                "                                <div> <i class=\"fa fa-comments-o\"> </i>"+  item.art_com_num+"&nbsp;&nbsp;评论 </div>\n" +
                "                                <div> <i class=\"fa fa-eye\"> </i>"+  item.art_hot_num +"&nbsp;&nbsp;浏览</div>\n" +
                "                                <div> <i class=\"glyphicon glyphicon-thumbs-up\"> </i>"+  item.art_like_num+"&nbsp;&nbsp;点赞</div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>";
            $("#article_div").append(str);
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
        var ul = $("<ul></ul>>").addClass("pagination");
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

});