---

# 📚 JAVA ve OOP İLERİ SEVİYE ÇALIŞMA NOTLARI

## 1. SOYUTLAMA (ABSTRACTION) VE ARAYÜZLER (INTERFACES)

Bu bölüm; **Abstract Class** ve **Interface** arasındaki ince mimari farkları soran 1-13 arası soruları detaylandırır.

### 🎯 Interface (Arayüz) Derinlemesine Analiz
Kaynak: [1], [2], [3], [4]

*   **Tanım:** Bir sınıfın *ne yapabileceğini* (capabilities) belirten, sadece metod imzalarını içeren bir şablondur. "Is-A" (nedir) değil, "Can-Do" (ne yapabilir) ilişkisidir.
*   **Değişkenlerin Durumu (Soru 2):** Interface içindeki tüm değişkenler varsayılan olarak **`public static final`**'dır.
    *   **Neden?** Interface'ler birer "davranış sözleşmesi"dir, durum (state) tutmazlar. Bu yüzden değişkenler ancak "evrensel sabitler" olabilir (Örn: `Math.PI` gibi).
*   **Çoklu Kalıtım Alternatifi (Soru 4, 7):** Java'da bir sınıfın birden fazla babası (superclass) olamaz (Diamond Problemi yüzünden). Ancak bir sınıf birden fazla Interface'i `implements` edebilir. Bu sayede "Çoklu Kalıtım" yeteneği simüle edilir.

### 🎯 Abstract Class (Soyut Sınıf) Derinlemesine Analiz
Kaynak: [5], [6], [7], [8]

*   **Tanım:** "Is-A" ilişkisi kurar. Ortak özellikleri olan sınıfların atasıdır. Hem soyut (gövdesiz) hem somut (iş yapan) metodlar barındırabilir.
*   **Neden Constructor'ı Vardır? (Soru 11):** Abstract sınıftan nesne üretilemese de, **yapıcı metodu (constructor) vardır**.
    *   **Teknik Neden:** Abstract sınıf içinde `private` değişkenler olabilir. Alt sınıflar (subclass) bu private değişkenlere doğrudan erişemez. Bu değişkenlerin ilk değerini atamak için abstract sınıfın constructor'ı çalışmalıdır. Alt sınıf `super()` ile bu yapıcıyı çağırır [8].
*   **Neden Nesne Üretilemez? (Soru 5):** Çünkü içinde henüz kodlanmamış (`abstract`) metodlar olabilir. Java, "nasıl çalışacağı belli olmayan" bir metodu çağırma riskini almaz.

### 🔄 Kritik Karşılaştırma: Abstract Class vs Interface (Soru 1, 3)

| Özellik | Interface (Arayüz) | Abstract Class (Soyut Sınıf) |
| :--- | :--- | :--- |
| **İlişki Türü** | "Yetenek" kazandırır (Can-Do). | "Öz/Soy" belirtir (Is-A). |
| **Metod Gövdesi** | Genelde yoktur (Java 8+ hariç hepsi soyuttur). | Hem soyut hem gövdeli metod olabilir. |
| **Değişkenler** | Sadece `public static final` (Sabit). | Her türlü (`private`, `int` vb.) olabilir (State tutar). |
| **Kalıtım Sayısı** | Sınırsız sayıda `implements` edilebilir. | Sadece 1 tane `extends` edilebilir. |
| **Kullanım Yeri** | Farklı hiyerarşideki sınıflar ortak bir iş yapacaksa (Örn: `Yuzebilir`). | Sınıflar birbirinin türeviyse ve kod paylaşacaksa (Örn: `Personel` -> `Mudur`). |

### 🛠 Tasarım Örneği (Soru 3 - Ödeme Sistemleri)
*   **Senaryo:** Kredi Kartı, Havale, Kripto Para.
*   **Tasarım:**
    *   `OdemeYontemi` (Interface): Çünkü hepsi "ödeme yapar" ama birbirleriyle akraba olmak zorunda değildir.
    *   `BaseBankPayment` (Abstract Class): Sadece banka tabanlılar (Kredi Kartı, Havale) için ortak güvenlik kodlarını (method gövdesi) tutmak için kullanılır. Kripto bunu extend etmez.

