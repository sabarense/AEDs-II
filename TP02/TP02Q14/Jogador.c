#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct {
    int id;
    char *nome;
    int altura;
    int peso;
    char *universidade;
    int anoNascimento;
    char *cidadeNascimento;
    char *estadoNascimento;
} Jogador;

int getint(int *pos, char linha[]) {
    char *tmp = calloc(100, sizeof(char));
    for (int j = 0; linha[*pos] != ','; j++) {
        tmp[j] = linha[(*pos)++];
    }
    int resp = atoi(tmp);
    free(tmp);
    return resp;
}

void getstring(int *pos, char *linha, char **v) {
    char *tmp = calloc(100, sizeof(char));
    for (int j = 0; (linha[*pos] != ',') && (linha[*pos] != '\n'); j++) {
        tmp[j] = linha[(*pos)++];
    }
    if (strlen(tmp) == 0) {
        tmp = "nao informado";
    }
    *v = tmp;
}

char *getLinha(FILE *f) {
    char *string = calloc(1001, sizeof(char));
    int i = 0;
    while ((string[i++] = fgetc(f)) != '\n');
    return string;
}

void criar(Jogador vet[]) {
    char lixo[1000], nf[20] = {"nao informado"};
    char *linha;
    FILE *f;
    const char *filename = "/tmp/players.csv";
    f = fopen(filename, "r");

    if (f == NULL) {
        printf("ERRO AO ABRIR ARQUIVO\n");
        return;
    }

    fscanf(f, " %[^\n]", lixo);
    fgetc(f);

    for (int i = 0; i < 3922; i++) {
        int pos = 0;
        linha = getLinha(f);
        vet[i].id = getint(&pos, linha); pos++;
        getstring(&pos, linha, &vet[i].nome); pos++;
        vet[i].altura = getint(&pos, linha); pos++;
        vet[i].peso = getint(&pos, linha); pos++;
        getstring(&pos, linha, &vet[i].universidade); pos++;
        vet[i].anoNascimento = getint(&pos, linha); pos++;
        getstring(&pos, linha, &vet[i].cidadeNascimento); pos++;
        getstring(&pos, linha, &vet[i].estadoNascimento); pos++;

        // Verificação e atribuição de valores padrão
        if (vet[i].id == -1) vet[i].id = -1;
        if (vet[i].nome[0] == '\0') strcpy(vet[i].nome, nf);
        if (vet[i].altura == 0) vet[i].altura = -1;
        if (vet[i].peso == 0) vet[i].peso = -1;
        if (vet[i].universidade[0] == '\0') strcpy(vet[i].universidade, nf);
        if (vet[i].anoNascimento == 0) vet[i].anoNascimento = -1;
        if (vet[i].cidadeNascimento[0] == '\0') strcpy(vet[i].cidadeNascimento, nf);
        if (vet[i].estadoNascimento[0] == '\0') strcpy(vet[i].estadoNascimento, nf);
    }

    fclose(f);
}

void swap(Jogador p1[], int i, int j) {
    Jogador tmp = p1[i];
    p1[i] = p1[j];
    p1[j] = tmp;
}

Jogador getMax(Jogador *array, int n) {
    Jogador maior = array[0];
    for (int i = 1; i < n; i++) {
        if (maior.id < array[i].id) {
            maior = array[i];
        }
    }
    return maior;
}

void radcountingSort(Jogador *array, int n, int exp, int *m, int *c) {
    int count[10];
    Jogador output[n];

    for (int i = 0; i < 10; i++) count[i] = 0;

    for (int i = 0; i < n; i++) {
        count[(array[i].id / exp) % 10]++;
    }

    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        output[count[(array[i].id / exp) % 10] - 1] = array[i];
        (*m)++;
        count[(array[i].id / exp) % 10]--;
    }

    for (int i = 0; i < n; i++) {
        array[i] = output[i];
    }
}

void radixsort(Jogador *array, int n, int *m, int *c) {
    Jogador max = getMax(array, n);
    for (int exp = 1; max.id / exp > 0; exp *= 10) {
        radcountingSort(array, n, exp, m, c);
    }
}

int main() {
    clock_t inicio, fi, tempo;
    Jogador vet[3923];
    criar(vet);

    char p[100];
    char fim[] = "FIM";
    scanf(" %s", p);

    Jogador vet2[5000];
    int k = 0;

    while (strcmp(p, fim) != 0) {
        int n = atoi(p);
        vet2[k] = vet[n];
        scanf(" %s", p);
        k++;
    }

    int mov = 0, comp = 0;
    inicio = clock();

    radixsort(vet2, k, &mov, &comp);

    for (int i = 0; i < k; i++) {
        printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
            vet2[i].id, vet2[i].nome, vet2[i].altura, vet2[i].peso, vet2[i].anoNascimento, vet2[i].universidade, vet2[i].cidadeNascimento, vet2[i].estadoNascimento);
    }

    FILE *f;
    f = fopen("791624_radixsort.txt", "w");
    int matricula = 801837;
    fi = clock();
    tempo = fi - inicio;
    fprintf(f, "%d\t%d\t%d\t%ld", matricula, comp, mov, tempo);
    fclose(f);

    return 0;
}
