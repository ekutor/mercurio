
package utilidades;

/**
 *
 * @author Kymera Systems SAS
 */
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class PintaImagen implements Border{

    private   ImageIcon image ;

    public PintaImagen(ImageIcon image ) {
        this.image=image;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    int x0 = x+ (width-image.getIconWidth())/2;
    int y0 = y+ (height-image.getIconHeight())/2;
    g.drawImage(image.getImage(),x0,y0,null); }

    public Insets getBorderInsets(Component c){
    return new Insets(0,0,0,0);}

    public boolean isBorderOpaque() {
    return true; }
}
