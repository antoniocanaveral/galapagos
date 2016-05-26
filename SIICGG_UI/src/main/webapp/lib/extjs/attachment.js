

Ext.namespace("Ext.ux","Ext.ux.form");

Ext.ux.form.AlfrescoFM = Ext.extend(Ext.Button, {
    disabled :false,
    tableName:undefined,
    recordID:undefined,
    filter:undefined,
    width:'80px',
    allowBlank:false,
    iconCls: 'iconAdjunto',
    onRender : function(ct, position){
        Ext.ux.form.AlfrescoFM.superclass.onRender.call(this, ct, position);

    },
    onClick : function(e, t){
        e.preventDefault();
        //Abrimos la ventana
        var alfrescoMng = new AlfrescoMng(this.tableName, this.recordID, this.filter);
        alfrescoMng.show();
    }
});
Ext.reg('uxalfrescofm', Ext.ux.form.AlfrescoFM);