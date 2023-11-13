package EstruturasDeDados.Pilha;

public class Main {
    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        while(!pilha.isFull()){
            for(int i = 5; i >= 1; i--){
                pilha.push(i);
                System.out.println("Empilhei o elemento " + i);
            }
        }

        System.out.println();

        System.out.println("O primeiro elemento da pilha é " + pilha.peek());

        System.out.println();

        while(!pilha.isEmpty()){
            System.out.println("Desempilhei o elemento " + pilha.pop());
        }

    }
}
