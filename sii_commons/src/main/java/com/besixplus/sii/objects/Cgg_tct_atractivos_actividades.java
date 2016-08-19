package com.besixplus.sii.objects;

/**
 * CLASE Cgg_tct_atractivos_actividades
 * TABLA: Cgg_tct_atractivos_actividades
 * DESCRIPCION:ALMACENA INFORMACION DE LOS DISTINTOS ATRACTIVOS Y ACTIVIDADES DEL REGISTRO DEL TCT.
 * ABREVIATURA:CAT*/
 
public class Cgg_tct_atractivos_actividades {

	private String myctata_codigo;
	private String myctgtr_codigo;
	private String myctata_vida_marina; 
	private String myctata_sol_playa ; 
	private String myctata_vida_terrestre;
	private String myctata_paisaje;
	private String myctata_crucero; 
	private String myctata_buceo;
	private String myctata_snorkel;
	private String myctata_kayak;
	private String myctata_surf;
	private String myctata_senderismo;
	private String myctata_observacion;
	private String myctata_fotografia;
	private String myctata_pesca_vivencial;

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_atractivos_actividades
     */
    public Cgg_tct_atractivos_actividades(){}

    /**
     * CONSTRUCTOR DE LA CLASE Cgg_tct_atractivos_actividades
     */
    public Cgg_tct_atractivos_actividades(
    		String inctata_codigo,
    		String inctgtr_codigo,
    		String inctata_vida_marina,
    		String inctata_sol_playa,  
    		String inctata_vida_terrestre,
    		String inctata_paisaje,
    		String inctata_crucero, 
    		String inctata_buceo,
    		String inctata_snorkel,
    		String inctata_kayak,
    		String inctata_surf,
    		String inctata_senderismo,
    		String inctata_observacion,
    		String inctata_fotografia,
    		String inctata_pesca_vivencial
    ){
        this.setCTATA_CODIGO(inctata_codigo);
        this.setCTGTR_CODIGO(inctgtr_codigo);
        this.setCTATA_VIDA_MARINA(inctata_vida_marina);
        this.setCTATA_SOL_PLAYA(inctata_sol_playa);
        this.setCTATA_VIDA_TERRESTRE(inctata_vida_terrestre);
        this.setCTATA_PAISAJE(inctata_paisaje); 
        this.setCTATA_CRUCERO(inctata_crucero);
        this.setCTATA_BUCEO(inctata_buceo);
        this.setCTATA_SNORKEL(inctata_snorkel);
        this.setCTATA_KAYAK(inctata_kayak);
        this.setCTATA_SURF(inctata_surf);
        this.setCTATA_SENDERISMO(inctata_senderismo);
        this.setCTATA_OBSERVACION(inctata_observacion);
        this.setCTATA_FOTOGRAFIA(inctata_fotografia);
        this.setCTATA_PESCA_VIVENCIAL(inctata_pesca_vivencial);
    }

    public String getCTATA_CODIGO() {
	return this.myctata_codigo;
}
public void setCTATA_CODIGO(String inctata_codigo) {
	this.myctata_codigo = inctata_codigo;
}
public String getCTGTR_CODIGO() {
	return this.myctgtr_codigo;
}
public void setCTGTR_CODIGO(String inctgtr_codigo) {
	this.myctgtr_codigo = inctgtr_codigo;
}
public String getCTATA_VIDA_MARINA() {
	return this.myctata_vida_marina;
}
public void setCTATA_VIDA_MARINA(String inctata_vida_marina ) {
	this.myctata_vida_marina = inctata_vida_marina ;
}
public String getCTATA_SOL_PLAYA() {
	return this.myctata_sol_playa;
}
public void setCTATA_SOL_PLAYA(String inctata_sol_playa) {
	this.myctata_sol_playa = inctata_sol_playa;
}
public String getCTATA_VIDA_TERRESTRE() {
	return this.myctata_vida_terrestre;
}
public void setCTATA_VIDA_TERRESTRE(String inctata_vida_terrestre) {
	this.myctata_vida_terrestre = inctata_vida_terrestre;
}
public String getCTATA_PAISAJE() {
	return this.myctata_paisaje;
}
public void setCTATA_PAISAJE(String inctata_paisaje) {
	this.myctata_paisaje = inctata_paisaje;
}
public String getCTATA_CRUCERO() {
	return this.myctata_crucero;
}
public void setCTATA_CRUCERO(String inctata_crucero) {
	this.myctata_crucero = inctata_crucero;
}
public String getCTATA_BUCEO() {
	return this.myctata_buceo;
}
public void setCTATA_BUCEO(String inctata_buceo) {
	this.myctata_buceo = inctata_buceo;
}
public String getCTATA_SNORKEL() {
	return this.myctata_snorkel;
}
public void setCTATA_SNORKEL(String inctata_snorkel) {
	this.myctata_snorkel = inctata_snorkel;
}
public String getCTATA_KAYAK() {
	return this.myctata_kayak;
}
public void setCTATA_KAYAK(String inctata_kayak) {
	this.myctata_kayak = inctata_kayak;
}
public String getCTATA_SURF() {
	return this.myctata_surf;
}
public void setCTATA_SURF(String inctata_surf) {
	this.myctata_surf = inctata_surf;
}
public String getCTATA_SENDERISMO() {
	return this.myctata_senderismo;
}
public void setCTATA_SENDERISMO(String inctata_senderismo) {
	this.myctata_senderismo = inctata_senderismo;
}
public String getCTATA_OBSERVACION() {
	return this.myctata_observacion;
}
public void setCTATA_OBSERVACION(String inctata_observacion) {
	this.myctata_observacion = inctata_observacion;
}
public String getCTATA_FOTOGRAFIA() {
	return this.myctata_fotografia;
}
public void setCTATA_FOTOGRAFIA(String inctata_fotografia) {
	this.myctata_fotografia = inctata_fotografia;
}
public String getCTATA_PESCA_VIVENCIAL() {
	return this.myctata_pesca_vivencial;
}
public void setCTATA_PESCA_VIVENCIAL(String inctata_pesca_vivencial) {
	this.myctata_pesca_vivencial = inctata_pesca_vivencial;
}
}
