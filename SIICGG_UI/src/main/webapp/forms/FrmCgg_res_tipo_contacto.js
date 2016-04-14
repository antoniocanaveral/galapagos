/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tipo_contacto.
 * @param {String} INSENTENCIA_CGG_RES_TIPO_CONTACTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TIPO_CONTACTO Registro de datos de la tabla Cgg_res_tipo_contacto.
 * @constructor
 * @base FrmListadoCgg_res_tipo_contacto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tipo_contacto(INSENTENCIA_CGG_RES_TIPO_CONTACTO,INRECORD_CGG_RES_TIPO_CONTACTO){
    var inSentenciaCgg_res_tipo_contacto = INSENTENCIA_CGG_RES_TIPO_CONTACTO;
    var inRecordCgg_res_tipo_contacto=INRECORD_CGG_RES_TIPO_CONTACTO;
    var urlCgg_res_tipo_contacto=URL_WS+"Cgg_res_tipo_contacto";
    var tituloCgg_res_tipo_contacto='Tipo contacto';
    var descCgg_res_tipo_contacto='El formulario permite administrar informaci\u00f3n de tipo contacto';
    var isEdit = false;
    var isFileSelected = false;
    var tmpUserSession = new UserSession();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
     */
    var txtCrtco_codigo = new Ext.form.TextField({
        id:'txtCrtco_codigo',
        name:'txtCrtco_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL TIPO DE CONTACTO
     */
    var txtCrtco_nombre = new Ext.form.TextField({
        id:'txtCrtco_nombre',
        name:'txtCrtco_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL ARCHIVO QUE REPRESENTA EL TIPO DE CONTACTO
     */
    var txtCrtco_nombre_imagen = new Ext.form.TextField({
        id:'txtCrtco_nombre_imagen',
        name:'txtCrtco_nombre_imagen',
        fieldLabel :'Nombre imagen',
        hideLabel:true,
        anchor:'98%',
        allowBlank :true,
        hidden:true
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrtco_imagen = new Ext.form.FileUploadField({
        id:'filCrtco_imagen',
        name:'filCrtco_imagen',
        fieldLabel :'Imagen',
        disabled :false,
        anchor:'98%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        },
        listeners:{
            fileselected: function(fb, v){
                isFileSelected = true;
                Ext.fly('divImage').dom.innerHTML= '' ;
            }
        }

    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tipo_contacto
     */
    var btnGuardarCgg_res_tipo_contacto = new Ext.Button({
        id:'btnGuardarCgg_res_tipo_contacto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                /*if (pnlCgg_res_tipo_contacto.getForm().isValid()==false){
                 return;
                 }*/
                var sFileExtension = null;
                //alert(filCrtco_imagen.getValue());
                if (isEdit)
                {
                    if (!isFileSelected)
                    {
                        filCrtco_imagen.setValue(null);
                    }
                }

                if (filCrtco_imagen.getValue() && filCrtco_imagen.getValue().length>0)
                    txtCrtco_nombre_imagen.setValue(filCrtco_imagen.getValue());
                try{

                    sFileExtension = txtCrtco_nombre_imagen.getValue().substring(txtCrtco_nombre_imagen.getValue().lastIndexOf('.')+1);
                    if (sFileExtension.toLowerCase()=='jpg'||sFileExtension.toLowerCase()=='jpeg'||sFileExtension.toLowerCase()=='png'||sFileExtension.toLowerCase()=='gif')
                    {
                        try
                        {
                            pnlCgg_res_tipo_contacto.getEl().mask('Espere un momento por favor...','x-mask-loading');
                            Ext.getCmp('pnlCgg_res_tipo_contacto').getForm().submit({
                                url:URL_WS+"Cgg_res_tipo_contactoSRV",
                                //waitMsg:'Enviando Formulario',
                                success:function(fp,o){
                                    pnlCgg_res_tipo_contacto.getEl().unmask();
                                    Ext.Msg.show({
                                        title:tituloCgg_res_tipo_contacto,
                                        msg: 'La informaci\u00f3n del tipo de contacto ha sido almacenada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    winFrmCgg_res_tipo_contacto.close();
                                },
                                failure:function(o){
                                    pnlCgg_res_tipo_contacto.getEl().unmask();
                                    Ext.Msg.show({
                                        title:tituloCgg_res_tipo_contacto,
                                        msg: 'La informaci\u00f3n del tipo de contacto no ha podido ser almacenada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                },
                                params:{
                                    request:INSENTENCIA_CGG_RES_TIPO_CONTACTO
                                }

                            });
                        }catch(inErr){
                            pnlCgg_res_tipo_contacto.getEl().unmask();
                            Ext.Msg.show({
                                title:tituloCgg_res_tramite,
                                msg:'Se present\u00F3 un problema al momento de guardar su informaci\u00f3n.\nError:'+inErr+'.\n'+ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    else
                    {
                        Ext.MessageBox.alert('Informaci&oacute;n', 'Seleccione un archivo con extensi&oacute;n .jpg,.jpeg,.png,.gif');
                    }
                }catch(inErr){
                    winFrmCgg_res_tipo_contacto.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_tipo_contacto.
     */
    var btnCancelarCgg_res_tipo_contacto = new Ext.Button({
        id:'btnCancelarCgg_res_tipo_contacto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_tipo_contacto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_tipo_contacto.
     */
    var btnCerrarCgg_res_tipo_contacto = new Ext.Button({
        id:'btnCerrarCgg_res_tipo_contacto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_tipo_contacto.close();
            }}
    });
    var pnlImage = new Ext.Panel({
        id : 'pnlImage',
        frame:true,
        height:35,
        region:'south',
        html:'<div id= "divImage" style="height:100% ; width: 100% ;text-align: center;">'
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_tipo_contacto.
     */
    var pnlCgg_res_tipo_contacto = new Ext.form.FormPanel({
        id:'pnlCgg_res_tipo_contacto',
        name:'pnlCgg_res_tipo_contacto',
        frame:true,
        labelWidth :100,
        fileUpload:true,
        items:[txtCrtco_codigo,
            {xtype:'panel',layout:'column',items:[{columnWidth:.85,layout:'form',items:[txtCrtco_nombre]},{columnWidth:.15,layout:'form',items:[pnlImage]}]},
            {xtype:'panel',layout:'form',padding:'10px 0px 0px 0px',items:[filCrtco_imagen]},txtCrtco_nombre_imagen]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tipo_contacto.
     */
    var winFrmCgg_res_tipo_contacto = new Ext.Window({
        id:'winFrmCgg_res_tipo_contacto',
        title:tituloCgg_res_tipo_contacto,
        tbar:getPanelTitulo(tituloCgg_res_tipo_contacto,descCgg_res_tipo_contacto),
        items:[pnlCgg_res_tipo_contacto],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_tipo_contacto,btnCancelarCgg_res_tipo_contacto,'->',btnCerrarCgg_res_tipo_contacto],
        listeners:{
            show:function(){
                if (isEdit)
                {
                    var html ='<img src= "/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+inRecordCgg_res_tipo_contacto.get('CRTCO_NOMBRE_IMAGEN')+'" width = "22px" height ="22px">';
                    Ext.fly('divImage').dom.innerHTML=html;
                }
            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_tipo_contacto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_tipo_contactoCtrls(inEstado){
        estado=!inEstado;
        txtCrtco_codigo.setDisabled(estado);
        txtCrtco_nombre.setDisabled(estado);
        txtCrtco_nombre_imagen.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tipo_contacto.
     */
    function cargarCgg_res_tipo_contactoCtrls(){
        if(inRecordCgg_res_tipo_contacto){
            txtCrtco_codigo.setValue(inRecordCgg_res_tipo_contacto.get('CRTCO_CODIGO'));
            txtCrtco_nombre.setValue(inRecordCgg_res_tipo_contacto.get('CRTCO_NOMBRE'));
            txtCrtco_nombre_imagen.setValue(inRecordCgg_res_tipo_contacto.get('CRTCO_NOMBRE_IMAGEN'));
            filCrtco_imagen.setValue(inRecordCgg_res_tipo_contacto.get('CRTCO_NOMBRE_IMAGEN'));
            isEdit = true;
            habilitarCgg_res_tipo_contactoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tipo_contacto.
     * @returns ventana winFrmCgg_res_tipo_contacto.
     * @base FrmCgg_res_tipo_contacto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tipo_contacto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tipo_contacto.
     * @base FrmCgg_res_tipo_contacto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tipo_contactoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tipo_contacto desde una instancia.
 */
FrmCgg_res_tipo_contacto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tipo_contacto desde una instancia.
 */
FrmCgg_res_tipo_contacto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tipo_contacto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tipo_contacto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tipo_contacto desde una instancia.
 */
FrmCgg_res_tipo_contacto.prototype.loadData = function(){
    this.loadData();
}
