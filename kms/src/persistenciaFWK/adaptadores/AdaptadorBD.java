package persistenciaFWK.adaptadores;

import persistenciaFWK.*;
import java.util.Map;

/**
 * adapta a las necesidades ( Bd o al local )
 * @author Kymera Systems SAS
 */
public class AdaptadorBD implements IAdaptador{
    private Class clase;

    public AdaptadorBD(Class clasePersistente) {
        this.clase = clasePersistente;
    }


    public ObjetoPersistente getRegistro(String ID){
        ObjetoPersistente op = null;
        try {
            op = (ObjetoPersistente) FachadaDePersistencia.getInstancia().get(ID, clase);
        } catch (BDNoDisponibleException ex) {
           
        }
        return op;
    }

    public Map getRegistros() {
        Map mp = null;
        try {
            mp = FachadaDePersistencia.getInstancia().gets(clase);
        } catch (BDNoDisponibleException ex) {
             new InfoNoDisponibleException("No se puede conectar a la Base de Datos", ex.getCause());
        }
        return mp;
    }

    public Class getClaseObjeto(){
        return clase;
    }

    public void putObject(ObjetoPersistente obj, int tipo) {
       switch(tipo){
           case INSERTAR:{
               Transacciones.getInstancia().addObjetoaInsertar(obj);
               break;
           }
           case MODIFICAR:{
                Transacciones.getInstancia().addObjetoaActualizar(obj);
                break;
           }
           case ELIMINAR:{
                Transacciones.getInstancia().addObjetoaEliminar(obj);
                break;
           }
       }
    }

    public Map getRegistros(String[] parametrosBusqueda) {
        Map mapa = null;
        try {
            mapa = FachadaDePersistencia.getInstancia().getRegistrosxParametros(clase, parametrosBusqueda);
        } catch (BDNoDisponibleException ex) {
            new InfoNoDisponibleException("No se puede conectar a la Base de Datos", ex.getCause());
        }
        return mapa;
    }

    public Map getRegistros(String parametro) {
         Map mapa = null;
        try {
            mapa = FachadaDePersistencia.getInstancia().getRegistrosxParametros(clase, parametro);
        } catch (BDNoDisponibleException ex) {
            new InfoNoDisponibleException("No se puede conectar a la Base de Datos", ex.getCause());
        }
        return mapa;
    }
}