import Service.ServiceContaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceContaBanco serviceCb = new ServiceContaBanco();
        Scanner scanner = new Scanner(System.in);

        String continua = "N";
        while (continua.equals("N")) {
            System.out.println("################@ Banco do lalau @################");
            System.out.print("Selecione a opção para continuar: \n[1]Abrir Conta: \n[2]Fechar Conta: " +
                    "\n[3]Deposito: \n[4]Sacar: \n[5]Pagar Mensal: \n[6]Finalizar Acesso: \nSelecione: ");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1: {
                    System.out.println("Selecione o tipo da conta a ser aberta: \n[1] para CC: \n[2] para CP:");
                    int selecao = scanner.nextInt();
                    String t;
                    if (selecao == 1) {
                        t = "CC";
                    } else {
                        t = "CP";
                    }
                    serviceCb.abrirConta(t);
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
