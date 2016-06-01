Ext.BLANK_IMAGE_URL='lib/extjs/resources/images/default/s.gif';
var URL_SERVER= document.URL.split('/')[2];
var URL_WS = "/siiws/";
var URL_APP="/sii/";
var URL_DOC_VIEWER="/siiws/DocViewer";
var URL_REPORT='http://'+document.domain+':8081/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii';
var URL_LOGOUT = 'SessionManager?request=logout';
var APP_TITLE='SIICGG';
var OUTPUT_REPORT='pdf';
var MSG_ACCESS_ERROR = 'Acceso no autorizado, por favor consulte con el Administrador del Sistema. ';
var ERR_TITLE_MESSAGE='Error SIICGG';
var ERR_MESSAGE='Por favor pongase en contacto con el administrador o proveedor de software informando la secci\u00F3n, fecha y hora del problema.<br>Le pedimos disculpas por las molestias ocasionadas.'
var RECORD_PAGE = 30;
var URL_SESSION=URL_APP+'SessionManager';
var NO_DATA_MESSAGE = 'Informaci\u00F3n no disponible';
var ONLINE = true;
var CURRENT_DATE = new Date();
var RPT_FORMAT = 'pdf';
var SII_mimeType = "application/x-nbiometric";
var defaultInPage=1;
var defaultInRowsPerPage=1;

var stDiagramaHistorial = null;

/*
* TIPO DE FORMATOS DE FECHA
*/
var TypeDateFormat = {
    ISO8601Long:"Y-m-d H:i:s",//date time
    ISO8601Short:"Y-m-d",
    CGG:'d/m/Y',
    Custom:"Y-m-d\\TH:i:s" //Timestamp
}

/*
* TIPOS DE FORMATOS DE INFORMACION
*/
var TypeFormat ={
    JSON:"JSON",
    XML:"XML"
};

/*
* TIPO DE GENEROS
*/
var TypeGenero ={
    MASCULINO:0,
    FEMENINO:1
};

/*
* TIPO DE ESTADO DE NOTIFICACIONES
*/
var TypeEstadoNotificacion ={
    REGISTRADA:0,
    PROCESADA:1,
    ANULADA:2,
    EJECUTADA:3,
    PERMITIDO_INGRESO:4
};

/*
*TIPO DE AUSPICIANTE
*/
var TypeAuspiciante ={
    NATURAL:0,
    JURIDICA:1
};

/*
* TIPO DE RESULTADOS
*/
var TypeResult={
    TRUE:1,
    FALSE:0
};

/*
*  ESTADO DE INGRESO A LA PROVINCIA
*/
var TypeImpos={
    IMPEDIDO:true,
    INGRESO:false
};

/*
* TIPO DE DISCAPACIDADES DE UNA PERSONA
*/
var TypePersonaDiscapacidad={
    NINGUNA:0,
    DISCAPACIDAD_FISICA:1,
    DISCAPACIDAD_COGNITIVA:2,
    DISCAPACIDAD_SENSORIAL:3
}

/*
* TIPO DE INGRESO DE PERSONA
*/
var TypeInPerson={
    RESIDENCIA:0,// Regular
    OTROS:1 // Irregular
}

/*
* TIPO DE ESTADO
*/
var TypeEstado={
    ACTIVO:true,
    INACTIVO:false
}

/*
* TIPO DE HERRAMIENTA
*/
var TypeTooltip =
{
    GUARDAR:'Guardar',
    CANCELAR:'Cancelar edici\u00f3n',
    CERRAR:'Cerrar',
    NUEVO:'Nuevo registro',
    EDITAR:'Editar registro seleccionado',
    ELIMINAR:'Eliminar registro seleccionado',
    SALIR:'Salir',
    BUSCAR:'Buscar',
    IMPRIMIR:'Imprimir'

}

/*
* TIPO DE MOVIMIENTO DE UN EXPEDIENTE 
*/
var TypeMovimientoExpediente={
    ARCHIVO:'',
    INGRESO:1,
    SALIDA:2
}

/*
* TIPO DE MOVIMIENTO INTERNO
*/
var TypeMovimientoInterno={
    INGRESOPROVINCIA:'',
    INGRESOISLA:1,
    SALIDAISLA:0
}

/*
* TIPO DE ESTADO DE HIJOS
*/
var TypeEstadoHijo={
    SINHIJOS:-1,
    SINRESPUESTAS:0,
    RESPUESTAPARCIAL:1,
    RESPUESTATOTAL:2
}

/*
* TIPO DE RESPUESTAS DE SEGUIMIENTOS
*/
var TypeRespuestaSeguimiento={
    INDETERMINADO:-1,
    NEGADO:0,
    APROBADO:1
}

/*
* TIPO DE ESTADO DE ATENCION
*/
var TypeEstadoAtencion={
    RECIBIDO:0,
    REVISADO:1,
    DISTRIBUIDO:2,
    PENDIENTE:3,
    DESPACHADO:4,
    FINALIZADO:5,
    INHABILITADO:6,
    REVISADODISTRIBUIDO:7
}

/*
* TIPOS DE NOVEDADES DE NOTIFICACIONES
*/
var TypeNovedadNotificacion={
    NOTIFICACION:0,
    COMENTARIO:1
}

/*
* TIPOS DE MENSAJES DE VENTANAS POPUP
*/
var MsgPopup={
    WARNING:'messagebox_warning.png',
    INFO:'messagebox_info.png'
}

/*
*TIPOS DE ESTADO DE UNA OFERTA
*/
var TypeEstadoOferta={
    REGISTRADA:0,
    APROBADA:1,
    VENCIDA:2,
    FINALIZADA:3
};

/*
*TIPOS DE ESTADO DE LAS CONVOCATORIAS
*/
var TypeEstadoConvocatoria={
    REGISTRADA:0,
    APROBADA:1,
    ANULADA:2,
    EN_PROCESO:3,
    SUSPENDIDA:4,
    CONCLUIDA:5
};

/*
* TIPOS DE DURACION DE UN TRABAJO
*/
var TypeDuracionTrabajo={
    HORA:0,
    DIA:1,
    MES:2,
    ANIO:3
};

/*
*TIPOS DE APROBACION DE UNA OFERTA
*/
var TypeAprobacionOferta={
    NOAPROBADO:0,
    APROBADOGENERADO:1,
    OTROS:2
}

/*
* TIPOS DE ESPECIE
*/
var TypeEspecie={
    RESIDENCIA:0,
    TCT:1,
    OTROS:2
}

/*
* TIPOS DE AMBITOS DE UNA ESPECIE
*/
var TypeAmbitoEspecie={
    RESIDENCIA:0,
    TCT:1,
    INTF:2
}

/*
* TIPOS DE MOVIMIENTOS DE LA KARDEX
*/
var TypeMovimientoKardek=
{
    INVENTARIO_INICIAL:0,
    INGRESO:1,
    SALIDA:2
}

/*
* TIPOS DE OPERACIONES DE KARDEX
*/
var TypeOperacionKardex=
{
    COMPRA:0,
    VENTA:1,
    ANULACION:2,
    DEVOLUCION:3,
    OTRAS:4
}

/*
* TIPOS DE DENUNCIAS
*/
var TypeDenuncia={
    RESIDENCIA:0,
    GESTIONEMPLEO:1
}

/*
* TIPOS DE OBJETOS
*/
var TypeObjeto={
    INTERFACE:0,
    SERVICIO:1
}

/*
* TIPOS DE ESTADOS DE MIGRACION
*/
var Typeestatus_migratorio = {
    NO_PERMITIDO:0,
    PERMITIDO:1
}

/*
*TIPO DE ESTADO DE BECA
*/
var TypeEstadoBeca={
    ACTIVO:0,
    INACTIVO:1,
    NO_VIGENTE:2
}

/*
* TIPOS DE APROBACION DE BECAS
*/
var TypeBecaAprobacion={
    NO_CONCLUIDA:0,
    REGISTRADA:1,
    EN_SEGUIMIENTO:2,
    CONCLUIDA:3,
    REPROBADA:4,
    TERMINADA_CASO_FORTUITO:5
}
/*
* TIPO DE RESIDENCIA PARA EL TIPO CURSO
*/
var TypeCursoAsistente={
    PERMANENTE_TEMPORAL:0,
    PERMANENTE:1,
    OTROS:2
};

/*
* TIPO DE RESIDENCIA
*/
var TypeResidencia={
    NINGUNA:'',
    PERMANENTE:'',
    TEMPORAL:'',
    TRANSEUNTE:'',
    TURISTA:''
};

/*
* TIPOS DE ADVERSARIOS
*/
var TypeAdversario ={
    PERSONA_NATURAL:0,
    PERSONA_JURIDICA:1
};

/*
* TIPOS DE ASIGNACIONES
*/
var TypeAsignacion={
    TRANSFERENCIA : 0,
    USUARIOS : 1,
    INDETERMINADO :-1
}
/*
 *ESTADO PARA LA ADMINISTRACION DE BECA
 *
 */
var TypeCiclo=
{
    ANUAL:0,
    SEMESTRAL:1,
    QUIMESTRAL:2,
    OTROS:3
}

/*
* TIPOS DE ESTADOS DE CICLOS ACADEMICOS
*/
var TypeEstadoCicloAcademico=
{
    NO_APROBADO:0,
    REGISTRADO:1,
    POR_APROBAR:2,
    APROBADO:3,
    CERTIFICADO:4,
    OTROS:5
}

/*
* TIPOS DE ESTADO DE APROBACIONES DE CURSOS
*/
var TypeEstadoAprobadoCurso=
{
    REPROBADO:0,
    APROBADO:1,
    RETIRADO:2,
    SIN_CALIFICACION:''
}

/*
* TIPOS DE ESTADOS DE INSCRIPCIONES
*/
var TypeEstadoInscripcion=
{
    PRE_INSCRITO:0,
    INSCRITO:1,
    ANULADO:2
}

/*
*TIPO DE ADJUNTO BECA
*/
var TypeAdjuntoBeca={
    CONTRATO_BECA:0,
    INFORME:1,
    MEMORANDUM_APROBACIONES:2,
    OTROS:3
}

