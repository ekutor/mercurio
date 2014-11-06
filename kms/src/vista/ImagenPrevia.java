package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.beans.*;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Kymera Systems SAS
 */
//CLASE ENCARGADA DE VER LA VISTA PREVIA DE LA IMAGEN EN EL JFileChooser
public class ImagenPrevia extends JComponent implements PropertyChangeListener {

    private ImageIcon icono;
    private File f;

    public ImagenPrevia(JFileChooser jf) {
        this.setPreferredSize(new Dimension(100, 50));
        jf.addPropertyChangeListener(this);
    }

    public void cargarImagen() {
        if (f == null) {
            icono = null;
            return;
        }

        ImageIcon tmpIcon = new ImageIcon(f.getPath());
        if (tmpIcon != null) {
            if (tmpIcon.getIconWidth() > 90) {
                icono = new ImageIcon(tmpIcon.getImage().
                        getScaledInstance(90, -1, Image.SCALE_DEFAULT));
            } else {//NO NECESITA MINIMIZAR EL TAMAÑO DE LA IMAGEN
                icono = tmpIcon;
            }
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        boolean actualizar = false;
        String prop = e.getPropertyName();

        //SI LA DIRECCION DE LA IMAGEN CAMBIA, NO MUESTRA NADA
        if(JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)){
            f = null;
            actualizar = true;
            
        }else if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)){
            f = (File) e.getNewValue();
            actualizar = true;
        }

        if(actualizar){
            icono = null;
            if(isShowing()){
                cargarImagen();
                repaint();
            }
        }

    }
//pinta en el componente
        protected void paintComponent(Graphics g) {
        if (icono == null) {
            cargarImagen();
        }
        if (icono != null) {
            int x = getWidth()/2 - icono.getIconWidth()/2;
            int y = getHeight()/2 - icono.getIconHeight()/2;

            if (y < 0) {
                y = 0;
            }

            if (x < 5) {
                x = 5;
            }
            icono.paintIcon(this, g, x, y);
        }
    }
}
