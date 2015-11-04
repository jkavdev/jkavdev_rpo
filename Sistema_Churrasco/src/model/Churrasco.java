/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author JKAVDEV
 */
@Entity
@Table(name = "churrasco", catalog = "db_sistema_churrasco", schema = "")
@NamedQueries({
    @NamedQuery(name = "Churrasco.findAll", query = "SELECT c FROM Churrasco c"),
    @NamedQuery(name = "Churrasco.findByIdChurrasco", query = "SELECT c FROM Churrasco c WHERE c.idChurrasco = :idChurrasco"),
    @NamedQuery(name = "Churrasco.findByData", query = "SELECT c FROM Churrasco c WHERE c.data = :data"),
    @NamedQuery(name = "Churrasco.findByHora", query = "SELECT c FROM Churrasco c WHERE c.hora = :hora"),
    @NamedQuery(name = "Churrasco.findByLocal", query = "SELECT c FROM Churrasco c WHERE c.local = :local")})
public class Churrasco implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idChurrasco")
    private Integer idChurrasco;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "local")
    private String local;

    public Churrasco() {
    }

    public Churrasco(Integer idChurrasco) {
        this.idChurrasco = idChurrasco;
    }

    public Integer getIdChurrasco() {
        return idChurrasco;
    }

    public void setIdChurrasco(Integer idChurrasco) {
        Integer oldIdChurrasco = this.idChurrasco;
        this.idChurrasco = idChurrasco;
        changeSupport.firePropertyChange("idChurrasco", oldIdChurrasco, idChurrasco);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        changeSupport.firePropertyChange("local", oldLocal, local);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChurrasco != null ? idChurrasco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Churrasco)) {
            return false;
        }
        Churrasco other = (Churrasco) object;
        if ((this.idChurrasco == null && other.idChurrasco != null) || (this.idChurrasco != null && !this.idChurrasco.equals(other.idChurrasco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Churrasco[ idChurrasco=" + idChurrasco + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
