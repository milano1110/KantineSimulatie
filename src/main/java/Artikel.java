public class Artikel {

    private String naam;        //Opgave 1b: Naam declareren
    private double prijs;       //Opgave 1b: Prijs declareren

    public Artikel(String naam, double prijs) {
        this.naam = naam;       //Opgave 1b: Naam initialiseren
        this.prijs = prijs;     //Opgave 1b: Prijs initialiseren
    }

    public Artikel() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        String returnString = getNaam() + " " + getPrijs();
        return returnString;
    }
}
