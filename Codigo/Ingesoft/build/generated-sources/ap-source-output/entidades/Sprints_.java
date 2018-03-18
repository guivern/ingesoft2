package entidades;

import entidades.Tareas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Sprints.class)
public class Sprints_ { 

    public static volatile SingularAttribute<Sprints, String> descripcion;
    public static volatile SingularAttribute<Sprints, Date> fechaIni;
    public static volatile CollectionAttribute<Sprints, Tareas> tareasCollection;
    public static volatile SingularAttribute<Sprints, Short> idSprint;
    public static volatile SingularAttribute<Sprints, Date> fechaFin;

}