package u00_Nivelamento.ArquivosJava;

public class Exercicio02 {
    public static void main(String[] args) {
        Arq.openWrite("u00_Nivelamento/ArquivosJava/ex2.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/ArquivosJava/ex2.txt");
        String string = Arq.readString();
        Arq.close();
        System.out.println(string);
    }
}
