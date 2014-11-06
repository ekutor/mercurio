package modelo;

import java.util.ArrayList;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author Kymera Systems SAS
 */
public class Proveedor extends ObjetoPersistente {

    private String id, razonSocial, direccion, telefono, ciudad, contacto, cargoContacto, email;

    public Proveedor() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }
    public Proveedor(ArrayList datos){
        this();
        setId((String)datos.get(0));
        setRazonSocial((String) datos.get(1));
        setDireccion((String)datos.get(2));
        setTelefono((String)datos.get(3));
        setCiudad((String)datos.get(4));
        setContacto((String)datos.get(5));
        setCargoContacto((String)datos.get(6));
        setEmail((String)datos.get(7));
    }
    public ArrayList toArray(){
        ArrayList datos = new ArrayList();
        datos.add(id);
        datos.add(razonSocial);
        datos.add(direccion);
        datos.add(telefono);
        datos.add(ciudad);
        datos.add(contacto);
        datos.add(cargoContacto);
        datos.add(email);
        return datos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.oid = id;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto.toUpperCase();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto.toUpperCase();
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

    public String getRazonSocial() {
        return razonSocial.toUpperCase();
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial.toUpperCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String toString(){
        return razonSocial;
    }

    @Override
    public void setOID(String id) {
        this.oid = id;
    }
}
