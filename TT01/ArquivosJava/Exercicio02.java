package TT01.ArquivosJava;

public class Exercicio02 {
    public static void main(String[] args) {
        Arq.openWrite("TT01/ArquivosJava/ex2.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("TT01/ArquivosJava/ex2.txt");
        String string = Arq.readString();
        Arq.close();
        System.out.println(string);
    }
}
