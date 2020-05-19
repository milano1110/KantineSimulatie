public class Persoon {

    private int BSN;
    private String voorNaam;
    private String achterNaam;
    private int geboorteDatum;
    private char geslacht;

    public Persoon(int BSN, String voorNaam, String achterNaam, int geboorteDatum, char geslacht) {
        this.BSN = BSN;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.geboorteDatum = geboorteDatum;
        this.geslacht = geslacht;
    }

    public Persoon() {
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

    public int getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(int geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }
}
