import java.util.*;
import java.text.DecimalFormat;

public class KantineSimulatie {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Constructor
     * Opdracht 6a: de constructor van kantineSimulatie maakt een nieuwe kantineSimulatie aan,
     * bij het aanmaken van een kantineSimulatie word er eerst een kantine aangemaakt,
     * daarna een variabele genaamt random, de variabele random is een random number generator.
     * daarna word er een int[] array aangemaakt genaamt hoeveelheden,
     * in deze array staan de gerandomisede hoeveelheid artikelen,
     * minimum artikelen per soort en maximale artikelen per soort.
     * hierna word er een instantie genaamd kantineaanbod aangemaakt,
     * dit is een KantineAanbod object, dit bevat het aanbod aan artikelen, hun namen, prijzen en hoeveelheiden.
     * daarna word het kantinaaanbod als het aanbod van de kantine gezet door kantine.setKantineAanbod(kantineaanbod);.
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * Opdracht 6b:
     * De minimale waarde van Random is inclusief, terwijl de maximale waarde exclusief is.
     * Dus bij min = 0 en max = 10, worden er nummers gegenereerd van 0 t/m 9, vandaar de +1.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */

    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = 100;

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad(persoon);
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = 3;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                 int[] tepakken = getRandomArray(
                    aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af
            System.out.println("Dagtotaal: " + df2.format(kantine.getKassa().hoeveelheidGeldInKassa()));

            // hoeveel personen binnen zijn gekomen
            System.out.println("Aantal personen: " + aantalpersonen);

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();

        }
    }
}
