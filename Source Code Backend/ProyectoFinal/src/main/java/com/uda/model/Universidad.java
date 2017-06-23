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
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Diego
 */
@Entity
public class Universidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIVERSIDAD_ID")
    private Long universidadId;
    @Size(max = 30)
    private String nombre_universidad;
    @Size(max = 100)
    private String descripccion_universidad;
    @Size(max = 300)
    private String direccion_universidad;
    @Size(max = 30)
    private String telefono_universidad;

    public Long getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(Long universidadId) {
        this.universidadId = universidadId;
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
        return "com.uda.model.Universidad[ id=" + universidadId + " ]";
    }

    /**
     * @return the nombre_universidad
     */
    public String getNombre_universidad() {
        return nombre_universidad;
    }

    /**
     * @param nombre_universidad the nombre_universidad to set
     */
    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    /**
     * @return the descripccion_universidad
     */
    public String getDescripccion_universidad() {
        return descripccion_universidad;
    }

    /**
     * @param descripccion_universidad the descripccion_universidad to set
     */
    public void setDescripccion_universidad(String descripccion_universidad) {
        this.descripccion_universidad = descripccion_universidad;
    }

    /**
     * @return the direccion_universidad
     */
    public String getDireccion_universidad() {
        return direccion_universidad;
    }

    /**
     * @param direccion_universidad the direccion_universidad to set
     */
    public void setDireccion_universidad(String direccion_universidad) {
        this.direccion_universidad = direccion_universidad;
    }

    /**
     * @return the telefono_universidad
     */
    public String getTelefono_universidad() {
        return telefono_universidad;
    }

    /**
     * @param telefono_universidad the telefono_universidad to set
     */
    public void setTelefono_universidad(String telefono_universidad) {
        this.telefono_universidad = telefono_universidad;
    }
    
}
