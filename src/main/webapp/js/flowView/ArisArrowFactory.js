var ArisArrowFactory = function (svg) {

    this.svg = svg;
};

ArisArrowFactory.prototype.drawArrow = function (occBean, flag) {

    // 判断最后两个点的位置来决定箭头方向
	//数据里面最后一个带; 所以要去掉再分割 不然多一个空点
	var points = occBean.points.substring(0,occBean.points.length-1).replace(/;/g, ",").split(",");
    // 起点坐标
    var startX = parseInt(points[0]);
    var startY = parseInt(points[1]);
    //参照点坐标，两个点的线时和起点相同，用于判断箭头方向的
    var refX = parseInt(points[points.length-4]);
    var refY = parseInt(points[points.length-3]);
    // 终点坐标
    var endX = parseInt(points[points.length-2]);
    var endY = parseInt(points[points.length-1]);
    var arrow;
    var arrowX;
    var arrowY;
    
    if (flag == "src") {

        // 起点画箭头
        arrowX = startX;
        arrowY = startY;
        if ((endX == refX) && (refY > endY)) {

            // 箭头向下
            arrow = this.svg.paper.polyline(arrowX+16,arrowY-16,arrowX,arrowY,arrowX-16,arrowY-16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((endX == refX) && (refY < endY)) {

            // 箭头向上
            arrow = this.svg.paper.polyline(arrowX-16,arrowY+16,arrowX,arrowY,arrowX+16,arrowY+16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((refY == endY) && (refX > endX)) {

            // 箭头向右
            arrow = this.svg.paper.polyline(arrowX-16,arrowY-16,arrowX,arrowY,arrowX-16,arrowY+16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((refY == endY) && (refX < endX)) {

            // 箭头向左
            arrow = this.svg.paper.polyline(arrowX+16,arrowY+16,arrowX,arrowY,arrowX+16,arrowY-16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        }
    } else {

        //终点画箭头
        arrowX = endX;
        arrowY = endY;
        if ((endX == refX) && (refY < endY)) {

            // 箭头向下
            arrow = this.svg.paper.polyline(arrowX+16,arrowY-16,arrowX,arrowY,arrowX-16,arrowY-16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((endX == refX) && (refY > endY)) {

            // 箭头向上
            arrow = this.svg.paper.polyline(arrowX-16,arrowY+16,arrowX,arrowY,arrowX+16,arrowY+16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((refY == endY) && (refX < endX)) {

            // 箭头向右
            arrow = this.svg.paper.polyline(arrowX-16,arrowY-16,arrowX,arrowY,arrowX-16,arrowY+16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        } else if ((refY == endY) && (refX > endX)) {

            // 箭头向左
            arrow = this.svg.paper.polyline(arrowX+16,arrowY+16,arrowX,arrowY,arrowX+16,arrowY-16).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(occBean.penColor),
                strokeWidth:occBean.penWidth
            });
        }
    }
    return arrow;
}

ArisArrowFactory.prototype.createArisArrow = function (occBean) {

    // 添加箭头    
    var arrow = null;
    var comtype = occBean.definitionBean.typenum;
    var conInfo = ConnectionTypeInfoLib.getConnectionTypeInfo(comtype);
    // occBean中srcarrow和tgtarrow等于0表示默认，-1表示无箭头，其他情况箭头太复杂先不处理统一用默认的样式
    if (occBean.srcarrow != -1) {

        // 创建起点箭头
        if (occBean.srcarrow == 0) {
            if (conInfo && conInfo.srcarrow == 1) {

                // 创建默认的起点箭头
                arrow = this.drawArrow(occBean,"src");
            }
        } else {

            // 箭头类型很多，此处仅创建默认的起点箭头
            arrow = this.drawArrow(occBean,"src");
        }
    }

    if (occBean.tgtarrow != -1) {

        // 创建终点箭头
        if (occBean.tgtarrow == 0) {

            if (conInfo && conInfo.tgtarrow == 1) {
                
                // 创建默认的终点箭头
                arrow = this.drawArrow(occBean,"tgt");
            }
        } else {

            // 箭头类型很多，此处仅创建默认的终点箭头
            arrow = this.drawArrow(occBean,"tgt");
        }
    }
    return arrow;
}

