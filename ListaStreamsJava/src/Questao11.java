import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Questao11 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("sol", "lua", "casa", "carro", "computador");
        
        Map<Integer, List<String>> agrupado = palavras.stream()
                .collect(Collectors.groupingBy(String::length));
                
        System.out.println(agrupado);
    }
}
