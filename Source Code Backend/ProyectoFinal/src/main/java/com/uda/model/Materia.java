/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

/**
 *
 * @author Diego
 */
@Entity
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATERIA_ID")
    private Long materiaId;
    @Size(max = 30)
    private String nombre_materia;
    @Size(max = 50)
    private String descripcion_materia;
    @Size(max = 30)
    private Integer numero_creditos;
    @Size(max = 30)
    private Integer rating_materia;
    @Size(max = 30)
    private Integer nivel;
    @JoinColumn(name = "CARRERA_ID", referencedColumnName = "CARRERA_ID")
    @ManyToOne
    private Carrera carreraId;

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaId != null ? materiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaId == null && other.materiaId != null) || (this.materiaId != null && !this.materiaId.equals(other.materiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Materia[ id=" + materiaId + " ]";
    }

    /**
     * @return the nombre_materia
     */
    public String getNombre_materia() {
        return nombre_materia;
    }

    /**
     * @param nombre_materia the nombre_materia to set
     */
    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    /**
     * @return the descripcion_materia
     */
    public String getDescripcion_materia() {
        return descripcion_materia;
    }

    /**
     * @param descripcion_materia the descripcion_materia to set
     */
    public void setDescripcion_materia(String descripcion_materia) {
        this.descripcion_materia = descripcion_materia;
    }

    /**
     * @return the numero_creditos
     */
    public Integer getNumero_creditos() {
        return numero_creditos;
    }

    /**
     * @param numero_creditos the numero_creditos to set
     */
    public void setNumero_creditos(Integer numero_creditos) {
        this.numero_creditos = numero_creditos;
    }

    /**
     * @return the rating_materia
     */
    public Integer getRating_materia() {
        return rating_materia;
    }

    /**
     * @param rating_materia the rating_materia to set
     */
    public void setRating_materia(Integer rating_materia) {
        this.rating_materia = rating_materia;
    }

    /**
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
}
