import java.io.Serializable;
import java.util.UUID;

/**
 * Abstrakcyjna klasa reprezentująca bilet.
 */
public abstract class Bilet implements Serializable { // zaimplementowane Serializable będzie dziedziczone
    // Pola wspólne dla wszystkich rodzajów biletów
    private UUID numerBiletu;
    private double cena;
    private Miejsce miejsce;

    /**
     * Konstruktor klasy Bilet.
     *
     * @param numerBiletu numer biletu
     * @param cena        cena biletu
     */
    public Bilet(UUID numerBiletu, double cena, Miejsce miejsce) {
        this.numerBiletu = numerBiletu;
        this.cena = cena;
        this.miejsce = miejsce;
    }

    /**
     * Pobiera numer biletu.
     *
     * @return numer biletu
     */
    public UUID getNumerBiletu() {
        return numerBiletu;
    }

    /**
     * Pobiera cenę biletu.
     *
     * @return cena biletu
     */
    public double getCena() {
        return cena;
    }
    public Miejsce getMiejsce(){
        return  miejsce;
    }
}

/**
 * Klasa reprezentująca bilet klasy ekonomicznej.
 */
class KlasaEkonomiczna extends Bilet implements ISerializowalne {

    /**
     * Konstruktor klasy KlasaEkonomiczna.
     *
     * @param numerBiletu numer biletu
     * @param cena        cena biletu

     */
    public KlasaEkonomiczna(UUID numerBiletu, double cena, Miejsce miejsce) {
        super(numerBiletu, cena,miejsce);

    }


    /**
     * Zwraca tekstową reprezentację obiektu KlasaEkonomiczna.
     *
     * @return tekstowa reprezentacja obiektu KlasaEkonomiczna
     */
    @Override
    public String toString() {
        return "\n----------------------------------------------"+
                "\nKlasaEkonomiczna" +
                "\n----------------------------------------------"+
                "\nnumerBiletu='" + getNumerBiletu() + '\'' +
                "\ncena=" + getCena();


    }

    @Override
    public String serializuj() {
        return "{\"numerBiletu\":"+getNumerBiletu()+
                ",\"cena\":"+getCena()+"\"}";
    }
}
/**
 * Klasa reprezentująca bilet klasy biznesowej.
 */
class KlasaBiznesowa extends Bilet implements  ISerializowalne{

    private Boolean czyPosilek;
    /**
     * Konstruktor klasy KlasaBiznesowa.
     *
     * @param numerBiletu   numer biletu
     * @param cena          cena biletu
     * @param miejsce   numer miejsce
     */
    public KlasaBiznesowa(UUID numerBiletu, double cena, Miejsce miejsce,Boolean czyPosilek) {
        super(numerBiletu, cena,miejsce);
        this.czyPosilek = czyPosilek;
    }

    /**
     * Pobranie informacji o posiłku
     *
     * @return bool
     */
    public boolean getPosilek(){
        return czyPosilek;
    }
    /**
     * Zwraca tekstową reprezentację obiektu KlasaBiznesowa.
     *
     * @return tekstowa reprezentacja obiektu KlasaBiznesowa
     */
    @Override
    public String toString() {
        return "\n----------------------------------------------"+
                "\nKlasaBiznesowa" +
                "\n----------------------------------------------"+
                "\nnumerBiletu='" + getNumerBiletu() + '\'' +
                "\ncena=" + getCena() +
                "\nposiłek="+ czyPosilek;


    }
    @Override
    public String serializuj() {
        return "{\"numerBiletu\":"+getNumerBiletu()+
                ",\"cena\":"+getCena()+
                ",\"posilek\":"+getPosilek()+"\"}";
    }
}