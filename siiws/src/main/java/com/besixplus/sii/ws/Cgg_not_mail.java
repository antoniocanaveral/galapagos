package com.besixplus.sii.ws;

import com.besixplus.sii.db.ManagerConnection;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by acanaveral on 4/7/16.
 */
@WebService()
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class Cgg_not_mail implements Serializable {

    private static final long serialVersionUID = -1827505233596014691L;
    @Resource
    WebServiceContext wctx;

    @WebMethod
    public String selectAll(){
        com.besixplus.sii.misc.Formatter tmpFormat = null;
        HttpServletRequest tmpRequest = (HttpServletRequest) wctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse tmpResponse = (HttpServletResponse) wctx.getMessageContext().get(MessageContext.SERVLET_RESPONSE);
        com.besixplus.sii.objects.Cgg_not_mail tmpObj = new com.besixplus.sii.objects.Cgg_not_mail();
        tmpObj.setNtml_usuario_insert(tmpRequest.getUserPrincipal().getName());
        tmpObj.setNtml_usuario_update(tmpRequest.getUserPrincipal().getName());
        try{
            Connection con = ManagerConnection.getConnection();
            if(!com.besixplus.sii.db.Cgg_sec_objeto.isGrant(con, Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getClassName(), tmpRequest.getUserPrincipal().getName(), 1)){
                con.close();
                tmpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, Thread.currentThread().getStackTrace()[1].getClassName()+" "+Thread.currentThread().getStackTrace()[1].getMethodName());
                return null;
            }
            con.setAutoCommit(!ManagerConnection.isDeployed());
            ArrayList<com.besixplus.sii.objects.Cgg_not_mail> tmpArray = new com.besixplus.sii.db.Cgg_not_mail(tmpObj).selectAll(con);
            tmpFormat = new com.besixplus.sii.misc.Formatter("JSON", tmpArray);
            con.close();
        }catch(SQLException inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            return inException.getMessage();
        }catch (Exception inException){
            com.besixplus.sii.db.SQLErrorHandler.errorHandler(inException);
            return inException.getMessage();
        }
        if (tmpObj != null)
            return tmpFormat.getData().toString();
        return null;
    }
}