/*
*TIPOS DE ESTADOS DEL CURSO
*/
var TypeEstadoCurso={
    REGISTRADO:0,
    PROCESO_INSCRIPCION:1,
    INICIADO:2,
    TERMINADO:3,
    FINALIZADO:4,
    SUSPENDIDO:5,
    CANCELADO:6
}

/*
 * ESTADO ASIGNACION PARA OPERACIONES Y CONTROL
*/ 
var TypeEstadoAsignacion=
{
    REGISTRADA:0,
    REASIGNADA:1,
    FINALIZADA:2
}

/*
 * ESTADO ASIGNACION PARA OPERACIONES Y CONTROL
 */
var TypeEstadoTransferencia=
{
    REGISTRADA:0,
    EJECUTADA:1

}

/*
 * TIPOS DE ESTADOS ASIGNACION PARA OPERACIONES Y CONTROL
 */
var TypeEstadoAnulacion=
{
    REGISTRADA:0,
    CONFIRMADA:1

}

/*
* TIPOS DE ESTADOS DE VENTA
*/
var TypeEstadoVenta=
{
    REGISTRADA:0,
    CONFIRMADA:1,
    CONTABILIZADA:2,
    TODOS:10
}

/*
* TIPOS DE ESTADOS DE CIERRE
*/
var TypeEstadoCierre=
{
    REGISTRADA:0,
    CONFIRMADA:1
}

/*
* TIPOS DE CIUDADANIA DE PERSONA
*/
var TypeCiudadPersona=
{
    NACIMIENTO:0,
    RESIDENCIA:1,
    RESIDENCIA_ANTERIOR:2
}

/*
* TIPOS DE ESTADO DE COMUNICADOS
*/
var TypeEstadoComunicado=
{
    REGISTRADO:0,
    OTROS:1
}

/*
* TIPOS DE VEHICULOS
*/
var TypeVehiculo=['Terrestre','Mar\u00edtimo', 'A\u00e9reo'];

/*
* TIPOS DE TIPO DE PROCESOS
*/
var TypeTipoProceso = {
    Demanda_Planteada :0,
    Demanda_Recibida:1
}

/*
* TIPOS DE ESTADO DE EJECUCIONES
*/
var TypeEstadoEjecucion = {
    Planteado:0,
    En_Proceso:1,
    Finalizado:2,
    Suspendido:3
}

/*
* TIPOS DE TIPO DE ACUERDOS
*/
var TypeTipoAcuerdo = {
    Contrato:0,
    Convenio:1
}

/*
* TIPOS DE OFICIALES DE SEGUIMIENTO
*/
var TypeOficialSeguimiento= {
    Oficial:0,
    Jefe:1
}

/*
* TIPO DE OPERACION MOVILIDAD
*/
var TypeOperacionMovilidad={
    ENTRADA:0,
    SALIDA:1
};

/*
* TIPOS DE CONTROL
*/
var TypeControlSerie={
    TRANSFERENCIA : 0,
    ASIGNACION : 1
}
/*--------------------STORE GLOBALES--------------------------*/

var dsTipoParticipante = [[0,'Auspiciante'],[1,'Beneficiario'],[2,'Conyuge/Conviviente'],[3,'Padre/Madre'],[4,'General']];
var dsTipoPersonaDiscapacidad = [[0,'Ninguna'],[1,'Fisica'],[2,'Cognitiva'],[3,'Sensorial']];
var dsTipoPersonaJuridica = [[0,'Interna'],[1,'Externa']];
var dsGeneroPersona = [[0,'M'],[1,'F']];
var dsTipoNovedadNotificacion = [[0,'Comentario'],[1,'Notificacion']];
var dsEstadoAtencionSeguimiento  = [[0,'Recibido'],[1,'Revisado'],[2,'Distribuido'],[3,'Pendiente'],[4,'Despachado'],[5,'Finalizado'],[6,'Inhabilitado'],[7,'Revisado de distribuici\u00f3n']];
var dsEstadoAtencion  = [[0,'Recibido'],[1,'Despachado'],[2,'Todos']];
var dsModalidad = [[0,'PERIODO'],[1, 'INDEFINIDO']];
var dsOperador=[['=','Igual(=)'],['!=','No es igual(!=)'],['<','Menor(<)'],['>','Mayor(>)'],['>=','Mayor o igual(>=)'],['<=','Menor o igual(<=)']];
var dsTipoOperacion = [[0,'Entrada'],[1,'Salida']];
var dsRptTipoOperacion = [[0,'Entrada'],[1,'Salida'],[2,'Todas']];
var dsDuracionTrabajo = [[0,'Hora'],[1,'D\u00eda'],[2,'Mes'],[3,'A\u00f1o']];
var dsAprobacionOferta = [[0,'No aprobado'],[1,'Aprobado y generado comunicado radial'],[2,'Otros']];
var dsEstadoOferta = [[0,'Registrada'],[1,'Aprobada'],[2,'Vencida'],[3,'Finalizada']];
var dsTipoSalida = [[0,'Normal'],[1,'Otros']];
var dsTipoPagoSalida = [[0,'Propio'],[1,'CGG']];
var dsTipoAerolinea= [[0,'Externa'],[1,'Interna']];
var dsTipoAeropuerto= [[0,'Externo'],[1,'Interno']];
var dsTipoVehiculo= [[0,'Terrestre'],[1,'Mar\u00edtimo'],[2,'A\u00e9reo'],[3,'Todos']];
var dsEstadoVehiculo= [[0,'Registrado'],[1,'Aprobado'],[2,'Censado'],[3,'Aprobado/Censado'],[4,'Devuelto'],[5,'Anulado']];
var dsTipoEspecie= [[0,'Residencia'],[1,'Tct'],[2,'Otros'],[4,'Todos']];
var dsEstadoDeposito = [[0,'Registrado'],[1, 'Contabilizado'],[2, 'Autorizado devoluci\u00f3n'],[3,'Devuelto'],[4,'Temporal']];
var dsRptEstadoDeposito = [[0,'Registrado'],[1, 'Contabilizado'],[2, 'Autorizado devoluci\u00f3n'],[3,'Devuelto'],[4,'Temporal'],[5,'Todos']];
var dsTipoIngresoVehiculo = [[0,'Permanente'],[1,'Temporal']];
var dsTipoTramiteVehiculo = [[0,'Veh\u00edculo'],[1,'Motor']];
var dsTipoAccionVehiculo = [[0,'Nuevo'],[1,'Existente'],[2,'Existente libre']];
var dsMotivoCarnet = [[0,'Nuevo'],[1,'Renovaci\u00f3n'],[2,'Deterioro'],[3,'P\u00e9rdida']];
var dsRptMotivoCarnet = [[0,'Nuevo'],[1,'Renovaci\u00f3n'],[2,'Deterioro'],[3,'P\u00e9rdida'],[4,'Todos']];
var dsTipoCaducidad = [[0,'Fecha'],[1,'D\u00edas']];
var dsTipoCuentaBancaria = [[0,'Corriente'],[1,'Ahorros']];
var dsTipoResolucion = [[0,'Normativa'],[1,'Aprobaci\u00f3n']];
var dsEstadoResolucion = [[0,'Para votaci\u00f3n'],[1,'Aprobada'],[2,'Negada'], [3,'Ejecutada'],[4,'Anulada']];
var dsEstadoConvocatoria =[[0,'Registrada'],[1,'Aprobada'],[2,'Anulada'],[3,'En proceso'],[4,'Suspendida'],[5,'Concluida']];
var dsEstadoRegistroTct = [[0,'Pre-registrada'],[1,'Impresa'],[2,'Activa'],[3,'Anulada'],[4,'Soporte'],[5,'Todos']];
var dsTipoGarantia = [[0,'Deposito'],[1,'Cheque'],[2,'Poliza'],[3,'Otros'],[4,'Todos']];
var dsEstadoNotificacion = [[0,'Registrada'],[1,'Procesada'],[2,'Anulada'],[3,'Ejecutada'],[4,'Permitido ingreso']];
var dsEstadoPermitidoNotificacion = [[0,'No Permitido'],[1,'Permitido'],[2,'Todos']];
var dsUbicacion = [[0,'Dentro'],[1,'Fuera'],[2,'Todos']];
var dsTipoPeriodoGem  = [[2,'Por fechas'],[0,'Anual'],[1,'Mensual']];
var dsFiltroGem  = [[0,'Por Isla'],[1,'Sector'],[2,'Por Sector/Isla']];
var dsCandidatosGem  = [[0,'Aplicados'],[3,'Ubicados'],[4,'Rechazados']];
var dsTipoSolicitudPadre  = [['CRTST1','Permanente'],['CRTST2','Temporal'],['','Todos']];
var dsTipoSolicitudPadreTranseunte  = [['CRTST1','Permanente'],['CRTST2','Temporal'],['CRTST7','Transeunte']];
var dsTipoSolicitudPadreTranseunteTodos  = [['CRTST1','Permanente'],['CRTST2','Temporal'],['CRTST7','Transeunte'],['','Todos']];
var dsTipoSolicitudPadreTuristaTranseunteTodos  = [['CRTST1','Permanente'],['CRTST2','Temporal'],['CRTST6','Turista'],['CRTST7','Transeunte'],['','Todos']];
var dsTipoSolicitudPadrePerTemp  = [['CRTST1','Permanente'],['CRTST2','Temporal']];
var dsMes = [[1,'Enero'],[2,'Febrero'],[3,'Marzo'],[4,'Abril'],[5,'Mayo'],[6,'Junio'],[7,'Julio'],[8,'Agosto'],[9,'Septiembre'],[10,'Octubre'],[11,'Noviembre'],[12,'Diciembre'],[13,'Todos']];
var dsCategoriasTCT=[[0,'Turistas'],[1,'Transeuntes']];
var dsTipoNacionalidad=[[0,'Nacional'],[1,'Extranjero']];
var dsRespuestaSeguimientoRpt=[[2,'Todos'],[1,'Aprobado'],[0,'Negado'],[-1,'Indeterminado']];
var dsTipoIngreso=[[0,'Todos los impresos'],[1,'S\u00f3lo los que ingresaron a GPS']];
var dttipo_estatus_migratorio = [
[0,'NO PERMITIDO'],
[1,'PERMITIDO']
];

