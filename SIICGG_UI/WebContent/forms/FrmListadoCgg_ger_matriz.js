/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_ger_matriz.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_ger_matriz(){
var urlListadoCgg_ger_matriz=URL_WS+"Cgg_ger_matriz";
var tituloListadoCgg_ger_matriz='Ger matriz';
var descListadoCgg_ger_matriz='El formulario permite administrar informaci\u00f3n de la tabla Ger matriz';
/**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_ger_matriz.
*/
var btnNuevoCgg_ger_matriz = new Ext.Button({
id:'btnNuevoCgg_ger_matriz',
text:'Nuevo',
iconCls:'iconNuevo',
listeners:{
click:function(){
var objCgg_ger_matriz = new FrmCgg_ger_matriz("insert");
objCgg_ger_matriz.closeHandler(function(){
gsCgg_ger_matriz.reload();
});
objCgg_ger_matriz.show();
}}
});
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_ger_matriz.
*/
var btnEditarCgg_ger_matriz = new Ext.Button({
id:'btnEditarCgg_ger_matriz',
text:'Editar',
iconCls:'iconEditar',
listeners:{
click:function(){
var r=grdCgg_ger_matriz.getSelectionModel().getSelected();
if(r){
var objCgg_ger_matriz = new FrmCgg_ger_matriz("update",r);
objCgg_ger_matriz.closeHandler(function(){
gsCgg_ger_matriz.reload();
});
objCgg_ger_matriz.loadData();
objCgg_ger_matriz.show();
}
}}
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_ger_matriz.
*/
var btnEliminarCgg_ger_matriz = new Ext.Button({
id:'btnEliminarCgg_ger_matriz',
text:'Eliminar',
iconCls:'iconEliminar',
listeners:{
click:function(){
Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_ger_matriz,icon: Ext.MessageBox.QUESTION});
function SWRCgg_ger_matriz(btn){if (btn=='yes'){
try{
function CallBackCgg_ger_matriz(r){
winFrmListadoCgg_ger_matriz.getEl().unmask();
if(r=='true'){
Ext.Msg.show({
title:tituloListadoCgg_ger_matriz,
msg: 'La informaci\u00f3n de Ger matriz ha sido eliminada.',
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.INFO
});
gsCgg_ger_matriz.reload();
}else{
Ext.Msg.show({
title:tituloListadoCgg_ger_matriz,
msg: 'La informaci\u00f3n de Ger matriz no ha podido ser eliminada.'+(r.message?r.message:r),
buttons: Ext.Msg.OK,
icon: Ext.MessageBox.ERROR
});
}}
winFrmListadoCgg_ger_matriz.getEl().mask('Eliminando...', 'x-mask-loading');
var param = new SOAPClientParameters();
param.add('inCggma_codigo',grdCgg_ger_matriz.getSelectionModel().getSelected().get('CGGMA_CODIGO'));
SOAPClient.invoke(urlListadoCgg_ger_matriz,"delete",param, true, CallBackCgg_ger_matriz);
}catch(inErr){
winFrmListadoCgg_ger_matriz.getEl().unmask();
}}}
}}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_ger_matriz.
*/
var btnSalirCgg_ger_matriz = new Ext.Button({
id:'btnSalirCgg_ger_matriz',
text:'Salir',
iconCls:'iconSalir',
listeners:{
click:function(){
winFrmListadoCgg_ger_matriz.close();
}}
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_matriz.
*/
var cmCgg_ger_matriz = new Ext.grid.ColumnModel([
{dataIndex:'CGGMA_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CGGIN_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true},
{dataIndex:'CGGMA_MES',header:'Mes',width:150,sortable:true},
{dataIndex:'CGGMA_ANIO',header:'Anio',width:150,sortable:true},
{dataIndex:'CGGMA_VALOR',header:'Valor',width:150,sortable:true},
{dataIndex:'CGGMA_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
{dataIndex:'CGGMA_ACTUALIZACIONES',header:'Actualizaciones',width:150,sortable:true}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_matriz por un campo especifico.
*/
var gsCgg_ger_matriz = new Ext.data.Store({
proxy:new Ext.ux.bsx.SoapProxy({
url:URL_WS+"Cgg_ger_matriz",
method:"selectPage",
pagin:true
}),
remoteSort:true,
reader:new Ext.data.JsonReader({
id:'CGGMA_CODIGO',
root:'dataSet',
totalProperty: 'totalCount'
},[
{name:'CGGMA_CODIGO'},
{name:'CCTN_CODIGO'},
{name:'CGGIN_CODIGO'},
{name:'CUSU_CODIGO'},
{name:'CGGMA_MES'},
{name:'CGGMA_ANIO'},
{name:'CGGMA_VALOR'},
{name:'CGGMA_DESCRIPCION'},
{name:'CGGMA_ACTUALIZACIONES'}
]),
sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
baseParams:{keyword:"",format:'JSON'}
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_ger_matriz.
*/
var pgBarCgg_ger_matriz= new Ext.PagingToolbar({
store: gsCgg_ger_matriz,
displayInfo: true,
pageSize:RECORD_PAGE,
displayMsg: 'Mostrando {0} - {1} de {2}',
temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_ger_matriz en un formato tabular de filas y columnas.
*/
var grdCgg_ger_matriz = new Ext.grid.GridPanel({
cm:cmCgg_ger_matriz,
store:gsCgg_ger_matriz,
region:'center',
sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
loadMask:{msg:"Cargando..."},
tbar: [
'Buscar: ',
new Ext.ux.bsx.SearchField({
store:gsCgg_ger_matriz,
width:200
})
],
bbar:pgBarCgg_ger_matriz,
listeners:{
rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
if(!btnEditarCgg_ger_matriz.hidden){
btnEditarCgg_ger_matriz.fireEvent('click', btnEditarCgg_ger_matriz);
}
}}});
gsCgg_ger_matriz.reload({params:{
start:0,
limit:RECORD_PAGE,
format:'JSON'
}
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_ger_matriz.
*/
var winFrmListadoCgg_ger_matriz = new Ext.Window({
id:'winFrmListadoCgg_ger_matriz',
title:tituloListadoCgg_ger_matriz,
iconCls:'iconAplicacion',
width:600,
minWidth:600,
height:400,
minHeight:400,
maximizable:true,
minimizable:true,
constrain:true,
layout:'border',
tbar:getPanelTitulo('Listado '+tituloListadoCgg_ger_matriz,descListadoCgg_ger_matriz),
items:[grdCgg_ger_matriz],
bbar:[btnNuevoCgg_ger_matriz,btnEditarCgg_ger_matriz,btnEliminarCgg_ger_matriz,'->',btnSalirCgg_ger_matriz]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_ger_matriz.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_ger_matriz.
* @returns ventana winFrmCgg_ger_matriz.
* @base FrmListadoCgg_ger_matriz.prototype.show
*/
this.getWindow = function(){
return winFrmListadoCgg_ger_matriz;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_ger_matriz.
* @base FrmListadoCgg_ger_matriz.prototype.loadData
*/
this.loadData = function(){
gsCgg_ger_matriz.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
return cmCgg_ger_matriz;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
return gsCgg_ger_matriz;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_ger_matriz.prototype.getColumnModel = function(){
this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_ger_matriz.prototype.getStore = function(){
this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_ger_matriz desde una instancia.
*/
FrmListadoCgg_ger_matriz.prototype.show = function(){
this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_ger_matriz desde una instancia.
*/
FrmListadoCgg_ger_matriz.prototype.close = function(){
this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_ger_matriz,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_ger_matriz.prototype.closeHandler = function(inFunctionHandler){
this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_ger_matriz desde una instancia.
*/
FrmListadoCgg_ger_matriz.prototype.loadData = function(){
this.loadData();
}
