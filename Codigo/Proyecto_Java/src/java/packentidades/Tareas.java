/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packentidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alan
 */
@Entity
@Table(name = "tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t")
    , @NamedQuery(name = "Tareas.findByIdTarea", query = "SELECT t FROM Tareas t WHERE t.idTarea = :idTarea")
    , @NamedQuery(name = "Tareas.findByDescripcion", query = "SELECT t FROM Tareas t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tareas.findByEstado", query = "SELECT t FROM Tareas t WHERE t.estado = :estado")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarea")
    private Short idTarea;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_sprint", referencedColumnName = "id_sprint")
    @ManyToOne(optional = false)
    private Sprints idSprint;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTarea")
    private Collection<Miembros> miembrosCollection;

    public Tareas() {
    }

    public Tareas(Short idTarea) {
        this.idTarea = idTarea;
    }

    public Short getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Short idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sprints getIdSprint() {
        return idSprint;
    }

    public void setIdSprint(Sprints idSprint) {
        this.idSprint = idSprint;
    }

    @XmlTransient
    public Collection<Miembros> getMiembrosCollection() {
        return miembrosCollection;
    }

    public void setMiembrosCollection(Collection<Miembros> miembrosCollection) {
        this.miembrosCollection = miembrosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packentidades.Tareas[ idTarea=" + idTarea + " ]";
    }
    
}
