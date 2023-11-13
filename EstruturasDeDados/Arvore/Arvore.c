#include <stdio.h>
#include <stdlib.h>

typedef struct No{
    int elemento;
    struct No *direita, *esquerda;
}NoArvore;

NoArvore* inserir(NoArvore *raiz, int elemento){
    if(raiz == NULL){
        NoArvore *no = malloc(sizeof(NoArvore));
        no->elemento = elemento;
        no->esquerda = NULL;
        no->direita = NULL;
        return no;
    }else if(elemento < raiz->elemento){
        raiz->esquerda = inserir(raiz->esquerda, elemento);
    }else if(elemento > raiz->elemento){
        raiz->direita = inserir(raiz->direita, elemento);
    }
    return raiz;
}

void imprimirSemOrdenar(NoArvore *raiz){
    if(raiz){
        printf("%d ", raiz->elemento);
        imprimirSemOrdenar(raiz->esquerda);
        imprimirSemOrdenar(raiz->direita);
    }
}
void imprimirOrdenado(NoArvore *raiz){
    if(raiz){
        imprimirOrdenado(raiz->esquerda);
        printf("%d ", raiz->elemento);
        imprimirOrdenado(raiz->direita);
    }
}

NoArvore* buscar(NoArvore *raiz, int elemento){
    if(raiz){
        if(elemento == raiz->elemento){
            return raiz;
        }else if(elemento < raiz->elemento){
            return buscar(raiz->esquerda, elemento);
        }else if(elemento > raiz->elemento){
            return buscar(raiz->direita, elemento);
        }
    }
    return NULL;
}

NoArvore* removerFolha(NoArvore* raiz, int chave){
    if(raiz == NULL){
        printf("Valor nao encontrado!\n");
    }else if(raiz->elemento == chave){
        if( (raiz->esquerda == NULL) && (raiz->direita == NULL) ){
            free(raiz);
            return NULL;
        }
    }else if(chave < raiz->elemento){
        raiz->esquerda = removerFolha(raiz->esquerda, chave);
    }else if(chave > raiz->elemento){
        raiz->direita = removerFolha(raiz->direita, chave);
    }
    return raiz;
}

void liberarArvore(NoArvore *raiz) {
    if (raiz) {
        liberarArvore(raiz->esquerda);
        liberarArvore(raiz->direita);
        free(raiz);
    }
}

int menu(){
    printf("0 - Sair\n");
    printf("1 - Inserir\n");
    printf("2 - Imprimir\n");
    printf("3 - Buscar\n");
}

int main(){
    NoArvore *busca, *raiz = NULL;
    int opcao, elemento;

    do{
        menu();

        scanf("%d", &opcao);

        switch(opcao){
            case 0:
                printf("Finalizando o programa\n");
                liberarArvore(raiz);
                break;
            case 1:
                printf("Digite um elemento a ser inserido:");
                scanf("%d", &elemento);
                raiz = inserir(raiz, elemento);
                break;
            case 2:
                printf("Primeira impressao sem ordenar:\n");
                imprimirSemOrdenar(raiz);
                printf("\n");
                printf("Segunda impressao ordenado:\n");
                imprimirOrdenado(raiz);
                printf("\n");
                break;
            case 3:
                printf("Digite um elemento a ser buscado:\n");
                scanf("%d", &elemento);
                busca = buscar(raiz, elemento);
                if(busca){
                    printf("Elemento encontrado: %d!\n", busca->elemento);
                }else{
                    printf("Elemento encontrado: %d!\n", busca->elemento);
                }
                break;
            default:
                if(opcao != 0){
                    printf("Opcao invalida! Digite um numero de 0 ate 3!\n");
                }
        }
    }while(opcao != 0);
}