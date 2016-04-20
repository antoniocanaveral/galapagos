package com.besixplus.sii.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Clase Messages
 * Proporciona metodos para la obtencion de mensajes formateados de acuerdo a la localizacion.
 *  
 * @author BESIXPLUS CIA. LTDA.
 *
 */
public class Messages {
	public enum Types{
		Error,Info
	};
	/**
	 * Localizacion del sistema.
	 */
	private Locale myLocale = Locale.getDefault();
	/**
	 * Ruta del archivos de propiedades.
	 */
	private String myProperties = null;
	/**
	 * Manejador de recursos incrustados.
	 */
	private ResourceBundle myMessages;
	/**
	 * Formateador de texto.
	 */
	private MessageFormat myMsgFormatter = new MessageFormat("");
	/**
	 * Contructor de la clase.
	 * @param inType Tipo de mensajes que se desea obtener.
	 */
	public Messages(Types inType) {
		this(inType,null);
	}
	/**
	 * Contructor de la clase.
	 * @param inType Tipo de mensajes que se desea obtener.
	 * @param inLocale Localizacion con la que se desea trabajar.
	 */
	public Messages(Types inType, Locale inLocale) {
		this.myLocale = inLocale!=null?inLocale:Locale.getDefault();
		this.myProperties = this.getClass().getPackage().getName()+"."+inType.toString();
		this.myMessages = ResourceBundle.getBundle(this.myProperties, myLocale);
	}
	/**
	 * Establece la localizacion de los mensajes.
	 * @param inLocale Localizacion con la que se desea trabajar.
	 */
	public void setLocale(Locale inLocale) {
		this.myLocale = inLocale;
		this.myMessages = ResourceBundle.getBundle(this.myProperties, myLocale);
	}
	/**
	 * Obtiene la localizacion con la que se esta trabajando.
	 * @return
	 */
	public Locale getLocale() {
		return this.myLocale;
	}
	/**
	 * Obtiene un mensaje formateado conforme a la plantilla.
	 * @param inKey Palabra clave que identifica a la plantilla de texto que se va a utilizar.
	 * @param inArgs Valores que son utilizados para formatear la plantilla. 
	 * @return Cadena de texto formateada.
	 */
	public String getMessage(String inKey, Object[] inArgs){
		this.myMsgFormatter.applyPattern(this.myMessages.getString(inKey));
		return this.myMsgFormatter.format(inArgs);
	}
}
