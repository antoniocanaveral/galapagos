/**
 *Funcion. Crea el flujo de trabajo de historial de un tramite.
 *@param inDiv para inyeccion del historial.
 *@param inNodeInfo Objecto json con informacion de los todo la ramificacion de un tramite segun especificacion www.thejit.com.
 */
function crearFlujoTrabajo(inDiv,inNodeInfo){

    var json = inNodeInfo;
    var tplInformacionTramite = new Ext.Template('<table id="ver-zebra2" width="100%" border="0"> <colgroup> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> </colgroup> <tr> <td width=80> N&uacute;mero:</td> <td width="100%"> {CRTRA_ANIO}-{CRTRA_NUMERO}</td> </tr> <tr> <td> Tipo solicitud:</td> <td> {CRTST_DESCRIPCION:ellipsis(25)}</td> </tr> <tr> <td> Beneficiario:</td> <td> {CRPER_BENEFICIARIO:ellipsis(25)}</td> </tr> <tr> <td> Isla:</td> <td> {CISLA_NOMBRE}</td> </tr> <tr> <td> Auspiciante:</td> <td> {CRPER_AUSPICIANTE:ellipsis(25)}</td> </tr> <tr> <td> Recepci&oacute;n:</td> <td> {CRTRA_FECHA_RECEPCION}</td> </tr> <tr> <td> Pers. jur&iacute;dica:</td> <td> {CRPJR_RAZON_SOCIAL:ellipsis(25)}</td> </tr> <tr> <td> N. folios:</td> <td> {CRTRA_FOLIO}</td> </tr> <tr> <td> Observaci&oacute;n:</td> <td> {CRTRA_OBSERVACION:ellipsis(60)}</td> </tr> <tr> <td width=80"> Comunicado(R):</td> <td width="33%"> {CRTRA_COMUNICADO_RADIAL}</td> </tr> <tr> <td>Actividad:</td> <td>{CRTRA_ACTIVIDAD_RESIDENCIA}</td> </tr> <tr> <td>Permanencia:</td> <td>{CRTRA_DIAS_PERMANENCIA}</td> </tr> <tr> <td>Recalificaci&oacute;n:</td> <td>{CRTRA_MOTIVO}</td> </tr> <tr> <td>Estado:</td> <td>{CRETT_NOMBRE}</td> </tr> <tr> <td>Proceso:</td> <td> {CRPRO_NOMBRE} </td> </tr> <tr> <td></td> <td> <a href="#" style="display:{VEHICULO}" onClick="abrirVeh(\'{CVVEH_CODIGO}\')"> Ver veh&iacute;culo</a> </td> </tr> <tr> <td></td> <td> <a href="#" onClick="abrirTramite(\'{CRTRA_CODIGO}\')"> Ver m&aacute;s...</a> </td> </tr> </table>');
    var tplInformacionSeguimiento = new Ext.Template('<table id="ver-zebra2" width="100%" border="0"> <colgroup> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> </colgroup> <tr> <td width="80px"> Seguimiento: </td> <td width="100%">{CRSEG_NUMERO}</td> </tr> <tr> <td> Observaci&oacute;n: </td> <td>{CRSEG_OBSERVACION}</td> </tr> <tr> <td> Recepci&oacute;n: </td> <td>{CRSEG_FECHA_RECEPCION}</td> </tr> <tr> <td> Fase: </td> <td>{CRFAS_NOMBRE}</td> </tr> <tr> <td> Usuario: </td> <td>{CRPER_NOMBRES}</td> </tr> <tr> <td> Despacho: </td> <td>{CRSEG_FECHA_DESPACHO}</td> </tr> <tr> <td> Actividad: </td> <td>{CRSEG_TIPO_ACTIVIDAD}</td> </tr> <tr> <td> Descripci&oacute;n: </td> <td>{CRSEG_DESCRIPCION}</td> </tr>   <tr> <td>Estado:</td> <td>{CRSEG_ESTADO_ATENCION}</td> </tr> <tr> <td>Respuesta</td> <td>{CRSEG_TIPO_RESPUESTA}</td> </tr>  <tr> <td></td> <td><a href="#" onClick="abrirSeguimiento(\'{CRSEG_CODIGO}\')">Ver m&aacute;s...</a></td> </tr> </table>');

    var datosTramite = {
        CRTRA_ANIO:'2011',
        CRTRA_NUMERO:'0',
        CRPER_BENEFICIARIO:'',
        CRPER_AUSPICIANTE:'',
        CRTRA_FECHA_RECEPCION:'',
        CRPJR_RAZON_SOCIAL:'',
        CISLA_NOMBRE:'',
        CRTRA_OBSERVACION:'',
        CRTRA_COMUNICADO_RADIAL:'',
        CRTRA_CODIGO:'',
        CRTRA_DIAS_PERMANENCIA:0,
        CRTRA_ACTIVIDAD_RESIDENCIA:'',
        CRTST_DESCRIPCION:'',
        CRETT_NOMBRE:'',
        CRPRO_NOMBRE:'',
        CRTRA_FOLIO:'',
        CRTRA_MOTIVO:'No',
        VEHICULO:'none',
        CVVEH_CODIGO:''
    };

    var datosSeguimiento = {
        CRSEG_NUMERO:'',
        CRSEG_OBSERVACION:'',
        CRSEG_FECHA_RECEPCION:'',
        CRSEG_FECHA_REVISION:'',        
        CRFAS_NOMBRE:'',
        CUSU_CODIGO:'',
        CRSEG_TIPO_ACTIVIDAD:'',
        CRSEG_FECHA_DESPACHO:'',
        CRSEG_DESCRIPCION:'',
        CRSEG_ESTADO_ATENCION:'',
        CRSEG_TIPO_RESPUESTA:'',
        CRSEG_CODIGO:'',
        CRPER_NOMBRES:''
    };

    
    //init Spacetree
    //Create a new ST instance

    if(stDiagramaHistorial!==null){        

        for(var id in stDiagramaHistorial.fx.labels.labels){
            stDiagramaHistorial.fx.labels.disposeLabel(id);
            delete stDiagramaHistorial.fx.labels[id];
        }

        stDiagramaHistorial.labels.clearLabels(true);
        stDiagramaHistorial.canvas.clear();
        
        var stDiagramaHistorial1 = new $jit.ST({
            //id of viz container element
            injectInto: inDiv,
            //set duration for the animation
            duration: 400,
            useCanvas:stDiagramaHistorial.canvas,
            //set animation transition type
            transition: $jit.Trans.Quart.easeInOut,
            //set distance between node and its children            
            constrained:false,
            levelsToShow: 100,
            levelDistance:100,
            siblingOffset:70,
            //enable panning
            /*Navigation: {
                enable:true,
                panning:false,
                zooming:50
            },*/
            orientation:'top',
            //set node and edge styles
            //set overridable=true for styling individual
            //nodes or edges
            Node: {
                height: 20,
                width: 60,
                type: 'circle',
                dim:30,                                
                color: '#aaa',
                overridable: true
            },
            Edge: {
                type: 'bezier',
                overridable: true
            },
            //This method is called on DOM label creation.
            //Use this method to add event handlers and styles to
            //your node.
            onCreateLabel: function(label, node){
                var htmlDiv='';
                var nodeData = node.data;
                label.id = node.id;
                if( node.id.substring(0, 4)=='CTRA' || node.id.substring(0, 5) == 'CRTRA'){
                    var estadoTramite = node.data.myCrett_codigo;

                    var scpConfCrettAnulado = new SOAPClientParameters({
                        inCgcnf_codigo:'19',
                        format:TypeFormat.JSON
                    });

                    var scpConfCrettFinalizado = new SOAPClientParameters({
                        inCgcnf_codigo:'20',
                        format:TypeFormat.JSON
                    });

                    var crettAnulado = null;
                    var crettFinalizado = null;
                    var esVehiculo = false;

                    try{
                        crettAnulado = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpConfCrettAnulado, false, null);
                        crettAnulado = Ext.util.JSON.decode(crettAnulado);
                        crettAnulado = crettAnulado[0];

                        crettFinalizado = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpConfCrettFinalizado, false, null);
                        crettFinalizado = Ext.util.JSON.decode(crettFinalizado);
                        crettFinalizado = crettFinalizado[0];

                        var scpTipoSol = new SOAPClientParameters({
                            inCrtst_codigo:nodeData.myCrtst_codigo ,
                            format:TypeFormat.JSON
                        });

                        esVehiculo = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'select', scpTipoSol, false, null);
                        esVehiculo = Ext.util.JSON.decode(esVehiculo);
                        esVehiculo = esVehiculo[0].CRTST_VEHICULO;
                        
                    }catch(inErr){
                        crettAnulado = null;
                        crettFinalizado = null;
                    }

                    if(crettAnulado !== null && crettFinalizado !== null){
                        if(estadoTramite == crettAnulado.CGCNF_VALOR_CADENA){
                            htmlDiv = 'divNodoTramiteAnulado';
                        }else if(estadoTramite == crettFinalizado.CGCNF_VALOR_CADENA){
                            htmlDiv = 'divNodoTramiteFinalizado';
                        }else{                            
                            if(esVehiculo==true){
                                htmlDiv = 'divNodoTraVeh';
                            }else{
                                htmlDiv = 'divNodoTramite';
                            }
                        }
                    }else{
                        if(esVehiculo==true){
                            htmlDiv = 'divNodoTraVeh';
                        }else{
                            htmlDiv = 'divNodoTramite';
                        }
                        
                    }

                }else if(node.id.substring(0, 5) == 'CRSEG' || node.id.substring(0, 4) == 'CSEG'){
                    switch (nodeData.myCrseg_estado_atencion) {
                        case TypeEstadoAtencion.RECIBIDO:
                            htmlDiv = 'divNodoRecibido';
                            break;
                        case TypeEstadoAtencion.REVISADO:
                            htmlDiv = 'divNodoRevisado';
                            break;
                        case TypeEstadoAtencion.DISTRIBUIDO:
                            htmlDiv = 'divNodoDistribuido';
                            break;
                        case TypeEstadoAtencion.PENDIENTE:
                            htmlDiv = 'divNodoPendiente';
                            break;
                        case TypeEstadoAtencion.DESPACHADO:
                            htmlDiv = 'divNodoDespachado';
                            break;
                        case TypeEstadoAtencion.REVISADODISTRIBUIDO:
                            htmlDiv = 'divNodoRevisadoDistribuido';
                            break;
                        case TypeEstadoAtencion.INHABILITADO:
                            htmlDiv = 'divNodoInhabilitado';
                            break;
                        default:
                            htmlDiv = 'divNodoDesconocido';
                            break;
                    }
                }
                label.innerHTML = '<table style="width:80px;" border="0"> <tr> <td style="width: 48px"><div class="'+htmlDiv+'"></td> <td><span class="labelNodo">'+node.name+'</span></td> </tr> </table>';
                label.onclick = function(){
                    //stDiagramaHistorial.onClick(node.id);
                    Ext.getCmp('pnlWorkflowInfo').expand(false);
                    Ext.getCmp('pnlWorkflowInfo').getEl().mask('Cargando...', 'x-mask-loading');
                    if( node.id.substring(0, 4)=='CTRA' || node.id.substring(0, 5) == 'CRTRA'){
                        
                        datosTramite.CRTRA_CODIGO=node.id;
                        
                        if(node.data.myCrtra_motivo!== undefined && node.data.myCrtra_motivo == 'true'){
                            datosTramite.CRTRA_MOTIVO = 'Si';
                        }
                        if(node.data.myCrtra_motivo!== undefined && node.data.myCrtra_motivo == 'false'){
                            datosTramite.CRTRA_MOTIVO = 'No';
                        }                       

                        var scpCargo = new SOAPClientParameters();
                        scpCargo.add('inCgcrg_codigo',node.data.myCrtra_actividad_residencia);
                        scpCargo.add('format',TypeFormat.JSON);

                        var tmpCargo = SOAPClient.invoke(URL_WS+'Cgg_gem_cargo', 'select', scpCargo, false, null);
                        try{
                            tmpCargo = Ext.util.JSON.decode(tmpCargo);
                            tmpCargo =  tmpCargo[0];
                            datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = tmpCargo.CGCRG_NOMBRE ;
                        }catch(inErr){
                            datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = NO_DATA_MESSAGE;
                        }

                        datosTramite.CRTRA_ANIO = node.data.myCrtra_anio;
                        
                        if(node.data.myCrtra_dias_permanencia == 0){
                            
                            if(node.data.myCrtra_fecha_salida!==undefined && node.data.myCrtra_fecha_salida !== null && node.data.myCrtra_fecha_salida.trim().length >=1){
                                datosTramite.CRTRA_DIAS_PERMANENCIA=node.data.myCrtra_fecha_salida.toString('dd/MM/yyyy');
                            }else{
                                datosTramite.CRTRA_DIAS_PERMANENCIA='Indefinido';
                            }
                            
                        }else if(node.data.myCrtra_dias_permanencia >=1){
                            datosTramite.CRTRA_DIAS_PERMANENCIA=node.data.myCrtra_dias_permanencia+' D\u00edas';
                        }
                                                
                        try{datosTramite.CRTRA_FECHA_RECEPCION = Date.parse(node.data.myCrtra_fecha_recepcion).toString('dd/MM/yyyy HH:mm');}catch(inErr){datosTramite.CRTRA_FECHA_RECEPCION = node.data.myCrtra_fecha_recepcion}
                        datosTramite.CRTRA_NUMERO = node.data.myCrtra_numero;
                        datosTramite.CRTRA_OBSERVACION = node.data.myCrtra_observacion?node.data.myCrtra_observacion:'';
                        datosTramite.CRTRA_COMUNICADO_RADIAL = node.data.myCrtra_comunicado_radial;
                        datosTramite.CRTRA_FOLIO = node.data.myCrtra_folio;
                        
                        for(var i=0;i<SCGG_ISLA.getCount();i++){
                            var rIsla = SCGG_ISLA.getAt(i);
                            if(rIsla.get('CISLA_CODIGO') == node.data.myCisla_codigo){
                                datosTramite.CISLA_NOMBRE = rIsla.get('CISLA_NOMBRE');
                                break;
                            }
                        }
                       
                        var scpTipoSolicitud = new SOAPClientParameters();
                        scpTipoSolicitud.add('inCrtst_codigo',node.data.myCrtst_codigo);
                        scpTipoSolicitud.add('format',TypeFormat.JSON);
                        var tmpSolicitud = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'select', scpTipoSolicitud, false, null);
                        try{
                            tmpSolicitud = Ext.util.JSON.decode(tmpSolicitud);
                            tmpSolicitud = tmpSolicitud[0];

                            //Consulta de tipo de solicitud padre.
                            var scpSolicitudPadre= new SOAPClientParameters();
                            scpSolicitudPadre.add('inCrtst_codigo',tmpSolicitud.CRTST_CODIGO);
                            scpSolicitudPadre.add('format',TypeFormat.JSON);
                            var crtstPadre = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','selectCGG_RES_TIPO_SOLICITUD_PADRE',scpSolicitudPadre, false,null);
                        
                            crtstPadre = eval(crtstPadre);
                            crtstPadre = crtstPadre[0];
                      
                            datosTramite.CRTST_DESCRIPCION = crtstPadre.CRTST_DESCRIPCION+' - '+tmpSolicitud.CRTST_DESCRIPCION;
                        }catch(inErr){
                            datosTramite.CRTST_DESCRIPCION = NO_DATA_MESSAGE;
                        }

                        var scpBeneficiario = new SOAPClientParameters();
                        scpBeneficiario.add('inCrper_codigo', node.data.myCgg_crper_codigo);
                        scpBeneficiario.add('format', TypeFormat.JSON);
                        var tmpBeneficiario = SOAPClient.invoke(URL_WS+'Cgg_res_persona', 'select', scpBeneficiario, false, false);
                        try{
                            tmpBeneficiario = Ext.util.JSON.decode(tmpBeneficiario);
                            tmpBeneficiario=tmpBeneficiario[0];
                            datosTramite.CRPER_BENEFICIARIO = Ext.util.Format.ellipsis((tmpBeneficiario.CRPER_NOMBRES?tmpBeneficiario.CRPER_NOMBRES:'')+' '+(tmpBeneficiario.CRPER_APELLIDO_PATERNO?tmpBeneficiario.CRPER_APELLIDO_PATERNO:'')+' '+(tmpBeneficiario.CRPER_APELLIDO_PATERNO?tmpBeneficiario.CRPER_APELLIDO_MATERNO:''),60);
                        }catch(inErr){
                            alert(inErr);
                            datosTramite.CRPER_BENEFICIARIO = NO_DATA_MESSAGE;
                        }

                        var scpAuspiciante = new SOAPClientParameters();
                        scpAuspiciante.add('inCrper_codigo', node.data.myCrper_codigo);
                        scpAuspiciante.add('format', TypeFormat.JSON);
                        var tmpAuspiciante = SOAPClient.invoke(URL_WS+'Cgg_res_persona', 'select', scpAuspiciante, false, false);
                        try{
                            tmpAuspiciante= Ext.util.JSON.decode(tmpAuspiciante);
                            tmpAuspiciante=tmpAuspiciante[0];
                            datosTramite.CRPER_AUSPICIANTE = Ext.util.Format.ellipsis((tmpAuspiciante.CRPER_NOMBRES?tmpAuspiciante.CRPER_NOMBRES:'')+' '+(tmpAuspiciante.CRPER_APELLIDO_PATERNO?tmpAuspiciante.CRPER_APELLIDO_PATERNO:'')+' '+(tmpAuspiciante.CRPER_APELLIDO_PATERNO?tmpAuspiciante.CRPER_APELLIDO_MATERNO:'') ,60);
                        }catch(inErr){
                            datosTramite.CRPER_AUSPICIANTE= NO_DATA_MESSAGE;
                        }

                        if(node.data.myCrpjr_codigo){
                            var scpPjuridica = new SOAPClientParameters();
                            scpPjuridica.add('inCrpjr_codigo', node.data.myCrpjr_codigo);
                            scpPjuridica.add('format', TypeFormat.JSON);
                            var tmpPjuridica= SOAPClient.invoke(URL_WS+'Cgg_res_persona_juridica', 'select', scpPjuridica, false, null);
                            try{
                                tmpPjuridica= Ext.util.JSON.decode(tmpPjuridica);
                                tmpPjuridica=tmpPjuridica[0];
                                datosTramite.CRPJR_RAZON_SOCIAL = Ext.util.Format.ellipsis(Ext.util.Format.undef(tmpPjuridica.CRPJR_RAZON_SOCIAL),60);
                            }catch(inErr){
                                datosTramite.CRPJR_RAZON_SOCIAL= NO_DATA_MESSAGE;
                            }
                        }
                        

                        var scpEstadoTramite = new SOAPClientParameters();
                        scpEstadoTramite.add('inCrett_codigo', node.data.myCrett_codigo);
                        scpEstadoTramite.add('format', TypeFormat.JSON);
                        var tmpEstadoTramite= SOAPClient.invoke(URL_WS+'Cgg_res_estado_tramite', 'select', scpEstadoTramite, false, null);
                        try{
                            tmpEstadoTramite= Ext.util.JSON.decode(tmpEstadoTramite);
                            tmpEstadoTramite=tmpEstadoTramite[0];
                            datosTramite.CRETT_NOMBRE= Ext.util.Format.undef(tmpEstadoTramite.CRETT_NOMBRE);
                        }catch(inErr){
                            datosTramite.CRETT_NOMBRE= NO_DATA_MESSAGE;
                        }

                        var scpProceso = new SOAPClientParameters();
                        scpProceso.add('inCrpro_codigo', node.data.myCrpro_codigo);
                        scpProceso.add('format', TypeFormat.JSON);
                        var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
                        try {
                            tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);
                            datosTramite.CRPRO_NOMBRE=tmpCrproRegistro[0].CRPRO_NOMBRE;

                        }catch (inErr) {
                            datosTramite.CRPRO_NOMBRE=NO_DATA_MESSAGE;
                        }

                        datosTramite.CVVEH_CODIGO = node.data.myCvveh_codigo;
                        if(node.data.myCvveh_codigo){
                            datosTramite.VEHICULO ='block';
                        }                       
                        
                        tplInformacionTramite.compile();
                        tplInformacionTramite.overwrite('lblWorkflowInfo',datosTramite);
                       
                    }else{

                        datosSeguimiento.CRSEG_DESCRIPCION = node.data.myCrseg_descripcion;
                        datosSeguimiento.CRSEG_FECHA_DESPACHO=node.data.myCrseg_fecha_despacho;
                        datosSeguimiento.CRSEG_FECHA_RECEPCION = node.data.myCrseg_fecha_recepcion;
                        datosSeguimiento.CRSEG_FECHA_REVISION = node.data.myCrseg_fecha_revision;
                        datosSeguimiento.CRSEG_NUMERO = node.data.myCrseg_numero;
                        datosSeguimiento.CRSEG_TIPO_ACTIVIDAD = node.data.myCrseg_tipo_actividad;
                        datosSeguimiento.CRSEG_OBSERVACION = node.data.myCrseg_observacion;
                        datosSeguimiento.CRSEG_CODIGO = node.data.myCrseg_codigo;

                        var scpUsuario = new SOAPClientParameters();
                        scpUsuario.add('inCusu_codigo',node.data.myCusu_codigo);
                        scpUsuario.add('format',TypeFormat.JSON);
                        var tmpUsuario = SOAPClient.invoke(URL_WS+'Cgg_usuario', 'selectUsuarioPersona', scpUsuario, false, null);
                        try{
                            tmpUsuario = Ext.util.JSON.decode(tmpUsuario);
                            tmpUsuario =tmpUsuario[0];
                            
                            datosSeguimiento.CRPER_NOMBRES =tmpUsuario.CRPER_NOMBRES+' '+tmpUsuario.CRPER_APELLIDO_PATERNO+' '+tmpUsuario.CRPER_APELLIDO_MATERNO+'('+tmpUsuario.CUSU_NOMBRE_USUARIO+')';
                        }catch(inErr){
                            datosSeguimiento.CRPER_NOMBRES =NO_DATA_MESSAGE;
                        }
                        
                        var tmpEstadoAtencion = null;
                        var tmpRespuesta = null;

                        for(var x=0;x<dsEstadoAtencionSeguimiento.length;x++){
                            if(dsEstadoAtencionSeguimiento[x][0]==node.data.myCrseg_estado_atencion){
                                tmpEstadoAtencion = dsEstadoAtencionSeguimiento[x][1];
                            }
                        }

                        for(TipoRespuesta in TypeRespuestaSeguimiento){
                            if(eval('TypeRespuestaSeguimiento.'+TipoRespuesta)==node.data.myCrseg_tipo_respuesta){
                                tmpRespuesta=TipoRespuesta;
                            }
                        }

                        datosSeguimiento.CRSEG_ESTADO_ATENCION=tmpEstadoAtencion;
                        datosSeguimiento.CRSEG_TIPO_RESPUESTA=tmpRespuesta;

                        var scpFase = new SOAPClientParameters();
                        scpFase.add('inCrfas_codigo',node.data.myCrfas_codigo);
                        scpFase.add('format',TypeFormat.JSON);

                        var tmpFase = SOAPClient.invoke(URL_WS+'Cgg_res_fase', 'select', scpFase, false, null);
                        try{
                            tmpFase = Ext.util.JSON.decode(tmpFase);
                            tmpFase = tmpFase[0];
                            datosSeguimiento.CRFAS_NOMBRE = tmpFase.CRFAS_NOMBRE;
                        }catch(inErr){
                            datosSeguimiento.CRFAS_NOMBRE = NO_DATA_MESSAGE;
                        }

                        tplInformacionSeguimiento.compile();
                        tplInformacionSeguimiento.overwrite('lblWorkflowInfo',datosSeguimiento);
                    }
                    Ext.getCmp('pnlWorkflowInfo').getEl().unmask();
                };
                /*label.onmouseover=function(){

            };*/
                //set label styles
                var style = label.style;
                style.width = 60 + 'px';
                style.height = 70 + 'px';
                style.cursor = 'pointer';
                style.color = '#333';
                style.fontSize = '0.8em';
                style.textAlign= 'center';
                style.paddingTop = '3px';
            },
            /* onPlaceLabel: function(label, node) {
            var pos = node.getPos(),
                width = node.getData('width'),
                height = node.getData('height'),
                size = st.canvas.getSize();
//            label.setAttribute("x", pos.x + size.width/2 - width/2);
//            label.setAttribute("y", pos.y + size.height/2);
        },*/
            //This method is called right before plotting
            //a node. It's useful for changing an individual node
            //style properties before plotting it.
            //The data properties prefixed with a dollar
            //sign will override the global node style properties.
            onBeforePlotNode: function(node){
                //add some color to the nodes in the path between the
                //root node and the selected node.
                if (node.selected) {
                    node.data.$color = "#ff7";
                }
                else {
                    delete node.data.$color;
                    //if the node belongs to the last plotted level
                    if(!node.anySubnode("exist")) {
                        //count children number
                        var count = 0;
                        node.eachSubnode(function(n) {
                            count++;
                        });
                        //assign a node color based on
                        //how many children it has
                        node.data.$color = ['#aaa', '#baa', '#caa', '#daa', '#eaa', '#faa'][count];
                    }
                }
            },

            //This method is called right before plotting
            //an edge. It's useful for changing an individual edge
            //style properties before plotting it.
            //Edge data proprties prefixed with a dollar sign will
            //override the Edge global style properties.
            onBeforePlotLine: function(adj){
                if (adj.nodeFrom.selected && adj.nodeTo.selected) {
                    adj.data.$color = "#eed";
                    adj.data.$lineWidth = 3;
                }
                else {
                    delete adj.data.$color;
                    delete adj.data.$lineWidth;
                }
            }
        });

        stDiagramaHistorial = stDiagramaHistorial1;
    }else{
        stDiagramaHistorial = new $jit.ST({
            //id of viz container element
            injectInto: inDiv,
            //set duration for the animation
            duration: 400,
            //set animation transition type
            transition: $jit.Trans.Quart.easeInOut,
            //set distance between node and its children            
            constrained: false,
            levelsToShow: 100,
            levelDistance:100,
            siblingOffset:90,
            //enable panning
            /* Navigation: {
                enable:true,
                panning:true,
                zooming:50
            },*/
            orientation:'top',
            //set node and edge styles
            //set overridable=true for styling individual
            //nodes or edges
            Node: {
                height: 20,
                width: 60,
                type: 'circle',
                dim:30,                
                color: '#aaa',
                overridable: true
            },
            Edge: {
                type: 'bezier',
                overridable: true
            },
            //This method is called on DOM label creation.
            //Use this method to add event handlers and styles to
            //your node.
            onCreateLabel: function(label, node){
                var htmlDiv='';
                var nodeData = node.data;
                label.id = node.id;
                if( node.id.substring(0, 4)=='CTRA' || node.id.substring(0, 5) == 'CRTRA'){
                    var estadoTramite = node.data.myCrett_codigo;

                    var scpConfCrettAnulado = new SOAPClientParameters({
                        inCgcnf_codigo:'19',
                        format:TypeFormat.JSON
                    });

                    var scpConfCrettFinalizado = new SOAPClientParameters({
                        inCgcnf_codigo:'20',
                        format:TypeFormat.JSON
                    });

                    var crettAnulado = null;
                    var crettFinalizado = null;
                    var esVehiculo = false;

                    try{
                        crettAnulado = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpConfCrettAnulado, false, null);
                        crettAnulado = Ext.util.JSON.decode(crettAnulado);
                        crettAnulado = crettAnulado[0];

                        crettFinalizado = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpConfCrettFinalizado, false, null);
                        crettFinalizado = Ext.util.JSON.decode(crettFinalizado);
                        crettFinalizado = crettFinalizado[0];

                        var scpTipoSol = new SOAPClientParameters({
                            inCrtst_codigo:nodeData.myCrtst_codigo ,
                            format:TypeFormat.JSON
                        });

                        esVehiculo = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'select', scpTipoSol, false, null);
                        esVehiculo = Ext.util.JSON.decode(esVehiculo);
                        esVehiculo = esVehiculo[0].CRTST_VEHICULO;

                    }catch(inErr){
                        crettAnulado = null;
                        crettFinalizado = null;
                    }

                    if(crettAnulado !== null && crettFinalizado !== null){
                        if(estadoTramite == crettAnulado.CGCNF_VALOR_CADENA){
                            htmlDiv = 'divNodoTramiteAnulado';
                        }else if(estadoTramite == crettFinalizado.CGCNF_VALOR_CADENA){
                            htmlDiv = 'divNodoTramiteFinalizado';
                        }else{
                            if(esVehiculo==true){
                                htmlDiv = 'divNodoTraVeh';
                            }else{
                                htmlDiv = 'divNodoTramite';
                            }
                        }
                    }else{
                        if(esVehiculo==true){
                            htmlDiv = 'divNodoTraVeh';
                        }else{
                            htmlDiv = 'divNodoTramite';
                        }

                    }

                }else if(node.id.substring(0, 5) == 'CRSEG' || node.id.substring(0, 4) == 'CSEG'){
                    switch (nodeData.myCrseg_estado_atencion) {                        
                        case TypeEstadoAtencion.RECIBIDO:
                            htmlDiv = 'divNodoRecibido';
                            break;
                        case TypeEstadoAtencion.REVISADO:
                            htmlDiv = 'divNodoRevisado';
                            break;
                        case TypeEstadoAtencion.DISTRIBUIDO:
                            htmlDiv = 'divNodoDistribuido';
                            break;
                        case TypeEstadoAtencion.PENDIENTE:
                            htmlDiv = 'divNodoPendiente';
                            break;
                        case TypeEstadoAtencion.DESPACHADO:
                            htmlDiv = 'divNodoDespachado';
                            break;
                        case TypeEstadoAtencion.REVISADODISTRIBUIDO:
                            htmlDiv = 'divNodoRevisadoDistribuido';
                            break;
                        case TypeEstadoAtencion.INHABILITADO:
                            htmlDiv = 'divNodoInhabilitado';
                            break;
                        default:
                            htmlDiv = 'divNodoDesconocido';
                            break;
                    }
                }
                label.innerHTML = '<table style="width:80px;" border="0"> <tr> <td style="width: 48px"><div class="'+htmlDiv+'"></td> <td><span class="labelNodo">'+node.name+'+</span></td> </tr> </table>';
                label.onclick = function(){
                    //stDiagramaHistorial.onClick(node.id);
                    Ext.getCmp('pnlWorkflowInfo').expand(false);
                    Ext.getCmp('pnlWorkflowInfo').getEl().mask('Cargando...', 'x-mask-loading');
                    if( node.id.substring(0, 4)=='CTRA' || node.id.substring(0, 5) == 'CRTRA'){

                        datosTramite.CRTRA_CODIGO=node.id;

                        if(node.data.myCrtra_motivo!== undefined && node.data.myCrtra_motivo == 'true'){
                            datosTramite.CRTRA_MOTIVO = 'Si';
                        }
                        if(node.data.myCrtra_motivo!== undefined && node.data.myCrtra_motivo == 'false'){
                            datosTramite.CRTRA_MOTIVO = 'No';
                        }

                        var scpCargo = new SOAPClientParameters();
                        scpCargo.add('inCgcrg_codigo',node.data.myCrtra_actividad_residencia);
                        scpCargo.add('format',TypeFormat.JSON);

                        var tmpCargo = SOAPClient.invoke(URL_WS+'Cgg_gem_cargo', 'select', scpCargo, false, null);
                        try{
                            tmpCargo = Ext.util.JSON.decode(tmpCargo);
                            tmpCargo =  tmpCargo[0];
                            datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = tmpCargo.CGCRG_NOMBRE ;
                        }catch(inErr){
                            datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = NO_DATA_MESSAGE;
                        }

                        datosTramite.CRTRA_ANIO = node.data.myCrtra_anio;

                        if(node.data.myCrtra_dias_permanencia == 0){

                            if(node.data.myCrtra_fecha_salida!==undefined && node.data.myCrtra_fecha_salida !== null && node.data.myCrtra_fecha_salida.trim().length >=1){
                                datosTramite.CRTRA_DIAS_PERMANENCIA=node.data.myCrtra_fecha_salida.toString('dd/MM/yyyy');
                            }else{
                                datosTramite.CRTRA_DIAS_PERMANENCIA='Indefinido';
                            }

                        }else if(node.data.myCrtra_dias_permanencia >=1){
                            datosTramite.CRTRA_DIAS_PERMANENCIA=node.data.myCrtra_dias_permanencia+' D\u00edas';
                        }

                        try{datosTramite.CRTRA_FECHA_RECEPCION = Date.parse(node.data.myCrtra_fecha_recepcion).toString('dd/MM/yyyy HH:mm');}catch(inErr){datosTramite.CRTRA_FECHA_RECEPCION = node.data.myCrtra_fecha_recepcion}

                        datosTramite.CRTRA_NUMERO = node.data.myCrtra_numero;
                        datosTramite.CRTRA_OBSERVACION = node.data.myCrtra_observacion?node.data.myCrtra_observacion:'';
                        datosTramite.CRTRA_COMUNICADO_RADIAL = node.data.myCrtra_comunicado_radial;
                        datosTramite.CRTRA_FOLIO = node.data.myCrtra_folio;

                        for(var i=0;i<SCGG_ISLA.getCount();i++){
                            var rIsla = SCGG_ISLA.getAt(i);
                            if(rIsla.get('CISLA_CODIGO') == node.data.myCisla_codigo){
                                datosTramite.CISLA_NOMBRE = rIsla.get('CISLA_NOMBRE');
                                break;
                            }
                        }

                        var scpTipoSolicitud = new SOAPClientParameters();
                        scpTipoSolicitud.add('inCrtst_codigo',node.data.myCrtst_codigo);
                        scpTipoSolicitud.add('format',TypeFormat.JSON);
                        var tmpSolicitud = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'select', scpTipoSolicitud, false, null);
                        try{
                            tmpSolicitud = Ext.util.JSON.decode(tmpSolicitud);
                            tmpSolicitud = tmpSolicitud[0];

                            //Consulta de tipo de solicitud padre.
                            var scpSolicitudPadre= new SOAPClientParameters();
                            scpSolicitudPadre.add('inCrtst_codigo',tmpSolicitud.CRTST_CODIGO);
                            scpSolicitudPadre.add('format',TypeFormat.JSON);
                            var crtstPadre = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','selectCGG_RES_TIPO_SOLICITUD_PADRE',scpSolicitudPadre, false,null);

                            crtstPadre = eval(crtstPadre);
                            crtstPadre = crtstPadre[0];

                            datosTramite.CRTST_DESCRIPCION = crtstPadre.CRTST_DESCRIPCION+' - '+tmpSolicitud.CRTST_DESCRIPCION;
                        }catch(inErr){
                            datosTramite.CRTST_DESCRIPCION = NO_DATA_MESSAGE;
                        }

                        var scpBeneficiario = new SOAPClientParameters();
                        scpBeneficiario.add('inCrper_codigo', node.data.myCgg_crper_codigo);
                        scpBeneficiario.add('format', TypeFormat.JSON);
                        var tmpBeneficiario = SOAPClient.invoke(URL_WS+'Cgg_res_persona', 'select', scpBeneficiario, false, null);
                        try{
                            tmpBeneficiario = Ext.util.JSON.decode(tmpBeneficiario);
                            tmpBeneficiario=tmpBeneficiario[0];
                            datosTramite.CRPER_BENEFICIARIO = Ext.util.Format.ellipsis((tmpBeneficiario.CRPER_NOMBRES?tmpBeneficiario.CRPER_NOMBRES:'')+' '+(tmpBeneficiario.CRPER_APELLIDO_PATERNO?tmpBeneficiario.CRPER_APELLIDO_PATERNO:'')+' '+(tmpBeneficiario.CRPER_APELLIDO_MATERNO?tmpBeneficiario.CRPER_APELLIDO_MATERNO:''),60);
                        }catch(inErr){
                            datosTramite.CRPER_BENEFICIARIO = NO_DATA_MESSAGE;
                        }

                        var scpAuspiciante = new SOAPClientParameters();
                        scpAuspiciante.add('inCrper_codigo', node.data.myCrper_codigo);
                        scpAuspiciante.add('format', TypeFormat.JSON);
                        var tmpAuspiciante = SOAPClient.invoke(URL_WS+'Cgg_res_persona', 'select', scpAuspiciante, false, null);
                        try{
                            tmpAuspiciante= Ext.util.JSON.decode(tmpAuspiciante);
                            tmpAuspiciante=tmpAuspiciante[0];
                            datosTramite.CRPER_AUSPICIANTE = Ext.util.Format.ellipsis(tmpAuspiciante.CRPER_NOMBRES+' '+ tmpAuspiciante.CRPER_APELLIDO_PATERNO,60);
                        }catch(inErr){
                            datosTramite.CRPER_AUSPICIANTE= NO_DATA_MESSAGE;
                        }

                       if(node.data.myCrpjr_codigo){
                            var scpPjuridica = new SOAPClientParameters();
                            scpPjuridica.add('inCrpjr_codigo', node.data.myCrpjr_codigo);
                            scpPjuridica.add('format', TypeFormat.JSON);
                            var tmpPjuridica= SOAPClient.invoke(URL_WS+'Cgg_res_persona_juridica', 'select', scpPjuridica, false, null);
                            try{
                                tmpPjuridica= Ext.util.JSON.decode(tmpPjuridica);
                                tmpPjuridica=tmpPjuridica[0];
                                datosTramite.CRPJR_RAZON_SOCIAL = Ext.util.Format.ellipsis(Ext.util.Format.undef(tmpPjuridica.CRPJR_RAZON_SOCIAL),60);
                            }catch(inErr){
                                datosTramite.CRPJR_RAZON_SOCIAL= NO_DATA_MESSAGE;
                            }
                        }

                        var scpEstadoTramite = new SOAPClientParameters();
                        scpEstadoTramite.add('inCrett_codigo', node.data.myCrett_codigo);
                        scpEstadoTramite.add('format', TypeFormat.JSON);
                        var tmpEstadoTramite= SOAPClient.invoke(URL_WS+'Cgg_res_estado_tramite', 'select', scpEstadoTramite, false, null);
                        try{
                            tmpEstadoTramite= Ext.util.JSON.decode(tmpEstadoTramite);
                            tmpEstadoTramite=tmpEstadoTramite[0];
                            datosTramite.CRETT_NOMBRE= Ext.util.Format.undef(tmpEstadoTramite.CRETT_NOMBRE);
                        }catch(inErr){
                            datosTramite.CRETT_NOMBRE= NO_DATA_MESSAGE;
                        }

                        var scpProceso = new SOAPClientParameters();
                        scpProceso.add('inCrpro_codigo', node.data.myCrpro_codigo);
                        scpProceso.add('format', TypeFormat.JSON);
                        var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
                        try {
                            tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);
                            datosTramite.CRPRO_NOMBRE=tmpCrproRegistro[0].CRPRO_NOMBRE;

                        }catch (inErr) {
                            datosTramite.CRPRO_NOMBRE=NO_DATA_MESSAGE;
                        }

                        datosTramite.CVVEH_CODIGO = node.data.myCvveh_codigo;
                        if(node.data.myCvveh_codigo){
                            datosTramite.VEHICULO ='block';
                        }                       

                        tplInformacionTramite.compile();
                        tplInformacionTramite.overwrite('lblWorkflowInfo',datosTramite);

                    }else{

                        datosSeguimiento.CRSEG_DESCRIPCION = node.data.myCrseg_descripcion;
                        datosSeguimiento.CRSEG_FECHA_DESPACHO=node.data.myCrseg_fecha_despacho;
                        datosSeguimiento.CRSEG_FECHA_RECEPCION = node.data.myCrseg_fecha_recepcion;
                        datosSeguimiento.CRSEG_FECHA_REVISION = node.data.myCrseg_fecha_revision;
                        datosSeguimiento.CRSEG_NUMERO = node.data.myCrseg_numero;
                        datosSeguimiento.CRSEG_TIPO_ACTIVIDAD = node.data.myCrseg_tipo_actividad;
                        datosSeguimiento.CRSEG_OBSERVACION = node.data.myCrseg_observacion;
                        datosSeguimiento.CRSEG_CODIGO = node.data.myCrseg_codigo;

                        var scpUsuario = new SOAPClientParameters();
                        scpUsuario.add('inCusu_codigo',node.data.myCusu_codigo);
                        scpUsuario.add('format',TypeFormat.JSON);
                        var tmpUsuario = SOAPClient.invoke(URL_WS+'Cgg_usuario', 'selectUsuarioPersona', scpUsuario, false, null);
                        try{
                            tmpUsuario = Ext.util.JSON.decode(tmpUsuario);
                            tmpUsuario =tmpUsuario[0];

                            datosSeguimiento.CRPER_NOMBRES =tmpUsuario.CRPER_NOMBRES+' '+tmpUsuario.CRPER_APELLIDO_PATERNO+' '+tmpUsuario.CRPER_APELLIDO_MATERNO+'('+tmpUsuario.CUSU_NOMBRE_USUARIO+')';
                        }catch(inErr){
                            datosSeguimiento.CRPER_NOMBRES =NO_DATA_MESSAGE;
                        }

                        var tmpEstadoAtencion = null;
                        var tmpRespuesta = null;

                        for(var x=0;x<dsEstadoAtencionSeguimiento.length;x++){
                            if(dsEstadoAtencionSeguimiento[x][0]==node.data.myCrseg_estado_atencion){
                                tmpEstadoAtencion = dsEstadoAtencionSeguimiento[x][1];
                            }
                        }

                        for(TipoRespuesta in TypeRespuestaSeguimiento){
                            if(eval('TypeRespuestaSeguimiento.'+TipoRespuesta)==node.data.myCrseg_tipo_respuesta){
                                tmpRespuesta=TipoRespuesta;
                            }
                        }

                        datosSeguimiento.CRSEG_ESTADO_ATENCION=tmpEstadoAtencion;
                        datosSeguimiento.CRSEG_TIPO_RESPUESTA=tmpRespuesta;

                        var scpFase = new SOAPClientParameters();
                        scpFase.add('inCrfas_codigo',node.data.myCrfas_codigo);
                        scpFase.add('format',TypeFormat.JSON);

                        var tmpFase = SOAPClient.invoke(URL_WS+'Cgg_res_fase', 'select', scpFase, false, null);
                        try{
                            tmpFase = Ext.util.JSON.decode(tmpFase);
                            tmpFase = tmpFase[0];
                            datosSeguimiento.CRFAS_NOMBRE = tmpFase.CRFAS_NOMBRE;
                        }catch(inErr){
                            datosSeguimiento.CRFAS_NOMBRE = NO_DATA_MESSAGE;
                        }

                        tplInformacionSeguimiento.compile();
                        tplInformacionSeguimiento.overwrite('lblWorkflowInfo',datosSeguimiento);
                    }
                    Ext.getCmp('pnlWorkflowInfo').getEl().unmask();
                };
                /*label.onmouseover=function(){

            };*/
                //set label styles
                var style = label.style;
                style.width = 60 + 'px';
                style.height = 70 + 'px';
                style.cursor = 'pointer';
                style.color = '#333';
                style.fontSize = '0.8em';
                style.textAlign= 'center';
                style.paddingTop = '3px';
            },
            /* onPlaceLabel: function(label, node) {
            var pos = node.getPos(),
                width = node.getData('width'),
                height = node.getData('height'),
                size = st.canvas.getSize();
//            label.setAttribute("x", pos.x + size.width/2 - width/2);
//            label.setAttribute("y", pos.y + size.height/2);
        },*/
            //This method is called right before plotting
            //a node. It's useful for changing an individual node
            //style properties before plotting it.
            //The data properties prefixed with a dollar
            //sign will override the global node style properties.
            onBeforePlotNode: function(node){
                //add some color to the nodes in the path between the
                //root node and the selected node.
                if (node.selected) {
                    node.data.$color = "#ff7";
                }
                else {
                    delete node.data.$color;
                    //if the node belongs to the last plotted level
                    if(!node.anySubnode("exist")) {
                        //count children number
                        var count = 0;
                        node.eachSubnode(function(n) {
                            count++;
                        });
                        //assign a node color based on
                        //how many children it has
                        node.data.$color = ['#aaa', '#baa', '#caa', '#daa', '#eaa', '#faa'][count];
                    }
                }
            },

            //This method is called right before plotting
            //an edge. It's useful for changing an individual edge
            //style properties before plotting it.
            //Edge data proprties prefixed with a dollar sign will
            //override the Edge global style properties.
            onBeforePlotLine: function(adj){
                if (adj.nodeFrom.selected && adj.nodeTo.selected) {
                    adj.data.$color = "#eed";
                    adj.data.$lineWidth = 3;
                }
                else {
                    delete adj.data.$color;
                    delete adj.data.$lineWidth;
                }
            }
        });
    }
        
    //load json data
    stDiagramaHistorial.loadJSON(json);
    //compute node positions and layout
    stDiagramaHistorial.compute();
    //optional: make a translation of the tree
    stDiagramaHistorial.geom.translate(new $jit.Complex(-200, 0), "current");
    //emulate a click on the root node.            
    stDiagramaHistorial.onClick(stDiagramaHistorial.root, {
        Move: {
            offsetY: 250            
        }
    });
//end
//Add event handlers to switch spacetree orientation.
//    var top = $jit.id('r-top'),
//        left = $jit.id('r-left'),
//        bottom = $jit.id('r-bottom'),
//        right = $jit.id('r-right'),
//        normal = $jit.id('s-normal');
//
//
//    function changeHandler() {
//        if(this.checked) {
//            top.disabled = bottom.disabled = right.disabled = left.disabled = true;
//            st.switchPosition(this.value, "animate", {
//                onComplete: function(){
//                    top.disabled = bottom.disabled = right.disabled = left.disabled = false;
//                }
//            });
//        }
//    };
    
//    top.onchange = left.onchange = bottom.onchange = right.onchange = changeHandler;
//end
   
}