package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
* CLASE Cgg_catalogo
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_catalogo POR MEDIO DE SERVICIOS WEB.
*
* @author BMLaurus.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_catalogo implements Serializable{

	//private static final long serialVersionUID = 1105604089;

	@Resource WebServiceContext wctx;

	/**
	* OBTIENE TODOS LOS REGISTROS DE LA TABLA Cgg_catalogo EN UNA ESTRUCTRA JSON o XML.
	* @param format FORMATO DE SALIDA DE LOS DATOS (JSON, XML). 
	* @return VECTOR JSON o XML EQUIVALENTE A LOS REGISTROS DE LA TABLA.
	* @throws SOAPException 
	*/
	@WebMethod
	public String selectByType(
		@WebParam(name="format")String format,
		@WebParam(name="in_identificador")String in_identificador
	) throws SOAPException {
		HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
		ArrayList<com.besixplus.sii.objects.Cgg_catalogo> obj = null;
		StringBuilder outCadena = null;
		com.besixplus.sii.misc.Formatter tmpFormat = null;		
		try{
			Connection con = ManagerConnection.getConnection();			
			if(tmpRequest.getUserPrincipal()!=null){				
				if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
					con.close();
					tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
					return null;
				}			
			}
			con.setAutoCommit(!ManagerConnection.isDeployed());
			obj = com.besixplus.sii.db.Cgg_catalogo.selectByType(con, in_identificador);
			tmpFormat = new com.besixplus.sii.misc.Formatter(format, obj);
			outCadena = tmpFormat.getData();
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}catch (Exception inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			try {
				tmpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, inException.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return inException.getMessage();
		}
		if (obj != null)
			if( format.toUpperCase().equals("JSON"))
				return outCadena.toString();			
		return null;
	}

}