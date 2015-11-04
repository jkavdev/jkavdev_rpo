/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author JKAVDEV
 */
@Entity
@Table(name = "carne", catalog = "db_sistema_churrasco", schema = "")
@NamedQueries({
    @NamedQuery(name = "Carne.findAll", query = "SELECT c FROM Carne c"),
    @NamedQuery(name = "Carne.findByIdCarne", query = "SELECT c FROM Carne c WHERE c.idCarne = :idCarne"),
    @NamedQuery(name = "Carne.findByNome", query = "SELECT c FROM Carne c WHERE c.nome = :nome"),
    @NamedQuery(name = "Carne.findByUnidade", query = "SELECT c FROM Carne c WHERE c.unidade = :unidade"),
    @NamedQuery(name = "Carne.findByPreco", query = "SELECT c FROM Carne c WHERE c.preco = :preco")})
public class Carne implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCarne")
    private Integer idCarne;
    @Column(name = "nome")
    private String nome;
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;

    public Carne() {
    }

    public Carne(Integer idCarne) {
        this.idCarne = idCarne;
    }

    public Integer getIdCarne() {
        return idCarne;
    }

    public void setIdCarne(Integer idCarne) {
        Integer oldIdCarne = this.idCarne;
        this.idCarne = idCarne;
        changeSupport.firePropertyChange("idCarne", oldIdCarne, idCarne);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        String oldUnidade = this.unidade;
        this.unidade = unidade;
        changeSupport.firePropertyChange("unidade", oldUnidade, unidade);
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        BigDecimal oldPreco = this.preco;
        this.preco = preco;
        changeSupport.firePropertyChange("preco", oldPreco, preco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarne != null ? idCarne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carne)) {
            return false;
        }
        Carne other = (Carne) object;
        if ((this.idCarne == null && other.idCarne != null) || (this.idCarne != null && !this.idCarne.equals(other.idCarne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Carne[ idCarne=" + idCarne + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
