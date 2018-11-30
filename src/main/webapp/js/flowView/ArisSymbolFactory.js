var ArisSymbolFactory = function(svg){

    this.svg = svg;
};

/**
 * 创建ARIS系统的符号.
 */
ArisSymbolFactory.prototype.createArisSymbol = function (occBean) {

    var symbol;
    if (typeof(occBean.symbolguid) == "undefined") {

        symbol = this.createArisGeneralSymbol(occBean);
    } else {

        symbol = this.createArisSpecialSymbol(occBean);
    }
    return symbol;
}

/**
 * 创建ARIS系统原厂的符号.
 */
ArisSymbolFactory.prototype.createArisGeneralSymbol = function(occBean) {

    var origW;
    var origH;
    var x = parseInt(occBean.positionX);
    var y = parseInt(occBean.positionY);
    var w = parseInt(occBean.sizeX);
    var h = parseInt(occBean.sizeY);
    var typenum = parseInt(occBean.typenum)
    var penColor = occBean.penColor;
    var penWidth = occBean.penWidth;
    var penStyle = occBean.penStyle;
    var brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
    if (typeof(penColor) == "undefined" || penColor == "-1") {

        penColor = "0";
    }
    if (typeof(penWidth) == "undefined" || penWidth == "-1") {

        penWidth = 1;
    }
    if (typeof(penStyle) == "undefined" || penStyle == "-1" ) {

        penStyle = 0;
    }
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
    switch (typenum) {

        case 1:
            origW = 250;
            origH = 156;
            break;
        case 3:
            origW = 248;
            origH = 154;
            break;
        case 13:
            origW = 249;
            origH = 156;
            break;
        case 14:
            if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

                brushColor = "#00FFFF";
            }
            var rect = this.svg.paper.rect(x, y, w, h).attr({
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle,
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
            });
            var line1 = this.svg.paper.line(x + 15, y, x + 15, y + h).attr({
                stroke: "#000000",
                strokeWidth: 1
            });
            var line2 = this.svg.paper.line(x + 30, y, x + 30, y + h).attr({
                stroke: "#000000",
                strokeWidth: 1
            });
            var line3 = this.svg.paper.line(x + w - 15,y, x + w - 15, y + h).attr({
                stroke: "#000000",
                strokeWidth: 1
            });
            var line4 = this.svg.paper.line(x + w - 30, y, x + w - 30, y + h).attr({
                stroke: "#000000",
                strokeWidth: 1
            });
            var symbol = this.svg.paper.g();
            symbol.add(rect, line1, line2, line3, line4);
            return symbol;
        case 29:
            origW = 250;
            origH = 156;
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#9C9AFF";
            }
            break;
        case 33:
            origW = 249;
            origH = 156;
            // 设置默认颜色
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#00ffff";
            }
            break;
        case 40:
            origW = 250;
            origH = 156;
            break;
        case 42:
            origW = 100;
            origH = 100;
            break;
        case 43: 
            origW = 100;
            origH = 100;
            break;
        case 44:
            origW = 100;
            origH = 100;
            break;
        case 54:
            origW = 349;
            origH = 120;
            break;
        case 58:
            origW = 250;
            origH = 95;
            break;
        case 70:
            origW = 250;
            origH = 156;
            break;
        case 71:
            origW = 250;
            origH = 156;
            break;
        case 72:
            origW = 250;
            origH = 156;
            break;
        case 94:
            origW = 290;
            origH = 204;
            break;
        case 105:
            origW = 250;
            origH = 156;
            break;
        case 107:
            // wu  
            origW = 250;
            origH = 150;
            break;
        case 129:
            origW = 250;
            origH = 192;
            var scaleX = w / parseInt(origW);
            var scaleY = h / parseInt(origH);
            var transX = x - (scaleX * x);
            var transY = y - (scaleY * y);
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#00ff00";
            }
            var symbol = this.svg.paper.el("use", {
                id:occBean.definitionBean.globalid,
                x:x,
                y:y,
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
                "xlink:href":"#symbol_" + typenum,
                transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"')",
                msg:x+","+y+","+w+","+h
            });
            var text = this.svg.paper.image("/images/flowView/loading.jpg",x+w+50, y+h/2-50 ,100,100);
            this.svg.select("#svgGroup").append(text);
            return symbol;
        case 141:
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#00ff00";
            }
            var symbol = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle
            });
            return symbol;
        case 143:
            origW = 249;
            origH = 96;
            var scaleX = w / parseInt(origW);
            var scaleY = h / parseInt(origH);
            var transX = x - (scaleX * x);
            var transY = y - (scaleY * y);
            var symbol = this.svg.paper.el("use", {
                //这个符号重复所以用occ标的id
                id:occBean.id,
                x:x,
                y:y,
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
                "xlink:href":"#symbol_" + typenum,
                transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"')",
                msg:x+","+y+","+w+","+h
            });
            return symbol;
        case 144:
            //组织单元个性化
            origW = 250;
            origH = 155;
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#FFFF00";
            }
            var scaleX = w / parseInt(origW);
            var scaleY = h / parseInt(origH);
            var transX = x - (scaleX * x);
            var transY = y - (scaleY * y);
            var symbol = this.svg.paper.el("use", {
                id:occBean.definitionBean.globalid,
                x:x,
                y:y,
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
                "xlink:href":"#symbol_" + typenum,
                transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"')",
                msg:x+","+y+","+w+","+h
            });
            return symbol;
        case 145:
            origW = 249;
            origH = 95;
            break;
        case 161:
            origW = 249;
            origH = 155;
            break;
        case 228:
            origW = 250;
            origH = 156;
            break;
        case 229:
            origW = 254;
            origH = 156;
            break;
        case 284:
            origW = 246;
            origH = 155;
            break;
        case 335:
            var definitionId = occBean.definitionBean.id;
            var defsymbolnum = occBean.definitionBean.defsymbolnum;
            origW = 249;
            origH = 155;
            var scaleX = w / parseInt(origW);
            var scaleY = h / parseInt(origH);
            var transX = x - (scaleX * x);
            var transY = y - (scaleY * y);
            var symbol = this.svg.paper.el("use", {
                x:x,
                y:y,
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
                "xlink:href":"#symbol_" + typenum,
                transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
                onmousedown:"symbolclick(evt,'" + definitionId + "','" + defsymbolnum + "','" + x + "','" + y + "','" + w + "','" + h + "');"
            });
            return symbol;
        case 465:
            origW = 248;
            origH = 99;
            break;
        case 533:
            origW = 261;
            origH = 162;
            break;
        case 550:
            origW = 270;
            origH = 170;
            break;
        case 552:
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#DEDBA5";
            }
            origW = 258;
            origH = 145;
            break;
        case 634:
            // 用于背景
            var symbol = this.svg.paper.rect(x, y, w, h).attr({

                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" + penStyle
            });
            return symbol;
        case 640:
            origW = 290;
            origH = 174;
            break;
        case 646:
            origW = 297; 
            origH = 178;
            break;
        case 688:
            origW = 237;
            origH = 155;
            break;
        case 689:
            origW = 251;
            origH = 178;
            break;
        case 729:
            origW = 239;
            origH = 146;
            if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#ccd2e8";
            }
            break;
        case 772:
        	if (typeof(occBean.brushColor) == "undefined"  || brushColor == "-1") {

                brushColor = "#00FF00";
            }
            var polyline1 = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({

                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle,
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
            });
            var polyline2 = this.svg.paper.polyline(x+w-33,y + 19/20*h, x+4, y+19/20*h).attr({

                fill:"none",
                stroke:ArisUtil.convertSymbolColor(penColor),
                style:"stroke-width:" + penWidth + ";" +penStyle
            });
            var symbol = this.svg.paper.g();
            symbol.add(polyline1, polyline2);
            return symbol
            //origW = 250;
            //origH = 156;
            break;
        case 1122:
            //origW = 240;
            //origH = 60;
            origW = 960;
            origH = 240;
            break;
        case 66259:
            origW = 249;
            origH = 156;
            break;
        case 66308:
            var brushColor;
            if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

                brushColor = "#9CFF9C";
            } else {

                brushColor = ArisUtil.convertSymbolColor(occBean.brushColor)
            }
            var symbol = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({
                id:occBean.definitionBean.globalid,
                fill:brushColor,
                stroke:ArisUtil.convertSymbolColor(penColor),
                strokeWidth:penWidth,
                style:"cursor:pointer;",
                onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
            });
            return symbol;
        case 262916:
            var penColor1;
            var penWidth1;
            if (typeof(occBean.penColor) == "undefined" || penColor == "-1") {

                penColor1 = "#000000";
            } else {

                penColor1 = occBean.penColor;
            }
            if (typeof(occBean.penWidth) == "undefined" || penWidth == "-1") {

                penWidth1 = 3;
            } else {

                penWidth1 = occBean.penWidth;
            }
            var symbol = this.svg.paper.rect(x, y, w, h).attr({

                fill:ArisUtil.convertSymbolColor(occBean.brushColor),
                stroke:ArisUtil.convertSymbolColor(penColor1),
                style:"stroke-width:" + penWidth1 + ";" +penStyle
            });
            return symbol;
        default:
            alert("缺少符号类型：" + typenum);
            return;
    }
    var scaleX = w / parseInt(origW);
    var scaleY = h / parseInt(origH);
    var transX = x - (scaleX * x);
    var transY = y - (scaleY * y);
    var symbol = this.svg.paper.el("use", {
        id:occBean.definitionBean.globalid,
        x:x,
        y:y,
        fill:brushColor,
        stroke:ArisUtil.convertSymbolColor(penColor),
        style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
        "xlink:href":"#symbol_" + typenum,
        transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
        onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
    });
    return symbol;
};

