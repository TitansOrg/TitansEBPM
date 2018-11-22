var ArisUtil = function () {

}

/**
 * 处理OccBean中points栏位，将16进制的字串，8位一组转化为10进制的点坐标.
 */
ArisUtil.pointHexToInt = function(points){
    
    var start = 0;
    var result = "";
    for (var i = 0; i < points.length; i = i + 8) {
        var s = parseInt(points.substring(start,start + 8),16);
        //sqlserver会多出来很多的0所以去掉
        if(s==0){
            return result;
        }
        if (i == 0) {

            result = result + s;
        }else {
            
            result = result + "," + s;
        }
        start = start + 8;
    }
    
    return result;
};


ArisUtil.convertColor = function(cARGB) {

    var hexColor = "#FFFFFF";
    if(cARGB == "-1"){
        return hexColor;
    }
    if (!isNaN(cARGB)) {

        var blue = (cARGB >> 16) & 0xff;
        var green = (cARGB >> 8) & 0xff;
        var red = cARGB & 0xff;
        
        var zero = "00";
        var redh = zero.substr(0, 2 - red.toString(16).length) + red.toString(16);
        var greenh = zero.substr(0, 2 - green.toString(16).length) + green.toString(16);
        var blueh = zero.substr(0, 2 - blue.toString(16).length) + blue.toString(16);
        hexColor = "#" + redh + greenh + blueh;
    }
    return hexColor;
}

/**
 * 符号转16进制颜色
 * @param cARGB
 * @returns {String}
 */
ArisUtil.convertSymbolColor = function(cARGB) {
    var hexColor = "#FFFFFF";
    if (cARGB == "-1") {

        return hexColor;
    }
    if (!isNaN(cARGB)) {

        if (parseInt(cARGB).toString(16).length < 6) {

            return this.convertColor(cARGB);
        } else {
        	return "#" + parseInt(cARGB).toString(16);
        }
    }
    
    return hexColor;
}

/**
 * 获取给定字符串的长度.
 * @param str 新流程图名称
 */
ArisUtil.getNamePx = function (str) {

    var len = 0;
    if (str == null) {

        return len;
    }
    for (var i = 0; i < str.length; i++) {

        // 微软雅黑9号字
        var myChar = str[i];
        var c = parseFloat(str.charCodeAt(i));
        if (c >= 48 && c <= 57) {

            // 一个数字宽度为 23.2558
            len = len + 23.2558;
        } else if (c >= 97 && c <= 122) {

            // 英文小写字母
            if (myChar == "a") {
                len = len + 22.22222;
            } else if (myChar == "b") {
                len = len + 26.315789;
            } else if (myChar == "c") {
                len = len + 20;
            } else if (myChar == "d") {
                len = len + 26.315789;
            } else if (myChar == "e") {
                len = len + 23.2558;
            } else if (myChar == "f") {
                len = len + 14.0845;
            } else if (myChar == "g") {
                len = len + 26.315789;
            } else if (myChar == "h") {
                len = len + 25;
            } else if (myChar == "i") {
                len = len + 11.049724;
            } else if (myChar == "j") {
                len = len + 11.049724;
            } else if (myChar == "k") {
                len = len + 22.22222;
            } else if (myChar == "l") {
                len = len + 11.049724;
            } else if (myChar == "m") {
                len = len + 37.037037;
            } else if (myChar == "n") {
                len = len + 25;
            } else if (myChar == "o") {
                len = len + 25;
            } else if (myChar == "p") {
                len = len + 26.315789;
            } else if (myChar == "q") {
                len = len + 26.315789;
            } else if (myChar == "r") {
                len = len + 15.037594;
            } else if (myChar == "s") {
                len = len + 19.04762;
            } else if (myChar == "t") {
                len = len + 15.037594;
            } else if (myChar == "u") {
                len = len + 25;
            } else if (myChar == "v") {
                len = len + 21.05263;
            } else if (myChar == "w") {
                len = len + 32.258;
            } else if (myChar == "x") {
                len = len + 20;
            } else if (myChar == "y") {
                len = len + 21.05263;
            } else if (myChar == "z") {
                len = len + 20;
            }
        } else if (c >= 65 && c <= 90) {

            // 大写英文字母
            if (myChar == "A") {
                len = len + 28.169;
            } else if (myChar == "B") {
                len = len + 25;
            } else if (myChar == "C") {
                len = len + 27.027;
            } else if (myChar == "D") {
                len = len + 30.303;
            } else if (myChar == "E") {
                len = len + 22.22222;
            } else if (myChar == "F") {
                len = len + 21.05263158;
            } else if (myChar == "G") {
                len = len + 26.31578947;
            } else if (myChar == "H") {
                len = len + 31.25;
            } else if (myChar == "I") {
                len = len + 12.0482;
            } else if (myChar == "J") {
                len = len + 16;
            } else if (myChar == "K") {
                len = len + 25;
            } else if (myChar == "L") {
                len = len + 20.8333;
            } else if (myChar == "M") {
                len = len + 39.215686;
            } else if (myChar == "N") {
                len = len + 33.33333;
            } else if (myChar == "O") {
                len = len + 33.33333;
            } else if (myChar == "P") {
                len = len + 24.096385;
            } else if (myChar == "Q") {
                len = len + 33.33333;
            } else if (myChar == "R") {
                len = len + 26.315789;
            } else if (myChar == "S") {
                len = len + 23.255814;
            } else if (myChar == "T") {
                len = len + 23.255814;
            } else if (myChar == "U") {
                len = len + 30.303030;
            } else if (myChar == "V") {
                len = len + 27.027027027;
            } else if (myChar == "W") {
                len = len + 41.66667;
            } else if (myChar == "X") {
                len = len + 26.31578947;
            } else if (myChar == "Y") {
                len = len + 24.0963855;
            } else if (myChar == "Z") {
                len = len + 25;
            }
        } else {
         
            // 半角
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                if (myChar == "*") {
                     len = len + 17.2;
                 } else {
                     len = len + 13.548;
                 }
            } else {

                // 微软雅黑9号字，汉字长度40
                len = len + 40;
            }

        }
    }
    //右侧统一缩进一点
    len = len + 6
    return len;
}

