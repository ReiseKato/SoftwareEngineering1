package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.NumberTransformer;
import org.hbrs.se1.ss24.uebung1.client.RomanNumberTransformer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRomanNumberTransformer {

    @Test
    void TestValidInput() {
        // Positivtestfälle
        RomanNumberTransformer rt = new RomanNumberTransformer();
        assertEquals("IV", rt.transformNumber(4));
        assertEquals("IX", rt.transformNumber(9));
        assertEquals("XLIX", rt.transformNumber(49));
        assertEquals("LXXXIX", rt.transformNumber(89));
        assertEquals("CCCXLIV", rt.transformNumber(344));
        assertEquals("DCCLXXXIII", rt.transformNumber(783));
        assertEquals("MMCMXCIX", rt.transformNumber(2999));
    }

    @Test
    void TestInvalidInput() {
        // Negativtestfälle
        RomanNumberTransformer rt = new RomanNumberTransformer();
        assertEquals("Fehler: Zahl außerhalb des gültigen Bereichs", rt.transformNumber(0));
        assertEquals("Fehler: Zahl außerhalb des gültigen Bereichs", rt.transformNumber(3001));
        assertEquals("Fehler: Zahl außerhalb des gültigen Bereichs", rt.transformNumber(-3));
    }
}
