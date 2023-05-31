public abstract class Bilet {
    // Pola wspólne dla wszystkich rodzajów biletów
    private String numerBiletu;
    private double cena;
    private boolean czyZarezerwowany;

    public Bilet(String numerBiletu, double cena) {
        this.numerBiletu = numerBiletu;
        this.cena = cena;
        this.czyZarezerwowany = false;
    }

    public Bilet() {
        super();
    }

    public String getNumerBiletu() {
        return numerBiletu;
    }
    public double getCena() {
        return cena;
    }

    public boolean czyZarezerwowany() {
        return czyZarezerwowany;
    }

    public void zarezerwuj() {
        this.czyZarezerwowany = true;
    }

    public void anulujRezerwację() {
        this.czyZarezerwowany = false;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "numerBiletu='" + numerBiletu + '\'' +
                ", cena=" + cena +
                ", czyZarezerwowany=" + czyZarezerwowany +
                '}';
    }
}

class KlasaEkonomiczna extends Bilet {
    private String miejsce;

    public KlasaEkonomiczna(String numerBiletu, double cena, String miejsce) {
        super(numerBiletu, cena);
        this.miejsce = miejsce;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    // Dodatkowe metody dla biletów klasy ekonomicznej
}

class KlasaBiznesowa extends Bilet {
    private int numerSiedzenia;

    public KlasaBiznesowa(String numerBiletu, double cena, int numerSiedzenia) {
        super(numerBiletu, cena);
        this.numerSiedzenia = numerSiedzenia;
    }

    public int getNumerSiedzenia() {
        return numerSiedzenia;
    }

    public void setNumerSiedzenia(int numerSiedzenia) {
        this.numerSiedzenia = numerSiedzenia;
    }

    // Dodatkowe metody dla biletów klasy biznesowej
}