public class Main {

    public static void main(String[] args) {
        /*
        22 juni 15:00
         */
/*
        Datum datum = new Datum(11, 10, 1998);
        Datum foutDatum = new Datum (29, 2, 1900);
        Datum goedDatum = new Datum (11, 10, 1900);

        Persoon persoon1 = new Persoon(123456789, "Milan", "Schuringa", new Datum(11, 10, 1998) ,'M');
        Persoon persoon2 = new Docent(123456789, "Lieuwe", "Baron", new Datum(11, 5, 2002), 'M', "BALI", "Java-theorie");
        Persoon persoon3 = new KantineMedewerker(123456789, "X", "Y", new Datum(1,1,1980), 'M', 42, false);

        Betaalwijze contant1 = new Contant();
        contant1.setSaldo(10.00);
        persoon1.setBetaalwijze(contant1);

        Betaalwijze contant2 = new Contant();
        contant2.setSaldo(10.00);
        persoon2.setBetaalwijze(contant2);

        Betaalwijze contant3 = new Contant();
        contant3.setSaldo(10.00);
        persoon3.setBetaalwijze(contant3);

        System.out.println(persoon1.toString());
        System.out.println(persoon2.toString());
        System.out.println(persoon3.toString());

        Dienblad klant1 = new Dienblad(persoon1);
        Dienblad klant2 = new Dienblad(persoon2);
        Dienblad klant3 = new Dienblad(persoon3);

        Artikel kaas = new Artikel("kaas", 3.00);
        Artikel worst = new Artikel("worst", 3.00);

        klant1.voegToe(kaas);
        klant1.voegToe(worst);
        klant2.voegToe(worst);
        klant2.voegToe(kaas);
        klant3.voegToe(worst);
        klant3.voegToe(kaas);

        KassaRij kassaRij = new KassaRij();
        Kassa kassa = new Kassa(kassaRij);

        kassaRij.sluitAchteraan(klant1);
        kassaRij.sluitAchteraan(klant2);
        kassaRij.sluitAchteraan(klant3);

        //Kantine kantine = new Kantine();
        //kantine.loopPakSluitAan();

        //System.out.println("Aantal artikelen: " + kantine.aantalArtikelen());

        //kantine.verwerkRijVoorKassa();

        //System.out.println("Aantal artikelen: " + kantine.aantalArtikelen());

        kassa.rekenAf(klant1);
        kassa.rekenAf(klant2);
        kassa.rekenAf(klant3);

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

        System.out.println("Persoon saldo: " + persoon1.getBetaalwijze().getSaldo());
        System.out.println("Docent saldo: " + persoon2.getBetaalwijze().getSaldo());
        System.out.println("Kantine Medewerker saldo: " + persoon3.getBetaalwijze().getSaldo());



        kassa.resetKassa();

        System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
        System.out.println("Hoeveelheid geld: " + kassa.hoeveelheidGeldInKassa());

*/

        KantineSimulatie kantineSimulatie = new KantineSimulatie();
        kantineSimulatie.simuleer(7);

/*
        //Opdracht 2b:
        int[] artikelen = {45, 56, 34, 39, 40, 31};
        double[] omzet = {567.70, 498.25, 458.90};
        //Administratie administratie = new Administratie();
        System.out.println(Administratie.berekenGemiddeldAantalArtikelen(artikelen));
        System.out.println(Administratie.berekenGemiddeldeOmzet(omzet));


        double[] omzet = {321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25, 220.90, 201.90, 242.70, 260.35, 321.35, 450.50, 210.45, 190.85, 193.25, 159.90, 214.25};
        System.out.println(Arrays.toString(Administratie.berekenDagOmzet(omzet)));

*/



    }
}
