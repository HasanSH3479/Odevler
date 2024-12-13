import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Fonksiyonlar 1. Kısım
        int[] sayilar = sayilariAl();
        long carpim = sayilariCarp(sayilar);
        System.out.println("\nDizinin elemanlarının çarpımı: " + carpim);

        // Fonksiyonlar 2. Kısım
        ArrayList<Integer> notlar = new ArrayList<>();

        notlariGir(notlar, 3);

        yeniNotEkleme(notlar);

        double ortalama = ortalamaHesapla(notlar);

        //Fonksiyonlar 3. Kısım
        System.out.println("Notlar: ");
        for (int i = 0; i < notlar.size(); i++) {
            System.out.println("Not " + (i + 1) + ": " + notlar.get(i));
        }
        System.out.println("Notların ortalaması: " + ortalama);

        double vizeFinalOrtalamasi = vizeFinalOrtalamasiHesapla();
        System.out.println("Vize ve Final Ortalaması: " + vizeFinalOrtalamasi);
    }

    public static long sayilariCarp(int[] sayilar) {
        long carpim = 1;
        for (int i = 0; i < sayilar.length; i++) {
            carpim *= sayilar[i];
        }
        return carpim;
    }

    public static int[] sayilariAl() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dizide kaç sayı olacağını girin: ");
        int diziBoyutu = scanner.nextInt();

        int[] sayilar = new int[diziBoyutu];
        System.out.println("Dizinin elemanlarını girin:");
        for (int i = 0; i < diziBoyutu; i++) {
            System.out.print("Eleman " + (i + 1) + ": ");
            sayilar[i] = scanner.nextInt();
        }
        return sayilar;
    }

    public static void notlariGir(ArrayList<Integer> notlar, int sayi) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < sayi; i++) {
            System.out.print("Lütfen " + (i + 1) + ". notu girin: ");
            notlar.add(scanner.nextInt());
        }
    }


    public static void yeniNotEkleme(ArrayList<Integer> notlar) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yeni bir not eklemek ister misiniz? (Evet/Hayır): ");
        String cevap = scanner.nextLine();

        if (cevap.equalsIgnoreCase("Evet")) {
            System.out.print("Yeni notu girin: ");
            int yeniNot = scanner.nextInt();
            notlar.add(yeniNot);
        }
    }

    public static double ortalamaHesapla(ArrayList<Integer> notlar) {
        int toplam = 0;
        for (int notDegeri : notlar) {
            toplam += notDegeri;
        }
        return (double) toplam / notlar.size();
    }

    public static double vizeFinalOrtalamasiHesapla() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vize notunu girin: ");
        double vizeNotu = scanner.nextDouble();

        System.out.print("Final notunu girin: ");
        double finalNotu = scanner.nextDouble();

        double vizeOrtalama = vizeNotu * 0.40;
        double finalOrtalama = finalNotu * 0.60;

        return vizeOrtalama + finalOrtalama;
    }
}
