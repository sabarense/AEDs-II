package Lab.TryCatch;

public class Principal {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.deposita(50);
        try{
            contaCorrente.saca(90);
            System.out.println("O valor desejado foi sacado de sua conta com sucesso.");
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}
