/**
 * Klasa reprezentująca Miejsce
 */
public class Miejsce implements ISerializowalne{
    private int numer;
    private int rzad;


    /**
     * Konstruktor klasy Miejsce
     * @param numer numer miejsca
     * @param rzad rząd w którym się znajduje
     */
    public Miejsce(int numer, int rzad){
        this.numer = numer;
        this.rzad = rzad;
    }

    /**
     *Pobiera numer miejsca
     *
     * @return numer miejsca
     */
    public int getNumer() {
        return numer;
    }

    /**
     * Pobiera rząd w którym jest miejsce
     *
     * @return rząd w którym jest miejsce
     */
    public int getRzad() {
        return rzad;
    }
    /**
     * Zwraca tekstową reprezentację obiektu Miejsce.
     *
     * @return tekstowa reprezentacja obiektu Miejsce
     */
    @Override
    public String toString() {
        return "Miejsce: " +
                " Numer: " + numer +
                "\n Rząd: " + rzad;
    }
    @Override
    public String serializuj() {
        return "{\"numer\":"+getNumer()+
                ",\"rzad\":"+getRzad()+"\"}";

    }
}
