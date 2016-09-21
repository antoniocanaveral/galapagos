function FrmAcercade(){
    var optMenu = 'Configuraci\u00F3n/Acerca de';
	 /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_frase_bienvenida.
     */
    var btnSalirAcercade = new Ext.Button({
		id:'btnSalirAcercade',
		text: 'Salir',
		iconCls: 'iconSalir',
		tooltip:'Cierra el formulario actual',            
		handler:function(){
			winFrmAcercade.close();
		}
	});
	
    /**
 *Crea una ventana para el objecto FrmAcercade.
 */
    var winFrmAcercade = new Ext.Window({
        id:'winFrmAcercade',
        title:'Acerca de..',
        iconCls:'bogus',
        width:420,
        height:360,        
        constrainHeader:true,
		resizable:false,
        layout:'border',
        modal:true,
        items:[{          
            region:'center',            
            html:'<div><table border="0" width="100%" height="100%" style="background-image:url(resources/images/acercade.png)"><tr><td style ="height:170px"></td></tr><tr><td style="font-size:11px" align="center">Para m&aacute;s informaci&oacute;n: <a href="http://www.bmlaurus.com">http://www.bmlaurus.com<a></td></tr></table></div>'
        }],        
        bbar:['->',btnSalirAcercade]
    });

    /**
 *Devuelve la ventada del objecto FrmAcercade.
 */
    this.getWindow = function(){
        return winFrmAcercade;
    } 

}

/**
 * Muestra el formulario.
 */
FrmAcercade.prototype.show = function(){
    this.getWindow().show();
}

/**
 * Estable una funcion para manejar el cierre del formulario.
 * @parama inFunctionHandler Funcion.
 */
FrmAcercade.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}