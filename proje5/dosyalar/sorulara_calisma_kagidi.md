Harika bir yolculuğa çıkıyoruz. Bilgisayar mühendisliği öğrencisi olarak Java'nın derinliklerine indiğin bu süreçte, sadece sınavı geçmeni değil, bu kavramları bir mühendis gibi içselleştirmeni sağlayacağım. Aşağıdaki notlar, verdiğin soru havuzundaki (1-60 arası) soruları kapsayacak şekilde, pedagojik bir sırayla hazırlanmıştır.

İşte senin için hazırladığım kapsamlı **Java OOP Ders Notları**:

-----

# JAVA OOP DERS NOTLARI - İLK 60 SORU (SORU HAVUZU ÇÖZÜMLÜ KONU ANLATIMI)

## İÇİNDEKİLER

1.  [BÖLÜM 1: KALITIM (INHERITANCE)](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-1-kal%C4%B1t%C4%B1m-inheritance)
2.  [BÖLÜM 2: ENCAPSULATION (KAPSÜLLEME)](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-2-encapsulation-kaps%C3%BClleme)
3.  [BÖLÜM 3: CONSTRUCTOR VE PAKETLER](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-3-constructor-ve-paketler)
4.  [BÖLÜM 4: METOD KAVRAMI VE OVERLOADING](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-4-metod-kavram%C4%B1-ve-overloading)
5.  [BÖLÜM 5: SINIF VE NESNE](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-5-s%C4%B1n%C4%B1f-ve-nesne)
6.  [BÖLÜM 6: DİZİLER (ARRAYS)](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-6-diziler-arrays)
7.  [BÖLÜM 7: ARRAYLIST VE VECTOR](https://www.google.com/search?q=%23b%C3%B6l%C3%BCm-7-arraylist-ve-vector)

-----

## BÖLÜM 1: KALITIM (INHERITANCE)

*(Soru Havuzu: 1-17)*

### 1.1 Kalıtım Temel Kavramlar

**Kalıtım (Inheritance) Nedir?**
Kalıtım, bir sınıfın (alt sınıf) başka bir sınıfın (üst sınıf) özelliklerini ve davranışlarını devralmasıdır. Biyolojideki anne-babadan geçen genler gibidir.

  * **Amaç:** Kod tekrarını önlemek ve "IS-A" (dır/dir) ilişkisi kurmaktır.
  * **Anahtar Kelime:** `extends` (Genişletir). Java'da bir sınıf **sadece bir** sınıfı `extends` edebilir.

**Gerçek Hayat Analogisi:**
Düşün ki bir "Araç" sınıfın var (Tekerleği var, motoru var). "Otomobil" de bir "Araç"tır. Tekerlek kodunu Otomobil için baştan yazmana gerek yok; Araç'tan miras alırsın.

```mermaid
   Araç (Super Class / Parent)
     ^
     | (extends)
   Otomobil (Sub Class / Child)
```

```java
// Üst Sınıf (Super Class)
class Hayvan {
    void yemekYe() { System.out.println("Yemek yeniyor..."); }
}

// Alt Sınıf (Sub Class)
class Kedi extends Hayvan {
    // yemekYe() metodu buraya gizlice miras geldi!
    void miyavla() { System.out.println("Miyav!"); }
}
```

### 1.2 Kalıtım Mekanikleri

**Super ve Constructor Zinciri:**
Bir alt sınıf nesnesi oluşturulduğunda, **önce üst sınıfın yapıcı metodu (constructor)** çalışmalıdır. Çünkü temel (temel atılmadan bina yapılmaz) önce oluşmalıdır.

  * `super()`: Üst sınıfın constructor'ını çağırır. Alt sınıf constructor'ının **ilk satırında** olmak zorundadır.

**Method Overriding (Metod Ezme):**
Üst sınıftan gelen metodun davranışı alt sınıfa uymuyorsa, onu yeniden yazarız.

  * *Neden?* Her hayvan ses çıkarır ama Kedi "Miyav", Köpek "Hav" der.
  * *Kural:* İsim, dönüş tipi ve parametreler aynı olmalıdır.

<!-- end list -->

```java
class Kopek extends Hayvan {
    @Override // Okunabilirliği artırır ve derleyici kontrolü sağlar
    void sesCikar() {
        super.sesCikar(); // İstersen önce babanın metodunu çağır
        System.out.println("Hav Hav!"); // Sonra kendi işini yap
    }
}
```

**`super` Anahtar Kelimesinin 2 Kullanımı:**

1.  `super.variable` veya `super.method()`: Üst sınıfın üye ve metodlarına erişim.
2.  `super()`: Üst sınıfın constructor'ını çağırma.

### 1.3 Final ve Erişim Kontrolleri

**`final` Anahtar Kelimesi (Son Karar):**

1.  **Değişkenlerde:** Değer bir kere atanır, değiştirilemez (sabit/constant).
2.  **Metotlarda:** Alt sınıf bu metodu **override edemez** (ezemez).
3.  **Sınıflarda:** Bu sınıf **extends edilemez** (kısırlaştırılmış sınıf).

> **Dikkat:** `private` üyeler kalıtımla alt sınıfa geçmez (miras alınmaz). Onlara ulaşmak için üst sınıfın `public` veya `protected` getter/setter metodlarını kullanmalısın.

### 1.4 Tasarım İlkeleri ve `this` vs `super`

**Kalıtım Tasarımı:**
Tasarım her zaman **Genel'den Özelleşmiş'e** doğru gider. (Varlık -\> Canlı -\> Hayvan -\> Kedi).

**`super()` vs `this()` Farkı:**
| Özellik | `this()` | `super()` |
| :--- | :--- | :--- |
| **Anlamı** | Bu sınıftaki başka bir constructor'ı çağırır. | Üst sınıfın constructor'ını çağırır. |
| **Konum** | İlk satırda olmalı. | İlk satırda olmalı. |
| **Birlikte Kullanım** | Aynı constructor içinde ikisi aynı anda bulunamaz\! | - |

-----

### 📝 Bölüm 1 Özet

  * **extends:** Miras alma komutu.
  * **IS-A İlişkisi:** Kalıtımın temel mantığı.
  * **super():** Üst sınıfın inşası için zorunlu çağrı.
  * **Override:** Miras alınan davranışı değiştirme.
  * **final:** Değişmezlik ve kalıtımı engelleme.

### ✅ Kendini Test Et

1.  Bir sınıfın miras alınmasını engellemek için hangi anahtar kelime kullanılır?
2.  `super()` çağrısı constructor'ın 2. satırına yazılırsa ne olur?
3.  `private` metodlar override edilebilir mi?

### ⚠️ Sık Yapılan Hatalar

  * Alt sınıf constructor'ında `super()` çağırmayı unutmak (Java varsayılan olarak parametresiz `super()` ekler ama parametreli varsa hata alırsın).
  * Override ederken metod ismini yanlış yazmak (Bu yüzden her zaman `@Override` annotasyonu kullan\!).

-----

## BÖLÜM 2: ENCAPSULATION (KAPSÜLLEME)

*(Soru Havuzu: 18-27)*

### 2.1 Encapsulation Temel Kavramlar

**Tanım:** Verilerin (değişkenlerin) dış dünyadan saklanması ve bu verilere erişimin kontrollü yöntemlerle (metotlar) sağlanmasıdır. Bir ilacı kapsül içine koymaya benzer; içindeki tozu (veriyi) korursun.

**Information Hiding vs Encapsulation:**

  * **Encapsulation:** Veriyi ve metodu bir arada paketlemek.
  * **Information Hiding:** Bu paketin iç detaylarını (private yaparak) gizlemek.

### 2.2 Getter ve Setter Metodları

Neden değişkeni `public` yapıp doğrudan erişmiyoruz?
Çünkü kontrolü kaybederiz\! Setter metodları **veri doğrulama (validation)** yapmamızı sağlar.

```java
class Insan {
    private int yas; // Dışarıya kapalı!

    // Getter: Okuma izni
    public int getYas() {
        return yas;
    }

    // Setter: Yazma izni (Kontrollü)
    public void setYas(int yas) {
        if (yas < 0) {
            System.out.println("Hata: Yaş negatif olamaz!");
            return;
        }
        this.yas = yas;
    }
}
```

**Özel Durumlar:**

  * **Read-Only (Sadece Okunur):** Sadece `getter` yazarsın, `setter` yazmazsın.
  * **Write-Only (Sadece Yazılır):** Nadirdir, sadece `setter` yazarsın.

### 2.3 Güvenlik ve Kontrol

Encapsulation olmadan, `nesne.yas = -500;` kodu çalışırdı ve nesnenin durumu (state) bozulurdu. Kapsülleme, nesnenin her zaman geçerli ve tutarlı bir durumda kalmasını garanti eder.

> **İpucu:** Her değişkene körü körüne getter/setter yazma. Eğer bir değişkenin dışarıdan değişmesi gerekmiyorsa, setter yazma.

-----

### 📝 Bölüm 2 Özet

  * **private:** Değişkenleri gizle.
  * **public getter/setter:** Erişimi yönet.
  * **Kontrol:** Setter içinde `if` kontrolleri ile hatalı veri girişini engelle.

### ✅ Kendini Test Et

1.  Setter metodu olmadan bir değişkene nasıl değer atanabilir? (İpucu: Constructor)
2.  Bir değişkeni `private` yapıp hiçbir metod yazmazsak ne olur?

-----

## BÖLÜM 3: CONSTRUCTOR VE PAKETLER

*(Soru Havuzu: 28-29)*

### 3.1 Constructor (Yapıcı Metod)

Sınıftan bir nesne üretildiğinde (`new` anahtar kelimesi ile) **otomatik olarak çalışan** ilk metottur.

**3 Temel Özellik:**

1.  **İsim:** Sınıf ismiyle **birebir aynı** olmalıdır (Büyük/küçük harf dahil).
2.  **Dönüş Tipi:** `void` dahil hiçbir dönüş tipi **yoktur**.
3.  **Amaç:** Nesnenin başlangıç değerlerini (field'ları) atamak.

**Default Constructor:** Sen hiç constructor yazmazsan, Java senin yerine parametresiz, içi boş bir tane (`public SinifAdi() {}`) oluşturur. Ama sen parametreli bir tane yazarsan, Java bu otomatik kıyağı iptal eder.

### 3.2 Paket Yönetimi

**Paket (Package) Nedir?**
Sınıfları gruplamak için kullanılan klasör yapısıdır.

  * `package com.okul.ogrenci;` -\> Dosyanın kimliği.
  * `import java.util.Scanner;` -\> Başka paketteki sınıfı kullanma izni.

**Neden Gerekli?**

1.  Düzen sağlar.
2.  İsim çakışmalarını önler (İki farklı kişi `Date` sınıfı yazabilir ama paketleri farklı olur).

-----

## BÖLÜM 4: METOD KAVRAMI VE OVERLOADING

*(Soru Havuzu: 30-35)*

### 4.1 Metod Yapısı

Bir metodun anatomisi:
`public static int topla(int a, int b) { ... }`

1.  **Erişim Belirteci:** (`public`) Kimler çağırabilir?
2.  **Static:** Nesneye mi ait, sınıfa mı?
3.  **Dönüş Tipi:** (`int`) İşlem bitince ne verecek? (Vermeyecekse `void`).
4.  **İsim:** (`topla`) Fiil olmalı.
5.  **Parametreler:** (`int a, int b`) Girdi değerleri.

### 4.2 Method Overloading (Aşırı Yükleme)

**Tanım:** Aynı isme sahip ama **parametre listesi farklı** birden fazla metod yazmaktır.

  * *Örnek:* `System.out.println()`. İçine String de atsan, int de atsan çalışır. Arkada farklı metodlar vardır.

**Metod İmzası (Signature):**
Derleyici metotları şuna göre ayırt eder: **Metod Adı + Parametre Listesi**.

> **Önemli:** Dönüş tipi imzaya dahil **DEĞİLDİR**.
> `int topla(int a, int b)` ile `double topla(int a, int b)` aynı anda OLAMAZ. Derleyici "Hangisini çağırıyorsun?" diye şaşırır.

### 4.3 Static Metodlar

**Static = Sınıfa Ait.**
Nesne oluşturmadan `SinifAdi.methodAdi()` şeklinde çağrılır.

  * *Örnek:* `Math.sqrt(16)`. Karekök almak için bir "Matematik Nesnesi" yaratmana gerek yoktur; bu evrensel bir işlemdir.

**Kritik Kural:** Static bir metodun içinden, static olmayan (instance) bir değişken veya metod **doğrudan çağrılamaz**.

  * *Sebep:* Static metod sınıf yüklendiğinde hafızadadır. Ama instance metodlar `new` ile nesne yaratılınca oluşur. Henüz doğmamış bir çocuğa isim veremezsin\!

-----

### 📝 Bölüm 4 Özet

  * **Overloading:** Aynı isim, farklı parametreler.
  * **İmza:** İsim + Parametreler (Dönüş tipi hariç).
  * **Static:** Nesneden bağımsız, sınıf üzerinden erişim.

-----

## BÖLÜM 5: SINIF VE NESNE

*(Soru Havuzu: 36-43)*

### 5.1 Class vs Object

  * **Class (Sınıf):** Taslak, kalıp, blueprint. (Ör: Mimari ev çizimi).
  * **Object (Nesne):** O kalıptan çıkan somut ürün. (Ör: O çizimden yapılan 34 numaralı bina).

`Araba benimArabam = new Araba();`

  * `Araba`: Sınıf (Tip).
  * `benimArabam`: Referans (Kumanda).
  * `new Araba()`: Heap bellekte oluşan gerçek nesne.

### 5.2 Erişim Belirleyiciler (Access Modifiers)

| Belirleyici | Sınıf İçi | Aynı Paket | Alt Sınıf | Her Yer |
| :--- | :---: | :---: | :---: | :---: |
| **public** | ✅ | ✅ | ✅ | ✅ |
| **protected** | ✅ | ✅ | ✅ | ❌ |
| *(default)* | ✅ | ✅ | ❌ | ❌ |
| **private** | ✅ | ❌ | ❌ | ❌ |

### 5.3 Constructor Çeşitliliği (Overloading)

Aynı sınıfta birden fazla constructor olabilir. Bu, nesneyi farklı şekillerde başlatma esnekliği sunar.

```java
// Sadece isimle yarat
Ogrenci o1 = new Ogrenci("Ali");
// İsim ve yaşla yarat
Ogrenci o2 = new Ogrenci("Veli", 21);
```

-----

## BÖLÜM 6: DİZİLER (ARRAYS)

*(Soru Havuzu: 44-53)*

### 6.1 Dizi Temelleri

Aynı türden verileri yan yana kutucuklarda tutar.

  * **Özellik:** Boyutu **sabittir**. Oluşturulduktan sonra değiştirilemez.
  * **Bellek:** Heap bölgesinde blok halinde tutulur. Hızlı erişim sağlar.

### 6.2 Dizi İşlemleri ve Selection Sort

**Selection Sort (Seçmeli Sıralama) Mantığı:**
"Diziyi tara, en küçüğü bul, en başa koy." Sonra kalan kısım için aynısını yap.

  * *Swap (Takas):* İki değişkenin yerini değiştirmek için **geçici (temp)** bir değişkene ihtiyaç vardır.
    ```java
    temp = a;
    a = b;
    b = temp;
    ```

### 6.3 Çok Boyutlu Diziler

Excel tablosu gibi düşün: Satırlar ve Sütunlar. `int[][] matris = new int[3][5];` (3 satır, 5 sütun).

**Ragged Array (Düzensiz Dizi):**
Her satırın uzunluğu farklı olabilir.

```
[ ] [ ] [ ]       (Satır 0: 3 eleman)
[ ] [ ] [ ] [ ] [ ] (Satır 1: 5 eleman)
[ ]               (Satır 2: 1 eleman)
```

Bu esneklik belleği verimli kullanmayı sağlar (boş kutular yaratmazsın).

**Hata Yönetimi:**
`dizi[10]` boyutluysa, `dizi[10]` veya `dizi[-1]` çağırmak `ArrayIndexOutOfBoundsException` hatası verir. İndeksler `0` ile `length-1` arasındadır.

-----

## BÖLÜM 7: ARRAYLIST VE VECTOR

*(Soru Havuzu: 54-60)*

### 7.1 ArrayList

Dizilerin "süper güçlendirilmiş" halidir.

  * **Dinamik Boyut:** Boyut vermene gerek yok, ekledikçe büyür, sildikçe küçülür.
  * **Sadece Nesne:** `int` tutamaz, `Integer` (Wrapper class) tutar.

**Mantıksal Boyut vs Kapasite:**
Sen 3 eleman eklersin (`size` = 3), ama o arkada 10'luk yer ayırmış olabilir (`capacity` = 10). Doldukça kapasiteyi (genelde %50 veya 2 katı) artırır. Bu büyüme işlemi maliyetlidir (eski diziyi kopyala, yeniye taşı).

### 7.2 Vector

ArrayList'in "eski toprak" abisidir.

  * **Farkı:** `Synchronized` (Senkronize) çalışır. Yani aynı anda birden fazla Thread (iş parçacığı) girerse sıraya sokar, veri bozulmaz. Ama bu yüzden ArrayList'ten **daha yavaştır**.
  * Günümüzde özel durumlar dışında genelde `ArrayList` tercih edilir.

### 7.3 Array vs ArrayList Seçimi

| Durum | Tercih |
| :--- | :--- |
| Boyut baştan belliyse | **Array** (Daha hızlı, az bellek) |
| Çok sık ekleme/çıkarma yapılacaksa | **ArrayList** |
| İlkel tipler (int, double) kullanılacaksa | **Array** (Wrapper masrafı yok) |
| Thread güvenliği şartsa | **Vector** (veya `Collections.synchronizedList`) |

-----

### 📝 Genel Tekrar ve Çalışma Stratejisi

Bu notlar, temel OOP kavramlarını, kalıtımın mantığını ve bellek yönetimini anlaman için tasarlandı. Sınavda başarılı olmak için:

1.  **Kod Yaz:** Örnekleri sadece okuma, IDE'de yaz ve değiştir.
2.  **Hata Yap:** Private bir değişkene main metodundan erişmeye çalış ve hatayı gör.
3.  **Çiz:** Nesne referanslarını ve miras ağaçlarını kağıda çizerek çalış.

Başarılar dilerim Mühendis Adayı\! 🚀
