import java.io.Serializable;

/**
 * Klasa reprezentująca Rezerwację
 */
public class Rezerwacja implements Serializable {
    private Lot lot;
    private Klient klient;
    private Miejsce zarezerwowaneMiejsce;

    /**
     * Kontruktor klasy Rezerwacja
     *
     * @param lot lot
     * @param klient klient
     * @param zarezerwowaneMiejsce miejsce
     */
    public Rezerwacja(Lot lot, Klient klient, Miejsce zarezerwowaneMiejsce){
        this.lot = lot;
        this.klient = klient;
        this.zarezerwowaneMiejsce = zarezerwowaneMiejsce;
    }

    /**
     * Pobiera informacje o locie
     *
     * @return lot
     */
    public Lot getLot() {

        return lot;
    }

    /**
     * Pobiera informacje o zarezerwowanym miejscu
     *
     * @return numer zarezerwowanego miejsca
     */
    public Miejsce getZarezerwowaneMiejsce() {

        return zarezerwowaneMiejsce;
    }

    /**
     * Pobiera informacje o kliencie
     *
     * @return informacje o kliencie
     */
    public Klient getKlient() {

        return klient;
    }

    /**
     * Zwraca tekstową reprezentację obiektu Rezerwacja.
     *
     * @return tekstowa reprezentacja obiektu Rezerwacja
     */
    @Override
    public String toString() {
        return "Rezerwacja" +
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
