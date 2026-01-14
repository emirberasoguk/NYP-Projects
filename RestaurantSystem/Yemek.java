public class Yemek extends Urun implements IndirimUygulanabilir, OzelUrun {
    private boolean vegMi;
    private boolean ozelGunYemegiMi;

    public Yemek(String ad, double hamFiyat, int hazirlamaSuresi, boolean vegMi, boolean ozelGunYemegiMi) {
        super(ad, hamFiyat, hazirlamaSuresi);
        this.vegMi = vegMi;
        this.ozelGunYemegiMi = ozelGunYemegiMi;

        if (this.ozelGunYemegiMi) {
            this.hamFiyat = this.hamFiyat * 0.85;
        }
    }

    @Override
    public double satisFiyatiHesapla() {
        double fiyat = hamFiyat;
        fiyat += fiyat * Sabitler.KDV_ORANI;
        fiyat += fiyat * Sabitler.SERVIS_UCRETI_ORANI;
        if (vegMi) {
            fiyat += 2.0;
        }
        return fiyat;
    }

    @Override
    public String kategoriAdi() {
        return "Yemek";
    }

    @Override
    public void indirimUygula(double oran) {
        if (oran >= 0 && oran <= 1) {
            hamFiyat = hamFiyat * (1 - oran);
        }
    }

    @Override
    public String ozelNotAl() {
        if (ozelGunYemegiMi) {
            return "Günün özel menüsü!";
        } else {
            return "Şefin özel sosuyla hazırlanır.";
        }
    }

    @Override
    public void ozelHazirlikYap() {
        System.out.println("Yemek için özel marine hazırlanıyor...");
        System.out.println("Taze sebzeler temizleniyor...");
        System.out.println("Şefin özel sosu ekleniyor...");
    }
}
