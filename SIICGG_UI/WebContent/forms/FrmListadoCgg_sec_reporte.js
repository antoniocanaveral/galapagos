/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_reporte.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_sec_reporte(inDesktop){
var optMenu = 'Configuraci\u00F3n/Reportes';
var urlListadoCgg_sec_reporte=URL_WS+"Cgg_sec_reporte";
var tituloListadoCgg_sec_reporte='Sec reporte';
var descListadoCgg_sec_reporte='El formulario permite administrar informaci\u00f3n de la tabla Sec reporte';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_reporte.
*/
var btnNuevoCgg_sec_reporte = new Ext.Button({
id:'btnNuevoCgg_sec_reporte',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_sec_reporte = new FrmCgg_sec_reporte("insert");
objCgg_sec_reporte.closeHandler(function(){
gsCgg_sec_reporte.reload();
});
objCgg_sec_reporte.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_sec_reporte.
*/
var btnEditarCgg_sec_reporte = new Ext.Button({
id:'btnEditarCgg_sec_reporte',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_sec_reporte.getSelectionModel().getSelected();
if(r){
var objCgg_sec_reporte = new FrmCgg_sec_reporte("update",r);
objCgg_sec_reporte.closeHandler(function(){
gsCgg_sec_reporte.reload();
});
objCgg_sec_reporte.loadData();
objCgg_sec_reporte.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_reporte.
*/
var btnEliminarCgg_sec_reporte = new Ext.Button({
id:'btnEliminarCgg_sec_reporte',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_sec_reporte,icon: Ext.MessageBox.QUESTION});
function SWRCgg_sec_reporte(btn){if (btn=='yes'){
try{
function CallBackCgg_sec_reporte(r){
winFrmListadoCgg_sec_reporte.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_sec_reporte,
msg: 'La informaci\u00f3n de Sec reporte ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_sec_reporte.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_sec_reporte,
msg: 'La informaci\u00f3n de Sec reporte no ha podido ser eliminada.'+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_sec_reporte.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCsrpt_codigo',grdCgg_sec_reporte.getSelectionModel().getSelected().get('CSRPT_CODIGO'));
SOAPClient.invoke(urlListadoCgg_sec_reporte,"delete",param, true, CallBackCgg_sec_reporte);
}catch(inErr){
winFrmListadoCgg_sec_reporte.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_reporte.
*/
var btnSalirCgg_sec_reporte = new Ext.Button({
id:'btnSalirCgg_sec_reporte',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_sec_reporte.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_reporte.
*/
var cmCgg_sec_reporte = new Ext.grid.ColumnModel([
{dataIndex:'CSRPT_REPORTE',header:'Reporte',width:250,sortable:true},
{dataIndex:'CSRPT_DESCRIPCION',header:'Descripcion',width:300,sortable:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_reporte por un campo especifico.
*/
var gsCgg_sec_reporte = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"Cgg_sec_reporte",
method:"selectPageDirectAll",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CSRPT_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CSRPT_CODIGO'},
{name:'CSRPT_REPORTE'},
{name:'CSRPT_DESCRIPCION'},
{name:'CSRPT_ACTIVO'}
]),
sortInfo:{field: 'CSRPT_REPORTE', direction: 'ASC'},
baseParams:{keyword:"",format:'JSON'}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_reporte.
*/
var pgBarCgg_sec_reporte= new Ext.PagingToolbar({
store: gsCgg_sec_reporte,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_reporte en un formato tabular de filas y columnas.
*/
var grdCgg_sec_reporte = new Ext.grid.GridPanel({
cm:cmCgg_sec_reporte,
store:gsCgg_sec_reporte,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ',
new Ext.ux.bsx.SearchField({
store:gsCgg_sec_reporte,
width:200
})
],
bbar:pgBarCgg_sec_reporte,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_sec_reporte.disabled){
btnEditarCgg_sec_reporte.fireEvent('click', btnEditarCgg_sec_reporte);
}
}}});
gsCgg_sec_reporte.reload({params:{
start:0,
limit:RECORD_PAGE,
format:'JSON'
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_reporte.
*/
var winFrmListadoCgg_sec_reporte = inDesktop.createWindow({
id:'winFrmListadoCgg_sec_reporte',
title:tituloListadoCgg_sec_reporte,
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrain:true,
layout:'border',
tbar:getPanelTitulo('Listado '+tituloListadoCgg_sec_reporte,descListadoCgg_sec_reporte),
items:[grdCgg_sec_reporte],
bbar:[btnNuevoCgg_sec_reporte,btnEditarCgg_sec_reporte,btnEliminarCgg_sec_reporte,'->',btnSalirCgg_sec_reporte]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_sec_reporte.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_reporte.
* @returns ventana winFrmCgg_sec_reporte.
* @base FrmListadoCgg_sec_reporte.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_sec_reporte;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_reporte.
* @base FrmListadoCgg_sec_reporte.prototype.loadData
*/
this.loadData = function(){
gsCgg_sec_reporte.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_sec_reporte;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_sec_reporte;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_sec_reporte.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_sec_reporte.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_reporte desde una instancia.
*/
FrmListadoCgg_sec_reporte.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_reporte desde una instancia.
*/
FrmListadoCgg_sec_reporte.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_reporte,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_sec_reporte.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_reporte desde una instancia.
*/
FrmListadoCgg_sec_reporte.prototype.loadData = function(){
this.loadData();
}
