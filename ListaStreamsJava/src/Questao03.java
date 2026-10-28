import java.util.Arrays;
import java.util.List;

public class Questao03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        numeros.stream()
                .forEach(n -> System.out.println(n * 2));
    }
}
