package u00_Nivelamento.ArquivosJava;

import java.io.RandomAccessFile;

public class ExemploRAF03Cabecote {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeBytes("Algoritmos");

        raf.seek(0);
        System.out.println(raf.readInt());

        raf.seek(12);
        System.out.println(raf.readChar());

        raf.seek(12);
        raf.writeChar('@');

        raf.seek(12);
        System.out.println(raf.readChar());

        raf.close();
    }
}
