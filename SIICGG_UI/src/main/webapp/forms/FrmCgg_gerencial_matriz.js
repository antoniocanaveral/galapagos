/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gerencial_matriz.
* @constructor 
* @author Besixplus Cia. Ltda.
*/

function FrmCgg_gerencial_matriz(inDesktop){		
	var optMenu = 'Gerencial/Subsistema Gerencial';
        var urlCgg_gerencial_matriz = URL_WS + "Cgg_gerencial_matriz";
        var tituloCgg_gerencial_matriz = 'Subsistema gerencial';
        var descCgg_gerencial_matriz = 'El formulario permite administrar informaci\u00f3n del subsistema gerencial';
		var totalTotal =0;
		
		function Cgg_indicador_data(){
		
			/**
			* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_indicador.
			*/
			this.columnModel = new Ext.grid.ColumnModel([
					{dataIndex:'CGGIN_NOMBRE',header:'Nombre',width:500,sortable:true},
					{dataIndex:'CGGIN_DESCRIPCION',header:'Descripcion',width:350,sortable:true,hidden:true}
			]);
			/**
			* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_indicador por un campo especifico.
			*/
			this.store = new Ext.data.Store({
					proxy:new Ext.ux.bsx.SoapProxy({
							url:URL_WS+"Cgg_ger_indicador",
							method:"selectPageDirect",
							pagin:true
					}),
					remoteSort:true,
					reader:new Ext.data.JsonReader({
							id:'CGGIN_CODIGO',
							root:'dataSet',
							totalProperty: 'totalCount'
					},[
						{name:'CGGIN_CODIGO'},
						{name:'CGGIT_CODIGO'},
						/*{name:'CUSU_CODIGO'},
						{name:'CCTN_CODIGO'},*/
						{name:'CGGIN_NOMBRE'},
						{name:'CGGIN_DESCRIPCION'}
					]),
					sortInfo:{field: 'CGGIT_CODIGO', direction: 'ASC'},
					baseParams:{keyword:"",format:'JSON'}
			});
		}
		var btnSalirCgg_gerencial_matriz = new Ext.Button(
        {
            id: 'btnSalirCgg_gerencial_matriz',
            text: 'Salir',
            iconCls: 'iconSalir',
            listeners: {
                click:
                    function (){
                        winFrmCgg_gerencial_matriz.close();
                    }
            }
        });
		var summary = new Ext.ux.grid.GroupSummary();
		function rndMeses(v,x,r){	
			try{
				if(tmpSw){
					var rTmp = eval("("+"{"+r.get("JSON_INFO")+"}"+")");
					var tmpRec = eval ("rTmp."+x.id) || {};		
					var divTooTip='';
					if (tmpRec.CGGMA_CODIGO){
						var divTooTip = "<b>Ultima fecha de actualizaci\u00f3n</b>: "+tmpRec.CGGMA_FECHA_UPDATE+"</br>"+
						"<b>N\u00famero de actualizaciones</b>: "+tmpRec.CGGMA_ACTUALIZACIONES+"</br>"+
						"<b>Responsable</b>: "+tmpRec.CUSU_CODIGO+"</br>"+
						"<b>Cargo</b>: "+tmpRec.CRCRG_NOMBRE+"</br>"+
						"<b>Valor</b>: "+tmpRec.CGGMA_VALOR+"</br>"+
						"<b>Observaci\u00f3n</b>: "+tmpRec .CGGMA_DESCRIPCION+"</br>";				
					}
					x.attr = 'ext:qtip="'+divTooTip+'"';			
					return '<div >'+(tmpRec.CGGMA_VALOR || '')+'</div>';
				}else{
					//x.css = "x-grid3-header";
					//tmpSw = true;
					return "<b>"+v+"</b>";
				}
			}catch(e){}
		}
		var MESES=[				
			["ENE","ENERO",0],
			["FEB","FEBRERO",0],
			["MAR","MARZO",0],
			["ABR","ABRIL",0],
			["MAY","MAYO",0],
			["JUN","JUNIO",0],
			["JUL","JULIO",0],
			["AGO","AGOSTO",0],
			["SEP","SEPTIEMBRE",0],
			["OCT","OCTUBRE",0],
			["NOV","NOVIEMBRE",0],
			["DIC","DICIEMBRE",0]
		];
		var tmpFechaActual = new Date();		
		var ANIO = tmpFechaActual.getFullYear();
		var txtTmpCggma_anio = new Ext.form.NumberField({
			id:'txtTmpCggma_anio',
			name:'txtTmpCggma_anio',			
			width:'50',
			allowBlank :false,
			value:ANIO,
			listeners:{
				change:function(){
					btnTmpReload.fireEvent('click');
				}
			}
		});
		/**
		* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
		*/
		var txtTmpCggin_codigo = new Ext.form.TextField({
			id:'txtTmpCggin_codigo',
			name:'txtTmpCggin_codigo',			
			width:'400',
			readOnly:'true',
			allowBlank :false			
		});
		/**
		* IDENTIFICATIVO UNICO DE REGISTRO
		*/
		var btnCggin_codigoCgg_ger_matriz = new Ext.Button({
			id:'btnCggin_codigoCgg_ger_matriz',
			text:'',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_ger_indicador = new Cgg_indicador_data();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_ger_indicador.store,tmpFLCgg_ger_indicador.columnModel);
					objBusqueda.closeHandler(function(){
						var tmpRecord = objBusqueda.getSelectedRow();
						if(tmpRecord){
							txtTmpCggin_codigo.setValue(tmpRecord.get('CGGIN_NOMBRE'));
							txtTmpCggin_codigo_codigo= tmpRecord.get('CGGIN_CODIGO');
							btnTmpReload.fireEvent('click');
						}
					});
					objBusqueda.show();
				}
			}
		});		
		/*Array que contiene  el columnmodel del grid*/
		var arrColumnMatriz = new Array();
		/*columnmodel correspondiente a los cantones de galapagos*/
		arrColumnMatriz.push({xtype:'actioncolumn',dataIndex:"CCTN_NOMBRE",header: "Cant\u00f3n",width:90,align:"RIGHT",renderer:
			function(z,x){
				x.css = "x-grid3-header";
				return z;
			},items:[{
				iconCls: 'iconGerencialRpt',
				tooltip:"Ver el reporte mensual",   
				handler: function(grid, rowIndex, colIndex) {
					//grid.getSelectionModel().selectRow(rowIndex);
					var rec = grid.getStore().getAt(rowIndex);
					if (rec){
						/*REPORTE MENSUAL POR CANTON */
						new Reporte("rptIndicadorGerencialGeneral", '/Reports/sii/gerencial', {
							P_CGGIN_CODIGO:txtTmpCggin_codigo_codigo,
							P_CCTN_CODIGO:rec.get('CCTN_CODIGO'),
							P_ANIO:txtTmpCggma_anio.getValue()
						}).show();
					}else{
						/*REPORTE MENSUAL DE TODOS LOS CANTONES */
						new Reporte("rptIndicadorGerencialGeneral", '/Reports/sii/gerencial', {
							P_CGGIN_CODIGO:txtTmpCggin_codigo_codigo,
							P_CCTN_CODIGO:' ',
							P_ANIO:txtTmpCggma_anio.getValue()
						}).show();
					}
				}
			}]
		});	
		for (i=0;i<MESES.length;i++){
			var tmpMes=MESES[i];
			arrColumnMatriz.push({id:tmpMes[0],dataIndex:tmpMes[0],header: tmpMes[1],renderer:rndMeses});	
		}
		arrColumnMatriz.push({xtype:'actioncolumn',dataIndex:"TOTAL",header: "TOTAL",width:90,align:"RIGHT",renderer:
			function(z,x,r){
				try{
					if(tmpSw){
						var rTmp = eval("("+"{"+r.get("JSON_INFO")+"}"+")");
						var tmpTotal = 0;
						for (var t=0;t<MESES.length;t++){
							var tmpRec = eval ("rTmp."+MESES[t][0]) || {};					
							if (tmpRec.CGGMA_VALOR){
								tmpTotal+=Number(tmpRec.CGGMA_VALOR);
								MESES[t][2]+=Number(tmpRec.CGGMA_VALOR);
							}
						}
						totalTotal+=Number(tmpTotal);
						return '<b>'+tmpTotal+'</b>';
					}else{						
						tmpSw = true;
						return '<b>'+z+'</b>';
					}
				}catch(e){					
				}
			},
			items:[{
				iconCls: 'iconGerencialRpt',
				tooltip:"Ver el reporte anual",              
				handler: function(grid, rowIndex, colIndex) {					
					var rec = grid.getStore().getAt(rowIndex);
					if (rec.data.CCTN_NOMBRE != 'TOTAL'){
						/*REPORTE MENSUAL POR CANTON */
						new Reporte("rptIndicadorGerencialGeneral", '/Reports/sii/gerencial', {
							P_CGGIN_CODIGO:txtTmpCggin_codigo_codigo,
							P_CCTN_CODIGO:rec.get('CCTN_CODIGO'),
							P_ANIO:null					
						}).show();
					}else{
						/*REPORTE MENSUAL DE TODOS LOS CANTONES */
						new Reporte("rptIndicadorGerencialGeneral", '/Reports/sii/gerencial', {
							P_CGGIN_CODIGO:txtTmpCggin_codigo_codigo,
							P_CCTN_CODIGO:null,
							P_ANIO:null
						}).show();
					}
				}
			}]
		});
		
		
		/**
		* Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_gerencial_matriz.
		*/        
		var cmCgg_gerencial_matriz = new Ext.grid.ColumnModel({
			columns:arrColumnMatriz,
			defaults: {sortable: false,menuDisabled: true,width: 60,align:"right"}
		});				
		
		var gsCgg_ger_matriz_grid = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
				url:URL_WS+"Cgg_ger_matriz",
				method:"selectDirectGrid"			
			}),			
			reader:new Ext.data.JsonReader({},[
				{name:'CCTN_CODIGO'},
				{name:'CCTN_NOMBRE'},
				{name:'JSON_INFO'},
				{name:'ENE'},
				{name:'FEB'},
				{name:'MAR'},
				{name:'ABR'},
				{name:'MAY'},
				{name:'JUN'},
				{name:'JUL'},
				{name:'AGO'},
				{name:'SEP'},
				{name:'OCT'},
				{name:'NOV'},
				{name:'DIC'}	,			
				{name:'TOTAL'}				
			]),			
			baseParams:{inCggin_codigo:"",inCggma_anio:''},	
			listeners:{
				load:function(){
					tmpSw=true;				
					var recTotal = Ext.data.Record.create([]);					
					var r = new recTotal({
						CCTN_NOMBRE:"TOTAL",
						ENE:MESES[0][2],
						FEB:MESES[1][2],
						MAR:MESES[2][2],
						ABR:MESES[3][2],
						MAY:MESES[4][2],
						JUN:MESES[5][2],
						JUL:MESES[6][2],
						AGO:MESES[7][2],
						SEP:MESES[8][2],
						OCT:MESES[9][2],
						NOV:MESES[10][2],
						DIC:MESES[11][2],
						TOTAL:totalTotal
					});					
					tmpSw=false;
					grdCgg_gerencial_matriz.getStore().insert(gsCgg_ger_matriz_grid.getCount(), r);
				}
			}
		});
		var tmpSw=true;
		var btnTmpReload = new Ext.Button({
			id:'btnTmpReload',			
			iconCls:'iconRecargar',
			text:'Refrescar',
			listeners:{
				click:function(){					
					if (( txtTmpCggma_anio.getValue()||0) < 2010)
						txtTmpCggma_anio.setValue(ANIO);
					if ( txtTmpCggma_anio.getValue() > ANIO)
						txtTmpCggma_anio.setValue(ANIO);
					if (txtTmpCggin_codigo.getValue().length==0){
						btnCggin_codigoCgg_ger_matriz.fireEvent('click');
					}else{
						gsCgg_ger_matriz_grid.baseParams.inCggin_codigo = txtTmpCggin_codigo_codigo;
						gsCgg_ger_matriz_grid.baseParams.inCggma_anio = txtTmpCggma_anio.getValue();
						for (var y=0;y<MESES.length;y++){
							MESES[y][2]=0;
						}
						totalTotal =0;
						gsCgg_ger_matriz_grid.reload();
					}
				}
			}
		});
		/**
		* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gerencial_matriz en un formato tabular de filas y columnas.
		*/
        var grdCgg_gerencial_matriz = new Ext.grid.EditorGridPanel({
			tbar:['A\u00f1o',txtTmpCggma_anio,'Indicador:',txtTmpCggin_codigo,btnCggin_codigoCgg_ger_matriz],
            cm: cmCgg_gerencial_matriz,
            store: gsCgg_ger_matriz_grid,
			columnLines:true,
			plugins : summary,  
            region: 'center',            
            loadMask: {msg: "Cargando..."},
			listeners:{
				celldblclick:function(grd, rIndex,cIndex, e){
					if (cIndex >0){
						try{
							var rTmp = eval("("+"{"+gsCgg_ger_matriz_grid.getAt(rIndex).get("JSON_INFO")+"}"+")");
							if (txtTmpCggma_anio.getValue()==ANIO){
								var tmpIndex =11;
								for (var t=0;t<MESES.length;t++){
									if (MESES[cIndex-1][0]==MESES[t][0] ){
										tmpIndex = t;
										break;
									}
								}
								var tmpMes = tmpFechaActual.getMonth();							
								if (tmpMes<tmpIndex){
									Ext.Msg.show({
										title:"Aviso",
										msg: 'No puede registrar informaci\u00f3n de los meses posteriores al actual',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
									return;
								}
							}
							var tmpRec = eval ("rTmp."+MESES[cIndex-1][0]) || {};			
							var tmpSentencia = (tmpRec.CGGMA_VALOR)?"update":"insert";
							var tmpRecors ={	
								CCTN_CODIGO:gsCgg_ger_matriz_grid.getAt(rIndex).get("CCTN_CODIGO"),
								CGGIN_CODIGO:txtTmpCggin_codigo_codigo,
								CUSU_CODIGO:'1',
								CGGMA_MES:MESES[cIndex-1][0],
								CGGMA_ANIO:txtTmpCggma_anio.getValue()							
							}
							/**
							*
							**/
							
							codigoIndicador = txtTmpCggin_codigo_codigo;
							param = new SOAPClientParameters();
							param.add('inCggin_codigo',codigoIndicador);
							param.add('inCctn_codigo',tmpRecors.CCTN_CODIGO);
							param.add('format',TypeFormat.JSON);

							var tmpCanton = SOAPClient.invoke(URL_WS+'Cgg_ger_indicador_encargado', 'selectCantonByIndicador', param, false, null);
							try{
								tmpCanton = Ext.util.JSON.decode(tmpCanton);
								tmpCanton=tmpCanton[0];
								codigoCanton = tmpCanton.CCTN_CODIGO;
							}catch(inErr){
								codigoCanton = '';
							}
							
							if (codigoCanton){
								if(tmpRecors.CCTN_CODIGO == codigoCanton){
									/**
									*
									**/

									var objCgg_ger_matriz = new FrmCgg_ger_matriz(tmpSentencia,((tmpSentencia =="insert")?null:tmpRec),tmpRecors);
									objCgg_ger_matriz.closeHandler(function(){
										btnTmpReload.fireEvent("click");
									});
									objCgg_ger_matriz.loadData();
									objCgg_ger_matriz.show();
								}else{
									Ext.Msg.show({
										title:"Aviso",
										msg: 'Usted no puede ingresar un indicador para esta isla',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
									return;
								}
							}else{
								Ext.Msg.show({
										title:"Aviso",
										msg: 'Usted no tiene permisos para ingresar informaci\u00F3n sobre este indicador para el cant\u00F3n '+gsCgg_ger_matriz_grid.getAt(rIndex).get("CCTN_NOMBRE"),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
									return;
							}
						}catch(e){}
					}
				}
			}
        });        
		/**
		* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gerencial_matriz.
		*/

        var winFrmCgg_gerencial_matriz = inDesktop.createWindow({        
            id: 'winFrmCgg_gerencial_matriz',
            title: tituloCgg_gerencial_matriz,
            width: 800,
            minWidth: 400,
            height: 400,
            minHeight: 300,
            maximizable: true,
            minimizable: true,
            constrainHeader: true,
            layout: 'border',
            tbar: getPanelTitulo(tituloCgg_gerencial_matriz, descCgg_gerencial_matriz),
            items: [grdCgg_gerencial_matriz],
            bbar: [btnTmpReload,'->', btnSalirCgg_gerencial_matriz]
        });
		/**
		* Funcion que aplica los privilegios del usuario.		
		*/
        applyGrants(winFrmCgg_gerencial_matriz.getBottomToolbar());
	this.getWindow= function(){
		return winFrmCgg_gerencial_matriz;
	}
}

FrmCgg_gerencial_matriz.prototype.show = function () {
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gerencial_matriz,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gerencial_matriz.prototype.closeHandler = function (inFunctionHandler)
{
    this.getWindow().on('close', inFunctionHandler);
}