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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByNumOrden", query = "SELECT c FROM Compras c WHERE c.numOrden = :numOrden"),
    @NamedQuery(name = "Compras.findByFactProveedor", query = "SELECT c FROM Compras c WHERE c.factProveedor = :factProveedor"),
    @NamedQuery(name = "Compras.findByFechaPedido", query = "SELECT c FROM Compras c WHERE c.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Compras.findByFechaEntrega", query = "SELECT c FROM Compras c WHERE c.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Compras.findByTotal", query = "SELECT c FROM Compras c WHERE c.total = :total"),
    @NamedQuery(name = "Compras.findByPagoCon", query = "SELECT c FROM Compras c WHERE c.pagoCon = :pagoCon"),
    @NamedQuery(name = "Compras.findByCambio", query = "SELECT c FROM Compras c WHERE c.cambio = :cambio"),
    @NamedQuery(name = "Compras.findByBase", query = "SELECT c FROM Compras c WHERE c.base = :base"),
    @NamedQuery(name = "Compras.findByIva", query = "SELECT c FROM Compras c WHERE c.iva = :iva"),
    @NamedQuery(name = "Compras.findByEstado", query = "SELECT c FROM Compras c WHERE c.estado = :estado"),
    @NamedQuery(name = "Compras.findByTimestamp", query = "SELECT c FROM Compras c WHERE c.timestamp = :timestamp")})
public class Compras implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compras")
    private List<DetalleCompra> detalleCompraList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUM_ORDEN")
    private String numOrden;
    @Basic(optional = false)
    @Column(name = "FACT_PROVEEDOR")
    private String factProveedor;
    @Basic(optional = false)
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "PAGO_CON")
    private Double pagoCon;
    @Column(name = "CAMBIO")
    private Double cambio;
    @Column(name = "BASE")
    private Double base;
    @Column(name = "IVA")
    private Double iva;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "PROV_ID", referencedColumnName = "ID")
    @ManyToOne
    private Proveedor provId;

    public Compras() {
    }

    public Compras(String numOrden) {
        this.numOrden = numOrden;
    }

    public Compras(String numOrden, String factProveedor, Date fechaPedido, Date fechaEntrega, String estado, Date timestamp) {
        this.numOrden = numOrden;
        this.factProveedor = factProveedor;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.timestamp = timestamp;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public String getFactProveedor() {
        return factProveedor;
    }

    public void setFactProveedor(String factProveedor) {
        this.factProveedor = factProveedor;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPagoCon() {
        return pagoCon;
    }

    public void setPagoCon(Double pagoCon) {
        this.pagoCon = pagoCon;
    }

    public Double getCambio() {
        return cambio;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
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

    public Proveedor getProvId() {
        return provId;
    }

    public void setProvId(Proveedor provId) {
        this.provId = provId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numOrden != null ? numOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.numOrden == null && other.numOrden != null) || (this.numOrden != null && !this.numOrden.equals(other.numOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Compras[ numOrden=" + numOrden + " ]";
    }

    @XmlTransient
    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }
    
}
