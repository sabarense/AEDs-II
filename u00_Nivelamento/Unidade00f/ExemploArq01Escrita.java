package u00_Nivelamento.Unidade00f;


public class ExemploArq01Escrita {
    public static void main(String[] args) {

        Arq.openWrite("u00_Nivelamento/Unidade00f/exemplo.txt");
        Arq.printInt(1);
        Arq.printDouble(5.3);
        Arq.printChar('X');
        Arq.printBoolean(true);
        Arq.printString("Algoritmos");
        Arq.close();
    }
}
