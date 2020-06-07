public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    private int medewerkersNummer;
    private boolean achterKassa;

    /**
     * Constructor
     * @param BSN
     * @param voorNaam
     * @param achterNaam
     * @param geboorteDatum
     * @param geslacht
     * @param medewerkersNummer
     * @param achterKassa
     */
    public KantineMedewerker(int BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht, int medewerkersNummer, boolean achterKassa) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);
        this.medewerkersNummer = medewerkersNummer;
        this.achterKassa = achterKassa;
    }

    public KantineMedewerker() {
        this.medewerkersNummer = 0;
        this.achterKassa = false;
    }

    public int getMedewerkersNummer() {
        return medewerkersNummer;
    }

    public void setMedewerkersNummer(int medewerkersNummer) {
        this.medewerkersNummer = medewerkersNummer;
    }

    public boolean isAchterKassa() {
        return achterKassa;
    }

    public void setAchterKassa(boolean achterKassa) {
        this.achterKassa = achterKassa;
    }

    @Override
    public String toString() {
        String returnString = "BSN: " + getBSN() + "\nNaam: " + getVoorNaam() + " " + getAchterNaam() + "\nGeboortedatum: "
                + getGeboorteDatum() + "\nGeslacht: " + getGeslacht() + "\nMedewerkersnummer: " + getMedewerkersNummer() + "\nAchter de kassa: " + isAchterKassa();
        return returnString;
    }

    /**
     * Methode om kortingspercentage op te vragen
     */
    @Override
    public double geefKortingsPercentage() {
        return 35;
    }

    /**
     * Methode om op te vragen of er maximum per keer aan de korting zit
     */
    @Override
    public boolean heeftMaximum() {
        return false;
    }

    /**
     * Methode om het maximum kortingsbedrag op te vragen
     */
    @Override
    public double geefMaximum() {
        return 0;
    }
}
