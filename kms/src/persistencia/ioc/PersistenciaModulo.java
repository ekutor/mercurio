/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.persist.jpa.JpaPersistModule;
import persistencia.AdaptadorBD;
import persistencia.IAdapatdor;
import persistencia.dao.IManagerDAO;
import persistencia.dao.ManagerDAO;

/**
 *
 * @author alsarmiento
 */
public class PersistenciaModulo extends AbstractModule {
    private String PU = null;

    public PersistenciaModulo(String PU) {
        this.PU = PU;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(PU));
                
	bind(IAdapatdor.class).to(AdaptadorBD.class).in(Singleton.class);
        bind(IManagerDAO.class).to(ManagerDAO.class).in( Singleton.class);
    }
    
}
