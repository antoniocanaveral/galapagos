package com.besixplus.sii.objects;

import java.util.ArrayList;
/**
* CLASE NodoTramite
* DESCRIPCION: ESTRUCTURA DE ALMACENAMIENTO QUE SE UTILIZA PARA EL HISTORIAL TRAMITE
*/
public class NodoTramite {

	private String id = null;

	private String name = null;

	private Object data = null;

	private ArrayList<NodoTramite> children = null;
	
	/**
	 * 
	 */
	public NodoTramite(){
		this(null,null,null,null);
	}
			
	/**
	 * ESTRUCTURA DE ALMACENAMIENTO QUE SE UTILIZA EN EL HISTORIAL DE TRAMITE.
	 * @param id IDENTIFICATIVO DEL NODO O FASE.
	 * @param name NOMBRE DEL NODO O FASE.
	 * @param data TIPO DE DATOS
	 * @param children NOMBRE DE LA FASE HIJA O NODO HIJO.
	 */
	public NodoTramite(String id, String name, String data,
			ArrayList<NodoTramite> children) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.children = children;
	}

	/**
	 * OBTIENE EL IDENTIFICATIVO DEL NODO O FASE.
	 * @return IDENTIFICATIVO DEL NODO O FASE.
	 */
	public String getId() {
		return id;
	}

	/** ESTABLECE EL IDENTIFICATIVO DEL NODO O FASE.
	 * @param id IDENTIFICATIVO DEL NODO O FASE.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * OBTIENE EL NOMBRE DEL NODO O FASE.
	 * @return NOMBRE DEL NODO O FASE.
	 */
	public String getName() {
		return name;
	}

	/**
	 * ESTABLECE EL NOMBRE DEL NODO O FASE.
	 * @param name NOMBRE DEL NODO O FASE.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * OBTIENE EL TIPO DE DATO.
	 * @return EL TIPO DE DATO.
	 */
	public Object getData() {
		return data;
	}

	/**
	 * ESTABLECE EL TIPO DE DATO.
	 * @param data TIPO DE DATO.
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * OBTIENE EL NOMBRE DEL NODO HIJO O DE LA FASE HIJA.
	 * @return NOMBRE DEL NODO HIJO O DE LA FASE HIJA.
	 */
	public ArrayList<NodoTramite> getChildren() {
		return children;
	}

	/**
	 * ESTABLECE EL NOMBRE DEL NODO HIJO O DE LA FASE HIJA.
	 * @param children NOMBRE DEL NODO HIJO O DE LA FASE HIJA.
	 */
	public void setChildren(ArrayList<NodoTramite> children) {
		this.children = children;
	}
		
}
