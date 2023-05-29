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
    public KlasaEkonomiczna() {
        super();
    }
    // Dodatkowe pola i metody dla biletów klasy ekonomicznej
}

class KlasaBiznesowa extends Bilet {
    public KlasaBiznesowa() {
        super();
    }
    // Dodatkowe pola i metody dla biletów klasy biznesowej
}