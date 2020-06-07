public class Docent extends Persoon implements KortingskaartHouder {

    private String afkorting;
    private String afdeling;

    /**
     * Constructor
     * @param BSN
     * @param voorNaam
     * @param achterNaam
     * @param geboorteDatum
     * @param geslacht
     * @param afkorting
     * @param afdeling
     */
    public Docent(int BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht, String afkorting, String afdeling) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    public Docent() {
        this.afkorting = null;
        this.afdeling = null;
    }

    public String getAfkorting() {
        return afkorting;
    }

    public void setAfkorting(String afkorting) {
        this.afkorting = afkorting;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public double geefKortingsPercentage() {
        return 25;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return true;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public double geefMaximum() {
        return 1.00;
    }

    @Override
    public String toString() {
        String returnString = "BSN: " + getBSN() + "\nNaam: " + getVoorNaam() + " " + getAchterNaam() + "\nGeboortedatum: "
                + getGeboorteDatum() + "\nGeslacht: " + getGeslacht() + "\nAfkorting: " + getAfkorting() + "\nAfdeling: " + getAfdeling();
        return returnString;
    }
}
