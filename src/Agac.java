import java.awt.Color;
import java.awt.Graphics2D;

/**
 * AĞAÇ SINIFI (hazır, değiştirmeyin)
 */
public class Agac {

    // ---- ÖZELLİKLER ----
    public int x = 0;                               // gövdenin ortası
    public int y = SahnePaneli.EV_HATTI;            // ağacın zemine oturduğu çizgi
    public int boy = 110;
    public String tur = "yuvarlak";                 // "yuvarlak" ya da "cam"
    public Color yaprakRengi = new Color(40, 140, 60);

    // ---- DAVRANIŞLAR ----

    // Ağacı 10 piksel büyütür. En fazla 220 olabilir.
    public void buyu() {
        boy = boy + 10;
        if (boy > 220) {
            boy = 220;
        }
    }

    // Ağacı ekrana çizer. Bu metodu Sahne kendisi çağırır.
    public void ciz(Graphics2D g) {
        g.setColor(new Color(110, 70, 40));                      // gövde
        int govdeGenisligi = boy / 8;
        g.fillRect(x - govdeGenisligi / 2, y - boy / 2, govdeGenisligi, boy / 2);

        g.setColor(yaprakRengi);                                 // yapraklar
        if (tur.equals("cam")) {
            int[] xler = {x, x - boy / 3, x + boy / 3};
            int[] yler = {y - boy, y - boy / 4, y - boy / 4};
            g.fillPolygon(xler, yler, 3);
        } else {
            g.fillOval(x - boy / 3, y - boy, boy * 2 / 3, boy * 2 / 3);
        }
    }
}
