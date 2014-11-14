/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
 * @author alsarmiento
 */
@Entity
@Table(name = "detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByVentaId", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.ventaId = :ventaId"),
    @NamedQuery(name = "DetalleVenta.findByProdId", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.prodId = :prodId"),
    @NamedQuery(name = "DetalleVenta.findByCant", query = "SELECT d FROM DetalleVenta d WHERE d.cant = :cant"),
    @NamedQuery(name = "DetalleVenta.findByPrecioUnt", query = "SELECT d FROM DetalleVenta d WHERE d.precioUnt = :precioUnt"),
    @NamedQuery(name = "DetalleVenta.findBySubtotal", query = "SELECT d FROM DetalleVenta d WHERE d.subtotal = :subtotal")})
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaPK detalleVentaPK;
    @Basic(optional = false)
    @Column(name = "CANT")
    private short cant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_UNT")
    private Double precioUnt;
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @JoinColumn(name = "PROD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "VENTA_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK, short cant) {
        this.detalleVentaPK = detalleVentaPK;
        this.cant = cant;
    }

    public DetalleVenta(String ventaId, String prodId) {
        this.detalleVentaPK = new DetalleVentaPK(ventaId, prodId);
    }

    public DetalleVentaPK getDetalleVentaPK() {
        return detalleVentaPK;
    }

    public void setDetalleVentaPK(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public short getCant() {
        return cant;
    }

    public void setCant(short cant) {
        this.cant = cant;
    }

    public Double getPrecioUnt() {
        return precioUnt;
    }

    public void setPrecioUnt(Double precioUnt) {
        this.precioUnt = precioUnt;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleVentaPK != null ? detalleVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.detalleVentaPK == null && other.detalleVentaPK != null) || (this.detalleVentaPK != null && !this.detalleVentaPK.equals(other.detalleVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.DetalleVenta[ detalleVentaPK=" + detalleVentaPK + " ]";
    }
    
}
