package conversores;

import utilidades.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDProducto extends ConversorBDAbstracto {

    private static final String TABLA = "PRODUCTO";

    public ConversorBDProducto() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Producto pr = null;
        if (regBD.next()) {
            pr = crearProducto(regBD);
        }
        return pr;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Producto pr = null;

            while (regBD.next()) {
                pr = crearProducto(regBD);
                mapa.put(pr.getId(), pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;

    }

    @Override
    protected void setTabla() {
        nombreTabla = TABLA;
    }
    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla + " WHERE ESTADOREG = 0";
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        Producto pr = (Producto) obj;
        String sentencia = null;
        if (pr.getFoto() != null) {
            agregarImagen = true;
            imagen = pr.getFoto();
            sentencia = "INSERT INTO " + nombreTabla + " values('" + pr.getId() + "','" + pr.getDescripcion() +
                    "'," + pr.getPrecio() + ",'" + pr.getFechaVencimiento() + "','" + pr.getLote() + "','" +
                    pr.getStock() + "','" + pr.getCategoria() + "','" + pr.getEstado() + "',NOW(),?," +
                    pr.getCosto() + "," + pr.getIva()+ ",0,'"+pr.getPerecedero()+"','"+pr.getValidaStock()+"','"+
                    pr.getProveedor()+"','"+pr.getMarca()+"',"+pr.getCalidad()+",'"+pr.getUnidad()+"','"+pr.getBodega()+"',"+pr.getIva_comprado()+")";
            System.out.println(sentencia);
        } else {
            sentencia = "INSERT INTO " + nombreTabla + " values('" + pr.getId() + "','" + pr.getDescripcion() +
                    "'," + pr.getPrecio() + ",'" + pr.getFechaVencimiento() + "','" + pr.getLote() + "','" +
                    pr.getStock() + "','" + pr.getCategoria() + "','" + pr.getEstado() + "',NOW(),null," +
                    pr.getCosto() + "," + pr.getIva() + ",0,'"+pr.getPerecedero()+"','"+pr.getValidaStock()+"','"+
                    pr.getProveedor()+"','"+pr.getMarca()+"',"+pr.getCalidad()+",'"+pr.getUnidad()+"','"+pr.getBodega()+"',"+pr.getIva_comprado()+")";
            System.out.println(sentencia);
        }

        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Producto pr = (Producto) obj;
        String sentencia = null;
        if (pr.getFoto() != null) {
            agregarImagen = true;
            imagen = pr.getFoto();
            sentencia = "UPDATE " + nombreTabla + " SET DESCRIPCION = '" + pr.getDescripcion() + "',PRECIO=" +
                    pr.getPrecio() + ",FECHA_VENC='" + pr.getFechaVencimiento() + "',LOTE='" + pr.getLote() +
                    "',UN_EN_STOCK='" + pr.getStock() + "',CATEGORIA='" + pr.getCategoria() + "',ESTADO='" +
                    pr.getEstado() + "',TIMESTAMP = NOW(),FOTO= ?,COSTO=" + pr.getCosto() + ",IVA=" + pr.getIva() +
                    ",PERECEDERO='"+pr.getPerecedero()+"',VALIDA_STOCK='"+pr.getValidaStock()+
                    "',PROVEEDOR='"+pr.getProveedor()+"',MARCA='"+pr.getMarca()+"',CALIDAD="+pr.getCalidad()+
                    ",UNIDAD='"+pr.getUnidad()+"',BODEGA='"+pr.getBodega()+"',IVA_COMPRADO="+pr.getIva_comprado()+
                    " WHERE ID='" + pr.getId() + "'";
            
        } else {
            sentencia = "UPDATE " + nombreTabla + " SET DESCRIPCION = '" + pr.getDescripcion() + "',PRECIO=" +
                    pr.getPrecio() + ",FECHA_VENC='" + pr.getFechaVencimiento() + "',LOTE='" + pr.getLote() +
                    "',UN_EN_STOCK='" + pr.getStock() + "',CATEGORIA='" + pr.getCategoria() + "',ESTADO='" +
                    pr.getEstado() + "', TIMESTAMP = NOW(),FOTO=null,COSTO=" + pr.getCosto() + ",IVA=" +
                    pr.getIva() + ",PERECEDERO='"+pr.getPerecedero()+"',VALIDA_STOCK='"+pr.getValidaStock()+
                    "',PROVEEDOR='"+pr.getProveedor()+"',MARCA='"+pr.getMarca()+"',CALIDAD="+pr.getCalidad()+
                    ",UNIDAD='"+pr.getUnidad()+"',BODEGA='"+pr.getBodega()+"',IVA_COMPRADO="+pr.getIva_comprado()+
                    " WHERE ID='" + pr.getId() + "'";

           
        }
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Producto pr = (Producto) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + pr.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    private Producto crearProducto(ResultSet regBD) throws SQLException {
        Producto pr = new Producto();
        pr.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        pr.setId(regBD.getString(1));
        pr.setDescripcion(regBD.getString(2));
        pr.setPrecio(regBD.getDouble(3));
        pr.setFechaVencimiento(Utilidades.datetoString(regBD.getDate(4)));
        pr.setLote(regBD.getString(5));
        pr.setStock(regBD.getInt(6));
        pr.setCategoria(regBD.getString(7));
        pr.setEstado(regBD.getString(8));
         byte[] bl = regBD.getBytes(10);
        if (bl != null) {
            pr.setFoto(bl);
        } else {
            pr.setFoto(null);
        }
        pr.setCosto(regBD.getDouble(11));
        pr.setIva(regBD.getInt(12));
        pr.setPerecedero(regBD.getString(14));
        pr.setValidaStock(regBD.getString(15));
        pr.setProveedor(regBD.getString(16));
        pr.setMarca(regBD.getString(17));
        pr.setCalidad(regBD.getInt(18));
        pr.setUnidad(regBD.getString(19));
        pr.setBodega(regBD.getString(20));
        pr.setIva_comprado(regBD.getInt(21));
        return pr;
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        return null;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
