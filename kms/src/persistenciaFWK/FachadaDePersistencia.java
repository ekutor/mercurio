package persistenciaFWK;

import conversores.Conversores;
import java.util.Map;


/**
 * singleton
 * @author Kymera Systems SAS
 */
public class FachadaDePersistencia {//la molienda express

    private static FachadaDePersistencia INSTANCIA;
    private Map conversores;
    private IConversor conversor;

    //mantiene el estado de conexion al servidor
    private static boolean ONLINE=true;

    private FachadaDePersistencia() {
        this.getConversores();
    }

    public synchronized static FachadaDePersistencia getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new FachadaDePersistencia();
            
        }
        return INSTANCIA;
    }

    public Object get(String id, Class clasePersistente) throws BDNoDisponibleException {
        //la clave del HM de Iconversores es la clase del obj persistente
        conversor = (IConversor) conversores.get(clasePersistente);
        Object ob;
        try {
            ob = conversor.get(id);
            setOnline(true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            setOnline(false);
            throw new BDNoDisponibleException(e.getCause());

        }

        return ob;
    }

    public void put(String oid, Object obj) {
        conversor.put(oid, obj);//para poner en cache

    }

    public Map gets(Class clasePersistente) throws BDNoDisponibleException {
        Map mp = null;
        conversor = (IConversor) conversores.get(clasePersistente);
        try {
            mp = conversor.gets();
             setOnline(true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
             setOnline(false);
            throw new BDNoDisponibleException(e.getCause());
        }
        return mp;
    }

     public Map getRegistrosxParametros(Class clasePersistente, String[] parametros) throws BDNoDisponibleException{
         Map mp = null;
        conversor = (IConversor) conversores.get(clasePersistente);
        try {
            mp = conversor.gets(parametros);
             setOnline(true);
        } catch (java.sql.SQLException e) {
             setOnline(false);
            throw new BDNoDisponibleException(e.getCause());
        }
        return mp;
     }
     public Map getRegistrosxParametros(Class clasePersistente, String parametro) throws BDNoDisponibleException{
         Map mp = null;
        conversor = (IConversor) conversores.get(clasePersistente);
        try {
            mp = conversor.gets(parametro);
             setOnline(true);
        } catch (java.sql.SQLException e) {
             setOnline(false);
            throw new BDNoDisponibleException(e.getCause());
        }
        return mp;
     }

    private void getConversores() {
        this.conversores = Conversores.getConversores();
    }

    /**
     * inserta objetos en el tipo de persistencia actual
     * @param obj el objeto a insertar
     * @return true si se completa la transaccion en el DBMS
     */
    public boolean insertar(Object obj) {
        conversor = (IConversor) conversores.get(obj.getClass());
        return conversor.putEnAlmacenamiento(obj,conversor.INSERTAR);
    }

    /**
     * actualiza objetos en el tipo de persistencia actual
     * @param el objeto a modificar
     * @return true si se completa la transaccion en el DBMS
     */
    public boolean actualizar(Object obj) {
        conversor = (IConversor) conversores.get(obj.getClass());
        return conversor.putEnAlmacenamiento(obj,conversor.MODIFICAR);
    }

    /**
     * elimina objetos de la persistencia actual
     * @param obj el objeto a eliminar
     * @return true si se completa la transaccion en el DBMS
     */
    public boolean eliminar(Object obj) {
        conversor = (IConversor) conversores.get(obj.getClass());
        return conversor.putEnAlmacenamiento(obj,conversor.ELIMINAR);
    }

    /**
     * recarga un objeto de la cache
     * @param obj
     */
    public boolean recargar(Object obj) {
        return true;
    }

    /**
     * Devuelve el estado de la conexion al DBMS
     * @return
     */
    public static boolean isOnline(){
        return ONLINE;
    }
    /**
     * Establece el estado de la conexion de la app con el DBMS
     * @param estado
     */
    public static void setOnline(boolean estado){
        ONLINE=estado;
        System.out.println("Estado de conexion "+FachadaDePersistencia.ONLINE);
        control.PuntoDeVenta.getInstancia().publicarEvento(control.PuntoDeVenta.ONLINE, ONLINE);
    }

    public static void recuperarRegistroEliminado(ObjetoPersistente obj){
        javax.swing.JOptionPane.showMessageDialog(null,"Este Registro ya existia en el Sistema " +
                "\nY ha sido recuperado. Por favor Verifique!",
                "Registro Recuperado", javax.swing.JOptionPane.WARNING_MESSAGE);
        if(obj instanceof modelo.Personal){
            control.CatalogoPersonal.cargarMap();
        }else if(obj instanceof modelo.Producto){
            control.CatalogoProductos.cargarMap(modelo.Producto.class);
        }else if(obj instanceof modelo.Cliente){
            control.CatalogoClienteProveedor.cargarMap(modelo.Cliente.class);
        }else if(obj instanceof modelo.Proveedor){
            control.CatalogoClienteProveedor.cargarMap(modelo.Proveedor.class);
        }
    }
}
