/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_tipo_beca.
 * @param {String} IN_SENTENCIA_CGG_DHU_TIPO_BECA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_TIPO_BECA Registro de datos de la tabla Cgg_dhu_tipo_beca.
 * @constructor
 * @base FrmListadoCgg_dhu_tipo_beca
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_tipo_beca(IN_SENTENCIA_CGG_DHU_TIPO_BECA,IN_RECORD_CGG_DHU_TIPO_BECA){
    var inSentenciaCgg_dhu_tipo_beca = IN_SENTENCIA_CGG_DHU_TIPO_BECA;
    var inRecordCgg_dhu_tipo_beca=IN_RECORD_CGG_DHU_TIPO_BECA;
    var urlCgg_dhu_tipo_beca=URL_WS+"Cgg_dhu_tipo_beca";
    var tituloCgg_dhu_tipo_beca='Tipo beca';
    var descCgg_dhu_tipo_beca='El formulario permite administrar la informaci\u00f3n sobre el tipo de beca';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
     */
    var txtCdtbc_codigo = new Ext.form.TextField({
        id:'txtCdtbc_codigo',
        name:'txtCdtbc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DE LA BECA
     */
    var txtCdtbc_nombre = new Ext.form.TextField({
        id:'txtCdtbc_nombre',
        name:'txtCdtbc_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField ABREVIATURA DE LA BECA
     */
    var txtCdtbc_abreviatura = new Ext.form.TextField({
        id:'txtCdtbc_abreviatura',
        name:'txtCdtbc_abreviatura',
        fieldLabel :'Abreviatura',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField ESTADO DE LA BECA
     0 - ACTIVO
     1 - INACTIVO
     2 - NO VIGENTE

     */
  /*  var numCdtbc_estado_beca = new Ext.form.NumberField({
        id:'numCdtbc_estado_beca',
        name:'numCdtbc_estado_beca',
        fieldLabel :'Estado beca',
        allowBlank :false,
        disabled :false
    });
      /**
     * Ext.form.NumberField ESTADO TIPO BECA

     */
 /*   var sttipo_beca = new Ext.data.ArrayStore({
        fields:['id','estado_tipo_beca'],
        data:dttipo_beca
    });*/
    var cbxCdhu_tipo_beca = new Ext.form.ComboBox({
        id:'cbxCdhu_tipo_beca ',
        name:'cbxCdhu_tipo_beca ',
        store: dsTipoBeca,
        fieldLabel :'Estado beca',
        displayField: 'estado_tipo_beca',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    //cbxCdhu_tipo_beca.setVisible(false);
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_tipo_beca
     */
    var btnGuardarCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnGuardarCgg_dhu_tipo_beca',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_tipo_beca.getForm().isValid()==false){
                    return;
                }

                try{
                    function CallBackCgg_dhu_tipo_beca(r){
                        winFrmCgg_dhu_tipo_beca.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_beca,
                                msg: 'La informaci\u00f3n de Dhu tipo beca ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_tipo_beca.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_beca,
                                msg: 'La informaci\u00f3n de Dhu tipo beca no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_tipo_beca.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdtbc_codigo',txtCdtbc_codigo.getValue());
                    param.add('inCdtbc_nombre',txtCdtbc_nombre.getValue());
                    param.add('inCdtbc_abreviatura',txtCdtbc_abreviatura.getValue());
                    param.add('inCdtbc_estado_beca',cbxCdhu_tipo_beca.getValue());
                    SOAPClient.invoke(urlCgg_dhu_tipo_beca,IN_SENTENCIA_CGG_DHU_TIPO_BECA,param, true, CallBackCgg_dhu_tipo_beca);
                }catch(inErr){
                    winFrmCgg_dhu_tipo_beca.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_tipo_beca.
     */
    var btnCancelarCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnCancelarCgg_dhu_tipo_beca',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_tipo_beca.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_tipo_beca.
     */
    var btnCerrarCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnCerrarCgg_dhu_tipo_beca',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_tipo_beca.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_tipo_beca.
     */
    var pnlCgg_dhu_tipo_beca = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdtbc_codigo,txtCdtbc_nombre,txtCdtbc_abreviatura,cbxCdhu_tipo_beca]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_tipo_beca.
     */
    var winFrmCgg_dhu_tipo_beca = new Ext.Window({
        id:'winFrmCgg_dhu_tipo_beca',
        title:tituloCgg_dhu_tipo_beca,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        constrain:true,
		modal : true,
		resizable:false,
        tbar:getPanelTitulo(tituloCgg_dhu_tipo_beca,descCgg_dhu_tipo_beca),
        items:[pnlCgg_dhu_tipo_beca],
        bbar:[btnGuardarCgg_dhu_tipo_beca,btnCancelarCgg_dhu_tipo_beca,'->',btnCerrarCgg_dhu_tipo_beca]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_tipo_beca.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_tipo_becaCtrls(inEstado){
        estado=!inEstado;
        txtCdtbc_codigo.setDisabled(estado);
        txtCdtbc_nombre.setDisabled(estado);
        txtCdtbc_abreviatura.setDisabled(estado);
        cbxCdhu_tipo_beca.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_tipo_beca.
     */
    function cargarCgg_dhu_tipo_becaCtrls(){
        if(inRecordCgg_dhu_tipo_beca){
            txtCdtbc_codigo.setValue(inRecordCgg_dhu_tipo_beca.get('CDTBC_CODIGO'));
            txtCdtbc_nombre.setValue(inRecordCgg_dhu_tipo_beca.get('CDTBC_NOMBRE'));
            txtCdtbc_abreviatura.setValue(inRecordCgg_dhu_tipo_beca.get('CDTBC_ABREVIATURA'));
           cbxCdhu_tipo_beca.setValue(inRecordCgg_dhu_tipo_beca.get('CDTBC_ESTADO_BECA'));
            isEdit = true;
            habilitarCgg_dhu_tipo_becaCtrls(true);
            //cbxCdhu_tipo_beca.setVisible(true);

        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_tipo_beca.
     * @returns ventana winFrmCgg_dhu_tipo_beca.
     * @base FrmCgg_dhu_tipo_beca.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_tipo_beca;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_tipo_beca.
     * @base FrmCgg_dhu_tipo_beca.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_tipo_becaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_tipo_beca desde una instancia.
 */
FrmCgg_dhu_tipo_beca.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_tipo_beca desde una instancia.
 */
FrmCgg_dhu_tipo_beca.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_tipo_beca,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_tipo_beca.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_tipo_beca desde una instancia.
 */
FrmCgg_dhu_tipo_beca.prototype.loadData = function(){
    this.loadData();
}
