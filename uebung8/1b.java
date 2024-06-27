public class ReiseAnbieterAdapter implements ReiseAnbieter {
    Hotelsuche hotelsuche;

    public ReiseAnbieterAdapter(Hotelsuche hotelsuche) {
        this.hotelsuche = hotelsuche;
    }

    public QueryResult runQuery(QeuryObject qeuryObject) {
        SuchAuftrag suchAuftrag = transformToSuchAuftrag(qeuryObject);
        SuchErgebnis suchErgebnis = hotelsuche.sucheHotel(suchAuftrag);
        return transformToQueryResult(suchErgebnis);
    }

    private SuchAuftrag transformToSuchAuftrag(QueryObject queryObject) {
        // transform QueryObject to SuchAuftrag
    }

    private QueryResult transformToQueryResult(SuchErgebnis suchErgebnis) {
        // transform SuchErgebnis to QueryResult
    }
}