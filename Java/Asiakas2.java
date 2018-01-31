/*
Ohjelman nimi: Asiakas2
Pvm: 27.6.2017
Kuvaus(Tehtävänanto):

Muokkaa edellistä tehtävää seuraavasti.

Lisää asiakas-luokkaan metodi tietojen näytölle tulostamista varten. Lisää luokkaan tämän jälkeen metodi, jonka avulla
voit lukea halutun asiakkaan tiedot edellisen tehtävän mukaisesti toteutetusta tekstitiedostosta
asiakkaan ID:n perusteella, tyyliin:

public void readFromFile(String searchID)
Vihje: hyödynnä halutun asiakkaan etsinnässä String-luokan merkkijonojen käsittelyyn tarjoamia metodeja.
*/

import java.util.*;
import java.io.*;

// Luodaan asiakas luokka
public class Asiakas2 {

    // Attribuutit
    private int ID;
    private String nimi;
    private String sposti;
    private String puhnro;

    // Konstruktori
    public Asiakas2(int id, String nim, String spost, String puhnr){
        ID = id;
        nimi = nim;
        sposti = spost;
        puhnro = puhnr;
    }

    // Metodi tietojen kysymistä varten.
    public void kysyTiedot(){

        // Luodaan scanneri lukijan syötteitä varten
        Scanner lukija;
        lukija = new Scanner(System.in);

        // Kysytään tiedot
        System.out.println("Anna ID: ");
        ID = lukija.nextInt();
        System.out.println("Anna nimmi: ");
        nimi = lukija.nextLine();
        System.out.println("Anna sähköpostiosoite: ");
        sposti = lukija.nextLine();
        System.out.println("Anna puhelinnumero: ");
        puhnro = lukija.nextLine();
    }

    public void tulostaTiedot(){
        System.out.println("ID: "+ID);
        System.out.println("Name: "+nimi);
        System.out.println("E-mail: "+sposti);
        System.out.println("Phone number: "+puhnro);
    }

    // Kirjoitetaan tiedot tiedostoon.
    public void kirjoitaTiedostoon(){

        try{
            // Luodaan tarvittavat oliot tiedostoon kirjoittamista varten ja kirjoitetaan asiakkaan tiedot
            BufferedWriter tiedostoonkirjoittaja = new BufferedWriter(new FileWriter("asiakas.txt",true));
            tiedostoonkirjoittaja.write("Data for customer #"+ID);
            tiedostoonkirjoittaja.newLine();
            tiedostoonkirjoittaja.write("Name: "+nimi);
            tiedostoonkirjoittaja.newLine();
            tiedostoonkirjoittaja.write("E-mail: "+sposti);
            tiedostoonkirjoittaja.newLine();
            tiedostoonkirjoittaja.write("Phone number: "+puhnro);
            tiedostoonkirjoittaja.newLine();

            // Suljetaan tiedosto kirjoittamisen jälkeen
            tiedostoonkirjoittaja.close();
        }
        // Mikäli tiedostoja ei löydy, ilmoitetaan asiasta ja lopetetaan ohjelma
        catch(FileNotFoundException e) {
            System.out.print("Tiedostoa ei löytynyt. Lopetan.");
            System.exit(1);
        }
        // Otetaan kiinni syöte- ja tulostevirtoihin liittyvät poikkeukset, tulostetaan ilmoitus ja lopetetaan.
        catch(IOException e){
            System.out.print("Syöte ja tulostevirtojen käsittely epäonnistui. Lopetan.");
            System.exit(1);
        }
        // Otetaan kiinni kaikki muut poikkeukset, tulostetaan yleispätevä ilmoitus ja lopetetaan ohjelma
        catch(Exception e){
            System.out.println("Jotain meni pieleen. Lopetan");
        }
    }

    // Metodi jolla luetaan asiakkaan tiedot ja tulostetaan ne näytölle jos ID on haluttu
    public void readFromFile(String searchID)
    {
        // Yritetään lukea tiedosto
        try {

            BufferedReader tiedostolukija = new BufferedReader(new FileReader("asiakas.txt"));
            String luetturivi;

            // Luetaan rivejä tiedostosta niin kauan, kun tekstitiedostossa on rivejä jäljellä.
            while ((luetturivi = tiedostolukija.readLine()) != null) {

                // Jos luetturivi sisältää rivin, jossa haluttu ID on, tulostetaan tiedot.
                if (luetturivi.contains("Data for customer #" + searchID)) {

                    // Tulostetaan ID rivin jälkeiset tiedot.
                    for (int i = 0; i < 3; i++) {
                        luetturivi = tiedostolukija.readLine();
                        System.out.println(luetturivi);
                    }
                }
            }
            // Suljetaan tiedostolukija
            tiedostolukija.close();
        }
        // Mikäli tiedostoja ei löydy, ilmoitetaan asiasta ja lopetetaan ohjelma
        catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt. Lopetan");
            System.exit(1);
        }
        // Otetaan kiinni syöte- ja tulostevirtoihin liittyvät poikkeukset, tulostetaan ilmoitus ja lopetetaan.
        catch(IOException e) {
            System.out.println("Syöte ja tulostevirtojen käsittely epäonnistui. Lopetan");
            System.exit(1);
        }
        // Otetaan kiinni kaikki muut poikkeukset, tulostetaan yleispätevä ilmoitus ja lopetetaan ohjelma
        catch(Exception e) {
            System.out.println("Jotain meni pieleen. Lopetan");
            System.exit(1);
        }
    }

    // Pääohjelma
    public static void main (String [ ] args) {

        // Luodaan uusi asiakas
        Asiakas2 asiakas1 = new Asiakas2(1,"Tino Torni","TT@gmail.com","123456");
        Asiakas2 asiakas2 = new Asiakas2(2,"Andy Ant","AA@luukku.com","654321");

        // Tulostetaan asiakkaiden tiedot.
        System.out.println("Tulostetaan asiakkaiden tiedot...\n");
        asiakas1.tulostaTiedot();
        asiakas2.tulostaTiedot();

        // Kirjoita metodi kirjoittaa tekstitiedostoon asiakkaiden tiedot.
        System.out.println("\nOhjelma kirjoittaa asiakkaiden tiedot tekstitiedostoon...\n");
        asiakas1.kirjoitaTiedostoon();
        asiakas2.kirjoitaTiedostoon();

        // Tulostetaan näytölle tiedot asiakkaista joiden ID on 1 ja 2
        System.out.println("Ohjelma lukee tekstitiedostosta asiakkaiden tiedot ja tulostaa näytölle tiedot asiakkaista, joiden ID on 1 ja 2...\n");
        asiakas1.readFromFile("1");
        asiakas2.readFromFile("2");
    }
}
