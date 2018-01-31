/*
Ohjelman nimi: KuukausiTulot
Pvm: 13.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka ottaa taulukkoon talteen kahdentoista kuukauden tulot ja laskee sekä tulostaa
näytölle tuloista yhteenlasketun vuositulon, keskitulon kuukautta kohti, sekä suurimman kuukausikohtaisen tulon.
*/

import java.util.Scanner;
import java.util.*;

public class KuukausiTulot {

    // Luodaan vakio kuukausien määrä, joka määrittää taulukon koon
    static final int kuukausienMaara = 12;

    public static void main (String [ ] args) {

        // Luodaan taulukko, mihin talletetaan 12kuukauden tulot, jotka kysytään käyttäjältä
        int[] kuukausiTaulukko = new int [kuukausienMaara];

        // Luodaan scanneri lukemaan käyttäjän syötteet.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Määritellään tarvittavat muuttujat
        int vuosiPalkka,i=0, kuukausi = 1, suurinTulo = 0;
        double kaPalkka;

        // Tulostetaan käyttäjälle tieto siitä mitä ohjelma tekee
        // Kysytään käyttäjältä 12 kuukauden tulot ja talletetaan ne taulukkoon.

        System.out.println("Ohjelma laskee vuoden kokonaistulon, keskimääräisen kuukausikohtaisen tulon \n" +
                "ja suurimman kuukausikohtaisen tulon antamiesi tietojen perusteella");

        for (i = 0; i < kuukausienMaara; i++){
            System.out.println("Anna " +kuukausi+ ". kuukauden tulo: ");
            kuukausiTaulukko[i] = lukija.nextInt();
            kuukausi++;
        }

        // Lasketaan vuosipalkka ja  keskiarvopalkka
        vuosiPalkka = kuukausiTaulukko[0] + kuukausiTaulukko[1] + kuukausiTaulukko[2] +
                      kuukausiTaulukko[3] + kuukausiTaulukko[4] + kuukausiTaulukko[5] +
                      kuukausiTaulukko[6] + kuukausiTaulukko[7] + kuukausiTaulukko[8] +
                      kuukausiTaulukko[9] + kuukausiTaulukko[10] + kuukausiTaulukko[11];
        kaPalkka = vuosiPalkka / 12;

        // Etsitään kuukausitulojen taulukosta suurinta arvoa ja talletetaan se suurinTulo muuttujaan
        for(int j:kuukausiTaulukko){
            if (j>suurinTulo)
                suurinTulo=j;
        }

        // Tulostetaan käyttäjälle tiedot
        System.out.println("Kokonaistulot ovat: "+ vuosiPalkka / 1.0);
        System.out.println("Keskiarvoinen kuukausikohtainen tulo on "+ kaPalkka / 1.0);
        System.out.println("Suurin kuukausikohtainen tulo on "+ suurinTulo / 1.0);
    }
}
