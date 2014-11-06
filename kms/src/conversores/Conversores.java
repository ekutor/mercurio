package conversores;


import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Kymera Systems SAS
 */
public class Conversores {

    public static Map getConversores() {

        Map conversores = new HashMap();
        try {

            conversores.put(modelo.Producto.class, new ConversorBDProducto());
            conversores.put(modelo.Categoria.class, new ConversorBDCategoria());
            conversores.put(modelo.Cargo.class, new ConversorBDCargo());
            conversores.put(modelo.UnidadMedida.class, new ConversorBDUnidadMedida());
            conversores.put(modelo.Personal.class, new ConversorBDEmpleado());
            conversores.put(modelo.Usuario.class, new ConversorBDUsuario());
            conversores.put(modelo.Venta.class, new ConversorBDVenta());
            conversores.put(modelo.Proveedor.class,new ConversorBDProveedor());
            conversores.put(modelo.Ciudad.class,new ConversorBDCiudad());
            conversores.put(modelo.Departamento.class,new ConversorBDDepartamento());
            conversores.put(modelo.Cliente.class,new ConversorBDCliente());
            conversores.put(modelo.Descuento.class, new ConversorBDDescuento());
            conversores.put(modelo.HistorialCaja.class, new ConversorBDCaja());
            conversores.put(modelo.MovimientosCaja.class, new ConversorBDCaja());
            conversores.put(modelo.Compra.class, new ConversorBDCompra());
            conversores.put(modelo.Marca.class,new ConversorBDMarca());
            conversores.put(modelo.Ubicacion.class,new ConversorBDUbicacion());
            conversores.put(modelo.CierresCaja.class, new ConversorBDCierres());
        } catch (Exception ex) {
             System.out.println("NO HA CARGADO EL CONVERSOR");
            ex.printStackTrace();

        }catch(ExceptionInInitializerError ei){
            System.out.println("causa "+ei.getCause().toString());
            System.out.println("eror al iniciar "+ei.getMessage());
        }
        return conversores;
    }
}
