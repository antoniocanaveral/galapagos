package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;
import com.bmlaurus.objects.DinardapResidencia;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by acanaveral on 2/9/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class ConsultaExterna implements Serializable {


    private static final long serialVersionUID = -758123714949061039L;

    private static final String ERR_CODE_NO_DATA = "501";

    @Resource
    WebServiceContext wctx;

    @WebMethod
    public DinardapResidencia consultaResidencia(
            @WebParam(name="numeroIdentificacion")String numeroIdentificacion
    )throws SOAPException {
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        List<DinardapResidencia> obj = null;
        StringBuilder outCadena = null;
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                throw new SOAPFaultException(SOAPFactory.newInstance().createFault("Acceso no autorizado.", new QName("http://schemas.xmlsoap.org/soap/envelope/",Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
            }
            con.setAutoCommit(!ManagerConnection.isDeployed());
            obj = com.besixplus.sii.db.Cgg_res_residencia.selectConsultaDinardap(con, numeroIdentificacion);
            //tmpFormat = new com.besixplus.sii.misc.Formatter("XML", obj);
            //outCadena = tmpFormat.getData();
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            throw new SOAPFaultException(SOAPFactory.newInstance().createFault(inException.getMessage(), new QName("http://schemas.xmlsoap.org/soap/envelope/", Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName())));
        }

        if(obj==null || obj.size()<=0){
            DinardapResidencia noData = new DinardapResidencia(ERR_CODE_NO_DATA,"No se encontraron datos para el documento ["+ numeroIdentificacion+"]");
            obj.add(noData);
        }

        return obj.get(0);
    }

}
