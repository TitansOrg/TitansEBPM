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
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-fileinput/fileinput.min.css">
    </head>
    <body>
        <div class="box-body form-horizontal">
            <form class="col-sm-10" id="uploadForm" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-sm-2 control-label text-center">工作流程名称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" name="workflowName" placeholder="工作流程名称">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label text-center">选择文件</label>
                    <div class="col-sm-10">
                        <input id="file" type="file" name="file" value="浏览">
                    </div>
                </div>
            </form>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/jquery/jquery-form.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.dialog.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.date.js"></script>
    <script src="<%=serverName%>/js/bootstrap-fileinput/fileinput.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-fileinput/locales/zh.js"></script>
    <script>
        $(function() {

            initFile();
        });

        function initFile() {

            $("#file").fileinput({

                uploadAsync: true,              // 异步上传
                language: "zh",                 // 设置语言
                showCaption: true,              // 是否显示标题
                showUpload: false,              // 是否显示上传按钮
                showRemove: true,               // 是否显示移除按钮
                showPreview: false,             // 是否显示预览按钮
                browseClass: "btn btn-primary", // 按钮样式 
                dropZoneEnabled: false,         // 是否显示拖拽区域
                allowedFileExtensions: ["zip"], // 接收的文件后缀
                maxFileCount: 1,                // 最大上传文件数限制
                previewFileIcon: "<i class='glyphicon glyphicon-file'></i>",
                enctype: "multipart/form-data",
                allowedPreviewTypes: null,
                previewFileIconSettings: {

                    "zip": "<i class='glyphicon glyphicon-file'></i>",
                },
                uploadExtraData: {

                    workflowName: $("#workflowName").val()
                }
            }).on("filepreupload", function(event, data, previewId, index) {

                var form = data.form;
                var files = data.files;
                var extra = data.extra;
                var response = data.response;
                var reader = data.reader;
                console.log("文件正在上传");
            }).on("fileuploaded", function (event, data, previewId, index) {

                console.log("文件上传成功！" + data.id);
            }).on("fileerror", function(event, data, msg) {

                console.log("文件上传失败！" + data.id);
            });
        }

        function toSubmit(dialog, id) {

            $("#uploadForm").ajaxSubmit({

                type: "POST",
                url: "<%=serverName%>/workflow/deployWorkflow.do",
                success: function (data) {

                    alert("上传成功！");
                    dialog.closeDialog(id);
                }
            });
        }
    </script>
</html>