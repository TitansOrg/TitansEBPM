$(function(){

    // 注册鼠标右键菜单事件
    $("#undo").bind("click", undo);
    $("#redo").bind("click", redo);
    $("#reloadPage").bind("click", reloadPage);
    $("#openInCurrentWindow").bind("click", openInCurrentWindow);
    $("#openInNewWindow").bind("click", openInNewWindow);
    $("#splFlow").bind("click", simpleFlow);
    $("#wholeFlow").bind("click", wholeFlow);
    $("#svgToImg").bind("click", svgToImg);
    // 阻止IE浏览器鼠标右键菜单弹出
    document.oncontextmenu = function () {

        return false;
    }
});

/**
 * 刷新页面方法.
 */
function reloadPage(){

    location.reload(true);
}

/**
 * 返回前一页面方法.
 */
function undo() {

    history.go(-1);
}

/**
 * 前进到下一页面方法.
 */
function redo() {

    history.go(1);
}

/**
 * 在当前窗口打开流程图方法.
 */
function openInCurrentWindow(){

    var guid = $("#contextMenu").attr("guid");
    assignClick(guid,"nav");
}

/**
 * 在新页面打开流程图方法.
 */
function openInNewWindow(){

    var guid = $("#contextMenu").attr("guid");
    var winName = Math.random();
    var date = new Date();
    assignClick(guid,date.getTime());
}

/**
 * 流程图中分配任务符号单击事件,用于打开新的流程图.
 * @param objguid 结点对象的GUID
 * @param winName 打开流程窗口的名称
 */
function assignClick(objguid, winName) {

    $.ajax({

        type:"post",
        url:serverName + "/flow/queryAssignInfo.action",
        dataType:"text",
        data:{guid:objguid},
        success:function(data){

            var arrs = $.parseJSON(data);
            if (arrs.length > 0) {

                window.open(serverName + "/flow/flowDetail.action?guid=" + escape(arrs[0].guid), winName);
            }
        }
    });
}

/**
 * 显示简易流程.
 */
function simpleFlow() {

    displaySimpleFlow();
}

/**
 * 显示完整流程.
 */
function wholeFlow() {

    displayWholeFlow();
}
/**
 * 格式化日期时间.
 */
function getFormatDate(date) {
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}

/**
 * SVG另存为图片.
 */
function svgToImg() {
    var imgName = $("#flowTitleSpan").text();
    var svgHtml = document.getElementById("svgCanvas");
    svgHtml = (new XMLSerializer()).serializeToString(svgHtml);
    var canvas = document.createElement('canvas');
    canvg(canvas, svgHtml);
    var context = canvas.getContext("2d");
    var imgData = context.getImageData(0, 0, canvas.width, canvas.height);
    context.putImageData(imgData, 0, 0);
    // 增加水印
    var watermarkCanvas = document.createElement('canvas');
    var watermarkContext = watermarkCanvas.getContext("2d")
    watermarkCanvas.width = canvas.width / 2;
    watermarkCanvas.height = canvas.height / 2;
    //水印边框
    //watermarkContext.save();
    //watermarkContext.beginPath();
    //watermarkContext.lineWidth="1";
    //watermarkContext.strokeStyle="black";
    //watermarkContext.rect(0,0,watermarkCanvas.width,watermarkCanvas.height);
    //watermarkContext.stroke();
    //watermarkContext.restore();
    //水印账号
    watermarkContext.save();
    watermarkContext.translate(watermarkCanvas.width * 1.5 / 8,watermarkCanvas.height * 4 / 8);
    watermarkContext.rotate(-Math.atan(canvas.height/canvas.width));
    watermarkContext.font = "bold "+(100 * Math.atan(canvas.height/canvas.width))+"px Arial" // 设置字体
    watermarkContext.fillStyle = "rgba( 145 , 145 , 145 , 0.6 )" // 填充rgba字体颜色
    watermarkContext.textBaseline = "middle"; // 文本对齐方式
    watermarkContext.fillText("shangjc1", 0, 0) // 填充文本
    watermarkContext.restore();
    //水印名称
    watermarkContext.save();
    watermarkContext.translate(watermarkCanvas.width * 2 / 8,watermarkCanvas.height * 6 / 8);
    watermarkContext.rotate(-Math.atan(canvas.height/canvas.width));
    watermarkContext.font = "bold "+(180 * Math.atan(canvas.height/canvas.width))+"px Arial" // 设置字体
    watermarkContext.fillStyle = "rgba( 145 , 145 , 145 , 0.6 )" // 填充rgba字体颜色
    watermarkContext.textBaseline = "middle"; // 文本对齐方式
    watermarkContext.fillText("shangjc2", 0, 0) // 填充文本
    watermarkContext.restore();
    // 水印日期
    watermarkContext.save();
    watermarkContext.translate(watermarkCanvas.width * 3 / 8,watermarkCanvas.height * 7 / 8);
    watermarkContext.rotate(-Math.atan(canvas.height/canvas.width));
    watermarkContext.font = "bold "+(50 * Math.atan(canvas.height/canvas.width))+"px Arial" // 设置字体
    watermarkContext.fillStyle = "rgba( 145 , 145 , 145 , 0.6 )" // 填充rgba字体颜色
    watermarkContext.textBaseline = "middle"; // 文本对齐方式
    watermarkContext.fillText(getFormatDate(new Date()), 0, 0) // 填充文本
    watermarkContext.restore();
    context.drawImage(watermarkCanvas, canvas.width / 4, canvas.height / 4)
    // 保存完整画布数据
    imgData = context.getImageData(0, 0, canvas.width, canvas.height);
    // 重新刷新画布数据
    context.putImageData(imgData, 0, 0);
    // 将画布数据转为图片
    var imgContent = canvas.toDataURL("image/png");
    imgContent = imgContent.substr("data:image/png;base64,".length,imgContent.length)
    // 取得要提交页面的URL
    $("#svgToImgForm input[name=imgContent]").val(imgContent);
    $("#svgToImgForm input[name=imgName]").val(imgName);
    $("#svgToImgForm").submit();
    $("#svgToImgForm input[name=imgContent]").val("");
    $("#svgToImgForm input[name=imgName]").val("");
}