---

## 2. KALITIM (INHERITANCE) VE MİMARİ

Bu bölüm; **Extends**, **Super**, **Override** ve **Diamond Problemi**ni içeren 15-31 arası soruları detaylandırır.

### 🎯 Temel Kavramlar
Kaynak: [9], [10], [11], [12]

*   **extends:** Bir sınıfı genişleterek özelliklerini miras almayı sağlar.
*   **super:** Üst sınıfa (parent) erişim anahtarıdır.
    *   `super()`: Üst sınıfın constructor'ını çağırır. **Metodun en üstünde olmalıdır**.
    *   `super.metodAdi()`: Override edilmiş bir metodun orijinal (üstteki) halini çağırır [12].
*   **Diamond Problemi (Soru 10):** Bir sınıfın iki farklı sınıfı extend etmesi durumunda (Çoklu Kalıtım), eğer iki üst sınıfta da aynı isimde metod varsa, hangisinin çalışacağı belirsizdir. Java bu yüzden sınıf bazlı çoklu kalıtımı yasaklar, bunu Interface ile çözer [13].

### 🎯 Constructor Zinciri (Soru 18, 26)
Kaynak: [14], [15]

*   Bir alt sınıf nesnesi oluşturulduğunda (`new`), önce en üstteki atanın (Object), sonra babanın, en son kendisinin constructor'ı çalışır.
*   **super() vs this() (Soru 26):**
    *   `super()`: Üst sınıfın yapıcısını çağırır.
    *   `this()`: Aynı sınıf içindeki başka bir yapıcıyı çağırır (Constructor overloading durumunda kullanılır).
    *   **Kural:** İkisi aynı anda bir constructor içinde kullanılamaz, çünkü ikisi de ilk satırda olmak ister.

### 🎯 Overriding (Üzerine Yazma) (Soru 20, 24, 25)
Kaynak: [16], [17]

*   **Nedir?** Üst sınıftan gelen bir metodun, alt sınıfta **aynı isim, aynı parametre ve aynı dönüş tipi** ile yeniden yazılmasıdır.
*   **Neden Yapılır?** "Genel sınıftan özelleşmiş sınıfa doğru genişleme" (Soru 25) ilkesi gereği.
    *   *Örnek:* `Hayvan` sınıfında `hareketEt()` geneldir. `Yılan` sınıfı bunu `surunerekHareketEt()` şeklinde özelleştirmek zorundadır.
*   **Özelleşmiş Genişleme (Soru 25):** Alt sınıfın, üst sınıftaki yetenekleri alıp, üzerine kendine has yeni metodlar (`tırmanmaVitesi` gibi) eklemesidir [10].

### 🎯 Final Anahtar Kelimesi (Soru 14, 22, 23)
Kaynak: [18], [19], [20]

OOP tasarımında kısıtlama getirmek için kullanılır:
1.  **Değişkende:** Değer bir kez atanır, bir daha değiştirilemez (Sabit/Constant).
2.  **Metodda:** Alt sınıflar bu metodu **Override edemez**. (Algoritma güvenliği için).
3.  **Sınıfta:** Bu sınıf **miras alınamaz** (`extends` edilemez). (Örn: String sınıfı).

---

## 3. KAPSÜLLEME (ENCAPSULATION)

Bu bölüm; **Private**, **Getter/Setter** ve **Bilgi Saklama**yı içeren 32-41 arası soruları detaylandırır.

### 🎯 Bilgi Saklama (Information Hiding) vs Kapsülleme (Soru 33)
Kaynak: [8], [21]

*   **Encapsulation (Kapsülleme):** Veriyi (field) ve bu veriyi işleyen metodları tek bir paket (class) içinde toplamak ve veriyi dışarıdan korumaktır.
*   **Information Hiding (Bilgi Saklama):** Kapsüllemenin *sonucudur*. Sınıfın iç detaylarının (`private` field) dış dünyadan gizlenmesidir. Dışarısı sadece `public` metodları (arayüzü) görür, içeride ne olduğunu bilmez.

