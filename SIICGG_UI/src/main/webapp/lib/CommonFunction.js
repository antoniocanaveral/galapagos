/**
 *Crea un Ext.data.record de una coleccion simple de objeto.
 *@param inData Objeto.
 *@return Ext.data.record.
 */
function parseRecord(inData){
    var tmpNewRecord = null;
    var myRecord = null;
    var tmpColumn = '';
    var tmpValueColumn = '';
    for(var item in inData){
        var value = eval('inData.'+item);
        tmpColumn+="'"+item+"',";
        if(Ext.isBoolean(value)==true || Ext.isNumber(value)==true){
            tmpValueColumn+='"'+item+'":'+value+",";
        }else if(value == null){
            tmpValueColumn+='"'+item+'":null,';
        }else{
            tmpValueColumn+='"'+item+'":"'+value+'",';
        }
    }

    tmpNewRecord = eval('Ext.data.Record.create(['+tmpColumn.substring(0,tmpColumn.length-1)+']);');
/*	var varTmpJson = '{'+tmpValueColumn.substring(0,tmpValueColumn.length-1)+'}';
	alert(varTmpJson);
	var tmpJson = eval('('+ varTmpJson +')');*/
    var tmpr = new tmpNewRecord(inData);
    //myRecord = eval(tmpr);
    //return myRecord;
	return tmpr;
}

Ext.grid.RowSelectionModel.override ({
    getSelectedIndex : function(){
        return this.grid.store.indexOf( this.selections.itemAt(0) );
    }
});

/**
 *Funcion publico de sobrescritura. Crea una funcion que devuelve los datos de un store en formato JSON.
 *@return jsonData Datos de un store en formato JSON
 */
Ext.data.Store.override({
    getJsonData : function(){
        var jsonData="";
        for(var i =0;i<this.getCount();i++){
            jsonData += Ext.encode(this.getAt(i).data)+',';
        }
        if(jsonData.trim().length>=1){
            jsonData = '['+jsonData.substr(0, jsonData.length-1)+']';
        }else{
            jsonData="[]";
        }
        return jsonData;
    }
});

/**
*Retorna una cadena JSON desde un conjunto de datos
*@param store Agrupacion de registros
*@return Cadena JSON
*/
function createJSONObject(store){
    var json ='';
    var dato = false;
    store.each(function(store){
        json += Ext.util.JSON.encode(store.data) + ',';
        dato=true;
    });
    if (dato)
    {
        json = json.substring(0, json.length - 1) +']';
    }
    if (json.lastIndexOf(']') == -1){
        return '['+json+']';
    }else{
        return '['+json;
    }
}
/**
*Retorna una cadena JSON desde un Record
*@param record 
*@return json Cadena JSON
*/
function createJSONObjectRecord(record){
    var json ='[';    
    for(i=0;i<record.length;i++)
        json += (i>0?',':'')+Ext.util.JSON.encode(record[i].data);            
    json +=']';
    return json;
}

/**
*Funcion que da formato a una fecha.
*@param inFecha Fecha
*@returns Fecha con formato (DD/MM/YYYY)
*/
function formatShortDate(inFecha){
    var objTmpFecha = inFecha;
    objTmpFecha = objTmpFecha.replace('-','/','g').substr(0,objTmpFecha.indexOf(' '));
    return Date.parse(objTmpFecha).format('d/m/Y');
}

/**
*Funcion que da formato a una hora.
*@param inFecha Fecha
*@returns Hora con formato (YYYY/MM/DD HH:min:ss)
*/
function formatTime(inFecha){
    var objTmpFecha = inFecha;
    objTmpFecha = objTmpFecha.substr(objTmpFecha.indexOf(' ')+1,objTmpFecha.length-1);
    objTmpFecha = objTmpFecha.substr(0,objTmpFecha.lastIndexOf('.'));
    return objTmpFecha;
}

/**
 * Aplica los permisos del usuario actual a los controles visuales.
 * @param inButtonsArray Vector que botones.
 * @param inDisabled Disactivar los controles en lugar de ocultarlos.
 */
function applyGrants(inButtonsArray, inDisabled){
    var tmpJSON = "[";
    var tmpIds = new Array();
    for (var i = 0; i < inButtonsArray.items.length; i++){
        if(inButtonsArray[i] != '->' && inButtonsArray[i] != '-'){
            if(tmpJSON.length > 1)
                tmpJSON +=",";
            tmpJSON +="\"" + inButtonsArray.items.get(i).getId() + "\"";
            tmpIds.push(inButtonsArray.items.get(i).getId());
        }
    }
    tmpJSON += "]";
    function CallBackGrants(r){
        if ( window.console && window.console.log ) {
            window.console.log("CallBack: "+r);
        }
        var tmpResJSON = Ext.util.JSON.decode(r);
        if ( window.console && window.console.log ) {
            window.console.log("Stringify: "+JSON.stringify(tmpResJSON));
        }
        if(tmpJSON.length > 0){
            for(i = 0; i < tmpIds.length; i++){
                if(inDisabled)
                    Ext.getCmp(tmpIds[i]).setDisabled(!tmpResJSON[i] && inDisabled);
                else
                    Ext.getCmp(tmpIds[i]).setVisible(tmpResJSON[i]);
            }
        }
    }
    var param = new SOAPClientParameters();
    param.add('inObject',tmpJSON);
    param.add('inPath','');
    SOAPClient.invoke(URL_WS+'Cgg_sec_objeto','isGrant',param, false, CallBackGrants);
}

