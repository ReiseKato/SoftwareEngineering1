public class HotelsucheAdapter extends Hotelsuche {
    private ReiseAnbieter reiseAnbieter;
    public HotelsucheAdapter(ReiseAnbieter reiseAnbieter) {
        this.reiseAnbieter = reiseAnbieter;
    }

    public SuchErgebnis suchen(SuchAuftrag suchAuftrag) {
        return transformToSuchErgebnis(reiseAnbieter.suchen(transformToQueryObject(suchAuftrag)));
    }

    private QueryObject transformToQueryObject(SuchAuftrag suchAuftrag) {
        // Transform SuchAuftrag to QueryObject
    }

    private SuchErgebnis transformToSuchErgebnis(QueryResult queryResult) {
        // Transform from QueryResult to SuchErgebnis
    }
}