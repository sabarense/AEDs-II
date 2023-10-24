package TT01.ArquivosJava;

import java.io.RandomAccessFile;

public class ExemploRAF01Escrita {
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("TT01/ArquivosJava/exemplo.txt", "rw");

        raf.writeInt(1);
        raf.writeDouble(5.3);
        raf.writeChar('X');
        raf.writeBoolean(true);
        raf.writeByte(5);

        raf.close();
    }
}
