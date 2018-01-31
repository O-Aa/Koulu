/*
Ohjelman nimi: PeliH
Pvm: 17.6.2017
Kuvaus(Tehtävänanto): Laadi pelihahmo-luokka, joka sisältää ainakin seuraavat attribuutit:
Nimi, hahmoluokka (esim. soturi, varas, velho, ..), sukupuoli, ikä ja ase. Toteuta hahmoluokka ja ase omina luokkinaan
ja käytä niitä pelihahmo-luokan attribuutteina.
Hahmoluokka sisältää ainakin seuraavat attribuutit:
Luokan nimi, hahmon taso ja erityistaidot.
Ase-luokka sisältää ainakin seuraavat attribuutit:
Tyyppi, vahinko ja bonukset.
Kaikissa toteutettavissa luokissa tulee olla metodit tietojen kyselemistä ja tulostamista varten. Attribuuttien tyypit
 voit valita parhaaksi katsomallasi tavalla.
Laadi lisäksi pääohjelma, jossa testaat luomiesi luokkien toiminnallisuuden
*/

import java.util.*;

public class PeliH {

    // Luodaan PeliHahmo-luokka
public static class PeliHahmo{

    // Attribuutit
    private String nimi;
    public String hahmoluokka;
    private String sukupuoli;
    private int ika;
    public String ase;

    // Konstruktori
    public PeliHahmo(String ni, String hahmol, String suku, int ik, String as){
        nimi = ni;
        hahmoluokka = hahmol;
        sukupuoli = suku;
        ika = ik;
        ase = as;
    }

    // Kysytään PeliHahmon tiedot käyttäjältä
    public void syotaPelihahmo(){

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        System.out.println("Anna Pelihahmollesi nimi: ");
        nimi = lukija.nextLine();
        System.out.println("Mikä on pelihahmosi luokka?(Soturi, Varas vai Velho?): ");
        hahmoluokka = lukija.nextLine();
        System.out.println("Anna hahmosi ase: ");
        ase = lukija.nextLine();
        System.out.println("Anna hahmosi sukupuoli: ");
        sukupuoli = lukija.nextLine();
        System.out.println("Anna hahmosi ikä: ");
        ika = lukija.nextInt();
    }

    // Metodit avustamaan tulostusta
    public String kerroNimi(){
        return nimi;
    }
    public String kerroSukupuoli(){
        return sukupuoli;
    }
    public int kerroIka(){
        return ika;
    }
    public String kerroHLuokka(){
        return hahmoluokka;
    }
    public String kerroAse(){
        return ase;
        }

    // Tulsotaa Pelihahmon tiedot käyttäjälle.
    public void tulostaPelihahmo(){
        System.out.println("Hahmosi nimi on: "+kerroNimi());
        System.out.println("Hahmosi sukupuoli on: "+kerroSukupuoli());
        System.out.println("Hahmosi ikä on: "+kerroIka()+"-vuotta");
        System.out.println("Hahmoluokka on:  "+kerroHLuokka());
        System.out.println("Hahmosi ase on: "+kerroAse());
    }
}

////////////////////// Luodaan HahmoLuokka-luokka////////////////////////////
public static class HahmoLuokka{

    // Attribuutit
    private String luokka;
    private int taso;
    private String erityistaidot;

    // Konstruktori
    public HahmoLuokka(String luok, int level, String etaidot){
        luokka = luokka;
        taso = level;
        erityistaidot = etaidot;
    }

    // Kysytään pelihahmon hahmoluokka, taso ja erityistaidot
    public void syotaHahmoluokka(){

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Pyydetetään käyttäjältä syötteet
        System.out.println("Mihin luokkaan hahmosi kuuluu?(Ritarit, Talonpojat, Taikaihmiset)?: ");
        luokka = lukija.nextLine();
        System.out.println("Mikä on hahmosi erityistaito?: ");
        erityistaidot = lukija.nextLine();
        System.out.println("Mikä on hahmosi taso(0-100)?: ");
        taso = lukija.nextInt();
    }

    // Metodit avustamaan tulostusta
    public String kerroLuokka(){
        return luokka;
    }
    public int kerroTaso(){
        return taso;
    }
    public String kerroeTaito(){
        return erityistaidot;
    }

    // Tulostetaan tiedot
    public void tulostaHahmoluokka(){
        System.out.println("Hahmosi luokka on: "+kerroLuokka());
        System.out.println("Hahmosi taso on: "+kerroTaso());
        System.out.println("Hahmosi erityistaito on: "+kerroeTaito());
    }
}

///////////////// Luodaan Ase-luokka //////////////////////////
public static class Ase{

    // Attribuutit
    private String tyyppi;
    private int vahinko;
    private int bonus;
    public  String ase1;

    // Konstruktori
    public Ase(String tyyp, int vahink, int bonu){
        tyyppi = tyyp;
        vahinko = vahink;
        bonus = bonu;
    }

    public void syotaAse(){

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        System.out.println("Anna aseen tyyppi: ");
        tyyppi = lukija.nextLine();
        System.out.println("Paljonko ase tekee vahinkoa(0-100): ");
        vahinko = lukija.nextInt();
        System.out.println("Kuinka paljon aseen Bonus vahinko on(0-50)?: ");
        bonus = lukija.nextInt();
    }

    // Metodit avustamaan tulostusta
    public String kerroTyyppi(){
        return tyyppi;
    }
    public int kerroVahinko(){
        return vahinko;
    }
    public int kerroBonus(){
        return bonus;
    }

    // Tulostetaan aseen tiedot
    public void tulostaAse(){
        System.out.println("Aseen tyyppi: "+kerroTyyppi());
        System.out.println("Aseen vahinko: "+kerroVahinko());
        System.out.println("Aseen bonus-vahinko: "+kerroBonus());
    }
}
    /////////////// Pääohjelma jota kutsutaan ohjelman suorituksen alkaessa ///////////////
    public static void main(String [ ] args) {

        // Luodaan PeliHahmo-, HahmoLuokka-, ja Ase- luokkien mukaiset oliot
        PeliHahmo pelaaja = new PeliHahmo("Nimi", "Hahmoluokka", "Sukupuoli", 0, "Ase");
        HahmoLuokka luokka = new HahmoLuokka("Luokka", 0, "Erityistaidot");
        Ase ase = new Ase("Tyyppi", 0,0);

        // Apumuuttuja valinta käyttäjän valinnan tekemiseen.
        int valinta;

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        // Annetaan käyttäjän tehdä pelihahmo
        System.out.println("Luo itsellesi pelihahmo");
        pelaaja.syotaPelihahmo();
        luokka.syotaHahmoluokka();
        ase.syotaAse();

        // Kysytään käyttäjältä haluaako nähdä hahmon tiedot
        System.out.println("Halutako nähdä antamasi pelihahmon tiedot?(Kyllä = 1), (Ei = 2 Ohjelma sammuu): ");
        valinta = lukija.nextInt();

        if (valinta == 1) {
            pelaaja.tulostaPelihahmo();
            luokka.tulostaHahmoluokka();
            ase.tulostaAse();
        }
        else if (valinta == 2) {
            System.out.println("Ohjelma sammuu.");
            System.exit(1);
        }
        else {
            System.out.println("Virheellinen syöte, ohjelma sammuu.");
            System.exit(0);
        }
    }
}
