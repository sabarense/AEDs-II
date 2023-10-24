package TT01.ArquivosJava;

import java.io.*;

public class Arq {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void openWrite(String nomeArq) {
        try {
            writer = new BufferedWriter(new FileWriter(nomeArq));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo para escrita: " + e.getMessage());
        }
    }

    public static void openWrite(String nomeArq, String charset) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nomeArq), charset));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo para escrita: " + e.getMessage());
        }
    }

    public static void openRead(String nomeArq) {
        try {
            reader = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo para leitura: " + e.getMessage());
        }
    }

    public static void openRead(String nomeArq, String charset) {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArq), charset));
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo para leitura: " + e.getMessage());
        }
    }

    public static void close() {
        try {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
        }
    }

    public static void printInt(int x) {
        try {
            writer.write(Integer.toString(x) + "\n");
            System.out.println("Numero inteiro escrito com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void printDouble(double x) {
        try {
            writer.write(Double.toString(x) + "\n");
            System.out.println("Numero real escrito com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void printString(String x) {
        try {
            writer.write(x + "\n");
            System.out.println("String escrita com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void printBoolean(boolean x) {
        try {
            writer.write(Boolean.toString(x) + "\n");
            System.out.println("Booleano escrito com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void printChar(char x) {
        try {
            writer.write(Character.toString(x) + "\n");
            System.out.println("Caractere escrito com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
            return 0;
        }
    }

    public static double readDouble() {
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
            return 0.0;
        }
    }

    public static boolean readBoolean() {
        try {
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
            return false;
        }
    }

    public static char readChar() {
        try {
            return reader.readLine().charAt(0);
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
            return '\0';
        }
    }

    public static String readString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao ler do arquivo: " + e.getMessage());
            return "";
        }
    }

    public static boolean hasNext() {
        try {
            return reader.ready();
        } catch (IOException e) {
            System.out.println("Erro ao verificar disponibilidade de leitura: " + e.getMessage());
            return false;
        }
    }

}
