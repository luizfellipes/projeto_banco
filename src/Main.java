import Entity.ContaBanco;
import Service.ServiceContaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceContaBanco serviceCb = new ServiceContaBanco();
        ContaBanco cb = new ContaBanco();
        Scanner scanner = new Scanner(System.in);

        String continua = "N";
        while (continua.equals("N")) {
            System.out.println("################@ Banco do lalau @################");
            System.out.print("Selecione a opção para continuar: \n[1]Abrir Conta: \n[2]Fechar Conta: " +
                    "\n[3]Deposito: \n[4]Sacar: \n[5]Saldo: \n[6]Pagar Mensal:  \n[7]Finalizar Acesso: \nSelecione: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1: {
                    System.out.print("Digite o numero da conta: ");
                    int numcont = scanner.nextInt();
                    cb.setNumConta(numcont);
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.next();
                    cb.setDono(nome);
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
                    break;
                }

                case 2: {
                    serviceCb.fecharConta();
                    break;
                }

                case 3: {
                    serviceCb.depositar(null);
                    break;
                }

                case 4: {
                    serviceCb.sacar(null);
                    break;
                }

                case 5: {
                    serviceCb.saldo();
                    break;
                }
                case 6: {
                    serviceCb.pagarMensal();
                    break;
                }
                default: {
                    System.out.println("Deseja realmente finalizar o acesso? \nSeus dados serão perdidos! [S/N]");
                    continua = scanner.next();
                    System.err.println("Programa Finalizado com sucesso !");
                }

            }
        }
    }
}
