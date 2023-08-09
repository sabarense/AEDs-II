package u00_Nivelamento.Unidade00g.exemploIf;

import java.util.Scanner;

public class ExemploIf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua nota: ");
        double nota = scanner.nextDouble();
        if(nota >= 80){
            System.out.println("Parabéns, muito bom");
        }else if(nota >= 70 && nota < 80){
            System.out.println("Parabéns, aprovado");
        }else{
            System.out.println("Infelizmente, reprovado");
        }
        scanner.close();
    }
}
