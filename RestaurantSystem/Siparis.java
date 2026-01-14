import java.util.ArrayList;

public class Siparis {
    private String musteriAdi;
    private ArrayList<Yemek> siparisYemekler;
    private ArrayList<Icecek> siparisIcecekler;
    private ArrayList<Tatli> siparisTatlilar;
    private boolean paketServisMi;

    public Siparis(String musteriAdi, boolean paketServisMi) {
        this.musteriAdi = musteriAdi;
        this.paketServisMi = paketServisMi;
        this.siparisYemekler = new ArrayList<>();
        this.siparisIcecekler = new ArrayList<>();
        this.siparisTatlilar = new ArrayList<>();
    }

    public void yemekEkle(Yemek yemek) {
        siparisYemekler.add(yemek);
    }

    public void icecekEkle(Icecek icecek) {
        siparisIcecekler.add(icecek);
    }

    public void tatliEkle(Tatli tatli) {
        siparisTatlilar.add(tatli);
    }

    public double toplamTutarHesapla() {
        double toplam = 0;

        for (Yemek yemek : siparisYemekler) {
            toplam += yemek.satisFiyatiHesapla();
        }
        for (Icecek icecek : siparisIcecekler) {
            toplam += icecek.satisFiyatiHesapla();
        }
        for (Tatli tatli : siparisTatlilar) {
            toplam += tatli.satisFiyatiHesapla();
        }

        if (paketServisMi) {
            toplam += 10.0;
        }

        return toplam;
    }

    public void siparisOzetiYazdir() {
        System.out.println("\n========== SİPARİŞ ÖZETİ ==========");
        System.out.println("Müşteri: " + musteriAdi);
        System.out.println("Servis Tipi: " + (paketServisMi ? "Paket Servis" : "Salon Servisi"));
        System.out.println();

        if (!siparisYemekler.isEmpty()) {
            System.out.println("--- Yemekler ---");
            for (Yemek yemek : siparisYemekler) {
                System.out.println(yemek.getAd() + " - " + yemek.satisFiyatiHesapla() + " TL");
            }
        }

        if (!siparisIcecekler.isEmpty()) {
            System.out.println("--- İçecekler ---");
            for (Icecek icecek : siparisIcecekler) {
                System.out.println(icecek.getAd() + " - " + icecek.satisFiyatiHesapla() + " TL");
            }
        }

        if (!siparisTatlilar.isEmpty()) {
            System.out.println("--- Tatlılar ---");
            for (Tatli tatli : siparisTatlilar) {
                System.out.println(tatli.getAd() + " - " + tatli.satisFiyatiHesapla() + " TL");
            }
        }

        System.out.println("\n--- TOPLAM TUTAR: " + toplamTutarHesapla() + " TL ---");
    }
}
