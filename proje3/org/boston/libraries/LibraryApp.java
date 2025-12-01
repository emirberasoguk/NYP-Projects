package org.boston.libraries;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class LibraryApp {
    private static Library kutuphane;
    private static CirculationStats istatistikler;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== KÜTÜPHANE YÖNETİM SİSTEMİ ===\n");

        boolean devam = true;
        while (devam) {
            menuGoster();
            int secim = guvenliIntGiris("Seçiminiz: ");

            switch (secim) {
                case 1:
                    kitaplariYukle();
                    break;
                case 2:
                    kitaplariListele();
                    break;
                case 3:
                    araBaslik();
                    break;
                case 4:
                    araBaslikVeYil();
                    break;
                case 5:
                    araKosul();
                    break;
                case 6:
                    sirala();
                    break;
                case 7:
                    puanKopyala();
                    break;
                case 8:
                    icerikEsitligiTesti();
                    break;
                case 9:
                    istatistikMenu();
                    break;
                case 10:
                    arrayListDonusum();
                    break;
                case 11:
                    vectorKapasiteGozlemi();
                    break;
                case 0:
                    System.out.println("\nProgram sonlandırılıyor. Hoşçakalın!");
                    devam = false;
                    break;
                default:
                    System.out.println("\n⚠ Geçersiz seçim! Lütfen 0-11 arası bir değer girin.\n");
            }
        }
        scanner.close();
    }

    private static void menuGoster() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║            ANA MENÜ                        ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  1)  Kitapları Yükle                       ║");
        System.out.println("║  2)  Kitapları Listele                     ║");
        System.out.println("║  3)  Ara (Başlık)                          ║");
        System.out.println("║  4)  Ara (Başlık + Yıl)                    ║");
        System.out.println("║  5)  Ara (Koşula Göre)                     ║");
        System.out.println("║  6)  Sırala (Ortalama Puan Artan)          ║");
        System.out.println("║  7)  Puan Dizisi: Kopya Al (Elle/Clone)    ║");
        System.out.println("║  8)  Puan Dizisi: İçerik Eşitliği Testi    ║");
        System.out.println("║  9)  İstatistik: Yıl/Çeyrek Toplamları     ║");
        System.out.println("║  10) ArrayList'e Aktar / Geri Dön          ║");
        System.out.println("║  11) Vector Kapasite Gözlemi               ║");
        System.out.println("║  0)  Çıkış                                 ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    // 1) Kitapları Yükle
    private static void kitaplariYukle() {
        Book[] kitaplar = new Book[6];

        kitaplar[0] = new Book("Savaş ve Barış", "Tolstoy", 1869,
                new int[]{9, 10, 8, 9, 10});
        kitaplar[0].etiketEkle("klasik");
        kitaplar[0].etiketEkle("tarih");

        kitaplar[1] = new Book("1984", "Orwell", 1949,
                new int[]{10, 9, 10, 8, 9});
        kitaplar[1].etiketEkle("distopya");

        kitaplar[2] = new Book("Suç ve Ceza", "Dostoyevski", 1866,
                new int[]{9, 9, 8, 10, 9});
        kitaplar[2].etiketEkle("klasik");

        kitaplar[3] = new Book("Hobbit", "Tolkien", 1937,
                new int[]{8, 9, 7, 8, 9});
        kitaplar[3].etiketEkle("fantastik");

        kitaplar[4] = new Book("Fareler ve İnsanlar", "Steinbeck", 1937,
                new int[]{7, 8, 7, 8, 7});
        kitaplar[4].etiketEkle("klasik");

        kitaplar[5] = new Book("Satranç", "Zweig", 1942,
                new int[]{8, 8, 9, 7, 8});

        kutuphane = new Library(kitaplar);

        // İstatistik verilerini yükle
        int[][] kullanimVerileri = {
                {120, 150, 180, 140},  // Yıl 0
                {200, 220, 190, 210},  // Yıl 1
                {180, 200, 170}        // Yıl 2 (ragged - 3 çeyrek)
        };
        istatistikler = new CirculationStats(new int[]{4, 4, 3});
        istatistikler.veriYukle(kullanimVerileri);

        System.out.println("\n 6 kitap başarıyla yüklendi!");
        System.out.println(" İstatistik verileri yüklendi.\n");
    }

    // 2) Kitapları Listele
    private static void kitaplariListele() {
        if (kutuphane == null) {
            System.out.println("\n Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        Book[] envanter = kutuphane.getEnvanter();
        System.out.println("\n=== KÜTÜPHANE ENVANTERİ ===");
        for (int i = 0; i < envanter.length; i++) {
            if (envanter[i] != null) {
                System.out.printf("[%d] %s%n", i, envanter[i]);
            }
        }
        System.out.println();
    }

    // 3) Ara (Başlık)
    private static void araBaslik() {
        if (kutuphane == null) {
            System.out.println("\n⚠ Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        System.out.print("\nAranacak başlık: ");
        String baslik = scanner.nextLine();

        Book[] sonuclar = kutuphane.ara(baslik);
        sonuclariGoster(sonuclar, "Başlık: " + baslik);
    }

    // 4) Ara (Başlık + Yıl)
    private static void araBaslikVeYil() {
        if (kutuphane == null) {
            System.out.println("\n⚠ Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        System.out.print("\nAranacak başlık: ");
        String baslik = scanner.nextLine();
        int yil = guvenliIntGiris("Aranacak yıl: ");

        Book[] sonuclar = kutuphane.ara(baslik, yil);
        sonuclariGoster(sonuclar, "Başlık: " + baslik + ", Yıl: " + yil);
    }

    // 5) Ara (Koşula Göre)
    private static void araKosul() {
        if (kutuphane == null) {
            System.out.println("\nÖnce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        System.out.print("\nMinimum ortalama puan (0-10): ");
        double minPuan = scanner.nextDouble();
        scanner.nextLine();

        Book[] sonuclar = kutuphane.ara(minPuan);
        sonuclariGoster(sonuclar, "Min. Puan: " + minPuan);
    }

    private static void sonuclariGoster(Book[] sonuclar, String kriter) {
        System.out.println("\n--- ARAMA SONUÇLARI (" + kriter + ") ---");
        if (sonuclar.length == 0) {
            System.out.println("Hiç sonuç bulunamadı.");
        } else {
            for (int i = 0; i < sonuclar.length; i++) {
                System.out.printf("[%d] %s%n", i, sonuclar[i]);
            }
        }
        System.out.println();
    }

    // 6) Sırala
    private static void sirala() {
        if (kutuphane == null) {
            System.out.println("\n Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        System.out.println("\nSıralama öncesi ilk 3 kitap:");
        Book[] envanter = kutuphane.getEnvanter();
        for (int i = 0; i < Math.min(3, envanter.length); i++) {
            if (envanter[i] != null) {
                System.out.printf("  [%d] %s - Ort: %.1f%n",
                        i, envanter[i].getBaslik(), envanter[i].ortalamaHesapla());
            }
        }

        kutuphane.sirala();

        System.out.println("\nSıralama sonrası tüm kitaplar:");
        for (int i = 0; i < envanter.length; i++) {
            if (envanter[i] != null) {
                System.out.printf("  [%d] %s - Ort: %.1f%n",
                        i, envanter[i].getBaslik(), envanter[i].ortalamaHesapla());
            }
        }
        System.out.println("\n Kitaplar ortalama puana göre sıralandı!\n");
    }

    // 7) Puan Kopya
    private static void puanKopyala() {
        if (kutuphane == null) {
            System.out.println("\n Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        Book[] envanter = kutuphane.getEnvanter();
        Book ornekKitap = envanter[0];

        System.out.println("\n=== PUAN DİZİSİ KOPYALAMA TESTİ ===");
        System.out.println("Orijinal kitap: " + ornekKitap.getBaslik());
        System.out.print("Orijinal puanlar: ");
        diziYazdir(ornekKitap.getPuanlar());

        // Elle kopya
        int[] elleKopya = Book.guvenliKopyaElle(ornekKitap.getPuanlar());
        System.out.print("Elle kopya: ");
        diziYazdir(elleKopya);

        // Clone ile kopya
        int[] cloneKopya = Book.guvenliKopyaClone(ornekKitap.getPuanlar());
        System.out.print("Clone kopya: ");
        diziYazdir(cloneKopya);

        // Alias olmadığını kanıtla
        System.out.println("\n--- Alias Testi ---");
        elleKopya[0] = 999;
        cloneKopya[0] = 888;

        System.out.print("Orijinal (değişmemeli): ");
        diziYazdir(ornekKitap.getPuanlar());
        System.out.print("Elle kopya (999 olmalı): ");
        diziYazdir(elleKopya);
        System.out.print("Clone kopya (888 olmalı): ");
        diziYazdir(cloneKopya);

        System.out.println("\n✓ Kopyalar alias değil, bağımsız diziler!\n");
    }

    // 8) İçerik Eşitliği
    private static void icerikEsitligiTesti() {
        System.out.println("\n=== İÇERİK EŞİTLİĞİ TESTİ ===");

        int[] dizi1 = {8, 9, 7, 10, 8};
        int[] dizi2 = {8, 9, 7, 10, 8};
        int[] dizi3 = {8, 9, 5, 10, 8};

        System.out.print("Dizi 1: ");
        diziYazdir(dizi1);
        System.out.print("Dizi 2: ");
        diziYazdir(dizi2);
        System.out.print("Dizi 3: ");
        diziYazdir(dizi3);

        System.out.println("\nDizi1 == Dizi2: " +
                (Book.puanDizisiEsitMi(dizi1, dizi2) ? " EŞİT" : " EŞİT DEĞİL"));

        boolean esitMi = Book.puanDizisiEsitMi(dizi1, dizi3);
        System.out.println("Dizi1 == Dizi3: " +
                (esitMi ? " EŞİT" : " EŞİT DEĞİL"));

        if (!esitMi) {
            int farkIndex = Book.ilkFarkIndeksi(dizi1, dizi3);
            System.out.println("  İlk fark indeksi: " + farkIndex +
                    " (dizi1[" + farkIndex + "]=" + dizi1[farkIndex] +
                    ", dizi3[" + farkIndex + "]=" + dizi3[farkIndex] + ")");
        }
        System.out.println();
    }

    // 9) İstatistik Menü
    private static void istatistikMenu() {
        if (istatistikler == null) {
            System.out.println("\n İstatistik verileri yüklü değil!\n");
            return;
        }

        System.out.println("\n=== İSTATİSTİK MENÜSÜ ===");
        System.out.println("1) Belirli Yılın Toplamı");
        System.out.println("2) En Yoğun Çeyrek");
        System.out.println("3) Yıllık Özet");
        System.out.println("4) Yıl Detayı");
        int secim = guvenliIntGiris("Seçim: ");

        switch (secim) {
            case 1:
                int yil = guvenliIntGiris("Yıl indeksi (0,1,2...): ");
                int toplam = istatistikler.yilToplamKullanim(yil);
                if (toplam == -1) {
                    System.out.println("Geçersiz yıl!");
                } else {
                    System.out.printf("Yıl %d toplam kullanım: %d%n", yil, toplam);
                }
                break;
            case 2:
                System.out.println("En yoğun çeyrek: " + istatistikler.enYogunCeyrek());
                break;
            case 3:
                istatistikler.yillikOzet();
                break;
            case 4:
                int yilDetay = guvenliIntGiris("Yıl indeksi: ");
                istatistikler.yilDetayGoster(yilDetay);
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
        System.out.println();
    }

    // 10) ArrayList Dönüşüm
    private static void arrayListDonusum() {
        if (kutuphane == null) {
            System.out.println("\n Önce kitapları yüklemeniz gerekiyor!\n");
            return;
        }

        System.out.println("\n=== ARRAYLİST DÖNÜŞÜMÜ ===");

        // Book[] -> ArrayList
        ArrayList<Book> liste = kutuphane.arrayListeDonustur();
        System.out.println(" Dizi ArrayList'e aktarıldı");
        System.out.println("  ArrayList size: " + liste.size());

        // Capacity'yi görmek için yeni eleman ekle
        System.out.println("\nNOT: ArrayList başlangıçta size kadar kapasite ayırır,");
        System.out.println("     gerektiğinde otomatik büyür (genelde 1.5x).");
        System.out.println("     ArrayList sadece nesne referansları tutar.");

        // ArrayList -> Book[]
        System.out.println("\n ArrayList tekrar diziye dönüştürülüyor...");
        kutuphane.arrayListtenAl(liste);
        System.out.println(" Dönüşüm tamamlandı!");
        System.out.println("  Dizi uzunluğu: " + kutuphane.getEnvanter().length);
        System.out.println();
    }

    // 11) Vector Kapasite
    private static void vectorKapasiteGozlemi() {
        System.out.println("\n=== VECTOR KAPASİTE GÖZLEMİ ===");

        int baslangicKapasitesi = guvenliIntGiris("Başlangıç kapasitesi: ");
        Vector<String> vector = new Vector<>(baslangicKapasitesi);

        System.out.println("\nBaşlangıç:");
        System.out.println("  size: " + vector.size() + ", capacity: " + vector.capacity());

        // Eleman ekle
        int eklenecekSayi = guvenliIntGiris("\nKaç eleman eklensin: ");
        for (int i = 1; i <= eklenecekSayi; i++) {
            vector.add("Kitap" + i);
            if (i % 5 == 0 || i == eklenecekSayi) {
                System.out.printf("  %d eleman sonrası -> size: %d, capacity: %d%n",
                        i, vector.size(), vector.capacity());
            }
        }

        // ensureCapacity kullanımı
        System.out.println("\nensureCapacity(50) çağrılıyor...");
        vector.ensureCapacity(50);
        System.out.println("  size: " + vector.size() + ", capacity: " + vector.capacity());

        System.out.println("\n Vector, ArrayList gibidir ama synchronized (thread-safe).");
        System.out.println(" Kapasite dolarsa 2 katına çıkar (ArrayList 1.5x).\n");
    }

    // Yardımcı metotlar
    private static void diziYazdir(int[] dizi) {
        System.out.print("[");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i]);
            if (i < dizi.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    private static int guvenliIntGiris(String mesaj) {
        while (true) {
            try {
                System.out.print(mesaj);
                int sayi = scanner.nextInt();
                scanner.nextLine(); // buffer temizle
                return sayi;
            } catch (Exception e) {
                System.out.println(" Lütfen geçerli bir sayı girin!");
                scanner.nextLine(); // hatalı girişi temizle
            }
        }
    }
}
