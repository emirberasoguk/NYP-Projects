# 🚙 Akıllı Otonom Araç Filosu Yönetim Sistemi

Bu proje, Nesne Yönelimli Programlama (OOP) prensiplerini temel alarak geliştirilmiş kapsamlı bir **Otonom Araç Filosu Simülasyonudur**. Java programlama dili kullanılarak geliştirilen sistem, farklı tipteki araçların, modüllerin, personelin ve görevlerin merkezi bir kontrol birimi üzerinden yönetilmesini sağlar.

---

## 🎯 Projenin Amacı ve Kapsamı

Projenin temel amacı, karmaşık bir yazılım mimarisini OOP prensipleriyle (Kalıtım, Kapsülleme, Çok Biçimlilik, Soyutlama) modellemektir. Sistem şunları simüle eder:
*   Farklı yeteneklere sahip araçların (Araba, Kargo Robotu, Drone) yönetimi.
*   Araçlara takılabilir akıllı modüllerin (Navigasyon, Güvenlik, Yapay Zeka) entegrasyonu.
*   Farklı uzmanlıklara sahip personelin (Mühendis, Teknisyen, Yönetici) hiyerarşik yapısı.
*   Görev (Mission) oluşturma, atama ve takip süreçleri.
*   Merkezi yönetim birimi (Fleet Control Center) üzerinden operasyonel işlemler.

---

## 🏗️ Yazılım Mimarisi ve Hiyerarşi

Proje 4 ana kategori altında toplanan 15 sınıftan oluşmaktadır:

### 1. Araç Hiyerarşisi (Vehicle Hierarchy)
Tüm araçlar ortak özelliklerini `Vehicle` sınıfından alır.
*   **Vehicle (Ana Sınıf):** Model, seri no, batarya durumu gibi ortak özellikleri tutar.
*   **Car:** Yolcu kapasitesi özelliğine sahiptir.
*   **CargoBot:** Yük taşıma kapasitesi ve yükleme/boşaltma mekanizmalarına sahiptir.
*   **GroundDrone:** Sensör sayısı ve farklı tarama (scan) modlarına sahiptir.

### 2. Modül Sistemi (Module System)
Araçlara ekstra özellik kazandıran donanım/yazılım parçalarıdır.
*   **Module (Ana Sınıf):** İsim ve versiyon bilgisini tutar.
*   **NavigationModule:** Harita versiyon bilgisini içerir.
*   **SafetyModule:** Risk seviyesi belirler.
*   **AIControlModule:** Yapay zeka modelini yönetir ve günceller.

### 3. Personel Yönetimi (Employee Hierarchy)
Sistemi yöneten insan kaynağını modeller.
*   **Employee (Ana Sınıf):** İsim, e-posta ve ID yönetimi.
*   **Engineer:** Uzmanlık alanı (specialty) belirtilir.
*   **Technician:** Tecrübe yılı ve bakım raporu oluşturma yeteneği vardır.
*   **Manager:** Altında çalışan bir ekibi (Employee listesi) yönetir.

### 4. Operasyonel Sistem (Operational System)
*   **Mission:** Görev tanımı, atanan araçlar ve sorumlu personeli bir araya getirir.
*   **FleetControlCenter:** Tüm sistemi yöneten ana merkezdir. Arama, listeleme ve ekleme işlemleri buradan yapılır.
*   **Main:** Sistemin test edildiği ve senaryoların koşulduğu ana sınıftır.

---

## 🛠️ Kullanılan Teknik Prensipler

Bu projede Java'nın güçlü OOP özellikleri aktif olarak kullanılmıştır:

1.  **Inheritance (Kalıtım):**
    *   `Car`, `CargoBot`, `GroundDrone` sınıfları `Vehicle` sınıfından türer.
    *   `Engineer` vb. sınıflar `Employee` sınıfından türer.
    *   Bu sayede kod tekrarı önlenmiş ve hiyerarşik bir yapı kurulmuştur.

2.  **Encapsulation (Kapsülleme):**
    *   Tüm sınıf değişkenleri `private` olarak tanımlanmıştır.
    *   Veriye erişim kontrollü olarak `Getter` ve `Setter` metotları ile sağlanır (Örn: Batarya seviyesinin 0-100 arasında tutulması).

3.  **Polymorphism (Çok Biçimlilik):**
    *   `getStatus()`, `getInfo()`, `describe()` metotları her alt sınıfta farklı davranışlar sergiler.
    *   `FleetControlCenter` içinde araçlar listelenirken, tek bir döngü ile her aracın kendine özgü durumu yazdırılır.

4.  **Overloading (Aşırı Yükleme):**
    *   Aynı isme sahip metotların farklı parametrelerle kullanılmasıdır.
    *   Örn: `drone.scan()` (basit tarama) vs `drone.scan("thermal")` (modlu tarama).

5.  **Overriding (Ezme):**
    *   Alt sınıfların, üst sınıftan miras aldığı metotları kendi ihtiyaçlarına göre yeniden yazmasıdır.
    *   Örn: `Car` sınıfının `getStatus()` metodunu ezip yolcu sayısını da eklemesi.

---

## 🚀 Nasıl Çalıştırılır?

Proje Linux ortamında terminal üzerinden şu komutlarla derlenip çalıştırılabilir:

1.  **Derleme:**
    ```bash
    javac *.java
    ```
2.  **Çalıştırma:**
    ```bash
    java Main
    ```

Bu proje, modern yazılım geliştirme standartlarına uygun, genişletilebilir ve modüler bir yapıya sahiptir.
