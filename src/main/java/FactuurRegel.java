
import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

@Entity
@Table(name = "factuurregel")

public class FactuurRegel implements Serializable {

    private static final DecimalFormat df2 = new DecimalFormat("#.##");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factuur_id")
    private Factuur factuur;
    @OneToOne(cascade = CascadeType.ALL)
    private Artikel artikel;

    public FactuurRegel() {
    }

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    /**
     * @return een printbare factuurregel
     */
    public String toString() {
        String returnString = "\nArtikelnaam: " + artikel.getNaam() + "\nArtikelprijs: "
                + artikel.getPrijs() + "\nArtikelkorting: " + df2.format(artikel.getKorting()) + "\n";
        return returnString;
    }
}




