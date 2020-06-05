public class Administratie {

    // Opdracht 2j:
    private static final int DAYS_IN_WEEK = 7;

    /**
     * Constructor
     * Opdracht 2e:
     */
    private Administratie() {
    }

    /*
    Opdracht 2c:
    Omdat Java automatisch een lege default constructor aanmaakt

    Opdracht 2d:
    Omdat je geen variabelen hoeft te initialiseren en daarom hoef je ook geen object er van te maken

    Opdracht 2e:
    Omdat de constructor niet buiten de klasse kan worden aangeroepen en dus kun je er dan geen instantie van maken

    Opdracht 2g:
    Final zorgt er voor dat een variabele maar 1 keer een waarde kan krijgen

    Opdracht 2h:
    Omdat de variabele niet static is wordt hij niet gemaakt waardoor de methode niet weet wat de variabele is

    Opdracht 2i:
    Het probleem is dat de variabele weer veranderd kan worden en dat willen we niet
     */

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param artikelen
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantalArtikelen(int[] artikelen) {
        if (artikelen != null) {
            double totaal = 0;
            for (int artikel : artikelen) {
                totaal += artikel;
            }
            return totaal / artikelen.length;
        } else {
            return 0;
        }
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        if (omzet != null) {
            double totaal = 0;
            for (double omz : omzet) {
                totaal += omz;
            }
            return totaal / omzet.length;
        } else {
            return 0;
        }
    }

    /**
     * Methode om dagomzet uit te rekenen
     * Opdracht 2f:
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            while ((i + DAYS_IN_WEEK * j) < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp;
    }
}
