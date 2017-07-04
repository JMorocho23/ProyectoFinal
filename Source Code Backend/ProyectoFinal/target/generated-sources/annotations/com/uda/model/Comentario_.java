package com.uda.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentario.class)
public abstract class Comentario_ {

	public static volatile SingularAttribute<Comentario, String> descripcion;
	public static volatile SingularAttribute<Comentario, Integer> ratingComentario;
	public static volatile SingularAttribute<Comentario, Date> fechaCommentario;
	public static volatile SingularAttribute<Comentario, String> semestreMes;
	public static volatile SingularAttribute<Comentario, String> materiaId;
	public static volatile SingularAttribute<Comentario, Integer> semestreAnio;
	public static volatile SingularAttribute<Comentario, Integer> nhoras;
	public static volatile SingularAttribute<Comentario, BigInteger> usuarioId;
	public static volatile SingularAttribute<Comentario, Long> comentarioId;
	public static volatile SingularAttribute<Comentario, String> consejo;

}

