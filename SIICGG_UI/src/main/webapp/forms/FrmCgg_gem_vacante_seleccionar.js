/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_vacante_seleccionar.
 * @param {String} IN_ESTADO_Cgg_gem_vacante_seleccionar Estado (aceptar/rechazar) para el tratamiento de la informacion.
 * @param {Ext.data.Record} inRecordVacante Registro de datos de la tabla Cgg_gem_vacante_seleccionar.
 * @constructor
 * @base FrmListadoCgg_gem_vacante_seleccionar
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_vacante_seleccionar(inRecordVacante) {
    var urlCgg_gem_vacante_seleccionar = URL_WS + "Cgg_gem_vacante";
    var tituloCgg_gem_vacante_seleccionar = 'Seleccionar candidato escogido';
    var descCgg_gem_vacante_seleccionar = 'El formulario permite registrar informaci\u00f3n del personal id\u00f3neo para la vacante.';
    var flagAceptar=false;
	
	/**
	 * Ext.form.DateField FECHA DE PUBLICACION DEL COMUNICADO RADIAL
	 */
	var dtCgvcn_fecha_salida = new Ext.form.DateField({
		id: 'dtCgvcn_fecha_salida',
		name: 'dtCgvcn_fecha_salida',
		fieldLabel: 'Fecha Salida',
		format: 'd/m/Y',
		value: new Date()
	});	
	/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnSeleccionarCgg_gem_candidato = new Ext.Button({
        id: 'btnSeleccionarCgg_gem_candidato',
        text: 'Contratar',
		toolTip: 'Selecciona al personal para el puesto vacante',
        iconCls: 'iconOk',		
		hidden:true,
        listeners: {
            click: function () {
				Ext.Msg.prompt(tituloCgg_gem_vacante_seleccionar,
					'Por favor ingrese un detalle u observaci\u00f3n de ser necesario,<br> por el cual ha sido <b>seleccionado</b> para el puesto.<br>',
					function(btn,text){ if (btn=="ok")fnSeleccionarParaVacante (3,text);},null,true
				);
            }
        }
    });
	
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnRechazarCgg_gem_candidato = new Ext.Button({
        id: 'btnRechazarCgg_gem_candidato',
        text: 'Rechazar',
		toolTip:'Rechaza al personal para el puesto vacante',
        iconCls: 'iconCancelar',		
		hidden:true,
        listeners: {
            click: function () {
				Ext.Msg.prompt(tituloCgg_gem_vacante_seleccionar,
					'Por favor ingrese un detalle u observaci\u00f3n de ser necesario,<br> por el cual ha sido <b>rechazado</b> para el puesto.<br>',
					function(btn,text){ if (btn=="ok")fnSeleccionarParaVacante (4,text);},null,true
				);
            }
        }
    });
	 /**
     * Ext.Button Boton que permite registrar la salida de su puesto de empleo contratado.
     */
    var btnSalidaCgg_gem_candidato = new Ext.Button({
        id: 'btnRechazarCgg_gem_candidato',
        text: 'Registrar Salida',
		toolTip:'Rechaza al personal para el puesto vacante',
        iconCls: '',
        listeners: {
            click: function () {
				Ext.Msg.prompt(tituloCgg_gem_vacante_seleccionar,
					'Por favor ingrese un detalle u observaci\u00f3n de ser necesario,<br> por el cual ha salido del puesto de empleo.<br>',
					function(btn,text){ if (btn=="ok")fnSeleccionarParaVacante (-1,text);},null,true
				);
            }
        }
    });
	/**
     * Finaliza el proceso de la oferta.
     */
    var btnFinalizarCgg_gem_candidato = new Ext.Button({
        id: 'btnFinalizarCgg_gem_candidato',
        text: 'Finalizar',
        iconCls: 'iconFinalizar',
		hidden:true,
        listeners: {
            click: function () {
				Ext.Msg.prompt('Finalizaci\u00f3n del proceso', 'El proceso de la oferta <b>'+inRecordVacante.get("CGVCN_NUMERO_COMUNICADO")+'</b> va ha finalizar.<br/>Por favor ingrese un detalle de finalizaci\u00f3n del proceso:',
					function(btn, text){
						if (btn == 'ok')finalizarTramiteOferta(text,7);
					},null,true
				);
            }
        }
    });
	
	/**
	* Funcion que permite finalizar el proceso de la oferta
	*/
	function finalizarTramiteOferta(txt,tp){
		try {
			function CallBackCgg_gem_vacante_finalizar(r){
				winFrmCgg_gem_vacante_seleccionar.getEl().unmask();
				if (r == 'true') {
					Ext.Msg.show({
						title: "Finalizaci\u00f3n",
						msg: 'La informaci\u00f3n de finalizaci\u00f3n del proceso de la oferta ha sido registrada exitosamente.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					flagAceptar = true;
					winFrmCgg_gem_vacante_seleccionar.close()
				} else {
					Ext.Msg.show({
						title: 'Finalizaci\u00f3n',
						msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_gem_vacante_seleccionar.getEl().mask('Guardando...', 'x-mask-loading');
			
			var param = new SOAPClientParameters();
			param.add('inCgvcn_codigo', inRecordVacante.get("CGVCN_CODIGO"));
			param.add('inCgvcn_estado_oferta', tp );
			param.add('inCgvcn_justificacion_no_contrat', txt);
			SOAPClient.invoke( URL_WS + "Cgg_gem_vacante", "finalizarProceso", param, true, CallBackCgg_gem_vacante_finalizar);
		} catch (inErr) {  alert(inErr);
			winFrmCgg_gem_vacante_detalle.getEl().unmask();
		}
	}
	
	function fnSeleccionarParaVacante(ns,text){
		var t = grdCgg_gem_candidato_vacante_finalizar.getSelectionModel().getSelected();
		var fechaTemporal = new Date().format('c');
		if (!t)	return;		
		if (ns == -1){
			fechaTemporal = dtCgvcn_fecha_salida.getValue().format('c');
		}
		try {
			function CallBackCgg_gem_candidato(r) {
				winFrmCgg_gem_vacante_seleccionar.getEl().unmask();	
				var err= r.substr (0,5);
				if (err == "ERROR"){
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'No se ha podido registrar la modificaci\u00f3n.<br> '+r,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}else if ((r==0 && ns==3) || (r==0 && ns==4))
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'No se ha podido registrar la modificaci\u00f3n,<br> debido a que no tiene entrevista realizada o fnalizada.<br>'+
						'Por lo menos debe registrarse informaci\u00f3n de una entrevista finalizada,<BR> o esperar que el administrador ingrese un criterio sobre la entrevista',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				else if (r==-1 && ns==3)
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'El sistema ha detectado que se han cubierto todas las vacantes.<br>',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					
				else
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'La informaci\u00f3n ha sido almacenada. ',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});					
				gsCgg_gem_candidato_vacante_finalizar.reload();				
			}
			winFrmCgg_gem_vacante_seleccionar.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			param.add('inCgcnd_codigo', t.get("CGCND_CODIGO"));
			param.add('inCgvcn_codigo', inRecordVacante.get("CGVCN_CODIGO"));
			param.add('inCgcnd_fecha_entrevista', fechaTemporal);
			param.add('inCgcnd_descripcion', "");
			param.add('inCgcnd_observacion', "");
			param.add('inCgcnd_detalle', text);
			/**     
			0 - NO SELECCIONADO
			1 - SELECCIONADO PARA ENTREVISTA
			2 - RECHAZADO PARA ENTREVISTA
			3 - SELECCIONADO PARA LA VACANTE
			4 - NO SELECCIONADO PARA VACANTE
			*/
			param.add('inCgcnd_seleccionado',ns );
			SOAPClient.invoke(URL_WS + "Cgg_gem_candidato", "update", param, true, CallBackCgg_gem_candidato);
		} catch (inErr) {
			alert (inErr);
			winFrmCgg_gem_vacante_seleccionar.getEl().unmask();
		}
	}
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_vacante_seleccionar.
     */
    var btnCancelarCgg_gem_vacante_seleccionar = new Ext.Button({
        id: 'btnCancelarCgg_gem_vacante_seleccionar',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_vacante_seleccionar.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_vacante_seleccionar.
     */
    var btnCerrarCgg_gem_vacante_seleccionar = new Ext.Button({
        id: 'btnCerrarCgg_gem_vacante_seleccionar',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_vacante_seleccionar.close();
            }
        }
    });
	function rndSeleccionado(v){
		switch(v){			
			case 4:v='iconCancelar'; break;
			case 3:v='iconOk'; break;
			case -1:v='iconRevision'; break;			
		}
		return '<div class="'+ v +' iconCell"/>';
	}
	function rndFormatFecha(v,x,r){
		if (r.get("CGCND_FECHA_ENTREVISTA") > new Date()){
			return "<span style = 'color:gray'>" +Ext.util.Format.date(v,"Y-m-d")+"</span>";
		}
		return Ext.util.Format.date(v,"Y-m-d");
	}
	/**
	 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_gem_candidato_vacante_finalizar.
	 */
	var rowExpander = new Ext.ux.grid.RowExpander({
        tpl : new Ext.Template(            
            '<b>Descripci\u00f3n del administrador:</b> {CGCND_DESCRIPCION}<br>',
            '<b>Detalle entrevista:</b> {CGCND_DETALLE}' 
        )
    });
	var btnCurriculum = {xtype:'actioncolumn',sortable:true,resizable: false,width: 100,header:'Curr\u00edculum', menuDisabled: true,align:"center",           
		items:[{
			iconCls: 'iconHojaVida',
			tooltip:"Muestra informaci\u00f3n del curr\u00edculum v\u00edtae",              
			handler: function(grid, rowIndex, colIndex) {
				grid.getSelectionModel().selectRow(rowIndex);
				var rec = grid.getStore().getAt(rowIndex);
				new FrmCgg_gem_hoja_vida(null,rec.get("CRPER_CODIGO")).show();
			}
		}]
	};
	
	var btnEntrevista = {xtype:'actioncolumn',sortable:true,resizable: false,width: 100,header:'Entrevista', menuDisabled: true,align:"center",           
		renderer: function(v,x,r){
			var strTmp = ""
			if (r.get("CGENT_FECHA_REALIZACION")) strTmp+='<img src="resources/images/edit_ent.png" />';
			if (r.get("CGENT_CRITERIO_TECNICO")) strTmp+='<img src="resources/images/edit_cr.png" />';
			return strTmp;
		},items:[{
			iconCls: 'iconEntrevistaUser',	
			toolTip: 'Administra la informaci\u00f3n de la entrevista del candidato',
			handler: function(grid, rowIndex, colIndex) {		
				grid.getSelectionModel().selectRow(rowIndex);
				var r = grdCgg_gem_candidato_vacante_finalizar.getSelectionModel().getSelected();
				var dateTmp = r.get("CGCND_FECHA_ENTREVISTA");
				if (dateTmp > new Date()){
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'Por favor, espere la fecha establecida de la entrevista para registrarla.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}
				var objCgg_gem_entrevista=null;
				if (r) {				
					var tmpAccion = "";
					if (r.get("CGCND_SELECCIONADO")<2 )
						if (SEG_GES_EMP == "CSROL_GEADM")tmpAccion = "ver";
						else
							if(!r.get("CGENT_CODIGO"))tmpAccion = 'insert';
							else	
								if (!r.get("CGENT_CRITERIO_TECNICO"))tmpAccion = 'update';
								else tmpAccion = 'ver';								
					else
						tmpAccion = "ver";
					objCgg_gem_entrevista = new FrmCgg_gem_entrevista(tmpAccion, r,inRecordVacante);
					
					objCgg_gem_entrevista.closeHandler(function () {
						gsCgg_gem_candidato_vacante_finalizar.reload();
					});
					if (r.get("CGENT_CODIGO")) objCgg_gem_entrevista.loadData();
					objCgg_gem_entrevista.show();
				}
			}
		}]
	};
	var btnCriterio = {xtype:'actioncolumn',sortable:true,resizable: false,width: 100,header:'Cr\u00edterio t\u00e9cnico', menuDisabled: true,align:"center",           
		renderer: function(v,x,r){
			var strTmp = ""
			if (r.get("CGENT_FECHA_REALIZACION")) strTmp+='<img src="resources/images/edit_ent.png" />';
			if (r.get("CGENT_CRITERIO_TECNICO")) strTmp+='<img src="resources/images/edit_cr.png" />';
			return strTmp;			
		},items:[{			
			iconCls: 'iconEntrevistaAdmin',			
			handler: function(grid, rowIndex, colIndex) {
				grid.getSelectionModel().selectRow(rowIndex);
				var r = grdCgg_gem_candidato_vacante_finalizar.getSelectionModel().getSelected();
				
				if ( !r.get("CGENT_FECHA_REALIZACION")){
					Ext.Msg.show({
						title: tituloCgg_gem_vacante_seleccionar,
						msg: 'Lo sentimos, el empleador a\u00fan no ha registrado la entrevista.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					return;
				}
				var objCgg_gem_entrevista=null;
				var tmpAccion = (r.get("CGCND_SELECCIONADO")>2 )?'ver':'criterio';									
				if (r) {
					var estadoSEL=inRecordVacante.get("CGVCN_ESTADO_OFERTA");
					if (estadoSEL==3 || estadoSEL==6 || estadoSEL==7 || estadoSEL==8){
						tmpAccion='ver';
					}
					objCgg_gem_entrevista = new FrmCgg_gem_entrevista( tmpAccion, r,inRecordVacante);
					objCgg_gem_entrevista.closeHandler(function () {
						gsCgg_gem_candidato_vacante_finalizar.reload();
					});
					objCgg_gem_entrevista.loadData();
					objCgg_gem_entrevista.show();
				}	
			}
		}]
	};
	
	var arrColumns = new Array();
	arrColumns.push(rowExpander);
	arrColumns.push({dataIndex:'CGCND_SELECCIONADO',header:' ',width:30,menuDisabled : true,renderer:rndSeleccionado});
	if (inRecordVacante.get("CGVCN_OFERTA_APROBADA") !==2)
		arrColumns.push({dataIndex:'CGENT_ESTADO_ENTREVISTA',header:'Estado',width:100,menuDisabled : true,renderer:function(v){if ( v) return (v==2)?'Realizada':'No realizada';}});
	arrColumns.push({dataIndex:'NOMBRE_USUARIO',header:'Usuario',width:200,sortable:true});	
	arrColumns.push(btnCurriculum);
	if (inRecordVacante.get("CGVCN_OFERTA_APROBADA") !==2)
		arrColumns.push({dataIndex:'CGCND_FECHA_ENTREVISTA',header:'F. entrevista',width:100,sortable:true,renderer:rndFormatFecha});
	if (inRecordVacante.get("CGVCN_OFERTA_APROBADA") !==2){
		if (SEG_GES_EMP == "CSROL_GEADM")
			arrColumns.push(btnCriterio);
		else 
			arrColumns.push(btnEntrevista);	
	}
	var cmCgg_gem_candidato_vacante_finalizar = new Ext.grid.ColumnModel(arrColumns);	
	
	
	
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_candidato_vacante_finalizar por un campo especifico.
	 */
	var gsCgg_gem_candidato_vacante_finalizar = new Ext.data.Store({
		proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_candidato",
            method: "selectFkVacante"
        }),
        remoteSort:true,
        reader: new Ext.data.JsonReader({
			id:"CGCND_CODIGO",
			root:"dataSet",
			totalProperty:'totalCont'
		}, [			
			{name:'CGCND_CODIGO'},
			{name:'CUSU_CODIGO'},
			{name:'NOMBRE_USUARIO'},
			{name:'CRPER_CODIGO'},
			{name:'CUSU_NOMBRE_USUARIO'},
			{name:'CGVCN_CODIGO'},
			{name:'CGCND_FECHA_ENTREVISTA',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGCND_ASPIRACION_SALARIAL'},			
			{name:'CGCND_DESCRIPCION'},
			{name:'CGCND_OBSERVACION'},
			{name:'CGCND_DETALLE'},
			{name:'CGCND_SELECCIONADO'},
			{name:'CGENT_CODIGO'},						
			{name:'CGENT_ESTADO_ENTREVISTA'},
			{name:'CGENT_FECHA_REALIZACION',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGENT_FECHA_CRITERIO_TECNICO',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGENT_CRITERIO_TECNICO'},
			{name:'CGENT_LUGAR'},
			{name:'CGENT_OBSERVACION'}
        ]),
        baseParams: {
			format: 'JSON',
			/*
			0 MUESTRA TODOS LOS CANDIDATOS PARA LA OFERTA
			1 MUESTRA CANDIDATOS QUE HAN SIDO SELECCIONADOS EN LA ENTREVISTA
			*/
			inTipo : 1,
			keyword:' ',
			start:0,
			limit:RECORD_PAGE,
			inCgvcn_codigo:inRecordVacante.get("CGVCN_CODIGO")
        },
		sortInfo:{field:'CGCND_CODIGO',direction:'asc'},
		listeners:{
			load:function(gs){
				if (gs.getCount()>0) {
					var contCdn = 0;
					for (var i =0;i<gs.getCount();i++){
						var dtCnd= gs.getAt(i).get("CGCND_SELECCIONADO");
						if (dtCnd== 3 || dtCnd== 4)
							contCdn++
					}
					btnFinalizarCgg_gem_candidato.setVisible((contCdn==gs.getCount())?true:false);
				}
				btnSeleccionarCgg_gem_candidato.setVisible(false);
				btnRechazarCgg_gem_candidato.setVisible(false);
				grdCgg_gem_candidato_vacante_finalizar.getSelectionModel().clearSelections();
			}
		}
	});	
	gsCgg_gem_candidato_vacante_finalizar.reload();
	/**
	 * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_candidato_vacante_finalizar en un formato tabular de filas y columnas.
	 */
	 var pgBarCgg_gem_candidato_vacante_finalizar = new Ext.PagingToolbar({
		store: gsCgg_gem_candidato_vacante_finalizar,
		displayInfo: true,
		pageSize: RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});	
	var estadoOfertaSEL= inRecordVacante.get("CGVCN_ESTADO_OFERTA");	
	var grdCgg_gem_candidato_vacante_finalizar = new Ext.grid.GridPanel({
		cm: cmCgg_gem_candidato_vacante_finalizar,		
		store: gsCgg_gem_candidato_vacante_finalizar,
		region:'center',
		tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
			store: gsCgg_gem_candidato_vacante_finalizar,
			width: 200
		})],
		plugins: rowExpander,
		bbar:pgBarCgg_gem_candidato_vacante_finalizar,
		sm: new Ext.grid.RowSelectionModel({
			singleSelect : false
		}),
		loadMask: {
			msg: "Cargando..."
		}		
	});
	grdCgg_gem_candidato_vacante_finalizar.getSelectionModel().on("selectionchange",function(sm_cgvcn){		
		var sw_cgvcn=sm_cgvcn.hasSelection();		
		if (!sw_cgvcn) return;
		rowSel = sm_cgvcn.getSelected().get("CGCND_SELECCIONADO");
		/*Contratacion directa*/
		var recAprobada = inRecordVacante.get("CGVCN_OFERTA_APROBADA");		
		if (recAprobada!=2){
			sw_cgvcn =true;
			for (var i=0;i<gsCgg_gem_candidato_vacante_finalizar.getCount();i++){
				var tmpRec = gsCgg_gem_candidato_vacante_finalizar.getAt(i);
				var tmpCriterio = tmpRec.get("CGENT_CRITERIO_TECNICO");
				if (!tmpCriterio)
					sw_cgvcn =false;			
			}
			if (!sw_cgvcn) return;
		}
		btnSeleccionarCgg_gem_candidato.setVisible(false);
		btnRechazarCgg_gem_candidato.setVisible(false);
		var tmpEstEnt = sm_cgvcn.getSelected().get("CGENT_ESTADO_ENTREVISTA");
		if (tmpEstEnt <2 && recAprobada!=2) return;
		if (sm_cgvcn.getSelected().get("CGENT_CRITERIO_TECNICO") || recAprobada==2){
			if (rowSel<3){
				btnRechazarCgg_gem_candidato.setVisible(true);
				btnSeleccionarCgg_gem_candidato.setVisible(true);
			}else{
				if (rowSel == 3) btnRechazarCgg_gem_candidato.setVisible(true);
				if (rowSel == 4) btnSeleccionarCgg_gem_candidato.setVisible(true);		
			}
		}
	});
	btnsSeleccion = new Array();
	if (estadoOfertaSEL!==2 && estadoOfertaSEL!==3 && estadoOfertaSEL!==6 && estadoOfertaSEL!==7 && estadoOfertaSEL!==8)
		if (SEG_GES_EMP =='CSROL_GEEMP' || SEG_GES_EMP =='CSROL_GEAPL' || SEG_GES_EMP =='CSROL_GEADM')
			btnsSeleccion.push(btnSeleccionarCgg_gem_candidato,btnRechazarCgg_gem_candidato,btnFinalizarCgg_gem_candidato);		
	if (estadoOfertaSEL==6 || estadoOfertaSEL==7)
		btnsSeleccion.push('Fecha Salida',dtCgvcn_fecha_salida,btnSalidaCgg_gem_candidato);
	btnsSeleccion.push('->');
	btnsSeleccion.push(btnCerrarCgg_gem_vacante_seleccionar);

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_vacante_seleccionar.
     */
    var winFrmCgg_gem_vacante_seleccionar = new Ext.Window({
        id: 'winFrmCgg_gem_vacante_seleccionar',
        title: tituloCgg_gem_vacante_seleccionar,
        width: 700,
		height: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrainHeader: true,
		layout:'border',
		modal:true,
        tbar: getPanelTitulo(tituloCgg_gem_vacante_seleccionar, descCgg_gem_vacante_seleccionar),
        items: [grdCgg_gem_candidato_vacante_finalizar],
		bbar :btnsSeleccion
    });	
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_vacante_seleccionar.
     * @returns ventana winFrmCgg_gem_vacante_seleccionar.
     * @base FrmCgg_gem_vacante_seleccionar.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_vacante_seleccionar;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_vacante_seleccionar.
     * @base FrmCgg_gem_vacante_seleccionar.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_vacante_seleccionarCtrls();
    }
	this.getFlagAceptar = function () {
		return flagAceptar;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_vacante_seleccionar desde una instancia.
 */
FrmCgg_gem_vacante_seleccionar.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_vacante_seleccionar desde una instancia.
 */
FrmCgg_gem_vacante_seleccionar.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_vacante_seleccionar,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_vacante_seleccionar.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_vacante_seleccionar desde una instancia.
 */
FrmCgg_gem_vacante_seleccionar.prototype.loadData = function () {
    this.loadData();
}