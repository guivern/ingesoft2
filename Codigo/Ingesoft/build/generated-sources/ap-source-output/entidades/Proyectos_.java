package entidades;

import entidades.Equipos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Proyectos.class)
public class Proyectos_ { 

    public static volatile SingularAttribute<Proyectos, String> descripcion;
    public static volatile SingularAttribute<Proyectos, Short> idProyecto;
    public static volatile SingularAttribute<Proyectos, String> estado;
    public static volatile SingularAttribute<Proyectos, Equipos> idEquipo;
    public static volatile SingularAttribute<Proyectos, String> nomProyecto;

}