var dsTipoBeca=[
[0,'ACTIVO'],
[1,'INACTIVO'],
[2,'NO VIGENTE']
];

var dsTipoRepresentante=[
[0,'PADRE'],
[1,'MADRE'],
[2,'REPRESENTANTE LEGAL'],
[3,'APODERADO'],
[4,'GARANTE']
];
var dsTipoAprobacionBeca=[

[0,'NO CONCLUIDA'],
// [1,'REGISTRADA'],
// [2,'EN_SEGUIMIENTO'],
// [3,'CONCLUIDA'],
[4,'REPROBADA'],
[5,'TERMINADA POR CASO FORTUITO']
];
var dsTipoAprobacionCiclo=[
[0,'NO APROBADO'],
[1,'REGISTRADO'],
[2,'POR APROBAR'],
[3,'APROBADO'],
[5,'OTROS']
];
var dsTipoCiclo=[
[0,'ANUAL'],
[1,'SEMESTRAL'],
[2,'QUIMESTRAL'],
[3,'OTROS']
];
var dsEstadoCurso=[
[1,'PROCESOSO INSCRIPCION'],
[2,'INICIADO'],
[5,'SUSPENDIDO'],
[6,'CANCELADO']
];
var dsEstadoCursoAsistente=[
[0,' REPROBADO'],
[1,'APROBADO'],
[2,'RETIRADO'],
[3,'SIN CALIFICACION']
];
var dsEstadoInscrito=[
[0,'PRE_INSCRITO'],
[1,'INSCRITO'],
[2,'ANULADO']
];
/**
 * Ext.form.NumberField tipo de adjunto
 */
var dtCdad_tipo = [
[0,'CONTRATO DE BECA'],
[1,'INFORME'],
[2,'MEMORANDUM DE APROBACIONES'],
[3,'OTROS']
];
/**
 * Ext.form.NumberField tipo de adjunto
 */
var dsTipoBusqueda = [
[0,'RESIDENTE TEMPORAL CAPACITADO'],
[1,'RESIDENTE PERMANENTE CAPACITADO'],
[2,'RESIDENTE GENERAL CAPACITADO']
];


var dsEstadoAsesor = [[0,'No Activo'],[1,'Activo'],[2,'Otro']];
var dsTipoProceso = [[0,'Demanda Planteada'],[1,'Demanda Recibida']];
var dsEstadoEjecucion = [[0,'Planteado'],[1,'En Proceso'],[2,'Finalizado'],[3,'Suspendido']];
var dsTipoAcuerdo = [[0,'Contrato'],[1,'Convenio']];
var dsEstadoAcuerdo = [[0,'FIRMADO'],[1,' EN PROCESO'],[2,'FINALIZADO'],[3,'SUSPENDIDO']];
var dsTipoMovimientoProceso = [[0,'ENTRADA'],[1,'SALIDA']];
var dsTipoAdversario = [[0,'PERSONA NATURAL'],[1,'PERSONA JURIDICA']];
var mensajesTCT =new Array ();
mensajesTCT ['MTCT1'] ='Registro de Salida no encontrado';
mensajesTCT ['MTCT2'] ='Persona, ya preregistrada anteriormente';
var dsTipoAnulacion = [[0,'Defecto fabrica'],[1,'Activo'],[2,'Otro']];
var dsTipoOcupacionLaboral = [[0,'Publica'],[1,'Privada'],[2,'Propia'],[3,'Otros']];
var dsExportableResidencia = [[0,'Permanente'],[1,'Temporal'],[2,'Ambos']];
var dsExportableTipo = [['ARCHIVO','Archivo'],['EXPLORADOR','Salida a explorador']];

var TypeOcupacionLaboral={
    PUBLICA:0,
    PRIVADA:1,
    PROPIA:2,
    OTROS:3
}
/**
 * Ext.data.Store Almacenamiento global de registro para los requisitos de una
 * solicitud.
 */
var SCGG_RES_TIPO_CONTACTO = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_tipo_contacto",
        method:"selectAll"
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({},[
    {
        name:'CRTCO_CODIGO'
    },

    {
        name:'CRTCO_NOMBRE'
    },

    {
        name:'CRTCO_NOMBRE_IMAGEN'
    },

    {
        name:'CRTCO_IMAGEN'
    }
    ]),
    baseParams:{
        format:"JSON"
    }
});

/**
 * Ext.data.Store Almacenamiento global de registro para los requisitos de una
 * solicitud.
 */
var SCGG_RES_REQUISITO = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_requisito",
        method:"selectAll"
    }),
    remoteSort:false,
    reader:new Ext.data.JsonReader({},[
    {
        name:'CRREQ_CODIGO'
    },

    {
        name:'CRREQ_DESCRIPCION'
    },

    {
        name:'CRREQ_OBSERVACION'
    }
    ]),
    baseParams:{
        format:"JSON"
    },
    listeners:{
        load:function(){
            SCGG_RES_REQUISITO.sort('CRREQ_DESCRIPCION','ASC');
        }
    }
});

/**
 * Ext.data.Store Almacenamiento de informacion de pais.
 */
var SCGG_PAIS = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_pais",
        method:"selectAllJoin"
    }),
    remoteSort:false,
    reader:new Ext.data.JsonReader({},[
    {
        name:'CPAIS_CODIGO'
    },

    {
        name:'CPAIS_NOMBRE'
    },

    {
        name:'CPAIS_DESCRIPCION'
    }
    ]),
    baseParams:{
        format:TypeFormat.JSON
    }
});
/**
 * Ext.data.Store Almacenamiento de informacion de la provincia.
 */
var SCGG_PROVINCIA = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_provincia",
        method:"selectAll"
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({},[
    {
        name:'CGPRV_CODIGO'
    },
    {
        name:'CPAIS_CODIGO'
    },
    {
        name:'CGPRV_NOMBRE'
    },
    {
        name:'CGPRV_DESCRIPCION'
    }
    ]),
    baseParams:{
        format:TypeFormat.JSON
    }
});
/**
 * Ext.data.Store Almacenamiento de informacion de canton.
 */
var SCGG_CANTON = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_canton",
        method:"selectAll"
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({},[
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
        name:'CCTN_DESCRIPCION'
    }
    ]),
    baseParams:{
        format:TypeFormat.JSON
    }
});
/**
 * Ext.data.Store Almacenamiento de informacion de isla
 */
var SCGG_ISLA = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_isla",
        method:"selectAll"
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({},[
    {
        name:'CISLA_CODIGO'
    },
    {
        name:'CCTN_CODIGO'
    },
    {
        name:'CISLA_NOMBRE'
    }
    ]),
    baseParams:{
        format:TypeFormat.JSON
    }
});

/**
 * * Ext.data.Store Coleccion de datos de los tipos de tramites.
 */
var SCGG_RES_PARROQUIA= new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_parroquia",
        method:"selectAll"
    }),
    reader:new Ext.data.JsonReader({},[
    {
        name:'CPRR_CODIGO'
    },

    {
        name:'CCTN_CODIGO'
    },

    {
        name:'CPRR_NOMBRE'
    },

    {
        name:'CPRR_DESCRIPCION'
    },

    {
        name:'CPRR_TIPO'
    }
    ]),
    baseParams:{
        format:TypeFormat.JSON
    }
});
/**
 *Persona. Crea un funcion prototipada de persona para extraccion de informacion de personal.
 */
function Persona(){

    var cm = null;
    var store = null;
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     * cgg_res_persona.
     */
    cm =new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'No. documento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_PATERNO',
        header:'Apellido paterno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_MATERNO',
        header:'Apellido materno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha nacimiento',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CRPER_LUGAR_NACIMIENTO',
        header:'Lugar nacimiento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:150,
        sortable:true,
        renderer:function(inCrper_genero){
            if(inCrper_genero==TypeGenero.MASCULINO){
                return('MASCULINO')
            }
            if(inCrper_genero==TypeGenero.FEMENINO){
                return('FEMENINO')
            }
        }
    },

    {
        dataIndex:'CRPER_NUMERO_RESIDENCIA',
        header:'Numero residencia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_AUTORIZADO',
        header:'Autorizado',
        width:150,
        sortable:true
    }
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un
     * campo especifico.
     */
    store=new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageLite",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_LUGAR_NACIMIENTO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRPER_OBSERVACIONES'
        },

        {
            name:'CRPER_NUMERO_RESIDENCIA'
        },

        {
            name:'CRPER_AUTORIZADO'
        },

        {
            name:'CRPER_NUMERO_EXPEDIENTE'
        }
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:TypeResidencia.NINGUNA,
            inCarnet:false,
            inIdentificacion:''
        }
    });
    this.getCm = function(){
        return cm;
    }

    this.getStore = function(){
        return store;
    }

    this.changeParamValue=function(inParam,inValue){
        eval('this.getStore().baseParams.'+inParam+"='"+inValue+"'");
    }

}

Persona.prototype.getColumnModel=function(){
    return this.getCm();
}

Persona.prototype.getStore=function(){
    return this.getStore();
}

Persona.prototype.changeParamValue=function(inParam,inValue){
    this.changeParamValue(inParam,inValue);
}


/**
 *Persona. Crea un funcion prototipada de persona para extraccion de informacion de personal.
 */

