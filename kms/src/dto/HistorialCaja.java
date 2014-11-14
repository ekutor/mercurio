/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alsarmiento
 */
@Entity
@Table(name = "historial_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCaja.findAll", query = "SELECT h FROM HistorialCaja h"),
    @NamedQuery(name = "HistorialCaja.findById", query = "SELECT h FROM HistorialCaja h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialCaja.findByFechaApertura", query = "SELECT h FROM HistorialCaja h WHERE h.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "HistorialCaja.findByFechaCierre", query = "SELECT h FROM HistorialCaja h WHERE h.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "HistorialCaja.findByHoraAptura", query = "SELECT h FROM HistorialCaja h WHERE h.horaAptura = :horaAptura"),
    @NamedQuery(name = "HistorialCaja.findByHoraCierre", query = "SELECT h FROM HistorialCaja h WHERE h.horaCierre = :horaCierre"),
    @NamedQuery(name = "HistorialCaja.findByTimestamp", query = "SELECT h FROM HistorialCaja h WHERE h.timestamp = :timestamp"),
    @NamedQuery(name = "HistorialCaja.findBySaldoInicial", query = "SELECT h FROM HistorialCaja h WHERE h.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "HistorialCaja.findBySaldoFinal", query = "SELECT h FROM HistorialCaja h WHERE h.saldoFinal = :saldoFinal"),
    @NamedQuery(name = "HistorialCaja.findByFacIni", query = "SELECT h FROM HistorialCaja h WHERE h.facIni = :facIni"),
    @NamedQuery(name = "HistorialCaja.findByFacFin", query = "SELECT h FROM HistorialCaja h WHERE h.facFin = :facFin"),
    @NamedQuery(name = "HistorialCaja.findByEstado", query = "SELECT h FROM HistorialCaja h WHERE h.estado = :estado"),
    @NamedQuery(name = "HistorialCaja.findByTerminal", query = "SELECT h FROM HistorialCaja h WHERE h.terminal = :terminal"),
    @NamedQuery(name = "HistorialCaja.findByBasegravable", query = "SELECT h FROM HistorialCaja h WHERE h.basegravable = :basegravable"),
    @NamedQuery(name = "HistorialCaja.findByIva", query = "SELECT h FROM HistorialCaja h WHERE h.iva = :iva"),
    @NamedQuery(name = "HistorialCaja.findByNumVentas", query = "SELECT h FROM HistorialCaja h WHERE h.numVentas = :numVentas")})
public class HistorialCaja implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
    private List<Cierres> cierresList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "FECHA_APERTURA")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @Basic(optional = false)
    @Column(name = "HORA_APTURA")
    @Temporal(TemporalType.TIME)
    private Date horaAptura;
    @Column(name = "HORA_CIERRE")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "SALDO_INICIAL")
    private double saldoInicial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALDO_FINAL")
    private Double saldoFinal;
    @Column(name = "FAC_INI")
    private String facIni;
    @Column(name = "FAC_FIN")
    private String facFin;
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TERMINAL")
    private int terminal;
    @Basic(optional = false)
    @Column(name = "BASEGRAVABLE")
    private double basegravable;
    @Basic(optional = false)
    @Column(name = "IVA")
    private double iva;
    @Column(name = "NUM_VENTAS")
    private Integer numVentas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
    private List<HistorialMovimientosCaja> historialMovimientosCajaList;
    @JoinColumn(name = "CAJERO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Personal cajero;

    public HistorialCaja() {
    }

    public HistorialCaja(String id) {
        this.id = id;
    }

    public HistorialCaja(String id, Date fechaApertura, Date horaAptura, Date timestamp, double saldoInicial, int terminal, double basegravable, double iva) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.horaAptura = horaAptura;
        this.timestamp = timestamp;
        this.saldoInicial = saldoInicial;
        this.terminal = terminal;
        this.basegravable = basegravable;
        this.iva = iva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getHoraAptura() {
        return horaAptura;
    }

    public void setHoraAptura(Date horaAptura) {
        this.horaAptura = horaAptura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getFacIni() {
        return facIni;
    }

    public void setFacIni(String facIni) {
        this.facIni = facIni;
    }

    public String getFacFin() {
        return facFin;
    }

    public void setFacFin(String facFin) {
        this.facFin = facFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public double getBasegravable() {
        return basegravable;
    }

    public void setBasegravable(double basegravable) {
        this.basegravable = basegravable;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Integer getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(Integer numVentas) {
        this.numVentas = numVentas;
    }

    @XmlTransient
    public List<HistorialMovimientosCaja> getHistorialMovimientosCajaList() {
        return historialMovimientosCajaList;
    }

    public void setHistorialMovimientosCajaList(List<HistorialMovimientosCaja> historialMovimientosCajaList) {
        this.historialMovimientosCajaList = historialMovimientosCajaList;
    }

    public Personal getCajero() {
        return cajero;
    }

    public void setCajero(Personal cajero) {
        this.cajero = cajero;
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
        if (!(object instanceof HistorialCaja)) {
            return false;
        }
        HistorialCaja other = (HistorialCaja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.HistorialCaja[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Cierres> getCierresList() {
        return cierresList;
    }

    public void setCierresList(List<Cierres> cierresList) {
        this.cierresList = cierresList;
    }
    
}
