/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_isla.
 * @param {String} INSENTENCIA_CGG_ISLA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_ISLA Registro de datos de la tabla Cgg_isla.
 * @constructor
 * @base FrmListadoCgg_isla
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_isla(INSENTENCIA_CGG_ISLA,INRECORD_CGG_ISLA){
    var inSentenciaCgg_isla = INSENTENCIA_CGG_ISLA;
    var inRecordCgg_isla=INRECORD_CGG_ISLA;
    var urlCgg_isla=URL_WS+"Cgg_isla";
    var tituloCgg_isla='Registro de isla o cuidad';
    var descCgg_isla='El formulario permite ingresar informaci\u00f3n de la Isla o ciudad';
    var isEdit = false;
    var tmpCanton=null;
    /**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var txtCisla_codigo = new Ext.form.TextField({
        id:'txtCisla_codigo',
        name:'txtCisla_codigo',
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
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Cant\u00f3n',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
	 * IDENTIFICATIVO UNICO DE REGISTRO
	 */
    var btnCctn_codigoCgg_isla = new Ext.Button({
        id:'btnCctn_codigoCgg_isla',        
        iconCls:'iconBuscar',
        tooltip:'Buscar cant\u00f3n',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined)
                    {
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                        tmpCanton=tmpRecord.get('CCTN_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
	 * Ext.form.TextField NOMBRE DE LA ISLA
	 */
    var txtCisla_nombre = new Ext.form.TextField({
        id:'txtCisla_nombre',
        name:'txtCisla_nombre',
        fieldLabel :'Isla',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
	* Ext.form.TextField ABREVIATURA DEL NOMBRE DE LA ISLA
	*/
    var txtCisla_abreviatura = new Ext.form.TextField({
        id:'txtCisla_abreviatura',
        name:'txtCisla_abreviatura',
        fieldLabel :'Abreviatura',
        anchor:'98%',
        allowBlank :false
    });

    /**
* Ext.form.NumberField INDICE NUMERICO PARA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET DE RESIDENCIA
*/
    var numCisla_indice = new Ext.form.NumberField({
        id:'numCisla_indice',        
        fieldLabel :'Indice',
        allowBlank :false,
        disabled :false
    });

    /**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_isla
	 */
    var btnGuardarCgg_isla = new Ext.Button({
        id:'btnGuardarCgg_isla',
        text:'Guardar',       
        iconCls:'iconGuardar',
        tooltip:'Guardar Isla',
        listeners:{
            click:function(){
                if (pnlCgg_isla.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_isla(r){
                        winFrmCgg_isla.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_isla,
                                msg: 'La informaci\u00f3n de isla ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_isla.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_isla,
                                msg: 'La informaci\u00f3n de isla no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_isla.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCisla_codigo',txtCisla_codigo.getValue());
                    param.add('inCctn_codigo',tmpCanton);
                    param.add('inCisla_nombre',txtCisla_nombre.getValue());
                    param.add('inCisla_abreviatura',txtCisla_abreviatura.getValue());
                    param.add('inCisla_indice',numCisla_indice.getValue());
                    SOAPClient.invoke(urlCgg_isla,INSENTENCIA_CGG_ISLA,param, true, CallBackCgg_isla);
                }catch(inErr){
                    winFrmCgg_isla.getEl().unmask();
                }
            }
        }
    });
    /**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_isla.
	 */
    var btnCancelarCgg_isla = new Ext.Button({
        id:'btnCancelarCgg_isla',
        text:'Cancelar',        
        iconCls:'iconCancelar',
        tooltip:'Cancelar informaci\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_isla.getForm().reset();
            }
        }
    });
    /**
	 * Boton que permite cerrar la ventana winFrmCgg_isla.
	 */
    var btnCerrarCgg_isla = new Ext.Button({
        id:'btnCerrarCgg_isla',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_isla.close();
            }
        }
    });
    /**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_isla.
	 */
    var pnlCgg_isla = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCisla_codigo,{
            xtype:'panel',
            layout:'column',
            anchor:'100%',
            items:[{
                columnWidth:.9,
                layout:'form',
                items:[txtCctn_codigo]
            },{
                columnWidth:.1,
                layout:'form',
                items:[btnCctn_codigoCgg_isla]
            }]
        },
        txtCisla_nombre,
        txtCisla_abreviatura,
        numCisla_indice]
    });
    /**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_isla.
	 */
    var winFrmCgg_isla = new Ext.Window({
        id:'winFrmCgg_isla',
        title:tituloCgg_isla,
        tbar:getPanelTitulo(tituloCgg_isla,descCgg_isla),
        items:[pnlCgg_isla],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_isla,btnCancelarCgg_isla,'->',btnCerrarCgg_isla]
    });
    /**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_isla.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
    function habilitarCgg_islaCtrls(inEstado){
        var estado=!inEstado;
        txtCisla_codigo.setDisabled(estado);
        txtCctn_codigo.setDisabled(estado);
        txtCisla_nombre.setDisabled(estado);
        txtCisla_abreviatura.setDisabled(estado);
    }
    /**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_isla.
	 */
    function cargarCgg_islaCtrls(){
        if(inRecordCgg_isla){
            txtCisla_codigo.setValue(inRecordCgg_isla.get('CISLA_CODIGO'));            
            tmpCanton = inRecordCgg_isla.get('CCTN_CODIGO');
            var scpCanton = new SOAPClientParameters();
            scpCanton.add('inCctn_codigo',tmpCanton);
            scpCanton.add('format',TypeFormat.JSON);
            var tmpCctnRegistro = SOAPClient.invoke(URL_WS+"Cgg_canton", 'select', scpCanton, false, null);
            try{
                tmpCctnRegistro = Ext.util.JSON.decode(tmpCctnRegistro);
                txtCctn_codigo.setValue(tmpCctnRegistro[0].CCTN_NOMBRE);
            }catch(inErr){
                tmpCanton = null;
                tmpCctnRegistro = null;
                txtCctn_codigo.setValue('Informaci\u00F3n no disponible');
            }
            txtCisla_nombre.setValue(inRecordCgg_isla.get('CISLA_NOMBRE'));
            txtCisla_abreviatura.setValue(inRecordCgg_isla.get('CISLA_ABREVIATURA'));
            numCisla_indice.setValue(inRecordCgg_isla.get('CISLA_INDICE'));
            isEdit = true;
            habilitarCgg_islaCtrls(true);
        }
    }
    /**
	 * Funcion miembro que devuelve la ventana winFrmCgg_isla.
	 * @returns ventana winFrmCgg_isla.
	 * @base FrmCgg_isla.prototype.show
	 */
    this.getWindow = function(){
        return winFrmCgg_isla;
    }
    /**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_isla.
	 * @base FrmCgg_isla.prototype.loadData
	 */
    this.loadData = function(){
        cargarCgg_islaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_isla desde una instancia.
 */
FrmCgg_isla.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_isla desde una instancia.
 */
FrmCgg_isla.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_isla,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_isla.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_isla desde una instancia.
 */
FrmCgg_isla.prototype.loadData = function(){
    this.loadData();
}
