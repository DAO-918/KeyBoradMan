$(function () {
    var totalRecord,currentPage;
    // 首页显示
    to_page(1);
    // 带条件查询
    $("#seek_btn").click(function () {
        to_page(1)
    })
    // 添加管理员
    add_admin();
    // 删除管理员
    delete_admin();


    function to_page(pageNo) {
        var data = {pageNo: pageNo}
        var name = $("#seek_name").val();

        if (name != '') {
            data.admin_login_name = name;
        }

        $.ajax({
            url: '/admin/findAll',
            data: data,
            type: 'GET',
            dataType: 'json',
            success: function (result) {
                table_page(result)
                //2.解析并显示分页信息
                build_page_info(result);
                //3.解析并显示分页条数据
                build_page_nav(result);
            }
        })
    }


    function table_page(result) {
        $("#admin_table tbody").empty();
        var adminList = result.extend.pageInfo.list;
        $.each(adminList, function (index, item) {
            var checkBox = $("<td><input type='checkbox' class='check_item'></td>");
            var admin_id = $("<td></td>").append(item.admin_id);
            var adminName = $("<td></td>").append(item.admin_login_name);
            var adminPwd = $("<td></td>").append(item.admin_login_pwd);
            var adminDat = $("<td></td>").append(item.admin_login_date);

            var button1 = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("编辑");
            var button2 = $("<button></button>").addClass("tn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("删除");
            var button3 = $("<button></button>").addClass("delete").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("测试");
            var td_btn = $("<td></td>").append(button1).append(" ").append(button2)

            $("<tr></tr>").append(checkBox).append(admin_id).append(adminName).append(adminPwd).append(adminDat).append(td_btn).appendTo("#admin_table tbody")
        })
    }

        //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总共" + result.extend.pageInfo.pages +
            "页，总共" + result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
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
            var numLi = $("<li></li>").append($('<a></a>').append(item).attr("href", "#"));

            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("disabled");
            }
            ;

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


    // 添加管理员
    function add_admin() {
        $("#admin_add_modal_btn").click(function () {
            $.ajax({
                url:'/admin/addAdmin',
                type:'PUT',
                dataType:'json',
                success:function (result) {
                    var name = result.extend.admin.admin_login_name;
                    var password = result.extend.admin.admin_login_pwd;
                    alert("新增管理员用户名为:"+name+"密码为："+password)
                    to_page(totalRecord);
                }
            })
        })
    }


    // 删除管理员
    function delete_admin() {
        $(document).on("click",".delete_btn",function () {
            var id = $(this).parents("tr").find("td:eq(1)").text();
            var name = $(this).parents("tr").find("td:eq(2)").text();

            if(confirm("确定要删除管理员【"+name+"】吗")){
                $.ajax({
                    url:'/admin/deleteAdmin',
                    data:{uid:id},
                    type:'POST',
                    dataType:'JSON',
                    success:function (result) {
                        alert(result.message);
                        to_page(currentPage);
                    }

                })
            }
        })


    }
})