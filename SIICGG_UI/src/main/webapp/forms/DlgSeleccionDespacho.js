/**
 *Funcion. Crea el objeto FrmSeleccionSeguimiento para seleccion de seguimiento de fases a las que se despacha un seguimiento de un tramite.
 *@param inCrpro_codigo Codigo de proceso precargado.
 */
function DlgSeleccionDespacho(inCrpro_codigo){

    var tituloDlgSeleccionDespacho = 'Selecci\u00F3n de seguimiento';
    var descDlgSeleccionDespacho = 'Este formulario le permite seleccionar el o los seguimientos a los que desea despachar el seguimiento de su tr\u00E1mite.';
    var crproCodigo = null;
    var crfasCodigo = null;
    var crfasSiguiente = null;
    var outResult = null;    
    
    var btnNuevoDlgSeleccionDespacho = new Ext.Button({
        id:'btnNuevoDlgSeleccionDespacho',
        text:'Aceptar',
        iconCls:'iconAceptar',
        handler:function (){
            var rFilaFase = cbsmDespacho.getSelected();
            if(rFilaFase !== null && rFilaFase !== undefined && validarSeguimiento(rFilaFase)){
                outResult = '['+Ext.util.JSON.encode(rFilaFase.data)+']';
                winDlgSeleccionDespacho.close();
            }
        }
    });

    var btnCerrarDlgSeleccionDespacho = new Ext.Button({
        id:'btnCerrarDlgSeleccionDespacho',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            outResult = null;
            winDlgSeleccionDespacho.close();
        }
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigoDss = new Ext.form.TextField({
        id: 'txtCrpro_codigoDss',
        name: 'txtCrpro_codigoDss',
        fieldLabel: 'Proceso',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true'        
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoDss = new Ext.Button({
        id: 'btnCrpro_codigoDss',
        iconCls: 'iconBuscar',
        disabled:true,
        listeners: {
            click: function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(), tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrpro_codigoDss.setValue(tmpRecord.get('CRPRO_NOMBRE'));
                        crproCodigo= tmpRecord.get('CRPRO_CODIGO');
                        
                        sCgg_res_faseDss.reload({
                            params: {
                                inCrpro_codigo: tmpRecord.get('CRPRO_CODIGO'),
                                inCisla_codigo: new UserSession().getUserData().CISLA_CODIGO,
                                format: TypeFormat.JSON
                            }
                        });
                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase por un campo especifico.
     */
    var sCgg_res_faseDss =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectCGG_RES_PROCESO"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {name: 'CRFAS_CODIGO'},
			{name: 'CRPRO_CODIGO'},
			{name: 'CRETT_CODIGO'},
			{name: 'CGG_CRETT_CODIGO'},
			{name: 'CRSEC_CODIGO'},
			{name: 'CGG_CRFAS_CODIGO'},
			{name: 'CGG_CUSU_CODIGO'},
			{name: 'CRFAS_NOMBRE'},
			{name: 'CRFAS_ORDEN'},
			{name: 'CRFAS_TAREA_REALIZA'},
			{name: 'CRFAS_SUBE_ADJUNTO'},
			{name: 'CRFAS_SUMILLA'},
			{name: 'CUSU_CODIGO'}
		]),
        baseParams:{
            inCrpro_codigo:null,
            inCisla_codigo:null,
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords){
                inThis.each(function(inRecord){
                    if(inRecord.get('CRFAS_CODIGO')==crfasSiguiente.CRFAS_CODIGO){
                        var tmpRegistro = [];
                        tmpRegistro[0]=inRecord;
                        cbsmDespacho.selectRecords(tmpRegistro, false);
                        cbsmDespacho.lock();
                    }
                });
            }
        }
    });
    
    var sCgg_res_fase_hijoDss =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectCGG_RES_FASE1"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {name:'CRFAS_CODIGO'},
            {name:'CRPRO_CODIGO'},
            {name:'CRETT_CODIGO'},
            {name:'CGG_CRETT_CODIGO'},
            {name:'CRSEC_CODIGO'},
            {name:'CGG_CRFAS_CODIGO'},
            {name:'CGG_CUSU_CODIGO'},
            {name:'CRFAS_NOMBRE'},
            {name:'CRFAS_ORDEN'},
			{name:'CRFAS_TAREA_REALIZA'},
			{name:'CRFAS_SUBE_ADJUNTO'},
			{name:'CRFAS_SUMILLA'},
			{name:'CUSU_CODIGO'}
		]),
        baseParams:{
            inCgg_crfas_codigo:null,
            format:TypeFormat.JSON
        }
    });


    var cbsmDespacho = new Ext.grid.CheckboxSelectionModel({
        singleSelect:true,
        moveEditorOnEnter: false,
        renderer: function(value, metaData, record){
            // Hide checkbox for certain records
            if(record.get('CRFAS_CODIGO') !== crfasSiguiente.CRFAS_CODIGO){
                return;
            }
            return Ext.grid.CheckboxSelectionModel.prototype.renderer.apply(this, arguments);
        }
    //        listeners: {
    //            beforerowselect: function(selModel, rowIndex, keepExisting, record){
    //                // Don't allow selection for certain records
    //                if(record.get('somefield') == somevalue){
    //                    return false;
    //                }
    //            }
    //        }
    });


