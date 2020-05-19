import java.util.Iterator;

public class Kassa {

    private KassaRij kassarij;
    private int totaalAantalArtikelen;
    private double totaalAantalGeld;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
        this.totaalAantalArtikelen = 0;
        this.totaalAantalGeld = 0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        //String gegevens = "Aantal artikelen: " + klant.getAantalArtikelen() + "\nTotaalPrijs: " + klant.getTotaalPrijs();
        this.totaalAantalArtikelen += klant.getAantalArtikelen();
        this.totaalAantalGeld += klant.getTotaalPrijs();
    }

    /**
     * Geeft het aantal artikelen aan dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden (resetKassa?) is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return totaalAantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return totaalAantalGeld;
    }

    /**
     * Reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        this.totaalAantalGeld = 0;
        this.totaalAantalArtikelen = 0;
    }
}
