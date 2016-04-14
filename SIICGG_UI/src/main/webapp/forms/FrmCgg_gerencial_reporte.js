/**
* Funcion publica. Formulario que permite enlazar los indices del modulo gerencial.
* @constructor
* @base FrmCgg_gerencial_reporte
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gerencial_reporte(inDesktop){
    var optMenu = 'Gerencial/An\u00e1lisis Gerencial';
    var tituloCgg_gerencial='An\u00e1lisis gerencial';
    var descCgg_gerencial='El formulario permite visualizar los indicadores de gestion de toda la infomaci\u00f3on que maneja el Consejo de gobierno de regimen especial Galapagos.';
    var resData=null;
    var vehData = null;
    var gemData = null;
    var dhuData = null;    

    resData =  [
    ['2','Residentes permanentes calificados','Listado de residentes permanentes calificados por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };        
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoResidenteCalificadoPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['3','Residentes temporales calificados','Listado de residentes temporales calificados por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoResidenteTemporalCalificadoPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['4','Transe\u00fantes calificados por la direcci\u00f3n de calificaci\u00f3n y control de residencial','Listado de Transe\u00fantes calificados por la direcci\u00f3n de calificaci\u00f3n y control de residencia por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoTranseunteCalificadoPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['5','Personas en estado irregular devueltas al continente','Listado de personas en estado irregular devueltas al continente por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIrregularDevuelto', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['6','Personas en estado irregular notificadas por periodo.','Listado de personas en estado irregular notificadas por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIrregularNotificado', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['7','Turistas que permanecen m\u00e1s de 90 d\u00edas en Gal\u00e1pagos','Listado de turistas que permanecen m\u00e1s de 90 d\u00edas en Gal\u00e1pagos.',function(){
        var params = [];
        params[0]={
            label:'A\u00f1o',
            paramName:'P_ANIO',
            paramValue:'',
            type:'input',
            required:true
        };
        
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoTuristaMas90dias', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['8','Ingreso de turista nacionales a Gal\u00e1pagos','Listado de ingreso de turista nacionales a Gal\u00e1pagos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoTuristaNacionalGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['9','Salida de turistas nacionales de Gal\u00e1pagos al Ecuador continental','Listado de salida de turistas nacionales de Gal\u00e1pagos al Ecuador continental por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoSalidaTuristaNacionalGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['10','Ingreso de turistas extranjeros a Gal\u00e1pagos.','Listado de ingreso de turistas extranjeros a Gal\u00e1pagos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoTuristaExtranjeroGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['11','Salida de turistas extranjeros de Gal\u00e1pagos al Ecuador continental','Listado de salida de turistas extranjeros de Gal\u00e1pagos al Ecuador continental por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoSalidaTuristaExtranjeroGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['12','Ingreso de residentes permanentes a las islas.','Listado de ingreso de residentes permanentes a las islas por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };        
                
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoResidentePermanenteGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['13','Salida de residentes permanentes al Ecuador continental','Listado de salida de residentes permanentes  al Ecuador continental por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
                
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoSalidaResidentePermanenteGalapagos', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['14','Personas impedidas de ingresar a Gal\u00e1pagos','Listado por mes de personas impedidas de ingresar a Gal\u00e1pagos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoPersonasImpedidas', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['15','Ingreso a Gal\u00e1pagos con TCT de turistas nacional','Listado por mes de ingreso a Gal\u00e1pagos con TCT de turistas nacional por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoTctTuristaNacional', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['16','Ingreso a Gal\u00e1pagos con TCT de turistas extranjero.','Listado por mes de ingreso a Gal\u00e1pagos con TCT de turistas extranjero por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoTctTuristaExtranjero', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['17','Reuniones del comit\u00e9 de calificaci\u00f3n y control de residencia.','Listado de reuniones del comit\u00e9 de calificaci\u00f3n y control de residencia por periodo.',function(){
        var params = [];
        params[0]={
            label:'A\u00f1o inicio',
            paramName:'P_ANIO_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'input'
        };
        params[1]={
            label:'A\u00f1o final',
            paramName:'P_ANIO_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'input'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptReunionesComiteCalificacionResidencia', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['18','Credencializaciones','Listado de credencializaciones por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptCredencializaciones', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['19','Totales de Transe\u00fantes nacionales y extranjeros.','Listado de totales de Transe\u00fantes nacionales y extranjeros por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoIngresoTranseunteNacionalExtranjero', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['20','Ingreso de residente temporal a las islas.','Listado de ingreso de residentes temporales a las islas por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };         
                
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstIngTempGal', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['21','Salida de residente temporal al Ecuador continental','Listado de salida de residentes temporales al Ecuador continental por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
                
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstSalTempGal', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ]
    ];

    /*********VEHICULOS*************/
    vehData =  [
    ['1','Veh\u00edculos terrestres reemplazados','Listado de veh\u00edculos terrestres reemplazados por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };

        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:0,
            value:'Terrestre',
            type:'direct'
        };

        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosReemplazadosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['2','Veh\u00edculos terrestres nuevos autorizados','Listado de veh\u00edculos terrestres nuevos autorizados por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:0,
            value:'Terrestre',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosNuevosAutorizadosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['3','Veh\u00edculos terrestres totales','Listado de veh\u00edculos terrestres totales por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:0,
            value:'Terrestre',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosTotalPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['4','Veh\u00edculos mar\u00edtimos ingresados (nuevos)','Listado de veh\u00edculos mar\u00edtimos ingresados (nuevos) por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:1,
            value:'Maritimos',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosNuevosAutorizadosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['5','Veh\u00edculos mar\u00edtimos remplazados.','Listado de veh\u00edculos mar\u00edtimos remplazados por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:1,
            value:'Maritimo',
            type:'direct'
        };

        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosReemplazadosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['6','Veh\u00edculos mar\u00edtimos totales','Listado de veh\u00edculos mar\u00edtimos totales por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:1,
            value:'Maritimo',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosTotalPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['7','Tramites  negados por el comit\u00e9 de veh\u00edculos','Listado de tramites  negados por el comit\u00e9 de veh\u00edculos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Comite',
            paramName:'P_CRCOM_CODIGO',
            paramValue:'CRCOM2',
            value:'Vehiculos',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoTramitesNegadosComiteVehiculosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['8','Veh\u00edculos terrestres nuevos autorizados(por solicitante)','Listado de veh\u00edculos terrestres nuevos autorizados(por solicitante) por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:0,
            value:'Terrestre',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosAutorizadosSolicitantePeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['9','Veh\u00edculos terrestres nuevos autorizados(por tipo)','Listado de veh\u00edculos terrestres nuevos autorizados(por tipo) por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo',
            paramName:'P_CVVEH_TIPO',
            paramValue:0,
            value:'Terrestre',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoVehiculosNuevosAutorizadosTipoPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['10','Tramites  ingresados al comit\u00e9 de veh\u00edculos','Listado tramites  ingresados al comit\u00e9 de veh\u00edculos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Comite',
            paramName:'P_CRCOM_CODIGO',
            paramValue:'CRCOM2',
            value:'Vehiculos',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoTramitesIngresadosComiteVehiculosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ]
    ];

    gemData = [
    ['1','N\u00famero de empleos ofertados por sector','Estadistica del N\u00famero de empleos ofertados por sector.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Agrupado por',
            paramName:' P_TIPO_BUSQUEDA',
            value:dsFiltroGem,
            paramValue:'',
            type:'combo',
            required:true
        };        
        var reporte = new FrmCriterioReporte('rptEstadisticoNumeroEmpleosOfertadosGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['2','N\u00famero de empleos ofertados por isla','Estadistica del N\u00famero de empleos ofertados por isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date',
            required:true
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date',
            required:true
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Agrupado por',
            paramName:' P_TIPO_BUSQUEDA',
            value:dsFiltroGem,
            paramValue:'',
            type:'combo',
            required:true
        };
        
        var reporte = new FrmCriterioReporte('rptEstadisticoNumeroEmpleosOfertadosGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['3','N\u00famero de empleos ofertados por isla','Estadistico del N\u00famero de empleos ofertados por sector e isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:0,
            value:'Isla',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoNumeroEmpleosOfertadosGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['4','N\u00famero de empleos ofertados por sector e isla','Estadistico del N\u00famero de empleos ofertados por sector e isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:2,
            value:'Sector e isla',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoNumeroEmpleosOfertadosGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['5','N\u00famero de aplicaciones por sector','Estadistica del N\u00famero de aplicaciones por sector.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:1,
            value:'Sector',
            type:'direct'
        };
        params[4]={
            label:'Tipo oferta',
            paramName:'P_TIPO_OFERTA',
            paramValue:0,
            value:'Aplicaciones',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['6','N\u00famero de aplicaciones por isla','Estadistica del N\u00famero de aplicaciones por isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:0,
            value:'Isla',
            type:'direct'
        };
        params[4]={
            label:'Tipo oferta',
            paramName:'P_TIPO_OFERTA',
            paramValue:0,
            value:'Aplicaciones',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['7','N\u00famero de aplicaciones por sector e isla','Estadistico del N\u00famero de aplicaciones por sector e isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:2,
            value:'Sector e isla',
            type:'direct'
        };
        params[4]={
            label:'Tipo oferta',
            paramName:'P_TIPO_OFERTA',
            paramValue:0,
            value:'Aplicaciones',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['8','N\u00famero de ubicaciones por sector','Estadistica del N\u00famero de ubicaciones por sector.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:1,
            value:'Sector',
            type:'direct'
        };
        params[4]={
            label:'Tipo oferta',
            paramName:'P_TIPO_OFERTA',
            paramValue:1,
            value:'Ubicaciones',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['9','N\u00famero de ubicaciones por sector e isla','Estadistica del N\u00famero de ubicaciones por sector e isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Clasificaci\u00f3n',
            paramName:'P_TIPO_FECHA',
            value:dsTipoPeriodoGem,
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'combo',
            required:true
        };
        params[3]={
            label:'Area',
            paramName:'P_TIPO_BUSQUEDA',
            paramValue:2,
            value:'Sector e isla',
            type:'direct'
        };
        params[4]={
            label:'Tipo oferta',
            paramName:'P_TIPO_OFERTA',
            paramValue:1,
            value:'Ubicaciones',
            type:'direct'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['10','Comunicados generados, oferentes que han aplicado y contratados por islas','Comunicados generados, oferentes que han aplicado y contratados por islas.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoComunicadoAplicadoContratado', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],['11','Nivel academico requerido por ofertas por sector e isla','Estadistica por nivel profesional requerido por ofertas por sector e isla.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };

        params[2]=
        {
            objectName:'FrmListadoCgg_nivel_estudio',
            label:'Nivel estudio',
            valueField:'CGNES_CODIGO',
            displayField:'CGNES_DESCRIPCION',
            paramName:'P_CGNES_CODIGO',
            paramValue:'',
            type:'searchable',
            required:true
        };


        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoNivelProfesionalOfertaSectorIsla', '/Reports/sii/gem', null);
        reporte.addParams(params);
        reporte.show();
    }
    ]
    ];

    dhuData = [
    ['1','Becas por periodo','Listado de becas por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        }; 
        params[2]=
        {
            label:'Responsable',
            paramName:'P_RESPONSABLE',
            paramValue:'',
            type:'input',
            required:true
        };
        params[3]=
        {
            objectName:'FrmListadoCgg_dhu_tipo_beca',
            label:'Tipo Beca',
            valueField:'CDTBC_CODIGO',
            displayField:'CDTBC_NOMBRE',
            paramName:'P_CDTBC_CODIGO',
            paramValue:'',
            type:'searchable',
            required:true
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoBecasTipoBecaporPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['2','Total aspirantes a becas o becarios','Listado total aspirantes a becas o becarios.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoBecariosporTipoBecaporPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    /*  ['2','Becas internacional estudiantil INGALA(pregrado)','Listado de becas internacional estudiantil INGALA(pregrado) por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
		 params[2]=
		{
			label:'Responsable',
			paramName:'P_RESPONSABLE',
			paramValue:'',
			type:'input',
			required:true
		};
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoBecasTipoBecaporPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['3','Becas de bachillerato t\u00e9cnico','Listado de becas de bachillerato t\u00e9cnico por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
		 params[2]=
		{
			label:'Responsable',
			paramName:'P_RESPONSABLE',
			paramValue:'',
			type:'input',
			required:true
		};
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoBecasTipoBecaporPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['4','Becas a la excelencia acad\u00e9mica','Listado de becas a la excelencia acad\u00e9mica por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
		 params[2]=
		{
			label:'Responsable',
			paramName:'P_RESPONSABLE',
			paramValue:'',
			type:'input',
			required:true
		};
		 params[3]=
		{
			label:'Tipo Beca',
			paramName:'P_CDTBC_CODIGO',
			paramValue:'',
			type:'hideen',
			required:true
		};
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoBecasTipoBecaporPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],*/
    ['3','Cursos de inducci\u00f3n realizados en Gal\u00e1pagos','Listado de cursos de inducci\u00f3n realizados en Galápagos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]=
        {
            label:'Responsable',
            paramName:'P_RESPONSABLE',
            paramValue:'',
            type:'input',
            required:true
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoCursosInduccionRealizadosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],    
    ['4','Total de residentes capacitados(curso de inducci\u00f3n)','Listado total de residentes capacitados(curso de inducci\u00f3n) por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            label:'Tipo Residente',
            paramName:'P_TIPO_BUSQUEDA',
            value: dsTipoBusqueda,
            paramValue:'',
            type:'combo',
            required:true
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoResidentesCapacitadosGeneralCursoInduccionporCanton', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ],
    ['5','Certificados Emitidos.','Listado de Certificados Emitidos por periodo.',function(){
        var params = [];
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]=
        {
            label:'Responsable',
            paramName:'P_RESPONSABLE',
            paramValue:'',
            type:'input',
            required:true
        };
        addTipoReporte(params);
        var reporte = new FrmCriterioReporte('rptEstadisticoCertificadosEmitidosPeriodo', '/Reports/sii/gerencial', null);
        reporte.addParams(params);
        reporte.show();
    }
    ]

 
    ];

    var cbxTipoReporte = new Ext.form.ComboBox({
        id:'cbxTipoReporte',
        store:[[0,'Estad\u00edstico'],[1,'Listado y estad\u00edstico']],
        anchor: '98%',
        mode:'local',
        editable:false,
        triggerAction:'all',
        value:0,
        listeners:{
            select:function(inThis,inRecord,inIndex){
                if(inThis.getValue()==1){
                    Ext.MsgPopup.msg(tituloCgg_gerencial,'La visualizaci\u00f3n de listados puede tardar algunos minuto adicionales al reporte.', MsgPopup.INFO);
                }
            }
        }
    });
    
    /**
	* Boton que permite cerrar la ventana.
	*/
    var btnCerrarCgg_gerencial = new Ext.Button({
        id:'btnCerrarCgg_gerencial',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_gerencial_reporte.close();
            }
        }
    });
   
    /**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana.
	*/
		
    var store = new Ext.data.ArrayStore({
        fields  : ['id', 'name','desc','report'],
        sortInfo: {
            field : 'id',
            direction: 'ASC'
        }
    });
    store.loadData(resData);

    var sVeh = new Ext.data.ArrayStore({
        fields  : ['id', 'name','desc','report'],
        sortInfo: {
            field : 'id',
            direction: 'ASC'
        }
    });
    sVeh.loadData(vehData);

    var sGem = new Ext.data.ArrayStore({
        fields  : ['id', 'name','desc','report'],
        sortInfo: {
            field : 'id',
            direction: 'ASC'
        }
    });
    sGem.loadData(gemData);

    var sDhu = new Ext.data.ArrayStore({
        fields  : ['id', 'name','desc','report'],
        sortInfo: {
            field : 'id',
            direction: 'ASC'
        }
    });
    sDhu.loadData(dhuData);
            
    var dataview = new Ext.DataView({
        store: store,
        tpl  : new Ext.XTemplate(
            '<ul id ="ulReportes">',
            '<tpl for=".">',
            '<li class="phone">',
            '<img width="32" height="32" src="resources/images/cgg3.png" />',
            '<strong>{name}</strong>',
            '<span>{desc}</span>',
            '</li>',
            '</tpl>',
            '</ul>'
            ),
        
        plugins : [
        new Ext.ux.DataViewTransition({
            duration  : 550,
            idProperty: 'id'
        })
        ],
        id: 'phones',        
        itemSelector: 'li.phone',
        overClass   : 'phone-hover',
        singleSelect: true,
        multiSelect : false,
        autoScroll  : true
    });

    var dvVeh = new Ext.DataView({
        store:sVeh,
        tpl:new Ext.XTemplate(
            '<ul id ="ulRepVeh">',
            '<tpl for=".">',
            '<li class="phone">',
            '<img width="32" height="32" src="resources/images/cgg3.png" />',
            '<strong>{name}</strong>',
            '<span>{desc}</span>',
            '</li>',
            '</tpl>',
            '</ul>'
            ),

        plugins : [
        new Ext.ux.DataViewTransition({
            duration  : 550,
            idProperty: 'id'
        })
        ],
        id: 'phones',
        itemSelector: 'li.phone',
        overClass   : 'phone-hover',
        singleSelect: true,
        multiSelect : false,
        autoScroll  : true
    });

    var dvGem = new Ext.DataView({
        store: sGem,
        tpl  : new Ext.XTemplate(
            '<ul id ="ulRepGem">',
            '<tpl for=".">',
            '<li class="phone">',
            '<img width="32" height="32" src="resources/images/cgg3.png" />',
            '<strong>{name}</strong>',
            '<span>{desc}</span>',
            '</li>',
            '</tpl>',
            '</ul>'
            ),

        plugins : [
        new Ext.ux.DataViewTransition({
            duration  : 550,
            idProperty: 'id'
        })
        ],
        id: 'phones',
        itemSelector: 'li.phone',
        overClass   : 'phone-hover',
        singleSelect: true,
        multiSelect : false,
        autoScroll  : true
    });

    var dvDhu = new Ext.DataView({
        store: sDhu,
        tpl  : new Ext.XTemplate(
            '<ul id ="ulRepDhu">',
            '<tpl for=".">',
            '<li class="phone">',
            '<img width="32" height="32" src="resources/images/cgg3.png" />',
            '<strong>{name}</strong>',
            '<span>{desc}</span>',
            '</li>',
            '</tpl>',
            '</ul>'
            ),

        plugins : [
        new Ext.ux.DataViewTransition({
            duration  : 550,
            idProperty: 'id'
        })
        ],
        id: 'phones',
        itemSelector: 'li.phone',
        overClass   : 'phone-hover',
        singleSelect: true,
        multiSelect : false,
        autoScroll  : true
    });
       
    var pnlCgg_gerencial = new Ext.Panel({        
        region:'center',
        layout:'border',
        items:[{
            id:'tpGerencial',
            xtype:'tabpanel',
            region:'center',
            activeTab:0,            
            items:[{
                id:'tpgRes',
                title:'Control de residencia',
                items:dataview,
                autoScroll:true,
                iconCls:'iconTramite'
            },{
                id:'tpgVeh',
                items:dvVeh,
                title:'Vehiculos',
                autoScroll:true,
                iconCls:'iconVehiculos'
            },{
                id:'tpgGem',
                items:dvGem,
                title:'Gesti\u00f3n de empleo',
                autoScroll:true,
                iconCls:'icongestionempleo'
            },{
                id:'tpgDhu',
                items:dvDhu,
                title:'Desarrollo humano',
                autoScroll:true,
                iconCls:'icondeshumano'
            }]           
            ,
            listeners:{
                tabChange:function(inThis,inTab){
                    if(inTab.getId()=='tpgGem'){
                        cbxTipoReporte.hide();
                    }else{
                        cbxTipoReporte.show();
                    }
                    if(inTab.getId()=='tpgRes'){
                        var ulReportes = document.getElementById('ulReportes');
                        var tmpLi = ulReportes.getElementsByTagName("li");
                        for(var i = 0; i < tmpLi.length; i++){

                            var tmpId = tmpLi[i].id.split("-")[1];
                            var tmpRowIndex = store.findExact('id',tmpId);
                            var tmpRec = store.getAt(tmpRowIndex);
                            tmpLi[i].title = tmpRec.get("desc");

                            tmpLi[i].onclick=function(){
                                var tmpId = this.id.split("-")[1];
                                var tmpRowIndex = store.findExact('id',tmpId);
                                var tmpRec = store.getAt(tmpRowIndex);
                                (tmpRec.get('report'))();
                            }
                        }
                    }else if(inTab.getId()=='tpgVeh'){
                        var ulReportes = document.getElementById('ulRepVeh');
                        var tmpLi = ulReportes.getElementsByTagName("li");
                        for(var i = 0; i < tmpLi.length; i++){

                            var tmpId = tmpLi[i].id.split("-")[1];
                            var tmpRowIndex = sVeh.findExact('id',tmpId);
                            var tmpRec = sVeh.getAt(tmpRowIndex);
                            tmpLi[i].title = tmpRec.get("desc");

                            tmpLi[i].onclick=function(){
                                var tmpId = this.id.split("-")[1];
                                var tmpRowIndex = sVeh.findExact('id',tmpId);
                                var tmpRec = sVeh.getAt(tmpRowIndex);
                                (tmpRec.get('report'))();
                            }
                        }

                    }else if(inTab.getId()=='tpgGem'){
                        var ulReportes = document.getElementById('ulRepGem');
                        var tmpLi = ulReportes.getElementsByTagName("li");
                        for(var i = 0; i < tmpLi.length; i++){

                            var tmpId = tmpLi[i].id.split("-")[1];
                            var tmpRowIndex = sGem.findExact('id',tmpId);
                            var tmpRec = sGem.getAt(tmpRowIndex);
                            tmpLi[i].title = tmpRec.get("desc");

                            tmpLi[i].onclick=function(){
                                var tmpId = this.id.split("-")[1];
                                var tmpRowIndex = sGem.findExact('id',tmpId);
                                var tmpRec = sGem.getAt(tmpRowIndex);
                                (tmpRec.get('report'))();
                            }
                        }
                    }else if(inTab.getId()=='tpgDhu'){
                        var ulReportes = document.getElementById('ulRepDhu');
                        var tmpLi = ulReportes.getElementsByTagName("li");
                        for(var i = 0; i < tmpLi.length; i++){

                            var tmpId = tmpLi[i].id.split("-")[1];
                            var tmpRowIndex = sDhu.findExact('id',tmpId);
                            var tmpRec = sDhu.getAt(tmpRowIndex);
                            tmpLi[i].title = tmpRec.get("desc");

                            tmpLi[i].onclick=function(){
                                var tmpId = this.id.split("-")[1];
                                var tmpRowIndex = sDhu.findExact('id',tmpId);
                                var tmpRec = sDhu.getAt(tmpRowIndex);
                                (tmpRec.get('report'))();
                            }
                        }
                    }
                }
            }
        }
        ],
        height: 615,
        width : 800
    });
    /**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gerencial.
	*/
    var winFrmCgg_gerencial_reporte = null;
    
    if(inDesktop !== undefined && inDesktop !== null){
        winFrmCgg_gerencial_reporte =new inDesktop.createWindow({
            id:'winFrmCgg_gerencial_reporte',
            title:tituloCgg_gerencial,
            iconCls:'iconGerencial',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloCgg_gerencial,descCgg_gerencial),
            items:[pnlCgg_gerencial],
            bbar:['Tipo reporte: ',cbxTipoReporte,'->',btnCerrarCgg_gerencial]
        });
    }else{
        winFrmCgg_gerencial_reporte =new Ext.Window({
            id:'winFrmCgg_gerencial_reporte',
            title:tituloCgg_gerencial,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloCgg_gerencial,descCgg_gerencial),
            items:[pnlCgg_gerencial],
            bbar:['Tipo reporte',cbxTipoReporte,'->',btnCerrarCgg_gerencial]
        });
    }


    function addTipoReporte(inParams){
        var i = inParams.length;
        inParams[i]={
            paramName:'P_LISTA_VISIBLE',
            paramValue:cbxTipoReporte.getValue(),
            value:cbxTipoReporte.getValue(),
            type:'hidden'
        };
    }

    /**
	* Funcion que aplica los privilegios del usuario.
	*/
    applyGrants(winFrmCgg_gerencial_reporte.getBottomToolbar());
    /*
	* Funcion miembro que devuelve la ventana winFrmCgg_gerencial_reporte.
	* @returns ventana winFrmCgg_gerencial_reporte.
	* @base FrmCgg_gerencial_reporte.prototype.show
	*/
    this.getWindow = function(){
        return winFrmCgg_gerencial_reporte;
    }
    /**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gerencial_reporte.
	* @base FrmCgg_gerencial_reporte.prototype.loadData
	*/
    this.loadData = function(){
        cargarCgg_gerencialCtrls();
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gerencial_reporte desde una instancia.
*/
FrmCgg_gerencial_reporte.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gerencial_reporte desde una instancia.
*/
FrmCgg_gerencial_reporte.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gerencial_reporte,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gerencial_reporte.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
