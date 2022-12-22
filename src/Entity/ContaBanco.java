package Entity;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int n) {
        this.numConta = n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String d) {
        this.dono = d;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float s) {
        this.saldo = s;
    }

    public boolean getStatus(boolean b) {
        return status;
    }

    public boolean setStatus(boolean status) {
        return status;
    }
}


// Conta corrente: CC + começa com 50 reais, metodo pagarMensal paga 12 reais
// Conta poupança: CP + ganha 150 reais, metodo pagarMensal paga 20 reais
// metodo construtor começa com a conta fechada e saldo 0