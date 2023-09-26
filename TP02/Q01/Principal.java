package TP02.Q01;

public class Principal {
    public static void main(String[] args) throws Exception {
        Jogador jogador = new Jogador();
        try{
            jogador.ler("C:\\Faculdade\\AEDs-II\\TP02\\Players.csv");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
