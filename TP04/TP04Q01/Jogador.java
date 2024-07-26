package TP04.TP04Q01;

import java.io.*;
import java.util.Scanner;

public class Jogador {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;
    public static int SIZE = 3922;
    public static String FILE_PATH = "/tmp/players.csv";
    public static final String MATRICULA = "791624";

    public Jogador() {
    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    void setId(int id) {
        this.id = id;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    void setAltura(int altura) {
        this.altura = altura;
    }

    void setPeso(int peso) {
        this.peso = peso;
    }

    void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    int getId() {
        return id;
    }

    String getNome() {
        return nome;
    }

    int getAltura() {
        return altura;
    }

    int getPeso() {
        return peso;
    }

    String getUniversidade() {
        return universidade;
    }

    int getAnoNascimento() {
        return anoNascimento;
    }

    String getCidadeNascimento() {
        return cidadeNascimento;
    }

    String getEstadoNascimento() {
        return estadoNascimento;
    }

    Jogador cloneJogador(Jogador jogador) {
        Jogador clone = new Jogador();
        clone.setId(jogador.getId());
        clone.setNome(jogador.getNome());
        clone.setAltura(jogador.getAltura());
        clone.setPeso(jogador.getPeso());
        clone.setUniversidade(jogador.getUniversidade());
        clone.setAnoNascimento(jogador.getAnoNascimento());
        clone.setCidadeNascimento(jogador.getCidadeNascimento());
        clone.setEstadoNascimento(jogador.getEstadoNascimento());
        return clone;
    }

    Jogador buscarPorId(int x) {
        Jogador[] temp = ler();
        for (int i = 0; i < SIZE; i++) {
            if (temp[i].getId() == x) {
                return temp[i];
            }
        }
        return temp[0];
    }

    Jogador[] ler() {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(FILE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
            return new Jogador[0];
        }

        scanner.nextLine(); // Ignorar a primeira linha
        Jogador[] jogador = new Jogador[SIZE];
        int i = 0;

        while (scanner.hasNext()) {
            jogador[i] = new Jogador();
            String jog = scanner.nextLine();
            String[] aux = new String[8];
            aux = jog.split(",", 8);
            jogador[i].setId(Integer.parseInt(aux[0]));
            jogador[i].setNome(aux[1]);
            jogador[i].setAltura(Integer.parseInt(aux[2]));
            jogador[i].setPeso(Integer.parseInt(aux[3]));
            jogador[i].setUniversidade(aux[4]);
            jogador[i].setAnoNascimento(Integer.parseInt(aux[5]));
            jogador[i].setCidadeNascimento(aux[6]);
            jogador[i].setEstadoNascimento(aux[7]);

            if (aux[4].isEmpty()) {
                jogador[i].setUniversidade("nao informado");
            }
            if (aux[6].isEmpty()) {
                jogador[i].setCidadeNascimento("nao informado");
            }
            if (aux[7].isEmpty()) {
                jogador[i].setEstadoNascimento("nao informado");
            }
            i++;
        }

        scanner.close();
        return jogador;
    }

    public void gerarLog(String matricula, long tempoExecucao, int numeroComparacoes) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(MATRICULA + "_arvoreBinaria.txt"));
            writer.write(MATRICULA + "\t" + tempoExecucao + "\t" + numeroComparacoes);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            Jogador jogador = new Jogador();
            ArvoreBinaria arvore = new ArvoreBinaria();
            jogador.ler();

            Scanner sc = new Scanner(System.in);
            String entrada = "";

            while (true) {
                entrada = sc.nextLine();
                if (entrada.equals("FIM"))
                    break;
                arvore.inserir(jogador.buscarPorId(Integer.parseInt(entrada)));
            }

            while (true) {
                entrada = sc.nextLine();
                if (entrada.equals("FIM"))
                    break;
                System.out.print(entrada);
                System.out.println(arvore.pesquisar(entrada) ? " SIM" : " NAO");
            }

            long tempoInicio = System.currentTimeMillis();
            long tempoFim = System.currentTimeMillis();
            int numeroComparacoes = arvore.comparacoes;

            jogador.gerarLog(MATRICULA, tempoFim - tempoInicio, numeroComparacoes);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class No {
        public Jogador elemento;
        public No esq, dir;

        public No(Jogador elemento) {
            this(elemento, null, null);
        }

        public No(Jogador elemento, No esq, No dir) {
            this.elemento = elemento;
            this.esq = this.dir = null;
        }

    }

    static class ArvoreBinaria {
        private No raiz;
        public int comparacoes;

        public ArvoreBinaria() {
            raiz = null;
        }

        public void inserir(Jogador elemento) throws Exception {
            raiz = inserir(elemento, raiz);
        }

        public No inserir(Jogador jogador, No i) throws Exception {
            if (i == null) {
                i = new No(jogador);
            } else if (i.elemento.getNome().compareTo(jogador.getNome()) > 0) {
                i.esq = inserir(jogador, i.esq);
            } else if (i.elemento.getNome().compareTo(jogador.getNome()) < 0) {
                i.dir = inserir(jogador, i.dir);
            } else {
                throw new Exception("Erro ao inserir!");
            }

            return i;
        }

        public boolean pesquisar(String nome) {
            System.out.print(" raiz");
            return pesquisar(nome, raiz);
        }

        public boolean pesquisar(String nome, No i) {
            boolean resp;
            if (i == null) {
                resp = false;
            } else if (i.elemento.getNome().compareTo(nome) > 0) {
                System.out.print(" esq");
                resp = pesquisar(nome, i.esq);
            } else if (i.elemento.getNome().compareTo(nome) < 0) {
                System.out.print(" dir");
                resp = pesquisar(nome, i.dir);
            } else {
                resp = true;
            }

            return resp;
        }
    }

}
