/*
Ohjelman nimi: AlueenAla
Pvm: 15.6.2017
Kuvaus(Tehtävänanto): Laadi metodi, joka ottaa parametrinaan alueen leveyden ja pituuden metreinä, sekä tiedon siitä
palautetaanko tulos aareina tai hehtaareina. Tämän jälkeen metodi laskee alueen alan ja palauttaa tuloksen.

Laadi myös pääohjelma, jonka avulla testaat metodia.
*/

import java.util.*;

public class AlueenAla {

        //Luodaan metodi joka laskee pinta-alan.
        public static void LaskePintaAla(int leveys, int pituus, int valinta) {

            // Luodaan pinta-ala muuttuja
            double pintaAla;

            // Jos valinta on aari, tulostetaan pinta-ala.
            if (valinta == 1) {
                pintaAla = (leveys * pituus) / 100;
                System.out.println("Alueen pinta-ala on " + pintaAla + " aaria.");
            }

            // Jos valinta on hehtaari, tulostetaan pinta-ala.
            if (valinta == 2) {
                pintaAla = (leveys * pituus) / 10000;
                System.out.println("Alueen pinta-ala on " + pintaAla + " hehtaaria.");
            }
        }

    public static void main(String[] args)
    {
        // Luodaan scanneri lukijan syötteitä varten
        Scanner lukija;
        lukija = new Scanner(System.in);

        // Luodaan tarvittavat muuttujat
        int leveys, pituus, valinta;

        //Kysytään käyttäjältä alueen leveys, pituus ja halutaanko tulos aareina vai hehtaareina.

        System.out.println("Anna alueen leveys metreinä: ");
        leveys = lukija.nextInt();
        System.out.println("Anna alueen pituus metreinä: ");
        pituus = lukija.nextInt();
        System.out.println("Tulostetaanko vastaus aareina vai hehtaareina ( Aari = 1, Hehtaari = 2): ");
        valinta = lukija.nextInt();

        // Kutsutaan metodia, joka tulostaa tiedot
        LaskePintaAla(leveys,pituus,valinta);
    }
}
