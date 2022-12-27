import Entity.ContaBanco;
import Service.ServiceContaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceContaBanco serviceCb = new ServiceContaBanco();
        Scanner scanner = new Scanner(System.in);

        String continua = "N";
        while (continua.equalsIgnoreCase("N")) {
            System.out.println("################@ Banco do lalau @################");
            System.out.print("""
                    Selecione a opção para continuar:\s
                    [1]Abrir Conta:\s
                    [2]Fechar Conta:\s
                    [3]Deposito:\s
                    [4]Sacar:\s
                    [5]Status da conta:\s
                    [6]Pagar Mensal: \s
                    [7]Finalizar Acesso:\s
                    Selecione:\s""");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> {
                    System.out.println("Selecione o tipo da conta a ser aberta: \n[1] para CC: \n[2] para CP:");
                    int selecao = scanner.nextInt();
                    String t;
                    if (selecao == 1) {
                        t = "CC";
                    } else {
                        t = "CP";
                    }
                    serviceCb.abrirConta(t);
                    serviceCb.estadoAtual();
                }
                case 2 -> {
                    serviceCb.fecharConta();
                }
                case 3 -> {
                    System.out.println("Digite o valor para o deposito: ");
                    float v = scanner.nextFloat();
                    serviceCb.depositar(v);
                }
                case 4 -> {
                    serviceCb.sacar();
                }
                case 5 -> {
                    serviceCb.estadoAtual();
                }
                case 6 -> {
                    serviceCb.pagarMensal();
                }
                default -> {
                    if (escolha == 7) {
                        System.out.println("Deseja realmente finalizar o acesso? \nSeus dados serão perdidos! [S/N]");
                        continua = scanner.next();
                        if (continua.equalsIgnoreCase("S")) {
                            System.err.println("Programa Finalizado com sucesso !");
                        }
                    }
                }
            }
        }
    }
}
