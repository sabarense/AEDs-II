package u00_Nivelamento.ExerciciosRevisao;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();
        int[] array = new int[tamanho];
        System.out.println("Digite o valor a ser guardado no array: ");
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        maiorMenor(array);
        scanner.close();
    }

    static void maiorMenor(int[]array){

        int maior = array[0];
        int menor = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > maior){
                maior = array[i];
            }else if(array[i] < menor){
                menor = array[i];
            }
        }
        System.out.printf("Maior = %d\n", maior);
        System.out.printf("Menor = %d", menor);
    }
}
