import Service.ServiceContaBanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceContaBanco serviceCb = new ServiceContaBanco();
        Scanner scanner = new Scanner(System.in);

        System.out.print("################@ Banco do lalau @################");
        System.out.print("Selecione a opção para continuar: \n[1]Abrir Conta: \n[2]Fechar Conta: " +
                "\n[3]Deposito \n[4]Sacar \n[5]Pagar Mensal \nSelecione: ");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1: {
                String t = null;
                serviceCb.abrirConta(t);
                break;
            }

            case 2: {
                serviceCb.fecharConta();
                break;
            }


        }
    }
}
