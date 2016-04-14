/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_seguimiento_criterio.
* @param inCJSCG_CODIGO Codigo de criterio de seguimiento.
* @constructor
* @author Besixplus Cia. Ltda.
*/
function FrmSubirAdjuntoCriterio(inCJSGC_CODIGO){
    
    var tituloCgg_jur_seguimiento_criterio='Documento adjunto de criterio';
    var descCgg_jur_seguimiento_criterio='El formulario permite subir su archivo adjunto.';
   	
    /**
	* ARCHIVO DIGITAL ANEXO
	*/
    var filCjsgc_archivo_adjunto = new Ext.form.FileUploadField({
        id:'filCjsgc_archivo_adjunto',
        name:'filCjsgc_archivo_adjunto',
        fieldLabel :'Archivo adjunto',
        disabled :false,
        anchor:'98%',
        allowBlank:false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
	
    /**
	* Boton que permite almacenar la informacion de la ventana winFrmSubirAdjuntoCriterio
	*/
    var btnGuardarCgg_jur_seguimiento_criterio = new Ext.Button({
        id:'btnGuardarCgg_jur_seguimiento_criterio',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_jur_seguimiento_criterio.getForm().isValid()==false){
                    return;
                }                                
                pnlCgg_jur_seguimiento_criterio.getEl().mask('Guardando...', 'x-mask-loading');
                pnlCgg_jur_seguimiento_criterio.getForm().submit({
                    url:URL_WS+"Cgg_jur_seguimiento_criterioSRV",
                    success:function(inForm,inAction){
                        pnlCgg_jur_seguimiento_criterio.getEl().unmask();
                        if((inAction.result+' ').trim()=='true'){
                            Ext.MsgPopup.msg(tituloCgg_jur_seguimiento_criterio, "Su archivo adjunto ha sido guardado.",MsgPopup.INFO);
                            winFrmSubirAdjuntoCriterio.close();
                        }else{
                            Ext.MsgPopup.msg(tituloCgg_jur_seguimiento_criterio, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result,MsgPopup.WARNING);
                        }
                    },
                    failure:function(inForm,inAction){
                        pnlCgg_jur_seguimiento_criterio.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_jur_seguimiento_criterio, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result,MsgPopup.WARNING);
                    },
                    params:{                        
                        inCjsgc_codigo:inCJSGC_CODIGO
                    }
                });

            }
        }
    });
	
    /**
	* Boton que permite cerrar la ventana winFrmSubirAdjuntoCriterio.
	*/
    var btnCerrarCgg_jur_seguimiento_criterio = new Ext.Button({
        id:'btnCerrarCgg_jur_seguimiento_criterio',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmSubirAdjuntoCriterio.close();
            }
        }
    });
    /**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmSubirAdjuntoCriterio.
	*/
    var pnlCgg_jur_seguimiento_criterio = new Ext.form.FormPanel({
        id:'pnlCgg_jur_seguimiento_criterio',
        frame:true,
        fileUpload:true,
        labelWidth :100,
        items:[filCjsgc_archivo_adjunto]
    });
    /**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_seguimiento_criterio.
	*/
    var winFrmSubirAdjuntoCriterio = new Ext.Window({
        id:'winFrmSubirAdjuntoCriterio',
        title:tituloCgg_jur_seguimiento_criterio,
        tbar:getPanelTitulo(tituloCgg_jur_seguimiento_criterio,descCgg_jur_seguimiento_criterio),
        items:[pnlCgg_jur_seguimiento_criterio],
        width:400,
        minWidth:400,                
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_jur_seguimiento_criterio,'->',btnCerrarCgg_jur_seguimiento_criterio]
    });

    /**
	* Funcion miembro que devuelve la ventana winFrmSubirAdjuntoCriterio.
	* @returns ventana winFrmSubirAdjuntoCriterio.
	* @base FrmSubirAdjuntoCriterio.prototype.show
	*/
    this.getWindow = function(){
        return winFrmSubirAdjuntoCriterio;
    }
    /**
	* Funcion miembro que carga los controles de la ventana winFrmSubirAdjuntoCriterio.
	* @base FrmSubirAdjuntoCriterio.prototype.loadData
	*/
    this.loadData = function(){
        cargarCgg_jur_seguimiento_criterioCtrls();
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmSubirAdjuntoCriterio desde una instancia.
*/
FrmSubirAdjuntoCriterio.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmSubirAdjuntoCriterio desde una instancia.
*/
FrmSubirAdjuntoCriterio.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmSubirAdjuntoCriterio,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmSubirAdjuntoCriterio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmSubirAdjuntoCriterio desde una instancia.
*/
FrmSubirAdjuntoCriterio.prototype.loadData = function(){
    this.loadData();
}
