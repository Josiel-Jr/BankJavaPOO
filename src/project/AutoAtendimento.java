package project;
import java.util.Scanner;
import java.util.Random;

public class AutoAtendimento{
    //atributos
    private Banco banco;

    //construtor

    public AutoAtendimento() {
        banco = new Banco();
    }


    //metodos especiais
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    //metodos
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AutoAtendimento a1 = new AutoAtendimento(); //instância a classe AutoAtendimento
        Banco meuBanco = new Banco();

        //registrar o gerente
        int numAgencia, senhaGerente;
        System.out.print("Número da agência do gerente: ");
        while(!input.hasNextInt()){
            System.out.print("Número da agência do gerente: ");
            input.next();
        }
        numAgencia = input.nextInt();


        System.out.print("Senha do gerente: ");
        while(!input.hasNextInt()){
            System.out.print("Senha do gerente: ");
            input.next();
        }
        senhaGerente = input.nextInt();

        meuBanco.setAgencia(numAgencia);
        meuBanco.setSenhaGerente(senhaGerente);

        a1.setBanco(meuBanco);


        //variaveis dentro do switch
        int numAgenciaSwitch, senhaGerenteSwitch;//switch 1 extern
        int numContaSwitch, senhaClienteSwitch;//switch 2 extern

        int qtClientesCadastrados=0;

        int opTipoConta = -1;

