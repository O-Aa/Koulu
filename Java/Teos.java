/*
Ohjelman nimi: Teos
Pvm: 17.6.2017
Kuvaus(Tehtävänanto): Toteuta Teos-luokka kirjastokäyttöön. Luokan tulee sisältää ainakin seuraavat attribuutit:

Tekijä, teoksen nimi, genre, ISBN, sivumäärä ja tila. Tila-attribuutti kertoo, onko teos saatavilla, lainassa, hävinnyt tms.

Luokan tulee sisältää ainakin seuraavan toiminnallisuuden mahdollistavat metodit:

Teoksen tila täytyy voida muuttaa ja tarkistaa tai tulostaa.
Teoksen tiedot täytyy voida syöttää käyttäjän toimesta.
Teoksen tiedot täytyy voida tulostaa käyttäjälle.

Laadi lisäksi pääohjelma, jossa testaat luomasi luokan toiminnallisuuden.
*/

import java.util.*;

    // Luodaan luokka kirja, ja annetaan sille attribuutit
    class Kirja{

        // Attribuutit teokselle
        private String tekija;
        private String nimi;
        private String genre;
        private int ISBN;
        private int sivumaara;
        public String tila;

        // Konstruktori teokselle
        public Kirja(String te, String ni, String gen, int isbn, int sivut, String til ){
            tekija = te;
            nimi = ni;
            genre = gen;
            ISBN = isbn;
            sivumaara = sivut;
            tila = til;
        }

        // Metodi jolla kysellään teoksen tiedot käyttäjältä.
        public void syotaTiedot() {

            // Luodaann scanneri käyttäjän syötteitä varten.
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            // Pyydetään käyttjältä teoksen tiedot.
            System.out.println("Anna teoksen tila (Saatavilla / Lainassa / Hävinnyt):");
            tila = lukija.nextLine();
            System.out.println("Anna tekijän nimi: ");
            tekija = lukija.nextLine();
            System.out.println("Anna teoksen nimi: ");
            nimi = lukija.nextLine();
            System.out.println("Anna teoksen genre: ");
            genre = lukija.nextLine();
            System.out.println("Anna teoksen ISBN: ");
            ISBN = lukija.nextInt();
            System.out.println("Anna teoksen sivujen lukumäärä: ");
            sivumaara = lukija.nextInt();
        }

        // Metodi jolla teoksn tilaa muutetaan.
        public void muutaTilaa(){

            // Luodaann scanneri käyttäjän syötteitä varten..
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            System.out.println("Anna teoksen uusi tila: ");
            tila = lukija.nextLine();
            System.out.println("Uusi tila on nyt: "+tila);
        }

        // Metodit joiden avulla tulostetaan teoksen tiedot.
        public String kerroTekija(){
            return tekija;
        }
        public String kerroNimi(){
            return nimi;
        }
        public String kerroGenre(){
            return genre;
        }
        public int kerroISBN(){
            return ISBN;
        }
        public int kerroSivut(){
            return sivumaara;
        }
        public String kerroTila(){
            return tila;
        }

        // Metodi joka tulostaa syötetyt tiedot käyttäjälle.
        void tulostaTiedot(){
            System.out.println("Teoksen tekijä on: "+kerroTekija());
            System.out.println("Teoksen nimi on: "+kerroNimi());
            System.out.println("Teoksen genre on: "+kerroGenre());
            System.out.println("Teoksen ISBN on: "+kerroISBN());
            System.out.println("Teoksessa on "+kerroSivut()+"sivua");
            System.out.println("Teoksen tila on: "+kerroTila());
        }
    }

public class Teos {

    // Pääohjelma jota kutsutaan ohjelman suorituksen alkaessa.
    public static void main(String [ ] args) {

        // Apumuuttuja valinta käyttäjän valinnan tekemiseen.
        int valinta;
        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        Kirja kirja = new Kirja("Teos", "Kirjailija", "Genre", 0, 0, "Tila puuttuu");
        System.out.println("Anna teokselle seuraavat tiedot: \n");
        kirja.syotaTiedot();
        System.out.println("Annoit seuraavat tiedot: \n");
        kirja.tulostaTiedot();

        // Tarkastetaan silmukalla ohjelman toimivuus
        do {
            System.out.println("\nHaluatko muuttaa tai tarkistaa teoksen tilan, vai tulostaa antamasi tiedot" +
                    "\n(1= Muuta tila, 2= Tarkista tila, 3= Tulosta tiedot, 0 = Ohjelma sammuu): ");
            valinta = lukija.nextInt();

            if (valinta == 0) {
            System.out.println("Ohjelma sammuu.");
            System.exit(1);
            }
            else if (valinta == 1) {
            kirja.muutaTilaa();
            }
            else if (valinta == 2) {
            System.out.println("Teos on tällä hetkellä: " + kirja.tila);
            }
            else if (valinta == 3) {
            kirja.tulostaTiedot();
            }
            else {
            System.out.println("Annoit virheellisen syötteen, ohjelma sammuu.");
            System.exit(1);
        }
    } while (valinta != 0);
    }
}
