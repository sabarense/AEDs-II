//package TP02.Q07;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        FileReader file = new FileReader(nomeDoArquivo);
        BufferedReader buffer = new BufferedReader(file);

        String line = buffer.readLine();
        String player[] = new String[10];

        while (line != null) {
            line = buffer.readLine();
            if (line == null) {
                break;
            }
            player = line.split(Pattern.quote(","));

            Jogador jogador = new Jogador();
            jogador.setId(Integer.parseInt(player[0]));

            jogador.setNome(player.length > 1 && !player[1].isEmpty() ? player[1] : "nao informado");
            jogador.setAltura(player.length > 2 && !player[2].isEmpty() ? Integer.parseInt(player[2]) : 0);
            jogador.setPeso(player.length > 3 && !player[3].isEmpty() ? Integer.parseInt(player[3]) : 0);
            jogador.setUniversidade(player.length > 4 && !player[4].isEmpty() ? player[4] : "nao informado");

            try {
                jogador.setAnoNascimento(player.length > 5 && !player[5].isEmpty() ? Integer.parseInt(player[5]) : 0);
                jogador.setCidadeNascimento(player.length > 6 && !player[6].isEmpty() ? player[6] : "nao informado");
                jogador.setEstadoNascimento(player.length > 7 && !player[7].isEmpty() ? player[7] : "nao informado");
            } catch (NumberFormatException e) {
                String str = "";
                str += player[4];
                str += ", ";
                if (player.length > 5 && !player[5].isEmpty()) {
                    str += player[5];
                } else {
                    str += "";
                }
                jogador.setUniversidade(str);
                jogador.setAnoNascimento(player.length > 6 && !player[6].isEmpty() ? Integer.parseInt(player[6]) : 0);
                jogador.setCidadeNascimento(player.length > 7 && !player[7].isEmpty() ? player[7] : "nao informado");
                jogador.setEstadoNascimento(player.length > 8 && !player[8].isEmpty() ? player[8] : "nao informado");
            }
            array.add(jogador);
        }
        buffer.close();
    }

    public static void ordenarInsercao(ArrayList<Jogador> jogadores) throws IOException {

        FileWriter escritor = new FileWriter("791624_insercao.txt");
        BufferedWriter buffer = new BufferedWriter(escritor);

        LocalDateTime dataHoraInicio = LocalDateTime.now();
        int contadorComparacoes = 0;

        try {
            for (int i = 1; i < jogadores.size(); i++) {
                Jogador tmp = jogadores.get(i);
                int j = i - 1;

                while ((j >= 0) && (jogadores.get(j).getAnoNascimento() >= tmp.getAnoNascimento())) {
                    if (jogadores.get(j).getAnoNascimento() == tmp.getAnoNascimento()) {
                        contadorComparacoes++;
                        if (jogadores.get(j).getNome().compareTo(tmp.getNome()) > 0) {
                            jogadores.set(j + 1, jogadores.get(j));
                            j--;
                        } else {
                            break;
                        }
                    } else {
                        jogadores.set(j + 1, jogadores.get(j));
                        j--;
                    }
                }
                jogadores.set(j + 1, tmp);
            }
        } catch (Exception e) {

        }

        buffer.write("Matricula: 808721\t");
        LocalDateTime dataHoraFinal = LocalDateTime.now();
        Duration duracao = Duration.between(dataHoraInicio, dataHoraFinal);
        long duracaoMillis = duracao.toMillis();
        buffer.write("Tempo de execucao: " + duracaoMillis + "s\t");
        buffer.write("Numero de comparacoes: " + contadorComparacoes + "\t");
        buffer.close();
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
            jogador.ler("C:\\Faculdade\\AEDs-II\\TP02\\players.csv", players);

            Scanner sc = new Scanner(System.in);
            String entrada = "";
            while (!entrada.equals("FIM")) {
                entrada = sc.nextLine();
                if (entrada.equals("FIM")) {
                    break;
                }
                for (int i = 0; i < (players.size() - 1); i++) {
                    if (players.get(i).getId() == Integer.parseInt(entrada)) {
                        playersInseridos.add(players.get(i).clone());
                        break;
                    }
                }
            }
            ordenarInsercao(playersInseridos);
            for (int i = 0; i < playersInseridos.size(); i++) {
                playersInseridos.get(i).imprimir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
