import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
/**
 * Główna klasa programu.
 */
public class Main {
    public static void main(String[] args) {

        Klient klient;
        Lot lot = null;
        Optional<Bilet> bilet;
        SystemRezerwacji systemRezerwacji = new SystemRezerwacji();
        List<Optional<Bilet>> bilety = new ArrayList<>();
        List<Lot> dostepneLoty = new ArrayList<>();
        List<Klient> klienci =new ArrayList<>();
        List<SystemRezerwacji> rezerwacje  = new ArrayList<>();
        List<Miejsce> dostepneMiejsca = new ArrayList<>();

        int idKlienta = 0;
        int idLotu = 0;
        String nazwaPliku ="";
        int number = 0;
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        while(!flag) {
            switch (number) {
                case 0:
                    System.out.println("****************************************************************************");
                    System.out.println("*********************************--MENU--***********************************");
                    System.out.println("****************************************************************************");
                    System.out.println("Wybierz opcje");
                    System.out.println("1. Stworz klienta");
                    System.out.println("2. Stworz lot");
                    System.out.println("3. Stworz rezerwacje");
                    System.out.println("4. Anuluj rezerwacje");
                    System.out.println("5. Wyswietl dostepne loty");
                    System.out.println("6. Wyswietl bilety");
                    System.out.println("7. Zapisz liste lotow");
                    System.out.println("8. Odczytaj listę lotow");
                    System.out.println("9. Exit");
                    System.out.println("****************************************************************************");

                    String value = in.nextLine();
                    number = Integer.parseInt(value);

                    break;
                case 1:
                    String imie;
                    String nazwisko;
                    String adres;
                    String numerTelefonu;

                    System.out.flush();
                    System.out.println("Podaj imie klienta: ");
                    imie = in.nextLine();
                    System.out.println("Podaj nazwisko klienta: ");
                    nazwisko = in.nextLine();
                    System.out.println("Podaj adres klienta: ");
                    adres = in.nextLine();
                    System.out.println("Podaj numer telefonu klienta: ");
                    numerTelefonu = in.nextLine();
                    klient = new Klient(idKlienta,imie, nazwisko, adres, numerTelefonu);
                    klienci.add(klient);
                    idKlienta++;
                    System.out.flush();

                    System.out.println("\nDodano klienta: ");
                    klient.drukuj();
                    number = 0;

                    break;
                case 2:
                    String miejsceWylotu;
                    String miejscePrzylotu;
                    String data;
                    String godzina;
                    double cena;
                    int iloscRzedow;
                    int iloscSiedzen;
                    Lot wybranyLot = null;

                    System.out.flush();
                    System.out.println("Podaj miejsce startowe: ");
                    miejsceWylotu = in.nextLine();
                    System.out.println("Podaj miejsce docelowe: ");
                    miejscePrzylotu = in.nextLine();
                    System.out.println("Podaj date: ");
                    data = in.nextLine();
                    System.out.println("Podaj godzine: ");
                    godzina = in.nextLine();
                    System.out.println("Podaj cenę: ");
                    String cenaString = in.nextLine();
                    cena = Double.parseDouble(cenaString);
                    System.out.println("Podaj ilosc rzedow: ");
                    String rzedy = in.nextLine();
                    iloscRzedow = Integer.parseInt(rzedy);
                    System.out.println("Podaj ilosc siedzen: ");
                    String siedzenie = in.nextLine();
                    iloscSiedzen = Integer.parseInt(siedzenie);
                    lot = new Lot(idLotu,miejsceWylotu, miejscePrzylotu, data, godzina, cena, iloscRzedow, iloscSiedzen);
                    dostepneLoty.add(lot);
                    System.out.flush();
                    System.out.println("\nDodano lot: ");
                    System.out.println(lot);
                    idLotu++;
                    number= 0;
                    break;
                case 3:


                    Boolean czyEkomoniczna;

                    System.out.println("Dostepni klienci: ");
                    for (Klient klient1 : klienci) {
                        System.out.println(klient1.toString());
                    }
                    System.out.println("Wybierz klienta: ");
                    String numerKlientaString = in.nextLine();
                    int numerKlienta = Integer.parseInt(numerKlientaString);

                    System.out.println("Dostępne loty: ");
                    for (Lot lot1 : dostepneLoty) {
                        System.out.println(lot1.toString());
                    }
                    System.out.println("Wybierz id lotu:");
                    String numerLotuString = in.nextLine();
                    int numerLotu = Integer.parseInt(numerLotuString);
                    //lot.getDostepneMiejsca();

                    wybranyLot = null; // Initialize with null
                    for (Lot lotIt : dostepneLoty) {
                        if (lotIt.getIdLotu() == numerLotu) {
                            wybranyLot = lotIt;
                        }
                    }
                    if (wybranyLot == null) {
                        wybranyLot = dostepneLoty.get(0);
                    }

                    System.out.println("Dostępne miejsca:");
                    for (Miejsce miejsce : wybranyLot.getDostepneMiejsca()) {
                        System.out.println("Rząd: " + miejsce.getRzad() + ", Numer: " + miejsce.getNumer());
                    }
                    System.out.println("Podaj rząd: ");
                    String numerRzeduString = in.nextLine();
                    int numerRzedu = Integer.parseInt(numerRzeduString);
                    System.out.println("Podaj miejsce: ");
                    String numerSiedzeniaString = in.nextLine();
                    int numerSiedzenia = Integer.parseInt(numerSiedzeniaString);
                    Miejsce miejsce = new Miejsce(numerSiedzenia,numerRzedu);
                    System.out.println("Jaki bilet chcesz zarezerwować: ");
                    System.out.println("1. Ekonomiczny: ");
                    System.out.println("2. Biznesowy: ");
                    String typString = in.nextLine();
                    int typ = Integer.parseInt(typString);
                    Boolean czyEkonomiczna = true;
                    if (typ == 1){
                        czyEkomoniczna = true;
                    }
                    if (typ == 2){
                        czyEkomoniczna = false;
                    }
                    Lot lotNew = dostepneLoty.stream()
                            .filter(lot1 -> lot1.getIdLotu() == numerLotu)
                            .findFirst().orElse(null);
                    Klient klientNew = klienci.stream()
                            .filter(klient1 -> klient1.getIdKlienta() == numerKlienta)
                            .findFirst().orElse(null);
                    bilet = systemRezerwacji.zarezerwujBilet(lotNew, miejsce, czyEkonomiczna);
                    bilety.add(bilet);
                    Drukowalny druk = new DrukBILET(miejsce,lotNew,bilet,klientNew);
                    druk.drukuj();
                    number = 0;

                    break;
                case 4:
                    System.out.println("Dostepne bilety: ");
                    for (Optional<Bilet> bilet1: bilety) {
                        System.out.println(bilet1.toString());
                    }
                    System.out.println("Wybierz bilet do anulowania: ");
                    String numerBiletu = in.nextLine();
                    UUID nBiletu = UUID.fromString(numerBiletu);
                /* to nie działa trzeba naprawić
                Optional<Bilet> biletNew = bilety.stream()
                        .filter(bilet1 -> bilet1.getNumerBiletu().equals(nBiletu))
                        .findFirst();
                        */

                    try {
                        //systemRezerwacji.anulujBilet(biletNew);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 5:
                    systemRezerwacji.wyswietlDostępneLoty();
                    break;
                case 6:
                    systemRezerwacji.wyswietlBilety();
                    break;
                case 7:
                    System.out.println("Podaj nazwę pliku (razem z formatem txt): ");
                    nazwaPliku = in.nextLine();
                    systemRezerwacji.zapiszListeLotow(nazwaPliku);
                    break;
                case 8:
                    systemRezerwacji.odczytajListeLotow(nazwaPliku);
                    break;
                case 9:
                    flag = true;
                    break;
                default:
                    System.out.println("Bledny numer wybierz ponownie");
                    break;
            }
        }
    }
}