/*
Ohjelman nimi: KaksiJoukkoa
Pvm: 28.6.2017
Kuvaus(Tehtävänanto): Määrittele pääohjelmassa kaksi joukkoa ja talleta kumpaankin viisi kokonaislukua siten,
että vain osa eri joukkoihin talletetuista luvuista on samoja. Toteuta ohjelmassa joukko-opin mukaisista joukkojen
perusoperaatioista unioni, leikkaus ja erotus joukko-kokoelman tarjoamien metodien avulla. Tulosta tulosjoukko aina
jokaisen operaation jälkeen.
*/

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class KaksiJoukkoa {

    // Pääohjelma
    public static void main(String args[]){

        // Luodaan joukot A ja B ja lisätään niihin arvot ja luodaan joukoista listat
        Set<Integer> A = new HashSet<Integer>();
        A.addAll(Arrays.asList(2,4,6,8,10));

        Set<Integer> B = new HashSet<Integer>();
        B.addAll(Arrays.asList(8,10,12,14,16));

        // Joukkojen unioni
        Set<Integer> unioni = new HashSet<Integer>();
        unioni.addAll(A);
        unioni.addAll(B);
        System.out.println("Joukkojen unioni on: " + unioni);

        // Joukkojen leikkaus
        Set<Integer> leikkaus = new HashSet<Integer>();
        leikkaus.addAll(A);
        leikkaus.retainAll(B);
        System.out.println("Joukkojen leikkaus on: " + leikkaus);

        // Joukkojen erotus
        Set<Integer> erotus = new HashSet<Integer>();
        erotus.addAll(A);
        erotus.removeAll(B);
        System.out.println("Joukkojen erotus on: " + erotus);
    }
}
