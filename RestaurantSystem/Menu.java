import java.util.ArrayList;

public class Menu {
    private String ad;
    private ArrayList<Yemek> yemekler;
    private ArrayList<Icecek> icecekler;
    private ArrayList<Tatli> tatlilar;

    public Menu(String ad) {
        this.ad = ad;
        this.yemekler = new ArrayList<>();
        this.icecekler = new ArrayList<>();
        this.tatlilar = new ArrayList<>();
    }

    public void yemekEkle(Yemek yemek) {
        yemekler.add(yemek);
    }

    public void icecekEkle(Icecek icecek) {
        icecekler.add(icecek);
    }

    public void tatliEkle(Tatli tatli) {
        tatlilar.add(tatli);
    }

    public void menuYazdir() {
        System.out.println("\n========== " + ad + " \n");

        System.out.println("--- YEMEKLER ---");
        for (Yemek yemek : yemekler) {
            yemek.urunBilgisiYazdir();
            System.out.println("Kategori: " + yemek.kategoriAdi());
            System.out.println("Satış Fiyatı: " + yemek.satisFiyatiHesapla() + " TL");
            System.out.println();
        }

        System.out.println("--- İÇECEKLER ---");
        for (Icecek icecek : icecekler) {
            icecek.urunBilgisiYazdir();
            System.out.println("Kategori: " + icecek.kategoriAdi());
            System.out.println("Satış Fiyatı: " + icecek.satisFiyatiHesapla() + " TL");
            System.out.println();
        }

        System.out.println("--- TATLILAR ---");
        for (Tatli tatli : tatlilar) {
            tatli.urunBilgisiYazdir();
            System.out.println("Kategori: " + tatli.kategoriAdi());
            System.out.println("Satış Fiyatı: " + tatli.satisFiyatiHesapla() + " TL");
            System.out.println();
        }
    }

    public double toplamMenuFiyati() {
        double toplam = 0;

        for (Yemek yemek : yemekler) {
            toplam += yemek.satisFiyatiHesapla();
        }
        for (Icecek icecek : icecekler) {
            toplam += icecek.satisFiyatiHesapla();
        }
        for (Tatli tatli : tatlilar) {
            toplam += tatli.satisFiyatiHesapla();
        }

        return toplam;
    }
}
