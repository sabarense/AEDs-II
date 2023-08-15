package u00_Nivelamento.ArquivosJava;

import java.io.RandomAccessFile;

public class ExemploRAF01Escrita {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("u00_Nivelamento/ArquivosJava/exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeByte(5);

        raf.close();
    }
}
