package u00_Nivelamento.Unidade00f;

public class Exercicio04 {
    public static void main(String[] args) {
        Arq.openWrite("u00_Nivelamento/Unidade00f/ex4.txt.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/Unidade00f/ex4.txt");
        StringBuilder string = new StringBuilder();
        while(Arq.hasNext()){
            string.append(Arq.readString()).append("\n");
        }
        Arq.close();

        Arq.openWrite("u00_Nivelamento/Unidade00f/ex4copia.txt");
        Arq.printString(string.toString());
        Arq.close();
    }
}
