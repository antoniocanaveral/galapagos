function DlgIngresoFecha(){
	var mySuccess = false;
    var fecha = new Date();

    var pnlIngresoFecha = new Ext.form.FormPanel({
        autoHeigth:true,
        frame:true,
        items:[{
            xtype:'datefield',
            id:'dtFechaIngreso',
            fieldLabel:'Fecha ingreso',
            allowBlank:false,
            blankText:'Establezca la fecha de entrada, por favor.',
            minValue:new Date(),
            value:fecha
        }]
    });

    /**
 *Crea una ventana para el objecto DlgIngresoFecha.
 */
    var winDlgIngresoFecha = new Ext.Window({
        id:'winDlgIngresoFecha',
        title:'Fecha de ingreso',
        width:400,
        minWidth:400,  
        constrain:true,
        tbar: getPanelTitulo('Fecha de ingreso', 'Este formulario le permite establecer la fecha de ingreso de un residente temporal para su creaci\u00f3n como transeunte.'),
        items:[pnlIngresoFecha],
        modal:true,
        bbar: [{
            text:'Aceptar',
            id:"btnAceptar",
            iconCls:'iconAceptar',
            handler:function(){
                if(Ext.getCmp('dtFechaIngreso').isValid()==false){
                    return;
                }
                fecha = Ext.getCmp('dtFechaIngreso').getValue();
		mySuccess = true;
                winDlgIngresoFecha.close();
            }
        },'->',{
            text: 'Cancelar',
            iconCls: 'iconCancelar',
            tooltip:'Cierra el formulario actual.',            
            handler:function(){
		mySuccess = false;
		winDlgIngresoFecha.close();
            }
        }]
    });

	/**
	*Devuelve la ventada del objecto DlgIngresoFecha.
	*/
    	this.getWindow = function(){
        	return winDlgIngresoFecha;
    	}

    	this.getFechaIngreso = function(){
        	return fecha;
    	}
	   
	this.isSuccess = function(){
		return mySuccess;
	}
}

/**
 * Muestra el formulario.
 */
DlgIngresoFecha.prototype.show = function(){
    this.getWindow().show();
}

/**
 * Estable una funcion para manejar el cierre del formulario.
 * @parama inFunctionHandler Funcion.
 */
DlgIngresoFecha.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}

DlgIngresoFecha.prototype.getValue = function(){
    return this.getFechaIngreso();
}

DlgIngresoFecha.prototype.isSuccess = function(){
	return this.isSuccess();
}