package u00_Nivelamento.ArquivosJava;

public class Exercicio03 {
    public static void main(String[] args) {
        Arq.openWrite("u00_Nivelamento/ArquivosJava/ex3.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/ArquivosJava/ex3.txt");
        String converteMaiusculo = Arq.readString().toUpperCase();
        Arq.close();
        System.out.println("Conteudo do arquivo em maiusculo: " + converteMaiusculo);
    }
}
