//package TP02.TP02Q11;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Jogador {

    private int id;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String nome;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;
    private static Duration duracao;
    private static int contadorComparacoes;
    public static final String FILE_PATH = "/tmp/players.csv";

    // Construtor vazio
    public Jogador() {
        this.id = this.altura = this.peso = this.anoNascimento = -1;
        this.nome = this.universidade = this.cidadeNascimento = this.estadoNascimento = "nao informado";
    }

    // Construtor que recebe os parametros
    public Jogador(int id, int altura, int peso, int anoNascimento, String nome, String universidade, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    protected Jogador clone() throws CloneNotSupportedException {
        Jogador novo = new Jogador();
        novo.setId(this.id);
        novo.setAltura(this.altura);
        novo.setPeso(this.peso);
        novo.setNome(this.nome);
        novo.setUniversidade(this.universidade);
        novo.setAnoNascimento(this.anoNascimento);
        novo.setCidadeNascimento(this.cidadeNascimento);
        novo.setEstadoNascimento(this.estadoNascimento);
        return novo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUniversidade() {
        return this.universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getCidadeNascimento() {
        return this.cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return this.estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public void ler(String nomeDoArquivo, ArrayList<Jogador> array) throws Exception {
        try (BufferedReader buffer = new BufferedReader(new FileReader(nomeDoArquivo))) {
            buffer.readLine();
            String linha;
            while ((linha = buffer.readLine()) != null) {
                String[] jogadorInfo = linha.split(",", -1);

                Jogador jogador = new Jogador();
                jogador.setId(Integer.parseInt(jogadorInfo[0]));
                jogador.setNome(obterValor(jogadorInfo, 1, "nao informado"));
                jogador.setAltura(obterValorInteiro(jogadorInfo, 2, 0));
                jogador.setPeso(obterValorInteiro(jogadorInfo, 3, 0));
                jogador.setUniversidade(obterValor(jogadorInfo, 4, "nao informado"));
                jogador.setAnoNascimento(obterValorInteiro(jogadorInfo, 5, 0));
                jogador.setCidadeNascimento(obterValor(jogadorInfo, 6, "nao informado"));
                jogador.setEstadoNascimento(obterValor(jogadorInfo, 7, "nao informado"));

                array.add(jogador);
            }
        }
    }

    private String obterValor(String[] array, int indice, String valorPadrao) {
        if (indice < array.length && !array[indice].isEmpty()) {
            return array[indice];
        }
        return valorPadrao;
    }

    private int obterValorInteiro(String[] array, int indice, int valorPadrao) {
        if (indice < array.length && !array[indice].isEmpty()) {
            return Integer.parseInt(array[indice]);
        }
        return valorPadrao;
    }

    public static void ordenarCountingSort(ArrayList<Jogador> jogadores) throws IOException {
        int contadorComparacoes = 0;

        LocalDateTime dataHoraInicio = LocalDateTime.now();

        int[] count = new int[400]; // Count array para armazenar a frequência das alturas

        // Contagem das alturas
        for (Jogador jogador : jogadores) {
            count[jogador.getAltura()]++;
        }

        // Reconstrução do vetor ordenado
        ArrayList<Jogador> jogadoresOrdenados = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            while (count[i] > 0) {
                Jogador jogador = new Jogador();
                jogador.setAltura(i);
                jogadoresOrdenados.add(jogador);
                count[i]--;
            }
        }

        LocalDateTime dataHoraFinal = LocalDateTime.now();
        Duration duracao = Duration.between(dataHoraInicio, dataHoraFinal);

        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("791624_count.txt"))) {
            buffer.write("Matricula: 791624\t");
            buffer.write("Tempo de execucao: " + duracao.toMillis() + "ms\t");
            buffer.write("Numero de comparacoes: " + contadorComparacoes + "\t");
        }
    }


    private static void encontrarEInserirJogador(ArrayList<Jogador> players, ArrayList<Jogador> playersInseridos, int id) throws CloneNotSupportedException {
        for (Jogador player : players) {
            if (player.getId() == id) {
                playersInseridos.add(player.clone());
                break;
            }
        }
    }

    public void imprimir(){
        System.out.println("["+ id +" ## "+ nome + " ## " + altura + " ## " + peso + " ## " +
                anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " +
                estadoNascimento +"]");
    }

    public static void imprimirInformacoes(String nomeDoArquivo, int duracaoExecucao, int numeroComparacoes) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
            buffer.write("Matricula: 791624\t");
            buffer.write("Tempo de execucao: " + duracaoExecucao + "ms\t");
            buffer.write("Numero de comparacoes: " + numeroComparacoes + "\t");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            Jogador jogador = new Jogador();
            ArrayList<Jogador> players = new ArrayList<>();
            ArrayList<Jogador> playersInseridos = new ArrayList<>();
            jogador.ler(FILE_PATH, players);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String entrada;

            while (true) {
                entrada = reader.readLine();
                if (entrada.equals("FIM")) {
                    break;
                }
                encontrarEInserirJogador(players, playersInseridos, Integer.parseInt(entrada));
            }

            ordenarCountingSort(playersInseridos);
            imprimirInformacoes(FILE_PATH,);

            for (Jogador jogadorInserido : playersInseridos) {
                jogadorInserido.imprimir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
