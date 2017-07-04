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
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByCarreraId", query = "SELECT c FROM Carrera c WHERE c.carreraId = :carreraId")
    , @NamedQuery(name = "Carrera.findByDescripcionCarrera", query = "SELECT c FROM Carrera c WHERE c.descripcionCarrera = :descripcionCarrera")
    , @NamedQuery(name = "Carrera.findByDuracionCarrera", query = "SELECT c FROM Carrera c WHERE c.duracionCarrera = :duracionCarrera")
    , @NamedQuery(name = "Carrera.findByHorarioCarrera", query = "SELECT c FROM Carrera c WHERE c.horarioCarrera = :horarioCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")    
    , @NamedQuery(name = "Carrera.findByFacultadId", query = "SELECT c FROM Carrera c WHERE c.facultadId = :facultadId")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CARRERA_ID")
    private Long carreraId;
    @Size(max = 200)
    @Column(name = "descripcion_carrera")
    private String descripcionCarrera;
    @Size(max = 50)
    @Column(name = "duracion_carrera")
    private String duracionCarrera;
    @Size(max = 30)
    @Column(name = "horario_carrera")
    private String horarioCarrera;
    @Size(max = 75)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @JoinColumn(name = "FACULTAD_ID", referencedColumnName = "FACULTAD_ID")
    @ManyToOne
    private Facultad facultadId;

    public Carrera() {
    }

    public Carrera(Long carreraId) {
        this.carreraId = carreraId;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }

    public String getDescripcionCarrera() {
        return descripcionCarrera;
    }

    public void setDescripcionCarrera(String descripcionCarrera) {
        this.descripcionCarrera = descripcionCarrera;
    }

    public String getDuracionCarrera() {
        return duracionCarrera;
    }

    public void setDuracionCarrera(String duracionCarrera) {
        this.duracionCarrera = duracionCarrera;
    }

    public String getHorarioCarrera() {
        return horarioCarrera;
    }

    public void setHorarioCarrera(String horarioCarrera) {
        this.horarioCarrera = horarioCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
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
        return "com.uda.model.Carrera[ carreraId=" + carreraId + " ]";
    }
    
}
