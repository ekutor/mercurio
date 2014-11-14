/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alsarmiento
 */
@Entity
@Table(name = "tipo_unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUnidades.findAll", query = "SELECT t FROM TipoUnidades t"),
    @NamedQuery(name = "TipoUnidades.findById", query = "SELECT t FROM TipoUnidades t WHERE t.id = :id"),
    @NamedQuery(name = "TipoUnidades.findByNombre", query = "SELECT t FROM TipoUnidades t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoUnidades.findByEstadoreg", query = "SELECT t FROM TipoUnidades t WHERE t.estadoreg = :estadoreg")})
public class TipoUnidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ESTADOREG")
    private int estadoreg;

    public TipoUnidades() {
    }

    public TipoUnidades(String id) {
        this.id = id;
    }

    public TipoUnidades(String id, String nombre, int estadoreg) {
        this.id = id;
        this.nombre = nombre;
        this.estadoreg = estadoreg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstadoreg() {
        return estadoreg;
    }

    public void setEstadoreg(int estadoreg) {
        this.estadoreg = estadoreg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUnidades)) {
            return false;
        }
        TipoUnidades other = (TipoUnidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.TipoUnidades[ id=" + id + " ]";
    }
    
}
