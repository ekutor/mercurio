
package modelo;

import java.util.ArrayList;
import java.util.List;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Usuario extends ObjetoPersistente{
    private String usuario, contrasena;
    private String empleado;
    private int permisos;

    public Usuario() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }
    public Usuario(String usuario,String contrasena,int tipo){
        this();
        this.oid = usuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.permisos = tipo;
    }
    public Usuario(List datos){
        this();
        setUsuario((String) datos.get(0));
        setContrasena((String) datos.get(1));
        setPermisos((Integer)datos.get(2));

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        this.oid = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String nom){
        empleado = nom;
    }

    public int getPermisos() {
        return permisos;
    }
    public void setPermisos(int p){
        permisos = p;
    }
    
    @Override
    public void setOID(String id) {
        this.oid = id;
    }

    public List toArray(){
        List ar = new ArrayList();
        ar.add(this.getUsuario());
        ar.add(this.getContrasena());
        ar.add(this.getPermisos());
        ar.add(this.getEmpleado());
        return ar;
    }

    @Override
    public String toString() {
        return this.usuario;
    }

   
}
