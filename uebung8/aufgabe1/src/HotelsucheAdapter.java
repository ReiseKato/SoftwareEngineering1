public class HotelsucheAdapter extends Hotelsuche {
    private ReiseAnbieter reiseAnbieter;
    public HotelsucheAdapter(ReiseAnbieter reiseAnbieter) {
        this.reiseAnbieter = reiseAnbieter;
    }

    public SuchErgebnis suchen(SuchAuftrag suchAuftrag) {
        System.out.println("transform");
        return transformToSuchErgebnis(reiseAnbieter.suchen(transformToQueryObject(suchAuftrag)));
    }

    private QueryObject transformToQueryObject(SuchAuftrag suchAuftrag) {
        return new QueryObject(suchAuftrag.auftrag);
    }

    private SuchErgebnis transformToSuchErgebnis(QueryResult queryResult) {
        return new SuchErgebnis(queryResult.res);
    }
}
