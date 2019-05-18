package design_patterns.behavioral.strategy;

import java.util.Random;

public class Context {

    public static void main(String[] args) {
        Random random = new Random();
        int zeroOrOne = random.nextInt(2);
        TaxAdder taxAdder = zeroOrOne == 0 ? new JapaneseTaxAdder() : new PolishTaxAdder();
        System.out.println(taxAdder.addVat(100));
    }
}
