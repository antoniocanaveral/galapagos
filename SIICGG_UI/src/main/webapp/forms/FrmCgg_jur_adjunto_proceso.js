/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_adjunto_proceso.
* @param {String} IN_SENTENCIA_CGG_JUR_ADJUNTO_PROCESO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_JUR_ADJUNTO_PROCESO Registro de datos de la tabla Cgg_jur_adjunto_proceso.
* @constructor
* @base FrmListadoCgg_jur_adjunto_proceso
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_jur_adjunto_proceso(IN_SENTENCIA_CGG_JUR_ADJUNTO_PROCESO,IN_RECORD_CGG_JUR_ADJUNTO_PROCESO){
var inSentenciaCgg_jur_adjunto_proceso = IN_SENTENCIA_CGG_JUR_ADJUNTO_PROCESO;
var inRecordCgg_jur_adjunto_proceso=IN_RECORD_CGG_JUR_ADJUNTO_PROCESO;
var urlCgg_jur_adjunto_proceso=URL_WS+"Cgg_jur_adjunto_proceso";
var tituloCgg_jur_adjunto_proceso='Jur adjunto proceso';
var descCgg_jur_adjunto_proceso='El formulario permite administrar la informaci\u00f3n de la tabla Jur adjunto proceso';
var isEdit = false;
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE HISTORIAL DE PROCESO
*/
var txtCjadp_codigo = new Ext.form.TextField({
id:'txtCjadp_codigo',
name:'txtCjadp_codigo',
fieldLabel :'Codigo',
anchor:'98%',
value:"KEYGEN",
hidden:true,
hideLabel:true,
allowBlank :false
});
/**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
*/
var txtCjpju_codigo = new Ext.form.TextField({
id:'txtCjpju_codigo',
name:'txtCjpju_codigo',
fieldLabel :'Codigo',
anchor:'98%',
readOnly:'true',
allowBlank :false
});
/**
* IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO JUDICIAL
*/
var btnCjpju_codigoCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnCjpju_codigoCgg_jur_adjunto_proceso',
text:'Cjpju_codigo',
iconCls:'iconCjpju_codigo',
listeners:{
click:function(){
var tmpFLCgg_jur_proceso_judicial = new FrmListadoCgg_jur_proceso_judicial();
var objBusqueda = new DlgBusqueda(tmpFLCgg_jur_proceso_judicial.getStore(),tmpFLCgg_jur_proceso_judicial.getColumnModel());
objBusqueda.closeHandler(function(){
var tmpRecord = objBusqueda.getSelectedRow();
if(tmpRecord)
txtCjpju_codigo.setValue(tmpRecord.get('CJPJU_CODIGO'));
});
objBusqueda.show();
}}
});
/**
* Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
*/
var txtCjadp_descripcion = new Ext.form.TextField({
id:'txtCjadp_descripcion',
name:'txtCjadp_descripcion',
fieldLabel :'Descripcion',
anchor:'98%',
allowBlank :false
});
/**
* Ext.form.DateField FECHA DE REGISTRO DEL ADJUNTO
*/
var dtCjhtp_fecha_registro = new Ext.form.DateField({
id:'dtCjhtp_fecha_registro',
name:'dtCjhtp_fecha_registro',
fieldLabel :'Fecha registro',
allowBlank :false,
format :'d/m/Y',
value:new Date()
});
/**
* Ext.form.TextField NOMBRE DEL ADJUNTO
*/
var txtCjadp_nombre_adjunto = new Ext.form.TextField({
id:'txtCjadp_nombre_adjunto',
name:'txtCjadp_nombre_adjunto',
fieldLabel :'Nombre adjunto',
anchor:'98%',
allowBlank :false
});
/**
* ARCHIVO DIGITAL 
*/
var filCjadp_adjunto = new Ext.form.FileUploadField({
id:'filCjadp_adjunto',
name:'filCjadp_adjunto',
fieldLabel :'Adjunto',
anchor:'98%',
disabled :false,
buttonCfg: {
text: '',
iconCls: 'iconAdjunto'
}
});
/**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_adjunto_proceso
*/
var btnGuardarCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnGuardarCgg_jur_adjunto_proceso',
text:'Guardar',
iconCls:'iconGuardar',
listeners:{
click:function(){
if (!pnlCgg_jur_adjunto_proceso.getForm().isValid()){
return;
}

Ext.getCmp('pnlCgg_jur_adjunto_proceso').getForm().submit({
	url: URL_WS+"Cgg_jur_adjunto_procesoSRV",
	waitMsg: 'Enviando formulario...',
	success: function(fp, o){
		Ext.Msg.show({
		title:tituloCgg_jur_adjunto_proceso,
		msg: 'La informaci\u00f3n de Jur adjunto proceso ha sido almacenada.',
		buttons: Ext.Msg.OK,
		icon: Ext.MessageBox.INFO
		});
		winFrmCgg_jur_adjunto_proceso.close();
	},
	failure:function(o){
		Ext.Msg.show({
		title:tituloCgg_jur_adjunto_proceso,
		msg: 'La informaci\u00f3n de Jur adjunto proceso no ha podido ser almacenada.'+(r.message?r.message:r),
		buttons: Ext.Msg.OK,
		icon: Ext.MessageBox.ERROR
		});
	}
});
 }}
});
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_adjunto_proceso.
*/
var btnCancelarCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnCancelarCgg_jur_adjunto_proceso',
text:'Cancelar',
iconCls:'iconCancelar',
listeners:{
click:function(){
pnlCgg_jur_adjunto_proceso.getForm().reset();
}}
});
/**
* Boton que permite cerrar la ventana winFrmCgg_jur_adjunto_proceso.
*/
var btnCerrarCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnCerrarCgg_jur_adjunto_proceso',
text:'Cerrar',
iconCls:'iconCerrar',
listeners:{
click:function(){
winFrmCgg_jur_adjunto_proceso.close();
}}
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_adjunto_proceso.
*/
var pnlCgg_jur_adjunto_proceso = new Ext.form.FormPanel({
frame:true,
labelWidth :100,
items:[txtCjadp_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCjpju_codigo]},{columnWidth:.4,layout:'form',items:[btnCjpju_codigoCgg_jur_adjunto_proceso]}]},txtCjadp_descripcion,dtCjhtp_fecha_registro,txtCjadp_nombre_adjunto,filCjadp_adjunto]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_adjunto_proceso.
*/
var winFrmCgg_jur_adjunto_proceso = new Ext.Window({
id:'winFrmCgg_jur_adjunto_proceso',
title:tituloCgg_jur_adjunto_proceso,
iconCls:'iconAplicacion',
width:400,
minWidth:400,
maximizable:true,
minimizable:true,
constrain:true,
tbar:getPanelTitulo(tituloCgg_jur_adjunto_proceso,descCgg_jur_adjunto_proceso),
items:[pnlCgg_jur_adjunto_proceso],
bbar:[btnGuardarCgg_jur_adjunto_proceso,btnCancelarCgg_jur_adjunto_proceso,'->',btnCerrarCgg_jur_adjunto_proceso]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_jur_adjunto_proceso.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_adjunto_proceso.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_jur_adjunto_procesoCtrls(inEstado){
estado=!inEstado;
txtCjadp_codigo.setDisabled(estado);
txtCjpju_codigo.setDisabled(estado);
txtCjadp_descripcion.setDisabled(estado);
dtCjhtp_fecha_registro.setDisabled(estado);
txtCjadp_nombre_adjunto.setDisabled(estado);
numCjadp_adjunto.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_adjunto_proceso.
*/
function cargarCgg_jur_adjunto_procesoCtrls(){
if(inRecordCgg_jur_adjunto_proceso){
txtCjadp_codigo.setValue(inRecordCgg_jur_adjunto_proceso.get('CJADP_CODIGO'));
txtCjpju_codigo.setValue(inRecordCgg_jur_adjunto_proceso.get('CJPJU_CODIGO'));
txtCjadp_descripcion.setValue(inRecordCgg_jur_adjunto_proceso.get('CJADP_DESCRIPCION'));
dtCjhtp_fecha_registro.setValue(inRecordCgg_jur_adjunto_proceso.get('CJHTP_FECHA_REGISTRO'));
txtCjadp_nombre_adjunto.setValue(inRecordCgg_jur_adjunto_proceso.get('CJADP_NOMBRE_ADJUNTO'));
numCjadp_adjunto.setValue(inRecordCgg_jur_adjunto_proceso.get('CJADP_ADJUNTO'));
isEdit = true;
habilitarCgg_jur_adjunto_procesoCtrls(true);
}}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_jur_adjunto_proceso.
* @returns ventana winFrmCgg_jur_adjunto_proceso.
* @base FrmCgg_jur_adjunto_proceso.prototype.show
*/
this.getWindow = function(){
return winFrmCgg_jur_adjunto_proceso;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_jur_adjunto_proceso.
* @base FrmCgg_jur_adjunto_proceso.prototype.loadData
*/
this.loadData = function(){
cargarCgg_jur_adjunto_procesoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_adjunto_proceso desde una instancia.
*/
FrmCgg_jur_adjunto_proceso.prototype.show = function(){
this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_adjunto_proceso desde una instancia.
*/
FrmCgg_jur_adjunto_proceso.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_adjunto_proceso,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_jur_adjunto_proceso.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_adjunto_proceso desde una instancia.
*/
FrmCgg_jur_adjunto_proceso.prototype.loadData = function(){
this.loadData();
}
