package project;

import java.util.ArrayList;

public class Banco {
    //atributos
    private String nome;
    private int agencia;
    private ArrayList<Cliente> clientes;
    private int senhaGerente;
    //construtor
    public Banco() {
        clientes=new ArrayList<>();
    }
    public Banco(String nome,int agencia,int senhaGerente) {
        this.nome=nome;
        this.agencia=agencia;
        this.senhaGerente=senhaGerente;
    }
    //metodos especiais
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public int getSenhaGerente() {
        return senhaGerente;
    }
    public void setSenhaGerente(int senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    //metodos
    public void cadastrarCliente(Cliente novo){
        this.clientes.add(novo);
    }
    public boolean excluirCliente(long CPF) {//talvez seja public void
        for(Cliente cliente : clientes){
            if(cliente.getCPF()==CPF){
                clientes.remove(cliente);
                System.out.printf("O cliente com CPF, %d foi removido.\n",CPF);
                return true;
            }
        }
        return false;
    }
}
