var BasicProcess = function() {

    this.svg = Snap("#svgCanvas");
};

BasicProcess.prototype.drawProcess = function(model) {

    this.svg.selectAll("#svgGroup > *").remove();
    var occBeans = model.occBeans;
    var symFactory = new ArisSymbolFactory(this.svg);
    var lineFactory = new ArisLineFactory(this.svg);
    var arrowFactory = new ArisArrowFactory(this.svg);
    var rectBorderFactory = new RectBorderFactory(this.svg);
    var polygonBorderFactory = new PolygonBorderFactory(this.svg);
    // 添加泳道
    this.addLaneAbility(model);
    for (var i = 0; i < occBeans.length; i++) {

        if (occBeans[i].discriminator == 1) {

            // 显示普通对象符号
            var symbol = symFactory.createArisSymbol(occBeans[i]);
            this.svg.select("#svgGroup").append(symbol);
            // 如果有分配任务，则显示分配任务符号
            if (occBeans[i].definitionBean.assignmentBeans.length > 0) {

                var task = symFactory.displayAssignTask(occBeans[i]);
                this.svg.select("#svgGroup").append(task);
            }
            // 显示符号的信息 
            var display = new ObjectInfoDisplay(this.svg);
            // 显示对象内容信息
            Interface.ensureImplements(display, InfoDisplay);
            display.displayInfo(occBeans[i], model.typenum);

        } else if (occBeans[i].discriminator == 2) {

            // 如果是EPC行展示流程图，则不显示65号"完成"连线
            var linetype = occBeans[i].definitionBean.typenum;
            if ((linetype == 65 || linetype == 507 ) && model.typenum == "140") {

                continue;
            }
            // 如果是流程选择图，则不显示30号"由…组成"和369号"属于"连线
            if ((linetype == 30 || linetype == 369)&& model.typenum == "141") {

                continue;
            }
            if (linetype == 118 && model.typenum == "13" && model.typguid == "775f1f20-d617-11e1-0538-848f69dcab2f") {

                continue;
            }
            // 符号之间的连线
            var line = lineFactory.createArisLine(occBeans[i]);
            this.svg.select("#svgGroup").append(line);
            // 绘制连线的箭头
            var arrow = arrowFactory.createArisArrow(occBeans[i]);
            this.svg.select("#svgGroup").append(arrow);
            // 显示对象内容信息
            var display = new LineInfoDisplay(this.svg);
            Interface.ensureImplements(display, InfoDisplay);
            display.displayInfo(occBeans[i]);
        } else if (occBeans[i].discriminator == 4) {

            //文本框
            var display = new TextInfoDisplay(this.svg);
            // 显示对象内容信息
            Interface.ensureImplements(display, InfoDisplay);
            display.displayInfo(occBeans[i]);
        } else if (occBeans[i].discriminator == 5) {

            if (occBeans[i].typenum == 0) {

                // 显示矩形边框线
                var rectBorder = rectBorderFactory.createArisRectBorder(occBeans[i]);
                this.svg.select("#svgGroup").append(rectBorder);
            } else if (occBeans[i].typenum == 1) {

                // 显示多边形边框线
                var polygonBorder = polygonBorderFactory.createPolygonBorder(occBeans[i]);
                this.svg.select("#svgGroup").append(polygonBorder);
            }
        }
    }
};

BasicProcess.prototype.setModelDetailInfo = function (data) {

    $.ajax({

        type: "post",
        url: serverName + "/flowInfo/queryModelDetailInfo.do",
        dataType: "text",
        data: {

            modelId: data.id
        },
        success: function(data) {

            var arrs = $.parseJSON(data);
            var attrPanel = "";
            for (var i = 0; i < arrs.length; i++) {

                attrPanel = attrPanel + "<div style='padding:10px;border-bottom:1px solid #ccc;'><b>"
                    + arrs[i].name + ":</b>" + arrs[i].val.replace(/\r\n/g,"<br/>") + "</div>";
                if (arrs[i].name == "名称") {

                    $("#flowTitleSpan").text(arrs[i].val);
                }
            }
            $("#info").html(attrPanel);
            $("#infoOverlay").hide();
        }
    });
}

