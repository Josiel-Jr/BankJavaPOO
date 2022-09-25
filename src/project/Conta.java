package project;

public class Conta {
    //atributos
    private int numConta;
    private float saldo;
    private int senha;
    //metodos especiai
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public int getSenha() {
        return senha;
    }
    public void setSenha(int senha) {
        this.senha = senha;
    }
    //construtor
    public Conta(){}
    public Conta(int numConta, float saldo, int senha) {
        this.numConta = numConta;
        this.saldo = saldo;
        this.senha = senha;
    }
    //metodos
    public void depositar(float valor) { //talvez sem senha
        if (valor < 0) {
            System.err.println("Valor de depósito negativo.");
        } else {
            System.out.printf("Na conta haviam R$%.2f", this.getSaldo());
            this.setSaldo(this.getSaldo() + valor);
            System.out.printf(" agora foi adicionado R$%.2f ficando com saldo de R$%.2f\n", valor, this.getSaldo());
        }
    }
    public void sacar(float valor, int senha) {
        if (senha == this.getSenha()) {
            if (valor < this.getSaldo()) {
                System.out.printf("Na conta havia R$%.2f", this.getSaldo());
                this.setSaldo(this.getSaldo() - valor);
                System.out.printf(" agora foi retirado R$%.2f ficando com saldo de R$%.2f\n", valor, this.getSaldo());
            } else {
                System.err.println("Saldo insuficiente, para realizar o saque.");
            }
        }
        else{
            System.err.println("A senha está errada.");
        }
    }
    public void verificarSaldo(int senha) {
        if (senha == this.getSenha()) {
            System.out.printf("A conta está com saldo de R$%.2f\n", this.getSaldo());
        }
        else{
            System.err.println("A senha está errada.");
        }
    }
}
