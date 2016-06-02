/**
 * Created by acanaveral on 29/5/16.
 */

var resultObj = undefined;

function AlfrescoUploader(jsonFile,_tableName,_recordId,filesRepository){

    var aspectItems = [];
    if(jsonFile.indexDefinitionList && jsonFile.indexDefinitionList.length>0) {//Existen indices. Los evaluamos y renderizamos
        //Ponemos los datos que conocemos hasta ahora
        aspectItems.push(new Ext.form.Hidden({
            name: "fileDefinition",
            fieldLabel: "fileDefinition",
            value: JSON.stringify(jsonFile)
        }));

        aspectItems.push(new Ext.form.Hidden({
            name: "identificable",
            fieldLabel: "identificable",
            value: JSON.stringify({tableName: _tableName, recordId: _recordId})
        }));
        //Preparamos la interfaz para que nos suministren los valores necesarios.
        for (var i = 0; i < jsonFile.indexDefinitionList.length; i++) {
            var aspectData = jsonFile.indexDefinitionList[i];
            if (aspectData.estado == true) {
                var _items = [];
                for (j = 0; j < aspectData.itemList.length; j++) {
                    var item = aspectData.itemList[j];
                    if (item.estado == true) {
                        var component = undefined;
                        switch (item.itemDataType) {
                            case "TEXT":
                                component = new Ext.form.TextArea({
                                    id: aspectData.code + "_" + item.code,
                                    name: item.itemName,
                                    allowBlank: !item.isMandatory,
                                    itemCls: item.isMandatory ? 'required' : '',
                                    fieldLabel: item.itemLabel
                                });
                                break;
                            case "DATE":
                                component = new Ext.form.DateField({
                                    id: aspectData.code + "_" + item.code,
                                    name: item.itemName,
                                    fieldLabel: item.itemLabel
                                });
                                break;
                            default:///Incluye STRING
                                component = new Ext.form.TextField({
                                    id: aspectData.code + "_" + item.code,
                                    name: item.itemName,
                                    allowBlank: !item.isMandatory,
                                    itemCls: item.isMandatory ? 'required' : '',
                                    fieldLabel: item.itemLabel
                                });
                                break;
                        }
                        //Cuando es Identificable
                        if (aspectData.name === 'Identificable') {
                            component.setReadOnly(true);
                            if (item.code === 'ITEM_RECORD_ID')
                                component.setValue(_recordId);
                            if (item.code === 'ITEM_TABLA')
                                component.setValue(_tableName);
                        }

                        if (component)
                            _items.push(component);
                    }

                }
                var frm_aspect = {
                    layout: 'form',
                    title: aspectData.name,
                    items: _items,
                    bodyStyle: 'padding: 10px 10px 0 10px;',
                    defaults: {anchor: '95%', msgTarget: 'side'}
                };
                aspectItems.push(frm_aspect);
            }
        }
    }
    if(filesRepository){
        aspectItems.push(new Ext.form.Hidden({
            name : "filesRepository",
            fieldLabel : "filesRepository",
            value : filesRepository
        }));

        aspectItems.push(new Ext.form.Hidden({
            name : "identificable",
            fieldLabel : "identificable",
            value : JSON.stringify({tableName:_tableName, recordId:_recordId})
        }));
    }

    var pnlFile = new Ext.ux.form.FileUploadField({
        id: 'archivo-versionado',
        emptyText: 'Seleccione un archivo',
        fieldLabel: 'Archivo',
        name: 'archivo-versionado',
        buttonText: '',
        allowBlank: false,
        anchor: '95%',
        msgTarget: 'side',
        buttonCfg: {
            iconCls: 'upload-icon'
        }
    });
    aspectItems.push(pnlFile);

    /**
     * Boton que permite almacenar la informacion del adjunto
     */
    var btnGuardarAlfresco = new Ext.Button({
        id:'btnGuardarAlfresco',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (fp.getForm().isValid()==false){
                    return;
                }
                try{
                    fp.getEl().mask('Guardando...', 'x-mask-loading');
                    fp.getForm().submit({
                        url:URL_WS+"AlfrescoUploaderSVR",
                        success:function(inForm,inAction){
                            fp.getEl().unmask();
                            console.log(JSON.stringify(inAction.result.objData));
                            resultObj = inAction.result.objData;
                            if(inAction.result.success == true){
                                Ext.MsgPopup.msg(tituloAlfrescoMng, "Su archivo adjunto ha sido guardado.",MsgPopup.INFO);
                                winAttach.close();
                            }else{
                                Ext.MsgPopup.msg(tituloAlfrescoMng, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                            }
                        },
                        failure:function(inForm,inAction){
                            fp.getEl().unmask();
                            Ext.MsgPopup.msg(tituloAlfrescoMng, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                        },
                        params:{
                            recordReference:{tableName:_tableName, recordId:_recordId}
                        }
                    });
                }catch(e){
                    fp.getEl().unmask();
                    Ext.MsgPopup.msg(tituloAlfrescoMng, "Existe un problema al guardar su archivo",MsgPopup.INFO);
                    console.log(e.message);
                }
            }
        }
    });

    var fp = new Ext.FormPanel({
        fileUpload: true,
        autoHeight: true,
        labelWidth: 250,
        items: aspectItems,
        buttons: [btnGuardarAlfresco,{
            text: 'Cerrar',
            handler: function(){
                fp.getForm().reset();
                winAttach.close();
            }
        }]
    });

    var tituloAlfrescoMng = 'Subir Adjuntos';
    var descAlfrescoMng = 'Complete la informaci&oacute;n requerida y adjunte el archivo';
    var winAttach = new Ext.Window({
        id          :'winAlfrescoUploader',
        title       :tituloAlfrescoMng,
        iconCls     :'iconAplicacion',
        tbar        :getPanelTitulo(tituloAlfrescoMng,descAlfrescoMng),
        items       :fp,
        width       :500,
        minWidth    :500,
        modal       :true,
        resizable   :true,
        maximizable :true,
        minimizable :false,
        constrain   :true,
        closable    : true,
        closeAction : 'hide'
    });
    this.getWindow = function(){
        return winAttach;
    };
}

AlfrescoUploader.prototype.show = function(){
    if(this.getWindow()){
        this.getWindow().show();
        Ext.getCmp('archivo-versionado').getEl().dom.parentElement.parentElement.parentElement.style='padding: 15px 5px 15px 5px;';
    }
};

AlfrescoUploader.prototype.close = function(){
    this.getWindow().close();
};

AlfrescoUploader.prototype.result = function(){
    var ret = resultObj;
    resultObj = null;
    return ret;
};

AlfrescoUploader.prototype.destroy = function(){
    resultObj=null;
    this.getWindow().destroy();
};

AlfrescoUploader.prototype.on = function(eventName,callback){
    this.getWindow().on(eventName,callback);
};