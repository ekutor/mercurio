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
import javax.persistence.Lob;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByFechaVenc", query = "SELECT p FROM Producto p WHERE p.fechaVenc = :fechaVenc"),
    @NamedQuery(name = "Producto.findByLote", query = "SELECT p FROM Producto p WHERE p.lote = :lote"),
    @NamedQuery(name = "Producto.findByUnEnStock", query = "SELECT p FROM Producto p WHERE p.unEnStock = :unEnStock"),
    @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado"),
    @NamedQuery(name = "Producto.findByTimestamp", query = "SELECT p FROM Producto p WHERE p.timestamp = :timestamp"),
    @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo"),
    @NamedQuery(name = "Producto.findByIva", query = "SELECT p FROM Producto p WHERE p.iva = :iva"),
    @NamedQuery(name = "Producto.findByEstadoreg", query = "SELECT p FROM Producto p WHERE p.estadoreg = :estadoreg"),
    @NamedQuery(name = "Producto.findByPerecedero", query = "SELECT p FROM Producto p WHERE p.perecedero = :perecedero"),
    @NamedQuery(name = "Producto.findByValidaStock", query = "SELECT p FROM Producto p WHERE p.validaStock = :validaStock"),
    @NamedQuery(name = "Producto.findByProveedor", query = "SELECT p FROM Producto p WHERE p.proveedor = :proveedor"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByCalidad", query = "SELECT p FROM Producto p WHERE p.calidad = :calidad"),
    @NamedQuery(name = "Producto.findByUnidad", query = "SELECT p FROM Producto p WHERE p.unidad = :unidad"),
    @NamedQuery(name = "Producto.findByBodega", query = "SELECT p FROM Producto p WHERE p.bodega = :bodega"),
    @NamedQuery(name = "Producto.findByIvaComprado", query = "SELECT p FROM Producto p WHERE p.ivaComprado = :ivaComprado")})
public class Producto implements Serializable {
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetalleVenta> detalleVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto1")
    private List<DetalleCompra> detalleCompraList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private double precio;
    @Column(name = "FECHA_VENC")
    @Temporal(TemporalType.DATE)
    private Date fechaVenc;
    @Column(name = "LOTE")
    private String lote;
    @Column(name = "UN_EN_STOCK")
    private Integer unEnStock;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private double costo;
    @Basic(optional = false)
    @Column(name = "IVA")
    private int iva;
    @Column(name = "ESTADOREG")
    private Integer estadoreg;
    @Column(name = "PERECEDERO")
    private String perecedero;
    @Column(name = "VALIDA_STOCK")
    private String validaStock;
    @Column(name = "PROVEEDOR")
    private String proveedor;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "CALIDAD")
    private Integer calidad;
    @Column(name = "UNIDAD")
    private String unidad;
    @Column(name = "BODEGA")
    private String bodega;
    @Column(name = "IVA_COMPRADO")
    private Integer ivaComprado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProd")
    private List<Descuento> descuentoList;
    @JoinColumn(name = "CATEGORIA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String id) {
        this.id = id;
    }

    public Producto(String id, String descripcion, double precio, String estado, Date timestamp, double costo, int iva) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.timestamp = timestamp;
        this.costo = costo;
        this.iva = iva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getUnEnStock() {
        return unEnStock;
    }

    public void setUnEnStock(Integer unEnStock) {
        this.unEnStock = unEnStock;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Integer getEstadoreg() {
        return estadoreg;
    }

    public void setEstadoreg(Integer estadoreg) {
        this.estadoreg = estadoreg;
    }

    public String getPerecedero() {
        return perecedero;
    }

    public void setPerecedero(String perecedero) {
        this.perecedero = perecedero;
    }

    public String getValidaStock() {
        return validaStock;
    }

    public void setValidaStock(String validaStock) {
        this.validaStock = validaStock;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCalidad() {
        return calidad;
    }

    public void setCalidad(Integer calidad) {
        this.calidad = calidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public Integer getIvaComprado() {
        return ivaComprado;
    }

    public void setIvaComprado(Integer ivaComprado) {
        this.ivaComprado = ivaComprado;
    }

    @XmlTransient
    public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Producto[ id=" + id + " ]";
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @XmlTransient
    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }
    
}
