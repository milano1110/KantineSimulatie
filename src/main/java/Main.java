public class Main {

    public static void main(String[] args) {
        Datum datum = new Datum(11, 10, 1998);
        Persoon persoon1 = new Persoon(231684666, "Milan", "Schuringa", datum ,'M');
        Datum foutDatum = new Datum (29, 13, 2200);
        Persoon persoon2 = new Persoon(231684666, "Milan", "Schuringa", foutDatum ,'M');
        System.out.println(datum.getDatumAsString());
        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());
    }
}