function symbolclick(evt,id,type,x,y,w,h) {

    var defId = id;
    if (evt.which == 1) {

        var svg = Snap("#svgCanvas");
        var marked = svg.select("#marked");
        x = parseInt(x) - 20;
        y = parseInt(y) - 20;
        w = parseInt(w) + 40
        h = parseInt(h) + 40;
        if (marked == null) {

            var sym = svg.paper.rect(x, y, w, h, 20, 20).attr({

                id:"marked",
                fill: "none",
                stroke: "#00189C",
                strokeWidth: 8
            });
            svg.select("#svgGroup").append(sym);

        } else {

            marked.attr({

                x:x,
                y:y,
                width:w,
                height:h
            });
        }
        $("#infoOverlay").show();
        $.ajax({
            type: "post",
            url: serverName + "/flowInfo/queryObjDetailInfo.do",
            dataType: "text",
            data: {

                guid: defId,
                objType: type
            },
            success: function(data) {

                var arrs = $.parseJSON(data);
                // 对象特性
                var attrPanel = "";
                for (var i = 0; i < arrs.length; i++) {

                    if (arrs[i].name == undefined) {

                        continue;
                    }
                    if (arrs[i].name == null || arrs[i].name == "") {

                        title = "";
                    } else {

                        title = arrs[i].name + ":&nbsp;";
                    }
                    if (arrs[i].val != null) {

                        attrPanel = attrPanel + "<div style='padding:10px;border-bottom:1px solid #ccc;'>"
                            + "<b>" + title + "</b>" + arrs[i].val.replace(/\r\n/g,"<br/>") + "</div>";
                    } else {

                        attrPanel = attrPanel + "<div style='padding:10px;border-bottom:1px solid #ccc;'></div>";
                    }
                }
                $("#info").html(attrPanel);
                $("#infoOverlay").hide();
            }
        });
        evt.stopPropagation();
        evt.preventDefault();
    } else if (3 == evt.which) {

        // 右键单击直接阻止默认事件触发
        evt.stopPropagation();
        evt.preventDefault();
    }
}

