import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        //Diziler ödevi 1. Kısım
        ArrayList<String> ogrenciler = new ArrayList<>();

        ogrenciler.add("Ahmet");
        ogrenciler.add("Mehmet");
        ogrenciler.add("Ayşe");
        ogrenciler.add("Fatma");
        ogrenciler.add("Osman");
        ogrenciler.add("Mahmut");
        ogrenciler.add("Engin");
        ogrenciler.add("Salih");
        ogrenciler.add("Ali");
        ogrenciler.add("Furkan");  //Dizi oluşturma

        for (int i = 0; i < ogrenciler.size(); i++) {
            System.out.println(ogrenciler.get(i)); //Dizi elemanlarını ekrana yazdırma
        }
        for (int i = 0; i < ogrenciler.size(); i++) {
            ogrenciler.set(i, ogrenciler.get(i).toUpperCase());
        }

        System.out.println("Güncellenmiş dizi:");
        for (String isim : ogrenciler) {
            System.out.println(isim);  //Dizi elemanlarını büyük harfle yazma

            ogrenciler.set(7, "Kemal"); //Dizi elemanını güncelleme

            ogrenciler.remove("Mehmet"); //Dizi elemanını kaldırma




        }
    }
}
