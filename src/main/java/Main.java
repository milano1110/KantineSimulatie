public class Main {

    public static void main(String[] args) {

        Datum datum = new Datum(11, 10, 1998);
        Datum foutDatum = new Datum (29, 2, 2015);

        Persoon persoon1 = new Persoon(123456789, "Milan", "Schuringa", datum ,'M');
        Persoon persoon2 = new Persoon(123456789, "Milan", "Schuringa", foutDatum ,'Q');
        Persoon persoon3 = new Persoon(123456789, "Lieuwe", "Baron", datum ,'M');

        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());

        Dienblad klant1 = new Dienblad(persoon1);
        Dienblad klant2 = new Dienblad(persoon2);
        Dienblad klant3 = new Dienblad(persoon3);

        Artikel kaas = new Artikel("kaas", 2.50);
        Artikel worst = new Artikel("worst", 3.75);

        klant1.voegToe(kaas);
        klant2.voegToe(worst);
        klant3.voegToe(kaas);

        KassaRij kassaRij = new KassaRij();
        Kassa kassa = new Kassa(kassaRij);

        kassaRij.sluitAchteraan(klant1);
        kassaRij.sluitAchteraan(klant2);
        kassaRij.sluitAchteraan(klant3);

        kassa.rekenAf(klant1);
        kassa.rekenAf(klant2);
        kassa.rekenAf(klant3);

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

        kassa.resetKassa();

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

    }
}