function PersonaAsistenteCurso(){

    var cmPersonaAsistenteCurso = null;
    var storePersonaAsistenteCurso=null;
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     * cgg_res_persona.
     */
    cmPersonaAsistenteCurso =new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'No. documento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_PATERNO',
        header:'Apellido paterno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_MATERNO',
        header:'Apellido materno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha nacimiento',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CRPER_LUGAR_NACIMIENTO',
        header:'Lugar nacimiento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NUMERO_RESIDENCIA',
        header:'Numero residencia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'TIPO_RESIDENCIA',
        header:'Tipo residencia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_AUSPICIANTE',
        header:'Auspiciante',
        width:150,
        sortable:true
    }
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un
     * campo especifico.
     */
    storePersonaAsistenteCurso=new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAistentePage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRDID_TIPO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_LUGAR_NACIMIENTO'
        },

        {
            name:'CRPER_NUMERO_RESIDENCIA'
        },

        {
            name:'TIPO_RESIDENCIA'
        },

        {
            name:'CRPER_AUSPICIANTE'
        },{
            name:'CODIGO'
        }

        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    this.getCm = function(){
        return cmPersonaAsistenteCurso;
    }

    this.getStore = function(){
        return storePersonaAsistenteCurso;
    }
}

PersonaAsistenteCurso.prototype.getColumnModel=function(){
    return this.getCm();
}

PersonaAsistenteCurso.prototype.getStore=function(){
    return this.getStore();
}

function Cgg_res_sesion_comite(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     * cgg_res_sesion_comite.
     */
    var cmCgg_res_sesion_comite= null;
    var gsCgg_res_sesion_comite= null;

    cmCgg_res_sesion_comite = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRSSC_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'CISLA_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'ISLA',
        header:'Isla',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRCOM_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'COMITE',
        header:'Comite',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRSSC_FECHA_REUNION',
        header:'Fecha reuni\u00f3n',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRSSC_FECHA_FINALIZACION',
        header:'Fecha finalizaci\u00f3n',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRSSC_NUMERO_SESION',
        header:'Numero sesi\u00f3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRSSC_EXTRACTO',
        header:'Extracto',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRSSC_OBSERVACION',
        header:'Observaci\u00f3n',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRSSC_FECHA_CONVOCATORIA',
        header:'Fecha convocatoria',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRSSC_MOTIVO_CONVOCATORIA',
        header:'Motivo convocatoria',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRSSC_DESCRIPCION_ADJUNTO',
        header:'Descripcion adjunto',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRSSC_NOMBRE_ADJUNTO',
        header:'Nombre adjunto',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRSSC_ESTADO_CONVOCATORIA',
        header:'Estado convocatoria',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_sesion_comite por
     * un campo especifico.
     */

    gsCgg_res_sesion_comite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_comite",
            method:"selectPageAprobada",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSSC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRSSC_CODIGO'
        },

        {
            name:'CISLA_CODIGO'
        },

        {
            name:'ISLA'
        },

        {
            name:'CRCOM_CODIGO'
        },

        {
            name:'COMITE'
        },

        {
            name:'CRSSC_FECHA_REUNION'
        },

        {
            name:'CRSSC_FECHA_FINALIZACION'
        },

        {
            name:'CRSSC_NUMERO_SESION'
        },

        {
            name:'CRSSC_EXTRACTO'
        },

        {
            name:'CRSSC_OBSERVACION'
        },

        {
            name:'CRSSC_FECHA_CONVOCATORIA'
        },

        {
            name:'CRSSC_MOTIVO_CONVOCATORIA'
        },

        {
            name:'CRSSC_DESCRIPCION_ADJUNTO'
        },

        {
            name:'CRSSC_NOMBRE_ADJUNTO'
        },

        {
            name:'CRSSC_ESTADO_CONVOCATORIA'
        }
        ]),
        sortInfo:{
            field: 'CRSSC_NUMERO_SESION',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }

    });
    this.getStore=function(){
        return gsCgg_res_sesion_comite;
    }
    this.getColumnModel =function(){
        return cmCgg_res_sesion_comite;
    }
}
Cgg_res_sesion_comite.prototype.getColumnModel=function(){
    return this.getColumnModel();
}

Cgg_res_sesion_comite.prototype.getStore=function(){
    return this.getStore();
}
/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comite.
 */
function Cgg_res_comite(){
    var cmCgg_res_comite = null;
    var gsCgg_res_comite = null

    cmCgg_res_comite = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRCOM_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRCOM_NOMBRE',
        header:'Nombre',
        width:580,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_res_comite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_comite",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRCOM_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRCOM_CODIGO'
        },

        {
            name:'CRCOM_NOMBRE'
        }
        ]),
        sortInfo:{
            field: 'CRCOM_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    this.getStoreComite=function(){
        return gsCgg_res_comite;
    }
    this.getColumnModelComite =function(){
        return cmCgg_res_comite;
    }
}
Cgg_res_comite.prototype.getColumnModel=function(){
    return this.getColumnModelComite();
}

Cgg_res_comite.prototype.getStore=function(){
    return this.getStoreComite();
}
/**
 *Tipo_Documento. Crea un funcion prototipada de tipo documento para extraccion de informacion tipo de documento
 */
function Nacionalidad(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     * cgg_tipo_documento.
     */
    var gsCgg_nacionalidad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_nacionalidad",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CGNCN_CODIGO'
            },

            {
                name:'CGNCN_NACIONALIDAD'
            }
            ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    gsCgg_nacionalidad.reload();
    this.getStore=function(){
        return gsCgg_nacionalidad;
    }
}
Nacionalidad.prototype.getStore=function(){
    return this.getStore();
}
/**
 *Tipo_Documento. Crea un funcion prototipada de tipo documento para extraccion de informacion tipo de documento
 */
function Especie_Kardex(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     * cgg_tipo_documento.
     */
    var gsCgg_kdx_especie = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_especie",
            method:"selectTipoEspecieTCT",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CKESP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CKESP_CODIGO'
        },

        {
            name:'CKESP_NOMBRE'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    gsCgg_kdx_especie.reload();
    this.getStore=function(){
        return gsCgg_kdx_especie;
    }
}
Especie_Kardex.prototype.getStore=function(){
    return this.getStore();
}

/**
 * Ext.data.Store Almacenamiento global de registro de parametros de configuracion.
 */
var SCGG_CONFIGURACION = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_configuracion",
        method:"selectAll"
    }),
    reader:new Ext.data.JsonReader({
        },[
        {
            name:'CGCNF_CODIGO'
        },

        {
            name:'CGCNF_CONFIGURACION'
        },

        {
            name:'CGCNF_VALOR_CADENA'
        },

        {
            name:'CGCNF_VALOR_NUMERICO'
        }
        ]),
    baseParams:{
        format:"JSON"
    },
    listeners:{
        load:function(inStore, inRecords, inOptions){
            TypeResidencia.PERMANENTE = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','03')).get('CGCNF_VALOR_CADENA');
            TypeResidencia.TEMPORAL = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','04')).get('CGCNF_VALOR_CADENA');
            TypeResidencia.TRANSEUNTE = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','05')).get('CGCNF_VALOR_CADENA');
            TypeResidencia.TURISTA = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','06')).get('CGCNF_VALOR_CADENA');
        }
    }
});

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comite.
 */
function Cgg_res_miembro_usuario(){
    var cmCgg_res_miembro_usuario = null;
    var gsCgg_res_miembro_usuario = null

    cmCgg_res_miembro_usuario = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CUSU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CUSU_EMPRESA',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRDID_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Nombre Usuario',
        width:150,
        sortable:true
    },

    {
        dataIndex:'DOCUMENTO',
        header:'Tipo Documento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'Num. Documento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombre',
        width:150,
        sortable:true
    },

    {
        dataIndex:'APELLIDO',
        header:'Apellido',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha Nacimiento',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CPRR_CODIGO',
        header:'Nombre',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'PARROQUIA',
        header:'Parroquia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CCTN_CODIGO',
        header:'Nombre',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CANTON',
        header:'Canton',
        width:150,
        sortable:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_res_miembro_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_miembro_comite",
            method:"selectUsuarioMiembro",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        },

        {
            name:'CUSU_EMPRESA'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'DOCUMENTO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'APELLIDO'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CPRR_CODIGO'
        },

        {
            name:'PARROQUIA'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CANTON'
        }
        ]),
        sortInfo:{
            field: 'CRPER_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    this.getStoreMiembroUsuario=function(){
        return gsCgg_res_miembro_usuario;
    }
    this.getColumnMiembroUsuario =function(){
        return cmCgg_res_miembro_usuario;
    }
}
Cgg_res_miembro_usuario.prototype.getColumnModel=function(){
    return this.getColumnMiembroUsuario();
}

Cgg_res_miembro_usuario.prototype.getStore=function(){
    return this.getStoreMiembroUsuario();
}

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_res_regla_validacion_lite.
 */
function Cgg_res_regla_validacion_lite(){
    var cmCgg_res_regla_validacion_lite = null;
    var gsCgg_res_regla_validacion_lite = null

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_res_regla_validacion_lite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_regla_validacion",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRVAL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRVAL_CODIGO'
        },

        {
            name:'CRVAL_NOMBRE'
        },

        {
            name:'CRVAL_DESCRIPCION'
        },

        {
            name:'CRVAL_FUNCION_VALIDACION'
        },

        {
            name:'CRVAL_FUNCION_PLSQL_PARAMETROS'
        }
        ]),
        sortInfo:{
            field: 'CRVAL_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:'',
            format:TypeFormat.JSON
        }
    });
	
    gsCgg_res_regla_validacion_lite.baseParams.start = 0;
    gsCgg_res_regla_validacion_lite.baseParams.limit = RECORD_PAGE;
	
    cmCgg_res_regla_validacion_lite = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRVAL_NOMBRE',
        header:'Nombre',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRVAL_DESCRIPCION',
        header:'Descripci\u00f3n',
        width:250,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRVAL_FUNCION_VALIDACION',
        header:'Funci\u00f3n validaci\u00f3',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRVAL_FUNCION_PLSQL_PARAMETROS',
        header:'Parametros',
        width:150,
        sortable:true,
        hidden:true
    }
    ]);
    this.getStoreCgg_res_regla_validacion_lite=function(){
        return gsCgg_res_regla_validacion_lite;
    }
    this.getColumnCgg_res_regla_validacion_lite =function(){
        return cmCgg_res_regla_validacion_lite;
    }
}
Cgg_res_regla_validacion_lite.prototype.getColumnModel=function(){
    return this.getColumnCgg_res_regla_validacion_lite();
}