        while (opTipoConta != 0) {
            Display.printMenuInicial();

            System.out.print("> ");
            while(!input.hasNextInt()){
                input.next();
            }
            opTipoConta = input.nextInt();
            while (opTipoConta < 0 || opTipoConta > 2) {
                System.out.println("Valor inválido ");
                System.out.print("> ");

                opTipoConta = input.nextInt();
            }



            if (opTipoConta == 0) {
                break;


            } else if (opTipoConta == 1) { // login Gerente
                System.out.print("Número da agência do gerente: ");
                while(!input.hasNextInt()){
                    System.out.print("Número da agência do gerente: ");
                    input.next();
                }
                numAgenciaSwitch=input.nextInt();

                System.out.println();

                System.out.print("Senha do gerente: ");
                while(!input.hasNextInt()){
                    System.out.print("Senha do gerente: ");
                    input.next();
                }
                senhaGerenteSwitch = input.nextInt();
                a1.loginGerente(numAgenciaSwitch , senhaGerenteSwitch);
                if(a1.banco.getAgencia() == numAgenciaSwitch && a1.banco.getSenhaGerente()==senhaGerenteSwitch) {//checa se as informações para acessar a conta do gerente estão certas
                    while (true) {
                        Display.printMenuGerente();
                        System.out.print("> ");
                        while(!input.hasNextInt()){
                            input.next();
                        }
                        int selecaoMenuGerente = input.nextInt();
                        while (selecaoMenuGerente > 4 || selecaoMenuGerente < 1) {
                            System.out.println("Valor inválido!");
                            System.out.print("> ");
                            while(!input.hasNextInt()){
                                input.next();
                            }
                            selecaoMenuGerente = input.nextInt();
                        }

                        if (selecaoMenuGerente == 1) { //cadastrarCliente
                            String nomeCliente;
                            long cpfCliente;
                            int numContaCliente;
                            Conta contaCliente = new Conta();
                            //aqui ira gera uma senha aleatoria
                            Random gerador=new Random();
                            int senhaAleatoria=0;
                            int j=100000;
                            for(int i=0;i<6;i++){
                                senhaAleatoria+= gerador.nextInt(10)*j;
                                j/=10;
                            }

                            // Dados básicos do cliente a ser cadastrado:
                            System.out.println("Digite o nome do cliente: ");
                            while(!input.hasNext()){
                                System.out.println("Digite o nome do cliente: ");
                                input.next();
                            }
                            nomeCliente = input.next();
                            System.out.println();

                            System.out.print("Digite o CPF do cliente: ");
                            while(!input.hasNextLong()){
                                System.out.print("Digite o CPF do cliente: ");
                                input.next();
                            }
                            cpfCliente = input.nextLong();
                            System.out.println();

                            // Criação de conta do Cliente a ser cadastrado:
                            System.out.print("Digite o numero da conta do cliente: ");
                            while(!input.hasNextInt()){
                                System.out.print("Digite o numero da conta do cliente: ");
                                input.next();
                            }
                            numContaCliente = input.nextInt();

                            contaCliente.setNumConta(numContaCliente);
                            contaCliente.setSaldo(0);
                            contaCliente.setSenha(senhaAleatoria);

                            // Criação do cliente e cadastro
                            Cliente novoCliente = new Cliente(nomeCliente, cpfCliente, contaCliente);
                            a1.gerenteCadastrarCliente(novoCliente);

                            System.out.println("> A senha do cliente é: " + senhaAleatoria);
                            qtClientesCadastrados++;
                        } else if (selecaoMenuGerente == 2) {
                            long cpfClienteExcluir;

                            System.out.println("Qual o CPF do cliente que você quer excluir? ");
                            while(!input.hasNextLong()){
                                System.out.println("Qual o CPF do cliente que você quer excluir? ");
                                input.next();
                            }
                            cpfClienteExcluir = input.nextLong();

                            a1.gerenteExcluirCliente(cpfClienteExcluir);
                        } else if (selecaoMenuGerente == 3) {
                            break;
                        }
                    }
                }



            } else if (opTipoConta == 2) { // login Cliente
                    if (qtClientesCadastrados != 0) {
                        int selecaoMenuCliente = -1;
                        int tentativas=3;
                        while (selecaoMenuCliente != 4) {
                            System.out.print("Número da conta do cliente: ");
                            while (!input.hasNextInt()) {
                                System.out.print("Número da conta do cliente: ");
                                input.next();
                            }
                            numContaSwitch = input.nextInt();
                            System.out.println();
                            System.out.print("Senha do cliente: ");
                            while (!input.hasNextInt()) {
                                System.out.print("Senha do cliente: ");
                                input.next();
                            }
                            senhaClienteSwitch = input.nextInt();
                            if (a1.loginCliente(numContaSwitch, senhaClienteSwitch) == 1) {
                                while (true) {

                                    Display.printMenuCliente();
                                    System.out.print("> ");
                                    selecaoMenuCliente = input.nextInt();

                                    if (selecaoMenuCliente == 1) { // Depositar
                                        System.out.print("Digite o CPF do destinatário: ");
                                        while (!input.hasNextLong()) {
                                            System.out.print("Digite o CPF do destinatário: ");
                                            input.next();
                                        }
                                        long cpfDestinario = input.nextLong();
                                        System.out.println();
                                        System.out.print("Valor do deposito: ");
                                        while (!input.hasNextFloat()) {
                                            System.out.print("Valor do deposito: ");
                                            input.next();
                                        }
                                        float valorDeposito = input.nextFloat();
                                        System.out.println();
                                        if(a1.clienteDepositar(valorDeposito, cpfDestinario)==1){
                                        }
                                        else {
                                            System.err.println("CPF não consta no sistema, Logo não será possível realizar o depósito");
                                        }

                                    } else if (selecaoMenuCliente == 2) { // Ver saldo
                                        System.out.print("Digite a senha: ");
                                        while (!input.hasNextInt()) {
                                            System.out.print("Digite a senha: ");
                                            input.next();
                                        }
                                        int clienteSenha = input.nextInt();
                                        if(clienteSenha==senhaClienteSwitch) {
                                            if (a1.clienteVerificarSaldo(clienteSenha) == 1) {

                                            } else {
                                                System.out.println("Senha não consta no sistema, Logo não será possível realizar o saldo");
                                            }
                                        }
                                        else {
                                            System.out.println("Senha incorreta");
                                        }

                                    } else if (selecaoMenuCliente == 3) { // Sacar
                                        System.out.print("Digite a senha: ");
                                        while (!input.hasNextInt()) {
                                            System.out.print("Digite a senha: ");
                                            input.next();
                                        }
                                        int clienteSenha = input.nextInt();
                                        System.out.println();
                                        System.out.print("Valor do saque: ");
                                        while (!input.hasNextFloat()) {
                                            System.out.print("Valor do saque: ");
                                            input.next();
                                        }
                                        float valorSaque = input.nextFloat();
                                        System.out.println();
                                        if(clienteSenha==senhaClienteSwitch){
                                            if (a1.clienteSacar(valorSaque, clienteSenha) == 1) {

                                            } else {
                                                System.err.println("Senha não consta no sistema, Logo não será possível realizar o saque");
                                            }
                                        }
                                        else {
                                            System.out.println("Senha incorreta");
                                        }
                                        }
                                        else if (selecaoMenuCliente == 4) { // logout
                                        break;
                                    }
                                }
                            } else {
                                tentativas--;
                                System.err.printf("Você tem direito a %d tentativa(s) de acessar a conta\n", tentativas);
                                if (tentativas == 0) {
                                    System.err.println("Você expirou o número de tentativas possíveis");
                                    break;
                                }
                            }
                        }
                    }

            }


        }
    }



    // Métodos
    public int loginCliente(int numConta, int senha) {
        for (Cliente cliente : this.banco.getClientes()) {
            if (numConta == cliente.getConta().getNumConta()) {
                if (senha == cliente.getConta().getSenha()) {
                    System.out.println("Login feito com sucesso");
                    return 1;
                } else {
                    //System.err.println("Senha incorreta");
                }
            } else {

            }
        }
        System.out.println("Não registro desses dados no sistema");
        return 0;
    }

    public void loginGerente(int numAgencia, int senha) {
        if (this.banco.getAgencia() == numAgencia) {
            if (this.banco.getSenhaGerente() == senha) {
                System.out.println("Login feito com sucesso");
            } else {
                //System.err.println("Senha incorreta");
            }
        } else {
            //System.err.println("Agência inexistente");
        }
    }

    public void gerenteCadastrarCliente(Cliente novo) {
        this.banco.cadastrarCliente(novo);
    }

    public void gerenteExcluirCliente(long CPF) {
        this.banco.excluirCliente(CPF);
    }

    public int clienteSacar(float valor, int senha) {
        for (Cliente cliente : this.banco.getClientes()) {
            if (cliente.getConta().getSenha() == senha) {
                cliente.getConta().sacar(valor, senha);
                return 1;
            }
        }
        return 0;
    }

    public int clienteDepositar(float valor , long cpf) {
        for (Cliente cliente : this.banco.getClientes()) {
            if (cliente.getCPF() == cpf) {
                cliente.getConta().depositar(valor);
                return 1;
            }
        }
        return 0;
    }

    public int clienteVerificarSaldo(int senha) {
        for (Cliente cliente : this.banco.getClientes()) {
            if (cliente.getConta().getSenha() == senha) {
                cliente.getConta().verificarSaldo(senha);
                return 1;
            }
        }
        return 0;
    }
}