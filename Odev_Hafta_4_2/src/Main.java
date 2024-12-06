import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        //Döngüler 1. Kısım
        Scanner scanner = new Scanner(System.in);
        int deneme_hakki = 0;
        boolean giris = false;


        for (int i = 0; i < 3; i++) {

            System.out.print("E-posta: ");
            String email = scanner.nextLine();
            System.out.print("Şifre: ");
            String sifre = scanner.nextLine();

            // E-posta ve şifreyi kontrol etme
            if (email.endsWith("@gmail.com") && sifre.length() >= 8) {
                giris = true;
                System.out.println("Kullanıcı onaylandı.");
                break;
            } else {
                deneme_hakki++;
                if (deneme_hakki < 3) {
                    System.out.println("E-posta veya şifre yanlış. Lütfen tekrar deneyin.");
                }
            }
            {

                if (!email.endsWith("@gmail.com")) {
                    System.out.println("E-posta 'gmail.com' ile bitmelidir.");
                }
                if (sifre.length() < 8) {
                    System.out.println("Şifre en az 8 karakter olmalıdır.");
                }
                deneme_hakki++;
                if (deneme_hakki >= 3) {
                    break;
                }
            }
        }


        if (!giris && deneme_hakki == 3) {
            System.out.println("Hatalı giriş.");
        }



        //Döngüler 2. Kısım

        System.out.print("Bir sayı girin: ");
        int sayi = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= sayi; i++) {
            factorial *= i;
        }
            System.out.println(sayi + " sayısının faktöriyel sonucu: " + factorial);
            scanner.close();

        //Döngüler 3. Kısım
        Random rd = new Random();

        int tek_sayi = 0;
        int cift_sayi = 0;


        for (int i = 0; i < 50; i++) {
            int number = rd.nextInt(101);


            if (number % 2 == 0) {
                cift_sayi++;
            } else {
                tek_sayi++;
            }
        }

        System.out.println("Çift sayıların sayısı: " + cift_sayi);
        System.out.println("Tek sayıların sayısı: " + tek_sayi);
    }
}








