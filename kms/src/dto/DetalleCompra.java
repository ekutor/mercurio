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
@Table(name = "detalle_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d"),
    @NamedQuery(name = "DetalleCompra.findByNumOrd", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.numOrd = :numOrd"),
    @NamedQuery(name = "DetalleCompra.findByProducto", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.producto = :producto"),
    @NamedQuery(name = "DetalleCompra.findByCantPedida", query = "SELECT d FROM DetalleCompra d WHERE d.cantPedida = :cantPedida"),
    @NamedQuery(name = "DetalleCompra.findByCantRecibida", query = "SELECT d FROM DetalleCompra d WHERE d.cantRecibida = :cantRecibida"),
    @NamedQuery(name = "DetalleCompra.findByPrecioUnidad", query = "SELECT d FROM DetalleCompra d WHERE d.precioUnidad = :precioUnidad"),
    @NamedQuery(name = "DetalleCompra.findByTotal", query = "SELECT d FROM DetalleCompra d WHERE d.total = :total")})
public class DetalleCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCompraPK detalleCompraPK;
    @Basic(optional = false)
    @Column(name = "CANT_PEDIDA")
    private int cantPedida;
    @Column(name = "CANT_RECIBIDA")
    private Integer cantRecibida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_UNIDAD")
    private Double precioUnidad;
    @Column(name = "TOTAL")
    private Double total;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;
    @JoinColumn(name = "NUM_ORD", referencedColumnName = "NUM_ORDEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compras compras;

    public DetalleCompra() {
    }

    public DetalleCompra(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public DetalleCompra(DetalleCompraPK detalleCompraPK, int cantPedida) {
        this.detalleCompraPK = detalleCompraPK;
        this.cantPedida = cantPedida;
    }

    public DetalleCompra(String numOrd, String producto) {
        this.detalleCompraPK = new DetalleCompraPK(numOrd, producto);
    }

    public DetalleCompraPK getDetalleCompraPK() {
        return detalleCompraPK;
    }

    public void setDetalleCompraPK(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public int getCantPedida() {
        return cantPedida;
    }

    public void setCantPedida(int cantPedida) {
        this.cantPedida = cantPedida;
    }

    public Integer getCantRecibida() {
        return cantRecibida;
    }

    public void setCantRecibida(Integer cantRecibida) {
        this.cantRecibida = cantRecibida;
    }

    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCompraPK != null ? detalleCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.detalleCompraPK == null && other.detalleCompraPK != null) || (this.detalleCompraPK != null && !this.detalleCompraPK.equals(other.detalleCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.DetalleCompra[ detalleCompraPK=" + detalleCompraPK + " ]";
    }
    
}
