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
    onLoad: function () {
        cc.tools.dialogNodePool = new cc.NodePool();
        let dialog = cc.instantiate(this.prefab);
        cc.tools.dialogNodePool.put(dialog);
    },

    // called every frame, uncomment this function to activate update callback
    // update: function (dt) {

    // },
});
