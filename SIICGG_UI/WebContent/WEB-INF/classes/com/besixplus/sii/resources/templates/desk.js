MyDesktop = new Ext.app.App({
    init :function(){
        Ext.QuickTips.init();
    },
    getModules : function(){
        return [
                {MENU_ENTRIES}
                ,new MyDesktop.mReporte()
        ];
    },
    getStartConfig : function(){
        return {
            id:'lblBienvenido',
            title:'Bienvenido',
            iconCls:'iconPersona',
            toolItems: [{
                text:'Cambiar clave',
                iconCls:'iconClave',
                scope:this,
                handler:function(){
                    var tmpUserSession = new UserSession();
                    var tmpDlg = new DlgUsuarioAC(tmpUserSession);
                    tmpDlg.show();
                }
            },{
                text:'Preferencias',
                scope:this,
                menu: {
                    items:[{
                        text: 'Formato de reportes',
                        scope: this,
                        menu:{

                            items:['<b class="menu-title">Escoja un formato de reporte</b>',
                            {
                                id:'miHtml',
                                text: 'Html(Pagina Web)',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miPdf',
                                text: 'Adobe Pdf',
                                iconCls:'',
                                checked:true,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miRtf',
                                text: 'Microsoft Word',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miXls',
                                text: 'Microsoft Excel',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miCsv',
                                text: 'Microsoft Excel(CSV)',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miSwf',
                                text: 'Adobe Flash',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            }
                            ]
                        }
                    }
                    ]
                }
            },{
                text:'Salir',
                iconCls:'iconSalir',
                scope:this,
                handler:function(){
                    function fnResultado(b){
                        if (b=="yes")
                            window.location="SessionManager?request=logout";
                    }
                    Ext.MessageBox.confirm('Confirme', 'Esta seguro que desea salir del sistema?', fnResultado);
                }
            }]
        }
    }
});
MyDesktop.StartMenuItem = Ext.extend(Ext.app.Module, {
    init : function(){
        this.launcher = {}
    },
    createWindow: function(src){
        var desktop = this.app.getDesktop();
        try{
            var win = desktop.getWindow('win'+src.windowId);
            if(!win){
                win = eval('new '+src.windowId+'(desktop);');
            }
            win.show();
        }catch(Exception){
            Ext.MessageBox.show({
                title:'Control de acceso',
                msg:'No tiene los permisos necesarios para hacer uso de este modulo.\nPor favor consulte con el Administrador del Sistema. '+Exception.message,
                icon:Ext.Msg.INFO,
                buttons:Ext.Msg.OK
            });
        }
    }
});