/*
Ohjelman nimi: Elain2
Pvm: 21.6.2017
Kuvaus(Tehtävänanto): Lisää edellisiin luokkiin seuraava toiminnallisuus polymorfismia hyödyntäen:

Määrittele eläin-luokka abstraktiksi ja lisää siihen abstrakti puhu-metodi. Toteuta tämän jälkeen kissalle,
papukaijalle ja lampaalle omat toteutuksensa puhu-metodille. Lisää lopuksi pääohjelmaan osio, jossa lisäät kissan,
papukaijan ja lampaan samaan eläin-taulukkoon ja käyt taulukon alkiot läpi kutsuen jokaisen kohdalla puhu-metodia.
Tällöin jokaisen eläimen tulisi puhua lajilleen ominaisella tavalla.
*/

import java.util.*;

public class Elain2 {

    // Luodaan luokka Eläin
    abstract static class Elain{

        // Eläimen attribuutit
        protected String nimi;
        protected int elossa = 1;
        protected int elossaVaiei;

        // Konstruktori
        public Elain(String Nimi, int Elossa){
            nimi = Nimi;
            elossa = Elossa;
        }

        // Metodi eläimen nimen antamiselle
        public void annaNimi(){

            // Luodaann scanneri käyttäjän syötteitä varten.
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            System.out.println("Anna eläimen nimi: ");
            nimi = lukija.nextLine();
        }

        // Metodi nimen tulostamiselle
        public void kerroNimi(){
            System.out.println("Eläimen nimi on: "+nimi);
        }

        // Metodi selvittämään onko eläin elossa
        public void kerroOnkoElossa(){

            // Luodaann scanneri käyttäjän syötteitä varten.
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            System.out.println("Onko eläin elossa?(On = 1/ Ei =0 ): ");
            elossaVaiei = lukija.nextInt();

            if(elossaVaiei == 1)
                elossa = 1;
            else if (elossaVaiei == 0)
                elossa = 0;
            else{ System.out.println("Virheellinen syöte, ohjelma sammuu");
                System.exit(1);}
        }

        // Metodi jolla tulostetaan käyttäjän halutessa tieto siitä onko eläin elossa vai ei.
        public void tulostaOnkoElossa(){
            if (elossa == 1){
                System.out.println("Eläin on elossa.");}
            else if (elossa == 0){
                System.out.println("Eläin on kuollut.");}
            else{
                System.out.println("Ohjelma sammuu");
            }
        }

        // Abstrakti metodi puhu
        abstract void Puhu();
    }

    ///////////////////// KISSA ////////////////////////
    public static class Kissa extends Elain{

        // Kissan attribuutit
        private int elamat;

        // Kissan Konstruktori
        public Kissa (String Nimi, int Elossa,int elamaT){
            super(Nimi,Elossa);
            elamat = elamaT;
        }

        // Metodi, jolla voidaan asettaa kissan elämien määrä.
        public void asetaElamat(){

            // Luodaann scanneri käyttäjän syötteitä varten.
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            System.out.println("Kuinka monta elämää kissalle annetaan?: ");
            elamat = lukija.nextInt();
        }

        // Metodi jolla lisätään elämä kissalle.
        public int lisaaElama(){
            elamat = elamat +1;
            return elamat;
        }

        // Metodi jolla vähennetään elämä kissalta.
        public int vahennaElama(){
            elamat = elamat -1;
            return elamat;
        }

        // Metodi joka kertoo montako elämää kissalla on tällä hetkellä.
        public void kerroElamat(){
            System.out.println("Kissalla on tällä hetkellä "+elamat+" elämää");
        }

        // Kissan puhu metodi
        void Puhu(){
            System.out.println("miumau");
        }
    }

    //////////////////////////// PAPUKAIJA /////////////////////////
    public static class Papukaija extends Elain{

        // Papukaijan attribuutit
        private String mrosvo;

        // Konstruktori
        public Papukaija(String Nimi, int Elossa, String mRosvo){
            super(Nimi,Elossa);
            mrosvo = mRosvo;
        }

        //Metodi merirosvoisännän asettamiseksi
        public void asetaMrosvo(){

            // Luodaann scanneri käyttäjän syötteitä varten.
            Scanner lukija;
            Locale.setDefault(Locale.ENGLISH);
            lukija = new Scanner(System.in);

            System.out.println("Mikä on papukaijan merirosvoisännän nimi?: ");
            mrosvo = lukija.nextLine();
        }

        // Metodi merirosvoisännän tulostamiseksi
        public void tulostaMrosvo(){
            System.out.println("Papukaijan merirosvoisännän nimi on: "+mrosvo);
        }

        // Papukaijan puhu metodi
        void Puhu(){
            System.out.println("titityy");
        }
    }
    /////////////////// LAMMAS ///////////////////////////////
    public static class Lammas extends Elain{

        //Attribuutit
        private String vari = "Valkoinen";

        // Konstruktori
        public Lammas(String Nimi, int Elossa, String Vari){
            super(Nimi,Elossa);
            vari = Vari;
        }

        // Metodi joka muuttaa värin mustaksi.
        public void variMustaksi(){
            vari = "Musta";
        }

        // Metodi joka muuttaa värin takaisin valkoiseksi.
        public void variValkoiseksi(){
            vari = "Valkoinen";
        }

