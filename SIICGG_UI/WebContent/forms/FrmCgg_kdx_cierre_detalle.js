/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_cierre_detalle.
 * @param {String} IN_SENTENCIA_CGG_KDX_CIERRE_DETALLE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_CIERRE_DETALLE Registro de datos de la tabla Cgg_kdx_cierre_detalle.
 * @constructor
 * @base FrmListadoCgg_kdx_cierre_detalle
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_cierre_detalle(IN_SENTENCIA_CGG_KDX_CIERRE_DETALLE,IN_RECORD_CGG_KDX_CIERRE_DETALLE){
    var inSentenciaCgg_kdx_cierre_detalle = IN_SENTENCIA_CGG_KDX_CIERRE_DETALLE;
    var inRecordCgg_kdx_cierre_detalle=IN_RECORD_CGG_KDX_CIERRE_DETALLE;
    var urlCgg_kdx_cierre_detalle=URL_WS+"Cgg_kdx_cierre_detalle";
    var tituloCgg_kdx_cierre_detalle='Detalle de recaudaci\u00f3n';
    var descCgg_kdx_cierre_detalle='El formulario permite administrar la informaci\u00f3n de detalle de recaudaci\u00f3n';
    var isEdit = false;
    var tmpDatosConfirmados = false;
    var objDetalleDenominacion= {
        CKCDT_CODIGO:'KEYGEN',
        CKDNM_CODIGO:'',
        CKDNM_DENOMINACION:'',
        CKCRR_CODIGO:'',
        CKCDT_CANTIDAD:'',
        CKCDT_VALOR:'',
        CKCDT_TOTAL:'',
        CKCDT_OBSERVACION:'',
        CKDNM_VALOR_MONETARIO:''
    }
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCkcdt_codigo = new Ext.form.TextField({
        id:'txtCkcdt_codigo',
        name:'txtCkcdt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCkdnm_codigo = new Ext.form.TextField({
        id:'txtCkdnm_codigo',
        name:'txtCkdnm_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCkdnm_nombre= new Ext.form.TextField({
        id:'txtCkdnm_nombre',
        name:'txtCkdnm_nombre',
        fieldLabel :'Denominaci\u00f3n',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });

    var gsCgg_kdx_denominacion_cierre = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_denominacion",
            method:"selectAllGroup"
        }),
        reader:new Ext.data.JsonReader({
        },[
            {name:'CKDNM_CODIGO'},
            {name:'CKTPG_CODIGO'},
            {name:'CKTPG_DESCRIPCION'},
            {name:'CKDNM_DENOMINACION'},
            {name:'CKDNM_OBSERVACION'},
            {name:'CKDNM_VALOR_MONETARIO'}
        ]),
        baseParams:{format:'JSON'},
        groupField: 'CKTPG_DESCRIPCION',
        listeners:{
            load:function()
            {
                if(isEdit)
                {
                    cbxCkdnm_codigo.setValue(inRecordCgg_kdx_cierre_detalle.get('CKDNM_CODIGO'));
                }
            }
        }
    });
    gsCgg_kdx_denominacion_cierre.reload();
    /**
     *Codigo unico que identifica el registro del origen.
     */
    var cbxCkdnm_codigo = new Ext.ux.form.GroupComboBox({
        id:'cbxCkdnm_codigo',
        xtype: 'uxgroupcombo',
        fieldLabel: 'Denominacion',
        store:gsCgg_kdx_denominacion_cierre,
        displayField: 'CKDNM_DENOMINACION',
        mode: 'local',
        triggerAction: 'all',
        anchor:'90%',
        showGroupName: false,
        startCollapsed: false,
        editable:true,
        forceSelection:true,
        selectOnFocus:true,
        valueField:'CKDNM_CODIGO',
        emptyText:'Seleccione la denominaci\u00f3n...',
        groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tipos" : "Tipo"]})',
        tpl: '<tpl for="."><div ext:qtip="{CKDNM_OBSERVACION}" class="x-combo-list-item">{CKDNM_DENOMINACION}</div></tpl>',
        listeners:{
            select:function(combo, record, index )
            {

                if(record.get('CKDNM_VALOR_MONETARIO')>0)
                {
                    numCkcdt_valor.setValue(record.get('CKDNM_VALOR_MONETARIO'));
                    numCkcdt_valor.show();
                    numCkcdt_cantidad.reset();
                    numCkcdt_total.reset();
                    txtCkcdt_observacion.hide();
                    spfCkcdt_valor.hide();

                }
                else
                {
                    numCkcdt_cantidad.setValue(1);
                    numCkcdt_valor.hide();
                    spfCkcdt_valor.show();
                    txtCkcdt_observacion.show();
                }
                objDetalleDenominacion.CKDNM_VALOR_MONETARIO = record.get('CKDNM_VALOR_MONETARIO');
            }
        }
    });

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    /* var btnCkdnm_codigoCgg_kdx_cierre_detalle = new Ext.Button({
     id:'btnCkdnm_codigoCgg_kdx_cierre_detalle',
     iconCls:'iconBuscar',
     tooltip:'Buscar denominaci\u00f3n',
     listeners:{
     click:function(){
     var tmpFLCgg_kdx_denominacion = new FrmListadoCgg_kdx_denominacion();
     var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_denominacion.getStore(),tmpFLCgg_kdx_denominacion.getColumnModel());
     objBusqueda.closeHandler(function(){
     var tmpRecord = objBusqueda.getSelectedRow();
     if(tmpRecord)
     {
     txtCkdnm_codigo.setValue(tmpRecord.get('CKDNM_CODIGO'));
     txtCkdnm_nombre.setValue(tmpRecord.get('CKDNM_DENOMINACION'));
     if(tmpRecord.get('CKDNM_VALOR_MONETARIO')>0)
     {
     numCkcdt_valor.setValue(tmpRecord.get('CKDNM_VALOR_MONETARIO'));
     numCkcdt_valor.show();
     spfCkcdt_valor.hide();

     }
     else
     {
     numCkcdt_cantidad.setValue(1);
     numCkcdt_valor.hide();
     spfCkcdt_valor.show();
     }
     objDetalleDenominacion.CKDNM_VALOR_MONETARIO = tmpRecord.get('CKDNM_VALOR_MONETARIO');
     }
     });
     objBusqueda.show();
     }}
     });*/


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCkcrr_codigo_detalle = new Ext.form.TextField({
        id:'txtCkcrr_codigo_detalle',
        name:'txtCkcrr_codigo_detalle',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCkcrr_codigoCgg_kdx_cierre_detalle = new Ext.Button({
        id:'btnCkcrr_codigoCgg_kdx_cierre_detalle',
        text:'Ckcrr_codigo',
        iconCls:'iconCkcrr_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_cierre = new FrmListadoCgg_kdx_cierre();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_cierre.getStore(),tmpFLCgg_kdx_cierre.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCkcrr_codigo_detalle.setValue(tmpRecord.get('CKCRR_CODIGO'));

                    }
                });
                objBusqueda.show();
            }}
    });


    /**
     * Ext.form.NumberField CANTIDAD
     */
    var numCkcdt_cantidad = new Ext.form.NumberField({
        id:'numCkcdt_cantidad',
        name:'numCkcdt_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false,
        enableKeyEvents:true,
        listeners:{
            change:function()
            {
                if(numCkcdt_valor.isVisible())
                    numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * numCkcdt_valor.getValue());
                else
                    numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * spfCkcdt_valor.getValue());
            },
            specialkey: function(field, e){
                // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                // e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
                if (e.getKey() == e.ENTER) {
                    if(numCkcdt_valor.isVisible())
                        numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * numCkcdt_valor.getValue());
                    else
                        numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * spfCkcdt_valor.getValue());
                }
            }
        }
    });
    /**
     * Ext.form.NumberField VALOR MONETARIO DE LA DENOMINACION
     */
    var numCkcdt_valor = new Ext.form.NumberField({
        id:'numCkcdt_valor',
        name:'numCkcdt_valor',
        fieldLabel :'Valor',
        allowBlank :false,
        disabled :true,
        hidden:false
    });

    var spfCkcdt_valor = new Ext.ux.form.SpinnerField({
        id:'spfCkcdt_valor',
        name:'spfCkcdt_valor',
        fieldLabel :'Valor',
        anchor:'50%',
        allowBlank :false,
        disabled :false,
        value:'1',
        minValue: 0,
        maxValue: 10000,
        allowDecimals: true,
        allowNegative: false,
        decimalPrecision: 1,
        incrementValue: 10,
        alternateIncrementValue: 1,
        accelerate: true,
        hidden:true,
        enableKeyEvents:true,
        listeners:{
            spin:function()
            {
                //alert(spfCkcdt_valor.getValue());
                numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * spfCkcdt_valor.getValue()) ;
            },
            keyup :function(obj)
            {
                numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * obj.getValue());
            },
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    numCkcdt_total.setValue(numCkcdt_cantidad.getValue() * spfCkcdt_valor.getValue());
                }
            }

        }
    });
    /**
     * Ext.form.NumberField TOTAL CONTABLE
     */
    var numCkcdt_total = new Ext.form.NumberField({
        id:'numCkcdt_total',
        name:'numCkcdt_total',
        fieldLabel :'Total',
        allowBlank :false,
        disabled :true
    });
    /**
     * Ext.form.TextField DATO AUXILIAR REFERENCIA AL TIPO DE DENOMINACION
     */
    var txtCkcdt_observacion = new Ext.form.TextField({
        id:'txtCkcdt_observacion',
        name:'txtCkcdt_observacion',
        fieldLabel :'Observacion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_cierre_detalle
     */
    var btnGuardarCgg_kdx_cierre_detalle = new Ext.Button({
        id:'btnGuardarCgg_kdx_cierre_detalle',
        text:'Aceptar',
        iconCls:'iconAceptar',
        listeners:{
            click:function(){
                objDetalleDenominacion.CKDNM_CODIGO= cbxCkdnm_codigo.getValue();
                objDetalleDenominacion.CKDNM_DENOMINACION= cbxCkdnm_codigo.getRawValue();
                objDetalleDenominacion.CKCDT_CANTIDAD= numCkcdt_cantidad.getValue();
                objDetalleDenominacion.CKCDT_VALOR= numCkcdt_valor.isVisible()?numCkcdt_valor.getValue():spfCkcdt_valor.getValue();
                objDetalleDenominacion.CKCDT_TOTAL= numCkcdt_total.getValue();
                objDetalleDenominacion.CKCDT_OBSERVACION= txtCkcdt_observacion.getValue();
                tmpDatosConfirmados = true;
                winFrmCgg_kdx_cierre_detalle.close();
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_cierre_detalle.
     */
    var btnCancelarCgg_kdx_cierre_detalle = new Ext.Button({
        id:'btnCancelarCgg_kdx_cierre_detalle',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_cierre_detalle.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_cierre_detalle.
     */
    var btnCerrarCgg_kdx_cierre_detalle = new Ext.Button({
        id:'btnCerrarCgg_kdx_cierre_detalle',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                tmpDatosConfirmados = false;
                winFrmCgg_kdx_cierre_detalle.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_cierre_detalle.
     */
    var pnlCgg_kdx_cierre_detalle = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkcdt_codigo,cbxCkdnm_codigo,numCkcdt_cantidad,numCkcdt_valor,spfCkcdt_valor,numCkcdt_total,txtCkcdt_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_cierre_detalle.
     */
    var winFrmCgg_kdx_cierre_detalle = new Ext.Window({
        id:'winFrmCgg_kdx_cierre_detalle',
        title:tituloCgg_kdx_cierre_detalle,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_cierre_detalle,descCgg_kdx_cierre_detalle),
        items:[pnlCgg_kdx_cierre_detalle],
        bbar:[btnGuardarCgg_kdx_cierre_detalle,btnCancelarCgg_kdx_cierre_detalle,'->',btnCerrarCgg_kdx_cierre_detalle]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_cierre_detalle.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_cierre_detalleCtrls(inEstado){
        estado=!inEstado;
        txtCkcdt_codigo.setDisabled(estado);
        cbxCkdnm_codigo.setDisabled(estado);
        //txtCkdnm_nombre.setDisabled(estado);
        txtCkcrr_codigo_detalle.setDisabled(estado);
        numCkcdt_cantidad.setDisabled(estado);
        //numCkcdt_valor.setDisabled(estado);
        //numCkcdt_total.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_cierre_detalle.
     */
    function cargarCgg_kdx_cierre_detalleCtrls(){
        if(inRecordCgg_kdx_cierre_detalle){
            txtCkcdt_codigo.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_CODIGO'));
            // txtCkdnm_codigo.setValue(inRecordCgg_kdx_cierre_detalle.get('CKDNM_CODIGO'));
            // txtCkdnm_nombre.setValue(inRecordCgg_kdx_cierre_detalle.get('CKDNM_DENOMINACION'));
            txtCkcrr_codigo_detalle.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCRR_CODIGO'));
            numCkcdt_cantidad.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_CANTIDAD'));
            numCkcdt_total.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_TOTAL'));
            txtCkcdt_observacion.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_OBSERVACION'))
            if(inRecordCgg_kdx_cierre_detalle.get('CKDNM_VALOR_MONETARIO')>0)
            {
                numCkcdt_valor.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_VALOR'));
                numCkcdt_valor.show();
                spfCkcdt_valor.hide();
                txtCkcdt_observacion.hide();
            }
            else
            {
                spfCkcdt_valor.setValue(inRecordCgg_kdx_cierre_detalle.get('CKCDT_VALOR'));
                numCkcdt_valor.hide();
                spfCkcdt_valor.show();
                txtCkcdt_observacion.show();
            }



            isEdit = true;
            habilitarCgg_kdx_cierre_detalleCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_cierre_detalle.
     * @returns ventana winFrmCgg_kdx_cierre_detalle.
     * @base FrmCgg_kdx_cierre_detalle.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_cierre_detalle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_cierre_detalle.
     * @base FrmCgg_kdx_cierre_detalle.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_cierre_detalleCtrls();
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_cierre_detalle.
     * @base FrmCgg_kdx_cierre_detalle.prototype.getData
     */
    this.getData = function(){
        if (tmpDatosConfirmados)
            return objDetalleDenominacion;
        else
            return null;
    }
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_cierre_detalle desde una instancia.
 */
FrmCgg_kdx_cierre_detalle.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_cierre_detalle desde una instancia.
 */
FrmCgg_kdx_cierre_detalle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_cierre_detalle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_cierre_detalle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_cierre_detalle desde una instancia.
 */
FrmCgg_kdx_cierre_detalle.prototype.loadData = function(){
    this.loadData();
}/**
 * Funcion prototipo. Permite obtener los datos del detalle de cierre registrado desde una instancia.
 */
FrmCgg_kdx_cierre_detalle.prototype.getData = function(){
    this.getData();
}

