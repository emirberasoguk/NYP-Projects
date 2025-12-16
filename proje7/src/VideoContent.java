import java.util.ArrayList;
import java.util.List;

// Kalıtım + Interface kullanımı
public class VideoContent extends Content implements Rateable, Downloadable {
    private int quality;
    private List<Integer> ratings;

    public VideoContent(String id, String title, int durationMin, double basePrice, int quality) {
        super(id, title, durationMin, basePrice);
        this.quality = quality;
        this.ratings = new ArrayList<>();
    }

    @Override
    public double finalPrice() {
        return basePrice + (durationMin * 0.02);
    }

    @Override
    public String type() {
        return "Video";
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
        double size = durationMin * 15;
        if (quality == 1080) {
            size *= 1.30;
        }
        return size;
    }

    @Override
    public boolean isDownloadable() {
        return isFree();
    }
}
