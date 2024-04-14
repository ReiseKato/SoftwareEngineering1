package org.hbrs.se1.ss24.uebung1.client;

import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;

abstract public class AbstractNumberTransformer implements NumberTransformer {
    @Override
    public String transformNumber(int number)
    {
        if(number < 1 || 3000 < number) {
            return "Fehler: Zahl außerhalb des gültigen Bereichs";
        }
        return doNumberTransformation(number);
    }

    protected abstract String doNumberTransformation(int number);

    @Override
    public String getTransformerType()
    {
        return "Zahlenformatierung";
    }
}
