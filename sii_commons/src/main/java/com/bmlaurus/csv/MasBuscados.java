package com.bmlaurus.csv;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by acanaveral on 1/9/16.
 */
public class MasBuscados implements Serializable{
    private String tipoIdentificacion;
    private String identificacion;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Date fecha;
    private boolean estado;

    public MasBuscados(String tipoIdentificacion, String identificacion, String apellidoPaterno, String apellidoMaterno, String nombres, String fecha, String estado) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fecha = new Date(sdf.parse(fecha).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.estado = Boolean.valueOf(estado);
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{'tipoIdentificacion':'"+tipoIdentificacion+"',");
        builder.append("'identificacion':'"+identificacion+"',");
        builder.append("'apellidoPaterno':'"+apellidoPaterno+"',");
        builder.append("'apellidoMaterno':'"+apellidoMaterno+"',");
        builder.append("'nombres':'"+nombres+"',");
        builder.append("'fecha':'"+fecha+"',");
        builder.append("'estado':"+estado+"}");
        return builder.toString();
    }
}
