$(function() {
    /**
     * 初始化查询列表
     */
    $('#allFile').datagrid({    
        url: serverName +'search/searchAllFile.do', 
        queryParams:{
            searchName : keyWord
        },
        striped:true//隔行变色
    }); 
    
   
});

function getModelInfo(value,rowData) {

    var url = serverName + "flowInfo/flowDetail2.do?modelId=" + escape(rowData["modelId"]);
    return "<a href='" + url + "' target='mainFrame'>" + value + "</a>";
}