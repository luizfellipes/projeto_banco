package Service;

import Entity.ContaBanco;
import Entity.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceContaBanco {

    ContaBanco cb = new ContaBanco();
    Pessoa pessoa = new Pessoa();
    Scanner scanner = new Scanner(System.in);
    private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

    public void cadastro() {
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();
        pessoa.setNome(nome);
        System.out.println("Digite seu Telefone: ");
        int telefone = scanner.nextInt();
        pessoa.setTelefone(telefone);
        System.out.println("Digite seu cpf: ");
        String cpf = scanner.next();
        pessoa.setCpf(cpf);
        int id = 0;
        if (listaPessoa == null) {
            id++;
            pessoa.setId(id);
        } else {
                if (id >= 1) {
                    id++;
                    pessoa.setId(id);
                }
            }
            listaPessoa.add(pessoa);
        }



    public void abrirConta(String t) {
        cadastro();
        cb.setTipo(t);
        cb.setStatus(true);
        if (t.equals("CC")) {
            cb.setSaldo(50);
        } else if (t.equals("CP")) {
            cb.setSaldo(150);
        }
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
            System.out.println("Deposito realizado com sucesso na conta de: " + /*listaPessoa.getNome() + */" Saldo atual: " + cb.getSaldo());
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
                System.out.println("Saque realizado com sucesso na conta de: " + /* cb.getDono() + */ " Saldo atual: " + cb.getSaldo());
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
        System.out.println("ID: "+ pessoa.getId() +"\nnome: " + pessoa.getNome() + "\nTelefone: " + pessoa.getTelefone() + "\nCpf: " + pessoa.getCpf() + "\nSaldo: " + cb.getSaldo() + "\nStatus da Conta: " + cb.getStatus());
    }

}
