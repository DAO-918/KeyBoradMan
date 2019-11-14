$(function () {
    var totalRecord,currentPage;

    to_page(1);
    // 禁用与启用用户
    stop_or_start();

    $(document).on('click','#seek_btn',function () {
        to_page(1)
    })

    findAll();



    function to_page(pageNo) {

        var data = {pageNo:pageNo};


        var name = $("#seek_name").val()
        var sex = $("#seek_sex").val()
        var fans = $("#seek_fans").val()
        //
        if(name != ''){
           data.user_name = name;
        }else{
            name = 'null';
        }
        if(sex != '' && sex != null){
            data.user_sex = sex;
        }

        data.user_fans = fans;


        $.ajax({
            url:"/userInfo/findUser",
            data:data,
            type:"GET",
            success:function (result) {
                build_userInfo_table(result)
                build_page_info(result)
                build_page_nav(result)
            }
        })


    }

    // 分页列表
    function build_userInfo_table(result) {
        $("#userinfo_table tbody").empty();
        var userinfoList =  result.extend.pageInfo.list;
        $.each(userinfoList,function (index, item) {
            var checkBox = $("<td><input type='checkbox' class='check_item'/></td>")
            var id = $("<td></td>").append(item.user_id);
            var img = $("<td></td>").append(item.user_img);
            var name = $("<td></td>").append("<a ></a>").append(item.user_name).attr("href","#").addClass("user_nameClass");
            var sex = $("<td></td>").append(item.user_sex);
            var ex = $("<td></td>").append(item.user_ex);
            var fans = $("<td></td>").append(item.user_fans);
            var Concern = $("<td></td>").append(item.user_concern);
        //    文章数量
            var ac = $("<td></td>").append(item.articleCount);

            var user_status = item.user.user_status;
            var button ;
            if(user_status == 1){
                button = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("禁用");
            }else{
                button = $("<button></button>").addClass("btn btn-danger btn-sm ").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("启用");
            }

            $("<tr></tr>").append(checkBox).append(id).append(img) .append(name).append(sex).append(ex).append(fans).append(Concern).append(ac).append(button).appendTo("#userinfo_table tbody");
        })
    }

    //解析显示分页信息
   function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append(
            "当前"+result.extend.pageInfo.pageNum+"页，总共"+
            result.extend.pageInfo.pages+"页，总共"+
            result.extend.pageInfo.total+"条记录");
       totalRecord = result.extend.pageInfo.total;
       currentPage=result.extend.pageInfo.pageNum;
   }

    // 解析显示分页导航条
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));

        if(result.extend.pageInfo.hasPreviousPage == false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            firstPageLi.click(function () {
                to_page(1)
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            })
        }

        if(result.extend.pageInfo.hasNextPage == false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled")
        }else{
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.lastPage);
            })
        }

        ul.append(firstPageLi).append(prePageLi);

        // 遍历添加页码
        $.each(result.extend.pageInfo.navigatepageNums,function (index, item) {
            var numLi = $("<li></li>").append($('<a></a>').append(item).attr("href","#"));

            if(result.extend.pageInfo.pageNum == item){
                numLi.addClass("disabled");
            };

            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });

        ul.append(nextPageLi).append(lastPageLi);

        var navEle = $("<nav></nav>").append(ul);

        navEle.appendTo("#page_nav_area");
    }


    // 禁用启用
    function stop_or_start() {
        $(document).on('click',".btn",function () {
            var id = $(this).parents("tr").find("td:eq(1)").text();
            var name = $(this).parents("tr").find("td:eq(3)").text();
            var staus = $(this).text();

            var id2 = parseInt(id);

            if(confirm("【"+name+"】账户当前的状态为【"+staus+"】，确认是否改变")){
                $.ajax({
                    url:'/user/update',
                    data:{uid:id2},
                    type:'POST',
                    dataType:'json',
                    success:function (result) {
                        alert(result.message);
                        to_page(currentPage);
                    }
                })
            }
        })
    }


    // 用户详细信息 模态框
    function findAll() {
        $(document).on('click','.user_nameClass',function () {
            $("#userInfoAllModal form")[0].reset();
            var id = $(this).parents("tr").find("td:eq(1)").text();


            $.ajax({
                url:'/userInfo/findAll',
                data:{uid:id},
                type:'GET',
                dataType:'json',
                success:function (result) {
                    var userInfo = result.extend.list;



                        $("#name_all_input").val(userInfo.user_name);
                        $("#email_all_input").val(userInfo.user_email);
                        $("#sex_all_input").val(userInfo.user_sex);
                        $("#phone_all_input").val(userInfo.user_phone);
                        $("#ex_all_input").val(userInfo.user_ex);
                        $("#time_all_input").val(userInfo.user_time);
                        $("#show_all_input").val(userInfo.user_show);
                        $("#fans_all_input").val(userInfo.user_fans);
                        $("#concren_all_input").val(userInfo.user_concern)

                }

            });

            $("#userInfoAllModal").modal({
                backdrop:"static"
            })
        })
    }
});