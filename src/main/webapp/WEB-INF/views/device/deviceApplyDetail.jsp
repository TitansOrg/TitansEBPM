<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>设备管理表</title>
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
    </head>
    <body>
        <div class="box-body form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">ID</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="id" value="<%=request.getParameter("id") %>">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">number</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="number">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">name</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">processId</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="processId">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">status</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="status">
                </div>
            </div>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/iCheck/icheck.min.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.dialog.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.date.js"></script>
    <script>
        $(function() {

        	pageDataInit();
        });

        function pageDataInit() {

            var id = $("#id").val();
            if (id != "null") {

                $.ajax({

                    type: "POST",
                    dataType:"json",
                    url: "<%=serverName%>/device/queryDetailInfoById.do",
                    data: {

                        id : id
                    },
                    success: function(data) {

                        $("#id").val(data.id);
                        $("#number").val(data.number);
                        $("#name").val(data.name);
                        $("#processId").val(data.processId);
                        $("#status").val(data.status);
                    }
                });
            }
        }

        function toSubmit(dialog, id) {

            var param = {

                number : $("#number").val(),
                name : $("#name").val()
            };
            $.ajax({

                type: "POST",
                dataType:"json",
                contentType: 'application/json',
                url: "<%=serverName%>/device/saveOrUpdate.do",
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