package TT01.IntroducaoOO;

public class LixaoRetangulo {
    public static void main(String[] args) {

        Retangulo retangulo1 = new Retangulo(5.4,5.5);
        Retangulo retangulo2 = new Retangulo();

        System.out.println("Altura do primeiro retangulo: " + retangulo1.getAltura());

        System.out.println("Base do primeiro retangulo: " + retangulo1.getBase());

        System.out.println("Area do primeiro retangulo: " + retangulo1.getArea());

        System.out.println("Perimetro do primeiro retangulo: " + retangulo1.getPerimetro());

        retangulo2.setAltura(6.5);
        System.out.println("Altura do segundo retangulo: " + retangulo2.getAltura());

        retangulo2.setBase(6.5);
        System.out.println("Base do segundo retangulo: " + retangulo2.getBase());

        System.out.println("Area do segundo retangulo: " + retangulo2.getArea());

        System.out.println("Perimetro do segundo retangulo: " + retangulo2.getPerimetro());


    }
}
