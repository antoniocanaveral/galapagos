package com.besixplus.sii.objects;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by acanaveral on 4/7/16.
 */
public class Cgg_not_mail implements Serializable {
  private static final long serialVersionUID = -1925139952547470663L;

    public static String TYPE_TEXT="text";
    public static String TYPE_HTML="html";
    /*
      ntml_codigo character varying NOT NULL,
      ntml_name character varying NOT NULL,
      ntml_description character varying,
      ntml_subject character varying NOT NULL,
      ntml_type character varying NOT NULL DEFAULT 'text'::character varying,
      ntml_body character varying,
      ntml_sendheader boolean DEFAULT false,
      ntml_sendfooter boolean DEFAULT false,
      ntml_header_override character varying,
      ntml_footer_override character varying,
      ntml_estado boolean,
      ntml_fecha_insert timestamp without time zone,
      ntml_usuario_insert character varying(20),
      ntml_fecha_update timestamp without time zone,
      ntml_usuario_update character varying(20),
     */
    private String ntml_codigo;
    private String ntml_name;
    private String ntml_description;
    private String ntml_subject;
    private String ntml_type;
    private String ntml_body;
    private boolean ntml_sendheader;
    private boolean ntml_sendfooter;
    private String ntml_header_override;
    private String ntml_footer_override;
    private boolean ntml_estado;
    private Timestamp ntml_fecha_insert;
    private String ntml_usuario_insert;
    private Timestamp ntml_fecha_update;
    private String ntml_usuario_update;

    public Cgg_not_mail() {
    }

    public String getNtml_codigo() {
        return ntml_codigo;
    }

    public void setNtml_codigo(String ntml_codigo) {
        this.ntml_codigo = ntml_codigo;
    }

    public String getNtml_name() {
        return ntml_name;
    }

    public void setNtml_name(String ntml_name) {
        this.ntml_name = ntml_name;
    }

    public String getNtml_description() {
        return ntml_description;
    }

    public void setNtml_description(String ntml_description) {
        this.ntml_description = ntml_description;
    }

    public String getNtml_subject() {
        return ntml_subject;
    }

    public void setNtml_subject(String ntml_subject) {
        this.ntml_subject = ntml_subject;
    }

    public String getNtml_type() {
        return ntml_type;
    }

    public void setNtml_type(String ntml_type) {
        this.ntml_type = ntml_type;
    }

    public String getNtml_body() {
        return ntml_body;
    }

    public void setNtml_body(String ntml_body) {
        this.ntml_body = ntml_body;
    }

    public boolean isNtml_sendheader() {
        return ntml_sendheader;
    }

    public void setNtml_sendheader(boolean ntml_sendheader) {
        this.ntml_sendheader = ntml_sendheader;
    }

    public boolean isNtml_sendfooter() {
        return ntml_sendfooter;
    }

    public void setNtml_sendfooter(boolean ntml_sendfooter) {
        this.ntml_sendfooter = ntml_sendfooter;
    }

    public String getNtml_header_override() {
        return ntml_header_override;
    }

    public void setNtml_header_override(String ntml_header_override) {
        this.ntml_header_override = ntml_header_override;
    }

    public String getNtml_footer_override() {
        return ntml_footer_override;
    }

    public void setNtml_footer_override(String ntml_footer_override) {
        this.ntml_footer_override = ntml_footer_override;
    }

    public boolean isNtml_estado() {
        return ntml_estado;
    }

    public void setNtml_estado(boolean ntml_estado) {
        this.ntml_estado = ntml_estado;
    }

    public String getNtml_usuario_insert() {
        return ntml_usuario_insert;
    }

    public void setNtml_usuario_insert(String ntml_usuario_insert) {
        this.ntml_usuario_insert = ntml_usuario_insert;
    }

    public String getNtml_usuario_update() {
        return ntml_usuario_update;
    }

    public void setNtml_usuario_update(String ntml_usuario_update) {
        this.ntml_usuario_update = ntml_usuario_update;
    }

    public Timestamp getNtml_fecha_insert() {
        return ntml_fecha_insert;
    }

    public void setNtml_fecha_insert(Timestamp ntml_fecha_insert) {
        this.ntml_fecha_insert = ntml_fecha_insert;
    }

    public Timestamp getNtml_fecha_update() {
        return ntml_fecha_update;
    }

    public void setNtml_fecha_update(Timestamp ntml_fecha_update) {
        this.ntml_fecha_update = ntml_fecha_update;
    }
}
