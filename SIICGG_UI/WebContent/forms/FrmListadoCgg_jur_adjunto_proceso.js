/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_adjunto_proceso.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_jur_adjunto_proceso(){
var urlListadoCgg_jur_adjunto_proceso=URL_WS+"Cgg_jur_adjunto_proceso";
var tituloListadoCgg_jur_adjunto_proceso='Jur adjunto proceso';
var descListadoCgg_jur_adjunto_proceso='El formulario permite administrar informaci\u00f3n de la tabla Jur adjunto proceso';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_adjunto_proceso.
*/
var btnNuevoCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnNuevoCgg_jur_adjunto_proceso',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_jur_adjunto_proceso = new FrmCgg_jur_adjunto_proceso("insert");
objCgg_jur_adjunto_proceso.closeHandler(function(){
gsCgg_jur_adjunto_proceso.reload();
});
objCgg_jur_adjunto_proceso.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_adjunto_proceso.
*/
var btnEditarCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnEditarCgg_jur_adjunto_proceso',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_jur_adjunto_proceso.getSelectionModel().getSelected();
if(r){
var objCgg_jur_adjunto_proceso = new FrmCgg_jur_adjunto_proceso("update",r);
objCgg_jur_adjunto_proceso.closeHandler(function(){
gsCgg_jur_adjunto_proceso.reload();
});
objCgg_jur_adjunto_proceso.loadData();
objCgg_jur_adjunto_proceso.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_adjunto_proceso.
*/
var btnEliminarCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnEliminarCgg_jur_adjunto_proceso',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_adjunto_proceso,icon: Ext.MessageBox.QUESTION});
function SWRCgg_jur_adjunto_proceso(btn){if (btn=='yes'){
try{
function CallBackCgg_jur_adjunto_proceso(r){
winFrmListadoCgg_jur_adjunto_proceso.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_jur_adjunto_proceso,
msg: 'La informaci\u00f3n de Jur adjunto proceso ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_jur_adjunto_proceso.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_jur_adjunto_proceso,
msg: 'La informaci\u00f3n de Jur adjunto proceso no ha podido ser eliminada.'+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_jur_adjunto_proceso.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCjadp_codigo',grdCgg_jur_adjunto_proceso.getSelectionModel().getSelected().get('CJADP_CODIGO'));
SOAPClient.invoke(urlListadoCgg_jur_adjunto_proceso,"delete",param, true, CallBackCgg_jur_adjunto_proceso);
}catch(inErr){
winFrmListadoCgg_jur_adjunto_proceso.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_adjunto_proceso.
*/
var btnSalirCgg_jur_adjunto_proceso = new Ext.Button({
id:'btnSalirCgg_jur_adjunto_proceso',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_jur_adjunto_proceso.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_adjunto_proceso.
*/
var cmCgg_jur_adjunto_proceso = new Ext.grid.ColumnModel([
{dataIndex:'CJADP_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CJPJU_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CJADP_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
{dataIndex:'CJHTP_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true},
{dataIndex:'CJADP_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
{dataIndex:'CJADP_ADJUNTO',header:'Adjunto',width:150,sortable:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_adjunto_proceso por un campo especifico.
*/
var gsCgg_jur_adjunto_proceso = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"Cgg_jur_adjunto_proceso",
method:"selectPage",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CJADP_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CJADP_CODIGO'},
{name:'CJPJU_CODIGO'},
{name:'CJADP_DESCRIPCION'},
{name:'CJHTP_FECHA_REGISTRO'},
{name:'CJADP_NOMBRE_ADJUNTO'},
{name:'CJADP_ADJUNTO'}
]),
sortInfo:{field: 'CJPJU_CODIGO', direction: 'ASC'},
baseParams:{keyword:"",format:'JSON'}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_adjunto_proceso.
*/
var pgBarCgg_jur_adjunto_proceso= new Ext.PagingToolbar({
store: gsCgg_jur_adjunto_proceso,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_adjunto_proceso en un formato tabular de filas y columnas.
*/
var grdCgg_jur_adjunto_proceso = new Ext.grid.GridPanel({
cm:cmCgg_jur_adjunto_proceso,
store:gsCgg_jur_adjunto_proceso,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ',
new Ext.ux.bsx.SearchField({
store:gsCgg_jur_adjunto_proceso,
width:200
})
],
bbar:pgBarCgg_jur_adjunto_proceso,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_jur_adjunto_proceso.hidden){
btnEditarCgg_jur_adjunto_proceso.fireEvent('click', btnEditarCgg_jur_adjunto_proceso);
}
}}});
gsCgg_jur_adjunto_proceso.reload({params:{
start:0,
limit:RECORD_PAGE,
format:'JSON'
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_adjunto_proceso.
*/
var winFrmListadoCgg_jur_adjunto_proceso = new Ext.Window({
id:'winFrmListadoCgg_jur_adjunto_proceso',
title:tituloListadoCgg_jur_adjunto_proceso,
iconCls:'iconAplicacion',
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrain:true,
layout:'border',
tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_adjunto_proceso,descListadoCgg_jur_adjunto_proceso),
items:[grdCgg_jur_adjunto_proceso],
bbar:[btnNuevoCgg_jur_adjunto_proceso,btnEditarCgg_jur_adjunto_proceso,btnEliminarCgg_jur_adjunto_proceso,'->',btnSalirCgg_jur_adjunto_proceso]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_jur_adjunto_proceso.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_adjunto_proceso.
* @returns ventana winFrmCgg_jur_adjunto_proceso.
* @base FrmListadoCgg_jur_adjunto_proceso.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_jur_adjunto_proceso;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_adjunto_proceso.
* @base FrmListadoCgg_jur_adjunto_proceso.prototype.loadData
*/
this.loadData = function(){
gsCgg_jur_adjunto_proceso.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_jur_adjunto_proceso;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_jur_adjunto_proceso;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_adjunto_proceso desde una instancia.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_adjunto_proceso desde una instancia.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_adjunto_proceso,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_adjunto_proceso desde una instancia.
*/
FrmListadoCgg_jur_adjunto_proceso.prototype.loadData = function(){
this.loadData();
}
