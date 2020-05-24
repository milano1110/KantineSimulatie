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
        Iterator<Artikel> iter = klant.getIterator();
        if (iter != null) {
            while (iter.hasNext()) {
                Artikel artikel = iter.next();
                this.totaalAantalGeld += artikel.getPrijs();
                this.totaalAantalArtikelen += 1;
            }
        }
    }

    /**
     * Geeft het aantal artikelen aan dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden (resetKassa?) is aangeroepen.
     * Opgave 4a: Bij deze methode.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return totaalAantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     * Opgave 4a: Bij deze methode.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return totaalAantalGeld;
    }

    /**
     * Reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     * Opgave 4a: Bij deze methode.
     */
    public void resetKassa() {
        this.totaalAantalGeld = 0;
        this.totaalAantalArtikelen = 0;
    }
/*
    public Iterator getIterator() {
        Iterator iter = kassarij.eerstePersoonInRij().iterator();
        while (iter.hasNext()) {
            Artikel element = (Artikel) iter.next();
            return element;
        }
    }

 */
}
