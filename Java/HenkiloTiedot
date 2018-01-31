/*
Ohjelman nimi: HenkilöTiedot
Pvm: 12.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka kysyy käyttäjältä kuvitteellisen henkilön seuraavat tiedot: ikä, pituus metreinä, paino sekä tieto siitä, omistaako
kyseinen henkilö ajokortin. Valitse tarvittavien muuttujien tietotyypit siten, että ne vievät mahdollisimman vähän turhaa tilaa.
Kun olet kysynyt tiedot käyttäjältä, tulosta ne näytölle. Mikäli pystyt tekemään tulostuksestasi elegantimpaa hyödyntämällä ratkaisussasi
myöhemmin opetettavaa ehtolausetta, saat yhden bonuspisteen.
*/

import java.io.*;
import java.util.Scanner;

public class HenkiloTiedot {

    public static void main (String [ ] args) {
    // Esitellään muuttujat
        byte ika = 0, paino = 0;
        float pituus =0;
        boolean akortti = false;

     // Luodaan scanner syötteiden lukemista varten
        Scanner lukija;
        lukija = new Scanner(System.in);

        // Kysytään käyttäjältä tiedot ja luetaan ne.
        // Jos syöte on virheellinen, ohjelma tulostaa virheilmoituksen ja sammuu.
        try {

            System.out.println("Kuinka vanha olet : ");
            ika = lukija.nextByte();
            System.out.println("Kerro painosi: ");
            paino = lukija.nextByte();
            System.out.println("Kuinka pitkä olet? (Esim. 1,75): ");
            pituus = lukija.nextFloat();
            System.out.println("Omistatko ajokortin? (Kyllä = true, Ei = false): ");
            akortti = lukija.nextBoolean();
			
        }catch ( Exception e){
            System.out.println("Annoit virheellisen syötteen, ohjelma sammuu.");
            System.exit(1);
        }

        // Tulostetaan käyttäjän antamat tiedot
        // Ei omista ajokorttia
        if (akortti == false){
            System.out.println("Ikäsi on "+ika+"-vuotta, painat "+paino+"kg ja olet "+pituus+"m pitkä, mutta et omista ajokorttia.");
        }
        // Omistaa ajokortin
        else{
            System.out.println("Ikäsi on "+ika+"-vuotta, painat "+paino+"kg ja olet "+pituus+"m pitkä sekä omistat ajokortin.");
        }
    }
}
