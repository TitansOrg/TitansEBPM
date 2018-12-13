(function ($) {

    var defaults = {

        id : "",
        title : "详细信息",
        url : "",
        width: 600,
        height: 400,
        closeable: true,
        ok: "确定",
        cancel: "取消",
        okFun: "toSubmit",
        cancelFun: "cancel",
        zIndex: 2000,
        param: {

            
        }
        
    };
    var tools = {

        clone: function (obj) {

            if (obj === null) {
                
                return null;
            };
            var o = tools.isArray(obj) ? [] : {};
            for (var i in obj) {
                
                o[i] = (obj[i] instanceof Date) ? new Date(obj[i].getTime()) : (typeof obj[i] === "object" ? tools.clone(obj[i]) : obj[i]);
            }
            return o;
        },
        isArray: function (arr) {

            return Object.prototype.toString.apply(arr) === "[object Array]";
        },
        apply: function (fun, param, defaultValue) {

            if ((typeof fun) == "function") {

                return fun.apply($.fn.titans, param ? param : []);
            }
            return defaultValue;
        }
    };
    var view = {

        makeFrameDialogView : function (setting) {

            var params = "";
            for (var param in setting.param) {

                params = params + param + "=" + setting.param[param] + "&";
            }
            var url = setting.url + "?" + params;
            var html = [];
            html.push("<div class='modal fade' id='" + setting.id + "' style='z-index:" + setting.zIndex + "'>");
            html.push("<div class='modal-dialog' style='width:" + setting.width + "px'>");
            html.push("<div class='modal-content'>");
            html.push("<div class='modal-header' style='border-bottom: 3px solid #3c8dbc;'>");
            if (setting.closeable) {

                html.push("<button type='button' class='close' data-dismiss='modal' aria-label='Close'>");
                html.push("<span aria-hidden='true'>&times;</span>");
                html.push("</button>");
            }
            html.push("<h4 class='modal-title' style='font-weight: bold;'>" + setting.title + "</h4>");
            html.push("</div>");
            html.push("<div class='modal-body'>");
            html.push("<iframe id='" + setting.id + "iframe' width='100%;' height='" + setting.height + "px' style='border-width:0px;' src='" + url + "'></iframe>");
            html.push("</div>");
            html.push("<div class='modal-footer'>");
            html.push("<button id='" + setting.id + "ok' class='btn btn-primary'>" + setting.ok + "</button>");
            html.push("<button id='" + setting.id + "cancel' class='btn btn-primary'>" + setting.cancel + "</button>");
            html.push("</div>");
            html.push("</div>");
            html.push("</div>");
            html.push("</div>");
            $(top.document.body).after(html.join(""));
        },
        
    };
    $.fn.titans = {

        dialog : {

            openDialog : function (options) {

                var setting = tools.clone(defaults);
                $.extend(setting, options);
                if (setting.id == "") {

                    setting.id = "dialog_" + new Date().getTime();
                }
                view.makeFrameDialogView(setting);
                var model = top.document.getElementById(setting.id);
                $(model).on('hidden.bs.modal', function() {

                    $(model).remove();
                })
                $(model).modal();
                $(top.document.getElementById(setting.id + "ok")).on("click", function() {

                    var fun = top.document.getElementById(setting.id + "iframe").contentWindow[setting.okFun];
                    tools.apply(fun, [$.fn.titans.dialog, setting.id]);
                });
                $(top.document.getElementById(setting.id + "cancel")).on("click", function() {

                    $(model).modal("hide");
                });
            },
            closeDialog : function (id) {

                $(top.document.getElementById(id)).modal("hide");
                var mainFrame = top.document.getElementById("mainFrame");
                $(mainFrame).attr("src", mainFrame.src);
            }
        }
    };
})(jQuery);