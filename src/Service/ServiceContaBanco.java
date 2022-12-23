package Service;

import Entity.ContaBanco;

public class ServiceContaBanco {

    ContaBanco cb = new ContaBanco();

    public void estadoAtual() {
        System.out.println("Conta: " + cb.getNumConta());
        System.out.println("Tipo: " + cb.getTipo());
        System.out.println("Dono: " + cb.getDono());
        System.out.println("Saldo: " + cb.getSaldo());
        System.out.println("Status da Conta: " + cb.getStatus());
    }

    public void abrirConta(String t) {
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
            System.out.println("O fechamento dessa conta não pode ser realizado, conta com dinheiro");
        } else if (cb.getSaldo() < 0) {
            System.out.println("O fechamento dessa conta não pode ser realizado, conta com débitos a pagar");
        } else {
            cb.setStatus(false);
            System.out.println("Fechamento de conta finalizada !!");
        }
    }

    public void depositar(Float v) {
        if (cb.getStatus()) {
            cb.setSaldo(cb.getSaldo() + v);
            System.out.println("Deposito realizado com sucesso na conta de: " + cb.getDono() + " Saldo atual: " + cb.getSaldo());
        } else {
            System.out.println("Impossível depositar");
        }
    }

    public void sacar(Float v) {
        if (cb.getStatus()) {
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

    public void saldo() {
        System.out.println(cb.getSaldo());
    }

    public void pagarMensal() {
        int v = 0;
        if (cb.getTipo() == "CC") {
            v = 12;
        } else if (cb.getTipo() == "CP") {
            v = 20;
        }
        if (cb.getStatus() && cb.getSaldo() > v) {
            cb.setSaldo(cb.getSaldo() - v);
        } else {
            System.out.println("Impossível pagar");
        }
    }

}
