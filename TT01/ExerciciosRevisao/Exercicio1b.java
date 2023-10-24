package TT01.ExerciciosRevisao;

import java.util.Scanner;

public class Exercicio1b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com o valor desejado: ");
        int numeroProcurado = scanner.nextInt();
        if(isContidoPesquisaBinaria(numeroProcurado)){
            System.out.println("O valor está contido no array.");
        }else{
            System.out.println("O valor não está contido no array.");
        }
        scanner.close();
    }

    public static boolean isContidoPesquisaBinaria(int numeroProcurado) {
        boolean resp = false;
        int[] array = {2, 3, 5, 7, 9, 11, 15, 17, 20};
        int tamanho = array.length;
        int direita = tamanho - 1;
        int esquerda = 0;
        int meio = 0;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (array[meio] <= numeroProcurado) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        if (direita <= tamanho - 1 && direita >= 0 && (array[direita] == numeroProcurado)) {
                resp = true;
                return resp;
        }
        return resp;
    }
}


