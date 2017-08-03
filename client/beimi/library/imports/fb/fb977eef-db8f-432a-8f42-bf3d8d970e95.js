"use strict";
cc._RF.push(module, 'fb9777v249DKo9Cvz2Nlw6V', 'HTTP');
// script/lib/HTTP.js

"use strict";

var URL = "http://127.0.0.1";
cc.VERSION = 2017061001;
var HTTP = cc.Class({
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

    statics: {
        baseURL: URL,
        authorization: null,
        httpGet: function httpGet(url, callback) {
            var xhr = cc.loader.getXMLHttpRequest();

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
                    var respone = xhr.responseText;
                    if (callback) {
                        callback(respone);
                    }
                }
            };
            xhr.open("GET", HTTP.baseURL + url, true);
            if (HTTP.authorization != null) {
                xhr.setRequestHeader("authorization", HTTP.authorization);
            }
            if (cc.sys.isNative) {
                xhr.setRequestHeader("Accept-Encoding", "gzip,deflate");
            }

            // note: In Internet Explorer, the timeout property may be set only after calling the open()
            // method and before calling the send() method.
            xhr.timeout = 5000; // 5 seconds for timeout

            xhr.send();
        },
        encodeFormData: function encodeFormData(data) {
            var pairs = [];
            var regexp = /%20/g;

            for (var name in data) {
                var value = data[name].toString();
                var pair = encodeURIComponent(name).replace(regexp, "+") + "=" + encodeURIComponent(value).replace(regexp, "+");
                pairs.push(pair);
            }
            return pairs.join("&");
        },
        httpPost: function httpPost(url, params, callback) {
            var xhr = cc.loader.getXMLHttpRequest();

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status >= 200 && xhr.status < 300) {
                    var respone = xhr.responseText;
                    if (callback) {
                        callback(respone);
                    }
                } else {
                    if (callback) {
                        callback(-1);
                    }
                }
            };
            xhr.open("POST", HTTP.baseURL + url, true);
            if (HTTP.authorization !== null) {
                xhr.setRequestHeader("authorization", HTTP.authorization);
            }
            if (cc.sys.isNative) {
                xhr.setRequestHeader("Accept-Encoding", "gzip,deflate");
            }
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            // note: In Internet Explorer, the timeout property may be set only after calling the open()
            // method and before calling the send() method.
            xhr.timeout = 5000; // 5 seconds for timeout

            xhr.send(HTTP.encodeFormData(params));
        }
    },

    // use this for initialization
    onLoad: function onLoad() {}

});

cc._RF.pop();