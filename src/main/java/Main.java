public class Main {

    public static void main(String[] args) {
        Datum datum = new Datum(11, 10, 1998);
        Persoon persoon1 = new Persoon(123456789, "Milan", "Schuringa", datum ,'M');
        Persoon persoon3 = new Persoon(123456789, "Lieuwe", "Baron", datum ,'M');
        Datum foutDatum = new Datum (29, 13, 2200);
        Persoon persoon2 = new Persoon(123456789, "Milan", "Schuringa", foutDatum ,'Q');

        //System.out.println(datum.getDatumAsString());
        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());

        Dienblad klant1 = new Dienblad(persoon1);
        Dienblad klant2 = new Dienblad(persoon2);
        Artikel kaas = new Artikel("kaas", 2.50);
        Artikel worst = new Artikel("worst", 3.75);

        klant1.voegToe(kaas);
        klant2.voegToe(worst);

        KassaRij kassaRij = new KassaRij();
        kassaRij.sluitAchteraan(klant1);
        kassaRij.sluitAchteraan(klant2);
        Kassa kassa = new Kassa(kassaRij);

        kassa.rekenAf(klant1);
        kassa.rekenAf(klant2);

        //System.out.println(klant1.getAantalArtikelen());
        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

        kassa.resetKassa();

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

    }
}
