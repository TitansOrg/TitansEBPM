var RectBorderFactory = function (svg) {

    this.svg = svg;
};

RectBorderFactory.prototype.createArisRectBorder = function(occBean) {
	
    var x = occBean.positionX;
    var y = occBean.positionY;
    var w = occBean.sizeX;
    var h = occBean.sizeY;
    var penColor = occBean.penColor;
    var penWidth = occBean.penWidth;
    var penStyle = occBean.penStyle;
    var brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
    
    if(brushColor.length < 6) {
    
        var brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
    }
    if (typeof(penColor) == "undefined" || penColor == "-1" ) {

        penColor = "0"; //默认0 就是黑色
    } else {
        penColor = ArisUtil.convertSymbolColor(occBean.penColor);
    }
    if (typeof(penWidth) == "undefined" || penWidth == "-1") {

        penWidth = 1;
    }
    if (typeof(penStyle) == "undefined" || penStyle == "-1" ) {

        penStyle = 0;
    }
    if (penColor == "#0") {

        penColor = "#000000";
    }
    var datas = occBean.data.split(";");
    
    switch (parseInt(penStyle)) {
  
        case 0:
            // 实线
            penStyle = "";
            break;
        case 1:
            // 虚线
            penStyle = "stroke-dasharray:25 25";
            break;
        case 2:
            // 点线
            penStyle = "stroke-dasharray:10 10";
            break;
    }
    //10脚本取不到这些数据.
    
    // 绘制矩形
    var rx = datas[0]*5;
    var ry = datas[1]*5;
    var symbol = this.svg.paper.rect(x, y, w, h).attr({

        rx:rx,
        ry:ry,
        fill:brushColor,
        stroke:penColor,
        style:"stroke-width:" + penWidth + ";" + penStyle
    });
    return symbol;
};