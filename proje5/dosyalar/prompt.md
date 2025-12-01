# UZMAN JAVA PROMPT: Akıllı Otonom Araç Filosu Yönetim Sistemi

Sen uzman bir Java geliştiricisisin. Aşağıdaki spesifikasyonlara göre eksiksiz bir Java projesi oluşturacaksın. Tüm kod çalışır durumda, derlenebilir ve test edilebilir olmalı.

---

## 🎯 PROJE AMAÇI

OOP prensiplerini (inheritance, encapsulation, polymorphism, overloading, overriding) kullanarak otonom araç filosu yönetim sistemi geliştir.

---

## 📁 PROJE YAPISI

15 ayrı Java dosyası oluştur:
- **Araçlar**: Vehicle.java, Car.java, CargoBot.java, GroundDrone.java
- **Modüller**: Module.java, NavigationModule.java, SafetyModule.java, AIControlModule.java
- **Personel**: Employee.java, Engineer.java, Technician.java, Manager.java
- **Sistem**: Mission.java, FleetControlCenter.java, Main.java

---

## 🔧 DETAYLI SPESİFİKASYONLAR

### 1️⃣ VEHICLE HIERARCHY (Araç Hiyerarşisi)

#### **Vehicle.java** (Base Class)
```
FIELDS (private):
- String model
- String serialNumber
- double batteryLevel
- ArrayList<Module> modules

CONSTRUCTORS (Overloading):
1. Vehicle() → varsayılan değerler
2. Vehicle(String model, String serialNumber) → batteryLevel=100, modules=new ArrayList<>()

METHODS:
- Getter/Setter (tüm field'lar için)
- setBatteryLevel(double level) → 0-100 dışı değerleri reddet
- addModule(Module m) → modules listesine ekle
- charge(double amount) → batteryLevel'a ekle (max 100)
- charge() → batteryLevel=100 yap (overloading)
- getStatus() → "Model: X, Serial: Y, Battery: Z%" döndür
```

#### **Car.java** (extends Vehicle)
```
ADDITIONAL FIELD:
- int passengerCapacity

CONSTRUCTOR:
- Car(String model, String serialNumber, int capacity) → super(model, serialNumber) çağır

METHODS:
- getPassengerCapacity(), setPassengerCapacity()
- @Override getStatus() → super.getStatus() + ", Passengers: X"
```

#### **CargoBot.java** (extends Vehicle)
```
ADDITIONAL FIELDS:
- double maxLoadKg
- double currentLoad

CONSTRUCTOR:
- CargoBot(String model, String serialNumber, double maxLoad)

METHODS:
- load(double kg) → currentLoad'a ekle ama maxLoadKg'ı geçmesin, geçerse hata mesajı
- unload() → currentLoad=0
- getMaxLoadKg(), getCurrentLoad()
- @Override getStatus() → super.getStatus() + ", Load: X/Y kg"
```

#### **GroundDrone.java** (extends Vehicle)
```
ADDITIONAL FIELD:
- int sensorCount

CONSTRUCTOR:
- GroundDrone(String model, String serialNumber, int sensors)

METHODS (Overloading):
- scan() → "Basic scan completed"
- scan(String mode) → "Scanning in [mode] mode" (örn: "thermal", "lidar")
- getSensorCount(), setSensorCount()
- @Override getStatus() → super.getStatus() + ", Sensors: X"
```

---

### 2️⃣ MODULE HIERARCHY (Modül Hiyerarşisi)

#### **Module.java** (Base Class)
```
FIELDS (private):
- String name
- String version

CONSTRUCTOR:
- Module(String name, String version)

METHODS:
- getName(), getVersion()
- getInfo() → "Module: [name] v[version]"
```

#### **NavigationModule.java** (extends Module)
```
ADDITIONAL FIELD:
- String mapVersion

CONSTRUCTOR:
- NavigationModule(String name, String version, String mapVersion) → super(name, version)

METHODS:
- getMapVersion(), setMapVersion()
- @Override getInfo() → super.getInfo() + ", Map: [mapVersion]"
```

#### **SafetyModule.java** (extends Module)
```
ADDITIONAL FIELD:
- int riskLevel

CONSTRUCTOR:
- SafetyModule(String name, String version, int riskLevel)

METHODS:
- getRiskLevel(), setRiskLevel()
- @Override getInfo() → super.getInfo() + ", Risk Level: [riskLevel]"
```

#### **AIControlModule.java** (extends Module)
```
ADDITIONAL FIELD:
- String modelName

CONSTRUCTOR:
- AIControlModule(String name, String version, String modelName)

METHODS (Overloading):
- updateModel(String newModel) → modelName'i güncelle
- updateModel(String newModel, boolean verbose) → güncelle + verbose ise "AI Model updated to: X" yazdır
- getModelName()
- @Override getInfo() → super.getInfo() + ", AI Model: [modelName]"
```

