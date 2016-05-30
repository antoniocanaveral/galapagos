/**
 * Created by acanaveral on 29/5/16.
 */


function AlfrescoUploader(jsonFile,_tableName,_recordId){

    if(jsonFile.indexDefinitionList && jsonFile.indexDefinitionList.length>0){//Existen indices. Los evaluamos y renderizamos
        var aspectItems = [];
        for(var i=0;i<jsonFile.indexDefinitionList.length;i++){
            var aspectData = jsonFile.indexDefinitionList[i];
            var _items = [];
            for(j=0;j<aspectData.itemList.length;j++){
                var item = aspectData.itemList[j];
                var component = undefined;
                switch (item.itemDataType) {
                      case "TEXT":
                        component = new Ext.form.TextArea({
                            id:aspectData.code+"_"+item.code,
                            name:item.itemName,
                            allowBlank :!item.isMandatory,
                            itemCls: item.isMandatory?'required':'',
                            fieldLabel: item.itemLabel
                        });
                        break;
                    case "DATE":
                        component = new Ext.form.DateField({
                            id:aspectData.code+"_"+item.code,
                            name:item.itemName,
                            fieldLabel: item.itemLabel
                        });
                        break;
                    default:///Incluye STRING
                        component = new Ext.form.TextField({
                            id:aspectData.code+"_"+item.code,
                            name:item.itemName,
                            allowBlank :!item.isMandatory,
                            itemCls: item.isMandatory?'required':'',
                            fieldLabel: item.itemLabel
                        });
                        break;
                }
                //Cuando es Identificable
                if(aspectData.name==='Identificable'){
                    component.setReadOnly(true);
                    if(item.code==='ITEM_RECORD_ID')
                        component.setValue(_recordId);
                    if(item.code==='ITEM_TABLA')
                        component.setValue(_tableName);
                }

                if(component){
                    console.log("Push Component");
                    _items.push(component);
                }
            }
            var frm_aspect = {
                layout:'form',
                title: aspectData.name,
                items:_items,
                bodyStyle: 'padding: 10px 10px 0 10px;',
                defaults: {anchor: '95%',msgTarget: 'side'}
            };
            aspectItems.push(frm_aspect);
        }

        var pnlFile = new Ext.ux.form.FileUploadField({
            id: 'form-file',
            emptyText: 'Seleccione un archivo',
            fieldLabel: 'Archivo',
            name: 'photo-path',
            buttonText: '',
            allowBlank: false,
            anchor: '95%',
            msgTarget: 'side',
            buttonCfg: {
                iconCls: 'upload-icon'
            }
        });
        aspectItems.push(pnlFile);

        var fp = new Ext.FormPanel({
            fileUpload: true,
            //width: 500,
            //frame: true,
            //title: 'Subir Archivo',
            autoHeight: true,
            //bodyStyle: 'padding: 10   px 10px 0 10px;',
            labelWidth: 250,
            /*defaults: {
                anchor: '95%',
                allowBlank: false,
                msgTarget: 'side'
            },*/
            items: aspectItems,
            buttons: [{
                text: 'Enviar',
                handler: function(){
                    if(fp.getForm().isValid()){
                        fp.getForm().submit({
                            url: 'file-upload.php',
                            waitMsg: 'Uploading your photo...',
                            success: function(fp, o){
                                msg('Success', 'Processed file "'+o.result.file+'" on the server');
                            }
                        });
                    }
                }
            },{
                text: 'Cerrar',
                handler: function(){
                    fp.getForm().reset();
                    winAttach.close();
                }
            }]
        });

    }

    var tituloAlfrescoMng = 'Subir Adjuntos';
    var descAlfrescoMng = 'Complete la información requerida y adjunte el archivo';
    var winAttach = new Ext.Window({
        id:'winAlfrescoUploader',
        title:tituloAlfrescoMng,
        iconCls:'iconAplicacion',
        tbar:getPanelTitulo(tituloAlfrescoMng,descAlfrescoMng),
        //items:[form],
        items:fp,
        width:500,
        minWidth:500,
        modal:true,
        resizable:true,
        maximizable:true,
        minimizable:false,
        constrain:true
        //bbar:[btnGuardarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
    });
    this.getWindow = function(){
        return winAttach;
    };
}

AlfrescoUploader.prototype.show = function(){
    if(this.getWindow()){
        this.getWindow().show();
        Ext.getCmp('form-file').getEl().dom.parentElement.parentElement.parentElement.style='padding: 15px 5px 15px 5px;';
    }
};
AlfrescoUploader.prototype.close = function(){
    this.getWindow().close();
};
