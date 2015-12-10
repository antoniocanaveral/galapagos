/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_pais.
 * @param {String} INSENTENCIA_CGG_PAIS Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_PAIS Registro de datos de la tabla Cgg_pais.
 * @constructor
 * @base FrmListadoCgg_pais
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_pais(INSENTENCIA_CGG_PAIS,INRECORD_CGG_PAIS){
    var inSentenciaCgg_pais = INSENTENCIA_CGG_PAIS;
    var inRecordCgg_pais=INRECORD_CGG_PAIS;
    var urlCgg_pais=URL_WS+"Cgg_pais";
    var tituloCgg_pais='Registro pa\u00EDs';
    var descCgg_pais='El formulario permite ingresar informaci\u00f3n del pa\u00EDs';
    var isEdit = false;
    /**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS
	 */
    var txtCpais_codigo = new Ext.form.TextField({
        id:'txtCpais_codigo',
        name:'txtCpais_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
	 * Ext.form.TextField NOMBRE DEL PAIS
	 */
    var txtCpais_nombre = new Ext.form.TextField({
        id:'txtCpais_nombre',
        name:'txtCpais_nombre',
        fieldLabel :'Pa\u00eds',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
	/**
	* Ext.form.TextField ABREVIATURA ISO DEL NOMBRE DEL PAIS
	*/
	var txtCpais_iso = new Ext.form.TextField({
			id:'txtCpais_iso',
			name:'txtCpais_iso',
			fieldLabel :'Iso',
			anchor:'98%',
			allowBlank :false,
			maxLength:2
	});
    /**
	 * Ext.form.TextField DESCRIPCION DEL PAIS O CODIGO INTERNACIONAL
	 */
    var txtCpais_descripcion = new Ext.form.TextField({
        id:'txtCpais_descripcion',
        name:'txtCpais_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :20
    });
    /**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_pais
	 */
    var btnGuardarCgg_pais = new Ext.Button({
        id:'btnGuardarCgg_pais',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar pa\u00EDs',
        listeners:{
            click:function(){
                if (pnlCgg_pais.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_pais(r){
                        winFrmCgg_pais.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_pais,
                                msg: 'La informaci\u00f3n del pa\u00EDs ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_pais.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_pais,
                                msg: 'La informaci\u00f3n de pa\u00EDs no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_pais.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCpais_codigo',txtCpais_codigo.getValue());
                    param.add('inCpais_nombre',txtCpais_nombre.getValue());
					param.add('inCpais_iso',txtCpais_iso.getValue());
                    param.add('inCpais_descripcion',txtCpais_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_pais,INSENTENCIA_CGG_PAIS,param, true, CallBackCgg_pais);
                }catch(inErr){
                    winFrmCgg_pais.getEl().unmask();
                }
            }
        }
    });
/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_pais.
	 */
var btnCancelarCgg_pais = new Ext.Button({
    id:'btnCancelarCgg_pais',
    text:'Cancelar',
    iconCls:'iconCancelar',
    tooltip:'Cancelar informaci\u00f3n',
    listeners:{
        click:function(){
            pnlCgg_pais.getForm().reset();
        }
    }
});
/**
	 * Boton que permite cerrar la ventana winFrmCgg_pais.
	 */
var btnCerrarCgg_pais = new Ext.Button({
    id:'btnCerrarCgg_pais',
    text:'Cerrar',
    iconCls:'iconCerrar',
    tooltip:'Cerrar formulario',
    listeners:{
        click:function(){
            winFrmCgg_pais.close();
        }
    }
});
/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_pais.
	 */
var pnlCgg_pais = new Ext.form.FormPanel({
    frame:true,
    labelWidth :100,
    items:[txtCpais_codigo,txtCpais_nombre,txtCpais_iso,txtCpais_descripcion]
});
/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_pais.
	 */
var winFrmCgg_pais = new Ext.Window({
    id:'winFrmCgg_pais',
    title:tituloCgg_pais,
    tbar:getPanelTitulo(tituloCgg_pais,descCgg_pais),
    items:[pnlCgg_pais],
    width:400,
    minWidth:400,
    modal:true,
    resizable:false,
    maximizable:false,
    minimizable:false,
    constrain:true,
    bbar:[btnGuardarCgg_pais,btnCancelarCgg_pais,'->',btnCerrarCgg_pais]
});
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_pais.
	 */
	function cargarCgg_paisCtrls(){
		if(inRecordCgg_pais){
			txtCpais_codigo.setValue(inRecordCgg_pais.get('CPAIS_CODIGO'));
			txtCpais_nombre.setValue(inRecordCgg_pais.get('CPAIS_NOMBRE'));
			txtCpais_iso.setValue(inRecordCgg_pais.get('CPAIS_ISO'));
			txtCpais_descripcion.setValue(inRecordCgg_pais.get('CPAIS_DESCRIPCION'));
			isEdit = true;
		}
	}
/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_pais.
	 * @returns ventana winFrmCgg_pais.
	 * @base FrmCgg_pais.prototype.show
	 */
this.getWindow = function(){
    return winFrmCgg_pais;
}
/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_pais.
	 * @base FrmCgg_pais.prototype.loadData
	 */
this.loadData = function(){
    cargarCgg_paisCtrls();
}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_pais desde una instancia.
 */
FrmCgg_pais.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_pais desde una instancia.
 */
FrmCgg_pais.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_pais,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_pais.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_pais desde una instancia.
 */
FrmCgg_pais.prototype.loadData = function(){
    this.loadData();
}
