/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guiver
 */
@Entity
@Table(name = "tareas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t")
    , @NamedQuery(name = "Tareas.findByNroTarea", query = "SELECT t FROM Tareas t WHERE t.nroTarea = :nroTarea")
    , @NamedQuery(name = "Tareas.findByTituloTarea", query = "SELECT t FROM Tareas t WHERE t.tituloTarea = :tituloTarea")
    , @NamedQuery(name = "Tareas.findByDescripcion", query = "SELECT t FROM Tareas t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tareas.findByEstado", query = "SELECT t FROM Tareas t WHERE t.estado = :estado")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_tarea")
    private Integer nroTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo_tarea")
    private String tituloTarea;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "nro_sprint", referencedColumnName = "nro_sprint")
    @ManyToOne(optional = false)
    private Sprints nroSprint;
    @JoinColumn(name = "nro_usuario", referencedColumnName = "nro_usuario")
    @ManyToOne(optional = false)
    private Usuarios nroUsuario;

    public Tareas() {
    }

    public Tareas(Integer nroTarea) {
        this.nroTarea = nroTarea;
    }

    public Tareas(Integer nroTarea, String tituloTarea) {
        this.nroTarea = nroTarea;
        this.tituloTarea = tituloTarea;
    }

    public Integer getNroTarea() {
        return nroTarea;
    }

    public void setNroTarea(Integer nroTarea) {
        this.nroTarea = nroTarea;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
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

    public Sprints getNroSprint() {
        return nroSprint;
    }

    public void setNroSprint(Sprints nroSprint) {
        this.nroSprint = nroSprint;
    }

    public Usuarios getNroUsuario() {
        return nroUsuario;
    }

    public void setNroUsuario(Usuarios nroUsuario) {
        this.nroUsuario = nroUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroTarea != null ? nroTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.nroTarea == null && other.nroTarea != null) || (this.nroTarea != null && !this.nroTarea.equals(other.nroTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tareas[ nroTarea=" + nroTarea + " ]";
    }
    
}
