package com.uda.model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Archivo.class)
public abstract class Archivo_ {

	public static volatile SingularAttribute<Archivo, String> descripcion;
	public static volatile SingularAttribute<Archivo, Date> fecha;
	public static volatile SingularAttribute<Archivo, String> tipo;
	public static volatile SingularAttribute<Archivo, Long> archivoID;
	public static volatile SingularAttribute<Archivo, String> tamanio;
	public static volatile SingularAttribute<Archivo, byte[]> documento;
	public static volatile SingularAttribute<Archivo, String> materiaId;
	public static volatile SingularAttribute<Archivo, BigInteger> usuarioId;

}

