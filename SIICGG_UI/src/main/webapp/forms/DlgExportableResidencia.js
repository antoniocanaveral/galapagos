/**
 *Funcion. Crea el objeto FrmSeleccionSeguimiento para seleccion de seguimiento de fases a las que se despacha un seguimiento de un tramite.
 */
function DlgExportableResidencia(){

    var tituloDlgSeleccionSeguimiento = 'Exportable aerolineas';
    var descDlgSeleccionSeguimiento = 'Este formulario le permite exportar los datos de residentes en formato CSV.';


    var btnNuevoDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnNuevoDlgSeleccionSeguimiento',
        text:'Seleccionar',
        iconCls:'iconAceptar',
        handler:function (){
            var url = 'https://'+ URL_SERVER +URL_WS+'ExportableResidenteSRV?TIPO='+cbxExportableTipo.getValue()+'&TIPO_RESIDENCIA='+cbxTipoResidencia.getValue();
            var open_link = window.open('');
            open_link.location= url ;
        }
    });

    var btnCerrarDlgSeleccionSeguimiento = new Ext.Button({
        id:'btnCerrarDlgSeleccionSeguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        handler:function (){
            winDlgExportableResidencia.close();
        }
    });

    var cbxTipoResidencia = new Ext.form.ComboBox({
        id:'cbxTipoResidencia',
        name:'cbxTipoResidencia',
        store: dsExportableResidencia,
        anchor:'75%',
        fieldLabel :'Tipo residencia',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',
        value:2
    });
    var cbxExportableTipo = new Ext.form.ComboBox({
        id:'cbxExportableTipo',
        name:'cbxExportableTipo',
        store: dsExportableTipo,
        anchor:'75%',
        fieldLabel :'Tipo',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        editable: false,
        triggerAction:'all',
        emptyText : 'Seleccione',        
      value:'ARCHIVO'
    });

    var winDlgExportableResidencia = new Ext.Window({
        id:'winDlgExportableResidencia',
        title:tituloDlgSeleccionSeguimiento,
        tbar:getPanelTitulo(tituloDlgSeleccionSeguimiento,descDlgSeleccionSeguimiento),
        iconCls:'iconDescargar',
        items:[{
          region:'center',
          xtype:'panel',
            layout:'form',
            frame:true,
            items:[cbxTipoResidencia,cbxExportableTipo]
        }],                
        height:180,
        minHeight:180,        
        constrain:true,
        resizable:false,
        modal:true,
        layout:'border',        
        bbar:[btnNuevoDlgSeleccionSeguimiento,'->',btnCerrarDlgSeleccionSeguimiento]
    });
  
    this.getWindow=function(){
        return winDlgExportableResidencia;
    }

}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgExportableResidencia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgExportableResidencia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
DlgExportableResidencia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
DlgExportableResidencia.prototype.loadData = function(){
    this.loadData();
}