### 🎯 Getter ve Setter Mantığı (Soru 35, 36, 40)
*   **Amaç:** Kontrolsüz veri girişini engellemek.
*   **Örnek (Soru 36):** `setAge(int age)` metodunda `if (age < 0)` kontrolü yaparak negatif değer atanması engellenir. Değişken `public` olsaydı `age = -5` yazılabilirdi ve engelleyemezdik.
*   **Setter Olmadan (Soru 40):** Sadece `getter` yazarsak, o sınıf **Immutable (Değişmez)** olur. Nesne bir kere oluşur ve verisi asla değiştirilemez. Bu, güvenli programlamada (Thread safety) çok önemlidir.

---

## 4. METOTLAR VE AKIŞ KONTROLÜ

Bu bölüm; **Method Signature**, **Overloading** ve **Call Stack** içeren 42-47 arası soruları detaylandırır.

### 🎯 Metot Bildirimi (Declaration) Parçaları (Soru 44)
Kaynak: [22], [23]

Örnek Header: `public static int min(int num1, int num2)`

1.  **Erişim Belirteci (public):** Kimler çağırabilir? (Public = herkes).
2.  **static:** Nesne üretmeden sınıf ismiyle çağrılabilir (Örn: `Math.min()`).
3.  **Dönüş Tipi (int):** İşlem bitince geriye ne verecek? (Void ise bir şey vermez).
4.  **Metod Adı (min):** Çağırmak için kullanılan isim.
5.  **Parametre Listesi (int num1...):** Çalışmak için ihtiyaç duyduğu girdiler (Formal arguments).

### 🎯 Metot İmzası (Signature) (Soru 47)
Kaynak: [24]

*   **İmza Şunları İçerir:** Metod Adı + Parametre Listesi (Tipleri ve Sırası).
*   **İmza Şunları İÇERMEZ:** **Dönüş Tipi (Return Type)**.
*   *Önemli:* `int topla(int a, int b)` ile `double topla(int a, int b)` aynı sınıfta bulunamaz. Java bunları ayırt edemez çünkü imzaları (isim+parametre) aynıdır.

### 🎯 Overloading (Aşırı Yükleme) (Soru 46)
Kaynak: [25], [24]

*   **Nedir?** Aynı isimde fakat farklı parametre listesine sahip metodlar yazmaktır.
*   **Fayda:** Okunabilirlik ve kullanım kolaylığı.
*   *Örnek:* `println(String s)` ve `println(int i)`. Geliştirici her veri tipi için `printInt`, `printString` diye ayrı metod isimleri ezberlemek zorunda kalmaz.

### 🎯 Akış Kontrolü (Control Flow) (Soru 45)
Kaynak: [25]

*   Bir metod (`main`), başka bir metodu (`min`) çağırdığında:
    1.  `main` metodu hafızada durur (pause).
    2.  Kontrol `min` metoduna geçer.
    3.  `min` işini bitirip `return` edene kadar `main` bekler.
    4.  `min` biter, stack'ten silinir, kontrol tekrar `main`'e kaldığı yerden döner.

---

## ✅ PRATİK SINAV İPUÇLARI (ÖZET)

1.  **"Interface içinde metod gövdesi olur mu?"** sorusuna "Java 8 öncesi hayır, Interface tamamen soyuttur. Abstract class'ta ise gövdeli metod olabilir" diyerek farkı belirtin [1].
2.  **"Final metod override edilir mi?"** sorusuna kesinlikle **HAYIR** deyin. "Final sınıf miras alınır mı?" sorusuna **HAYIR** deyin [20].
3.  **"Constructor bir metod mudur?"** Evet ama özel bir metottur; **dönüş tipi (void dahil) yoktur** ve sınıf ismiyle aynı olmak zorundadır [21].
4.  **"Polymorphism nedir?"** sorusu gelirse: Üst sınıf referansının (Örn: `Hayvan`), alt sınıf nesnesini (Örn: `Kopek`) tutabilmesi ve `sesCikar()` dendiğinde Köpeğin metodunun çalışmasıdır (Dynamic Binding) [17].

