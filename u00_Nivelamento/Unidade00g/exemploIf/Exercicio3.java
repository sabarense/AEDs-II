package u00_Nivelamento.Unidade00g.exemploIf;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = new int[10];
        for(int i = 0; i < array.length - 1; i++){
            System.out.println("Digite o numero na posicao: " + i);
            array[i] = scanner.nextInt();
        }
        verificaMaior(array);
        scanner.close();
    }

    static void verificaMaior(int[]array ){

        int maior = array[0];
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > maior){
                maior = array[i];
            }
        }
        System.out.println("Maior numero: " + maior);
    }
}
