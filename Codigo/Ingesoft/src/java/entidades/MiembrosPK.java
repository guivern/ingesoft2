/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guiver
 */
@Embeddable
public class MiembrosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private short idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;

    public MiembrosPK() {
    }

    public MiembrosPK(short idUsuario, short idEquipo) {
        this.idUsuario = idUsuario;
        this.idEquipo = idEquipo;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(short idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembrosPK)) {
            return false;
        }
        MiembrosPK other = (MiembrosPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MiembrosPK[ idUsuario=" + idUsuario + ", idEquipo=" + idEquipo + " ]";
    }
    
}
