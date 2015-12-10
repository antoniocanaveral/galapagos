/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_categoria.
 * @param {String} IN_SENTENCIA_CGG_DHU_CATEGORIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_CATEGORIA Registro de datos de la tabla Cgg_dhu_categoria.
 * @constructor
 * @base FrmListadoCgg_dhu_categoria
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_categoria(IN_SENTENCIA_CGG_DHU_CATEGORIA,IN_RECORD_CGG_DHU_CATEGORIA){
    var inSentenciaCgg_dhu_categoria = IN_SENTENCIA_CGG_DHU_CATEGORIA;
    var inRecordCgg_dhu_categoria=IN_RECORD_CGG_DHU_CATEGORIA;
    var urlCgg_dhu_categoria=URL_WS+"Cgg_dhu_categoria";
    var tituloCgg_dhu_categoria='Categor\u00eda';
    var descCgg_dhu_categoria='El formulario permite administrar la informaci\u00f3n de la Categor\u00eda';
    var isEdit = false;
    var tmpCggCdcat_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
     */
    var txtCdcat_codigo = new Ext.form.TextField({
        id:'txtCdcat_codigo',
        name:'txtCdcat_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCdcat_codigo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_categoria",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CDCAT_CODIGO'},
            {name:'CDCAT_NOMBRE'},
            {name:'CGG_CDCAT_NOMBRE'}
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    /**
     * Ext.form.ComboBox IDENTIFICATIVO UNICO DE REGISTRO DE LA CATEGORIA
     */
    var cbxCggCdcat_codigo = new Ext.form.ComboBox({
        id:'cbxCdcat_codigo',
        fieldLabel :'Categor\u00eda',
        displayField:'CDCAT_NOMBRE',
        store:gsCdcat_codigo,
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione una Categor\u00eda',
        selectOnFocus:true,
        valueField:'CDCAT_CODIGO',       
        anchor:'98%',
        listeners:
        {
            select:function(combo,record)
            {
                tmpCggCdcat_codigo = record.get('CDCAT_CODIGO');
            }
        }
    });
    gsCdcat_codigo.load();

    /**
     * Ext.form.TextField NOMBRE DE LA CATEGORIA
     */
    var txtCdcat_nombre = new Ext.form.TextField({
        id:'txtCdcat_nombre',
        name:'txtCdcat_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_categoria
     */
    var btnGuardarCgg_dhu_categoria = new Ext.Button({
        id:'btnGuardarCgg_dhu_categoria',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_dhu_categoria.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_dhu_categoria(r){
                        winFrmCgg_dhu_categoria.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_categoria,
                                msg: 'La informaci\u00f3n de Categor\u00eda ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_categoria.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_categoria,
                                msg: 'La informaci\u00f3n de Categor\u00eda no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_categoria.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdcat_codigo',txtCdcat_codigo.getValue());
                    param.add('inCgg_cdcat_codigo',tmpCggCdcat_codigo?tmpCggCdcat_codigo:null);                    
                    param.add('inCdcat_nombre',txtCdcat_nombre.getValue());
                    SOAPClient.invoke(urlCgg_dhu_categoria,IN_SENTENCIA_CGG_DHU_CATEGORIA,param, true, CallBackCgg_dhu_categoria);
                }catch(inErr){
                    winFrmCgg_dhu_categoria.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_categoria.
     */
    var btnCancelarCgg_dhu_categoria = new Ext.Button({
        id:'btnCancelarCgg_dhu_categoria',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_categoria.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_categoria.
     */
    var btnCerrarCgg_dhu_categoria = new Ext.Button({
        id:'btnCerrarCgg_dhu_categoria',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_categoria.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_categoria.
     */
    var pnlCgg_dhu_categoria = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdcat_codigo,
            cbxCggCdcat_codigo,txtCdcat_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_categoria.
     */
    var winFrmCgg_dhu_categoria = new Ext.Window({
        id:'winFrmCgg_dhu_categoria',
        title:tituloCgg_dhu_categoria,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_dhu_categoria,descCgg_dhu_categoria),
        items:[pnlCgg_dhu_categoria],
        bbar:[btnGuardarCgg_dhu_categoria,btnCancelarCgg_dhu_categoria,'->',btnCerrarCgg_dhu_categoria]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_dhu_categoria.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_categoria.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_categoriaCtrls(inEstado){
        estado=!inEstado;
        txtCdcat_codigo.setDisabled(estado);
        cbxCggCdcat_codigo.setDisabled(estado);
        txtCdcat_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_categoria.
     */
    function cargarCgg_dhu_categoriaCtrls(){
        if(inRecordCgg_dhu_categoria){
            txtCdcat_codigo.setValue(inRecordCgg_dhu_categoria.get('CDCAT_CODIGO'));
            cbxCggCdcat_codigo.setValue(inRecordCgg_dhu_categoria.get('SUB_CATEGORIA'));
            tmpCggCdcat_codigo=inRecordCgg_dhu_categoria.get('CGG_CDCAT_CODIGO');
            txtCdcat_nombre.setValue(inRecordCgg_dhu_categoria.get('CDCAT_NOMBRE'));
            isEdit = true;
            habilitarCgg_dhu_categoriaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_categoria.
     * @returns ventana winFrmCgg_dhu_categoria.
     * @base FrmCgg_dhu_categoria.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_categoria;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_categoria.
     * @base FrmCgg_dhu_categoria.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_categoriaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_categoria desde una instancia.
 */
FrmCgg_dhu_categoria.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_categoria desde una instancia.
 */
FrmCgg_dhu_categoria.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_categoria,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_categoria.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_categoria desde una instancia.
 */
FrmCgg_dhu_categoria.prototype.loadData = function(){
    this.loadData();
}
