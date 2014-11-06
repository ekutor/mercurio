package conversores;

import utilidades.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Personal;
import persistenciaFWK.ConversorBDAbstracto;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author MindSoft
 */
public class ConversorBDEmpleado extends ConversorBDAbstracto {

    private static final String TABLA = "PERSONAL";

    public ConversorBDEmpleado() {
        setTabla();
    }

    @Override
    protected Object getObjetoDelRegistro(String id, ResultSet regBD) throws SQLException {
        Personal emp = null;
        if (regBD.next()) {
            emp = crearEmpleado(regBD);

        }
        return emp;
    }

    @Override
    protected Map getRegistrosDeTabla(ResultSet regBD) {
        Map mapa = new HashMap();
        try {
            Personal emp = null;
            while (regBD.next()) {
                emp = crearEmpleado(regBD);
                mapa.put(emp.getCedula(), emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConversorBDProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }

    @Override
    protected void setTabla() {
        this.nombreTabla = TABLA;
    }

    @Override
    protected String cargarSentenciaSQL() {
        return "SELECT * FROM " + nombreTabla + " WHERE ESTADOREG = 0";
    }

    @Override
    protected String insert(ObjetoPersistente obj) {
        Personal emp = (Personal) obj;
        String sentencia = null;
        if (emp.getFoto() != null) {
            agregarImagen = true;
            imagen = emp.getFoto();
            sentencia = "INSERT INTO " + nombreTabla + " values('" + emp.getCedula() + "','" + emp.getNombre() + "','" + emp.getApellido() + "','" + emp.getGenero() + "','" + emp.getFecha_nacimiento() + "','" + emp.getCiudadNacimiento() + "','" + emp.getLibretaMilitar() + "','" + emp.getDireccion() + "','" + emp.getTelefono() + "','" + emp.getCelular() + "','" + emp.getCiudad() + "','" + emp.getEmail() + "','" + emp.getCargo() + "','" + emp.getFecha_ingreso() + "','" + emp.getFecha_salida() + "','" + emp.getTipo_contratacion() + "','" + emp.getManipulacion_alimento() + "','" + emp.getEstado() + "','" + emp.getObservacion() + "',?,NOW(),'" + emp.getEstadoCivil() + "',0)";
            System.out.println(sentencia);
        } else {
            sentencia = "INSERT INTO " + nombreTabla + " values('" + emp.getCedula() + "','" + emp.getNombre() + "','" + emp.getApellido() + "','" + emp.getGenero() + "','" + emp.getFecha_nacimiento() + "','" + emp.getCiudadNacimiento() + "','" + emp.getLibretaMilitar() + "','" + emp.getDireccion() + "','" + emp.getTelefono() + "','" + emp.getCelular() + "','" + emp.getCiudad() + "','" + emp.getEmail() + "','" + emp.getCargo() + "','" + emp.getFecha_ingreso() + "','" + emp.getFecha_salida() + "','" + emp.getTipo_contratacion() + "','" + emp.getManipulacion_alimento() + "','" + emp.getEstado() + "','" + emp.getObservacion() + "',null,NOW(),'" + emp.getEstadoCivil() + "',0)";
            System.out.println(sentencia);
        }

        return sentencia;
    }

    @Override
    protected String update(ObjetoPersistente obj) {
        Personal emp = (Personal) obj;
        String sentencia = null;
        if (obj.recuperarRegistro) {
            sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 0 WHERE ID ='" + 
                    emp.getCedula() + "'";
            obj.recuperarRegistro = false;
        } else {
            if (emp.getFoto() != null) {
                agregarImagen = true;
                imagen = emp.getFoto();
                sentencia = "UPDATE " + nombreTabla + " SET NOMBRE='" + emp.getNombre() + "',APELLIDO='" + emp.getApellido() + "',GENERO='" + emp.getGenero() + "',FECHA_NAC='" + emp.getFecha_nacimiento() + "',CIUDAD_NAC='" + emp.getCiudadNacimiento() + "',LIBRETA='" + emp.getLibretaMilitar() + "',DIRECCION='" + emp.getDireccion() + "',TELEFONO='" + emp.getTelefono() + "',CELULAR='" + emp.getCelular() + "',CIUDAD='" + emp.getCiudad() + "',EMAIL='" + emp.getEmail() + "',CARGO='" + emp.getCargo() + "',FECHA_ING='" + emp.getFecha_ingreso() + "',FECHA_RETI='" + emp.getFecha_salida() + "',TIPO_CONTR='" + emp.getTipo_contratacion() + "',CERTIFICADO='" + emp.getManipulacion_alimento() + "',ESTADO='" + emp.getEstado() + "',OBS='" + emp.getObservacion() + "',FOTO=?,TIMESTAMP=NOW(),ESTADOCIVIL='" + emp.getEstadoCivil() + "' WHERE ID='" + emp.getCedula() + "'";
                System.out.println(sentencia);
            } else {
                sentencia = "UPDATE " + nombreTabla + " SET NOMBRE='" + emp.getNombre() + "',APELLIDO='" + emp.getApellido() + "',GENERO='" + emp.getGenero() + "',FECHA_NAC='" + emp.getFecha_nacimiento() + "',CIUDAD_NAC='" + emp.getCiudadNacimiento() + "',LIBRETA='" + emp.getLibretaMilitar() + "',DIRECCION='" + emp.getDireccion() + "',TELEFONO='" + emp.getTelefono() + "',CELULAR='" + emp.getCelular() + "',CIUDAD='" + emp.getCiudad() + "',EMAIL='" + emp.getEmail() + "',CARGO='" + emp.getCargo() + "',FECHA_ING='" + emp.getFecha_ingreso() + "',FECHA_RETI='" + emp.getFecha_salida() + "',TIPO_CONTR='" + emp.getTipo_contratacion() + "',CERTIFICADO='" + emp.getManipulacion_alimento() + "',ESTADO='" + emp.getEstado() + "',OBS='" + emp.getObservacion() + "',FOTO=null,TIMESTAMP=NOW(),ESTADOCIVIL='" + emp.getEstadoCivil() + "'WHERE ID='" + emp.getCedula() + "'";
                System.out.println(sentencia);
            }
        }
        return sentencia;
    }

    @Override
    protected String delete(ObjetoPersistente obj) {
        Personal emp = (Personal) obj;
        String sentencia = "UPDATE " + nombreTabla + " SET ESTADOREG = 1 WHERE ID ='" + emp.getCedula() + "'";
        return sentencia;
    }

    public Personal crearEmpleado(ResultSet regBD) throws SQLException {
        Personal emp = new Personal();
        emp.setEstadoObjeto(ObjetoPersistente.LIMPIO);
        emp.setCedula(regBD.getString(1));
        emp.setNombre(regBD.getString(2));
        emp.setApellido(regBD.getString(3));
        emp.setGenero(regBD.getString(4));
        emp.setFecha_nacimiento(Utilidades.datetoString(regBD.getDate(5)));
        emp.setCiudadNacimiento(regBD.getString(6));
        emp.setLibretaMilitar(regBD.getString(7));
        emp.setDireccion(regBD.getString(8));
        emp.setTelefono(regBD.getString(9));
        emp.setCelular(regBD.getString(10));
        emp.setCiudad(regBD.getString(11));
        emp.setEmail(regBD.getString(12));
        emp.setCargo(regBD.getString(13));
        emp.setFecha_ingreso(Utilidades.datetoString(regBD.getDate(14)));
        emp.setFecha_salida(Utilidades.datetoString(regBD.getDate(15)));
        emp.setTipo_contratacion(regBD.getString(16));
        emp.setManipulacion_alimento(regBD.getString(17));
        emp.setEstado(regBD.getString(18));
        emp.setObservacion(regBD.getString(19));
        byte[] bl = regBD.getBytes(20);
        if (bl != null) {
            emp.setFoto(bl);
        } else {
            emp.setFoto(null);
        }
        emp.setEstadoCivil(regBD.getString(22));
        return emp;
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