/**
 * 获取给定字符串的长度(微软雅黑11号字体加粗的).
 * @param str 新流程图名称
 */
ArisUtil.getNamePxN = function (str) {
    var len = 0;
    if (str == null) {

        return len;
    }
    for (var i = 0; i < str.length; i++) {

        // 微软雅黑11号字
        var myChar = str[i];
        var c = parseFloat(str.charCodeAt(i));
        if (c >= 48 && c <= 57) {
            // 一个数字宽度为 28.47619047619048;
            len = len + 28.47619047619048;
        } else if (c >= 97 && c <= 122) {

            // 英文小写字母
            if (myChar == "a") {
                len = len + 27.1819;
            } else if (myChar == "b") {
                len = len + 31.4737;
            } else if (myChar == "c") {
                len = len + 23;
            } else if (myChar == "d") {
                len = len + 31.4737;
            } else if (myChar == "e") {
                len = len + 27.1819;
            } else if (myChar == "f") {
                len = len + 18.6875;
            } else if (myChar == "g") {
                len = len + 31.4737;
            } else if (myChar == "h") {
                len = len + 29.9;
            } else if (myChar == "i") {
                len = len + 13.906976;
            } else if (myChar == "j") {
                len = len + 13.907;
            } else if (myChar == "k") {
                len = len + 35.177;
            } else if (myChar == "l") {
                len = len + 35.177;
            } else if (myChar == "m") {
                len = len + 35.177;
            } else if (myChar == "n") {
                len = len + 46;
            } else if (myChar == "o") {
                len = len + 30.666666666667;
            } else if (myChar == "p") {
                len = len + 31.47368421052632;
            } else if (myChar == "q") {
                len = len + 31.47368421052632;
            } else if (myChar == "r") {
                len = len + 19.93333333333;
            } else if (myChar == "s") {
                len = len + 28.47619047619048;
            } else if (myChar == "t") {
                len = len + 19.29032258064516;
            } else if (myChar == "u") {
                len = len + 29.9;
            } else if (myChar == "v") {
                len = len + 27.18181818181818;
            } else if (myChar == "w") {
                len = len + 39.866666666667;
            } else if (myChar == "x") {
                len = len + 27.181818181818;
            } else if (myChar == "y") {
                len = len + 27.181818181818;
            } else if (myChar == "z") {
                len = len + 23.92;
            }
            
        } else if (c >= 65 && c <= 90) {

            // 大写英文字母
            if (myChar == "A") {
                len = len + 35.17647058823529;
            } else if (myChar == "B") {
                len = len + 31.47368421052632;
            } else if (myChar == "C") {
                len = len + 31.47368421052632;
            } else if (myChar == "D") {
                len = len + 37.1;
            } else if (myChar == "E") {
                len = len + 27.18181818181818;
            } else if (myChar == "F") {
                len = len + 26;
            } else if (myChar == "G") {
                len = len + 35.17647058823529;
            } else if (myChar == "H") {
                len = len + 38.2;
            } else if (myChar == "I") {
                len = len + 15.73684210526316;
            } else if (myChar == "J") {
                len = len + 22.14814814814815;
            } else if (myChar == "K") {
                len = len + 32.7;
            } else if (myChar == "L") {
                len = len + 25.5;
            } else if (myChar == "M") {
                len = len + 47.84;
            } else if (myChar == "N") {
                len = len + 39.8666666667;
            } else if (myChar == "O") {
                len = len + 38.2;
            } else if (myChar == "P") {
                len = len + 30.8;
            } else if (myChar == "Q") {
                len = len + 38.2;
            } else if (myChar == "R") {
                len = len + 32.7;
            } else if (myChar == "S") {
                len = len + 28.1;
            } else if (myChar == "T") {
                len = len + 29.17;
            } else if (myChar == "U") {
                len = len + 36.24242424242424;
            } else if (myChar == "V") {
                len = len + 33.22222222222222;
            } else if (myChar == "W") {
                len = len + 49.76;
            } else if (myChar == "X") {
                len = len + 32.8;
            } else if (myChar == "Y") {
                len = len + 30.1;
            } else if (myChar == "Z") {
                len = len + 30.2;
            }
        } else {

            // 半角
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {

                len = len + 18.121212121212;
            } else {

                // 微软雅黑11号字加粗，汉字长度46
                len = len + 46;
            }
        }
    }
    len = len + 6;
    return len;
}