/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anticlutch
 */
@Entity
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")
    , @NamedQuery(name = "Archivo.findByArchivoID", query = "SELECT a FROM Archivo a WHERE a.archivoID = :archivoID")
    , @NamedQuery(name = "Archivo.findByDescripcion", query = "SELECT a FROM Archivo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Archivo.findByTipo", query = "SELECT a FROM Archivo a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Archivo.findByTamanio", query = "SELECT a FROM Archivo a WHERE a.tamanio = :tamanio")
    , @NamedQuery(name = "Archivo.findByFecha", query = "SELECT a FROM Archivo a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Archivo.findByMateriaId", query = "SELECT a FROM Archivo a WHERE a.materiaId = :materiaId")
    , @NamedQuery(name = "Archivo.findByUsuarioId", query = "SELECT a FROM Archivo a WHERE a.usuarioId = :usuarioId")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Archivo_ID")
    private Long archivoID;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 50)
    @Column(name = "tamanio")
    private String tamanio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Lob
    @Column(name = "documento")
    private byte[] documento;
    @Size(max = 255)
    @Column(name = "MATERIA_ID")
    private String materiaId;
    @Column(name = "USUARIO_ID")
    private BigInteger usuarioId;

    public Archivo() {
    }

    public Archivo(Long archivoID) {
        this.archivoID = archivoID;
    }

    public Archivo(Long archivoID, Date fecha) {
        this.archivoID = archivoID;
        this.fecha = fecha;
    }

    public Long getArchivoID() {
        return archivoID;
    }

    public void setArchivoID(Long archivoID) {
        this.archivoID = archivoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archivoID != null ? archivoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.archivoID == null && other.archivoID != null) || (this.archivoID != null && !this.archivoID.equals(other.archivoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Archivo[ archivoID=" + archivoID + " ]";
    }
    
}
