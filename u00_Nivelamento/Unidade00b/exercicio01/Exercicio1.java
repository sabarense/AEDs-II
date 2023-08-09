package u00_Nivelamento.Unidade00b.exercicio01;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Exercicio1 Exercicio1 = new Exercicio1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] array = new int[tamanho];

        System.out.println("Digite os valores do array: ");
        for (int i = 0; i < tamanho; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Digite o valor a ser procurado: ");
        int x = scanner.nextInt();

        boolean resultado = Exercicio1.isContido(array, x);

        if (resultado) {
            System.out.println("O valor está contido no array.");
        } else {
            System.out.println("O valor NÃO está contido no array.");
        }

        scanner.close();
    }

    boolean isContido(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return true;
            }
        }
        return false;
    }
}
