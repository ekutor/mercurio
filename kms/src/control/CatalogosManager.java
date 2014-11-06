package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.*;
import persistenciaFWK.adaptadores.IAdaptador;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogosManager {

    private static IAdaptador adaptador;
    private static CatalogosManager INSTANCIA;
    public static final int PRIMERO = 0;
    public static final int SIGUIENTE = 10;
    public static final int ANTERIOR = 20;
    public static final int ULTIMO = 99;
    public static final int PRODUCTO = 33;
    public static final int PROVEEDOR = 42;
    public static final int CLIENTE = 69;
    public static final int PERSONAL = 71;
    public static final int DESCUENTO = 13;
    public static final int CATEGORIA = 66;
    public static final int COMPRA = 93;
    public static final int CARGO = 77;
    public static final int UNIDAD = 88;
    public static final int MARCA = 89;
    public static final int UBICACION = 90;
    private static CatalogoUsuarios usuarios;
    private static CatalogoClienteProveedor cliprov;
    private static CatalogoPersonal personal;
    private static CatalogoProductos producto;
    private static CatalogoDescuento descuentos;
    private static CatalogosGenerales ctGenerales;
    private static HistorialCompras hisCompras;
    public static String idCliente;

    public static CatalogosManager getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new CatalogosManager();
        }
        return INSTANCIA;
    }

    public static Map getEmpleados() {
        Map mp = CatalogoPersonal.personalEnCache;
        if (mp == null) {
            new CatalogoPersonal();
            mp = CatalogoPersonal.personalEnCache;
        }
        return mp;
    }
    public static Map getEmpleadosActivos() {
        Map mp = new HashMap();
        if (CatalogoPersonal.personalEnCache == null) {
            new CatalogoPersonal();
            for(Map.Entry me :CatalogoPersonal.personalEnCache.entrySet()){
                Personal p = (Personal) me.getValue();
                if(p.getEstado().equalsIgnoreCase("activo")){
                    mp.put(me.getKey(), p);
                }
            }
        }
        return mp;
    }

    public static Map getClientes() {
        Map mp = CatalogoClienteProveedor.clienteEnCache;
        if (mp == null) {
            CatalogoClienteProveedor.cargarMap(Cliente.class);
            mp = CatalogoClienteProveedor.clienteEnCache;
        }
        return mp;
    }
        public static Map getMarcas() {
        Map mp = CatalogosGenerales.marcaEnCache;
        if (mp == null) {
            CatalogosGenerales.cargarMap(Marca.class);
            mp = CatalogosGenerales.marcaEnCache;
        }
        return mp;
    }

    public static Map getUbicacion() {
        if (CatalogosGenerales.ubicacionEnCache == null) {
            CatalogosGenerales.cargarMap(modelo.Ubicacion.class);
        }
        return CatalogosGenerales.ubicacionEnCache;
    }

    public static List buscarRegistro(String nombre, int tipo) throws InvalidException {
        crearCatalogo(tipo);
        List al = new ArrayList();
        switch (tipo) {
            case PRODUCTO: {
                al = producto.buscarNomProducto(nombre);
                break;
            }
            case PROVEEDOR: {
                al = cliprov.buscarNomProveedor(nombre);
                break;
            }
            case CLIENTE: {
                al = cliprov.buscarNomCliente(nombre);
                break;
            }
            case DESCUENTO: {
                al = descuentos.getDescuentosActivos();
                for (Object o : al) {
                    List l = (List) o;
                    Producto prod = (Producto) getRegistro(l.get(0).toString(), PRODUCTO);
                    l.set(0, prod.getDescripcion());
                }
                break;
            }
            case PERSONAL: {
                al = personal.buscarNombrePersonal(nombre);
                break;
            }
            case COMPRA: {
                al = hisCompras.buscarComprasFiltro(nombre);
                break;
            }
        }
        return al;
    }

    /**
     * Busca en la cache los objetos segun su id y los retorna como un
     * Object
     * @param id
     * @param tipo
     * @return
     */
    public static Object getRegistro(String id, int tipo) {
        Object obj = null;
        crearCatalogo(tipo);
        switch (tipo) {
            case PERSONAL: {
                obj = personal.getPersonal(id);
                break;
            }
            case DESCUENTO: {
                obj = descuentos.getDescuentosActivos(id,idCliente);
                break;
            }
            case PRODUCTO: {
                obj = producto.getProducto(id);
                break;
            }
            case CLIENTE: {
                obj = cliprov.getCache(Cliente.class, id);
                break;
            }
            case PROVEEDOR: {
                obj = cliprov.getCache(Proveedor.class, id);
                break;
            }
        }
        return obj;
    }

    public static Map getCiudad(int dptoId) {

        CatalogosGenerales.cargarCiudad(dptoId);
        Map mp = CatalogosGenerales.ciudadEnCache;
        return mp;
    }

    public static String getCiudad(String ciudadId) {

        CatalogosGenerales.cargarCiudad(Integer.valueOf(ciudadId.substring(0, 2)));
        Ciudad ciudad = CatalogosGenerales.ciudadEnCache.get(ciudadId);
        return ciudad.getNombre();
    }

    public static Map getDepartamentos() {
        Map mp = CatalogosGenerales.deptoEnCache;
        if (mp == null) {
            CatalogosGenerales.cargarMap(Departamento.class);
            mp = CatalogosGenerales.deptoEnCache;
        }
        return mp;
    }

    public static Map getCargos() {
        Map mp = CatalogosGenerales.cargoEnCache;
        if (mp == null) {
            CatalogosGenerales.cargarMap(Cargo.class);
            mp = CatalogosGenerales.cargoEnCache;
        }
        return mp;
    }

    public static Map getProductos() {
        Map mp = CatalogoProductos.productosEnCache;
        if (mp == null) {
            CatalogoProductos.cargarMap(Producto.class);
            mp = CatalogoProductos.productosEnCache;
        }
        return mp;
    }

    public static Map getProveedores() {
        Map mp = CatalogoClienteProveedor.proveedorEnCache;
        if (mp == null) {
            CatalogoClienteProveedor.cargarMap(Proveedor.class);
            mp = CatalogoClienteProveedor.proveedorEnCache;
        }
        return mp;
    }

    public static Map getCategoria() {
        if (CatalogosGenerales.categoriaEnCache == null) {
            CatalogosGenerales.cargarMap(modelo.Categoria.class);
        }
        return CatalogosGenerales.categoriaEnCache;
    }

    public static Map getUnidadMedida() {
        if (CatalogosGenerales.unidadMEnCache == null) {
            CatalogosGenerales.cargarMap(modelo.UnidadMedida.class);
        }
        return CatalogosGenerales.unidadMEnCache;
    }

    public Usuario cargarUsuario(int pos) {
        if (usuarios == null) {
            usuarios = new CatalogoUsuarios();
        }
        return usuarios.traerUsuario(pos);
    }

    public Cliente cargarCliente(int pos) throws InvalidException {
        if (cliprov == null) {
            cliprov = new CatalogoClienteProveedor();
        }
        return cliprov.traerCliente(pos);
    }

    public Personal cargarPersonal(int pos)throws InvalidException {
        if (personal == null) {
            personal = new CatalogoPersonal();
        }
        return personal.traerPersonal(pos);
    }

    public Proveedor cargarProveedor(int pos) throws InvalidException {
        if (cliprov == null) {
            cliprov = new CatalogoClienteProveedor();
        }
        return cliprov.traerProveedor(pos);
    }

    public Producto cargarProducto(int pos) throws InvalidException {
        if (producto == null) {
            producto = new CatalogoProductos();
        }
        return producto.traerProductos(pos);
    }

    public List obtenerCategorias() {
        if (ctGenerales == null) {
            ctGenerales = new CatalogosGenerales();
        }
        return ctGenerales.obtenerListDatos(Categoria.class);
    }

    public List obtenerCargos() {
        if (ctGenerales == null) {
            ctGenerales = new CatalogosGenerales();
        }
        return ctGenerales.obtenerListDatos(Cargo.class);
    }

    public static Map getSupervisores() {
        Map mapa = new HashMap();
        Map<String, modelo.Cargo> m = getCargos();
        String cajeroID = "";
        for (modelo.Cargo c : m.values()) {
            if (c.getNombre().equals("CAJERO")) {
                cajeroID = c.getId();
                break;
            }
        }
        Map<String, modelo.Personal> pers = CatalogosManager.getEmpleados();
        for (modelo.Personal p : pers.values()) {
            if (!p.getCargo().equals(cajeroID)) {
                mapa.put(p.oid, p);
            }
        }
        return mapa;
    }

    public void administrarUsuarios(Object datos, int tipo) {

        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Usuario.class);
        switch (tipo) {
            case PuntoDeVenta.INSERTAR: {
                Usuario user = new Usuario((List) datos);
                usuarios.adicionarUsuarioCache(user);
                adaptador.putObject(user, IAdaptador.INSERTAR);
                break;
            }
            case PuntoDeVenta.MODIFICAR: {
                Usuario user = new Usuario((List) datos);
                usuarios.adicionarUsuarioCache(user);
                adaptador.putObject(user, IAdaptador.MODIFICAR);
                break;
            }
            case PuntoDeVenta.ELIMINAR: {
                adaptador.putObject(usuarios.getUsuarioCache(datos.toString()), IAdaptador.ELIMINAR);
                usuarios.eliminarUsuarioCache(datos.toString());
                break;
            }
        }
    }

    public void administrarClientes(Object datos, int tipo) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Cliente.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Cliente cl = new Cliente((ArrayList) datos);
                cliprov.adicionarEnCache(Cliente.class, cl);
                adaptador.putObject(cl, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Cliente cl = new Cliente((ArrayList) datos);
                cliprov.adicionarEnCache(Cliente.class, cl);
                adaptador.putObject(cl, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(cliprov.getCache(Cliente.class, datos.toString()), IAdaptador.ELIMINAR);
                cliprov.eliminarCache(Cliente.class, datos.toString());
                break;
            }
        }
    }

    public void administrarPersonal(Object datos, int tipo) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Personal.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Personal pr = new Personal((ArrayList) datos);
                personal.adicionarPersonal(pr);
                adaptador.putObject(pr, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Personal pr = new Personal((ArrayList) datos);
                personal.adicionarPersonal(pr);
                adaptador.putObject(pr, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(personal.getPersonal(datos.toString()), IAdaptador.ELIMINAR);
                personal.eliminarPersonalCache(datos.toString());
                break;
            }
        }
    }

    public void administrarProveedor(Object datos, int tipo) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Proveedor.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Proveedor pr = new Proveedor((ArrayList) datos);
                cliprov.adicionarEnCache(Proveedor.class, pr);
                adaptador.putObject(pr, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Proveedor pr = new Proveedor((ArrayList) datos);
                cliprov.adicionarEnCache(Proveedor.class, pr);
                adaptador.putObject(pr, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(cliprov.getCache(Proveedor.class, datos.toString()), IAdaptador.ELIMINAR);
                cliprov.eliminarCache(Proveedor.class, datos.toString());
                break;
            }
        }
    }

    public void administrarProducto(Object datos, int tipo) {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Producto.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Producto pr = new Producto((ArrayList) datos);
                producto.ingresarProducto(pr);
                adaptador.putObject(pr, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Producto pr = new Producto((ArrayList) datos);
                producto.ingresarProducto(pr);
                adaptador.putObject(pr, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(producto.getProducto(datos.toString()), IAdaptador.ELIMINAR);
                producto.eliminarProducto(datos.toString());
                break;
            }
        }
    }

    public void administrarDescuentos(Object datos, int tipo) {
        crearCatalogo(DESCUENTO);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Descuento.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                ArrayList data = (ArrayList) datos;
                Descuento d = new Descuento(data);
                descuentos.ingresarDescuento(data.get(0).toString(), d);
                adaptador.putObject(d, IAdaptador.INSERTAR);
                publicarMensaje("Descuento Ingresado Correctamente");
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                ArrayList data = (ArrayList) datos;
                Descuento d = new Descuento(data);
                descuentos.ingresarDescuento(data.get(0).toString(), d);
                adaptador.putObject(d, IAdaptador.MODIFICAR);
                publicarMensaje("Descuento Modificado Correctamente");
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(cliprov.getCache(Proveedor.class, datos.toString()), IAdaptador.ELIMINAR);
                descuentos.eliminarDescuento(datos.toString());
                publicarMensaje("Descuento Eliminado Correctamente");
                break;
            }
        }
    }

    public void administrarDescuentosxCategoria(Object datos, int tipo) {
        crearCatalogo(DESCUENTO);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Descuento.class);
        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                ArrayList data = (ArrayList) datos;
                List<Producto> productos = CatalogoProductos.buscarxCategoria((String) data.get(0));
                for (Producto p : productos) {
                    data.set(0, p.getId());
                    Descuento d = new Descuento(data);
                    descuentos.ingresarDescuento(d.getIdProd(), d);
                    adaptador.putObject(d, IAdaptador.INSERTAR);
                }
                publicarMensaje("Descuentos Ingresado Correctamente");
                break;
            }
            case RegistrosGenerales.MODIFICAR: {

                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                ArrayList data = (ArrayList) datos;
                List<Producto> productos = CatalogoProductos.buscarxCategoria((String) data.get(0));
                for (Producto p : productos) {
                    Descuento d = new Descuento(data);
                    adaptador.putObject(d, IAdaptador.ELIMINAR);
                    descuentos.eliminarDescuento(d.getIdProd());
                }
                publicarMensaje("Descuentos Eliminado Correctamente");
                break;
            }
        }
    }

    public void administrarUnidades(Object datos, int tipo) {
        crearCatalogo(UNIDAD);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(UnidadMedida.class);

        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                UnidadMedida un = new UnidadMedida((ArrayList) datos);
                ctGenerales.adicionarCache(UnidadMedida.class, un);
                adaptador.putObject(un, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                UnidadMedida un = new UnidadMedida((ArrayList) datos);
                ctGenerales.adicionarCache(UnidadMedida.class, un);
                adaptador.putObject(un, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(ctGenerales.getCache(UnidadMedida.class, datos.toString()), IAdaptador.ELIMINAR);
                ctGenerales.eliminarCache(UnidadMedida.class, datos.toString());
                break;
            }
        }
    }

    public void administrarMarca(Object datos, int tipo) {
        crearCatalogo(MARCA);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Marca.class);

        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Marca un = new Marca((ArrayList) datos);
                ctGenerales.adicionarCache(Marca.class, un);
                adaptador.putObject(un, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Marca un = new Marca((ArrayList) datos);
                ctGenerales.adicionarCache(Marca.class, un);
                adaptador.putObject(un, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(ctGenerales.getCache(Marca.class, datos.toString()), IAdaptador.ELIMINAR);
                ctGenerales.eliminarCache(Marca.class, datos.toString());
                break;
            }
        }
    }

    public void administrarUbicacion(Object datos, int tipo) {
        crearCatalogo(UBICACION);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Ubicacion.class);

        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Ubicacion un = new Ubicacion((ArrayList) datos);
                ctGenerales.adicionarCache(Ubicacion.class, un);
                adaptador.putObject(un, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Ubicacion un = new Ubicacion((ArrayList) datos);
                ctGenerales.adicionarCache(Ubicacion.class, un);
                adaptador.putObject(un, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(ctGenerales.getCache(Ubicacion.class, datos.toString()), IAdaptador.ELIMINAR);
                ctGenerales.eliminarCache(Ubicacion.class, datos.toString());
                break;
            }
        }
    }

    public void administrarCategorias(Object datos, int tipo) {
        crearCatalogo(CATEGORIA);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Categoria.class);

        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Categoria ct = new Categoria((ArrayList) datos);
                ctGenerales.adicionarCache(Categoria.class, ct);
                adaptador.putObject(ct, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Categoria ct = new Categoria((ArrayList) datos);
                ctGenerales.adicionarCache(Categoria.class, ct);
                adaptador.putObject(ct, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(ctGenerales.getCache(Categoria.class, datos.toString()), IAdaptador.ELIMINAR);
                ctGenerales.eliminarCache(Categoria.class, datos.toString());
                break;
            }
        }
    }

    public void administrarCargos(Object datos, int tipo) {
        crearCatalogo(CARGO);
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Cargo.class);

        switch (tipo) {
            case RegistrosGenerales.INSERTAR: {
                Cargo cg = new Cargo((ArrayList) datos);
                ctGenerales.adicionarCache(Cargo.class, cg);
                adaptador.putObject(cg, IAdaptador.INSERTAR);
                break;
            }
            case RegistrosGenerales.MODIFICAR: {
                Cargo cg = new Cargo((ArrayList) datos);
                ctGenerales.adicionarCache(Cargo.class, cg);
                adaptador.putObject(cg, IAdaptador.MODIFICAR);
                break;
            }
            case RegistrosGenerales.ELIMINAR: {
                adaptador.putObject(ctGenerales.getCache(Cargo.class, datos.toString()), IAdaptador.ELIMINAR);
                ctGenerales.eliminarCache(Cargo.class, datos.toString());
                break;
            }
        }
    }

    public static ArrayList stockMinimo(int cant) {
        return CatalogoProductos.buscarStock(cant);
    }

    public static ArrayList fechaVencimiento(String fecha) {
        return CatalogoProductos.buscarFechaVencimiento(fecha);
    }

    public void actualizarStock(String idProd, int cant, boolean esVenta) {
        Producto pro = producto.getProducto(idProd);
        int stock = pro.getStock();
        if (esVenta) {
            pro.setStock((stock - cant));
        } else {
            pro.setStock((stock + cant));
        }
        administrarProducto(pro.toArray(), RegistrosGenerales.MODIFICAR);

    }

    public void publicarMensaje(String mensaje) {
        PuntoDeVenta.getInstancia().publicarEvento(PuntoDeVenta.LANZAR_MENSAJE, mensaje);
    }

    public static void crearCatalogo(int tipo) {
        switch (tipo) {
            case PERSONAL: {
                if (personal == null) {
                    personal = new CatalogoPersonal();
                }
                break;
            }
            case DESCUENTO: {
                if (descuentos == null) {
                    descuentos = new CatalogoDescuento();
                    adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Descuento.class);
                    CatalogoDescuento.descuentosEnCache = adaptador.getRegistros();
                }
                break;
            }
            case PRODUCTO: {
                if (producto == null) {
                    producto = new CatalogoProductos();

                }
                break;
            }
            case CATEGORIA: {
                if (ctGenerales == null) {
                    ctGenerales = new CatalogosGenerales();
                }
                break;
            }
            case CARGO: {
                if (ctGenerales == null) {
                    ctGenerales = new CatalogosGenerales();
                }
                break;
            }
            case UNIDAD: {
                if (ctGenerales == null) {
                    ctGenerales = new CatalogosGenerales();
                }
                break;
            }
            case MARCA: {
                if (ctGenerales == null) {
                    ctGenerales = new CatalogosGenerales();
                }
                break;
            }
            case UBICACION: {
                if (ctGenerales == null) {
                    ctGenerales = new CatalogosGenerales();
                }
                break;
            } case COMPRA: {
                if (hisCompras == null) {
                    hisCompras = new HistorialCompras();
                }
                break;
            }
            default: {
                if (cliprov == null) {
                    cliprov = new CatalogoClienteProveedor();

                }
                break;
            }
        }
    }

    public boolean validarCliente(String idCliente, int tipo) {
        CatalogosManager.crearCatalogo(tipo);
        List al = new ArrayList();
        al = cliprov.buscarIDCliente(idCliente);
        if (!al.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int obtenerPosProducto(String nom) {
        if (producto == null) {
            producto = new CatalogoProductos();
        }
        return producto.obtenerPosProducto(nom);
    }
       public List obtenerMarcas() {
        if (ctGenerales == null) {
            ctGenerales = new CatalogosGenerales();
        }
        return ctGenerales.obtenerListDatos(Marca.class);
    }

    public List obtenerUnidades() {
        if (ctGenerales == null) {
            ctGenerales = new CatalogosGenerales();
        }
        return ctGenerales.obtenerListDatos(UnidadMedida.class);
    }

    public List obtenerUbicaciones() {
        if (ctGenerales == null) {
            ctGenerales = new CatalogosGenerales();
        }
        return ctGenerales.obtenerListDatos(Ubicacion.class);
    }
}
