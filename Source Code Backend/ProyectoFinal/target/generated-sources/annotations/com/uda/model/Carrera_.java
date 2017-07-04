package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Carrera.class)
public abstract class Carrera_ {

	public static volatile SingularAttribute<Carrera, String> descripcionCarrera;
	public static volatile SingularAttribute<Carrera, String> nombreCarrera;
	public static volatile SingularAttribute<Carrera, Facultad> facultadId;
	public static volatile SingularAttribute<Carrera, String> horarioCarrera;
	public static volatile SingularAttribute<Carrera, Long> carreraId;
	public static volatile SingularAttribute<Carrera, String> duracionCarrera;

}

