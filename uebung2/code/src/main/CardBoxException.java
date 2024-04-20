package main;

/**
 * checked Exception fuer das illegale Hinzufügen einer PersonCard, falls diese bereits in der CardBox vorhanden ist.
 * */


public class CardBoxException extends Exception {
    public CardBoxException() {}

    /**
     * @param   id ID des PersonCard Objekts, welches sich bereits in der CardBox befindet
     * */
    public CardBoxException(int id) {
            super("Das CardBox-Objekt mit der ID [" + id + "] ist bereits vorhanden.");
        }

}
