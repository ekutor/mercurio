package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Usuario;
import persistenciaFWK.ObjetoPersistente;
import persistenciaFWK.adaptadores.IAdaptador;

/**
 *
 * @author Kymera Systems SAS
 */
public class CatalogoUsuarios {

    private IAdaptador adaptador;
    public static Map<String, Usuario> empleadosEnCache;
    private int pos;
    

    public CatalogoUsuarios() {
        adaptador = FactoriaServicios.getInstancia().getAdaptadorDeDatos(Usuario.class);
        empleadosEnCache = adaptador.getRegistros();
    }


    public Usuario traerUsuario(int posicion) {
        Usuario usu = null;
        List<Usuario>listaUsuarios = new ArrayList(empleadosEnCache.values());
        int numElementos = listaUsuarios.size();
        if (!listaUsuarios.isEmpty()) {
            switch (posicion) {
                case CatalogosManager.PRIMERO: {
                    pos = 0;
                    break;
                }
                case CatalogosManager.SIGUIENTE: {
                    if (numElementos - 1 > pos) {
                        pos++;
                    } else {
                        pos = numElementos-1;
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
            usu = listaUsuarios.get(pos);
            return usu;
        } else {
            return null;
        }
    }

    public void eliminarUsuarioCache(String id){
        empleadosEnCache.remove(id);
    }
    public void adicionarUsuarioCache(Usuario user){
        empleadosEnCache.put(user.getUsuario(), user);
    }

    public Usuario getUsuarioCache(String id){
        return empleadosEnCache.get(id);
    }

}
