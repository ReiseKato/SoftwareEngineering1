package org.hbrs.se1.ss24.uebung1.factory;

import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.GermanFormatNumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.RomanNumberTransformer;

public class RomanNumberTransformerFactory {
    // erstelle Instanz von RomanNumberTransformer
    public static NumberTransformer createRomanNumberTransformer() {
        return new RomanNumberTransformer();
    }
}
