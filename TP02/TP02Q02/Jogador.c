#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef char* String;

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

    printf(" ## ");

    if (jogador.peso != -1) {
        printf("%d", jogador.peso);
    } else {
        printf("nao informado");
    }

    printf(" ## ");

    if (jogador.anoNascimento != -1) {
        printf("%d", jogador.anoNascimento);
    } else {
        printf("nao informado");
    }

    printf(" ## %s ## %s ## %s]\n", jogador.universidade, jogador.cidadeNascimento, jogador.estadoNascimento);

    free(jogador.nome);
    free(jogador.universidade);
    free(jogador.cidadeNascimento);
    free(jogador.estadoNascimento);
}


Jogador ler(int nid){
    FILE *arq = fopen("/tmp/players.csv", "r");
    if (arq == NULL) {
        printf("Abertura do arquivo nao sucedida\n");
        exit(1);
    }

    String linha = (String)calloc(600, sizeof(char));
    Jogador player;
    int nlinha=0;
    int j=0;

    //tem q ler cada linha pra percorrer o arquivo
    //id+3 pq o primeiro jogador ta na linha 2, ent o while para antes do id+3
    while(nlinha != nid+2){
        fscanf(arq,"%[^\n]", linha);
        fgetc(arq);
        //printf("%s\n", linha);
        nlinha++;
    }
    fclose(arq);
//    puts(linha);

    String tmp = (String)calloc(400, sizeof(char));
    int caracter=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        j++;
        caracter++;
    }
    player.id = stringToInt(tmp);
//    printf("%d", player.id);

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
        }
    j=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        j++;
        caracter++;
    }
//    puts(tmp);
    player.nome = strdup(tmp);

    player.altura = -1; // inicializando como -1
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    while (linha[caracter] != ',') {
        tmp[j] = linha[caracter];
        caracter++;
        j++;
    }
    if (strlen(tmp) > 0) {
        player.altura = stringToInt(tmp);
    }

    player.peso = -1;
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
    }
    if (strlen(tmp) > 0) {
        player.peso = stringToInt(tmp);

    }

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
    }

    j=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
    }
    player.universidade = strdup(tmp);


    player.anoNascimento = -1;
    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    j=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
    }
    if (strlen(tmp) > 0){
        player.anoNascimento = stringToInt(tmp);
    }

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ','){
            strcpy(tmp, "nao informado");
        }
    j=0;
    while(linha[caracter] != ','){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
    }
    player.cidadeNascimento = strdup(tmp);

    caracter++;
    free(tmp);
    tmp = (String)calloc(400, sizeof(char));
    if(linha[caracter] == ',' || linha[caracter] == '\n' || linha[caracter] == '\0'){
            strcpy(tmp, "nao informado");
        }
    j=0;
    while(linha[caracter] != ',' && linha[caracter] != '\n' && linha[caracter] != '\0'){
        tmp[j]=linha[caracter];
        caracter++;
        j++;
    }
    player.estadoNascimento = strdup(tmp);

return player;

}

int main()
{
    String pubin = (String)malloc(sizeof(char)*5);
    scanf("%s", pubin);
    getchar();

    while(pubin[0] != 'F'){
        imprimir(ler(stringToInt(pubin)));
        scanf("%s", pubin);
        getchar();
    }
    return 0;
}