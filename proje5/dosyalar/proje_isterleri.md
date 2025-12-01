# NYP Lab 5 - Akıllı Otonom Araç Filosu Yönetim Sistemi
## Detaylı Yapılacaklar Listesi

---

## 📋 PROJE YAPISI

```
src/
├── Vehicle.java
├── Car.java
├── CargoBot.java
├── GroundDrone.java
├── Module.java
├── NavigationModule.java
├── SafetyModule.java
├── AIControlModule.java
├── Employee.java
├── Engineer.java
├── Technician.java
├── Manager.java
├── Mission.java
├── FleetControlCenter.java
└── Main.java
```

---

## 🔧 ADIM 1: TEMEL ARAÇ SINIFI (Vehicle.java)

### 1.1 Değişkenleri Tanımla
- [ ] `private String model`
- [ ] `private String serialNumber`
- [ ] `private double batteryLevel`
- [ ] `private ArrayList<Module> modules`

### 1.2 Constructor'ları Yaz (Overloading)
- [ ] **Parametresiz constructor**: Tüm değerleri varsayılan olarak ayarla
- [ ] **İki parametreli constructor**: `Vehicle(String model, String serialNumber)`
  - batteryLevel = 100
  - modules = new ArrayList<>()

### 1.3 Getter/Setter Metotları
- [ ] `getModel()`, `setModel()`
- [ ] `getSerialNumber()`, `setSerialNumber()`
- [ ] `getBatteryLevel()`
- [ ] `setBatteryLevel(double level)` → 0-100 arası kontrol yap
- [ ] `getModules()`

### 1.4 Diğer Metotlar
- [ ] `addModule(Module m)` → modules listesine ekle
- [ ] `charge(double amount)` → batteryLevel'a ekle, 100'ü geçmesin
- [ ] `charge()` → batteryLevel'ı 100 yap (overloading)
- [ ] `public String getStatus()` → temel bilgileri döndür

---

## 🚗 ADIM 2: ARAÇ ALT SINIFLARI

### 2.1 Car.java
- [ ] `extends Vehicle` yaz
- [ ] `private int passengerCapacity` ekle
- [ ] Constructor yaz → `super(model, serialNumber)` çağır
- [ ] `getPassengerCapacity()` ve `setPassengerCapacity()` ekle
- [ ] `@Override public String getStatus()` → super.getStatus() + yolcu kapasitesi

### 2.2 CargoBot.java
- [ ] `extends Vehicle` yaz
- [ ] `private double maxLoadKg` ekle
- [ ] `private double currentLoad` ekle
- [ ] Constructor yaz → `super()` çağır
- [ ] `load(double kg)` → limit kontrolü yap, maxLoadKg'ı aşmasın
- [ ] `unload()` → currentLoad = 0
- [ ] Getter/Setter'lar
- [ ] `@Override public String getStatus()` → super + yük bilgisi

### 2.3 GroundDrone.java
- [ ] `extends Vehicle` yaz
- [ ] `private int sensorCount` ekle
- [ ] Constructor yaz → `super()` çağır
- [ ] `scan()` → basit tarama mesajı
- [ ] `scan(String mode)` → mode'a göre özel tarama (overloading)
- [ ] Getter/Setter
- [ ] `@Override public String getStatus()` → super + sensör bilgisi

---

## 💻 ADIM 3: MODÜL HIYERARŞISI

### 3.1 Module.java (Base Class)
- [ ] `private String name`
- [ ] `private String version`
- [ ] Constructor: `Module(String name, String version)`
- [ ] `getName()`, `getVersion()`
- [ ] `public String getInfo()` → name ve version döndür

### 3.2 NavigationModule.java
- [ ] `extends Module` yaz
- [ ] `private String mapVersion` ekle
- [ ] Constructor → `super(name, version)` çağır
- [ ] `getMapVersion()`, `setMapVersion()`
- [ ] `@Override public String getInfo()` → super.getInfo() + mapVersion

### 3.3 SafetyModule.java
- [ ] `extends Module` yaz
- [ ] `private int riskLevel` ekle
- [ ] Constructor → `super()` çağır
- [ ] `getRiskLevel()`, `setRiskLevel()`
- [ ] `@Override public String getInfo()` → super.getInfo() + riskLevel

