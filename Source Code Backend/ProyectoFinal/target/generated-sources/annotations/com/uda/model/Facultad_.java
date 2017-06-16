package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facultad.class)
public abstract class Facultad_ {

	public static volatile SingularAttribute<Facultad, String> nombre_facultad;
	public static volatile SingularAttribute<Facultad, Universidad> universidadId;
	public static volatile SingularAttribute<Facultad, String> descripcion_facultad;
	public static volatile SingularAttribute<Facultad, String> telefono_facultad;
	public static volatile SingularAttribute<Facultad, Long> facultadId;

}

