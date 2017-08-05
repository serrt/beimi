"use strict";
cc._RF.push(module, 'e9755EwNoJFIIeGTUOUee0C', 'DialogPrefab');
// script/prefab/DialogPrefab.js

"use strict";

cc.Class({
    extends: cc.Component,

    properties: {
        root: {
            default: null,
            type: cc.Node
        },
        prefab: {
            default: null,
            type: cc.Prefab
        },
        canvas: {
            default: null,
            type: cc.Canvas
        }
    },

    // use this for initialization
    onLoad: function onLoad() {
        cc.tools.dialogNodePool = new cc.NodePool();
        var dialog = cc.instantiate(this.prefab);
        cc.tools.dialogNodePool.put(dialog);
    }

});

cc._RF.pop();