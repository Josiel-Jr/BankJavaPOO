package project;

public class Display {
    public static void printMenuInicial() {
        System.out.println("*-------------------*");
        System.out.println("0 - Sair do programa");
        System.out.println("1 - Login Gerente");
        System.out.println("2 - Login Cliente");
        System.out.println("*-------------------*");
    }

    public static void printMenuGerente() {
        System.out.println("*-------Gerente-------*");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Excluir Cliente");
        System.out.println("3 - Logout");
        System.out.println("*---------------------*");
    }

    public static void printMenuCliente() {
        System.out.println("*-------Cliente-----*");
        System.out.println("1 - Depositar");
        System.out.println("2 - Ver Saldo");
        System.out.println("3 - Sacar");
        System.out.println("4 - Logout");
        System.out.println("*-------------------*");
    }
}
