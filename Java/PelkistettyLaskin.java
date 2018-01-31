/*
Ohjelman nimi: PelkistettyLaskin
Pvm: 14.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka toimii erittäin pelkistettynä laskimena. Ohjelma kysyy käyttäjältä kaksi
lukua (operandia) ja luvun, joka kertoo kyseessä olevan operaattorin (+, -, *, tai /). Tämän jälkeen ohjelma suorittaa
pyydetyn laskutoimituksen ja tulostaa vastauksen. Käytä ohjelmassasi switch-lausetta.
*/

import java.util.*;

public class PelkistettyLaskin {

    public static void main (String [ ] args) {

        // Esitellään tarvittavat muuttujat
        int luku1 = 0, luku2 = 0, valinta = 0, summa, erotus, tulo;
        double jakolasku;

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Kysytään käyttäjältä luvut 1 ja 2, sekä millä operaattorilla laskutoimitus tehdään.
        try {
            System.out.println("Tervetuloa erittäin pelkistettyyn laskin ohjelmaan.");
            System.out.println("Anna ensimmäinen luku: ");
            luku1 = lukija.nextInt();
            System.out.println("Anna toinen luku: ");
            luku2 = lukija.nextInt();
            System.out.println("Valitse mikä laskutoimitus tehdään (1 = summa, 2 = ertous, 3 = tulo, 4 = osamäärä): ");
            valinta = lukija.nextInt();
        }   catch ( Exception e){
            System.out.println("Annoit virheellisen syötteen, ohjelma sammuu.");
            System.exit(1);
        }

        // Laskutoimitukset
        summa = luku1 + luku2;
        erotus = luku1 - luku2;
        tulo = luku1 * luku2;
        jakolasku = luku1 / luku2;

        // Suoritetaan laskutoimitus käyttäjän valinnan mukaan
        switch (valinta){
            case 1: System.out.println("Laskutoimituksen tulos on: " +summa);
                break;
            case 2: System.out.println("Laskutoimituksen tulos on: " +erotus);
                break;
            case 3: System.out.println("Laskutoimituksen tulos on: " +tulo);
                break;
            case 4: System.out.println("Laskutoimituksen tulos on: " +jakolasku);
                break;
            // Jos syöte ei ole välillä 1-4
            default:
                System.out.println("Annoit virheellisen syötteen, ohjelma sammuu.");
                System.exit(1);
        }
    }
}
