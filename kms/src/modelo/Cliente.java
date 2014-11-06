package modelo;

import java.util.ArrayList;
import java.util.Date;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Cliente extends ObjetoPersistente {

    private String id, nombre, apellido, fechaNacimiento, ciudad, telefono, direccion, email;
    private byte[] foto;

    public Cliente() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public Cliente(ArrayList datos) {
        this();
        setId((String) datos.get(0));
        setNombre((String) datos.get(1));
        setApellido((String) datos.get(2));
        setTelefono((String) datos.get(3));
        setFechaNacimiento(utilidades.Utilidades.getInstancia().datetoString((Date) datos.get(4)));
        setDireccion((String) datos.get(5));
        setCiudad((String) datos.get(6));
        setEmail((String) datos.get(7));
        setFoto((byte[]) datos.get(8));
    }

    public Cliente(String id) {
        this();
        this.id = id;
        this.oid = id;
    }

    public ArrayList toArray() {
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(nombre);
        datos.add(apellido);
        datos.add(telefono);
        datos.add(fechaNacimiento);
        datos.add(direccion);
        datos.add(ciudad);
        datos.add(email);
        datos.add(foto);
        return datos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
      public String toString(){
        return nombre + " " + apellido;
    }

    @Override
    public void setOID(String id) {
        this.oid = id;
    }
}
