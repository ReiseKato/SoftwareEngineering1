package org.hbrs.se1.ss24.uebung1.client;

public class GermanFormatNumberTransformer extends AbstractNumberTransformer {
    @Override
    protected String doNumberTransformation(int number) {
        return new java.text.DecimalFormat("#,###").format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}
