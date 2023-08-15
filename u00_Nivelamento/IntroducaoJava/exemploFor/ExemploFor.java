package u00_Nivelamento.IntroducaoJava.exemploFor;

import java.util.Scanner;

public class ExemploFor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numAlunos = 5;
        double soma = 0;
        double[]notas = new double[numAlunos];
        for(int i = 0; i < notas.length; i++){
            System.out.println("Digite a " + (i+1) + " nota:");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }
        double media = soma / numAlunos;
        System.out.println("Media = " + media);

        scanner.close();
    }
}
