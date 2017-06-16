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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
/**
 *
 * @author Diego
 */
@Entity
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARRERA_ID")
    private Long carreraId;
    @Size(max = 30)
    private String nombre_carrera;
    @Size(max = 50)
    private String descripcion_carrera;
    @Size(max = 30)
    private String duracion_carrera;
    @Size(max = 30)
    private String horario_carrera;
    @JoinColumn(name = "FACULTAD_ID", referencedColumnName = "FACULTAD_ID")
    @ManyToOne
    private Facultad facultadId;

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carreraId != null ? carreraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.carreraId == null && other.carreraId != null) || (this.carreraId != null && !this.carreraId.equals(other.carreraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Carrera[ id=" + carreraId + " ]";
    }

    /**
     * @return the nombre_carrera
     */
    public String getNombre_carrera() {
        return nombre_carrera;
    }

    /**
     * @param nombre_carrera the nombre_carrera to set
     */
    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    /**
     * @return the descripcion_carrera
     */
    public String getDescripcion_carrera() {
        return descripcion_carrera;
    }

    /**
     * @param descripcion_carrera the descripcion_carrera to set
     */
    public void setDescripcion_carrera(String descripcion_carrera) {
        this.descripcion_carrera = descripcion_carrera;
    }

    /**
     * @return the duracion_carrera
     */
    public String getDuracion_carrera() {
        return duracion_carrera;
    }

    /**
     * @param duracion_carrera the duracion_carrera to set
     */
    public void setDuracion_carrera(String duracion_carrera) {
        this.duracion_carrera = duracion_carrera;
    }

    /**
     * @return the horario_carrera
     */
    public String getHorario_carrera() {
        return horario_carrera;
    }

    /**
     * @param horario_carrera the horario_carrera to set
     */
    public void setHorario_carrera(String horario_carrera) {
        this.horario_carrera = horario_carrera;
    }
    
}
