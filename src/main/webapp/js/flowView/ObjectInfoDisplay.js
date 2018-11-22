var ObjectInfoDisplay = function (svg) {

    this.svg = svg;
    
}

ObjectInfoDisplay.prototype.displayInfo = function (occBean ,modelTypeNum) {
    //这里是符号的一些位置 用来点击文字的时候保证选中边框的大小
    var tx = parseInt(occBean.positionX);
    var ty = parseInt(occBean.positionY);
    var tw = parseInt(occBean.sizeX);
    var th = parseInt(occBean.sizeY);
    var attrOccBeans = occBean.attrOccBeans;
    //点击文字添加事件，特殊符号处理，同符号显示右侧属性对应
    
    //活动特殊处理 添加入参model_id
    var ids;
    var typenum = parseInt(occBean.typenum);
    var modelId = occBean.modelid;
    var definitionId = occBean.definitionBean.id;
    var symbolguid = occBean.symbolguid;
    //判断顶层组织图跟金龙连接的几个职位符号。就不画下面的负责人并且垂直居中显示
    var jlDef = "";
    for (var i = 0; i < attrOccBeans.length; i++) {

        var attrs = occBean.definitionBean.definitionAttrBeans;
        var content = "";
        var alignment = 0;
        var postID = "";//存放岗位ID
        var deptID = "";//存放部门ID
        for (var j = 0; j < attrs.length; j++) {

            if (attrs[j].attrtypenum == attrOccBeans[i].attrtypenum && attrs[j].typeguid == attrOccBeans[i].typeguid) {
                 alignment = attrOccBeans[i].alignment;
                 var val1 = attrs[j].plaintextfragment;
                 var val2 = attrs[j].plaintextclob;
                 if (val2 != null && val2.length > val1.length) {

                     content = val2;
                 } else {

                     content = val1;
                 }
                 break;
             }
         }
         // 如果内容为空，则不用考虑显示内容
         if (content == "" || typeof(content) == "undefined" || content == null) {

             continue;
         }
         // 符号左上顶点横坐标
         var x = parseInt(occBean.positionX);
        // 符号左上顶点纵坐标
         var y = parseInt(occBean.positionY);
        // 符号的实际宽度
         var w = parseInt(occBean.sizeX);
        // 符号的实际高度
         var h = parseInt(occBean.sizeY);
         // 符号中心点横坐标
         var centerX = x + w * 0.5;
        // 符号中心点纵坐标
         var centerY = y + h * 0.5;
        // 需要显示内容的总的像素长度
         var contentLen = ArisUtil.getNamePx(content);
        // 选择内容显示的位置
        switch (parseInt(attrOccBeans[i].port)) {

            case 1:
                // 符号外左上
                var fontX = x - contentLen;
                var fontY = y - 16;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 2:
                // 符号外上中
                var rows = Math.floor(h / 74);
                var rowLen = 0;
                var rowContentArr = [];
                var rowContent ="";
                for (var s = 0; s < content.length; s++) {
                    if ((rowLen + ArisUtil.getNamePx(content[s])) > w) {

                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "" + content[s];
                        rowLen = ArisUtil.getNamePx(content[s]);
                    } else if (content[s] == "\r") {

                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "";
                        s = s + 1;
                    } else {
                        rowLen = rowLen + ArisUtil.getNamePx(content[s]);
                        rowContent = rowContent + content[s];
                    }
                    if (s == content.length-1) {
                        rowContentArr.push(rowContent);
                    }
                 }
                 var rowsH;
                 if (rows > rowContentArr.length) {

                     rowsH = rowContentArr.length * 40;
                 } else {

                     rowsH = rows * 40;
                 }
                 var fontStartY = y - 80 ;

                 for (var s = 0; s < rowContentArr.length; s++) {

                     var fontX = x + (w - ArisUtil.getNamePx(rowContentArr[s])) * 0.5;
                     var fontY = fontStartY + s * 40 + 20;
                     if (rowContentArr.length == 1) {

                         fontY = y - 16;
                     } 
                     if (rows < rowContentArr.length && (s + 1) == rows) {

                         var text = this.svg.paper.text(fontX, fontY, rowContentArr[s]).attr({
                             cursor:"pointer",
                             onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                         });
                         this.svg.select("#svgGroup").append(text);
                         break;
                     } else {

                         var text = this.svg.paper.text(fontX, fontY, rowContentArr[s]).attr({
                             cursor:"pointer",
                             onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                         });
                         this.svg.select("#svgGroup").append(text);
                     }
                 }
                 break;
            case 3:
                // 符号外右上
                var fontX = x + w;
                var fontY = y - 16;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 4:
                // 符号外左中
                var fontX = x - contentLen;
                var fontY = centerY;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 5:
                // 符号内中心
                var rows = Math.floor(h / 74);
                var rowLen = 0;
                var rowContentArr = [];
                var rowContent ="";
                for (var s = 0; s < content.length; s++) {

                    if ((rowLen + ArisUtil.getNamePx(content[s])) > w) {

                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "" + content[s];
                        rowLen = ArisUtil.getNamePx(content[s]);
                    } else if (content[s] == "\r") {

                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "";
                        // 换行有\r就必定有\n，故直接跳过\n
                        s = s + 1;
                    } else {

                        rowLen = rowLen + ArisUtil.getNamePx(content[s]);
                        rowContent = rowContent + content[s];
                    }
                    if (s == content.length-1) {

                        rowContentArr.push(rowContent);
                    }
                }
                var rowsH;
                if (rows > rowContentArr.length) {

                    rowsH = rowContentArr.length * 40;
                } else {

                    rowsH = rows * 40;
                }
                var fontStartY = y + (h - rowsH) * 0.5 + 40;
                for (var s = 0; s < rowContentArr.length; s++) {

                    var fontX = x + (w - ArisUtil.getNamePx(rowContentArr[s])) * 0.5 + 13;
                    var fontY = fontStartY + s * 40;
                    if (rows < rowContentArr.length && (s + 1) == rows) {

                        var text = this.svg.paper.text(fontX, fontY, rowContentArr[s].substring(0, rowContentArr[s].length-1) + "...").attr({
                            cursor:"pointer",
                            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                        });
                        this.svg.select("#svgGroup").append(text);
                        break;
                    } else {

                        var text = this.svg.paper.text(fontX, fontY, rowContentArr[s]).attr({
                            cursor:"pointer",
                            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                        });
                        this.svg.select("#svgGroup").append(text);
                    }
                }
                break;
            case 6:
                // 符号外右中
                var fontX = x + w;
                var fontY = centerY;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 7:
                // 符号外左下
                var fontX = x - contentLen;
                var fontY = y + h + 48;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 8:
                // 符号外下中
                var fontX = centerX - contentLen * 0.5;
                var fontY = y + h + 48;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 9:
                // 符号外右下
                var fontX = x + w;
                var fontY = y + h + 48;
                var text = this.svg.paper.text(fontX, fontY, content).attr({
                    cursor:"pointer",
                    onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                });
                this.svg.select("#svgGroup").append(text);
                break;
            case 10:
                // 符号内上中
                var rows = Math.floor(h / 74);
                var rowLen = 0;
                var rowContentArr = [];
                var rowContent ="";
                for (var s = 0; s < content.length; s++) {

                    if ((rowLen + ArisUtil.getNamePx(content[s])) > w) {

                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "" + content[s];
                        rowLen = ArisUtil.getNamePx(content[s]);
                    } else if (content[s] == "\r") {
                        
                        rowContentArr.push(rowContent);
                        rowLen = 0;
                        rowContent = "";
                        s = s + 1;
                    } else {

                        rowLen = rowLen + ArisUtil.getNamePx(content[s]);
                        rowContent = rowContent + content[s];
                    }
                    if (s == content.length-1) {

                        rowContentArr.push(rowContent);
                    }
                }
                var rowsH;
                if (rows > rowContentArr.length) {

                    rowsH = rowContentArr.length * 40;
                } else {

                    rowsH = rows * 40;
                }
                var fontStartY = y + 65;
                var orderNum = attrOccBeans[i].ordernum; 
                if ( orderNum == 1 ) {
                    //标示符占一行，所以第二行高度+40 15行间距
                    fontStartY = fontStartY + 55 
                } 
                for (var s = 0; s < rowContentArr.length; s++) {

                    var fontX = x + (w - ArisUtil.getNamePx(rowContentArr[s])) * 0.5;
                    var fontY = fontStartY + s * 40;
                    if (rows < rowContentArr.length && (s + 1) == rows) {

                        var text = this.svg.paper.text(fontX, fontY, rowContentArr[s].substring(0, rowContentArr[s].length-1) + "...").attr({
                            cursor:"pointer",
                            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                        });
                        this.svg.select("#svgGroup").append(text);
                        break;
                    } else {

                        var text = this.svg.paper.text(fontX, fontY, rowContentArr[s]).attr({
                            cursor:"pointer",
                            onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                        });
                        this.svg.select("#svgGroup").append(text);
                    }
                }
                break;
            case 11:
                // 符号内下中
                break;
            case 12:

                // 定义行的高度
                var lineHeight = 45;
                // 这个值是用来弥补ABA中和平台中宽度的差异的。例如ABA中设定文本框宽度为50mm，里面可以显示10个字
                // 但是这个50通过数据数据库到达页面时，所能容纳的字数要多于10个，同时我们的页面时缩小了一倍显示的，
                // 随意位置，需根据XOFFSET，YOFFSET设置位置，相对偏移位置的坐标是相对于符号中心坐标的
                var xoffset = parseInt(attrOccBeans[i].xoffset);
                var yoffset = parseInt(attrOccBeans[i].yoffset);
                var sizeX = parseInt(attrOccBeans[i].sizeX);
                var sizeY = parseInt(attrOccBeans[i].sizeY);
                // 所画的符号图形的正中心点的坐标，它的坐标加上水平和竖直方向上的偏移量，可以得到文本框的中心点坐标
                var centerPoint = {

                    posx : x + w * 0.5,
                    posy : y + h * 0.5
                };
                // 文本框
                // 竖直方向上文字永远处于该文本框的最顶端，水平方向上文字在该框中居中显示
                var textBox = {

                    // 文本框中心位置
                    centerPointX : centerPoint.posx + xoffset,
                    centerPointY : centerPoint.posy + yoffset,
                    width : sizeX,
                    height : sizeY,
                    // 文本框顶部位置
                    textBoxTopStart : 0,
                    // 文本框左侧竖线位置
                    textBoxLeftStart : 0
                };
                // content内容不为空，文本框的宽度和高度不可能真正为0。计算文本框的真实宽度和高度
                // 当文本框的宽度和高度不为0的时候，该值是由用户设置的，保留原始值
                // 当文本框的高度或者宽度为0时，根据文本的实际内容，计算该框的高度和宽度
                // 计算文本框的高度
                var rowLen = 0;
                var rowContentArr = [];
                var rowContent ="";
                // 计算文本内容
                if (textBox.width == 0) {

                    for (var s = 0; s < content.length; s++) {

                        if (content[s] == "\r") {

                            rowContentArr.push(rowContent);
                            rowLen = 0;
                            rowContent = "";
                            s = s + 1;
                        } else {

                            rowLen = rowLen + ArisUtil.getNamePx(content[s]);
                            rowContent = rowContent + content[s];
                        }
                        if (s == content.length - 1) {

                            rowContentArr.push(rowContent);
                        }
                    }
                } else {

                    // 用户限定了其宽度，内容的换行会受到宽度的限制
                    for (var s = 0; s < content.length; s++) {

                        if (content[s] == "\r") {

                            rowContentArr.push(rowContent);
                            rowLen = 0;
                            rowContent = "";
                            s = s + 1;
                        } else if ((rowLen + ArisUtil.getNamePx(content[s])) > textBox.width) {

                            rowContentArr.push(rowContent);
                            rowLen = 0;
                            rowContent = "" + content[s];
                            rowLen = ArisUtil.getNamePx(content[s]);
                        } else {

                            rowLen = rowLen + ArisUtil.getNamePx(content[s]);
                            rowContent = rowContent + content[s];
                        }
                        if (s == content.length - 1) {

                            rowContentArr.push(rowContent);
                        }
                    }
                }
                // 在对这些文字做了按照文本框宽度划分成多行之后，只要判断高度，如果文本框高度不够，就将能够显示的最后一行最后一个字符换成“...”
                if (textBox.height != 0  && (rowContentArr.length * lineHeight > textBox.height)) {

                    // 当用户设定的高度很小而不足一行的时候，会按照一行显示
                    var showLineNum = Math.floor(textBox.height / lineHeight);
                    if (showLineNum < 1) {

                        showLineNum = 1;
                    }
                    var lastLine = rowContentArr[showLineNum - 1];
                    rowContentArr[showLineNum - 1] = lastLine.substring(0, lastLine.length - 1) + "...";
                    rowContentArr.splice(showLineNum, rowContentArr.length - showLineNum);
                    textBox.textBoxTopStart = textBox.centerPointY - textBox.height * 0.5;
                    // 计算文本框宽度
                    if (textBox.width == 0) {

                        var len = 0;
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var rowContent = rowContentArr[s];
                            if (ArisUtil.getNamePx(rowContent) > len) {
                                len = ArisUtil.getNamePx(rowContent);
                            }
                        }
                        textBox.width = len;
                    }
                    // 循环依次写字
                    if (alignment == 0 || alignment == 3 || typeof(alignment) == "undefined") {

                        // 居左显示
                        for (var s = 0; s < rowContentArr.length; s++) {
                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX - textBox.width * 0.5;
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    }  else if (alignment == 2) {

                        // 居右显示
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX + textBox.width * 0.5 - ArisUtil.getNamePx(str);
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    } else if (alignment == 1 || alignment == 4) {

                        // 居中显示
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX - ArisUtil.getNamePx(str) * 0.5;
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    }
                } else {
                    // 计算文本框宽度

                    if (textBox.width == 0) {

                        var len = 0;
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var rowContent = rowContentArr[s];
                            if (ArisUtil.getNamePx(rowContent) > len) {
                                len = ArisUtil.getNamePx(rowContent);
                            }
                        }
                        textBox.width = len;
                    }
                    textBox.textBoxTopStart = textBox.centerPointY - rowContentArr.length * lineHeight * 0.5;
                    // 循环依次写字
                    if (alignment == 0 || alignment == 3 || typeof(alignment) == "undefined") {

                        // 居左显示
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX - textBox.width * 0.5;
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    }  else if (alignment == 2) {

                        // 居右显示
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX + textBox.width * 0.5 - ArisUtil.getNamePx(str);
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    } else if (alignment == 1 || alignment == 4) {

                        // 居中显示
                        for (var s = 0; s < rowContentArr.length; s++) {

                            var str = rowContentArr[s];
                            var fontX = textBox.centerPointX - ArisUtil.getNamePx(str) * 0.5;
                            // 每输出一行Y 坐标加上一行的行高fontHeight。减去15，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                            var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 15;
                            var text = this.svg.paper.text(fontX, fontY, str).attr({
                                cursor:"pointer",
                                onmousedown:"symbolclick(evt,'"+definitionId+"','"+occBean.definitionBean.defsymbolnum+"','"+tx+"','"+ty+"','"+tw+"','"+th+"');"
                            });
                            this.svg.select("#svgGroup").append(text);
                        }
                    }
                }
                break;
        }
    }

}