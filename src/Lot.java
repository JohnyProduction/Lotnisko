import java.util.ArrayList;
import java.util.List;
public class Lot {
    private String miejsceWylotu;
    private String miejscePrzylotu;
    private String data;
    private String godzina;
    private double cena;
    private List<Miejsce> dostepneMiejsca;

    // Konstruktor, metody dostępowe itp.
    public Lot (String miejsceWylotu, String miejscePrzylotu, String data, String godzina, double cena){
        this.miejsceWylotu = miejsceWylotu;
        this.miejscePrzylotu = miejscePrzylotu;
        this.data = data;
        this.godzina = godzina;
        this.cena = cena;
        this.dostepneMiejsca = new ArrayList<>();
    }

    public String getMiejsceWylotu() {
        return miejsceWylotu;
    }

    public String getMiejscePrzylotu() {
        return miejscePrzylotu;
    }

    public String getData() {
        return data;
    }

    public String getGodzina() {
        return godzina;
    }

    public double getCena() {
        return cena;
    }

    public List<Miejsce> getDostepneMiejsca() {

        return dostepneMiejsca;
    }
    public String toString(){
        return "Miejsce wylotu: " +miejsceWylotu+
                "\n Miejsce przylotu: "+miejscePrzylotu+
                "\n Data: "+data+
                "\n Godzina:"+ godzina +
                "\n Cena:" + cena;
    }
}
