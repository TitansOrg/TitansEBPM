var ArisLineFactory = function(svg){

    this.svg = svg;
};

ArisLineFactory.prototype.createArisLine = function(occBean){

    var penStyle;
    switch (parseInt(occBean.penStyle)) {

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
    var penColor = ArisUtil.convertSymbolColor(occBean.penColor);
    var point = occBean.points.replace(/;/g, ",");
    
    point = point.substring(0,point.length - 1);
    var line = this.svg.paper.polyline(point).attr({

        id:occBean.id,
        fill:"none",
        stroke:penColor,
        style:"stroke-width:" + occBean.penWidth + ";" + penStyle + ""
    });
    return line;
};