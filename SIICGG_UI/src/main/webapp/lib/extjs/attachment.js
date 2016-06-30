

Ext.namespace("Ext.ux","Ext.ux.form");

Ext.ux.form.AlfrescoFM = Ext.extend(Ext.Button, {
    disabled :false,
    tableName:undefined,
    validateRecordID:false,
    recordID:undefined,
    filter:undefined,
    width:'80px',
    allowBlank:false,
    iconCls: 'iconAdjunto',
    onRender : function(ct, position){
        Ext.ux.form.AlfrescoFM.superclass.onRender.call(this, ct, position);
        this.addEvents("updateData");

    },
    onClick : function(e, t){
        e.preventDefault();
        this.fireEvent("updateData",this);
        //Validamos si tiene recordID
        var isValid = true;
        if(this.validateRecordID) {
            isValid = false;
            if(this.recordID!=null && this.recordID!="KEYGEN")
                isValid =true;
        }

        if(isValid){
            //Abrimos la ventana
            var alfrescoMng = new AlfrescoMng(this.tableName, this.recordID, this.filter);
            alfrescoMng.show();
        }else
            Ext.MsgPopup.msg("Adjunto","Guarde o Seleccione el registro, para abrir Adjuntos.", MsgPopup.ERROR);

    },
});
Ext.reg('uxalfrescofm', Ext.ux.form.AlfrescoFM);