
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
    static Jogador PesquisaId(int x) {
        Jogador[] temp = ler();
        for (int i = 0; i < 3922; i++) {
            if (temp[i].getId() == x) {
                return temp[i];
            }
        }
        return temp[0];
    }

    // Método para ler o jogador a partir do ID do parâmetro
    static Jogador[] ler() {
        Arq.openRead("/tmp/players.csv");
        Jogador[] jogador = new Jogador[3922];
        int i = 0;
        Arq.readLine();
        while (Arq.hasNext()) {
            jogador[i] = new Jogador();
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
    static Jogador cloneJogador(Jogador jogador) {
        String temp;
        Jogador clone = new Jogador();
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
        private Jogador[] array;
        private int n;

        // Construtor sem parâmetros
        public ListaSequencial() {
            this(0);
        }

        // Construtor com o parâmetro int tamanho
        public ListaSequencial(int tamanho) {
            array = new Jogador[tamanho];
            n = 0;
        }

        // Método de inserção no início
        void inserirInicio(Jogador jogador) throws Exception {
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
        void inserir(Jogador jogador, int pos) throws Exception {
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
        void inserirFim(Jogador jogador) throws Exception {
            if (n >= array.length) {
                throw new Exception("Array cheio");
            }
            array[n] = jogador;
            n++;
        }

        // Método de remoção no início
        Jogador removerInicio() throws Exception {
            if (n == 0) {
                throw new Exception("Array vazio");
            }
            Jogador resp = array[0];
            for (int i = 0; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            return resp;
        }

        // Método de remoção em uma posição válida
        Jogador remover(int pos) throws Exception {
            if (pos < 0 || pos >= n || n == 0) {
                throw new Exception("Não foi possível remover");
            }
            Jogador resp = array[pos];
            for (int i = pos; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            return resp;
        }

        // Método para remoção no final
        Jogador removerFim() throws Exception {
            if (n == 0) {
                throw new Exception("Array vazio");
            }
            return array[--n];
        }

        // Método para preencher o array de jogadores utilizados no main
        public void preencher(Jogador[] tmp) {
            for (int i = 0; i < n; i++) {
                n++;
                array[i] = Jogador.cloneJogador(tmp[i]);
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

    // Classe para a pilha de jogador
    static class PilhaJogador {
        public Celula topo;
        public Celula fim;

        public PilhaJogador(){
            topo = null;
        }

        public void inserir(Jogador jogador){
            Celula tmp = new Celula(jogador);
            if(topo == null){
                topo = tmp;
                fim = tmp;
                return;
            }
            Celula ponteiro = topo;

            while(ponteiro.prox != null){
                ponteiro = ponteiro.prox;
            }
            ponteiro.prox = tmp;
            fim = tmp;
        }

        public Jogador remover() throws Exception {
            if (topo == null) {
                throw new Exception("Pilha vazia!");
            }

            Jogador removido = fim.elemento;

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


        public void mostrar(){
            int index = 0;
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.println("[" + index + "] ## " + i.elemento.getNome() + " ## " + i.elemento.getAltura() + " ## " + i.elemento.getPeso() + " ## " +
                        i.elemento.getAnoNascimento() + " ## " + i.elemento.getUniversidade() + " ## " + i.elemento.getCidadeNascimento() + " ## " +
                        i.elemento.getEstadoNascimento() + " ##");
                index++;
            }
        }

    }

    // Classe para a celula
    static class Celula {
        public Jogador elemento;
        public Celula prox;

        public Celula(){
            this(null);
        }

        public Celula(Jogador elemento){
            this.elemento = elemento;
            this.prox = null;
        }
    }

    public static void main(String[] args) throws Exception {
        String temp;
        Jogador[] a = Jogador.ler();
        Jogador[] b = new Jogador[3922];
        int i = 0;
        PilhaJogador pilha = new PilhaJogador();

        // Método para ler e empilhar os jogadores do arquivo de entrada
        while (true) {
            temp = MyIO.readLine();
            if (temp.equals("FIM")) {
                break;
            } else if (Integer.parseInt(temp) < 3922) {
                pilha.inserir(Jogador.PesquisaId(Integer.parseInt(temp)));
                i++;
            }
        }

        int num = MyIO.readInt();
        for (int j = 0; j < num; j++) {
            String acao = MyIO.readString();

            switch (acao) {
                case "I":
                    int idI = MyIO.readInt();
                    pilha.inserir(Jogador.PesquisaId(idI));
                    break;
                case "R":
                    Jogador removido = pilha.remover();
                    System.out.println("(R) " + removido.getNome());
                    break;
                default:
                    break;
            }
        }
        pilha.mostrar();
    }
}



