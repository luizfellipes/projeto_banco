package Service;

import Entity.ContaBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceContaBanco {

    ContaBanco cb = new ContaBanco();
    Scanner scanner = new Scanner(System.in);

    public void abrirConta(String t) {
        System.out.print("Digite o numero da conta: ");
        int numConta = scanner.nextInt();
        cb.setNumConta(numConta);
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();
        cb.setDono(nome);
        cb.setTipo(t);
        cb.setStatus(true);
        if (t.equals("CC")) {
            cb.setSaldo(50);
        } else if (t.equals("CP")) {
            cb.setSaldo(150);
        }
        List<String> contasDeBanco = new ArrayList<>();
        contasDeBanco.add(numConta, nome);
        System.out.println("Sua nova conta foi aberta !");
    }

    public void fecharConta() {
        if (cb.getSaldo() > 0) {
            System.out.println("O fechamento dessa conta não pode ser realizado, conta com saldo disponivel: " + cb.getSaldo());
        } else if (cb.getSaldo() < 0) {
            System.out.println("O fechamento dessa conta não pode ser realizado, conta com débitos a pagar: " + cb.getSaldo());
        } else {
            cb.setStatus(false);
            System.out.println("Fechamento de conta finalizada !!");
        }
    }

    public void depositar(float v) {
        if (cb.getStatus()) {
            cb.setSaldo(cb.getSaldo() + v);
            System.out.println("Deposito realizado com sucesso na conta de: " + cb.getDono() + " Saldo atual: " + cb.getSaldo());
        } else {
            System.out.println("Impossível depositar");
        }
    }

    public void sacar() {
        if (cb.getStatus()) {
            System.out.println("Digite o valor desejado do saque: ");
            float v = scanner.nextFloat();
            if (cb.getSaldo() >= v) {
                cb.setSaldo(cb.getSaldo() - v);
                System.out.println("Saque realizado com sucesso na conta de: " + cb.getDono() + " Saldo atual: " + cb.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para realização de saque");
            }
        } else {
            System.err.println("Impossível sacar de uma conta fechada");
        }
    }

    public void pagarMensal() {
        int v = 0;
        if (cb.getTipo().equals("CC")) {
            v = 12;
        } else if (cb.getTipo().equals("CP")) {
            v = 20;
        }
        if (cb.getStatus() && cb.getSaldo() > v) {
            cb.setSaldo(cb.getSaldo() - v);
        } else {
            System.out.println("Impossível pagar, conta sem saldo !");
        }
    }

    public void estadoAtual() {
        System.out.println("Conta: " + cb.getNumConta());
        System.out.println("Tipo: " + cb.getTipo());
        System.out.println("Dono: " + cb.getDono());
        System.out.println("Saldo: " + cb.getSaldo());
        System.out.println("Status da Conta: " + cb.getStatus());
    }

}
