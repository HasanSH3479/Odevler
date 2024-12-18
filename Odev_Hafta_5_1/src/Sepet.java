import java.util.ArrayList;

public class Sepet {
    private ArrayList<Urun> urunler = new ArrayList<>();
    private ArrayList<Integer> miktarlar = new ArrayList<>();


    public void sepeteUrunEkle(Urun urun, int miktar) {
        if (urun.getStock() >= miktar) {
            urunler.add(urun);
            miktarlar.add(miktar);
            urun.reduceStock(miktar);
            System.out.println(miktar + " adet " + urun.getName() + " sepete eklendi.");
        } else {
            System.out.println("Yetersiz stok: " + urun.getName());
        }
    }

    public void sepetiGoruntule() {
        double total = 0;
        System.out.println("Sepetiniz:");
        for (int i = 0; i < urunler.size(); i++) {
            Urun urun = urunler.get(i);
            int miktar = miktarlar.get(i);
            System.out.println("- " + urun.getName() + " | Fiyat: " + urun.getPrice() + " TL | Miktar: " + miktar);
            total += urun.getPrice() * miktar;  // Fiyat * miktar
        }
        System.out.println("Toplam: " + total + " TL");
    }


    public void sepetiTemizle() {
        urunler.clear();
        miktarlar.clear();
        System.out.println("Sepet temizlendi.");
    }
}
