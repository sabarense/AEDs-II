package u00_Nivelamento.ArquivosJava;

public class Exercicio04 {
    public static void main(String[] args) {
        Arq.openWrite("u00_Nivelamento/ArquivosJava/ex4.txt.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/ArquivosJava/ex4.txt");
        StringBuilder string = new StringBuilder();
        while(Arq.hasNext()){
            string.append(Arq.readString()).append("\n");
        }
        Arq.close();

        Arq.openWrite("u00_Nivelamento/ArquivosJava/ex4copia.txt");
        Arq.printString(string.toString());
        Arq.close();
    }
}
