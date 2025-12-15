import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContentManager {
    private List<Content> contents;
    private PricingPolicy pricingPolicy;

    public ContentManager() {
        this.contents = new ArrayList<>();
        this.pricingPolicy = new NoDiscountPolicy(); // Default policy
    }

    public void setPricingPolicy(PricingPolicy p) {
        this.pricingPolicy = p;
    }

    public void add(Content c) {
        for (Content existing : contents) {
            if (existing.getId().equals(c.getId())) {
                System.out.println("ID zaten var, eklenmedi");
                return;
            }
        }
        contents.add(c);
    }

    public void printAll() {
        for (Content c : contents) {
            System.out.println(c.type() + " | " + c.getInfo() + " | Price: " + pricingPolicy.apply(c));
        }
    }

    public double totalRevenueIfAllBought() {
        double total = 0;
        for (Content c : contents) {
            total += pricingPolicy.apply(c);
        }
        return total;
    }

    public void printTopRated(int n) {
        List<Rateable> rateables = new ArrayList<>();
        for (Content c : contents) {
            if (c instanceof Rateable) {
                rateables.add((Rateable) c);
            }
        }

        rateables.sort(Comparator.comparingDouble(Rateable::averageRating).reversed());

        int count = 0;
        for (Rateable r : rateables) {
            if (count >= n) break;
            System.out.println("Rating: " + r.averageRating() + " | Count: " + r.ratingCount()); 
            // Ideally we'd print more info, but Rateable interface doesn't enforce getInfo/Title. 
            // We can cast back to Content to print details if needed, which is safe here as all are Content.
            if (r instanceof Content) {
                System.out.println(((Content) r).getInfo());
            }
            count++;
        }
    }

    public void printDownloadReport() {
        List<Downloadable> downloadables = new ArrayList<>();
        for (Content c : contents) {
            if (c instanceof Downloadable) {
                Downloadable d = (Downloadable) c;
                if (d.isDownloadable()) {
                    downloadables.add(d);
                }
            }
        }

        downloadables.sort(Comparator.comparingDouble(Downloadable::downloadSizeMB).reversed());

        for (Downloadable d : downloadables) {
            System.out.println("Size: " + d.downloadSizeMB() + " MB");
            if (d instanceof Content) {
                System.out.println(((Content) d).getInfo());
            }
        }
    }
    
    // Helper to get raw list if needed for Main class tasks, or Main can use Manager directly.
    public List<Content> getContents() {
        return contents;
    }
}
