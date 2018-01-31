/*
Ohjelman nimi: YhdistaMerkkijonoksi
Pvm: 25.6.2017
Kuvaus(Tehtävänanto): Laadi kaksi funktiota: Ensimmäinen funktio kysyy ja palauttaa käyttäjältä tämän nimen ja toinen
funktio kysyy ja palauttaa käyttäjältä tämän syntymäajan. Laadi myös pääohjelma, jossa yhdistät edellisten funktioiden
palauttamat tiedot yhdeksi merkkijonoksi, minkä tulostat käyttäjälle.
Käytä ratkaisussasi StringBuffer-luokkaa (ei String-luokkaa).
*/

import java.util.*;

public class YhdistaMerkkijonoksi {

    // Funktio millä kysytään nimi
    static StringBuffer annaNimi() {

        // Muuttujat
        StringBuffer nimi = new StringBuffer();

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Kysytään käyttäjän nimi
        System.out.println("Kerro nimesi: ");
        nimi.append(lukija.next());
        return nimi;
    }

    // Funktio millä kysytään ikä
    static StringBuffer annaSyntyma(){

        // Muuttujat
        StringBuffer syntyma = new StringBuffer();

        // Luodann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Kysytään käyttäjän nimi
        System.out.println("Kerro syntymäaikasi: ");
        syntyma.append(lukija.next());
        return syntyma;
    }

    // Pääohjelmassa yhdistetään nimi ja syntmäaika yhdeksi merkkijonoksi
    public static void main(String [ ] args) {
        StringBuffer yhdistetty = new StringBuffer("");
        System.out.println(yhdistetty.append(annaNimi()).append(annaSyntyma()));
        System.out.println("Nimesi ja syntymäaikasi yhdistettynä on: "+yhdistetty);
    }
}
