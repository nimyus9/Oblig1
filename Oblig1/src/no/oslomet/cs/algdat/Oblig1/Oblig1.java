package no.oslomet.cs.algdat.Oblig1;

//////////////////// Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) throw new NoSuchElementException("Array kan ikke være tom!");
        else if(a.length == 1) return a[0];

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                bytt(a, i,i+1);
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int teller = 0;

        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i-1]){
                teller++;

                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
        return teller;
    }

    /*  TILLEGGSOPPGAVER TIL OPPGAVE 1)
     *
     * // * Naar blir det flest ombyttinger?
     * Det blir flest ombyttinger naar det stoerste tallet er foerst i rekken(Arrayet)
     *
     * // * Naar blir det faerrest?
     * Det blir faerest obmbyttinger naar det stoerste tallet er sist i rekken
     *
     * // * Hvor mange blir det i gjennomsnitt?
     * Det varierer fra hvor mange tall vi har i arrayen.
     *
     * */

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                throw new IllegalStateException("Array er ikke sortert stigende!");
            }
        }

        int totaltVerdier = 0;

        ArrayList<Integer> ulikeVerdier = new ArrayList<>();

        for (int i : a) {
            if (!ulikeVerdier.contains(i)) {
                ulikeVerdier.add(i);
            }
        }

        totaltVerdier = ulikeVerdier.size();

        return totaltVerdier;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0){
            return 0;
        }
        if(a.length == 1){
            return 1;
        }

        int antallVerdier = 0;
        int maksVerdi = biggestNumber(a);
        int startVerdi = 0;

        for(int i = 0; i <= maksVerdi; i++) {
            for (int j : a) {
                if(startVerdi == j) {
                    antallVerdier++;
                    break;
                }
            }
            if(startVerdi > maksVerdi){
                System.out.println(startVerdi);
                break;
            }
            startVerdi++;
        }
        return antallVerdier;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int antOdd = 0;

        //Sorterer oddetall paa venstre side
        for(int i = 0; i < a.length; i++){

            if(a[i]%2 != 0){
                bytt(a,antOdd,i);
                antOdd++;
            }
        }
        if (antOdd == 0 || antOdd == a.length){
            Arrays.sort(a);
        }
        else {
            Arrays.sort(a,0,antOdd);
            Arrays.sort(a,antOdd,a.length);
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(!(a.length == 0)){
            char[] b = new char[a.length];

            b[0] = a[a.length - 1];

            for(int i = 1; i < a.length; i++){
                b[i] = a[i-1];
            }

            for (int j = 0; j<b.length; j++){
                a[j] = b[j];
            }
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(s.length(), t.length());

        // Legger til først annenhver
        for(int i = 0; i < min; i++){
            sb.append(s.charAt(i));
            sb.append(t.charAt(i));
        }

        // Legger til resterende
        sb.append(s.substring(min));
        sb.append(t.substring(min));

        return sb.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        StringBuilder sb = new StringBuilder();

        //finner maks
        int max = 0;
        for (int t = 0; t < s.length; t++){
            if(s[t].length() > max){
                max = s[t].length();
            }
        }

        //Flett
        for(int i = 0; i < max; i++){
            for(int j = 0; j < s.length; j++){
                if(s[j].length() <= i){
                    continue;
                }else{
                    sb.append(s[j].charAt(i));
                    continue;
                }
            }
        }

        return sb.toString();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }


    //HJELPEMETODER

    //Bytt-metode
    public static void bytt(int[] a, int iEn, int iTo){
        int tmp = a[iEn];
        a[iEn] = a[iTo];
        a[iTo] = tmp;
    }

    // finner stoerste int verdi i array
    public static int biggestNumber(int[] a){
        int stoerst = a[0];

        for(int i : a){
            if(i > stoerst){
                stoerst = i;
            }
        }

        return stoerst;
    }
}  // Oblig1