Bu notlar, kaynaklarınızdaki akademik tanımları soru bankanızdaki pratik problemlerle birleştirerek hazırlanmıştır. Başarılar!* **Abstract Class (Soyut Sınıf):** Ortak özellikleri olan sınıflar için bir "çatı" görevi görür. Hem soyut (gövdesiz) hem somut (gövdeli) metodlar içerebilir.

## 💡 Neden Kullanılır?

* **Standart Oluşturmak (Interface):** Farklı sınıfların aynı metod isimlerini kullanmasını garanti altına almak için (Örn: `USB` girişine takılan her şeyin `connect()` metodu olmalıdır).
* **Kod Tekrarını Önlemek (Abstract):** Alt sınıflarda ortak olan kodları tek bir yerde yazmak için (Örn: Tüm `Sekil`lerin rengi vardır, bunu her sınıfta tekrar yazmaya gerek yok).
* **Çoklu Kalıtım Eksiğini Kapatmak:** Java'da bir sınıf sadece bir sınıfı `extend` edebilir ama birden fazla interface'i `implement` edebilir,.

## 📝 Nasıl Kullanılır?

### Sözdizimi (Syntax)

```java
// INTERFACE
// Değişkenler varsayılan olarak: public static final (sabit)
// Metodlar varsayılan olarak: public abstract (gövdesiz)
interface OdemeYontemi {
    double VERGI_ORANI = 0.18; // public static final
    void ode(double miktar);   // Gövdesiz method
}

// ABSTRACT CLASS
// 'abstract' kelimesi zorunludur.
// Hem gövdeli hem gövdesiz method olabilir.
abstract class Calisan {
    String isim; // Normal değişken olabilir

    // Constructor (Nesne üretilemez ama alt sınıf super() ile çağırır)
    public Calisan(String isim) { 
        this.isim = isim;
    }

    // Gövdeli method (Ortak iş)
    void girisYap() { 
        System.out.println("Kart okutuldu."); 
    }

    // Gövdesiz (Abstract) method (Alt sınıf doldurmak ZORUNDA)
    abstract double maasHesapla(); 
}
```

## ⚠️ Kritik Noktalar & Sınav Tüyoları

* **Nesne Üretimi:** Soyut sınıflardan ve Interface'lerden **nesne üretilemez** (`new AbstractClass()` ❌). Çünkü içlerinde tamamlanmamış (soyut) metodlar olabilir, Java yarım kalan bir işi çalıştıramaz.
* **Constructor:** Abstract class'ın constructor'ı vardır (alt sınıflar `super()` ile ortak alanları set etsin diye). Interface'in constructor'ı **yoktur**,.
* **Zorunluluk:** Bir sınıf abstract bir sınıfı extend ederse, onun tüm `abstract` metodlarını **Override etmek (ezmek)** zorundadır. Etmezse o sınıf da abstract olmak zorundadır.

## 🔄 Karşılaştırma (Soru 1 ve 3 için)

| Özellik | Interface (Arayüz) | Abstract Class (Soyut Sınıf) |
| :--- | :--- | :--- |
| **Kullanım Amacı** | Bir "yetenek" veya "sözleşme" kazandırmak (Can-Do). | Ortak özellikleri gruplamak, "özü" tanımlamak (Is-A). |
| **Çoklu Kullanım** | Bir sınıf **birden fazla** interface implement edebilir. | Bir sınıf **sadece 1** abstract class extend edebilir. |
| **Değişkenler** | Sadece `public static final` (sabit). | Her türlü değişken (`private`, `int` vb.) olabilir. |
| **Constructor** | Yoktur. | Vardır (alt sınıflar için). |
| **Hız** | Teorik olarak biraz daha yavaştır (lookup). | Daha hızlıdır. |

---

# 2. INHERITANCE (KALITIM)

Bu bölüm, soru listesindeki 15, 16, 17, 18, 19, 20, 21, 24, 25, 26, 27, 29, 30 ve 31. soruları kapsar.

## 🎯 Nedir?

