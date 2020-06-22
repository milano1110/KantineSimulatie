import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import java.text.DecimalFormat;

public class KantineSimulatie {

    private static final DecimalFormat df2 = new DecimalFormat("#.##");

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"}; //

    // prijzen
    private static final double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65}; //

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("KantineSimulatie");
    EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();

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
        kantine = new Kantine(manager);
        random = new Random();
        int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
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
     * Haalt de top 3 hoogste omzet op uit de database
     * @return list met top 3 omzet
     */
    private List<Double> getHoogsteOmzet() {
        return manager.
                createQuery("SELECT totaal FROM Factuur ORDER BY totaal DESC",
                        Double.class).setMaxResults(3).getResultList();
    }

    /**
     * Haalt de totale korting op uit de database
     * @return de totale korting
     */
    private double getTotaalKorting() {
        Query query = manager.createQuery("SELECT SUM(korting) FROM Factuur");
        return (Double) query.getSingleResult();
    }

    /**
     * Haalt de gemiddelde korting op uit de database
     * @return de gemiddelde korting
     */
    private double getGemiddeldeKorting() {
        Query query = manager.createQuery("SELECT AVG(korting) FROM Factuur");
        return (Double) query.getSingleResult();
    }

    /**
     * Haalt de totale omzet op uit de database
     * @return de totale omzet
     */
    private double getTotaalOmzet() {
        Query query = manager.createQuery("SELECT SUM(totaal) FROM Factuur");
        return (Double) query.getSingleResult();
    }

    /**
     * Haalt de gemiddelde omzet op uit de database
     * @return de gemiddelde omzet
     */
    private double getGemiddeldeOmzet() {
        Query query = manager.createQuery("SELECT AVG(totaal) FROM Factuur");
        return (Double) query.getSingleResult();
    }

    /**
     * Haalt de totale omzet per artikel op
     * @return de totale omzet per artikel
     */
    private List<Double> getTotaalArtikel() {
        return manager.createQuery("SELECT SUM(prijs) FROM Artikel GROUP BY naam",
                Double.class).getResultList();

    }

    /**
     * Haalt de totale korting per artikel op
     * @return de totale korting per artikel
     */
    private List<Double> getKortingArtikel() {
        return manager.createQuery("SELECT SUM(korting) FROM Artikel GROUP BY naam",
                Double.class).getResultList();

    }

    private List<Double> getHooogsteOmzetArtikel() {
        return manager.
                createQuery("SELECT SUM(prijs) AS prijs FROM Artikel GROUP BY naam ORDER BY prijs DESC",
                    Double.class).setMaxResults(3).getResultList();
    }

    private List populairsteArtikelen() {
        return manager.createQuery(
                "SELECT artikel.naam, COUNT(artikel.naam) AS aantal FROM FactuurRegel GROUP BY artikel.naam ORDER BY aantal DESC"
                    ).setMaxResults(3).getResultList();
    }

    private List totaleOmzetArtikelPerDag() {
        return manager.createQuery(
                "SELECT fr.artikel.naam, f.datum, SUM(fr.artikel.prijs - fr.artikel.korting) AS omzet FROM FactuurRegel fr join Factuur f on fr.factuur = f.id GROUP BY fr.artikel.naam, f.datum"
        ).getResultList();
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen Het aantal dagen dat gesimuleerd wordt
     */
    public void simuleer(int dagen) {

        double [] dagomzet = new double[dagen];
        int [] artikel = new int[dagen];

        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {
            kantineaanbod.refreshKorting();

            int aantalStudenten = 0;
            int aantalDocenten = 0;
            int aantalKantineMedewerkers = 0;
            Persoon persoon = null;

            // bedenk hoeveel personen vandaag binnen lopen
            //int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            int aantalpersonen = 5;

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                // bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                //int aantalartikelen = 4;

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN - 1); //

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                int randomPersoon = random.nextInt(100);

                // maak persoon aan
                if (randomPersoon >= 0 && randomPersoon <= 88) {
                    persoon = new Student(123456789, "Milan", "Schuringa", new Datum(11, 10, 1998) ,'M', 359838, "HBO-ICT");
                    aantalStudenten++;
                }
                if (randomPersoon >= 89 && randomPersoon <= 98) {
                    persoon = new Docent(123456789, "Lieuwe", "Baron", new Datum(11, 5, 2002), 'M', "BALI", "Java-theorie");
                    aantalDocenten++;
                }
                if (randomPersoon == 99) {
                    persoon = new KantineMedewerker(123456789, "X", "Y", new Datum(1,1,1980), 'M', 42, false);
                    aantalKantineMedewerkers++;
                }

                // koppel dienblad aan persoon
                Dienblad dienblad = new Dienblad(persoon);

                // maak een willekeurig betaalwijze aan
                int randomBetaalwijze = random.nextInt(2);
                Betaalwijze betaalwijze;

                if (randomBetaalwijze == 0) {
                    betaalwijze = new Contant();
                } else {
                    betaalwijze = new Pinpas();
                }

                // koppel de betaalwijze aan een persoon en zet willekeurig saldo tussen 0-20
                assert persoon != null;
                persoon.setBetaalwijze(betaalwijze);
                betaalwijze.setSaldo(getRandomValue(0, 20));

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);
            }
            //verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af
            System.out.println("\nDag: " + (i + 1));
            System.out.println("Dagtotaal: " + df2.format(kantine.getKassa().hoeveelheidGeldInKassa()));

            // tel de dagtotalen in een array op
            dagomzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            artikel[i] = kantine.getKassa().aantalArtikelen();

            List omzetlijst = getTotaalArtikel();

            // hoeveel personen binnen zijn gekomen
            System.out.println("Aantal klanten: " + aantalpersonen);
            System.out.println("Aantal studenten: " + aantalStudenten);
            System.out.println("Aantal docenten: " + aantalDocenten);
            System.out.println("Aantal kantine medewerkers: " + aantalKantineMedewerkers);
            System.out.println("Aantal artikelen: " + kantine.getKassa().aantalArtikelen());
            System.out.println("Omzet per artikel: " + omzetlijst);
            System.out.println();

            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();
        }
        // print de totalen per dag uit
        System.out.println("Dagtotalen: " + Arrays.toString(Administratie.berekenDagOmzet(dagomzet)));
        System.out.println("Gemiddelde artikelen: " + Administratie.berekenGemiddeldAantalArtikelen(artikel));
        System.out.println("Gemiddelde omzet: " + df2.format(Administratie.berekenGemiddeldeOmzet(dagomzet)));

        System.out.println("Totaal korting: " + df2.format(getTotaalKorting()));
        System.out.println("Totaal omzet: " + df2.format(getTotaalOmzet()));
        System.out.println("Gemiddelde korting: " + df2.format(getGemiddeldeKorting()));
        System.out.println("Gemiddelde omzet: " + df2.format(getGemiddeldeOmzet()));
        System.out.println("Top 3 omzet: " + getHoogsteOmzet());
        System.out.println("Omzet per artikel: " + getTotaalArtikel());
        System.out.println("Korting per artikel: " + getKortingArtikel());
        System.out.println("");
        System.out.println("Top 3 populairste artikelen: " + populairsteArtikelen());
        System.out.println("Top 3 omzet per artikel: " + getHooogsteOmzetArtikel());

        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }
}
