/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "Tareas.findByFechaFin", query = "SELECT t FROM Tareas t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Tareas.findByTitulo", query = "SELECT t FROM Tareas t WHERE t.titulo = :titulo")
    , @NamedQuery(name = "Tareas.findByDescripcion", query = "SELECT t FROM Tareas t WHERE t.descripcion = :descripcion")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_tarea")
    private Integer nroTarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "tarea_nro_estado", referencedColumnName = "nro_estado")
    @ManyToOne(optional = false)
    private Estados tareaNroEstado;
    @JoinColumn(name = "nro_usuario_fk", referencedColumnName = "nro_usuario")
    @ManyToOne(optional = false)
    private Usuarios nroUsuarioFk;

    public Tareas() {
    }

    public Tareas(Integer nroTarea) {
        this.nroTarea = nroTarea;
    }

    public Tareas(Integer nroTarea, Date fechaFin, String titulo, String descripcion) {
        this.nroTarea = nroTarea;
        this.fechaFin = fechaFin;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Integer getNroTarea() {
        return nroTarea;
    }

    public void setNroTarea(Integer nroTarea) {
        this.nroTarea = nroTarea;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estados getTareaNroEstado() {
        return tareaNroEstado;
    }

    public void setTareaNroEstado(Estados tareaNroEstado) {
        this.tareaNroEstado = tareaNroEstado;
    }

    public Usuarios getNroUsuarioFk() {
        return nroUsuarioFk;
    }

    public void setNroUsuarioFk(Usuarios nroUsuarioFk) {
        this.nroUsuarioFk = nroUsuarioFk;
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
