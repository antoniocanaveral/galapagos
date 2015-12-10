/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_cronograma_encuesta.
 * @param {String} INSENTENCIA_CGG_DHU_CRONOGRAMA_ENCUESTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_CRONOGRAMA_ENCUESTA Registro de datos de la tabla Cgg_dhu_cronograma_encuesta.
 * @constructor
 * @base FrmListadoCgg_dhu_cronograma_encuesta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_cronograma_encuesta(INSENTENCIA_CGG_DHU_CRONOGRAMA_ENCUESTA,INRECORD_CGG_DHU_CRONOGRAMA_ENCUESTA){
    var inSentenciaCgg_dhu_cronograma_encuesta = INSENTENCIA_CGG_DHU_CRONOGRAMA_ENCUESTA;
    var inRecordCgg_dhu_cronograma_encuesta=INRECORD_CGG_DHU_CRONOGRAMA_ENCUESTA;
    var urlCgg_dhu_cronograma_encuesta=URL_WS+"Cgg_dhu_cronograma_encuesta";
    var tituloCgg_dhu_cronograma_encuesta='Cronograma de la Encuesta';
    var descCgg_dhu_cronograma_encuesta='El formulario permite administrar informaci\u00f3n del Cronograma de la Encuesta';
    var isEdit = false;
    var tmpCdenc_codigo;
    var tmpCdcur_codigo;
    var tmpCisla_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO CRONOGRAMA ENCUESTA
     */
    var txtCdcre_codigo = new Ext.form.TextField({
        id:'txtCdcre_codigo',
        name:'txtCdcre_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var txtCdenc_codigo = new Ext.form.TextField({
        id:'txtCdenc_codigo',
        name:'txtCdenc_codigo',
        fieldLabel :'Encuesta',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var btnCdenc_codigoCgg_dhu_cronograma_encuesta = new Ext.Button({
        id:'btnCdenc_codigoCgg_dhu_cronograma_encuesta',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_encuesta = new FrmListadoCgg_dhu_encuesta();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_encuesta.getStore(),tmpFLCgg_dhu_encuesta.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCdenc_codigo=tmpRecord.get('CDENC_CODIGO');
                        txtCdenc_codigo.setValue(tmpRecord.get('CDENC_NOMBRE'));

                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var txtCdcur_codigo = new Ext.form.TextField({
        id:'txtCdcur_codigo',
        name:'txtCdcur_codigo',
        fieldLabel :'Curso',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    /*var txtCisla_codigo = new Ext.form.TextField({
        id:'txtCisla_codigo',
        name:'txtCisla_codigo',
        fieldLabel :'Isla',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });*/
	
	/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON DE NACIMIENTO
     */
    var cbxCisla = new Ext.form.ComboBox({
        id:'cbxCisla',
        name:'cbxCisla',
        fieldLabel :'Isla',
        anchor:'98%',
        store: SCGG_ISLA,
        displayField:'CISLA_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Isla',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CISLA_NOMBRE}. {CISLA_NOMBRE}" class="x-combo-list-item">{CISLA_NOMBRE}</div></tpl>',
        valueField:'CISLA_CODIGO',
        lastQuery: ''/*,
        listeners:{
            select:function(combo, value) {
                cbxCgprv_nombre_nacimiento.clearValue();
                cbxCctn_nombre_nacimiento.clearValue();
                cbxCctn_nombre_nacimiento.getStore().filter('CGPRV_CODIGO', '');
                cbxCgprv_nombre_nacimiento.getStore().filter('CPAIS_CODIGO', combo.getValue());

            }
        }*/

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CURSO
     */
    var btnCdcur_codigoCgg_dhu_cronograma_encuesta = new Ext.Button({
        id:'btnCdcur_codigoCgg_dhu_cronograma_encuesta',       
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_curso = new FrmListadoCgg_dhu_curso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_curso.getStore(),tmpFLCgg_dhu_curso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCdcur_codigo=tmpRecord.get('CDCUR_CODIGO');
                        txtCdcur_codigo.setValue(tmpRecord.get('CDCUR_DESCRIPCION'));
                        /*tmpCisla_codigo=tmpRecord.get('CISLA_CODIGO');
                        txtCisla_codigo.setValue(tmpRecord.get('CISLA_NOMBRE'));*/
                    }
                });
                objBusqueda.show();
            }}
    });


    /**
     * Ext.form.TextField DESCRIPCION DEL CRONOGRAMA DE ENCUESTA
     */
    var txtCdcre_descripcion = new Ext.form.TextField({
        id:'txtCdcre_descripcion',
        name:'txtCdcre_descripcion',
        fieldLabel :'Descripci\u00f3n ',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.DateField FECHA DE EJECUCION DEL CRONOGRAMA
     */
    var dtCdcre_fecha_ejecucion = new Ext.form.DateField({
        id:'dtCdcre_fecha_ejecucion',
        name:'dtCdcre_fecha_ejecucion',
        fieldLabel :'Ejecuci\u00f3n ',
        allowBlank :false,
        value:new Date(),
        minValue:new Date(),
		listeners:{
            change:function(obj,newValue,oldValue){
                dtCdcre_fecha_maxima_realizacion.setMinValue(newValue);
                dtCdcre_fecha_maxima_realizacion.setValue(newValue);				
            },
            select:function(obj,value){
                dtCdcre_fecha_maxima_realizacion.setMinValue(value);
                dtCdcre_fecha_maxima_realizacion.setValue(value);				
            }
        }
    });
    /**
     * Ext.form.DateField FECHA MAXIMA HASTA CUANDO SE PUEDE EJECUTAR UNA ENCUESTA
     */
    var dtCdcre_fecha_maxima_realizacion = new Ext.form.DateField({
        id:'dtCdcre_fecha_maxima_realizacion',
        name:'dtCdcre_fecha_maxima_realizacion',
        fieldLabel :'M\u00e1xima realizaci\u00f3n ',
        allowBlank :false,
        value:new Date(),
        minValue:dtCdcre_fecha_ejecucion.getValue()
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_cronograma_encuesta
     */
    var btnGuardarCgg_dhu_cronograma_encuesta = new Ext.Button({
        id:'btnGuardarCgg_dhu_cronograma_encuesta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_cronograma_encuesta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_cronograma_encuesta(r){
                        winFrmCgg_dhu_cronograma_encuesta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_cronograma_encuesta,
                                msg: 'La informaci\u00f3n de Cronograma Encuesta ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_cronograma_encuesta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_cronograma_encuesta,
                                msg: 'La informaci\u00f3n de Cronograma Encuesta no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_cronograma_encuesta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdcre_codigo',txtCdcre_codigo.getValue());
                    param.add('inCdenc_codigo',tmpCdenc_codigo);
                    param.add('inCdcur_codigo',tmpCdcur_codigo);
                    param.add('inCisla_codigo',cbxCisla.getValue());//tmpCisla_codigo);
                    param.add('inCdcre_descripcion',txtCdcre_descripcion.getValue());
                    param.add('inCdcre_fecha_ejecucion',dtCdcre_fecha_ejecucion.getValue().format('c'));
                    param.add('inCdcre_fecha_maxima_realizacion',dtCdcre_fecha_maxima_realizacion.getValue().format('c'));
                    SOAPClient.invoke(urlCgg_dhu_cronograma_encuesta,INSENTENCIA_CGG_DHU_CRONOGRAMA_ENCUESTA,param, true, CallBackCgg_dhu_cronograma_encuesta);
                }catch(inErr){
                    winFrmCgg_dhu_cronograma_encuesta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_cronograma_encuesta.
     */
    var btnCancelarCgg_dhu_cronograma_encuesta = new Ext.Button({
        id:'btnCancelarCgg_dhu_cronograma_encuesta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_cronograma_encuesta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_cronograma_encuesta.
     */
    var btnCerrarCgg_dhu_cronograma_encuesta = new Ext.Button({
        id:'btnCerrarCgg_dhu_cronograma_encuesta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_cronograma_encuesta.close();
            }}
    });
    /**
     * ExtPanel Panel que contiene los controles de la aerolinea y el numero de vuelo
     */
    var pnlfsFechas = new Ext.form.FieldSet({
        id:'pnlfsFechas',
        title:'Fecha',
        region:'center',       
        items:[{xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.5,layout:'form',  labelWidth :60,items:[dtCdcre_fecha_ejecucion]},
                    {columnWidth:.5,layout:'form',  labelWidth :105,items:[dtCdcre_fecha_maxima_realizacion]}]}

        ]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_cronograma_encuesta.
     */
    var pnlCgg_dhu_cronograma_encuesta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdcre_codigo,
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.92,layout:'form',items:[txtCdenc_codigo]},
                    {columnWidth:.08,layout:'form',items:[btnCdenc_codigoCgg_dhu_cronograma_encuesta]}]},
            {xtype:'panel',layout:'column',items:[
                {columnWidth:.92,layout:'form',items:[txtCdcur_codigo]},
                {columnWidth:.08,layout:'form',items:[btnCdcur_codigoCgg_dhu_cronograma_encuesta]}]},
            /*txtCisla_codigo*/cbxCisla, txtCdcre_descripcion,pnlfsFechas]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_cronograma_encuesta.
     */
    var winFrmCgg_dhu_cronograma_encuesta = new Ext.Window({
        id:'winFrmCgg_dhu_cronograma_encuesta',
        title:tituloCgg_dhu_cronograma_encuesta,
        tbar:getPanelTitulo(tituloCgg_dhu_cronograma_encuesta,descCgg_dhu_cronograma_encuesta),
        items:[pnlCgg_dhu_cronograma_encuesta],
        width:480,
        minWidth:480,
        maximizable:false,
        minimizable:false,
		resizable : false,
		modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_cronograma_encuesta,btnCancelarCgg_dhu_cronograma_encuesta,'->',btnCerrarCgg_dhu_cronograma_encuesta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_cronograma_encuesta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_cronograma_encuestaCtrls(inEstado){
        estado=!inEstado;
        txtCdcre_codigo.setDisabled(estado);
        txtCdenc_codigo.setDisabled(estado);
        txtCdcur_codigo.setDisabled(estado);
        //txtCisla_codigo.setDisabled(estado);
		cbxCisla.setDisabled(estado);
        txtCdcre_descripcion.setDisabled(estado);
        dtCdcre_fecha_ejecucion.setDisabled(estado);
        dtCdcre_fecha_maxima_realizacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_cronograma_encuesta.
     */
    function cargarCgg_dhu_cronograma_encuestaCtrls(){
        if(inRecordCgg_dhu_cronograma_encuesta){
            txtCdcre_codigo.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_CODIGO'));
            tmpCdenc_codigo = inRecordCgg_dhu_cronograma_encuesta.get('CDENC_CODIGO');
            txtCdenc_codigo.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CDENC_NOMBRE'));
            tmpCdcur_codigo=inRecordCgg_dhu_cronograma_encuesta.get('CDCUR_CODIGO');
            txtCdcur_codigo.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CDCUR_DESCRIPCION'));
            //tmpCisla_codigo = inRecordCgg_dhu_cronograma_encuesta.get('CISLA_CODIGO');
			cbxCisla.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CISLA_CODIGO'));
            //txtCisla_codigo.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CISLA_NOMBRE'));
            txtCdcre_descripcion.setValue(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_DESCRIPCION'));
            dtCdcre_fecha_ejecucion.setMinValue(truncDate(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_FECHA_EJECUCION')));
            dtCdcre_fecha_ejecucion.setValue(truncDate(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_FECHA_EJECUCION')));
            dtCdcre_fecha_maxima_realizacion.setMinValue(truncDate(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_FECHA_MAXIMA_REALIZACION')));
            dtCdcre_fecha_maxima_realizacion.setValue(truncDate(inRecordCgg_dhu_cronograma_encuesta.get('CDCRE_FECHA_MAXIMA_REALIZACION')));
            isEdit = true;
            habilitarCgg_dhu_cronograma_encuestaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_cronograma_encuesta.
     * @returns ventana winFrmCgg_dhu_cronograma_encuesta.
     * @base FrmCgg_dhu_cronograma_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_cronograma_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_cronograma_encuesta.
     * @base FrmCgg_dhu_cronograma_encuesta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_cronograma_encuestaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_cronograma_encuesta desde una instancia.
 */
FrmCgg_dhu_cronograma_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_cronograma_encuesta desde una instancia.
 */
FrmCgg_dhu_cronograma_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_cronograma_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_cronograma_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_cronograma_encuesta desde una instancia.
 */
FrmCgg_dhu_cronograma_encuesta.prototype.loadData = function(){
    this.loadData();
}
