public class Docent extends Persoon {

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

    @Override
    public String toString() {
        return "Docent";
    }
}
