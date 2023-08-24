
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool ehPalindromo(char palavra[]){
    
    bool result = true;
    int tamanho = strlen(palavra);
    for(int i = 0, j = tamanho - 1; i < tamanho/2; i++, j--){
        if(palavra[i] != palavra[j]){
            result = false;
            i = tamanho;
        }
    }
    return result;
}

int main(){
 
    char* palavra = (char*)malloc(200 * sizeof(char));
    bool palindromo = false;
    scanf(" %[^\r\n%*c]", palavra);
    while(strcmp(palavra,"FIM") != 0){
        palindromo = ehPalindromo(palavra);
        if(palindromo){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        scanf(" %[^\r\n]%*c", palavra);
    }
    return 0;
}