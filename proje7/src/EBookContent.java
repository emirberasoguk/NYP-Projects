import java.util.ArrayList;
import java.util.List;

// Kalıtım + Interface kullanımı
public class EBookContent extends Content implements Rateable, Downloadable {
    private int pageCount;
    private List<Integer> ratings;

    public EBookContent(String id, String title, int durationMin, double basePrice, int pageCount) {
        super(id, title, durationMin, basePrice);
        this.pageCount = pageCount;
        this.ratings = new ArrayList<>();
        
        if (this.pageCount > 300) {
            this.basePrice += 1.5;
        }
    }

    @Override
    public double finalPrice() {
        return basePrice + (durationMin * 0.005);
    }

    @Override
    public String type() {
        return "EBook";
    }

    @Override
    public void addRating(int stars) {
        if (stars >= 1 && stars <= 5) {
            ratings.add(stars);
        }
    }

    @Override
    public double averageRating() {
        if (ratings.isEmpty()) return 0;
        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.size();
    }

    @Override
    public int ratingCount() {
        return ratings.size();
    }

    @Override
    public double downloadSizeMB() {
        return 25;
    }

    @Override
    public boolean isDownloadable() {
        return true;
    }
}
