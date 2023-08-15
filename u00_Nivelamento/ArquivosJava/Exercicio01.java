package u00_Nivelamento.ArquivosJava;

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo a ser lido: ");
        String nomeArq = scanner.nextLine();

        System.out.println("Digite uma frase a ser inserida no arquivo: ");
        String frase = scanner.nextLine();

        Arq.openWrite(nomeArq);
        Arq.printString(frase);

        Arq.close();
        scanner.close();

    }
}
