public class Icecek extends Urun implements IndirimUygulanabilir {
    private boolean sogukMu;
    private boolean sekerliMi;
    private static int toplamIcecekSayisi = 0;

    public Icecek(String ad, double hamFiyat, int hazirlamaSuresi, boolean sogukMu, boolean sekerliMi) {
        super(ad, hamFiyat, hazirlamaSuresi);
        this.sogukMu = sogukMu;
        this.sekerliMi = sekerliMi;
        toplamIcecekSayisi++;
    }

    @Override
    public double satisFiyatiHesapla() {
        double fiyat = hamFiyat;
        fiyat += fiyat * Sabitler.KDV_ORANI;
        if (!sogukMu) {
            fiyat += 1.0;
        }
        if (!sekerliMi) {
            fiyat -= 0.5;
        }
        return fiyat;
    }

    @Override
    public String kategoriAdi() {
        return "İçecek";
    }

    @Override
    public void indirimUygula(double oran) {
        if (oran >= 0 && oran <= 1) {
            hamFiyat = hamFiyat * (1 - oran);
        }
    }

    public static int getToplamIcecekSayisi() {
        return toplamIcecekSayisi;
    }
}
