# Restoran Sipariş ve Menü Yönetim Sistemi - Yapılacaklar Listesi

## 1. SABITLER SINIFI (Sabitler.java)

**Yapılacaklar:**
- [ ] `final` anahtar kelimesiyle sınıf tanımla
- [ ] 3 adet `public static final` sabit tanımla:
  - KDV_ORANI = 0.10
  - SERVIS_UCRETI_ORANI = 0.05
  - MIN_HAZIRLAMA_SURESI = 5
- [ ] `private` constructor yaz (nesne üretilmesin diye)

---

## 2. URUN SOYUT SINIFI (Urun.java)

**Yapılacaklar:**
- [ ] `abstract` anahtar kelimesiyle sınıf tanımla
- [ ] 3 `protected` alan tanımla:
  - String ad
  - double hamFiyat
  - int hazirlamaSuresi
- [ ] Constructor yaz (3 parametreli)
  - hazirlamaSuresi kontrolü yap (MIN_HAZIRLAMA_SURESI'nden küçükse düzelt)
- [ ] 3 getter metodu yaz (getAd, getHamFiyat, getHazirlamaSuresi)
- [ ] setHamFiyat metodunu yaz (negatif kontrolü yap, negatifse 0 yap)
- [ ] urunBilgisiYazdir metodunu yaz (ad, hamFiyat, hazirlamaSuresi yazdır)
- [ ] `abstract` satisFiyatiHesapla metodunu tanımla (gövde yok)
- [ ] `abstract` kategoriAdi metodunu tanımla (gövde yok)

---

## 3. ARAYÜZLER

### 3.1. IndirimUygulanabilir Arayüzü (IndirimUygulanabilir.java)
**Yapılacaklar:**
- [ ] `interface` anahtar kelimesiyle tanımla
- [ ] `void indirimUygula(double oran)` metodu tanımla (gövde yok)

### 3.2. OzelUrun Arayüzü (OzelUrun.java)
**Yapılacaklar:**
- [ ] `interface` anahtar kelimesiyle tanımla
- [ ] `String ozelNotAl()` metodu tanımla (gövde yok)
- [ ] `void ozelHazirlikYap()` metodu tanımla (gövde yok)

---

## 4. YEMEK SINIFI (Yemek.java)

**Yapılacaklar:**
- [ ] `extends Urun` yaz
- [ ] `implements IndirimUygulanabilir, OzelUrun` yaz
- [ ] 2 `private` alan tanımla:
  - boolean vegMi
  - boolean ozelGunYemegiMi
- [ ] Constructor yaz (5 parametreli: ad, hamFiyat, hazirlamaSuresi, vegMi, ozelGunYemegiMi)
  - super() çağrısı yap
  - ozelGunYemegiMi true ise hamFiyat'ı %15 düşür (opsiyonel)
- [ ] `@Override satisFiyatiHesapla()` metodunu yaz:
  - hamFiyat'ı fiyat değişkenine al
  - KDV ekle (fiyat * KDV_ORANI)
  - Servis ücreti ekle (fiyat * SERVIS_UCRETI_ORANI)
  - vegMi true ise +2 TL ekle
  - Sonucu döndür
- [ ] `@Override kategoriAdi()` metodunu yaz (return "Yemek")
- [ ] `@Override indirimUygula(double oran)` metodunu yaz:
  - oran 0-1 arasında mı kontrol et
  - hamFiyat = hamFiyat * (1 - oran) işlemini yap
- [ ] `@Override ozelNotAl()` metodunu yaz (örnek metin döndür)
- [ ] `@Override ozelHazirlikYap()` metodunu yaz (konsola mesaj yaz)

---

## 5. ICECEK SINIFI (Icecek.java)

**Yapılacaklar:**
- [ ] `extends Urun` yaz
- [ ] `implements IndirimUygulanabilir` yaz
- [ ] 3 `private` alan tanımla:
  - boolean sogukMu
  - boolean sekerliMi
  - static int toplamIcecekSayisi = 0
- [ ] Constructor yaz (5 parametreli: ad, hamFiyat, hazirlamaSuresi, sogukMu, sekerliMi)
  - super() çağrısı yap
  - toplamIcecekSayisi'ni 1 artır
- [ ] `@Override satisFiyatiHesapla()` metodunu yaz:
  - hamFiyat'ı fiyat değişkenine al
  - KDV ekle
  - sogukMu false ise (sıcak) +1 TL ekle
  - sekerliMi false ise (şekersiz) -0.5 TL çıkar
  - Sonucu döndür
- [ ] `@Override kategoriAdi()` metodunu yaz (return "İçecek")
- [ ] `@Override indirimUygula(double oran)` metodunu yaz (Yemek'teki gibi)
- [ ] `public static int getToplamIcecekSayisi()` metodunu yaz

---

## 6. TATLI SINIFI (Tatli.java)

**Yapılacaklar:**
- [ ] `extends Urun` yaz
- [ ] `implements OzelUrun` yaz
- [ ] 2 `private` alan tanımla:
  - boolean sutluMu
  - boolean sicakServisMi
- [ ] Constructor yaz (5 parametreli: ad, hamFiyat, hazirlamaSuresi, sutluMu, sicakServisMi)
  - super() çağrısı yap
- [ ] `@Override satisFiyatiHesapla()` metodunu yaz:
  - hamFiyat'ı fiyat değişkenine al
  - KDV ekle
  - sutluMu true ise +2 TL ekle
  - sicakServisMi true ise +1 TL ekle
  - Sonucu döndür
- [ ] `@Override kategoriAdi()` metodunu yaz (return "Tatlı")
- [ ] `@Override ozelNotAl()` metodunu yaz (örnek metin döndür)
- [ ] `@Override ozelHazirlikYap()` metodunu yaz (konsola mesaj yaz)

---

## 7. MENU SINIFI (Menu.java)

**Yapılacaklar:**
- [ ] `private` alanları tanımla:
  - String ad
  - ArrayList<Yemek> yemekler
  - ArrayList<Icecek> icecekler
  - ArrayList<Tatli> tatlilar
- [ ] Constructor yaz (1 parametreli: ad)
  - Tüm ArrayList'leri new ile oluştur
- [ ] `yemekEkle(Yemek yemek)` metodunu yaz
- [ ] `icecekEkle(Icecek icecek)` metodunu yaz
- [ ] `tatliEkle(Tatli tatli)` metodunu yaz
- [ ] `menuYazdir()` metodunu yaz:
  - Her kategori için başlık yazdır
  - Her ürün için: urunBilgisiYazdir(), kategoriAdi(), satisFiyatiHesapla() yazdır
- [ ] `toplamMenuFiyati()` metodunu yaz:
  - 3 listedeki tüm ürünlerin satış fiyatlarını topla
  - Sonucu döndür

---

## 8. SIPARIS SINIFI (Siparis.java)

**Yapılacaklar:**
- [ ] `private` alanları tanımla:
  - String musteriAdi
  - ArrayList<Yemek> siparisYemekler
  - ArrayList<Icecek> siparisIcecekler
  - ArrayList<Tatli> siparisTatlilar
  - boolean paketServisMi
- [ ] Constructor yaz (2 parametreli: musteriAdi, paketServisMi)
  - Tüm ArrayList'leri new ile oluştur
- [ ] `yemekEkle(Yemek yemek)` metodunu yaz
- [ ] `icecekEkle(Icecek icecek)` metodunu yaz
- [ ] `tatliEkle(Tatli tatli)` metodunu yaz
- [ ] `toplamTutarHesapla()` metodunu yaz:
  - 3 listedeki tüm ürünlerin satış fiyatlarını topla
  - paketServisMi true ise +10 TL ekle
  - Sonucu döndür
- [ ] `siparisOzetiYazdir()` metodunu yaz:
  - Müşteri adı yazdır
  - Paket/salon bilgisi yazdır
  - Her kategori için ürünleri ve fiyatları yazdır
  - Toplam tutarı yazdır

---

## 9. MAIN SINIFI (Uygulama.java)

**Yapılacaklar:**
- [ ] `public class Uygulama` tanımla
- [ ] `public static void main(String[] args)` metodu yaz
- [ ] Bir Menu nesnesi oluştur
- [ ] En az 2 Yemek nesnesi oluştur ve menüye ekle
- [ ] En az 2 Icecek nesnesi oluştur ve menüye ekle
- [ ] En az 2 Tatli nesnesi oluştur ve menüye ekle
- [ ] Bazı ürünlere indirimUygula metodu çağır
- [ ] Bazı ürünlere ozelHazirlikYap ve ozelNotAl metotlarını çağır
- [ ] menu.menuYazdir() metodunu çağır
- [ ] menu.toplamMenuFiyati() sonucunu yazdır
- [ ] Bir Siparis nesnesi oluştur
- [ ] Siparişe ürünler ekle (yemekEkle, icecekEkle, tatliEkle)
- [ ] siparis.siparisOzetiYazdir() metodunu çağır
- [ ] Icecek.getToplamIcecekSayisi() sonucunu yazdır

---

## GENEL KONTROL LİSTESİ

- [ ] Tüm sınıflar ayrı .java dosyalarında mı?
- [ ] import java.util.ArrayList; ifadeleri gerekli yerlerde var mı?
- [ ] Tüm abstract metotlar alt sınıflarda override edilmiş mi?
- [ ] Tüm interface metotları implemente edilmiş mi?
- [ ] Getter/setter metotları doğru yazılmış mı?
- [ ] Constructor'larda super() çağrıları yapılmış mı?
- [ ] Fiyat hesaplamaları Sabitler sınıfını kullanıyor mu?
- [ ] Program çalışıyor ve hata vermiyor mu?
