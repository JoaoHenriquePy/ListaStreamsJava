import java.util.Arrays;
import java.util.List;

public class Questao06 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(10, 50, 3, 99, 25);
        
        int maior = lista.stream()
                .max(Integer::compareTo)
                .orElse(0);
                
        System.out.println("Maior numero: " + maior);
    }
}
