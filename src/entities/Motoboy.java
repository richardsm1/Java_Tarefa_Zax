package entities;

import java.util.ArrayList;
import java.util.List;

public class Motoboy {
    private String nome;
    private double valorEntrega;
    private Loja lojaExclusiva;
    private List<Pedido> pedidos = new ArrayList<>();

    public Motoboy(String nome, double valorEntrega, Loja lojaExclusiva) {
        this.nome = nome;
        this.valorEntrega = valorEntrega;
        this.lojaExclusiva = lojaExclusiva;
    }

    public Motoboy(String nome, double valorEntrega) {
        this.nome = nome;
        this.valorEntrega = valorEntrega;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public Loja getLojaExclusiva() {
        return lojaExclusiva;
    }

    public void setLojaExclusiva(Loja lojaExclusiva) {
        this.lojaExclusiva = lojaExclusiva;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double calcularGanhoPedido(Pedido p) {
        return valorEntrega + p.getValor() * p.getLoja().getComissaoPedidos();
    }

    public void relacaoPedidos() {

        System.out.printf("%nNome: %s%nQuantidade de pedidos: %d%n", nome, pedidos.size());
        System.out.println("\n                Relacao de pedidos do motoboy " + nome + "                ");

        pedidos.forEach(p -> System.out.println(
                "\nNumero do Pedido: " + p.getNumero() + "\n" +
                        "Loja responsavel: " + p.getLoja().getNome() + "\n" +
                        "Valor do pedido: " + String.format("R$ %.2f", p.getValor()) + "\n" +
                        "Comissao paga pela loja: " + String.format("%.2f%%", p.getLoja().getComissaoPedidos() * 100) + "\n" +
                        "Valor a ganhar pela entrega: " + String.format("R$ %.2f", calcularGanhoPedido(p)))
        );

        System.out.println("-----------------------------------------------------------------------------");
    }
}
