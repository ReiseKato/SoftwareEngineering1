package org.hbrs.se1.ss24.uebung1.factory;

import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.GermanFormatNumberTransformer;

public class GermanFormatNumberTransformerFactory {
    // erstelle Instanz von GermanFormatNumberTransformer
    public static NumberTransformer createGermanFormatNumberTransformer() {
        return new GermanFormatNumberTransformer();
    }
}
