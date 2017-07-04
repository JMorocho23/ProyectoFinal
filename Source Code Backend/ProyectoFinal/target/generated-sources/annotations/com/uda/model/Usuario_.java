package com.uda.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile SingularAttribute<Usuario, String> tipoUsuario;
	public static volatile SingularAttribute<Usuario, String> nombreUsuario;
	public static volatile SingularAttribute<Usuario, String> nombreApe;
	public static volatile SingularAttribute<Usuario, String> telefono;
	public static volatile SingularAttribute<Usuario, Long> usuarioId;
	public static volatile SingularAttribute<Usuario, String> email;

}

