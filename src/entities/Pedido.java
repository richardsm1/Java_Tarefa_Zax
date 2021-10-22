package entities;

public class Pedido {
    private int numero;
    private Loja loja;
    private double valor;

    public Pedido(int numero, Loja loja, double valor) {
        this.numero = numero;
        this.loja = loja;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
