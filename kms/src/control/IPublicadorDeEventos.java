
package control;

/**
 *
 * @author Kymera Systems SAS
 */
public interface IPublicadorDeEventos {

    public void publicarEvento(String propiedad, Object valor);
    public void addEscuchadorEventos(ObservadorEventos observador);

}
