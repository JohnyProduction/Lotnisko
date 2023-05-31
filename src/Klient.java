public class Klient implements Drukowalny {
    private String imie;
    private String nazwisko;
    private String adres;
    private String numerTelefonu;

    // Konstruktor, metody dostępowe itp.
    public Klient (String imie, String nazwisko, String adres, String numerTelefonu){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.numerTelefonu = numerTelefonu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    @Override
    public void drukuj(){
        System.out.println("Klient :");
        System.out.println("    Imie: "+imie);
        System.out.println("    Nazwisko: "+nazwisko);
        System.out.println("    Adres: "+adres);
        System.out.println("    Numer Telefonu: "+numerTelefonu);
        System.out.println("----------------------------");
    }
}
