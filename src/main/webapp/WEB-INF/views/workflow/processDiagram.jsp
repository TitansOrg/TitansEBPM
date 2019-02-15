<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>流程图</title>
    </head>
    <body>
        <img style="position: absolute;top: 0px;left: 0px;"
             src="<%=serverName%>/workflow/queryCurrentDiagram.do?taskId=<%=request.getParameter("taskId")%>">
        <div id="borderDiv" style="position: absolute;border:1px solid red;"></div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script>
        $(function() {

            $.ajax({

                type: "POST",
                dataType:"json",
                url: "<%=serverName%>/workflow/queryCurrentTaskCoording.do",
                data: {

                    taskId : <%=request.getParameter("taskId")%>
                },
                success: function(data) {

                    $("#borderDiv").height(data.height + 6);
                    $("#borderDiv").width(data.width + 6);
                    $("#borderDiv").css({ "top": data.y - 4, "left": data.x -3 });
                }
            });
        });
    </script>
</html>