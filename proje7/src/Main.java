import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContentManager manager = new ContentManager();

        // Nesne oluşturma
        VideoContent v1 = new VideoContent("V1", "Java Tutorial", 10, 100.0, 720);
        VideoContent v2 = new VideoContent("V2", "Movie: Inception", 148, 200.0, 1080);
        VideoContent v3 = new VideoContent("V3", "Funny Cat Video", 2, 0.0, 480);

        PodcastContent p1 = new PodcastContent("P1", "Tech Talk", 45, 50.0, false, 5);
        PodcastContent p2 = new PodcastContent("P2", "Live News", 60, 50.0, true, 10);

        EBookContent e1 = new EBookContent("E1", "Learn Java", 120, 80.0, 400);
        EBookContent e2 = new EBookContent("E2", "Short Story", 30, 20.0, 100);

        // Polymorphism: Hepsi Content olarak ekleniyor
        manager.add(v1);
        manager.add(v2);
        manager.add(v3);
        manager.add(p1);
        manager.add(p2);
        manager.add(e1);
        manager.add(e2);

        System.out.println("--- Duplicate Add Test ---");
        manager.add(new VideoContent("V1", "Duplicate", 10, 10.0, 720));

        System.out.println("\n--- Tüm İçerikler (Polymorphism) ---");
        List<Content> library = manager.getContents();
        for (Content c : library) {
            System.out.println(c.type() + " | " + c.getInfo() + " | Final Price: " + c.finalPrice());
        }

        System.out.println("\n--- Rateable Arayüz Testi ---");
        List<Rateable> rateables = new ArrayList<>();
        for (Content c : library) {
            if (c instanceof Rateable) {
                rateables.add((Rateable) c);
            }
        }
        
        for (Rateable r : rateables) {
            r.addRating(4);
            r.addRating(5);
            if (Math.random() > 0.5) r.addRating(3);
        }
        for (Rateable r : rateables) {
             System.out.println("Avg Rating: " + r.averageRating() + " (Count: " + r.ratingCount() + ")");
        }

        System.out.println("\n--- Downloadable Arayüz Testi ---");
        List<Downloadable> downloads = new ArrayList<>();
        for (Content c : library) {
            if (c instanceof Downloadable) {
                downloads.add((Downloadable) c);
            }
        }
        for (Downloadable d : downloads) {
            if (d.isDownloadable()) {
                System.out.println("Download Size: " + d.downloadSizeMB() + " MB");
            }
        }

        System.out.println("\n--- AdSupported Arayüz Testi ---");
        List<AdSupported> ads = new ArrayList<>();
        for (Content c : library) {
            if (c instanceof AdSupported) {
                ads.add((AdSupported) c);
            }
        }
        int totalAds = 0;
        double totalAdDiscount = 0;
        for (AdSupported a : ads) {
            totalAds += a.adCount();
            totalAdDiscount += a.adDiscount();
        }
        System.out.println("Total Ads: " + totalAds);
        System.out.println("Total Ad Discount: " + totalAdDiscount);

        System.out.println("\n--- ContentManager Raporları ---");
        System.out.println("Total Revenue (Varsayılan): " + manager.totalRevenueIfAllBought());
        
        System.out.println("\n--- Top Rated (Top 3) ---");
        manager.printTopRated(3);

        System.out.println("\n--- Download Report ---");
        manager.printDownloadReport();

        System.out.println("\n--- Strateji Deseni Testi ---");
        System.out.println("Politika değişiyor: WeekendDiscountPolicy (%10 indirim)");
        manager.setPricingPolicy(new WeekendDiscountPolicy());
        System.out.println("Total Revenue (Haftasonu): " + manager.totalRevenueIfAllBought());
        
        manager.printAll();
    }
}
