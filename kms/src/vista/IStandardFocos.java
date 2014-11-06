package vista;

import java.awt.Color;

/**
 *
 * @author h3ct0r
 */
public interface IStandardFocos {
    public Color FOCO_GANADO = new Color(231,251,252);
    public Color FOCO_PERDIDO = new Color(255,255,255);

    /*Metodo para establecer Foco a los JTextFiled*/
    public void establecerFoco();

    public void setFocoGanado(java.awt.event.FocusEvent evt);

    public void setFocoPerdido(java.awt.event.FocusEvent evt);

}