/**
     * Ext.data.Store. Almacenamiento de los usuarios de una fase por su isla.
     */
    var sCgg_res_fase_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase_usuario",
            method:"selectUsuariosFase"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        }
        ]),
        baseParams:{
            inCrfas_codigo:'',
            inCisla_codigo:'',
            format:TypeFormat.JSON
        }
    });

    var cbxCUSU_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCUSU_CODIGOEditor',
        store: sCgg_res_fase_usuario,
        displayField:'CRPER_NOMBRES',
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRPER_NOMBRES}" class="x-combo-list-item">{CRPER_NOMBRES}</div></tpl>',
        valueField:'CUSU_CODIGO'
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_faseDss = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        cbsmDespacho,
        {
            dataIndex:'CRFAS_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRPRO_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRETT_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CRETT_CODIGO',
            header:'Crett codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRSEC_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CRFAS_CODIGO',
            header:'Crfas codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CGG_CUSU_CODIGO',
            header:'Cusu codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRFAS_NOMBRE',
            header:'Nombre',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRFAS_ORDEN',
            header:'Orden',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRFAS_SUBE_ADJUNTO',
            header:'Sube adjunto',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },{
            dataIndex:'CUSU_CODIGO',
            header:'Usuario',
            width:150,
            sortable:true,
            editor:cbxCUSU_CODIGOEditor,
            renderer:function(inCUSU_CODIGO){
                var scpUsuario = new SOAPClientParameters();
                scpUsuario.add('inCusu_codigo',Ext.util.Format.undef(inCUSU_CODIGO));
                scpUsuario.add('format',TypeFormat.JSON);
                var tmpCusuUsuario = SOAPClient.invoke(URL_WS+"Cgg_usuario", 'selectUsuarioPersona', scpUsuario, false, null);
                try{
                    tmpCusuUsuario = Ext.util.JSON.decode(tmpCusuUsuario);
                    tmpCusuUsuario= tmpCusuUsuario[0];
                    return tmpCusuUsuario.CRPER_NOMBRES+' '+tmpCusuUsuario.CRPER_APELLIDO_PATERNO+' '+tmpCusuUsuario.CRPER_APELLIDO_MATERNO;
                }catch(inErr){
                    return NO_DATA_MESSAGE;
                }
            }
        },{
            dataIndex:'CRFAS_SUMILLA',
            header:'Comentario/Sumilla',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield'
            }
        },{
            dataIndex:'CRFAS_TAREA_REALIZA',
            header:'Actividad',
            width:150,
            sortable:true
        }]);

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_faseDss = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_faseDss,
        store:sCgg_res_faseDss,
        region:'center',
        frame:true,
        sm:cbsmDespacho,
        tbar:['Destinatario/s'],
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        clicksToEdit:1,
        listeners:{            
            afteredit:function(inObject){
                if(inObject.value.trim().length ==0){
                    inObject.record.set('CRFAS_SUMILLA','Atender, por favor.');
                }
            }            
        }
    });

    var pnlNorteDss = new Ext.Panel({
        id:'pnlNorteDss',
        layout:'column',
        region:'north',
        height:35,
        minHeight:35,
        frame:true,
        anchor:'100%',
        items:[{
            columnWidth:.95,
            layout: 'form',
            labelWidth:90,
            items: [txtCrpro_codigoDss]
        }, {
            columnWidth:.05,
            layout: 'form',
            style:{
                marginleft:'5px'
            },
            items: [btnCrpro_codigoDss]
        }/*,{
            columnWidth:.5,
            anchor:'100%',
            items:[cbxCgg_res_faseDss]
        }*/]
    });
    
    var winDlgSeleccionDespacho = new Ext.Window({
        id:'winDlgSeleccionDespacho',
        title:tituloDlgSeleccionDespacho,
        tbar:getPanelTitulo(tituloDlgSeleccionDespacho,descDlgSeleccionDespacho),
        items:[pnlNorteDss,grdCgg_res_faseDss],
        width:600,
        minWidth:600,
        height:300,
        minHeight:400,
        maximizable:true,
        constrain:true,
        modal:true,
        layout:'border',        
        bbar:[btnNuevoDlgSeleccionDespacho,'->',btnCerrarDlgSeleccionDespacho]        
    });

    function cargarDatos(){
        if(inCrpro_codigo !== null && inCrpro_codigo !== undefined){            
            var cislaCodigo =   new UserSession().getUserData().CISLA_CODIGO;

            var scpProceso = new SOAPClientParameters();
            scpProceso.add('inCrpro_codigo', inCrpro_codigo);
            scpProceso.add('format', TypeFormat.JSON);
            var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
            try {
                tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);

                txtCrpro_codigoDss.setValue(tmpCrproRegistro[0].CRPRO_NOMBRE);
                crproCodigo= tmpCrproRegistro[0].CRPRO_CODIGO;

                sCgg_res_faseDss.reload({
                    params: {
                        inCrpro_codigo:crproCodigo,
                        inCisla_codigo:cislaCodigo,
                        format: TypeFormat.JSON
                    }
                });
            }catch (inErr) {
                txtCrpro_codigoDss.setValue('');
                crproCodigo= null;
            }
            
            var scpFaseSiguiente = new SOAPClientParameters();
            scpFaseSiguiente.add('inCrfas_codigo', crfasCodigo);
            scpFaseSiguiente.add('inCisla_codigo', cislaCodigo);
            scpFaseSiguiente.add('format', TypeFormat.JSON);
            var tmpFaseSiguiente = SOAPClient.invoke(URL_WS+"Cgg_res_fase", 'selectFaseSiguiente', scpFaseSiguiente, false, null);
            try{
                crfasSiguiente = Ext.util.JSON.decode(tmpFaseSiguiente);
                crfasSiguiente = crfasSiguiente[0];

                sCgg_res_fase_usuario.reload({
                    params:{
                        inCrfas_codigo:crfasSiguiente.CRFAS_CODIGO,
                        inCisla_codigo:cislaCodigo,
                        format:TypeFormat.JSON
                    }
                });

            }catch(inErr){
                crfasSiguiente = null;
            }
        }
    }

    /**
     *Funcion. Valida si la fase seleccionada es diferente a la establecida por el metodo setCrfas_codigo.
     *@param inRecordFase Record de la fase seleccionada del grid.
     *@return True/False.
     */
    function validarSeguimiento(inRecordFase){
        var tmpFlag = true;
        if(crfasCodigo !== null && crfasCodigo !== undefined){        
            if(inRecordFase.get('CRFAS_CODIGO')==crfasCodigo){
                Ext.Msg.show({
                    title:tituloDlgSeleccionDespacho,
                    msg:'Seleccion una fase diferente a la suya, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                tmpFlag = false;
            }else{
                tmpFlag = true;
            }
        }else{
            tmpFlag = true;
        }
        return tmpFlag;
    }

    /**
     * Funcion miembro que devuelve la ventana winDlgSeleccionDespacho.
     * @returns ventana winDlgSeleccionDespacho.
     * @base winDlgSeleccionDespacho.prototype.show
     */
    this.getWindow = function(){
        return winDlgSeleccionDespacho;
    }

    this.getCrproCodigo = function(){
        return crproCodigo;
    }

    this.getCrfasCodigo = function(){
        return crfasCodigo;
    }

    this.getCrfasSeguimiento = function(){
        return outResult;
    }

    this.setCrfasCodigo = function(inCrfasCodigo){
        crfasCodigo = inCrfasCodigo;
    }

    this.loadData = cargarDatos;

}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgSeleccionDespacho.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgSeleccionDespacho.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
DlgSeleccionDespacho.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionDespacho.prototype.getCrproCodigo = function(){
    this.getCrproCodigo();
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionDespacho.prototype.getCrfasCodigo = function(){
    this.getCrfasCodigo();
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionDespacho.prototype.getCrfasSeguimiento = function(){
    this.getCrfasSeguimiento();
}

DlgSeleccionDespacho.prototype.setCrfasCodigo = function(inCrfasCodigo){
    this.setCrfasCodigo(inCrfasCodigo);
}

DlgSeleccionDespacho.prototype.loadData = function(){
    return this.loadData;
}