/**
 * Obtiene el tama�o de la ventana
 * @return Dimensiones de la ventana
 */
function getWindowSize() {  
    var Width =0;
    var Height =0;
    if( typeof( window.innerWidth ) == 'number' ) {
        //Non-IE
        Width = window.innerWidth;
        Height = window.innerHeight;
    } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
        //IE 6+ in 'standards compliant mode'
        Width = document.documentElement.clientWidth;
        Height = document.documentElement.clientHeight;
    } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        //IE 4 compatible
        Width = document.body.clientWidth;
        Height = document.body.clientHeight;
    }
	
    this.getWidth = function(){
        return Width;
    }
	
    this.getHeight = function(){
        return Height;
    }
	
}

/**
 * OBTIENE EL ANCHO DE LA VENTANA
 * @return getWidth ANCHO DE LA VENTANA
 */
getWindowSize.prototype.Width = function(){
    return this.getWidth();
}
/**
 * OBTIENE EL ALTO DE LA VENTANA
 * @return getHeight ALTO DE LA VENTANA
 */
getWindowSize.prototype.Height = function(){
    return this.getHeight();
}
/**
 * ELIMINA LOS ESCACIOS EN BLANCON DE UNA CADENA
 * @return CADENA
 */
function trim(str){
    if(!str || typeof str != 'string')
        return null;
    return str.replace(/^[\s]+/,'').replace(/[\s]+$/,'').replace(/[\s]{2,}/,' ');
}

/**
 *Funcion. Devuelve un objeto fecha truncado de una cadena de datos.
 *@param inDateString Fecha formato cadena
 *@return Objecto Date con formato d/m/Y.
 */
function truncDate(inDateString){
    if(inDateString && typeof(inDateString) != 'string')
        return inDateString.format('d/m/Y');
    var outDate = null;
    try{
        if (inDateString !== null && inDateString !== undefined && inDateString.trim().length >= 0){
            outDate = Date.parse(inDateString.substr(0,inDateString.lastIndexOf('.'))).format('d/m/Y');
        }else{
            outDate = null;
        }
	
    }catch(inErr){
        outDate = null;
    }
    return outDate;
}

/**
 *Funcion. Devuelve un objeto fecha truncado de una cadena de datos.
 *@param inDateString Fecha formato cadena
 *@return Objecto Date con formato d/m/Y.
 */
function truncDateTime(inDateString){
    if(inDateString && typeof(inDateString) != 'string')
        return inDateString.format('d/m/Y H:i');
    var outDate = null;
    try{
        if (inDateString !== null && inDateString !== undefined && inDateString.trim().length >= 0){
            outDate = Date.parse(inDateString.substr(0,inDateString.lastIndexOf('.'))).format('d/m/Y H:i:s');
        }else{
            outDate = null;
        }
	
    }catch(inErr){
        outDate = null;
    }
    return outDate;
}
/**
 *Funcion. Devuelve la edad de una persona.
 *@param IN_FECHA_NACIMIENTO Fecha de nacimiento.
 *@return Objecto Date con formato d/m/Y.
 */
function calcularEdad(IN_FECHA_NACIMIENTO){
    var fechaNacimiento = Date.parse(IN_FECHA_NACIMIENTO);
    var dia_nacim = fechaNacimiento.getDay();
    var mes_nacim = fechaNacimiento.getMonth();
    var anio_nacim = fechaNacimiento.getFullYear();
    var fecha_hoy = new Date();
    var ahora_anio = fecha_hoy.getFullYear();
    var ahora_mes = fecha_hoy.getMonth();
    var ahora_dia = fecha_hoy.getDay();
    var edad = (ahora_anio) - anio_nacim;
    if ( ahora_mes < (mes_nacim))
    {
        edad--;
    }
    if (((mes_nacim) == ahora_mes) && (ahora_dia < dia_nacim))
    {
        edad--;
    }

    return edad;
}
/**
 *Funcion. Formatea una cadena de fecha en formato especificado.
 *@param inDate fecha en formato cadena.
 *@param inPattern formato de salida de la fecha.
 *@return Objeto fecha.
 */
function formatearFecha(inDate,inPattern){
    var tmpResultado = null;
    if(inDate !== null && inDate !== undefined && inDate.trim().length >=4){
        var tmpFecha = Date.parse(inDate);
        tmpResultado = tmpFecha.format(inPattern);
    }else{
        tmpResultado = null;
    }
    return tmpResultado;
}

/**
 * Funcion publica. Crea un panel de titulo utilizado en todos los formularios en la seccion superior.
 * @param strTitulo Titulo del panel.
 * @param strDescripcion Descripcion del panel o del formulario.
 * @param strExtra Cadena extra
 * @return Ext.Panel
 */
function getPanelTitulo(strTitulo,strDescripcion,strExtra){
    var logoTitulo = 'logoTitulo';
    var fondoTitulo ='fondoTitulo';
    if (strExtra){
        logoTitulo = strExtra.icono||'logoTitulo'
        fondoTitulo = strExtra.fondo||'fondoTitulo'
    }
    var tituloCompleto = String.format('<div class="'+fondoTitulo+'"><div class="'+logoTitulo+'"><div class="lblTitulo">{0}</div><div class="lblDescripcion">{1}</div></div></div>', strTitulo, strDescripcion);
    var pnlTitulo = new Ext.Panel({       
        height:50,
        html:tituloCompleto,
        border:false
    });
    return pnlTitulo;
}
/**
 * Funcion publica. VAlida si una cadena es numerica
 * @param sText Cadena
 * @return IsNumber SI es o no numero
 */
