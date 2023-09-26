package TP02.Q01;

public class Principal {
    public static void main(String[] args) throws Exception {
        Jogador jogador = new Jogador();
        try{
            jogador.ler("C:\\Users\\yan.silva\\Desktop\\AEDs-II\\TP02\\Q01\\players.csv");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
