public class Miejsce {
    private int numer;
    private int rzad;
    private String klasa;

    // Konstruktor, metody dostępowe itp.
    public Miejsce(int numer, int rzad, String klasa){
        this.numer = numer;
        this.rzad = rzad;
        this.klasa = klasa;
    }

    public int getNumer() {
        return numer;
    }

    public int getRzad() {
        return rzad;
    }

    public String getKlasa() {
        return klasa;
    }

    @Override
    public String toString() {
        return "Miejsce: " +
                " Numer: " + numer +
                "\n Rząd: " + rzad +
                "\n Klasa: " + klasa;
    }
}
