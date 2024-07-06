public class Client {
    public static void main(String[] args) {
        // Composite Pattern
            // -> erstelle anpassbare, hierarchische Objekt-Strukturen
        Abteilungsgruppe AB = new Abteilungsgruppe("AB");
        Abteilungsgruppe AB3 = new Abteilungsgruppe("AB3");
        Abteilungsgruppe AB4 = new Abteilungsgruppe("AB4");
        EinzelAbteilung AB30 = new EinzelAbteilung("AB30");
        EinzelAbteilung AB31 = new EinzelAbteilung("AB31");
        EinzelAbteilung AB40 = new EinzelAbteilung("AB40");
        EinzelAbteilung AB41 = new EinzelAbteilung("AB41");

        // make hierarchy
        AB3.addAbteilung(AB30);
        AB3.addAbteilung(AB31);
        AB4.addAbteilung(AB40);
        AB4.addAbteilung(AB41);
        AB.addAbteilung(AB3);
        AB.addAbteilung(AB4);

        // print hierarchy
        AB.printName();
    }
}