/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_canton.
 * @param {String} INSENTENCIA_CGG_CANTON Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_CANTON Registro de datos de la tabla Cgg_canton.
 * @constructor
 * @base FrmListadoCgg_canton
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_canton(INSENTENCIA_CGG_CANTON,INRECORD_CGG_CANTON){
    var optMenu = 'Configuracion/Division geografica/Canton';
    var deskIcon = 'resources/images/48x48/residencia.png';
    var inSentenciaCgg_canton = INSENTENCIA_CGG_CANTON;
    var inRecordCgg_canton=INRECORD_CGG_CANTON;
    var urlCgg_canton=URL_WS+"Cgg_canton";
    var tituloCgg_canton='Registro cant\u00f3n';
    var descCgg_canton='El formulario permite ingresar informaci\u00f3n del cant\u00f3n';
    var isEdit = false;
    var tmpProvincia=null;
    /**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	 */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var txtCgprv_codigo = new Ext.form.TextField({
        id:'txtCgprv_codigo',
        name:'txtCgprv_codigo',
        fieldLabel :'Provincia',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
	 * IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var btnCgprv_codigoCgg_canton = new Ext.Button({
        id:'btnCgprv_codigoCgg_canton',
        iconCls:'iconBuscar',
        tooltip:'Buscar Provincia',
        listeners:{
            click:function(){
                var tmpFLCgg_provincia = new FrmListadoCgg_provincia();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_provincia.getStore(),tmpFLCgg_provincia.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined)
                    {
                        txtCgprv_codigo.setValue(tmpRecord.get('CGPRV_NOMBRE'));
                        tmpProvincia=tmpRecord.get('CGPRV_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
	 * Ext.form.TextField NOMBRE DEL CANTON
	 */
    var txtCctn_nombre = new Ext.form.TextField({
        id:'txtCctn_nombre',
        name:'txtCctn_nombre',
        fieldLabel :'Canton',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
	 * Ext.form.TextField DESCRIPCION DEL CANTON 
	 */
    var txtCctn_descripcion = new Ext.form.TextField({
        id:'txtCctn_descripcion',
        name:'txtCctn_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :20
    });
	/**
	 * Ext.form.TextField DESCRIPCION DEL CANTON 
	 */
    var txtCctn_abreviatura = new Ext.form.TextField({
        id:'txtCctn_abreviatura',
        name:'txtCctn_abreviatura',
        fieldLabel :'Abreviatura',
        anchor:'98%',
        allowBlank :true,
        maxLength :10
    });
    /**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_canton
	 */
    var btnGuardarCgg_canton = new Ext.Button({
        id:'btnGuardarCgg_canton',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar cant\u00f3n',
        listeners:{
            click:function(){
                if (pnlCgg_canton.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_canton(r){
                        winFrmCgg_canton.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_canton,
                                msg: 'La informaci\u00F3n de cant\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_canton.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_canton,
                                msg: 'La informaci\u00F3n de cant\u00f3n no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_canton.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    param.add('inCctn_codigo',txtCctn_codigo.getValue());
                    param.add('inCgprv_codigo',tmpProvincia);
                    param.add('inCctn_nombre',txtCctn_nombre.getValue());
                    param.add('inCctn_descripcion',txtCctn_descripcion.getValue());
					param.add('inCctn_abreviatura',txtCctn_abreviatura.getValue());
                    SOAPClient.invoke(urlCgg_canton,INSENTENCIA_CGG_CANTON,param, true, CallBackCgg_canton);
                }catch(inErr){
                    winFrmCgg_canton.getEl().unmask();
                }
            }
        }
    });
    /**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_canton.
	 */
    var btnCancelarCgg_canton = new Ext.Button({
        id:'btnCancelarCgg_canton',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar ingreso',
        listeners:{
            click:function(){
                pnlCgg_canton.getForm().reset();
            }
        }
    });
    /**
	 * Boton que permite cerrar la ventana winFrmCgg_canton.
	 */
    var btnCerrarCgg_canton = new Ext.Button({
        id:'btnCerrarCgg_canton',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_canton.close();
            }
        }
    });
    /**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_canton.
	 */
    var pnlCgg_canton = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCctn_codigo,{
            xtype:'panel',
            layout:'column',
            anchor:'100%',
            items:[{
                columnWidth:.9,
                layout:'form',
                items:[txtCgprv_codigo]
            },{
                columnWidth:.1,
                layout:'form',
                items:[btnCgprv_codigoCgg_canton]
            }]
        },txtCctn_nombre,txtCctn_descripcion,txtCctn_abreviatura]
    });
    /**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_canton.
	 */
    var winFrmCgg_canton = new Ext.Window({
        id:'winFrmCgg_canton',
        title:tituloCgg_canton,
        iconCls:'iconAplicacion',
        tbar:getPanelTitulo(tituloCgg_canton,descCgg_canton),
        items:[pnlCgg_canton],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_canton,btnCancelarCgg_canton,'->',btnCerrarCgg_canton]
    });
    /**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_canton.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
    function habilitarCgg_cantonCtrls(inEstado){
        estado=!inEstado;
        txtCctn_codigo.setDisabled(estado);
        txtCgprv_codigo.setDisabled(estado);
        txtCctn_nombre.setDisabled(estado);
        txtCctn_descripcion.setDisabled(estado);
		txtCctn_abreviatura.setDisabled(estado);
    }
    /**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_canton.
	 */
    function cargarCgg_cantonCtrls(){
        if(inRecordCgg_canton){
            txtCctn_codigo.setValue(inRecordCgg_canton.get('CCTN_CODIGO'));
            tmpProvincia = inRecordCgg_canton.get('CGPRV_CODIGO');
            var scpProvincia = new SOAPClientParameters();
            scpProvincia.add('inCgprv_codigo',tmpProvincia);
            scpProvincia.add('format',TypeFormat.JSON);
            var tmpCgprvRegistro = SOAPClient.invoke(URL_WS+"Cgg_provincia", 'select', scpProvincia, false, null);
            try{
                tmpCgprvRegistro = Ext.util.JSON.decode(tmpCgprvRegistro);
                txtCgprv_codigo.setValue(tmpCgprvRegistro[0].CGPRV_NOMBRE);
            }catch(inErr){
                tmpProvincia = null;
                tmpCgprvRegistro = null;
                txtCgprv_codigo.setValue('Informaci\u00F3n no disponible');
            }
            txtCctn_nombre.setValue(inRecordCgg_canton.get('CCTN_NOMBRE'));
            txtCctn_descripcion.setValue(inRecordCgg_canton.get('CCTN_DESCRIPCION'));
			txtCctn_abreviatura.setValue(inRecordCgg_canton.get('CCTN_ABREVIATURA'));
            isEdit = true;
            habilitarCgg_cantonCtrls(true);
        }
    }
    /**
	 * Funcion miembro que devuelve la ventana winFrmCgg_canton.
	 * @returns ventana winFrmCgg_canton.
	 * @base FrmCgg_canton.prototype.show
	 */
    this.getWindow = function(){
        return winFrmCgg_canton;
    }
    /**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_canton.
	 * @base FrmCgg_canton.prototype.loadData
	 */
    this.loadData = function(){
        cargarCgg_cantonCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_canton desde una instancia.
 */
FrmCgg_canton.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_canton desde una instancia.
 */
FrmCgg_canton.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_canton,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_canton.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_canton desde una instancia.
 */
FrmCgg_canton.prototype.loadData = function(){
    this.loadData();
}
