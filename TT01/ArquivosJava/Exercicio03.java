package TT01.ArquivosJava;

public class Exercicio03 {
    public static void main(String[] args) {
        Arq.openWrite("TT01/ArquivosJava/ex3.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("TT01/ArquivosJava/ex3.txt");
        String converteMaiusculo = Arq.readString().toUpperCase();
        Arq.close();
        System.out.println("Conteudo do arquivo em maiusculo: " + converteMaiusculo);
    }
}
