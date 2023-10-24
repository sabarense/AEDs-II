package TT01.IntroducaoJava.exemploIf;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        int a = leNumero();
        int b = leNumero();

        verifica(a,b);
    }

    static int leNumero(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int num = scanner.nextInt();

        scanner.close();

        return num;
    }

    static void verifica(int a, int b) {
        if (a > 45 || b > 45) {
            int soma = a + b;
            System.out.println("Soma: " + soma);
        } else if (a > 20 && b > 20) {
            int maior, menor;
            if (a > b) {
                maior = a;
                menor = b;
            } else {
                maior = b;
                menor = a;
            }
            int subtracaoMaiorMenor = maior - menor;
            System.out.println("Subtração do Maior pelo Menor: " + subtracaoMaiorMenor);
        } else if ((a < 10 || b < 10) && (b != 0 || a != 0)) {
            int divisaoPrimeiroSegundo = a / b;
            System.out.println("Divisão do Primeiro pelo Segundo: " + divisaoPrimeiroSegundo);
        } else {
            System.out.println("Seu nome (Yan)");
        }
    }
}
