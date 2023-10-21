package TP01.TP01Q15;

import TP01.MyIO;

public class isRecursivo {
    public static void main(String[] args) {

        String palavra = MyIO.readLine();
        while (!palavra.equalsIgnoreCase("FIM")) {
            boolean[] list = new boolean[4];
            list[0] = isVogal(palavra, 0);
            list[1] = isConsoante(palavra, 0);
            list[2] = isInt(palavra, 0);
            list[3] = isDouble(palavra, 0);
            verifica(list, 0);
            System.out.println("");
            palavra = MyIO.readLine();
        }
    }

    public static boolean isVogal(String palavra, int index) {
        if (index >= palavra.length()) {
            return true;
        }

        String vogais = "AEIOUaeiou";
        if (vogais.indexOf(palavra.charAt(index)) == -1) {
            return false;
        }

        return isVogal(palavra, index + 1);
    }

    public static boolean isConsoante(String palavra, int index) {
        if (index >= palavra.length()) {
            return true;
        }

        String consoantes = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
        if (consoantes.indexOf(palavra.charAt(index)) == -1) {
            return false;
        }

        return isConsoante(palavra, index + 1);
    }

    public static boolean isInt(String palavra, int index) {
        if (index >= palavra.length()) {
            return true;
        }

        if (!Character.isDigit(palavra.charAt(index))) {
            return false;
        }

        return isInt(palavra, index + 1);
    }

    public static boolean isDouble(String palavra, int index) {
        if (index >= palavra.length()) {
            return true;
        }

        char currentChar = palavra.charAt(index);
        if (!Character.isDigit(currentChar) && currentChar != '.') {
            return false;
        }

        return isDouble(palavra, index + 1);
    }

    public static void verifica(boolean[] list, int index) {
        if (index < list.length) {
            if (list[index]) {
                System.out.print("SIM ");
            } else {
                System.out.print("NAO ");
            }
            verifica(list, index + 1);
        }
    }
}
