package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Cargo extends ObjetoPersistente  {

    String id,nombre;//Comntario Nuevo

    public Cargo(){
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public Cargo(String id,String nombre){
        this();
        this.id = id;
        this.nombre = nombre;
        this.oid = id;
    }
    public Cargo(ArrayList d){
        this();
        setId((String) d.get(0));
        setNombre((String) d.get(1));
    }
    public ArrayList toArray(){
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(nombre);
        return datos;
    }

    public String getId() {
        return id.toUpperCase();
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
    public String toString(){
        return nombre;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }

    public int compareTo(Object o) {
       Cargo c = (Cargo)o;
       return this.getNombre().compareTo(c.getNombre());
    }
      
}
