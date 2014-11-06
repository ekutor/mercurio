package modelo;

import java.util.ArrayList;
import persistenciaFWK.ObjetoPersistente;
import persistenciaFWK.EstadoNuevo;

/**
 * modelo de producto
 * @author Kymera Systems SAS
 */
public class Producto extends ObjetoPersistente {

    private double precio, costo;
    private int stock, iva,calidad,iva_comprado;
    private String descripcion, id, lote, categoria, estado, fechaVencimiento,perecedero,
            validaStock,proveedor,marca,unidad,bodega;
    private byte[] foto;

    public Producto() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public Producto(double precio, String descripcion, String id) {
        this();
        this.precio = precio;
        this.descripcion = descripcion;
        this.id = id;
        this.oid = id;
    }

    public Producto(ArrayList datos) {
        this();
        setId((String) datos.get(0));
        setDescripcion((String) datos.get(1));
        setPrecio((Double) datos.get(2));
        setFechaVencimiento((String) datos.get(3));
        setLote((String) datos.get(4));
        setStock((Integer) datos.get(5));
        setCategoria((String) datos.get(6));
        setEstado((String) datos.get(7));
        setFoto((byte[]) datos.get(8));
        setCosto((Double) datos.get(9));
        setIva((Integer) datos.get(10));
        setPerecedero((String) datos.get(11));
        setValidaStock((String) datos.get(12));
        setProveedor((String) datos.get(13));
        setMarca((String)datos.get(14));
        setCalidad((Integer)datos.get(15));
        setUnidad((String)datos.get(16));
        setBodega((String)datos.get(17));
        setIva_comprado((Integer)datos.get(18));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion.toUpperCase();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    public ArrayList toArray() {
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(descripcion);
        datos.add(precio);
        datos.add(fechaVencimiento);
        datos.add(lote);
        datos.add(stock);
        datos.add(categoria);
        datos.add(estado);
        datos.add(foto);
        datos.add(costo);
        datos.add(iva);
        datos.add(perecedero);
        datos.add(validaStock);
        datos.add(proveedor);
        datos.add(marca);
        datos.add(calidad);
        datos.add(unidad);
        datos.add(bodega);
        datos.add(iva_comprado);
        return datos;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getIva_comprado() {
        return iva_comprado;
    }

    public void setIva_comprado(int iva_comprado) {
        this.iva_comprado = iva_comprado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    

    public String toString() {
        return descripcion;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }
}
