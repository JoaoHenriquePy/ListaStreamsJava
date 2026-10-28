import java.util.Arrays;
import java.util.List;

public class Questao07 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("computador", "java", "sistema", "sol", "programacao");
        
        long total = palavras.stream()
                .filter(p -> p.length() > 5)
                .count();
                
        System.out.println("Quantidade de palavras com mais de 5 letras: " + total);
    }
}
