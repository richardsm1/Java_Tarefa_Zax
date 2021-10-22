package entities;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Pedido> pedidos = new ArrayList<>();
    private List<Motoboy> motoboysExclusivos= new ArrayList<>();
    private double comissaoPedidos;

    public Loja(String nome, double comissaoPedidos) {
        this.nome = nome;
        this.comissaoPedidos = comissaoPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Motoboy> getMotoboysExclusivos() {
        return motoboysExclusivos;
    }

    public void setMotoboysExclusivos(List<Motoboy> motoboysExclusivos) {
        this.motoboysExclusivos = motoboysExclusivos;
    }

    public double getComissaoPedidos() {
        return comissaoPedidos;
    }

    public void setComissaoPedidos(double comissaoPedidos) {
        this.comissaoPedidos = comissaoPedidos;
    }
}
