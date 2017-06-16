package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Documento.class)
public abstract class Documento_ {

	public static volatile SingularAttribute<Documento, Integer> numero_pagina;
	public static volatile SingularAttribute<Documento, String> nombre_doc;
	public static volatile SingularAttribute<Documento, String> tipo_doc;
	public static volatile SingularAttribute<Documento, Usuario> id_usuario;
	public static volatile SingularAttribute<Documento, Long> id;
	public static volatile SingularAttribute<Documento, Materia> id_materia;

}