function IsNumeric(sText) {
    var ValidChars = "0123456789";
    var IsNumber = true;
    var Char;
    for (i = 0; i < sText.length && IsNumber == true; i++) {
        Char = sText.charAt(i);
        if (ValidChars.indexOf(Char) == -1) {
            IsNumber = false;
        }
    }
    return IsNumber;
}

/***
 * Valida un numero de cedula ingresado
 * @param inCedula Cedula de la persona
 * @return TRUE/FALSE
 * */

function validarCedula(inCedula)
{
    var array = inCedula.split("") ;
    var num = array.length;
    var total;
    var digito;
    var mult;
    var decena;
    var end;

    if(num == 10)
    {
        total = 0;
        digito = (array[9]*1);
        for( var i = 0; i<(num-1);i++)
        {
            mult = 0;
            if((i%2) != 0)
            {
                total = total + (array[i]*1);
            }
            else
            {
                mult = array[i]*2;
                if( mult > 9)
                {
                    total = total + (mult - 9);
                }
                else
                {
                    total = total + mult;
                }
            }

        }
        decena = total/10;
        decena = Math.floor(decena);
        decena = ( decena + 1 ) * 10;
        end = ( decena - total ) ;
        if((end == 10 && digito == 0)|| end == digito)
        {
            return  true;
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false;
    }
}
/**
 * Funcion publica. Carga todos los almacenamientos comunes de la aplicacion a memoria.
 */
function AppCommonStores(){
	Ext.Ajax.timeout = 900000;
    SCGG_RES_REQUISITO.load();
    SCGG_PAIS.load();
    SCGG_PROVINCIA.load();
    SCGG_CANTON.load();
    SCGG_RES_PARROQUIA.load();
    SCGG_ISLA.load();
    SCGG_RES_TIPO_CONTACTO.load();
    SCGG_CONFIGURACION.load();
}

/**
 * Funcion publica. Obtiene los valores que se corresponden con los parametros de busqueda dentro de una almacenamiento.
 * @param inStore Coleccion de datos.
 * @param inKeyColumn Columna clave para la busqueda.
 * @param inKeyValue Valor para comparacion con la columna clave.
 * @param inDisplayValue Opcional. Valor a obtenerse del record resultante de la busqueda.
 * @return Ext.data.record / string.
 */
function getRecordFromStore(inStore,inKeyColumn,inKeyValue,inDisplayValue){
    var rResultado = null;
    for(var i=0;i<inStore.getCount();i++){
        if(inStore.getAt(i).get(inKeyColumn) == inKeyValue ){
            if(inDisplayValue !== null && inDisplayValue !== undefined){
                rResultado = inStore.getAt(i).get(inDisplayValue);
            }else{
                rResultado = inStore.getAt(i);
            }
            break;
        }
    }
    return rResultado;
}

/**
 * Funcion. Capataliza la primera letra de cada palabra de la cadena enviada.
 * @param inString Cadena de datos.
 * @return Cadena capitalizada en sus primeras letras por palabra.
 */
function ucFirst(inString) {
    if(inString !== null && inString !== undefined){
        var val = inString;
        var newVal = '';
        val = val.split(' ');
        for(var c=0; c < val.length; c++) {
            newVal += val[c].substring(0,1).toUpperCase() +
            val[c].substring(1,val[c].length) + ' ';
        }
    }else{
        newVal = null;
    }
    return newVal;
}

/**
 * Funcion. Devuelve la diferencia en dias calculada entre dos fechas.
 * @param inFistDate Cadena minuendo de la operacion
 * @param inSecondDate Cadena sustraendo de la operacion
 * @return Valor numerico Representacion del nuemro de dias.
 */
function daysBetween(inFistDate,inSecondDate) {
    var dias = 0;
    if(inFistDate !== null && inSecondDate !== null){
        var diferencia = inFistDate.getTime() - inSecondDate.getTime();
        dias = Math.floor(diferencia/(1000* 60* 60*24));
    }
    return dias;
}

function Fade(inSR, inSG, inSB, inER, inEG, inEB, inSteps, inStepStop){
    function makearray(n){
        this.length = n;
        for(var i = 1; i <= n; i++)
            this[i] = 0;
        return this;
    }
    var hexa = new makearray(16);

    for(var i = 0; i < 10; i++) hexa[i] = i;

    hexa[10]="a";
    hexa[11]="b";
    hexa[12]="c";
    hexa[13]="d";
    hexa[14]="e";
    hexa[15]="f";
    function hex(i){
        if (i < 0) return "00";
        else if (i >255) return "ff";
        else return "" + hexa[Math.floor(i/16)] + hexa[i%16];
    }
    if(inStepStop > inSteps)
        inStepStop = inSteps;
    var hr = hex(Math.floor(inSR * ((inSteps - inStepStop)/inSteps) + inER * (inStepStop/inSteps)));
    var hg = hex(Math.floor(inSG * ((inSteps-inStepStop)/inSteps) + inEG * (inStepStop/inSteps)));
    var hb = hex(Math.floor(inSB * ((inSteps-inStepStop)/inSteps) + inEB * (inStepStop/inSteps)));

    return "#"+hr+hg+hb;
}

/**
* Obtiene la zona de tiempo del usuario.
* @return gmt_offset
*/
function getTimezoneOffset() {
    var current_date = new Date( );
    var gmt_offset = current_date.getTimezoneOffset( ) / 60;
    return gmt_offset;
}

/**
*Function Publica. Brinda informacion acerca de la session de usuario almacenada en la session del servidor.
*@param inCallbackFunction
*/
function UserSession(inCallbackFunction){
    var userID = null;
    var userName = null;
    var usuarioPersona = null;
    var cambiarClave;
    var caducidad;
    var caducaClave;
    var isla;

    new Ajax.Request(URL_SESSION, {
        method: 'get',
        parameters:{
            request:'userobject',
            timezone:getTimezoneOffset()
        },
        asynchronous:false,
        onSuccess: function(inServerResponse) {
            try{
                usuarioPersona = Ext.util.JSON.decode(inServerResponse.responseText);
                userName = usuarioPersona.CUSU_NOMBRE_USUARIO;
                userID = usuarioPersona.CUSU_CODIGO;
                cambiarClave = usuarioPersona.CUSU_CAMBIAR_CLAVE;
                caducidad = usuarioPersona.CADUCIDAD;
                caducaClave = usuarioPersona.CUSU_CADUCA_CLAVE;
                isla = usuarioPersona.ISLA;
                if(inCallbackFunction){
                    inCallbackFunction(usuarioPersona);
                }
            }catch(inErr){
                usuarioPersona = null;
                userName = null;
                userID = null;
            }
        },
        onFailure:function(inServerResponse){
            usuarioPersona = null;
            userName = null;
            userID = null;
        }
    });

    this.getUserID = function(){
        return userID;
    }
    
    this.getUserName = function(){
        return userName;
    }
	
    this.getUserData = function(){
        return usuarioPersona;
    }
	
    this.isCambiarClave = function(){
        return cambiarClave;
    }
    this.isCaducaClave = function(){
        return caducaClave;
    }
    this.getCaducidad = function(){
        return caducidad;
    }
    this.getIsla = function(){
        return isla;
    }
}

UserSession.prototype.getUserID = function(){
    return this.getUserID();
}

UserSession.prototype.getUserName = function(){
    return this.getUserName();
}

UserSession.prototype.getUserData = function(){
    return this.getUserData();
}

UserSession.prototype.isCambiarClave = function(){
    return this.isCambiarClave();
}

UserSession.prototype.getCaducidad = function(){
    return this.getCaducidad();
}
UserSession.prototype.getIsla = function(){
    return this.getIsla();
}

function abrirVeh(inCVVEH_CODIGO){
  
	var gsCgg_veh_color = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_veh_color",
			method:"selectPageDirect"
		}),
		remoteSort:true,
		reader:new Ext.data.JsonReader({
			id:'CVCLR_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		},[
			{name:'CVCLR_CODIGO'},
			{name:'CVCLR_NOMBRE'},
		]),
		sortInfo:{field: 'CVCLR_NOMBRE', direction: 'ASC'},
		baseParams:{keyword:"",format:'JSON'}
	});
	gsCgg_veh_color.baseParams.start = 0;
	gsCgg_veh_color.baseParams.limit = 1000;
	gsCgg_veh_color.reload();
        
    var vehiculo = null;
    var scpVeh= new SOAPClientParameters({
        'inCvveh_codigo':inCVVEH_CODIGO,
        'format':TypeFormat.JSON
    });

    try{
        vehiculo = SOAPClient.invoke(URL_WS+'Cgg_veh_vehiculo','select1', scpVeh, false, null);
        vehiculo = vehiculo.evalJSON(true);
        vehiculo = parseRecord(vehiculo[0]);

        var objVeh = new FrmCgg_veh_vehiculo('update', vehiculo);
        objVeh.setStoreColor(gsCgg_veh_color);
        objVeh.loadData();
        objVeh.show();                

    }catch(inErr){
        vehiculo = null;
    }
   
}
/**
 * Funcion. Abre el formulario de tramite en modo de consulta.
 *@param inCRTRA_CODIGO Codigo de tramite.
 */
