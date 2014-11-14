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
@Table(name = "historial_movimientos_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialMovimientosCaja.findAll", query = "SELECT h FROM HistorialMovimientosCaja h"),
    @NamedQuery(name = "HistorialMovimientosCaja.findById", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByTipoMov", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.tipoMov = :tipoMov"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByMonto", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.monto = :monto"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByTipoMoneda", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.tipoMoneda = :tipoMoneda"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByPagadaA", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.pagadaA = :pagadaA"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByTipoTercero", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.tipoTercero = :tipoTercero"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByFactura", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.factura = :factura"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByObs", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.obs = :obs"),
    @NamedQuery(name = "HistorialMovimientosCaja.findBySupervisor", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.supervisor = :supervisor"),
    @NamedQuery(name = "HistorialMovimientosCaja.findByTimestamp", query = "SELECT h FROM HistorialMovimientosCaja h WHERE h.timestamp = :timestamp")})
public class HistorialMovimientosCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TIPO_MOV")
    private String tipoMov;
    @Basic(optional = false)
    @Column(name = "MONTO")
    private double monto;
    @Column(name = "TIPO_MONEDA")
    private String tipoMoneda;
    @Column(name = "PAGADA_A")
    private String pagadaA;
    @Basic(optional = false)
    @Column(name = "TIPO_TERCERO")
    private String tipoTercero;
    @Column(name = "FACTURA")
    private String factura;
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "CAJA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HistorialCaja caja;

    public HistorialMovimientosCaja() {
    }

    public HistorialMovimientosCaja(Integer id) {
        this.id = id;
    }

    public HistorialMovimientosCaja(Integer id, String tipoMov, double monto, String tipoTercero, String supervisor, Date timestamp) {
        this.id = id;
        this.tipoMov = tipoMov;
        this.monto = monto;
        this.tipoTercero = tipoTercero;
        this.supervisor = supervisor;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getPagadaA() {
        return pagadaA;
    }

    public void setPagadaA(String pagadaA) {
        this.pagadaA = pagadaA;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
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
        if (!(object instanceof HistorialMovimientosCaja)) {
            return false;
        }
        HistorialMovimientosCaja other = (HistorialMovimientosCaja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.HistorialMovimientosCaja[ id=" + id + " ]";
    }
    
}
