/**
 *Funcion. Crea el objeto FrmSeleccionSeguimiento para seleccion de seguimiento de fases a las que se despacha un seguimiento de un tramite.
 */
function DlgSeleccionSeguimiento(){

    var tituloDlgSeleccionSeguimiento = 'Selecci\u00F3n de seguimiento';
    var descDlgSeleccionSeguimiento = 'Este formulario le permite seleccionar el o los seguimientos a los que desea despachar el seguimiento de su tr\u00E1mite.';
    var crproCodigo = null;
    var crfasCodigo = null;
    var outResult = null;
    
    var btnNuevoDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnNuevoDlgSeleccionSeguimiento',
        text:'Aceptar',
        iconCls:'iconAceptar',
        handler:function (){
            var rFilaFase = grdCgg_res_faseDss.getSelectionModel().getSelected();
            if(rFilaFase !== null && rFilaFase !== undefined){
                outResult = '['+Ext.util.JSON.encode(rFilaFase.data)+']';
                winDlgSeleccionSeguimiento.close();
            }
        }
    });

    var btnCerrarDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnCerrarDlgSeleccionSeguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            outResult = null;
            winDlgSeleccionSeguimiento.close();
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
                                inCisla_codigo:null,
                                inCrtra_codigo:null,
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
			{name: 'CUSU_CODIGO'},
			{name: 'USUARIO'}
		]),
        baseParams:{
            inCrpro_codigo:null,
            inCisla_codigo:null,
            inCrtra_codigo:null,
            format:TypeFormat.JSON
        }
    });

    /**
     *Ext.form.ComboBox Combo para seleccion de fases.
     */
    /*var cbxCgg_res_faseDss = new Ext.form.ComboBox({
        id:'cbxCgg_res_faseDss',
        store:sCgg_res_faseDss,
        displayField:'CRFAS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        valueField:'CRFAS_CODIGO',
        anchor:'98%',        
        listeners:{
            select:function(inThis,inRecord,inIndex){
                crfasCodigo = inRecord.get('CRFAS_CODIGO');
                sCgg_res_fase_hijoDss.reload({
                    params:{
                        inCgg_crfas_codigo:inRecord.get('CRFAS_CODIGO'),
                        format:TypeFormat.JSON
                    }
                });                
            }
        }
    });*/

    var sCgg_res_fase_hijoDss =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectCGG_RES_FASE1"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRPRO_CODIGO'
            },

            {
                name:'CRETT_CODIGO'
            },

            {
                name:'CGG_CRETT_CODIGO'
            },

            {
                name:'CRSEC_CODIGO'
            },

            {
                name:'CGG_CRFAS_CODIGO'
            },

            {
                name:'CGG_CUSU_CODIGO'
            },

            {
                name:'CRFAS_NOMBRE'
            },

            {
                name:'CRFAS_ORDEN'
            },{
                name:'CRFAS_TAREA_REALIZA'
            },{
                name:'CRFAS_SUBE_ADJUNTO'
            },{
                name:'CRFAS_SUMILLA'
            },{
                name:'CUSU_CODIGO'
            }]),
        baseParams:{
            inCgg_crfas_codigo:null,
            format:TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_faseDss = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
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
            dataIndex:'USUARIO',
            header:'Usuario',
            width:150,
            sortable:true
        },/*{
            dataIndex:'CRFAS_SUMILLA',
            header:'Comentario/Sumilla',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield'
            }
        },*/{
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
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveEditorOnEnter: false
        }),
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
    
    var winDlgSeleccionSeguimiento = new Ext.Window({
        id:'winDlgSeleccionSeguimiento',
        title:tituloDlgSeleccionSeguimiento,
        tbar:getPanelTitulo(tituloDlgSeleccionSeguimiento,descDlgSeleccionSeguimiento),
        items:[pnlNorteDss,grdCgg_res_faseDss],
        width:600,
        minWidth:600,
        height:300,
        minHeight:400,
        maximizable:true,
        constrain:true,
        modal:true,
        layout:'border',        
        bbar:[btnNuevoDlgSeleccionSeguimiento,'->',btnCerrarDlgSeleccionSeguimiento]
    });

    /**
     * Funcion miembro que devuelve la ventana winDlgSeleccionSeguimiento.
     * @returns ventana winDlgSeleccionSeguimiento.
     * @base winDlgSeleccionSeguimiento.prototype.show
     */
    this.getWindow = function(){
        return winDlgSeleccionSeguimiento;
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

}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgSeleccionSeguimiento.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgSeleccionSeguimiento.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
DlgSeleccionSeguimiento.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionSeguimiento.prototype.getCrproCodigo = function(){
    this.getCrproCodigo();
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionSeguimiento.prototype.getCrfasCodigo = function(){
    this.getCrfasCodigo();
}

/**
 * Funcion prototipo. Seleciona el codigo de proceso seleccionado.
 */
DlgSeleccionSeguimiento.prototype.getCrfasSeguimiento = function(){
    this.getCrfasSeguimiento();
}


