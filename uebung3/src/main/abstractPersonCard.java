package main;

import java.io.Serializable;

/**
 * Abstrakte Klasse, von der die Klassen "DeveloperCard" und "EnduserCard" erben.
 * Noetig fuer die automatische Vergabe einzigartiger IDs (Primaerschluessel) -> id := static counter
 * */
abstract public class abstractPersonCard implements PersonCard, Serializable {
    private String firstname;
    private String lastname;
    private int id;
    private static int counter;

    public abstractPersonCard(){}

    public abstractPersonCard(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = counter;
        this.counter++;
    }

    @Override
    public String getFirstName() {
        return this.firstname;
    }

    @Override
    public String getLastName() {
        return this.lastname;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public String toString() {
        String s = String.format("ID = [%d], Vorname = [%s], Nachname = [%s], ", this.id,
                this.firstname, this.lastname);
        return s;
    }
}