Cgg_res_regla_validacion_lite.prototype.getStore=function(){
    return this.getStoreCgg_res_regla_validacion_lite();
}

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_transferencia_disponible.
 */
function Cgg_kdx_transferencia_disponible(inCkpvt_codigo){
    var cmCgg_kdx_transferencia_disponible = null;
    var gsCgg_kdx_transferencia_disponible = null

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_transferencia_pv.
     */
    cmCgg_kdx_transferencia_disponible = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKTRN_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKPVT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKPVT_NOMBRE',
        header:'Punto de Venta',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKESP_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKESP_NOMBRE',
        header:'Especie',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKTRN_NUMERO_TRANSFERENCIA',
        header:'Numero transferencia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKTRN_FECHA_RECEPCION',
        header:'Fecha recepci\u00f3n',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CKTRN_CANTIDAD',
        header:'Cantidad',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKTRN_PRECIO_UNITARIO',
        header:'Precio unitario',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKTRN_CANTIDAD_DISPONIBLE',
        header:'Cantidad Disponible',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKTRN_SERIE_INICIO',
        header:'Serie inicio',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKTRN_SERIE_FIN',
        header:'Serie fin',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_transferencia_pv por un campo especifico.
     */
    gsCgg_kdx_transferencia_disponible = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_transferencia",
            method:"selectPageDisponiblePV",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKTRN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CKTRN_CODIGO'
        },

        {
            name:'CKPVT_CODIGO'
        },

        {
            name:'CKPVT_NOMBRE'
        },

        {
            name:'CKESP_CODIGO'
        },

        {
            name:'CKESP_NOMBRE'
        },

        {
            name:'CKTRN_NUMERO_TRANSFERENCIA'
        },

        {
            name:'CKTRN_FECHA_RECEPCION'
        },

        {
            name:'CKTRN_CANTIDAD'
        },

        {
            name:'CKTRN_PRECIO_UNITARIO'
        },

        {
            name:'CKTRN_CANTIDAD_DISPONIBLE'
        },

        {
            name:'CKTRN_SERIE_INICIO'
        },

        {
            name:'CKTRN_SERIE_FIN'
        }
        ]),
        sortInfo:{
            field: 'CKTRN_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:'JSON',
            inCkpvt_codigo:inCkpvt_codigo
        }
    });
    this.getStoreTransferenciaDisponible=function(){
        return gsCgg_kdx_transferencia_disponible;
    }
    this.getColumnTransferenciaDisponible =function(){
        return cmCgg_kdx_transferencia_disponible;
    }
}
Cgg_kdx_transferencia_disponible.prototype.getColumnModel=function(){
    return this.getColumnTransferenciaDisponible();
}

Cgg_kdx_transferencia_disponible.prototype.getStore=function(){
    return this.getStoreTransferenciaDisponible();
}


/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_transferencia_disponible.
 */
function Cgg_kdx_usuario_pv(inCkpvt_codigo){
    var cmCgg_kdx_usuario_pv = null;
    var gsCgg_kdx_usuario_pv = null

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_usuario_pv.
     */
    cmCgg_kdx_usuario_pv = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKUPV_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKPVT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CUSU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Identificaci\u00f3n',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombre',
        width:150,
        sortable:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_usuario_pv por un campo especifico.
     */
    gsCgg_kdx_usuario_pv = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_usuario_pv",
            method:"selectUsuarioPuntoVenta",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CKUPV_CODIGO'
            },

            {
                name:'CKPVT_CODIGO'
            },

            {
                name:'CUSU_CODIGO'
            },

            {
                name:'CKPVT_ACTIVO'
            },

            {
                name:'CUSU_NOMBRE_USUARIO'
            },

            {
                name:'CRPER_NOMBRES'
            }
            ]),
        //sortInfo:{field: 'CKPVT_CODIGO', direction: 'ASC'},
        baseParams:{
            inCkpvt_codigo:inCkpvt_codigo?inCkpvt_codigo:'',
            format:TypeFormat.JSON
        }
    });
    this.getStoreUsuarioPV=function(){
        return gsCgg_kdx_usuario_pv;
    }
    this.getColumnUsuarioPV =function(){
        return cmCgg_kdx_usuario_pv;
    }
}
Cgg_kdx_usuario_pv.prototype.getColumnModel=function(){
    return this.getColumnUsuarioPV();
}

Cgg_kdx_usuario_pv.prototype.getStore=function(){
    return this.getStoreUsuarioPV();
}

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_asignacion_usuario_recibe.
 */
function Cgg_kdx_asignacion_usuario(inCgg_Ckupv_codigo){
    var cmCgg_kdx_asignacion_usuario = null;
    var gsCgg_kdx_asignacion_usuario = null

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_asignacion.
     */
    cmCgg_kdx_asignacion_usuario = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKASG_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKTRN_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKASG_NUMERO_ASIGNACION',
        header:'No. asignacion',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKESP_NOMBRE',
        header:'Especie',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKUPV_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRPER_NOMBRES_USUARIO_ENTREGA',
        header:'Usuario entrega',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CGG_CKUPV_CODIGO',
        header:'Ckupv codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRPER_NOMBRES_USUARIO_RECIBE',
        header:'Usuario recibe',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CGG_CKASG_CODIGO',
        header:'Ckasg codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKASG_FECHA_RECEPCION',
        header:'Fecha recepcion',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CKASG_CANTIDAD',
        header:'Cantidad',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKASG_PRECIO_UNITARIO',
        header:'Precio unitario',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKASG_SERIE_INICIO',
        header:'Serie inicio',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKASG_SERIE_FIN',
        header:'Serie fin',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKASG_CANTIDAD_DISPONIBLE',
        header:'Cantidad disponible',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_asignacion por un campo especifico.
     */
    gsCgg_kdx_asignacion_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_asignacion",
            method:"selectPageUsuarioRecibePV",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKASG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CKASG_CODIGO'
        },

        {
            name:'CKTRN_CODIGO'
        },

        {
            name:'CKESP_NOMBRE'
        },

        {
            name:'CKUPV_CODIGO'
        },

        {
            name:'CRPER_NOMBRES_USUARIO_ENTREGA'
        },

        {
            name:'CGG_CKUPV_CODIGO'
        },

        {
            name:'CRPER_NOMBRES_USUARIO_RECIBE'
        },

        {
            name:'CGG_CKASG_CODIGO'
        },

        {
            name:'CKASG_NUMERO_ASIGNACION'
        },

        {
            name:'CKASG_FECHA_RECEPCION'
        },

        {
            name:'CKASG_CANTIDAD'
        },

        {
            name:'CKASG_PRECIO_UNITARIO'
        },

        {
            name:'CKASG_SERIE_INICIO'
        },

        {
            name:'CKASG_SERIE_FIN'
        },

        {
            name:'CKASG_CANTIDAD_DISPONIBLE'
        }
        ]),
        sortInfo:{
            field: 'CKASG_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:'JSON',
            inCgg_Ckupv_codigo:inCgg_Ckupv_codigo
        }
    });

    this.getStoreAsignacionUsuario=function(){
        return gsCgg_kdx_asignacion_usuario;
    }
    this.getColumnAsignacionUsuario =function(){
        return cmCgg_kdx_asignacion_usuario;
    }
}
Cgg_kdx_asignacion_usuario.prototype.getColumnModel=function(){
    return this.getColumnAsignacionUsuario();
}

Cgg_kdx_asignacion_usuario.prototype.getStore=function(){
    return this.getStoreAsignacionUsuario();
}

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_transferencia_disponible.
 */
function Cgg_kdx_Venta_estado(inCkvnt_estado_venta){
    var cmCgg_kdx_venta_estado = null;
    var gsCgg_kdx_venta_estado = null

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta.
     */
    cmCgg_kdx_venta_estado = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKVNT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKASG_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKVNT_LOTE',
        header:'Lote',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKVNT_NUMERO_VENTA',
        header:'Numero venta',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKESP_NOMBRE',
        header:'Lote',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKVNT_FECHA_INGRESO',
        header:'Fecha ingreso',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CKVNT_SERIE_INICIO',
        header:'Serie inicio',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKVNT_SERIE_FIN',
        header:'Serie fin',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKVNT_CANTIDAD',
        header:'Cantidad',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKVNT_TOTAL',
        header:'Total',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CKVNT_ESTADO_VENTA',
        header:'Estado venta',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CKPVT_NOMBRE',
        header:'Punto venta',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Usuario',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta por un campo especifico.
     */
    gsCgg_kdx_venta_estado = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta",
            method:"selectPageByEstado",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKVNT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CKVNT_CODIGO'
        },

        {
            name:'CKASG_CODIGO'
        },
        {
            name:'CKESP_NOMBRE'
        },
        {
            name:'CKVNT_LOTE'
        },

        {
            name:'CKVNT_FECHA_INGRESO'
        },

        {
            name:'CKVNT_NUMERO_VENTA'
        },

        {
            name:'CKVNT_SERIE_INICIO'
        },

        {
            name:'CKVNT_SERIE_FIN'
        },

        {
            name:'CKVNT_CANTIDAD'
        },
        {
            name :'CKASG_PRECIO_UNITARIO'
        }
        ,
        {
            name:'CKVNT_TOTAL'
        },

        {
            name:'CKVNT_ESTADO_VENTA'
        },

        {
            name:'CKPVT_NOMBRE'
        },

        {
            name:'CRPER_NOMBRES'
        }
        ]),
        sortInfo:{
            field: 'CKASG_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:'',
            format:TypeFormat.JSON,
            inCkvnt_estado_venta:inCkvnt_estado_venta
        }
    });
    this.getStoreVenta_estado=function(){
        return gsCgg_kdx_venta_estado;
    }
    this.getColumnVenta_estado =function(){
        return cmCgg_kdx_venta_estado;
    }
}

Cgg_kdx_Venta_estado.prototype.getColumnModel=function(){
    return this.getColumnVenta_estado();
}

Cgg_kdx_Venta_estado.prototype.getStore=function(){
    return this.getStoreVenta_estado();
}
/**
     *Persona. Crea un funcion prototipada de persona para extraccion de informacion de personal.
     */
