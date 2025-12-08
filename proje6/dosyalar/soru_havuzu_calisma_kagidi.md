Harika, verilen soru listesini ve ders notlarını analiz ettim. Bu sorular Java'nın temel taşı olan OOP (Nesneye Yönelimli Programlama) kavramlarının "neden" ve "nasıl"ına odaklanıyor. Sadece kod yazmayı değil, tasarım yapmayı da ölçen sorular bunlar.

Aşağıda, bu soruların tamamını kapsayacak şekilde hazırladığım **Java ve OOP Sınav Hazırlık Notları** yer almaktadır.

---

# 📚 JAVA ve OOP ÇALIŞMA NOTLARI

Bu notlar, verilen soru bankasındaki 47 soruyu cevaplayabilmen için **Kalıtım, Arayüzler, Soyutlama, Kapsülleme ve Metotlar** başlıkları altında toplanmıştır.

---

# 1. INTERFACE (ARAYÜZ) & ABSTRACT CLASS (SOYUT SINIF)

Bu bölüm, soru listesindeki 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ve 13. soruları kapsar.

## 🎯 Nedir?

* **Interface (Arayüz):** Bir sınıfın "ne yapabileceğini" (becerilerini) belirtir ama "nasıl yapacağını" söylemez. Sadece method imzalarını barındırır.
* **Abstract Class (Soyut Sınıf):** Ortak özellikleri olan sınıflar için bir "çatı" görevi görür. Hem soyut (gövdesiz) hem somut (gövdeli) metodlar içerebilir.

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
