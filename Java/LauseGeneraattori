/*
Ohjelman nimi: LauseGeneraattori
Pvm: 26.6.2017
Kuvaus(Tehtävänanto): Laadi surrealistinen lausegeneraattori. Generaattorin ideana on, että se arpoo satunnaisesti
esimerkiksi kymmenestä mahdollisesta eri sanasta aina jokaisen lauseenjäsenen paikalle yhden sanan. Tällä tavalla
muodostuu periaatteessa toimivia mutta omituisia lauseita. Laadi lauseet siten, että ne muodostuvat adjektiivista,
subjektista, predikaatista, adjektiivista ja objektista. Laadi myös pääohjelma, joka tuottaa lauseita generaattorin
avulla.
*/

import java.util.*;

public class LauseGeneraattori {

    // Luodaan generaattori jota kutsutaan pääohjelmassa
    public static void generaattori() {

        // Tulostetaan 5 randomia lausetta.
        for (int i = 0; i < 5; i++) {

            // Luodaan random muuttuja joka auttaa lauseiden tekemisessä
            Random random = new Random();

            // Luodaan sanoille taulukot adjektiivi, subjekti, predidaatti adjektiivi ja objekti.
            String[] Adjektiivi1 = {"Funny", "Sad", "Big", "Small", "Huge", "Historical", "Pink", "Blue", "Black",
                    "Happy"};
            String[] Subjekti = {"Captain Hook", "Spiderman", "Superman", "Batman", "Hulk", "Tiger", "Wolf", "Dog", "Cat",
                    "Butterfly"};
            String[] Predikaatti = {"Attacks", "Runs", "Hits", "Dates", "Loves", "Walks", "Swims", "Drives", "Talks",
                    "Drinks"};
            String[] Adjektiivi2 = {"Red", "Angry", "Hungry", "Starving", "Cold", "Hot", "Wet", "Dry", "Freezing",
                    "White"};
            String[] Objekti = {"Car", "Ship", "House", "Computer", "Mouse", "Headphones", "Building", "Wallet",
                    "Bottle", "Telephone"};

            // Talletetaan muuttujiin tieto siitä, kuinka monta sanaa taulukoissa on ja random arpoo sanat
            int pituusA1 = random.nextInt(Adjektiivi1.length);
            int pituusS = random.nextInt(Subjekti.length);
            int pituusP = random.nextInt(Predikaatti.length);
            int pituusA2 = random.nextInt(Adjektiivi2.length);
            int pituusO = random.nextInt(Objekti.length);

            // Tulostetaan lauseet
            System.out.println(Adjektiivi1[pituusA1] + " " + Subjekti[pituusS] + " " + Predikaatti[pituusP] + " " + Adjektiivi2[pituusA2]
                    + " " + Objekti[pituusO] + ".");
        }
    }

    // Pääohjelma
    public static void main(String [ ] args) {
        System.out.println("Tämä ohjelma tuottaa viisi satunnaista lausetta ja sammuu.\n");
        generaattori();
    }
}
