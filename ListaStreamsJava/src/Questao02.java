import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Questao02 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("pedro", "ana", "jose", "maria");
        
        List<String> resultado = nomes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
                
        System.out.println(resultado);
    }
}
