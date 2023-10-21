#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    FILE *arquivo;
    
    scanf("%d", &n);

    arquivo = fopen("valores.txt", "w");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        exit(1);
    }
    
    for (int i = 0; i < n; i++) {
        float valor;
        scanf("%f", &valor);
        fprintf(arquivo, "%.2f\n", valor);
    }

    fclose(arquivo);
    
   
    arquivo = fopen("valores.txt", "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        exit(1);
    }
    fseek(arquivo, 0, SEEK_END);
    long tamanho = ftell(arquivo);
    
   
    for (long i = tamanho - 1; i >= 0; i--) {
        char c;
        fseek(arquivo, i, SEEK_SET);
        fread(&c, sizeof(char), 1, arquivo);
        if ((c >= '0' && c <= '9') || c == '.') {
            printf("%c", c);
        } else if (c == '\n') {
            break;
        }
    }
    

    fclose(arquivo);
    
    return 0;
}
