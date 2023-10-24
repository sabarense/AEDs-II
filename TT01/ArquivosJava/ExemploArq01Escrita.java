package TT01.ArquivosJava;


public class ExemploArq01Escrita {
    public static void main(String[] args) {

        Arq.openWrite("TT01/ArquivosJava/exemplo.txt");
        Arq.printInt(1);
        Arq.printDouble(5.3);
        Arq.printChar('X');
        Arq.printBoolean(true);
        Arq.printString("Algoritmos");
        Arq.close();
    }
}
