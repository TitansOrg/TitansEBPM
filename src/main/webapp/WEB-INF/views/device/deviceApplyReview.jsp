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
        <input type="hidden" id="taskId" value="<%=request.getParameter("taskId") %>">
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
        <hr/>
        <div class="box-body form-horizontal">
            <div id="note" class="form-group">
                <label class="col-sm-2 control-label text-center">备注</label>
                <div class="col-sm-6">
                    <textarea id="noteContent" class="form-control"></textarea>
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
            branchBtnInit();
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

        function branchBtnInit() {

            var taskId = $("#taskId").val();
            $.ajax({

                type: "POST",
                dataType:"json",
                url: "<%=serverName%>/workflow/queryTaskBranchInfo.do",
                data: {

                    taskId : taskId
                },
                success: function(data) {

                    var html = "";
                    for (var str in data) {

                        html = html + "<div class='form-group'>"
                            + "<div class='col-sm-2' style='text-align: right;'>"
                            + "<input type='radio' name='branch' class='radio icheck' value='" + data[str] + "'>"
                            + "</div>"
                            + "<label class='col-sm-2' style='padding-top:0px;'>" + data[str] + "</label>"
                            + "</div>";
                    }
                    $("#note").before(html);
                    $(":radio").iCheck({

                        radioClass: 'iradio_square-blue'
                    });
                }
            });
        }

        function toSubmit(dialog, id) {

            $.ajax({

                type: "POST",
                dataType:"json",
                url: "<%=serverName%>/workflow/submitTask.do",
                data: {

                    branch : $("input[name=branch]:checked").val(),
                    note : $("#noteContent").val(),
                    taskId : $("#taskId").val()
                },
                success: function(data) {

                    if (data) {

                        alert("提交成功！");
                        dialog.closeDialog(id);
                    } else {

                        alert("提交失败！");
                    }
                }
            });
        }
    </script>
</html>