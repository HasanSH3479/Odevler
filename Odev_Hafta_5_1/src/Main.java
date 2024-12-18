public class Main {
    public static void main(String[] args) {
        // E-Ticaret Sitesi
        Urun laptop = new Urun("Laptop", 15000, 10);
        Urun phone = new Urun("Telefon", 5000, 20);
        Urun tablet = new Urun("Tablet", 3000, 15);

        Kullanici user = new Kullanici("Ahmet");

        laptop.urunBilgisiGoruntule();
        phone.urunBilgisiGoruntule();
        tablet.urunBilgisiGoruntule();

        user.sepeteEkle(laptop, 2);
        user.sepeteEkle(phone, 3);
        user.sepeteEkle(tablet, 5);

        user.sepetiGoruntule();

        user.cikis();

        user.sepetiTemizle();
    }
}
