package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Departamento extends ObjetoPersistente {

    private String id, nombre;

    public Departamento() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }
    public Departamento(String id,String nombre){
        this();
        this.id = id;
        this.oid = id;
        this.nombre = nombre;
    }
    public Departamento(ArrayList datos){
        this();
        setId((String) datos.get(0));
        setNombre((String)datos.get(1));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }
      public ArrayList toArray(){
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(nombre);
        return datos;
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
        this.oid = id;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(id);
    }

    @Override
    public int compareTo(Object o) {
       Departamento c = (Departamento)o;
       return this.getNombre().compareTo(c.getNombre());
    }
  
}
