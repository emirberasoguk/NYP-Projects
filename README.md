# Object Oriented Programming (OOP) Projects

[🇹🇷 Türkçe](#-türkçe) | [🇬🇧 English](#-english)

---

<a name="-türkçe"></a>
## 🇹🇷 Türkçe

Bu depo, Nesne Yönelimli Programlama (Object Oriented Programming - OOP) dersi kapsamında geliştirilen Java laboratuvar projelerini ve çalışma dosyalarını içerir. Her proje, OOP prensiplerini (kalıtım, kapsülleme, çok biçimlilik vb.) pekiştirmek amacıyla farklı senaryolar üzerine kurulmuştur.

### 📂 Proje İçerikleri

#### 📚 LibrarySystem (Proje 3): Kütüphane Yönetim Sistemi
Kütüphane işleyişini simüle eden bir uygulama.
*   **Ana Özellikler:** Kitap takibi, ödünç alma/iade işlemleri ve kütüphane istatistikleri.
*   **Yapı:** `org.boston.libraries` paketi altında Kitap (`Book`) ve Kütüphane (`Library`) sınıfları.

#### 🚛 FleetManagement (Proje 5): Filo ve Lojistik Yönetimi (AI Destekli)
Araç filolarının yönetildiği, yapay zeka ve güvenlik modüllerini içeren kapsamlı bir simülasyon.
*   **Ana Özellikler:**
    *   Farklı araç tipleri (Araba, Kargo Botu, Kara Dronu).
    *   Çalışan yönetimi (Mühendis, Teknisyen, Yönetici).
    *   Modüler yapı (Navigasyon, Güvenlik, AI Kontrol modülleri).
    *   Görev (`Mission`) atama ve takip sistemi.

#### 🍽️ RestaurantSystem (Proje 6): Restoran Sipariş Sistemi
Bir restoranın menü ve sipariş süreçlerini yöneten sistem.
*   **Ana Özellikler:**
    *   Yiyecek, İçecek ve Tatlı sınıfları.
    *   İndirim uygulanabilir ürünler arayüzü (`IndirimUygulanabilir`).
    *   Sipariş oluşturma ve hesaplama işlemleri.

### 🛠️ Teknolojiler
*   **Dil:** Java
*   **Kavramlar:** Inheritance (Kalıtım), Interface (Arayüz), Polymorphism (Çok Biçimlilik), Encapsulation (Kapsülleme).

### 🚀 Nasıl Çalıştırılır?

Projeler standart Java yapısındadır. Çalıştırmak için bilgisayarınızda **JDK (Java Development Kit)** yüklü olmalıdır.

#### Komut Satırı ile (CLI)

Terminali ilgili proje klasöründe (örneğin `FleetManagement`) açın ve aşağıdaki adımları izleyin:

1. **Kaynak kodları derleyin:**
   ```bash
   javac *.java
   ```

2. **Ana sınıfı çalıştırın:**
   *   **FleetManagement için:** `java Main`
   *   **RestaurantSystem için:** `java Uygulama`

---

<a name="-english"></a>
## 🇬🇧 English

This repository contains Java laboratory projects and working files developed within the scope of the Object Oriented Programming (OOP) course. Each project is built upon different scenarios to reinforce OOP principles (inheritance, encapsulation, polymorphism, etc.).

### 📂 Project Contents

#### 📚 LibrarySystem (Project 3): Library Management System
An application simulating library operations.
*   **Key Features:** Book tracking, borrowing/returning processes, and library statistics.
*   **Structure:** `Book` and `Library` classes under the `org.boston.libraries` package.

#### 🚛 FleetManagement (Project 5): Fleet and Logistics Management (AI Supported)
A comprehensive simulation managing vehicle fleets, including AI and security modules.
*   **Key Features:**
    *   Different vehicle types (Car, Cargo Bot, Ground Drone).
    *   Employee management (Engineer, Technician, Manager).
    *   Modular structure (Navigation, Safety, AI Control modules).
    *   Mission assignment and tracking system.

#### 🍽️ RestaurantSystem (Project 6): Restaurant Ordering System
A system managing a restaurant's menu and ordering processes.
*   **Key Features:**
    *   Food, Drink, and Dessert classes.
    *   Discount applicable products interface (`IndirimUygulanabilir`).
    *   Order creation and calculation processes.

### 🛠️ Technologies
*   **Language:** Java
*   **Concepts:** Inheritance, Interface, Polymorphism, Encapsulation.

### 🚀 How to Run?

Projects follow standard Java structure. To run them, you must have **JDK (Java Development Kit)** installed on your computer.

#### Via Command Line (CLI)

Open the terminal in the relevant project folder (e.g., `FleetManagement`) and follow these steps:

1. **Compile source codes:**
   ```bash
   javac *.java
   ```

2. **Run the main class:**
   *   **For FleetManagement:** `java Main`
   *   **For RestaurantSystem:** `java Uygulama`

#### Via IDE (IntelliJ, Eclipse, VS Code)
Open the project folder with your IDE, locate the main class file (`Main.java` or `Uygulama.java`), and press the **Run** button.
