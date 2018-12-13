﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String serverName = request.getContextPath();

%>
<!DOCTYPE html>
<html style="background-color: #ecf0f5;overflow: hidden">
    <head>
        <title>工作流程</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
        <meta http-equiv="expires" content="-1">
        <link rel="stylesheet" type="text/css" href="<%=serverName%>/css/flowView/flowView.css">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/zTree/zTreeStyle.css">
        <style>
            #catalog a {
                
                color : black;
            }
        </style>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="main-sidebar" style="background-color: #ecf0f5;padding-left: 15px;padding-top:15px;">
            <section class="sidebar">
                <div class="box box-primary" style="margin-bottom: 0px;">
                    <div class="box-header with-border">
                        <h3 class="box-title">文件目录</h3>
                    </div>
                    <div id="catalog" class="box-body" style="overflow: auto;padding:0px;">
                        <ul id="treeDemo" class="ztree"></ul>
                    </div>
                </div>
            </section>
        </div>
        <div class="wrapper">
            <div id="contentWrapper" class="content-wrapper">
                <section class="content" style="padding-top: 15px; padding-bottom: 0px;">
                    <div class="row">
                        <div class="col-md-10">
                            <div class="box box-primary" style="margin-bottom: 0px;">
                                <div class="box-header with-border">
                                    <h3 id="flowTitleSpan" class="box-title"></h3>
                                </div>
                                <div  id="svgDiv" class="box-body" style="overflow: auto;padding:0px;">
                                    <svg id="svgCanvas" style="cursor:default;font-family:'Microsoft YaHei';border: 0px solid red;font-size: 40px;">
                                        <%@ include file="symbolLib.jsp"%>
                                        <g id="svgGroup" transform="translate(0,-50) scale(0.3 0.3)"></g>
                                    </svg>
                                </div>
                                <div id="svgDivOverlay" class="overlay" style="display:none">
                                    <i class="fa fa-refresh fa-spin"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2" style="padding-left:0px;">
                            <div class="box box-primary" style="margin-bottom: 0px;">
                                <div class="box-header with-border">
                                    <h3 class="box-title">特性</h3>
                                </div>
                                <div id="info" class="box-body" style="overflow: auto;padding:0px;"></div>
                                <div id="infoOverlay" class="overlay" style="display:none;">
                                    <i class="fa fa-refresh fa-spin"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/zTree/jquery.ztree.core.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/snap/snap.svg.js"></script>
    <script src="<%=serverName%>/js/canvg/rgbcolor.js"></script>
    <script src="<%=serverName%>/js/canvg/StackBlur.js"></script>
    <script src="<%=serverName%>/js/canvg/canvg.js"></script>
    <script src="<%=serverName%>/js/flowView/ArisUtil.js"></script>
    <script src="<%=serverName%>/js/flowView/BasicProcess.js"></script>
    <script src="<%=serverName%>/js/flowView/ArisSymbolFactory.js"></script>
    <script src="<%=serverName%>/js/flowView/ArisLineFactory.js"></script>
    <script src="<%=serverName%>/js/flowView/ArisArrowFactory.js"></script>
    <script src="<%=serverName%>/js/flowView/RectBorderFactory.js"></script>
    <script src="<%=serverName%>/js/flowView/PolygonBorderFactory.js"></script>
    <script src="<%=serverName%>/js/flowView/Interface.js"></script>
    <script src="<%=serverName%>/js/flowView/InfoDisplay.js"></script>
    <script src="<%=serverName%>/js/flowView/ObjectInfoDisplay.js"></script>
    <script src="<%=serverName%>/js/flowView/LineInfoDisplay.js"></script>
    <script src="<%=serverName%>/js/flowView/TextInfoDisplay.js"></script>
    <script src="<%=serverName%>/js/flowView/ConnectionTypeInfoLib.js"></script>
    <script>
        var serName = "<%=serverName%>";
        var serverName = "<%=serverName%>";
        var zTreeObj;
        var setting = {

            async: {

                enable: true,
                autoParam: ["id"],
                url: "<%=serverName%>/flowInfo/getFileRootPath.do"
            },
            data: {

                simpleData: {

                    enable: true
                }
            },
            callback: {

                onClick: function (event, treeId, treeNode) {

                    if (!treeNode.isParent) {

                        initFlow(treeNode.id);
                    }
                }
            }
        };
        $(function() {
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting);
            $("#svgDiv").height($(document).height() - 15 - 3 - 41 - 1);
            $("#info").height($(document).height() - 15 - 3 - 41 - 1);
            $("#catalog").height($(document).height() - 15 - 3 - 41 - 1);
            
            document.oncontextmenu = function () {

                return false;
            }
        });

        function initFlow(modelId) {

            $("#svgDivOverlay").show();
            $("#infoOverlay").show();
            $.ajax({

                type: "post",
                url: "<%=serverName%>/flowInfo/queryEbpmModelBean.do",
                dataType: "json",
                data: {

                    modelId: encodeURIComponent(modelId)
                },
                success: function (data) {

                    var process = new BasicProcess();
                    process.setProcessLayout(data);
                    process.drawProcess(data);
                    process.setModelDetailInfo(data);
                    $("#svgDivOverlay").hide();
                    $("#svgCanvas").on("mousedown", function (evt) {

                        $("#infoOverlay").show();
                        $.ajax({

                            type: "post",
                            url: serverName + "/flowInfo/queryModelDetailInfo.do",
                            dataType: "json",
                            data: {

                                modelId: encodeURIComponent(data.id)
                            },
                            success: function(data) {

                                var attrPanel = "";
                                for (var i = 0; i < data.length; i++) {

                                    attrPanel = attrPanel + "<div style='padding:10px;border-bottom:1px solid #ccc;'><b>" 
                                        + data[i].name + ": </b>" + data[i].val.replace(/\r\n/g,"<br/>") + "</div>";
                                }
                                $("#info").html(attrPanel);
                                $("#infoOverlay").hide();
                            }
                        });
                        evt.stopPropagation();
                        evt.preventDefault();
                    });
                }
            });
        }
    </script>
</html>