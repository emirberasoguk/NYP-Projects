public class Uygulama {
    public static void main(String[] args) {
        
        // 1. MENÜ OLUŞTUR
        Menu menu = new Menu("Ana Menü");
        
        // 2. YEMEKLER OLUŞTUR VE EKLE
        Yemek yemek1 = new Yemek("İskender", 80.0, 20, false, false);
        Yemek yemek2 = new Yemek("Vejetaryen Güveç", 50.0, 25, true, true);
        menu.yemekEkle(yemek1);
        menu.yemekEkle(yemek2);
        
        // 3. İÇECEKLER OLUŞTUR VE EKLE
        Icecek icecek1 = new Icecek("Türk Kahvesi", 15.0, 10, false, true);
        Icecek icecek2 = new Icecek("Ayran", 8.0, 2, true, false);
        menu.icecekEkle(icecek1);
        menu.icecekEkle(icecek2);
        
        // 4. TATLILAR OLUŞTUR VE EKLE
        Tatli tatli1 = new Tatli("Sütlaç", 30.0, 15, true, false);
        Tatli tatli2 = new Tatli("Künefe", 45.0, 12, true, true);
        menu.tatliEkle(tatli1);
        menu.tatliEkle(tatli2);
        
        // 5. İNDİRİM UYGULA
        System.out.println("=== İNDİRİM UYGULAMALARI ===");
        yemek1.indirimUygula(0.15); // %15 indirim
        System.out.println(yemek1.getAd() + " için %15 indirim uygulandı.");
        icecek2.indirimUygula(0.10); // %10 indirim
        System.out.println(icecek2.getAd() + " için %10 indirim uygulandı.\n");
        
        // 6. ÖZEL HAZIRLIK VE NOTLAR
        System.out.println("=== ÖZEL ÜRÜN BİLGİLERİ ===");
        System.out.println(yemek1.getAd() + " - " + yemek1.ozelNotAl());
        yemek1.ozelHazirlikYap();
        System.out.println();
        
        System.out.println(tatli2.getAd() + " - " + tatli2.ozelNotAl());
        tatli2.ozelHazirlikYap();
        System.out.println();
        
        // 7. MENÜYÜ YAZDIR
        menu.menuYazdir();
        System.out.println("MENÜ TOPLAM FİYATI: " + menu.toplamMenuFiyati() + " TL\n");
        
        // 8. SİPARİŞ OLUŞTUR
        Siparis siparis = new Siparis("Ahmet Yılmaz", false);
        siparis.yemekEkle(yemek1);
        siparis.icecekEkle(icecek1);
        siparis.tatliEkle(tatli2);
        
        // 9. SİPARİŞ ÖZETİNİ YAZDIR
        siparis.siparisOzetiYazdir();
        
        // 10. TOPLAM İÇECEK SAYISI
        System.out.println("\nŞu ana kadar üretilen İçecek sayısı: " + Icecek.getToplamIcecekSayisi());
    }
}
