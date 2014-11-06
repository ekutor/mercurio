package modelo;

import utilidades.Utilidades;
import java.util.ArrayList;
import java.util.Date;
import persistenciaFWK.EstadoNuevo;
import persistenciaFWK.ObjetoPersistente;

/**
 *
 * @author MindSoft
 */
public class Personal extends ObjetoPersistente {

    String cedula, nombre, apellido, telefono, direccion;
    String cargo, celular, email, libretaMilitar, estadoCivil;
    String tipo_contratacion, genero, manipulacion_alimento;
    String observacion, estado, fecha_nacimiento, fecha_ingreso;
    String fecha_salida, ciudad, ciudadNacimiento;
    byte[] foto;

    public Personal() {
        setEstadoObjeto(EstadoNuevo.getInstancia());
    }

    public Personal(ArrayList datos) {
        this();
        setCedula(datos.get(0).toString());
        setNombre(datos.get(1).toString());
        setApellido(datos.get(2).toString());
        setGenero(datos.get(3).toString());
        setFecha_nacimiento(Utilidades.getInstancia().datetoString((Date) datos.get(4)));
        this.setCiudadNacimiento(datos.get(5).toString());
        setLibretaMilitar(datos.get(6).toString());
        setDireccion(datos.get(7).toString());
        setTelefono(datos.get(8).toString());
        setCelular(datos.get(9).toString());
        this.setCiudad(datos.get(10).toString());
        setEmail(datos.get(11).toString());
        setCargo(datos.get(12).toString());
        setFecha_ingreso(Utilidades.getInstancia().datetoString((Date) datos.get(13)));
        setFecha_salida(Utilidades.getInstancia().datetoString((Date) datos.get(14)));
        setTipo_contratacion(datos.get(15).toString());
        setManipulacion_alimento(datos.get(16).toString());
        setEstado(datos.get(17).toString());
        setObservacion(datos.get(18).toString());
        setFoto((byte[]) datos.get(19));
        setEstadoCivil(datos.get(20).toString());

    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion.toUpperCase();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero.toUpperCase();
    }

    public String getManipulacion_alimento() {
        return manipulacion_alimento;
    }

    public void setManipulacion_alimento(String manipulacion_alimento) {
        this.manipulacion_alimento = manipulacion_alimento.toUpperCase();
    }

    public ArrayList toArray() {
        ArrayList datos = new ArrayList();
        datos.add(cedula);
        datos.add(nombre);
        datos.add(apellido);
        datos.add(genero);
        datos.add(fecha_nacimiento);
        datos.add(ciudadNacimiento);
        datos.add(libretaMilitar);
        datos.add(direccion);
        datos.add(telefono);
        datos.add(celular);
        datos.add(ciudad);
        datos.add(email);
        datos.add(cargo);
        datos.add(fecha_ingreso);
        datos.add(fecha_salida);
        datos.add(tipo_contratacion);
        datos.add(manipulacion_alimento);
        datos.add(estado);
        datos.add(observacion);
        datos.add(foto);
        datos.add(estadoCivil);
        return datos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil.toUpperCase();
    }

    public String getLibretaMilitar() {
        return libretaMilitar;
    }

    public void setLibretaMilitar(String libretaMilitar) {
        this.libretaMilitar = libretaMilitar;
    }

    public String getTipo_contratacion() {
        return tipo_contratacion;
    }

    public void setTipo_contratacion(String tipo_contratacion) {
        this.tipo_contratacion = tipo_contratacion;
    }

    public String getApellido() {
        return apellido.toUpperCase();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toUpperCase();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedual) {
        this.cedula = cedual;
        this.oid = cedual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.toUpperCase();
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void setOID(String id) {
        oid = id;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    @Override
    public String toString() {
        return nombre+" " + apellido;
    }

}
