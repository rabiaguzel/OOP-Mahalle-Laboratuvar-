import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * GÜNEŞ SINIFI (hazır, değiştirmeyin)
 */
public class Gunes {

    // ---- ÖZELLİKLER ----
    public int x = 0;                    // güneşin merkezi
    public int y = 0;
    public int yaricap = 45;
    public boolean ay = false;           // true ise güneş yerine ay çizilir

    // ---- DAVRANIŞLAR ----

    // Güneşse aya, aysa güneşe dönüştürür.
    public void geceGunduzDegistir() {
        ay = !ay;
    }

    // Güneşi (ya da ayı) ekrana çizer. Bu metodu Sahne kendisi çağırır.
    public void ciz(Graphics2D g) {
        if (ay) {
            g.setColor(new Color(235, 235, 220));
            g.fillOval(x - yaricap, y - yaricap, 2 * yaricap, 2 * yaricap);
            return;
        }

        g.setColor(new Color(255, 200, 40));
        g.fillOval(x - yaricap, y - yaricap, 2 * yaricap, 2 * yaricap);

        g.setStroke(new BasicStroke(3));                         // ışınlar
        for (int i = 0; i < 12; i++) {
            double aci = 2 * Math.PI * i / 12;
            int x1 = x + (int) (Math.cos(aci) * (yaricap + 8));
            int y1 = y + (int) (Math.sin(aci) * (yaricap + 8));
            int x2 = x + (int) (Math.cos(aci) * (yaricap + 25));
            int y2 = y + (int) (Math.sin(aci) * (yaricap + 25));
            g.drawLine(x1, y1, x2, y2);
        }
        g.setStroke(new BasicStroke(1));
    }
}
