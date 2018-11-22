var ConnectionTypeInfoLib = (function () {

    var connectionTypeInfos = {

        3:{"name":"是…的上级","srcarrow":"0","tgtarrow":"1"},
        6:{"name":"属于","srcarrow":"0","tgtarrow":"1"},
        7:{"name":"由…组成","srcarrow":"0","tgtarrow":"1"},
        8:{"name":"是…技术上的上级","srcarrow":"0","tgtarrow":"1"},
        9:{"name":"是…学术上的上级","srcarrow":"0","tgtarrow":"1"},
        28:{"name":"创建输出到","srcarrow":"0","tgtarrow":"1"},
        30:{"name":"由…组成","srcarrow":"0","tgtarrow":"1"},
        39:{"name":"是…的面向流程的上级","srcarrow":"0","tgtarrow":"1"},
        41:{"name":"是…的面向对象的上级","srcarrow":"0","tgtarrow":"1"},
        43:{"name":"激活","srcarrow":"0","tgtarrow":"1"},
        44:{"name":"创建","srcarrow":"0","tgtarrow":"1"},
        46:{"name":"拥有从属事件","srcarrow":"0","tgtarrow":"1"},
        48:{"name":"由…评估","srcarrow":"0","tgtarrow":"1"},
        49:{"name":"是…的输入","srcarrow":"0","tgtarrow":"1"},
        50:{"name":"拥有…的输出","srcarrow":"0","tgtarrow":"1"},
        53:{"name":"为…提供输入","srcarrow":"0","tgtarrow":"1"},
        54:{"name":"链接","srcarrow":"0","tgtarrow":"1"},
        60:{"name":"使用","srcarrow":"0","tgtarrow":"1"},
        65:{"name":"完成","srcarrow":"0","tgtarrow":"0"},
        66:{"name":"创建","srcarrow":"0","tgtarrow":"1"},
        67:{"name":"包含","srcarrow":"0","tgtarrow":"0"},
        75:{"name":"拥有状态","srcarrow":"0","tgtarrow":"1"},
        116:{"name":"导致","srcarrow":"0","tgtarrow":"1"},
        117:{"name":"导致","srcarrow":"0","tgtarrow":"1"},
        118:{"name":"是…的前驱","srcarrow":"0","tgtarrow":"1"},
        147:{"name":"支持","srcarrow":"0","tgtarrow":"0"},
        152:{"name":"是…的前驱","srcarrow":"0","tgtarrow":"1"},
        155:{"name":"包含","srcarrow":"0","tgtarrow":"1"},
        210:{"name":"占据","srcarrow":"0","tgtarrow":"0"},
        218:{"name":"完成","srcarrow":"0","tgtarrow":"0"},
        221:{"name":"支持","srcarrow":"0","tgtarrow":"0"},
        232:{"name":"对…作出决定","srcarrow":"0","tgtarrow":"1"},
        233:{"name":"对…有贡献","srcarrow":"0","tgtarrow":"0"},
        239:{"name":"包含","srcarrow":"0","tgtarrow":"1"},
        247:{"name":"读取","srcarrow":"0","tgtarrow":"1"},
        255:{"name":"必须通报…的结果","srcarrow":"0","tgtarrow":"1"},
        266:{"name":"必须得到…的通知","srcarrow":"0","tgtarrow":"0"},
        279:{"name":"需要","srcarrow":"0","tgtarrow":"1"},
        323:{"name":"对…作出决定","srcarrow":"0","tgtarrow":"1"},
        324:{"name":"对…有贡献","srcarrow":"0","tgtarrow":"0"},
        326:{"name":"必须得到…的通知","srcarrow":"0","tgtarrow":"0"},
        363:{"name":"通过…得到降低","srcarrow":"0","tgtarrow":"1"},
        366:{"name":"由…实现","srcarrow":"0","tgtarrow":"1"},
        369:{"name":"属于","srcarrow":"0","tgtarrow":"1"},
        380:{"name":"影响","srcarrow":"0","tgtarrow":"1"},
        395:{"name":"是…组织的管理者","srcarrow":"0","tgtarrow":"1"},
        399:{"name":"提供","srcarrow":"0","tgtarrow":"1"},
        431:{"name":"包含","srcarrow":"0","tgtarrow":"1"},
        452:{"name":"可以自由处理","srcarrow":"0","tgtarrow":"1"},
        481:{"name":"和…相矛盾","srcarrow":"0","tgtarrow":"1"},
        486:{"name":"通过…来衡量","srcarrow":"0","tgtarrow":"0"},
        504:{"name":"和…有关系","srcarrow":"0","tgtarrow":"1"},
        507:{"name":"出现在","srcarrow":"0","tgtarrow":"0"},
        628:{"name":"在…被完成","srcarrow":"0","tgtarrow":"0"},
        629:{"name":"影响","srcarrow":"0","tgtarrow":"1"},
        663:{"name":"使用","srcarrow":"0","tgtarrow":"1"}
    };
    var ctor = function () {};
    ctor.getConnectionTypeInfo = function (name) {

        return connectionTypeInfos[name];
    };
    return ctor;
})();