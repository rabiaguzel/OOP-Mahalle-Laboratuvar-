import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * SAHNE
 * Bu dosyada "GÖREV" yazan yerleri dolduracaksınız. Yapacağınız üç şey var:
 *
 *   1) Nesne oluşturmak:            Ev ev1 = new Ev();
 *   2) Nesnenin özelliğine değer:   ev1.x = 250;
 *   3) Nesnenin metodunu çağırmak:  ev1.katEkle();
 *
 * Oluşturduğunuz nesnenin ekranda görünmesi için onu listeye ekleyin:  evler.add(ev1);
 * Hangi sınıfın hangi özellikleri ve metotları olduğunu README dosyasındaki tablolarda bulabilirsiniz.
 */
public class Sahne {

    // Sahnedeki nesnelerin listeleri (hazır)
    private ArrayList<Ev> evler = new ArrayList<Ev>();
    private ArrayList<Agac> agaclar = new ArrayList<Agac>();
    private ArrayList<Araba> arabalar = new ArrayList<Araba>();
    private ArrayList<Bulut> bulutlar = new ArrayList<Bulut>();
    private Gunes gunes;
    private boolean gece = false;

    public Sahne() {
        sahneyiKur();
    }

    private void sahneyiKur() {

        // ===== ÖRNEK (hazır): bir ev nasıl eklenir? =====
        Ev ornekEv = new Ev();                          // 1) nesne oluştur
        ornekEv.x = 40;                                 // 2) özelliklerine değer ver
        ornekEv.duvarRengi = new Color(230, 200, 160);
        ornekEv.catiRengi = new Color(170, 60, 50);
        evler.add(ornekEv);                             // 3) sahneye ekle

        // GÖREV 1: Güneş
        //   gunes değişkeni yukarıda hazır. Ona yeni bir Gunes nesnesi oluşturun:  gunes = new Gunes();
        //   Sonra güneşi sağ üst köşeye taşıyın: x değeri 790, y değeri 85 olsun.
        // ... buraya yazın ...

        // GÖREV 2: Mavi ev
        //   ev2 adında yeni bir Ev oluşturun ve şu değerleri verin:
        //     x = 250, genislik = 170, yukseklik = 130
        //     duvarRengi = new Color(200, 220, 240), catiRengi = new Color(60, 80, 140)
        //   Sonra evler listesine ekleyin. Yukarıdaki örneğe bakın.
        // ... buraya yazın ...

        // GÖREV 3: Apartman (metot çağırma)
        //   apartman adında yeni bir Ev oluşturun, x değeri 510 olsun.
        //   pencereSayisi değerini 3 yapın.
        //   apartman nesnesinin katEkle() metodunu İKİ kez çağırın. Her çağrı evi bir kat yükseltir.
        //   Sonra evler listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 4: Yuvarlak ağaç
        //   agac1 adında yeni bir Agac oluşturun, x değeri 195 olsun. agaclar listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 5: Çam ağacı
        //   cam1 adında yeni bir Agac oluşturun. Değerleri: x = 455, boy = 130, tur = "cam"
        //   agaclar listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 6: Kırmızı araba
        //   araba1 adında yeni bir Araba oluşturun. x = 100, renk = Color.RED
        //   arabalar listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 7: Sarı araba (metot çağırma)
        //   araba2 adında yeni bir Araba oluşturun. Değerleri:
        //     x = 700, y = SahnePaneli.UST_SERIT, renk = new Color(250, 190, 30), hiz = 4
        //   Sola gitmesi için araba2 nesnesinin yonDegistir() metodunu çağırın.
        //   arabalar listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 8: Bulutlar
        //   bulut1 adında yeni bir Bulut oluşturun. x = 80, y = 60
        //   yagmurBulutu adında yeni bir Bulut oluşturun. x = 600, y = 40, boyut = 70, yagmurlu = true
        //   İkisini de bulutlar listesine ekleyin.
        // ... buraya yazın ...

        // GÖREV 9: Grubunuzun nesneleri
        //   Kendi seçtiğiniz bir araba ve bir ağaç ekleyin. Konum, renk, hız, boy sizin seçiminiz.
        //   Arabayı üst şeride koymak için y = SahnePaneli.UST_SERIT yazın.
        // ... buraya yazın ...
    }

    // Fareyle tıklanınca çağrılır. x ve y tıklanan noktadır.
    public void tiklandi(int x, int y) {
        if (y > SahnePaneli.UFUK) {
            // GÖREV 10: Çimene tıklanınca tıklanan yere yeni bir ağaç ekleyin.
            //   Yeni bir Agac oluşturun. Ağacın x değeri tıklanan x, y değeri tıklanan y olsun.
            //   agaclar listesine ekleyin.
            // ... buraya yazın ...
        }
    }

    // Bir tuşa basılınca çağrılır.
    public void tusaBasildi(char tus) {
        if (tus == 'y') {
            // ÖRNEK (hazır): Y tuşu her arabanın yonDegistir() metodunu çağırır.
            for (Araba a : arabalar) {
                a.yonDegistir();
            }
        } else if (tus == 'h') {
            // GÖREV 11: H tuşu her arabanın hizlan() metodunu çağırsın. Yukarıdaki örneğe bakın.
            for (Araba a : arabalar) {
                // ... buraya yazın ...
            }
        } else if (tus == 'b') {
            // GÖREV 12: B tuşu her ağacın buyu() metodunu çağırsın.
            for (Agac a : agaclar) {
                // ... buraya yazın ...
            }
        } else if (tus == 'g') {
            gece = !gece;
            // GÖREV 13: G tuşu her evin isikDegistir() metodunu çağırsın.
            for (Ev e : evler) {
                // ... buraya yazın ...
            }
            // Güneşin de geceGunduzDegistir() metodunu çağırın.
            if (gunes != null) {
                // ... buraya yazın ...
            }
        }
    }

    // ---- Aşağısı hazır: SahnePaneli bu metotları kullanır ----
    public void guncelle(int panelGenisligi) {
        for (Araba a : arabalar) {
            a.hareketEt(panelGenisligi);
        }
        for (Bulut b : bulutlar) {
            b.hareketEt(panelGenisligi);
        }
    }

    public void ciz(Graphics2D g) {
        if (gunes != null) {
            gunes.ciz(g);
        }
        for (Bulut b : bulutlar) {
            b.ciz(g);
        }
        for (Ev e : evler) {
            e.ciz(g);
        }
        for (Agac a : agaclar) {
            a.ciz(g);
        }
        for (Araba a : arabalar) {
            a.ciz(g);
        }
    }

    public boolean isGece() {
        return gece;
    }

    public boolean bosMu() {
        return gunes == null && evler.isEmpty() && agaclar.isEmpty()
                && arabalar.isEmpty() && bulutlar.isEmpty();
    }
}
