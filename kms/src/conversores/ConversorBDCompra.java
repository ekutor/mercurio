package conversores;

import control.LineaCompra;
import utilidades.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Compra;
import persistenciaFWK.ConexionBD;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCompra extends ConversorBDAbstracto {

    private static final String TABLA = "COMPRAS";
    private Map objetosEnCache;
    private boolean esCompra = true;

    public ConversorBDCompra() {
        setTabla();
        objetosEnCache = new HashMap();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Compra c = null;
        if (regBD.next()) {
            c = new Compra();
            c.setOID(regBD.getString(1));
        }
        return c;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            if (esCompra) {
                Compra co = null;
                while (regBD.next()) {
                    co = cargarCompra(regBD);
                    mapa.put(co.oid, co);
                }
            } else {
                LineaCompra lc = null;
                while (regBD.next()) {
                    lc = cargarLineaCompra(regBD);
                    mapa.put(lc.oid, lc);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }

    @Override
    protected void setTabla() {
        nombreTabla = TABLA;
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        if (obj instanceof Compra) {
            Compra compra = (Compra) obj;
            this.objetosEnCache.put(compra.oid, compra);
            String sentencia = "INSERT INTO " + TABLA +
                    " values('" + compra.oid + "','" + compra.factProveedor + "','" + compra.provID + "','" +
                    compra.getFechaPedido() + "','" + compra.getFechaEntrega() + "'," + compra.getTotal() + ","
                    + compra.pagoCon + ","+compra.cambio + ","+ Utilidades.reducirDecimales(compra.baseGrabable)
                    + ","+Utilidades.reducirDecimales(compra.iva)+ ",'" + compra.getEst() + "',now())";
            return sentencia;
        } else {
            LineaCompra lc = (LineaCompra) obj;
            this.objetosEnCache.put(lc.oid, lc);
            String sentencia = "INSERT INTO DETALLE_COMPRA values('" + lc.getNumOrden() + "','" + lc.pr.getId() + "'," + lc.getCantidad() +
                    ","+null+"," + lc.pr.getCosto() + "," + lc.getSubtotal() + ")";
            return sentencia;
        }
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        if (obj instanceof Compra) {
            Compra compra = (Compra) obj;
            this.objetosEnCache.put(compra.oid, compra);
            String sentencia = "UPDATE "+ TABLA +
                    " SET FECHA_ENTREGA = '" + compra.getFechaEntrega() +
                    "', TOTAL = " + compra.getTotal() +
                    ", PAGO_CON = " + compra.pagoCon +
                    ", CAMBIO = " + compra.cambio +
                    ", BASE = " + Utilidades.reducirDecimales(compra.baseGrabable) +
                    ", IVA = " + Utilidades.reducirDecimales(compra.iva) +
                    ", ESTADO = '" + compra.getEst() + "', TIMESTAMP = '" + compra.getTimestamp() +
                    "' WHERE NUM_ORDEN = '" + compra.oid + "'";
            return sentencia;
        } else {
            LineaCompra lc = (LineaCompra) obj;
            this.objetosEnCache.put(lc.oid, lc);
            String sentencia = "UPDATE DETALLE_COMPRA"+
                    " SET CANT_RECIBIDA = " + lc.getCantidad() +
                    ", PRECIO_UNIDAD = " + lc.pr.getCosto() +
                    ", TOTAL = " + lc.getSubtotal() + " WHERE NUM_ORD = '" + lc.getNumOrden() + "' AND" +
                    " PRODUCTO = '" + lc.pr.getId()+"'";
            return sentencia;
        }
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean putObjetoEnAlmacenamiento(ObjetoPersistente obj, int tipo) {
        try {
            st = ConexionBD.getInstancia().getSentencia();
            this.tranEjecutada = true;
            String query = null;
            switch (tipo) {
                case INSERTAR: {
                    Compra compra = (Compra) obj;
                    System.out.println(insert(compra));
                    st.addBatch(insert(compra));
                    for (LineaCompra lc : compra.getLineasDeCompra()) {
                        System.out.println(insert(lc));
                        st.addBatch(insert(lc));
                    }
                    break;
                }
                case MODIFICAR: {
                    Compra compra = (Compra) obj;
                    System.out.println(update(compra));
                    st.addBatch(update(compra));
                    for (LineaCompra lc : compra.getLineasDeCompra()) {
                        st.addBatch(update(lc));
                    }
                    break;
                }
                case ELIMINAR: {
                    query = delete(obj);
                    break;
                }
            }
            st.executeBatch();
        } catch (SQLException ex) {
            System.out.println("ERROR Al EJECUTAR SENTENCIA EN LA BASE DE DATOS");
            this.tranEjecutada = false;
            ConexionBD.cerrarConexion();
            ex.printStackTrace();
        }
        return this.tranEjecutada;
    }

    public Compra cargarCompra(ResultSet rgsBD) {
        Compra compra = new Compra();
        try {
            compra.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            compra.setOID(regBD.getString(1));
            compra.setFactProveedor(regBD.getString(2));
            compra.setProveedor(regBD.getString(3));
            compra.setFechaPedido(Utilidades.datetoString(regBD.getDate(4)));
            compra.setFechaEntrega(Utilidades.datetoString(regBD.getDate(5)));
            compra.setTotal(regBD.getDouble(6));
            compra.pagoCon = regBD.getDouble(7);
            compra.cambio = regBD.getDouble(8);
            compra.baseGrabable = regBD.getDouble(9);
            compra.iva = regBD.getDouble(10);
            compra.setEst(regBD.getString(11));
            compra.setTimestamp(regBD.getString(12));
            return compra;
        } catch (Exception ex) {
        }
        return compra;

    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        if (paramBusqueda.length == 2) {
            esCompra = true;
            return "SELECT * FROM " + TABLA + " WHERE FECHA_PEDIDO >= " + paramBusqueda[0] + " AND FECHA_PEDIDO <= " + paramBusqueda[1];
        } else {
            esCompra = false;
            return "SELECT * FROM DETALLE_COMPRA WHERE NUM_ORD = '" + paramBusqueda[0] + "'";
        }
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        esCompra = true;
        return "SELECT * FROM " + TABLA + " WHERE ESTADO = '" + paramBusqueda + "' AND FECHA_PEDIDO >= " +
                Utilidades.getAñoActual() + "-" + Utilidades.getMesActual() + "-1";
    }

    public LineaCompra cargarLineaCompra(ResultSet regBD) {
        LineaCompra lineaCompra = new LineaCompra();
        try {
            lineaCompra.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            lineaCompra.pr.setId(regBD.getString(2));
            lineaCompra.setNumOrden(regBD.getString(1));
            lineaCompra.setCantidad(regBD.getInt(3));
            lineaCompra.setCantidadRecibida(regBD.getInt(4));
            lineaCompra.pr.setCosto(regBD.getDouble(5));
            lineaCompra.setSubTotal(regBD.getDouble(6));
            return lineaCompra;
        } catch (Exception ex) {
        }
        return lineaCompra;
    }

}