### 3.4 AIControlModule.java
- [ ] `extends Module` yaz
- [ ] `private String modelName` ekle
- [ ] Constructor → `super()` çağır
- [ ] `getModelName()`, `setModelName()`
- [ ] `updateModel(String newModel)` → modelName güncelle
- [ ] `updateModel(String newModel, boolean verbose)` → verbose ise mesaj yazdır (overloading)
- [ ] `@Override public String getInfo()` → super.getInfo() + modelName

---

## 👥 ADIM 4: PERSONEL HIYERARŞISI

### 4.1 Employee.java (Base Class)
- [ ] `private String name`
- [ ] `private String email`
- [ ] `private String employeeId`
- [ ] Constructor overloading:
  - `Employee(String name, String email, String employeeId)`
  - `Employee(String name, String email)` → employeeId otomatik oluştur
- [ ] Getter/Setter'lar
- [ ] `getNormalizedEmail()` → trim() + toLowerCase()
- [ ] `public String describe()` → temel bilgileri döndür

### 4.2 Engineer.java
- [ ] `extends Employee` yaz
- [ ] `private String specialty` ekle
- [ ] Constructor → `super()` çağır
- [ ] `getSpecialty()`, `setSpecialty()`
- [ ] `@Override public String describe()` → super.describe() + specialty

### 4.3 Technician.java
- [ ] `extends Employee` yaz
- [ ] `private int experienceYears` ekle
- [ ] Constructor → `super()` çağır
- [ ] `getExperienceYears()`, `setExperienceYears()`
- [ ] `maintenanceReport()` → basit rapor
- [ ] `maintenanceReport(boolean includeTimestamp)` → timestamp ekle (overloading)
- [ ] `@Override public String describe()` → super.describe() + tecrübe

### 4.4 Manager.java
- [ ] `extends Employee` yaz
- [ ] `private ArrayList<Employee> team` ekle
- [ ] Constructor → `super()` çağır, team = new ArrayList<>()
- [ ] `addTeamMember(Employee e)` → team'e ekle
- [ ] `getTeam()`
- [ ] `@Override public String describe()` → super.describe() + takım sayısı

---

## 🎯 ADIM 5: GÖREV SISTEMI

### 5.1 Mission.java
- [ ] `private String missionId`
- [ ] `private String description`
- [ ] `private ArrayList<Vehicle> assignedVehicles`
- [ ] `private ArrayList<Employee> responsibleStaff`
- [ ] Constructor: `Mission(String missionId, String description)`
  - Liste'leri initialize et
- [ ] `assignVehicle(Vehicle v)` → assignedVehicles'a ekle
- [ ] `assignEmployee(Employee e)` → responsibleStaff'a ekle
- [ ] `boolean containsKeyword(String keyword)` → description içinde case-insensitive ara
- [ ] Getter metotları

---

## 🏢 ADIM 6: FİLO YÖNETİM MERKEZİ

### 6.1 FleetControlCenter.java
- [ ] `private ArrayList<Vehicle> vehicles`
- [ ] `private ArrayList<Employee> employees`
- [ ] `private ArrayList<Mission> missions`
- [ ] Constructor → tüm liste'leri initialize et
- [ ] `addVehicle(Vehicle v)`
- [ ] `addEmployee(Employee e)`
- [ ] `addMission(Mission m)`
- [ ] `ArrayList<Mission> searchMission(String keyword)` → containsKeyword kullanan filtre
- [ ] `listVehiclesByStatus()` → tüm araçların getStatus()'unu yazdır (polimorfizm)

---

## 🚀 ADIM 7: MAIN SINIFI (Test)

### 7.1 Araç Oluşturma
- [ ] `Car` objesi oluştur
  - passengerCapacity ayarla
- [ ] `CargoBot` objesi oluştur
  - maxLoadKg ayarla
  - load() metodu test et
- [ ] `GroundDrone` objesi oluştur
  - sensorCount ayarla

### 7.2 Modül Ekleme
- [ ] Her araca `NavigationModule` ekle
- [ ] Her araca `SafetyModule` ekle
- [ ] Her araca `AIControlModule` ekle
  - `updateModel()` overloading'i test et (verbose true/false)

### 7.3 Personel Oluşturma
- [ ] `Engineer` objesi oluştur
  - specialty belirle
- [ ] `Technician` objesi oluştur
  - experienceYears belirle
  - maintenanceReport() overloading test et
- [ ] `Manager` objesi oluştur
  - Diğer çalışanları takıma ekle (`addTeamMember`)

