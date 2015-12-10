package com.besixplus.sii.objects;

/*import java.util.Date;*/

import com.besixplus.sii.misc.CGGEnumerators.VALORESREGLAVALIDACION;
import com.besixplus.sii.ws.Cgg_res_persona;

/**
 * OPERACION DE LAS REGLAS DE VALIDACION PARA CONTROLAR EL INGRESO DE LA INFORMACION.
 *
 */
public class OperacionValidacion {
	private String myPersona;
	private String myFechaIngreso;
	private String myAeropuertoOrigen;
	private String myAeropuertoDestino;
	private String myUsuario;
	private String myDocumentoIdentificacion;
	private String myCodigoBarras;
	
	
	public  OperacionValidacion()
	 {
		 
	 }
	/**
	 * VALIDA EL NOMBRE DE USUARIO. 
	 * @param inUserName NOMBRE DEL USUARIO
	 */
	public  OperacionValidacion(String inUserName)
	 {
		 this.setUsuario(inUserName);
	 }
	/**
	 * PERMITE LA ASIGNACION DE VALORES.
	 * @param inName NOMBRE DE UN VALOR DE VALIDACION
	 * @param inValue VALOR DE LA ASIGNACION.
	 * @return ASIGNACION.
	 */
	public String asignarValores(String inName, String inValue)
	{
		if (inName.equals(VALORESREGLAVALIDACION.PERSONA.getValue()))
		{
			this.setPersona(inValue);
			return this.getPersona();
		}
		if (inName.equals(VALORESREGLAVALIDACION.FECHAINGRESO.getValue()))
		{
			this.setFechaIngreso(inValue);
			return this.getFechaIngreso();
		}
		if (inName.equals(VALORESREGLAVALIDACION.AEROPUERTOORIGEN.getValue()))
		{
			this.setAeropuertoOrigen(inValue);
			return this.getAeropuertoOrigen();
		}
		if (inName.equals(VALORESREGLAVALIDACION.AEROPUERTODESTINO.getValue()))
		{
			this.setAeropuertoDestino(inValue);
			return this.getAeropuertoDestino();
		}
		if (inName.equals(VALORESREGLAVALIDACION.DOCUMENTOIDENTIFICACION.getValue()))
		{
			this.setDocumentoIdentificacion(inValue);
			return this.getDocumentoIdentificacion();
		}
		if (inName.equals(VALORESREGLAVALIDACION.USUARIO.getValue()))
		{
			return this.getPersona();
		}
		return null;
		
	}
	/**
	 * OBTIENE LOS VALORE DE LA VALIDACION.
	 * @param inName NOMBRE DEL VALOR DE VALIDACION.
	 * @return COLECCION DE INFORMACION.
	 */
	public String obtenerValores(String inName)
	{
		if (inName.equals(VALORESREGLAVALIDACION.PERSONA.getValue()))
		{
			this.setPersona(new Cgg_res_persona().selectNumeroIdentificacion(this.getDocumentoIdentificacion()));
			return this.getPersona();
		}
		if (inName.equals(VALORESREGLAVALIDACION.FECHAINGRESO.getValue()))
		{
			return this.getFechaIngreso();
		}
		if (inName.equals(VALORESREGLAVALIDACION.AEROPUERTOORIGEN.getValue()))
		{
			return this.getAeropuertoOrigen();
		}
		if (inName.equals(VALORESREGLAVALIDACION.AEROPUERTODESTINO.getValue()))
		{
			return this.getAeropuertoDestino();
		}
		if (inName.equals(VALORESREGLAVALIDACION.USUARIO.getValue()))
		{
			return this.getUsuario();
		}
		if (inName.equals(VALORESREGLAVALIDACION.DOCUMENTOIDENTIFICACION.getValue()))
		{
			return this.getDocumentoIdentificacion();
		}
		if (inName.equals(VALORESREGLAVALIDACION.CODIGOBARRAS.getValue()))
		{
			return this.getCodigoBarras();
		}
		return null;
		
	}
	
	/**OBTIENE EL IDENTIFICATIVO DE PERSONA
	 * @return String PERSONA
	 */
	public String getPersona() {
		return myPersona;
	}
	/**
	 * ESTABLECE EL IDENTIFICATIVO DE PERSONA
	 * @param myPersona PERSONA
	 */
	public void setPersona(String myPersona) {
		this.myPersona = myPersona;
	}
	/**
	 * OBTIENE LA FECHA DE INGRESO
	 * @return FECHA INGRESO
	 */
	public String getFechaIngreso() {
		return myFechaIngreso;
	}
	/**
	 * ESTABLECE LA FECHA DE INGRESO
	 * @param myFechaIngreso FECHA INGRESO
	 */
	public void setFechaIngreso(String myFechaIngreso) {
		this.myFechaIngreso = myFechaIngreso;
	}
	/**
	 * OBTIENE EL AEROPUERTO ORIGEN
	 * @return String AEROPUERTO ORIGEN 
	 */
	public String getAeropuertoOrigen() {
		return myAeropuertoOrigen;
	}
	/**
	 * ESTABLECE EL AEROPUERTO DE ORIGEN
	 * @param myAeropuertoOrigen AEROPUERTO ORIGEN
	 */
	public void setAeropuertoOrigen(String myAeropuertoOrigen) {
		this.myAeropuertoOrigen = myAeropuertoOrigen;
	}
	/**
	 * OBTIENE EL AEROPUERTO DE DESTINO
	 * @return String AEROPUERTO DESTINO
	 */
	public String getAeropuertoDestino() {
		return myAeropuertoDestino;
	}
	/**
	 * ESTABLECE EL AEROPUERTO DE DESTINO
	 * @param myAeropuertoDestino AEROPUERTO DE DESTINO
	 */
	public void setAeropuertoDestino(String myAeropuertoDestino) {
		this.myAeropuertoDestino = myAeropuertoDestino;
	}
	/**
	 * OBTIENE EL USUARIO	
	 * @return String USUARIO
	 */
	public String getUsuario() {
		return myUsuario;
	}
	/**
	 * ESTABLECE EL USUARIO
	 * @param myUsuario USUARIO
	 */
	public void setUsuario(String myUsuario) {
		this.myUsuario = myUsuario;
	}
	/**
	 * OBTIENE EL DOCUMENTO DE IDENTIFCACIN
	 * @return String DOCUMENTO DE IDENTIFICACION
	 */
	public String getDocumentoIdentificacion() {
		return myDocumentoIdentificacion;
	}
	/**
	 * ESTABLECE DOCUMENTO DE IDENTIFICACION
	 * @param myDocumentoIdentificacion DOCUMENTO DE IDENTIFICACION
	 */
	public void setDocumentoIdentificacion(String myDocumentoIdentificacion) {
		this.myDocumentoIdentificacion = myDocumentoIdentificacion;
	}
	/**
	 * OBTIENE EL CODIGO DE BARRAS
	 * @return String CODIGO DE BARRAS
	 */
	public String getCodigoBarras() {
			return myCodigoBarras;
	}
	/**
	 * ESTABLECE CODIGO DE BARRAS
	 * @param myCodigoBarras CODIGO DE BARRAS
	 */
	public void setCodigoBarras(String myCodigoBarras) {
			this.myCodigoBarras = myCodigoBarras;
	}
	

}
