/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packentidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alan
 */
@Entity
@Table(name = "miembros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Miembros.findAll", query = "SELECT m FROM Miembros m")
    , @NamedQuery(name = "Miembros.findByIdUsuario", query = "SELECT m FROM Miembros m WHERE m.miembrosPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Miembros.findByIdEquipo", query = "SELECT m FROM Miembros m WHERE m.miembrosPK.idEquipo = :idEquipo")})
public class Miembros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MiembrosPK miembrosPK;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea")
    @ManyToOne(optional = false)
    private Tareas idTarea;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Miembros() {
    }

    public Miembros(MiembrosPK miembrosPK) {
        this.miembrosPK = miembrosPK;
    }

    public Miembros(short idUsuario, short idEquipo) {
        this.miembrosPK = new MiembrosPK(idUsuario, idEquipo);
    }

    public MiembrosPK getMiembrosPK() {
        return miembrosPK;
    }

    public void setMiembrosPK(MiembrosPK miembrosPK) {
        this.miembrosPK = miembrosPK;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    public Tareas getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Tareas idTarea) {
        this.idTarea = idTarea;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (miembrosPK != null ? miembrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Miembros)) {
            return false;
        }
        Miembros other = (Miembros) object;
        if ((this.miembrosPK == null && other.miembrosPK != null) || (this.miembrosPK != null && !this.miembrosPK.equals(other.miembrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packentidades.Miembros[ miembrosPK=" + miembrosPK + " ]";
    }
    
}
