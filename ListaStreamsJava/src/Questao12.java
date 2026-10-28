import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

enum TipoServico {
    ELETRICO,
    HIDRAULICO,
    ALVENARIA
}

class Servico {
    TipoServico tipo;
    double valor;

    public Servico(TipoServico tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}

class Autonomo {
    String nome;
    String cpf;
    List<Servico> listaServicos;

    public Autonomo(String nome, String cpf, List<Servico> listaServicos) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaServicos = listaServicos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }
}

public class Questao12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Autonomo> autonomos = new ArrayList<>();

        List<Servico> servicosJose = new ArrayList<>();
        servicosJose.add(new Servico(TipoServico.ELETRICO, 200.0));
        servicosJose.add(new Servico(TipoServico.ALVENARIA, 300.0));
        autonomos.add(new Autonomo("José", "123", servicosJose));

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n1 - Cadastrar Autonomo");
            System.out.println("2 - Cadastrar Servico");
            System.out.println("3 - Consultar Servicos por CPF");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            if (!scanner.hasNextInt()) break;
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                autonomos.add(new Autonomo(nome, cpf, new ArrayList<>()));
                System.out.println("Autonomo cadastrado com sucesso!");

            } else if (opcao == 2) {
                System.out.print("CPF do autonomo: ");
                String cpf = scanner.nextLine();

                Autonomo autonomo = autonomos.stream()
                        .filter(a -> a.getCpf().equals(cpf))
                        .findFirst()
                        .orElse(null);

                if (autonomo != null) {
                    System.out.println("Tipo (1-ELETRICO, 2-HIDRAULICO, 3-ALVENARIA): ");
                    int t = scanner.nextInt();
                    System.out.print("Valor: ");
                    double v = scanner.nextDouble();
                    scanner.nextLine();

                    TipoServico tipo = TipoServico.ELETRICO;
                    if (t == 2) tipo = TipoServico.HIDRAULICO;
                    if (t == 3) tipo = TipoServico.ALVENARIA;

                    autonomo.getListaServicos().add(new Servico(tipo, v));
                    System.out.println("Servico cadastrado com sucesso!");
                } else {
                    System.out.println("Autonomo nao encontrado!");
                }

            } else if (opcao == 3) {
                System.out.print("Digite o cpf: ");
                String cpfBusca = scanner.nextLine();

                Autonomo encontrado = autonomos.stream()
                        .filter(a -> a.getCpf().equals(cpfBusca))
                        .findFirst()
                        .orElse(null);

                if (encontrado != null) {
                    System.out.println("***********************");
                    System.out.println("Usuario: " + encontrado.getNome() + " - CPF:" + encontrado.getCpf());

                    encontrado.getListaServicos().stream().forEach(s -> {
                        System.out.println("   Serviço : " + s.getTipo() + "| Valor  R$: " + s.getValor());
                    });

                    double total = encontrado.getListaServicos().stream()
                            .mapToDouble(Servico::getValor)
                            .sum();

                    System.out.println("Total R$: " + total);
                    System.out.println("***********************");
                } else {
                    System.out.println("Autonomo nao encontrado!");
                }
            }
        }
        scanner.close();
    }
}
