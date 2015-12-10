/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_asesor.
 * @param {String} IN_SENTENCIA_CGG_JUR_ASESOR Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_ASESOR Registro de datos de la tabla Cgg_jur_asesor.
 * @constructor
 * @base FrmListadoCgg_jur_asesor
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_asesor(IN_SENTENCIA_CGG_JUR_ASESOR,IN_RECORD_CGG_JUR_ASESOR){
    var inSentenciaCgg_jur_asesor = IN_SENTENCIA_CGG_JUR_ASESOR;
    var inRecordCgg_jur_asesor=IN_RECORD_CGG_JUR_ASESOR;
    var urlCgg_jur_asesor=URL_WS+"Cgg_jur_asesor";
    var tituloCgg_jur_asesor='Asesor proceso judicial';
    var descCgg_jur_asesor='El formulario permite administrar la informaci\u00f3n del Asesor proceso judicial';
    var isEdit = false;
    var tmpCusu_codigo = null;
    var tmpCjpju_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASESOR DE PROCESO JURIDICO
     */
    var txtCjase_codigo = new Ext.form.TextField({
        id:'txtCjase_codigo',
        name:'txtCjase_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * new Ext.Panel PANEL PARA LA VISUALIZACION LOS USUARIOS
     */
    var pnlAsesor = new Ext.Panel({        
        tbar:[{
            type:'button',
            id:'btnAsesor',
            text:'Asesor ',
            iconCls:'iconBuscar',
            handler:function(){
                var tmpAsesor = new Cgg_res_miembro_usuario();
                var objBusqueda = new DlgBusqueda(tmpAsesor.getStoreMiembroUsuario(), tmpAsesor.getColumnMiembroUsuario());
                objBusqueda.closeHandler(function () {
                    tmpAsesor = objBusqueda.getSelectedRow();

                    if (tmpAsesor) {
                        document.getElementById('divInfoAsesor').innerHTML =tmpInfoAsesor.apply(tmpAsesor.json);
                        tmpCusu_codigo=tmpAsesor.get('CUSU_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }],                
        height:180,
        html:'<div id="divInfoAsesor" style="padding:0px 0px 0px 0px;"></div>'
    });
    /**
     * new Ext.XTemplate XTEMPLATE PARA LA VISUALIZACION DE LA INFORMACION  DE LOS USUARIOS EN EL PANEL pnlAsesor
     */
    var tmpInfoAsesor = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="0">' +
        '<tr rowspan="0"><td>' +
        '<div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Documento</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{DOCUMENTO}</span></div></td>' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Num. Identificaci\u00f3n:</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NUM_DOC_IDENTIFIC}</span></div></td></tr>' +
        '<tr rowspan="0">' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_NOMBRES}</span></div></td>' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Apellidos</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{APELLIDO}</span></div></td></tr>' +
        '<tr rowspan="0">' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif"> Fecha Nacimiento</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</span></div>' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">G\u00e9nero</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CRPER_GENERO}</span></div></td>' +
        '<tr rowspan="0">' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Parroquia</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{PARROQUIA}</span></div></td>' +
        '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Cant\u00f3n</font></div></td>' +
        '<td><div class="itemTemplate"><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CANTON}</span></div></td></tr>' +

        '</td></tr></table>',
        {            
            disableFormats: true,            
            myDate: function(CRPER_FECHA_NACIMIENTO){
                return truncDate(CRPER_FECHA_NACIMIENTO);
            }
        }
        );

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
     */
    var txtCjpju_codigo = new Ext.form.TextField({
        id:'txtCjpju_codigo',
        name:'txtCjpju_codigo',
        fieldLabel :'Proceso Judicial',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
     */
    var btnCjpju_codigoCgg_jur_asesor = new Ext.Button({
        id:'btnCjpju_codigoCgg_jur_asesor',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_jur_proceso_judicial = new FrmListadoCgg_jur_proceso_judicial();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_jur_proceso_judicial.getStore(),tmpFLCgg_jur_proceso_judicial.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCjpju_codigo=tmpRecord.get('CJPJU_CODIGO');
                        txtCjpju_codigo.setValue(tmpRecord.get('CJPJU_NUMERO'));
                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Ext.form.NumberField ESTADO QUE DETERMINA SI UN ENCARGADO SE HALLA ACTIVO SOBRE UN PROCESO
     0 - NO ACTIVO
     1 - ACTIVO
     2 - OTRO
     */
    var cbxCjase_activo = new Ext.form.ComboBox({
        id:'cbxCjase_activo',
        name:'cbxCjase_activo',
        store: dsEstadoAsesor,
        fieldLabel :'Estado',
        anchor:'75%',
        mode:'local',
        editable:false,
        triggerAction:'all',
        value:0
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_asesor
     */
    var btnGuardarCgg_jur_asesor = new Ext.Button({
        id:'btnGuardarCgg_jur_asesor',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (validarAsesor()==false){
                    return;
                }
                try{
                    function CallBackCgg_jur_asesor(r){
                        winFrmCgg_jur_asesor.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_asesor,
                                msg: 'La informaci\u00f3n del asesor ha sido almacenado.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_jur_asesor.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_asesor,
                                msg: 'La informaci\u00f3n del asesor no ha podido ser almacenado. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_asesor.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCjase_codigo',txtCjase_codigo.getValue());
                    param.add('inCusu_codigo',tmpCusu_codigo);
                    param.add('inCjpju_codigo',tmpCjpju_codigo);
                    param.add('inCjase_activo',cbxCjase_activo.getValue());
                    SOAPClient.invoke(urlCgg_jur_asesor,IN_SENTENCIA_CGG_JUR_ASESOR,param, true, CallBackCgg_jur_asesor);
                }catch(inErr){
                    winFrmCgg_jur_asesor.getEl().unmask();
                }
            }
        }
    });

    function validarAsesor(){
        if(tmpCusu_codigo==null){

            Ext.Msg.show({
                title:tituloCgg_jur_asesor,
                msg: 'Seleccione un asesor, por favor.',
                fn:function(){
                  Ext.getCmp().focus();
                },
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });            
            
            return false;

        }else if(txtCjpju_codigo.getValue() == null || txtCjpju_codigo.getValue().trim().length == 0 ){
            txtCjpju_codigo.markInvalid('Estableza el proceso judicial, por favor.');
            return false;
        }
    }
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_asesor.
     */
    var btnCancelarCgg_jur_asesor = new Ext.Button({
        id:'btnCancelarCgg_jur_asesor',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_asesor.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_asesor.
     */
    var btnCerrarCgg_jur_asesor = new Ext.Button({
        id:'btnCerrarCgg_jur_asesor',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_asesor.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_asesor.
     */
    var pnlCgg_jur_asesor = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCjase_codigo,
        {
            xtype:'panel',
            layout:'column',
            items:[

            {
                columnWidth:.92,
                layout:'form',
                items:[txtCjpju_codigo]
            },

            {
                columnWidth:.08,
                layout:'form',
                items:[btnCjpju_codigoCgg_jur_asesor]
            }]
        },
        cbxCjase_activo]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_asesor.
     */
    var winFrmCgg_jur_asesor = new Ext.Window({
        id:'winFrmCgg_jur_asesor',
        title:tituloCgg_jur_asesor,
        iconCls:'iconAplicacion',
        width:500,
        minWidth:400,
        maximizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_jur_asesor,descCgg_jur_asesor),
        items:[pnlAsesor,pnlCgg_jur_asesor],
        bbar:[btnGuardarCgg_jur_asesor,btnCancelarCgg_jur_asesor,'->',btnCerrarCgg_jur_asesor]

    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_asesor.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_asesor.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_asesorCtrls(inEstado){
        var estado=!inEstado;
        txtCjase_codigo.setDisabled(estado);
        txtCjpju_codigo.setDisabled(estado);
        cbxCjase_activo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_asesor.
     */
    function cargarCgg_jur_asesorCtrls(){
        if(inRecordCgg_jur_asesor){
            txtCjase_codigo.setValue(inRecordCgg_jur_asesor.get('CJASE_CODIGO'));
            tmpCjpju_codigo=inRecordCgg_jur_asesor.get('CJPJU_CODIGO');
            txtCjpju_codigo.setValue(inRecordCgg_jur_asesor.get('NUMERO'));
            cbxCjase_activo.setValue(inRecordCgg_jur_asesor.get('CJASE_ACTIVO'));
            isEdit = true;
            habilitarCgg_jur_asesorCtrls(true);

        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_asesor.
     * @returns ventana winFrmCgg_jur_asesor.
     * @base FrmCgg_jur_asesor.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_asesor;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_asesor.
     * @base FrmCgg_jur_asesor.prototype.loadData
     */
    this.loadData = function(inDatosAsesor){
        cargarCgg_jur_asesorCtrls();
        document.getElementById('divInfoAsesor').innerHTML =tmpInfoAsesor.apply(inDatosAsesor.json);
        tmpCusu_codigo=inDatosAsesor.get('CUSU_CODIGO');
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_asesor desde una instancia.
 */
FrmCgg_jur_asesor.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_asesor desde una instancia.
 */
FrmCgg_jur_asesor.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_asesor,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_asesor.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_asesor desde una instancia.
 */
FrmCgg_jur_asesor.prototype.loadData = function(){
    this.loadData();
}
