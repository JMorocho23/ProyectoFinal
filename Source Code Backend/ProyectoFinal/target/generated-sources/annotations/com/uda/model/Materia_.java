package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Materia.class)
public abstract class Materia_ {

	public static volatile SingularAttribute<Materia, String> nombre_materia;
	public static volatile SingularAttribute<Materia, String> descripcion_materia;
	public static volatile SingularAttribute<Materia, Integer> numero_creditos;
	public static volatile SingularAttribute<Materia, Long> materiaId;
	public static volatile SingularAttribute<Materia, Integer> nivel;
	public static volatile SingularAttribute<Materia, Carrera> carreraId;
	public static volatile SingularAttribute<Materia, Integer> rating_materia;

}

