import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kart türünü seçiniz: \n1. 65 Yaş Üstü\n2. Öğrenci\n3. Yetişkin");
        int kartTuru = scanner.nextInt();

        System.out.println("Kart tipi seçiniz: \n1. Normal\n2. Aylık");
        int kartTipi = scanner.nextInt();
        //kullanıcıdan kart tipi ve kart türü alınır
        double bakiye = 0;
        int kullanimHakki = 0;

        if (kartTipi == 1) {
            System.out.println("Bakiyenizi giriniz: ");
            bakiye = scanner.nextDouble();
        } else if (kartTipi == 2) {
            if (kartTuru == 2) {
                kullanimHakki = 200; // Öğrenci aylık kart başlangıçta 200 basım hakkı
            } else if (kartTuru == 3) {
                kullanimHakki = 100; // Yetişkin aylık kart başlangıçta 100 basım hakkı
            }
        }


        System.out.println("Hangi toplu taşıma aracını kullanacaksınız?\n1. Otobüs\n2. Tramvay\n3. Metro\n4. Metrobüs\n5. Marmaray");
        int aracTuru = scanner.nextInt();

        // 65 yaş üstü kullanıcılar için ücretsiz kontrol
        if (kartTuru == 1) {
            System.out.println("65 yaş üstü kartınızla tüm toplu taşıma araçlarını ücretsiz kullanabilirsiniz.");
        } else {
            double ucret = 0;
            int basim = 0;

            // Öğrenci veya yetişkin kartı için ücret ve basım hakkı belirleme
            if (aracTuru == 1 || aracTuru == 2 || aracTuru == 3) { // Otobüs, Tramvay veya Metro
                if (kartTuru == 3) { // Yetişkin
                    ucret = 20;
                } else if (kartTuru == 2) { // Öğrenci
                    ucret = 10;
                    basim = 1;
                }
            } else if (aracTuru == 4 || aracTuru == 5) { // Metrobüs veya Marmaray
                System.out.println("Kaç durak gideceksiniz?");
                int durakSayisi = scanner.nextInt();

                if (kartTuru == 3) { // Yetişkin
                    if (durakSayisi <= 2) {
                        ucret = 15;
                    } else if (durakSayisi == 3) {
                        ucret = 20;
                    } else if (durakSayisi <= 10) {
                        ucret = 25;
                    } else {
                        ucret = 30;
                    }
                } else if (kartTuru == 2) { // Öğrenci
                    if (durakSayisi <= 5) {
                        ucret = 5;
                        basim = 1;
                    } else {
                        ucret = 10;
                        basim = 2;
                    }
                }
            }

            // Ödeme işlemi
            if (kartTipi == 1) { // Normal kart
                if (bakiye >= ucret) {
                    bakiye -= ucret;
                    System.out.println("Ödeme başarılı. Kalan bakiye: " + bakiye + " TL");
                } else {
                    System.out.println("Yetersiz bakiye.");
                }
            } else if (kartTipi == 2) { // Aylık kart
                if (kullanimHakki >= basim) {
                    kullanimHakki -= basim;
                    System.out.println("Ödeme başarılı. Kalan kullanım hakkı: " + kullanimHakki);
                } else {
                    System.out.println("Yetersiz kullanım hakkı.");
                }
            }
        }
        scanner.close();
    }
}