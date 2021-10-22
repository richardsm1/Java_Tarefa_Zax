import entities.Loja;
import entities.Motoboy;
import entities.Pedido;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        String motoboyInformado;
        Scanner sc = new Scanner(System.in);
        Loja loja1 = new Loja("Loja 1", 0.05);
        Loja loja2 = new Loja("Loja 2", 0.05);
        Loja loja3 = new Loja("Loja 3", 0.15);

        List<Motoboy> motoboys = Arrays.asList(
                new Motoboy("Moto 1", 2),
                new Motoboy("Moto 2", 2),
                new Motoboy("Moto 3", 2),
                new Motoboy("Moto 4", 2, loja1),
                new Motoboy("Moto 5", 3)
        );

        List<Pedido> pedidosLoja1 = Arrays.asList(
                new Pedido(1, loja1, 50.0),
                new Pedido(2, loja1, 50.0),
                new Pedido(3, loja1, 50.0)
        );

        List<Pedido> pedidosLoja2 = Arrays.asList(
                new Pedido(1, loja2, 50.0),
                new Pedido(2, loja2, 50.0),
                new Pedido(3, loja2, 50.0),
                new Pedido(4, loja2, 50.0)
        );

        List<Pedido> pedidosLoja3 = Arrays.asList(
                new Pedido(1, loja3, 50.0),
                new Pedido(2, loja3, 50.0),
                new Pedido(3, loja3, 100.0)
        );

        loja1.getPedidos().addAll(pedidosLoja1);
        loja2.getPedidos().addAll(pedidosLoja2);
        loja3.getPedidos().addAll(pedidosLoja3);

        motoboys.get(3).getPedidos().addAll(pedidosLoja1.subList(0, 2)); //Motoboy 4 pega 2 pedidos da loja 1 por ter exclusividade
        motoboys.get(0).getPedidos().add(pedidosLoja1.get(2));
        motoboys.get(0).getPedidos().add(pedidosLoja2.get(0));
        motoboys.get(1).getPedidos().addAll(pedidosLoja2.subList(1, 3));
        motoboys.get(2).getPedidos().add(pedidosLoja2.get(3));
        motoboys.get(2).getPedidos().add(pedidosLoja3.get(0));
        motoboys.get(4).getPedidos().addAll(pedidosLoja3.subList(1, 3));

        List<String> nomesMotoboys = motoboys.stream().map(Motoboy::getNome).collect(Collectors.toList());

        System.out.print("Informe o nome do Motoboy ou aperte Enter para exibir todos: ");
        motoboyInformado = sc.nextLine();

        if (nomesMotoboys.contains(motoboyInformado)) {
            Motoboy motoboy = motoboys.stream().filter(x -> x.getNome().equals(motoboyInformado)).findFirst().get();
            motoboy.relacaoPedidos();
        } else {
            System.out.println("                Relacao Geral de Pedidos                ");
            motoboys.forEach(Motoboy::relacaoPedidos);
        }
    }
}
