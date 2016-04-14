/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_miembro_comite.
 * @param {String} INSENTENCIA_CGG_RES_MIEMBRO_COMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MIEMBRO_COMITE Registro de datos de la tabla Cgg_res_miembro_comite.
 * @constructor
 * @base FrmListadoCgg_res_miembro_comite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_miembro_comite(INSENTENCIA_CGG_RES_MIEMBRO_COMITE,INRECORD_CGG_RES_MIEMBRO_COMITE){
    var inSentenciaCgg_res_miembro_comite = INSENTENCIA_CGG_RES_MIEMBRO_COMITE;
    var inRecordCgg_res_miembro_comite=INRECORD_CGG_RES_MIEMBRO_COMITE;
    var urlCgg_res_miembro_comite=URL_WS+"Cgg_res_miembro_comite";
    var tituloCgg_res_miembro_comite='Miembro Comit\u00e9';
    var descCgg_res_miembro_comite='El formulario permite administrar la informaci\u00f3n del Miembro Comit\u00e9';
    var isEdit = false;
    var tmpCrcrg_codigo;
    var tmpCrdid_codigo;
    var tmpCusu_codigo;
    var tmpCargo_Comite;
    
    var tmpDuracion = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF44')).data.CGCNF_VALOR_NUMERICO;
	if(!tmpDuracion)
		tmpDuracion = 12;
		
    var pnlUsuario = new Ext.Panel({
        tbar:[{type:'button',id:'btnUsuario',text:'Usuario ',iconCls:'iconBuscar',handler:function(){
            var tmpUsuario = new Cgg_res_miembro_usuario();
            var objBusqueda = new DlgBusqueda(tmpUsuario.getStoreMiembroUsuario(), tmpUsuario.getColumnMiembroUsuario());
            objBusqueda.closeHandler(function () {
                tmpUsuario = objBusqueda.getSelectedRow();

                if (tmpUsuario) {
                    document.getElementById('divInfoUsuario').innerHTML =tmpInfoUsuario.apply(tmpUsuario.json);
                    tmpCusu_codigo=tmpUsuario.get('CUSU_CODIGO');
                    tmpCrdid_codigo=tmpUsuario.get('CRDID_CODIGO');
                }
            });
            objBusqueda.show();
        }}],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:140,
        html:'<div id="divInfoUsuario" style="padding:0px 0px 0px 0px;"></div>'
    });
    var tmpInfoUsuario = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td>' +
                    '<div class="tituloTemplate">Documento</div></td>' +
                    '<td><div class="itemTemplate">{DOCUMENTO}</div></td>' +
                    '<td><div class="tituloTemplate"> Num. Identificacion:</div></td>' +
                    '<td><div class="itemTemplate">{CRPER_NUM_DOC_IDENTIFIC}</div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate">Nombres</div></td>' +
                    '<td><div class="itemTemplate">{CRPER_NOMBRES}</div></td>' +
                    '<td><div class="tituloTemplate">Apellidos</div></td>' +
                    '<td><div class="itemTemplate">{APELLIDO}</div></td></tr>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate"> Fecha Nacimiento</div></td>' +
                    '<td><div class="itemTemplate">{[this.myDate(values.CRPER_FECHA_NACIMIENTO)]}</div>' +
                    '<td><div class="tituloTemplate">Genero</div></td>' +
                    '<td><div class="itemTemplate">{CRPER_GENERO}</div></td>' +
                    '<tr rowspan="0">' +
                    '<td><div class="tituloTemplate">Parroquia</div></td>' +
                    '<td><div class="itemTemplate">{PARROQUIA}</div></td>' +
                    '<td><div class="tituloTemplate">Canton</div></td>' +
                    '<td><div class="itemTemplate">{CANTON}</div></td></tr>' +

                    '</td></tr></table>',
    {
        // XTemplate configuration:
        disableFormats: true,
        // member functions:
        myDate: function(CRPER_FECHA_NACIMIENTO){
            return truncDate(CRPER_FECHA_NACIMIENTO);
        }
    }
            );


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrmbc_codigo = new Ext.form.TextField({
        id:'txtCrmbc_codigo',
        name:'txtCrmbc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrcrg_codigo = new Ext.form.TextField({
        id:'txtCrcrg_codigo',
        name:'txtCrcrg_codigo',
        fieldLabel :'Cargo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :true
    });
    
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_cargo_comite por un campo especifico.
     */
    var gsCgg_res_cargo_comite = new  Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_cargo_comite",
            method:"selectPageComite",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRCRG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRCRG_CODIGO'},
            {name:'CRCOM_CODIGO'},
            {name:'CRCRG_NOMBRE'},
			{name:'CRCRG_PRINCIPAL'},
            {name:'CRCRG_VOTO_DIRIMENTE'}
        ]),
        sortInfo:{field: 'CRCRG_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON", inCrcom_codigo:''}
    });
    //////////////////////////////////////////////////////////////////////////////
    /**
     * IDENTIFICATIVO UNICO DE REGSITRO
     */
    var btnCrcrg_codigoCgg_res_miembro_comite = new Ext.Button({
        id:'btnCrcrg_codigoCgg_res_miembro_comite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
				 var checkColumn = new Ext.grid.CheckColumn({
					header: 'Voto dirimente',
					dataIndex:'CRCRG_VOTO_DIRIMENTE',
					width: 80
				});
				var chkCrcrg_principal = new Ext.grid.CheckColumn(
				{dataIndex:'CRCRG_PRINCIPAL',header:'Principal',width:80,sortable:true});
				var cmCgg_res_cargo_comite = new Ext.grid.ColumnModel([
					{dataIndex:'CRCRG_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
					{dataIndex:'CRCOM_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
					{dataIndex:'CRCRG_NOMBRE',header:'Nombre',width:250,sortable:true},
					chkCrcrg_principal,
					checkColumn]);
                var objBusqueda = new DlgBusqueda(gsCgg_res_cargo_comite,cmCgg_res_cargo_comite);
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCrcrg_codigo=tmpRecord.get('CRCRG_CODIGO');
                        txtCrcrg_codigo.setValue(tmpRecord.get('CRCRG_NOMBRE'));}
                });
                objBusqueda.show();
            }}
    });



    /**
     * Ext.form.DateField FECHA DE DESIGNACION DEL MIEMBRO EN EL CARGO
     */
    var dtCrmbc_fecha_inicio_funciones = new Ext.form.DateField({
        id:'dtCrmbc_fecha_inicio_funciones',
        name:'dtCrmbc_fecha_inicio_funciones',
        fieldLabel :'Fecha inicio',
        allowBlank :false,
        format :'d/m/Y',
        value:CURRENT_DATE,
        listeners:{
        	change:function(obj,newValue,oldValue){
        		dtCrmbc_fecha_fin_funciones.setMinValue(newValue);
        		newValue = newValue.add(Date.MONTH, tmpDuracion);
                	dtCrmbc_fecha_fin_funciones.setValue(newValue);
            	},
            	select:function(obj,value){
            		dtCrmbc_fecha_fin_funciones.setMinValue(value);
        		value = value.add(Date.MONTH, tmpDuracion);
                	dtCrmbc_fecha_fin_funciones.setValue(value);
            	}
        }
    });
    /**
     * Ext.form.DateField FECHA DE CESE DE FUNCIONES
     */
    var dtCrmbc_fecha_fin_funciones = new Ext.form.DateField({
        id:'dtCrmbc_fecha_fin_funciones',
        name:'dtCrmbc_fecha_fin_funciones',
        fieldLabel :'Fecha fin',
        allowBlank :false,
        format :'d/m/Y',
        value:CURRENT_DATE.add(Date.MONTH, tmpDuracion) 
    });
    /**
     * Ext.form.TextField DIRECCION DOMICILIARIA PRINCIPAL
     */
    var txtCrmbc_direccion_principal = new Ext.form.TextField({
        id:'txtCrmbc_direccion_principal',
        name:'txtCrmbc_direccion_principal',
        fieldLabel :'Principal ',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField DIRECCION DOMICILIARIA ALTERNATIVA
     */
    var txtCrmbc_direccion_secundaria = new Ext.form.TextField({
        id:'txtCrmbc_direccion_secundaria',
        name:'txtCrmbc_direccion_secundaria',
        fieldLabel :'Secundaria',
        anchor:'98%',
        allowBlank :false
    });

    /**
     * Ext.form.Checkbox ESTADO QUE DEFINE SI ES DELEGADO TITULAR DE UNA INSTITUCION
     */
    var chkCrmbc_titular = new Ext.form.Checkbox({
        id:'chkCrmbc_titular',
        name:'chkCrmbc_titular',
        fieldLabel :'Titular',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DEFINE LA ACREDITACION PARA PARTICIPAR EN LA VOTACION
     */
    var chkCrmbc_autorizado = new Ext.form.Checkbox({
        id:'chkCrmbc_autorizado',
        name:'chkCrmbc_autorizado',
        fieldLabel :'Autorizado',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_miembro_comite
     */
    var btnGuardarCgg_res_miembro_comite = new Ext.Button({
        id:'btnGuardarCgg_res_miembro_comite',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_miembro_comite.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_miembro_comite(r){
                        winFrmCgg_res_miembro_comite.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_miembro_comite,
                                msg: 'La informaci\u00f3n de Miembro Comite ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_miembro_comite.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_miembro_comite,
                                msg: 'La informaci\u00f3n de Miembro Comite no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_miembro_comite.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrmbc_codigo',txtCrmbc_codigo.getValue());
                    param.add('inCrcrg_codigo',tmpCrcrg_codigo);
                    param.add('inCrdid_codigo',tmpCrdid_codigo);
                    param.add('inCusu_codigo',tmpCusu_codigo);
                    param.add('inCrmbc_fecha_inicio_funciones',dtCrmbc_fecha_inicio_funciones.getValue().format('c'));
                    param.add('inCrmbc_fecha_fin_funciones',dtCrmbc_fecha_fin_funciones.getValue().format('c'));
                    param.add('inCrmbc_titular',chkCrmbc_titular.getValue());
                    param.add('inCrmbc_autorizado',chkCrmbc_autorizado.getValue());
                    SOAPClient.invoke(urlCgg_res_miembro_comite,INSENTENCIA_CGG_RES_MIEMBRO_COMITE,param, true, CallBackCgg_res_miembro_comite);
                }catch(inErr){
                    winFrmCgg_res_miembro_comite.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_miembro_comite.
     /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_miembro_comite.
     */
    var btnCancelarCgg_res_miembro_comite = new Ext.Button({
        id:'btnCancelarCgg_res_miembro_comite',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_miembro_comite.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_miembro_comite.
     */
    var btnCerrarCgg_res_miembro_comite = new Ext.Button({
        id:'btnCerrarCgg_res_miembro_comite',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_miembro_comite.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_miembro_comite.
     */
    var pnlCgg_res_miembro_comite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.92,layout:'form',items:[txtCrcrg_codigo]},
                    {columnWidth:.08,layout:'form',items:[btnCrcrg_codigoCgg_res_miembro_comite]}]},

            dtCrmbc_fecha_inicio_funciones, dtCrmbc_fecha_fin_funciones,chkCrmbc_titular,chkCrmbc_autorizado]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_miembro_comite.
     */
    var winFrmCgg_res_miembro_comite = new Ext.Window({
        id:'winFrmCgg_res_miembro_comite',
        title:tituloCgg_res_miembro_comite,
        tbar:getPanelTitulo(tituloCgg_res_miembro_comite,descCgg_res_miembro_comite),
        items:[pnlUsuario,pnlCgg_res_miembro_comite],
        width:540,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_miembro_comite,btnCancelarCgg_res_miembro_comite,'->',btnCerrarCgg_res_miembro_comite]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_miembro_comite.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_miembro_comiteCtrls(inEstado){
        estado=!inEstado;
        txtCrmbc_codigo.setDisabled(estado);
        txtCrcrg_codigo.setDisabled(estado);
        dtCrmbc_fecha_inicio_funciones.setDisabled(estado);
        dtCrmbc_fecha_fin_funciones.setDisabled(estado);
        chkCrmbc_titular.setDisabled(estado);
        chkCrmbc_autorizado.setDisabled(estado);
    }

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_miembro_comite.
     */
    function cargarCgg_res_miembro_comiteCtrls(){
        if(inRecordCgg_res_miembro_comite){
            txtCrmbc_codigo.setValue(inRecordCgg_res_miembro_comite.get('CRMBC_CODIGO'));
            tmpCrcrg_codigo=inRecordCgg_res_miembro_comite.get('CRCRG_CODIGO');
            txtCrcrg_codigo.setValue(inRecordCgg_res_miembro_comite.get('CARGO'))
            dtCrmbc_fecha_inicio_funciones.setValue(truncDate(inRecordCgg_res_miembro_comite.get('CRMBC_FECHA_INICIO_FUNCIONES')));
            dtCrmbc_fecha_fin_funciones.setValue(truncDate(inRecordCgg_res_miembro_comite.get('CRMBC_FECHA_FIN_FUNCIONES')));
            chkCrmbc_titular.setValue(inRecordCgg_res_miembro_comite.get('CRMBC_TITULAR'));
            chkCrmbc_autorizado.setValue(inRecordCgg_res_miembro_comite.get('CRMBC_AUTORIZADO'));
            isEdit = true;
            habilitarCgg_res_miembro_comiteCtrls(true);

        }}

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_miembro_comite.
     * @returns ventana winFrmCgg_res_miembro_comite.
     * @base FrmCgg_res_miembro_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_miembro_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_miembro_comite.
     * @base FrmCgg_res_miembro_comite.prototype.loadData
     */
    this.loadData = function(inDatosMiembro){
        cargarCgg_res_miembro_comiteCtrls();
        document.getElementById('divInfoUsuario').innerHTML =tmpInfoUsuario.apply(inDatosMiembro.json);
        tmpCrcrg_codigo=inDatosMiembro.get('CRCRG_CODIGO');
        tmpCrdid_codigo=inDatosMiembro.get('CRDID_CODIGO');
        tmpCusu_codigo=inDatosMiembro.get('CUSU_CODIGO');
    }
    /**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCarComite(inCrcom_codigo){
        gsCgg_res_cargo_comite.baseParams.inCrcom_codigo= inCrcom_codigo;
    }

    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.setLoadCarComite = function(inCrcom_codigo){
        cargarCarComite(inCrcom_codigo);
    }


}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_miembro_comite desde una instancia.
 */
FrmCgg_res_miembro_comite.prototype.show = function(){
    this.getWindow().show();

}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_miembro_comite desde una instancia.
 */
FrmCgg_res_miembro_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_miembro_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_miembro_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_miembro_comite desde una instancia.
 */
FrmCgg_res_miembro_comite.prototype.loadData = function(){
    this.loadData();
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_miembro_comite desde una instancia.
 */
FrmCgg_res_miembro_comite.prototype.setLoadCarComite = function(inCrcom_codigo){
    this.setLoadCarComite(inCrcom_codigo);
}
