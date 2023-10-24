package TT01.IntroducaoJava.exemploString;

import java.util.Scanner;

public class ExemploString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um caractere: ");
        char caractere = scanner.next().charAt(0);

        System.out.println("Digite uma string: ");
        String string = scanner.nextLine();

        int count = 0;

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == caractere){
                count++;
            }
        }

        System.out.println("O caractere aparece na tela: " + count + " vezes");

        scanner.close();
    }
}
