import TP03.TP03Q06.Arq;

public class Jogador {

    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    // Construtor sem parâmetros
    public Jogador() {

    }

    // Construtor com parâmetros para todos atributos
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

    // Métodos setters
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

    // Métodos getters
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

    // Método para encontrar o jogador com o id inserido
    static TP04.TP04Q01.Jogador PesquisaId(int x) {
        TP04.TP04Q01.Jogador[] temp = ler();
        for (int i = 0; i < 3922; i++) {
            if (temp[i].getId() == x) {
                return temp[i];
            }
        }
        return temp[0];
    }

    // Método para ler o jogador a partir do ID do parâmetro
    static TP04.TP04Q01.Jogador[] ler() {
        Arq.openRead("/tmp/players.csv");
        TP04.TP04Q01.Jogador[] jogador = new TP04.TP04Q01.Jogador[3922];
        int i = 0;
        Arq.readLine();
        while (Arq.hasNext()) {
            jogador[i] = new TP04.TP04Q01.Jogador();
            String jog = Arq.readLine();
            String[] temp = new String[8];
            temp = jog.split(",", 8);
            jogador[i].setId(Integer.parseInt(temp[0]));
            jogador[i].setNome(temp[1]);
            jogador[i].setAltura(Integer.parseInt(temp[2]));
            jogador[i].setPeso(Integer.parseInt(temp[3]));
            jogador[i].setUniversidade(temp[4]);
            jogador[i].setAnoNascimento(Integer.parseInt(temp[5]));
            jogador[i].setCidadeNascimento(temp[6]);
            jogador[i].setEstadoNascimento(temp[7]);

            // Ifs para lidar com campos vazios
            if (temp[4].isEmpty()) jogador[i].setUniversidade("nao informado");
            if (temp[6].isEmpty()) jogador[i].setCidadeNascimento("nao informado");
            if (temp[7].isEmpty()) jogador[i].setEstadoNascimento("nao informado");
            i++;
        }
        Arq.close();
        return jogador;
    }

    // Método para clonar um jogador
    static TP04.TP04Q01.Jogador cloneJogador(TP04.TP04Q01.Jogador jogador) {
        String temp;
        TP04.TP04Q01.Jogador clone = new TP04.TP04Q01.Jogador();
        temp = Integer.toString(jogador.getId());
        clone.setId(Integer.parseInt(temp));
        temp = jogador.getNome();
        clone.setNome(temp);
        temp = Integer.toString(jogador.getAltura());
        clone.setAltura(Integer.parseInt(temp));
        temp = Integer.toString(jogador.getPeso());
        clone.setPeso(Integer.parseInt(temp));
        temp = jogador.getUniversidade();
        clone.setUniversidade(temp);
        temp = Integer.toString(jogador.getAnoNascimento());
        clone.setAnoNascimento(Integer.parseInt(temp));
        temp = jogador.getCidadeNascimento();
        clone.setCidadeNascimento(temp);
        temp = jogador.getEstadoNascimento();
        clone.setEstadoNascimento(temp);
        return clone;
    }

    // Classe para a lista sequencial
    static class ListaSequencial {
        private TP04.TP04Q01.Jogador[] array;
        private int n;

        // Construtor sem parâmetros
        public ListaSequencial() {
            this(0);
        }

        // Construtor com o parâmetro int tamanho
        public ListaSequencial(int tamanho) {
            array = new TP04.TP04Q01.Jogador[tamanho];
            n = 0;
        }

        // Método de inserção no início
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

        // Método de inserir em qualquer posição válida
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

        // Método de inserção no final
        void inserirFim(TP04.TP04Q01.Jogador jogador) throws Exception {
            if (n >= array.length) {
                throw new Exception("Array cheio");
            }
            array[n] = jogador;
            n++;
        }

        // Método de remoção no início
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

        // Método de remoção em uma posição válida
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

        // Método para remoção no final
        TP04.TP04Q01.Jogador removerFim() throws Exception {
            if (n == 0) {
                throw new Exception("Array vazio");
            }
            return array[--n];
        }

        // Método para preencher o array de jogadores utilizados no main
        public void preencher(TP04.TP04Q01.Jogador[] tmp) {
            for (int i = 0; i < n; i++) {
                n++;
                array[i] = TP04.TP04Q01.Jogador.cloneJogador(tmp[i]);
            }
            System.out.println(n);
        }

        // Método para imprimir os jogadores do array
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

    public static void main(String[] args) throws Exception {
        String temp;
        TP04.TP04Q01.Jogador[] a = ler();
        int i = 0;
        ListaSequencial lista = new ListaSequencial(3923);

        // Método para ler e inserir ao final os jogadores do arquivo de entrada
        while (true) {
            temp = MyIO.readLine();
            if (temp.equals("FIM")){
                break;
            }
            else if (Integer.parseInt(temp) < 3922) {
                lista.inserirFim(PesquisaId(Integer.parseInt(temp)));
                i++;
            }
        }

        int num = MyIO.readInt();
        for (int j = 0; j < num; j++) {
            String acao = MyIO.readString();

            switch (acao) {
                case "II":
                    int idII = MyIO.readInt();
                    lista.inserirInicio(PesquisaId(idII));
                    break;
                case "IF":
                    int idIF = MyIO.readInt();
                    lista.inserirFim(PesquisaId(idIF));
                    break;
                case "I*":
                    int pos = MyIO.readInt();
                    int idI = MyIO.readInt();
                    lista.inserir(PesquisaId(idI), pos);
                    break;
                case "RF":
                    TP04.TP04Q01.Jogador removidoFim = lista.removerFim();
                    System.out.println("(R) " + removidoFim.getNome());
                    break;
                case "RI":
                    TP04.TP04Q01.Jogador removidoInicio = lista.removerInicio();
                    System.out.println("(R) " + removidoInicio.getNome());
                    break;
                default:
                    int posDefault = MyIO.readInt();
                    TP04.TP04Q01.Jogador removidoDefault = lista.remover(posDefault);
                    System.out.println("(R) " + removidoDefault.getNome());
                    break;
            }
        }

        lista.mostrar();
    }
}



