# Restoran Sipariş ve Menü Yönetim Sistemi - Detaylı Proje Promptu

## Proje Özeti
Java'da nesneye yönelik programlama prensiplerine uygun bir restoran sipariş ve menü yönetim sistemi geliştir. Sistem; soyut sınıflar, arayüzler, kalıtım, polimorfizm ve kapsülleme kavramlarını kullanmalı.

---

## 1. Sabitler Sınıfı (Sabitler.java)

```
SINIF: final class Sabitler
AMAÇ: Uygulama genelinde kullanılacak sabit değerleri barındırır, miras alınamaz

SABİTLER:
- public static final double KDV_ORANI = 0.10
- public static final double SERVIS_UCRETI_ORANI = 0.05
- public static final int MIN_HAZIRLAMA_SURESI = 5

CONSTRUCTOR:
- private Sabitler() { } // Nesne oluşturulmasını engeller
```

---

## 2. Urun Soyut Sınıfı (Urun.java)

```
SINIF: abstract class Urun
AMAÇ: Tüm menü ürünleri için temel şablon

ALANLAR (protected):
- String ad
- double hamFiyat
- int hazirlamaSuresi

CONSTRUCTOR:
public Urun(String ad, double hamFiyat, int hazirlamaSuresi) {
    this.ad = ad;
    this.hamFiyat = hamFiyat;
    if (hazirlamaSuresi < Sabitler.MIN_HAZIRLAMA_SURESI) {
        this.hazirlamaSuresi = Sabitler.MIN_HAZIRLAMA_SURESI;
    } else {
        this.hazirlamaSuresi = hazirlamaSuresi;
    }
}

GETTER METODLARI:
- public String getAd() { return ad; }
- public double getHamFiyat() { return hamFiyat; }
- public int getHazirlamaSuresi() { return hazirlamaSuresi; }

SETTER:
public void setHamFiyat(double hamFiyat) {
    if (hamFiyat < 0) {
        this.hamFiyat = 0;
    } else {
        this.hamFiyat = hamFiyat;
    }
}

BİLGİ YAZDIRMA:
public void urunBilgisiYazdir() {
    System.out.println("Ürün: " + ad);
    System.out.println("Ham Fiyat: " + hamFiyat + " TL");
    System.out.println("Hazırlama Süresi: " + hazirlamaSuresi + " dakika");
}

SOYUT METODLAR (alt sınıflar implement edecek):
- public abstract double satisFiyatiHesapla();
- public abstract String kategoriAdi();
```

---

## 3. Arayüzler (Interfaces)

### 3.1. IndirimUygulanabilir.java
```
public interface IndirimUygulanabilir {
    void indirimUygula(double oran); // oran: 0.0-1.0 arası (örn: 0.2 = %20)
}
```

### 3.2. OzelUrun.java
```
public interface OzelUrun {
    String ozelNotAl(); // Özel açıklama metni döndürür
    void ozelHazirlikYap(); // Konsola özel hazırlık adımları yazar
}
```

---

## 4. Yemek Sınıfı (Yemek.java)

```
SINIF: class Yemek extends Urun implements IndirimUygulanabilir, OzelUrun

EK ALANLAR (private):
- boolean vegMi
- boolean ozelGunYemegiMi

CONSTRUCTOR:
public Yemek(String ad, double hamFiyat, int hazirlamaSuresi, boolean vegMi, boolean ozelGunYemegiMi) {
    super(ad, hamFiyat, hazirlamaSuresi);
    this.vegMi = vegMi;
    this.ozelGunYemegiMi = ozelGunYemegiMi;
    
    // Opsiyonel: Özel günün yemeğiyse %15 indirim
    if (ozelGunYemegiMi) {
        this.hamFiyat = hamFiyat * 0.85;
    }
}

OVERRIDE METODLARI:

1. satisFiyatiHesapla():
   - Başlangıç: fiyat = hamFiyat
   - KDV ekle: fiyat += fiyat * Sabitler.KDV_ORANI
   - Servis ücreti ekle: fiyat += fiyat * Sabitler.SERVIS_UCRETI_ORANI
   - Vejetaryen ise: fiyat += 2.0 (özel malzeme ücreti)
   - return fiyat

2. kategoriAdi():
   - return "Yemek"

3. indirimUygula(double oran):
   - if (oran >= 0 && oran <= 1) {
       hamFiyat = hamFiyat * (1 - oran);
     }

4. ozelNotAl():
   - if (ozelGunYemegiMi) return "Günün özel menüsü!";
   - else return "Şefin özel sosuyla hazırlanır.";

5. ozelHazirlikYap():
   - System.out.println("Yemek için özel marine hazırlanıyor...");
   - System.out.println("Taze sebzeler temizleniyor...");
   - System.out.println("Şefin özel sosu ekleniyor...");
```

