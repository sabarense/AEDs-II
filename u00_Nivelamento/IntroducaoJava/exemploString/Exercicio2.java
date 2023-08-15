package u00_Nivelamento.IntroducaoJava.exemploString;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String string = scanner.nextLine();

        if (isPalindromo(string.toLowerCase())) {
            System.out.println("É palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }

        scanner.close();
    }

    static boolean isPalindromo(String string) {

        boolean result = true;
        int i = 0;
        int j = string.length() - i - 1;
        for (; i < string.length() / 2; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                result = false;
                break;
            }
        }
        return result;
    }
}

