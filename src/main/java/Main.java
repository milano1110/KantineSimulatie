public class Main {

    public static void main(String[] args) {
        Datum datum = new Datum(11, 10, 1998);
        Persoon persoon1 = new Persoon(123456789, "Milan", "Schuringa", datum ,'M');
        Datum foutDatum = new Datum (29, 13, 2200);
        Persoon persoon2 = new Persoon(123456789, "Milan", "Schuringa", foutDatum ,'Q');
        System.out.println(datum.getDatumAsString());
        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());

        Dienblad klant = new Dienblad(persoon1);
        System.out.println(klant.getKlant());
    }
}
