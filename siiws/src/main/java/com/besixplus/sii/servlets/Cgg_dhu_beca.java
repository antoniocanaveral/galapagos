package com.besixplus.sii.servlets;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Cgg_dhu_beca extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1271228977;

	public Cgg_dhu_beca() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean tmpIsMultipart = ServletFileUpload.isMultipartContent(request);
		String outResult = "true";
		if(tmpIsMultipart){
			com.besixplus.sii.objects.Cgg_dhu_beca obj = new com.besixplus.sii.objects.Cgg_dhu_beca();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(10485760);
			List items;
			try {
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						if(item.getFieldName().equals("cdtbc_codigo")){
							obj.setCDTBC_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cgesp_codigo")){
							obj.setCGESP_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cgied_codigo")){
							obj.setCGIED_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cpais_codigo")){
							obj.setCPAIS_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cgtpr_codigo")){
							obj.setCGTPR_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("crper_codigo")){
							obj.setCRPER_CODIGO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_numero")){
							obj.setCDBEC_NUMERO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_fecha_ingreso")){
							obj.setCDBEC_FECHA_INGRESO(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_funcionario")){
							obj.setCDBEC_FUNCIONARIO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_numero_aprobacion")){
							obj.setCDBEC_NUMERO_APROBACION(item.getString());
						}
						if(item.getFieldName().equals("cdbec_fecha_inicio")){
							obj.setCDBEC_FECHA_INICIO(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_fecha_fin")){
							obj.setCDBEC_FECHA_FIN(Timestamp.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_numero_convenio")){
							obj.setCDBEC_NUMERO_CONVENIO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_vsalida_origen")){
							obj.setCDBEC_VSALIDA_ORIGEN(item.getString());
						}
						if(item.getFieldName().equals("cdbec_vsalida_destino")){
							obj.setCDBEC_VSALIDA_DESTINO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_vsalida_valor")){
							obj.setCDBEC_VSALIDA_VALOR(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
						}
						if(item.getFieldName().equals("cdbec_vretorno_origen")){
							obj.setCDBEC_VRETORNO_ORIGEN(item.getString());
						}
						if(item.getFieldName().equals("cdbec_vretorno_destino")){
							obj.setCDBEC_VRETORNO_DESTINO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_vretorno_valor")){
							obj.setCDBEC_VRETORNO_VALOR(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
						}
						if(item.getFieldName().equals("cdbec_carrera")){
							obj.setCDBEC_CARRERA(item.getString());
						}
						if(item.getFieldName().equals("cdbec_tipo_ciclo")){
							obj.setCDBEC_TIPO_CICLO(Integer.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_total_ciclos")){
							obj.setCDBEC_TOTAL_CICLOS(Integer.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_numero_cuento")){
							obj.setCDBEC_NUMERO_CUENTO(item.getString());
						}
						if(item.getFieldName().equals("cdbec_observacion")){
							obj.setCDBEC_OBSERVACION(item.getString());
						}
						if(item.getFieldName().equals("cdbec_titulo_entregado")){
							obj.setCDBEC_TITULO_ENTREGADO(Boolean.valueOf(item.getString()));
						}
						
						if(item.getFieldName().equals("cdbec_beca_devengada")){
							obj.setCDBEC_BECA_DEVENGADA(Boolean.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_estado_aprobacion")){
							obj.setCDBEC_ESTADO_APROBACION(Integer.valueOf(item.getString()));
						}
						if(item.getFieldName().equals("cdbec_valor_reembolso")){
							obj.setCDBEC_VALOR_REEMBOLSO(java.math.BigDecimal.valueOf(Double.valueOf(item.getString())));
						}
					} else {

				/*		if(item.getFieldName().equals("cdbec_doc_convenio")){
							obj.setCDBEC_NOMBRE_ADJUNTO(item.getName());
							obj.setCDBEC_DOC_CONVENIO(item.get());
						}
						if(item.getFieldName().equals("cdbec_adjunto_titulo")){
							obj.setCDBEC_ADJUNTO_TITULO(item.get());
						}*/

					}
				}
				obj.setCDBEC_CODIGO("KEYGEN");
				obj.setCDBEC_ESTADO(true);
				obj.setCDBEC_USUARIO_INSERT(request.getUserPrincipal().getName());
				obj.setCDBEC_USUARIO_UPDATE(request.getUserPrincipal().getName());
				Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
				outResult = new com.besixplus.sii.db.Cgg_dhu_beca(obj).insert(tmpCon);
				try {
					tmpCon.close();
				} catch (SQLException e) {
					com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
					outResult = "false";
				}	
			} catch (FileUploadException e) {
				e.printStackTrace();

				outResult ="false";

				outResult = "false";

			}

			//response.getWriter().println(Boolean.toString(outResult));
		}else{
String tmpCodigo = request.getParameter("codigo");
String tmpColumna = request.getParameter("columna");
if(tmpCodigo != null){
com.besixplus.sii.objects.Cgg_dhu_beca obj = null;
obj = new com.besixplus.sii.objects.Cgg_dhu_beca();
obj.setCDBEC_CODIGO(tmpCodigo);
Connection tmpCon = com.besixplus.sii.db.ManagerConnection.getConnection();
try{
tmpCon.setAutoCommit(!com.besixplus.sii.db.ManagerConnection.isDeployed());
new com.besixplus.sii.db.Cgg_dhu_beca(obj).select(tmpCon);
tmpCon.close();
} catch (SQLException e) {
com.besixplus.sii.db.SQLErrorHandler.errorHandler(e);
}

}

}

			response.getWriter().println(outResult);

		}
	}

