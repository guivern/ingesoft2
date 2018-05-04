package Entidades;

import Entidades.Tareas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T14:40:48")
@StaticMetamodel(Estados.class)
public class Estados_ { 

    public static volatile SingularAttribute<Estados, String> estado;
    public static volatile CollectionAttribute<Estados, Tareas> tareasCollection;
    public static volatile SingularAttribute<Estados, Integer> nroEstado;

}