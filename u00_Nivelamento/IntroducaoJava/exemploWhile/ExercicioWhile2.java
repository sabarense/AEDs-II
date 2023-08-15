package u00_Nivelamento.IntroducaoJava.exemploWhile;

public class ExercicioWhile2 {
    public static void main(String[] args) {

        int count = 0;
        int num = 1;
        while(count < 10){
            if(num > 0){
                System.out.println("Numero: " + num);
                num++;
            }
            count++;
        }
    }
}
