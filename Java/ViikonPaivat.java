/*
Ohjelman nimi: ViikonPaivat
Pvm: 13.6.2017
Kuvaus(Tehtävänanto): Laadi ohjelma, joka tallettaa viikonpäivät kolmella eri kielellä taulukkoon/taulukkoihin.
Kielet voit valita vapaasti. Ohjelman tulee tietojen tallettamisen jälkeen kysyä, monennenko viikonpäivän nimen
käyttäjä haluaa tietää ja millä kolmesta kielestä, sekä tulostaa vastaus näytölle
*/

import java.util.*;

public class ViikonPaivat {

    // Luodaan vakio, joka määrittää taulukon koon
    static final int paivienMaara = 7;

    public static void main (String [ ] args) {

        // Luodaan taulukot ja talletetaan niihin viikonpäivät kolmella eri kielellä.

        String[] suomiTaulukko = new String[paivienMaara];
        suomiTaulukko[0] = "Maanantai";
        suomiTaulukko[1] = "Tiistai";
        suomiTaulukko[2] = "Keskiviikko";
        suomiTaulukko[3] = "Torstai";
        suomiTaulukko[4] = "Perjantai";
        suomiTaulukko[5] = "Lauantai";
        suomiTaulukko[6] = "Sunnuntai";

        String[] englantiTaulukko = new String[paivienMaara];
        englantiTaulukko[0] = "Monday";
        englantiTaulukko[1] = "Tuesday";
        englantiTaulukko[2] = "Wednesday";
        englantiTaulukko[3] = "Thursday";
        englantiTaulukko[4] = "Friday";
        englantiTaulukko[5] = "Saturday";
        englantiTaulukko[6] = "Sunday";

        String[] ruotsiTaulukko = new String[paivienMaara];
        ruotsiTaulukko[0] = "Måndag";
        ruotsiTaulukko[1] = "Tisdag";
        ruotsiTaulukko[2] = "Onsdag";
        ruotsiTaulukko[3] = "Torsdag";
        ruotsiTaulukko[4] = "Fredag";
        ruotsiTaulukko[5] = "Lördag";
        ruotsiTaulukko[6] = "Söndag";

        // Luodaan scanneri lukemaan käyttäjän syötteet.
        Scanner lukija;
        lukija = new Scanner(System.in);

        // Luodaan tarvittavat muuttujat
        int kieli = 0 , paiva = 0;

        // Kysytään käyttäjältä millä kielellä tulostus halutaan, virheellisistä kokonaislukusyötteistä
        // tulostuu virheilmoitus ja käyttäjä voi yrittää uudestaan virheen sattuessa.
        
        System.out.println("Ohjelma pyytää sinua valitsemaan päivän ja kielen,\nja tulostaa kyseisen päivän kyseisellä kielellä");
        do {
            System.out.println("Millä kielellä haluat tulostuksen(1=Suomi, 2=Englanti, 3=Ruotsi)?: ");
            kieli = lukija.nextInt();
            if (kieli < 1 || kieli >= 4 )
                System.out.println("Virheellinen syöte, yritä uudelleen.");
        }while(kieli != 1 && kieli != 2 && kieli != 3);

        // Kysytään käyyttäjältä minkä viikonpäivän hän haluaa tietää valitsemallaan kielellä.
        System.out.println("Minkä päivän nimen haluat tietää (1=Maanantai, ... , 7=Sunnuntai): ");
        paiva = lukija.nextInt();

        // Jos kieli on Suomi
        if (kieli == 1){
            switch (paiva){
                case 1: System.out.println("1. Viikonpäivä on suomeksi "+suomiTaulukko[0]+".");
                    break;
                case 2: System.out.println("2. Viikonpäivä on suomeksi "+suomiTaulukko[1]+".");
                    break;
                case 3: System.out.println("3. Viikonpäivä on suomeksi "+suomiTaulukko[2]+".");
                    break;
                case 4: System.out.println("4. Viikonpäivä on suomeksi "+suomiTaulukko[3]+".");
                    break;
                case 5: System.out.println("5. Viikonpäivä on suomeksi "+suomiTaulukko[4]+".");
                    break;
                case 6: System.out.println("6. Viikonpäivä on suomeksi "+suomiTaulukko[5]+".");
                    break;
                case 7: System.out.println("7. Viikonpäivä on suomeksi "+suomiTaulukko[6]+".");
                    break;
                // Jos luku ei ole väliltä 1-7, ohjelma tulostaa virheilmoituksen ja sammuu.
                default:
                    System.out.println("Annoit virheellisen päivän, ohjelma sammuu.");
                    System.exit(1);
            }
            
         // Jos kieli on Englanti
        } else if (kieli == 2) {
            switch (paiva) {
                case 1: System.out.println("1. Viikonpäivä on englanniksi " + englantiTaulukko[0] + ".");
                    break;
                case 2: System.out.println("2. Viikonpäivä on englanniksi " + englantiTaulukko[1] + ".");
                    break;
                case 3: System.out.println("3. Viikonpäivä on englanniksi " + englantiTaulukko[2] + ".");
                    break;
                case 4: System.out.println("4. Viikonpäivä on englanniksi " + englantiTaulukko[3] + ".");
                    break;
                case 5: System.out.println("5. Viikonpäivä on englanniksi " + englantiTaulukko[4] + ".");
                    break;
                case 6: System.out.println("6. Viikonpäivä on englanniksi " + englantiTaulukko[5] + ".");
                    break;
                case 7: System.out.println("7. Viikonpäivä on englanniksi " + englantiTaulukko[6] + ".");
                    break;
                // Jos luku ei ole väliltä 1-7, ohjelma tulostaa virheilmoituksen ja sammuu.
                default:
                    System.out.println("Annoit virheellisen päivän, ohjelma sammuu.");
                    System.exit(1);
            }
            
            // Jos kieli on Ruotsi
        } else if (kieli == 3) {
            switch (paiva) {
                case 1: System.out.println("1. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[0] + ".");
                    break;
                case 2: System.out.println("2. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[1] + ".");
                    break;
                case 3: System.out.println("3. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[2] + ".");
                    break;
                case 4: System.out.println("4. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[3] + ".");
                    break;
                case 5: System.out.println("5. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[4] + ".");
                    break;
                case 6: System.out.println("6. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[5] + ".");
                    break;
                case 7: System.out.println("7. Viikonpäivä on ruotsiksi " + ruotsiTaulukko[6] + ".");
                    break;
                // Jos luku ei ole väliltä 1-7, ohjelma tulostaa virheilmoituksen ja sammuu.
                default:
                    System.out.println("Annoit virheellisen päivän, ohjelma sammuu.");
                    System.exit(1);
            }
        }
    }
}
