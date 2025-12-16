// Varsayılan strateji
public class NoDiscountPolicy implements PricingPolicy {
    @Override
    public double apply(Content c) {
        return c.finalPrice();
    }
}
