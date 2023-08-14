package u00_Nivelamento.Unidade00g.exemploIf;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {

        int a = leNumero();
        int b = leNumero();
    }
    static int leNumero(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        int num = scanner.nextInt();

        scanner.close();

        return num;
    }
}
