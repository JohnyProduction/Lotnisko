import java.io.Serializable;

/**
 * Klasa reprezentująca klienta
 */
public class Klient implements Drukowalny,ISerializowalne, Serializable {
    private int idKlienta;
    private String imie;
    private String nazwisko;
    private String adres;
    private String numerTelefonu;

    /**
     * Kontruktor domyślny klasy Klient
     *
     * @param imie imie klienta
     * @param nazwisko nazwisko klienta
     * @param adres adres klienta
     * @param numerTelefonu numer telefonu klienta
     */
    public Klient (int idKlienta,String imie, String nazwisko, String adres, String numerTelefonu){
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.numerTelefonu = numerTelefonu;
    }

    /**
     * Pobiera id klienta
     *
     * @return idKlienta
     */
    public int getIdKlienta(){
        return idKlienta;
    }
    /**
     * Pobiera imie klienta
     *
     * @return imie klienta
     */
    public String getImie() {

        return imie;
    }

    /**
     * Pobiera nazwisko klienta
     *
     * @return nazwisko klienta
     */
    public String getNazwisko() {

        return nazwisko;
    }

    /**
     * Pobiera adres klienta
     *
     * @return adres klienta
     */
    public String getAdres() {

        return adres;
    }

    /**
     * Pobiera numer telefonu
     *
     * @return numer telefonu
     */
    public String getNumerTelefonu() {

        return numerTelefonu;
    }

    /**
     * Zwraca tekstową reprezentację obiektu Klient.
     *
     * @return tekstowa reprezentacja obiektu Klient
     */
    @Override
    public void drukuj(){
        System.out.println("Klient :");
        System.out.println("    Id Klienta: "+idKlienta);
        System.out.println("    Imie: "+imie);
        System.out.println("    Nazwisko: "+nazwisko);
        System.out.println("    Adres: "+adres);
        System.out.println("    Numer Telefonu: "+numerTelefonu);
        System.out.println("----------------------------");
    }

    @Override
    public String serializuj() {
        return "{\"idKlienta\":"+getIdKlienta() +
                ",\"imie\":"+getImie()+
                ",\"nazwisko\":"+getNazwisko()+
                ",\"adres\":"+getAdres()+
                ",\"numerTelefonu\":"+getNumerTelefonu()+"\"}";
    }

    @Override
    public String toString(){
        return "ID klienta: " +idKlienta+ "\n" +
                "imie:"+getImie()+ "\n" +
                "nazwisko:"+getNazwisko()+ "\n" +
                "adres:"+getAdres()+ "\n" +
                "numerTelefonu:"+getNumerTelefonu() + "\n";
    }
}
