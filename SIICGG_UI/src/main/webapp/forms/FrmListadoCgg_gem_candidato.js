/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_candidato.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_candidato(inRecordVacante) {
    var urlListadoCgg_gem_candidato = URL_WS + "Cgg_gem_candidato";
    var tituloListadoCgg_gem_candidato = 'Candidatos de la oferta';
    var descListadoCgg_gem_candidato = 'El formulario permite listar la informaci\u00f3n de los candidatos que pueden aplicar para la oferta';
	var tmp_CRPER_CODIGO="";
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnAceptarCgg_gem_candidato = new Ext.Button({
        id: 'btnAceptarCgg_gem_candidato',
        text: 'Seleccionar para entrevista',
        iconCls: 'iconSeleccionado',
		hidden:true,
        listeners: {
            click: function () {
				var r = grdCgg_gem_candidato.getSelectionModel().getSelected();                
				if (r) {	
					var objCgg_gem_candidato = new FrmCgg_gem_candidato("aceptar",r,inRecordVacante);
					objCgg_gem_candidato.closeHandler(function () {
						btnAceptarCgg_gem_candidato.setVisible(false);
						btnRechazarCgg_gem_candidato.setVisible(false);
						grdCgg_gem_candidato.getSelectionModel().clearSelections();
						gsCgg_gem_candidato.reload();
					});
					objCgg_gem_candidato.loadData();
					objCgg_gem_candidato.show();
				}
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnRechazarCgg_gem_candidato = new Ext.Button({
        id: 'btnRechazarCgg_gem_candidato',
        text: 'Descartar',
        iconCls: 'iconIndeterminado',
		hidden:true,
        listeners: {
            click: function () {
                var r = grdCgg_gem_candidato.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_candidato = new FrmCgg_gem_candidato("rechazar", r,inRecordVacante);
                    objCgg_gem_candidato.closeHandler(function () {
                        btnAceptarCgg_gem_candidato.setVisible(false);
						btnRechazarCgg_gem_candidato.setVisible(false);
						grdCgg_gem_candidato.getSelectionModel().clearSelections();
						gsCgg_gem_candidato.reload();
                    });
                    objCgg_gem_candidato.loadData();
                    objCgg_gem_candidato.show();
                }
            }
        }
    });
	/**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnAgregarCgg_gem_candidato = new Ext.Button({
        id: 'btnAgregarCgg_gem_candidato',
        text: 'Agregar candidato',
        iconCls: 'iconNuevo',		
        listeners: {
            click: function () {
                var  objTmpBusquedaPerfil = new FrmListadoCgg_gem_busqueda_perfil(null,true);
				objTmpBusquedaPerfil.closeHandler(function(){
					var tmpRecord = objTmpBusquedaPerfil.getSelectedRow();                    
					try {
						function CallBackCgg_gem_candidatoCND(r) {
							winFrmListadoCgg_gem_candidato.getEl().unmask();
							if (r == 'true') {
								Ext.Msg.show({
									title: tituloListadoCgg_gem_candidato,
									msg:'La informaci\u00f3n ha sido almacenada.',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});								
							} else {								
								Ext.Msg.show({
									title: tituloListadoCgg_gem_candidato,
									msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});								
							}
							gsCgg_gem_candidato.reload();
						}
						winFrmListadoCgg_gem_candidato.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();		
						param.add('inCusu_codigo', tmpRecord.get("CUSU_CODIGO"));
						param.add('inCgvcn_codigo', inRecordVacante.get("CGVCN_CODIGO"));
						param.add('inCgcnd_aspiracion_salarial', null);						
						param.add('inCgcnd_observacion', null);						
						SOAPClient.invoke(URL_WS + "Cgg_gem_candidato", "insert", param, true, CallBackCgg_gem_candidatoCND);
					} catch (inErr) {
						winFrmListadoCgg_gem_candidato.getEl().unmask();
					}
				});
				objTmpBusquedaPerfil.show();
				
            }
        }
    });
	/**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnEliminarCgg_gem_candidato = new Ext.Button({
        id: 'btnEliminarCgg_gem_candidato',
        text: 'Eliminar candidato',
        iconCls: 'iconEliminar',		
        listeners: {
            click: function () {                
				var r= grdCgg_gem_candidato.getSelectionModel().getSelected();
				if(!r)return;
				Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_candidatoDelete,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_candidatoDelete(btn){if (btn=='yes'){
					try {
						function CallBackCgg_gem_candidatoCNDDEL(r) {
							winFrmListadoCgg_gem_candidato.getEl().unmask();
							if (r == 'true') {
								Ext.Msg.show({
									title: tituloListadoCgg_gem_candidato,
									msg:'La informaci\u00f3n ha sido eliminada.',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});									
							} else {								
								Ext.Msg.show({
									title: tituloListadoCgg_gem_candidato,
									msg: 'La informaci\u00f3n no ha podido ser eliminada. ' + r,
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});								
							}
							gsCgg_gem_candidato.reload();
							
						}
						winFrmListadoCgg_gem_candidato.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();		
						param.add('inCgcnd_codigo', r.get("CGCND_CODIGO"));					
						SOAPClient.invoke(URL_WS + "Cgg_gem_candidato", "delete", param, true, CallBackCgg_gem_candidatoCNDDEL);
					} catch (inErr) {}
				}}
            }
        }
    });
	/**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnEnviarCgg_gem_candidato = new Ext.Button({
        id: 'btnEnviarCgg_gem_candidato',
        text: 'Enviar candidatos',
        iconCls: 'iconAceptar',		
        listeners: {
            click: function () {
				Ext.Msg.confirm('Confirmar', 'Esta seguro de enviar la informaci\u00f3n de los candidatos?', 
					function(btn){
						if (btn == 'yes')
							GenerarExistenciaManoObra(2,'');
					}
				);
            }
        }
    });
	/**
     * Ext.Button Boton que permite generar el certificado de existencia de mano de obra.
     */
	var flagGenerado = false;
    var btnManoObraCgg_gem_candidato = new Ext.Button({
        id: 'btnManoObraCgg_gem_candidato',
        text: 'Existencia de mano de obra',
        iconCls: 'iconConfiguracion',
        listeners: {
            click: function () {
				var swMsg=false;
				for (k=0;k<gsCgg_gem_candidato.getTotalCount();k++){
					r=gsCgg_gem_candidato.getAt(k);
					if (r.get("CGCND_SELECCIONADO") == '1')
						swMsg =true;
				}
				if (swMsg == false){
					Ext.Msg.prompt('Confirmar', 'El sistema ha verificado que <span style="color:red"><b>NO</b></span> existe mano de obra para la oferta.<br>Registre una observaci\u00f3n para generar el <br><b>certificado de NO existencia de mano de obra<b>:', function(btn, text){
						if (btn == 'ok')
							GenerarExistenciaManoObra(0,text);
					});
				}else{
					Ext.Msg.confirm('Confirmar','El sistema ha verificado que <span style="color:green"><b>SI</b></span> existe mano de obra para la oferta.<br>Desea generar el <b>certificado de existencia de mano de obra</b>?', function(btn){
						if (btn == 'yes')
							GenerarExistenciaManoObra(1,"");							
					});
				}
            }
		}
    });
	/*
	* Funcion que permite registrar la existencia o no de mano de obra para una oferta
	*/
	function GenerarExistenciaManoObra(estado,text){		
		try{
			function CallBackCgg_gem_vacante_manobra(r) {				
			   winFrmListadoCgg_gem_candidato.getEl().unmask();
			   var err= r.substr(0,5) ;
				if (err== 'ERROR') {
					Ext.Msg.show({
						title: tituloListadoCgg_gem_candidato,
						msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});					
				} else {
					if (estado ==2 ){
						Ext.Msg.show({
							title: tituloListadoCgg_gem_candidato,
							msg: 'Se ha enviado correctamente la informaci\u00f3n de los candidatos',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});						
					}else{
						Ext.Msg.show({
							title: tituloListadoCgg_gem_candidato,
							msg: 'Se ha registrado correctamente la existencia<br/> de mano de obra para la oferta.<B><br/><br/>NUMERO: '+r+"</B>",
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});						
						new Reporte("rptCertificadoExistenciaManObra", '/Reports/sii/gem', {
							P_CGVCN_CODIGO:inRecordVacante.get('CGVCN_CODIGO'),
							P_CUSU_CODIGO:inRecordVacante.get('CUSU_CODIGO')						
						}).show();								
					}
					flagGenerado=true;
					winFrmListadoCgg_gem_candidato.close();	
				}
			}
			winFrmListadoCgg_gem_candidato.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			param.add('inCgvcn_codigo',inRecordVacante.get("CGVCN_CODIGO"));
			param.add('inCgvcn_existencia_manobra',estado);
			param.add('inCgvcn_justificacion_no_contrat',text);
			SOAPClient.invoke(URL_WS + "Cgg_gem_vacante", "generarExistenciaManoObra", param, true, CallBackCgg_gem_vacante_manobra);
		} catch (inErr) {
			winFrmListadoCgg_gem_candidato.getEl().unmask();
		}
	}
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_candidato.
     */
    var btnSalirCgg_gem_candidato = new Ext.Button({
        id: 'btnSalirCgg_gem_candidato',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_candidato.close();
            }
        }
    });
   
	function rndSeleccionado(v){
		switch(v){
			case 0:v='';break;
			case 1:v='iconSeleccionado'; break;
			case 2:v='iconIndeterminado'; break;
			case 3:v='iconSeleccionado'; break;
			case 4:v='iconSeleccionado'; break;
		}
		return '<div class="'+ v +' iconCell"/>';
	}
	function rndFormatFecha(v){
		if(v)
			return '<b>'+Ext.util.Format.date(v,"Y-m-d")+'</b>';
	}
	var rowExpander = new Ext.ux.grid.RowExpander({
        tpl : new Ext.Template(            
            '<b>Descripci\u00f3n del administrador:</b> {CGCND_DESCRIPCION}<br>'
        )
    });
	var btnCurriculum = {xtype:'actioncolumn',sortable:true,resizable: false,width: 100,header:'Curr\u00edculum', menuDisabled: true,align:"center",           
		items:[{
			iconCls: 'iconHojaVida',
			tooltip:"Muestra informaci\u00f3n del curr\u00edculum v\u00edtae",              
			handler: function(grid, rowIndex, colIndex) {
				grid.getSelectionModel().selectRow(rowIndex);
				var rec = grid.getStore().getAt(rowIndex);
				if (SEG_GES_EMP == "CSROL_GEADM")
					new FrmCgg_gem_administracion_hoja_vida(null,rec.get("CRPER_CODIGO")).show();
				else
					new FrmCgg_gem_hoja_vida(null,rec.get("CRPER_CODIGO")).show();
			}
		}]
	};
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_candidato.
     */
    var cmCgg_gem_candidato = new Ext.grid.ColumnModel({
		defaults: {menuDisabled:true},
		columns:[
			rowExpander,
			{dataIndex:'CGCND_SELECCIONADO',header:' ',width:35,resizable: false,renderer:rndSeleccionado},
			{dataIndex:'NOMBRE_USUARIO',header:'Nombres',width:200,sortable:true},
			btnCurriculum,
			{dataIndex:'CGCND_FECHA_ENTREVISTA',header:'F. entrevista',width:90,sortable:true,renderer:rndFormatFecha,align:'center'},
			{dataIndex:'CGINF_CALIFICACION',header:'Calificaci\u00f3n',width:180,sortable:true,renderer:
				function(v){
					var tmpCalif = "";
					for (i=1;i<=5;i++){
						tmpCalif += (i<=v)?
							"<img src='resources/images/staron.jpg' title='"+i+"'/>":
							"<img src='resources/images/staroff.jpg' title='"+i+"'/>";
					}
					return tmpCalif;
				}
			},
			{dataIndex:'CGINF_OBSERVACIONES',header:'.',width:30,renderer:
				function(v){
					return "<img src='resources/images/message.png' title='"+v+"'/>";
				}
			}
		]
	});
	
	 
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_candidato por un campo especifico.
     */
    var gsCgg_gem_candidato = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_candidato",
            method: "selectFkVacante"
        }),
		remoteSort:true,
        reader: new Ext.data.JsonReader(
		{
			id:"CGCND_CODIGO",
			root:"dataSet",
			totalProperty:'totalCont'
		}, [		
			{name:'CGCND_CODIGO'},
			{name:'CRPER_CODIGO'},
			{name:'CGINF_CALIFICACION'},
			{name:'CGINF_OBSERVACIONES'},
			{name:'CUSU_NOMBRE_USUARIO'},
			{name:'NOMBRE_USUARIO'},
			{name:'CGVCN_CODIGO'},
			{name:'CGCND_FECHA_ENTREVISTA',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGCND_ASPIRACION_SALARIAL'},
			{name:'CGCND_OBSERVACION'},
			{name:'CGCND_DESCRIPCION'},
			{name:'CGCND_SELECCIONADO'}
        ]),     
		baseParams: {
            format: 'JSON',
			/*
			0 MUESTRA TODOS LOS CANDIDATOS PARA LA OFERTA
			1 MUESTRA CANDIDATOS QUE HAN SIDO SELECCIONADOS EN LA ENTREVISTA
			*/
			inTipo : 0,
			keyword:' ',
			inCgvcn_codigo:inRecordVacante.get("CGVCN_CODIGO"),
			start:0,
			limit:RECORD_PAGE				
		},
	   sortInfo:{field:"CGCND_FECHA_ENTREVISTA",direction:"asc"}
    });
	var pgBarCgg_gem_candidato = new Ext.PagingToolbar({
		store: gsCgg_gem_candidato,
		displayInfo: true,
		pageSize: RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});	
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_candidato en un formato tabular de filas y columnas.
     */
	 var estadoOfertaENT= inRecordVacante.get("CGVCN_ESTADO_OFERTA");
    var grdCgg_gem_candidato = new Ext.grid.GridPanel({
		id:'grdCgg_gem_candidato',
		border:false,
        cm: cmCgg_gem_candidato,		
        store: gsCgg_gem_candidato,
		bodyStyle:'border-bottom:1px solid #99BBE8;',
		region:"center",
		bbar:pgBarCgg_gem_candidato,
		frame:false,
		plugins: rowExpander,        
        sm: new Ext.grid.RowSelectionModel({singleSelect: true}),
        loadMask: {msg: "Cargando..."}        
    });
    gsCgg_gem_candidato.reload();
	var tplCandidato = new Ext.Template(		
		'<B>NOMBRE:</B>   {NOMBRE_USUARIO}<BR>',
		'<B>SALARIO:</B>  {CGCND_ASPIRACION_SALARIAL} <br> ',
		'<B>OBSERVACION CANDIDATO:</B>   {CGCND_OBSERVACION}<BR>',
		'<B>OBSERVACION ADMINISTRADOR:</B>   {CGCND_DESCRIPCION}<BR>',
		(("{CGCND_FECHA_ENTREVISTA}")?'<B>FECHA ENT.:</B>{CGCND_FECHA_ENTREVISTA:date("d/m/Y H:i")}<BR><B>':"")+
		'<span id="spanLink" style="color:blue;cursor:pointer">Mostrar hoja de vida</span></B>'
	);		
	grdCgg_gem_candidato.getSelectionModel().on("selectionchange",function(sm_cgvcn){		
		var sw_cgvcn=sm_cgvcn.hasSelection();	
		if (!sw_cgvcn) return;
		var rowSel = sm_cgvcn.getSelected().get("CGCND_SELECCIONADO");		
		btnAceptarCgg_gem_candidato.setVisible(true);
		btnRechazarCgg_gem_candidato.setVisible(true);
		if (rowSel == 1){
			btnAceptarCgg_gem_candidato.setVisible(false);			
		}else if (rowSel == 2){			
			btnRechazarCgg_gem_candidato.setVisible(false);
		}
		
	});	
	var pnlCgg_gem_candidato = new Ext.Panel({
		id:'pnlCgg_gem_candidato',
		layout: 'border',
		width:'100%',		
		frame:false,
		height:350,
		region:'center',
		items: [grdCgg_gem_candidato]
	});	
	var pnlPrincipal = new Ext.Panel({
		id:'pnlPrincipal',
		region:'center',
		layout:'border',
		bodyStyle:'border-bottom:0px solid white;border-left:0px solid white;border-right:0px solid white;background-color:#CFDEEF;border-top;1px solid #99BBE8;',
		defaults:{border:false},
		items:[pnlCgg_gem_candidato]
	});	
	var showBtn =(SEG_GES_EMP == "CSROL_GEADM" 
			&& estadoOfertaENT!="-1" 
			&& estadoOfertaENT!="0"
			&& estadoOfertaENT!="6"
			&& estadoOfertaENT!="7"
			&& estadoOfertaENT!="8"
			&& estadoOfertaENT!="5"			
		)?"btnAceptarCgg_gem_candidato, btnRechazarCgg_gem_candidato,":"";
	var btnsGenerarManoObra = "";
	if (estadoOfertaENT=="3"){
		btnsGenerarManoObra = "["+showBtn+" '->', btnSalirCgg_gem_candidato]";
	}else if (SEG_GES_EMP == "CSROL_GEADM"){
		if (inRecordVacante.get ("CGVCN_EXISTENCIA_MANOBRA")=="1" || inRecordVacante.get ("CGVCN_EXISTENCIA_MANOBRA")=="0"){
			btnsGenerarManoObra = "["+showBtn+"'->', btnSalirCgg_gem_candidato]";
		}else{
			if (inRecordVacante.get("CGVCN_OFERTA_APROBADA") == 2 && estadoOfertaENT!="8"){
				btnsGenerarManoObra = "[btnAgregarCgg_gem_candidato,btnEliminarCgg_gem_candidato,'-',btnEnviarCgg_gem_candidato,'->', btnSalirCgg_gem_candidato]";
			}else{
				var fechaPublicacion = inRecordVacante.get ("CGVCN_FECHA_PUBLICACION");
				var duracionOferta = inRecordVacante.get ("CGVCN_DURACION_OFERTA");
				var fechaReal= fechaPublicacion.add(Date.DAY, duracionOferta);
				if (new Date>fechaReal && estadoOfertaENT!="8" 
					&& estadoOfertaENT!="6"
					&& estadoOfertaENT!="7"
					&& estadoOfertaENT!="8"
					&& estadoOfertaENT!="5"	)
					btnsGenerarManoObra = "["+showBtn+"btnManoObraCgg_gem_candidato,  '->', btnSalirCgg_gem_candidato]";
				else
					btnsGenerarManoObra = "["+showBtn+"'->', btnSalirCgg_gem_candidato]";					
			}
		}
    }else{
		btnsGenerarManoObra = "["+showBtn+" '->', btnSalirCgg_gem_candidato]";
	}
	
	/**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_candidato.
     */
    var winFrmListadoCgg_gem_candidato = new Ext.Window({
        id: 'winFrmListadoCgg_gem_candidato',
        title: tituloListadoCgg_gem_candidato,
        width: 700,
        minWidth: 400,
        height: 400,
        minHeight: 300,
        maximizable: true,
        minimizable: true,
        constrainHeader: true,
		modal:true,
        layout: 'border',
		bodyStyle:'background-color:#CFDEEF;border-top;1px solid #99BBE8;',
        tbar: getPanelTitulo('Listado de candidatos de la oferta', descListadoCgg_gem_candidato),
        items: [pnlPrincipal],
		listeners:{
			show:function(){
				var tmpRec = inRecordVacante.get("CGVCN_DURACION");
				var tmpD = dsDuracionTrabajo;
				for (k=0;k<tmpD.length;k++){
					if (tmpD[k][0] == tmpRec){
						inRecordVacante.set("CGVCN_DURACION_TIEMPO",inRecordVacante.get("CGVCN_DURACION_TIEMPO")+" "+tmpD[k][1]);
						break;
					}
				}				
			}
		},
        bbar: eval(btnsGenerarManoObra)
    });    
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_candidato.
     * @returns ventana winFrmCgg_gem_candidato.
     * @base FrmListadoCgg_gem_candidato.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_candidato;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_candidato.
     * @base FrmListadoCgg_gem_candidato.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_candidato.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_candidato;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_candidato;
    }
	this.getFlagGenerado = function(){
		return flagGenerado;
	}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_candidato.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_candidato.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_candidato desde una instancia.
 */
FrmListadoCgg_gem_candidato.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_candidato desde una instancia.
 */
FrmListadoCgg_gem_candidato.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_candidato,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_candidato.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_candidato desde una instancia.
 */
FrmListadoCgg_gem_candidato.prototype.loadData = function () {
    this.loadData();
}
