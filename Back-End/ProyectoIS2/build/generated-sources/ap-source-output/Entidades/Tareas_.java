package Entidades;

import Entidades.Estados;
import Entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T14:40:48")
@StaticMetamodel(Tareas.class)
public class Tareas_ { 

    public static volatile SingularAttribute<Tareas, String> descripcion;
    public static volatile SingularAttribute<Tareas, Usuarios> nroUsuarioFk;
    public static volatile SingularAttribute<Tareas, Integer> nroTarea;
    public static volatile SingularAttribute<Tareas, String> titulo;
    public static volatile SingularAttribute<Tareas, Estados> tareaNroEstado;
    public static volatile SingularAttribute<Tareas, Date> fechaFin;

}