        // Metodi joka kertoo värin.
        public void kerroVari(){
            System.out.println("Lampaan väri on: "+vari);
        }

        // Lampaan puhu metodi
        void Puhu(){
            System.out.println("määmää");
        }
    }

    public static void main(String [ ] args) {

        // Luodaan oliot
        Kissa kissa1 = new Kissa("Kissa",1,9);
        Papukaija papukaija1 = new Papukaija("Papukaija",1,"Merirosvo");
        Lammas lammas1 = new Lammas("Lammas",1,"Valkoinen");

        // Eläin oliot taulukkoon.
        Elain etaulukko[] = new Elain[3];
        etaulukko[0] = kissa1;
        etaulukko[1] = papukaija1;
        etaulukko[2] = lammas1;

        // Kutsutaan metodia puhu, joka tulostaa eläinten puhumiset
        for(int i = 0; i < 3; i++){
            etaulukko[i].Puhu();
        }

        // Apumuuttujat valinnan tekemiseen
        int valinta1, valinta2;

        // Luodaann scanneri käyttäjän syötteitä varten.
        Scanner lukija;
        Locale.setDefault(Locale.ENGLISH);
        lukija = new Scanner(System.in);

        //Elain elain = new Elain("Elain", 1);

        System.out.println("Valitse eläin Kissa = 1, Papukaija = 2, Lammas = 3.");
        valinta1 = lukija.nextInt();

        // Kissa
        if(valinta1 == 1){
            Kissa kissa = new Kissa("kissa",1,9);

            do {
                System.out.println("Valitsit kissan. Mitä haluat tehdä?");
                System.out.println("(1) Anna kissalle nimi\n(2) Tarkista Kissan nimi\n(3) Kerro ohjelmalle onko kissa elossa\n" +
                        "(4) Tarkista onko kissa elossa\n(5) Aseta kissalle elämät\n(6) Lisää yksi elämä\n" +
                        "(7) Vähennä yksi elämä\n(8) Tarkista elämien määrä\n(-1) Lopeta ohjelma ");
                System.out.println("Valintasi: ");
                valinta2 = lukija.nextInt();
                switch (valinta2) {
                    case 1:kissa.annaNimi();
                        break;
                    case 2:kissa.kerroNimi();
                        break;
                    case 3:kissa.kerroOnkoElossa();
                        break;
                    case 4:kissa.tulostaOnkoElossa();
                        break;
                    case 5:kissa.asetaElamat();
                        break;
                    case 6:kissa.lisaaElama();
                        break;
                    case 7:kissa.vahennaElama();
                        break;
                    case 8:kissa.kerroElamat();
                        break;
                    default:
                        System.out.println("Virheellinen syöte, ohjelma sammuu.");
                        System.exit(1);
                }
            }while(valinta2 != -1);
        }

        // Papukaija
        else if (valinta1 == 2){

            Papukaija papukaija = new Papukaija("Papukaija",1,"Isäntä");

            do {
                System.out.println("Valitsit papukaijan. Mitä haluat tehdä?");
                System.out.println("(1) Anna papukaijalle nimi\n(2) Tarkista papukaijan nimi\n(3) Kerro ohjelmalle onko papukaija elossa\n" +
                        "(4) Tarkista onko papukaija elossa\n(5) Aseta papukaijan isäntä\n(6) Tulosta papukaijan isäntä\n"+
                        "(-1) Lopeta ohjelma");
                System.out.println("Valintasi: ");
                valinta2 = lukija.nextInt();
                switch (valinta2) {
                    case 1:papukaija.annaNimi();
                        break;
                    case 2:papukaija.kerroNimi();
                        break;
                    case 3:papukaija.kerroOnkoElossa();
                        break;
                    case 4:papukaija.tulostaOnkoElossa();
                        break;
                    case 5: papukaija.asetaMrosvo();
                        break;
                    case 6: papukaija.tulostaMrosvo();
                        break;
                    default:
                        System.out.println("Virheellinen syöte, ohjelma sammuu.");
                        System.exit(1);
                }
            }while(valinta2 != -1);
        }

        // Lammas
        else if (valinta1 == 3) {

            Lammas lammas = new Lammas("Lammas", 1, "Valkoinen");

            do {
                System.out.println("Valitsit lampaan. Mitä haluat tehdä?");
                System.out.println("(1) Anna lampaalle nimi\n(2) Tarkista lampaan nimi\n(3) Kerro ohjelmalle onko lammas elossa\n" +
                        "(4) Tarkista onko lammas elossa\n(5) Kerro lampaan väri\n(6) Aseta väri mustakasi\n" +
                        "(7) Aseta väri valkoiseksi\n (-1) Lopeta ohjelma ");
                System.out.println("Valintasi: ");
                valinta2 = lukija.nextInt();
                switch (valinta2) {
                    case 1:lammas.annaNimi();
                        break;
                    case 2:lammas.kerroNimi();
                        break;
                    case 3:lammas.kerroOnkoElossa();
                        break;
                    case 4:lammas.tulostaOnkoElossa();
                        break;
                    case 5:lammas.kerroVari();
                        break;
                    case 6:lammas.variMustaksi();
                        break;
                    case 7:lammas.variValkoiseksi();
                        break;
                    default:
                        System.out.println("Virheellinen syöte, ohjelma sammuu.");
                        System.exit(1);
                }
            } while (valinta2 != -1);
        }
    }
}

