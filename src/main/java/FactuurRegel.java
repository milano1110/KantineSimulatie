
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "factuurregel")

public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
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
                + artikel.getPrijs() + "\nArtikelkorting: " + artikel.getKorting() + "\n";
        return returnString;
    }
}




