package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Ciudad extends ObjetoPersistente {

    private String id, nombre, departamento;

    public Ciudad() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }
    public Ciudad(String id,String nombre,String depto){
        this();
        this.oid = id;
        this.nombre = nombre;
        this.departamento = depto;
    }
    public Ciudad(ArrayList datos){
        this();
        setId((String) datos.get(0));
        setNombre((String) datos.get(1));
        setDepartamento((String)datos.get(2));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList toArray(){
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(nombre);
        datos.add(departamento);
        return datos;
    }
    @Override
    public String toString(){
        return nombre;
    }

    @Override
    public void setOID(String id) {
        this.oid = id;
    }

    @Override
    public int compareTo(Object o) {
       Ciudad c = (Ciudad)o;
       return this.getNombre().compareTo(c.getNombre());
    }
}
