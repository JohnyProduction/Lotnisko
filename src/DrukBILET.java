import java.io.Serializable;
import java.util.Optional;

/**
 * Klasa reprezentująca druk biletu
 */

public class DrukBILET implements Drukowalny, Serializable {
    private Miejsce miejsce;
    private Lot lot;
    private Optional<Bilet> bilet;
    private Klient klient;

    /**
     * Konstruktor klasy DrukBILET
     *
     * @param miejsce informacje o miejscu
     * @param lot informacje o locie
     * @param bilet informacje o bilecie
     */
    public DrukBILET (Miejsce miejsce, Lot lot, Optional<Bilet> bilet, Klient klient){
        this.miejsce =miejsce;
        this.bilet = bilet;
        this.lot = lot;
        this.klient = klient;
    }

    /**
     * Zwraca tekstową reprezentację obiektu DrukBILET.
     *
     * @return tekstowa reprezentacja obiektu DrukBILET
     */

    @Override
    public void  drukuj(){
        System.out.println("****************************************************************************");
        System.out.println("*********************************--TICKET--*********************************");
        System.out.println("****************************************************************************");
        System.out.println("Dane klienta: " +klient.getImie()+ " " + klient.getNazwisko() + " " + klient.getNumerTelefonu());
        System.out.println("Dane lotu:     Z "+ lot.getMiejsceWylotu() + " DO "+ lot.getMiejscePrzylotu());
        System.out.println("          Data i godzina: " + lot.getData() + " " + lot.getData());
        System.out.println("Miejsce: " + miejsce.getNumer());
        System.out.println("Rzad: "+miejsce.getRzad());
        System.out.println("****************************************************************************");
    }
    /*

    @Override
    public void drukuj(){
        System.out.println("****************************************************************************");
        System.out.println("*********************************--TICKET--*********************************");
        System.out.println("****************************************************************************");
        System.out.println("Dane klienta: " + .imie + " " + nazwisko + " " + numerTelefonu );
        System.out.println("Dane lotu:     Z "+ miejsceStartowe + " DO "+ miejsceDocelowe);
        System.out.println("          Data i godzina: " + dataWylotu + " " + godzinaWylotu);
        System.out.println("Klasa: " + klasa);
        System.out.println("Miejsce: " + numerMiejsca);
        System.out.println("Rzad: "+numerRzedu);
        System.out.println("****************************************************************************");
    }
    */

}