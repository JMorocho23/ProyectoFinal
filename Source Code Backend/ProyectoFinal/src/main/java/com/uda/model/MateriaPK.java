/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Anticlutch
 */
@Embeddable
public class MateriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MATERIA_ID")
    private String materiaId;
    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "CARRERA_ID", referencedColumnName = "CARRERA_ID")
    @ManyToOne
    private Carrera carreraId;


    public MateriaPK() {
    }

    public MateriaPK(String materiaId, Carrera carreraId) {
        this.materiaId = materiaId;
        this.carreraId = carreraId;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaId != null ? materiaId.hashCode() : 0);
        //hash += (int) carreraId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaPK)) {
            return false;
        }
        MateriaPK other = (MateriaPK) object;
        if ((this.materiaId == null && other.materiaId != null) || (this.materiaId != null && !this.materiaId.equals(other.materiaId))) {
            return false;
        }
        if (this.carreraId != other.carreraId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.MateriaPK[ materiaId=" + materiaId + ", carreraId=" + carreraId + " ]";
    }
    
}
