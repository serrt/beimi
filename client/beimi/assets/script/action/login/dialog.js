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
    },
    onClick:function(){
        let root = cc.find("Canvas");
        if (cc.tools.dialogNodePool.size() > 0) {
            cc.tools.dialog = cc.tools.dialogNodePool.get();
        
            if(cc.tools.dialog !== null){
                cc.tools.dialog.parent = root ;
                cc.tools.dialog.position = cc.p(0 , 0 ) ;
                
                cc.tools.dialog.on(cc.Node.EventType.TOUCH_START, function(e){
                    e.stopPropagation();
                });
            }
        }
    },
    onCloseClick:function(){
        if(cc.tools.dialog){
            /**
             *  对象池返回， 释放资源 ，  同时 解除 事件绑定
             * 
             */
            cc.tools.dialog.off(cc.Node.EventType.TOUCH_START, function(e){
                e.stopPropagation();
            });
            cc.tools.dialogNodePool.put(cc.tools.dialog);
            cc.tools.dialog = null ;
        }
    }

    // called every frame, uncomment this function to activate update callback
    // update: function (dt) {

    // },
});
