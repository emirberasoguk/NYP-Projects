public class WeekendDiscountPolicy implements PricingPolicy {
    @Override
    public double apply(Content c) {
        return c.finalPrice() * 0.90; // 10% discount
    }
}
