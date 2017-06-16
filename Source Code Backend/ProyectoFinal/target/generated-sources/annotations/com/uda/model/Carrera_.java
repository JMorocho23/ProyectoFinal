package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Carrera.class)
public abstract class Carrera_ {

	public static volatile SingularAttribute<Carrera, String> duracion_carrera;
	public static volatile SingularAttribute<Carrera, Facultad> facultadId;
	public static volatile SingularAttribute<Carrera, String> nombre_carrera;
	public static volatile SingularAttribute<Carrera, String> descripcion_carrera;
	public static volatile SingularAttribute<Carrera, String> horario_carrera;
	public static volatile SingularAttribute<Carrera, Long> carreraId;

}

