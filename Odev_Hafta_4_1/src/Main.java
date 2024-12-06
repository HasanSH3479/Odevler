import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> sayilar = new ArrayList<>();

        //Diziler Ödevi 2. Kısım
        System.out.println("0-100 arasında 3 sayı giriniz:");
        int sayi1 = scan.nextInt();
        sayilar.add(sayi1);
        int sayi2 = scan.nextInt();
        sayilar.add(sayi2);
        int sayi3 = scan.nextInt();
        sayilar.add(sayi3);

        int toplam = 0;

        for (int i = 0; i < sayilar.size(); i++) {
            toplam += sayilar.get(i);
        }
        System.out.println("Toplam: " + toplam);


        double ort = (double) toplam / sayilar.size();

        System.out.println("Ortalama: " + ort);

        int max = sayilar.get(0);
        for (int i = 0; i < sayilar.size(); i++) {
            if (sayilar.get(i) > max) {
                max = sayilar.get(i);
            }
        }
        System.out.println("Max deger: " + max);

        //Diziler Ödevi 3. Kısım

        int[] sayilar2 = new int[15];
        Random rd = new Random();

        for (int i = 0; i < sayilar2.length; i++) {
            sayilar2[i] = rd.nextInt(100) + 1;  // 1 ile 100 arasında sayılar
        }

        System.out.println("Rastgele Sayılar:");
        for (int number : sayilar2) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(sayilar2);

        System.out.println("Küçükten büyüğe sıralanan sayılar:");
        for (int number : sayilar2) {
            System.out.print(number + " ");
        }
    }
}