<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String keyWord = request.getParameter("keyWord");
%>
<html>
<head>
<%@ include file="../common/common.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
    
    .panel-body{
        padding:0px;
    }
</style>
<title>全局搜索</title>

<script type="text/javascript">
    var keyWord = "<%=keyWord%>";
    var serverName = "<%=serverName%>";
</script>
<script src="<%=serverName%>/js/search/search.js"></script>
</head>
<body>
    <div class="container" style="border:0;height:100%">
	    <table id="allFile" class="easyui-datagrid" title="全局查询">
	        <thead>
	            <tr>
	                <th data-options="field:'id',width:'20%',align:'center'">编号</th>
	                <th data-options="field:'name' ,width:'60%',formatter:getModelInfo">名称</th>
	                <th data-options="field:'version',width:'21%',align:'center'">版本</th>
	                <th data-options="field:'modelId',width:'20%',hidden:true">主键</th>
	            </tr>
	        </thead>
	    </table>
    </div>
   
</body>
</html>