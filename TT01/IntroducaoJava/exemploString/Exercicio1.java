package TT01.IntroducaoJava.exemploString;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String string = scanner.nextLine();

        if(hasDigito(string)){
            System.out.println("Tem digitos");
        }else{
            System.out.println("Nao tem digitos");
        }

        scanner.close();
    }
    static boolean hasDigito(String string){

        boolean result = false;
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                result = true;
                return result;
            }
        }
        return result;
    }
}
