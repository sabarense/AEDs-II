package Aquecimento;

import java.util.Scanner;

public class parOuImpar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        verifica(numero);
        scanner.close();
    }

    static void verifica(int numero){
        if(numero % 2 == 0 ){
            System.out.println("par");
        }else{
            System.out.println("impar");
        }
    }
}
