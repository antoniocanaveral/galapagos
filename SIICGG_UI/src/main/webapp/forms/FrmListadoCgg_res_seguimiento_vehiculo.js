/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_seguimiento.
* @constructor
* @param inDesktop Escritorio web de la aplicacion.
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_seguimiento_vehiculo(inDesktop){
	var optMenu = 'Veh\u00edculos/Seguimiento de tr\u00e1mites';
	/**
	* Ext.Button Boton que permite cambiar la vista de la ventana winFrmListadoCgg_res_seguimiento.
	*/
    var btnModoVehiculoCgg_res_seguimiento = new Ext.Button({
        id:'btnModoVehiculoCgg_res_seguimiento',
        text:'Modo veh\u00edculos',
        iconCls:'iconVehiculos',
        tooltip:'Cambio a modo para veh\u00edculos',
        listeners:{
            click:function(){
            }
        }
    });
	
	var tmpFrmSeguimiento = inDesktop.getWindow('winFrmListadoCgg_res_seguimiento');
	
	if(!tmpFrmSeguimiento){
		tmpFrmSeguimiento = new FrmListadoCgg_res_seguimiento(inDesktop);
		tmpFrmSeguimiento.setVehiculo();
	}else{
		Ext.MessageBox.alert('Informaci\u00f3n', 'Por favor cierre el formulario de seguimiento de tr\u00e1mites de residencia.');
	}
    /**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_seguimiento_vehiculo.
* @returns ventana winFrmCgg_res_seguimiento.
* @base FrmListadoCgg_res_seguimiento_vehiculo.prototype.show
*/
    this.getWindow = function(){
        return tmpFrmSeguimiento;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_seguimiento_vehiculo.
* @base FrmListadoCgg_res_seguimiento_vehiculo.prototype.loadData
*/
    this.loadData = function(){
        tmpFrmSeguimiento.load();
    }
    /**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
    this.getColumnModel = function(){
        return tmpFrmSeguimiento.getColumnModel();
    }
    /**
* Funcion miembro que develve el Store utilizado en el listado.
*/
    this.getStore = function(){
        return tmpFrmSeguimiento.getStore();
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_seguimiento_vehiculo desde una instancia.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_seguimiento_vehiculo desde una instancia.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_seguimiento_vehiculo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_seguimiento_vehiculo desde una instancia.
*/
FrmListadoCgg_res_seguimiento_vehiculo.prototype.loadData = function(){
    this.loadData();
}
