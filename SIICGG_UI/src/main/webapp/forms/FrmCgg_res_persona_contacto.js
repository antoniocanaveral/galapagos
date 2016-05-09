/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_persona_contacto.
 * @param {String} INSENTENCIA_CGG_RES_PERSONA_CONTACTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PERSONA_CONTACTO Registro de datos de la tabla Cgg_res_persona_contacto.
 * @constructor
 * @base FrmListadoCgg_res_persona_contacto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_persona_contacto(INSENTENCIA_CGG_RES_PERSONA_CONTACTO,INRECORD_CGG_RES_PERSONA_CONTACTO,inCrper_codigo){
    var inSentenciaCgg_res_persona_contacto = INSENTENCIA_CGG_RES_PERSONA_CONTACTO;
    var inRecordCgg_res_persona_contacto=INRECORD_CGG_RES_PERSONA_CONTACTO;
    var urlCgg_res_persona_contacto=URL_WS+"Cgg_res_persona_contacto";
    var tituloCgg_res_persona_contacto='Res persona contacto';
    var descCgg_res_persona_contacto='El formulario permite administrar informaci\u00f3n de la tabla Res persona contacto';
    var isEdit = false;
    var objPersonaContacto = null;
	var tmpUserSession = new UserSession();
    
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrprc_codigo = new Ext.form.TextField({
        id:'txtCrprc_codigo',
        name:'txtCrprc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20,
        value:inCrper_codigo
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_res_persona_contacto = new Ext.Button({
        id:'btnCrper_codigoCgg_res_persona_contacto',
        text:'Crper_codigo',
        iconCls:'iconCrper_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
     */
    var txtCrtco_codigo = new Ext.form.TextField({
        id:'txtCrtco_codigo',
        name:'txtCrtco_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
     */
    var txtCrtco_nombre = new Ext.form.TextField({
        id:'txtCrtco_nombre',
        name:'txtCrtco_nombre',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        readOnly:'true',
        maxLength :100
    });

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
     */
    var btnCrtco_codigoCgg_res_persona_contacto = new Ext.Button({
        id:'btnCrtco_codigoCgg_res_persona_contacto',
        //text:'Crtco_codigo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_tipo_contacto = new FrmListadoCgg_res_tipo_contacto();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_contacto.getStore(),tmpFLCgg_res_tipo_contacto.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCrtco_codigo.setValue(tmpRecord.get('CRTCO_CODIGO'));
                        txtCrtco_nombre.setValue(tmpRecord.get('CRTCO_NOMBRE'));
                        //txtCrtco_nombre.setValue(inCrper_codigo);
                        var html ='<img src= "/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+tmpRecord.get('CRTCO_NOMBRE_IMAGEN')+'" width = "22px" height ="22px">' ;

                        objPersonaContacto ={
                            CRPRC_CODIGO:txtCrprc_codigo.getValue(),
                            CRTCO_CODIGO:tmpRecord.get('CRTCO_CODIGO'),
                            CRTCO_NOMBRE:tmpRecord.get('CRTCO_NOMBRE'),
                            CRTCO_NOMBRE_IMAGEN:tmpRecord.get('CRTCO_NOMBRE_IMAGEN'),
                            CRPRC_DESCRIPCION:'',
                            CRPRC_CONTACTO:'',
                            CRPRC_HTML:html
                        };
                        html += '<br><p><b>'+tmpRecord.get('CRTCO_NOMBRE')+'</b></p>';
                        Ext.fly('divImagePersonaContacto').dom.innerHTML=html;


                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField VALOR ASIGNADO AL CONTACTO
     */
    var txtCrprc_descripcion = new Ext.form.TextField({
        id:'txtCrprc_descripcion',
        name:'txtCrprc_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Ext.form.TextField NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
     */
    var txtCrprc_contacto = new Ext.form.TextField({
        id:'txtCrprc_contacto',
        name:'txtCrprc_contacto',
        fieldLabel :'Contacto',
        anchor:'98%',
        allowBlank :false,
        maxLength :200
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_persona_contacto
     */
    var btnGuardarCgg_res_persona_contacto = new Ext.Button({
        id:'btnGuardarCgg_res_persona_contacto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_persona_contacto.getForm().isValid()==false){
                    return;
                }
                /*try{
                    function CallBackCgg_res_persona_contacto(r){
                        winFrmCgg_res_persona_contacto.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_persona_contacto,
                                msg: 'La informaci\u00f3n de Res persona contacto ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_persona_contacto.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_persona_contacto,
                                msg: 'La informaci\u00f3n de Res persona contacto no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_persona_contacto.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrprc_codigo',txtCrprc_codigo.getValue());
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());
                    param.add('inCrtco_codigo',txtCrtco_codigo.getValue());
                    param.add('inCrprc_descripcion',txtCrprc_descripcion.getValue());
                    param.add('inCrprc_contacto',txtCrprc_contacto.getValue());
                    SOAPClient.invoke(urlCgg_res_persona_contacto,INSENTENCIA_CGG_RES_PERSONA_CONTACTO,param, true, CallBackCgg_res_persona_contacto);
                }catch(inErr){
                    winFrmCgg_res_persona_contacto.getEl().unmask();
                }*/
                try{
						function CallBackCgg_res_persona_contacto(r){
							winFrmCgg_res_persona_contacto.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_res_persona_contacto,
										msg: 'La informaci\u00f3n de Area ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_res_persona_contacto.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_res_persona_contacto,
										msg: 'La informaci\u00f3n de Area no ha podido ser almacenada. '+r,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_res_persona_contacto.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCrprc_codigo',txtCrprc_codigo.getValue());
                    param.add('inCrtco_codigo',txtCrtco_codigo.getValue());
                    param.add('inCrper_codigo',txtCrper_codigo.getValue());                    
                    param.add('inCrprc_descripcion',txtCrprc_descripcion.getValue());
                    param.add('inCrprc_contacto',txtCrprc_contacto.getValue());
						SOAPClient.invoke(urlCgg_res_persona_contacto,INSENTENCIA_CGG_RES_PERSONA_CONTACTO,param, true, CallBackCgg_res_persona_contacto);
					}catch(inErr){
						winFrmCgg_res_persona_contacto.getEl().unmask();
					}
                
                ///////////////////////
               /* objPersonaContacto.CRPRC_DESCRIPCION = txtCrprc_descripcion.getValue();
                objPersonaContacto.CRPRC_CONTACTO = txtCrprc_contacto.getValue();
                //alert(objPersonaContacto.CRPRC_CONTACTO);*/

                winFrmCgg_res_persona_contacto.close();
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_persona_contacto.
     */
    var btnCancelarCgg_res_persona_contacto = new Ext.Button({
        id:'btnCancelarCgg_res_persona_contacto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_persona_contacto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_persona_contacto.
     */
    var btnCerrarCgg_res_persona_contacto = new Ext.Button({
        id:'btnCerrarCgg_res_persona_contacto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_persona_contacto.close();
            }}
    });
     /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_persona_contacto.
     */
     var pnlImagePersonaContacto = new Ext.Panel({
         id : 'pnlImagePersonaContacto',
         frame:true,
         height:60,
         //region:'south',
         html:'<div id= "divImagePersonaContacto" style="height:100% ; width: 100% ;text-align: center;">'
     });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_persona_contacto.
     */
    var pnlCgg_res_persona_contacto = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrprc_codigo,
               {xtype:'panel',layout:'column',items:[
                   {columnWidth:.25,padding:'7px 0px 0px 0px',layout:'form',items:[{xtype:'label',text:'Contacto:'}]},
                   {columnWidth:.25,padding:'0px 0px 0px 5px',items:[pnlImagePersonaContacto]},
                   {columnWidth:.1,layout:'form',padding:'15px 0px 0px 10px',items:[btnCrtco_codigoCgg_res_persona_contacto]}]},
            {xtype:'panel',layout:'form',padding:'10px 0px 0px 0px',items:[txtCrprc_contacto]}]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_persona_contacto.
     */
    var winFrmCgg_res_persona_contacto = new Ext.Window({
        id:'winFrmCgg_res_persona_contacto',
        title:tituloCgg_res_persona_contacto,
        tbar:getPanelTitulo(tituloCgg_res_persona_contacto,descCgg_res_persona_contacto),
        items:[pnlCgg_res_persona_contacto],
        width:420,
        minWidth:420,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_persona_contacto,'->',btnCerrarCgg_res_persona_contacto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_persona_contacto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_persona_contactoCtrls(inEstado){
        estado=!inEstado;
        txtCrprc_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCrtco_codigo.setDisabled(estado);
        txtCrprc_descripcion.setDisabled(estado);
        txtCrprc_contacto.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_persona_contacto.
     */
    function cargarCgg_res_persona_contactoCtrls(){
        if(inRecordCgg_res_persona_contacto){
            txtCrprc_codigo.setValue(inRecordCgg_res_persona_contacto.get('CRPRC_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_res_persona_contacto.get('CRPER_CODIGO'));
            //txtCrper_codigo.setValue(inCrper_codigo);
            txtCrtco_codigo.setValue(inRecordCgg_res_persona_contacto.get('CRTCO_CODIGO'));
            txtCrprc_descripcion.setValue(inRecordCgg_res_persona_contacto.get('CRPRC_DESCRIPCION'));
            txtCrprc_contacto.setValue(inRecordCgg_res_persona_contacto.get('CRPRC_CONTACTO'));
            isEdit = true;
            habilitarCgg_res_persona_contactoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_persona_contacto.
     * @returns ventana winFrmCgg_res_persona_contacto.
     * @base FrmCgg_res_persona_contacto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_persona_contacto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona_contacto.
     * @base FrmCgg_res_persona_contacto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_persona_contactoCtrls();
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona_contacto.
     * @base FrmCgg_res_persona_contacto.prototype.loadData
     */
    this.getData = function(){
        return objPersonaContacto;
    }
}
/**
 * Funcion prototipo. Permite obtener los datos del contacto registrado desde una instancia.
 */
FrmCgg_res_persona_contacto.prototype.getData = function(){
    this.getData();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_persona_contacto desde una instancia.
 */
FrmCgg_res_persona_contacto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_persona_contacto desde una instancia.
 */
FrmCgg_res_persona_contacto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_persona_contacto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_persona_contacto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_persona_contacto desde una instancia.
 */
FrmCgg_res_persona_contacto.prototype.loadData = function(){
    this.loadData();
}
