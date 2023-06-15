import java.io.*;
import java.util.*;

/**
 * Klasa reprezentująca System rezerwacji
 */
class SystemRezerwacji extends Exception implements Serializable {
    private Map<Bilet,Lot> bilety;
    /**
     * Konstruktor klasy SystemRezerwacji.
     */
    public SystemRezerwacji() {
        bilety = new HashMap<Bilet,Lot>();
    }
    /**
     * Zapisuje listę lotów do pliku.
     *
     * @param nazwaPliku Nazwa pliku do którego mają być zapisane loty.
     */
    public void zapiszListeLotow(String nazwaPliku) {
        try {
            FileWriter writer = new FileWriter(nazwaPliku);
            for (Lot lot : bilety.values().stream().distinct().toList()) {
                writer.write(lot.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Odczytuje i wyświetla listę lotów z pliku.
     *
     * @param nazwaPliku Nazwa pliku do odczytania.
     */
    public void odczytajListeLotow(String nazwaPliku) {
        try {
            FileReader reader = new FileReader(nazwaPliku);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linia;
            while ((linia = bufferedReader.readLine()) != null) {
                System.out.println(linia);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rezerwuje bilet na lot.
     *
     * @param lot Lot, na który ma zostać zarezerwowany bilet.
     * @param miejsce, na które ma zostać zarezerwowany bilet.
     * @param czyEkonomiczna Określa, czy bilet ma być w klasie ekonomicznej, czy nie.
     * @return Opcja zawierająca zarezerwowany bilet, jeśli miejsce jest dostępne, lub pusta Opcja w przeciwnym razie.
     */
     public Optional<Bilet> zarezerwujBilet (Lot lot, Miejsce miejsce, Boolean czyEkonomiczna) {
        Boolean czyDostepne =lot.czyDostepneMiejsce(miejsce.getRzad(),miejsce.getNumer());
        if(czyDostepne == false) {
            return Optional.empty();
        }
        lot.zarezerwujMiejsce(miejsce.getRzad(),miejsce.getNumer());
        Bilet bilet;
        if(czyEkonomiczna){
             bilet = new KlasaEkonomiczna(UUID.randomUUID(),420 , miejsce);
        }
        else{
            bilet = new KlasaBiznesowa(UUID.randomUUID(),2137 , miejsce, true);
        }
        bilety.put(bilet,lot);
        return  Optional.of(bilet);
    }


    /**
     * Wyświetla informacje o wszystkich biletach w systemie.
     */
    public void wyswietlBilety() {
        for (Bilet bilet : bilety.keySet()) {
            System.out.println(bilet.toString());
        }
    }
    /**
     * Anuluje rezerwację biletu.
     *
     * @param bilet Bilet do anulowania.
     * @throws UsuniecieRezerwacjiException Jeśli podany bilet nie istnieje w rekordach rezerwacji.
     */
    public void anulujBilet(Optional<Bilet> bilet) throws UsuniecieRezerwacjiException {
        if (!bilety.containsKey(bilet)) {
            throw new UsuniecieRezerwacjiException("Podany bilet nie istnieje.");
        }
        /*
        bilety.get(bilet).anulujZarezerwowaneMiejsce(bilet.getMiejsce().getRzad(),bilet.getMiejsce().getNumer());
        bilety.remove(bilet);
*/
    }

    /**
     * Wyświetla dostępne loty.
     * Drukuje informacje o każdym unikalnym locie obecnym w rekordach rezerwacji.
     */
    public void wyswietlDostępneLoty() {
        for (Lot lot : bilety.values().stream().distinct().toList()) {
            System.out.println(lot.toString());
        }
    }
}