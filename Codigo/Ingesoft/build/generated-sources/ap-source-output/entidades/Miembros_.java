package entidades;

import entidades.Equipos;
import entidades.MiembrosPK;
import entidades.Roles;
import entidades.Tareas;
import entidades.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-17T16:21:29")
@StaticMetamodel(Miembros.class)
public class Miembros_ { 

    public static volatile SingularAttribute<Miembros, Roles> idRol;
    public static volatile SingularAttribute<Miembros, Tareas> idTarea;
    public static volatile SingularAttribute<Miembros, MiembrosPK> miembrosPK;
    public static volatile SingularAttribute<Miembros, Usuarios> usuarios;
    public static volatile SingularAttribute<Miembros, Equipos> equipos;

}