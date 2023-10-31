//package TP03.TP03Q01;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import static java.lang.System.exit;

public class Jogador {

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

    public List<Jogador> ler(String nomeDoArquivo) throws Exception {

        ArrayList<Jogador> jogadores = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(nomeDoArquivo))) {

            buffer.readLine();
            String linha;

            while ((linha = buffer.readLine()) != null) {
                String[] jogadorInfo = linha.split(",", -1);

                Jogador jogador = new Jogador();
                jogador.setId(Integer.parseInt(jogadorInfo[0]));
                jogador.setNome(obterValor(jogadorInfo, 1));
                jogador.setAltura(obterValorInteiro(jogadorInfo, 2));
                jogador.setPeso(obterValorInteiro(jogadorInfo, 3));
                jogador.setUniversidade(obterValor(jogadorInfo, 4));
                jogador.setAnoNascimento(obterValorInteiro(jogadorInfo, 5));
                jogador.setCidadeNascimento(obterValor(jogadorInfo, 6));
                jogador.setEstadoNascimento(obterValor(jogadorInfo, 7));

                jogadores.add(jogador);
            }
        }
        return jogadores;
    }

    private static String obterValor(String[] array, int indice) {
        if (indice < array.length && !array[indice].isEmpty()) {
            return array[indice];
        }
        return "nao informado";
    }

    private static int obterValorInteiro(String[] array, int indice) {
        if (indice < array.length && !array[indice].isEmpty()) {
            return Integer.parseInt(array[indice]);
        }
        return -1;
    }

    public static Jogador criarJogador(String[] jogadorInfo) {

        int id = Integer.parseInt(jogadorInfo[0]);
        int altura = obterValorInteiro(jogadorInfo, 2);
        int peso = obterValorInteiro(jogadorInfo, 3);
        int anoNascimento = obterValorInteiro(jogadorInfo, 5);

        String nome = obterValor(jogadorInfo, 1);
        String universidade = obterValor(jogadorInfo, 4);
        String cidadeNascimento = obterValor(jogadorInfo, 6);
        String estadoNascimento = obterValor(jogadorInfo, 7);

        return new Jogador(id, altura, peso, anoNascimento, nome, universidade, cidadeNascimento, estadoNascimento);
    }

    public void imprimir() {
        System.out.println("[" + id + " ## " + nome + " ## " + altura + " ## " + peso + " ## " +
                anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " +
                estadoNascimento + "]");
    }

    public class Lista {

        Jogador[] array;

        int n;

        Lista(int tamanho) {
            array = new Jogador[tamanho];
            n = 0;
        }

        Lista() {
            this(3923);
        }

        void inserirInicio(Jogador jogador) throws Exception {
            if (n >= array.length)
                throw new Exception("Erro!");
            //levar elementos para o fim do array
            for (int i = n; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = jogador;
            n++;
        }

        void inserir(Jogador jogador, int pos) throws Exception {
            if (n >= array.length || pos < 0 || pos > n)
                throw new Exception("Erro!");
            //levar elementos para o fim do array
            for (int i = n; i > pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos] = jogador;
            n++;
        }

        void inserirFim(Jogador jogador) throws Exception {
            if (n >= array.length)
                throw new Exception("Erro!");
            array[n] = jogador;
            n++;
        }

        Jogador removerInicio() throws Exception {
            if (n == 0)
                throw new Exception("Erro!");
            Jogador jogadorRemovidoInicio = array[0];
            n--;
            for (int i = 0; i < n; i++) {
                array[i] = array[i + 1];
            }
            return jogadorRemovidoInicio;
        }

        Jogador remover(int pos) throws Exception {
            if (n == 0 || pos < 0 || pos >= n)
                throw new Exception("Erro!");
            Jogador jogadorRemovidoPosicaoDesejada = array[pos];
            n--;
            for (int i = pos; i < n; i++) {
                array[i] = array[i + 1];
            }
            return jogadorRemovidoPosicaoDesejada;
        }

        Jogador removerFim() {
            if (n == 0)
                exit(1);

            return array[--n];
        }

        public void processarComandos(String[] comandos) throws Exception {
            int i = 0;
            while (i < comandos.length) {
                String comando = comandos[i];
                String[] partes = comando.split(" ");
                String operacao = partes[0];

                switch (operacao) {
                    case "II":
                        Jogador jogadorInicio = Jogador.criarJogador(obterInfo(partes[1]));
                        this.inserirInicio(jogadorInicio);
                        break;
                    case "IF":
                        Jogador jogadorFim = Jogador.criarJogador(obterInfo(partes[1]));
                        this.inserirFim(jogadorFim);
                        break;
                    case "I*":
                        Jogador jogadorPosicao = Jogador.criarJogador(obterInfo(partes[2]));
                        int posicao = Integer.parseInt(partes[1]);
                        this.inserir(jogadorPosicao, posicao);
                        break;
                    case "RI":
                        System.out.println("(R) " + this.removerInicio().getNome());
                        break;
                    case "RF":
                        System.out.println("(R) " + this.removerFim().getNome());
                        break;
                    case "R*":
                        int posicaoRemocao = Integer.parseInt(partes[1]);
                        System.out.println("(R) " + this.remover(posicaoRemocao).getNome());
                        break;
                }
                i++;
            }
        }

        private String[] obterInfo(String arquivo) throws Exception {
            try (BufferedReader buffer = new BufferedReader(new FileReader(arquivo))) {
                String linha = buffer.readLine();
                return linha.split(",", -1);
            }
        }

        public void mostrarLista() {
            for (int i = 0; i < n; i++) {
                System.out.println("[" + array[i].getNome() + " ## " + array[i].getAltura() + " ## " + array[i].getPeso() + " ## " +
                        array[i].getAltura() + " ## " + array[i].getUniversidade() + " ## " + array[i].getCidadeNascimento() + " ## " +
                        array[i].getEstadoNascimento() + "]");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Jogador jogador = new Jogador();
            Lista lista = new Lista();

            Lista<Jogador> = jogador.ler("/tmp/players.csv");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Parte 2 da entrada: processar comandos
            int n = Integer.parseInt(reader.readLine());
            String[] comandos = new String[n];
            for (int i = 0; i < n; i++) {
                comandos[i] = reader.readLine();
            }

            // Processar comandos
            lista.processarComandos(comandos);

            // Mostrar lista após operações
            lista.mostrarLista();

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