function abrirTramite(inCRTRA_CODIGO){

    var scpTramite = new SOAPClientParameters();
    scpTramite.add('inCrtra_codigo',inCRTRA_CODIGO);
    scpTramite.add('format',TypeFormat.JSON);

    var rTramite = Ext.data.Record.create(
        [
        {
            name:'CRTRA_CODIGO'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRPER_TBENEFICIARIO'
        },

        {
            name:'CRPJR_CODIGO'
        },
        {
            name:'CRPJR_NOMBRES'
        },
        {
            name:'CGG_CRPER_CODIGO'
        },
        {
            name:'CRPER_TAUSPICIANTE'
        },
        {
            name:'CRPRO_CODIGO'
        },
        {
            name:'CRTST_CODIGO'
        },
        {
            name:'CRTST_DESCRIPCION'
        },
        {
            name:'CVVEH_CODIGO'
        },
        {
            name:'CRETT_CODIGO'
        },
        {
            name:'CISLA_CODIGO'
        },
        {
            name:'CVMTR_CODIGO'
        },
        {
            name:'CRTRA_ANIO'
        },
        {
            name:'CRTRA_NUMERO'
        },
        {
            name:'CRTRA_FECHA_RECEPCION'
        },
        {
            name:'CRTRA_ACTIVIDAD_RESIDENCIA'
        },{
            name:'ACTIVIDAD_RESIDENCIA'
        },
        {
            name:'CRTRA_OBSERVACION'
        },
        {
            name:'CRTRA_DIAS_PERMANENCIA'
        },
        {
            name:'CRTRA_PENDIENTE'
        },
        {
            name:'CRTRA_OBSERVACION_PENDIENTE'
        },
        {
            name:'CRTRA_ATENCION_CLIENTE'
        },
        {
            name:'CRTRA_COMUNICADO_RADIAL'
        },
        {
            name:'CRTRA_MOTIVO'
        },{
            name:'CRTRA_FECHA_INGRESO'
        },{
            name:'CRTRA_FECHA_SALIDA'
        },
        {
            name:'CRTRA_FOLIO'
        },{
            name:'CRTRA_GRUPO'
        },
        {
            name:'CRTRA_ORDEN'
        }
        ]
        );


    var filaTramite = SOAPClient.invoke(URL_WS+'Cgg_res_tramite','select', scpTramite, false, null);
    try{
        filaTramite = Ext.util.JSON.decode(filaTramite);
        filaTramite= filaTramite[0];

        var rdTramite = new rTramite({
            CRTRA_CODIGO:filaTramite.CRTRA_CODIGO,
            CRPER_CODIGO:filaTramite.CRPER_CODIGO,
            CRPER_TBENEFICIARIO:'',
            CRPJR_CODIGO:filaTramite.CRPJR_CODIGO,
            CRPJR_NOMBRES:filaTramite.CRPJR_NOMBRES,
            CGG_CRPER_CODIGO:filaTramite.CGG_CRPER_CODIGO,
            CRPER_TAUSPICIANTE:'',
            CRPRO_CODIGO:filaTramite.CRPRO_CODIGO,
            CRTST_CODIGO:filaTramite.CRTST_CODIGO,
            CRTST_DESCRIPCION:'',
            CVVEH_CODIGO:filaTramite.CVVEH_CODIGO,
            CRETT_CODIGO:filaTramite.CRETT_CODIGO,
            CISLA_CODIGO:filaTramite.CISLA_CODIGO,
            CVMTR_CODIGO:filaTramite.CVMTR_CODIGO,
            CRTRA_ANIO:filaTramite.CRTRA_ANIO,
            CRTRA_NUMERO:filaTramite.CRTRA_NUMERO,
            CRTRA_FECHA_RECEPCION:filaTramite.CRTRA_FECHA_RECEPCION,
            CRTRA_ACTIVIDAD_RESIDENCIA:filaTramite.CRTRA_ACTIVIDAD_RESIDENCIA,
            CRTRA_OBSERVACION:filaTramite.CRTRA_OBSERVACION,
            CRTRA_DIAS_PERMANENCIA:filaTramite.CRTRA_DIAS_PERMANENCIA,
            CRTRA_PENDIENTE:filaTramite.CRTRA_PENDIENTE,
            CRTRA_OBSERVACION_PENDIENTE:filaTramite.CRTRA_OBSERVACION_PENDIENTE,
            CRTRA_ATENCION_CLIENTE:filaTramite.CRTRA_ATENCION_CLIENTE,
            CRTRA_COMUNICADO_RADIAL:filaTramite.CRTRA_COMUNICADO_RADIAL,
            CRTRA_MOTIVO:filaTramite.CRTRA_MOTIVO,
            CRTRA_FOLIO:filaTramite.CRTRA_FOLIO,
            CRTRA_FECHA_INGRESO:filaTramite.CRTRA_FECHA_INGRESO,
            CRTRA_FECHA_SALIDA:filaTramite.CRTRA_FECHA_SALIDA,
            CRTRA_GRUPO:filaTramite.CRTRA_GRUPO,
            CRTRA_ORDEN:filaTramite.CRTRA_ORDEN
        });

        var objTramite = new FrmCgg_res_tramite(null, rdTramite);
        objTramite.setDisabled(true);        
        objTramite.show();
        objTramite.setHistorico(true);
        objTramite.loadData();
        
    }catch(inErr){
        Ext.MsgPopup.msg(APP_TITLE, "No se pudo consultar el tr\u00E1mite.<br>Error:"+inErr, MsgPopup.WARNING);
    }
}

