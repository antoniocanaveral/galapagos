package com.bmlaurus.ws.dinardap;

import java.util.List;

/**
 * Created by acanaveral on 3/8/16.
 */
public class SRI extends DinardapService {

    private String numeroRuc;
    private String personaSociedad;
    private String razonSocial;
    private String nombreFantasiaComercial;
    private String fechaInicioActividades;
    private String fechaCancelacion;
    private String fechaSuspencionDefinitiva;
    private String actividadEconomicaPrincipal;
    private List<SRIEstablecimiento> SRIEstablecimiento;

    public SRI(String numeroIdentificacion) {
        super(SERVICE_SRI, numeroIdentificacion);
    }

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public String getPersonaSociedad() {
        return personaSociedad;
    }

    public void setPersonaSociedad(String personaSociedad) {
        this.personaSociedad = personaSociedad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreFantasiaComercial() {
        return nombreFantasiaComercial;
    }

    public void setNombreFantasiaComercial(String nombreFantasiaComercial) {
        this.nombreFantasiaComercial = nombreFantasiaComercial;
    }

    public String getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(String fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getFechaSuspencionDefinitiva() {
        return fechaSuspencionDefinitiva;
    }

    public void setFechaSuspencionDefinitiva(String fechaSuspencionDefinitiva) {
        this.fechaSuspencionDefinitiva = fechaSuspencionDefinitiva;
    }

    public String getActividadEconomicaPrincipal() {
        return actividadEconomicaPrincipal;
    }

    public void setActividadEconomicaPrincipal(String actividadEconomicaPrincipal) {
        this.actividadEconomicaPrincipal = actividadEconomicaPrincipal;
    }

    public List<com.bmlaurus.ws.dinardap.SRIEstablecimiento> getSRIEstablecimiento() {
        return SRIEstablecimiento;
    }

    public void setSRIEstablecimiento(List SRIEstablecimiento) {
        this.SRIEstablecimiento = SRIEstablecimiento;
    }
}