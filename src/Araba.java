import java.awt.Color;
import java.awt.Graphics2D;

/**
 * ARABA SINIFI (hazır, değiştirmeyin)
 */
public class Araba {

    // ---- ÖZELLİKLER ----
    public int x = 0;
    public int y = SahnePaneli.ALT_SERIT;           // tekerlerin yola değdiği çizgi
    public Color renk = Color.RED;
    public int hiz = 3;
    public boolean sagaGidiyor = true;

    // ---- DAVRANIŞLAR ----

    // Hızı 1 artırır. En fazla 12 olabilir.
    public void hizlan() {
        hiz = hiz + 1;
        if (hiz > 12) {
            hiz = 12;
        }
    }

    // Sağa gidiyorsa sola, sola gidiyorsa sağa döndürür.
    public void yonDegistir() {
        sagaGidiyor = !sagaGidiyor;
    }

    // Arabayı hızı kadar ilerletir. Bu metodu Sahne kendisi çağırır.
    public void hareketEt(int panelGenisligi) {
        if (sagaGidiyor) {
            x = x + hiz;
            if (x > panelGenisligi) {
                x = -100;                    // sağdan çıktı, soldan girsin
            }
        } else {
            x = x - hiz;
            if (x < -100) {
                x = panelGenisligi;          // soldan çıktı, sağdan girsin
            }
        }
    }

    // Arabayı ekrana çizer. Bu metodu Sahne kendisi çağırır.
    public void ciz(Graphics2D g) {
        g.setColor(renk);
        g.fillRoundRect(x, y - 40, 100, 25, 12, 12);             // gövde
        g.fillRoundRect(x + 20, y - 60, 55, 25, 12, 12);         // kabin

        g.setColor(new Color(200, 230, 255));                    // camlar
        g.fillRect(x + 27, y - 55, 18, 14);
        g.fillRect(x + 50, y - 55, 18, 14);

        g.setColor(Color.DARK_GRAY);                             // tekerlekler
        g.fillOval(x + 12, y - 25, 24, 24);
        g.fillOval(x + 64, y - 25, 24, 24);

        g.setColor(Color.YELLOW);                                // far
        if (sagaGidiyor) {
            g.fillRect(x + 94, y - 35, 6, 8);
        } else {
            g.fillRect(x, y - 35, 6, 8);
        }
    }
}
