<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>工作流程</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
        <meta http-equiv="expires" content="-1">
        <link rel="stylesheet" type="text/css" href="<%=serverName%>/js/easyui/themes/gray/easyui.css">
        <link rel="stylesheet" type="text/css" href="<%=serverName%>/js/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="<%=serverName%>/css/flowView/flowView.css">
        <script type="text/javascript" src="<%=serverName%>/js/jquery/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/snap/snap.svg.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/canvg/rgbcolor.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/canvg/StackBlur.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/canvg/canvg.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ArisUtil.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/BasicProcess.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ArisSymbolFactory.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ArisLineFactory.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ArisArrowFactory.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/RectBorderFactory.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/PolygonBorderFactory.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/Interface.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/InfoDisplay.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ObjectInfoDisplay.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/LineInfoDisplay.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/TextInfoDisplay.js"></script>
        <script type="text/javascript" src="<%=serverName%>/js/flowView/ConnectionTypeInfoLib.js"></script>
        <script type="text/javascript">
            var serName = "<%=serverName%>";
            var serverName = "<%=serverName%>";
            $(function() {

                document.oncontextmenu = function () {

                    return false;
                }
                $('#maskDiv').show();
                $.ajax({

                    type: "post",
                    url: "<%=serverName%>/flowInfo/queryEbpmModelBean.do",
                    dataType: "json",
                    data: {

                        modelId: encodeURIComponent("<%=request.getParameter("modelId")%>")
                    },
                    success: init
                });
                function init(data) {

                    var process = new BasicProcess();
                    process.setProcessLayout(data);
                    process.drawProcess(data);
                    process.setModelDetailInfo(data);
                }
                $("#svgCanvas").bind("mousedown", function (evt) {

                    // 获取流程图详细信息
                    $.ajax({

                        type: "post",
                        url: serverName + "/flowInfo/queryModelDetailInfo.do",
                        dataType: "json",
                        data: {

                            modelId: encodeURIComponent("<%=request.getParameter("modelId")%>")
                        },
                        success: function(data) {

                            var attrPanel = "";
                            for (var i = 0; i < data.length; i++) {

                                attrPanel = attrPanel + "<div style=\"padding:10px;\" data-options=\"width:'100%'\"><b>" 
                                    + data[i].name + ": </b>" + data[i].val.replace(/\r\n/g,"<br/>") + "</div>";
                            }
                            $("#info").html(attrPanel);
                            $('#info div').panel();
                        }
                    });
                    evt.stopPropagation();
                    evt.preventDefault();
                });
            });
        </script>
    </head>
    <body>
        <div id="lay" class="easyui-layout" data-options="fit:true">
            <div data-options="region:'north'" style="height: 50px;overflow:hidden; text-align: center;">
                <span id="flowTitleSpan" style="line-height:40px;width:38%;display: inline-block;font-size: 30px;font-weight: bold;"></span>
            </div>
            <div id="leftinfo" style="width:60%" data-options="region:'center',collapsed:false,split:true" title="">
                <div id="maskDiv"
                      style="width: 100%; height: 100%; position: absolute; top: 0px; left: 0px; 
                      background-image:url('<%=serverName%>/images/flowView/loading.jpg');
                      background-color: rgb(45, 45, 45);
                      z-index: 5000; opacity: 0.2; 
                      display: none; background-position: center center; background-repeat: no-repeat;">
                </div>
                <svg id="svgCanvas" viewBox="0 0 3000 3000"
                    style="cursor:default;font-family:'Microsoft YaHei';border: 0px solid red;font-size: 40px;">
                    <%@ include file="symbolLib.jsp"%>
                    <g id="svgGroup" transform="translate(0,-50) scale(0.3 0.3)"></g>
                </svg>
            </div>
            <div id="info"  data-options="region:'east',split:true,collapsed:true" title="详细信息" style="width:20%;padding:0 17px 0 0;"></div>
        </div>
        <div id="wftable" title="请选择要打开的流程">
            <ul></ul>
        </div>
    </body>
</html>