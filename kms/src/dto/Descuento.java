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
@Table(name = "descuento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuento.findAll", query = "SELECT d FROM Descuento d"),
    @NamedQuery(name = "Descuento.findById", query = "SELECT d FROM Descuento d WHERE d.id = :id"),
    @NamedQuery(name = "Descuento.findByDescuento", query = "SELECT d FROM Descuento d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "Descuento.findByIdCliente", query = "SELECT d FROM Descuento d WHERE d.idCliente = :idCliente"),
    @NamedQuery(name = "Descuento.findByFecIni", query = "SELECT d FROM Descuento d WHERE d.fecIni = :fecIni"),
    @NamedQuery(name = "Descuento.findByFecFin", query = "SELECT d FROM Descuento d WHERE d.fecFin = :fecFin"),
    @NamedQuery(name = "Descuento.findByHorIni", query = "SELECT d FROM Descuento d WHERE d.horIni = :horIni"),
    @NamedQuery(name = "Descuento.findByHorFin", query = "SELECT d FROM Descuento d WHERE d.horFin = :horFin"),
    @NamedQuery(name = "Descuento.findByEstado", query = "SELECT d FROM Descuento d WHERE d.estado = :estado"),
    @NamedQuery(name = "Descuento.findByTimestamp", query = "SELECT d FROM Descuento d WHERE d.timestamp = :timestamp")})
public class Descuento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DESCUENTO")
    private double descuento;
    @Column(name = "ID_CLIENTE")
    private String idCliente;
    @Column(name = "FEC_INI")
    @Temporal(TemporalType.DATE)
    private Date fecIni;
    @Column(name = "FEC_FIN")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Column(name = "HOR_INI")
    @Temporal(TemporalType.TIME)
    private Date horIni;
    @Column(name = "HOR_FIN")
    @Temporal(TemporalType.TIME)
    private Date horFin;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "ID_PROD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto idProd;

    public Descuento() {
    }

    public Descuento(Integer id) {
        this.id = id;
    }

    public Descuento(Integer id, double descuento, String estado, Date timestamp) {
        this.id = id;
        this.descuento = descuento;
        this.estado = estado;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Date getHorIni() {
        return horIni;
    }

    public void setHorIni(Date horIni) {
        this.horIni = horIni;
    }

    public Date getHorFin() {
        return horFin;
    }

    public void setHorFin(Date horFin) {
        this.horFin = horFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Producto getIdProd() {
        return idProd;
    }

    public void setIdProd(Producto idProd) {
        this.idProd = idProd;
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
        if (!(object instanceof Descuento)) {
            return false;
        }
        Descuento other = (Descuento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Descuento[ id=" + id + " ]";
    }
    
}
