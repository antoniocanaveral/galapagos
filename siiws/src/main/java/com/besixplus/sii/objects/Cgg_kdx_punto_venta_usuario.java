package com.besixplus.sii.objects;

/**
 * Clase para sostener informacion de punto de venta y usuario de punto.
 * @author BESIXPLUS CIA. LTDA.
 */
public class Cgg_kdx_punto_venta_usuario {

	private String CKPVT_CODIGO;
	private String CCTN_CODIGO;
	private String CKPVT_NOMBRE;
	private String CUSU_CODIGO;
	private String CUSU_NOMBRE_USUARIO;	
	

	public Cgg_kdx_punto_venta_usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCKPVT_CODIGO() {
		return CKPVT_CODIGO;
	}

	public void setCKPVT_CODIGO(String cKPVT_CODIGO) {
		CKPVT_CODIGO = cKPVT_CODIGO;
	}

	public String getCCTN_CODIGO() {
		return CCTN_CODIGO;
	}

	public void setCCTN_CODIGO(String cCTN_CODIGO) {
		CCTN_CODIGO = cCTN_CODIGO;
	}

	public String getCKPVT_NOMBRE() {
		return CKPVT_NOMBRE;
	}

	public void setCKPVT_NOMBRE(String cKPVT_NOMBRE) {
		CKPVT_NOMBRE = cKPVT_NOMBRE;
	}

	public String getCUSU_CODIGO() {
		return CUSU_CODIGO;
	}

	public void setCUSU_CODIGO(String cUSU_CODIGO) {
		CUSU_CODIGO = cUSU_CODIGO;
	}

	public String getCUSU_NOMBRE_USUARIO() {
		return CUSU_NOMBRE_USUARIO;
	}

	public void setCUSU_NOMBRE_USUARIO(String cUSU_NOMBRE_USUARIO) {
		CUSU_NOMBRE_USUARIO = cUSU_NOMBRE_USUARIO;
	}	
		
}
