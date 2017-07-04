/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anticlutch
 */
@Entity
@Table(name = "facultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f")
    , @NamedQuery(name = "Facultad.findByFacultadId", query = "SELECT f FROM Facultad f WHERE f.facultadId = :facultadId")
    , @NamedQuery(name = "Facultad.findByDescripcionFacultad", query = "SELECT f FROM Facultad f WHERE f.descripcionFacultad = :descripcionFacultad")
    , @NamedQuery(name = "Facultad.findByNombreFacultad", query = "SELECT f FROM Facultad f WHERE f.nombreFacultad = :nombreFacultad")
    , @NamedQuery(name = "Facultad.findByTelefonoFacultad", query = "SELECT f FROM Facultad f WHERE f.telefonoFacultad = :telefonoFacultad")
    , @NamedQuery(name = "Facultad.findByUniversidadId", query = "SELECT f FROM Facultad f WHERE f.universidadId = :universidadId")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FACULTAD_ID")
    private Long facultadId;
    @Size(max = 50)
    @Column(name = "descripcion_facultad")
    private String descripcionFacultad;
    @Size(max = 100)
    @Column(name = "nombre_facultad")
    private String nombreFacultad;
    @Size(max = 30)
    @Column(name = "telefono_facultad")
    private String telefonoFacultad;
    @JoinColumn(name = "UNIVERSIDAD_ID", referencedColumnName = "UNIVERSIDAD_ID")
    @ManyToOne
    private Universidad universidadId;

    public Facultad() {
    }

    public Facultad(Long facultadId) {
        this.facultadId = facultadId;
    }

    public Long getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Long facultadId) {
        this.facultadId = facultadId;
    }

    public String getDescripcionFacultad() {
        return descripcionFacultad;
    }

    public void setDescripcionFacultad(String descripcionFacultad) {
        this.descripcionFacultad = descripcionFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public String getTelefonoFacultad() {
        return telefonoFacultad;
    }

    public void setTelefonoFacultad(String telefonoFacultad) {
        this.telefonoFacultad = telefonoFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultadId != null ? facultadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.facultadId == null && other.facultadId != null) || (this.facultadId != null && !this.facultadId.equals(other.facultadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Facultad[ facultadId=" + facultadId + " ]";
    }
    
}
