package TT01.ArquivosJava;

public class Exercicio04 {
    public static void main(String[] args) {
        Arq.openWrite("TT01/ArquivosJava/ex4.txt.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("TT01/ArquivosJava/ex4.txt");
        StringBuilder string = new StringBuilder();
        while(Arq.hasNext()){
            string.append(Arq.readString()).append("\n");
        }
        Arq.close();

        Arq.openWrite("TT01/ArquivosJava/ex4copia.txt");
        Arq.printString(string.toString());
        Arq.close();
    }
}
