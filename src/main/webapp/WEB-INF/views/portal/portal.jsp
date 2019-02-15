<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html style="height:100%;padding:0px;margin:0;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入口</title>
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/datatables.net-bs/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <style>
            .content {

                padding: 10px;
            }
            .strip1 {

                background-color: #F9F9F9;
            }
            .strip2 {


            }
            .table-cell-style{

                text-align: center;
            }
        </style>
    </head>
    <body class="hold-transition skin-blue sidebar-mini" style="background-color: #ecf0f5;">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title" style="font-weight: bold;">我的任务</h3>
                        </div>
                        <div class="box-body">
                            <table id="dataTable" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>taskId</th>
                                        <th>taskName</th>
                                        <th>createTime</th>
                                        <th>processId</th>
                                        <th>execId</th>
                                        <th>defId</th>
                                        <th>businessKey</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/datatables.net/jquery.dataTables.min.js"></script>
    <script src="<%=serverName%>/js/datatables.net-bs/dataTables.bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/iCheck/icheck.min.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.dialog.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.date.js"></script>
    <script>
        $(function () {

            var table = $("#dataTable").DataTable({

                language: {

                    url : "<%=serverName%>/js/datatables.net/i18n/resources_zh_CN.txt"
                },
                paging : true,
                pagingType : "full_numbers",
                lengthChange : true,
                lengthMenu: [

                    [10, 15, 30, -1],
                    [10, 15, 30, "All"]
                ],
                searching : true,
                ordering : false,
                info : true,
                autoWidth : true,
                ajax : {

                    url : "<%=serverName%>/workflow/getMyTaskList.do",
                    dataSrc : ""
                },
                order : [[1, "asc"]],
                stripeClasses : [ "strip1", "strip2"],
                columns : [

                    {data: "taskId"},
                    {data: "taskName"},
                    {data: "createTime"},
                    {data: "processId"},
                    {data: "execId"},
                    {data: "defId"},
                    {data: "businessKey"}
                ],
                columnDefs : [{

                    searchable : false,
                    orderable : false,
                    targets : 6,
                    className: "table-cell-style",
                    render : function(data, type, row) {

                        var result = "";
                        result = "<a href='javascript:void(0);' onclick='review(" + data + "," + row.taskId + ")'>审批</a>";
                        result = result  + "&nbsp;&nbsp;";
                        result = result + "<a href='javascript:void(0);' onclick='openDiagram(" + row.taskId + ")'>流程图</a>";
                        result = result  + "&nbsp;&nbsp;";
                        result = result + "<a href='javascript:void(0);' onclick='openProcessHisComment(" + row.taskId + ")'>审批记录</a>";
                        return result;
                    }
                }]
            });
        });

        function openDiagram(taskId) {

            var options = {

                title : "处理流程图",
                url : "<%=serverName%>/workflow/processDiagram.do",
                height : 400,
                width : 800,
                param: {

                    taskId: taskId
                }
            };
            $.fn.titans.dialog.openDialog(options);
        }

        function openProcessHisComment(taskId) {

            var options = {

                title : "审批记录",
                url : "<%=serverName%>/workflow/processHisComment.do",
                height : 400,
                width : 800,
                param: {

                    taskId: taskId
                }
            };
            $.fn.titans.dialog.openDialog(options);
        }

        function review(id, taskId) {

            var options = {

                title : "审批",
                url : "<%=serverName%>/device/deviceApplyReview.do",
                height : 400,
                width : 800,
                param: {

                    id: id,
                    taskId: taskId
                }
            };
            $.fn.titans.dialog.openDialog(options);
        }
    </script>
</html>