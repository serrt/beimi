"use strict";
cc._RF.push(module, '16d18o/xiJL/7rFDrEjg4ir', 'dialog');
// script/action/login/dialog.js

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
    },

    onLoad: function onLoad() {
        var self = this;
        this._dialog = cc.find("Canvas/dialog");
        this._button = cc.find("Canvas/button");
        this._button.active = false;
        this._girl = cc.find("Canvas/splash/background/girl");
        this._animCtrl = this._girl.getComponent(cc.Animation);
    },
    onClick: function onClick() {
        this._dialog.active = false;
        this._button.active = true;
        this._animCtrl.play("girl_to_left");
    },
    onShowClick: function onShowClick() {
        this._button.active = false;
        this._dialog.active = true;
        var anim = this.getComponent(cc.Animation);
        this._animCtrl.play("girl_to_right");
    }

    // called every frame, uncomment this function to activate update callback
    // update: function (dt) {

    // },
});

cc._RF.pop();