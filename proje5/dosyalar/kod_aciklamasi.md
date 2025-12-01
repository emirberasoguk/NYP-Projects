# 📖 Kod Açıklaması ve Analizi

Bu doküman, "Akıllı Otonom Araç Filosu Yönetim Sistemi" projesindeki tüm Java sınıflarını ve kod bloklarını satır satır ve mantıksal bloklar halinde analiz eder.

---

## 1. BÖLÜM: ARAÇ SINIFLARI (VEHICLE HIERARCHY)

### 📄 Vehicle.java (Ana Sınıf)
Bu sınıf, tüm araçların ortak özelliklerini taşır.

*   **Sınıf Tanımı ve Değişkenler:**
    *   `private String model, serialNumber;`: Aracın kimlik bilgileri. `private` yapılarak dışarıdan doğrudan erişim engellendi (Encapsulation).
    *   `private double batteryLevel;`: Batarya seviyesi.
    *   `private ArrayList<Module> modules;`: Araca takılan modülleri tutan liste.

*   **Constructor (Yapıcı Metotlar):**
    *   `public Vehicle()`: Parametresiz çağrıldığında varsayılan değerler ("Unknown", %100 pil) atar.
    *   `public Vehicle(String model, ...)`: Model ve seri numarasını parametre olarak alır. Pili %100 başlatır ve modül listesini (`new ArrayList<>()`) oluşturur.

*   **Kritik Metotlar:**
    *   `setBatteryLevel(double level)`: Buradaki `if` bloğu, pilin 0'dan küçük veya 100'den büyük olmasını engeller. Bu, veri bütünlüğü için önemlidir.
    *   `charge(double amount)`: `Math.min(100, ...)` fonksiyonu kullanılarak, şarj eklenince 100'ü geçmemesi sağlanır.
    *   `charge()`: Parametresiz versiyon (Overloading). Pili direkt %100 yapar.
    *   `getStatus()`: Aracın temel durumunu String olarak döndürür. Alt sınıflar bunu geliştirecektir.

### 📄 Car.java (Alt Sınıf)
`Vehicle` sınıfından türetilmiştir.

*   **Kalıtım:** `extends Vehicle` ifadesi ile Vehicle'ın tüm özelliklerini miras alır.
*   **Değişkenler:** `passengerCapacity` (yolcu kapasitesi) sadece arabaya özgüdür.
*   **Constructor:** `super(model, serialNumber)` komutu ile önce üst sınıfın (Vehicle) yapıcı metodu çalıştırılır, ardından yolcu kapasitesi atanır.
*   **Polimorfizm:** `@Override getStatus()` metodu, üst sınıfın `super.getStatus()` sonucunu alır ve sonuna ", Passengers: X" ekler.

### 📄 CargoBot.java (Alt Sınıf)
Yük taşıyan robotları temsil eder.

*   **Değişkenler:** `maxLoadKg` (maksimum yük) ve `currentLoad` (mevcut yük).
*   **load(double kg) Metodu:**
    *   Mantıksal kontrol: `if (currentLoad + kg <= maxLoadKg)` satırı ile kapasite aşımı kontrol edilir.
    *   Aşarsa hata mesajı basar, aşmazsa yükü ekler.
*   **unload() Metodu:** `currentLoad` değişkenini 0.0 yapar (yükü boşaltır).

### 📄 GroundDrone.java (Alt Sınıf)
Yerde giden sensörlü drone'ları temsil eder.

*   **Overloading (Aşırı Yükleme) Örneği:**
    *   `scan()`: Parametresizdir, "Basic scan" yazar.
    *   `scan(String mode)`: Parametrelidir, verilen moda göre (örn: "thermal") çıktı verir.
*   **getStatus():** Sensör sayısını da rapora ekler.

---

## 2. BÖLÜM: MODÜL SINIFLARI (MODULE HIERARCHY)

### 📄 Module.java (Ana Sınıf)
Tüm modüllerin atasıdır.

*   **Temel Yapı:** İsim (`name`) ve versiyon (`version`) bilgilerini tutar.
*   **getInfo():** Modülün temel bilgilerini döndüren metottur. Alt sınıflar bunu genişletir.

### 📄 NavigationModule.java
*   **Ek Özellik:** `mapVersion` (harita sürümü).
*   **Constructor:** `super(name, version)` ile temel bilgileri üst sınıfa gönderir.
*   **getInfo():** Harita versiyonunu da çıktıya ekler.

### 📄 SafetyModule.java
*   **Ek Özellik:** `riskLevel` (risk seviyesi, tamsayı).
*   **getInfo():** Risk seviyesini raporlar.

