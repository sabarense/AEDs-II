#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LENGTH 100
#define MAX_TAM 3923

typedef struct {
    int id;
    char nome[MAX_LENGTH];
    int altura;
    int peso;
    char universidade[MAX_LENGTH];
    int anoNascimento;
    char cidadeNascimento[MAX_LENGTH];
    char estadoNascimento[MAX_LENGTH];
} Jogador;

Jogador array[MAX_TAM];
int n;

void start(){
    n = 0;
}

void inserirInicio(Jogador x) {
   int i;

   if(n >= MAX_TAM){
      printf("Erro ao inserir inicio!");
      exit(1);
   }

   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }

   array[0] = x;
   n++;
}


void inserirFim(Jogador x) {
   if(n >= MAX_TAM){
      printf("Erro ao inserir fim!");
      exit(1);
   }

   array[n] = x;
   n++;
}


void inserir(Jogador x, int pos) {
   int i;

   if(n >= MAX_TAM || pos < 0 || pos > n){
      printf("Erro ao inserir pos!");
      exit(1);
   }

   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }

   array[pos] = x;
   n++;
}


Jogador removerInicio() {
   int i;
   Jogador resp;

   if (n == 0) {
      printf("Erro ao remover inicio!");
      exit(1);
   }

   resp = array[0];
   n--;

   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}


Jogador removerFim() {

   if (n == 0) {
      printf("Erro ao remover fim!");
      exit(1);
   }

   return array[--n];
}

Jogador remover(int pos) {
   int i;
   Jogador resp;

   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover pos!");
      exit(1);
   }

   resp = array[pos];
   n--;

   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}


void mostrar(){
    for(int i = 0; i < n; i++){
        printf("[%i] ## %s ## %i ## %i ## %i ## %s ## %s ## %s ##\n", i, array[i].nome, array[i].altura, array[i].peso, array[i].anoNascimento, array[i].universidade, array[i].cidadeNascimento, array[i].estadoNascimento);
    }
}

void imprimir(Jogador *jogador){
    printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void replaceVirgula(char *str){
    int tamanho = strlen(str);
    char tmp[3 * tamanho];
    int j = 0;

    for (int i = 0; i < tamanho; i++) {
        if (str[i] == ',' && str[i+1] == ',') {
            tmp[j++] = ',';
            tmp[j++] = 'n';
            tmp[j++] = 'a';
            tmp[j++] = 'o';
            tmp[j++] = ' ';
            tmp[j++] = 'i';
            tmp[j++] = 'n';
            tmp[j++] = 'f';
            tmp[j++] = 'o';
            tmp[j++] = 'r';
            tmp[j++] = 'm';
            tmp[j++] = 'a';
            tmp[j++] = 'd';
            tmp[j++] = 'o';
            tmp[j++] = ',';

            i++;

        } else {
            tmp[j++] = str[i];
        }

    }

    if (tmp[j - 2] == ',') {
        tmp[j-1] = 'n';
        tmp[j++] = 'a';
        tmp[j++] = 'o';
        tmp[j++] = ' ';
        tmp[j++] = 'i';
        tmp[j++] = 'n';
        tmp[j++] = 'f';
        tmp[j++] = 'o';
        tmp[j++] = 'r';
        tmp[j++] = 'm';
        tmp[j++] = 'a';
        tmp[j++] = 'd';
        tmp[j++] = 'o';
    }

    tmp[j] = '\0';
    strcpy(str, tmp);
}


void clone(Jogador *jogador, Jogador *novo){
    novo->id = jogador->id;
    strcpy(novo->nome, jogador->nome);
    novo->altura = jogador->altura;
    novo->peso = jogador->peso;
    strcpy(novo->universidade, jogador->universidade);
    novo->anoNascimento = jogador->anoNascimento;
    strcpy(novo->cidadeNascimento, jogador->cidadeNascimento);
    strcpy(novo->estadoNascimento, jogador->estadoNascimento);
}

void ler(Jogador* jogador, char str[300]){
    replaceVirgula(str);
    str[strcspn(str, "\n")] = '\0';

    char *token;
    token = strtok(str, ",");
    int i = 0;

    while( token != NULL ) {
        if(i % 8 == 0){
            jogador->id = atoi(token);

        }else if(i % 8 == 1){
            strcpy(jogador->nome, token);

        }else if(i % 8 == 2){
            jogador->altura = atoi(token);

        }else if(i % 8 == 3){
            jogador->peso = atoi(token);

        }else if(i % 8 == 4){
            strcpy(jogador->universidade, token);

        }else if(i % 8 == 5){
            jogador->anoNascimento = atoi(token);

        }else if(i % 8 == 6){
            strcpy(jogador->cidadeNascimento, token);


        }else if(i % 8 == 7){
            strcpy(jogador->estadoNascimento, token);
        }
        i++;

        token = strtok(NULL, ",");
   }
}

int main(){

    Jogador players[3923];
    char a[5];

    FILE *arq = fopen("/tmp/players.csv", "r");
    start();

    if(arq == NULL){
        printf("File not found\n");
        return 0;
    }

    char str[300];
    fgets(str, sizeof(str), arq);
    int i = 0;
    while (fgets(str, sizeof(str), arq)) {
        ler(&players[i], str);
        i++;
    }

    scanf("%s", a);
    int cont = 0;
    while(1){
        if(strcmp(a, "FIM") == 0)
            break;
        inserirFim(players[atoi(a)]);
        scanf("%s", a);
    }

    scanf("%s", a);
    int qtd = atoi(a);

    for(int i = 0; i < qtd; i++){
        scanf(" %[^\n]", a);
        char str[MAX_LENGTH][MAX_LENGTH];
        char* token;
        token = strtok(a, " ");

        for(int i = 0; token != NULL; i++) {
            strcpy(str[i], token);
            token = strtok(NULL, " ");
        }

        if(strcmp(str[0], "II") == 0){
            inserirInicio(players[atoi(str[1])]);
        }
        else if(strcmp(str[0], "IF") == 0){
            inserirFim(players[atoi(str[1])]);
        }
        else if(strcmp(str[0], "I*") == 0){
            inserir(players[atoi(str[2])], atoi(str[1]));
        }
        else if(strcmp(str[0], "RI") == 0){
            Jogador player = removerInicio();
            printf("(R) %s\n", player.nome);
        }
        else if(strcmp(str[0], "RF") == 0){
            Jogador player = removerFim();
            printf("(R) %s\n", player.nome);
        }
        else if(strcmp(str[0], "R*") == 0){
            Jogador player = remover(atoi(str[1]));
            printf("(R) %s\n", player.nome);
        }
    }
    mostrar();

    fclose(arq);

    return 0;
}