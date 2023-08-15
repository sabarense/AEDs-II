package u00_Nivelamento.ArquivosJava;

public class ExemploArq03Exercicio {
    public static void main(String[] args) {
        Arq.openRead("u00_Nivelamento/ArquivosJava/exemplo.txt");
        StringBuilder string = new StringBuilder();
        while(Arq.hasNext()){
            string.append(Arq.readString()).append("\n");
        }
        Arq.close();
        Arq.openWrite("u00_Nivelamento/ArquivosJava/copia.txt");
        Arq.printString(string.toString());
        Arq.close();
    }
}
