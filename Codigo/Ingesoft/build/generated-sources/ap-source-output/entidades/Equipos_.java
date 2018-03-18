package entidades;

import entidades.Miembros;
import entidades.Proyectos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Equipos.class)
public class Equipos_ { 

    public static volatile SingularAttribute<Equipos, Short> idEquipo;
    public static volatile CollectionAttribute<Equipos, Proyectos> proyectosCollection;
    public static volatile CollectionAttribute<Equipos, Miembros> miembrosCollection;
    public static volatile SingularAttribute<Equipos, String> nombre;

}