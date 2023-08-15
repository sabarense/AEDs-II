package u00_Nivelamento.IntroducaoJava.exemploIf;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ladoA: ");
        double ladoA = scanner.nextDouble();

        System.out.println("Digite o ladoB: ");
        double ladoB = scanner.nextDouble();

        System.out.println("Digite o ladoC: ");
        double ladoC = scanner.nextDouble();

        verificaTriangulo(ladoA, ladoB, ladoC);

        scanner.close();
    }
    static void verificaTriangulo(double ladoA, double ladoB, double ladoC){
        if(ladoA == ladoB && ladoB == ladoC){
            System.out.println("Equilatero");
        }else if(ladoA != ladoB && ladoB != ladoC && ladoA != ladoC){
            System.out.println("Escaleno");
        }else{
            System.out.println("Isosceles");
        }
    }
}
