package com.sda.scrum;

import java.util.*;

public class Sortowanie {

    public final static String alfabet = "0123456789AĄBCĆDEĘFGIJKLŁMNŃOÓPQRSŚTUVWXYZŹŻaąbcćdeęfghijklłmnńoópqrsśtuvwxyzźż";

    public static void main(String[] args) {
        List<String> lista = new ArrayList();
        lista.add("Monika");
        lista.add("agnieszka");
        lista.add("Tomasz");
        lista.add("Grzegorz");
        lista.add("zbyszek");
        lista.add("Anna");
        lista.add("Monika");
        lista.add("Łukasz");
        lista.add("Filip");
        lista.add("Grzegorz");
        lista.add("Szymon");
        lista.add("Zenon");
        lista.add("Monika");

        List<String> posortowana = posortujListe(lista);
        posortowana.stream().forEach(p-> System.out.print(p+","));
        System.out.println();
        Map mapa = zliczSlowa(posortowana);

        mapa.forEach((k,v)->System.out.println(k + "->" + v));

    }

    private static Map<String, Integer> zliczSlowa(List<String> lista) {
        Map policzone = new HashMap();
        for (String slowo : lista) {
            if (policzone.containsKey(slowo)){
                Integer ile = Integer.parseInt(policzone.get(slowo).toString());
                policzone.put(slowo,++ile);
            }
            else {
                policzone.put(slowo,1);
            }
        }
        return policzone;
    }


    public static boolean toSwapWords(String[] wejscie){
        return toSwapWords(wejscie[0], wejscie[1]);
    }

    public static boolean toSwapWordsPL(String tekst1, String tekst2){
        int minNumberOfCharacters = tekst1.length();
        if(tekst2.length()<tekst1.length()) minNumberOfCharacters = tekst2.length();
        char[] znaki1 = tekst1.toCharArray();
        char[] znaki2 = tekst2.toCharArray();
        boolean zamiana=false,rowneSlowa=true;
        for (int i=0; i<minNumberOfCharacters; i++){
            if(alfabet.indexOf(tekst1.substring(i,i+1))==alfabet.indexOf(tekst2.substring(i,i+1)))
                continue;
            if(alfabet.indexOf(tekst1.substring(i,i+1))>alfabet.indexOf(tekst2.substring(i,i+1))) zamiana=true;
            rowneSlowa=false;
            break;
        }
        if(tekst1.length()>minNumberOfCharacters && rowneSlowa) zamiana=true;
        return zamiana;
    }

    public static boolean toSwapWords(String tekst1, String tekst2){
        int minNumberOfCharacters = tekst1.length();
        if(tekst2.length()<tekst1.length()) minNumberOfCharacters = tekst2.length();
        char[] znaki1 = tekst1.toCharArray();
        char[] znaki2 = tekst2.toCharArray();
        boolean zamiana=false,rowneSlowa=true;
        for (int i=0; i<minNumberOfCharacters; i++){
            if((int)znaki1[i]==(int)znaki2[i]) continue;
            if((int)znaki1[i]>(int)znaki2[i]) zamiana=true;
            rowneSlowa=false;
            break;
        }
        if(tekst1.length()>minNumberOfCharacters && rowneSlowa) zamiana=true;
        return zamiana;
    }

    public static String[] swapWords(String[] wejscie) {
        return swapWords(wejscie[0], wejscie[1]);
    }

    public static String[] swapWords(String tekst1, String tekst2){
        String tmp=tekst1;
        tekst1=tekst2;
        tekst2=tmp;
        String[] tab = {tekst1,tekst2};
        return tab;
    }

    public static void displayArray(String[] tabela){
        for (String i: tabela) System.out.print(i+"; ");
        System.out.println();
    }

    public static String[] bubbleSort(String[] wejscie){

        String[] wyjscie = new String[wejscie.length];
        String[] zmiana = new String[2];
        boolean podmiana;
        do{
            podmiana=false;
            for(int i=0; i<wejscie.length-1;i++){
                if(toSwapWordsPL(wejscie[i],wejscie[i+1])){
                    zmiana=swapWords(wejscie[i],wejscie[i+1]);
                    wejscie[i]=zmiana[0];
                    wejscie[i+1]=zmiana[1];
                    podmiana=true;
                }
            }
        }while(podmiana);
        return wejscie;
    }

    private static List<String> posortujListe(List<String> lista) {
        boolean podmiana;
        do{
            podmiana=false;
            for(int i=0; i<lista.size()-1;i++){
                    String slowo1 = lista.get(i);
                    String slowo2 = lista.get(i+1);
                if(toSwapWordsPL(slowo1,slowo2)){
                    lista.set(i,slowo2);
                    lista.set(i+1,slowo1);
                    podmiana=true;
                }
            }
        }while(podmiana);

        return lista;
    }
}
