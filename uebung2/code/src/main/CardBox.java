package main;

import java.util.ArrayList;

public class CardBox {

    /**Variables*/
    private ArrayList<PersonCard> cards;

    /**Constructor*/
    public CardBox() {
        cards = new ArrayList<>();
    }

    /**Methods*/

    /**
     * Hinzufügen einer PersonCard, falls diese nicht bereits vorhanden ist, sonst Exception.
     * @param   personCard  Fuegt die uebergebene PersonCard hinzu, falls noch nicht vorhanden.
     * @throws  CardBoxException    Wenn personCard bereits in CardBox enthalten.
     * */
    public void addPerson(PersonCard personCard) throws CardBoxException {
        if(cards.size() == 0) {
            cards.add(personCard);
            return;
        }
        for(PersonCard card : cards) {
            if(card.getId() == personCard.getId()) {
                throw new CardBoxException(personCard.getId());
            }
        }
        cards.add(personCard);
    }

    /**
     * Entfernen einer PersonCard, falls diese in CardBox vorhanden, sonst Fehlermeldung als String.
     * @param   id  entferne die personCard mit id aus CardBox.
     * @return      Fehlermeldung als String, falls personCard mit id nicht in CardBox.
     * */
    public String deletePerson(int id) {
        if(cards.size() == 0) {
            return "CardBox ist leer.";
        }
        for(PersonCard card : cards) {
            if(card.getId() == id) {
                cards.remove(card);
                return "";
            }
        }
        return "[" +  id + "] nicht in CardBox.";
    }

    /**
     * Anzeigen aller PersonCards in CardBox auf der Konsole.
     * */
    public void showContent() {
        for(PersonCard card : cards) {
            System.out.println(card.toString());
        }
    }

    /**
     * Gibt aktuelle Anzahl an Elementen in CardBox zurueck.
     * */
    public int size() {
        return cards.size();
    }
}