Bir sınıfın (Subclass/Child), başka bir sınıfın (Superclass/Parent) özelliklerini ve metodlarını miras almasıdır. "IS-A" (dır/dir) ilişkisidir. (Örn: Yarış Bisikleti bir Bisiklettir).

## 💡 Neden Kullanılır?

* **Kod Tekrarını Azaltmak (Reuse):** Ortak kodları üst sınıfa yazıp her yerde kullanmak.
* **Bakım Kolaylığı:** Hatayı sadece üst sınıfta düzeltirsiniz, her yere yansır.
* **Genişletilebilirlik:** Mevcut kodu bozmadan yeni özellikler eklemek.

## 📝 Nasıl Kullanılır?

Anahtar kelime: **`extends`**.

```java
// Üst Sınıf (Super Class)
class Hayvan {
    void sesCikar() {
        System.out.println("Ses...");
    }
}

// Alt Sınıf (Sub Class)
class Kopek extends Hayvan {
    // Override: Üstteki metodu kendine göre değiştirme
    @Override
    void sesCikar() {
        System.out.println("Hav Hav");
    }
    
    void kuyrukSalla() { // Genişleme (Extension)
        System.out.println("Mutlu.");
    }
}
```

## ⚠️ Dikkat Edilecekler

* **Diamond Problemi:** Java'da **çoklu kalıtım yoktur** (bir sınıf iki babaya sahip olamaz). Çünkü iki baba da aynı isimde metoda sahipse hangisinin çalışacağı belirsizdir. Bu yüzden "extends" tek, "implements" çokludur.
* **super() vs this():**
  * `super()`: Üst sınıfın yapıcısını (constructor) çağırır. Metodun **ilk satırında** olmalıdır.
  * `this()`: Aynı sınıf içindeki başka bir yapıcıyı çağırır.
  * `super.metodAdi()`: Üst sınıfın metodunu çağırır (override edilmiş olsa bile orjinalini çağırır).

## 🔄 Özel Durumlar

* **Private Üyeler:** Alt sınıf, üst sınıfın `private` değişkenlerini miras alır ama **doğrudan erişemez**. Erişim için `public/protected` getter-setter metodları kullanmalıdır.
* **Genişleme:** Alt sınıf, üst sınıftan aldıklarının üzerine yeni metodlar eklerse buna "özelleşmiş sınıfa doğru genişleme" denir.

---

# 3. ENCAPSULATION (KAPSÜLLEME)

Bu bölüm, soru listesindeki 12, 28, 32, 33, 34, 35, 36, 37, 38, 39, 40 ve 41. soruları kapsar.

## 🎯 Nedir?

Verilerin (field) dış dünyadan saklanması ve bu verilere erişimin kontrollü bir şekilde (metodlar aracılığıyla) açılmasıdır.

## 💡 Neden Kullanılır?

* **Kontrol ve Güvenlik:** `setAge(-5)` gibi mantıksız değer atamalarını engellemek.
* **Information Hiding (Bilgi Saklama):** Sınıfın iç işleyişini gizleyip sadece sonucu göstermek. Kapsülleme, bilgi saklamayı uygulamanın bir yoludur (Soru 33).

## 📝 Nasıl Kullanılır?

1. Değişkenleri `private` yap.
2. Erişim için `public` **Getter** (okuma) ve **Setter** (yazma) metodları yaz.

```java
class Insan {
    private int yas; // Dışarıdan doğrudan erişilemez (Information Hiding)

    // Getter
    public int getYas() {
        return yas;
    }

    // Setter - Kontrol buradadır
    public void setYas(int yas) {
        if (yas < 0) {
            System.out.println("Yaş negatif olamaz!");
        } else {
            this.yas = yas;
        }
    }
}
```

### Setter Olmadan Kapsülleme Olur mu?

Evet. Sadece `getter` yazarsanız **Read-Only (Sadece okunabilir)**, değişmez (immutable) bir sınıf yapmış olursunuz. Bu da kapsüllemenin bir parçasıdır (Soru 40).

---

# 4. FINAL ANAHTAR KELİMESİ

Bu bölüm, soru listesindeki 14, 22 ve 23. soruları kapsar.

