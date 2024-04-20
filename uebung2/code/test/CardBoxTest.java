import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardBoxTest {
    CardBox cardBox;
    @BeforeEach
    void setUp() {
        cardBox = new CardBox();
    }

    /**
     * Teste, ob Exception geworfen wird, wenn gleiche Person 2x hinzugefuegt werden soll.
     * */
    @Test
    void addExistingPersonTest() {
        PersonCard developerCard = new DeveloperCard("Reise", "Kato");
        try {
            cardBox.addPerson(developerCard);
            assertThrows(CardBoxException.class, () -> cardBox.addPerson(developerCard));
        } catch (CardBoxException e) {

        }
    }

    /**
     * Teste, ob richtige Nachricht zurueckgegeben wird, wenn versucht wird, eine nicht existierende PersonCard aus der
     * CardBox zu entfernen.
     * */
    @Test
    void deleteNonExistingCard() {
        PersonCard personCard1 = new DeveloperCard("Thomas", "Kato");
        PersonCard personCard2 = new EnduserCard("Reise", "Kato");
        try {
            cardBox.addPerson(personCard1);
        } catch (CardBoxException e) {

        }
        assertEquals("[" + personCard2.getId() + "] nicht in CardBox.", cardBox.deletePerson(personCard2.getId()));
    }

    /**
     * Teste, ob richtige Nachricht zurueckgegeben wird, falls veruscht wird aus einer leeren CardBox
     * eine PersonCard zu ntfernen.
     */
    @Test
    void deleteFromEmptyCardBox() {
        assertEquals("CardBox ist leer.", cardBox.deletePerson(0));
    }

    /**
     * Teste, ob add, delete, size richtig funktionieren, indem alle Operationen in der genannten Reihenfolge
     * ausgefuehrt werden.
     */
    @Test
    void addDeleteSizeTest() {
        PersonCard personCard1 = new DeveloperCard("Thomas", "Kato");
        PersonCard personCard2 = new EnduserCard("Reise", "Kato");
        PersonCard personCard3 = new EnduserCard("Joachim", "Schmitt");
        PersonCard personCard4 = new EnduserCard("Jan", "Vies");
        try {
            cardBox.addPerson(personCard1);
            cardBox.addPerson(personCard2);
            cardBox.addPerson(personCard3);
            cardBox.addPerson(personCard4);
            cardBox.deletePerson(personCard3.getId());
        } catch (CardBoxException e) {

        }
        assertEquals(3, cardBox.size());
    }

    /**
     * Teste, ob showContent eine richtige Konsolenausgabe liefert. Hier ist eine manuelle Ueberpruefung notwendig.
     * Es reicht aus die beiden unterschiedlichen Unterklassen jeweils einmal auszugeben, um die richtige
     * Implementation der Ausgabe beider Klassen zu ueberpruefen.
     */
    @Test
    void showContentTest() {
        PersonCard personCard1 = new DeveloperCard("Thomas", "Kato");
        PersonCard personCard2 = new EnduserCard("Reise", "Kato");
        try {
            cardBox.addPerson(personCard1);
            cardBox.addPerson(personCard2);
        } catch (CardBoxException e) {

        }

        cardBox.showContent();
    }
}
