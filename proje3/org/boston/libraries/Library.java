package org.boston.libraries;

import java.util.ArrayList;

public class Library {
    private Book[] envanter;

    public Library(int kapasite) {
        this.envanter = new Book[kapasite];
    }

    public Library(Book[] kitaplar) {
        this.envanter = kitaplar;
    }

    // Arama 1: Sadece başlığa göre
    public Book[] ara(String baslik) {
        ArrayList<Book> bulunanlar = new ArrayList<>();
        for (Book kitap : envanter) {
            if (kitap != null && kitap.getBaslik().equalsIgnoreCase(baslik)) {
                bulunanlar.add(kitap);
            }
        }
        return bulunanlar.toArray(new Book[0]);
    }

    // Arama 2: Başlık + yıl kombinasyonu
    public Book[] ara(String baslik, int yil) {
        ArrayList<Book> bulunanlar = new ArrayList<>();
        for (Book kitap : envanter) {
            if (kitap != null &&
                    kitap.getBaslik().equalsIgnoreCase(baslik) &&
                    kitap.getYil() == yil) {
                bulunanlar.add(kitap);
            }
        }
        return bulunanlar.toArray(new Book[0]);
    }

    // Arama 3: Koşula göre (ortalama puan eşiği)
    public Book[] ara(double minOrtalama) {
        ArrayList<Book> bulunanlar = new ArrayList<>();
        for (Book kitap : envanter) {
            if (kitap != null && kitap.ortalamaHesapla() >= minOrtalama) {
                bulunanlar.add(kitap);
            }
        }
        return bulunanlar.toArray(new Book[0]);
    }

    // Selection Sort - artan sıralama
    public void sirala() {
        int n = gerceKitapSayisi();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (envanter[j] != null && envanter[minIndex] != null) {
                    if (envanter[j].ortalamaHesapla() < envanter[minIndex].ortalamaHesapla()) {
                        minIndex = j;
                    }
                }
            }
            // Swap
            if (minIndex != i) {
                Book temp = envanter[i];
                envanter[i] = envanter[minIndex];
                envanter[minIndex] = temp;
            }
        }
    }

    // Derin kopya
    public Book[] derinKopya() {
        Book[] kopya = new Book[envanter.length];
        for (int i = 0; i < envanter.length; i++) {
            if (envanter[i] != null) {
                kopya[i] = new Book(
                        envanter[i].getBaslik(),
                        envanter[i].getYazar(),
                        envanter[i].getYil(),
                        Book.guvenliKopyaElle(envanter[i].getPuanlar())
                );
            }
        }
        return kopya;
    }

    // İçerik eşitliği (erken çıkış)
    public boolean icerikEsitMi(Library diger) {
        if (this.envanter.length != diger.envanter.length) {
            return false;
        }
        for (int i = 0; i < envanter.length; i++) {
            Book kitap1 = this.envanter[i];
            Book kitap2 = diger.envanter[i];

            if (kitap1 == null && kitap2 == null) {
                continue;
            }
            if (kitap1 == null || kitap2 == null) {
                return false;
            }
            if (!kitap1.getBaslik().equals(kitap2.getBaslik()) ||
                    !kitap1.getYazar().equals(kitap2.getYazar()) ||
                    kitap1.getYil() != kitap2.getYil() ||
                    !kitap1.puanIcerikEsitMi(kitap2)) {
                return false;
            }
        }
        return true;
    }

    // ArrayList'e dönüştür
    public ArrayList<Book> arrayListeDonustur() {
        ArrayList<Book> liste = new ArrayList<>();
        for (Book kitap : envanter) {
            if (kitap != null) {
                liste.add(kitap);
            }
        }
        return liste;
    }

    // ArrayList'ten geri al
    public void arrayListtenAl(ArrayList<Book> liste) {
        this.envanter = new Book[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            this.envanter[i] = liste.get(i);
        }
    }

    private int gerceKitapSayisi() {
        int sayac = 0;
        for (Book kitap : envanter) {
            if (kitap != null) {
                sayac++;
            }
        }
        return sayac;
    }

    public Book[] getEnvanter() {
        return envanter;
    }

    public void setEnvanter(Book[] envanter) {
        this.envanter = envanter;
    }
}
