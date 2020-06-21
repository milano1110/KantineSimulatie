import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, Double> prijzen;
    private String[] artikelNamen;

/*
Opdracht 5a:
Dan kun je de variablen niet van buitenaf veranderen.

Opdracht 5b:
Je gebruikt HashMap als je een implementatie van Map moet hebben en
HashSet als je een implementatie van Set moet hebben waar geen dubbele data in voor kan komen.
 */

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen, het tweede argument is
     * eenlijst met prijzen en het derde argument is een lijst met hoeveelheden. Let op: de
     * dimensies van de drie arrays moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        this.artikelNamen = artikelnaam;
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        startVoorraad = new HashMap<String, Integer>();
        prijzen = new HashMap<String, Double>();
        for (int i = 0; i < artikelnaam.length; i++) {
            ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
            for (int j = 0; j < hoeveelheid[i]; j++) {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            startVoorraad.put(artikelnaam[i], hoeveelheid[i]);
            prijzen.put(artikelnaam[i], prijs[i]);
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    public void refreshKorting() {
        int max = artikelNamen.length;
        int min = 1;
        String[] usableArray = Randomize(artikelNamen);
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        for (int i = 0; i < max; i++) {
            ArrayList<Artikel> replacementArtikelen = new ArrayList<>();
            for(int j = 0; j < aanbod.get(usableArray[i]).size(); j++) {
                Artikel replacement = new Artikel(usableArray[i], aanbod.get(usableArray[i]).get(0).getPrijs(), 0.00);
                replacementArtikelen.add(replacement);
            }
            aanbod.put(usableArray[i], replacementArtikelen);
        }

        for (int i = 0; i < randomNumber; i++) {
            ArrayList<Artikel> replacementArtikelen = new ArrayList<>();
            for(int j = 0; j < aanbod.get(usableArray[i]).size(); j++) {
                Artikel replacement = new Artikel(usableArray[i], aanbod.get(usableArray[i]).get(0).getPrijs(), (aanbod.get(usableArray[i]).get(0).getPrijs() * 0.2));
                replacementArtikelen.add(replacement);
            }
            aanbod.put(usableArray[i], replacementArtikelen);
        }
    }

    public static String[] Randomize(String[] arr) {
        String[] randomizedArray = new String[arr.length];
        System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
        Random rgen = new Random();

        for (int i = 0; i < randomizedArray.length; i++) {
            int randPos = rgen.nextInt(randomizedArray.length);
            String tmp = randomizedArray[i];
            randomizedArray[i] = randomizedArray[randPos];
            randomizedArray[randPos] = tmp;
        }

        return randomizedArray;
    }

    private void vulVoorraadAan(String productnaam) {
        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
        int startHoeveelheid = startVoorraad.get(productnaam);
        int huidigeHoeveelheid = huidigeVoorraad.size();
        double prijs = prijzen.get(productnaam);
        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
            huidigeVoorraad.add(new Artikel(productnaam, prijs));
        }
        aanbod.put(productnaam, huidigeVoorraad);
    }




    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van het artikel.
     * Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam);
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. Retourneert null als de
     * stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= 10)
                vulVoorraadAan(a.getNaam());
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert null als artikel
     * niet bestaat of niet op voorraad is.
     *
     * @param productnaam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {
        return getArtikel(getArrayList(productnaam));
    }
}
