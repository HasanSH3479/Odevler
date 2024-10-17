import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    //1. Senaryo
    Scanner scanner = new Scanner(System.in);
    boolean dogruKimlik=false;;
    while (!dogruKimlik){
    System.out.println("T.C Kimlik Numarasını Giriniz:");
    String kimlikNumarasi = scanner.nextLine(); //kullanıcıdan kimlik numarası alınır
        if (kimlikNumarasi.charAt(0)== '0'){
            System.out.println("Kimlik numarası 0 rakamı ile başlayamaz.");
        }
        if (kimlikNumarasi.length() == 11) { //kimlik numarasının 11 haneli olup olmadığı kontrol edilir
    int toplam=0;
    for (int i=0; i< kimlikNumarasi.length()-1;i++) {
        toplam +=
                Character.getNumericValue(kimlikNumarasi.charAt(i));
    } //kimlik numarasının ilk 10 hanesi toplanır
        int birlerBasamagi = toplam % 10;
        int sonRakam=Character.getNumericValue(kimlikNumarasi.charAt(10));
        //ilk 10 hanenin toplamının birler basamağı son haneye eşit olmalıdır

        if (birlerBasamagi == sonRakam){
            System.out.println("Kimlik numarası doğrulanmıştır.");
        }
        dogruKimlik=true;
        }
        else {
            System.out.println("Hatalı kimlik numarası");
        }
    }
    scanner.close();
        }
        }


