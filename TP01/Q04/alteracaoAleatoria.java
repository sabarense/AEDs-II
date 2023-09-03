package TP01.Q04;

import TP01.MyIO;

import java.util.Random;

public class alteracaoAleatoria {
    public static void main(String[] args) {

        MyIO.setCharset("UTF-8");
        String palavra = MyIO.readLine();
        while(!palavra.equalsIgnoreCase("FIM")) {
            String resultado = sorteiaLetra(palavra);
            System.out.println(resultado);
            palavra = MyIO.readLine();
        }
    }

    public static String sorteiaLetra(String palavra) {

        Random gerador = new Random();
        gerador.setSeed(4);
        char sorteioA = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char sorteioB = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        StringBuilder stringAlterada = new StringBuilder();

        for (int i = 0; i < palavra.length(); i++) {
            char currentChar = palavra.charAt(i);
            if (currentChar == sorteioA) {
                stringAlterada.append(sorteioB);
            } else {
                stringAlterada.append(currentChar);
            }
        }
        return stringAlterada.toString();
    }
}
