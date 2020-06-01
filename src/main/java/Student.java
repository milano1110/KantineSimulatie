public class Student extends Persoon {

    private int studentNummer;
    private String studieRichting;

    /**
     * Opdracht 3b:
     * Omdat als eerste de constructor van de parent class wordt gemaakt
     *
     * Constructor
     * @param BSN
     * @param voorNaam
     * @param achterNaam
     * @param geboorteDatum
     * @param geslacht
     * @param studentNummer
     * @param studieRichting
     */
    public Student(int BSN, String voorNaam, String achterNaam, Datum geboorteDatum, char geslacht, int studentNummer, String studieRichting) {
        super(BSN, voorNaam, achterNaam, geboorteDatum, geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    public Student() {
        this.studentNummer = 0;
        this.studieRichting = null;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getStudieRichting() {
        return studieRichting;
    }

    public void setStudieRichting(String studieRichting) {
        this.studieRichting = studieRichting;
    }
}
