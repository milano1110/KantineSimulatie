public class Persoon {

    private int BSN;
    private String voorNaam;
    private String achterNaam;
    private Datum geboorteDatum;
    private char geslacht;

    public Persoon(int BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        this.geslacht = geslacht;
    }

    public Persoon() {
        this.geboorteDatum = null;
        this.geslacht = 'O';
    }

    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public String getGeslacht() {
        String returnString = "";
        if (geslacht == 'M') {
            returnString = "Man";
        }
        if (geslacht == 'V') {
            returnString = "Vrouw";
        }
        if (geslacht != 'M' && geslacht != 'V') {
            returnString = "Onbekend";
        }

        return returnString;
    }

    public void setGeslacht(char geslacht) {
        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        }
        else {
            geslacht = 'O';
        }
    }

    @Override
    public String toString() {
        String returnString = "BSN: " + getBSN() + "\nNaam: " + getVoorNaam() + " " + getAchterNaam() + "\nGeboortedatum: " + getGeboorteDatum() + "\nGeslacht: " + getGeslacht();
        return returnString;
    }
}
