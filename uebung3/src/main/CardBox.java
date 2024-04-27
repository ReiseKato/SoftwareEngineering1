package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardBox {

    // Singleton
    private static CardBox cardBox;

    /**Variables*/
    private ArrayList<PersonCard> cards;
    private String filename = "CardBox.txt";

    /**Constructor*/
    private CardBox() {
        cards = new ArrayList<>();
    }

    public static CardBox getInstance()
    {
        if(cardBox == null) {
            return new CardBox();
        }
        return cardBox;
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
     * Gibt aktuelle Anzahl an Elementen in CardBox zurueck.
     * */
    public int size() {
        return cards.size();
    }

    /**
     * Speichert alle PersonCard in der CardBox in einer Datei.
     *
     * @throws CardBoxStorageException
     */
    public void save() throws CardBoxStorageException {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            fos.getChannel().truncate(0);
            for(PersonCard card : cards) {
                oos.writeObject(card);
            }
            oos.close();
        } catch (IOException e) {
            throw new CardBoxStorageException("Fehler beim Speichern der Card Box.", e);
        }
    }

    /**
     * Lädt die abgespeicherte Datei und speichert belegt die geleerte CardBox mit den PersonCard aus der Datei.
     *
     * @throws CardBoxStorageException
     */
    public void load() throws CardBoxStorageException {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cards.clear();
            while(true) {
                try {
                    this.addPerson((PersonCard)ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (IOException e) {
            throw new CardBoxStorageException("Fehler beim Laden der Datei.", e);
        } catch (ClassNotFoundException e) {
            throw new CardBoxStorageException("Fehler beim Laden der Karten.", e);
        } catch (CardBoxException e) {
            throw new CardBoxStorageException("Fehler beim Einfügen der Karte.", e);
        }
    }

    /**
     * getter-Methode fuer die Liste aller PersonCard in CardBox Objekt
     *
     * @return  Liste aller PersonCard in CardBox Objekt
     */
    public List<PersonCard> getCurrentList() {
        return cards;
    }
}

