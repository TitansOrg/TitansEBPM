<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html style="height:100%;padding:0px;margin:0;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>用户管理表</title>
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
        <section class="content-header">
            <h1>用户管理表</h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard"></i> 首页</li>
                <li>系统管理</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <button type="button" class="btn btn-sm btn-flat btn-primary" onclick="addData();">添加</button>
                            <button type="button" class="btn btn-sm btn-flat btn-primary" onclick="modifyData();">修改</button>
                            <button type="button" class="btn btn-sm btn-flat btn-primary" onclick="removeData();">删除</button>
                            <button type="button" class="btn btn-sm btn-flat btn-primary">导入</button>
                            <button type="button" class="btn btn-sm btn-flat btn-primary">导出</button>
                        </div>
                        <div class="box-body">
                            <table id="dataTable" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th style="width:50px;text-align:center;">
                                            <input type="checkbox" class="checkbox icheck">
                                        </th>
                                        <th>用户账号</th>
                                        <th>用户名称</th>
                                        <th>用户密码</th>
                                        <th>创建时间</th>
                                        <th>更新时间</th>
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

                    url : "<%=serverName%>/user/getSysUserList.do",
                    dataSrc : ""
                },
                order : [[1, "asc"]],
                stripeClasses : [ "strip1", "strip2"],
                columns : [

                    {data: "id"},
                    {data: "usercode"},
                    {data: "username"},
                    {data: "password"},
                    {data: "createTime"},
                    {data: "updateTime"}
                ],
                columnDefs : [{

                    searchable : false,
                    orderable : false,
                    targets : 0,
                    className: "table-cell-style",
                    render : function(data, type, row) {

                        return "<input type='checkbox' class='checkbox icheck' value='" + data + "'>";
                    }
                }]
            });
            $('#dataTable').on('draw.dt',function() {

                $(":checkbox").iCheck({

                    checkboxClass: 'icheckbox_square-blue'
                });
            });
        });

        function addData() {

            var options = {

                title : "详细信息",
                url : "<%=serverName%>/user/sysUserDetail.do",
                height : 500,
                width : 1000
            }
            $.fn.titans.dialog.openDialog(options);
        }

        function modifyData() {

            var ids = [];
            $("tbody :checkbox:checked").each(function() {

                ids.push($(this).val());
            });
            if (ids.length == 1) {

                var options = {

                    title : "详细信息",
                    url : "<%=serverName%>/user/sysUserDetail.do",
                    height : 500,
                    width : 1000,
                    param: {

                        id: ids[0]
                    }
                };
                $.fn.titans.dialog.openDialog(options);
            } else {

                alert("请选择一条需要编辑的数据！");
            }
        }

        function removeData() {

            var ids = [];
            $("tbody :checkbox:checked").each(function() {

                ids.push($(this).val());
            });
            if (ids.length > 0) {

                $.ajax({

                    type: "POST",
                    dataType:"json",
                    url: "<%=serverName%>/user/removeData.do",
                    data: {

                        ids : JSON.stringify(ids)
                    },
                    success: function(data) {

                        if (data) {

                            alert("删除成功！");
                            parent.refreshFrame();
                        } else {

                            alert("删除失败！");
                        }
                    }
                });
            }  else {

                alert("至少需要选择一条数据！");
            }
        }
    </script>
</html>