var PolygonBorderFactory = function (svg) {

    this.svg = svg;
};

PolygonBorderFactory.prototype.createPolygonBorder = function(occBean) {


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
    //2650,163;5300,838;0,838;2650,163;false
    var datas = occBean.data.substring(0,occBean.data.lastIndexOf(";"));
    datas = datas.replace(/[;]/g,',');
    datas = datas.substring(0,datas.length-1);
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
    /**
     * 多边形，前面点， 是否阴影
     * 2650,163;5300,838;0,838;2650,163;false
     */
    var symbol = this.svg.paper.polyline(datas).attr({

        fill:brushColor,
        stroke:penColor,
        style:"stroke-width:" + penWidth + ";" + penStyle
    });
    return symbol;
};