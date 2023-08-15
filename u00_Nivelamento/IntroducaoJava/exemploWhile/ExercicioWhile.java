package u00_Nivelamento.IntroducaoJava.exemploWhile;

import java.util.Scanner;

public class ExercicioWhile {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numAlunos = 5;
        double[]array = new double[numAlunos];
        double soma = 0;
        int i = 0 ;
        while(i < numAlunos){
            System.out.println("Digite a " + (i+1) + " nota: ");
            array[i] = scanner.nextDouble();
            soma += array[i];
            i++;
        }
        double media = soma / numAlunos;
        System.out.println("Media: " + media);

        scanner.close();
    }
}
