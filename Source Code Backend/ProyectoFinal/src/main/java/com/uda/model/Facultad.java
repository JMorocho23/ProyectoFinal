/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Diego
 */
@Entity
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FACULTAD_ID")
    private Long facultadId;
    @Size(max = 30)
    private String nombre_facultad;
    @Size(max = 50)
    private String descripcion_facultad;
    @Size(max = 30)
    private String telefono_facultad;
    @JoinColumn(name = "UNIVERSIDAD_ID", referencedColumnName = "UNIVERSIDAD_ID")
    @ManyToOne
    private Universidad universidadId;

    public Long getFacultadId() {
        return facultadId;
    }

    public void setFacultadId(Long facultadId) {
        this.facultadId = facultadId;
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
        return "com.uda.model.Facultad[ id=" + facultadId + " ]";
    }

    /**
     * @return the nombre_facultad
     */
    public String getNombre_facultad() {
        return nombre_facultad;
    }

    /**
     * @param nombre_facultad the nombre_facultad to set
     */
    public void setNombre_facultad(String nombre_facultad) {
        this.nombre_facultad = nombre_facultad;
    }

    /**
     * @return the descripcion_facultad
     */
    public String getDescripcion_facultad() {
        return descripcion_facultad;
    }

    /**
     * @param descripcion_facultad the descripcion_facultad to set
     */
    public void setDescripcion_facultad(String descripcion_facultad) {
        this.descripcion_facultad = descripcion_facultad;
    }

    /**
     * @return the telefono_facultad
     */
    public String getTelefono_facultad() {
        return telefono_facultad;
    }

    /**
     * @param telefono_facultad the telefono_facultad to set
     */
    public void setTelefono_facultad(String telefono_facultad) {
        this.telefono_facultad = telefono_facultad;
    }

    /**
     * @return the universidadId
     */
    public Universidad getUniversidadId() {
        return universidadId;
    }

    /**
     * @param universidadId the universidadId to set
     */
    public void setUniversidadId(Universidad universidadId) {
        this.universidadId = universidadId;
    }
    
}
