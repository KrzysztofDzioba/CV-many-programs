package design_patterns.behavioral.strategy;

public class JapaneseTaxAdder implements TaxAdder {

    private static final float TAX_PERCENT = 0.05f;

    @Override
    public float addVat(float priceWithoutTax) {
        return priceWithoutTax + priceWithoutTax * TAX_PERCENT;
    }
}
