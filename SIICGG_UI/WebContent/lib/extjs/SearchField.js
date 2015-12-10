/*!
 * Ext JS Library 3.2.1
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.ns('Ext.ux.bsx');

Ext.ux.bsx.SearchField = Ext.extend(Ext.form.TwinTriggerField, {
    initComponent : function(){
        Ext.ux.bsx.SearchField.superclass.initComponent.call(this);
        this.on('specialkey', function(f, e){
            if(e.getKey() == e.ENTER){
                this.onTrigger2Click();
            }
        }, this);
    },

    validationEvent:false,
    validateOnBlur:false,
    trigger1Class:'x-form-clear-trigger',
    trigger2Class:'x-form-search-trigger',
    hideTrigger1:true,
    width:180,
    hasSearch : false,
    paramName : 'keyword',
    pagin:true,
    onTrigger1Click : function(){
        if(this.hasSearch){
            this.el.dom.value = '';
            this.store.baseParams = this.store.baseParams || {};
            this.store.baseParams[this.paramName] = '';
            if(this.pagin)
                this.store.lastOptions.params.start =0;
            else
                this.store.lastOptions.params[this.paramName]='';        
            this.store.reload();
            this.triggers[0].hide();
            this.hasSearch = false;
        }
    },

    onTrigger2Click : function(){
        var v = this.getRawValue();
        if(v.length < 1){
            this.onTrigger1Click();
            return;
        }        
        this.store.baseParams = this.store.baseParams || {};
        this.store.baseParams[this.paramName] = v;
        if(this.pagin)
            this.store.lastOptions.params.start =0;
        else
            this.store.lastOptions.params[this.paramName]=v;
        this.store.reload();
        this.hasSearch = true;
        this.triggers[0].show();
    }
});
