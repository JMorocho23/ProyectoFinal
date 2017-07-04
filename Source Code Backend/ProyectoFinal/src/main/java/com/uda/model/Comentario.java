/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uda.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anticlutch
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByComentarioId", query = "SELECT c FROM Comentario c WHERE c.comentarioId = :comentarioId")
    , @NamedQuery(name = "Comentario.findByDescripcion", query = "SELECT c FROM Comentario c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Comentario.findByConsejo", query = "SELECT c FROM Comentario c WHERE c.consejo = :consejo")
    , @NamedQuery(name = "Comentario.findByFechaCommentario", query = "SELECT c FROM Comentario c WHERE c.fechaCommentario = :fechaCommentario")
    , @NamedQuery(name = "Comentario.findByNhoras", query = "SELECT c FROM Comentario c WHERE c.nhoras = :nhoras")
    , @NamedQuery(name = "Comentario.findByRatingComentario", query = "SELECT c FROM Comentario c WHERE c.ratingComentario = :ratingComentario")
    , @NamedQuery(name = "Comentario.findBySemestreMes", query = "SELECT c FROM Comentario c WHERE c.semestreMes = :semestreMes")
    , @NamedQuery(name = "Comentario.findBySemestreAnio", query = "SELECT c FROM Comentario c WHERE c.semestreAnio = :semestreAnio")
    , @NamedQuery(name = "Comentario.findByMateriaId", query = "SELECT c FROM Comentario c WHERE c.materiaId = :materiaId")
    , @NamedQuery(name = "Comentario.findByUsuarioId", query = "SELECT c FROM Comentario c WHERE c.usuarioId = :usuarioId")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMENTARIO_ID")
    private Long comentarioId;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "consejo")
    private String consejo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_commentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCommentario;
    @Column(name = "nhoras")
    private Integer nhoras;
    @Column(name = "rating_comentario")
    private Integer ratingComentario;
    @Size(max = 30)
    @Column(name = "semestre_mes")
    private String semestreMes;
    @Column(name = "semestre_anio")
    private Integer semestreAnio;
    @Size(max = 255)
    @Column(name = "MATERIA_ID")
    private String materiaId;
    @Column(name = "USUARIO_ID")
    private BigInteger usuarioId;

    public Comentario() {
    }

    public Comentario(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Comentario(Long comentarioId, Date fechaCommentario) {
        this.comentarioId = comentarioId;
        this.fechaCommentario = fechaCommentario;
    }

    public Long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    public Date getFechaCommentario() {
        return fechaCommentario;
    }

    public void setFechaCommentario(Date fechaCommentario) {
        this.fechaCommentario = fechaCommentario;
    }

    public Integer getNhoras() {
        return nhoras;
    }

    public void setNhoras(Integer nhoras) {
        this.nhoras = nhoras;
    }

    public Integer getRatingComentario() {
        return ratingComentario;
    }

    public void setRatingComentario(Integer ratingComentario) {
        this.ratingComentario = ratingComentario;
    }

    public String getSemestreMes() {
        return semestreMes;
    }

    public void setSemestreMes(String semestreMes) {
        this.semestreMes = semestreMes;
    }

    public Integer getSemestreAnio() {
        return semestreAnio;
    }

    public void setSemestreAnio(Integer semestreAnio) {
        this.semestreAnio = semestreAnio;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
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
        return "com.uda.model.Comentario[ comentarioId=" + comentarioId + " ]";
    }
    
}