`final` kelimesi nerede kullanıldığına göre anlam değiştirir,,:

1. **Değişkende:** Değeri **sabit** olur, bir kez atandıktan sonra değiştirilemez (`final double PI = 3.14`).
2. **Metodda:** Alt sınıflar bu metodu **Override edemez** (değiştiremez). Güvenlik veya algoritmanın bozulmaması için kullanılır.
3. **Sınıfta:** Bu sınıf **miras alınamaz** (`extends` edilemez). Örn: `String` sınıfı final'dır. (Soru 22: Kalıtımı engellemek için kullanılır).

---

# 5. CONSTRUCTOR (YAPICI METOD)

Bu bölüm, soru listesindeki 11, 18, 26 ve 42. soruları kapsar.

## 🎯 Nedir?

Nesne `new` anahtar kelimesiyle oluşturulduğu anda çalışan özel metottur.

## ⚠️ Kurallar

* İsmi sınıf ismiyle **aynı** olmalıdır.
* **Geri dönüş tipi (void, int vs.) yoktur.** Olursa normal metod olur.
* Her sınıfın en az 1 constructor'ı vardır (yazmazsanız Java boş bir tane ekler: Default Constructor).
* **Constructor Zinciri:** Alt sınıf nesnesi oluşurken önce en üst sınıfın (Object), sonra babanın, en son kendisinin yapıcısı çalışır.

---

# 6. METOTLAR, OVERLOADING & OVERRIDING

Bu bölüm, soru listesindeki 44, 45, 46 ve 47. soruları kapsar.

## Method İmzası (Signature) Nedir?

Metodun **adı** ve **parametre listesidir** (tipi ve sırası).
⚠️ **Dönüş tipi (Return type) imzaya dahil değildir!** (Soru 47).

## Overloading (Aşırı Yükleme)

* **Nedir?** Aynı isimde ama farklı parametrelerde metod yazmak.
* **Neden?** Kullanım kolaylığı. Örn: `System.out.println()` hem `int`, hem `String`, hem `boolean` basabilir.
* **Kural:** İsim aynı, parametreler (sayısı veya türü) farklı olmalı.

## Control Flow (Akış Kontrolü)

Bir metod başka bir metodu çağırdığında, çağrılan metod bitene kadar çağıran metod bekler (Stack mantığı). `main` -> `metodA` -> `metodB` sırasında çalışır, dönüş tam tersidir.

---

# 7. PAKETLER (PACKAGES)

Bu bölüm, soru listesindeki 43. soruyu kapsar.

* **Nedir?** Sınıfları gruplamak için kullanılan klasör yapısıdır.
* **Dizin İlişkisi:** `tr.edu.kocaeli` paketi bilgisayarda `tr/edu/kocaeli` klasörlerine karşılık gelir.
* **Kullanım:** Başka paketteki sınıfı kullanmak için `import` edilir (Örn: `import java.util.Scanner;`).

---

# ✅ ÖZET KONTROL LİSTESİ (BUNLARI BİLİYOR MUSUN?)

Sınava girmeden önce şu farkları netleştirdiğinden emin ol:

* [ ] **Interface vs Abstract Class:** Biri "yapabilirlik/sözleşme" (implements), diğeri "öz/soy" (extends).
* [ ] **Overloading vs Overriding:** Biri "aynı isim farklı parametre" (static polymorphism), diğeri "aynı isim aynı imza ama farklı gövde" (dynamic polymorphism).
* [ ] **Encapsulation:** Private field + Public Getter/Setter = Güvenli veri.
* [ ] **Polymorphism (Çok Biçimlilik):** Üst sınıf referansı ile alt sınıf nesnesini tutabilmek. (`Hayvan h = new Kopek();`).
* [ ] **Constructor:** Dönüş tipi yok, sınıf ile aynı isimde.
* [ ] **Final:** Değişmez (değişken), ezilemez (metod), kısırdır/türetilemez (sınıf).

Bu notlar verilen görsellerdeki tüm teorik soruları ve kod mantığını kapsamaktadır. Başarılar!
