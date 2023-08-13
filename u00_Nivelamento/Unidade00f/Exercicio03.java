package u00_Nivelamento.Unidade00f;

public class Exercicio03 {
    public static void main(String[] args) {
        Arq.openWrite("u00_Nivelamento/Unidade00f/ex3.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/Unidade00f/ex3.txt");
        String converteMaiusculo = Arq.readString().toUpperCase();
        Arq.close();
        System.out.println("Conteudo do arquivo em maiusculo: " + converteMaiusculo);
    }
}
