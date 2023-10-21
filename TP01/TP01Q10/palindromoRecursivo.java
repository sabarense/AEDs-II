package TP01.TP01Q10;

import TP01.MyIO;

public class palindromoRecursivo {

    public static void main(String[] args) {

        String palavra = MyIO.readLine();
        while (!palavra.equalsIgnoreCase("FIM")) {
            if (isPalindromo(palavra, 0, palavra.length() - 1)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            palavra = MyIO.readLine();
        }

    }

    public static boolean isPalindromo(String palavra, int inicio, int fim) {
        if (inicio >= fim) {
            return true;
        }
        if (palavra.charAt(inicio) != palavra.charAt(fim)) {
            return false;
        }
        return isPalindromo(palavra, inicio + 1, fim - 1);
    }
}
