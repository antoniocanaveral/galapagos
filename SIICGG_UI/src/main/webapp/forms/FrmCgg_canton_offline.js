function FrmCgg_canton_offline(){
    var optMenu = 'Offline/Base E/S persona';
    var Canton_offline = null;
	 
    var btnSalirCgg_canton_offline = new Ext.Button({
        id:'btnSalirFrmCgg_canton_offline',
        text: 'Salir',
        iconCls: 'iconSalir',
        tooltip:'Cierra el formulario actual',
        handler:function(){
            winFrmCgg_canton_offline.close();
        }
    });

    var btnDescargarCgg_canton_offline = new Ext.Button({
        id:'btnDescargarFrmCgg_canton_offline',
        text: 'Descargar',
        iconCls: 'iconDescargar',
        tooltip:'Descarga datos',
        handler:function(){
            if(Canton_offline){
                var url = 'https://'+ URL_SERVER +URL_WS+'/PublicWS/DatosConfigMovilidadSRV?tipo=file&in_Canton='+Canton_offline;
                var open_link = window.open('');
                open_link.location= url ;
            }

        }
    });

    var txtCctn_codigo = new Ext.form.TextField({
        id: 'txtCctn_codigo',
        name: 'txtCctn_codigo',
        fieldLabel: 'Cant\u00f3n',
        anchor: '98%',
        readOnly: true,
        allowBlank:false
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_canton por un campo especifico.
     */
    function Canton(){
        var Cm=null;
        var Store=null;
        Cm =new Ext.grid.ColumnModel([
        {
            dataIndex:'CCTN_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CCTN_NOMBRE',
            header:'Cant\u00f3n',
            width:300,
            sortable:true
        }
        ]);
	 
        Store=new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"Cgg_canton",
                method:"selectPage",
                pagin:true
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CCTN_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
            {
                name:'CCTN_CODIGO'
            },

            {
                name:'CGPRV_CODIGO'
            },

            {
                name:'CCTN_NOMBRE'
            },

            {
                name:'CCTN_DESCRPCION'
            },

            {
                name:'CCTN_ABREVIATURA'
            }
            ]),
            sortInfo:{
                field: 'CCTN_NOMBRE',
                direction: 'ASC'
            },
            baseParams:{
                keyword:"",
                format:"JSON"
            }
        });
        this.getCm = function(){
            return Cm;
        }

        this.getStore = function(){
            return Store;
        }


    }

    Canton.prototype.getColumnModel=function(){
        return this.getCm();
    }

    Canton.prototype.getStore=function(){
        return this.getStore();
    }



    var btnCctn_codigo = new Ext.Button({
        id: 'btnCctn_codigo',
        iconCls: 'iconBuscar',
        tooltip: 'Seleccion de cant\u00f3n para filtrar informaci\u00f3n',
        listeners: {
            click: function(){
                var Cantonoff = new Canton();
                var objBusqueda = new DlgBusqueda(Cantonoff.getStore(), Cantonoff.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                        Canton_offline = (tmpRecord.get('CCTN_CODIGO'));
						
                    }
                });
                objBusqueda.show();
            }
        }
    });
	
    /**
 *Crea una ventana para el objecto FrmCgg_usuario_pvt.
 */
    var winFrmCgg_canton_offline = new Ext.Window({
        id:'winFrmCgg_canton_offline',
        title:'Cant\u00f3',
        iconCls:'iconOffline',
        width:420,
        height:150,
        constrainHeader:true,
        resizable:false,
        layout:'border',
        modal:true,        
        tbar:getPanelTitulo('Cant\u00f3n','Le permite seleccionar el Cant\u00f3 para exportar una base preconfigurada de offline.'),
        items:[{
            xtype: 'panel',
            region:'center',
            id:'pnlCanton',
            frame:true,
            layout: 'column',
            items: [{
                columnWidth: .93,
                layout: 'form',
                items: [txtCctn_codigo]
            }, {
                columnWidth: .07,
                layout: 'form',
                items: [btnCctn_codigo]
            }]
        }],
        bbar:[btnDescargarCgg_canton_offline,'->',btnSalirCgg_canton_offline]
    });

    /**
 *Devuelve la ventada del objecto FrmCgg_canton_offline.
 */
    this.getWindow = function(){
        return winFrmCgg_canton_offline;
    } 

}

/**
 * Muestra el formulario.
 */
FrmCgg_canton_offline.prototype.show = function(){
    this.getWindow().show();
}
