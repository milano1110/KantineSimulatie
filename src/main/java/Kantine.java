public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
      * In deze methode wordt een dienblad met artikelen
      * in de kassarij geplaatst.
      *
      * @param dienblad
      */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        for(int i = 0; i < artikelnamen.length; i++) {
            Artikel currentArtikel = kantineAanbod.getArtikel(artikelnamen[i]);
            dienblad.voegToe(currentArtikel);
        }
        kassarij.sluitAchteraan(dienblad);
/*
Opdracht 1b:
        Persoon persoon = new Persoon();
        Dienblad dienblad = new Dienblad(persoon);
        Artikel artikel1 = new Artikel("brood", 2.00);
        Artikel artikel2 = new Artikel("kaas", 3.00);

        dienblad.voegToe(artikel1);
        dienblad.voegToe(artikel2);

        kassarij.sluitAchteraan(dienblad);
 */
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     * Opgave 1a: Omdat je niet weet hoe groot de rij voor de kassa is.
     */

    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public Kassa getKassa() {
        return kassa;
    }

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}