function abrirPersona(inCrper_codigo){
    var objCgg_res_persona = new FrmCgg_res_persona("update",inCrper_codigo);
    objCgg_res_persona.loadData1();
    objCgg_res_persona.show();
}

/**
 *Abre el formulario de seguimiento.
 *@param inCrseg_codigo Codigo de seguimiento.
 */
function abrirSeguimiento(inCrseg_codigo){
    var inRecordCgg_res_seguimiento = null;
    var tmpSeguimiento = null;
    var rSeguimiento = new Ext.data.Record.create([
    {
        name:'CRSEG_CODIGO'
    },

    {
        name:'CGG_CRSEG_CODIGO'
    },

    {
        name:'CRTRA_CODIGO'
    },

    {
        name:'CRFAS_CODIGO'
    },

    {
        name:'CGG_CRFAS_CODIGO'
    },

    {
        name:'CUSU_CODIGO'
    },

    {
        name:'CRSEG_DESCRIPCION'
    },

    {
        name:'CRSEG_ESTADO_ATENCION'
    },

    {
        name:'CRSEG_OBSERVACION'
    },

    {
        name:'CRSEG_TIPO_RESPUESTA'
    },

    {
        name:'CRSEG_TIPO_ACTIVIDAD'
    },

    {
        name:'CRSEG_FECHA_RECEPCION'
    },

    {
        name:'CRSEG_FECHA_REVISION'
    },

    {
        name:'CRSEG_FECHA_DESPACHO'
    },

    {
        name:'CRSEG_ESTADO_HIJO'
    },

    {
        name:'CRSEG_USUARIO_INSERT'
    },

    {
        name:'CRTRA_NUMERO'
    },

    {
        name:'CRFAS_NOMBRE'
    },

    {
        name:'CUSU_APELLIDOS'
    },

    {
        name:'CUSU_ANTERIOR'
    },

    {
        name:'CRTRA_FECHA_RECEPCION'
    },

    {
        name:'CISLA_CODIGO'
    },

    {
        name:'CRSEG_NUMERO'
    },

    {
        name:'CRPJR_CODIGO'
    },

    {
        name:'CRTRA_OBSERVACION'
    },

    {
        name:'CRTRA_COMUNICADO_RADIAL'
    },

    {
        name:'CRPER_CODIGO'
    },

    {
        name:'CRPER_BENEFICIARIO'
    },

    {
        name:'CGG_CRPER_CODIGO'
    },

    {
        name:'CRPER_AUSPICIANTE'
    },

    {
        name:'CRTRA_ANIO'
    },

    {
        name:'CISLA_NOMBRE'
    },

    {
        name:'CRTRA_ACTIVIDAD_RESIDENCIA'
    },

    {
        name:'CRTST_DESCRIPCION'
    },

    {
        name:'CRFAS_NOMBRE_ANTERIOR'
    },

    {
        name:'CRPJR_RAZON_SOCIAL'
    },

    {
        name:'CRTST_CODIGO'
    },

    {
        name:'VEHICULO'
    },

    {
        name:'CRPRO_CODIGO'
    },

    {
        name:'SEGUIMIENTO_HTML'
    },

    {
        name:'CRTRA_FOLIO'
    },

    {
        name:'CRTRA_DIAS_PERMANENCIA'
    },

    {
        name:'CRTRA_FECHA_ENTRADA'
    },

    {
        name:'CRTRA_FECHA_SALIDA'
    },

    {
        name:'CRTRA_GRUPO'
    },

    {
        name:'CRTRA_ORDEN'
    },

    {
        name:'CRETT_CODIGO'
    }
    ]);
        
    var scpSeguimiento = new SOAPClientParameters();
    scpSeguimiento.add('inCrseg_codigo',inCrseg_codigo);
    scpSeguimiento.add('format',TypeFormat.JSON);

    try{
        tmpSeguimiento = SOAPClient.invoke(URL_WS+'Cgg_res_seguimiento', 'selectSeguimientoTramite', scpSeguimiento, false, null);
        tmpSeguimiento = Ext.util.JSON.decode(tmpSeguimiento);
        tmpSeguimiento = tmpSeguimiento[0];
    }catch(inErr){
        inRecordCgg_res_seguimiento = null;
        return;
    }

    inRecordCgg_res_seguimiento = new rSeguimiento({
        CRSEG_CODIGO:tmpSeguimiento.CRSEG_CODIGO,
        CGG_CRSEG_CODIGO:tmpSeguimiento.CGG_CRSEG_CODIGO,
        CRTRA_CODIGO:tmpSeguimiento.CRTRA_CODIGO,
        CRFAS_CODIGO:tmpSeguimiento.CRFAS_CODIGO,
        CGG_CRFAS_CODIGO:tmpSeguimiento.CGG_CRFAS_CODIGO,
        CUSU_CODIGO:tmpSeguimiento.CUSU_CODIGO,
        CRSEG_DESCRIPCION:tmpSeguimiento.CRSEG_DESCRIPCION,
        CRSEG_ESTADO_ATENCION:tmpSeguimiento.CRSEG_ESTADO_ATENCION,
        CRSEG_OBSERVACION:tmpSeguimiento.CRSEG_OBSERVACION,
        CRSEG_TIPO_RESPUESTA:tmpSeguimiento.CRSEG_TIPO_RESPUESTA,
        CRSEG_TIPO_ACTIVIDAD:tmpSeguimiento.CRSEG_TIPO_ACTIVIDAD,
        CRSEG_FECHA_RECEPCION:tmpSeguimiento.CRSEG_FECHA_RECEPCION,
        CRSEG_FECHA_REVISION:tmpSeguimiento.CRSEG_FECHA_REVISION,
        CRSEG_FECHA_DESPACHO:tmpSeguimiento.CRSEG_FECHA_DESPACHO,
        CRSEG_ESTADO_HIJO:tmpSeguimiento.CRSEG_ESTADO_HIJO,
        CRSEG_USUARIO_INSERT:tmpSeguimiento.CRSEG_USUARIO_INSERT,
        CRTRA_NUMERO:tmpSeguimiento.CRTRA_NUMERO,
        CRFAS_NOMBRE:tmpSeguimiento.CRFAS_NOMBRE,
        CUSU_APELLIDOS:tmpSeguimiento.CUSU_APELLIDOS,
        CUSU_ANTERIOR:tmpSeguimiento.CUSU_ANTERIOR,
        CRTRA_FECHA_RECEPCION:tmpSeguimiento.CRTRA_FECHA_RECEPCION,
        CISLA_CODIGO:tmpSeguimiento.CISLA_CODIGO,
        CRSEG_NUMERO:tmpSeguimiento.CRSEG_NUMERO,
        CRPJR_CODIGO:tmpSeguimiento.CRPJR_CODIGO,
        CRTRA_OBSERVACION:tmpSeguimiento.CRTRA_OBSERVACION,
        CRTRA_COMUNICADO_RADIAL:tmpSeguimiento.CRTRA_COMUNICADO_RADIAL,
        CRPER_CODIGO:tmpSeguimiento.CRPER_CODIGO,
        CRPER_BENEFICIARIO:tmpSeguimiento.CRPER_BENEFICIARIO,
        CGG_CRPER_CODIGO:tmpSeguimiento.CGG_CRPER_CODIGO,
        CRPER_AUSPICIANTE:tmpSeguimiento.CRPER_AUSPICIANTE,
        CRTRA_ANIO:tmpSeguimiento.CRTRA_ANIO,
        CISLA_NOMBRE:tmpSeguimiento.CISLA_NOMBRE,
        CRTRA_ACTIVIDAD_RESIDENCIA:tmpSeguimiento.CRTRA_ACTIVIDAD_RESIDENCIA,
        CRTST_DESCRIPCION:tmpSeguimiento.CRTST_DESCRIPCION,
        CRFAS_NOMBRE_ANTERIOR:tmpSeguimiento.CRFAS_NOMBRE_ANTERIOR,
        CRPJR_RAZON_SOCIAL:tmpSeguimiento.CRPJR_RAZON_SOCIAL,
        CRTST_CODIGO:tmpSeguimiento.CRTST_CODIGO,
        VEHICULO:tmpSeguimiento.VEHICULO,
        CRPRO_CODIGO:tmpSeguimiento.CRPRO_CODIGO,
        SEGUIMIENTO_HTML:tmpSeguimiento.SEGUIMIENTO_HTML,
        CRTRA_FOLIO:tmpSeguimiento.CRTRA_FOLIO,
        CRTRA_DIAS_PERMANENCIA:tmpSeguimiento.CRTRA_DIAS_PERMANENCIA,
        CRTRA_FECHA_ENTRADA:tmpSeguimiento.CRTRA_FECHA_ENTRADA,
        CRTRA_FECHA_SALIDA:tmpSeguimiento.CRTRA_FECHA_SALIDA,
        CRTRA_GRUPO:tmpSeguimiento.CRTRA_GRUPO,
        CRTRA_ORDEN:tmpSeguimiento.CRTRA_ORDEN,
        CRETT_CODIGO:tmpSeguimiento.CRETT_CODIGO
    });


    var objCgg_res_seguimiento = MyDesktop.desktop.getWindow('winFrmCgg_res_seguimiento');
    if (objCgg_res_seguimiento){
        objCgg_res_seguimiento.maximize();
        objCgg_res_seguimiento.close();
    }
    objCgg_res_seguimiento = new FrmCgg_res_seguimiento(inRecordCgg_res_seguimiento,MyDesktop.desktop);
    objCgg_res_seguimiento.loadData(true);
    objCgg_res_seguimiento.show();

}

