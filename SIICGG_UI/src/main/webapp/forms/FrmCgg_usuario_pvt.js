function FrmCgg_usuario_pvt(){
    var optMenu = 'Offline/Offline tct';
    var rUsuarioPvt = null;
	 
    var btnSalirCgg_usuario_pvt = new Ext.Button({
        id:'btnSalirCgg_usuario_pvt',
        text: 'Salir',
        iconCls: 'iconSalir',
        tooltip:'Cierra el formulario actual',
        handler:function(){
            winFrmCgg_usuario_pvt.close();
        }
    });

    var btnDescargarCgg_usuario_pvt = new Ext.Button({
        id:'btnDescargarCgg_usuario_pvt ',
        text: 'Descargar',
        iconCls: 'iconDescargar',
        tooltip:'Descarga datos',
        handler:function(){
            if(rUsuarioPvt){
                
                var param = new SOAPClientParameters({
                    format:TypeFormat.JSON
                });

                SOAPClient.invoke(URL_WS + "Cgg_tct_registro",'validarInformacionOffline',param, true, function(inServiceResponse){
                    try{
                        inServiceResponse = inServiceResponse.evalJSON();
                    }catch(inErr){
                        inServiceResponse = null;
                    }

                    if(inServiceResponse == null || inServiceResponse.length > 0){
                        var personas = '<ul>';
                        for(var i=0;i<inServiceResponse.length;i++){
                            personas += '<li> *'+inServiceResponse[i].CRPER_NUM_DOC_IDENTIFIC+'</li>';
                        }
                        personas += '</ul>';

                        Ext.Msg.show({
                            title:'Usuario offline',
                            msg: 'La informaci\u00f3n de las siguientes personas contiene caracteres invalidos:<br>'+personas+'Verifiquelas, por favor.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });

                    }else if(inServiceResponse.length == 0){
                        var url = 'https://'+ URL_SERVER +URL_WS+'PublicWS/DatosConfiguracionTctSRV?tipo=file&CUSU_CODIGO='+rUsuarioPvt.get('CUSU_CODIGO');
                        var open_link = window.open('');
                        open_link.location= url ;
                    }
                });
                
            }
        }
    });

    var txtCusu_codigo = new Ext.form.TextField({
        id: 'txtCusu_codigo',
        name: 'txtCusu_codigo',
        fieldLabel: 'Usuario',
        anchor: '98%',
        readOnly: true,
        allowBlank:false
    });

    var btnCusu_codigo = new Ext.Button({
        id: 'btnCusu_codigo',
        iconCls: 'iconBuscar',
        tooltip: 'Buscar usuario de punto de venta',
        listeners: {
            click: function(){
                var usuarioPvt = new Cgg_punto_venta_usuario();
                var objBusqueda = new DlgBusquedaNoPaginado(usuarioPvt.getStore(), usuarioPvt.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCusu_codigo.setValue(tmpRecord.get('CUSU_NOMBRE_USUARIO').toUpperCase()+'('+tmpRecord.get('CKPVT_NOMBRE')+')');
                        rUsuarioPvt = tmpRecord;
                    }
                });
                objBusqueda.show();
            }
        }
    });
	
    /**
 *Crea una ventana para el objecto FrmCgg_usuario_pvt.
 */
    var winFrmCgg_usuario_pvt = new Ext.Window({
        id:'winFrmCgg_usuario_pvt',
        title:'Usuario offline',
        iconCls:'iconOffline',
        width:420,
        height:150,
        constrainHeader:true,
        resizable:false,
        layout:'border',
        modal:true,        
        tbar:getPanelTitulo('Usuario offline','Le permite seleccionar el usuario de punto de venta para la exportacion de una base preconfigurada de offline.'),
        items:[{
            xtype: 'panel',
            region:'center',
            id:'pnlTrmAuspiciante',
            frame:true,
            layout: 'column',
            items: [{
                columnWidth: .93,
                layout: 'form',
                items: [txtCusu_codigo]
            }, {
                columnWidth: .07,
                layout: 'form',
                items: [btnCusu_codigo]
            }]
        }],
        bbar:[btnDescargarCgg_usuario_pvt,'->',btnSalirCgg_usuario_pvt]
    });

    /**
 *Devuelve la ventada del objecto FrmCgg_usuario_pvt.
 */
    this.getWindow = function(){
        return winFrmCgg_usuario_pvt;
    } 

}

/**
 * Muestra el formulario.
 */
FrmCgg_usuario_pvt.prototype.show = function(){
    this.getWindow().show();
}
