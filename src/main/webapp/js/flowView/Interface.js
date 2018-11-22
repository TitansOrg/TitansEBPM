/**
 * 定义通用接口类型.
 * @param name 接口名称
 * @param method 接口中所包含的方法名称数组
 * @throws Exception 参数不正确
 */
var Interface = function (name, methods) {
 
    if (arguments.length != 2) {

        throw new Error("接口的构造方法参数不正确，应该至少为两个参数！");
    }
    this.name = name;
    this.methods = [];
    for (var i = 0; i < methods.length; i++) {

        if (typeof methods[i] !== 'string') {

            throw new Error("构造方法中的的方法名称必须为一个字符串！");
        }
        this.methods.push(methods[i]);
    }
}
 
/**
 * 定义检查对象是否实现指定接口的方法.
 * @param object 被检查对象
 * @throws Exception 未实现该接口
 */
Interface.ensureImplements = function (object) {
 
    if (arguments.length < 2) {
 
        throw new Error("Interface.ensureImplements方法需要至少两个参数！");
    }
    for (var i = 1; i < arguments.length; i++) {
 
        var interface = arguments[i];
        if (interface.constructor !== Interface) {
 
            throw new Error("第二个参数必须是接口的一个实例！");
        }
    }
    for (var j = 0; j < interface.methods.length; j++) {
 
        var method = interface.methods[j];
        if (!object[method] || typeof object[method] !== 'function') {
 
            throw new Error("对象未实现接口" + interface.name + "中的" + method + "方法！");
        }
    }
} 