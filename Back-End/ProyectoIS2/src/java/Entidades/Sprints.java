/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guiver
 */
@Entity
@Table(name = "sprints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprints.findAll", query = "SELECT s FROM Sprints s")
    , @NamedQuery(name = "Sprints.findByNroSprint", query = "SELECT s FROM Sprints s WHERE s.nroSprint = :nroSprint")
    , @NamedQuery(name = "Sprints.findByDescripcion", query = "SELECT s FROM Sprints s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Sprints.findByFechaInicio", query = "SELECT s FROM Sprints s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Sprints.findByFechaFin", query = "SELECT s FROM Sprints s WHERE s.fechaFin = :fechaFin")})
public class Sprints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_sprint")
    private Integer nroSprint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroSprint")
    private Collection<Tareas> tareasCollection;

    public Sprints() {
    }

    public Sprints(Integer nroSprint) {
        this.nroSprint = nroSprint;
    }

    public Sprints(Integer nroSprint, String descripcion, Date fechaInicio) {
        this.nroSprint = nroSprint;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
    }

    public Integer getNroSprint() {
        return nroSprint;
    }

    public void setNroSprint(Integer nroSprint) {
        this.nroSprint = nroSprint;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Tareas> getTareasCollection() {
        return tareasCollection;
    }

    public void setTareasCollection(Collection<Tareas> tareasCollection) {
        this.tareasCollection = tareasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroSprint != null ? nroSprint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprints)) {
            return false;
        }
        Sprints other = (Sprints) object;
        if ((this.nroSprint == null && other.nroSprint != null) || (this.nroSprint != null && !this.nroSprint.equals(other.nroSprint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sprints[ nroSprint=" + nroSprint + " ]";
    }
    
}
