function loadrequisitosTipoSolicitud(){

    /**
     * VARIABLES PARA ASIGNAR A LOS COMPONENTES HTML
     */

    var codigoSolicitud = null;
    var urlReport = null;
    var TypeTramite = {//INFORMACION REFERENTE A LOS PARAMETROS DE CONFIGURACION
        RESIDENCIA:'13',
        VEHICULOS:'12'
    };
    /* Add an onclick handler for the movie template items */
	function menuClick(){
		document.getElementById('tmpMensaje').innerHTML = "<img src='css/icon/cargando.gif'/> &nbsp;Por favor espere...";		
        var tmpCodigo = null;
        tmpCodigo = this.id;
		var cadena = this.textContent;
        codigoSolicitud = tmpCodigo;
        var tmplItem = $.tmplItem(this);
        function callBackListadoRequisitos(r){
            var tmpRespuestaTramite = eval('('+r+')');
            if(tmpRespuestaTramite.length>0)
            {
				if((tmpRespuestaTramite[0].REQUISITOS.length>0)){
					$("#divTipoSolicitud").html('<div><b> Residencia:</b> '+(tmplItem.data.CRTST_DESCRIPCION||"") + ' - ' + tmpRespuestaTramite[0].REQUISITOS[0].CRTST_DESCRIPCION+'</div><br>'+
							'<div><button id="btnImprimirRequisitos" title="Reporte"><img src="css/icon/printer2.png"/> &nbsp;Generar reporte  </button></div>');
					$("#divFrmListadoRequisitos").html($.tmpl( "requisitosTemplate", tmpRespuestaTramite ));
					$('#btnImprimirRequisitos').click(function(){
						printSolicitud();
					});
				}else{
					$("#divTipoSolicitud").html('<b> Residencia:</b> '+(tmplItem.data.CRTST_DESCRIPCION||"") + ' - '+cadena);//tmplItem.data.TIPOSOLICITUD[0].CRTST_DESCRIPCION);
					$("#divFrmListadoRequisitos").html('');
					//$('#btnImprimirRequisitos').hide();
				}
            }
			document.getElementById('tmpMensaje').innerHTML ="";         
        }
        var param = new SOAPClientParameters();
        param.add('inCrtst_codigo',tmpCodigo);
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+'PublicWS/Cgg_res_solicitud_requisito','selectTipo_solicitud_tramite_all',param, true,callBackListadoRequisitos);
    }


    function consultarSolicitudes(){
        var params= new SOAPClientParameters();
        params.add('inCgcnf_codigo',TypeTramite.RESIDENCIA);
        params.add('format',TypeFormat.JSON);
        var tmpRespuesta = SOAPClient.invoke(URL_WS+'PublicWS/Cgg_res_tipo_solicitud_tramite','selectAllTipoSolicitudATC',params, false,null);
        try{
            var tmpRespuestaTramite = eval('('+tmpRespuesta+')');
            if(tmpRespuestaTramite.length>0)
            {
                 var dtsMenu = tmpRespuestaTramite[0].MENU;
				crearMenu(dtsMenu);
            }

        }catch(inErr){

        }

    };
	
	function crearMenu(dts){
		var events1 = "";
		var strMenu ='<ul class="sf-menu">';
        var title1 = null;
		for (i=0;i<dts.length;i++){
			strMenu+='<li style = "width:150px">'+
			'<a href="#">'+dts[i].CRTST_DESCRIPCION+'</a> ';
			if (dts[i].TIPOSOLICITUD){
				var dts1 =dts[i].TIPOSOLICITUD;
				strMenu +='<ul>';
				for (i1=0;i1<dts1.length;i1++){
					if (dts1[i1].TIPOSOLICITUDFINAL){
						strMenu+='<li id ="'+dts1[i1].CRTST_CODIGO+'">';
						strMenu+='<a href="#">'+dts1[i1].CRTST_DESCRIPCION+'</a> ';
						strMenu+='<span class="sf-sub-indicator"></span>';					
						var dts2 =dts1[i1].TIPOSOLICITUDFINAL;
						strMenu +='<ul>';
						for (i2=0;i2<dts2.length;i2++){
                            title1 = dts2[i2].CRTST_OBSERVACION.replace(/"/g,'');
							strMenu+='<li id ="'+dts2[i2].CRTST_CODIGO+'" title="'+title1+'">';
							events1+='document.getElementById("'+dts2[i2].CRTST_CODIGO+'").onclick = menuClick; ';
							strMenu+='<a href="#" >'+dts2[i2].CRTST_DESCRIPCION+'</a> '+
							'</li>';			
						}
						strMenu+='</ul>';
					}else{
                        title1 = dts1[i1].CRTST_OBSERVACION.replace(/"/g,'');
						strMenu+='<li id ="'+dts1[i1].CRTST_CODIGO+'" title="'+title1+'">';
						events1+='document.getElementById("'+dts1[i1].CRTST_CODIGO+'").onclick = menuClick;';
						strMenu+='<a href="#" >'+dts1[i1].CRTST_DESCRIPCION+'</a> ';
					}
					strMenu+='</li>';			
				}
				strMenu+='</ul>';
			}
			strMenu+='</li>';			
		}
		strMenu+='</ul>';
		$("#divMenu").html(strMenu);
		eval(events1);
		jQuery(function(){
			jQuery('ul.sf-menu').superfish();
		});
	}
    consultarSolicitudes();

    $.template(
            "requisitosTemplate",
            '<table id="tableRequisitos"  border="0"  cellspacing="0" cellpadding="5" style="font-size:11px; border:1px solid #CCCCCC;">'+
				'<thead >'+
					' <tr>'+
						'<th style="width:3%">#</th>'+
						'<th style="width:25%">Requisito</th>'+
						'<th style="width:25%">Descripcion</th>'+
						'<th style="width:15%">Participante</th>'+
                        '<th style="width:10%">Obligatorio</th>'+
					'</tr>'+
				'</thead>'+
				'{{each REQUISITOS}}'+
                    '<tr >'+						
						'<td style="width:3%;height:auto" > ${$index+1}</td>'+
						'<td style="width:25%">${CRREQ_DESCRIPCION}</td>'+
						'<td style="width:25%">${CRSRQ_DESCRIPCION}</td>'+
						'<td style="width:15%">${CRSRQ_PARTICIPANTE}</td>'+
                        '<td style="width:10%">${CRSRQ_REQUERIDO}</td>'+
                    '</tr>'+
                '{{/each}}'+
            '</table>'
            );

    function printSolicitud(){
        if(codigoSolicitud){
            urlReport = new Reporte('rptListadoRequisitosporTipoSolicitud','/Reports/sii/atencionalcliente',{P_CRTST_CODIGO:codigoSolicitud});
            urlReport.show();
        }else
            alert('Por favor seleccione un tipo de solicitud para continuar.');
    }

     function printPlantilla(){
        if(codigoSolicitud)
        {
            urlReport = new Reporte('rptSolicitudesResidenciaPermanente','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:'',P_CRTST_CODIGO:codigoSolicitud});
            urlReport.show();
        }
        else
        {
            alert('Por favor seleccione un tipo de solicitud para continuar.');
        }
    }    
	setHeightForm();
}
	