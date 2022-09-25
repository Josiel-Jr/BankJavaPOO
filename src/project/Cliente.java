package project;

public class Cliente {
    //atributos
    private String nome;
    private long CPF;
    private Conta conta;
    //construtor
    public Cliente(){

    }
    public Cliente(String nome,long CPF, Conta conta) {
        this.nome=nome;
        this.CPF=CPF;
        this.conta=conta;
    }
    //metodos especiais
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCPF() {
        return CPF;
    }
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    public Conta getConta() {
        return conta;
    }
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
