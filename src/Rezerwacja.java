public class Rezerwacja {
    private Lot lot;
    private Klient klient;
    private Miejsce zarezerwowaneMiejsce;

    // Konstruktor, metody dostępowe itp.
    public Rezerwacja(Lot lot, Klient klient, Miejsce zarezerwowaneMiejsce){
        this.lot = lot;
        this.klient = klient;
        this.zarezerwowaneMiejsce = zarezerwowaneMiejsce;
    }
    public Lot getLot() {
        return lot;
    }

    public Miejsce getZarezerwowaneMiejsce() {
        return zarezerwowaneMiejsce;
    }

    public Klient getKlient() {
        return klient;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" +
                "\nlot: " + lot +
                "\nklient: " + klient +
                "\nzarezerwowaneMiejsce: " + zarezerwowaneMiejsce;
    }
}
// Wyjątek przy próbie zarezerwowania już zajętego miejsca
class RezerwacjaException extends Exception {
    public RezerwacjaException(String message) {
        super(message);
    }

}
// Wyjątek przy próbie usunięcia nieistniejącej rezerwacji
class UsuniecieRezerwacjiException extends Exception {
    public UsuniecieRezerwacjiException(String message) {
        super(message);
    }

}
