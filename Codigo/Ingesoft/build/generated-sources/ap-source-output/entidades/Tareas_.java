package entidades;

import entidades.Miembros;
import entidades.Sprints;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Tareas.class)
public class Tareas_ { 

    public static volatile SingularAttribute<Tareas, String> descripcion;
    public static volatile SingularAttribute<Tareas, String> estado;
    public static volatile SingularAttribute<Tareas, Short> idTarea;
    public static volatile SingularAttribute<Tareas, Sprints> idSprint;
    public static volatile CollectionAttribute<Tareas, Miembros> miembrosCollection;

}