public class Kullanici {
    private String isim;
    private Sepet sepet;

    public Kullanici(String isim) {
        this.isim = isim;
        this.sepet = new Sepet();
    }

    public void sepeteEkle(Urun urun, int miktar) {
        sepet.sepeteUrunEkle(urun, miktar);
    }

    public void sepetiGoruntule() {
        sepet.sepetiGoruntule();
    }

    public void sepetiTemizle() {
        sepet.sepetiTemizle();
    }

    public void cikis() {
        System.out.println(isim + " adlı kullanıcı siparişini tamamladı.");
        sepet.sepetiTemizle();
    }
}
