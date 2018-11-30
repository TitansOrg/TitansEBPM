<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String serverName = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>流程管理平台</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="<%=serverName%>/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/font-awesome/font-awesome.css">
        <link rel="stylesheet" href="<%=serverName%>/css/ionicons/ionicons.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/AdminLTE.min.css">
        <link rel="stylesheet" href="<%=serverName%>/css/adminlet/skins/_all-skins.min.css">
        <script type="text/javascript">
              var serverName = "<%=serverName%>";
              function setIframeHeight(iframe) {
	              if (iframe) {
	                  var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	                  if (iframeWin.document.body) {
	                      iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	                  }
	              }
              };
        </script>
    </head>
    <body class="hold-transition skin-blue-light layout-top-nav">
        <div class="wrapper">
            <header class="main-header">
                <nav class="navbar navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <a class="navbar-brand"><b>EBPM</b></a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="#">首页</a></li>
                                <li><a  target = "mainFrame" href="<%=serverName%>/flowInfo/flowDetail.do">流程文件 </a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理 <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">用户管理</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">角色管理</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">权限管理</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <form id="searchForm" class="navbar-form navbar-left" method="post"  target="mainFrame" role="search">
                                <div class="form-group">
                                    <input type="text" name="keyWord" class="form-control" id="navbar-search-input" onkeydown="searchSubmit(event)" placeholder="搜索">
                                </div>
                            </form>
                        </div>
                        <div class="navbar-custom-menu">
                            <ul class="nav navbar-nav">
                                <li class="dropdown messages-menu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-envelope-o"></i>
                                        <span class="label label-success">4</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="header">You have 4 messages</li>
                                        <li>
                                            <ul class="menu">
                                                <li>
                                                    <a href="#">
                                                        <div class="pull-left">
                                                            <img src="<%=serverName%>/images/head/head.jpg" class="img-circle" alt="User Image">
                                                        </div>
                                                        <h4>Support Team<small><i class="fa fa-clock-o"></i> 5 mins</small></h4>
                                                        <p>Why not buy a new awesome theme?</p>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="footer">
                                            <a href="#">See All Messages</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown notifications-menu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-bell-o"></i>
                                        <span class="label label-warning">10</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="header">You have 10 notifications</li>
                                        <li>
                                            <ul class="menu">
                                                <li>
                                                    <a href="#">
                                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="footer">
                                            <a href="#">View all</a>
                                        </li>
                                    </ul>
                                </li>
                                <!-- Tasks Menu -->
                                <li class="dropdown tasks-menu">
                                    <!-- Menu Toggle Button -->
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-flag-o"></i>
                                        <span class="label label-danger">9</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="header">You have 9 tasks</li>
                                        <li>
                                            <ul class="menu">
                                                <li>
                                                    <a href="#">
                                                        <h3>
                                                            Design some buttons
                                                            <small class="pull-right">20%</small>
                                                        </h3>
                                                        <div class="progress xs">
                                                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                                <span class="sr-only">20% Complete</span>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="footer">
                                            <a href="#">View all tasks</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown user user-menu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <img src="<%=serverName%>/images/head/head.jpg" class="user-image" alt="User Image">
                                        <span class="hidden-xs">${curr_user_info.username }</span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="user-header">
                                            <img src="<%=serverName%>/images/head/head.jpg" class="img-circle">
                                            <p>${curr_user_info.username }<small>软件工程师</small></p>
                                        </li>
                                        <li class="user-footer">
                                            <div class="pull-left">
                                                <a href="#" class="btn btn-default btn-flat">个人信息</a>
                                            </div>
                                            <div class="pull-right">
                                                <a href="#" class="btn btn-default btn-flat">退出系统</a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div id="mainContentWrapper" class="content-wrapper">
                <div id="mainContainer" class="container" style="padding: 0 0 0 0;width: 100%;margin: 0 0 0 0;">
                    <iframe  onload="setIframeHeight(this)"  id="mainFrame" name="mainFrame" src="<%=serverName%>/flowInfo/flowDetail.do" style="border:0px;width:100%;overflow: hidden"></iframe>
                </div>
            </div>
            <footer class="main-footer">
                <div class="container">
                    <div class="pull-right hidden-xs">
                        <b>版本</b> 1.0.0
                    </div>
                    <strong>流程管理平台</strong>
                </div>
            </footer>
        </div>
    </body>
    <script src="<%=serverName%>/js/jquery/jquery.min.js"></script>
    <script src="<%=serverName%>/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=serverName%>/js/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=serverName%>/js/fastclick/fastclick.js"></script>
    <script src="<%=serverName%>/js/adminlte/adminlte.min.js"></script>
    <script src="<%=serverName%>/js/mainPage/mainPage.js"></script>
    <!-- AdminLTE for demo purposes
    <script src="../../dist/js/demo.js"></script> -->
    <script>
        $(function() {

            var bodyHeight = $("body").height();
            $("#mainContentWrapper").height(bodyHeight - 101);
            $("#mainContainer").height(bodyHeight - 101);
            $("#mainFrame").height(bodyHeight - 101);
           
        });
    </script>
</html>