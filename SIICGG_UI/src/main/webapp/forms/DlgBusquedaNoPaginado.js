/**
 *Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Busqueda.
 *@constructor
 *@author Besixplus Cia. Ltda.
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
            width:200
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
       
    this.getWindow = function(){
        return winBusquedaNoPaginado;
    }
    this.getSelectedRow = function(){
        return r;
    }
    this.getSelectedRows = function(){
        return r;
    }
    this.getGrid = function(){
        return grdBusqueda;
    }
	this.setTitle = function(inTitle){
		winBusquedaNoPaginado.setTitle(inTitle);
	}
}

/**
 *Funcion prototipo. Permite establecer el titulo de la ventana.
 */
DlgBusquedaNoPaginado.prototype.setTitle = function(inTitle){
    this.setTitle(inTitle);
}

/**
 *Funcion prototipo. Permite mostrar la ventana winBusquedaNoPaginado desde una instancia.
 */
DlgBusquedaNoPaginado.prototype.show = function(){
    this.getWindow().show();
}

DlgBusquedaNoPaginado.prototype.getSelectedRow = function(){
    this.getSelectedRow();
}

DlgBusquedaNoPaginado.prototype.getSelectedRows = function(){
    this.getSelectedRows();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winBusquedaNoPaginado desde una instancia.
 */
DlgBusquedaNoPaginado.prototype.close = function(){
    this.getWindow().close();
}

/**
 *Funcion prototipo. Permite saber si se ha cerrado la ventana winBusquedaNoPaginado,
 *con el fin de realizar otras acciones desde una instancia.
 */
DlgBusquedaNoPaginado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
