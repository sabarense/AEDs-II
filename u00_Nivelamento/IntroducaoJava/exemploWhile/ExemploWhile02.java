package u00_Nivelamento.IntroducaoJava.exemploWhile;

public class ExemploWhile02 {
    public static void main(String[] args) {

        int numero = 1;
        while (numero <= 10) {
            double logBase10 = calcularLogBase10(numero);
            System.out.println("Log base 10 de " + numero + " é: " + logBase10);
            numero++;
        }
    }

    public static double calcularLogBase10(int numero) {

        double logE = Math.log(numero);
        return logE / Math.log(10);
    }
}
