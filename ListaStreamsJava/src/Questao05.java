import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Questao05 {
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Pedro", "Ana", "José", "Maria", "Antonia", "Augusto", "Carlos", "Francisco");
        
        List<String> resultado = lista.stream()
                .filter(nome -> nome.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
                
        System.out.println(resultado);
    }
}
