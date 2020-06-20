import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class Kassa {

    private KassaRij kassarij;
    private int totaalAantalArtikelen;
    private double totaalAantalGeld;
    EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager eManager) {
        this.kassarij = kassarij;
        this.totaalAantalArtikelen = 0;
        this.totaalAantalGeld = 0;
        this.manager = eManager;
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
        Factuur factuur = new Factuur(klant, LocalDate.now());
        EntityTransaction transaction = null;

        /*
        int totaalArtikelen = 0;
        Iterator<Artikel> iter = klant.getIterator();
        if (iter != null) {
            while (iter.hasNext()) {
                Artikel artikel = iter.next();
                totaalArtikelen++;
            }
        }
         */

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            double kortingtotaalbedrag = factuur.getTotaal() - factuur.getKorting();
            Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
            double saldo = betaalwijze.getSaldo();
            betaalwijze.betaal(kortingtotaalbedrag);
            betaalwijze.setSaldo(saldo - kortingtotaalbedrag);
            totaalAantalGeld += kortingtotaalbedrag;
            totaalAantalArtikelen += factuur.getArtikelen(); //totaalArtikelen;
            System.out.println(factuur.toString());
            manager.persist(factuur);
            transaction.commit();
        } catch (TeWeinigGeldException e) {
            System.out.println(klant.getKlant().getVoorNaam() + " heeft te weinig saldo.");
            transaction.rollback();
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
