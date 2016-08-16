/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_notificacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_notificacion(inDesktop){
    var optMenu = 'Control de Residencia/Notificaciones';
    var urlListadoCgg_res_notificacion=URL_WS+"Cgg_res_notificacion";
    var tituloListadoCgg_res_notificacion='Listado notificaci\u00f3n';
    var descListadoCgg_res_notificacion='Formulario que permite administrar informaci\u00f3n de las notificaciones de las personas irregulares';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_notificacion.
     */
    var btnNuevoCgg_res_notificacion = new Ext.Button({
        id:'btnNuevoCgg_res_notificacion',
        text:'Nuevo',
        iconCls:'iconNuevo',

        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_notificacion = new FrmCgg_res_notificacion("insert");
                objCgg_res_notificacion.closeHandler(function(){
                    gsCgg_res_notificacion.reload();
                });
                objCgg_res_notificacion.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_notificacion.
     */
    var btnEditarCgg_res_notificacion = new Ext.Button({
        id:'btnEditarCgg_res_notificacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_res_notificacion.getSelectionModel().getSelected();
                if(r){
                    //	if(r.data.CRNOT_ESTADO_NOTIFICACION < 3){
                    var objCgg_res_notificacion = new FrmCgg_res_notificacion("update",r);
                    objCgg_res_notificacion.closeHandler(function(){
                        gsCgg_res_notificacion.reload();
                    });
                    objCgg_res_notificacion.loadData();
                    objCgg_res_notificacion.show();
                /*}else{
                    		Ext.Msg.show({
                                    title:tituloListadoCgg_res_notificacion,
                                    msg: 'La notificaci\u00f3n ya fue procesada. No se puede modificar.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                    	}*/
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_notificacion.
     */
//MO
    /*var btnEliminarCgg_res_notificacion = new Ext.Button({
        id:'btnEliminarCgg_res_notificacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso', 
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_notificacion,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_notificacion(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_notificacion(r){
                                winFrmListadoCgg_res_notificacion.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_notificacion,
                                        msg: 'La informaci\u00f3n de notificaci\u00f3n ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_notificacion.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_notificacion,
                                        msg: 'La informaci\u00f3n de notificaci\u00f3n no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_notificacion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrnot_codigo',grdCgg_res_notificacion.getSelectionModel().getSelected().get('CRNOT_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_notificacion,"delete",param, true, CallBackCgg_res_notificacion);
                        }catch(inErr){
                            winFrmListadoCgg_res_notificacion.getEl().unmask();
                        }
                    }
                }
            }
        }
    });*/
//

	  var btnProcesarCgg_res_notificacion = new Ext.Button({
          id:'btnProcesarCgg_res_notificacion',
          text:'Procesar Notificacion',
          listeners:{
              click:function() {

                  ActualizarNotificacion();
              }}
      });

//MO

    /**
     * Ext.Button BotÓn que permite generar reporte con las
     personas que han sobrepasado el tiempo de 60 días.
     */

    var btnReporteCgg_res_notificacion = new Ext.Button({
        id:'btnReporteCgg_res_notificacion',
        text:'Generar Reporte',
        listeners:{
            click:function() {

                //ActualizarNotificacion();
            }}
    });

//

    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_registro.
     */
    var btnOfflineCSVCgg_res_notificacion = new Ext.Button({
        id:'btnOfflineCSVCgg_res_notificacion',
        text:'Subir CSV offline',
        iconCls:'iconAddCSV',    
        listeners:{
            click:function(){
                var winCSV = MyDesktop.desktop.getWindow('winFrmCgg_res_notificacion_csv');
                if (!winCSV)
                    winCSV = new FrmCgg_res_notificacion_csv(MyDesktop.desktop);				
                winCSV.show();				
            }
        }
    });
		function ActualizarNotificacion(){
    		function CallBackCgg_res_notificacion_update(r) {
                      if (r == 'true') {
                          Ext.Msg.show({
                              title: tituloListadoCgg_res_notificacion,
                              msg: 'La informaci\u00f3n  ha sido actualizada.',
                              buttons: Ext.Msg.OK,
                              icon: Ext.MessageBox.INFO
                          });
                          gsCgg_res_notificacion.reload();
                      } else {
                          Ext.Msg.show({
                              title: tituloListadoCgg_res_notificacion,
                              msg: 'La informaci\u00f3n no ha podido ser actualizada. ' ,
                              buttons: Ext.Msg.OK,
                              icon: Ext.MessageBox.ERROR
                          });
                      }
                  }
                  SOAPClient.invoke(urlListadoCgg_res_notificacion,"updateEstado", false, false, CallBackCgg_res_notificacion_update);
		}

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_notificacion.
     */
    var btnSalirCgg_res_notificacion = new Ext.Button({
        id:'btnSalirCgg_res_notificacion',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_notificacion.close();
            }
        }
    });  

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_notificacion.
     */
    var cmCgg_res_notificacion = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRNOT_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRTNT_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRNOT_NUMERO_NOTIFICACION',
        header:'No.',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'Cedula/pasaporte',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:250,
        sortable:true
    },
    {
        dataIndex:'CRNOT_FECHA_NOTIFICACION',
        header:'Fecha notificaci\u00f3n',
        width:100,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CANTON_NOTIFICACION',
        header:'Cant\u00f3n not.',
        width:100,
        sortable:true
    },
    {
        dataIndex:'NOMBRE_OFICIAL',
        header:'Oficial not.',
        width:250,
        sortable:true
    },
    {
        dataIndex:'CRTNT_SUSTENTO_LEGAL',
        header:'Sustento legal',
        width:300,
        sortable:true
    },
    {
        dataIndex:'CRNOT_LUGAR_NOTIFICACION',
        header:'Lugar notificacion',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRNOT_REFERENCIA',
        header:'Referencia',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRNOT_ESTADO_NOTIFICACION',
        header:'Estado',
        width:100,
        sortable:true,
        renderer:function(inCrnotestadoNtificacion){
            return dsEstadoNotificacion[inCrnotestadoNtificacion][1]||inCrnotestadoNtificacion;
        }
    },
    {
        dataIndex:'CRNOT_REGULARIZACION',
        header:'Regularizaci\u00f3n',
        width:100,
        sortable:true,
        renderer:function(inCrnotRegularizacion){
            if (dsEstadoPermitidoNotificacion[inCrnotRegularizacion])
                return dsEstadoPermitidoNotificacion[inCrnotRegularizacion][1];
            else
                return inCrnotRegularizacion;
        }
    },
    {
        dataIndex:'CRNOT_PROCEDE_NOTIFICACION',
        hidden:true,
        header:'Procede not.',
        width:150,
        sortable:true,
        xtype: 'booleancolumn', 
        trueText: 'Si',
        falseText: 'No'
    },
    {
        dataIndex:'CUSU_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'NOMBRES_USUARIO_REGISTRO',
        hidden:true,
        header:'Usuario registro',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CGG_CUSU_CODIGO',
        hidden:true,
        header:'Cusu codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRDEN_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRDEN_NUMERO',
        header:'No. denuncia',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CGG_CROSG_CODIGO',
        hidden:true,
        header:'Crosg codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'NOMBRE_AUDIENCIA',
        header:'Oficial audiencia',
        width:250,
        sortable:true
    },
    {
        dataIndex:'CRNOT_FECHA_AUDIENCIA',
        header:'Fecha audiencia',
        width:100,
        sortable:true,
        renderer:truncDate,
        hidden:true
    }]);
        
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_notificacion por un campo especifico.
     */
    var gsCgg_res_notificacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_notificacion",
            method:"selectNotificacionConsulta",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRNOT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRNOT_CODIGO'
        }, 

        {
            name:'CRTNT_CODIGO'
        },

        {
            name:'CRTNT_SUSTENTO_LEGAL'
        },

        {
            name:'CRPER_CODIGO'
        }, 

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_NUMERO_RESIDENCIA'
        },

        {
            name:'CRPER_PARROQUIA'
        },

        {
            name:'CRPER_NACIONALIDAD'
        },

        {
            name:'CUSU_CODIGO'
        },

        {
            name:'NOMBRES_USUARIO_REGISTRO'
        },

        {
            name:'CGG_CUSU_CODIGO'
        }, 

        {
            name:'NOMBRES_USUARIO_AUDIENCIA'
        },

        {
            name:'CRRES_CODIGO'
        }, 

        {
            name:'CRRES_RESOLUCION'
        },

        {
            name:'CRDEN_CODIGO'
        },

        {
            name:'CRDEN_NUMERO'
        },

        {
            name:'CRDEN_DESCRIPCION'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CANTON_NOTIFICACION'
        },

        {
            name:'CROSG_CODIGO'
        }, 

        {
            name:'NOMBRE_OFICIAL'
        },

        {
            name:'CGG_CROSG_CODIGO'
        }, 

        {
            name:'NOMBRE_AUDIENCIA'
        },

        {
            name:'CRNOT_NUMERO_NOTIFICACION'
        }, 

        {
            name:'CRNOT_FECHA_NOTIFICACION'
        }, 

        {
            name:'CRNOT_LUGAR_NOTIFICACION'
        }, 

        {
            name:'CRNOT_REFERENCIA'
        }, 

        {
            name:'CRNOT_OBSERVACION'
        },

        {
            name:'CRNOT_ESTADO_NOTIFICACION'
        }, 

        {
            name:'CRNOT_ESTADO'
        }, 

        {
            name:'CRNOT_REGULARIZACION'
        }, 

        {
            name:'CRNOT_FECHA_AUDIENCIA'
        }, 

        {
            name:'CRNOT_EXTRACTO_AUDIENCIA'
        }, 

        {
            name:'CRNOT_OBSERVACION_AUDIENCIA'
        }, 

        {
            name:'CRNOT_PROCEDE_NOTIFICACION'
        }, 

        {
            name:'CRNOT_DESCRIPCION_ADJUNTO_AUD'
        }, 

        {
            name:'CRNOT_NOMBRE_ADJUNTO_AUDIENCIA'
        }, 

        {
            name:'CRNOT_ADJUNTO_AUDIENCIA'
        }, 

        {
            name:'CRNOT_FECHA_SALIDA_VOLUNT'
        }, 

        {
            name:'CRNOT_FECHA_EXPULSION'
        }
        ]),
        sortInfo:{
            field: 'CRNOT_FECHA_NOTIFICACION', 
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                for (var i = 0; i < inRecords.length; i++){
                    var tmpCaduca = inRecords[i].get('CRNOT_ESTADO_NOTIFICACION');
                    if(tmpCaduca==TypeEstadoNotificacion.ANULADA){
                        grdCgg_res_notificacion.getView().getRow(i).style.backgroundColor = 'FF3366';
                    }

                }
            }
        }
    });



    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_notificacion.
     */
    var pgBarCgg_res_notificacion= new Ext.PagingToolbar({
        store: gsCgg_res_notificacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_notificacion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_notificacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_notificacion,
        store:gsCgg_res_notificacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ', ' ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_res_notificacion,
            width:200
        })
        ],
        bbar:pgBarCgg_res_notificacion,
        listeners:{
            /* rowclick :function(inGrid,inNumero,inObjeto){
               // tmpFecha = isEdit && dtCrnot_fecha_salida_volunt.getValue() ? dtCrnot_fecha_salida_volunt.getValue().format('d/m/Y') : null;
                if (grdCgg_res_notificacion.getSelectionModel().getSelected().get('CRNOT_FECHA_EXPULSION').format('d/m/Y')= null){
                    Ext.MessageBox.alert('Registro de notificacion', 'Registro sin audiencia, imposible editar');
                    btnEditarCgg_res_notificacion.disable();
                }else{
                    btnEditarCgg_res_notificacion.enable();
                }
            },*/
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_notificacion.hidden){
                    btnEditarCgg_res_notificacion.fireEvent('click', btnEditarCgg_res_notificacion);
                }
            }
        }
    });
    gsCgg_res_notificacion.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_notificacion.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_notificacion = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_notificacion',
            title:tituloListadoCgg_res_notificacion,
            tbar:getPanelTitulo(''+tituloListadoCgg_res_notificacion,descListadoCgg_res_notificacion),
            items:[grdCgg_res_notificacion],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrainHeader:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_notificacion,btnEditarCgg_res_notificacion,'-',btnProcesarCgg_res_notificacion,'-',btnReporteCgg_res_notificacion,'->',btnSalirCgg_res_notificacion]
// MO       //bbar:[btnNuevoCgg_res_notificacion,btnEditarCgg_res_notificacion,btnEliminarCgg_res_notificacion,'-',btnProcesarCgg_res_notificacion,'->',btnSalirCgg_res_notificacion]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_notificacion.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_notificacion.
     * @returns ventana winFrmCgg_res_notificacion.
     * @base FrmListadoCgg_res_notificacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_notificacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_notificacion.
     * @base FrmListadoCgg_res_notificacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_notificacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_notificacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_notificacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_notificacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_notificacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_notificacion desde una instancia.
 */
FrmListadoCgg_res_notificacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_notificacion desde una instancia.
 */
FrmListadoCgg_res_notificacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_notificacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_notificacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_notificacion desde una instancia.
 */
FrmListadoCgg_res_notificacion.prototype.loadData = function(){
    this.loadData();
}
