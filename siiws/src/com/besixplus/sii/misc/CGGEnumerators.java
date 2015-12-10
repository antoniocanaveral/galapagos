package com.besixplus.sii.misc;

/**
 * Enumeradores para la aplicacion SIICGG.
 * @author BESIXPLUS CIA. LTDA.
 *
 */
public class CGGEnumerators {

	/**
	 * Define los tipos de residencias macros soportados.
	 */
	public enum Residencia{
		Permanente(0),Temporal(1);
		private int myValue;
		private Residencia(int inValue) {
			this.myValue = inValue;
		}
		public int getValue(){
			return this.myValue;
		}
	}
	/**
	 * Enumerador publico. Señala las longitudes de las claves primarias.
	 */
	public enum LONGITUDCLAVEPRIMARIA {
		MINIMO(6),MAXIMO(20);
		private int Value;
		LONGITUDCLAVEPRIMARIA(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	
	/**
	 * Enumerador publico. Señala los posibles valores de atencion de un seguimiento.
	 *
	 */
	public enum ESTADOATENCION{
		RECIBIDO(0),REVISADO(1),DISTRIBUIDO(2),PENDIENTE(3),DESPACHADO(4),FINALIZADO(5),INHABILITADO(6),REVISADODISTRIBUIDO(7);
		private int Value;
		ESTADOATENCION(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	
	/**
	 * Enumerador publico. Señala los posibles valores del estado de un seguimiento.
	 */
	public enum TIPORESPUESTA{
		INDETERMINADO(-1),NEGADO(0),APROBADO(1);
		private int Value;
		TIPORESPUESTA(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
			
	/**
	 * Enumerador publico. Señala los estado de las repuestas de los segimientos hijos de un seguimiento.
	 */
	public enum ESTADORESPUESTA{
		SINHIJOS(-1),SINRESPUESTAS(0),RESPUESTAPARCIAL(1),RESPUESTATOTAL(2);
		private int Value;
		ESTADORESPUESTA(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	
	/**
	 * Enumerador publico. Señala los estado del tipo de novedad para los seguimientos.	 
	 */
	public enum TIPONOVEDAD{
		COMENTARIO(0),NOTIFICACION(1);
		private int Value;
		TIPONOVEDAD(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	
	/**
	 * Enumerador publico. Señala los estado cuando un tramite se encuentra pendiente.	 
	 */
	public enum ESTADOPENDIENTETRAMITE{
		NOEVALUADO(0),EVALUADO(1),CADUCADO(2),SOLOGUARDADO(3),FINALIZADO(4),ANULADO(5),OTRO(6);				
		private int Value;
		ESTADOPENDIENTETRAMITE(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	/**
	 * Define los tipos de votos de residencia
	 */
	public enum Voto{
		Aprobado(0),Negado(1),Abstencion(2);
		private int myValue;
		private Voto(int inValue) {
			this.myValue = inValue;
		}
		public int getValue(){
			return this.myValue;
		}
		public static Voto valueOf(int inValue){
			for(int i = 0; i < Voto.values().length; i++){
				if(Voto.values()[i].getValue() == inValue){
					return Voto.values()[i];
				}
			}
			return null;
		}
	}
	/**
	 * Define los estados de una resolucion.
	 */
	public enum EstadoResolucion{
		Esperando_Votacion(0),Aprobada(1),Negada(2),Ejecutada(3),Anulada(4);
		private int myValue;
		private EstadoResolucion(int inValue) {
			this.myValue = inValue;
		}
		public int getValue(){
			return this.myValue;
		}
	}
	/**
	 * Define los tipos de una resolucion.
	 */
	public enum TipoResolucion{
		Normativa(0),Aprobacion(1);
		private int myValue;
		private TipoResolucion(int inValue) {
			this.myValue = inValue;
		}
		public int getValue(){
			return this.myValue;
		}
	}
	/**
	 * Define los tipos datos de objetos de la base
	 */
	public enum DataTypes{
		VARCHAR("CHARACTER VARYING"),
		VARCHAR1("VARCHAR"),
		NUMERIC("NUMERIC"),
		TEXT("TEXT"),
		TIMESTAMP("TIMESTAMP WITH TIME ZONE"),
		INTEGER("SMALLINT"),
		BOOLEAN("BOOLEAN"),
		SMALLINT("INT4"),
		VOID("VOID"),
		CURSOR("REFCURSOR");
		private String myValue;
		private DataTypes(String inValue) {
			this.myValue = inValue;
		}
		public String getValue(){
			return this.myValue;
		}
	}
	
	/**
	 * Define los tipos de estado de depositos de garantia.
	 */
	public enum ESTADODEPOSITOGARANTIA{
		REGISTRADO(0),AUTORIZADODEVOLUCION(1),DEVUELLTO(2);
		private int Value;
		private ESTADODEPOSITOGARANTIA(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	
	/**
	 * Define los tipos de movimientos para el manejo de kardex.
	 */
	public enum TIPOMOVIMIENTOKARDEX{
		INVENTARIOINICIAL(0),INGRESO(1),SALIDA(2);
		private int Value;
		private TIPOMOVIMIENTOKARDEX(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	
	/**
	 * Define los tipos de estado asignacion.
	 */
	public enum TIPOESTADOASIGNACION{
		REGISTRADA(0),REASIGNADA(1),FINALIZADA(2);
		private int Value;
		private TIPOESTADOASIGNACION(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}


	/**
	 * Define los tipos de operaciones para el manejo de kardex.
	 */
	public enum TIPOOPERACIONKARDEX{
		COMPRA(0),VENTA(1),ANULACION(2),DEVOLUCION(3),OTRAS(4);
		private int Value;
		private TIPOOPERACIONKARDEX(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	
	public enum TipoVehiculo{
		Terrestre(0),Maritimo(1),Aereo(2);
		private int Value;
		private TipoVehiculo(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	/**
	 * Definicion en donde se emite la especie seleccionada.
	 *
	 */
	public enum TipoAmbitoEspecie{
		Residencia(0),TCT(1),IntentosFallidos(2);
		private int myValue;
		private TipoAmbitoEspecie(int inValue){
			this.myValue = inValue;
		}
		public int getValue(){
			return this.myValue; 
		}
	}
	
	/**
	 * Tipo de tramite de vehiculos.
	 */
	public enum TipoVehiculoTramite{
		Vehiculo(0),Motor(1);
		private int Value;
		private TipoVehiculoTramite(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	
	/**
	 * Define los tipos de formas de generar resultado de forma general.
	 */
	public enum TIPOGENERACION{
		GENERA(0),GENERAYESCRIBE(1);
		private int Value;
		private TIPOGENERACION(int inValue) {
			this.Value = inValue;
		}
		public int getValue(){
			return this.Value;
		}
	}
	
	
	/**
	 * Defincion de variables asociadas a las reglas de validacion.
	 */
	public enum VALORESREGLAVALIDACION{
		PERSONA("tmpCrper_codigo"),FECHAINGRESO("tmpFechaIngreso"),
		AEROPUERTOORIGEN("tmpCarpt_codigo_origen"),AEROPUERTODESTINO("tmpCarpt_codigo_destino"),
		USUARIO("tmpCusu_nombre"),DOCUMENTOIDENTIFICACION("tmpNumeroDocumento"),CODIGOBARRAS("tmpCtreg_codigo_barras");
		private String Value;
		private VALORESREGLAVALIDACION(String inValue) {
			this.Value = inValue;
		}
		public String getValue(){
			return this.Value;
		}
	}
	
	/**
	 * Enumerador publico. Establece el tipo de formato de salida.
	 *
	 */
	public enum TIPOFORMATO{
		JSON(0),XML(1);
		private int Value;
		TIPOFORMATO(int inValue) {
			Value = inValue;
		}
		public int getValue() {
			return Value;
		}
	}
	
	
}
