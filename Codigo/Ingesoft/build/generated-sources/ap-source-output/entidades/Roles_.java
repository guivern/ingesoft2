package entidades;

import entidades.Miembros;
import entidades.Permisos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, String> descripcion;
    public static volatile SingularAttribute<Roles, Short> idRol;
    public static volatile CollectionAttribute<Roles, Permisos> permisosCollection;
    public static volatile CollectionAttribute<Roles, Miembros> miembrosCollection;

}