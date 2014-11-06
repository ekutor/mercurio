package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class UnidadMedida extends ObjetoPersistente {

    String id,nombre;
    public UnidadMedida(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public UnidadMedida(String id,String nombre){
        this();
        this.id = id;
        this.nombre = nombre;
        this.oid = id;
    }
    public UnidadMedida(ArrayList l){
        this();
        setId((String) l.get(0));
        setNombre((String) l.get(1));
    }

    public ArrayList toArray(){
        ArrayList l = new ArrayList();
        l.add(id);
        l.add(nombre);
        return l;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString(){
        return nombre;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }

}
