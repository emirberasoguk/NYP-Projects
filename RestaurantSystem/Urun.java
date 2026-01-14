public abstract class Urun {
    protected String ad;
    protected double hamFiyat;
    protected int hazirlamaSuresi;

    public Urun(String ad, double hamFiyat, int hazirlamaSuresi) {
        this.ad = ad;
        this.hamFiyat = hamFiyat;
        if (hazirlamaSuresi < Sabitler.MIN_HAZIRLAMA_SURESI) {
            this.hazirlamaSuresi = Sabitler.MIN_HAZIRLAMA_SURESI;
        } else {
            this.hazirlamaSuresi = hazirlamaSuresi;
        }
    }

    public String getAd() {
        return ad;
    }

    public double getHamFiyat() {
        return hamFiyat;
    }

    public int getHazirlamaSuresi() {
        return hazirlamaSuresi;
    }

    public void setHamFiyat(double hamFiyat) {
        if (hamFiyat < 0) {
            this.hamFiyat = 0;
        } else {
            this.hamFiyat = hamFiyat;
        }
    }

    public void urunBilgisiYazdir() {
        System.out.println("Ürün: " + ad);
        System.out.println("Ham Fiyat: " + hamFiyat + " TL");
        System.out.println("Hazırlama Süresi: " + hazirlamaSuresi + " dakika");
    }

    public abstract double satisFiyatiHesapla();
    public abstract String kategoriAdi();
}
