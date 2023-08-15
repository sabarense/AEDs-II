package u00_Nivelamento.IntroducaoOO;

public class Ponto {

    private double x = 0;
    private double y = 0;
    private int id;
    private static int nextId = 0;

    public Ponto(){
        this.x = 0;
        this.y = 0;
        this.id = Ponto.nextId;
        Ponto.nextId++;
    }

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
        this.id = Ponto.nextId;
        Ponto.nextId++;
    }

    //gets
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getID() {
        return this.id;
    }

    public static int getNextID() {
        return nextId;
    }

    public double getAreaRetangulo(Ponto p){
        return 0;
    }

    //sets
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double dist(Ponto p){
        double dx = Math.pow( (this.x - p.getX()) , 2);
        double dy = Math.pow( (this.y - p.getY()) , 2);
        return Math.sqrt(dx + dy);
    }

    public double dist(double x, double y){
        double dx = Math.pow( (this.x - x) , 2);
        double dy = Math.pow( (this.y - y) , 2);
        return Math.sqrt(dx + dy);
    }

    public static double dist(double x1, double y1, double x2, double y2){
        double dx = Math.pow( (x1 - x2) , 2);
        double dy = Math.pow( (y1 - y2) , 2);
        return Math.sqrt(dx + dy);
    }

    public static boolean isTriangulo(Ponto p1, Ponto p2, Ponto p3){
        double diag1 = p1.getX() * p2.getY() *1; // diagonal primaria
        double diag2 = p1.getY() * 1 * p3.getX(); // diagonal primaria
        double diag3 = 1 * p2.getX()* p3.getY(); // diagonal primaria
        double diag4 = p1.getY()* p2.getX() * 1; // diagonal secundaria
        double diag5 = p1.getX() * 1 * p3.getY(); // diagonal secundaria
        double diag6 = 1 * p2.getY() * p3.getX(); //  // diagonal secundaria

        double determinante = diag1 + diag2 + diag3 - diag4 - diag5 - diag6;

        return (determinante != 0);
    }
}
