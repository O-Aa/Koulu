/*
Ohjelman nimi: Vuosiluvut
Pvm: 14.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka kyselee käyttäjältä vuosilukuja, kunnes käyttäjä syöttää luvun -1.
Vuosiluvun perusteella ohjelma tulostaa kyseisen vuoden jokaisen kuukauden päivien lukumäärän. Laadi ohjelma siten,
että se osaa huomioida karkausvuoden.
*/

import java.util.*;

public class Vuosiluvut {

    // Vakio taulukoille
    static final int kuukausienMaara = 12;

    public static void main (String [ ] args) {

        // Esitellään tarvittavat muuttujat ja tehdään taulukot normaalin vuoden sekä karkausvuoden päivien lkmstä.
        int i, vuosiluku = 0, testimuuttuja = 3;

        String [] kuukausiTaulukko = new String[kuukausienMaara];
        kuukausiTaulukko[0] = "Tammikuu: 31";
        kuukausiTaulukko[1] = "Helmikuu: 28";
        kuukausiTaulukko[2] = "Maaliskuu: 31";
        kuukausiTaulukko[3] = "Huhtikuu: 30";
        kuukausiTaulukko[4] = "Toukokuu: 31";
        kuukausiTaulukko[5] = "Kesäkuu: 30";
        kuukausiTaulukko[6] = "Heinäkuu: 31";
        kuukausiTaulukko[7] = "Elokuu: 31";
        kuukausiTaulukko[8] = "Syyskuu: 30";
        kuukausiTaulukko[9] = "Lokakuu: 31";
        kuukausiTaulukko[10] = "Marraskuu: 30";
        kuukausiTaulukko[11] = "Joulukuu: 31";

        String [] karkausTaulukko = new String[kuukausienMaara];
        karkausTaulukko[0] = "Tammikuu: 31";
        karkausTaulukko[1] = "Helmikuu: 29";
        karkausTaulukko[2] = "Maaliskuu: 31";
        karkausTaulukko[3] = "Huhtikuu: 30";
        karkausTaulukko[4] = "Toukokuu: 31";
        karkausTaulukko[5] = "Kesäkuu: 30";
        karkausTaulukko[6] = "Heinäkuu: 31";
        karkausTaulukko[7] = "Elokuu: 31";
        karkausTaulukko[8] = "Syyskuu: 30";
        karkausTaulukko[9] = "Lokakuu: 31";
        karkausTaulukko[10] = "Marraskuu: 30";
        karkausTaulukko[11] = "Joulukuu: 31";

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Kerrotaan käyttäjälle mitä ohjelma tekee, ohjelma sammuu kun käyttäjä syöttää -1.
        System.out.println("Ohjelma tulostaa valitsemasi vuoden kuukausien päivien lukumäärän");
        while (vuosiluku != -1) {
                System.out.println("Anna vuosiluku (-1 lopettaa ohjelman): ");
                vuosiluku = lukija.nextInt();

                // Jos vuosiluku on karkausvuosi.
                if (((vuosiluku % 4 == 0) && (vuosiluku % 100 != 0)) || (vuosiluku % 400 == 0))
                    testimuuttuja = 1;

                else if(vuosiluku == -1)
                    System.out.println("Ohjelma sammuu.");

                // Jos vuosiluku on "normaalivuosi".
                else
                    testimuuttuja = 0;

                // testimuuttuja luotu koska jonkin virheen takia ohjelma ei toiminut vain if else menetelmällä.
                // 0 = ei karkausvuosi, 1 = karkausvuosi
                // Tulosestetaan päivien lkm taulukoista
                switch (testimuuttuja){
                    case 0: for (i = 0; i < kuukausienMaara; i++) {
                        System.out.println(kuukausiTaulukko[i]);
                    }
                        System.out.println("Vuosi " + vuosiluku + " ei ole karkausvuosi");
                        break;
                    case 1: for (i = 0; i < kuukausienMaara; i++) {
                        System.out.println(karkausTaulukko[i]);
                    }
                        System.out.println("Vuosi " + vuosiluku + " on karkausvuosi");
                        break;
                    default:
                        System.out.println("Annoit virheellisen syötteen, ohjelma sammuu.");
                        System.exit(1);
                }
        }
    }
}

