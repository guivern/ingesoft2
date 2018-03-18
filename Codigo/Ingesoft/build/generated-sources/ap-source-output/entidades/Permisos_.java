package entidades;

import entidades.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Permisos.class)
public class Permisos_ { 

    public static volatile SingularAttribute<Permisos, String> descripcion;
    public static volatile SingularAttribute<Permisos, Short> idPermiso;
    public static volatile CollectionAttribute<Permisos, Roles> rolesCollection;

}