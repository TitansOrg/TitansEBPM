<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>${tableDesc}</title>
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/iCheck/square/blue.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap-datepicker/bootstrap-datepicker.min.css">
    </head>
    <body>
        <input id="id" type="hidden" value="<%=request.getParameter("id") %>"/>
        <div class="box-body form-horizontal">
            <#list members as member>
            <#if member.memberType == "Date">
            <div class="form-group">
                <label class="col-sm-2 control-label">${member.description}</label>
                <div class="col-sm-6">
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input type="text" class="form-control pull-right" id="${member.memeberName}" placeholder="${member.description}">
                    </div>
                </div>
            </div>
            <#else>
            <#if member.isPrimaryKey != "1">
            <div class="form-group">
                <label class="col-sm-2 control-label text-center">${member.description}</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="${member.memeberName}" placeholder="${member.description}">
                </div>
            </div>
            </#if>
            </#if>
            </#list>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap-datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
    <script src="<%=serverName%>/js/titans/jquery.titans.dialog.js"></script>
    <script>
        $(function() {

            <#list members as member>
            <#if member.memberType == "Date">
            $('#${member.memeberName}').datepicker({

                language: "zh-CN",
                format: "yyyy-mm-dd",
                autoclose: true
            });
            </#if>
            </#list>
            pageDataInit();
        });

        function pageDataInit() {

            var id = $("#id").val();
            if (id != "null") {

                $.ajax({

                    type: "POST",
                    dataType:"json",
                    url: "<%=serverName%>/${function}/queryDetailInfoById.do",
                    data: {

                        id : id
                    },
                    success: function(data) {

                        <#list members as member>
                        <#if member.isPrimaryKey != "1">
                        $("#${member.memeberName}").val(data.${member.memeberName});
                        </#if>
                        </#list>
                    }
                });
            }
        }

        function toSubmit(dialog, id) {

            var param = {

                <#list members as member>
                ${member.memeberName} : $("#${member.memeberName}").val()<#sep>,
                </#list>

            };
            $.ajax({

                type: "POST",
                dataType:"json",
                contentType: "application/json",
                url: "<%=serverName%>/${function}/saveOrUpdate.do",
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