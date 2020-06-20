import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "factuur")

public class Factuur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "datum")
    private LocalDate datum;
    @Column(name = "korting")
    private double korting;
    @Column(name = "totaal")
    private double totaal;
    @Column(name = "artikelen")
    private int artikelen;
    //@ManyToMany(cascade = CascadeType.ALL)
    //private List<FactuurRegel> regels = new ArrayList<>();

    private String persoonSoort = "";

    private static final DecimalFormat df2 = new DecimalFormat("#.##");

    public Factuur() {
        totaal = 0;
        korting = 0;
        artikelen = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe.
     * <p>
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {
        Iterator<Artikel> iter = klant.getIterator();
        if (iter != null) {
            double totaalbedrag = 0;
            int totaalArtikelen = 0;
            double kortingsbedrag = 0;
            double kortingspercentage;

            while (iter.hasNext()) {
                Artikel artikel = iter.next();

                totaalbedrag += artikel.getPrijs();
                kortingsbedrag += artikel.getKorting();
                totaalArtikelen++;

                //regels.add(new FactuurRegel(this, artikel));

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
            if (klant.getKlant() instanceof Docent) {
                persoonSoort = "Docent";
            }
            if (klant.getKlant() instanceof Student) {
                persoonSoort = "Student";
            }
            if (klant.getKlant() instanceof KantineMedewerker) {
                persoonSoort = "Kantine medewerker";
            }
            totaal = totaalbedrag;
            korting = kortingsbedrag;
            artikelen = totaalArtikelen;
        }
    }

    /**
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting
     */
    public double getKorting() {
        return korting;
    }

    public int getArtikelen() {
        return artikelen;
    }

    /**
     * @return een printbaar bonnetje
     */
    public String toString() {

        String returnString = "Datum: " + this.datum + "\nAantal artikelen: " + getArtikelen() + "\nTotaal: " + df2.format(getTotaal()) +
                "\nKorting: " + df2.format(getKorting()) + "\nTotaal bedrag: " + df2.format((getTotaal() - getKorting()))
                + "\nPersoon: " + persoonSoort + "\nArtikelen: "; //regels.toString();
        return returnString;
    }
}
