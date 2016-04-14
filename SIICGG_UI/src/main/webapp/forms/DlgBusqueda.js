/**
 *FUNCION PUBLICA. FORMULARIO QUE PERMITE VISUALIZAR EN FORMA DE LISTADO, LA INFORMACION DE LOS REGISTROS DE TABLA BUSQUEDA.
 *@param gsBusqueda CONTIENE LOS DATOS QUE RETORNA EL WEBSERVICE
 *@param cmBusqueda DEFINICION DE LAS COLUMNAS DEL GRID
 *@param inMultiSelect SI LA BUSQUEDA PERMITE UNA SELECCION MULTIPLE DE DE LAS FILAS
 */
function DlgBusqueda(gsBusqueda, cmBusqueda, inMultiSelect){
    var r=null;
    var tmpSelectionModel;
    var multiSelect = inMultiSelect;
	
   var btnAceptarBusqueda = new Ext.Button({
        id:'btnAceptarBusqueda',
        text:'Seleccionar',
        iconCls:'iconAceptar',
        listeners:{
			click:function (){
				if(multiSelect == true){
					r = grdBusqueda.getSelectionModel().getSelections();
				}else{
					r = grdBusqueda.getSelectionModel().getSelected();
				}
				if(r)
					winBusqueda.close();
			}
		}
    });

    var btnCancelarBusqueda = new Ext.Button({
        id:'btnCancelarBusqueda',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            r = null;
            winBusqueda.close();
        }
    });
    
    var pagBarBusqueda= new Ext.PagingToolbar({
        store: gsBusqueda,
        displayInfo: true,
        pageSize:30,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci&oacute;n para mostrar'
    });
	
	if(multiSelect && multiSelect == true){
		tmpSelectionModel = new Ext.grid.CheckboxSelectionModel();
		cmBusqueda.config.splice(0,0, tmpSelectionModel);
	}else{
		multiSelect = false;
		tmpSelectionModel = new Ext.grid.RowSelectionModel({
			singleSelect:!multiSelect
		});
	}
	gsBusqueda.reload({
        params:{
            start:0,
            limit:RECORD_PAGE
        }
    });
    var grdBusqueda = new Ext.grid.GridPanel({
        cm:cmBusqueda,
        store:gsBusqueda,
        region:'center',
        sm:tmpSelectionModel,
        loadMask:{
            msg:"Cargando..."
        },
        tbar: ['Buscar: ', ' ',new Ext.ux.bsx.SearchField({
                id:'sfBusqueda',
            store:gsBusqueda,
            width:200
        })],
        bbar:pagBarBusqueda,
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        listeners:{
            rowdblclick:function(){
                if(!btnAceptarBusqueda.disabled){
                    btnAceptarBusqueda.fireEvent('click', btnAceptarBusqueda);
                }
            }
        }
    });

    var winBusqueda = new Ext.Window({
        id:'winBusqueda',
        title:"Buscar",
        items:[grdBusqueda],
        width:600,
        minWidth:600,
        height:300,
        minHeight:400,
        maximizable:true,
        constrain:true,
        modal:true,
        layout:'border',        
        bbar:[btnAceptarBusqueda,'->',btnCancelarBusqueda],
        listeners:{
            show:function(){
                Ext.getCmp('sfBusqueda').focus(true,400);
            }
        }
    });
    /**
     *FUNCION MIEMBRO QUE DEVUELVE LA VENTANA winBusqueda
     * @returns VENTANA winBusqueda.
     */            
    this.getWindow = function(){
        return winBusqueda;
    }
    /**
     *FUNCION PERMITE OBTENER LA FILA SELECCIONADA.
     *@return r FILA SELECIONADA
     */
    this.getSelectedRow = function(){
        return r;
    }
    /**
     *FUNCION PERMITE OBTENER LAS FILAS SELECCIONADAS.
     *@return r FILAS SELECCIONADAS
     */
    this.getSelectedRows = function(){
        return r;
    }
    /**
     *FUNCION QUE OBTIENE LA INFORMACION RELACIONADA A LA BUSQUE EN UN GRID .
     *@return grdBusqueda
     */
    this.getGrid = function(){
        return grdBusqueda;
    }

}

/**
 *FUNCION PROTOTIPO. PERMITE MOSTRAR LA VENTANA WINBUSQUEDA DESDE UNA INSTANCIA.
 */
DlgBusqueda.prototype.show = function(){
    this.getWindow().show();
}
/**
 *FUNCION PROTOTIPO. PERMITE OBTENER LA FILA SELECCIONADA.
 */
DlgBusqueda.prototype.getSelectedRow = function(){
    this.getSelectedRow();
}
/**
 *FUNCION PROTOTIPO. PERMITE OBTENER LAS FILAS SELECCIONADAS.
 */
DlgBusqueda.prototype.getSelectedRows = function(){
    this.getSelectedRows();
}
/**
 *FUNCION PROTOTIPO. PERMITE CERRAR LA VENTANA WINBUSQUEDA DESDE UNA INSTANCIA.
 */
DlgBusqueda.prototype.close = function(){
    this.getWindow().close();
}

/**
 *FUNCION PROTOTIPO. PERMITE SABER SI SE HA CERRADO LA VENTANA WINBUSQUEDA,
 *CON EL FIN DE REALIZAR OTRAS ACCIONES DESDE UNA INSTANCIA.
 */
DlgBusqueda.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
