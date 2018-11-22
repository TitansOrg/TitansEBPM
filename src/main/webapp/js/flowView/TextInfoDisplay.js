var TextInfoDisplay = function (svg) {

    this.svg = svg;
}

TextInfoDisplay.prototype.displayInfo = function (occBean) {
    var attrOccBeans = occBean.attrOccBeans;
    for (var i = 0; i < attrOccBeans.length; i++) {

        var attrs = occBean.definitionBean.definitionAttrBeans;
        var content = "";
        var alignment = occBean.alignment;
        for (var j = 0; j < attrs.length; j++) {

            if (attrs[j].attrtypenum == attrOccBeans[i].attrtypenum) {

                content = attrs[j].plaintextfragment;
                var contentLong = attrs[j].plaintextclob;
                if (contentLong != null &&(contentLong.length > content.length)) {

                    content = contentLong;
                }
                break;
            }
        }
        // 如果内容为空，则不用考虑显示内容
        if (content == "" || typeof(content) == "undefined" || content == null) {

            continue;
        }
   
        var sizeX = parseInt(attrOccBeans[i].sizeX);
        var sizeY = parseInt(attrOccBeans[i].sizeY);
        var x = parseInt(occBean.positionX);
        var y = parseInt(occBean.positionY);
        var lineHeight = 50;
        // 文本框
        var textBox = {

            // 文本框中心位置
            centerPointX : x,
            centerPointY : y,
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
        var rowContent = "";
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

            // 用户限定了其宽度，而没有设定高度的时候，高度会根据内容和宽度设定自动调整
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
        if (rowContentArr.length * lineHeight > textBox.height && textBox.height != 0) {

            // 用户设定了高度，而且高度不够
            // 当用户设定的高度很小而不足一行的时候，会按照一行显示
            var showLineNum = Math.floor(textBox.height / lineHeight);
            if (showLineNum < 1) {

                showLineNum = 1;
            }
            var lastLine = rowContentArr[showLineNum - 1];
            rowContentArr[showLineNum - 1] = lastLine.substring(0, lastLine.length - 1) + "...";
            rowContentArr.splice(showLineNum, rowContentArr.length - showLineNum);
            textBox.textBoxTopStart = textBox.centerPointY - textBox.width * 0.5;
            // 循环依次写字
            if (alignment == 0 || alignment == 3 || typeof(alignment) == "undefined") {

                // 居左显示
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX;
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            }  else if (alignment == 2) {

                // 居右显示
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX - ArisUtil.getNamePx(str);
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            } else if (alignment == 1 || alignment == 4) {
                // 居中显示
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX - ArisUtil.getNamePx(str) * 0.5;
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            }
        } else {

            textBox.textBoxTopStart = textBox.centerPointY - rowContentArr.length * lineHeight * 0.5;
            // 循环依次写字
            if (alignment == 0 || alignment == 3 || typeof(alignment) == "undefined") {

                // 居左显示（3是由老图带进来的）
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX;
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            } else if (alignment == 2) {

                // 居右显示（5是由老图带进来的）
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX - ArisUtil.getNamePx(str);
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            } else if (alignment == 1 || alignment == 4) {
                // 居中显示
                for (var s = 0; s < rowContentArr.length; s++) {

                    var str = rowContentArr[s];
                    var fontX = textBox.centerPointX - ArisUtil.getNamePx(str) * 0.5;
                    // 每输出一行Y 坐标加上一行的行高fontHeight。减去30，是因为调试过程中发现，写字的时候，字体会自动向下移动一段距离
                    var fontY = textBox.textBoxTopStart + (s + 1) * lineHeight - 30;
                    var text = this.svg.paper.text(fontX, fontY, str);
                    this.svg.select("#svgGroup").append(text);
                }
            }
        }
    }
}