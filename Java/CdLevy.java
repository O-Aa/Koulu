/*
Ohjelman nimi: CdLevy
Pvm: 28.6.2017
Kuvaus(Tehtävänanto):Laadi luokka, joka sisältää tiedot yksittäisestä cd-levystä. Minimissään tiedoista löytyvät
artisti, levyn nimi ja vuosi. Laadi luokalle metodit, joiden avulla voit kysyä levyn tiedot käyttäjältä ja tulostaa
levyn tiedot näytölle. Laadi seuraavaksi levykokoelma-luokka. Levykokoelma-luokka sisältää vektorin(ArrayList), johon
levyt talletetaan. Tämän lisäksi luokka sisältää metodit levyjen lisäämistä ja poistamista sekä kokoelman tulostamista
varten. Toteuta myös pääohjelma, jolla testaat edellä esiteltyjen luokkien toimintaa.
*/

import java.util.*;


public class CdLevy {

    public static class Levy{

        // Attribuutit
        public String artisti;
        public String lnimi;
        public int vuosi;

        // Konstruktori

        public Levy(String artist, String lnim, int vuos){
            artisti = artist;
            lnimi = lnim;
            vuosi = vuos;
        }

        // Metodi jolla pyydetään käyttäjältä levyn tiedot
        public void kerroTiedot(){

            // Luodaan scanner syötteiden lukua varten
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            // Kysytään tiedot
            System.out.println("Anna levyn artisti: ");
            artisti = lukija.nextLine();
            System.out.println("Anna levyn nimi: ");
            lnimi = lukija.nextLine();
            System.out.println("Anna levyn julkaisu vuosi: ");
            vuosi = lukija.nextInt();
        }

        public String kerroArtisti(){
            return artisti;
        }
        public String kerroNimi(){
            return lnimi;
        }
        public int kerroVuosi(){
            return vuosi;
        }

        void tulostaTiedot(){
            System.out.println("Artisti: "+kerroArtisti());
            System.out.println("Levyn nimi: "+kerroNimi());
            System.out.println("Julkaisuvuosi: "+kerroVuosi());
        }
    }

    // Luodaan levykokoelma luokka
    public static class Levykokoelma{

        // Vektori
        // Objekti siksi, koska Characterin kanssa levyn lisääminen ei toiminut.
        Vector<Object> vektori = new Vector<Object>();

        // Metodi levyn lisäämistä varten
        public void lisaaLevy(){

            Levy levy = new Levy("Artisti","Levyn nimi",0);
            levy.kerroTiedot();
            vektori.add(levy.artisti +" " + levy.lnimi + " "+ levy.vuosi);
        }

        // Metodi levyn poistamista varten
        public void poistaLevy(){

            // Luodaan scanner syötteiden lukua varten
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            // Apumuuttuja indeksi, jonka avulla monesko levy poistetaan.
            int i;

            // Kysytään käyttäjältä mikä levy poistetaan.
            System.out.println("Monesko levy poistetaan(0 - x): ");
            i = lukija.nextInt();

            // Poistetaan levy
            vektori.remove(i);
        }

        // Metodi levyn tulostamista varten
        public void tulostaKokoelma(){

            // Luodaan vektorista taulukko, jotta tulostus helpompaa
            Object[]objArray = vektori.toArray();
            System.out.println("Tulostetaan levykokoelma...");

            // Tulostetaan
            for (int i = 0; i < objArray.length; i++)
                System.out.println(objArray[i]);
        }
    }

    // Pääohjelma
    public static void main (String [ ] args) {

        // Apumuuttuja valinta
        int valinta;

        // Luodaan scanner syötteiden lukua varten
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Luodaan uusi levykokoelma
        Levy levy = new Levy("Artisti","Levyn nimi",0);
        Levykokoelma Kokoelma = new Levykokoelma();


        // Kysytään mitä käyttäjä haluaa tehdä
        do
        {
            System.out.println("Mitä haluat tehdä?\n(1) Lisää levy\n(2) Poista levy\n(3) Tulosta levykokoelma\n(-1) Lopeta ohjelma: ");
            valinta = lukija.nextInt();

            if (valinta == 1) {
                Kokoelma.lisaaLevy();
            }
            else if (valinta == 2) {
                Kokoelma.poistaLevy();
            }
            else if (valinta == 3) {
                Kokoelma.tulostaKokoelma();
            }
            else{
                System.out.println("Virheellinen syöte, ohjelma sammuu.");
                System.exit(1);
            }
        } while (valinta != -1);
    }
}
