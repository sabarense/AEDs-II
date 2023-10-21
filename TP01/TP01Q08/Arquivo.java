package TP01.TP01Q08;

import TP01.MyIO;

import java.io.*;

public class Arquivo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            // Abre o arquivo para escrita
            RandomAccessFile arquivo = new RandomAccessFile("arq.txt", "rw");

            // Lê e salva os valores no arquivo
            for (int i = 0; i < n; i++) {
                double valor = Double.parseDouble(br.readLine());
                arquivo.writeDouble(valor);
            }

            // Fecha o arquivo
            arquivo.close();

            // Reabre o arquivo para leitura
            arquivo = new RandomAccessFile("arq.txt", "r");

            // Move o ponteiro para o final do arquivo
            long tamanho = arquivo.length();
            int numValores = (int) (tamanho / 8); // Cada double tem 8 bytes

            // Lê os valores de trás para frente
            for (int i = numValores - 1; i >= 0; i--) {
                arquivo.seek(i * 8); // Posiciona o ponteiro corretamente
                double valor = arquivo.readDouble();
                MyIO.println(valor);
            }

            // Fecha o arquivo novamente
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
