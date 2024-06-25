public class Hotelsuche {
    HotelsucheAdapter hotelsucheAdapter;
    public Hotelsuche(ReiseAnbieter reiseAnbieter) {
        hotelsucheAdapter = new HotelsucheAdapter(reiseAnbieter);
    }
    public SuchErgebnis suchen(SuchAuftrag auf){
        return hotelsucheAdapter.suchen(auf);
    }
}
