#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_LENGTH 100
#define K 10

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

void imprimir(Jogador *jogador)
{
    printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void replaceVirgula(char *str)
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

void clone(Jogador *jogador, Jogador *novo)
{
    novo->id = jogador->id;
    strcpy(novo->nome, jogador->nome);
    novo->altura = jogador->altura;
    novo->peso = jogador->peso;
    strcpy(novo->universidade, jogador->universidade);
    novo->anoNascimento = jogador->anoNascimento;
    strcpy(novo->cidadeNascimento, jogador->cidadeNascimento);
    strcpy(novo->estadoNascimento, jogador->estadoNascimento);
}

void ler(Jogador *jogador, char str[300])
{
    replaceVirgula(str);
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

void swap(Jogador array[], int i, int j)
{
    Jogador temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void garanteOrdem(Jogador *jogador, int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (jogador[i].anoNascimento == jogador[j].anoNascimento)
            {
                if (strcmp(jogador[i].nome, jogador[j].nome) > 0)
                {
                    swap(jogador, i, j);
                }
            }
        }
    }
}

void heapify(Jogador array[], int n, int i)
{
    int maior = i;
    int esq = 2 * i + 1;
    int dir = 2 * i + 2;

    if (esq < n && array[esq].altura > array[maior].altura)
        maior = esq;

    if (dir < n && array[dir].altura > array[maior].altura)
        maior = dir;

    if (maior != i)
    {
        swap(array, i, maior);
        heapify(array, n, maior);
    }
}

void heapsort(Jogador array[], int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(array, n, i);

    for (int i = n - 1; i >= n - K; i--)
    {
        swap(array, 0, i);
        heapify(array, i, 0);
    }

    for (int i = n - K; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (array[i].anoNascimento == array[j].anoNascimento)
            {
                if (strcmp(array[i].nome, array[j].nome) > 0)
                {
                    swap(array, i, j);
                }
            }
        }
    }
}


int main()
{
    Jogador players[3923];
    Jogador clonedPlayers[3923];
    int contador = 0;
    char n[5];

    FILE *arq = fopen("/tmp/players.csv", "r");

    if (arq == NULL)
    {
        printf("File not found\n");
        return 0;
    }

    char str[300];
    fgets(str, sizeof(str), arq);
    int i = 0;
    while (fgets(str, sizeof(str), arq))
    {
        ler(&players[i], str);
        i++;
    }

    scanf("%s", n);
    int j = 0;
    while (strcmp(n, "FIM") != 0)
    {
        int indice = atoi(n);
        clone(&players[indice], &clonedPlayers[contador++]);
        j++;
        scanf("%s", n);
    }

    char name[100];
    scanf(" %[^\n]s", name);

    clock_t inicio, fim;
    double total;

    inicio = clock();
    heapsort(clonedPlayers, j);
    garanteOrdem(clonedPlayers, j);
    fim = clock();

    total = ((double)(fim - inicio)) / CLOCKS_PER_SEC;

    for (int i = j - K; i < j; i++)
    {
        imprimir(&clonedPlayers[i]);
    }
    fclose(arq);
    return 0;
}
