package com.besixplus.sii.ws;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.besixplus.sii.db.ManagerConnection;

@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_capacitacion implements Serializable {
	
	@Resource WebServiceContext wctx;
	/**
	 * Selecciona el nombre de una persona.
	 * @param inCrper_num_doc_identific Numero de documento de la person.
	 * @return Nombre de la persona.
	 * @throws SOAPException
	 */
	@WebMethod
	public String seleccionarNombrePersona(
			@WebParam(name="inCrper_num_doc_identific")String inCrper_num_doc_identific			
	) throws SOAPException{
		
		String tmpNombrePersona = "";
		
		//com.besixplus.sii.misc.Formatter tmpFormat = null;
		//HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		//com.besixplus.sii.objects.Cgg_canton tmpObj = new com.besixplus.sii.objects.Cgg_canton();
		//tmpObj.setCCTN_CODIGO(inCctn_codigo);
		try{
			Connection con = ManagerConnection.getConnection();
			
			/*if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
				con.close();
				throw new SOAPFaultException(SOAPFactory.newInstance().createFault(myInfoMessages.getMessage("sii.seguridad.acceso.negado", null), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
			}*/
			
			con.setAutoCommit(false);
			com.besixplus.sii.db.Cgg_capacitacion objCapacitacion = new com.besixplus.sii.db.Cgg_capacitacion();
			tmpNombrePersona = objCapacitacion.seleccionaNombrePersona(con, inCrper_num_doc_identific);
			
			con.close();
		}catch(SQLException inException){
			com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
			throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
		}
		
		return tmpNombrePersona;
	}
	
}
