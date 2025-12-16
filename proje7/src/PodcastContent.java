import java.util.ArrayList;
import java.util.List;

// Kalıtım + Interface kullanımı
public class PodcastContent extends Content implements Rateable, AdSupported {
    private boolean live;
    private int totalAds;
    private List<Integer> ratings;

    public PodcastContent(String id, String title, int durationMin, double basePrice, boolean live, int totalAds) {
        super(id, title, durationMin, basePrice);
        this.live = live;
        this.totalAds = totalAds;
        this.ratings = new ArrayList<>();
    }

    @Override
    public double finalPrice() {
        double price = basePrice - adDiscount();
        return Math.max(0, price);
    }

    @Override
    public String type() {
        return "Podcast";
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
    public int adCount() {
        return live ? 0 : totalAds;
    }

    @Override
    public double adDiscount() {
        return adCount() * 0.10;
    }
}
