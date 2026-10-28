import java.util.Arrays;
import java.util.List;

class Pedido {
    int id;
    double valor;

    public Pedido(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

public class Questao10 {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1, 150.0),
                new Pedido(2, 250.0),
                new Pedido(3, 100.0)
        );

        double total = pedidos.stream()
                .mapToDouble(Pedido::getValor)
                .sum();

        System.out.println("Valor total dos pedidos: " + total);
    }
}
