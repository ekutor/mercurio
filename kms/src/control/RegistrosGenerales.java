/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;


import modelo.Categoria;
import modelo.Cliente;
import modelo.Personal;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Descuento;
import utilidades.InvalidException;

/**
 *
 * @author KYMERA SYSTEMS
 */
public class RegistrosGenerales {

    public static final String CARGAR_CLIENTE = "cliente";
    public static final String CARGAR_PERSONAL = "personal";
    public static final String CARGAR_PROVEEDOR = "proveedor";
    public static final String CARGAR_PRODUCTO = "producto";
    public static final String STOCK_MINIMO = "stock";
    public static final String FECHA_VENCIMIENTO = "fecha_vencimiento";
    public static final String CARGAR_CATEGORIA = "categoria";
    private List<ObservadorEventos> observadores;
    public static final int INSERTAR = 1;
    public static final int MODIFICAR = 2;
    public static final int ELIMINAR = 3;

    public RegistrosGenerales() {
        observadores = new ArrayList();
    }

    /************ A D M I N I S T R A R ************/
    public void administrarClientes(Object datos, int tipo) {
        try {
            CatalogosManager.getInstancia().administrarClientes(datos, tipo);
            cargarCliente(CatalogosManager.PRIMERO);
        } catch (InvalidException ex) {
        }
    }

    public void administrarPersonal(Object datos, int tipo) {
        try {
            CatalogosManager.getInstancia().administrarPersonal(datos, tipo);
            cargarPersonal(CatalogosManager.PRIMERO);
        } catch (InvalidException ex) {

        }
    }

    public void administrarProveedor(Object datos, int tipo) {
        try {
            CatalogosManager.getInstancia().administrarProveedor(datos, tipo);
            cargarProveedores(CatalogosManager.PRIMERO);
        } catch (InvalidException ex) {
        }
    }

    public void administrarProducto(Object datos, int tipo) {
        try {
            CatalogosManager.getInstancia().administrarProducto(datos, tipo);
            cargarProductos(CatalogosManager.PRIMERO);
        } catch (InvalidException ex) {
        }
    }

    public void administrarDescuentos(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarDescuentos(datos, tipo);

    }

    public void administrarDescxCateg(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarDescuentosxCategoria(datos, tipo);

    }

    public void administrarCategorias(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarCategorias(datos, tipo);

    }

    public void administrarCargos(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarCargos(datos, tipo);
    }

    public void administrarUnidades(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarUnidades(datos, tipo);
    }

    public void administrarMarca(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarMarca(datos, tipo);
    }

    public void administrarUbicacion(Object datos, int tipo) {
        CatalogosManager.getInstancia().administrarUbicacion(datos, tipo);
    }

    /************ C A R G A R *********************/
    public void cargarPersonal(int pos)throws InvalidException {
        Personal personal = null;
        personal = CatalogosManager.getInstancia().cargarPersonal(pos);
        PuntoDeVenta.getInstancia().publicarEvento(CARGAR_PERSONAL, personal.toArray());
    }

    public void cargarProveedores(int pos) throws InvalidException {
        Proveedor pr = null;
        pr = CatalogosManager.getInstancia().cargarProveedor(pos);
        PuntoDeVenta.getInstancia().publicarEvento(CARGAR_PROVEEDOR, pr.toArray());

    }

    public void cargarProductos(int pos) throws InvalidException {
        Producto pr = null;
        pr = CatalogosManager.getInstancia().cargarProducto(pos);
        PuntoDeVenta.getInstancia().publicarEvento(CARGAR_PRODUCTO, pr.toArray());

    }

    public void cargarCliente(int pos) throws InvalidException {
        Cliente cliente = null;
        cliente = CatalogosManager.getInstancia().cargarCliente(pos);
        PuntoDeVenta.getInstancia().publicarEvento(CARGAR_CLIENTE, cliente.toArray());

    }

    public void cargarCategoria() {
        List l = CatalogosManager.getInstancia().obtenerCategorias();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_CATEGORIA, l);
    }

    public void cargarCargos() {
        List l = CatalogosManager.getInstancia().obtenerCargos();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_CARGOS, l);
    }

    public void actualizarTablaCategoria() {
        List l = CatalogosManager.getInstancia().obtenerCategorias();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ACTUALIZAR_TABLA, l);
    }

    public void actualizarTablaCargo() {
        List l = CatalogosManager.getInstancia().obtenerCargos();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ACTUALIZAR_TABLA, l);
    }

    public void stockMinimo(int cant) {
        ArrayList c = CatalogosManager.stockMinimo(cant);
        if (c.size() > 0) {
            PuntoDeVenta.getInstancia().publicarEvento(STOCK_MINIMO, c);
        } else {
        }

    }

    public void fechaVencimiento(String fecha) {
        ArrayList c = CatalogosManager.fechaVencimiento(fecha);
        if (c.size() > 0) {
            PuntoDeVenta.getInstancia().publicarEvento(FECHA_VENCIMIENTO, c);
        } else {
        }
    }

    public List getDescuentosDia() throws InvalidException {
        return CatalogosManager.buscarRegistro("hoy", CatalogosManager.DESCUENTO);
    }

    public int obtenerPosProducto(String nom) {
        int pos = 0;
        return pos = CatalogosManager.getInstancia().obtenerPosProducto(nom);
    }

//    public int obtenerPosPersonal(String nom) {
//        int pos = 0;
//        return pos = CatalogosManager.getInstancia().obtenerPosPersonal(nom);
//    }
    public void busquedas(String id, int tipo) {
        switch (tipo) {
            case CatalogosManager.PERSONAL: {
                Personal personal = null;
                personal = (Personal) CatalogosManager.getRegistro(id, CatalogosManager.PERSONAL);
                PuntoDeVenta.getInstancia().publicarEvento(CARGAR_PERSONAL, personal.toArray());
                break;
            }
            case CatalogosManager.PROVEEDOR: {
                Proveedor proveedor = null;
                proveedor = (Proveedor) CatalogosManager.getRegistro(id, CatalogosManager.PROVEEDOR);
                PuntoDeVenta.getInstancia().publicarEvento(CARGAR_PROVEEDOR, proveedor.toArray());
            }
            case CatalogosManager.CLIENTE: {
                Cliente cliente = null;
                cliente = (Cliente) CatalogosManager.getRegistro(id, CatalogosManager.CLIENTE);
                PuntoDeVenta.getInstancia().publicarEvento(CARGAR_CLIENTE, cliente.toArray());
            }
        }
    }
      public void actualizarTablaUnidad() {
        List l = CatalogosManager.getInstancia().obtenerUnidades();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ACTUALIZAR_TABLA, l);
    }

    public void actualizarTablaMarca() {
        List l = CatalogosManager.getInstancia().obtenerMarcas();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ACTUALIZAR_TABLA, l);
    }

    public void actualizarTablaUbicacion() {
        List l = CatalogosManager.getInstancia().obtenerUbicaciones();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.ACTUALIZAR_TABLA, l);
    }

    public void cargarUnidades() {
        List l = CatalogosManager.getInstancia().obtenerUnidades();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_UNIDADES, l);

    }

    public void cargarMarcas() {
        List l = CatalogosManager.getInstancia().obtenerMarcas();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_MARCAS, l);
    }

    public void cargarUbicaciones() {
        List l = CatalogosManager.getInstancia().obtenerUbicaciones();
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.CARGAR_UBICACION, l);
    }


}
