public abstract class Content {
    protected String id;
    protected String title;
    protected int durationMin;
    protected double basePrice;

    public Content(String id, String title, int durationMin, double basePrice) {
        this.id = id;
        this.title = title;
        this.durationMin = durationMin;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return id + " | " + title + " | " + durationMin;
    }

    public boolean isFree() {
        return basePrice == 0;
    }

    public abstract double finalPrice();
    public abstract String type();
}
