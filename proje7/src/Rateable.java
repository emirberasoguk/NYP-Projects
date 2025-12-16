// Puanlanabilme yeteneği (Interface)
public interface Rateable {
    void addRating(int stars);
    double averageRating();
    int ratingCount();
}
