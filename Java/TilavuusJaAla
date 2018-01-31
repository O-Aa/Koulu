/*
Ohjelman nimi: TilavuusJaAla
Pvm: 14.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka laskee ympyrän pinta-alan tai pallon tilavuuden. Ohjelman tulee kysyä ensin
käyttäjältä, onko kyse pallosta vai ympyrästä. Tämän jälkeen ohjelman tulee kysyä käyttäjältä ympyrän tai pallon säde
ja laskea sen perusteella pinta-ala tai tilavuus. Lopuksi Ohjelman tulee tulostaa pinta-ala tai tilavuus näytölle.
*/

import java.util.*;
import java.lang.Math;

public class TilavuusJaAla {

    public static void main (String [ ] args) {

        // Luodaan scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        lukija = new Scanner(System.in);

        //Esitellään tarvittavat muuttujat
        int valinta;
        double pintaAla, sade = 0, tilavuus;

        // Kerrotaan mitä ohjelma tekee ja kysytään käyttäjältä kumpi arvo lasketaan
        System.out.println("Ohjelma laskee ympyrän pinta-alan tai pallon tilvauuden.");

        // Jos käyttäjä syöttää virheellisen arvon, kysytään syötettä jatkuvasti uudelleen.
        do {
            System.out.println("Haluatko laskea ympyrän pinta-alan vai pallon tilavuuden(Ympyrä = 1, Pallo = 2): ");
            valinta = lukija.nextInt();
            if (valinta < 1 || valinta >= 3 )
                System.out.println("Virheellinen syöte, yritä uudelleen.");
        }while (valinta != 1 && valinta != 2);

        // Jos valinta 1 niin ympyrä, jos valinta 2 niin pallo.
        // Valinnasta riippuen lasketaan joko ympyrän ala tai pallon tilavuus.
        // Pyöristys kokonaisluvuksi, jotta saadaan desimaalipilkun jälkeiset luvut kuriin.
            if (valinta == 1) {
                System.out.println("Anna ympyrän säde (kokonaislukuna tai desimaalina esim. 5 tai 5,5): ");
                sade = lukija.nextDouble();
                pintaAla = Math.PI * (Math.pow(sade, 2));
                System.out.println("Ympyrän pinta-ala on: "+Math.round(pintaAla));

            } else if (valinta == 2) {
                System.out.println("Anna pallon säde (kokonaislukuna tai desimaalina esim. 5 tai 5,5): ");
                sade = lukija.nextDouble();
                tilavuus = (4 * Math.PI * (Math.pow(sade, 3)) )/ 3;
                System.out.println("Pallon tilavuus on: "+Math.round(tilavuus));
            }
    }
}
