<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>流程管理</title>
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
    <body>
        <div class="row">
            <div class="col-xs-12">
                <table id="dataTable" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>type</th>
                            <th>userId</th>
                            <th>time</th>
                            <th>taskId</th>
                            <th>processInstanceId</th>
                            <th>action</th>
                            <th>message</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
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
        $(function() {

        	var table = $("#dataTable").DataTable({

                language: {

                    url : "<%=serverName%>/js/datatables.net/i18n/resources_zh_CN.txt"
                },
                paging : false,
                pagingType : "full_numbers",
                lengthChange : false,
                lengthMenu: [

                    [10, 15, 30, -1],
                    [10, 15, 30, "All"]
                ],
                searching : false,
                ordering : false,
                info : true,
                autoWidth : false,
                ajax : {

                    url : "<%=serverName%>/workflow/queryProcessHisComment.do",
                    data:{

                        taskId : "<%=request.getParameter("taskId")%>"
                    },
                    dataSrc : ""
                },
                order : [[1, "asc"]],
                stripeClasses : [ "strip1", "strip2"],
                columns : [

                    {data: "id"},
                    {data: "type"},
                    {data: "userId"},
                    {data: "time"},
                    {data: "taskId"},
                    {data: "processInstanceId"},
                    {data: "action"},
                    {data: "message"}
                ]
            });
        });
    </script>
</html>