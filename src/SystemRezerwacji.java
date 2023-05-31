import java.io.*;
import java.util.ArrayList;
import java.util.List;
class SystemRezerwacji extends Exception {
    private List<Lot> listaLotow;
    private List<Klient> listaKlientow;
    private List<Rezerwacja> listaRezerwacji;

    // Metody związane z obsługą plików

    public void zapiszListeLotow(String nazwaPliku) {
        try {
            FileWriter writer = new FileWriter(nazwaPliku);
            for (Lot lot : listaLotow) {
                writer.write(lot.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void odczytajListeLotow(String nazwaPliku) {
        try {
            FileReader reader = new FileReader(nazwaPliku);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linia;
            while ((linia = bufferedReader.readLine()) != null) {
                // Tworzenie obiektu Lot na podstawie odczytanej linii i dodanie go do listy lotów
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metody obsługujące rezerwacje

    public void zarezerwujLot(Lot lot, Klient klient, Miejsce miejsce) throws RezerwacjaException {
        if (!lot.getDostepneMiejsca().contains(miejsce)) {
            throw new RezerwacjaException("To miejsce jest już zarezerwowane.");
        }
        Rezerwacja rezerwacja = new Rezerwacja(lot, klient, miejsce);
        listaRezerwacji.add(rezerwacja);
        lot.getDostepneMiejsca().remove(miejsce);
    }

    public void usunRezerwacje(Rezerwacja rezerwacja) throws UsuniecieRezerwacjiException {
        if (!listaRezerwacji.contains(rezerwacja)) {
            throw new UsuniecieRezerwacjiException("Podana rezerwacja nie istnieje.");
        }
        listaRezerwacji.remove(rezerwacja);
        rezerwacja.getLot().getDostepneMiejsca().add(rezerwacja.getZarezerwowaneMiejsce());
    }

    // Metody wyświetlające listy dostępnych lotów i typów biletów z wykorzystaniem polimorfizmu

    public void wyswietlDostępneLoty() {
        for (Lot lot : listaLotow) {
            System.out.println(lot.toString());
        }
    }

    public void wyswietlDostępneTypyBiletow() {
        List<Bilet> listaBiletow = new ArrayList<>();
        listaBiletow.add(new KlasaEkonomiczna());
        listaBiletow.add(new KlasaBiznesowa());

        for (Bilet bilet : listaBiletow) {
            System.out.println(bilet.toString());
        }
    }
}