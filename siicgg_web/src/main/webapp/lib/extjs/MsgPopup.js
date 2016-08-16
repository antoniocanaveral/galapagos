/*!
 * Ext JS Library 3.3.0
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.MsgPopup = function(){
    var msgCt;

    function createBox(t,s,i){
        var msgBody = ['<div class="msg">',
        '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
        '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><div align="center"><img src="resources/images/48x48/'+i+'"/></div><h3>', t, '</h3>', s, '</div></div></div>',
        '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>',
        '</div>'].join('');
        return msgBody;
    }
    return {
        msg : function(title, format,icon){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {
                    id:'msg-div'
                }, true);
            }
            if(icon == null || icon == undefined){
                icon = MsgPopup.INFO;
            }
            msgCt.alignTo(document, 't-t');
            var s = String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, {
                html:createBox(title, s,icon)
            }, true);
            m.slideIn('t').pause(3).ghost("t", {
                remove:true
            });
        },

        init : function(){
            /*
            var t = Ext.get('exttheme');
            if(!t){ // run locally?
                return;
            }
            var theme = Cookies.get('exttheme') || 'aero';
            if(theme){
                t.dom.value = theme;
                Ext.getBody().addClass('x-'+theme);
            }
            t.on('change', function(){
                Cookies.set('exttheme', t.getValue());
                setTimeout(function(){
                    window.location.reload();
                }, 250);
            });*/

            var lb = Ext.get('lib-bar');
            if(lb){
                lb.show();
            }
        }
    };
}();