function PersonaResidentePermanente(){

    var cmPersonaResidentePermanente = null;
    var storePersonaResidentePermanente=null;
    /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
         * cgg_res_persona.
         */
    cmPersonaResidentePermanente =new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'No. documento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_PATERNO',
        header:'Apellido paterno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_MATERNO',
        header:'Apellido materno',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha nacimiento',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CRPER_LUGAR_NACIMIENTO',
        header:'Lugar nacimiento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_NUMERO_RESIDENCIA',
        header:'Numero residencia',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_AUTORIZADO',
        header:'Autorizado',
        width:150,
        sortable:true
    }
    ]);

    /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un
         * campo especifico.
         */
    storePersonaResidentePermanente=new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_beca",
            method:"selectBecaPersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRDID_TIPO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_LUGAR_NACIMIENTO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRPER_NUMERO_RESIDENCIA'
        },

        {
            name:'CRPER_AUTORIZADO'
        },

        {
            name:'CODIGO'
        },

        {
            name:'NUM_REGISTROS'
        }
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    this.getCm = function(){
        return cmPersonaResidentePermanente;
    }

    this.getStore = function(){
        return storePersonaResidentePermanente;
    }
}

PersonaResidentePermanente.prototype.getColumnModel=function(){
    return this.getCm();
}

PersonaResidentePermanente.prototype.getStore=function(){
    return this.getStore();
}
/**
 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_pj_isla por un campo especifico.
 */
var storeCgg_gem_pj_isla = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_gem_pj_isla",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CPJIS_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CPJIS_CODIGO'
    },

    {
        name:'CRPJR_CODIGO'
    },

    {
        name:'CISLA_CODIGO'
    }
    ]),
    sortInfo:{
        field: 'CRPJR_CODIGO',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});

/**
 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_cargo por un campo especifico.
 */
function Cgg_gem_cargo_data(){
    this.columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CGARE_NOMBRE',
        header:'Area',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CGCRG_NOMBRE',
        header:'Cargo',
        width:250,
        sortable:true
    },

    {
        dataIndex:'CGCRG_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:300,
        sortable:true,
        hidden:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_cargo por un campo especifico.
     */
    this.store = new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_cargo",
            method: "selectPageDirect"
        }),
        groupField:'CGARE_NOMBRE',
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGCRG_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name: 'CGCRG_CODIGO'
        },

        {
            name: 'CGARE_CODIGO'
        },

        {
            name: 'CGARE_NOMBRE'
        },

        {
            name: 'CGCRG_NOMBRE'
        },

        {
            name: 'CGCRG_DESCRIPCION'
        }
        ]),
        sortInfo: {
            field: 'CGCRG_NOMBRE',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: "JSON"
        }
    });   
}

function Cgg_gem_area_funcional_data(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_area_funcional.
     */
    this.columnModel = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CGARE_NOMBRE',
            header:'Nombre',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CGARE_DESCRIPCION',
            header:'Descripci\u00f3n',
            width:400,
            sortable:true
        }
        ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_area_funcional por un campo especifico.
     */
    this.store = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_area_funcional",
            method: "selectPage",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGARE_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
        {
            name:'CGARE_CODIGO'
        },

        {
            name:'CGARE_NOMBRE'
        },

        {
            name:'CGARE_DESCRIPCION'
        }
        ]),
        sortInfo: {
            field: 'CGARE_NOMBRE',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON'
        }
    });
}
/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comite.
 */
