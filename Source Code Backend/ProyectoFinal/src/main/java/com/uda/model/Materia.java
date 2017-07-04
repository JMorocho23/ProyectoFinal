/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByMateriaId", query = "SELECT m FROM Materia m WHERE m.materiaPK.materiaId = :materiaId")
    , @NamedQuery(name = "Materia.findByDescripcionMateria", query = "SELECT m FROM Materia m WHERE m.descripcionMateria = :descripcionMateria")
    , @NamedQuery(name = "Materia.findByNivel", query = "SELECT m FROM Materia m WHERE m.nivel = :nivel")
    , @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Materia.findByNumeroCreditos", query = "SELECT m FROM Materia m WHERE m.numeroCreditos = :numeroCreditos")    
    , @NamedQuery(name = "Materia.findByRatingMateria", query = "SELECT m FROM Materia m WHERE m.ratingMateria = :ratingMateria")
    , @NamedQuery(name = "Materia.findByCarreraId", query = "SELECT m FROM Materia m WHERE m.materiaPK.carreraId = :carreraId")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaPK materiaPK;
    @Size(max = 50)
    @Column(name = "descripcion_materia")
    private String descripcionMateria;
    @Column(name = "nivel")
    private Integer nivel;
    @Size(max = 50)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Column(name = "numero_creditos")
    private Integer numeroCreditos;
    @Column(name = "rating_materia")
    private Integer ratingMateria;

    public Materia() {
    }

    public Materia(MateriaPK materiaPK) {
        this.materiaPK = materiaPK;
    }

    public Materia(String materiaId, Carrera carreraId) {
        this.materiaPK = new MateriaPK(materiaId, carreraId);
    }

    public MateriaPK getMateriaPK() {
        return materiaPK;
    }

    public void setMateriaPK(MateriaPK materiaPK) {
        this.materiaPK = materiaPK;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getRatingMateria() {
        return ratingMateria;
    }

    public void setRatingMateria(Integer ratingMateria) {
        this.ratingMateria = ratingMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaPK != null ? materiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaPK == null && other.materiaPK != null) || (this.materiaPK != null && !this.materiaPK.equals(other.materiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Materia[ materiaPK=" + materiaPK + " ]";
    }
    
}
