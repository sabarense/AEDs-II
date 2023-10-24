package TT01.IntroducaoJava.exemploIf;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valorA: ");
        int valorA = scanner.nextInt();

        System.out.println("Digite um valorB: ");
        int valorB = scanner.nextInt();

        System.out.println("Digite um valorC: ");
        int valorC = scanner.nextInt();

        verificaMaiorMenor(valorA, valorB, valorC);

        scanner.close();
    }

    static void verificaMaiorMenor(int valorA, int valorB, int valorC){

        int maior = valorA;
        int menor = valorA;

        if(valorB < menor){
            menor = valorB;
        }else if(valorB > maior){
            maior = valorB;
        }

        if(valorC < menor){
            menor = valorC;
        }else if(valorC > maior){
            maior = valorC;
        }

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

    }
}
