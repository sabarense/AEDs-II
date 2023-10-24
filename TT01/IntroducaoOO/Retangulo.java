package TT01.IntroducaoOO;

public class Retangulo {

    private double base;
    private double altura;

    public Retangulo(){

    }

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea(){
        return base * altura;
    }

    public double getPerimetro(){
        return 2 * (base + altura);
    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(this.altura,2) + Math.pow(this.base, 2));
    }


}

