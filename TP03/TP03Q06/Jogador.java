import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public Jogador() {

    }

    public Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento,
                   String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    // Métodos getters e setters

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

    static TP04.TP04Q01.Jogador buscarPorId(int x) {
        TP04.TP04Q01.Jogador[] temp = ler();
        for (int i = 0; i < SIZE; i++) {
            if (temp[i].getId() == x) {
                return temp[i];
            }
        }
        return temp[0];
    }

    static TP04.TP04Q01.Jogador[] ler() {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(FILE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
            return new TP04.TP04Q01.Jogador[0];
        }

        scanner.nextLine(); // Ignorar a primeira linha
        TP04.TP04Q01.Jogador[] jogador = new TP04.TP04Q01.Jogador[SIZE];
        int i = 0;

        while (scanner.hasNext()) {
            jogador[i] = new TP04.TP04Q01.Jogador();
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

    static TP04.TP04Q01.Jogador cloneJogador(TP04.TP04Q01.Jogador jogador) {
        TP04.TP04Q01.Jogador clone = new TP04.TP04Q01.Jogador();
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

    public static class ListaSequencial {
        private TP04.TP04Q01.Jogador[] array;
        private int n;

        public ListaSequencial() {
            this(0);
        }

        public ListaSequencial(int tamanho) {
            array = new TP04.TP04Q01.Jogador[tamanho];
            n = 0;
        }

        void inserirInicio(TP04.TP04Q01.Jogador jogador) throws Exception {
            if (n >= array.length) {
                throw new Exception("Erro ao inserir");
            }
            for (int i = n; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = jogador;
            n++;
        }

        void inserir(TP04.TP04Q01.Jogador jogador, int pos) throws Exception {
            if (pos < 0 || pos > array.length) {
                throw new Exception("Posição Inválida");
            }
            for (int i = n; i > pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos] = jogador;
            n++;
        }

        void inserirFim(TP04.TP04Q01.Jogador jogador) throws Exception {
            if (n >= array.length) {
                throw new Exception("Array cheio");
            }
            array[n] = jogador;
            n++;
        }

        TP04.TP04Q01.Jogador removerInicio() throws Exception {
            if (n == 0) {
                throw new Exception("Array vazio");
            }
            TP04.TP04Q01.Jogador resp = array[0];
            for (int i = 0; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            return resp;
        }

        TP04.TP04Q01.Jogador remover(int pos) throws Exception {
            if (pos < 0 || pos >= n || n == 0) {
                throw new Exception("Não foi possível remover");
            }
            TP04.TP04Q01.Jogador resp = array[pos];
            for (int i = pos; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            return resp;
        }

        TP04.TP04Q01.Jogador removerFim() throws Exception {
            if (n == 0) {
                throw new Exception("Array vazio");
            }
            return array[--n];
        }

        public void preencher(TP04.TP04Q01.Jogador[] aux) {
            for (int i = 0; i < n; i++) {
                n++;
                array[i] = TP04.TP04Q01.Jogador.cloneJogador(aux[i]);
            }
            System.out.println(n);
        }

        void mostrar() {
            for (int i = 0; i < n; i++) {
                System.out.print("[" + i + "]");
                System.out.print(" ## ");
                System.out.print(array[i].getNome());
                System.out.print(" ## ");
                System.out.print(array[i].getAltura());
                System.out.print(" ## ");
                System.out.print(array[i].getPeso());
                System.out.print(" ## ");
                System.out.print(array[i].getAnoNascimento());
                System.out.print(" ## ");
                System.out.print(array[i].getUniversidade());
                System.out.print(" ## ");
                System.out.print(array[i].getCidadeNascimento());
                System.out.print(" ## ");
                System.out.print(array[i].getEstadoNascimento());
                System.out.println(" ## ");
            }
        }
    }

    public static class PilhaJogador {
        public Celula topo;
        public Celula fim;

        public PilhaJogador() {
            topo = null;
        }

        public void inserir(TP04.TP04Q01.Jogador jogador) {
            Celula tmp = new Celula(jogador);
            if (topo == null) {
                topo = tmp;
                fim = tmp;
                return;
            }
            Celula ponteiro = topo;

            while (ponteiro.prox != null) {
                ponteiro = ponteiro.prox;
            }
            ponteiro.prox = tmp;
            fim = tmp;
        }

        public TP04.TP04Q01.Jogador remover() throws Exception {
            if (topo == null) {
                throw new Exception("Pilha vazia!");
            }

            TP04.TP04Q01.Jogador removido = fim.elemento;

            if (topo == fim) {
                topo = null;
                fim = null;
            } else {
                Celula ponteiro = topo;
                while (ponteiro.prox != fim) {
                    ponteiro = ponteiro.prox;
                }
                ponteiro.prox = null;
                fim = ponteiro;
            }

            return removido;
        }

        public int tamanho() {
            int tamanho = 0;
            for (Celula i = topo; i != null; i = i.prox) {
                tamanho++;
            }
            return tamanho;
        }

        public void mostrarReverso() {
            int index = tamanho() - 1;
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.println("[" + index + "] ## " + i.elemento.getNome() + " ## " + i.elemento.getAltura() + " ## " + i.elemento.getPeso() + " ## " + i.elemento.getAnoNascimento() + " ## " + i.elemento.getUniversidade() + " ## " + i.elemento.getCidadeNascimento() + " ## " + i.elemento.getEstadoNascimento() + " ##");
                index--;
            }
        }

        public void mostrar() {
            int index = 0;
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.println("[" + index + "] ## " + i.elemento.getNome() + " ## " + i.elemento.getAltura() + " ## " + i.elemento.getPeso() + " ## " + i.elemento.getAnoNascimento() + " ## " + i.elemento.getUniversidade() + " ## " + i.elemento.getCidadeNascimento() + " ## " + i.elemento.getEstadoNascimento() + " ##");
                index++;
            }
        }
    }

    static class Celula {
        public TP04.TP04Q01.Jogador elemento;
        public Celula prox;

        public Celula() {
            this(null);
        }

        public Celula(TP04.TP04Q01.Jogador elemento) {
            this.elemento = elemento;
            this.prox = null;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String aux;
        TP04.TP04Q01.Jogador[] a = TP04.TP04Q01.Jogador.ler();
        TP04.TP04Q01.Jogador[] b = new TP04.TP04Q01.Jogador[SIZE];
        int i = 0;
        PilhaJogador pilha = new PilhaJogador();

        while (true) {
            aux = scanner.nextLine();
            if (aux.equals("FIM")) {
                break;
            } else if (Integer.parseInt(aux) < SIZE) {
                pilha.inserir(TP04.TP04Q01.Jogador.buscarPorId(Integer.parseInt(aux)));
                i++;
            }
        }

        int num = scanner.nextInt();
        for (int j = 0; j < num; j++) {
            String acao = scanner.next();

            switch (acao) {
                case "I":
                    int idI = scanner.nextInt();
                    pilha.inserir(TP04.TP04Q01.Jogador.buscarPorId(idI));
                    break;
                case "R":
                    TP04.TP04Q01.Jogador removido = pilha.remover();
                    System.out.println("(R) " + removido.getNome());
                    break;
                default:
                    break;
            }
        }
        pilha.mostrar();
        scanner.close();
    }
}