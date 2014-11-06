package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Cliente;
import modelo.Proveedor;
import persistenciaFWK.ObjetoPersistente;
import persistenciaFWK.adaptadores.IAdaptador;
import utilidades.InvalidException;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogoClienteProveedor {

    private static IAdaptador adaptador;
    public static Map<String, Cliente> clienteEnCache;
    public static Map<String, Proveedor> proveedorEnCache;
    private int pos;

    public CatalogoClienteProveedor() {
        
    }

    public void adicionarEnCache(Class modeloDatos,ObjetoPersistente obj){
        if(modeloDatos.equals(Cliente.class)){
            if(clienteEnCache == null){
                cargarMap(Cliente.class);
            }
            clienteEnCache.put(obj.oid,(Cliente) obj);

        }else if(modeloDatos.equals(Proveedor.class)){
            if(proveedorEnCache == null){
                cargarMap(Proveedor.class);
            }
            proveedorEnCache.put(obj.oid,(Proveedor) obj);
        }
    }

    public ObjetoPersistente getCache(Class modeloDatos,String oid){
        if(modeloDatos.equals(Cliente.class)){
            return clienteEnCache.get(oid);
        }else if(modeloDatos.equals(Proveedor.class)){
            return proveedorEnCache.get(oid);
        }else{
            return null;
        }
    }

    public void eliminarCache(Class modeloDatos,String oid){
        if(modeloDatos.equals(Cliente.class)){
            clienteEnCache.remove(oid);
        }else if(modeloDatos.equals(Proveedor.class)){
            proveedorEnCache.remove(oid);
        }
    }

  public static Map cargarMap(Class modeloDatos){
      adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(modeloDatos);
      if(modeloDatos.equals(Cliente.class)){
          return clienteEnCache = adaptador.getRegistros();
      }else if(modeloDatos.equals(Proveedor.class)){
          return proveedorEnCache = adaptador.getRegistros();
      }else{
          return null;
      }
  }

    public Cliente traerCliente(int posicion)throws InvalidException {
        Cliente cliente = null;
         if(clienteEnCache == null){
            cargarMap(Cliente.class);
        }
        List<Cliente> listaClientes = new ArrayList(clienteEnCache.values());
        int numElementos = listaClientes.size();
        if (!listaClientes.isEmpty()) {
            switch (posicion) {
                case CatalogosManager.PRIMERO: {
                    pos = 0;
                    break;
                }
                case CatalogosManager.SIGUIENTE: {
                    if (numElementos - 1 > pos) {
                        pos++;
                    } else {
                        pos = numElementos - 1;
                    }
                    break;
                }
                case CatalogosManager.ANTERIOR: {
                    if (0 < pos) {
                        pos--;
                    } else {
                        pos = 0;
                    }
                    break;
                }
                case CatalogosManager.ULTIMO: {
                    pos = numElementos - 1;
                    break;
                }
            }
            cliente = listaClientes.get(pos);
            return cliente;
        } 
           else {
           throw new InvalidException("No Se Encuentra Ningun Registro");
        }
        
    }

    public Proveedor traerProveedor(int posicion)throws InvalidException {
        Proveedor pr = null;
        if(proveedorEnCache == null){
            cargarMap(Proveedor.class);
        }
        List<Proveedor> listaProveedores = new ArrayList(proveedorEnCache.values());
        int numElementos = listaProveedores.size();
        if (!listaProveedores.isEmpty()) {
            switch (posicion) {
                case CatalogosManager.PRIMERO: {
                    pos = 0;
                    break;
                }
                case CatalogosManager.SIGUIENTE: {
                    if (numElementos - 1 > pos) {
                        pos++;
                    } else {
                        pos = numElementos - 1;
                    }
                    break;
                }
                case CatalogosManager.ANTERIOR: {
                    if (0 < pos) {
                        pos--;
                    } else {
                        pos = 0;
                    }
                    break;
                }
                case CatalogosManager.ULTIMO: {
                    pos = numElementos - 1;
                    break;
                }
            }
            pr = listaProveedores.get(pos);
            return pr;
        } else {
           throw new InvalidException("No Se Encuentra Ningun Registro");
        }
    }
    public ArrayList buscarNomProveedor(String nombre) throws InvalidException{
        if(proveedorEnCache == null){
            cargarMap(Proveedor.class);
        }
        ArrayList al = new ArrayList();
        for(Proveedor pr:proveedorEnCache.values()){
            if(pr.getRazonSocial().toUpperCase().contains(nombre.toUpperCase())){
                al.add(pr.toArray());
            }
        }
        if(al.isEmpty()){
            throw new InvalidException("No Se Encuentra Ningun Registro Con esa Razon Social!!!");
        }
        return al;
    }
    public ArrayList buscarNomCliente(String nombre) throws InvalidException{
         if(clienteEnCache == null){
            cargarMap(Cliente.class);
        }
        ArrayList al = new ArrayList();
        for(Cliente cl:clienteEnCache.values()){
            if(cl.getNombre().toUpperCase().contains(nombre.toUpperCase())){
                al.add(cl.toArray());
            }
        }
        if(al.isEmpty()){
            throw new InvalidException("No Se Encuentra Ningun Registro con ese Nombre!!!");
        }
        return al;
    }
    public ArrayList buscarIDCliente(String idCliente){
         if(clienteEnCache == null){
            cargarMap(Cliente.class);
        }
        ArrayList al = new ArrayList();
        for(Cliente cl:clienteEnCache.values()){
            if(cl.getId().equals(idCliente)){
                al.add(cl.toArray());
            }
        }
        return al;
    }
}
