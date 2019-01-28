<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>用户导入</title>
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/select2/select2.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-fileinput/fileinput.min.css">
    </head>
    <body>
       <form  id="uploadForm" method="post" enctype="multipart/form-data">  
             <input type="hidden" id="AttachGUID" name="AttachGUID" /> 
             <input id="excelFile" type="file" name="file" style="height:20px;top:8px" value="浏览">
       </form>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/jquery/jquery-form.js"></script>
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
    <script src="<%=serverName%>/js/bootstrap-fileinput/fileinput.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-fileinput/locales/zh.js"></script>
    <script>
  //初始化Excel导入的文件
    InitExcelFile();
    function InitExcelFile() {
        $("#AttachGUID").val(newGuid());
        $("#excelFile").fileinput({
            uploadUrl: "<%=serverName%>/FileUpload/Upload",//上传的地址
            uploadAsync: true,              //异步上传
            language: "zh",                 //设置语言
            showCaption: true,              //是否显示标题
            showUpload: false,             //是否显示上传按钮
            showRemove: true,               //是否显示移除按钮
            showPreview : true,             //是否显示预览按钮
            browseClass: "btn btn-primary", //按钮样式 
            dropZoneEnabled: true,         //是否显示拖拽区域
            allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
            maxFileCount: 1,                        //最大上传文件数限制
            previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
            enctype: 'multipart/form-data',
            allowedPreviewTypes: null,
            previewFileIconSettings: {
                'docx': '<i class="glyphicon glyphicon-file"></i>',
                'xlsx': '<i class="glyphicon glyphicon-file"></i>',
                'pptx': '<i class="glyphicon glyphicon-file"></i>',
                'jpg': '<i class="glyphicon glyphicon-picture"></i>',
                'pdf': '<i class="glyphicon glyphicon-file"></i>',
                'zip': '<i class="glyphicon glyphicon-file"></i>',
            },
            uploadExtraData: {  //上传的时候，增加的附加参数
                folder: '数据导入文件', guid: $("#AttachGUID").val()
            }
        }).on('filepreupload', function(event, data, previewId, index) {     //上传中
            var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
            console.log('文件正在上传');
        }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
            console.log('文件上传成功！'+data.id);
 
        }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
            console.log('文件上传失败！'+data.id);
       });
    } 
    
    function newGuid()
    {
        var guid = "";
        for (var i = 1; i <= 32; i++){
          var n = Math.floor(Math.random()*16.0).toString(16);
          guid +=   n;
          if((i==8)||(i==12)||(i==16)||(i==20))
            guid += "-";
        }
        return guid;    
    }
    
    function toSubmit(dialog, id) {
        $("#uploadForm").ajaxSubmit({
            type: "POST",
            url: "<%=serverName%>/user/importExcel.do",
            success: function (data) {
                 if (data) {

                     alert("上传成功！");
                     dialog.closeDialog(id);
                 } else {

                     alert("上传失败！");
                 }
            }
        });
    }
    </script>
</html>