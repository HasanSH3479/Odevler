public class Urun {
    private String isim;
    private double fiyat;
    private int stok_durumu;

    public Urun(String isim, double fiyat, int stok_durumu) {
        this.isim = isim;
        this.fiyat = fiyat;
        this.stok_durumu = stok_durumu;
    }

    public String getName() {
        return isim;
    }

    public double getPrice() {
        return fiyat;
    }

    public int getStock() {
        return stok_durumu;
    }

    public void reduceStock(int miktar) {
        if (stok_durumu >= miktar) {
            stok_durumu -= miktar;
        } else {
            System.out.println("Yetersiz stok, mevcut stok: " + stok_durumu);
        }
    }

    public void urunBilgisiGoruntule() {
        System.out.println("Ürün: " + isim + " - Fiyat: " + fiyat + " TL - Stok: " + stok_durumu);
    }
}
