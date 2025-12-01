package org.boston.libraries;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    private String baslik;
    private String yazar;
    private int yil;
    private int[] puanlar;
    private ArrayList<String> etiketler;

    // Tam parametreli kurucu
    public Book(String baslik, String yazar, int yil, int[] puanlar) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.yil = yil;
        this.puanlar = puanlar;
        this.etiketler = new ArrayList<>();
    }

    // Parametresiz kurucu
    public Book() {
        this.baslik = "Bilinmeyen Kitap";
        this.yazar = "Bilinmeyen Yazar";
        this.yil = 2024;
        this.puanlar = new int[]{0};
        this.etiketler = new ArrayList<>();
    }

    // Ortalama puan hesaplama
    public double ortalamaHesapla() {
        if (puanlar == null || puanlar.length == 0) {
            return 0.0;
        }
        int toplam = 0;
        for (int puan : puanlar) {
            toplam += puan;
        }
        return (double) toplam / puanlar.length;
    }

    // Etiket ekle
    public void etiketEkle(String etiket) {
        if (!etiketler.contains(etiket)) {
            etiketler.add(etiket);
        }
    }

    // Etiket çıkar
    public void etiketCikar(String etiket) {
        etiketler.remove(etiket);
    }

    // İçerik eşitliği - puan dizilerini karşılaştır
    public boolean puanIcerikEsitMi(Book diger) {
        return Book.puanDizisiEsitMi(this.puanlar, diger.puanlar);
    }

    // Statik: Güvenli kopya (elle)
    public static int[] guvenliKopyaElle(int[] orijinal) {
        if (orijinal == null) {
            return null;
        }
        int[] kopya = new int[orijinal.length];
        for (int i = 0; i < orijinal.length; i++) {
            kopya[i] = orijinal[i];
        }
        return kopya;
    }

    // Statik: Güvenli kopya (clone)
    public static int[] guvenliKopyaClone(int[] orijinal) {
        if (orijinal == null) {
            return null;
        }
        return orijinal.clone();
    }

    // Statik: İki puan dizisinin içerik eşitliği
    public static boolean puanDizisiEsitMi(int[] dizi1, int[] dizi2) {
        if (dizi1 == null && dizi2 == null) {
            return true;
        }
        if (dizi1 == null || dizi2 == null) {
            return false;
        }
        if (dizi1.length != dizi2.length) {
            return false;
        }
        for (int i = 0; i < dizi1.length; i++) {
            if (dizi1[i] != dizi2[i]) {
                return false;
            }
        }
        return true;
    }

    // İlk farkın indeksini bul
    public static int ilkFarkIndeksi(int[] dizi1, int[] dizi2) {
        if (dizi1 == null || dizi2 == null) {
            return -1;
        }
        int minUzunluk = Math.min(dizi1.length, dizi2.length);
        for (int i = 0; i < minUzunluk; i++) {
            if (dizi1[i] != dizi2[i]) {
                return i;
            }
        }
        if (dizi1.length != dizi2.length) {
            return minUzunluk;
        }
        return -1;
    }

    // Getter metotları
    public String getBaslik() {
        return baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public int getYil() {
        return yil;
    }

    public int[] getPuanlar() {
        return puanlar;
    }

    public ArrayList<String> getEtiketler() {
        return etiketler;
    }

    @Override
    public String toString() {
        return String.format("'%s' - %s (%d) | Ort: %.1f | Etiketler: %s",
                baslik, yazar, yil, ortalamaHesapla(),
                etiketler.isEmpty() ? "yok" : etiketler);
    }
}
