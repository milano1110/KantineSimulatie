public class Artikel {

    private String naam;        //Opgave 1b: Naam declareren
    private double prijs;       //Opgave 1b: Prijs declareren
    private double korting;

    public Artikel(String naam, double prijs) {
        this.naam = naam;       //Opgave 1b: Naam initialiseren
        this.prijs = prijs;     //Opgave 1b: Prijs initialiseren
        this.korting = 0.00;
    }

    public Artikel(String naam, double prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
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

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }

    @Override
    public String toString() {
        String returnString = getNaam() + " " + getPrijs();
        return returnString;
    }
}
