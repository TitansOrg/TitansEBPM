/**
 * 全局查询，查询所有模型，带超链接可以点击。
 */
function searchSubmit(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
        var keyWord = $("#navbar-search-input").val();
        if (keyWord == null || keyWord == "") {

            alert("搜索条件不能为空！");
            return;
        }
        var url = serverName + "/search/search.do";
        document.getElementById("searchForm").action = url;
        document.getElementById("searchForm").submit();
    }
}