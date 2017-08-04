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
    },
    onClick: function onClick() {
        this._dialog.active = false;
    }

    // called every frame, uncomment this function to activate update callback
    // update: function (dt) {

    // },
});

cc._RF.pop();