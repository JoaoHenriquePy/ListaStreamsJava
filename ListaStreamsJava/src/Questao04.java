import java.util.Arrays;
import java.util.List;

public class Questao04 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(4, 25, 32, 5, 45, 13, 8, 77, 58, 2, 52);
        
        long total = lista.stream()
                .filter(n -> n > 10)
                .count();
                
        System.out.println("Quantidade de numeros maiores que 10: " + total);
    }
}
