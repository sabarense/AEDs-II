#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool ehPalindromoRec(char palavra[], int inicio, int fim)
{
    if (inicio >= fim)
    {
        return true;
    }
    if (palavra[inicio] != palavra[fim])
    {
        return false;
    }
    return ehPalindromoRec(palavra, inicio + 1, fim - 1);
}

bool ehPalindromo(char palavra[])
{
    int tamanho = strlen(palavra);
    return ehPalindromoRec(palavra, 0, tamanho - 1);
}

int main()
{

    char *palavra = (char *)malloc(200 * sizeof(char));
    bool palindromo = false;
    scanf(" %[^\r\n%*c]", palavra);
    while (strcmp(palavra, "FIM") != 0)
    {
        palindromo = ehPalindromo(palavra);
        if (palindromo)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        scanf(" %[^\r\n]%*c", palavra);
    }
    return 0;
}
