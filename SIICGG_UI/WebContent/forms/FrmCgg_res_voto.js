/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_voto.
 * @param {String} INSENTENCIA_CGG_RES_VOTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_VOTO Registro de datos de la tabla Cgg_res_voto.
 * @constructor
 * @base FrmListadoCgg_res_voto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_voto(INSENTENCIA_CGG_RES_VOTO,INRECORD_CGG_RES_VOTO){
    var inSentenciaCgg_res_voto = INSENTENCIA_CGG_RES_VOTO;
    var inRecordCgg_res_voto=INRECORD_CGG_RES_VOTO;
    var urlCgg_res_voto=URL_WS+"Cgg_res_voto";
    var tituloCgg_res_voto='Voto';
    var descCgg_res_voto='El formulario permite administrar informaci\u00f3n del Voto';
    var isEdit = false;
    var Crres_codigoResolucion;
    var lisResolucion ;
    var tmpAprobacion;
    var tmpReprobados
    var tmpAbstencion;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE VOTO
     */
    var txtCrvto_codigo = new Ext.form.TextField({
        id:'txtCrvto_codigo',
        name:'txtCrvto_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCION
     */
    var txtCrres_codigo = new Ext.form.TextField({
        id:'txtCrres_codigo',
        name:'txtCrres_codigo',
        fieldLabel :' Resoluci\u00f3n',
        anchor:'98%',
        hidden:true,
        hideLabel:true,

        readOnly:'true'
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SESION MIEMBRO
     */
    var txtCrsmb_codigo = new Ext.form.TextField({
        id:'txtCrsmb_codigo',
        name:'txtCrsmb_codigo',
        fieldLabel :'Miembro',
        hidden:true,
        hideLabel:true,
        anchor:'98%',
        readOnly:'true'
    });

    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA LA DECISION APLICADA AL VOTO
     0 - APROBADO
     1 - NEGADO
     2 - ABSTENCION
     */
    var dtVotacion =[
        [0,'APROBADO'],[1,'NEGADO'],[2,'ABSTENCI\u00d3N']
    ];
    var stVotacion = new Ext.data.ArrayStore({
        fields:['id','votacion'],
        data:dtVotacion
    });
    var cbxVotacion = new Ext.form.ComboBox({
        id:'cbxVotacion',
        name:'cbxVotacion',
        store: dtVotacion,
        fieldLabel :'Votaci\u00f3n',
        width:'150',
        displayField: 'votacion',
        valueField: 'id',
        mode:'local',
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    /**
     * Ext.form.TextArea OBSERVACION DE LOS MIEMBROS EN LA VOTACION
     */
    var txtCrvto_observacion = new Ext.form.TextArea({
        id:'txtCrvto_observacion',
        name:'txtCrvto_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_voto
     */
    var btnGuardarCgg_res_voto = new Ext.Button({
        id:'btnGuardarCgg_res_voto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_voto.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_voto(r){
                        winFrmCgg_res_voto.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_voto,
                                msg: 'La informaci\u00f3n del Voto ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_voto.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_voto,
                                msg: 'La informaci\u00f3n del Voto no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_voto.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrvto_codigo',txtCrvto_codigo.getValue());
                    param.add('inLisResolucion',lisResolucion);
                    param.add('inCrvto_votacion',cbxVotacion.getValue());
                    param.add('inCrvto_observacion',txtCrvto_observacion.getValue());
                    SOAPClient.invoke(urlCgg_res_voto,INSENTENCIA_CGG_RES_VOTO,param, true, CallBackCgg_res_voto);
                }catch(inErr){
                    winFrmCgg_res_voto.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_voto.
     */
    var btnCancelarCgg_res_voto = new Ext.Button({
        id:'btnCancelarCgg_res_voto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_voto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_voto.
     */
    var btnCerrarCgg_res_voto = new Ext.Button({
        id:'btnCerrarCgg_res_voto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_voto.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_voto.
     */
    var pnlCgg_res_voto = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrvto_codigo,txtCrres_codigo,txtCrsmb_codigo,cbxVotacion,txtCrvto_observacion]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_voto.
     */
    var winFrmCgg_res_voto = new Ext.Window({
        id:'winFrmCgg_res_voto',
        title:tituloCgg_res_voto,
        tbar:getPanelTitulo(tituloCgg_res_voto,descCgg_res_voto),
        items:[pnlCgg_res_voto],
        width:400,
        minWidth:400,
        modal:true,
        maximizable:true,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_voto,btnCancelarCgg_res_voto,'->',btnCerrarCgg_res_voto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_voto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_votoCtrls(inEstado){
        estado=!inEstado;
        txtCrvto_codigo.setDisabled(estado);
        txtCrres_codigo.setDisabled(estado);
        txtCrsmb_codigo.setDisabled(estado);
        cbxVotacion.setDisabled(estado);
        txtCrvto_observacion.setDisabled(estado);
    }

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_voto.
     * @returns ventana winFrmCgg_res_voto.
     * @base FrmCgg_res_voto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_voto;
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_voto
     */
    this.loadResolucion = function(tmpResoluciones){
        lisResolucion='[';
        for(i = 0; i < tmpResoluciones.length; i++){
            if(i>0){
                lisResolucion=lisResolucion+','
            }
            lisResolucion = lisResolucion + '{CRRES_CODIGO:"'+tmpResoluciones[i].get('CRRES_CODIGO')+ '",CRTRA_CODIGO:"'+tmpResoluciones[i].get('CRTRA_CODIGO')+'",CRSMB_CODIGO:"'+tmpResoluciones[i].get('CRSMB_CODIGO')+'"}';

        }
        lisResolucion=lisResolucion+']';
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_voto desde una instancia.
 */
FrmCgg_res_voto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_voto desde una instancia.
 */
FrmCgg_res_voto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_voto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_voto desde una instancia.
 */
FrmCgg_res_voto.prototype.loadData = function(){
    this.loadData();
}
FrmCgg_res_voto.prototype.loadResolucion = function(tmpResoluciones){
    this.loadResolucion(tmpResoluciones);
}
FrmCgg_res_voto.prototype.loadMiembro = function(inMiembro){
    this.loadMiembro(inMiembro);
}