---

## 5. Icecek Sınıfı (Icecek.java)

```
SINIF: class Icecek extends Urun implements IndirimUygulanabilir

EK ALANLAR (private):
- boolean sogukMu
- boolean sekerliMi
- static int toplamIcecekSayisi = 0

CONSTRUCTOR:
public Icecek(String ad, double hamFiyat, int hazirlamaSuresi, boolean sogukMu, boolean sekerliMi) {
    super(ad, hamFiyat, hazirlamaSuresi);
    this.sogukMu = sogukMu;
    this.sekerliMi = sekerliMi;
    toplamIcecekSayisi++; // Her yeni içecek için sayacı artır
}

OVERRIDE METODLARI:

1. satisFiyatiHesapla():
   - fiyat = hamFiyat
   - KDV ekle: fiyat += fiyat * Sabitler.KDV_ORANI
   - Sıcak içecek ise (!sogukMu): fiyat += 1.0
   - Şekersiz ise (!sekerliMi): fiyat -= 0.5
   - return fiyat

2. kategoriAdi():
   - return "İçecek"

3. indirimUygula(double oran):
   - if (oran >= 0 && oran <= 1) {
       hamFiyat = hamFiyat * (1 - oran);
     }

STATİK METOD:
public static int getToplamIcecekSayisi() {
    return toplamIcecekSayisi;
}
```

---

## 6. Tatli Sınıfı (Tatli.java)

```
SINIF: class Tatli extends Urun implements OzelUrun

EK ALANLAR (private):
- boolean sutluMu
- boolean sicakServisMi

CONSTRUCTOR:
public Tatli(String ad, double hamFiyat, int hazirlamaSuresi, boolean sutluMu, boolean sicakServisMi) {
    super(ad, hamFiyat, hazirlamaSuresi);
    this.sutluMu = sutluMu;
    this.sicakServisMi = sicakServisMi;
}

OVERRIDE METODLARI:

1. satisFiyatiHesapla():
   - fiyat = hamFiyat
   - KDV ekle: fiyat += fiyat * Sabitler.KDV_ORANI
   - Sütlü ise: fiyat += 2.0
   - Sıcak servis ise: fiyat += 1.0
   - return fiyat

2. kategoriAdi():
   - return "Tatlı"

3. ozelNotAl():
   - if (sicakServisMi) return "Sıcak servis edilir, sıcakken tüketiniz.";
   - else return "Soğuk servis edilen özel tatlımız.";

4. ozelHazirlikYap():
   - System.out.println("Tatlı için özel hamur hazırlanıyor...");
   - System.out.println("Dekorasyon yapılıyor...");
```

---

## 7. Menu Sınıfı (Menu.java)

```
SINIF: class Menu
AMAÇ: Restoran menüsünü yönetir

IMPORT: import java.util.ArrayList;

ALANLAR (private):
- String ad
- ArrayList<Yemek> yemekler
- ArrayList<Icecek> icecekler
- ArrayList<Tatli> tatlilar

CONSTRUCTOR:
public Menu(String ad) {
    this.ad = ad;
    this.yemekler = new ArrayList<>();
    this.icecekler = new ArrayList<>();
    this.tatlilar = new ArrayList<>();
}

EKLEME METODLARI:
- public void yemekEkle(Yemek yemek) { yemekler.add(yemek); }
- public void icecekEkle(Icecek icecek) { icecekler.add(icecek); }
- public void tatliEkle(Tatli tatli) { tatlilar.add(tatli); }

YAZDIRMA METODU:
public void menuYazdir() {
    System.out.println("\n========== " + ad + " ==========\n");
    
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

TOPLAM FİYAT:
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
```

---

## 8. Siparis Sınıfı (Siparis.java)

```
SINIF: class Siparis
AMAÇ: Müşteri siparişlerini yönetir

IMPORT: import java.util.ArrayList;

ALANLAR (private):
- String musteriAdi
- ArrayList<Yemek> siparisYemekler
- ArrayList<Icecek> siparisIcecekler
- ArrayList<Tatli> siparisTatlilar
- boolean paketServisMi

CONSTRUCTOR:
public Siparis(String musteriAdi, boolean paketServisMi) {
    this.musteriAdi = musteriAdi;
    this.paketServisMi = paketServisMi;
    this.siparisYemekler = new ArrayList<>();
    this.siparisIcecekler = new ArrayList<>();
    this.siparisTatlilar = new ArrayList<>();
}

EKLEME METODLARI:
- public void yemekEkle(Yemek yemek) { siparisYemekler.add(yemek); }
- public void icecekEkle(Icecek icecek) { siparisIcecekler.add(icecek); }
- public void tatliEkle(Tatli tatli) { siparisTatlilar.add(tatli); }

TOPLAM TUTAR:
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
        toplam += 10.0; // Paket ücreti
    }
    
    return toplam;
}

SİPARİŞ ÖZETİ:
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
```

