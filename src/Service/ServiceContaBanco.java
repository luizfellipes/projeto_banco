package Service;

import Entity.ContaBanco;

public class ServiceContaBanco {

    ContaBanco cb = new ContaBanco();

    public void abrirConta(String t) {
        cb.setTipo(t);
        cb.setStatus(true);
        if (t == "CC") {
            cb.setSaldo(50);
        } else {
            cb.setSaldo(150);
        }
    }

    public void fecharConta() {
        if (cb.getSaldo() > 0) {
            System.out.println("Conta com dinheiro");
        } else if (cb.getSaldo() < 0) {
            System.out.println("Conta com débitos a pagar");
        } else {
            cb.setStatus(false);
            System.out.println("Conta finalizada !!");
        }
    }

    public void depositar(Float v) {
        if (cb.getStatus(true)) {
            cb.setSaldo(cb.getSaldo() + v);
            System.out.println("Saldo atual: " + cb.getSaldo());
        } else {
            System.out.println("Impossível depositar");
        }
    }

    public void sacar(Float v) {
        if (cb.getStatus(true) && cb.getSaldo() > v) {
            cb.setSaldo(cb.getSaldo() - v);
        } else {
            System.out.println("Impossível sacar");
        }
    }

    public void pagarMensal() {
        float v = 0;
        if (cb.getTipo() == "CC") {
            v = 12;
        } else if (cb.getTipo() == "CP") {
            v = 20;
        }
        if (cb.getStatus(true) && cb.getSaldo() > v) {
            cb.setSaldo(cb.getSaldo() - v);
        } else {
            System.out.println("Impossível pagar");
        }
    }

}
