"use strict";
cc._RF.push(module, '14bfe1GqB5C77bPnI+ETJt7', 'event');
// script/action/login/event.js

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

    // use this for initialization
    onLoad: function onLoad() {
        this.node.opacity = 50;
        this.node.on(cc.Node.EventType.TOUCH_START, function (e) {
            e.stopPropagation();
        });
    }

});

cc._RF.pop();