/*
Ohjelman nimi: TehtavaLista
Pvm: 28.6.2017
Kuvaus(Tehtävänanto): Laadi luokka tehtävien listaamista varten. Luokan tulee sisältää merkkijono, joka sisältää
tehtävän kuvauksen. Luokan tulee lisäksi sisältää metodit, joiden avulla tehtäväkuvaus voidaan kysyä käyttäjältä
ja tulostaa näytölle. Määrittele pääohjelmassa jono, johon voidaan tallettaa tehtävä-luokan mukaisia olioita.
Testaa pääohjelmassa monipuolisesti jonosi ja tehtävä-luokkasi toimintaa.
*/

import java.util.*;

public class TehtavaLista {

    // Luodaan luokka tehtävälista
    public static class Tehtava{

       // Attribuutit
        protected String tehtkuvaus;

        // Konstruktori
        public Tehtava(String tkuvaus){
            tehtkuvaus = tkuvaus;
        }

        // Metodi joka kysyy tehtäväkuvauksen
        public void kerroKuvaus(){

            // Luodaan scanner syötteiden lukua varten
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            // Kysytään kuvaus
            System.out.println("Anna tehtäväkuvaus: ");
            tehtkuvaus = lukija.nextLine();
        }

        public String Kuvaus(){
            return tehtkuvaus;
        }

        // Metodi joka tulsotaa kuvauksen
        public void tulostaKuvaus(){
            System.out.println("Tehtäväkuvaus on: "+Kuvaus());
        }
    }

    // Pääohjelma
    public static void main(String [] args){

        // Apumuuttuja auttamaan valinnassa
        int valinta;

        // Luodaan scanner syötteiden lukua varten
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Luodaan uusi tehtävälista
        Tehtava tehtava = new Tehtava("kuvaus");

        // Luodaan uusi jono
        Queue<Object> jono = new LinkedList<Object>();

        // Kysytään käyttäjältä mitä tehdään.
        do {
            System.out.println("(1) Lisää tehtävä\n(2) Tulosta tehtävät\n(-1) Lopeta ohjelma: ");
            valinta = lukija.nextInt();

            if (valinta == 1) {
                tehtava.kerroKuvaus();
                // Lisätään tehtävä jonoon.
                jono.add(tehtava.Kuvaus());
            }
            else if (valinta == 2) {

                // Tehdään jonosta taulukko, jotta tulostus olisi tehokkaampaa.
                Object[] taulukko = jono.toArray();
                // Tulostetaan tehtävälista.
                System.out.println("Tulostetaan tehtävälista... ");
                for (int i = 0; i < taulukko.length; i++)
                    System.out.println(taulukko[i]);
            }
            else if (valinta == -1){
                System.out.println("Ohjelma sammuu.");
            }
        } while (valinta != -1);
    }
}
