public class Tatli extends Urun implements OzelUrun {
    private boolean sutluMu;
    private boolean sicakServisMi;

    public Tatli(String ad, double hamFiyat, int hazirlamaSuresi, boolean sutluMu, boolean sicakServisMi) {
        super(ad, hamFiyat, hazirlamaSuresi);
        this.sutluMu = sutluMu;
        this.sicakServisMi = sicakServisMi;
    }

    @Override
    public double satisFiyatiHesapla() {
        double fiyat = hamFiyat;
        fiyat += fiyat * Sabitler.KDV_ORANI;
        if (sutluMu) {
            fiyat += 2.0;
        }
        if (sicakServisMi) {
            fiyat += 1.0;
        }
        return fiyat;
    }

    @Override
    public String kategoriAdi() {
        return "Tatlı";
    }

    @Override
    public String ozelNotAl() {
        if (sicakServisMi) {
            return "Sıcak servis edilir, sıcakken tüketiniz.";
        } else {
            return "Soğuk servis edilen özel tatlımız.";
        }
    }

    @Override
    public void ozelHazirlikYap() {
        System.out.println("Tatlı için özel hamur hazırlanıyor...");
        System.out.println("Dekorasyon yapılıyor...");
    }
}
