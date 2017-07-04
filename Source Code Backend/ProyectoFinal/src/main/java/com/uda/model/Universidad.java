/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "universidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u")
    , @NamedQuery(name = "Universidad.findByUniversidadId", query = "SELECT u FROM Universidad u WHERE u.universidadId = :universidadId")
    , @NamedQuery(name = "Universidad.findByDescripccionUniversidad", query = "SELECT u FROM Universidad u WHERE u.descripccionUniversidad = :descripccionUniversidad")
    , @NamedQuery(name = "Universidad.findByDireccionUniversidad", query = "SELECT u FROM Universidad u WHERE u.direccionUniversidad = :direccionUniversidad")
    , @NamedQuery(name = "Universidad.findByNombreUniversidad", query = "SELECT u FROM Universidad u WHERE u.nombreUniversidad = :nombreUniversidad")
    , @NamedQuery(name = "Universidad.findByTelefonoUniversidad", query = "SELECT u FROM Universidad u WHERE u.telefonoUniversidad = :telefonoUniversidad")})
public class Universidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UNIVERSIDAD_ID")
    private Long universidadId;
    @Size(max = 300)
    @Column(name = "descripccion_universidad")
    private String descripccionUniversidad;
    @Size(max = 100)
    @Column(name = "direccion_universidad")
    private String direccionUniversidad;
    @Size(max = 100)
    @Column(name = "nombre_universidad")
    private String nombreUniversidad;
    @Size(max = 30)
    @Column(name = "telefono_universidad")
    private String telefonoUniversidad;

    public Universidad() {
    }

    public Universidad(Long universidadId) {
        this.universidadId = universidadId;
    }

    public Long getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Long universidadId) {
        this.universidadId = universidadId;
    }

    public String getDescripccionUniversidad() {
        return descripccionUniversidad;
    }

    public void setDescripccionUniversidad(String descripccionUniversidad) {
        this.descripccionUniversidad = descripccionUniversidad;
    }

    public String getDireccionUniversidad() {
        return direccionUniversidad;
    }

    public void setDireccionUniversidad(String direccionUniversidad) {
        this.direccionUniversidad = direccionUniversidad;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public String getTelefonoUniversidad() {
        return telefonoUniversidad;
    }

    public void setTelefonoUniversidad(String telefonoUniversidad) {
        this.telefonoUniversidad = telefonoUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universidadId != null ? universidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.universidadId == null && other.universidadId != null) || (this.universidadId != null && !this.universidadId.equals(other.universidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Universidad[ universidadId=" + universidadId + " ]";
    }
    
}
