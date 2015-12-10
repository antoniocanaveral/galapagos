/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_provincia.
 * @param {String} INSENTENCIA_CGG_PROVINCIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_PROVINCIA Registro de datos de la tabla Cgg_provincia.
 * @constructor
 * @base FrmListadoCgg_provincia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_provincia(INSENTENCIA_CGG_PROVINCIA,INRECORD_CGG_PROVINCIA){
    var optMenu = 'Configuracion/Division geografica/Provincia';
    var inSentenciaCgg_provincia = INSENTENCIA_CGG_PROVINCIA;
    var inRecordCgg_provincia=INRECORD_CGG_PROVINCIA;
    var urlCgg_provincia=URL_WS+"Cgg_provincia";
    var tituloCgg_provincia='Registro provincia';
    var descCgg_provincia='El formulario permite administrar informaci\u00f3n de provincia';
    var isEdit = false;	
    var tmpPais=null;
    /**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var txtCgprv_codigo = new Ext.form.TextField({
        id:'txtCgprv_codigo',
        name:'txtCgprv_codigo',
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
    var txtCpais_codigo = new Ext.form.TextField({
        id:'txtCpais_codigo',
        name:'txtCpais_codigo',
        fieldLabel :'Pa\u00EDs',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
	 * IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var btnCpais_codigoCgg_provincia = new Ext.Button({
        id:'btnCpais_codigoCgg_provincia',
        iconCls:'iconBuscar',
        tooltip:'Buscar pa\u00EDs',
        listeners:{
            click:function(){
                var tmpFLCgg_pais = new FrmListadoCgg_pais();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_pais.getStore(),tmpFLCgg_pais.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined)
                    {
                        txtCpais_codigo.setValue(tmpRecord.get('CPAIS_NOMBRE'));
                        tmpPais=tmpRecord.get('CPAIS_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
	 * Ext.form.TextField NOMBRE DE LA PROVINCIA
	 */
    var txtCgprv_nombre = new Ext.form.TextField({
        id:'txtCgprv_nombre',
        name:'txtCgprv_nombre',
        fieldLabel :'Provincia',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
	 * Ext.form.TextField DESCRIPCION DE LA PROVINCIA
	 */
    var txtCgprv_descripcion = new Ext.form.TextField({
        id:'txtCgprv_descripcion',
        name:'txtCgprv_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :20
    });
    /**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_provincia
	 */
    var btnGuardarCgg_provincia = new Ext.Button({
        id:'btnGuardarCgg_provincia',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar provincia',
        listeners:{
            click:function(){
                if (pnlCgg_provincia.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_provincia(r){
                        winFrmCgg_provincia.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_provincia,
                                msg: 'La informaci\u00F3n de provincia ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_provincia.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_provincia,
                                msg: 'La informaci\u00F3n de provincia no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_provincia.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    param.add('inCgprv_codigo',txtCgprv_codigo.getValue());
                    param.add('inCpais_codigo',tmpPais);
                    param.add('inCgprv_nombre',txtCgprv_nombre.getValue());
                    param.add('inCgprv_descripcion',txtCgprv_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_provincia,INSENTENCIA_CGG_PROVINCIA,param, true, CallBackCgg_provincia);
                }catch(inErr){
                    winFrmCgg_provincia.getEl().unmask();
                }
            }
        }
    });
    /**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_provincia.
	 */
    var btnCancelarCgg_provincia = new Ext.Button({
        id:'btnCancelarCgg_provincia',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar informaci\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_provincia.getForm().reset();
            }
        }
    });
    /**
	 * Boton que permite cerrar la ventana winFrmCgg_provincia.
	 */
    var btnCerrarCgg_provincia = new Ext.Button({
        id:'btnCerrarCgg_provincia',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_provincia.close();
            }
        }
    });
    /**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_provincia.
	 */
    var pnlCgg_provincia = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgprv_codigo,{
            xtype:'panel',
            layout:'column',
            anchor:'100%',
            items:[{
                columnWidth:.9,
                layout:'form',
                items:[txtCpais_codigo]
            },{
                columnWidth:.1,
                layout:'form',
                items:[btnCpais_codigoCgg_provincia]
            }]
        },txtCgprv_nombre,txtCgprv_descripcion]
    });
    /**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_provincia.
	 */
    var winFrmCgg_provincia = new Ext.Window({
        id:'winFrmCgg_provincia',
        title:tituloCgg_provincia,
        iconCls:'iconAplicacion',
        tbar:getPanelTitulo(tituloCgg_provincia,descCgg_provincia),
        items:[pnlCgg_provincia],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_provincia,btnCancelarCgg_provincia,'->',btnCerrarCgg_provincia]
    });
    	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_provincia.getBottomToolbar());

    /**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_provincia.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
    function habilitarCgg_provinciaCtrls(inEstado){
        var estado=!inEstado;
        txtCgprv_codigo.setDisabled(estado);
        txtCpais_codigo.setDisabled(estado);
        txtCgprv_nombre.setDisabled(estado);
        txtCgprv_descripcion.setDisabled(estado);
    }
    /**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_provincia.
	 */
    function cargarCgg_provinciaCtrls(){
        if(inRecordCgg_provincia){
            txtCgprv_codigo.setValue(inRecordCgg_provincia.get('CGPRV_CODIGO'));

            var scpPais = new SOAPClientParameters();
            scpPais.add('inCpais_codigo',inRecordCgg_provincia.get('CPAIS_CODIGO'));
            scpPais.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS+'Cgg_pais','select',scpPais,true,function(inServiceResponse){
                try{
                    inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                    inServiceResponse = inServiceResponse[0];
                    tmpPais = inServiceResponse.CPAIS_CODIGO;
                    txtCpais_codigo.setValue(inServiceResponse.CPAIS_DESCRIPCION);
                }catch(inErr){
                    tmpPais = null;
                    txtCpais_codigo.setValue(NO_DATA_MESSAGE);
                }
            });
          
            txtCgprv_nombre.setValue(inRecordCgg_provincia.get('CGPRV_NOMBRE'));
            txtCgprv_descripcion.setValue(inRecordCgg_provincia.get('CGPRV_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_provinciaCtrls(true);
        }
    }
    /**
	 * Funcion miembro que devuelve la ventana winFrmCgg_provincia.
	 * @returns ventana winFrmCgg_provincia.
	 * @base FrmCgg_provincia.prototype.show
	 */
    this.getWindow = function(){
        return winFrmCgg_provincia;
    }
    /**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_provincia.
	 * @base FrmCgg_provincia.prototype.loadData
	 */
    this.loadData = function(){
        cargarCgg_provinciaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_provincia desde una instancia.
 */
FrmCgg_provincia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_provincia desde una instancia.
 */
FrmCgg_provincia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_provincia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_provincia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_provincia desde una instancia.
 */
FrmCgg_provincia.prototype.loadData = function(){
    this.loadData();
}
