public class Main {

    public static void main(String[] args) {

        /*
        maandag code mailen
        vrijdag 29 mei 14:30
         */
/*
        Datum datum = new Datum(11, 10, 1998);
        Datum foutDatum = new Datum (29, 2, 1900);
        Datum goedDatum = new Datum (11, 10, 1900);

        Persoon persoon1 = new Persoon(123456789, "Milan", "Schuringa", datum ,'M');
        Persoon persoon2 = new Persoon(123456789, "Fout", "Datum", foutDatum ,'Q');
        Persoon persoon3 = new Persoon(123456789, "Goed", "Datum", goedDatum ,'M');

        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());
        System.out.println(persoon3.toString());

        Dienblad klant1 = new Dienblad(persoon1);
        Dienblad klant2 = new Dienblad(persoon2);
        Dienblad klant3 = new Dienblad(persoon3);

        Artikel kaas = new Artikel("kaas", 3.00);
        Artikel worst = new Artikel("worst", 3.75);

        klant1.voegToe(kaas);
        klant1.voegToe(worst);
        klant2.voegToe(worst);
        klant3.voegToe(kaas);

        KassaRij kassaRij = new KassaRij();
        Kassa kassa = new Kassa(kassaRij);

        kassaRij.sluitAchteraan(klant1);
        kassaRij.sluitAchteraan(klant2);
        kassaRij.sluitAchteraan(klant3);


        Kantine kantine = new Kantine();
        kantine.loopPakSluitAan();

        //System.out.println("Aantal artikelen: " + kantine.aantalArtikelen());

        //kantine.verwerkRijVoorKassa();

        //System.out.println("Aantal artikelen: " + kantine.aantalArtikelen());

/*
        kassa.rekenAf(klant1);
        kassa.rekenAf(klant2);
        kassa.rekenAf(klant3);

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

        kassa.resetKassa();

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

 */
        KantineSimulatie kantineSimulatie = new KantineSimulatie();
        kantineSimulatie.simuleer(50);

    }
}
