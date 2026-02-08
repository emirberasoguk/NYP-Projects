import java.util.Scanner;
import java.util.Random;
public class sayi_tahmin_oyunu {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner alıcı = new Scanner(System.in); 
        int ana_menu,aranan,menu_sayi_tahmin,min_tut,max_tut,max_min_tut_fark;
        boolean devammı = true;
        System.out.println("\t\t\t*****************\n");
        System.out.println("\t\t\tOyun Kompleksine Hos Geldiniz!\n");
        System.out.println("\t\t\t*****************\n");
        while(devammı){
            System.out.println("*****************\n");
            System.out.println("\tMenu\n\t-0-CIKIS\n\t-1-Sayi Tahmini Oyunu OYNA\n\t-2-ZAR Atma Oyunu OYNA\n\t-3-Yazi Tura Atma Oyunu OYNA\n\t-4-Bahis Oyunu OYNA");
            System.out.println("*****************\n");
            ana_menu = alıcı.nextInt();
            switch(ana_menu){
                case 0:
                    System.out.println("CIKIS yapiliyor...");
                    devammı = false;
                    break;
                case 1:
                    System.out.println("Sayiyi -1-bilgisayar mi tutsun\n yoksa -2-sen mi tutacaksin?");
                    menu_sayi_tahmin = alıcı.nextInt();
                    switch(menu_sayi_tahmin){
                        case 1:
                            System.out.println("Tutualcak sayi hangi sayi araliginda olsun?\n !once min daha sonra max degeri giriniz!");
                            min_tut = alıcı.nextInt();
                            max_tut = alıcı.nextInt();
                            max_min_tut_fark = max_tut - min_tut;
                            max_min_tut_fark += 1;
                            aranan = random.nextInt(min_tut) + max_min_tut_fark;
                            System.out.println("Sayi Tutuldu\n hadi tahminleri alalim");
                                                      
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("HATALI GIRDI\n Program kapaniyor...");
                            System.exit(-2);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("HATALI GIRDI!!!\n Program kapaniyor..."); 
                    System.exit(-1);
            }
        }
    }
}
