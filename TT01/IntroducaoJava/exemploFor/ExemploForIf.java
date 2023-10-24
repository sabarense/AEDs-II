package TT01.IntroducaoJava.exemploFor;

import java.util.Scanner;

public class ExemploForIf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double totalNotas = 0;
        int contador = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite a nota do aluno " + i + ": ");
            double nota = scanner.nextDouble();

            if (nota >= 80) {
                totalNotas += nota;
                contador++;
            }
        }
        scanner.close();
        if (contador > 0) {
            double media = totalNotas / contador;
            System.out.println("Média das notas >= 80: " + media);
        } else {
            System.out.println("Nenhuma nota >= 80 foi informada.");
        }
    }
}
