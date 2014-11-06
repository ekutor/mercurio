package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Categoria extends ObjetoPersistente {

    String id, nombre;

    public Categoria() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public Categoria(String id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.oid = id;
    }

    public Categoria(ArrayList datos) {
        this();
        setId((String) datos.get(0));
        setNombre((String) datos.get(1));
    }

    public ArrayList toArray() {
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(nombre);
        return datos;
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
        this.nombre = nombre.toUpperCase();
    }

    public String toString() {
        return nombre;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }
}
