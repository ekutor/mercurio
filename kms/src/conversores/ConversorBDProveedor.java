package conversores;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Proveedor;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDProveedor extends ConversorBDAbstracto {

    private static final String TABLA = "PROVEEDOR";

    public ConversorBDProveedor() {
        setTabla();
    }
   
    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Proveedor pr = null;
        if (regBD.next()) {
            pr = crearProveedor(regBD);
        }
        return pr;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Proveedor pr= null;

            while (regBD.next()) {
                pr = crearProveedor(regBD);
                mapa.put(pr.getId(), pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;

    }

    @Override
    public ResultSet getRegistroBD(String id) throws SQLException, NullPointerException {
        return super.getRegistroBD(id);
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
        Proveedor pr = (Proveedor) obj;
        String sentencia = "INSERT INTO " + nombreTabla + " values('" + pr.getId() + "','" + pr.getRazonSocial() + "','" + pr.getDireccion() + "','" + pr.getTelefono() + "','" + pr.getCiudad() + "','" + pr.getContacto() + "','" + pr.getCargoContacto() + "','" + pr.getEmail()+ "',NOW(),0)";
        System.out.println(sentencia);

        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Proveedor pr = (Proveedor) obj;
        String sentencia = null;
                sentencia = "UPDATE " + nombreTabla + " SET RAZONSOCIAL = '" + pr.getRazonSocial() + "',DIRECCION='" + pr.getDireccion() + "',TELEFONO='" + pr.getTelefono() + "',CIUDAD='" + pr.getCiudad() + "',CONTACTO='" + pr.getContacto() + "',CARGOCONTACTO='" +pr.getCargoContacto() + "',EMAIL='" + pr.getEmail()+"',TIMESTAMP = NOW() WHERE ID='" + pr.getId() + "'";
            System.out.println(sentencia);

          
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Proveedor pr = (Proveedor) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + pr.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    private Proveedor crearProveedor(ResultSet regBD) throws SQLException {
        Proveedor pr = new Proveedor();
        pr.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        pr.setId(regBD.getString(1));
        pr.setRazonSocial(regBD.getString(2));
        pr.setDireccion(regBD.getString(3));
        pr.setTelefono(regBD.getString(4));
        pr.setCiudad(regBD.getString(5));
        pr.setContacto(regBD.getString(6));
        pr.setCargoContacto(regBD.getString(7));
        pr.setEmail(regBD.getString(8));
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
