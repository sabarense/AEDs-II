package EstruturasDeDados.Pilha;

public class Pilha {

    int[]elementos;
    int topo;

    Pilha(){
        elementos = new int[10];
        topo = -1;
    }

    public void push(int elementoDesejado){
        if(isFull()){
            throw new RuntimeException("Impossível acrescentar à pilha cheia");
        }
        topo++;
        elementos[topo] = elementoDesejado;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Impossível retirar da pilha vazia");
        }
        int elementoAserRemovido = elementos[topo];
        topo--;
        return elementoAserRemovido;
    }

    public boolean isEmpty(){
        return (topo == -1);
    }

    public boolean isFull(){
        return (topo == elementos.length - 1);
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Impossível retirar da pilha vazia");
        }
        return elementos[topo];
    }
}
