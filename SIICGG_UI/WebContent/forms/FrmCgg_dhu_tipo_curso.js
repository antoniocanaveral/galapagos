/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_tipo_curso.
 * @param {String} INSENTENCIA_CGG_DHU_TIPO_CURSO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_TIPO_CURSO Registro de datos de la tabla Cgg_dhu_tipo_curso.
 * @constructor
 * @base FrmListadoCgg_dhu_tipo_curso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_tipo_curso(INSENTENCIA_CGG_DHU_TIPO_CURSO,INRECORD_CGG_DHU_TIPO_CURSO){
    var inSentenciaCgg_dhu_tipo_curso = INSENTENCIA_CGG_DHU_TIPO_CURSO;
    var inRecordCgg_dhu_tipo_curso=INRECORD_CGG_DHU_TIPO_CURSO;
    var urlCgg_dhu_tipo_curso=URL_WS+"Cgg_dhu_tipo_curso";
    var tituloCgg_dhu_tipo_curso=' Tipo curso';
    var descCgg_dhu_tipo_curso='El formulario permite administrar informaci\u00f3n del tipo de curso';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CURSO
     */
    var txtCdtcr_codigo = new Ext.form.TextField({
        id:'txtCdtcr_codigo',
        name:'txtCdtcr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE O DESCRIPCION DEL TIPO DE CURSO
     */
    var txtCdtcr_nombre = new Ext.form.TextField({
        id:'txtCdtcr_nombre',
        name:'txtCdtcr_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    
	
	var dsTipoResidente=[
    [0,'PERMANENTE/TEMPORAL'],
    [1,'PERMANENTE'],
    [2,'OTROS']

];

    var cbxTipo_residente = new Ext.form.ComboBox({
       id:'cbxTipo_residente',
        name:'cbxTipo_residente',
        store: dsTipoResidente,
        anchor:'98%',
        displayField: 'Tipo residente',
        mode: 'local',
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        valueField:'id_tipo_residente',
		allowBlank :false

    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_tipo_curso
     */
    var btnGuardarCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnGuardarCgg_dhu_tipo_curso',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_tipo_curso.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_tipo_curso(r){
                        winFrmCgg_dhu_tipo_curso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_curso,
                                msg: 'La informaci\u00f3n de tipo curso ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_tipo_curso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_curso,
                                msg: 'La informaci\u00f3n de tipo curso no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_tipo_curso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdtcr_codigo',txtCdtcr_codigo.getValue());
                    param.add('inCdtcr_nombre',txtCdtcr_nombre.getValue());
                    param.add('inCdtcr_tipo_residente',cbxTipo_residente.getValue());
                    SOAPClient.invoke(urlCgg_dhu_tipo_curso,INSENTENCIA_CGG_DHU_TIPO_CURSO,param, true, CallBackCgg_dhu_tipo_curso);
                }catch(inErr){
                    winFrmCgg_dhu_tipo_curso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_tipo_curso.
     */
    var btnCancelarCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnCancelarCgg_dhu_tipo_curso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_tipo_curso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_tipo_curso.
     */
    var btnCerrarCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnCerrarCgg_dhu_tipo_curso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_tipo_curso.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_tipo_curso.
     */
    var pnlCgg_dhu_tipo_curso = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdtcr_codigo,txtCdtcr_nombre,cbxTipo_residente]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_tipo_curso.
     */
    var winFrmCgg_dhu_tipo_curso = new Ext.Window({
        id:'winFrmCgg_dhu_tipo_curso',
        title:tituloCgg_dhu_tipo_curso,
        tbar:getPanelTitulo(tituloCgg_dhu_tipo_curso,descCgg_dhu_tipo_curso),
        items:[pnlCgg_dhu_tipo_curso],
        width:400,
        minWidth:400,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_tipo_curso,btnCancelarCgg_dhu_tipo_curso,'->',btnCerrarCgg_dhu_tipo_curso]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_tipo_curso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_tipo_cursoCtrls(inEstado){
        estado=!inEstado;
        txtCdtcr_codigo.setDisabled(estado);
        txtCdtcr_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_tipo_curso.
     */
    function cargarCgg_dhu_tipo_cursoCtrls(){
        if(inRecordCgg_dhu_tipo_curso){
            txtCdtcr_codigo.setValue(inRecordCgg_dhu_tipo_curso.get('CDTCR_CODIGO'));
            txtCdtcr_nombre.setValue(inRecordCgg_dhu_tipo_curso.get('CDTCR_NOMBRE'));
			cbxTipo_residente.setValue(inRecordCgg_dhu_tipo_curso.get('CDTCR_TIPO_RESIDENTE'));
            isEdit = true;
            habilitarCgg_dhu_tipo_cursoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_tipo_curso.
     * @returns ventana winFrmCgg_dhu_tipo_curso.
     * @base FrmCgg_dhu_tipo_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_tipo_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_tipo_curso.
     * @base FrmCgg_dhu_tipo_curso.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_tipo_cursoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_tipo_curso desde una instancia.
 */
FrmCgg_dhu_tipo_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_tipo_curso desde una instancia.
 */
FrmCgg_dhu_tipo_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_tipo_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_tipo_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_tipo_curso desde una instancia.
 */
FrmCgg_dhu_tipo_curso.prototype.loadData = function(){
    this.loadData();
}
