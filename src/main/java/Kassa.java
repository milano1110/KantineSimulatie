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
     * Opdracht 4d
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Iterator<Artikel> iter = klant.getIterator();
        if (iter != null) {
            double totaalbedrag = 0;
            int totaalArtikelen = 0;
            double kortingsbedrag = 0;
            double kortingspercentage;

            while (iter.hasNext()) {
                Artikel artikel = iter.next();
                totaalbedrag += (artikel.getPrijs() - artikel.getKorting());
                totaalArtikelen++;

                if (artikel.getKorting() == 0.00) {
                    if (klant.getKlant() instanceof Docent) {
                        kortingspercentage = ((Docent) klant.getKlant()).geefKortingsPercentage();
                        kortingsbedrag += artikel.getPrijs() * (kortingspercentage / 100);
                        if (((Docent) klant.getKlant()).heeftMaximum()) {
                            double maximum = ((Docent) klant.getKlant()).geefMaximum();
                            if (kortingsbedrag > maximum) {
                                kortingsbedrag = maximum;
                            }
                        }
                    }
                    if (klant.getKlant() instanceof KantineMedewerker) {
                        kortingspercentage = ((KantineMedewerker) klant.getKlant()).geefKortingsPercentage();
                        kortingsbedrag += artikel.getPrijs() * (kortingspercentage / 100);
                        if (((KantineMedewerker) klant.getKlant()).heeftMaximum()) {
                            double maximum = ((KantineMedewerker) klant.getKlant()).geefMaximum();
                            if (kortingsbedrag > maximum) {
                                kortingsbedrag = maximum;
                            }
                        }
                    }
                }
            }

            try {
                double kortingtotaalbedrag = totaalbedrag - kortingsbedrag;
                Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
                double saldo = betaalwijze.getSaldo();
                betaalwijze.betaal(kortingtotaalbedrag);
                betaalwijze.setSaldo(saldo - kortingtotaalbedrag);
                totaalAantalGeld += kortingtotaalbedrag;
                totaalAantalArtikelen += totaalArtikelen;
            } catch (TeWeinigGeldException e) {
                System.out.println(klant.getKlant().getVoorNaam() + " heeft te weinig saldo.");
            }
        }
    }

    public KassaRij getKassarij() {
        return kassarij;
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
}
