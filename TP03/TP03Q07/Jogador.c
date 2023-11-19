#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LENGTH 100
#define MAX_TAM 6

typedef struct
{
    int id;
    char nome[MAX_LENGTH];
    int altura;
    int peso;
    char universidade[MAX_LENGTH];
    int anoNascimento;
    char cidadeNascimento[MAX_LENGTH];
    char estadoNascimento[MAX_LENGTH];
} Jogador;

typedef struct Celula
{
    Jogador elemento;
    struct Celula *prox;
} Celula;

Celula *primeiraCelula;
Celula *ultimaCelula;
int quantidadeJogadores = 0;

Jogador listaJogadores[MAX_TAM];

Celula *criarCelula(Jogador elemento)
{
    Celula *novaCelula = (Celula *)malloc(sizeof(Celula));
    novaCelula->elemento = elemento;
    novaCelula->prox = NULL;
    return novaCelula;
}

int calcularMediaAlturas()
{
    float mediaAltura = 0;
    int contador = 0;
    Celula *celulaAtual;

    for (celulaAtual = primeiraCelula->prox; celulaAtual != NULL; celulaAtual = celulaAtual->prox)
    {
        mediaAltura += celulaAtual->elemento.altura;
        contador++;
    }

    mediaAltura = (float)mediaAltura / contador;
    mediaAltura += 0.5;
    mediaAltura = (int)mediaAltura;
    return (int)mediaAltura;
}

Jogador removerJogador()
{
    if (primeiraCelula == ultimaCelula)
    {
        printf("Erro ao remover!\n");
        exit(1);
    }

    Celula *temp = primeiraCelula;
    primeiraCelula = primeiraCelula->prox;
    Jogador jogadorRemovido = primeiraCelula->elemento;
    temp->prox = NULL;
    free(temp);
    temp = NULL;
    quantidadeJogadores--;

    return jogadorRemovido;
}

void inserirJogador(Jogador novoJogador)
{
    if (quantidadeJogadores == 5)
    {
        removerJogador();
    }

    ultimaCelula->prox = criarCelula(novoJogador);
    ultimaCelula = ultimaCelula->prox;
    quantidadeJogadores++;

    int somaAltura = 0;
    int numJogadores = 0;
    Celula *celulaAtual;

    for (celulaAtual = primeiraCelula->prox; celulaAtual != NULL; celulaAtual = celulaAtual->prox)
    {
        somaAltura += celulaAtual->elemento.altura;
        numJogadores++;
    }

    if (numJogadores == 0)
    {
        printf("Erro ao calcular a média!\n");
        exit(1);
    }

    int mediaAltura = calcularMediaAlturas();

    printf("%i\n", mediaAltura);
}

void mostrarJogadores()
{
    Celula *celulaAtual;
    int contador = 0;

    for (celulaAtual = primeiraCelula->prox; celulaAtual != NULL; celulaAtual = celulaAtual->prox, contador++)
    {
        printf("[%i] ## %s ## %i ## %i ## %i ## %s ## %s ## %s ##\n",
               contador, celulaAtual->elemento.nome, celulaAtual->elemento.altura,
               celulaAtual->elemento.peso, celulaAtual->elemento.anoNascimento,
               celulaAtual->elemento.universidade, celulaAtual->elemento.cidadeNascimento,
               celulaAtual->elemento.estadoNascimento);
    }
}

void imprimirJogador(Jogador *jogador)
{
    printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s]\n",
           jogador->id, jogador->nome, jogador->altura, jogador->peso,
           jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento,
           jogador->estadoNascimento);
}

void substituirVirgulaPorNaoInformado(char *str)
{
    int tamanho = strlen(str);
    char tmp[3 * tamanho];
    int j = 0;

    for (int i = 0; i < tamanho; i++)
    {
        if (str[i] == ',' && str[i + 1] == ',')
        {
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
        }
        else
        {
            tmp[j++] = str[i];
        }
    }

    if (tmp[j - 2] == ',')
    {
        tmp[j - 1] = 'n';
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

void clonarJogador(Jogador *origem, Jogador *destino)
{
    destino->id = origem->id;
    strcpy(destino->nome, origem->nome);
    destino->altura = origem->altura;
    destino->peso = origem->peso;
    strcpy(destino->universidade, origem->universidade);
    destino->anoNascimento = origem->anoNascimento;
    strcpy(destino->cidadeNascimento, origem->cidadeNascimento);
    strcpy(destino->estadoNascimento, origem->estadoNascimento);
}

void lerJogador(Jogador *jogador, char str[300])
{
    substituirVirgulaPorNaoInformado(str);
    str[strcspn(str, "\n")] = '\0';

    char *token;
    token = strtok(str, ",");
    int i = 0;

    while (token != NULL)
    {
        if (i % 8 == 0)
        {
            jogador->id = atoi(token);
        }
        else if (i % 8 == 1)
        {
            strcpy(jogador->nome, token);
        }
        else if (i % 8 == 2)
        {
            jogador->altura = atoi(token);
        }
        else if (i % 8 == 3)
        {
            jogador->peso = atoi(token);
        }
        else if (i % 8 == 4)
        {
            strcpy(jogador->universidade, token);
        }
        else if (i % 8 == 5)
        {
            jogador->anoNascimento = atoi(token);
        }
        else if (i % 8 == 6)
        {
            strcpy(jogador->cidadeNascimento, token);
        }
        else if (i % 8 == 7)
        {
            strcpy(jogador->estadoNascimento, token);
        }
        i++;

        token = strtok(NULL, ",");
    }
}

int main()
{
    Jogador jogadoresArquivo[3923];
    char entrada[MAX_LENGTH];

    FILE *arquivo = fopen("/tmp/players.csv", "r");

    primeiraCelula = criarCelula(jogadoresArquivo[0]);
    ultimaCelula = primeiraCelula;

    if (arquivo == NULL)
    {
        printf("Arquivo não encontrado\n");
        return 0;
    }

    char linha[300];
    fgets(linha, sizeof(linha), arquivo);
    int i = 0;

    while (fgets(linha, sizeof(linha), arquivo))
    {
        lerJogador(&jogadoresArquivo[i], linha);
        i++;
    }

    scanf("%s", entrada);
    int cont = 0;

    while (1)
    {
        if (strcmp(entrada, "FIM") == 0)
            break;
        inserirJogador(jogadoresArquivo[atoi(entrada)]);
        scanf("%s", entrada);
    }

    scanf("%s", entrada);
    int quantidade = atoi(entrada);

    for (int i = 0; i < quantidade; i++)
    {
        scanf(" %[^\n]", entrada);
        char comandos[MAX_LENGTH][MAX_LENGTH];
        char *token;
        token = strtok(entrada, " ");

        for (int i = 0; token != NULL; i++)
        {
            strcpy(comandos[i], token);
            token = strtok(NULL, " ");
        }

        if (strcmp(comandos[0], "I") == 0)
        {
            inserirJogador(jogadoresArquivo[atoi(comandos[1])]);
        }
        else if (strcmp(comandos[0], "R") == 0)
        {
            Jogador jogadorRemovido = removerJogador();
            printf("(R) %s\n", jogadorRemovido.nome);
        }
    }
    mostrarJogadores();

    fclose(arquivo);

    return 0;
}