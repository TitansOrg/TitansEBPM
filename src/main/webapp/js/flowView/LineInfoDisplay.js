var LineInfoDisplay = function (svg) {

    this.svg = svg;
}

LineInfoDisplay.prototype.displayInfo = function (occBean) {
    var attrOccBeans = occBean.attrOccBeans;
    if (attrOccBeans.length == 0) {

        return;
    }
    var typenum = occBean.definitionBean.typenum;
    var conInfo = ConnectionTypeInfoLib.getConnectionTypeInfo(typenum);
    
    if (conInfo == null || conInfo == undefined) {
        alert("缺少定义线类型为" + typenum);
    }
    var lineName = conInfo.name; //连接线名称
    for (var i = 0; i < attrOccBeans.length; i++) {

        var attrs = occBean.definitionBean.definitionAttrBeans;
        var content = lineName;
        for (var j = 0; j < attrs.length; j++) {

            if (attrs[j].attrtypenum == attrOccBeans[i].attrtypenum) {

                content = attrs[j].plaintextfragment;
                break;
            }
        }
        // 如果内容为空，则不用考虑显示内容
        if (content == "") {

            continue;
        }
        var points = occBean.points.replace(/;/g, ",");
        points = points.substring(0,points.length - 1).split(',');
        var startX = parseInt(points[0]);
        var startY = parseInt(points[1]);
        var endX = parseInt(points[points.length - 2]);
        var endY = parseInt(points[points.length - 1]);
        var port = parseInt(attrOccBeans[i].port);
        var flag;
        switch (port) {

            case 1:
                // 起点上方
                var refX = parseInt(points[2]);
                var refY = parseInt(points[3]);
                if (startX == refX) {

                    if (startY - refY < 0) {

                        // 线是由上向下画的
                        flag = 1;
                    } else {

                        // 线是由下向上画的
                        flag = 2;
                    }
                } else {

                    if (refX - startX > 0) {

                        // 线是从左向右画的
                        flag = 3;
                    } else {

                        // 线是从右向左画的
                        flag = 4;
                    }
                }
                switch (flag) {

                    case 1:
                        // 上到下
                        var fontX = startX + 10;
                        var fontY = startY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 2:
                        // 下到上
                        var fontX = startX + 10;
                        var fontY = startY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 3:
                        // 左到右
                        var fontX = startX + 10;
                        var fontY = startY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 4:
                        // 右到左
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = startX - contentLen - 10;
                        var fontY = startY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                }
                break;
            case 2:
                // 上中
                break;
            case 3:
                // 终点上方
                var refX = parseInt(points[points.length - 4]);
                var refY = parseInt(points[points.length - 3]); 
                if (endX == refX) {

                    if (endY - refY > 0) {

                        // 线是由上向下画的
                        flag = 1;
                    } else {

                        // 线是由下向上画的
                        flag = 2;
                    }
                } else {

                    if (refX - endX < 0) {

                        // 线是从右向左画的
                        flag = 3;
                    } else {

                        // 线是从左向右画的
                        flag = 4;
                    }
                }
                switch (flag) {

                    case 1:
                        // 上到下
                        var fontX = endX + 10;
                        var fontY = endY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 2:
                        // 下到上
                        var fontX = endX + 10;
                        var fontY = endY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 3:
                        // 左到右
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = endX - contentLen - 10;
                        var fontY = endY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 4:
                        // 右到左
                        var fontX = endX + 10;
                        var fontY = endY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                }
                break;
            case 4:
                // 起点下方
                var refX = parseInt(points[2]);
                var refY = parseInt(points[3]); 
                if (startX == refX) {

                    if (startY - refY < 0) {

                        // 线是由上向下画的
                        flag = 1;
                    } else {

                        // 线是由下向上画的
                        flag = 2;
                    }
                } else {

                    if (refX - startX > 0) {

                        // 线是从左向右画的
                        flag = 3;
                    } else {

                        // 线是从右向左画的
                        flag = 4;
                    }
                }
                switch (flag) {

                    case 1:
                        // 上到下
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = startX - contentLen - 10;
                        var fontY = startY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 2:
                        // 下到上
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = startX - contentLen;
                        var fontY = startY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 3:
                        // 左到右
                        var fontX = startX + 10;
                        var fontY = startY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 4:
                        // 右到左
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = startX - contentLen - 10;
                        var fontY = startY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                }
                break;
            case 5:
                // 下中
                break;
            case 6:
                // 终点下方
                var refX = parseInt(points[points.length - 4]);
                var refY = parseInt(points[points.length - 3]); 
                if (endX == refX) {

                    if (endY - refY > 0) {

                        // 线是由上向下画的
                        flag = 1;
                    } else {

                        // 线是由下向上画的
                        flag = 2;
                    }
                } else {

                    if (refX - endX > 0) {
                
                        // 线是从左向右画的
                        flag = 3;
                    } else {

                        // 线是从右向左画的
                        flag = 4;
                    }
                }
                switch (flag) {

                    case 1:
                        // 上到下
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = endX - contentLen - 10;
                        var fontY = endY - 10;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 2:
                        // 下到上
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = endX - contentLen - 10;
                        var fontY = endY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 3:
                        // 左到右
                        var contentLen = ArisUtil.getNamePx(content);
                        var fontX = endX - contentLen - 10;
                        var fontY = endY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                    case 4:
                        // 右到左
                        var fontX = endX + 10;
                        var fontY = endY + 48;
                        var text = this.svg.paper.text(fontX, fontY, content);
                        this.svg.select("#svgGroup").append(text);
                        break;
                }
                break;
            case 12:
                // 随意位置
                var centerX = (startX + endX) * 0.5;
                var centerY = (startY + endY) * 0.5;
                var contentLen = ArisUtil.getNamePx(content);
                var xoffset = attrOccBeans[i].xoffset;
                var yoffset = attrOccBeans[i].yoffset;
                var fontX = centerX - contentLen * 0.5 + xoffset;
                var fontY = centerY + 10 + yoffset;
                var text = this.svg.paper.text(fontX, fontY, content);
                this.svg.select("#svgGroup").append(text);
                break;
        }
    }
}