package TT01.ArquivosJava;

public class ExemploArq03Exercicio {
    public static void main(String[] args) {
        Arq.openRead("TT01/ArquivosJava/exemplo.txt");
        StringBuilder string = new StringBuilder();
        while(Arq.hasNext()){
            string.append(Arq.readString()).append("\n");
        }
        Arq.close();
        Arq.openWrite("TT01/ArquivosJava/copia.txt");
        Arq.printString(string.toString());
        Arq.close();
    }
}
