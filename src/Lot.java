import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca loty
 */
public class Lot implements ISerializowalne, Serializable {
    private int idLotu;
    private String miejsceWylotu;
    private String miejscePrzylotu;
    private String data;
    private String godzina;
    private double cena;
    private List<Miejsce> dostepneMiejsca;

    /**
     * Konstruktor klasy Lot
     *
     * @param miejsceWylotu miejsce wylotu samolotu
     * @param miejscePrzylotu miejsce destynacji samolotu
     * @param data  data lotu
     * @param godzina godzina lotu
     * @param cena cena lotu
     * @param iloscRzedow ilosc rzędów w samolocie
     * @param iloscSiedzen ilosc siedzeń w rzędzie
     */
    public Lot (int idLotu, String miejsceWylotu, String miejscePrzylotu, String data, String godzina, double cena, int iloscRzedow,int iloscSiedzen){
        this.idLotu = idLotu;
        this.miejsceWylotu = miejsceWylotu;
        this.miejscePrzylotu = miejscePrzylotu;
        this.data = data;
        this.godzina = godzina;
        this.cena = cena;
        this.dostepneMiejsca = new ArrayList<>();
        for(int rzad=1;rzad<=iloscRzedow;rzad++){
            for (int siedzenie=1;siedzenie<=iloscSiedzen;siedzenie++){
                dostepneMiejsca.add(new Miejsce(siedzenie,rzad));

            }
        }
    }
/*
    public Lot (int idLotu, String miejsceWylotu, String miejscePrzylotu, String data, String godzina, double cena,List<Miejsce> listaMiejsc){
        this.idLotu= idLotu;
        this.miejsceWylotu = miejsceWylotu;
        this.miejscePrzylotu = miejscePrzylotu;
        this.data = data;
        this.godzina = godzina;
        this.cena = cena;
        this.dostepneMiejsca = listaMiejsc;

    }
*/
    /**
     * Pobiera id lotu
     *
     * @return idLotu
     */
    public int getIdLotu() {
        return idLotu;
    }

    /**
     * Pobiera informacje na temat miejsca wylotu
     *
     * @return miejsce wylotu
     */
    public String getMiejsceWylotu() {
        return miejsceWylotu;
    }

    /**
     * Pobiera miejsce przylotu
     *
     * @return destynacja
     */
    public String getMiejscePrzylotu() {
        return miejscePrzylotu;
    }

    /**
     * Pobiera date lotu
     *
     * @return data lotu
     */
    public String getData() {
        return data;
    }

    /**
     * Pobiera godzine wylotu
     *
     * @return godzina wylotu
     */
    public String getGodzina() {
        return godzina;
    }

    /**
     * Pobiera cene za lot
     *
     * @return cena lotu
     */
    public double getCena() {
        return cena;
    }

    /**
     * Pobiera dostępne miejsca w samolocie (locie)
     *
     * @return dostępne miejsca
     */
    public List<Miejsce> getDostepneMiejsca() {
        return dostepneMiejsca;
    }

    /**
     * Pobranie informacji czy miejsce jest dostępne
     *
     * @param numerRzedu numer rzędu
     * @param numerSiedzenia numer siedzenie w rzędzie
     * @return bool
     */
    public boolean czyDostepneMiejsce(int numerRzedu,int numerSiedzenia){
        return dostepneMiejsca.stream().anyMatch(miejsce ->
                miejsce.getRzad() == numerRzedu && miejsce.getNumer() ==numerSiedzenia);
    }

    /**
     * Zarezerwowanie miejsca
     *
     * @param numerRzedu numer rzędzu
     * @param numerSiedzenia numer siedzenia w rzędzie
     */
    public void zarezerwujMiejsce(int numerRzedu,int numerSiedzenia){
        dostepneMiejsca.removeIf(miejsce ->
                miejsce.getRzad() == numerRzedu && miejsce.getNumer() ==numerSiedzenia);
    }

    /**
     * Anulowanie zarezerwowanego miejsca
     *
     * @param numerRzedu numer rzędu
     * @param numerSiedzenia numer siedzenie w rzędzie
     */
    public void anulujZarezerwowaneMiejsce(int numerRzedu,int numerSiedzenia){
        if(czyDostepneMiejsce(numerRzedu,numerSiedzenia)){
            return;
        }
        dostepneMiejsca.add(new Miejsce(numerRzedu,numerSiedzenia));
    }


    /**
     * Zwraca tekstową reprezentację obiektu Lot.
     *
     * @return tekstowa reprezentacja obiektu Lot
     */
    @Override
    public String toString(){
        return "ID lotu: " +idLotu+
                "\nMiejsce wylotu: " +miejsceWylotu+
                "\n Miejsce przylotu: "+miejscePrzylotu+
                "\n Data: "+data+
                "\n Godzina:"+ godzina +
                "\n Cena:" + cena + "\n";
    }

    @Override
    public String serializuj() {
        return "{\"miejsceWylotu\":"+getMiejsceWylotu()+
                ",\"miejscePrzylotu\":"+getMiejscePrzylotu()+
                ",\"data\":"+getData()+
                ",\"godzina\":"+getGodzina()+
                ",\"cena\":"+getCena()+
                ",\"miejca\":["+serializujMiejsca()+"],\"}";
    }
    String serializujMiejsca(){
        String s = "";
        for (Miejsce miejsce: dostepneMiejsca)
        {
        s+=miejsce.serializuj();
        s+=",";
        }
        return s.substring(0,s.length()-2);
    }
}
