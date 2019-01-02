<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>用户管理表</title>
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/select2/select2.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
    </head>
    <body>
        <input id="id" type="hidden" value="<%=request.getParameter("id") %>"/>
        <div class="box-body form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">用户账号</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="usercode" placeholder="用户账号">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">用户名称</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="username" placeholder="用户名称">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">用户密码</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="password" placeholder="用户密码">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">角色</label>
                <div class="col-sm-6">
                    <select id="roleList" class="form-control select2"></select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">创建时间</label>
                <div class="col-sm-6">
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="createTime" placeholder="创建时间">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">更新时间</label>
                <div class="col-sm-6">
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="updateTime" placeholder="更新时间">
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/iCheck/icheck.min.js"></script>
    <script src="<%=serverName%>/js/select2/i18n/zh-CN.js"></script>
    <script src="<%=serverName%>/js/select2/select2.full.min.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.dialog.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.date.js"></script>
    <script>
        $(function() {

            $.ajax({

                type: "POST",
                dataType:"json",
                url: "<%=serverName%>/role/getSysRoleList.do",
                success: function(data) {

                    var options = [];
                    for(var i = 0; i < data.length; i++) {

                        options.push({id: data[i].id, text: data[i].name});
                    }
                    $("#roleList").select2({

                        data: options,
                        multiple: true,
                        placeholder: "请选择角色",
                        width:"460px"
                    });
                    pageDataInit();
                }
            });
            $("#createTime").datepicker({

                language: "zh-CN",
                format: "yyyy-mm-dd",
                autoclose: true
            });
            $("#updateTime").datepicker({

                language: "zh-CN",
                format: "yyyy-mm-dd",
                autoclose: true
            });
        });

        function pageDataInit() {

            var id = $("#id").val();
            if (id != "null") {

                $.ajax({

                    type: "POST",
                    dataType:"json",
                    url: "<%=serverName%>/user/queryDetailInfoById.do",
                    data: {

                        id : id
                    },
                    success: function(data) {

                        $("#usercode").val(data.usercode);
                        $("#username").val(data.username);
                        $("#password").val(data.password);
                        $("#createTime").val(getSmpFormatDateByLong(data.createTime,false));
                        $("#updateTime").val(getSmpFormatDateByLong(data.updateTime,false));
                        var roles = data.roles;
                        var options = [];
                        for (var i = 0; i < roles.length; i++) {

                            options.push(roles[i].id);
                        }
                        $('#roleList').val(options).trigger('change');
                    }
                });
            }
        }

        function toSubmit(dialog, id) {

            var roles = [];
            $.each($("#roleList").val(), function(i, n) {

                var role = {

                    id : n,
                }
                roles.push(role);
            });
            var param = {

                id : $("#id").val(),
                usercode : $("#usercode").val(),
                username : $("#username").val(),
                password : $("#password").val(),
                createTime : $("#createTime").val(),
                updateTime : $("#updateTime").val(),
                roles : roles
            };
            $.ajax({

                type: "POST",
                dataType:"json",
                contentType: 'application/json',
                url: "<%=serverName%>/user/saveOrUpdate.do",
                data: JSON.stringify(param),
                success: function(data) {

                    if (data) {

                        alert("保存成功！");
                        dialog.closeDialog(id);
                    } else {

                        alert("保存失败！");
                    }
                }
            });
        }
    </script>
</html>