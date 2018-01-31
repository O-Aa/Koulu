/*
Ohjelman nimi: Asiakas1
Pvm: 27.6.2017
Kuvaus(Tehtävänanto): Laadi asiakas-luokka, joka sisältää asiakkaan ID:n, nimen, sähköpostiosoitteen ja puhelinnumeron.
Toteuta luokkaan metodi tietojen kysymistä varten.

Laadi tämän jälkeen luokkaan metodi, joka kirjoittaa luokan mukaisen olion sisältämät tiedot talteen tekstitiedostoon.
Toteuta metodi siten, että kaikkien asiakkaiden (kyseisestä luokasta luotujen olioiden) tiedot talletetaan samaan
tekstitiedostoon. Alla on esimerkki tiedoston sisällöstä:
*/

import java.util.*;
import java.io.*;

// Luodaan asiakas luokka
public class Asiakas1 {

    // Attribuutit
    private int ID;
    private String nimi;
    private String sposti;
    private String puhnro;

    // Konstruktori
    public Asiakas1(int id, String nim, String spost, String puhnr){
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

    // Pääohjelma
    public static void main (String [ ] args) {

        // Luodaan uusi asiakas
        Asiakas1 asiakas1 = new Asiakas1(1,"Tino Torni","TT@gmail.com","123456");
        Asiakas1 asiakas2 = new Asiakas1(2,"Andy Ant","AA@luukku.com","654321");

        // Kirjoita metodi kirjoittaa tekstitiedostoon asiakkaiden tiedot.
        asiakas1.kirjoitaTiedostoon();
        asiakas2.kirjoitaTiedostoon();
    }
}
