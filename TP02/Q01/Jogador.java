package TP02.Q01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Jogador {

    private int id;
    private String nome;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;
    private int altura;

    public Jogador(){}

    public Jogador(int id, String nome, int peso, int anoNascimento, int altura) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.anoNascimento = anoNascimento;
        this.altura = altura;
    }

    public Jogador clone() throws CloneNotSupportedException {
        Jogador clone = (Jogador) super.clone();
        clone.id = this.id;
        clone.altura = this.altura;
        clone.peso = this.peso;
        clone.universidade = this.universidade;
        clone.anoNascimento = this.anoNascimento;
        clone.cidadeNascimento = this.cidadeNascimento;
        clone.estadoNascimento = this.estadoNascimento;
        return clone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }

    public void setEstadoNascimento(String estadoNascimento) {
        this.estadoNascimento = estadoNascimento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void imprimir() {
        System.out.print("[" +
                this.id + " ## " +
                this.nome + " ## " +
                this.altura + " ## " +
                this.peso + " ## " +
                this.universidade + " ## " +
                this.anoNascimento + " ## " +
                this.cidadeNascimento + " ## " +
                this.estadoNascimento + "]");
    }

    public void ler(String nomeDoArquivo) throws Exception {
        FileReader file = new FileReader(nomeDoArquivo);
        try (BufferedReader buffer = new BufferedReader(file)) {
            String line = buffer.readLine();
            String[] player;
            String naoInformado = "nao informado";

            while (line != null) {
                player = line.split(Pattern.quote(","));

                Jogador jogador = new Jogador();
                jogador.setId(Integer.parseInt(player[0]));

                if (player[1].isEmpty())
                    jogador.setNome(naoInformado);
                else
                    jogador.setNome(player[1]);

                jogador.setAltura(Integer.parseInt(player[2]));
                jogador.setPeso(Integer.parseInt(player[3]));

                if (player[4].isEmpty())
                    jogador.setUniversidade(naoInformado);
                else
                    jogador.setUniversidade(player[4]);

                jogador.setAnoNascimento(Integer.parseInt(player[5]));

                if (player[5].isEmpty())
                    jogador.setCidadeNascimento(naoInformado);
                else
                    jogador.setCidadeNascimento(player[5]);

                if (player[6].isEmpty())
                    jogador.setEstadoNascimento(naoInformado);
                else
                    jogador.setEstadoNascimento(player[6]);

                jogador.imprimir();

                line = buffer.readLine(); // Mover esta linha para o final do loop
            }
        }
    }

}