---

### 3️⃣ EMPLOYEE HIERARCHY (Personel Hiyerarşisi)

#### **Employee.java** (Base Class)
```
FIELDS (private):
- String name
- String email
- String employeeId

CONSTRUCTORS (Overloading):
1. Employee(String name, String email, String employeeId)
2. Employee(String name, String email) → employeeId'yi otomatik oluştur (örn: "EMP" + random sayı)

METHODS:
- Getter/Setter (tüm field'lar)
- getNormalizedEmail() → email.trim().toLowerCase()
- describe() → "Employee: [name], Email: [normalizedEmail], ID: [employeeId]"
```

#### **Engineer.java** (extends Employee)
```
ADDITIONAL FIELD:
- String specialty (örn: "AI Systems", "Robotics")

CONSTRUCTOR:
- Engineer(String name, String email, String employeeId, String specialty) → super(...)

METHODS:
- getSpecialty(), setSpecialty()
- @Override describe() → super.describe() + ", Specialty: [specialty]"
```

#### **Technician.java** (extends Employee)
```
ADDITIONAL FIELD:
- int experienceYears

CONSTRUCTOR:
- Technician(String name, String email, String employeeId, int experience)

METHODS (Overloading):
- maintenanceReport() → "Maintenance report generated"
- maintenanceReport(boolean includeTimestamp) → timestamp true ise tarih/saat ekle
- getExperienceYears(), setExperienceYears()
- @Override describe() → super.describe() + ", Experience: [years] years"
```

#### **Manager.java** (extends Employee)
```
ADDITIONAL FIELD:
- ArrayList<Employee> team

CONSTRUCTOR:
- Manager(String name, String email, String employeeId) → super(...) + team = new ArrayList<>()

METHODS:
- addTeamMember(Employee e) → team'e ekle
- getTeam() → team döndür
- @Override describe() → super.describe() + ", Team Size: [team.size()]"
```

---

### 4️⃣ MISSION SYSTEM (Görev Sistemi)

#### **Mission.java**
```
FIELDS (private):
- String missionId
- String description
- ArrayList<Vehicle> assignedVehicles
- ArrayList<Employee> responsibleStaff

CONSTRUCTOR:
- Mission(String missionId, String description) → listeleri initialize et

METHODS:
- assignVehicle(Vehicle v) → assignedVehicles'a ekle
- assignEmployee(Employee e) → responsibleStaff'a ekle
- containsKeyword(String keyword) → description içinde case-insensitive ara (toLowerCase kullan)
- getMissionId(), getDescription(), getAssignedVehicles(), getResponsibleStaff()
```

---

### 5️⃣ FLEET CONTROL CENTER (Filo Yönetim Merkezi)

#### **FleetControlCenter.java**
```
FIELDS (private):
- ArrayList<Vehicle> vehicles
- ArrayList<Employee> employees
- ArrayList<Mission> missions

CONSTRUCTOR:
- FleetControlCenter() → tüm listeleri initialize et

METHODS:
- addVehicle(Vehicle v)
- addEmployee(Employee e)
- addMission(Mission m)
- searchMission(String keyword) → missions içinde containsKeyword kullanan filtre, bulunanları ArrayList olarak döndür
- listVehiclesByStatus() → tüm vehicles için getStatus() çağır ve yazdır (POLİMORFİZM)
```

---

### 6️⃣ MAIN CLASS (Test ve Demo)

#### **Main.java**

Aşağıdakileri SIRASI İLE yap:

