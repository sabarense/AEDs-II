package TT01.ArquivosJava;

public class Exercicio05 {
    public static void main(String[] args) {

        Arq.openWrite("TT01/ArquivosJava/ex5.txt");
        Arq.printString("teste");
        Arq.close();

        Arq.openRead("TT01/ArquivosJava/ex5.txt");
        StringBuilder converteMaiusculo = new StringBuilder();
        while(Arq.hasNext()){
            converteMaiusculo.append(Arq.readString().toUpperCase()).append("\n");
        }
        Arq.close();

        Arq.openWrite("TT01/ArquivosJava/ex5copia.txt");
        Arq.printString(String.valueOf(converteMaiusculo));
        Arq.close();
    }
}