function randomFromTo(from, to){
    return Math.floor(Math.random() * (to - from + 1) + from);
}

/**
 *Funcion. Comprueba la conexion al servidor esperando una respuesta con una llamada a la pagina test.html.
 */
function comprobarConexion(){
    new Ajax.Request('test.html',{
        onComplete: function(inServerResponse) {
            if(inServerResponse.status != 200 || navigator.onLine == false){
                Ext.MsgPopup.msg(APP_TITLE, "Vaya, por el momento estamos sin conexi\u00f3n!<br>Espera unos pocos minutos y trata de nuevo.", MsgPopup.WARNING);
                ONLINE = false;
            }else if(ONLINE == false){
                Ext.MsgPopup.msg(APP_TITLE, "El servicio ha regresado!.", MsgPopup.INFO);
                ONLINE = true;
            }
        }
    });
}

/**
 * Funcion. comprueba si el usuario actual tiene seguimientos y se encarga de notificarlos en un hilo de ejecucion.
 */
function comprobarSeguimiento(){
	var user =new UserSession();
    var flagAviso = new ManagerCookies().read('NO_AVISO_SEGUIMIENTO');
    if(flagAviso !==null && flagAviso =="true"){
        return;
    }
	//if (Ext.getCmp("winFrmListadoCgg_res_seguimiento") || Ext.getCmp("winFrmListadoCgg_gem_vacante"))
    SOAPClient.invoke(URL_WS+'Cgg_res_seguimiento', 'selectCountNotificacion', false, true, function(inServiceResponse){
        var tmpResultado;
		try{
			tmpResultado =  eval("("+inServiceResponse+")");
		}catch(e){
			tmpResultado = [];
		}
		if (tmpResultado.length == 0)
			return;
		
		var countTramites = tmpResultado[0].COUNT_TRAMITES;
        var countOfertas = tmpResultado[0].COUNT_OFERTAS;
		if(countTramites>0 || countOfertas>0){
			if(countTramites>0 && document.getElementById('divLnkSeguimiento'))
				document.getElementById('divLnkSeguimiento').innerHTML= 'Seguimiento de tramites(<span class="textResaltado">'+countTramites+'</span>)';
            var linkTramites ='<div id = "btnRevisarTarea" style="margin:5 10 5 10" class="link"><span style="margin-right:10"><b>'+countTramites+'</b></span><span>Tr\u00e1mite(s) pendientes</span></div>';
			var linkOfertas ='<div id = "btnRevisarOferta" style="margin:5 10 5 10" class="link"><span style="margin-right:10"><b>'+countOfertas+'</b></span><span>Oferta(s) de empleo por aprobar</span></div>';
			var objNotificadorSeguimiento = new Ext.ux.window.MessageWindow({
                title: "Tareas por atender",
                autoHeight: true,
                closable:true,
                pinOnClick:false,
				draggable: false,
                help:false,
                hideFx: {delay: 4000,mode: 'standard',useProxy: false},
                iconCls: 'messagebox_info_16',
				html: (countTramites>0?linkTramites:'')+(countOfertas>0?linkOfertas:'')+
				'<div style="margin:15 10 5 10"><input  id = "chkRecordar" type="checkbox"/><span style="margin-left:5"><i>No avisarme</i></span></div>',
                showFx: {delay: 0,mode: 'standard',useProxy: false},
                width: 250
            }).show(Ext.getDoc());
						
			document.getElementById("chkRecordar").onclick = function(inChecked){
				if(inChecked==true){
					new ManagerCookies().erase('NO_AVISO_SEGUIMIENTO');
					new ManagerCookies().create('NO_AVISO_SEGUIMIENTO', true, 168);
				}else{
					new ManagerCookies().erase('NO_AVISO_SEGUIMIENTO');
				}
			}
			if(countTramites>0)		
				document.getElementById("btnRevisarTarea").onclick = function(){				
				try{
                            var win = MyDesktop.desktop.getWindow('winFrmListadoCgg_res_seguimiento');
                            if (!win){
                                win = new FrmListadoCgg_res_seguimiento(MyDesktop.desktop);
                            }
                            win.show();
                            objNotificadorSeguimiento.close();
                        }catch(inErr){
                            Ext.Msg.show({
                                title:APP_TITLE,
                                msg:'Se present\u00F3 un problema.<br>Error:'+inErr+'.<br>'+ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
						
				}
			if(countOfertas>0)	
				document.getElementById("btnRevisarOferta").onclick = function(){				
				try{
                            var win = MyDesktop.desktop.getWindow('winFrmListadoCgg_gem_vacante');
                            if (!win){
                                win = new FrmListadoCgg_gem_vacante(MyDesktop.desktop);
                            }
                            win.show();							
                            objNotificadorSeguimiento.close();
                        }catch(inErr){
                            Ext.Msg.show({
                                title:APP_TITLE,
                                msg:'Se present\u00F3 un problema.<br>Error:'+inErr+'.<br>'+ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }						
				}
        }        
    });
}
/**
 * Funcion. Mensaje de bienvenida de usuario
 */
function bienvenidaUsuario(){
    var user =new UserSession();
    if(user !==null && user.getUserName() !== undefined && user.getUserName().trim().length >=1 ){
        if(user.isCambiarClave() || user.getCaducidad() <= 0 && user.isCaducaClave() ){
            Ext.Msg.show({
                title:APP_TITLE,
                msg:'Actualize su clave de acceso antes de continuar, por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.INFO,
                fn:function(btn){
                    var tmpDlg = new DlgUsuarioAC(user,false);
                    tmpDlg.setUserName(user.getUserName());
                    tmpDlg.show();
                }
            });
        }else{
            var tmpUsername = user.getUserName();
            Ext.MsgPopup.msg(APP_TITLE, 'Bienvenido '+tmpUsername+'!', MsgPopup.INFO);
            Ext.getCmp('lblBienvenido').setTitle('Bienvenido '+tmpUsername); 
            Ext.getDom('ux-clockbutton-text').innerHTML = tmpUsername;
            Ext.getDom('user-info').src="resources/images/16x16/actions/metacontact_away.png";
        }
    }
}

function miFormatoHandler(inItem){
    OUTPUT_REPORT = inItem.getId().substring(2).toLowerCase();
}

/**
 *Funcion. Comprueba una compatibilidad basica de exploradores web para el SIICGG.
 */
function comprobarExplorador(){
    if(Ext.isChrome == false && Ext.isFirefox == false && Ext.isOpera == false && Ext.isSafari4==false ){
        Ext.Msg.show({
            title:APP_TITLE,
            msg:'Vaya!, su explorador todavia no es soportado completamente por el sistema!<br>Le recomendamos utilizar Google Chrome, Mozilla Firefox, Opera o Apple Safari.',
            buttons: Ext.Msg.OK,
            icon: Ext.MessageBox.WARNING
        });
    }
}

Ext.onReady(function(){    
    setTimeout('AppCommonStores()',1);
    setTimeout('comprobarExplorador()',1);
    setTimeout('bienvenidaUsuario()',10000);
    Ext.TaskMgr.start({
        run: comprobarSeguimiento,
        interval: 240000
    });

    Ext.TaskMgr.start({
        run: comprobarConexion,
        interval: 300000
    });   
    
});

function clone1(o) {
    if(!o || 'object' !== typeof o) {
        return o;
    }
    if('function' === typeof o.clone) {
        return o.clone();
    }
    var c = '[object Array]' === Object.prototype.toString.call(o) ? [] : {};
    var p, v;
    for(p in o) {
        if(o.hasOwnProperty(p)) {
            v = o[p];
            if(v && 'object' === typeof v) {
                c[p] = clone1(v);
            }
            else {
                c[p] = v;
            }
        }
    }
    return c;
}