function Cgg_jur_acuerdo(){
    var cmCgg_jur_acuerdo = null;
    var gsCgg_jur_acuerdo = null

    cmCgg_jur_acuerdo = new Ext.grid.ColumnModel([
    {
        dataIndex:'CJACU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRPJR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CJACU_NUMERO',
        header:'Numero',
        width:150,
        sortable:true
    },


    {
        dataIndex:'RAZON_SOCIAL',
        header:'Raz\u00f3n Social',
        width:200,
        sortable:true,
        renderer:
        function(value,metadata,record)
        {
            if (value.length >0)
            {
                return value;
            }
            else
            {
                return record.get('PERSONA');
            }

        }
    },
    {
        dataIndex:'PERSONA',
        header:'Tipo',
        width:50,
        sortable:true,
        renderer:
        function(value,metaData,record)
        {
            if (record.data.PERSONA) {
                metaData.css = 'iconPersonaNatural';

            }
            else
            {

                metaData.css = 'iconPersonaJuridica';

            }
            return '';
        }
    },



    {
        dataIndex:'CRPER_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },


    {
        dataIndex:'CJTPR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'NOMBRE_PROCESO',
        header:'Nombre Proceso',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJACU_ANIO',
        header:'Anio',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CJACU_COSTO',
        header:'Costo',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJACU_OBJETO',
        header:'Objeto',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJACU_FECHA_SUSCRIPCION',
        header:'Fecha suscripcion',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CJACU_FECHA_INICIO',
        header:'Fecha inicio',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'RESPONSABLE',
        header:'Responsable',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJACU_ESTADO_EJECUCION',
        header:'Estado ejecucion',
        width:150,
        sortable:true,
        renderer:function(inCjacu_estado_ejecucion) {
            var result = "";
            switch (inCjacu_estado_ejecucion) {
                case 0:
                    result = 'PLANTEADO';
                    break;
                case 1:
                    result = 'EN PROCESO';
                    break;
                case 2:
                    result = 'FINALIZADO';
                    break;
                case 3:
                    result = 'SUSPENDIDO';
                    break;

                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    },
    {
        dataIndex:'CJACU_FECHA_FINALIZACION',
        header:'Fecha finalizacion',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CJACU_TIPO',
        header:'Tipo',
        width:150,
        sortable:true,
        renderer:function(inCjacu_tipo) {
            var result = "";
            switch (inCjacu_tipo) {
                case 0:
                    result = 'CONVENIO';
                    break;
                case 1:
                    result = 'CONTRATO';
                    break;
                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    },

    {
        dataIndex:'CJACU_TIPO_PERSONA',
        header:'Tipo persona',
        width:150,
        sortable:true,
        renderer:function(inCjacu_tipo_adversario) {
            var result = "";
            switch (inCjacu_tipo_adversario) {
                case 0:
                    result = 'PERSONA NATURAL';
                    break;
                case 1:
                    result = 'PERSONA JURIDICA';
                    break;
                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_jur_acuerdo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_acuerdo",
            method:"selectPageAcuerdo",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CJACU_CODIGO'
        },

        {
            name:'CRPJR_CODIGO'
        },

        {
            name:'RAZON_SOCIAL'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'PERSONA'
        },

        {
            name:'CJTPR_CODIGO'
        },

        {
            name:'NOMBRE_PROCESO'
        },

        {
            name:'CJACU_ANIO'
        },

        {
            name:'CJACU_COSTO'
        },

        {
            name:'CJACU_NUMERO'
        },

        {
            name:'CJACU_OBJETO'
        },

        {
            name:'CJACU_FECHA_SUSCRIPCION'
        },

        {
            name:'CJACU_FECHA_INICIO'
        },

        {
            name:'RESPONSABLE'
        },

        {
            name:'CJACU_ESTADO_EJECUCION'
        },

        {
            name:'CJACU_FECHA_FINALIZACION'
        },

        {
            name:'CJACU_TIPO'
        },

        {
            name:'CJACU_TIPO_PERSONA'
        },
        {
            name:'PAGOS'
        }
        ]),
        sortInfo:{
            field: 'CRPER_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });

    this.getStoreAcuerdo=function(){
        return gsCgg_jur_acuerdo;
    }
    this.getColumnAcuerdo =function(){
        return cmCgg_jur_acuerdo;
    }
}
Cgg_jur_acuerdo.prototype.getColumnModel=function(){
    return this.getColumnAcuerdo();
}

Cgg_jur_acuerdo.prototype.getStore=function(){
    return this.getStoreAcuerdo();
}

/**
 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_comite.
 */
function Cgg_jur_proceso_judicial(){
    var cmCgg_jur_proceso_judicial = null;
    var gsCgg_jur_proceso_judicial = null

    cmCgg_jur_proceso_judicial = new Ext.grid.ColumnModel([
    {
        dataIndex:'CJPJU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CCTN_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CANTON',
        header:'Canton',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPJR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'RAZON_SOCIAL',
        header:'Razon Social',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'PERSONA',
        header:'Persona',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJPJU_NUMERO',
        header:'Numero',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJPJU_TIPO_PROCESO',
        header:'Tipo proceso',
        width:150,
        sortable:true,
        renderer:function(inCjpju_tipo_proceso) {
            var result = "";
            switch (inCjpju_tipo_proceso) {
                case 0:
                    result = 'DEMANDA PLANTEADA';
                    break;
                case 1:
                    result = 'DEMANDA RECIBIDA';
                    break;
                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    },
    {
        dataIndex:'CJPJU_TIPO_ADVERSARIO',
        header:'Tipo adversario',
        width:150,
        sortable:true,
        renderer:function(inCjpju_tipo_adversario) {
            var result = "";
            switch (inCjpju_tipo_adversario) {
                case 0:
                    result = 'PERSONA NATURAL';
                    break;
                case 1:
                    result = 'PERSONA JURIDICA';
                    break;
                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    },
    {
        dataIndex:'CJPJU_FECHA_INICIO',
        header:'Fecha inicio',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CJPJU_FECHA_FINALIZACION',
        header:'Fecha finalizacion',
        width:150,
        sortable:true,
        renderer:truncDate
    },

    {
        dataIndex:'CJPJU_ESTADO_EJECUCION',
        header:'Estado ejecucion',
        width:150,
        sortable:true,
        renderer:function(inCjpj_estado_ejecucion) {
            var result = "";
            switch (inCjpj_estado_ejecucion) {
                case 0:
                    result = 'PLANTEADO';
                    break;
                case 1:
                    result = 'EN PROCESO';
                    break;
                case 2:
                    result = 'FINALIZADO';
                    break;
                case 3:
                    result = 'SUSPENDIDO';
                    break;

                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;

        }
    }
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_comite por un campo especifico.
     */
    gsCgg_jur_proceso_judicial= new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_proceso_judicial",
            method:"selectPageProceso",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CJPJU_CODIGO'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CANTON'
        },

        {
            name:'CRPJR_CODIGO'
        },

        {
            name:'RAZON_SOCIAL'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'PERSONA'
        },

        {
            name:'CJPJU_NUMERO'
        },

        {
            name:'CJPJU_TIPO_PROCESO'
        },

        {
            name:'CJPJU_TIPO_ADVERSARIO'
        },

        {
            name:'CJPJU_FECHA_INICIO'
        },

        {
            name:'CJPJU_FECHA_FINALIZACION'
        },

        {
            name:'CJPJU_ESTADO_EJECUCION'
        }

        ]),
        sortInfo:{
            field: 'CJPJU_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    this.getStoreProcesoJudicial=function(){
        return gsCgg_jur_proceso_judicial;
    }
    this.getColumnProcesoJudicial =function(){
        return cmCgg_jur_proceso_judicial;
    }
}
Cgg_jur_acuerdo.prototype.getColumnModel=function(){
    return this.getColumnProcesoJudicial();
}

Cgg_jur_acuerdo.prototype.getStore=function(){
    return this.getStoreProcesoJudicial();
}

/**
 *Tipo_Documento. Crea un funcion prototipada de tipo documento para extraccion de informacion tipo de documento
 */
function Residencia(){
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto
     */
    var gsCgg_residencia = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_pais",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CPAIS_CODIGO'
            },

            {
                name:'CPAIS_NOMBRE'
            },

            {
                name:'CPAIS_DESCRIPCION'
            }
            ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    this.getStore=function(){
        return gsCgg_residencia;
    }
}
Residencia.prototype.getStore=function(){
    return this.getStore();
}

function Cgg_usuario(){
    var cmCgg_usuario= null;
    var sCgg_usuario= null

    var chkUsuarioInterno = new Ext.grid.CheckColumn(
    {
        dataIndex:'CUSU_USUARIO_INTERNO',
        header:'Usuario interno',
        width:150,
        sortable:true
    }
    );
    var chkCaducaClave = new Ext.grid.CheckColumn(
    {
        dataIndex:'CUSU_CADUCA_CLAVE',
        header:'Caduca clave',
        width:150,
        sortable:true
    }
    );
    var chkCusu_activo = new Ext.grid.CheckColumn(
    {
        dataIndex:'CUSU_ACTIVO',
        header:'Activo',
        width:150,
        sortable:true
    }
    );

    cmCgg_usuario = new Ext.grid.ColumnModel([
    {
        dataIndex:'CUSU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },

    {
        dataIndex:'NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true
    },

    {
        dataIndex:'APELLIDOS',
        header:'Apellidos',
        width:150,
        sortable:true
    },

    {
        dataIndex:'EMPRESA',
        header:'Empresa',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Nombre usuario',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CUSU_CLAVE_ACCESO',
        header:'Clave acceso',
        width:150,
        sortable:true,
        hideable:false,
        hidden:true
    },
    chkUsuarioInterno, chkCaducaClave,
    chkCusu_activo
    ]);
    /**Ext.data.Store Agrupacion de registros
	 *
	 */
    sCgg_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_usuario",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CRCRG_CODIGO'
        },

        {
            name:'CRCRG_NOMBRE'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPJR_CODIGO'
        },

        {
            name:'CRPJR_RAZON_SOCIAL'
        },

        {
            name:'CTAGV_CODIGO'
        },

        {
            name:'CTAGV_NOMBRE'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CCTN_NOMBRE'
        },

        {
            name:'NOMBRES'
        },

        {
            name:'APELLIDOS'
        },

        {
            name:'EMPRESA'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        },

        {
            name:'CUSU_CLAVE_ACCESO'
        },

        {
            name:'CUSU_USUARIO_INTERNO'
        },

        {
            name:'CUSU_CADUCA_CLAVE'
        },

        {
            name:'CUSU_ACTIVO'
        },

        {
            name:'CUSU_CAMBIAR_CLAVE'
        },

        {
            name:'VIGENCIA'
        },

        {
            name:'TRANSCURRIDO'
        },

        {
            name:'CISLA_CODIGO'
        },

        {
            name:'CISLA_NOMBRE'
        }
        ]),
        sortInfo:{
            field: 'CUSU_NOMBRE_USUARIO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCusu_usuario_interno:'1',
            inCrper_codigo:''
        }
    });

    this.getStore=function(){
        return sCgg_usuario;
    }
    this.getColumnModel =function(){
        return cmCgg_usuario;
    }
}

Cgg_usuario.prototype.getColumnModel=function(){
    return this.getColumnModel();
}

Cgg_usuario.prototype.getStore=function(){
    return this.getStore();
}

/**
 *Funcion prototypada que contiene informacion de la definicion estructural de la tabla Cgg_res_tramite.
 */
function Cgg_res_tramite(){

    var cbcCRTRA_ATENCION_CLIENTE =  new Ext.grid.CheckColumn({
        dataIndex:'CRTRA_ATENCION_CLIENTE',
        header:'Preregistro',
        width:80,
        sortable:true
    });

    var cbcCRTRA_GRUPO =  new Ext.grid.CheckColumn({
        dataIndex:'CRTRA_GRUPO',
        header:'Grupal',
        width:80,
        sortable:true
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tramite.
     */
    var cmCgg_res_tramite = new Ext.grid.ColumnModel([{
        dataIndex:'CRTRA_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTRA_ANIO',
        header:'A\u00F1o',
        width:80,
        sortable:true
    },
    {
        dataIndex:'CRTRA_NUMERO',
        header:'Tr\u00E1mite',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRPER_TAUSPICIANTE',
        header:'Auspiciante',
        width:210,
        sortable:true
    },
    {
        dataIndex:'CRPJR_NOMBRES',
        header:'Persona jur\u00EDdica',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_TBENEFICIARIO',
        header:'Beneficiario',
        width:210,
        sortable:true
    },
    {
        dataIndex:'CRPRO_CODIGO',
        header:'Proceso',
        width:100,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTST_DESCRIPCION',
        header:'Solicitud',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CVVEH_CODIGO',
        header:'Veh\u00EDculo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRETT_NOMBRE',
        header:'Estado',
        width:80,
        sortable:true
    },
    {
        dataIndex:'CISLA_CODIGO',
        header:'Isla',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CVMTR_CODIGO',
        header:'Motor',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTRA_FECHA_RECEPCION',
        header:'Recepci\u00F3n',
        width:90,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CGCRG_NOMBRE',
        header:'Actividad',
        width:100
    },
    {
        dataIndex:'CRTRA_OBSERVACION',
        header:'Observaciones',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRTRA_DIAS_PERMANENCIA',
        header:'Dias permanencia',
        width:70,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTRA_PENDIENTE',
        header:'Pendiente',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTRA_OBSERVACION_PENDIENTE',
        header:'Observaci\u00F3n pendiente',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },cbcCRTRA_ATENCION_CLIENTE,
    {
        dataIndex:'CRTRA_COMUNICADO_RADIAL',
        header:'Comunicado radial',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRTRA_MOTIVO',
        header:'Motivo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTRA_FECHA_INGRESO',
        header:'Ingreso',
        width:90,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRTRA_FECHA_SALIDA',
        header:'Salida',
        width:90,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRTRA_FOLIO',
        header:'Folios',
        width:80,
        sortable:true
    },cbcCRTRA_GRUPO,{
        dataIndex:'CRTRA_ORDEN',
        header:'Transeunte',
        width:80
    }]);
		
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tramite por un campo especifico.
	  */
    var sCgg_res_tramite = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tramite",
            method:"selectPageDirect1",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
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
            name:'CRETT_NOMBRE'
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
        },

        {
            name:'CGCRG_NOMBRE'
        },

        {
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
        },

        {
            name:'CRTRA_FECHA_INGRESO'
        },

        {
            name:'CRTRA_FECHA_SALIDA'
        },

        {
            name:'CRTRA_FOLIO'
        },

        {
            name:'CRTRA_GRUPO'
        },

        {
            name:'CRTRA_ORDEN'
        }
        ]),
        groupField:'CRTRA_FECHA_RECEPCION',
        sortInfo:{
            field: 'CRTRA_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });

    this.getColumnModel= function(){
        return cmCgg_res_tramite;
    }
	
    this.getStore= function(){
        return sCgg_res_tramite;
    }
}

Cgg_res_tramite.prototype.getColumnModel = function(){
    return this.getColumnModel();
}


/**
 *Funcion prototypada que contiene informacion de la definicion estructural de la tabla Cgg_pais.
 */
function Cgg_pais(){
    /**
     * Ext.data.Store Almacenamiento de informacion de pais.
     */
    var stPAIS = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_pais",
            method:"selectAllJoin"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CPAIS_CODIGO'
        },

        {
            name:'CPAIS_NOMBRE'
        },

        {
            name:'CPAIS_DESCRIPCION'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    this.getStore= function(){
        return stPAIS;
    }
}

/**
 *Funcion prototypada que contiene informacion de la definicion estructural de la tabla Cgg_provincia.
 */
function Cgg_provincia(){
    /**
     * Ext.data.Store Almacenamiento de informacion de la provincia.
     */
    var stPROVINCIA = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_provincia",
            method:"selectAll"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CGPRV_CODIGO'
        },
        {
            name:'CPAIS_CODIGO'
        },
        {
            name:'CGPRV_NOMBRE'
        },
        {
            name:'CGPRV_DESCRIPCION'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
    this.getStore= function(){
        return stPROVINCIA;
    }
}

/**
 *Funcion prototypada que contiene informacion de la definicion estructural de la tabla Cgg_canton.
 */
function Cgg_canton(){
    /**
     * Ext.data.Store Almacenamiento de informacion de canton.
     */
    var stCANTON = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_canton",
            method:"selectAll"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
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
            name:'CCTN_DESCRIPCION'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });

    this.getStore= function(){
        return stCANTON;
    }
}

/**
 *Funcion prototypada que contiene informacion de la definicion estructural de la tabla Cgg_canton.
 */
function FuncionSQL(){

    var cmFuncionSql = new Ext.grid.ColumnModel([
    {
        dataIndex:'PRONAME',
        header:'Funci\u00f3n',
        width:200,
        sortable:true
    },

    {
        dataIndex:'PRONARGS',
        header:'Prm.',
        width:50,
        sortable:true
    },

    {
        dataIndex:'PROARGNAMES',
        header:'Variables',
        width:200,
        sortable:true
    }
    ]);

    /**Ext.data.Store Agrupacion de registros */
    var sFuncionSql= new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_regla_validacion",
            method: "selectFuncionPlSql"
        }),
        remoteSort:true,
        reader: new Ext.data.JsonReader({
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [{
            name: 'PRONAME'
        },

        {
            name: 'PRONARGS'
        },

        {
            name: 'PROARGNAMES'
        },

        {
            name: 'TYPNAME'
        }
        ]),
        sortInfo:{
            field: 'PRONAME',
            direction: 'ASC'
        },
        baseParams: {
            keyword:'',
            format: TypeFormat.JSON
        }
    });

    this.getStore= function(){
        return sFuncionSql;
    }

    this.getColumnModel= function(){
        return cmFuncionSql;
    }
}

FuncionSQL.prototype.getColumnModel= function(){
    return this.getColunModel();
}

FuncionSQL.prototype.getStore = function(){
    return this.getStore();
}


/**
 *Funcion que contiene informacion de la definicion estructural de los candidatos habilitados para gestion de empleo.
 */
function Cgg_gem_candidato_lite(){
    this.columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_APELLIDO_PATERNO',
        header:'Apellido paterno',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRPER_APELLIDO_MATERNO',
        header:'Apellido materno',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'No. identific.',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRPER_NUMERO_RESIDENCIA',
        header:'No residencia',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:200,
        sortable:true
    }
    ]);
	
    /**Ext.data.Store Agrupacion de registros */
    this.store= new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_candidato",
            method: "selectPageLite"
        }),
        remoteSort:true,
        reader: new Ext.data.JsonReader({
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_NUMERO_RESIDENCIA'
        },

        {
            name:'CRPER_GENERO'
        }
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams: {
            keyword:'',
            format: TypeFormat.JSON
        }
    });
}