// var modelId = "";
BasicProcess.prototype.setProcessLayout = function(data) {

    var occBeans = data.occBeans;
    var maxWidth = 0;
    var maxHeight = 0;
    var modelId = data.id;
    for (var i = 0; i < occBeans.length; i++) {

        var occBean = occBeans[i];
        if (typeof(occBean.positionX) != "undefined"
         && typeof(occBean.positionY) != "undefined"
         && typeof(occBean.sizeX) != "undefined"
         && typeof(occBean.sizeY) != "undefined") {

            var positionX = parseInt(occBean.positionX);
            var positionY = parseInt(occBean.positionY);
            var sizeX = parseInt(occBean.sizeX);
            var sizeY = parseInt(occBean.sizeY);
            if (positionX + sizeX > maxWidth) {

                maxWidth = positionX + sizeX;
            }
            if (positionY + sizeY > maxHeight) {

                maxHeight = positionY + sizeY;
            }
        }
    }
    maxWidth = maxWidth * 0.3;
    maxHeight = maxHeight * 0.3;
    if (maxWidth < 1100) {

        maxWidth = 1100;
    }
    var svg = document.getElementById("svgCanvas");
    document.getElementById("svgCanvas").style.width = (maxWidth) + "px";
    document.getElementById("svgCanvas").style.height = (maxHeight + 100) + "px";
    var s = "0 0 " + (maxWidth + 80) + " " + maxHeight;
    s = "0 0 " + maxWidth + " " + (maxHeight - 100);
    svg.setAttribute('viewBox',s);
};

BasicProcess.prototype.addLaneAbility = function(model){

    // 如果为泳道图则为其添加泳道
    if (model.typenum == "140" || model.typenum == "141") {

        var lanes = model.laneBeans;
        for (var i = 0; i < lanes.length; i++) {

            var lane = lanes[i];
            // 添加横向泳道orientation为1，纵向泳道为0
            if (lane.orientation == 1) {

                // 绘制水平泳道线
                var startX = 0;
                var startY = parseInt(lane.endborder);
                // 泳道线长度暂定9999，后续不够长再调整
                var endX = 19999;
                var endY = startY;
                var symbol = this.svg.paper.line(startX, startY, endX, endY).attr({

                    fill:"none",
                    stroke:"#000000",
                    strokeWidth:1,
                });
                this.svg.select("#svgGroup").append(symbol);
                // 添加水平泳道的说明栏
                var rect = this.svg.paper.rect().attr({

                    x:startX,
                    y:parseInt(lane.startborder),
                    width:62.5,
                    height:parseInt(lane.endborder) - parseInt(lane.startborder),
                    fill:"#EFEFE7",
                    stroke:"#000000",
                    strokeWidth:1,
                });
                this.svg.select("#svgGroup").append(rect);
                // 添加水平泳道的说明栏文字内容
                var content = "";
                if (lane.laneAttrBeans.length > 0) {

                    content = lane.laneAttrBeans[0].plaintextfragment;
                }
                if (content != "") {

                    var conH = content.length * 20;
                    for (var j = 0; j < content.length; j++) {
                        
                        var rectH = parseInt(lane.endborder) - parseInt(lane.startborder);
                        var fontX = 12;
                        // 矩形顶点y坐标 + （矩形高度-字串总高度）的一半(* 0.5) + 每个字的高度
                        var fontY = parseInt(lane.startborder) + (rectH - conH) * 0.5 + j * 40;
                        var text = this.svg.paper.text(fontX, fontY, content[j]);
                        this.svg.select("#svgGroup").append(text);
                    }
                }
            } else {

                // 绘制垂直泳道线
                var startX = parseInt(lane.endborder);
                var startY = 0;
                var endX = startX;
                var endY = 9999;
                var symbol = this.svg.paper.line(startX, startY, endX, endY).attr({

                    id:lane.id,
                    fill:"none",
                    stroke:"#000000",
                    strokeWidth:1,
                });
                this.svg.select("#svgGroup").append(symbol);
                // 添加垂直泳道的说明栏
                var rect = this.svg.paper.rect().attr({

                    x:parseInt(lane.startborder),
                    y:0,
                    width:parseInt(lane.endborder) - parseInt(lane.startborder),
                    height:62.5,
                    fill:"#EFEFE7",
                    stroke:"#000000",
                    strokeWidth:1,
                });
                this.svg.select("#svgGroup").append(rect);
                // 添加垂直泳道的说明栏文字内容
                var content = "";
                if (lane.laneAttrBeans.length > 0) {

                    content = lane.laneAttrBeans[0].plaintextfragment;
                }
                if (content != "") {
                    
                    var conLen = ArisUtil.getNamePx(content);
                    var rectW = parseInt(lane.endborder) - parseInt(lane.startborder);
                    var fontX = parseInt(lane.startborder) + (rectW - conLen) * 0.5;
                    var fontY = 48;
                    var text = this.svg.paper.text(fontX, fontY, content);
                    this.svg.select("#svgGroup").append(text);
                }
            }
        }
        return symbol;
    }
};