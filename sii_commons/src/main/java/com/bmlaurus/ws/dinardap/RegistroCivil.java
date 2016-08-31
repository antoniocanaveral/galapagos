package com.bmlaurus.ws.dinardap;

/**
 * Created by acanaveral on 29/6/16.
 */
public class RegistroCivil extends DinardapService {

    private String cedula;
    private String nombre;
    private String genero;
    private String sexo;
    private String fechaNacimiento;
    private String lugarNacimiento;
    private String nacionalidad;
    private String estadoCivil;
    private String conyuge;
    private String nombrePadre;
    private String nombreMadre;
    private String fechaMatrimonio;
    private String fechaDefuncion;
    private String instruccion;
    private String profesion;
    private String cedulaPadre;
    private String cedulaMadre;
    private String cedulaConyuge;
    private String cedulaMagna;
    private String fotografia;
    private String firma;


    public RegistroCivil(String numeroIdentificacion) {
        super(SERVICE_RC, numeroIdentificacion);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenero() {
        String _genero=null;
        if(genero!=null)
            _genero = genero;
        else if(sexo!=null)
            _genero = sexo;
        else
            _genero = "UNDEFINED";

        return _genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getFechaMatrimonio() {
        return fechaMatrimonio;
    }

    public void setFechaMatrimonio(String fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public String getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(String fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCedulaPadre() {
        return cedulaPadre;
    }

    public void setCedulaPadre(String cedulaPadre) {
        this.cedulaPadre = cedulaPadre;
    }

    public String getCedulaMadre() {
        return cedulaMadre;
    }

    public void setCedulaMadre(String cedulaMadre) {
        this.cedulaMadre = cedulaMadre;
    }

    public String getCedulaConyuge() {
        return cedulaConyuge;
    }

    public void setCedulaConyuge(String cedulaConyuge) {
        this.cedulaConyuge = cedulaConyuge;
    }

    public String getCedulaMagna() {
        return cedulaMagna;
    }

    public void setCedulaMagna(String cedulaMagna) {
        this.cedulaMagna = cedulaMagna;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
