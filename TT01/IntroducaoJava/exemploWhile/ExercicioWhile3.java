package TT01.IntroducaoJava.exemploWhile;

import java.util.Scanner;

public class ExercicioWhile3 {
    public static void main(String[] args) {

        int num = leInteiro();
        imprimeImpar(num);
    }

    static int leInteiro(){

        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        num = scanner.nextInt();
        scanner.close();
        return num;
    }

    static void imprimeImpar(int num){

        int numero = 1;
        int count = 0;
        while(count < num){
            if(numero % 2 != 0){
                System.out.println("Número ímpar: " + numero);
                count++;
            }
            numero++;
        }
    }
}


