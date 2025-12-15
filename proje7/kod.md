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
