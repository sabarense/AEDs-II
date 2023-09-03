package TP01.Q01;

import TP01.MyIO;

public class palindromo {

    public static void main(String[] args) {

        String palavra = MyIO.readLine();
        while(!palavra.equalsIgnoreCase("FIM")){
            if(isPalindromo(palavra)){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            palavra = MyIO.readLine();
        }

    }

    public static boolean isPalindromo(String palavra){

        int i;
        int j;
        for(i = 0, j = (palavra.length()-1); i < palavra.length() / 2; i++, j--){
            if(palavra.charAt(i) != palavra.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