---

## 9. Main Sınıfı (Uygulama.java)

```
SINIF: public class Uygulama

MAIN METODU:
public static void main(String[] args) {
    
    // 1. MENÜ OLUŞTUR
    Menu menu = new Menu("Ana Menü");
    
    // 2. YEMEKLER OLUŞTUR VE EKLE
    Yemek yemek1 = new Yemek("İskender", 80.0, 20, false, false);
    Yemek yemek2 = new Yemek("Vejetaryen Güveç", 50.0, 25, true, true);
    menu.yemekEkle(yemek1);
    menu.yemekEkle(yemek2);
    
    // 3. İÇECEKLER OLUŞTUR VE EKLE
    Icecek icecek1 = new Icecek("Türk Kahvesi", 15.0, 10, false, true);
    Icecek icecek2 = new Icecek("Ayran", 8.0, 2, true, false);
    menu.icecekEkle(icecek1);
    menu.icecekEkle(icecek2);
    
    // 4. TATLILAR OLUŞTUR VE EKLE
    Tatli tatli1 = new Tatli("Sütlaç", 30.0, 15, true, false);
    Tatli tatli2 = new Tatli("Künefe", 45.0, 12, true, true);
    menu.tatliEkle(tatli1);
    menu.tatliEkle(tatli2);
    
    // 5. İNDİRİM UYGULA
    System.out.println("=== İNDİRİM UYGULAMALARI ===");
    yemek1.indirimUygula(0.15); // %15 indirim
    System.out.println(yemek1.getAd() + " için %15 indirim uygulandı.");
    icecek2.indirimUygula(0.10); // %10 indirim
    System.out.println(icecek2.getAd() + " için %10 indirim uygulandı.\n");
    
    // 6. ÖZEL HAZIRLIK VE NOTLAR
    System.out.println("=== ÖZEL ÜRÜN BİLGİLERİ ===");
    System.out.println(yemek1.getAd() + " - " + yemek1.ozelNotAl());
    yemek1.ozelHazirlikYap();
    System.out.println();
    
    System.out.println(tatli2.getAd() + " - " + tatli2.ozelNotAl());
    tatli2.ozelHazirlikYap();
    System.out.println();
    
    // 7. MENÜYÜ YAZDIR
    menu.menuYazdir();
    System.out.println("MENÜ TOPLAM FİYATI: " + menu.toplamMenuFiyati() + " TL\n");
    
    // 8. SİPARİŞ OLUŞTUR
    Siparis siparis = new Siparis("Ahmet Yılmaz", false);
    siparis.yemekEkle(yemek1);
    siparis.icecekEkle(icecek1);
    siparis.tatliEkle(tatli2);
    
    // 9. SİPARİŞ ÖZETİNİ YAZDIR
    siparis.siparisOzetiYazdir();
    
    // 10. TOPLAM İÇECEK SAYISI
    System.out.println("\nŞu ana kadar üretilen İçecek sayısı: " + Icecek.getToplamIcecekSayisi());
}
```

---

## PROJE YAPISI

```
Proje/
├── Sabitler.java
├── Urun.java
├── IndirimUygulanabilir.java
├── OzelUrun.java
├── Yemek.java
├── Icecek.java
├── Tatli.java
├── Menu.java
├── Siparis.java
└── Uygulama.java
```

---

## DERLEME VE ÇALIŞTIRMA

```bash
# Tüm dosyaları derle
javac *.java

# Uygulamayı çalıştır
java Uygulama
```

---

## BAŞARI KRİTERLERİ

✅ Final sınıf doğru tanımlanmış (Sabitler)
✅ Abstract sınıf ve metotlar doğru kullanılmış (Urun)
✅ İki arayüz tanımlanmış ve implement edilmiş
✅ Kalıtım doğru uygulanmış (extends Urun)
✅ Polimorfizm çalışıyor (satisFiyatiHesapla her sınıfta farklı)
✅ Kapsülleme uygulanmış (private alanlar, getter/setter)
✅ Static değişken kullanılmış (toplamIcecekSayisi)
✅ ArrayList ile koleksiyonlar yönetiliyor
✅ Program hatasız çalışıyor ve çıktı veriyor
