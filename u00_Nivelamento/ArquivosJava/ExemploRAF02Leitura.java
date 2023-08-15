package u00_Nivelamento.ArquivosJava;

import java.io.RandomAccessFile;

public class ExemploRAF02Leitura {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        int inteiro = raf.readInt();
        double real = raf.readDouble();
        char caractere = raf.readChar();
        boolean booleano = raf.readBoolean();
        String string = raf.readLine();

        raf.close();

        System.out.println(inteiro + "" + real + "" + caractere + "" + booleano + "" + string);
    }
}
