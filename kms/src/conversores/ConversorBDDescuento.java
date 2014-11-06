

package conversores;

/**
 *
 * @author Kymera Systems SAS
 */
import utilidades.Utilidades;
import modelo.Descuento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistenciaFWK.ConexionBD;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

public class ConversorBDDescuento extends ConversorBDAbstracto{
    private static final String TABLA = "DESCUENTO";
    private Map objetosEnCache;
    private String fecha= Utilidades.getInstancia().datetoStringLimpio(Calendar.getInstance().getTime()) ;

    public ConversorBDDescuento(){
        setTabla();
        objetosEnCache =  new HashMap();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Descuento d = null;
        if(regBD.next()){
            d = new Descuento();
            d.setOID(regBD.getString(1));
        }
        return d;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Descuento de = null;

            while (regBD.next()) {
                de = crearDescuento(regBD);
                mapa.put(de.oid, de);
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
        Descuento desc = (Descuento) obj;
        this.objetosEnCache.put(desc.oid, desc);
        String sentencia = "INSERT INTO " + TABLA +
                " values("+desc.getId() + ",'"+desc.getIdProd()+"'," +
                desc.getDescuento()+",'"+ desc.getIdCliente()+"','"+desc.getFecIni()+"'," +
                "'"+desc.getFecFin()+"','"+desc.getHorIni()+"','"+desc.getHorFin()+"','"+desc.getEstad()+"',now())";
        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Descuento desc = (Descuento) obj;
        String sentencia = null;
        sentencia = "UPDATE " + nombreTabla + " SET DESCUENTO = " + desc.getDescuento()+
                " WHERE ID='" + desc.getId()+ "'";
        System.out.println(sentencia);
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Descuento desc = (Descuento) obj;
        String sentencia = "DELETE FROM " + nombreTabla + " WHERE ID ='" + desc.getIdProd() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    public Descuento crearDescuento(ResultSet rgsBD){
        Descuento desc = new Descuento();
        try{
            desc.setEstadoObjeto(ObjetoPersistente.LIMPIO);
            desc.setId(regBD.getInt(1));
            desc.setIdProd(regBD.getString(2));
            desc.setDescuento(regBD.getDouble(3));
            desc.setIdCliente(regBD.getString(4));
            desc.setFecIni(Utilidades.datetoString(regBD.getDate(5)));
            desc.setFecFin(Utilidades.datetoString(regBD.getDate(6)));
            desc.setHorIni(regBD.getString(7));
            desc.setHorFin(regBD.getString(8));
            desc.setEstad(regBD.getString(9));
            return desc;
        }
        catch(Exception ex){ }
        return desc;

    }
    @Override
    public Map getRegistrosBD() throws SQLException {
        st = ConexionBD.getInstancia().getSentencia();
        regBD = st.executeQuery("SELECT * FROM "+TABLA+" WHERE FEC_INI<= '"+ fecha
                +"' AND  `FEC_FIN`>= '"+fecha+"' AND estado = 'ACTIVO'");
        return getRegistrosDeTabla(regBD);
    }

    @Override
    protected String crearSentencia(String[] paramBusqueda) {
       return "SELECT * FROM "+ TABLA + " WHERE ID = "+paramBusqueda[0];
    }
    @Override
    protected String crearSentencia(String paramBusqueda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
