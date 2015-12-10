/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_vacante.
 * @param {String} inSentenciaCgg_gem_vacante Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} inRecordCgg_gem_vacante Registro de datos de la tabla Cgg_gem_vacante.
 * @constructor
 * @base FrmListadoCgg_gem_vacante
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_vacante(inSentenciaCgg_gem_vacante, inRecordCgg_gem_vacante) {    	
    var urlCgg_gem_vacante = URL_WS + "Cgg_gem_vacante";
    var tituloCgg_gem_vacante = 'Oferta de empleo';
    var descCgg_gem_vacante = 'El formulario permite administrar la informaci\u00f3n de ofertas de empleo.';
    var isEdit = false;
	var arrRecDireccion =[];
	var tmpExtras = {titulo:"",cargo:"",msg:""};
	
	function Cgg_titulo_profesional_data(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_titulo_profesional.
     */
    this.columnModel = new Ext.grid.ColumnModel([
        {
            dataIndex:'CGNES_DESCRIPCION',
            header:'Nivel de Estudio',
            width:120,
            sortable:true            
        },

        {
            dataIndex:'CGTPR_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:400,
            sortable:true
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_titulo_profesional por un campo especifico.
     */
    this.store = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_titulo_profesional",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGTPR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {
                name:'CGTPR_CODIGO'
            },

            {
                name:'CGNES_CODIGO'
            },

            {
                name:'CGNES_DESCRIPCION'
            },

            {
                name:'CGTPR_DESCRIPCION'
            }
        ]),
        sortInfo:{
            field: 'CGTPR_DESCRIPCION',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        },
        groupField:'CGNES_DESCRIPCION'
    });
}
    /**
     * Variable que contiene el codigo de la vacante seleccionada.
     */
    var txtCgvcn_codigo = "";
    /**
     * Variable que almacena el codigo del usuario que inicio la sesion.
     */
	var txtCusu_codigo_COD=userSessionData.CUSU_CODIGO;  		
	var txtCusu_codigo_Empresa = new Ext.form.TextField({
        id: 'txtCusu_codigo_Empresa',
        name: 'txtCusu_codigo_Empresa',
        fieldLabel: 'Oferta a nombre de',
		textBlank:'Seleccione el usuario encargado de la Empresa para la oferta',
        anchor: '98%',
        readOnly: true,        
        allowBlank: (SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?false:true
    });	
    /**
     * Ext.Button Muestra la ventana de seleccion del cargo
     */
    var btnCusu_codigo_Empresa = new Ext.Button({
        id: 'btnCusu_codigo_Empresa',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {				
                var tmpflcgg_persona_juridica = new Cgg_usuario_responsable_Empresa();
                var objBusqueda = new DlgBusqueda(tmpflcgg_persona_juridica.store, tmpflcgg_persona_juridica.columnModel);
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
						txtCusu_codigo_COD = tmpRecord.get('CUSU_CODIGO');							
						txtCusu_codigo_Empresa.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
					}
                });
                objBusqueda.show();
            }
        }
    }); 
	/**
     * Ext.form.DateField FECHA DE INGRESO DE LA OFERTA
     */
    var dtCgvcn_fecha_ingreso = new Ext.form.DateField({
        id: 'dtCgvcn_fecha_ingreso',
        name: 'dtCgvcn_fecha_ingreso',        
        format: 'd/m/Y H:i:s',
		disabled:true,		
        value: new Date(),
		hidden:true
    });       
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var txtCgcrg_codigo_TXT = "";
    var txtCgcrg_codigo_COD = "";
	var txtCgcrg_codigo = new Ext.form.TextField({
        id: 'txtCgcrg_codigo',
        name: 'txtCgcrg_codigo',
        fieldLabel: 'Cargo',
        anchor: '98%',
        readOnly: 'true',
        allowBlank: false
    });	
    /**
     * Ext.Button Muestra la ventana de seleccion del cargo
     */
    var btnCgcrg_codigoCgg_gem_vacante = new Ext.Button({
        id: 'btnCgcrg_codigoCgg_gem_vacante',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_gem_cargo = new Cgg_gem_cargo_data();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_cargo.store, tmpFLCgg_gem_cargo.columnModel);
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
						txtCgcrg_codigo.setValue(tmpRecord.get('CGCRG_NOMBRE'));
						txtCgcrg_codigo_TXT = tmpRecord.get('CGCRG_NOMBRE');						
						txtCgcrg_codigo_COD = tmpRecord.get('CGCRG_CODIGO');
						chkCargo.setValue(false);
					}
                });
                objBusqueda.show();
            }
        }
    }); 
	/**
     * Ext.form.TextField NOMBRE IDENTIFICATIVO DE LA VACANTE
     */
	var txtCgvcn_titulo_profesional_TXT='';
	var txtCgvcn_titulo_profesional_COD='';
    var txtCgvcn_titulo_profesional = new Ext.form.TextField({
        id: 'txtCgvcn_titulo_profesional',
        name: 'txtCgvcn_titulo_profesional',
        fieldLabel: 'T\u00EDtulo prof.',
		readOnly:true,
        anchor: '98%',
        allowBlank: false
    });
	
	/**
     * Ext.Button Muestra la ventana de seleccion del titulo profesional
     */
    var btnCgtpr_codigoCgg_gem_vacante = new Ext.Button({
        id: 'btnCgtpr_codigoCgg_gem_vacante',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function (){
				var tmpCgg_titulo_profesional = new Cgg_titulo_profesional_data();
                var objBusqueda = new DlgBusqueda(tmpCgg_titulo_profesional.store, tmpCgg_titulo_profesional.columnModel);
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
						txtCgvcn_titulo_profesional.setValue(tmpRecord.get('CGTPR_DESCRIPCION'));
						txtCgvcn_titulo_profesional_TXT = tmpRecord.get('CGTPR_DESCRIPCION')						
						txtCgvcn_titulo_profesional_COD = tmpRecord.get('CGTPR_CODIGO')						
						chkTitulo.setValue(false);
					}
                });
                objBusqueda.show();
            }
        }
    });
	var chkCargo = new Ext.form.Checkbox({         
		id:'chkCargo',         
		name:'chkCargo',         
		hideLabel: true,
		hidden:(SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?true:false,		
		checked:false,    
		tabTip:'Nuevo cargo',		
		listeners:{             
			check: function (obj,value){ 				
				if (value){					
					txtCgcrg_codigo.getEl().dom.removeAttribute('readOnly');
				}else{
					txtCgcrg_codigo.getEl().dom.setAttribute('readOnly', true);
					txtCgcrg_codigo.setValue(txtCgcrg_codigo_TXT);
				}	          
			}         
		}     
	});
	var chkTitulo = new Ext.form.Checkbox({         
		id:'chkTitulo',         
		name:'chkTitulo', 
		tabTip:'Nuevo t\u00EDtulo profesional',
		hideLabel: true,	
		hidden:(SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?false:true,
		checked:false,         
		listeners:{             
			check: function (obj,value){
				if (value){					
					txtCgvcn_titulo_profesional.getEl().dom.removeAttribute('readOnly');
				}else{
					txtCgvcn_titulo_profesional.getEl().dom.setAttribute('readOnly', true);
					txtCgvcn_titulo_profesional.setValue(txtCgvcn_titulo_profesional_TXT);
				}				  
			}         
		}     
	});
    /**
     * Ext.form.TextArea DESCRIPCION DE LA VACANTE para empresas y NOmbre negocio/Lugar de trabajo para personas naturales
     */
    var txtCgvcn_descripcion = new Ext.form.TextArea({
        id: 'txtCgvcn_descripcion',
        name: 'txtCgvcn_descripcion',
        fieldLabel: (SEG_GES_EMP == "CSROL_GEEMP")?'Funciones':((SEG_GES_EMP == "CSROL_GEADM")?'Funciones del Cargo':'Lugar trabajo'),
        width: '100%',
        allowBlank: false,
		height:35
    });    
	/**
	* Ext.data.Store Contiene datos de las isla seleccionadas.
	*/
	var gsCgg_gem_isla_empleo = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_gem_isla_empleo",
			method:"selectPageByFkId"
		}),		
		reader:new Ext.data.JsonReader({},[
			{name:'CGISE_CODIGO'},			
			{name:'CISLA_CODIGO'},
			{name:'CISLA_NOMBRE'},
			{name:'CGISE_DIRECCION'}
		]),		
		baseParams:{inCgvcn_codigo:(inRecordCgg_gem_vacante)?inRecordCgg_gem_vacante.get("CGVCN_CODIGO"):null},
		listeners:{
			load:function(){
				var tmpStore=gsCgg_gem_isla_empleo;				
				tmpDir="";
				for(i=0;i<tmpStore.getCount();i++){
					arrRecDireccion.push(tmpStore.getAt(i));
					tmpDir+=((i==0)?"":", ")+tmpStore.getAt(i).get("CISLA_NOMBRE");
				}
				txtCgvcn_direccion_isla.setValue(tmpDir);
			}
		}
	});
	if (inRecordCgg_gem_vacante) gsCgg_gem_isla_empleo.reload();

    var txtCgvcn_direccion_isla = new Ext.form.TextArea({
        id: 'txtCgvcn_direccion_isla',
        name: 'txtCgvcn_direccion_isla',
        fieldLabel: 'Isla empleo',
        anchor: '100%',
		height:35,
		readOnly:true,
        allowBlank: false
    });
	/**
	* Ext.Button Muestra la ventana de seleccion de las islas para el empreo
	*/
	var btnDireccionCgg_gem_vacante = new Ext.Button({
        id: 'btnDireccionCgg_gem_vacante',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
				var tmpDireccion = "";
				var sm = new Ext.grid.CheckboxSelectionModel({});			
				new Ext.Window({
					id:'winTmpDireccion',
					iconCls:"iconBuscar",
					title:"Seleccione una o mas Islas",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,
							{dataIndex:'CISLA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
							{dataIndex:'CISLA_NOMBRE',header:'Nombre',width:100,sortable:true}							
						]),
						store:new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_isla",
								method:"selectAll"
							}),
							autoLoad:true,							
							reader:new Ext.data.JsonReader({},[
								{name:'CISLA_CODIGO'},
								{name:'CISLA_NOMBRE'}
							]),
							baseParams:{
								format:"JSON"
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();									
									for (var i=0;i<arrRecDireccion.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CISLA_CODIGO") == arrRecDireccion[i].get("CISLA_CODIGO"))
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						}),
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],					
					maximizable:false,
					constrainHeader:true,
					width:250,
					height:300,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpDireccion="";
						arrRecDireccion = sm.getSelections();
						for (i=0;i<arrRecDireccion.length;i++)
							tmpDireccion+=(i>0?', ':'')+arrRecDireccion[i].get("CISLA_NOMBRE");
						txtCgvcn_direccion_isla.setValue(tmpDireccion);
						Ext.getCmp('winTmpDireccion').close();
						if (Ext.getCmp('winTmpDireccion')) Ext.getCmp('winTmpDireccion') = null;
					}}]					
				}).show();					
            }
        }
    });
       
	/**
     * Ext.form.ComboBox Contiene datos de sectores productivos
     */
	
    var cbxCsctp_codigo = new Ext.form.ComboBox({
        id: 'cbxCsctp_codigo',
        name: 'cbxCsctp_codigo',
        fieldLabel: 'Sector productivo',
        anchor: '98%',        
        //allowBlank: false,		
        displayField: 'CSCTP_NOMBRE',
        valueField: 'CSCTP_CODIGO',
		blankText:"Seleccione...",		
        mode:'local',
		editable: true,
        triggerAction:'all',
		typeAhed:true,
		forceSelection:true,
    });
    /**
     * Ext.form.ComboBox Contiene datos tipos de contratos
     */
    var cbxCgtcn_codigo = new Ext.form.ComboBox({
        id: 'cbxCgtcn_codigo',
        name: 'cbxCgtcn_codigo',
        fieldLabel: 'Tipo de contrato',
		width:150,
        allowBlank: false,
		editable: false,
        displayField: 'CGTCN_DESCRIPCION',
        valueField: 'CGTCN_CODIGO',
		blankText:"Seleccione...",		
        mode:'local',
        triggerAction:'all'
    });
	 /**
     * Ext.form.NumberField CANTIDAD DE VACANTES DISPONIBLES
     */
    var numCgvcn_numero_vacantes = new Ext.form.NumberField({
        id: 'numCgvcn_numero_vacantes',
        name: 'numCgvcn_numero_vacantes',
        fieldLabel: 'N\u00FAmero vacantes',
        allowBlank: false,
        disabled: false,
		width:50
    });   
    /**
     * Ext.form.NumberField Duracion del empleo
     */
    var numCgvcn_duracion_tiempo = new Ext.form.NumberField({
        id: 'numCgvcn_duracion_tiempo',
        name: 'numCgvcn_duracion_tiempo',
        fieldLabel: 'Duraci\u00f3n empleo',
		width:'98%',
        allowBlank: false
    });
	 /**
     * Ext.form.NumberField  DURACION DEL TRABAJO VALORES:
     0 - HORA
     1 - DIA
     2 - MES
     3 - ANIO
     */
    var cbxCgvcn_duracion = new Ext.form.ComboBox({
		id:'cbxCgvcn_duracion',
		name:'cbxCgvcn_duracion',
		store: dsDuracionTrabajo,
        displayField: 'tipo',
        valueField: 'id',
        mode:'local',
        editable: false,
		allowBlank: false,
        triggerAction:'all',
        emptyText : '',
		width:80
    });
	/**
     * Ext.form.NumberField MONTO OFERTADO COMO RECONOCIMIENTO POR EL TRABAJO REALIZADO
     */
    var numCgvcn_salario = new Ext.form.NumberField({
        id: 'numCgvcn_salario',
        name: 'numCgvcn_salario',
        fieldLabel: 'Salario',
        width: '97%',
        allowBlank: false,
        disabled: false
    });
    /**
     * Ext.form.ComboBox Contiene datos de tipos de salarios
     */
    var cbxCgtsa_codigo = new Ext.form.ComboBox({
        id: 'cbxCgtsa_codigo',
        name: 'cbxCgtsa_codigo',
        anchor: '98%',
        displayField: 'CGTSA_NOMBRE',
        valueField: 'CGTSA_CODIGO',
		blankText:"Seleccione...",		
        mode:'local',
		allowBlank: false,
        editable: false,
        triggerAction:'all',
		width:80
    });
	
	var strEstadoOferta="-1";
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante
     */
    var btnGuardarCgg_gem_vacante = new Ext.Button({
        id: 'btnGuardarCgg_gem_vacante',
        text: 'Solo guardar',
		hidden:(SEG_GES_EMP == "CSROL_GEADM")?true:false,
        iconCls: 'iconGuardar',
        listeners: {
			click: function () {             				
				var tmpValor=SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF45')).get('CGCNF_VALOR_NUMERICO');
				
				//alert(tmpValor);
				var meses_anios = numCgvcn_duracion_tiempo.value * 12;
				var meses_meses = numCgvcn_duracion_tiempo.value;
				var meses_dias = numCgvcn_duracion_tiempo.value / 30;
				var meses_horas = (numCgvcn_duracion_tiempo.value / 24)/30;
				var swTmp = true;
				var tmpCadena = '';
				var tmpVal = '';
				var valorSeleccionado = cbxCgvcn_duracion.getValue();
				switch(valorSeleccionado){
					case 0:
							if(meses_horas > tmpValor){
								swTmp = false;
								tmpCadena = 'horas es de: ';
								tmpVal = (tmpValor*30)*24;
							}					
								break;
					case 1:
							if(meses_dias > tmpValor){
								swTmp = false;
								tmpCadena = 'd\u00edas es de: ';
								tmpVal = tmpValor*30;								
							}
								break;
					case 2:
							if(meses_meses > tmpValor){
								swTmp = false;
								tmpCadena = 'meses es de: ';
								tmpVal = tmpValor;								
							}
								break;
					case 3:
							if(meses_anios > tmpValor){
								swTmp = false;
								tmpCadena = 'a\u00f1os es de: ';
								tmpVal = tmpValor/12;
							}							
								break;
				}
				if (!swTmp)	{
					numCgvcn_duracion_tiempo.markInvalid('El n\u00FAmero m\u00E1ximo de '+tmpCadena+tmpVal);
					numCgvcn_duracion_tiempo.setMaxValue(tmpVal);
				}
				if (pnlCgg_gem_vacante.getForm().isValid() == false) {strEstadoOferta ="-1";return;}
				if (swTmp == true){
					if (grdCgg_gem_requisito_vacante.getStore().getCount()==0){
						Ext.Msg.show({
							title: tituloCgg_gem_vacante,
							msg: "Por favor agregue al menos un requisito.",
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
						return;
					}
					try {
						function CallBackCgg_gem_vacante(r) {						
							winFrmCgg_gem_vacante.getEl().unmask();
							if (isEdit){
								if (r == 'true') {
									var tmpMsg =(strEstadoOferta =="0")?
										"La oferta ha sido almacenada.":
										"La oferta ha sido almacenada."
									Ext.Msg.show({
										title: tituloCgg_gem_vacante,
										msg: tmpMsg,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
									});
									winFrmCgg_gem_vacante.close();
								} else{
									Ext.Msg.show({
										title: tituloCgg_gem_vacante,
										msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
								}
							}else{
								Ext.Msg.show({
									title: tituloCgg_gem_vacante,
									msg: 'La oferta se ha registrado exitosamente.<br/> El n\u00famero de la oferta es: <b>' +r+'</b>',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								winFrmCgg_gem_vacante.close();
							}
						}
						winFrmCgg_gem_vacante.getEl().mask('Guardando...', 'x-mask-loading');
						
						var tmpArrNew=new Array();
						var tmpArrDel=new Array();					
						
						for (i=0;i<gsCgg_gem_isla_empleo.getCount();i++){
							var tmpisla = gsCgg_gem_isla_empleo.getAt(i).get("CISLA_CODIGO");
							var tmpSw=false;
							for(j=0;j<arrRecDireccion.length;j++)
								if (tmpisla==arrRecDireccion[j].get("CISLA_CODIGO")) 
									tmpSw=true;							
							if(tmpSw == false)tmpArrDel.push(gsCgg_gem_isla_empleo.getAt(i));
						}
						for (i=0;i<arrRecDireccion.length;i++){
							var tmpisla = arrRecDireccion[i].get("CISLA_CODIGO");
							var tmpSw=false;
							for(j=0;j<gsCgg_gem_isla_empleo.getCount();j++)
								if (tmpisla==gsCgg_gem_isla_empleo.getAt(j).get("CISLA_CODIGO")) 
									tmpSw=true;							
							if(tmpSw == false)tmpArrNew.push(arrRecDireccion[i]);
						}
						var tmpObj = '[{"objDel":'+createJSONObjectRecord(tmpArrDel)+","+'"objNew":'+createJSONObjectRecord(tmpArrNew)+'}]';
						var tmpObjNew = createJSONObjectRecord(arrRecDireccion);
						var param = new SOAPClientParameters();
						if (isEdit) param.add('inCgvcn_codigo', txtCgvcn_codigo);
							param.add('inJSONIslaEmpleo', (isEdit)?tmpObj:tmpObjNew);
							param.add('inCsctp_codigo', null);
							param.add('inCgtcn_codigo', cbxCgtcn_codigo.getValue());
							param.add('inCgtsa_codigo', cbxCgtsa_codigo.getValue());
							param.add('inCgcrg_codigo', (chkCargo.getValue())?'CGCRG0':txtCgcrg_codigo_COD);
							param.add('inCgtpr_codigo', (chkTitulo.getValue())?'CGTPR0':txtCgvcn_titulo_profesional_COD);
							var tmpJson ="{'cargo':'"+ ((chkCargo.getValue() || txtCgcrg_codigo_COD =='CGCRG0')?txtCgcrg_codigo.getValue():'')+							
								"','titulo':'"+((chkTitulo.getValue() || txtCgcrg_codigo_COD =='CGTPR0')?txtCgvcn_titulo_profesional.getValue():'')+
								"','msg':''}";
							param.add('inCgvcn_titulo', tmpJson);
							param.add('inCgvcn_estado_oferta', (SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?'9':strEstadoOferta);
							param.add('inCgvcn_descripcion', txtCgvcn_descripcion.getValue());
							param.add('inCgvcn_salario', numCgvcn_salario.getValue());
							param.add('inCgvcn_direccion', txtCgvcn_direccion_isla.getValue());
							param.add('inCgvcn_numero_vacantes', numCgvcn_numero_vacantes.getValue());
							param.add('inCgvcn_experiencia',null);
							param.add('inCgvcn_duracion', cbxCgvcn_duracion.getValue());
							param.add('inCgvcn_duracion_tiempo', numCgvcn_duracion_tiempo.getValue());						
							if (!isEdit){						
								param.add('inCusu_codigo', txtCusu_codigo_COD);
								param.add('inCgvcn_fecha_ingreso', dtCgvcn_fecha_ingreso.getValue().format(TypeDateFormat.Custom));
								param.add('inJSONRequisitos',createJSONObject(grdCgg_gem_requisito_vacante.getStore()));							
							}
							SOAPClient.invoke(urlCgg_gem_vacante, inSentenciaCgg_gem_vacante, param, true, CallBackCgg_gem_vacante);

					} catch (inErr) {
						strEstadoOferta ="-1";
						winFrmCgg_gem_vacante.getEl().unmask();
					}						
				}
				
            }
        }
    });
	 /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante
     */
	 var btnGuardarEnviarCgg_gem_vacante = new Ext.Button({
		id: 'btnGuardarEnviarCgg_gem_vacante',
        text: (SEG_GES_EMP == "CSROL_GEADM")?'Guardar':'Guardar y enviar',
		toolTip:'Guarda y evia la informacion para su aprobacion',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
				
					strEstadoOferta ="0";
					btnGuardarCgg_gem_vacante.fireEvent('click');			
				
			}
		}
	 });	 
	 
	 /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_vacante
     */
	 var btnRevisarCgg_gem_vacante = new Ext.Button({
		id: 'btnRevisarCgg_gem_vacante',
        text: 'Revisar',
		hidden:true,
		toolTip:'Muestra informaci\u00f3n de lso datos por revisar de la oferta',
        iconCls: 'iconAviso',		
        listeners: {
            click: function () {
               	Ext.Msg.show({
					title: "Observaciones del administrador por revisar",
					msg: tmpExtras.msg||"",
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.INFO
				});
			}
		}
	 });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_vacante.
     */
    var btnCancelarCgg_gem_vacante = new Ext.Button({
        id: 'btnCancelarCgg_gem_vacante',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_vacante.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_vacante.
     */
    var btnCerrarCgg_gem_vacante = new Ext.Button({
        id: 'btnCerrarCgg_gem_vacante',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_vacante.close();
            }
        }
    });	
	
	var frameDatosGenerales = {
		columnWidth: .50,
		labelWidth:65,
		layout: 'form',
		items: [{
			xtype:'fieldset',
			anchor:'97%',
			layout: 'form',
			title: 'Datos generales',
			items :[{
				xtype: 'panel',
				layout: 'column',
				items: [
					{columnWidth: .6,layout: 'form',items: [dtCgvcn_fecha_ingreso]}
				]
			},{
				xtype: 'panel',
				layout: 'column',
				items: [
					{columnWidth: .9,layout: 'form',items: [txtCgcrg_codigo]},
					{columnWidth: .1,layout: 'form',items: [btnCgcrg_codigoCgg_gem_vacante]}
				]
			},{
				xtype: 'panel',
				layout: 'column',
				items: [
					{columnWidth: .9,layout: 'form',items: [txtCgvcn_titulo_profesional]},
					{columnWidth: .1,layout: 'form',items: [btnCgtpr_codigoCgg_gem_vacante]}
				]
			}, 
			txtCgvcn_descripcion,			
			{
				xtype: 'panel',
				layout: 'column',
				items: [
					{columnWidth: .92,layout: 'form',items: [txtCgvcn_direccion_isla]},
					{columnWidth: .08,layout: 'form',items: [btnDireccionCgg_gem_vacante]}
				]
			}]
		}]
	}
	
	/**
	* Ext.form.FormPanel Panel contenedor de controles de ingreso de informacion para las ofertas
	*/
	var pnlCgg_gem_vacante=new Ext.form.FormPanel({
		id:'pnlCgg_gem_vacante',
		bodyStyle:"padding: 0 0;",
		frame:true,		
		labelWidth:70,
		region:'north',
		autoHeight:true,
		items:[{
				xtype: 'panel',
				hidden: (SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?false:true,
				layout: 'column',
				items: [
					{columnWidth: .70,layout: 'form',labelWidth:120,items: [txtCusu_codigo_Empresa]},
					{columnWidth: .30,layout: 'form',items: [btnCusu_codigo_Empresa]}
				]
			},{
			xtype: 'panel',
			layout: 'column',
			items: [frameDatosGenerales,{
				columnWidth: .50,
				labelWidth:110,
				layout: 'form',
				items: [{
					xtype: 'fieldset',				
					layout: 'form',
					title: 'Datos Especificos',
					items :[cbxCgtcn_codigo,numCgvcn_numero_vacantes,{
						xtype: 'panel',
						layout: 'column',
						items: [
							{columnWidth: .60,layout: 'form',items: [numCgvcn_duracion_tiempo]},
							{columnWidth: .40,items:[cbxCgvcn_duracion]}
						]
					},{
						xtype: 'panel',
						layout: 'column',
						items: [
							{columnWidth: .60,layout: 'form',items: [numCgvcn_salario]},
							{columnWidth: .40,items: [cbxCgtsa_codigo]}
						]
					}]
				}]
			}]
		}]
	});

   /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_requisito_vacante.
	*/	
	var cmCgg_gem_requisito_vacante = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(),
		{dataIndex:'CGRVC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
		{dataIndex:'CGVCN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
		{dataIndex:'CGRVC_REQUISITO',header:'Requisito',width:500,sortable:true,editor:{xtype:'textfield',allowBlank:false}},
		{dataIndex: 'CGRVC_OBLIGATORIO',header: 'Obligatorio?',width: 80,sortable: true,editor:{xtype:'checkbox',x:100,align:'center',bodyStyle:"padding-Left:30;"},align:'center',renderer:function(v){return (v)?"si":"no"}}
	]);

	var recordRequisitos = [
		{name:'CGRVC_CODIGO'},
		{name:'CGVCN_CODIGO'},
		{name:'CGRVC_REQUISITO'},
		{name:'CGRVC_OBLIGATORIO'}
	];
	
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_requisito_vacante por un campo especifico.
     */
    var gsCgg_gem_requisito_vacante =new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_requisito_vacante",
            method: "selectFKVacante"            
        }),        
        reader: new Ext.data.JsonReader({},recordRequisitos),
        baseParams:{inCgvcn_codigo: ""}		
    });
	var editorCgg_gem_requisito_vacante = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
		cancelText:"Cancelar",
		listeners:{
            canceledit:function(inRowEditor,inFlag){
				if (!isEdit){
					if (inRowEditor.record.data.CGRVC_REQUISITO.length ==0) grdCgg_gem_requisito_vacante.getStore().remove(inRowEditor.record);
					return;
				}
				gsCgg_gem_requisito_vacante.reload();				
            },
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){					
				if (!isEdit)return;
				function CallBackCgg_gem_requisito_vacante1(e){
					gsCgg_gem_requisito_vacante.reload();
				}
				var param = new SOAPClientParameters();
				tmpIns = "insert";
				if (inRecord.get("CGRVC_CODIGO")!="KEYGEN"){
					param.add('inCgrvc_codigo',inRecord.get("CGRVC_CODIGO"));
					tmpIns = "update";
				}
				param.add('inCgvcn_codigo',txtCgvcn_codigo);
				param.add('inCgrvc_requisito',inRecord.get("CGRVC_REQUISITO"));
				param.add('inCgrvc_obligatorio',inRecord.get("CGRVC_OBLIGATORIO"));
				SOAPClient.invoke(URL_WS+"Cgg_gem_requisito_vacante",tmpIns,param, true, CallBackCgg_gem_requisito_vacante1);
            }
        }
    });
	/**
	* Ext.Button Agrega un nuevo requisito al listado
	*/
	var btnNuevoRequisito = new Ext.Button({
        id: 'btnNuevoRequisito',
        text: 'Agregar',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var recTmp = Ext.data.Record.create(recordRequisitos);
				var r = new recTmp({
                    CGRVC_CODIGO: "KEYGEN",
                    CGVCN_CODIGO: '',
                    CGRVC_REQUISITO: '',
                    CGRVC_OBLIGATORIO: true
                });
				var posInsert = gsCgg_gem_requisito_vacante.getCount();
				editorCgg_gem_requisito_vacante.stopEditing();
                gsCgg_gem_requisito_vacante.insert(posInsert, r);
                grdCgg_gem_requisito_vacante.getView().refresh();
                grdCgg_gem_requisito_vacante.getSelectionModel().selectRow(posInsert);
                editorCgg_gem_requisito_vacante.startEditing(posInsert);
            }
        }
    });
	/**
	* Ext.Button Elimina un requisito del listado
	*/
	var btnEliminarRequisito = new Ext.Button({
        id: 'btnEliminarRequisito',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
		disabled:true,
        listeners: {
            click: function () {
                if (!grdCgg_gem_requisito_vacante.getSelectionModel().getSelected()) return;
                if (!isEdit){
					grdCgg_gem_requisito_vacante.getStore().remove(grdCgg_gem_requisito_vacante.getSelectionModel().getSelected());
					return;
				}
				function CallBackCgg_gem_requisito_vacante(e){					
					gsCgg_gem_requisito_vacante.reload();
				}
				if (grdCgg_gem_requisito_vacante.getSelectionModel().getSelected()){
					var param = new SOAPClientParameters();
					var tmp = grdCgg_gem_requisito_vacante.getSelectionModel().getSelected().get("CGRVC_CODIGO");
					param.add('inCgrvc_codigo', tmp);
					SOAPClient.invoke(URL_WS + "Cgg_gem_requisito_vacante", "delete", param, true, CallBackCgg_gem_requisito_vacante);
				}	
            }
        }
    });
	
	
	var tbarReq= (SEG_GES_EMP == "CSROL_GEADM" && inSentenciaCgg_gem_vacante == "insert")?
		[btnNuevoRequisito,btnEliminarRequisito]:
		[btnNuevoRequisito,btnEliminarRequisito,chkTitulo,chkCargo];
		
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_requisito_vacante en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_requisito_vacante = new Ext.grid.EditorGridPanel({
        cm: cmCgg_gem_requisito_vacante,
        store: gsCgg_gem_requisito_vacante,
		plugins: [editorCgg_gem_requisito_vacante],
		region:'center',
		view: new Ext.grid.GroupingView({markDirty: false}),		
        sm: new Ext.grid.RowSelectionModel({singleSelect: true}),
        loadMask:{msg: "Cargando..."},
        tbar: tbarReq
    });		
	grdCgg_gem_requisito_vacante.getSelectionModel().on("selectionchange",function(sm){
		btnEliminarRequisito.setDisabled(!sm.hasSelection())
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_vacante.
     */
    var winFrmCgg_gem_vacante = new Ext.Window({
        id: 'winFrmCgg_gem_vacante',
        title: tituloCgg_gem_vacante,
        minWidth: 600,
		minHeight: 400,
		width: 700,
		height:500,
		modal:true,
        maximizable: true,
        minimizable: true,
        constrainHeader: true,
		frame:true,
		layout:'border',
        tbar: getPanelTitulo(tituloCgg_gem_vacante, descCgg_gem_vacante),
        items: [pnlCgg_gem_vacante,grdCgg_gem_requisito_vacante],
        bbar: [btnGuardarCgg_gem_vacante,btnGuardarEnviarCgg_gem_vacante,btnRevisarCgg_gem_vacante,btnCancelarCgg_gem_vacante, '->', btnCerrarCgg_gem_vacante]
		,listeners:{
			show:function(){
				insertCheckboxInTextField("chkCargo","txtCgcrg_codigo");
				insertCheckboxInTextField("chkTitulo","txtCgvcn_titulo_profesional");
				if (txtCgcrg_codigo_COD=='CGCRG0')	chkCargo.setValue(true);
				if (txtCgvcn_titulo_profesional_COD=='CGTPR0')chkTitulo.setValue(true);
			}
		}
    });
	function insertCheckboxInTextField(idCheckbox,idTextField){
		document.getElementById(idTextField).style.paddingRight="20px";			
		var tmpChk = document.getElementById(idCheckbox);
		tmpChk.style.cssText="position: absolute; right:10;top:4";			
		document.getElementById("x-form-el-"+idTextField).appendChild(tmpChk);
	}
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_vacante.
     */
    function cargarCgg_gem_vacanteCtrls() {
        if (inRecordCgg_gem_vacante) {
            txtCgvcn_codigo=inRecordCgg_gem_vacante.get('CGVCN_CODIGO');
            cbxCgtcn_codigo.setValue(inRecordCgg_gem_vacante.get('CGTCN_CODIGO'));
            cbxCgtsa_codigo.setValue(inRecordCgg_gem_vacante.get('CGTSA_CODIGO'));            
			//cbxCsctp_codigo.setValue(inRecordCgg_gem_vacante.get("CSCTP_CODIGO"));						
			
			var tmpJson = inRecordCgg_gem_vacante.get('CGVCN_TITULO');			
			try{
				tmpExtras=eval("("+tmpJson+")");
			}catch(ex){
			}	
			txtCgcrg_codigo_COD = inRecordCgg_gem_vacante.get('CGCRG_CODIGO');
			txtCgcrg_codigo_TXT = inRecordCgg_gem_vacante.get('CGCRG_NOMBRE');
			if (txtCgcrg_codigo_COD=="CGCRG0"){
				txtCgcrg_codigo_TXT = tmpExtras.cargo;
			}
			txtCgcrg_codigo.setValue(txtCgcrg_codigo_TXT);
			
			btnRevisarCgg_gem_vacante.setVisible((tmpExtras.msg.length!=0)?true:false);
            
			txtCgvcn_titulo_profesional_COD =  inRecordCgg_gem_vacante.get('CGTPR_CODIGO')
			txtCgvcn_titulo_profesional_TXT =  inRecordCgg_gem_vacante.get('CGTPR_DESCRIPCION')
			if (txtCgvcn_titulo_profesional_COD=="CGTPR0"){				
				txtCgvcn_titulo_profesional_TXT = tmpExtras.titulo;
			}
			txtCgvcn_titulo_profesional.setValue(txtCgvcn_titulo_profesional_TXT);
            
			txtCgvcn_descripcion.setValue(inRecordCgg_gem_vacante.get('CGVCN_DESCRIPCION'));
            numCgvcn_salario.setValue(inRecordCgg_gem_vacante.get('CGVCN_SALARIO'));
            txtCgvcn_direccion_isla.setValue(inRecordCgg_gem_vacante.get('CGVCN_DIRECCION'));
            dtCgvcn_fecha_ingreso.setValue(inRecordCgg_gem_vacante.get('CGVCN_FECHA_INGRESO'));            
            numCgvcn_numero_vacantes.setValue(inRecordCgg_gem_vacante.get('CGVCN_NUMERO_VACANTES'));
            cbxCgvcn_duracion.setValue(inRecordCgg_gem_vacante.get('CGVCN_DURACION'));
            numCgvcn_duracion_tiempo.setValue(inRecordCgg_gem_vacante.get('CGVCN_DURACION_TIEMPO'));                        
            isEdit = true;
            gsCgg_gem_requisito_vacante.reload({params: {inCgvcn_codigo: inRecordCgg_gem_vacante.get('CGVCN_CODIGO')}});
				
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_vacante.
     * @returns ventana winFrmCgg_gem_vacante.
     * @base FrmCgg_gem_vacante.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_vacante;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_vacante.
     * @base FrmCgg_gem_vacante.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_vacanteCtrls();
    }
	
	this.setStoreTipoSalario = function(inStoreTipoSalario){
		cbxCgtsa_codigo.store = inStoreTipoSalario;
	}
	
	this.setStoreTipoContrato = function(inStoreTipoContrato){
		cbxCgtcn_codigo.store = inStoreTipoContrato;
	}
	
	this.setStoreSectorProductivo = function (inStoreSectorProductivo) {
		//cbxCsctp_codigo.store = inStoreSectorProductivo;
	}	
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_vacante desde una instancia.
 */
FrmCgg_gem_vacante.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_vacante desde una instancia.
 */
FrmCgg_gem_vacante.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_vacante,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_vacante.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_vacante desde una instancia.
 */
FrmCgg_gem_vacante.prototype.loadData = function () {
    this.loadData();
}

FrmCgg_gem_vacante.prototype.setStoreTipoSalario = function (inStoreTipoSalario) {
	this.setStoreTipoSalario(inStoreTipoSalario);
}
FrmCgg_gem_vacante.prototype.setStoreTipoContrato = function (inStoreTipoContrato) {
	this.setStoreTipoContrato(inStoreTipoContrato);
}
FrmCgg_gem_vacante.prototype.setStoreSectorProductivo = function (inStoreSectorProductivo) {
	this.setStoreSectorProductivo(inStoreSectorProductivo);
}