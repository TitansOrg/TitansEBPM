function CommonUtils() { 
    
}

/**
 * 获取所有部门列表
 */
CommonUtils.prototype.getDepart = function() {
    var _deptMap = {};
    $.ajax({
        async:false,
        type: "POST",
        dataType:"json",
        url : serverName +"/dept/getAllDept.do",
        success: function(data) {
             for ( var i = 0; i < data.length; i++) {
                 _deptMap[data[i].id] = data[i].name;
             }
        }
    });
    return _deptMap;
}

CommonUtils.prototype.addOption = function(_url,domObj) {
	$.ajax({
        async:true,
        type: "POST",
        dataType:"json",
        url : _url,
        success: function(data) {
             for ( var i = 0; i < data.length; i++) {

                  domObj.append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
             }
        }
    });
}