/**
 *Estructura de datos de usuarios responsable de empresas
 */
function Cgg_usuario_responsable_Empresa(){
    /**
     * Ext.data.Store Almacenamiento de informacion.
     */
    this.store = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_vacante",
            method:"selectUsuarioEmpresa"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        },

        {
            name:'CRPJR_RAZON_SOCIAL'
        },

        {
            name:'CRPJR_ACTIVIDAD'
        },

        {
            name:'CISLA_NOMBRE'
        }
        ]),
        sortInfo:{
            field: 'CRPJR_RAZON_SOCIAL',
            direction: 'asc'
        },
        baseParams:{
            keyword:''
        }
    });
    this.columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Usuario',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPJR_RAZON_SOCIAL',
        header:'Raz\u00F3n social',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CISLA_NOMBRE',
        header:'Isla',
        sortable:true
    },

    {
        dataIndex:'CRPJR_ACTIVIDAD',
        header:'Actividad',
        width:200,
        sortable:true
    }
    ]);
}

function Cgg_preregistro_empresa_data(){
    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_preregistro_empresa.
	*/
    this.columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CGPRE_RAZON_SOCIAL',
        header:'Raz\u00F3n social',
        width:100,
        sortable:true
    },

    {
        dataIndex:'CGPRE_RUC',
        header:'Ruc',
        width:100,
        sortable:true
    },

    {
        dataIndex:'CGPRE_REPRESENTANTE',
        header:'Representante',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CGPRE_FECHA_CREACION',
        header:'Fecha creacion',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CGPRE_ACTIVIDAD',
        header:'Actividad',
        width:120,
        sortable:true
    },

    {
        dataIndex:'CGPRE_DIRECCION',
        header:'Direccion',
        width:120,
        sortable:true
    },

    {
        dataIndex:'CGPRE_SECTOR',
        header:'Sector',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CGPRE_NUMERO_EMPLEADO',
        header:'Numero empleado',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CGPRE_TELEFONO',
        header:'Telefono',
        width:70,
        sortable:true
    },

    {
        dataIndex:'CGPRE_EMAIL',
        header:'Email',
        width:90,
        sortable:true
    },

    {
        dataIndex:'CGPRE_CEDULA',
        header:'Cedula',
        width:150,
        sortable:true,
        hidden:true
    }
    ]);
    /**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_preregistro_empresa por un campo especifico.
	*/
    this.estore = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"/PublicWS/Cgg_gem_preregistro_empresa",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGPRE_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CGPRE_CODIGO'
        },

        {
            name:'CGPRE_RAZON_SOCIAL'
        },

        {
            name:'CGPRE_RUC'
        },

        {
            name:'CGPRE_REPRESENTANTE'
        },

        {
            name:'CGPRE_FECHA_CREACION'
        },

        {
            name:'CGPRE_ACTIVIDAD'
        },

        {
            name:'CGPRE_DIRECCION'
        },

        {
            name:'CGPRE_SECTOR'
        },

        {
            name:'CGPRE_TIPO'
        },

        {
            name:'CGPRE_NUMERO_EMPLEADO'
        },

        {
            name:'CGPRE_TELEFONO'
        },

        {
            name:'CGPRE_EMAIL'
        },

        {
            name:'CGPRE_CEDULA'
        },

        {
            name:'CGPRE_NOMBRE_ADJUNTO'
        },

        {
            name:'CGPRE_CCTN_CODIGO'
        }
        ]),
        sortInfo:{
            field: 'CGPRE_RAZON_SOCIAL',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });
}

function Cgg_punto_venta_usuario(){

    /**
	* Ext.grid.ColumnModel Define el modelo de columnas.
	*/
    var columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKPVT_CODIGO',
        hidden:true
    },

    {
        dataIndex:'CCTN_CODIGO',
        hidden:true
    },

    {
        dataIndex:'CKPVT_NOMBRE',
        header:'Punto venta',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CUSU_CODIGO',
        hidden:true
    },

    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Usuario',
        width:120,
        sortable:true
    }
    ]);
    /**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_preregistro_empresa por un campo especifico.
	*/
    var store = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_punto_venta",
            method:"selectPuntoUsuario"
        }),        
        reader:new Ext.data.JsonReader({},[
        {
            name:'CKPVT_CODIGO'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CKPVT_NOMBRE'
        },

        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        }
        ]),        
        baseParams:{
            keyword:'',
            format:'JSON'
        }
    });

    this.getColumnModel = function(){
        return columnModel;
    }

    this.getStore = function(){
        return store ;
    }
}

Cgg_punto_venta_usuario.prototype.getColumnModel=function(){
    return this.getColumnModel();
}

Cgg_punto_venta_usuario.prototype.getStore=function(){
    return this.getStore();
}


function Cgg_vehiculo_libre(){

    /**
	* Ext.grid.ColumnModel Define el modelo de columnas.
	*/
    var columnModel = new Ext.grid.ColumnModel([
    {
        dataIndex:'CVVEH_CODIGO',
        hidden:true
    },   

    {
        dataIndex:'CVVEH_NOMBRE',
        header:'Nombre',
        width:120,
        sortable:true
    },

    {
        dataIndex:'CVVEH_TIPO',
        hidden:true
    },
    {
        dataIndex:'MARCA',
        header:'Marca',
        width:80,
        sortable:true

    },
    {
        dataIndex:'CVVEH_ANIO_PRODUCCION',
        header:'A\u00f1o',
        width:80,
        sortable:true

    },

    {
        dataIndex:'CVVEH_CHASIS',
        header:'Chasis',
        width:80,
        sortable:true
    },

    {
        dataIndex:'CVVEH_PLACA',
        header:'Placa',
        width:80,
        sortable:true
    },

    {
        dataIndex:'CVVEH_FECHA_INGRESO',
        header:'F. Ingreso',
        width:80,
        sortable:true
    },

    {
        dataIndex:'CVVEH_OBSERVACION',
        header:'Observaci\u00f3n',
        width:80,
        sortable:true
    }
    ]);


    /**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_preregistro_empresa por un campo especifico.
	*/
    var store = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_veh_historial",
            method: "selectVehiculoLibre"
        }),
        reader: new Ext.data.JsonReader({
            id:'CVVEH_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        }, [
        {
            name: 'CVVEH_CODIGO'
        },       
        {
            name: 'CVVEH_NOMBRE'
        },

        {
            name: 'CVVEH_TIPO'
        },

        {
            name: 'CVVEH_ANIO_PRODUCCION'
        },

        {
            name: 'CVVEH_CHASIS'
        },

        {
            name: 'CVVEH_PLACA'
        },

        {
            name: 'CVVEH_FECHA_INGRESO'
        },

        {
            name: 'CVVEH_OBSERVACION'
        },
        {
            name: 'MARCA'
        }
        ]),
        remoteSort:true,
        sortInfo:{
            field: 'CVVEH_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format: TypeFormat.JSON,
            inCvveh_tipo: 0
        }
    });

    this.getColumnModel = function(){
        return columnModel;
    }

    this.getStore = function(){
        return store ;
    }
}

Cgg_vehiculo_libre.prototype.getColumnModel=function(){
    return this.getColumnModel();
}

Cgg_vehiculo_libre.prototype.getStore=function(){
    return this.getStore();
}

/**Ext.data.Store Agrupacion de registros */
var storeReports = new Ext.data.Store({
    proxy: new Ext.ux.bsx.SoapProxy({
        url: URL_WS + "Cgg_sec_reporte",
        method: "selectReportUser"
    }),
    reader: new Ext.data.JsonReader({}, [
    {
        name:'CSRPT_CODIGO'
    },

    {
        name:'CSRPT_REPORTE'
    },

    {
        name:'CSRPT_DESCRIPCION'
    },

    {
        name:'CSRPT_ESTADO'
    }
    ])
});
storeReports.reload();
