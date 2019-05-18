package design_patterns.behavioral.strategy;

public class PolishTaxAdder implements TaxAdder {

    private static final float TAX_PERCENT = 0.23f;

    @Override
    public float addVat(float priceWithoutTax) {
        return priceWithoutTax + priceWithoutTax * TAX_PERCENT;
    }
}
