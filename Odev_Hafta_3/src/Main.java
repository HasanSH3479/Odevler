import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1. Kısım Sayıları Karşılaştırma
        System.out.println("Birinci sayıyı girin: ");
        int sayi1 = scanner.nextInt();

        System.out.println("İkinci sayıyı girin: ");
        int sayi2 = scanner.nextInt();
        //Kullanıcından sayı değerleri alınır

        if (sayi1 > sayi2) {
            System.out.println("Birinci sayı (" + sayi1 + ") ikinci sayıdan (" + sayi2 + ") büyüktür.");
        } else if (sayi1 < sayi2) {
            System.out.println("Birinci sayı (" + sayi1 + ") ikinci sayıdan (" + sayi2 + ") küçüktür.");
        } else {
            System.out.println("İki sayı eşittir: " + sayi1);
        }
        //sayılar karşılaştırılarak, sonuçları ekrana yazdırılır

        //2. Kısım Vize ve Final notlarına göre not hesaplama

        System.out.print("Vize notunu girin: ");
        double vizeNotu = scanner.nextDouble();

        System.out.print("Final notunu girin: ");
        double finalNotu = scanner.nextDouble();
        //kullanıcıdan vize ve final notu bilgileri alınır

        double ortalama = (vizeNotu * 0.35) + (finalNotu * 0.65);

        System.out.println("Ortalama: " + ortalama);
        //sınavların etki yüzdesine göre değerler çarpılır ve ortalama hesaplanır
        if (ortalama >= 75) {
            System.out.println("Dersi geçtiniz.");
        } else {
            System.out.println("Dersten kaldınız.");
        }

        //3. Kısım Sayılarla dört işlem

        char islem= ' ';
        boolean gecerliIslem = false;

        // Geçerli bir işlem girilene kadar döner
        while (!gecerliIslem) {
            System.out.println("Yapmak istediğiniz işlemi seçin (+, -, *, /): ");
            islem = scanner.next().charAt(0);

            // İşlem türünün geçerli olup olmadığını kontrol eder
            if (islem == '+' || islem == '-' || islem == '*' || islem == '/') {
                gecerliIslem = true;
            } else {
                System.out.println("Geçersiz işlem türü. Lütfen tekrar deneyin.");
            }
        }

        System.out.println("Kaç sayı ile işlem yapmak istiyorsunuz?");
        int sayiAdedi = scanner.nextInt();

        double sonuc = 0;
        boolean ilkSayi = true;
        System.out.println("Sayıları girin (Çıkmak için 'escape' yazabilirsiniz):");

        for (int i = 0; i < sayiAdedi; i++) {
            String girdi = scanner.next();

            // Kullanıcı 'escape' yazarsa program sonlanır
            if (girdi.equalsIgnoreCase("escape")) {
                System.out.println("Program sonlandırılıyor...");
                return;
            }

            double sayi;
            try {
                sayi = Double.parseDouble(girdi);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin veya 'escape' yazın.");
                i--;
                continue;
            }

            if (ilkSayi) {
                sonuc = sayi;
                ilkSayi = false;
            } else {
                switch (islem) {
                    case '+':
                        sonuc += sayi;
                        break;
                    case '-':
                        sonuc -= sayi;
                        break;
                    case '*':
                        sonuc *= sayi;
                        break;
                    case '/':
                        if (sayi != 0) {
                            sonuc /= sayi;
                        } else {
                            System.out.println("Hata: Sıfıra bölme.");
                            return;
                        }
                        break;
                }
            }
        }

        System.out.println("Sonuç: " + sonuc);


        //4. Kısım E-Posta Kontrolü
        System.out.println("Lütfen e-posta adresinizi girin: ");

        scanner.nextLine();

        String email = scanner.nextLine();

        if (email.endsWith("@gmail.com") && email.length() >= 11) {
            System.out.println("E-posta kabul edildi.");
        }
        else if (email.length() < 10) {
            System.out.println("E-posta adresi en az 10 karakter uzunluğunda olmalıdır.");
        }
        else {
            System.out.println("Sadece @gmail.com domainli e-postalar kabul edilmektedir.");
        }
    }
}