/**
 * 创建定制后的特殊符号.
 */
ArisSymbolFactory.prototype.createArisSpecialSymbol = function (occBean) {

    var symbol;
    var symbolguid = occBean.symbolguid;
    //var symbolguid = occBean.definitionBean.symbolguid;
    var x = parseInt(occBean.positionX);
    var y = parseInt(occBean.positionY);
    var w = parseInt(occBean.sizeX);
    var h = parseInt(occBean.sizeY);
    var penColor = occBean.penColor;
    var penWidth = occBean.penWidth;
    var penStyle = occBean.penStyle;
    var brushColor = occBean.brushColor
    var origW;
    var origH;
    if (typeof(penColor) == "undefined" || penColor == "-1") {

        penColor = "0";
    }
    if (typeof(penWidth) == "undefined" || penWidth == "-1") {

        penWidth = 1;
    }
    if (typeof(penStyle) == "undefined" || penStyle == "-1") {

        penStyle = 0;
    }
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
    if (symbolguid == "CUSTOM_WORKFLOW") {
        w = w - 60;
        h = h - 45;
        // 65569 工作流程 3dae3470-65bd-11e6-786a-005056a14bdf
        if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

           brushColor = "#00ffff";
        } else {

           brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
        }
        
        var rect = this.svg.paper.rect(x, y, w, h).attr({

            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
        var polyline1 = this.svg.paper.polyline(x + 15,y, x + 15, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline2 = this.svg.paper.polyline(x + 30,y, x + 30, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline3 = this.svg.paper.polyline(x + w -30,y, x + w -30, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline4 = this.svg.paper.polyline(x + w - 15,y, x + w - 15, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var text = this.svg.paper.text(x + w - 80, y + h + 14, "≈").attr({

            fill:"#000000",
            stroke:"#000000",
            style:"font-family:NSimSun;font-size:108pt;font-weight:bold;stroke-width:1"
        });
        symbol = this.svg.paper.g();
        symbol.add(rect, polyline1, polyline2, polyline3, polyline4, text);
    } else if (symbolguid == "CUSTOM_VAL_ADD_CHN_SML") {

        // 65641 背景
        symbol = this.svg.paper.rect(x, y, w, h).attr({

            fill:ArisUtil.convertSymbolColor(occBean.brushColor),
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"cursor:default;stroke-width:" + penWidth + ";" +penStyle
        });
    }  else if (symbolguid == "CUSTOM_PRCS_MOD") {
        // 66308 增值链（EPC),TODO 确认是否需要选定框
        if (typeof(occBean.brushColor) == "undefined" || occBean.brushColor == "-1") {

            brushColor = "#9CFF9C";
        } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor)
        }
        var definitionId = occBean.definitionBean.id;
        symbol = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({
            id:occBean.definitionBean.globalid,
            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            strokeWidth:penWidth,
            style:"cursor:pointer;",
            onmousedown:"symbolclick(evt,'" + definitionId + "','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
    } else if (symbolguid == "CUSTOM_RULE_GUID") {

        // 66259 制度
        var rect = this.svg.paper.rect(x, y, w, h).attr({

            fill:ArisUtil.convertSymbolColor(occBean.brushColor),
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
        var polyline1 = this.svg.paper.polyline(x + 10,y, x + 10, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline2 = this.svg.paper.polyline(x + 20,y, x + 20, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline3 = this.svg.paper.polyline(x + w -20,y, x + w -20, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        var polyline4 = this.svg.paper.polyline(x + w - 10,y, x + w - 10, y + h).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        symbol = this.svg.paper.g();
        symbol.add(rect, polyline1, polyline2, polyline3, polyline4);
    } else if (symbolguid == "CUSTOM_FUNC") {

        // 65871 IPD结构元素 335
        symbol = this.svg.paper.rect(x, y, w, h).attr({

            fill:ArisUtil.convertSymbolColor(occBean.brushColor),
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle,
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
    } else if (symbolguid == "CUSTOM_BACKGROUND") {

        // 131844 流程模块（EPC）
        var rect = this.svg.paper.rect(x, y, w, h).attr({

            fill:ArisUtil.convertSymbolColor(occBean.brushColor),
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle,
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
        var polyline = this.svg.paper.polyline(x, y + h - 15, x + w, y + h - 15).attr({

            fill:"none",
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
        symbol = this.svg.paper.g();
        symbol.add(rect, polyline);
    } else if (symbolguid == "CUSTOM_VAL_ADD_CHN_LEFTUP") {

        /*
         * 197380 增值链（左上角）
         * 此符号颜色数据库中默认为空，系统获取与772符号相同的样式，故此处进行特殊设置
         */
         if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

            brushColor = "#00FF00";
         } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
         }
        symbol = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({

            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle
        });
    } else if (symbolguid == "6709a250-89c7-11e5-786a-005056a14bdf") {

        // 131624 KPI实例，默认背景为绿色
       
        if (typeof(occBean.brushColor) == "undefined" || occBean.brushColor == "-1") {

            brushColor = "#00FF00";
        } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
        }
        symbol = this.svg.paper.polyline(x, y + 60, x, y + h, x + w, y + h, x + w, y + 60, x + w * 0.5, y, x, y + 60).attr({

            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle,
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
    } else if (symbolguid == "CUSTOM_KIP_INSTANCE") {

        // 66088 取数点,默认为白色背景
        if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

            brushColor = "#FFFFFF";
        } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
        }
        symbol = this.svg.paper.ellipse(x + w * 0.5, y + h * 0.5, w * 0.5, h * 0.5).attr({

            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            style:"stroke-width:" + penWidth + ";" +penStyle,
            onmousedown:"symbolclick(evt,'"+occBean.id+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
    } else if (symbolguid == "CUSTOM_PRCSMOD") {

        // 262916 背景（EPC）
        var penColor1;
        var penWidth1;
        if (typeof(occBean.penColor) == "undefined" || penColor == "-1") {

            penColor1 = "#000000";
        }
        
        if (typeof(occBean.penWidth) == "undefined" || penWidth == "-1") {

            penWidth1 = 3;
        }
        symbol = this.svg.paper.rect(x, y, w, h).attr({

            fill:ArisUtil.convertSymbolColor(occBean.brushColor),
            stroke:penColor1,
            style:"stroke-width:" + penWidth1 + ";" +penStyle
        });
    } else if ( symbolguid == "CUSTOM_CONTROL_WORD") { //风控文档
        //65565
        if (typeof(occBean.penColor) == "undefined" || penColor == "-1") {

            penColor1 = "#000000";
        }
        if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

            brushColor = "#FFFFFF";
        } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor);
        }
         origW = 250;
         origH = 156;
         var scaleX = w / parseInt(origW);
         var scaleY = h / parseInt(origH);
         var transX = x - (scaleX * x);
         var transY = y - (scaleY * y);
         var symbol = this.svg.paper.el("use", {
             x:x,
             y:y,
             fill:brushColor,
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
             "xlink:href":"#symbol_" + 65565,
             transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")",
             onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
         });
    } else if (symbolguid == "CUSTOM_CONTROL_EPC") {

        // 262916 风控增值链（EPC),TODO 确认是否需要选定框
        if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

            brushColor = "#ccffcc";
        } else {

            brushColor = ArisUtil.convertSymbolColor(occBean.brushColor)
        }
        var definitionId = occBean.definitionBean.id;
        var polyline1 = this.svg.paper.polyline(x,y, x+w-35,y, x+w,y+h/2, x+w-35,y+h, x,y+h, x+35,y+h/2,x,y).attr({
            id:occBean.definitionBean.globalid,
            fill:brushColor,
            stroke:ArisUtil.convertSymbolColor(penColor),
            strokeWidth:penWidth,
            style:"cursor:pointer;",
            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
        var polyline2 = this.svg.paper.polyline(x+w/2+60,y+h+30, x + w/2,y+h-50 , x + w/2 +120,y+h-50  ,x+w/2+60,y+h+30).attr({

            id:occBean.definitionBean.globalid,
            fill:ArisUtil.convertSymbolColor('6749696'),
            stroke:ArisUtil.convertSymbolColor(penColor),
            strokeWidth:penWidth,
            style:"cursor:pointer;",
            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
        });
        var startX1= x+h+h/10 + w/5;
        var endY1 = y+h-h/10;
        var endY2 = endY1+ 40;
        var path = this.svg.paper.path("M"+startX1+","+endY1+ " A13,13 0 1,0 " + " " + startX1 +  ","+endY2 + "").attr({
            stroke: "#000",
            fill:"none",
            strokeWidth: 10
        });
        origW = 362;
        origH = 245;
        var scaleX = w / parseInt(origW);
        var scaleY = h / parseInt(origH);
        var transX = x - (scaleX * x);
        var transY = y - (scaleY * y);
        symbol = this.svg.paper.g().attr({
            transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")"
        });
        symbol.add(polyline1, polyline2, path);
    } else if (symbolguid == "CUSTOM_RULE_CONTROL") {
        // 制度控制点
        if (typeof(occBean.brushColor) == "undefined" || brushColor == "-1") {

            brushColor = "#9CCFFF";
        }
         var rect = this.svg.paper.rect(x, y, w, h).attr({

             fill:brushColor,
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle + ";cursor:pointer;",
             onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
         });
         var polyline1 = this.svg.paper.polyline(x + 10,y, x + 10, y + h).attr({

             fill:"none",
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle
         });
         var polyline2 = this.svg.paper.polyline(x + 20,y, x + 20, y + h).attr({

             fill:"none",
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle
         });
         var polyline3 = this.svg.paper.polyline(x + w -20,y, x + w -20, y + h).attr({

             fill:"none",
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle
         });
         var polyline4 = this.svg.paper.polyline(x + w - 10,y, x + w - 10, y + h).attr({

             fill:"none",
             stroke:ArisUtil.convertSymbolColor(penColor),
             style:"stroke-width:" + penWidth + ";" +penStyle
         });
         var polyline5 = this.svg.paper.polyline(x+w/2+60,y+h+30, x + w/2,y+h-50 , x + w/2 +120,y+h-50  ,x+w/2+60,y+h+30).attr({
            id:occBean.definitionBean.globalid,
            fill:ArisUtil.convertSymbolColor('6749696'),
            stroke:ArisUtil.convertSymbolColor(penColor),
            strokeWidth:penWidth,
            style:"cursor:pointer;",
            onmousedown:"symbolclick(evt,'"+occBean.definitionBean.id+"','"+occBean.definitionBean.defsymbolnum+"','"+x+"','"+y+"','"+w+"','"+h+"');"
         });
         var startX1= x+w/2+w/2.5;
         var endY1 = y+h-h/10;
         var endY2 = endY1+ 40;
        
         var path = this.svg.paper.path("M"+startX1+","+endY1+ " A13,13 0 1,0 " + " " + startX1 +  ","+endY2 + "").attr({
             stroke: "#000",
             fill:"none",
             strokeWidth: 10    
         });
    
         //先画100%  100%   196   255
         //    238   196    237   
         origW = w;
         origH = h*237/196;
         var scaleX = w / parseInt(origW);
         var scaleY = h / parseInt(origH);
         var transX = x - (scaleX * x);
         var transY = y - (scaleY * y);
         symbol = this.svg.paper.g();
         symbol = this.svg.paper.g().attr({
             transform:"translate(" + transX + "," + transY + ") scale(" + scaleX + "," + scaleY + ")"
         });
         symbol.add(rect,polyline1, polyline2, polyline3, polyline4, polyline5, path);
    } 
    return symbol;
}

/**
 * 显示对象分配任务的链接.
 */
ArisSymbolFactory.prototype.displayAssignTask = function (occBean) {

    var modelid = occBean.definitionBean.assignmentBeans[0].modelid;
    var url = serName + "/flowInfo/flowDetail2.do?modelId=" + escape(modelid);
    var task = this.svg.paper.el("use", {

        id:occBean.definitionBean.id.replace(/[:,#]/g,''),
        x: parseInt(occBean.positionX) + parseInt(occBean.sizeX) + 2,
        y: parseInt(occBean.positionY) + parseInt(occBean.sizeY) + 6,
        "xlink:href" : "#symbol_405",
        "onclick": "window.open('"+url+"');"
    });
    return task;
}