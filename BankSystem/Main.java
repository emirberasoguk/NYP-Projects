import java.util.Scanner;
import java.util.ArrayList;
public class main {
    static void ana_menu(){
        System.out.print("\n---===Bir Seçim yapınız===---\n-0- CIKIŞ\n-1-Hesap Oluştur\n-2-Hesap İşlemleri\n");
    }
    static void alt_menu(){
            System.out.print("\n---===Hangi İşlemi Yapmak istersiniz?===---\n-0-\n-1-Para Yatır\n-2-Para Çek\n-3-Hesap Bilgileri\n");
        }
    public static void main(String[] args){
        ArrayList<hesap> hesaplar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean devam_mi=true;
        hesaplar.add(new hesap("240201092", "Emir Bera Soğuk", 99999.0));
        System.out.println("-----=====:::::Banka sistemine hoş geldiniz:::::=====-----");
        while(devam_mi){
        ana_menu();
        int ana_menu_secim=scanner.nextInt();
            if(ana_menu_secim==2){
                if(hesaplar.isEmpty()){
                    System.out.println("HATA HESAP YOK GİT OLUŞTUR");
                    continue;
                }
                System.out.print("\n---===İşlem Yapılacak Hesabı Seçiniz===---\n");
                for(int i=0; i<hesaplar.size();i++){
                    System.out.println("-"+(i+1)+"-"+ hesaplar.get(i).hesap_sahibi_alici());
                }
                int hesap_secim=scanner.nextInt();
                if(hesap_secim>hesaplar.size()){System.out.println("HATA YANLIŞ GİRDİNİZ"); devam_mi=false;}
                else if(hesap_secim<=0){System.out.println("HATA YANLIŞ GİRDİNİZ"); devam_mi=false;}
                int hesap_secim_indexi=hesap_secim-1;
                hesap secilen_hesap = hesaplar.get(hesap_secim_indexi);
                alt_menu();
                int alt_menu_secim=scanner.nextInt();
                switch(alt_menu_secim){
                    case 0:
                        System.out.println("---Cıkış Yapılıyor Güle Güle---");
                        devam_mi=false;
                    case 1:
                        System.out.println("Yatırılacak Miktarı giriniz:");
                        int yatirilacak=scanner.nextInt();
                        secilen_hesap.para_yatir(yatirilacak);
                        break;
                    case 2:
                        System.out.println("Çekilecek Miktarı Giriniz:");
                        int cekilecek=scanner.nextInt();
                        secilen_hesap.para_cek(cekilecek);
                        break;
                    case 3:
                        secilen_hesap.bilgi_goster();
                        System.out.println("\n--------------------\n");
                        break;
                    default:
                        System.out.println("!!!!!Hatalı giriş!!!!!");
                        devam_mi=false;
                }
            }
            else if(ana_menu_secim==1){
                System.out.print("Hesap Adı:");
                scanner.nextLine();
                String hesap_sahibi=scanner.next();
                System.out.print("Hesap Numarası:");
                scanner.nextLine();
                String Hesap_no=scanner.next();
                System.out.print("Başlangıç Bakiyesi:");
                scanner.nextLine();
                double bakiye=scanner.nextDouble();
                hesaplar.add(new hesap(Hesap_no, hesap_sahibi, bakiye));
            }
            else{
                System.out.println("HATALI GİRİS");
                devam_mi=false;
            }
        }
    }
}
