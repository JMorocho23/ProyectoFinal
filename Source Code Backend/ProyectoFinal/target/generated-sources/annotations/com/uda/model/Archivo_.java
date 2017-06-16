package com.uda.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Archivo.class)
public abstract class Archivo_ {

	public static volatile SingularAttribute<Archivo, String> descripcion;
	public static volatile SingularAttribute<Archivo, Byte> path;
	public static volatile SingularAttribute<Archivo, Date> fecha;
	public static volatile SingularAttribute<Archivo, Long> archivoId;
	public static volatile SingularAttribute<Archivo, Materia> materiaId;
	public static volatile SingularAttribute<Archivo, Usuario> usuarioId;

}

