import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    private ArrayList<Dienblad> klanten;

    /**
     * Constructor
     */
    public KassaRij() {
        this.klanten = new ArrayList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        klanten.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if (!klanten.isEmpty()) {
            Dienblad eersteKlant = klanten.get(0);
            klanten.remove(eersteKlant);
            return eersteKlant;
        }
        else {
            return null;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if (klanten.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
