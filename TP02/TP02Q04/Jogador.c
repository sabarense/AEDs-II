#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

typedef char* String;
int comp=0;

int stringToInt(String str){
    int res=0;
    int linha=1;
    for(int i=strlen(str)-1; i>=0; i--, linha*=10){
        res +=((int)(str[i])-48)*linha;
    }
    return res;
}

typedef struct Jogador{
int id;
String nome;
int altura;
int peso;
String universidade;
int anoNascimento;
String cidadeNascimento;
String estadoNascimento;
} Jogador;

void imprimir(Jogador jogador) {
    printf("[%d ## %s ## ", jogador.id, jogador.nome);

    if (jogador.altura != -1) {
        printf("%d", jogador.altura);
    } else {
        printf("nao informado");
    }
    comp++;

    printf(" ## ");

    if (jogador.peso != -1) {
        printf("%d", jogador.peso);
    } else {
        printf("nao informado");
    }
    comp++;

    printf(" ## ");

    if (jogador.anoNascimento != -1) {
        printf("%d", jogador.anoNascimento);
    } else {
        printf("nao informado");
    }
    comp++;

    printf(" ## %s ## %s ## %s]\n", jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);

    free(jogador.nome);
    free(jogador.universidade);
    free(jogador.cidadeNascimento);
    free(jogador.estadoNascimento);
}


Jogador ler(int nid){
//   FILE *arq = fopen(".\\tmp\\players.csv", "r");
    FILE *arq = fopen("/tmp/players.csv", "r");
    if (arq == NULL) {
        printf("Abertura do arquivo nao sucedida\n");
        exit(1);
    }
    comp++;

    String linha = (String)calloc(600, sizeof(char));
    Jogador player;
    int nlinha=0;
    int j=0;

    //tem q ler cada linha pra percorrer o arquivo
    //id+3 pq o primeiro jogador ta na linha 2, ent o while para antes do id+3
    comp++;
    while(nlinha != nid+2){
        fscanf(arq,"%[^\n]", linha);
        fgetc(arq);
        //printf("%s\n", linha);
        nlinha++;
        comp++;
    }

    fclose(arq);
//    puts(linha);

    String tmp = (String)calloc(400, sizeof(char));
    int caracter=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        j++;
        caracter++;
        comp++;
    }

    player.id = stringToInt(tmp);
//    printf("%d", player.id);

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
        }
        comp++;
    j=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        j++;
        caracter++;
        comp++;
    }
//    puts(tmp);
    player.nome = strdup(tmp);

    player.altura = -1; // inicializando como -1
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    comp++;
    while (linha[caracter] != ',') {
        tmp[j] = linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    if (strlen(tmp) > 0) {
        player.altura = stringToInt(tmp);
    }
    comp++;

    player.peso = -1;
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    if (strlen(tmp) > 0) {
        player.peso = stringToInt(tmp);

    }
    comp++;

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
    }
    comp++;

    j=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    player.universidade = strdup(tmp);


    player.anoNascimento = -1;
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    if (strlen(tmp) > 0){
        player.anoNascimento = stringToInt(tmp);
    }
    comp++;

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));

    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
        }
        comp++;
    j=0;
    comp++;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    player.cidadeNascimento = strdup(tmp);

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ',' || linha[caracter] == '\n' || linha[caracter] == '\0'){
            strcpy(tmp, "nao informado");
        }
        comp++;
    j=0;
    comp++;
    while(linha[caracter] != ',' && linha[caracter] != '\n' && linha[caracter] != '\0'){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
        comp++;
    }
    player.estadoNascimento = strdup(tmp);

return player;

}
//compara��o pro quicksort
int compararJogadores(const void* a, const void* b) {
    return strcmp(((Jogador*)a)->nome, ((Jogador*)b)->nome);
    comp++;
}

// funcao p trocar elementos - (aux)
void trocar(Jogador* a, Jogador* b) {
    Jogador temp = *a;
    *a = *b;
    *b = temp;
}

// quicksort
void quicksort(Jogador lista[], int esquerda, int direita) {
    if (esquerda < direita) {
        comp++;
        //pivo � o elemento do meio
        int meio = esquerda + (direita - esquerda) / 2;
        Jogador pivo = lista[meio];

        // particionou a lista em dois subarrays
        int i = esquerda, j = direita;
        comp++;
        while (i <= j) {
                comp++;
            while (compararJogadores(&lista[i], &pivo) < 0) {
                comp++;
                i++;
            }
            while (compararJogadores(&lista[j], &pivo) > 0) {
                comp++;
                j--;
            }
            comp++;
            if (i <= j) {
                trocar(&lista[i], &lista[j]);
                i++;
                j--;
            }
        }

        // recursao pra ordenar os elementos antes e depois do piv�
        quicksort(lista, esquerda, j);
        quicksort(lista, i, direita);
    }
}
int pesqBin(Jogador lista[], int tamanho, String nomein) {
    int esquerda = 0;
    int direita = tamanho - 1;

    comp++;
    while (esquerda <= direita) {
        comp++;
        int meio = esquerda + (direita - esquerda) / 2;
        int resultado = strcmp(lista[meio].nome, nomein);

        if (resultado == 0) {
            // O nome foi encontrado, retornar a posi��o
            return meio;
        }
        comp++;

        if (resultado < 0) {
            // O nome est� � direita
            esquerda = meio + 1;
        } else {
            // O nome est� � esquerda
            direita = meio - 1;
        }
        comp++;
    }

    return -1; //nao achou o nome
}
void pesquisa(){
    Jogador lista [105];
    String pubin = (String)malloc(sizeof(char)*5);
    scanf("%s", pubin);
    getchar();

    int i=0;
    comp++;
    while(pubin[0] != 'F'){
        ler(stringToInt(pubin));
        lista[i] = ler(stringToInt(pubin));
        i++;
        scanf(" %s", pubin);
        getchar();
        comp++;
    }
 /*   for(int j=0; j<i; j++){
        printf("%s ",lista[j].nome);
    }*/

    quicksort(lista, 0, i-1);

    String nomein = (String)malloc(sizeof(char)*40);
    fgets(nomein, sizeof(char) * 40, stdin);

    comp++;
    while(strcmp(nomein, "FIM") != 0){
        comp++;
        int len = strlen(nomein);
        if (nomein[len - 1] == '\n') {
            nomein[len - 1] = '\0'; // Remova a quebra de linha
        }
        comp++;
        int posicao = pesqBin(lista, i, nomein);
        if(posicao != -1){
            printf("SIM\n");
        } else{
            printf("NAO\n");
        }
        comp++;
        fgets(nomein, sizeof(char) * 40, stdin);
    }


}

int main()
{
    clock_t tempoInicial = clock();

    pesquisa();

    FILE *escrever;
    escrever = fopen("matricula_sequencial.txt", "w");
    if (escrever == NULL) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }
    fprintf(escrever, "00817611 \t %ld \t %d\n", (clock() - tempoInicial), comp);
    fclose(escrever);

    return 0;
}