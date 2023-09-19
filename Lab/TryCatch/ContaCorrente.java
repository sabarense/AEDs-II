package Lab.TryCatch;

public class ContaCorrente {
    private double saldo;


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saca(double valor) {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Tente fazer um novo saque.");
        } else {
            this.saldo-=valor;
        }
    }

    public void deposita(double valor){
        this.saldo+=valor;
    }
}
