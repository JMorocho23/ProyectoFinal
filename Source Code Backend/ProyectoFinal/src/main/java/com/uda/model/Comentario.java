/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import java.util.Date;
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
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMENTARIO_ID")
    private Long comentarioId;
    @Size(max = 5)
    private Integer rating_comentario;
    @Size(max = 500)
    private String descripcion;
    @Size(max = 30)
    private Integer nhoras;
    private Date fecha;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID")
    @ManyToOne
    private Usuario usuarioId;
    @JoinColumn(name = "MATERIA_ID", referencedColumnName = "MATERIA_ID")
    @ManyToOne
    private Materia materiaId;

    public Long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uda.model.Comentarios[ id=" + comentarioId + " ]";
    }
    
    /**
     * @return the rating_comentario
     */
    public Integer getRating_comentario() {
        return rating_comentario;
    }

    /**
     * @param rating_comentario the rating_comentario to set
     */
    public void setRating_comentario(Integer rating_comentario) {
        this.rating_comentario = rating_comentario;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nhoras
     */
    public Integer getNhoras() {
        return nhoras;
    }

    /**
     * @param nhoras the nhoras to set
     */
    public void setNhoras(Integer nhoras) {
        this.nhoras = nhoras;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
