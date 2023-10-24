package TT01.ArquivosJava;

public class ExemploArq02Leitura {
    public static void main(String[] args) {

        Arq.openRead("TT01/ArquivosJava/exemplo.txt");

        int inteiro = Arq.readInt();
        double real = Arq.readDouble();
        char caractere = Arq.readChar();
        boolean booleano = Arq.readBoolean();
        String string = Arq.readString();

        Arq.close();

        System.out.println("inteiro: " + inteiro);
        System.out.println("double: " + real);
        System.out.println("caractere: " + caractere);
        System.out.println("boolean: " + booleano);
        System.out.println("string: " + string);
    }
}
