package EstruturasDeDados.Arvore;

public class NoArvore {
    int elemento;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(int elemento) {
        this.elemento = elemento;
        this.esquerda = null;
        this.direita = null;
    }
}
