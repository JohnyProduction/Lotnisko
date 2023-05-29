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
class RezerwacjaException extends Exception {
    public RezerwacjaException(String s) {
    }
    // Wyjątek przy próbie zarezerwowania już zajętego miejsca
}

class UsunięcieRezerwacjiException extends Exception {
    public UsunięcieRezerwacjiException(String s) {
    }
    // Wyjątek przy próbie usunięcia nieistniejącej rezerwacji
}
