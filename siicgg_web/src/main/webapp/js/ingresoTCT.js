
	  jQuery.noConflict();
	  jQuery(document).ready(function() {
		  jQuery("#chkDatosConyuge").click(function(){
		        if (jQuery(this).is(":checked"))
		        {
		        	jQuery("#divConyuge").show();
		            //setHeightForm();
		            //alert('sii')
		        }
		        else{
		        	jQuery("#divConyuge").hide();}
		        setHeightForm();
		    });
		  
	  });   

	  //Acepta solo numeros
	  function aceptarNumeros(e, field) {
			key = e.keyCode ? e.keyCode : e.which;
			if (key == 8 || key == 46)
				return true;
			
			if (key > 47 && key < 58) {
				return true;
			}
			return false;
		}
	  
function loadIngresoTCT(){		

	function showForm(frm){
		$("divBgModal").style.display="block";
		frm.style.display="block";	
	}
	function btnSalirAll(frm){
		$("divBgModal").style.display="none";
		frm.style.display="none";					
	}
	var tmpObjReglasValidacion = null;
	var cbxAerolinea = $("cbxAerolinea");
	var dtFechaIngreso = $("dtFechaIngreso");
	var dtFechaSalida = $("dtFechaSalida");
	var tblActividad = $("tblActividad");
	var btnAgregar = $("btnAgregar");
	var btnEliminar = $("btnEliminar");
	var txtFechaNacimiento = $("txtFechaNacimiento");
	var btnAceptarIngreso = $("btnAceptarIngreso");
	var btnSalirIngreso = $("btnSalirIngreso");	
	var txtNumeroDocumento = $("txtNumeroDocumento"); 
	var txtNombrePersona = $("txtNombrePersona");
	var txtApellidoPersona = $("txtApellidoPersona");
	var cbmGenero = $("cbmGenero");	
	var txtTipo = $("txtTipo");
	var txtNumeroAut = $("txtNumeroAut");
	var frmPersona = $("frmPersona");
	var btnGuardarTTC = $("btnGuardarTTC");
	var txtCodigoPersona = $("txtCodigoPersona");
	var txtCodigoTramite = $("txtCodigoTramite");
	var frmPersonaRegistro = $("frmPersonaRegistro");
	var txtCodigoEspecie = $("txtCodigoEspecie");
	var btnEditar = $("btnEditar");
	var tblPersona = $("tblPersona");
	//AC->Medio de Transporte
	var cbmMedioTransporte = jQuery("#cbmMedioTransporte");
	//AC->Correo
	var txtCorreoElectronico = $("txtCorreoElectronico");
	var txtConfirCorreoElectronico = $("txtConfirCorreoElectronico");
	//AC->Codigo Postal
	var txtCodigoPostal = $("txtCodigoPostal");
	//AC-> Hospedaje Dinamico
	var btnAgregarHospedaje = $("btnAgregarHospedaje");
	var btnEliminarHospedaje = $("btnEliminarHospedaje");
	var btnAceptarHospedaje = $("btnAceptarHospedaje");
	var btnSalirHospedaje = $("btnSalirHospedaje");
	var frmHospedaje = $("frmHospedaje");
	var tblHospedaje = $("tblHospedaje");
	var dtFechaIngresoHospedaje = $("dtFechaIngresoHospedaje");
	var dtFechaSalidaHospedaje = $("dtFechaSalidaHospedaje");
	dtFechaIngresoHospedaje.value = Date.today().toString("dd/MM/yyyy");
	dtFechaSalidaHospedaje.value = Date.today().toString("dd/MM/yyyy");
	var filaTablaHospedaje = '';
	var lugarHospedaje;
	var lugarHospedajeId;
	var tblEncuesta = $("tblEncuesta");

	var filaTablaPersona = '';
	var posicion = -1;
	var posicionEdit = -1;
	var swEdit = false;
	var swValido = false;
	var tmpCarpt_codigo_origen=null;
	var tmpCusu_nombre;
	var flagValido = true;
	var mensaje;
	dtFechaIngreso.value = Date.today().toString("dd/MM/yyyy");
    dtFechaSalida.value = Date.today().toString("dd/MM/yyyy");
    jQuery("#divNombreHospedaje").show();
	jQuery("#divNombreHospedajeIsla").hide();
	jQuery("#divLugarHospedaje").hide();
    jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
    jQuery('#cbxNombreHospedaje').html('');
	jQuery('#cbxNombreHospedaje').append("<option value='0'>Seleccione un item</option>");
	jQuery("#txtNroVuelo").val('');
	jQuery("#txtNumeroMiembros").val('');
	//jQuery("input:radio[checked=false]");
	jQuery("input[type=radio]").attr('checked', false);

	//Preset
	jQuery("#cbmMedioTransporte").val("AVION");
	jQuery("#cbxOrigenAux").val("0");
	jQuery("#cmbNroVuelo").val("0");
	jQuery("#txtNroVuelo").val("");
	jQuery("#txtTotalDias").val("0");



	//AC--> Encuesta Dinamica
	function CallBackCgg_cargar_encuesta(r){
		var colSize = 4;
		if (jQuery(window).width() < 1350)
			colSize = 3;
		if (jQuery(window).width() < 1065)
			colSize = 2;
		r = eval ("("+r+")");
		var rowNum = tblEncuesta.rows.length-1;
		if(r){
			for(var i=0;i<r.length;i++){
				var pregunta = r[i];
				var tbodyEncuesta = tblEncuesta.tBodies[0];
				//Pregunta
				rowNum+=1;
				var fila =tbodyEncuesta.insertRow(rowNum);
				fila.id = 'filaEncuesta_' + rowNum;
				fila.pregunta = pregunta.codigo;
				fila.preguntaIndex = i;
				fila.preguntaHeader = true;
				fila.tipo = pregunta.tipo;
				var cell = fila.insertCell();
				cell.id = pregunta.codigo;
				cell.innerHTML = pregunta.descripcion;
				cell.colSpan = colSize;

				//Items STAR
				if(pregunta.tipo=="SCORE") {
					rowNum += 1;
					fila = tbodyEncuesta.insertRow(rowNum);
					fila.id = 'filaEncuesta_' + rowNum;
					fila.pregunta = pregunta.codigo;
					for (var j = 0; j < pregunta.items.length; j++) {
						var cellItem = fila.insertCell();
						cellItem.id = "itemEncuesta_" + i + "_" + j;
						cellItem.itemId = ""+pregunta.items[j].codigo;
						cellItem.rateYo = "rateYo_" + i + "_" + pregunta.items[j].codigo;
						cellItem.innerHTML = "<div class='itemContainer'> <div class='itemRateYo' id='rateYo_" + i + "_" + pregunta.items[j].codigo + "'></div> <div class='itemTitle'>" + pregunta.items[j].descripcion + " </div></div>";
						if ((j + 1) % colSize == 0) {//Es multiplo de colSize. Creamos otra fila debajo.
							rowNum += 1;
							fila = tbodyEncuesta.insertRow(rowNum);
							fila.id = 'filaEncuesta_' + rowNum;
							fila.pregunta = pregunta.codigo;
						}
						jQuery("#rateYo_" + i + "_" + pregunta.items[j].codigo).raty({
								number:         4,
								targetType:     'number'
							});
					}
				}else if(pregunta.tipo=="MULTI"){
					rowNum += 1;
					fila = tbodyEncuesta.insertRow(rowNum);
					fila.id = 'filaEncuesta_' + rowNum;
					fila.pregunta = pregunta.codigo;
					for (var j = 0; j < pregunta.items.length; j++) {
						var cellItem = fila.insertCell();
						cellItem.id = "itemEncuesta_" + i + "_" + j;
						cellItem.itemId = ""+pregunta.items[j].codigo;
						cellItem.checkId = "check_" + i + "_" + j;
						cellItem.innerHTML = "<div class='checkContainer'> <input type='checkbox' class='checkItem' id='check_" + i + "_" + j + "' value='"+pregunta.items[j].codigo+"'/> <div class='checkTitle'>" + pregunta.items[j].descripcion + " </div></div>";
						if ((j + 1) % colSize == 0) {//Es multiplo de colSize. Creamos otra fila debajo.
							rowNum += 1;
							fila = tbodyEncuesta.insertRow(rowNum);
							fila.id = 'filaEncuesta_' + rowNum;
							fila.pregunta = pregunta.codigo;
						}
					}
				}else if(pregunta.tipo=="COMBO"){
					rowNum+=1;
					fila =tbodyEncuesta.insertRow(rowNum);
					fila.id = 'filaEncuesta_' + rowNum;
					fila.pregunta = pregunta.codigo;
					var cellItem = fila.insertCell();
					cellItem.id = "itemEncuesta_" + i;
					cellItem.innerHTML ="<select class='selectEncuesta' id='select_"+ i +"'></select>";
					cellItem.colSpan = colSize;
					jQuery("#select_"+ i).append("<option value=''>Seleccione un Item</option>");
					for(var j=0;j<pregunta.items.length;j++){
						jQuery("#select_"+ i).append("<option value='"+pregunta.items[j].codigo+"'>"+pregunta.items[j].descripcion+"</option>");
					}

				}else if(pregunta.tipo=="TEXT"){
					rowNum+=1;
					fila =tbodyEncuesta.insertRow(rowNum);
					fila.id = 'filaEncuesta_' + rowNum;
					fila.pregunta = pregunta.codigo;
					var cellItem = fila.insertCell();
					cellItem.id = "itemEncuesta_" + i;
					cellItem.codigo = pregunta.items[0].codigo;
					cellItem.innerHTML ="<input type='text' maxlength='200' class='inputEncuesta' id='text_"+ i +"'/>";
					cellItem.colSpan = colSize;
				}
			}
		}
	}

	var objEncuesta = null;
	function validarEncuesta(){
		var tbodyEncuesta = tblEncuesta.tBodies[0];
		if(tbodyEncuesta && tbodyEncuesta.rows.length>0){
			objEncuesta = {};
			var tipo;
			var pregunta;
			objEncuesta.preguntas = {};
			for(var i=0;i<tbodyEncuesta.rows.length;i++){
				var fila = tbodyEncuesta.rows[i];
				if(fila.preguntaHeader){
					tipo = fila.tipo;
					pregunta = fila.pregunta;
					var index = fila.preguntaIndex;
					objEncuesta.preguntas[pregunta]={};
					objEncuesta.preguntas[pregunta].values = [];
				}else{
					switch (tipo){
						case "TEXT":
							if(jQuery("#text_"+index).val() && jQuery("#text_"+index).val().length>0)
								objEncuesta.preguntas[pregunta].values.push({"code":fila.cells[0].codigo, "value":jQuery("#text_"+index).val()});
							break;
						case "COMBO":
							if(jQuery("#select_"+index).val() && jQuery("#select_"+index).val().length>0)
								objEncuesta.preguntas[pregunta].values.push({"code":jQuery("#select_"+index).val(), "value":jQuery("#select_"+index).val()});
							break;
						case "MULTI":
							for(var j=0;j<fila.cells.length;j++){
								var col = fila.cells[j];
								var check = document.getElementById(col.checkId);
								if(check && check.checked)
									objEncuesta.preguntas[pregunta].values.push({"code":col.itemId, "value":"true"});
							}
							break;
						case "SCORE":
							for(var j=0;j<fila.cells.length;j++){
								var col = fila.cells[j];
								if(jQuery("#"+col.rateYo).raty('score') &&  jQuery("#"+col.rateYo).raty('score') > 0){
									objEncuesta.preguntas[pregunta].values.push({"code":col.itemId, "value":jQuery("#"+col.rateYo).raty('score')});
								}
							}
							break;
					}
				}
			}
		}
	}

	function encuestaLlena(){
		var llena = true;
		validarEncuesta();
		if(objEncuesta){
			for(var pregunta in objEncuesta.preguntas){
				if(objEncuesta.preguntas[pregunta].values && objEncuesta.preguntas[pregunta].values.length==0){
					jQuery("#"+pregunta).addClass("form-line-error");
					llena=false;
				}
			}
		}
		return llena;
	}

	function cargarEncuesta(){
		SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro", "cargarEncuesta", null, true, CallBackCgg_cargar_encuesta);
	}

	cargarEncuesta();

	btnSalirIngreso.onclick = function(){
		btnSalirAll($("FrmIngresoPersona"));
	};

	btnEditar.onclick = function(){
		if (filaTablaPersona){
			if(posicion>0){
				txtNumeroDocumento.readOnly = true;
				cbxTipoDocumento.dom.value = tblPersona.rows[posicion].cells[0].id;
				cbxNacionalidad.dom.value = tblPersona.rows[posicion].cells[5].id;
				txtNombrePersona.value = tblPersona.rows[posicion].cells[2].innerHTML;
				txtApellidoPersona.value = tblPersona.rows[posicion].cells[3].innerHTML;
				txtNumeroDocumento.value = tblPersona.rows[posicion].cells[1].innerHTML;
				txtFechaNacimiento.value = tblPersona.rows[posicion].cells[6].innerHTML;
				cbmGenero.value = tblPersona.rows[posicion].cells[4].id;
				cbxPaisResidencia.dom.value = tblPersona.rows[posicion].cells[11].id;
				txtCodigoPersona.value = tblPersona.rows[posicion].cells[2].id;
				txtCodigoTramite.value = tblPersona.rows[posicion].cells[12].id;
				txtCodigoEspecie.value = tblPersona.rows[posicion].cells[7].id;				
				swEdit = true;
				btnAceptarIngreso.visibled=false;
				showForm(FrmIngresoPersona);			
			}
		}
	};
	function fnVerificarDatos(){		
		jQuery('.form-line-error').removeClass("form-line-error");
        var isComplete =  true;
        if(jQuery("#cbxCategoria").val()==0)
        {
        	jQuery('#cbxCategoria').addClass("form-line-error");
            isComplete = false;
        }
		if(jQuery("#cbxTipoRegistro").val()==0)
        {
        	jQuery('#cbxTipoRegistro').addClass("form-line-error");
            isComplete = false;
        }

       if(jQuery("#cbxAerolineaAux").val()==0)
        {
        	jQuery('#cbxAerolineaAux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxOrigenAux").val()==0)
        {
        	jQuery('#cbxOrigenAux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxDestinoAux").val()==0)
        {
        	jQuery('#cbxDestinoAux').addClass("form-line-error");
            isComplete = false;
        }

        if(jQuery("#cbxInformacionViaje1Aux").val()==0)
        {
        	jQuery('#cbxInformacionViaje1Aux').addClass("form-line-error");
            isComplete = false;
        }

        if(jQuery("#txtNroVuelo").val().trim()=='' && jQuery("#cmbNroVuelo").val()=='0')
        {
        	jQuery('#txtNroVuelo').addClass("form-line-error");
            isComplete = false;
        }
        
        if(jQuery("#txtNumeroMiembros").val().trim()=='')
        {
        	jQuery('#txtNumeroMiembros').addClass("form-line-error");
            isComplete = false;
        }

        if(!encuestaLlena()){
			isComplete = false;
		}
		
        if(isComplete ==false){
        	new bsxMessageBox({
        		title:'Alerta',
                msg: 'Por favor verifique que todos los datos del formulario hayan sido ingresados correctamente. ',
                icon: "iconInfo"
			});	
        	return false;
        	
        }else{
        	if((jQuery("#cbxInformacionViaje1Aux").val()==16) || (jQuery("#cbxInformacionViaje1Aux").val()==15)){
	        	 if((jQuery("#txtNumeroMiembros").val().trim()=='0') || (jQuery("#txtNumeroMiembros").val().trim()=='1')){
	             	jQuery('#txtNumeroMiembros').addClass("form-line-error");
	            			new bsxMessageBox({
	            				title:"Error de Ingreso",
	            				msg:'El n&uacute;mero de miembros debe ser mayor a 1',
	            				icon:"iconError"
	            			});			
	            	 return false;
	             }
        	}
        	
        	var arrFecha =dtFechaIngreso.value.split('/');
    		var dateIngreso= new Date (arrFecha[2],arrFecha[1],arrFecha[0]);
    		var arrFecha =dtFechaSalida.value.split('/');
    		var dateSalida= new Date (arrFecha[2],arrFecha[1],arrFecha[0]);
        	if(dateSalida<dateIngreso){
    			new bsxMessageBox({
    				title:"Error de Ingreso",
    				msg:'La fecha de salida debe ser mayor o igual a la fecha de ingreso',
    				icon:"iconError"
    			});		
    			return false;
        	}
        	
        }
		return isComplete;
	}
	
	btnAgregar.onclick = function(){
		frmPersona.reset();
		txtNumeroDocumento.readOnly = false;
		swEdit = false;
		showForm($("FrmIngresoPersona"));
		fnHabilitarControles(true);
		btnAceptarIngreso.disabled = true;
	};
	btnEliminar.onclick = function(){
		if(filaTablaPersona){
			var tbodyPersona = tblPersona.tBodies[0];	
			tbodyPersona.removeChild(filaTablaPersona);
			filaTablaPersona='';
		}
	};
	var objIngreso = new JsDatePick({
        useMode:2,
        target:"dtFechaIngreso",
        dateFormat:"%d/%m/%Y",
        imgPath:"../css/image/jsdatepicker/"
		//limitToToday:true
    });
	var objSalida =new JsDatePick({
        useMode:2,
        target:"dtFechaSalida",
        dateFormat:"%d/%m/%Y",
        imgPath:"..images/jsdatepicker/"
		//limitToToday:true
    });
	new JsDatePick({
        useMode:2,
        target:"txtFechaNacimiento",
        dateFormat:"%d/%m/%Y",
        imgPath:"..images/jsdatepicker/"
		//limitToToday:true
    });

	//->AC Hospedaje Dinamico

	btnAgregarHospedaje.onclick = function(){
		frmHospedaje.reset();
		jQuery("#dtFechaIngresoHospedaje").datepicker({
			showOn: 'both',
			buttonImage: 'css/icon/date.gif',
			buttonImageOnly: false,
			appendText: '(dd/mm/yyyy)',
			dateFormat: 'dd/mm/yy',
			defaultDate: Date.parseExact(dtFechaSalida.value,"dd/MM/yyyy"),
			minDate: Date.parseExact(dtFechaSalida.value,"dd/MM/yyyy"),
			maxDate: hospCont >=1 ?Date.parseExact(dtFechaSalida.value,"dd/MM/yyyy"):null,
			changeYear: false,
			changeMonth: false,
			showButtonPanel: false,
			beforeShow: function(input, inst)
			{
				inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
			}
		});
		var limite_dias = jQuery("#cbxTipoRegistro").val() == 1 ? 90:180;
		document.getElementById("dtFechaSalidaHospedaje").disabled = true;
		jQuery("#dtFechaIngresoHospedaje").change(function(v){
			if(jQuery("#dtFechaSalidaHospedaje").datepicker){
				jQuery("#dtFechaSalidaHospedaje").val('');
				jQuery("#dtFechaSalidaHospedaje").datepicker("destroy");
			}
			jQuery("#dtFechaSalidaHospedaje").datepicker({
				showOn: 'both',
				buttonImage: 'css/icon/date.gif',
				buttonImageOnly: false,
				appendText: '(dd/mm/yyyy)',
				dateFormat: 'dd/mm/yy',
				currentText: 'Hoy',
				defaultDate: Date.parseExact(v.target.value,"dd/MM/yyyy").add(1).days(),
				minDate: Date.parseExact(v.target.value,"dd/MM/yyyy").add(1).days(),
				maxDate: Date.parseExact(dtFechaIngreso.value,"dd/MM/yyyy").add(limite_dias).days(),
				changeYear: false,
				changeMonth: true,
				showButtonPanel: false,
				nextText: 'Siguiente',
				prevText: 'Anterior',
				beforeShow: function(input, inst)
				{
					inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
				}
			});
			document.getElementById("dtFechaSalidaHospedaje").disabled = false;
		});

		showForm($("FrmIngresoHospedaje"));
	};
	btnEliminarHospedaje.onclick = function(){
		if(filaTablaHospedaje && filaTablaHospedaje.id=="tr_"+(tblHospedaje.rows.length-2)){
			var tbodyHospedaje = tblHospedaje.tBodies[0];
			tbodyHospedaje.removeChild(filaTablaHospedaje);
			filaTablaHospedaje='';
			hospCont--;
			if(hospCont==0){
				dtFechaIngreso.value = Date.today().toString("dd/MM/yyyy");
				dtFechaSalida.value = Date.today().toString("dd/MM/yyyy");
			}else{
				var fila = tblHospedaje.rows[hospCont];
				dtFechaSalida.value = fila.cells[4].id;
			}
			calculaTotalDias();
		}else{
			new bsxMessageBox({
				title:"Validaci\u00f3n",
				msg:"<span>Por favor elimine el hospedaje desde el \u00f1ltimo registro</span>",
				icon:"iconError"
			});
		}
	};

	function verificaHospedaje(){
		jQuery('.form-line-error').removeClass("form-line-error");
		var isComplete =  true;
		if(jQuery("#cbxTipoHospedaje").val()==0){
			jQuery('#cbxTipoHospedaje').addClass("form-line-error");
			isComplete = false;
		}
		if(jQuery("#cbxTipoHospedaje").val()==102){
			if(jQuery("#cbxNombreHospedaje").val()==0){
				jQuery('#cbxNombreHospedaje').addClass("form-line-error");
				isComplete = false;
			}
		}else if(jQuery("#cbxTipoHospedaje").val()==104){
			if(jQuery("#cbxNombreHospedajeIsla").val()==0){
				jQuery('#cbxNombreHospedajeIsla').addClass("form-line-error");
				isComplete = false;
			}
			if(jQuery("#cbxIslaHospedaje").val()==0){
				jQuery('#cbxIslaHospedaje').addClass("form-line-error");
				isComplete = false;
			}

		}else if(jQuery("#cbxTipoHospedaje").val()==103){
			if(jQuery("#divLugarHospedaje").val().trim()==''){
				jQuery('#divLugarHospedaje').addClass("form-line-error");
				isComplete = false;
			}
			if(jQuery("#cbxIslaHospedaje").val()==0){
				jQuery('#cbxIslaHospedaje').addClass("form-line-error");
				isComplete = false;
			}
		}
		if(jQuery("#dtFechaIngresoHospedaje").val().trim()==''){
			jQuery('#dtFechaIngresoHospedaje').addClass("form-line-error");
			isComplete = false;
		}
		if(jQuery("#dtFechaSalidaHospedaje").val().trim()==''){
			jQuery('#dtFechaSalidaHospedaje').addClass("form-line-error");
			isComplete = false;
		}

		if(isComplete ==false){
			new bsxMessageBox({
				title:'Alerta',
				msg: 'Por favor verifique que todos los datos del formulario hayan sido ingresados correctamente.',
				icon: "iconInfo"
			});
			return false;

		}

		return isComplete;
	}

	btnAceptarHospedaje.onclick = function () {
		if(verificaHospedaje()) {
			fnLlenarHospedaje();
			jQuery("#dtFechaIngresoHospedaje").datepicker("destroy");
			jQuery("#dtFechaSalidaHospedaje").datepicker("destroy");
			calculaTotalDias();
		}
	};

	function calculaTotalDias(){
		var txtTotalDias = 0;
		var tbodyHospedaje = tblHospedaje.tBodies[0];
		for(var i=0;i<tbodyHospedaje.rows.length;i++){
			var fila = tbodyHospedaje.rows[i];
			if(fila.cells[5] && fila.cells[5].id && fila.cells[5].id.toString().startsWith("dias_")){
				txtTotalDias += parseInt(fila.cells[5].innerHTML);
			}
		}
		jQuery("#txtTotalDias").val(txtTotalDias);
	}

	btnSalirHospedaje.onclick = function () {
		btnSalirAll($("FrmIngresoHospedaje"));
	};
	var numeroDiasHospedaje = 0;
	jQuery("#dtFechaSalidaHospedaje").change(function(v){
		var oneDay = 24*60*60*1000;
		var entrada = jQuery("#dtFechaIngresoHospedaje").val();
		var salida = v.target.value;//jQuery("#dtFechaSalidaHospedaje").val();
		numeroDiasHospedaje = Math.round(Math.abs((Date.parseExact(salida,"dd/MM/yyyy").getTime() - Date.parseExact(entrada,"dd/MM/yyyy").getTime())/(oneDay)));
	});

	var hospCont = 0;
	var posicionHosp;
	function fnLlenarHospedaje(){
		var tbodyHospedaje = tblHospedaje.tBodies[0];
		var fila =tbodyHospedaje.insertRow(tblHospedaje.rows.length-1);
		fila.id = 'tr_'+hospCont;
		fila.onclick = function(){
			filaTablaHospedaje = this;
			posicionHosp = this.sectionRowIndex+1;
			for (var i=1;i<tblHospedaje.rows.length;i++) {
				tblHospedaje.rows[i].className = "rowNoSelectTable";
			}
			this.className="rowSelectTable";

		};
		if(hospCont==0)
			dtFechaIngreso.value = jQuery("#dtFechaIngresoHospedaje").val();

		hospCont++;

		var celda= fila.insertCell(0);
		celda.id = cbxTipoHospedaje.dom.value;
		celda.innerHTML = cbxTipoHospedaje.dom.options[cbxTipoHospedaje.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(1);
		celda.id = cbxIslaHospedaje.dom.value;
		celda.innerHTML = cbxIslaHospedaje.dom.value=="0"?"No Aplica":cbxIslaHospedaje.dom.options[cbxIslaHospedaje.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(2);
		celda.id = lugarHospedajeId;
		celda.innerHTML = lugarHospedaje;
		celda.width = 110;

		celda= fila.insertCell(3); //FECHA DE INGRESO
		celda.id = jQuery("#dtFechaIngresoHospedaje").val();
		celda.innerHTML = jQuery("#dtFechaIngresoHospedaje").val();
		celda.width = 80;

		celda= fila.insertCell(4); //FECHA SALIDA
		celda.id = jQuery("#dtFechaSalidaHospedaje").val();
		celda.innerHTML = jQuery("#dtFechaSalidaHospedaje").val();
		celda.width = 80;

		celda= fila.insertCell(5);// NUMERO DE DIAS
		celda.id = "dias_"+numeroDiasHospedaje;
		celda.innerHTML = numeroDiasHospedaje;
		celda.width = 80;

		numeroDiasHospedaje = 0;
		dtFechaSalida.value = jQuery("#dtFechaSalidaHospedaje").val();
		btnSalirAll($("FrmIngresoHospedaje"));
	}

	btnAceptarIngreso.onclick = function(){	
		//btnAceptarIngreso.disabled=true;
		if(cbxTipoDocumento.dom.value == 1){
			if (validarCedula(txtNumeroDocumento.value) == false){
				new bsxMessageBox({
					title:"N\u00famero de c\u00E9dula inv\u00E1lido",
					msg:'En n\u00famero ingresado es inv\u00E1lido, por favor ingrese un n\u00f1mero v\u00E1lido para continuar',
					icon:"iconError"
				});
				return;
			}
		}
		var swVerificado = false;
		if(trim(txtNumeroDocumento.value)==0){				
			txtNumeroDocumento.focus();
			swVerificado=false;
		}else if(trim(txtNombrePersona.value)==0){				
			txtNombrePersona.focus();
			swVerificado=false;
		}else if(trim(txtApellidoPersona.value)==0){				
			txtApellidoPersona.focus();
			swVerificado=false;
		}else if(txtFechaNacimiento.value.length==0){
			txtFechaNacimiento.focus();
			swVerificado = false;
		}else{
			swVerificado = true;
		}
		if(cbxEstadoCivil.dom.value==0){
			swVerificado = false;
			//cbxEstadoCivil.focus();
		}
		if(txtCorreoElectronico.value && txtCorreoElectronico.value.length>0 && txtCorreoElectronico.value == txtConfirCorreoElectronico.value){
			swVerificado = true;
		}else{
			txtCorreoElectronico.focus();
			swVerificado = false;
			mensaje = "Hay problemas validando el correo electronico.";
		}
		if (swVerificado == true && flagValido == true){
			fnLlenarPersona();
		}else{
			new bsxMessageBox({
				title:"Error validaci\u00f3n",
				msg:'<span>No se puede realizar el registro de la persona.!!</span>'+mensaje,
				icon:"iconError"
			});	
		}
	};
	$("btnVerificar").onclick=function(){
		if (cbxTipoDocumento.dom.value == 1 && validarCedula(txtNumeroDocumento.value) == false){
			
			new bsxMessageBox({
				title:"N\u00famero de documento inv\u00E1lido",
				msg:'El n\u00famero de documento es inv\u00E1lido, por favor intente nuevamente con un n\u00famero de documento v\u00E1lido',
				icon:"iconError",
				close:function(){
					txtNumeroDocumento.focus();
				}
			});
			txtNombrePersona.value = '';			
			txtApellidoPersona.value = '';
			txtFechaNacimiento.value = '';			
			return;
		}
		consultarPersona();	
	};
	
	txtNumeroDocumento.onkeypress = function (event){
		fnHabilitarControles(true);
		fnLimpiarControles();	
        if (event.which == '13') {
            if (cbxTipoDocumento.dom.value == 1 && validarCedula(txtNumeroDocumento.value) == false){			
				
				new bsxMessageBox({
					title:"N\u00famero de documento inv\u00E1lido",
					msg:'El n\u00famero de documento es inv\u00E1lido, por favor intente nuevamente con un n\u00famero de documento v\u00E1lido',
					icon:"iconError",
					close:function(){
						txtNumeroDocumento.focus();
					}
				});
					
				return;
			}
			consultarPersona();		
        }
    };
	function fnLimpiarControles(){
		txtNombrePersona.value = '';			
		txtApellidoPersona.value = '';
		txtFechaNacimiento.value = '';	
	}
	txtNumeroDocumento.onchange = function (){			                    
		fnLimpiarControles();		
    };
	
	btnGuardarTTC.onclick = function(){
		btnGuardarTTC.disabled=false;
		if (fnVerificarDatos()==true){			
			if(tblPersona.rows.length<=1){
				new bsxMessageBox({
					title:"Pre-registro TCT",
					msg:"Para enviar la informaci\u00f3n por favor a\u00f1ada por lo menos una persona.",
					icon:"iconError"
				});	
				btnGuardarTTC.disabled=false;
				return
			}
				
			var jsonPersona = '[';
			var i=0;
			var textos='';
			for (var i=1;i<tblPersona.rows.length;i++) {
				var genero = '0';
				if (tblPersona.rows[i].cells[4].innerHTML == 'M'){
					genero = '0';
				}else{
					genero = '1';
				}
				var a = (tblPersona.rows[i].cells[6].innerHTML).split('/');
				var fechaNac = a[2]+'-'+a[1]+'-'+a[0]+'T00:00:00';
				jsonPersona += ((i==1)?'':',')+'{"CRDID_CODIGO":"'+tblPersona.rows[i].cells[0].id+'","CGNCN_CODIGO":"'+tblPersona.rows[i].cells[5].id+'",'+
				'"CRPER_NOMBRES":"'+tblPersona.rows[i].cells[2].innerHTML+'",'+
				'"CRPER_APELLIDO_PATERNO":"'+tblPersona.rows[i].cells[3].innerHTML+'",'+
				'"CRPER_NUM_DOC_IDENTIFIC":"'+tblPersona.rows[i].cells[1].innerHTML+'",'+
				'"CRPER_FECHA_NACIMIENTO":"'+fechaNac+'",'+
				'"CRPER_GENERO":"'+genero+'",'+
				'"CGG_CPAIS_CODIGO":"'+tblPersona.rows[i].cells[11].id+'",'+
				'"CRPER_CODIGO":"'+tblPersona.rows[i].cells[2].id+'",'+
				'"CRTRA_CODIGO":"'+tblPersona.rows[i].cells[12].id+'",'+
				'"CKESP_CODIGO":"'+tblPersona.rows[i].cells[7].id+'",'+
				'"CRPRC_CONTACTO":"'+tblPersona.rows[i].cells[13].id+'",'+
				'"CTREG_OBSERVACION":" "}';
			}
			jsonPersona += ']';

			var jsonHospedaje = '[';
			i=0;
			for (var i=1;i<tblHospedaje.rows.length;i++) {
				jsonHospedaje += ((i==1)?'':',')+'{'+
					'"tipoHospedaje":"'+tblHospedaje.rows[i].cells[0].id+'",'+
					'"codigoIsla":"'+tblHospedaje.rows[i].cells[1].id+'",'+
					'"lugarHospedaje":"'+tblHospedaje.rows[i].cells[2].id+'",'+
					'"fechaIngreso":"'+tblHospedaje.rows[i].cells[3].id+'",'+
					'"fechaSalida":"'+tblHospedaje.rows[i].cells[4].id+'"'+
					//',"reserva":"'+tblHospedaje.rows[i].cells[6].id+'+'" +
					'}';
			}
			jsonHospedaje += ']';

			function CallBackCgg_tct_registro(r) {			
				r = eval ("("+r+")");
				if(r.success){
					new bsxMessageBox({
						title:"Pre-registro TCT",
						msg:"La informaci\u00f3n del Pre-Registro ha sido almacenada. Gracias por utilizar nuestros servicios en l\u00ednea",
						icon:"iconOk",
						close:function(){
							btnGuardarTTC.disabled=false;
							//document.location = 'inicio.jsp?CWPAG_CODIGO=CWPAG1';
						}
					});	
					frmPersonaRegistro.reset();
					var tbodyPersona = tblPersona.tBodies[0];
					var totalFilas = tblPersona.rows.length;
					for (var i=totalFilas-1;i>=1;i--) {					
						tbodyPersona.removeChild(tblPersona.rows[i]);
					}
					var tbodyHospedaje = tblHospedaje.tBodies[0];
					totalFilas = tblHospedaje.rows.length;
					for (var i=totalFilas-1;i>=1;i--) {
						tbodyHospedaje.removeChild(tblHospedaje.rows[i]);
					}
					var tbodyEncuesta = tblEncuesta.tBodies[0];
					totalFilas = tblEncuesta.rows.length;
					for (var i=totalFilas-1;i>=1;i--) {
						tbodyEncuesta.removeChild(tblEncuesta.rows[i]);
					}
					//document.location = 'ingresoTCT.jsp';
					loadIngresoTCT();
				}else{
					new bsxMessageBox({
						title:"Pre-registro TCT",
						msg:'La informaci\u00f3n del Pre- Registro no ha podido ser almacenada. ' + (r.message?r.message:r),
						icon:"iconError"
					});			
					btnGuardarTTC.disabled=false;
				}
			}
			
			var param = new SOAPClientParameters();		
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1;
			var yyyy = today.getFullYear();		
			if (mm<10)	mm = '0'+mm;		
			if (dd<10)	dd = '0'+dd;		
			var fechaPreregsitro = yyyy+'-'+mm+'-'+dd+'T00:00:00';
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0]+'T00:00:00';			
			arrFecha = dtFechaSalida.value.split('/');
			var fechaSalida = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0]+'T00:00:00';	

			param.add('inCarpt_codigo', cbxOrigenAux.dom.value);
			param.add('inCgg_carpt_codigo', cbxDestinoAux.dom.value);
			param.add('inCraln_codigo', cbxAerolineaAux.dom.value);
			param.add('inCtreg_numero', null);		
			param.add('inCtreg_fecha_preregistro',fechaPreregsitro);
			param.add('inCtreg_fecha_ingreso',fechaIngreso);
			param.add('inCtreg_codigo_barras', 0);
			param.add('inCtreg_fecha_salida', fechaSalida);
			param.add('inCtreg_categoria', cbxCategoria.dom.value );
			param.add('inCtreg_tipo_registro', cbxTipoRegistro.dom.value);
			param.add('inCtreg_vuelo', jQuery("#txtNroVuelo").val());
			param.add('inCtreg_viaje_acompanante', cbxInformacionViaje1Aux.dom.value);
			param.add('inCtreg_viaje_miembros', jQuery("#txtNumeroMiembros").val());
			param.add('inPersona_JSON', jsonPersona);
			param.add('inHospedaje_JSON', jsonHospedaje);
			param.add('inEncuesta_JSON',objEncuesta!=null?JSON.stringify(objEncuesta):null);
			SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro", "insertLite", param, true, CallBackCgg_tct_registro);
		}else
			btnGuardarTTC.disabled=false;
	};

	/*
	 *Creación de un combobox para Estado Civil
	 */
	var cbxEstadoCivil = new bsxComboBox({
		id:"cbxEstadoCivil",
		renderTo:"tdEstadoCivil",
		displayField:"CRECV_DESCRPCION",
		valueField:"CRECV_CODIGO",
		webService:{
			url:URL_WS+"Cgg_res_estado_civil",
			method:"selectAll",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxEstadoCivil').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxEstadoCivil").val(0);
			}
		}
	});
	cbxEstadoCivil.reload();


	
	/*
	 *Creación de un combobox para Categoría
	 */
	var cbxCategoria = new bsxComboBox({
		id:"cbxCategoria",
		renderTo:"tdCategoria",
		displayField:"TCTCAT_NOMBRE",
		valueField:"TCTCAT_CODIGO",
		webService:{
			url:URL_WS+"Cgg_tct_categoria",
			method:"selectAll",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				//jQuery('#cbxCategoria').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxCategoria").val(1);
			}
		}
	});
	cbxCategoria.reload();

	/*
	 *Creación de un combobox para Tipo de Registro
	 */
	var cbxTipoRegistro = new bsxComboBox({
		id:"cbxTipoRegistro",
		renderTo:"tdTipoRegistro",
		displayField:"TCTTR_NOMBRE",
		valueField:"TCTTR_CODIGO",
		webService:{
			url:URL_WS+"Cgg_tct_tipo_registro",
			method:"selectAll",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				//jQuery('#cbxTipoRegistro').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoRegistro").val(1);
			}
		}
	});
	cbxTipoRegistro.reload();

	/*
	* AC--> Obtencion de los datos de Transporte para mejorar el dinamismo
	* */
	var tctTransporte = {};

	SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro", "getTctTransporte", null, true, function(v){
		tctTransporte = eval("("+v+")");
	});

	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxAerolineaAux = new bsxComboBox({
		id:"cbxAerolineaAux",		
		renderTo:"tdAereolinea",		
		displayField:"CRALN_NOMBRE",
		valueField:"CRALN_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aerolinea",
			method:"selectAllRelated",
			params:[
				{name:"format",value:"JSON"},
				{name:"tipo",value:cbmMedioTransporte.val()}
			]
		},		
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxAerolineaAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxAerolineaAux").val(0);
			}
		}
	});	
	cbxAerolineaAux.reload();

	var transItems = [];
	cbxAerolineaAux.dom.onchange = function(v){
		if(cbxAerolineaAux.dom.value != "0")
			document.getElementById("vueloDetail").style.display="table-row";
		else
			document.getElementById("vueloDetail").style.display="none";

		transItems = [];
		for(var i=0;i<tctTransporte.length;i++){
			if(tctTransporte[i].codigoAerolinea==v.target.value){
				transItems.push(tctTransporte[i]);
			}
		}
		if(transItems.length>0){
			var cmbNroVuelo = document.getElementById("cmbNroVuelo");
			document.getElementById("txtNroVuelo").style.display='none';
			document.getElementById("cbxDestinoAux").disabled = true;
			cmbNroVuelo.style.display='block';
			//Borramos todos los items previamente
			jQuery("#cmbNroVuelo").empty();
			jQuery("#cmbNroVuelo")
				.append("<option value='0'>Seleccione un Item</option>");
			for(var i=0;i<transItems.length;i++){
				jQuery("#cmbNroVuelo")
					.append("<option value='"+transItems[i].vuelo+"'>"+transItems[i].vuelo+"</option>");
			}
		}else{
			document.getElementById("txtNroVuelo").style.display='block';
			document.getElementById("cmbNroVuelo").style.display='none';
			document.getElementById("cbxDestinoAux").disabled = false;
			jQuery("#cbxDestinoAux").val(0);
		}
	};

	cbmMedioTransporte.change(function(v){
		cbxAerolineaAux.params=[	{name:"format",value:"JSON"},
									{name:"tipo",value:v.target.value}];
		cbxAerolineaAux.reload();

		jQuery("#cbxAerolineaAux").val(0).trigger('change');
	});

	jQuery("#cmbNroVuelo").change(function(v){
		jQuery("#txtNroVuelo").val(v.target.value);
		for(var i=0;i<transItems.length;i++){
			if(transItems[i].vuelo == v.target.value){
				jQuery("#cbxDestinoAux").val(transItems[i].codigoAeropuerto);
			}
		}
	});

	/*
	*Creacion de un combobox para los origenes de las aereolineas
	*/
	var cbxOrigenAux = new bsxComboBox({
		id:"cbxOrigenAux",
		renderTo:"tdOrigen",		
		displayField:"CARPT_NOMBRE",
		valueField:"CARPT_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aeropuerto",
			method:"selectDirectByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCarpt_tipo_aereopuerto",value:0}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxOrigenAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxOrigenAux").val(0);
			}
		}
	});	
	cbxOrigenAux.reload();
	/*
	*Creacion de un combobox para los destinos de la aereolineas
	*/
	var cbxDestinoAux = new bsxComboBox({
		id:"cbxDestinoAux",
		renderTo:"tdDestino",		
		displayField:"CARPT_NOMBRE",
		valueField:"CARPT_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aeropuerto",
			method:"selectDirectByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCarpt_tipo_aereopuerto",value:1}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxDestinoAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxDestinoAux").val(0);
			}
		}
	});	
	cbxDestinoAux.reload();
	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxTipoDocumento = new bsxComboBox({
		id:"cbxTipoDocumento",
		renderTo:"tdTipoDocumento",		
		displayField:"CRDID_DESCRIPCION",
		valueField:"CRDID_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_documento_identificacio",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxTipoDocumento').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoDocumento").val(0);
			}
		}	
	});	
	cbxTipoDocumento.reload();
	
	cbxTipoDocumento.dom.onchange = function(){		
		fnLimpiarControles();
		fnHabilitarControles(true);
		txtNumeroDocumento.value = '';
		txtNumeroDocumento.focus();
	};
	/*
	*Creacion de un combobox para las nacionalidades
	*/
	var cbxPaisResidencia = new bsxComboBox({
		id:"cbxPaisResidencia",
		renderTo:"tdPaisResidencia",		
		displayField:"CPAIS_NOMBRE",
		valueField:"CPAIS_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_pais",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxPaisResidencia').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxPaisResidencia").val(0);
			}
		}
	});	
	cbxPaisResidencia.reload();
	/*
	*Creacion de un combobox para las nacionalidades
	*/
	var cbxNacionalidad = new bsxComboBox({
		id:"cbxNacionalidad",
		renderTo:"tdNacionalidad",		
		displayField:"CGNCN_NACIONALIDAD",
		valueField:"CGNCN_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_nacionalidad",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxNacionalidad').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxNacionalidad").val(0);
			}
		}	
	});	
	cbxNacionalidad.reload();
	
	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxConfiguracion = new bsxComboBox({
		id:"cbxConfiguracion",
		renderTo:"tdConfiguracion",		
		displayField:"CGCNF_VALOR_CADENA",
		valueField:"CGCNF_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_configuracion",
			method:"select",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCgcnf_codigo",value:"CONF35"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxConfiguracion').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxConfiguracion").val(0);
			}
		}
	});	
	cbxConfiguracion.reload();

	/*
	 *Creacion de un combobox para la isla de hospedaje
	 */

	var cbxIslaHospedaje = new bsxComboBox({
		id:"cbxIslaHospedaje",
		renderTo:"divIslaHospedaje",
		displayField:"CISLA_NOMBRE",
		valueField:"CISLA_CODIGO",
		webService:{
			url:URL_WS+"Cgg_isla",
			method:"selectAllAtencionCliente",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxIslaHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxIslaHospedaje").val(0);
			}
		}
	});
	cbxIslaHospedaje.reload();

	/*
	 *Creacion de un combobox para el tipo de hospedaje
	 */

	var cbxTipoHospedaje = new bsxComboBox({
		id:"cbxTipoHospedaje",
		renderTo:"divTipoHospedaje",
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"9"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxTipoHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoHospedaje").val(0);
			}
		}
	});
	cbxTipoHospedaje.reload();

	/*
	 *Creacion de un combobox para el nombre de hospedaje
	 */

	var cbxNombreHospedaje = new bsxComboBox({
		id:"cbxNombreHospedaje",
		renderTo:"divNombreHospedaje",
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"8"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxNombreHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxNombreHospedaje").val(0);
			}
		}
	});

	cbxNombreHospedaje.dom.onchange = function(v){
		lugarHospedajeId = cbxNombreHospedaje.dom.value;
		lugarHospedaje = cbxNombreHospedaje.dom.options[cbxNombreHospedaje.dom.selectedIndex].text;
	};

	
	var cbxNombreHospedajeIsla = new bsxComboBox({
		id:"cbxNombreHospedajeIsla",
		renderTo:"divNombreHospedajeIsla",
		displayField:"CDISHO_NOMBRE",
		valueField:"CDISHO_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_isla_hotel",
			method:"selectByIsland",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_isla_codigo",value:""}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxNombreHospedajeIsla').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxNombreHospedajeIsla").val(0);
			}
		}
	});

	cbxNombreHospedajeIsla.dom.onchange = function(v){
		lugarHospedajeId = cbxNombreHospedajeIsla.dom.value;
		lugarHospedaje = cbxNombreHospedajeIsla.dom.options[cbxNombreHospedajeIsla.dom.selectedIndex].text;
	};

	/*
	*Creacion de un combobox para la informacion del viaje - usted esta viajando con
	*/
	var cbxInformacionViaje1Aux = new bsxComboBox({
		id:"cbxInformacionViaje1Aux",
		renderTo:"tdInformacionViaje1",		
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"4"}
			]
		},
		width: '80%',
		events:{
			load:function(v){
				jQuery('#cbxInformacionViaje1Aux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxInformacionViaje1Aux").val(0);
			}
		}
	});	
	cbxInformacionViaje1Aux.reload();

	function fnHabilitarControles(estado){
		txtNombrePersona.readOnly = estado;
		txtApellidoPersona.readOnly = estado;
		txtFechaNacimiento.disabled = estado;
		cbmGenero.disabled = estado;
	}
	
	function consultarPersona()
    {	   flagValido = true; 
			$("divInfoValidacion").style.display = "block";
			btnAceptarIngreso.disabled = true;			
			function CallBackCgg_tct_persona(r){
				var tmpselect = eval('('+r+')');
				var personaExists = false;
				//tmpselect.length== 0 )
				if(tmpselect.length>0){
					personaExists = tmpselect[0].CRPER_CODIGO!=null;
				}

				if (!personaExists) {
					txtNombrePersona.focus();
					txtNombrePersona.value = tmpselect.length > 0 ? (tmpselect[0].CRPER_NOMBRES?tmpselect[0].CRPER_NOMBRES:'') : '';
					txtApellidoPersona.value = tmpselect.length > 0 ? (tmpselect[0].CRPER_APELLIDO_PATERNO?tmpselect[0].CRPER_APELLIDO_PATERNO:'') : '';
					var numeroIdentificacion = txtNumeroDocumento.value;
					txtCodigoPersona.value = '';
					cbxNacionalidad.dom.value = tmpselect.length > 0 ? tmpselect[0].CGNCN_CODIGO : null;
					cbxPaisResidencia.dom.value = tmpselect.length > 0 ? tmpselect[0].CGG_CPAIS_CODIGO : null;
					if (tmpselect.length > 0) {
						var fecha = tmpselect[0].CRPER_FECHA_NACIMIENTO.split(' ');
						var b = fecha[0].split('-');
						var fechaNacimiento = b[2] + '/' + b[1] + '/' + b[0];
						txtFechaNacimiento.value = fechaNacimiento;
					}
					txtCodigoTramite.value = '';
					txtCodigoEspecie.value = '';					
					txtNumeroDocumento.value = numeroIdentificacion;
					fnHabilitarControles(false);
					btnAceptarIngreso.disabled = false;
					$("divInfoValidacion").style.display = "none";
				}else{
					fnHabilitarControles(true);
					txtCodigoPersona.value=tmpselect[0].CRPER_CODIGO;					
					txtNombrePersona.value = tmpselect[0].CRPER_NOMBRES;
					txtApellidoPersona.value= tmpselect[0].CRPER_APELLIDO_PATERNO;				  
				    var tmps= (tmpselect[0].CRPER_GENERO+" ").trim();
					if (tmps.length>0)
						cbmGenero.value = tmpselect[0].CRPER_GENERO;
					
					cbxNacionalidad.dom.value = tmpselect[0].CGNCN_CODIGO;
					cbxPaisResidencia.dom.value = tmpselect[0].CGG_CPAIS_CODIGO;
					if(tmpselect[0].CKESP_CODIGO)
						txtCodigoEspecie.value=tmpselect[0].CKESP_CODIGO;
					else
						txtCodigoEspecie.value = cbxConfiguracion.dom.value;

					var fecha = tmpselect[0].CRPER_FECHA_NACIMIENTO.split(' ');
					var b = fecha[0].split('-');
					var fechaNacimiento = b[2]+'/'+b[1]+'/'+b[0];
					txtFechaNacimiento.value = fechaNacimiento;
					txtCodigoTramite.value = (tmpselect[0].CRTRA_CODIGO)?tmpselect[0].CRTRA_CODIGO:'';
					var numero_tramite = tmpselect[0].CRTRA_NUMERO;
					txtTipo.value=tmpselect[0].TIPO_RESIDENCIA;						
					if(numero_tramite){
						txtTipo.value = 'TRANSEUNTE';
					}else{
						txtTipo.value='TURISTA';
					}
					//AC-> Correo
					if(tmpselect[0].CRPRC_CONTACTO) {
						txtCorreoElectronico.value = tmpselect[0].CRPRC_CONTACTO;
						txtConfirCorreoElectronico.value = tmpselect[0].CRPRC_CONTACTO;
						txtCorreoElectronico.readOnly=true;
						txtConfirCorreoElectronico.readOnly=true;
						txtCorreoElectronico.disabled=true;
						txtConfirCorreoElectronico.disabled=true;
					}else{
						txtCorreoElectronico.readOnly=false;
						txtConfirCorreoElectronico.readOnly=false;
						txtCorreoElectronico.disabled=false;
						txtConfirCorreoElectronico.disabled=false;
					}

					validarReglas(txtCodigoPersona.value);
				}
             

            }

			//Limpiamos los campos por consultas previas:
			txtCodigoPersona.value="";
			txtNombrePersona.value = "";
			txtApellidoPersona.value= "";
			cbxNacionalidad.dom.value = "0";
			cbxPaisResidencia.dom.value = "0";
			txtCorreoElectronico.value="";
			txtConfirCorreoElectronico.value="";
			txtFechaNacimiento.value="";
			txtCodigoTramite.value ="";
			txtCodigoEspecie.value ="";
			txtCodigoPostal.value="";

            var param = new SOAPClientParameters();
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0];			
            param.add('inCrper_num_doc_identific',txtNumeroDocumento.value);
			param.add('inCrdid_codigo',cbxTipoDocumento.dom.value);
            param.add('inCtreg_fecha_ingreso',fechaIngreso+'T00:00:00');
            param.add('format','JSON');
            SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro",'selectPersonaTct',param, true, CallBackCgg_tct_persona);
     
    }

	var cont = 1;
	function fnLlenarPersona(){
		var tbodyPersona = tblPersona.tBodies[0];
		if(swEdit==false){
			if(tblPersona.rows.length>1){
				for (var i=1;i<tblPersona.rows.length;i++) {
					if(tblPersona.rows[i].cells[1].innerHTML == txtNumeroDocumento.value){					
						new bsxMessageBox({
							title:"Error de ingreso",
							msg:'La persona ya pertenece al listado de pre-registro.',
							icon:"iconError"
						});	
						return;
					}				
				}
			}
		}else{
			tblPersona.rows[posicion].cells[0].id = cbxTipoDocumento.dom.value;
			tblPersona.rows[posicion].cells[5].id = cbxNacionalidad.dom.value;
			tblPersona.rows[posicion].cells[2].innerHTML = txtNombrePersona.value;
			tblPersona.rows[posicion].cells[3].innerHTML = txtApellidoPersona.value;
			tblPersona.rows[posicion].cells[1].innerHTML = txtNumeroDocumento.value;
			tblPersona.rows[posicion].cells[6].innerHTML = txtFechaNacimiento.value;
			tblPersona.rows[posicion].cells[4].id = cbmGenero.value;
			if(cbmGenero.value == 0){				
				tblPersona.rows[posicion].cells[4].innerHTML = 'M';
			}else{
				tblPersona.rows[posicion].cells[4].innerHTML = 'F';				
			}
			tblPersona.rows[posicion].cells[11].id = cbxPaisResidencia.dom.value;
			tblPersona.rows[posicion].cells[2].id = txtCodigoPersona.value;
			
			tblPersona.rows[posicion].cells[7].id = txtCodigoEspecie.value;
			tblPersona.rows[posicion].cells[5].innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[7].innerHTML = cbxConfiguracion.dom.options[cbxConfiguracion.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[0].innerHTML = cbxTipoDocumento.dom.options[cbxTipoDocumento.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[11].innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
			
			tblPersona.rows[posicion].cells[12].id = (txtCodigoTramite.value)?txtCodigoTramite.value:"";			
			tblPersona.rows[posicion].cells[12].innerHTML = txtCodigoTramite.value;

			tblPersona.rows[posicion].cells[13].innerHTML = txtCorreoElectronico.value;
			tblPersona.rows[posicion].cells[14].innerHTML = txtCodigoPostal.value;

			swEdit = false;
			btnSalirAll($("FrmIngresoPersona"));
			
			return;
		}
		var fila =tbodyPersona.insertRow(tblPersona.rows.length-1);
		fila.id = 'tr'+cont;
		fila.onclick = function(){		
			filaTablaPersona = this;
			posicion = this.sectionRowIndex+1;
			for (var i=1;i<tblPersona.rows.length;i++) {							
					tblPersona.rows[i].className = "rowNoSelectTable";								
			}
			this.className="rowSelectTable";
			
		};
		
		cont++;

		var celda= fila.insertCell(0);
		celda.id = cbxTipoDocumento.dom.value;
		celda.innerHTML = cbxTipoDocumento.dom.options[cbxTipoDocumento.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(1);		
		celda.innerHTML = txtNumeroDocumento.value;
		celda.width = 80;

		celda= fila.insertCell(2);	
		celda.id = txtCodigoPersona.value;
		celda.innerHTML = txtNombrePersona.value;
		celda.width = 110;

		celda= fila.insertCell(3);
		celda.innerHTML = txtApellidoPersona.value;
		celda.width = 110;
		
		celda= fila.insertCell(4);
		if(cbmGenero.value == 0){
			celda.id = '0';
			celda.innerHTML = 'M';
		}else{
			celda.innerHTML = 'F';
			celda.id = '1';
		}
		celda.width = 40;
		
		celda= fila.insertCell(5);
		celda.id = cbxNacionalidad.dom.value;
		celda.innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(6);
		celda.innerHTML = txtFechaNacimiento.value;
		celda.width = 100;

		celda= fila.insertCell(7);
		celda.style.display = "none";
		celda.id = cbxConfiguracion.dom.selectedIndex;
		celda.innerHTML = cbxConfiguracion.dom.options[cbxConfiguracion.dom.selectedIndex].text;
	
		celda= fila.insertCell(8);
		celda.style.display = "none";
		celda.innerHTML = 'PREREGISTRADA';

		celda= fila.insertCell(9);
		celda.style.display="none";
		celda.innerHTML = txtTipo.value;

		celda= fila.insertCell(10);
		celda.style.display = "none";
		celda.innerHTML = txtNumeroAut.value;
		
		celda= fila.insertCell(11);
		celda.style.display = "none";
		celda.id = cbxPaisResidencia.dom.value;
		celda.innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
		
		celda= fila.insertCell(12);
		celda.style.display = "none";
		celda.id = (txtCodigoTramite.value)?txtCodigoTramite.value:"";
		celda.innerHTML = txtCodigoTramite.value;

		celda= fila.insertCell(13);
		celda.id = (txtCorreoElectronico.value)?txtCorreoElectronico.value:"";
		celda.innerHTML = txtCorreoElectronico.value;

		celda= fila.insertCell(14);
		celda.id = (txtCodigoPostal.value)?txtCodigoPostal.value:"";
		celda.innerHTML = txtCodigoPostal.value;

		btnSalirAll($("FrmIngresoPersona"));		
	}
	function CallBackReglasTipoSolicitud(r)
	{
		try
		{			
			tmpObjReglasValidacion  = r;		
		}
		catch(inErr)
		{			
			tmpObjReglasValidacion =[];
		}

	}
	var param = new SOAPClientParameters();
	param.add('inCopvl_formulario','FrmCgg_tct_registro');
	param.add('format','JSON');
	SOAPClient.invoke(URL_WS+'PublicWS/Cgg_regla_validacion' ,'selectOperacionValidacionByForm',param, true,CallBackReglasTipoSolicitud);
	/*
     * Funcion encargada de obtener los valores definidos en cada una de las reglas de validacion
     * */

    function evaluarReglasValidacion(objReglasValidacion1)
    {
        for(var i=0;i<objReglasValidacion1.length;i++)
        {           
            var objTmp =  eval('('+objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION+')')[0]; 
            for (var key in objTmp) {
                objTmp[key] = eval(objTmp[key]);
            }
            objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION ='['+JSON.stringify(objTmp)+']';
        }
        return (JSON.stringify(objReglasValidacion1));

    }
	
	
	/*
     * Funcion definida para invocar el proceso de validacion
     *
     * */
    function validarReglas(codigoPersona)
    {
	btnAceptarIngreso.disabled = true;	
            function CallBackCgg_regla_validacion(r){                
				var validacion = eval('('+r+')');    
				
				if(validacion.resultadoValidacion != undefined){
					if(validacion.resultadoValidacion == 'false'){
						mensaje = '<table style="font-size:12">';
						var j=1;
						for(i=0;i<validacion.dataSet.length;i++){								
							if(validacion.dataSet[i].CRVAL_APROBADO == 'FALSE'){
								mensaje += '<tr><th>'+j+'</th><td>'+validacion.dataSet[i].CRVAL_SUGERENCIA+'</td></tr>'
								j++;
							}
						}
						mensaje += '</table>';							
						new bsxMessageBox({
							title:"Error validaci\u00f3n",
							msg:'<span>No se puede realizar el registro de la persona.!!</span>'+mensaje,//+tplNotificacion.apply(validacion.dataSet),
							icon:"iconError",
							close:function(){
								flagValido = false;
								btnAceptarIngreso.disabled = false;
								$("divInfoValidacion").style.display = "none";									
							}
						});	
						
					}else{						
						flagValido = true;	
						btnAceptarIngreso.disabled = false;	
						$("divInfoValidacion").style.display = "none";
					}
				}
            }            
			tmpCarpt_codigo_origen = cbxAerolineaAux.dom.value;
			tmpNumeroDocumento = txtNumeroDocumento.value;
			tmpCrper_codigo = codigoPersona?codigoPersona:'';
			tmpCusu_nombre = null;
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0];		

			tmpFechaIngreso = fechaIngreso+'T00:00:00';
//dtFechaIngreso.value.format(TypeDateFormat.ISO8601Long);

            objReglasValidacion  = eval('('+tmpObjReglasValidacion+')');/*Ext.decode(tmpObjReglasValidacion);*/
            var param = new SOAPClientParameters();
			var jsonevalualRegla = evaluarReglasValidacion(objReglasValidacion);			
            param.add('inJSON_reglas_validacion',jsonevalualRegla);
			param.add('jsonData',null);
            SOAPClient.invoke(URL_WS+'PublicWS/Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, true, CallBackCgg_regla_validacion);
    }
	setHeightForm();
	jQuery("#cbxInformacionViaje1Aux").change(function() {
		  var tipo = jQuery(this).val();
		  if(tipo == 13){
			  jQuery("#txtNumeroMiembros").val(1);
			  jQuery("#txtNumeroMiembros").attr('disabled', true);
		  } else if(tipo == 14){
			  jQuery("#txtNumeroMiembros").val(2);
			  jQuery("#txtNumeroMiembros").attr('disabled', true);
		  } else if((tipo == 15)||(tipo == 16)||(tipo == 0)){
			  jQuery("#txtNumeroMiembros").val(0);
			  jQuery("#txtNumeroMiembros").attr('disabled', false);
		  } 
		 
	});
	
	
	
	jQuery("#cbxTipoHospedaje").change(function() {
		  var tipo = jQuery(this).val();
		  if(tipo == 102){//CRUCERO
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#cbxIslaHospedaje").attr('disabled', true);
			  jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
			  jQuery("#divNombreHospedaje").show();
			  jQuery("#divNombreHospedajeIsla").hide();
			  jQuery("#divLugarHospedaje").hide();
			  jQuery("#divLugarHospedaje").val('');
			  cbxNombreHospedaje.reload();
		  } else if(tipo == 104){//HOTEL
			  jQuery("#cbxIslaHospedaje").attr('disabled', false); 
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
			  jQuery("#divNombreHospedaje").hide();
			  jQuery("#divNombreHospedajeIsla").show();
			  jQuery("#divLugarHospedaje").hide();
			  jQuery('#cbxNombreHospedajeIsla').html('');
			  jQuery('#cbxNombreHospedajeIsla').append("<option value='0'>Seleccione un item</option>");
			  jQuery("#divLugarHospedaje").val('');
		  }else{//DOMICILIO AMIGO/FAMILIAR
			  jQuery("#cbxIslaHospedaje").attr('disabled', false); 
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#labelHospedaje").html("* Lugar de hospedaje");
			  jQuery("#divNombreHospedaje").hide();
			  jQuery("#divNombreHospedajeIsla").hide();
			  jQuery("#divLugarHospedaje").show();
			  jQuery("#divLugarHospedaje").val('');
		  }
		 
	});
	
	
	jQuery("#cbxIslaHospedaje").change(function() {
		var tipo = jQuery(this).val();
		cbxNombreHospedajeIsla.setParam('in_isla_codigo',tipo);
		cbxNombreHospedajeIsla.reload();
		
	});
	
}
	
