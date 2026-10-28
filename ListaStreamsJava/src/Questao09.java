import java.util.Arrays;
import java.util.List;

public class Questao09 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 12, 8, 30);
        
        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);
                
        System.out.println("Todos os elementos sao positivos? " + todosPositivos);
    }
}
