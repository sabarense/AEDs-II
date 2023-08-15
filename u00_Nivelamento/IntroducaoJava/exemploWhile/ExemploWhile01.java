package u00_Nivelamento.IntroducaoJava.exemploWhile;

public class ExemploWhile01 {
    public static void main(String[] args) {
        int count = 1;
        int numero = 0;
        while(count <= 10){
            if(numero % 2 == 0){
                System.out.println(numero);
                count++;
            }
            numero++;
        }
    }
}
