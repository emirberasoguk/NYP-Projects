  1. Sınıf ve Interface Yapısı:
       * Content soyut sınıfı (Abstract) ve istenen alanlar/metotlar doğru tanımlanmış.
       * Rateable, Downloadable, AdSupported interface'leri ve metotları mevcut.

  2. Somut Sınıflar ve Kurallar:
       * VideoContent: Fiyat hesaplama, indirme boyutu (kaliteye göre artış) ve sadece ücretsizlerin indirilebilmesi
         kuralı uygulanmış.
       * PodcastContent: Canlı yayın (live) durumunda reklamın 0 olması ve reklam indirim mantığı doğru.
       * EBookContent: 300+ sayfa için taban fiyata ekleme yapılması (+1.5) ve sabit indirme boyutu kuralı
         uygulanmış.

  3. Polimorfizm ve Listeleme:
       * Main sınıfında tüm içerikler, puanlanabilirler, indirilebilirler ve reklamlı içerikler için ayrı ayrı
         listeleme ve işlem yapma mantığı (polimorfizm) başarıyla çalışıyor.

  4. ContentManager ve Yönetim:
       * Aynı ID kontrolü yapılıyor ("ID zaten var, eklenmedi").
       * printTopRated (puan sıralaması) ve printDownloadReport (boyut sıralaması) fonksiyonları doğru çalışıyor.
       * Toplam gelir hesabı (totalRevenueIfAllBought) doğru.

  5. Tasarım Deseni (Strategy Pattern):
       * PricingPolicy interface'i ile NoDiscountPolicy ve WeekendDiscountPolicy (%10 indirim) stratejileri
         uygulanmış.
       * Manager üzerinden politika değiştirildiğinde fiyatlar anlık olarak güncelleniyor.

✦ Projenin yapısını inceledim. Bu proje, Nesne Yönelimli Programlama (NYP) ilkelerini kullanarak esnek bir "İçerik
  Yönetim Sistemi" simüle ediyor. Temelde farklı türdeki dijital içerikleri (Video, Podcast, E-Kitap) tek bir çatı
  altında yönetmeyi, fiyatlandırmayı ve özelliklerine göre işlemeyi hedefliyor.

  İşte projenin çalışma mantığının NYP ilkeleriyle analizi:

  1. Kalıtım (Inheritance) - "Ortak Özellikleri Tek Yerde Toplama"
  Projedeki Content sınıfı bir Ebeveyn (Parent) sınıftır.

* Mantık: Tüm içeriklerin (Video, Podcast, E-Kitap) ortak özellikleri vardır: id, title (başlık), durationMin
     (süre), basePrice (taban fiyat).
* Uygulama: Bu ortak özellikler her sınıfta tekrar tekrar yazılmak yerine Content sınıfında tanımlanmış.
     VideoContent, PodcastContent ve EBookContent sınıfları extends Content diyerek bu özellikleri miras alır.

  2. Soyutlama (Abstraction) - "Detayları Gizleme ve Zorunluluk Kılma"
  Content sınıfı `abstract` (soyut) olarak tanımlanmıştır.

* Mantık: Tek başına "İçerik" diye bir nesne yaratılamaz; içerik ya videodur ya da e-kitaptır.
* Uygulama: finalPrice() (son fiyat) metodu soyuttur. Yani Content sınıfı der ki: "Her içeriğin bir son fiyatı
     olmalıdır, ama bunun nasıl hesaplanacağını alt sınıflar (Video, Podcast vb.) kendisi belirler." Örneğin
     VideoContent, süresine ve kalitesine göre kendi fiyatını hesaplar.

  3. Çok Biçimlilik (Polymorphism) - "Tek Kod, Çok İşlev"
  ContentManager sınıfı, elindeki tüm içerikleri List<Content> içinde tutar.

* Mantık: Yönetici sınıf, listedeki elemanın Video mu Podcast mi olduğunu bilmek zorunda değildir. Hepsine "Sen
     bir İçeriksin" gözüyle bakar.
* Uygulama: manager.printAll() metodunda döngü dönerken c.finalPrice() çağrıldığında, Java çalışma zamanında o
     nesne hangi türdeyse (Video, Podcast) onun hesaplama yöntemini çalıştırır.

  4. Arayüzler (Interfaces) - "Yetenek Kazandırma"
  Projede Rateable (Puanlanabilir), Downloadable (İndirilebilir) gibi arayüzler var.

* Mantık: Her içerik indirilemeyebilir (örneğin canlı yayınlar) veya her içerik puanlanmayabilir. Bu özellikler
     kalıtımla değil, yetenek (interface) olarak eklenir.
* Uygulama: VideoContent sınıfı implements Rateable diyerek puanlanabilir olma özelliği kazanır. Kod içerisinde
     if (c instanceof Rateable) kontrolü yapılarak sadece bu yeteneğe sahip nesneler filtrelenebilir.

  5. Strateji Deseni (Strategy Pattern) - "Esnek Fiyatlandırma"
  Projedeki en kritik tasarım kararlarından biri PricingPolicy arayüzüdür.

* Mantık: Fiyat hesaplama mantığı (indirimler, kampanyalar) zamanla değişebilir. Bu mantığı Content sınıflarının
     içine gömmek yerine ayrı bir "Politika" olarak tanımlanmış.
* Uygulama: ContentManager bir PricingPolicy nesnesi tutar (Varsayılan: NoDiscountPolicy). Eğer
     manager.setPricingPolicy(new WeekendDiscountPolicy()) derseniz, tüm içeriklerin fiyat hesaplama mantığı anında
     değişir. Bu, kodun değişime kapalı ama gelişime açık (Open/Closed Principle) olmasını sağlar.

  Özetle: Proje, yeni bir içerik türü eklendiğinde (örneğin "ArticleContent") mevcut kodu bozmadan sisteme dahil
  edilebilmesi için modüler ve genişletilebilir tasarlanmıştır.
