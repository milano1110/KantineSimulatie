import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad(Persoon klant) {
        this.klant = new Persoon();
        this.artikelen = new Stack<>();
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Opdracht 4d
     * @return Iterator over de artikelen
     */
    public Iterator<Artikel> getIterator() {
        Iterator<Artikel> iter = artikelen.iterator();
        return iter;
    }
}

