package conversores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class ConversorBDCliente extends ConversorBDAbstracto{
    private static final String TABLA ="CLIENTE";
    
    public ConversorBDCliente(){
        setTabla();
    }
    
    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Cliente cl = null;
        if(regBD.next()){
            cl = crearCliente(regBD);
        }
        return cl;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
       Map mapa = new HashMap();
       try{
           Cliente cl=null;
           while(regBD.next()){
               cl = crearCliente(regBD);
               mapa.put(cl.getId(), cl);
           }
       }catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
       return mapa;
    }

    @Override
    protected void setTabla() {
        nombreTabla =TABLA;
    }
    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla + " WHERE ESTADOREG = 0";
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        Cliente cl = (Cliente) obj;
        String sentencia = null;
        if (cl.getFoto() != null) {
            agregarImagen = true;
            imagen = cl.getFoto();
            sentencia = "INSERT INTO " + nombreTabla + " values('" + cl.getId() + "','" + cl.getNombre() + "','" + cl.getApellido() + "','" + cl.getTelefono() + "','" + cl.getFechaNacimiento() + "','" + cl.getDireccion() + "','" + cl.getCiudad() + "','" + cl.getEmail() + "',NOW(),?,0)";
            System.out.println(sentencia);
        } else {
            sentencia = "INSERT INTO " + nombreTabla + " values('" + cl.getId() + "','" + cl.getNombre() + "','" + cl.getApellido() + "','" + cl.getTelefono() + "','" + cl.getFechaNacimiento() + "','" + cl.getDireccion() + "','" + cl.getCiudad() + "','" + cl.getEmail() + "',NOW(),null,0)";
            System.out.println(sentencia);
        }

        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Cliente cl = (Cliente) obj;
        String sentencia = null;
        if (cl.getFoto() != null) {
            agregarImagen = true;
            imagen = cl.getFoto();
            sentencia = "UPDATE " + nombreTabla + " SET NOMBRE = '" + cl.getNombre() + "',APELLIDO='" + cl.getApellido() + "',TELEFONO='" + cl.getTelefono() + "',FECHA_NACIMIENTO='" + cl.getFechaNacimiento() + "',DIRECCION='" + cl.getDireccion() + "',CIUDAD='" + cl.getCiudad() + "',EMAIL='" + cl.getEmail() + "',TIMESTAMP= NOW(),FOTO= ? WHERE ID='" + cl.getId() + "'";
            System.out.println(sentencia);
        } else {
            sentencia = "UPDATE " + nombreTabla + " SET NOMBRE = '" + cl.getNombre() + "',APELLIDO='" + cl.getApellido() + "',TELEFONO='" + cl.getTelefono() + "',FECHA_NACIMIENTO='" + cl.getFechaNacimiento() + "',DIRECCION='" + cl.getDireccion() + "',CIUDAD='" + cl.getCiudad() + "',EMAIL='" + cl.getEmail() + "',TIMESTAMP= NOW(),FOTO= null WHERE ID='" + cl.getId() + "'";
            System.out.println(sentencia);
        }
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
      Cliente cl= (Cliente) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + cl.getId() + "'";
        System.out.println(sentencia);
        return sentencia;
    }

    public Cliente crearCliente(ResultSet r) throws SQLException{
        Cliente cl = new Cliente();
        cl.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        cl.setId(r.getString(1));
        cl.setNombre(r.getString(2));
        cl.setApellido(r.getString(3));
        cl.setTelefono(r.getString(4));
        cl.setFechaNacimiento(utilidades.Utilidades.getInstancia().datetoString(r.getDate(5)));
        cl.setDireccion(r.getString(6));
        cl.setCiudad(r.getString(7));
        cl.setEmail(r.getString(8));
         byte[] bl = regBD.getBytes(10);
        if (bl != null) {
            cl.setFoto(bl);
        } else {
            cl.setFoto(null);
        }
         return cl;


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
