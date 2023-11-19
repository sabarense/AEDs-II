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

    static class Node {
        Jogador jogador;
        Node proximo;

        public Node(Jogador jogador) {
            this.jogador = jogador;
            this.proximo = null;
        }
    }

    static class ListaDinamica {
        private Node primeiro;

        public ListaDinamica() {
            this.primeiro = null;
        }

        void inserirInicio(Jogador jogador) {
            Node novoNode = new Node(jogador);
            novoNode.proximo = primeiro;
            primeiro = novoNode;
        }

        void inserirFim(Jogador jogador) {
            Node novoNode = new Node(jogador);
            if (primeiro == null) {
                primeiro = novoNode;
            } else {
                Node atual = primeiro;
                while (atual.proximo != null) {
                    atual = atual.proximo;
                }
                atual.proximo = novoNode;
            }
        }

        void inserir(Jogador jogador, int pos) {
            if (pos == 0) {
                inserirInicio(jogador);
            } else {
                Node novoNode = new Node(jogador);
                Node anterior = obterNodeNaPosicao(pos - 1);
                if (anterior != null) {
                    novoNode.proximo = anterior.proximo;
                    anterior.proximo = novoNode;
                }
            }
        }

        Jogador removerInicio() {
            if (primeiro == null) {
                return null;
            }
            Jogador removido = primeiro.jogador;
            primeiro = primeiro.proximo;
            return removido;
        }

        Jogador removerFim() {
            if (primeiro == null) {
                return null;
            }
            Jogador removido;
            if (primeiro.proximo == null) {
                removido = primeiro.jogador;
                primeiro = null;
            } else {
                Node atual = primeiro;
                while (atual.proximo.proximo != null) {
                    atual = atual.proximo;
                }
                removido = atual.proximo.jogador;
                atual.proximo = null;
            }
            return removido;
        }

        Jogador remover(int pos) {
            if (pos == 0) {
                return removerInicio();
            } else {
                Node anterior = obterNodeNaPosicao(pos - 1);
                if (anterior != null && anterior.proximo != null) {
                    Jogador removido = anterior.proximo.jogador;
                    anterior.proximo = anterior.proximo.proximo;
                    return removido;
                }
            }
            return null;
        }

        int tamanho() {
            int tamanho = 0;
            Node atual = primeiro;
            while (atual != null) {
                tamanho++;
                atual = atual.proximo;
            }
            return tamanho;
        }

        void mostrar() {
            Node atual = primeiro;
            int i = 0;
            while (atual != null) {
                System.out.print("[" + i + "]");
                System.out.print(" ## ");
                System.out.print(atual.jogador.getNome());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getAltura());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getPeso());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getAnoNascimento());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getUniversidade());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getCidadeNascimento());
                System.out.print(" ## ");
                System.out.print(atual.jogador.getEstadoNascimento());
                System.out.println(" ## ");
                atual = atual.proximo;
                i++;
            }
        }

        Node obterNodeNaPosicao(int pos) {
            if (pos < 0 || pos >= tamanho()) {
                return null;
            }
            Node atual = primeiro;
            for (int i = 0; i < pos; i++) {
                atual = atual.proximo;
            }
            return atual;
        }
    }

    public static void main(String[] args) throws Exception {

        String temp;
        Jogador[] a = ler();
        Jogador[] b = new Jogador[3922];
        int i = 0;
        ListaDinamica lista = new ListaDinamica();

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
                    Jogador removidoFim = lista.removerFim();
                    System.out.println("(R) " + removidoFim.getNome());
                    break;
                case "RI":
                    Jogador removidoInicio = lista.removerInicio();
                    System.out.println("(R) " + removidoInicio.getNome());
                    break;
                default:
                    int posDefault = MyIO.readInt();
                    Jogador removidoDefault = lista.remover(posDefault);
                    System.out.println("(R) " + removidoDefault.getNome());
                    break;
            }
        }

        lista.mostrar();
    }
}



