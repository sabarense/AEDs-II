package TP01.Q01;

import java.util.Scanner;

public class palindromo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String palavra = scanner.nextLine();
        while(!palavra.equals("FIM")){
            if(isPalindromo(palavra)){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            palavra = scanner.nextLine();
        }
        scanner.close();
    }

    static boolean isPalindromo(String palavra){

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
