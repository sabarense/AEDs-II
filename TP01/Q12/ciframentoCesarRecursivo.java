package TP01.Q12;

import TP01.MyIO;

public class ciframentoCesarRecursivo{

    public static void main(String[] args) {
        String palavra = MyIO.readLine();
        while (!palavra.equals("FIM")) {
            String resultado = criptografaRecursivo(palavra, 0);
            MyIO.println(resultado);
            palavra = MyIO.readLine();
        }
    }

    static String criptografaRecursivo(String palavra, int index) {
        if (index == palavra.length()) {
            return "";
        } else {
            int character = (int) palavra.charAt(index);
            character += 3;
            char criptografado = (char) character;
            return criptografado + criptografaRecursivo(palavra, index + 1);
        }
    }
}
