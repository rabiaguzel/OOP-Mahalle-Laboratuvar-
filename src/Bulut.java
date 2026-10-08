import java.awt.Color;
import java.awt.Graphics2D;

/**
 * BULUT SINIFI (hazır, değiştirmeyin)
 */
public class Bulut {

    // ---- ÖZELLİKLER ----
    public double x = 0;                 // ondalıklı, çünkü bulut çok yavaş ilerler
    public int y = 60;
    public int boyut = 90;
    public double hiz = 0.4;
    public boolean yagmurlu = false;

    // ---- DAVRANIŞLAR ----

    // Bulutu hızı kadar sağa kaydırır. Bu metodu Sahne kendisi çağırır.
    public void hareketEt(int panelGenisligi) {
        x = x + hiz;
        if (x > panelGenisligi) {
            x = -2 * boyut;              // sağdan çıktı, soldan girsin
        }
    }

    // Bulutu ekrana çizer. Bu metodu Sahne kendisi çağırır.
    public void ciz(Graphics2D g) {
        if (yagmurlu) {
            g.setColor(new Color(150, 150, 160));
        } else {
            g.setColor(Color.WHITE);
        }
        int bx = (int) x;
        int b = boyut;
        g.fillOval(bx, y, b, b * 6 / 10);
        g.fillOval(bx + b * 4 / 10, y - b * 3 / 10, b, b * 8 / 10);
        g.fillOval(bx + b * 9 / 10, y, b, b * 6 / 10);
    }
}