```java
public class Main {
    public static void main(String[] args) {
        // 1. ARAÇ OLUŞTURMA
        Car car = new Car("Tesla Model S", "TS001", 5);
        CargoBot cargo = new CargoBot("CargoBot Pro", "CB001", 500.0);
        GroundDrone drone = new GroundDrone("Scout X1", "GD001", 8);

        // 2. MODÜL OLUŞTURMA VE EKLEME
        NavigationModule nav1 = new NavigationModule("NavCore", "2.1", "WorldMap 2024");
        SafetyModule safe1 = new SafetyModule("SafeGuard", "1.5", 3);
        AIControlModule ai1 = new AIControlModule("AIBrain", "3.0", "GPT-Auto");

        car.addModule(nav1);
        car.addModule(safe1);
        car.addModule(ai1);

        // CargoBot ve Drone'a da modüller ekle (benzer şekilde)

        // 3. AI MODEL GÜNCELLEME TESTİ (Overloading)
        ai1.updateModel("GPT-Auto-v2"); // sessiz güncelleme
        ai1.updateModel("GPT-Auto-v3", true); // verbose güncelleme

        // 4. CARGOBOT YÜK TESTİ
        cargo.load(300);
        cargo.load(250); // Limit aşımı kontrolü
        cargo.unload();

        // 5. DRONE SCAN TESTİ (Overloading)
        drone.scan();
        drone.scan("thermal");
        drone.scan("lidar");

        // 6. PERSONEL OLUŞTURMA
        Engineer eng = new Engineer("Alice Johnson", "alice@fleet.com", "ENG001", "AI Systems");
        Technician tech = new Technician("Bob Smith", "bob@fleet.com", "TECH001", 7);
        Manager mgr = new Manager("Carol Davis", "carol@fleet.com", "MGR001");

        // 7. MANAGER TAKIM OLUŞTURMA
        mgr.addTeamMember(eng);
        mgr.addTeamMember(tech);

        // 8. TECHNICIAN RAPOR TESTİ (Overloading)
        tech.maintenanceReport();
        tech.maintenanceReport(true);

        // 9. MİSSION OLUŞTURMA
        Mission mission1 = new Mission("M001", "Urban thermal scan mission with cargo delivery");
        mission1.assignVehicle(car);
        mission1.assignVehicle(cargo);
        mission1.assignVehicle(drone);
        mission1.assignEmployee(eng);
        mission1.assignEmployee(tech);
        mission1.assignEmployee(mgr);

        // 10. FLEET CONTROL CENTER KURULUMU
        FleetControlCenter center = new FleetControlCenter();
        center.addVehicle(car);
        center.addVehicle(cargo);
        center.addVehicle(drone);
        center.addEmployee(eng);
        center.addEmployee(tech);
        center.addEmployee(mgr);
        center.addMission(mission1);

        // 11. MISSION ARAMA TESTİ
        System.out.println("\n=== MISSION SEARCH: 'thermal' ===");
        ArrayList<Mission> found = center.searchMission("thermal");
        for (Mission m : found) {
            System.out.println("Found: " + m.getMissionId() + " - " + m.getDescription());
        }

        // 12. VEHICLE STATUS LİSTELEME (POLİMORFİZM TESTİ)
        System.out.println("\n=== ALL VEHICLE STATUS (POLYMORPHISM) ===");
        center.listVehiclesByStatus();

        // 13. PERSONEL AÇIKLAMALARI (POLİMORFİZM TESTİ)
        System.out.println("\n=== EMPLOYEE DESCRIPTIONS (POLYMORPHISM) ===");
        System.out.println(eng.describe());
        System.out.println(tech.describe());
        System.out.println(mgr.describe());

        // 14. BATTERY CHARGE TESTİ (Overloading)
        System.out.println("\n=== BATTERY CHARGE TEST ===");
        car.setBatteryLevel(50);
        System.out.println("Car battery before: " + car.getBatteryLevel() + "%");
        car.charge(30);
        System.out.println("Car battery after charge(30): " + car.getBatteryLevel() + "%");
        car.charge();
        System.out.println("Car battery after charge(): " + car.getBatteryLevel() + "%");

        // 15. MODÜL BİLGİLERİ
        System.out.println("\n=== MODULE INFORMATION ===");
        for (Module m : car.getModules()) {
            System.out.println(m.getInfo());
        }
    }
}
```

---

## ✅ ZORUNLU ÇIKTI ÖRNEKLERİ

Main çalıştırıldığında şu çıktıları üretmeli:

```
AI Model updated to: GPT-Auto-v3
Load successful: 300.0 kg loaded. Current load: 300.0/500.0 kg
Error: Cannot load 250.0 kg. Would exceed maximum capacity of 500.0 kg
Cargo unloaded successfully
Basic scan completed
Scanning in thermal mode
Scanning in lidar mode
Maintenance report generated
Maintenance report generated at: [timestamp]

=== MISSION SEARCH: 'thermal' ===
Found: M001 - Urban thermal scan mission with cargo delivery

=== ALL VEHICLE STATUS (POLYMORPHISM) ===
Model: Tesla Model S, Serial: TS001, Battery: 50.0%, Passengers: 5
Model: CargoBot Pro, Serial: CB001, Battery: 100.0%, Load: 0.0/500.0 kg
Model: Scout X1, Serial: GD001, Battery: 100.0%, Sensors: 8

=== EMPLOYEE DESCRIPTIONS (POLYMORPHISM) ===
Employee: Alice Johnson, Email: alice@fleet.com, ID: ENG001, Specialty: AI Systems
Employee: Bob Smith, Email: bob@fleet.com, ID: TECH001, Experience: 7 years
Employee: Carol Davis, Email: carol@fleet.com, ID: MGR001, Team Size: 2

=== BATTERY CHARGE TEST ===
Car battery before: 50.0%
Car battery after charge(30): 80.0%
Car battery after charge(): 100.0%

=== MODULE INFORMATION ===
Module: NavCore v2.1, Map: WorldMap 2024
Module: SafeGuard v1.5, Risk Level: 3
Module: AIBrain v3.0, AI Model: GPT-Auto-v3
```

