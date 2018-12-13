<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>流程管理平台</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
    </head>
    <body class="hold-transition login-page" style="padding-top: 7%">
        <div class="login-box" style="margin:0 auto 0 auto;">
            <div class="login-logo">
                <b>流程管理平台</b>
            </div>
            <div class="login-box-body">
                <p id="loginInfo" class="login-box-msg">请输入您的账号和密码</p>
                <div class="form-group has-feedback">
                    <input id="usercode" type="text" class="form-control" placeholder="账号">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input id="password" type="password" class="form-control" placeholder="密码">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button onclick="login();" class="btn btn-primary btn-block btn-flat">登录</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script>
        function login() {

            $.ajax({

                url: "<%=serverName%>/login/login.do",
                data: {

                    usercode: $("#usercode").val(),
                    password: $("#password").val()
                },
                dataType: "json",
                success: function(data) {

                    if (data) {

                        location.href = "<%=serverName%>/login/mainPage.do";
                    } else {

                        $("#loginInfo").text("账号或密码输入不正确！").css("color","red");
                    }
                }
            });
        }
    </script>
</html>