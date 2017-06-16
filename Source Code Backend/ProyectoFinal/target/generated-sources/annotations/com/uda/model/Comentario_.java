package com.uda.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentario.class)
public abstract class Comentario_ {

	public static volatile SingularAttribute<Comentario, String> descripcion;
	public static volatile SingularAttribute<Comentario, Date> fecha;
	public static volatile SingularAttribute<Comentario, Integer> rating_comentario;
	public static volatile SingularAttribute<Comentario, Materia> materiaId;
	public static volatile SingularAttribute<Comentario, Integer> nhoras;
	public static volatile SingularAttribute<Comentario, Usuario> usuarioId;
	public static volatile SingularAttribute<Comentario, Long> comentarioId;

}

