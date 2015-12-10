/**
 *FUNCION PUBLICA. FORMULARIO QUE PERMITE VISUALIZAR EN FORMA DE LISTADO, LA INFORMACION DE LOS REGISTROS DE LA TABLA BUSQUEDA.
 *@param gsBusqueda CONTIENE LOS DATOS QUE RETORNA EL WEBSERVICE
 *@param cmBusqueda DEFINICION DE LAS COLUMNAS DEL GRID
 *@param inMultiSelect SI LA BUSQUEDA PERMITE UNA SELECCION MULTIPLE DE DE LAS FILAS
 */
function DlgBusquedaNoPaginado(gsBusqueda, cmBusqueda, inMultiSelect){
    var r=null;
    var tmpSelectionModel;
    var multiSelect = inMultiSelect;

   var btnAceptarBusqueda = new Ext.Button({
        id:'btnAceptarBusqueda',
        text:'Seleccionar',
        iconCls:'iconAceptar',
        handler:function (){
            if(multiSelect == true){
                r = grdBusqueda.getSelectionModel().getSelections();
            }else{
                r = grdBusqueda.getSelectionModel().getSelected();
            }
            if(r!== null && r!== undefined){
                winBusquedaNoPaginado.close();
            }
        }
    });

    var btnCancelarBusqueda = new Ext.Button({
        id:'btnCancelarBusqueda',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            r = null;            
            winBusquedaNoPaginado.close();
        }
    });

    if(multiSelect != undefined && multiSelect == true){
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
           format:TypeFormat.JSON
        }
    });


    var grdBusqueda = new Ext.grid.EditorGridPanel({
        cm:cmBusqueda,
        store:gsBusqueda,
        region:'center',
        sm:tmpSelectionModel,
        loadMask:{
            msg:"Cargando..."
        },
        tbar: ['Buscar: ', ' ',new Ext.ux.bsx.SearchField({
            store:gsBusqueda,
            width:200,
            pagin:false
        })],
         listeners:{
            rowdblclick:function(){
                if(multiSelect == true){
                    r = grdBusqueda.getSelectionModel().getSelections();
                }else{
                    r = grdBusqueda.getSelectionModel().getSelected();
                }
                if(r!== null && r!== undefined){
                    winBusquedaNoPaginado.close();
                }
            }
        }
    });

    var winBusquedaNoPaginado = new Ext.Window({
        id:'winBusquedaNoPaginado',
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
        bbar:[btnAceptarBusqueda,'->',btnCancelarBusqueda]
    });
    /**
     *FUNCION MIEMBRO QUE DEVUELVE LA VENTANA winBusquedaNoPaginado
     * @returns VENTANA winBusquedaNoPaginado.
     */      
    this.getWindow = function(){
        return winBusquedaNoPaginado;
    }
    /**
     *FUNCION PERMITE OBTENER LA FILA SELECCIONADA.
     *@return r FILA SELECCIONADA
     */
    this.getSelectedRow = function(){
        return r;
    }
    /**
     *FUNCION QUE PERMITE OBTENER LAS FILAS SELECCIONADAS.
     *@return r FILAS SELECCIONADAS
     */
    this.getSelectedRows = function(){
        return r;
    }
    /**
     *FUNCION QUE OBTIENE LA INFORMACION RELACIONADA A LA BUSQUEDA EN UN GRID .
     *@return grdBusqueda INFORMACION OBTENIDA
     */
    this.getGrid = function(){
        return grdBusqueda;
    }
    /**
     *FUNCION QUE ESTABLECE EL TITULO.
     *@param inTitle TITULO
     */
	this.setTitle = function(inTitle){
		winBusquedaNoPaginado.setTitle(inTitle);
	}
}

/**
 *FUNCION PROTOTIPO. PERMITE ESTABLECER EL TITULO DE LA VENTANA.
 */
DlgBusquedaNoPaginado.prototype.setTitle = function(inTitle){
    this.setTitle(inTitle);
}

/**
 *FUNCION PROTOTIPO. PERMITE MOSTRAR LA VENTANA WINBUSQUEDANOPAGINADO DESDE UNA INSTANCIA.
 */
DlgBusquedaNoPaginado.prototype.show = function(){
    this.getWindow().show();
}
/**
 *FUNCION PROTOTIPO. PERMITE OBTENER LA FILA SELECCIONADA.
 */
DlgBusquedaNoPaginado.prototype.getSelectedRow = function(){
    this.getSelectedRow();
}
/**
 *FUNCION PROTOTIPO. PERMITE OBTENER LAS FILAS SELECCIONADAS.
 */
DlgBusquedaNoPaginado.prototype.getSelectedRows = function(){
    this.getSelectedRows();
}
/**
 *FUNCION PROTOTIPO. PERMITE CERRAR LA VENTANA WINBUSQUEDANOPAGINADO DESDE UNA INSTANCIA.
 */
DlgBusquedaNoPaginado.prototype.close = function(){
    this.getWindow().close();
}

/**
 *FUNCION PROTOTIPO. PERMITE SABER SI SE HA CERRADO LA VENTANA WINBUSQUEDANOPAGINADO,
 *CON EL FIN DE REALIZAR OTRAS ACCIONES DESDE UNA INSTANCIA.
 *@param inFunctionHandler FUNCION
 */
DlgBusquedaNoPaginado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
