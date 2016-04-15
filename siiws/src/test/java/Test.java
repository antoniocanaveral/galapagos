import com.besixplus.sii.ws.Cgg_configuracion;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dirExportable=new Cgg_configuracion().select("CONFDIREXP","JSON");
		System.out.print(dirExportable);
		//new Cgg_res_tipo_tramite().insert("k1", "z1");
		//new Cgg_res_tipo_tramite().selectPage(0,30,"CRTPT_NOMBRE","ASC","","JSON");
		//System.out.print(new Cgg_res_requisito().selectAll("JSON"));
		//		System.out.print(new Cgg_res_tipo_solicitud_tramite().insertTipoSolicitudTramite(
		//					"CRTST1",
		//					"CRTPT1",
		//					"CRPRO2",
		//					null,
		//					"Art. 26",
		//					"Residencia para familiares",
		//					false,
		//					true,
		//					false,
		//					false,
		//					false,
		//					false,
		//					0,
		//					false,
		//					false,
		//					false,
		//					"[{\"CRSRQ_CODIGO\":\"KEYGEN\",\"CRTSR_CODIGO\":\"KEYGEN\",\"CRREQ_CODIGO\":\"CRREQ3\",\"CRSRQ_DESCRIPCION\":\"\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":2},{\"CRSRQ_CODIGO\":\"KEYGEN\",\"CRTSR_CODIGO\":\"KEYGEN\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Actualizada\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1},{\"CRSRQ_CODIGO\":\"KEYGEN\",\"CRTSR_CODIGO\":\"KEYGEN\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Actualizada\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0}]",
		//					"[]",
		//					"[]"));

		//		System.out.print(new Cgg_res_tipo_solicitud_tramite().updateTipoSolicitudTramite(
		//					"CRTST5", 
		//					"CRTST1", 
		//					"CRTPT1", 
		//					"CRPRO2",
		//					"",
		//					"Art. 26",
		//					"Residencia para familiares",
		//					false, 
		//					true, 
		//					false,
		//					false, 
		//					false, 
		//					false, 
		//					0, 
		//					false,
		//					false,
		//					false,
		//					1,
		//					"[{\"CRSRQ_CODIGO\":\"CRSRQ1\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ3\",\"CRSRQ_DESCRIPCION\":\"\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":2},{\"CRSRQ_CODIGO\":\"CRSRQ2\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Actualizada\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1},{\"CRSRQ_CODIGO\":\"CRSRQ3\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Actualizada\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0}]", 
		//					"[]",
		//					"[]"));
		//System.out.print(new Cgg_res_tipo_solicitud_tramite().selectPage(0, 30, "CRTST_CODIGO", "ASC", "","JSON"));
		//System.out.print(new Cgg_res_solicitud_requisito().selectCgg_res_tipo_solicitud_tramite("CRTST4", "JSON"));
		//System.out.print(new Cgg_res_garantia_solicitud().selectCgg_res_tipo_solicitud_tramite(null, "JSON"));*/
		//System.out.print(new Cgg_res_requisito_tramite().selectTramiteTipoSolcitudRequisito("CRTRA52","CRTST5","JSON"));
		//System.out.print(new Cgg_res_requisito_tramite().selectRequisitoAdjunto("CRTST10","CRTRA49","JSON"));		
		/*Magic parser = new Magic() ;
		MagicMatch match;
		try {
			match = parser.getMagicMatch(new File("hola.pdf"),false);
			System.out.print(match.getMimeType());
		} catch (MagicParseException e) {

			e.printStackTrace();
		} catch (MagicMatchNotFoundException e) {

			e.printStackTrace();
		} catch (MagicException e) {

			e.printStackTrace();
		}*/

		/*Cgg_res_adjunto objAdjunto = new Cgg_res_adjunto();
		objAdjunto.setCRADJ_CODIGO("KEYGEN");
		objAdjunto.setCRADJ_NOMBRE_ADJUNTO("hola.gif");
		objAdjunto.setCRADJ_ARCHIVO_ADJUNTO(new byte[0]);

		Cgg_res_adjunto objAdjunto1 = new Cgg_res_adjunto();
		objAdjunto1.setCRADJ_CODIGO("KEYGEN");
		objAdjunto1.setCRADJ_NOMBRE_ADJUNTO("mundo.gif");
		objAdjunto1.setCRADJ_ARCHIVO_ADJUNTO(new byte[0]);

		ArrayList<Cgg_res_adjunto> objTmp = new ArrayList<Cgg_res_adjunto>();
		objTmp.add(objAdjunto);
		objTmp.add(objAdjunto1);*/
		/*Date date1 = null;
		 String pattern = "dd/MM/yyyy";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    try {
		      date1 = format.parse("03/03/2012");

		    } catch (ParseException e) {
		      e.printStackTrace();
		    }

		String outResult = new Cgg_res_tramite().registrarTramite(
				"CPSNCRT34828", 
				"CPJR6", 
				"CRPER375850", 
				"CRPRO4", 
				"CRTST34", 
				"KEYGEN", 
				"CISLA1", 
				null, 
				null, 
				null, 
				null,
				"Ejemplo de observacion",
				0, 
				false, 
				null, 
				null, 
				new BigDecimal(1), 
				null, 
				"[]", 
				"[]",				
				"[]", 
				null,
				date1,
				null, 
				null, 
				null,
				null);
		System.out.print(outResult);*/
		//[{\"CRREQ_DESCRIPCION\":\"Papeleta de votacion\",\"CRSRQ_DESCRIPCION\":\"\",\"CRRQT_CUMPLE\":null,\"CRTST_CODIGO\":\"CRTST25\",\"CRSRQ_REQUERIDO\":true,\"CRREQ_CODIGO\":\"CRREQ16\",\"CRRQT_CODIGO\":null,\"CRSRQ_CODIGO\":\"CRSRQ19\",\"CRTRA_CODIGO\":null,\"CRRQT_OBSERVACION\":null,\"CRSRQ_PARTICIPANTE\":1},{\"CRREQ_DESCRIPCION\":\"Cedula\",\"CRSRQ_DESCRIPCION\":\"\",\"CRRQT_CUMPLE\":null,\"CRTST_CODIGO\":\"CRTST25\",\"CRSRQ_REQUERIDO\":true,\"CRREQ_CODIGO\":\"CRREQ13\",\"CRRQT_CODIGO\":null,\"CRSRQ_CODIGO\":\"CRSRQ20\",\"CRTRA_CODIGO\":null,\"CRRQT_OBSERVACION\":null,\"CRSRQ_PARTICIPANTE\":0}]


		//Connection con = ManagerConnection.getConnection();
		/*com.besixplus.sii.objects.Cgg_res_tramite objTra = new com.besixplus.sii.objects.Cgg_res_tramite();
		objTra.setCRTRA_CODIGO("KEYGEN");*/

		//		System.out.print(new Cgg_res_requisito_tramite().selectTramiteTipoSolcitudRequisito("CRTST25",null,"JSON"));
		//		try {
		//			System.out.print(new Cgg_res_fase().selectCGG_RES_PROCESO("CRPRO2","CISLA1", "JSON"));
		//		} catch (SOAPException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//System.out.print(new Cgg_res_proceso().select("CRPRO11", "JSON"));
		//System.out.print(new Cgg_res_fase().selectCGG_RES_FASE1("CRFAS1", "JSON"));
		//		System.out.print(new Cgg_res_tramite().selectHistorialTramite("CRTRA82", "JSON"));
		//System.out.print(new Cgg_res_tramite().selectPageHistorial(0, 30, "CRTRA_FECHA_RECEPCION", "DESC", "", "JSON"));
		//System.out.print(new Cgg_res_informe_seguimiento().selectCGG_RES_SEGUIMIENTO("CRSEG185", "JSON"));
		//System.out.print(new Cgg_res_novedad_notificacion().selectCGG_RES_SEGUIMIENTO("CRSEG156", "JSON"));
		//System.out.print(new Cgg_res_tipo_solicitud_tramite().selectPage(0, 30, "CGG_CRTSR_CODIGO", "ASC", "", "JSON"));
		//System.out.print(new com.besixplus.sii.ws.Cgg_res_tipo_solicitud_tramite().eliminarTipoSolicitudTramite("CRTST9"));
		//System.out.print(new Cgg_res_adjunto().selectCGG_RES_SEGUIMIENTO1("CRSEG168", "JSON"));		
		//System.out.print(new Cgg_res_novedad_notificacion().selectCGG_RES_SEGUIMIENTO("CRSEG168", "JSON"));
		//System.out.print(new Cgg_jur_seguimiento_criterio().selectSEGUIMIENTO_CRITERIO("CRSEG64", "CRFAS2", "JSON"));
		//System.out.print(new Cgg_jur_seguimiento_criterio().insertarCriterios("CRSEG64", "[{\"CJSGC_CODIGO\":\"CJSGC3\",\"CRSEG_CODIGO\":\"CRSEG64\",\"CJCRI_CODIGO\":\"CJCRI2\",\"CJSGC_RESPUESTA\":true,\"CJSGC_JUSTIFICACION\":\"en verdad si cumple\",\"CJSGC_OBSERVACION\":\"\",\"CJSGC_NOMBRE_ADJUNTO\":\"\",\"CJCRI_REQUERIMIENTO\":\"Documentacion completa\",\"CJCRI_REQUERIDO\":true},{\"CJSGC_CODIGO\":\"CJSGC4\",\"CRSEG_CODIGO\":\"CRSEG64\",\"CJCRI_CODIGO\":\"CJCRI3\",\"CJSGC_RESPUESTA\":\"\",\"CJSGC_JUSTIFICACION\":\"\",\"CJSGC_OBSERVACION\":\"\",\"CJSGC_NOMBRE_ADJUNTO\":\"\",\"CJCRI_REQUERIMIENTO\":\"Informe de criterio juridico\",\"CJCRI_REQUERIDO\":true}]"));
		//System.out.print(new Cgg_regla_validacion().selectFuncionPlSql("JSON"));
		//System.out.print(new Cgg_res_seguimiento().envioSeguimiento("CRSEG88", "[{\"CRFAS_CODIGO\":\"CRFAS3\",\"CRPRO_CODIGO\":\"CRPRO1\",\"CRETT_CODIGO\":\"\",\"CGG_CRETT_CODIGO\":\"\",\"CRSEC_CODIGO\":\"CRSEC3\",\"CGG_CRFAS_CODIGO\":\"CRFAS2\",\"CGG_CUSU_CODIGO\":\"\",\"CRFAS_NOMBRE\":\"Seguimiento de parejas\",\"CRFAS_ORDEN\":0,\"CRFAS_TAREA_REALIZA\":\"Informe de estado de parejas\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\" a\",\"CUSU_CODIGO\":\"2\"},{\"CRFAS_CODIGO\":\"CRFAS4\",\"CRPRO_CODIGO\":\"CRPRO1\",\"CRETT_CODIGO\":\"CRETT2\",\"CGG_CRETT_CODIGO\":\"CRETT3\",\"CRSEC_CODIGO\":\"CRSEC2\",\"CGG_CRFAS_CODIGO\":\"CRFAS2\",\"CGG_CUSU_CODIGO\":\"\",\"CRFAS_NOMBRE\":\"Analisis Jurtidico\",\"CRFAS_ORDEN\":0,\"CRFAS_TAREA_REALIZA\":\"Brindara soporte juridico al tramite\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\" s\",\"CUSU_CODIGO\":\"2\"}]"));
		//System.out.print(new Cgg_res_seguimiento().revisionSeguimiento("CRSEG70"));
		//System.out.print(new Cgg_res_persona().selectPageLite(0, 30, "CRPER_CODIGO", "asc", "", "JSON"));
		//System.out.print(new Cgg_res_seguimiento().selectCount1());
		//eSystem.out.print(new Cgg_jur_seguimiento_criterio().selectSEGUIMIENTO_CRITERIO("CRSEG119", "CRFAS15", "JSON"));
		//System.out.print( new Cgg_res_tramite().selectHistorialTramite("CRTRA20", "JSON"));
		//System.out.print( new Cgg_usuario().selectUsuarioPersona("CUSU43", "JSON"));
		//		System.out.print(new Cgg_regla_validacion().selectReglaLiteParametros("JSON")); 

		//System.out.print(new Cgg_res_tramite().selectPageDirect1(0, 30, "CRTRA_NUMERO", "ASC", "61", "JSON"));
		//System.out.print(new Cgg_res_seguimiento().enviarSeguimiento("CRSEG167", 4, null, 1));
		//System.out.print(new Cgg_res_seguimiento().despacharSeguimientoHijo("CRSEG166", 1));
		//System.out.print(new Cgg_res_seguimiento().dejarPendiente("CRSEG166"));
		//System.out.print(new Cgg_res_tramite().registrarTramiteTranseunte("388"	, null, null, "CRPRO5", "CRTST1", null, "CISLA1", null, null, "buscando a nemo","niinguan", 1, false, null, null, new BigDecimal(0), new Date(), new Date(), new Date(), "[{\"CRTRA_CODIGO\":\"\",\"CRPER_CODIGO\":\"KEYGEN\",\"CRECV_CODIGO\":\"CRECV1\",\"CRDID_CODIGO\":\"CRDID1\",\"CGNCN_CODIGO\":\"\",\"CRPER_NOMBRES\":\"Klever \",\"CRPER_APELLIDO_PATERNO\":\"Lascano \",\"CRPER_APELLIDO_MATERNO\":\"SUMBANA\",\"CRPER_NUM_DOC_IDENTIFIC\":\"0103897955\",\"CRPER_FECHA_NACIMIENTO\":\"08/08/2010\",\"CRPER_LUGAR_NACIMIENTO\":\"\",\"CRPER_GENERO\":0,\"CRPER_REQUISITOS_JSON\":\"[{\\\"CRSRQ_CODIGO\\\":\\\"CRSRQ1\\\",\\\"CRTSR_CODIGO\\\":\\\"\\\",\\\"CRREQ_CODIGO\\\":\\\"CRREQ1\\\",\\\"CRSRQ_DESCRIPCION\\\":\\\"11111111111111\\\",\\\"CRSRQ_REQUERIDO\\\":true,\\\"CRSRQ_PARTICIPANTE\\\":0,\\\"CRRQT_CODIGO\\\":\\\" \\\",\\\"CRTRA_CODIGO\\\":\\\" \\\",\\\"CRRQT_CUMPLE\\\":true,\\\"CRRQT_OBSERVACION\\\":\\\" asdfasdf\\\"}]\"}]", "[{\"CRFAS_CODIGO\":\"CRFAS13\",\"CRPRO_CODIGO\":\"CRPRO5\",\"CRETT_CODIGO\":\"CRETT6\",\"CGG_CRETT_CODIGO\":null,\"CRSEC_CODIGO\":\"CRSEC3\",\"CGG_CRFAS_CODIGO\":null,\"CGG_CUSU_CODIGO\":null,\"CRFAS_NOMBRE\":\"FASE DE ANALISIS DE CRITERIO\",\"CRFAS_ORDEN\":1,\"CRFAS_TAREA_REALIZA\":\"SE ANALIZAN LOS DOCUMENTOS\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\" mundo\",\"CUSU_CODIGO\":\"1\"}]", "2", null, null, null, null));
		//System.out.print(new Cgg_res_fase().selectFaseSiguiente("CRFAS27", "JSON"));
		//System.out.print(new Cgg_res_voto().insert("[{CRRES_CODIGO\"CRRES8\\\",CRTRA_CODIGO\"CRTRA75\\\",CRSMB_CODIGO\"CRSMB1\\\"}]", 1, 0, 0, "Observacion"));
		//System.out.print(new Cgg_res_tipo_solicitud_tramite().iniciaTipoSolicitudTramite("CRTST5", "CUSU5"));
		//System.out.print(new Cgg_gem_vacante().verificarComunicado(1));
		//System.out.print(new Cgg_res_tramite().selectPageEstadoIsla(0, 30, "CRTRA_FECHA_RECEPCION", "DESC", "", "CISLA1", "CRETT4", "JSON"));
		//System.out.print(new Cgg_res_residencia().generarResidencia("CRTRA11", 0));
		/*try {
			System.out.print(new Cgg_regla_validacion().ejecutarReglaTipoSolicitud("[{\"CRVAL_APROBADO\":\"FALSE\",\"CRVAL_VALOR_2\":null,\"CRVAL_USUARIO_UPDATE\":\"recepcion\",\"CRVAL_VALOR_1\":null,\"CRVAR_FECHA_FIN\":\"2011-04-09 00:00:00.0\",\"CRVAL_FUNCION_VALIDACION\":\"F_RESIDENTE_OBSERVADO\",\"CRVAL_OPERADOR_COMPARADOR\":\"=\",\"CRVAL_DESCRIPCION\":\"Verifica si una residente esta observado\",\"CRVAL_ESTADO\":true,\"CRVAR_FECHA_INICIO\":\"2011-04-09 00:00:00.0\",\"CRVAL_CODIGO\":\"CRVAL8\",\"CRTSE_CAMPO_EVALUACION\":\"[{\\\"IN_CRPER_CODIGO\\\":\\\"1103\\\"}]\",\"CRVAL_VALOR_LIBRE\":\"TRUE\",\"CRVAL_TIPO\":1,\"CRVAL_SUGERENCIA\":\"El auspiciante del tramite se encuentra observado por lo que primero debe de acercarse a las oficinas del CGG a normalizar su situacion.\",\"CRVAL_FECHA_INSERT\":\"2011-04-09 14:46:37.85179\",\"CRVAL_USUARIO_INSERT\":\"recepcion\",\"CRVAL_FECHA_UPDATE\":\"2011-04-09 14:46:37.85179\",\"CGCNF_CODIGO\":null,\"CRVAL_NOMBRE\":\"Residente observado\",\"CRVAL_RESULTADO_ACEPTACION\":\"TRUE\"}]"));
		} catch (SOAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//System.out.println(new Cgg_tct_registro().selectTranseunteOffline("JSON"));		
		//System.out.println(new Cgg_tct_registro().selectDiaPermanenciaOffline("JSON"));
		//System.out.println(new Cgg_tct_registro().selectNotificadoOffline("JSON"));

		//System.out.println(new Cgg_res_fase_usuario().selectUsuariosFase("CRFAS5","CISLA1","JSON"));

		//		Date date1 = null;
		//		Date date2 = null;
		//		 String pattern = "dd/MM/yyyy";
		//		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		//		    try {
		//		      date1 = format.parse("01/01/2011");
		//		      date2 = format.parse("31/01/2011");
		//		      
		//		    } catch (ParseException e) {
		//		      e.printStackTrace();
		//		    }
		//		
		//		System.out.println(new Cgg_res_tramite().registrarTramiteTranseunte(
		//				null, 
		//				"CRPJR2", 
		//				null, 
		//				"CRPRO3", 
		//				"CRTST7", 
		//				null, 
		//				"CISLA1", 
		//				null, 
		//				null, 
		//				"CGCRG1", 
		//				"JOLL", 
		//				90, 
		//				true, 
		//				null, 
		//				null, 
		//				new BigDecimal(0), 
		//				date1, 
		//				date2, 
		//				"[{\"CRTRA_CODIGO\":\"\",\"CRPER_CODIGO\":\"KEYGEN\",\"CRECV_CODIGO\":\"CRECV1\",\"CRDID_CODIGO\":\"1\",\"CGNCN_CODIGO\":\"\",\"CRPER_NOMBRES\":\"Davis \",\"CRPER_APELLIDO_PATERNO\":\"orozco\",\"CRPER_APELLIDO_MATERNO\":\"orozco\",\"CRPER_NUM_DOC_IDENTIFIC\":\"01010122552\",\"CRPER_FECHA_NACIMIENTO\":\"24/01/1855\",\"CPAIS_CODIGO\":\"Colombia\",\"CRPER_GENERO\":0,\"CRPER_REQUISITOS_JSON\":\"[{\\\"CRSRQ_CODIGO\\\":\\\"CRSRQ5\\\",\\\"CRTSR_CODIGO\\\":\\\"\\\",\\\"CRREQ_CODIGO\\\":\\\"CRREQ1\\\",\\\"CRSRQ_DESCRIPCION\\\":\\\"\\\",\\\"CRSRQ_REQUERIDO\\\":true,\\\"CRSRQ_PARTICIPANTE\\\":0,\\\"CRRQT_CODIGO\\\":\\\" \\\",\\\"CRTRA_CODIGO\\\":\\\" \\\",\\\"CRRQT_CUMPLE\\\":true,\\\"CRRQT_OBSERVACION\\\":\\\" \\\",\\\"CRATE_DATA\\\":\\\"\\\"}]\"}]", 
		//				"[{\"CRFAS_CODIGO\":\"CRFAS13\",\"CRPRO_CODIGO\":\"CRPRO3\",\"CRETT_CODIGO\":\"CRETT8\",\"CGG_CRETT_CODIGO\":null,\"CRSEC_CODIGO\":\"CRSEC1\",\"CGG_CRFAS_CODIGO\":null,\"CUSU_CODIGO\":\"1\",\"CRFAS_NOMBRE\":\"Analisis Tecnico\",\"CRFAS_ORDEN\":1,\"CRFAS_TAREA_REALIZA\":\"Verificacion y validacion de documentacion\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\"asdfsadf\"}]", 
		//				null, 
		//				null, 
		//				null, 
		//				null
		//				));
		//		    try {
		//				
		//		    	System.out.print(new Cgg_res_tipo_solicitud_tramite().selectCGG_RES_TIPO_SOLICITUD_PADRE("CRTST8", "JSON"));
		//				
		//			} catch (SOAPException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//  try {
		//				System.out.print(new Cgg_res_deposito_garantia().insert("CRCPJ1", 
		//						"0", 
		//						"", 
		//						new BigDecimal(0), 
		//						new Date(), 
		//						new Date(), 
		//						new Date(), 
		//						new Date(), 
		//						new Date(), 
		//						new Date(), 
		//						true, 
		//						1, 
		//						"hola"
		//						));
		//System.out.print(new Cgg_res_deposito_garantia().selectPageDirect(0, 25, "CRDPT_CODIGO", "ASC", "", "JSON"));

		//			} catch (SOAPException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}

		//System.out.print(new Cgg_res_tramite().selectHistorialTramite("CRTRA72", "JSON"));
		//		try {
		//			System.out.print(new Cgg_res_residencia().selectTranseunteDirect(0, 25, "crtra_codigo", "asc", "", "JSON"));
		//		} catch (SOAPException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		try {
		//			System.out.print(new Cgg_res_deposito_garantia().insert("CRCPJ1", "0", "", true, 0, new BigDecimal(120), new Date(), new Date(), new Date(), new Date(), new Date(), new Date(), false, 4,"Garantia temporales extrangeros mayores"));
		//		} catch (SOAPException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		/*System.out.print(new Cgg_res_tramite().actualizarTramite(
				"CRTRA194", 
				"4113", 
				null, 
				"4344", 
				"CRPRO11", 
				"CRTST20", 
				"KEYGEN", 
				"CISLA1", 
				"CRDPT46", 
				"KEYGEN", 
				null, 
				null, 
				null, 
				"verfiiacion de la garantia a 4", 
				0, 
				false, 
				null, 
				"false", 
				new BigDecimal(11), 
				null, 
				"[{\"CRFAS_CODIGO\":\"CRFAS40\",\"CRPRO_CODIGO\":\"CRPRO11\",\"CRETT_CODIGO\":null,\"CGG_CRETT_CODIGO\":null,\"CRSEC_CODIGO\":\"CRSEC1\",\"CGG_CRFAS_CODIGO\":null,\"CGG_CUSU_CODIGO\":null,\"CRFAS_NOMBRE\":\"Digitacion\",\"CRFAS_ORDEN\":2,\"CRFAS_TAREA_REALIZA\":\"Digitalizaci\u00f3n y subida de documentaci\u00f3n adjunta del tramite\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\"verfiiacion de la garantia a 4\",\"CUSU_CODIGO\":\"CUSU44\"}]", 
				"\t[{\"CRSRQ_CODIGO\":\"CRSRQ27\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ3\",\"CRSRQ_DESCRIPCION\":\"Dirijida al presidente del comite - 2 Ejemplares\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ28\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ2\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ29\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Original y copia a colores\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ35\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ5\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ36\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ2\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ37\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ38\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ10\",\"CRSRQ_DESCRIPCION\":\"\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ39\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ11\",\"CRSRQ_DESCRIPCION\":\"Copia integra de la inscripcion\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"}]", 
				"[]", 
				null, 
				null, 
				null, 
				null, 
				null));*/

		/*System.out.print(new Cgg_res_tramite().actualizarTramite(
				"CRTRA196", 
				"28957", 
				null, 
				"450468", 
				"CRPRO11", 
				"CRTST20", 
				"KEYGEN", 
				"CISLA1", 
				"CRDPT46", 
				"KEYGEN", 
				null, 
				null, 
				null, 
				"Esta prueba es importante", 
				0, 
				false, 
				null, 
				"false", 	
				new BigDecimal(16), 
				null, 
				"[{\"CRFAS_CODIGO\":\"CRFAS40\",\"CRPRO_CODIGO\":\"CRPRO11\",\"CRETT_CODIGO\":null,\"CGG_CRETT_CODIGO\":null,\"CRSEC_CODIGO\":\"CRSEC1\",\"CGG_CRFAS_CODIGO\":null,\"CGG_CUSU_CODIGO\":null,\"CRFAS_NOMBRE\":\"Digitacion\",\"CRFAS_ORDEN\":2,\"CRFAS_TAREA_REALIZA\":\"Digitalizaci\u00f3n y subida de documentaci\u00f3n adjunta del tramite\",\"CRFAS_SUBE_ADJUNTO\":true,\"CRFAS_SUMILLA\":\" hola mundo mudo\",\"CUSU_CODIGO\":\"CUSU44\"}]", 
				"[{\"CRSRQ_CODIGO\":\"CRSRQ27\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ3\",\"CRSRQ_DESCRIPCION\":\"Dirijida al presidente del comite - 2 Ejemplares\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" 1\",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ28\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ2\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" 3\",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ29\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Original y copia a colores\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" asdf\",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ35\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ5\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":0,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" ddf\",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ36\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ2\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ37\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ1\",\"CRSRQ_DESCRIPCION\":\"Original y copia\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ38\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ10\",\"CRSRQ_DESCRIPCION\":\"\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"},{\"CRSRQ_CODIGO\":\"CRSRQ39\",\"CRTSR_CODIGO\":\"\",\"CRREQ_CODIGO\":\"CRREQ11\",\"CRSRQ_DESCRIPCION\":\"Copia integra de la inscripcion\",\"CRSRQ_REQUERIDO\":true,\"CRSRQ_PARTICIPANTE\":1,\"CRRQT_CODIGO\":\" \",\"CRTRA_CODIGO\":\" \",\"CRRQT_CUMPLE\":true,\"CRRQT_OBSERVACION\":\" \",\"CRATE_DATA\":\"\"}]", 
				"[]", 
				null, 
				null, 
				null, 
				null, 
				null));*/
		//System.out.print(new Cgg_res_tramite().delete("CRTRA200"));
		//System.out.print(new Cgg_res_tramite().anularTramite("CRTRA200","Esta es la anulacion"));
		//System.out.print(new Cgg_res_tramite().selectPageDirect1(0, 30, "CRTRA_FECHA_RECEPCION", "DESC", "", "JSON"));
		/*try {
			System.out.print(new Cgg_res_tramite_garantia().selectCGG_RES_TRAMITE_GARANTIA("CRTRA244", "JSON"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			System.out.print(new Cgg_res_aerolinea().selectAll("JSON"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		/*try {
			new Cgg_veh_historial().selectVehiculoLibre(0, 25, "CVVEH_CODIGO", "ASC", "MAZDA", "JSON", 0);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto> datoAeropuerto = new ArrayList<com.besixplus.sii.objects.Cgg_res_aeropuerto>();
		ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea> datoAerolinea = new ArrayList<com.besixplus.sii.objects.Cgg_res_aerolinea>();
		ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje> datoTipoHospedaje = new ArrayList<com.besixplus.sii.objects.Cgg_tct_tipo_hospedaje>();
		ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad> datoTipoActividad = new ArrayList<com.besixplus.sii.objects.Cgg_tct_actividad>();

		ArrayList<HashMap<String,Object>> movilidad_ingreso = new ArrayList<HashMap<String,Object>>();
		ArrayList<HashMap<String,Object>> movilidad_salida = new ArrayList<HashMap<String,Object>>();
		ArrayList<HashMap<String,Object>> movilidad_residente =  new ArrayList<HashMap<String,Object>>();
		//ArrayList<HashMap<String,Object>> grupo_actividad =  new ArrayList<HashMap<String,Object>>();
		//ArrayList<HashMap<String,Object>> grupo_hospedaje =  new ArrayList<HashMap<String,Object>>();


		com.besixplus.sii.objects.HistoricoMovi historicomovi = new com.besixplus.sii.objects.HistoricoMovi();
		String exp1 = "",exp2 = "",expFinal ="";

		InfoConfigMovilidad datoConfigMovilidad = null;
		Connection con = null;
		String userName = "klascano";//request.getUserPrincipal().getName();
		String in_Canton="";

		con = ManagerConnection.getConnection();		

		try {
			con.setAutoCommit(false);			

			datoAeropuerto = com.besixplus.sii.db.Cgg_res_aeropuerto.selectAll(con, userName);						
			datoAerolinea = com.besixplus.sii.db.Cgg_res_aerolinea.selectAll(con, userName);								
			datoTipoHospedaje = com.besixplus.sii.db.Cgg_tct_tipo_hospedaje.selectAll(con, userName);			
			datoTipoActividad = com.besixplus.sii.db.Cgg_tct_actividad.selectAll(con, userName);

			movilidad_ingreso = com.besixplus.sii.db.Cgg_res_movilidad.selectAllBuscarPersonasOffLine(con,userName);
			movilidad_salida = com.besixplus.sii.db.Cgg_res_movilidad.selectAllBuscarSalidaPersonasOffLine(con,userName);
			movilidad_residente = com.besixplus.sii.db.Cgg_res_movilidad.selectAllBuscarResidenteOffLine(con,userName,in_Canton);					
			//grupo_hospedaje = com.besixplus.sii.db.Cgg_tct_grupo_hospedaje.selectGrupohospedajeoff(con,userName);	
			//grupo_actividad = com.besixplus.sii.db.Cgg_tct_grupo_actividad.selectGrupoActividadoff(con,userName);			

			datoConfigMovilidad = new InfoConfigMovilidad();
			datoConfigMovilidad.setCgg_res_aeropuerto(datoAeropuerto);
			datoConfigMovilidad.setCgg_res_aerolinea(datoAerolinea);
			datoConfigMovilidad.setCgg_tct_tipo_hospedaje(datoTipoHospedaje);
			datoConfigMovilidad.setCgg_tct_actividad(datoTipoActividad);

			exp1 = new Gson().toJson(datoConfigMovilidad);

			historicomovi.setMovilidad_ingreso(movilidad_ingreso);
			historicomovi.setMovilidad_salida(movilidad_salida);
			//historicomovi.setMovilidad_residente(movilidad_residente);
			//historicomovi.setGrupo_hospedaje(grupo_hospedaje);
			//historicomovi.setGrupo_actividad(grupo_actividad);

			exp2 = new JSONObject(historicomovi).toString();//mas de 1 minuto
			//exp2 = new Gson().toJson(historicomovi);
			expFinal ="["+exp1+","+exp2+"]"; 

			con.setAutoCommit(true);
			con.close();					

		} catch (SQLException e) {			
			System.out.println(e.getMessage());			
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(expFinal);*/

		/*String outputFile = "a.zip";
		int level = 9;
		try{
	
		    FileOutputStream fout = new FileOutputStream(outputFile);
		    ZipOutputStream zout = new ZipOutputStream(fout);
		    zout.setLevel(level);

		    ZipEntry ze = new ZipEntry("a.zip");
		    FileInputStream fin = new FileInputStream("b.dat");
		    zout.putNextEntry(ze);
		    for (int c = fin.read(); c != -1; c = fin.read()) {
		      zout.write(c);
		    }
		    fin.close();
		    zout.close();
		}catch(IOException ioe){

		}*/
		//Connection con = ManagerConnection.getConnection();
		/*ArrayList<HashMap<String,Object>> a456 =  new ArrayList<HashMap<String,Object>>();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a456 = Cgg_res_notificacion.selectOficialSelectoff(con,"kl");*/
		
		
	//	System.out.print(new Cgg_res_residencia().selectExportable(2, "CSV"));
		/*Connection con = ManagerConnection.getConnection();
		 
		try {
			//CopyManager tmpCM = new CopyManager((BaseConnection) con);
			//PrintStream tmpPS = new PrintStream(tmpBuffer);
			//System.setOut(tmpPS);
			
			Statement tmpStm = con.createStatement();
			tmpStm.execute("COPY (SELECT C1.NOMBRES,	 C1.CRPER_NUM_DOC_IDENTIFIC, C1.CRPER_NUMERO_RESIDENCIA, C1.CRPER_FECHA_NACIMIENTO, C1.CRRSD_FECHA_INICIO, C1.CRRSD_FECHA_CADUCIDAD	FROM ( WITH CONFIG AS( 	SELECT CGCNF_VALOR_CADENA FROM SII.CGG_CONFIGURACION WHERE CGCNF_CODIGO  IN ('03','04' ) ),RES1 AS( 	SELECT C2.CRTST_CODIGO, 		   C2.CRPER_CODIGO, 		C2.CRRSD_FECHA_INICIO, 		C2.CRRSD_FECHA_CADUCIDAD	 	 FROM (			  		SELECT F_TIPO_SOLICITUD_PADRE(CRTST_CODIGO) CRTST_CODIGO_PADRE, 			CRTST_CODIGO, 			CRPER_CODIGO, 			CRRSD_FECHA_INICIO, 			CRRSD_FECHA_CADUCIDAD	 		 FROM SII.CGG_RES_RESIDENCIA 		 WHERE CRRSD_ESTADO = TRUE 		 AND CRRSD_VIGENTE = TRUE		             	) AS C2 	WHERE C2.CRTST_CODIGO_PADRE IN( SELECT CGCNF_VALOR_CADENA FROM CONFIG) )	  SELECT      	TRIM(COALESCE(PER.CRPER_NOMBRES,' ')||' '||COALESCE(PER.CRPER_APELLIDO_PATERNO,' ')||' '||COALESCE(PER.CRPER_APELLIDO_MATERNO,' ')) NOMBRES,	 	TRIM(REPLACE(PER.CRPER_NUM_DOC_IDENTIFIC,'-','')) CRPER_NUM_DOC_IDENTIFIC, 	SUBSTRING(PER.CRPER_NUMERO_RESIDENCIA FOR 7) CRPER_NUMERO_RESIDENCIA, 	TO_CHAR(PER.CRPER_FECHA_NACIMIENTO,'YYYYMMDD') CRPER_FECHA_NACIMIENTO, 	TO_CHAR(RSD.CRRSD_FECHA_INICIO,'YYYYMMDD') CRRSD_FECHA_INICIO, 	TO_CHAR(RSD.CRRSD_FECHA_CADUCIDAD,'YYYYMMDD') CRRSD_FECHA_CADUCIDAD        FROM RES1 RSD  JOIN SII.CGG_RES_PERSONA PER ON(PER.CRPER_CODIGO=RSD.CRPER_CODIGO) ) AS C1) TO 'D:/DATOS.CSV'");
			System.out.println("Termino!!!");
			tmpStm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

	}	

}
