/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_entrevista.
 * @param {String} inSentenciaEntrevista Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} inRecEntrevista Registro de datos de la tabla Cgg_gem_entrevista.
 * @constructor
 * @base FrmListadoCgg_gem_entrevista
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_entrevista(inSentenciaEntrevista, inRecEntrevista,inRecordVacante) {
    var urlCgg_gem_entrevista = URL_WS + "Cgg_gem_entrevista";
    var tituloCgg_gem_entrevista = 'Entrevista';
    var descCgg_gem_entrevista = 'El formulario permite administrar la informaci\u00f3n de las entrevistas realizadas';
    var isEdit = false;
	var txtCgcnd_codigo_id= inRecEntrevista.get('CGCND_CODIGO');			
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ENTREVISTA
     */
    var txtCgent_codigo = new Ext.form.TextField({
        id: 'txtCgent_codigo',
        name: 'txtCgent_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    }); 
	var chkInasistencia = new Ext.form.Checkbox({         
		id:'chkInasistencia',         
		name:'chkInasistencia',
		fieldLabel:"Inasistencia?",
		checked:true,
		hidden:true,
		disabled:(inSentenciaEntrevista=="ver")?true:false
	});
    /**
     * Ext.form.TextField ESTABLECE EL VALOR SOBRE EL ESTADO EN EL QUE SE ENCUENTRA LA ENTREVISTA
     0 - NO REALIZADA
	 1 - INASISTENCIA
     2 - REALIZADA 
     */
	storeEstado = [['0','No realizada'],['1','No Realizada'],['2','Realizada']];
	 if (inSentenciaEntrevista=="insert")
		storeEstado= [['2','Realizada'],['0','No realizada']];	
	 
    var cbxCgent_estado_entrevista = new Ext.form.ComboBox({
        id: 'cbxCgent_estado_entrevista',
        name: 'cbxCgent_estado_entrevista',
        fieldLabel: 'Estado entrevista',        
        allowBlank: false,
		store: storeEstado,
		blankText:"Seleccione...",		
        mode:'local',
        editable: false,
		readOnly:(inSentenciaEntrevista=="insert")?false:true,
        triggerAction:'all',
		width:150,
		listeners:{
			select:function(t,nv,ov){
				if (t.getValue()=='0'){
					chkInasistencia.setVisible(true);
					chkInasistencia.setValue(true);
				}else
					chkInasistencia.setVisible(false);
			}
		}
    });
	
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE LA ENTREVISTA
     */
	var fechaPublicacion = inRecordVacante.get ("CGVCN_FECHA_PUBLICACION");
	var duracionOferta = inRecordVacante.get ("CGVCN_DURACION_OFERTA");
	var fechaReal= fechaPublicacion.add(Date.DAY, duracionOferta);
    var dtCgent_fecha_realizacion = new Ext.form.DateField({
        id: 'dtCgent_fecha_realizacion',
        name: 'dtCgent_fecha_realizacion',
        fieldLabel: 'Fecha realizaci\u00f3n',
        allowBlank: false,
        format: 'd/m/Y',		
        value: new Date(),
		maxValue:new Date(),		
		hidden:true
    });

    /**
     * Ext.form.TextField LUGAR DE REALIZACION DE LA ENTREVISTA
     */
    var txtCgent_lugar = new Ext.form.TextField({
        id: 'txtCgent_lugar',
        name: 'txtCgent_lugar',
        fieldLabel: 'Lugar',
        anchor: '90%',
		readOnly:(inSentenciaEntrevista=="ver" || inSentenciaEntrevista=="criterio")?true:false,
        allowBlank: false
    });
    /**
     * Ext.form.TextArea OBSERVACION DE LA ENTREVISTA
     */
    var txtCgent_observacion = new Ext.form.TextArea({
        id: 'txtCgent_observacion',
        name: 'txtCgent_observacion',
        fieldLabel: 'Observaci\u00f3n',
        width: '90%',
        allowBlank: false,
		readOnly:(inSentenciaEntrevista=="ver" || inSentenciaEntrevista=="criterio")?true:false
    });
	var dtCgent_fecha_criterio_tecnico = new Ext.form.DateField({
        id: 'dtCgent_fecha_criterio_tecnico',
        name: 'dtCgent_fecha_criterio_tecnico',
        fieldLabel: 'Fecha criterio t\u00e9cnico',        		
        format: 'd/m/Y',		
		readOnly:true,
        value: new Date(),
		maxValue:new Date(),		
		minValue : dtCgent_fecha_realizacion.getValue(),
		hidden:true
    });
	var txtCgent_criterio_tecnico = new Ext.form.TextArea({
		id:'txtCgent_criterio_tecnico',
		name:'txtCgent_criterio_tecnico',
		fieldLabel :'Criterio tecnico',
		readOnly:(inSentenciaEntrevista=="ver")?true:false,
		width:'90%',
		hidden:(inSentenciaEntrevista=="insert")?true:false
	});
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_entrevista
     */
    var btnGuardarCgg_gem_entrevista = new Ext.Button({
        id: 'btnGuardarCgg_gem_entrevista',
        text: 'Guardar',
        iconCls: 'iconGuardar',
		hidden:(inSentenciaEntrevista=="ver")?true:false,
        listeners: {
            click: function () {
                if (pnlCgg_gem_entrevista.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_gem_entrevista(r) {
                        winFrmCgg_gem_entrevista.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_gem_entrevista,
                                msg: 'La informaci\u00f3n correspondiente a la entrevista ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_gem_entrevista.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_gem_entrevista,
                                msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_gem_entrevista.getEl().mask('Guardando...', 'x-mask-loading');
					var tmpSentenciaEntrevista = inSentenciaEntrevista;
                    var param = new SOAPClientParameters();
					var estadoEntrevista = 2;
					if (cbxCgent_estado_entrevista.getValue() == 0)
						if (chkInasistencia.getValue())
							estadoEntrevista = 1;
						else
							estadoEntrevista = 0;						
                    if (isEdit) 
						param.add('inCgent_codigo', txtCgent_codigo.getValue());
                    if (inSentenciaEntrevista=='criterio'){
						tmpSentenciaEntrevista="registrarCriterioTecnico";
						param.add('inCgent_fecha_criterio_tecnico', dtCgent_fecha_criterio_tecnico.getValue().format('c'));
						param.add('inCgent_criterio_tecnico', txtCgent_criterio_tecnico.getValue());
					}else{
						param.add('inCgcnd_codigo', txtCgcnd_codigo_id);
						param.add('inCgent_estado_entrevista', estadoEntrevista);
						param.add('inCgent_fecha_realizacion', dtCgent_fecha_realizacion.getValue().format('c'));
						param.add('inCgent_lugar', txtCgent_lugar.getValue());
						param.add('inCgent_observacion', txtCgent_observacion.getValue());
					}
                    SOAPClient.invoke(urlCgg_gem_entrevista,tmpSentenciaEntrevista , param, true, CallBackCgg_gem_entrevista);
                } catch (inErr) {
                    winFrmCgg_gem_entrevista.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_entrevista.
     */
    var btnCancelarCgg_gem_entrevista = new Ext.Button({
        id: 'btnCancelarCgg_gem_entrevista',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
		hidden:(inSentenciaEntrevista=="ver")?true:false,
        listeners: {
            click: function () {
                pnlCgg_gem_entrevista.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_entrevista.
     */
    var btnCerrarCgg_gem_entrevista = new Ext.Button({
        id: 'btnCerrarCgg_gem_entrevista',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_entrevista.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_entrevista.
     */
    var pnlCgg_gem_entrevista = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,		
		autoScroll:true,
        items: [{
			xtype:'fieldset',
			title: 'Datos entrevista',
			autoHeight:true,				
			items :[dtCgent_fecha_realizacion,txtCgent_codigo,cbxCgent_estado_entrevista,chkInasistencia, txtCgent_lugar, txtCgent_observacion				
			]
		},{		
			xtype:'fieldset',
			title: 'Criterio t\u00e9cnico',
			autoHeight:true,			
			collapsed: (inSentenciaEntrevista=="insert" || inSentenciaEntrevista=="update")?true:false,			
			items :[dtCgent_fecha_criterio_tecnico,txtCgent_criterio_tecnico]
		}]
    });
	
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_entrevista.
     */
    var winFrmCgg_gem_entrevista = new Ext.Window({
        id: 'winFrmCgg_gem_entrevista',
        title: tituloCgg_gem_entrevista,
        width: 400,
        minWidth: 400,			
        maximizable: true,
        minimizable: true,		
        constrainHeader: true,
		modal:true,
        tbar: getPanelTitulo(tituloCgg_gem_entrevista, descCgg_gem_entrevista),
        items: [pnlCgg_gem_entrevista],
        bbar: [btnGuardarCgg_gem_entrevista, btnCancelarCgg_gem_entrevista, '->', btnCerrarCgg_gem_entrevista]
    });
    
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_entrevista.
     */	
    function cargarCgg_gem_entrevistaCtrls() {
        if (inRecEntrevista) {
            txtCgent_codigo.setValue(inRecEntrevista.get('CGENT_CODIGO'));            
            cbxCgent_estado_entrevista.setValue(inRecEntrevista.get('CGENT_ESTADO_ENTREVISTA'));	
			if (inRecEntrevista.get('CGENT_ESTADO_ENTREVISTA')==1 || inRecEntrevista.get('CGENT_ESTADO_ENTREVISTA')==0){			
				chkInasistencia.setVisible(true);
				if (inRecEntrevista.get('CGENT_ESTADO_ENTREVISTA')==1)
					chkInasistencia.setValue(true);
				else
					chkInasistencia.setValue(false);
			}
            dtCgent_fecha_realizacion.setValue(inRecEntrevista.get('CGENT_FECHA_REALIZACION'));
            dtCgent_fecha_criterio_tecnico.setValue(inRecEntrevista.get('CGENT_FECHA_CRITERIO_TECNICO'));
			if (dtCgent_fecha_criterio_tecnico.getValue().length==0)
				dtCgent_fecha_criterio_tecnico.setValue(new Date());
			dtCgent_fecha_criterio_tecnico.setMinValue(inRecEntrevista.get('CGENT_FECHA_REALIZACION'));
            txtCgent_lugar.setValue(inRecEntrevista.get('CGENT_LUGAR'));
            txtCgent_criterio_tecnico.setValue(inRecEntrevista.get('CGENT_CRITERIO_TECNICO'));
            txtCgent_observacion.setValue(inRecEntrevista.get('CGENT_OBSERVACION'));
            isEdit = true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_entrevista.
     * @returns ventana winFrmCgg_gem_entrevista.
     * @base FrmCgg_gem_entrevista.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_entrevista;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_entrevista.
     * @base FrmCgg_gem_entrevista.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_entrevistaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_entrevista desde una instancia.
 */
FrmCgg_gem_entrevista.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_entrevista desde una instancia.
 */
FrmCgg_gem_entrevista.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_entrevista,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_entrevista.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_entrevista desde una instancia.
 */
FrmCgg_gem_entrevista.prototype.loadData = function () {
    this.loadData();
}