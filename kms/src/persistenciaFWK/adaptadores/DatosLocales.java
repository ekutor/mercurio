package persistenciaFWK.adaptadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import persistenciaFWK.*;

/**
 * Clase que maneja los Datos en el Disco Duro de la maquina
 * @author Kymera Systems SAS
 */
public class DatosLocales implements IAdaptador, Runnable {

    private IAdaptador servicioRemoto;
    private ControladorArchivos archivo;
    private Class claseaUsar;
    private Thread hilo;

    /**
     * servicio Remoto es la conexion a la BD
     * @param servicioRemoto
     */
    public DatosLocales(IAdaptador servicioRemoto) {
        this.servicioRemoto = servicioRemoto;
        //obtiene la clase persistente para que guarde los objetos de esa clase
        //en un archivo con el mismo nombre de la clase.
        claseaUsar = servicioRemoto.getClaseObjeto();
        archivo = new ControladorArchivos(claseaUsar);
        //hilo = new Thread(this);  //hilo para buscar archivos locales y actualizar en la BD
        //hilo.start();
    }

    /**
     * obtiene un objeto del disco duro
     * @param ID
     * @return
     */
    public ObjetoPersistente getRegistro(String ID) {

        ObjetoPersistente objeto = this.servicioRemoto.getRegistro(ID);
        /*
        //puede validar si esta o no conectado
        //FachadaDePersistencia.isOnline();
        //busca un objeto por su id
        ObjetoPersistente objeto = null;
        // -1 TRAE EL ULTIMO REGISTRO
        if (!ID.equals("-1")) {
            objeto = (ObjetoPersistente) archivo.leerObjeto(ID);
        }
        if (objeto == null) {
            //si no se encuentra el objeto los busca en la BD
            objeto = this.servicioRemoto.getRegistro(ID);
            if (!ID.equals("-1")) {
                try {
                    this.anularEstadoObjeto(objeto);
                    archivo.escribirObjeto(claseaUsar.cast(objeto), ID);
                    this.recargarEstadoObjeto(objeto);
                } catch (NullPointerException ne) {
                    System.out.println("Producto no encontrado en la BD");
                    new InfoNoDisponibleException("Registro no encontrado en la BD");
                }
            }
        } else {
            this.recargarEstadoObjeto(objeto);
        }*/
        return objeto;
    }

    /**
     * Obtiene todos los objetos que tenga el archivo local
     * @return un Map con los registros solicitados
     */
    public Map getRegistros() {


        Map mp = new HashMap();
        mp = this.servicioRemoto.getRegistros();
        
//        //obtiene todos los objetos locales
//        mp = archivo.getObjetos();
//        if (mp == null || mp.isEmpty()) {
//            //obtiene todos los objeos de la BD
//            mp = this.servicioRemoto.getRegistros();
//            if (mp != null) {
//                this.anularEstadoObjeto(mp);
//                archivo.setObjetos(mp);
//                this.recargarEstadoObjeto(mp);
//            }
//        } else {
//            this.recargarEstadoObjeto(mp);
//        }
        return mp;
    }

    public Class getClaseObjeto() {
        return claseaUsar;
    }

    public void putObject(ObjetoPersistente obj, int tipo) {

        /*switch (tipo) {
            case INSERTAR: {
                archivo.escribirObjeto(obj, obj.oid);
                break;
            }
            case MODIFICAR: {
                archivo.reemplazarObjeto(obj.oid, obj);
                break;
            }
            case ELIMINAR: {
                archivo.eliminarObjeto(obj.oid);
                break;
            }
        }*/
        servicioRemoto.putObject(obj, tipo);
    }

    public void putObject(ObjetoPersistente obj) {
        //escribira todo en el archivo offline
//        archivo = new ControladorArchivos(claseaUsar, ControladorArchivos.CONEX_OFF_LINE);
//        archivo.escribirObjeto(obj, obj.oid);

    }

    private void anularEstadoObjeto(ObjetoPersistente objeto) {
        objeto.setEstadoObjeto(ObjetoPersistente.NULO);
    }

    private void recargarEstadoObjeto(ObjetoPersistente objeto) {
        objeto.setEstadoObjeto(objeto.estadoObjetoInt);
    }

    private void anularEstadoObjeto(Map<Object, ObjetoPersistente> objs) {
        Iterator it = objs.values().iterator();
        while (it.hasNext()) {
            this.anularEstadoObjeto((ObjetoPersistente) it.next());
        }
    }

    private void recargarEstadoObjeto(Map objs) {
        Iterator it = objs.values().iterator();
        while (it.hasNext()) {
            this.recargarEstadoObjeto((ObjetoPersistente) it.next());
        }
    }

    public void run() {
        //para siempre
        //while(true){
        //}
    }

    public Map getRegistros(String[] parametrosBusqueda) {
        return servicioRemoto.getRegistros(parametrosBusqueda);
    }

    public Map getRegistros(String parametro) {
        return servicioRemoto.getRegistros(parametro);
    }
}