### 7.4 Görev Oluşturma
- [ ] `Mission` objesi oluştur
- [ ] Araçları görev'e ata (`assignVehicle`)
- [ ] Personeli görev'e ata (`assignEmployee`)

### 7.5 FleetControlCenter Testleri
- [ ] `FleetControlCenter` objesi oluştur
- [ ] Tüm araçları merkeze ekle
- [ ] Tüm personeli merkeze ekle
- [ ] Mission'ı merkeze ekle
- [ ] `searchMission("thermal")` test et
  - Drone'un scan("thermal") ile ilişkili mission aranmalı
- [ ] `listVehiclesByStatus()` çağır → POLİMORFİZM TESTİ
- [ ] Tüm personelin `describe()` metotlarını yazdır
- [ ] Battery charge overloading test:
  - `charge(50)` → 50 birim ekle
  - `charge()` → tam şarj

---

## 📝 ADIM 8: SORU CEVAPLARI (Rapor)

### 8.1 İlişki Analizi (is-a vs has-a)
- [ ] Car – Vehicle → **is-a** (Car bir Vehicle'dır - inheritance)
- [ ] Vehicle – Module → **has-a** (Vehicle modül içerir - composition)
- [ ] Mission – Vehicle → **has-a** (Mission araç içerir - composition)
- [ ] Manager – Employee → **is-a** (Manager bir Employee'dir - inheritance)
- [ ] Manager – Employee(team) → **has-a** (Manager çalışanlar içerir - composition)
- [ ] GroundDrone – Vehicle → **is-a** (GroundDrone bir Vehicle'dır - inheritance)

### 8.2 super Kullanımı
- [ ] **Constructor'da kullanım**: Alt sınıf constructor'ı üst sınıf constructor'ını çağırır
  - Örnek: `Car` constructor'ında `super(model, serialNumber)`
- [ ] **Override metotta kullanım**: Üst sınıfın metodunu genişletmek için
  - Örnek: `Car.getStatus()` içinde `super.getStatus()` + ek bilgi
- [ ] Her kullanımın amacını açıkla

### 8.3 Overloading vs Overriding
- [ ] **Overloading yaptığım sınıflar**:
  - Vehicle: charge() ve charge(double)
  - GroundDrone: scan() ve scan(String)
  - AIControlModule: updateModel() iki versiyonu
  - Technician: maintenanceReport() iki versiyonu
  - Employee: Constructor overloading
  
- [ ] **Overriding yaptığım sınıflar**:
  - Car, CargoBot, GroundDrone: getStatus()
  - NavigationModule, SafetyModule, AIControlModule: getInfo()
  - Engineer, Technician, Manager: describe()

- [ ] **Çözüm zamanı**:
  - Overloading → **Compile-time** (derleme zamanı)
  - Overriding → **Runtime** (çalışma zamanı - polimorfizm)

---

## ✅ TEST KONTROL LİSTESİ

### Inheritance (Kalıtım)
- [ ] Tüm alt sınıflar extends kullanıyor
- [ ] super() çağrıları doğru yerlerde

### Encapsulation (Kapsülleme)
- [ ] Tüm field'lar private
- [ ] Getter/Setter'lar mevcut
- [ ] setBatteryLevel 0-100 kontrolü yapıyor

### Polymorphism (Çok Biçimlilik)
- [ ] getStatus() her araç tipinde farklı çalışıyor
- [ ] describe() her personel tipinde farklı çalışıyor
- [ ] listVehiclesByStatus() polimorfik davranış gösteriyor

### Overloading
- [ ] En az 4 yerde overloading var
- [ ] Parametre sayısı/tipi farklı

### Overriding
- [ ] @Override annotation kullanılmış
- [ ] Metot imzaları aynı

### Composition (has-a)
- [ ] Vehicle'da Module listesi var
- [ ] Mission'da Vehicle ve Employee listesi var
- [ ] Manager'da Employee listesi var

---

## 🎓 İPUÇLARI

1. **Önce temel sınıfları yaz**, sonra alt sınıfları
2. **Her sınıfı yazdıktan sonra compile et** → hata kontrolü
3. **toString() metotları ekle** → test ederken kolaylık sağlar
4. **Main'de adım adım test et** → her özelliği ayrı kontrol et
5. **System.out.println() kullanarak çıktıları gözlemle**

Bu listeyi yukarıdan aşağıya takip edersen projeyi sorunsuz tamamlarsın! 🚀
