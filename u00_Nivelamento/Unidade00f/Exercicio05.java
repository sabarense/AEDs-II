package u00_Nivelamento.Unidade00f;

public class Exercicio05 {
    public static void main(String[] args) {

        Arq.openWrite("u00_Nivelamento/Unidade00f/ex5.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("u00_Nivelamento/Unidade00f/ex5.txt");
        StringBuilder converteMaiusculo = new StringBuilder();
        while(Arq.hasNext()){
            converteMaiusculo.append(Arq.readString().toUpperCase()).append("\n");
        }
        Arq.close();

        Arq.openWrite("u00_Nivelamento/Unidade00f/ex5copia.txt");
        Arq.printString(String.valueOf(converteMaiusculo));
        Arq.close();
    }
}
