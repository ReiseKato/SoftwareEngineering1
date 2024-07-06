import java.util.ArrayList;

public class Abteilungsgruppe extends Abteilung {
    private ArrayList<Abteilung> abteilungen;

    public Abteilungsgruppe(String name) {
        super(name);
        abteilungen = new ArrayList<>();
    }

    public void printName() {
        super.printName();
        for (Abteilung i : abteilungen) {
            i.printName();
        }
    }

    public void addAbteilung(Abteilung abt) {
        abteilungen.add(abt);
    }

    public void removeAbteilung(Abteilung abt) {
        abteilungen.remove(abt);
    }
}
