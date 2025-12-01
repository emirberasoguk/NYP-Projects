package org.boston.libraries;

public class CirculationStats {
    private int[][] kullanimSayilari; // [yıl][çeyrek]

    // Standart (dikdörtgen) yapı
    public CirculationStats(int yilSayisi, int ceyrekSayisi) {
        this.kullanimSayilari = new int[yilSayisi][ceyrekSayisi];
    }

    // Ragged (satır uzunlukları farklı) yapı
    public CirculationStats(int[] ceyrekUzunluklari) {
        this.kullanimSayilari = new int[ceyrekUzunluklari.length][];
        for (int i = 0; i < ceyrekUzunluklari.length; i++) {
            this.kullanimSayilari[i] = new int[ceyrekUzunluklari[i]];
        }
    }

    // Veri yükleme
    public void veriYukle(int[][] veri) {
        this.kullanimSayilari = veri;
    }

    // Belirli yılın toplam kullanımı
    public int yilToplamKullanim(int yilIndex) {
        if (yilIndex < 0 || yilIndex >= kullanimSayilari.length) {
            return -1;
        }
        int toplam = 0;
        for (int kullanim : kullanimSayilari[yilIndex]) {
            toplam += kullanim;
        }
        return toplam;
    }

    // En yoğun çeyrek (tüm yıllar içinde)
    public String enYogunCeyrek() {
        int maxKullanim = -1;
        int maxYil = -1;
        int maxCeyrek = -1;

        for (int yil = 0; yil < kullanimSayilari.length; yil++) {
            for (int ceyrek = 0; ceyrek < kullanimSayilari[yil].length; ceyrek++) {
                if (kullanimSayilari[yil][ceyrek] > maxKullanim) {
                    maxKullanim = kullanimSayilari[yil][ceyrek];
                    maxYil = yil;
                    maxCeyrek = ceyrek;
                }
            }
        }

        if (maxYil == -1) {
            return "Veri bulunamadı";
        }
        return String.format("Yıl: %d, Çeyrek: %d, Kullanım: %d",
                maxYil, maxCeyrek + 1, maxKullanim);
    }

    // Yıllık özet (her yılın toplamı)
    public void yillikOzet() {
        System.out.println("\n=== YILLIK ÖZET ===");
        for (int yil = 0; yil < kullanimSayilari.length; yil++) {
            int toplam = yilToplamKullanim(yil);
            System.out.printf("Yıl %d: %d toplam kullanım (Çeyrek sayısı: %d)%n",
                    yil, toplam, kullanimSayilari[yil].length);
        }
    }

    // Belirli bir yılın detayını göster
    public void yilDetayGoster(int yilIndex) {
        if (yilIndex < 0 || yilIndex >= kullanimSayilari.length) {
            System.out.println("Geçersiz yıl indeksi!");
            return;
        }
        System.out.printf("\nYıl %d Detayı:%n", yilIndex);
        for (int ceyrek = 0; ceyrek < kullanimSayilari[yilIndex].length; ceyrek++) {
            System.out.printf("  Çeyrek %d: %d kullanım%n",
                    ceyrek + 1, kullanimSayilari[yilIndex][ceyrek]);
        }
        System.out.printf("  TOPLAM: %d%n", yilToplamKullanim(yilIndex));
    }

    public int[][] getKullanimSayilari() {
        return kullanimSayilari;
    }
}
