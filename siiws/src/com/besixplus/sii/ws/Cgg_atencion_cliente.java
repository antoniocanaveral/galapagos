package com.besixplus.sii.ws;


import java.io.Serializable;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;

/**
* CLASE Cgg_atc_denuncia_sugerencia
* CONTIENE LOS METODOS NECESARIOS PARA EL MANEJO DE LA INFORMACION CONTENIDA EN LA TABLA Cgg_res_denuncia POR MEDIO DE SERVICOS WEB.
*
* @autor BESIXPLUS CIA. LTDA.
*/
@WebService()
@SOAPBinding(style=Style.RPC)
public class Cgg_atencion_cliente implements Serializable{

	private static final long serialVersionUID = 1315874501;

	@Resource WebServiceContext wctx;

		
}