/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alsarmiento
 */
@Entity
@Table(name = "cierres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cierres.findAll", query = "SELECT c FROM Cierres c"),
    @NamedQuery(name = "Cierres.findById", query = "SELECT c FROM Cierres c WHERE c.id = :id"),
    @NamedQuery(name = "Cierres.findByMoneda", query = "SELECT c FROM Cierres c WHERE c.moneda = :moneda"),
    @NamedQuery(name = "Cierres.findByCantidad", query = "SELECT c FROM Cierres c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Cierres.findByTotal", query = "SELECT c FROM Cierres c WHERE c.total = :total"),
    @NamedQuery(name = "Cierres.findByTimestamp", query = "SELECT c FROM Cierres c WHERE c.timestamp = :timestamp")})
public class Cierres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "MONEDA")
    private int moneda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "CAJA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HistorialCaja caja;

    public Cierres() {
    }

    public Cierres(Integer id) {
        this.id = id;
    }

    public Cierres(Integer id, int moneda, int cantidad, double total, Date timestamp) {
        this.id = id;
        this.moneda = moneda;
        this.cantidad = cantidad;
        this.total = total;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HistorialCaja getCaja() {
        return caja;
    }

    public void setCaja(HistorialCaja caja) {
        this.caja = caja;
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
        if (!(object instanceof Cierres)) {
            return false;
        }
        Cierres other = (Cierres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Cierres[ id=" + id + " ]";
    }
    
}
