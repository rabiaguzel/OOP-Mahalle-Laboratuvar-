import java.awt.Color;
import java.awt.Graphics2D;

/**
 * EV SINIFI (hazır, değiştirmeyin)
 * Bir evin özelliklerini ve yapabileceklerini tanımlar.
 */
public class Ev {

    // ---- ÖZELLİKLER (alanlar): Sahne'den değer verebilirsiniz ----
    public int x = 0;                               // evin sol kenarı
    public int y = SahnePaneli.EV_HATTI;            // evin zemine oturduğu çizgi
    public int genislik = 120;
    public int yukseklik = 110;
    public int pencereSayisi = 2;
    public Color duvarRengi = new Color(230, 200, 160);
    public Color catiRengi = new Color(170, 60, 50);
    public boolean isikAcik = false;

    // ---- DAVRANIŞLAR (metotlar): Sahne'den çağırabilirsiniz ----

    // Evi bir kat (40 piksel) yükseltir.
    public void katEkle() {
        yukseklik = yukseklik + 40;
    }

    // Işıklar açıksa kapatır, kapalıysa açar.
    public void isikDegistir() {
        isikAcik = !isikAcik;
    }

    // Evi ekrana çizer. Bu metodu Sahne kendisi çağırır.
    public void ciz(Graphics2D g) {
        int ust = y - yukseklik;

        g.setColor(duvarRengi);                                  // duvar
        g.fillRect(x, ust, genislik, yukseklik);

        g.setColor(catiRengi);                                   // çatı
        int[] xler = {x - 10, x + genislik + 10, x + genislik / 2};
        int[] yler = {ust, ust, ust - genislik / 2};
        g.fillPolygon(xler, yler, 3);

        g.setColor(new Color(100, 60, 30));                      // kapı
        g.fillRect(x + genislik / 2 - 12, y - 40, 24, 40);

        if (isikAcik) {                                          // pencereler
            g.setColor(new Color(255, 220, 90));
        } else {
            g.setColor(new Color(170, 210, 240));
        }
        int aralik = genislik / (pencereSayisi + 1);
        for (int i = 1; i <= pencereSayisi; i++) {
            g.fillRect(x + i * aralik - 10, ust + 20, 20, 20);
        }
    }
}
