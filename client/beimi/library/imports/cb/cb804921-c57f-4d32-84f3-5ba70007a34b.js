"use strict";
cc._RF.push(module, 'cb804khxX9NMoTzW6cAB6NL', 'loading');
// script/components/loading.js

"use strict";

cc.Class({
    extends: cc.Component,

    properties: {
        // foo: {
        //    default: null,      // The default value will be used only when the component attaching
        //                           to a node for the first time
        //    url: cc.Texture2D,  // optional, default is typeof default
        //    serializable: true, // optional, default is true
        //    visible: true,      // optional, default is true
        //    displayName: 'Foo', // optional
        //    readonly: false,    // optional, default is false
        // },
        // ...
        _progress: 0.0,
        _splash: null,
        _isLoading: false
    },

    // use this for initialization
    onLoad: function onLoad() {
        if (!cc.sys.isNative && cc.sys.isMobile) {
            var canvas = this.node.getComponent(cc.Canvas);
            canvas.fitHeight = true;
            canvas.fitWidth = true;
        }
        this.initMgr();
        this._splash = cc.find("Canvas/splash");
        this._splash.active = true;

        cc.tools.audio.playBGM("bgMain.mp3");
        var xhr = cc.tools.http.httpPost("/tokens", { username: 'admin', password: '123456' }, function (ret) {
            cc.tools.http.authorization = ret;
            cc.tools.http.httpGet("/tokens", function (ret) {
                //console.log(ret);
            });
        });
        io("http://127.0.0.1:9081/im/user?userid=admin");
    },
    start: function start() {
        var self = this;
        var SHOW_TIME = 3000;
        var FADE_TIME = 500;
        if (cc.sys.os != cc.sys.OS_IOS || !cc.sys.isNative) {
            self._splash.active = true;
        } else {
            self._splash.active = false;
        }
    },
    initMgr: function initMgr() {
        cc.tools = {};
        cc.tools.http = require("HTTP");

        var Audio = require("Audio");
        cc.tools.audio = new Audio();
        cc.tools.audio.init();

        if (cc.sys.isNative) {
            window.io = SocketIO;
        } else {
            window.io = require("socket.io");
        }
    }

});

cc._RF.pop();