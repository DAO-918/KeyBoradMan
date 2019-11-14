$(function () {

    Gian_code();
    login_admin()


    function Gian_code() {
        $("#gain_code").click(function () {
            $.ajax({
                url:'/admin/code',
                type:'POST',
                dataType:'JSON',
                success:function (result) {
                    alert(result.extend.code)
                }
            })
        })
    }


    function login_admin() {
        $(".btn-block").click(function () {


            var data = {};

            var name = $("#user_name").val();
            var password = $("#password").val();
            var codes = $("#codes").val();


            $.ajax({
                url:'/admin/loginAdmin',
                data:{
                    codes:codes,
                    admin_login_name:name,
                    admin_login_pwd:password,
                },
                type:'POST',
                dataType:'JSON',
                success:function (result) {
                    var message = result.extend.message;
                    if(message == 200){
                        window.location.replace("http://localhost:8080/view/Admin/admin.html")
                    }
                    if(message == 501){
                        alert("用户名或者密码错误")
                    }
                    if(message == 502){
                        alert("验证码错误")
                    }
                    if(message == 503){
                        alert("用户名或密码不能为空")
                    }


                }
            })




        })


    }

})