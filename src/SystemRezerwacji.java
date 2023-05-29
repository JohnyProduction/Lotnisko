import java.io.*;
import java.util.ArrayList;
import java.util.List;
class SystemRezerwacji {
    private List<Lot> listaLotów;
    private List<Klient> listaKlientów;
    private List<Rezerwacja> listaRezerwacji;

    // Metody związane z obsługą plików

    public void zapiszListęLotów(String nazwaPliku) {
        try {
            FileWriter writer = new FileWriter(nazwaPliku);
            for (Lot lot : listaLotów) {
                writer.write(lot.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void odczytajListęLotów(String nazwaPliku) {
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
        if (!lot.getDostępneMiejsca().contains(miejsce)) {
            throw new RezerwacjaException("To miejsce jest już zarezerwowane.");
        }
        Rezerwacja rezerwacja = new Rezerwacja(lot, klient, miejsce);
        listaRezerwacji.add(rezerwacja);
        lot.getDostępneMiejsca().remove(miejsce);
    }

    public void usuńRezerwację(Rezerwacja rezerwacja) throws UsunięcieRezerwacjiException {
        if (!listaRezerwacji.contains(rezerwacja)) {
            throw new UsunięcieRezerwacjiException("Podana rezerwacja nie istnieje.");
        }
        listaRezerwacji.remove(rezerwacja);
        rezerwacja.getLot().getDostępneMiejsca().add(rezerwacja.getZarezerwowaneMiejsce());
    }

    // Metody wyświetlające listy dostępnych lotów i typów biletów z wykorzystaniem polimorfizmu

    public void wyświetlDostępneLoty() {
        for (Lot lot : listaLotów) {
            System.out.println(lot.toString());
        }
    }

    public void wyświetlDostępneTypyBiletów() {
        List<Bilet> listaBiletów = new ArrayList<>();
        listaBiletów.add(new KlasaEkonomiczna());
        listaBiletów.add(new KlasaBiznesowa());

        for (Bilet bilet : listaBiletów) {
            System.out.println(bilet.toString());
        }
    }
}