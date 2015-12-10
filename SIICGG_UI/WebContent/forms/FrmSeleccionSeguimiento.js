/**
 *Funcion. Crea el objeto FrmSeleccionSeguimiento para seleccion de seguimiento de fases a las que se despacha un seguimiento de un tramite.
 */
function DlgSeleccionSeguimiento(){

    var tituloDlgSeleccionSeguimiento = 'Seleccion de seguimiento';
    var descDlgSeleccionSeguimiento = 'Este formulario le permite seleccionar el o los seguimientos a los que desea despachar el seguimiento de su tr\u00E1mite.';


 var btnNuevoDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnNuevoDlgSeleccionSeguimiento',
        text:'Seleccionar',
        iconCls:'iconAceptar',
        handler:function (){
            
        }
    });

    var btnCerrarDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnCerrarDlgSeleccionSeguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            
        }
    });

    

    var winDlgSeleccionSeguimiento = new Ext.Window({
        id:'winDlgSeleccionSeguimiento',
        title:tituloDlgSeleccionSeguimiento,
        tbar:getPanelTitulo(tituloDlgSeleccionSeguimiento,descDlgSeleccionSeguimiento),
        items:[grdCgg_res_resolucion],
        width:600,
        minWidth:600,
        height:300,
        minHeight:400,
        maximizable:true,
        constrain:true,
        modal:true,
        layout:'border',        
        bbar:[btnNuevoDlgSeleccionSeguimiento,'->',btnCerrarDlgSeleccionSeguimiento]
    });

}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmSeleccionSeguimiento.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmSeleccionSeguimiento.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmSeleccionSeguimiento.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmSeleccionSeguimiento.prototype.loadData = function(){
    this.loadData();
}