### 📄 AIControlModule.java
*   **Ek Özellik:** `modelName` (Yapay zeka modelinin adı, örn: "GPT-4").
*   **updateModel Metotları (Overloading):**
    *   `updateModel(String newModel)`: Sadece ismi değiştirir.
    *   `updateModel(String newModel, boolean verbose)`: Eğer `verbose` true ise, güncelleme yapıldıktan sonra ekrana bilgi mesajı ("AI Model updated to...") yazdırır.

---

## 3. BÖLÜM: PERSONEL SINIFLARI (EMPLOYEE HIERARCHY)

### 📄 Employee.java (Ana Sınıf)
*   **Constructor Overloading:**
    *   3 parametreli: ID kullanıcı tarafından verilir.
    *   2 parametreli: ID otomatik üretilir (`"EMP" + Math.random()`).
*   **getNormalizedEmail():** E-postayı alır, boşlukları temizler (`trim`) ve küçük harfe çevirir (`toLowerCase`). Veri standardizasyonu sağlar.

### 📄 Engineer.java
*   **Özellik:** `specialty` (Uzmanlık alanı).
*   **describe():** Personel bilgilerine uzmanlık alanını ekler.

### 📄 Technician.java
*   **Özellik:** `experienceYears` (Tecrübe yılı).
*   **MaintenanceReport (Overloading):**
    *   Parametresiz: Sadece rapor oluşturuldu yazar.
    *   `boolean includeTimestamp`: Eğer true ise `new java.util.Date()` kullanarak o anki zamanı rapora ekler.

### 📄 Manager.java
*   **Composition (Has-A İlişkisi):** `ArrayList<Employee> team` değişkeni ile yönetici, diğer çalışanları bünyesinde barındırır.
*   **addTeamMember(Employee e):** Listeye yeni eleman ekler.
*   **describe():** Takımdaki kişi sayısını (`team.size()`) raporlar.

---

## 4. BÖLÜM: SİSTEM SINIFLARI

### 📄 Mission.java (Görev Sistemi)
Bir görevi tanımlayan sınıftır.

*   **Composition:** Hem `ArrayList<Vehicle>` (araçlar) hem de `ArrayList<Employee>` (personel) listelerine sahiptir.
*   **containsKeyword(String keyword):**
    *   `description.toLowerCase().contains(keyword.toLowerCase())`: Görev açıklamasında arama yapar. Büyük/küçük harf duyarlılığını kaldırmak için her iki tarafı da küçük harfe çevirir.

### 📄 FleetControlCenter.java (Yönetim Merkezi)
Tüm sistemi koordine eden sınıftır.

*   **Veri Yapıları:** Araçlar, personel ve görevler için ayrı `ArrayList`'ler tutar.
*   **searchMission(String keyword):**
    *   Görevler listesinde döngü kurar.
    *   `m.containsKeyword(keyword)` true dönerse o görevi sonuç listesine ekler.
*   **listVehiclesByStatus() (Polimorfizm'in Zirvesi):**
    *   `for (Vehicle v : vehicles)` döngüsü ile listedeki her aracı gezer.
    *   `v.getStatus()` çağrıldığında; araç `Car` ise arabanın durumu, `Drone` ise dronun durumu çalışır. Java bunu çalışma zamanında (runtime) belirler.

---

## 5. BÖLÜM: TEST VE ÇALIŞTIRMA (MAIN)

### 📄 Main.java
Uygulamanın giriş noktasıdır. Kod akışı adım adım şöyledir:

1.  **Nesne Oluşturma:** `new` anahtar kelimesi ile Araba, CargoBot ve Drone oluşturulur.
2.  **Modül Entegrasyonu:** Navigasyon, güvenlik ve AI modülleri oluşturulup araçlara `.addModule()` ile eklenir.
3.  **Yük Testi:** `cargo.load()` metodu ile kapasite sınırları test edilir (300kg başarılı, +250kg başarısız olur).
4.  **Drone Testi:** `scan()` metodunun farklı varyasyonları çağrılır.
5.  **Personel ve Takım:** Mühendis ve Teknisyen oluşturulup Yönetici'nin takımına (`mgr.addTeamMember`) eklenir.
6.  **Rapor Testi:** Teknisyenin zaman damgalı rapor özelliği test edilir.
7.  **Görev Oluşturma:** Bir `Mission` nesnesi yaratılır; araçlar ve personel bu göreve atanır.
8.  **Filo Merkezi:** `FleetControlCenter` kurulur ve tüm varlıklar buraya kaydedilir.
9.  **Arama:** "thermal" kelimesi ile görev araması yapılır.
10. **Polimorfik Listeleme:** `center.listVehiclesByStatus()` ile tüm farklı araç tipleri tek komutla listelenir.
11. **Soru-Cevap:** Kodun en altında, projenin teorik altyapısını açıklayan (Inheritance vs Composition, Overloading vs Overriding) yorum satırları bulunur.

Bu `Main` sınıfı, yazılan tüm sınıfların birbiriyle uyumlu çalıştığını kanıtlayan bir senaryoyu icra eder.
