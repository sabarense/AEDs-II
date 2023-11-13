package EstruturasDeDados.Arvore;

import java.util.Scanner;


public class BinaryTree {

    // Método para inserir um elemento na árvore
    static NoArvore inserir(NoArvore raiz, int elemento) {
        if (raiz == null) {
            // Cria um novo nó se a árvore estiver vazia
            return new NoArvore(elemento);
        } else if (elemento < raiz.elemento) {
            // Insere recursivamente na sub-árvore esquerda
            raiz.esquerda = inserir(raiz.esquerda, elemento);
        } else if (elemento > raiz.elemento) {
            // Insere recursivamente na sub-árvore direita
            raiz.direita = inserir(raiz.direita, elemento);
        }
        return raiz;
    }

    // Método para imprimir a árvore em pré-ordem (Nó -> Esquerda -> Direita(desordenada))
    static void imprimirSemOrdenar(NoArvore raiz) {
        if (raiz != null) {
            System.out.print(raiz.elemento + " ");
            imprimirSemOrdenar(raiz.esquerda);
            imprimirSemOrdenar(raiz.direita);
        }
    }

    // Método para imprimir a árvore em ordem (Esquerda -> Nó -> Direita (ordenada))
    static void imprimirOrdenado(NoArvore raiz) {
        if (raiz != null) {
            imprimirOrdenado(raiz.esquerda);
            System.out.print(raiz.elemento + " ");
            imprimirOrdenado(raiz.direita);
        }
    }

    static NoArvore buscar(NoArvore raiz, int elemento){
        if(raiz != null){
            if(elemento == raiz.elemento){
                return raiz;
            }else if(elemento < raiz.elemento){
                return buscar(raiz.esquerda, elemento);
            }else if(elemento > raiz.elemento){
                return buscar(raiz.direita, elemento);
            }
        }
        return null;
    }


    static void menu() {
        System.out.println("0 - Sair");
        System.out.println("1 - Inserir");
        System.out.println("2 - Imprimir");
        System.out.println("3 - Buscar na árvore");

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoArvore raiz = null;
        int opcao, elemento;


        do {
            menu();

            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Finalizando o programa");
                    break;
                case 1:
                    System.out.print("Digite um elemento a ser inserido:");
                    elemento = scanner.nextInt();
                    raiz = inserir(raiz, elemento);
                    break;
                case 2:
                    System.out.println("Primeira impressao sem ordenar:");
                    imprimirSemOrdenar(raiz);
                    System.out.println();
                    System.out.println("Segunda impressao ordenada:");
                    imprimirOrdenado(raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Digite o elemento a ser buscado:");
                    elemento = scanner.nextInt();
                    NoArvore resultadoBusca = buscar(raiz, elemento);
                    if (resultadoBusca != null) {
                        System.out.println("Elemento encontrado na árvore: " + resultadoBusca.elemento);
                    } else {
                        System.out.println("Elemento não encontrado na árvore.");
                    }
                    break;
                default:
                    if (opcao != 0) {
                        System.out.println("Opcao invalida! Digite um numero de 0 ate 2!");
                    }
            }
        } while (opcao != 0);

        // Fechar o scanner
        scanner.close();
    }
}