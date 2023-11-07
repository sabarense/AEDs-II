package TP02.TP02Q18;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Jogador {
    private int id;
    private int altura;
    private int peso;
    private int anoNascimento;
    private String nome;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;

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

    public static void ordenarQuicksortParcial(ArrayList<Jogador> jogadores, int k) {
        if (jogadores.size() <= k) {
            // Não é necessário ordenar, pois já temos k elementos ou menos
            return;
        }

        // Seleciona os primeiros k jogadores como os menores até o momento
        ArrayList<Jogador> menores = new ArrayList<>(jogadores.subList(0, k));

        // Aplica o Quicksort no vetor
        quicksort(jogadores, 0, jogadores.size() - 1, menores, k);
    }

    private static void quicksort(ArrayList<Jogador> jogadores, int inicio, int fim, ArrayList<Jogador> menores, int k) {
        if (inicio < fim) {
            int indicePivo = particionar(jogadores, inicio, fim, menores, k);

            // Verifica se o pivo está entre os k menores
            if (indicePivo < k) {
                // A parte à direita do pivo não precisa ser ordenada
                quicksort(jogadores, indicePivo + 1, fim, menores, k);
            }

            // A parte à esquerda do pivo sempre precisa ser ordenada
            quicksort(jogadores, inicio, indicePivo - 1, menores, k);
        }
    }

    private static int particionar(ArrayList<Jogador> jogadores, int inicio, int fim, ArrayList<Jogador> menores, int k) {
        Jogador pivo = jogadores.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (jogadores.get(j).getEstadoNascimento().compareTo(pivo.getEstadoNascimento()) <= 0) {
                i++;
                Collections.swap(jogadores, i, j);
                if (i < k) {
                    menores.set(i, jogadores.get(i));
                }
            }
        }

        Collections.swap(jogadores, i + 1, fim);
        if (i + 1 < k) {
            menores.set(i + 1, jogadores.get(i + 1));
        }

        return i + 1;
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
    public static void main(String[] args) {
        try {
            Jogador jogador = new Jogador();
            ArrayList<Jogador> players = new ArrayList<>();
            ArrayList<Jogador> playersInseridos = new ArrayList<>();
            jogador.ler("/tmp/players.csv", players);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String entrada;

            while (true) {
                entrada = reader.readLine();
                if (entrada.equals("FIM")) {
                    break;
                }
                encontrarEInserirJogador(players, playersInseridos, Integer.parseInt(entrada));
            }

            ordenarQuicksortParcial(playersInseridos, 10);

            for (Jogador jogadorInserido : playersInseridos) {
                jogadorInserido.imprimir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
