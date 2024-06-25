public class Main {
    public static void main(String[] args) {
        SuchAuftrag suchAuftrag = new SuchAuftrag("1");
        Hotelsuche hotelsuche = new Hotelsuche();
        SuchErgebnis suchErgebnis = hotelsuche.suchen(suchAuftrag);
        System.out.println(suchErgebnis.ergebnis);
    }
}