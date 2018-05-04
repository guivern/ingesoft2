/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guiver
 */
@Entity
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
    , @NamedQuery(name = "Estados.findByNroEstado", query = "SELECT e FROM Estados e WHERE e.nroEstado = :nroEstado")
    , @NamedQuery(name = "Estados.findByEstado", query = "SELECT e FROM Estados e WHERE e.estado = :estado")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_estado")
    private Integer nroEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tareaNroEstado")
    private Collection<Tareas> tareasCollection;

    public Estados() {
    }

    public Estados(Integer nroEstado) {
        this.nroEstado = nroEstado;
    }

    public Estados(Integer nroEstado, String estado) {
        this.nroEstado = nroEstado;
        this.estado = estado;
    }

    public Integer getNroEstado() {
        return nroEstado;
    }

    public void setNroEstado(Integer nroEstado) {
        this.nroEstado = nroEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (nroEstado != null ? nroEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.nroEstado == null && other.nroEstado != null) || (this.nroEstado != null && !this.nroEstado.equals(other.nroEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estados[ nroEstado=" + nroEstado + " ]";
    }
    
}
