/*
Ohjelman nimi: PvmFormaatti
Pvm: 16.6.2017
Kuvaus(Tehtävänanto): Laadi metodi (eli funktio), joka ottaa parametrinaan vuoden, kuukauden, päivän ja
 tulostusformaatin. Metodi tulostaa päivänmäärän halutussa formaatissa.
*/

import java.util.*;

public class PvmFormaatti {

    // Luodaan MuunnaPvm niminen metodi, joka muokkaa formaatit halutun laiseksi.
    public static void MuunnaPvm(int paiva, int kuukausi, int vuosi, int valinta) {

        // Jos valinta on 1 mukainen formaatti
        if (valinta == 1) {
            switch (kuukausi) {
                case 1:
                    System.out.println(paiva + ". tammikuuta " + vuosi);
                    break;
                case 2:
                    System.out.println(paiva + ". helmikuuta " + vuosi);
                    break;
                case 3:
                    System.out.println(paiva + ". maaliskuuta " + vuosi);
                    break;
                case 4:
                    System.out.println(paiva + ". helmikuuta " + vuosi);
                    break;
                case 5:
                    System.out.println(paiva + ". toukokuuta " + vuosi);
                    break;
                case 6:
                    System.out.println(paiva + ". kesäkuuta " + vuosi);
                    break;
                case 7:
                    System.out.println(paiva + ". heinäkuuta " + vuosi);
                    break;
                case 8:
                    System.out.println(paiva + ". elokuuta " + vuosi);
                    break;
                case 9:
                    System.out.println(paiva + ". syyskuuta " + vuosi);
                    break;
                case 10:
                    System.out.println(paiva + ". lokakuuta " + vuosi);
                    break;
                case 11:
                    System.out.println(paiva + ". marraskuuta " + vuosi);
                    break;
                case 12:
                    System.out.println(paiva + ". joulukuuta " + vuosi);
                    break;
            }
        }

        // Jos valinta on 2 mukainen formaatti
        else if (valinta == 2) {
            System.out.println(paiva + "." + kuukausi + "." + vuosi);
        }

        // Jos valinta on 3 mukainen formaatti
        else if (valinta == 3) {
            System.out.println(vuosi + "-" + kuukausi + "-" + paiva);
        }
    }

    public static void main (String [ ] args) {

        // Esitellään muuttujat
        int paiva, kuukausi, vuosi, valinta;

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Kysytään käyttäjältä päivä, kuukausi, vuosi sekä millaisen tulostuksen hän haluaa
        System.out.println("Anna päivä (1-31): ");
        paiva = lukija.nextInt();
        System.out.println("Anna kuukausi (1-12): ");
        kuukausi = lukija.nextInt();
        System.out.println("Anna vuosi: ");
        vuosi = lukija.nextInt();
        System.out.println("Valitse tulostusformaatti (ESIM: 1 = 6. joulukuuta 1917, 2 = 6.12.1917, 3 = 1917-12-06: ");
        valinta = lukija.nextInt();

        // Kutsutaan metodia joka tulostaa tiedot
        MuunnaPvm(paiva, kuukausi, vuosi, valinta);
    }
}
