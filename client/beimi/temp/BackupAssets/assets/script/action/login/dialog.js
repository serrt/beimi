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

    onLoad: function () {
        var self = this;
        this._dialog = cc.find("Canvas/dialog");
    },
    onClick:function(){
        this._dialog.active = false ;
    }

    // called every frame, uncomment this function to activate update callback
    // update: function (dt) {

    // },
});
