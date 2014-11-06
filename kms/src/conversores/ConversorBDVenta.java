package conversores;

import control.LineaVenta;
import control.PuntoDeVenta;
import utilidades.Utilidades;
import modelo.Venta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import persistenciaFWK.ConexionBD;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDVenta extends ConversorBDAbstracto {

    private static final String TABLA = "VENTA";
    private Map objetosEnCache;

    public ConversorBDVenta() {
        setTabla();
        objetosEnCache = new HashMap();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Venta v = null;
        if (regBD.next()) {
            v = new Venta();
            v.setOID(regBD.getString(1));
        }
        return v;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Venta ve = null;

            while (regBD.next()) {
                ve = cargarVenta(regBD);
                mapa.put(ve.oid, ve);
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
    protected String insert(ObjetoPersistente obj) {
        if(obj instanceof Venta){
            Venta venta = (Venta) obj;
            this.objetosEnCache.put(venta.oid, venta);
            String sentencia = "INSERT INTO " + TABLA +
                    " values('"+venta.oid+"','"+((Usuario)PuntoDeVenta.usuarioActual).getUsuario()+
                    "','"+venta.cliente+"','"+venta.getFecha()+"','"+venta.getHora()+"',"+venta.descTotal+","+venta.total+
                    "," + venta.pagoCon + ","+venta.cambio + ","+ Utilidades.reducirDecimales(venta.baseGrabable)
                    + ","+Utilidades.reducirDecimales(venta.iva)+ ",'pagado',now())";
            return sentencia;
        }
        else{
            LineaVenta lv = (LineaVenta) obj;
            this.objetosEnCache.put(lv.oid, lv);
            String sentencia = "INSERT INTO DETALLE_VENTA values('"+lv.oid+"','"+lv.pr.getId()+"',"+lv.getCantidad()+
                    ","+lv.pr.getPrecio()+","+lv.getSubtotal()+")";
            return sentencia;
        }

    }

    @Override
    protected String update(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean putObjetoEnAlmacenamiento(ObjetoPersistente obj, int tipo) {
        this.tranEjecutada = true;
        try {
            st = ConexionBD.getInstancia().getSentencia();

            String query = null;
            switch (tipo) {
                case INSERTAR: {
                    Venta venta = (Venta) obj;
                    st.addBatch(insert(venta));
                    for (LineaVenta lv : venta.getLineasDeVenta()) {
                        st.addBatch(insert(lv));
                    }
                    break;
                }
                case MODIFICAR: {

                    break;
                }
                case ELIMINAR: {
                    query = delete(obj);
                    break;
                }
            }
            st.executeBatch();
        } catch (SQLException ex) {
            System.out.println("ERROR Al EJECUTAR VENTA EN LA BASE DE DATOS");
            ConexionBD.cerrarConexion();
            //this.tranEjecutada = false;
            ex.printStackTrace();
        }
        return this.tranEjecutada;
    }

    public Venta cargarVenta(ResultSet rgsBD) {
        Venta venta = new Venta();
        try {
            venta.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            venta.setOID(regBD.getString(1));
            venta.setUsuario(regBD.getString(2));
            venta.setCliente(regBD.getString(3));
            venta.setFecha(Utilidades.datetoString(regBD.getDate(4)));
            venta.setHora(regBD.getString(5));
            venta.setDesuento(regBD.getDouble(6));
            venta.setTotal(regBD.getDouble(7));
            venta.setPaga_con(regBD.getDouble(8));
            venta.setCamb(regBD.getDouble(9));
            venta.baseGrabable = regBD.getDouble(10);
            venta.iva =  regBD.getDouble(11);
            venta.setEst(regBD.getString(12));
            return venta;
        } catch (Exception ex) {
        }
        return venta;

    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
        String sentencia = "";
        if (paramBusqueda.length == 2) {
            sentencia = "SELECT * FROM " + TABLA + " WHERE FECHA >= '" + paramBusqueda[0] + "' AND FECHA <= '" + paramBusqueda[1]+"'";
        }else{
            sentencia = "SELECT * FROM " + TABLA + " WHERE FECHA >= '" + paramBusqueda[0] + "' AND FECHA <= '" + paramBusqueda[1]+
                    "' AND PER_ID = '"+paramBusqueda[2]+"'";
        }
        return sentencia;
    }

    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