---

## 🎯 KRİTİK KURALLAR

1. **Import Statements**: `import java.util.ArrayList;` tüm gerekli dosyalarda olmalı
2. **Encapsulation**: TÜM field'lar `private` olmalı
3. **super() Kullanımı**: Alt sınıf constructor'larında MUTLAKA üst sınıf constructor'ı çağrılmalı
4. **@Override Annotation**: Override edilen TÜM metotlarda kullan
5. **Validation**: 
   - setBatteryLevel: 0-100 kontrolü
   - CargoBot.load: maxLoadKg kontrolü
6. **Case-Insensitive Search**: `containsKeyword()` ve `searchMission()` için `toLowerCase()` kullan
7. **ArrayList Initialization**: Constructor'larda `new ArrayList<>()` ile initialize et
8. **Polimorfizm**: Base class referansı ile alt sınıf objelerini kullan

---

## 📋 SORU CEVAPLARI (Kod yorumları olarak ekle)

Main.java dosyasının sonuna şu cevapları yorum olarak ekle:

```java
/*
==========================================
SORU CEVAPLARI
==========================================

1) İLİŞKİ ANALİZİ (is-a vs has-a):

   - Car – Vehicle: IS-A (inheritance) 
     → Car extends Vehicle, Car bir Vehicle türüdür

   - Vehicle – Module: HAS-A (composition)
     → Vehicle içinde ArrayList<Module> var, Vehicle modül içerir

   - Mission – Vehicle: HAS-A (composition)
     → Mission içinde ArrayList<Vehicle> var, Mission araç içerir

   - Manager – Employee: IS-A (inheritance)
     → Manager extends Employee, Manager bir Employee türüdür

   - Manager – Employee(team): HAS-A (composition)
     → Manager içinde ArrayList<Employee> team var, Manager çalışan içerir

   - GroundDrone – Vehicle: IS-A (inheritance)
     → GroundDrone extends Vehicle, GroundDrone bir Vehicle türüdür

2) SUPER ANAHTAR KELİMESİ KULLANIMI:

   A) CONSTRUCTOR İÇİNDE:
      - Örnek: Car.java → super(model, serialNumber)
      - Amaç: Üst sınıfın (Vehicle) constructor'ını çağırarak ortak field'ları initialize etmek
      - Kural: super() çağrısı constructor'ın ilk satırı olmalı

   B) OVERRIDE EDİLEN METOT İÇİNDE:
      - Örnek: Car.getStatus() → return super.getStatus() + ", Passengers: " + passengerCapacity
      - Amaç: Üst sınıfın metodunu çağırıp üzerine ek bilgi eklemek, kod tekrarını önlemek
      - Fayda: Base class davranışını koruyarak genişletme (extension)

3) OVERLOADING vs OVERRIDING:

   OVERLOADING (Aynı sınıf, farklı parametreler):
   - Vehicle: charge() ve charge(double amount)
   - GroundDrone: scan() ve scan(String mode)
   - AIControlModule: updateModel(String) ve updateModel(String, boolean)
   - Technician: maintenanceReport() ve maintenanceReport(boolean)
   - Employee: Constructor overloading
   - Çözüm: COMPILE-TIME (Derleme zamanında hangi metodun çağrılacağı belirlenir)

   OVERRIDING (Alt sınıf, aynı imza):
   - Car, CargoBot, GroundDrone: getStatus() metodunu override eder
   - NavigationModule, SafetyModule, AIControlModule: getInfo() metodunu override eder
   - Engineer, Technician, Manager: describe() metodunu override eder
   - Çözüm: RUNTIME (Çalışma zamanında objenin gerçek tipi baz alınır - POLİMORFİZM)

==========================================
*/
```

---

## 🚀 ÇIKTI FORMATI

Her Java dosyasını ayrı kod bloğu olarak ver:
- Dosya adını başlıkta belirt
- Tam çalışır kod yaz
- Gerekli import'ları ekle
- Açıklayıcı yorumlar ekle

**ÖNEMLİ**: 15 dosyanın hepsini eksiksiz üret. Her dosya bağımsız derlenebilir olmalı.

---

Şimdi projeyi oluştur! 🎯
