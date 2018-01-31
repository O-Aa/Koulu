/*
Ohjelman nimi: Asiakas3
Pvm: 27.6.2017
Kuvaus(Tehtävänanto): Muuta edellistä tehtävää siten, että se tallettaa tiedot tekstitiedoston sijaan binääritiedostoon.
*/

import java.util.*;
import java.io.*;

// Luodaan asiakas luokka
public class Asiakas3 {

    // Attribuutit
    private int ID;
    private String nimi;
    private String sposti;
    private String puhnro;

    // Konstruktori
    public Asiakas3(int id, String nim, String spost, String puhnr){
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
            FileOutputStream tiedosto = new FileOutputStream("asiakas.bin", true);
            ObjectOutputStream tiedostoonkirjoittaja = new ObjectOutputStream(tiedosto);

            tiedostoonkirjoittaja.writeInt(ID);
            tiedostoonkirjoittaja.writeObject(nimi);
            tiedostoonkirjoittaja.writeObject(sposti);
            tiedostoonkirjoittaja.writeObject(puhnro);

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
        ObjectInputStream reader = null;

        // Yritetään lukea tiedosto
        try {
            FileInputStream tiedostonlukija = new FileInputStream("asiakas.bin");
            reader =  new ObjectInputStream(tiedostonlukija);
            while (true) {


                ID = reader.readInt();
                nimi = (String) reader.readObject();
                sposti = (String) reader.readObject();
                puhnro = (String) reader.readObject();

                reader.close();
            }
        }
        // Ilmoitetaan käyttäjälle kun päästään tiedoston loppuun
        catch (EOFException eof) {
            System.out.println("Tiedosto loppui.");
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
        Asiakas3 asiakas1 = new Asiakas3(1,"Tino Torni","TT@gmail.com","123456");
        Asiakas3 asiakas2 = new Asiakas3(2,"Andy Ant","AA@luukku.com","654321");

        // Kirjoita metodi kirjoittaa binääritiedostoon asiakkaiden tiedot.
        asiakas1.kirjoitaTiedostoon();
        asiakas2.kirjoitaTiedostoon();

        // Tulostetaan näytölle tiedot asiakkaista joiden ID on 1 ja 2
        asiakas1.readFromFile("1");
        asiakas2.readFromFile("2");
    }
}
