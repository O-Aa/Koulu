/*
Ohjelman nimi: Anagrammi
Pvm: 25.6.2017
Kuvaus(Tehtävänanto): Laadi funktio, joka tarkastaa ovatko kaksi sen parametrinaan saamaa merkkijonoa anagrammeja
keskenään. Laadi myös pääohjelma, joka käyttää kyseistä funktiota.
*/

import java.util.*;

public class Anagrammi {

    // Metodi joka tarkastaa, ovatko merkkijonot anagrammeja
    public static void onkoAnagrammi(String merkkiJono1, String merkkiJono2) {

        //Muutetaan merkkijonoja siten, että välilyönnit poistetaan, jolloin vertailu helpompaa.
        String eiValeja1 = merkkiJono1.replaceAll("\\s", "");
        String eiValeja2 = merkkiJono2.replaceAll("\\s", "");

        // Asetetaan alussa tila tosi
        boolean tila = true;

        // Jos merkkijonot eivät ole samanpituisia, kerrotaan se käyttäjälle
        if(eiValeja1.length() != eiValeja2.length()) {
            tila = false;
        }

        //Muutetan jo muutetut merkkijonot isoiksi kirjaimisi ja tehdään niistä merkkijonot
        else{
            char[] jono1 = eiValeja1.toUpperCase().toCharArray();
            char[] jono2 =eiValeja2.toUpperCase().toCharArray();

            // Järjestetään merkkijonojen merkit uudestaan
            Arrays.sort(jono1);
            Arrays.sort(jono2);

            // Ja verrataan ovatko merkkijonot samanlaiset
            tila = Arrays.equals(jono1,jono2);
        }

        // Jos tila on tosi
        if(tila == true) {
            System.out.println(merkkiJono1+" ja "+merkkiJono2+" ovat anagrammeja.");
        }
        // Jos tila on epätosi
        else {
            System.out.println(merkkiJono1+" ja "+merkkiJono2+" eivät ole anagrammeja");
        }
    }

    // Pääohjelma, missä testataan onkoAnagrammi metodia
    public static void main(String [ ] args) {
        System.out.println("Tällä ohjelmalla voit testata ovatko kaksi sanaa anagrammeja.\n");
        onkoAnagrammi("kissa","koira");
        onkoAnagrammi("kissa","kissa");
        onkoAnagrammi("valio","olavi");
        onkoAnagrammi("oiva","aivo");
        onkoAnagrammi("kesäloma","loma sekä");
    }
}
