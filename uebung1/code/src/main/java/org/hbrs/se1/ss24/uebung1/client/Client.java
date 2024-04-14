package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;

public class Client {
    private NumberTransformer numberTransformer;
    public Client(NumberTransformer nt) {
        this.numberTransformer = nt;
    }

    public void printTransformation(int number) {
        String result = numberTransformer.transformNumber(number); // transformiere passend zu Typ
        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
