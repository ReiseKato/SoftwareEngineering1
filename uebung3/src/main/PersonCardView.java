package main;

import java.util.List;

public class PersonCardView {
    /**
     * Anzeigen aller PersonCards in CardBox auf der Konsole.
     * */
    public void showContent(List<PersonCard> liste) {
        for(PersonCard card : liste) {
            System.out.println(card.toString());
        }
    }
}
