import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaColonias {
    private static List<ModuloHabitacional> modulos = new ArrayList<>();
    private static List<Habitante> habitantes = new ArrayList<>();
    private static List<Recurso> recursos = new ArrayList<>();
    private static List<Pesquisa> pesquisas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Gerenciamento de Colônias Submarinas ===");
            System.out.println("1. Cadastrar Módulo Habitacional");
            System.out.println("2. Cadastrar Habitante");
            System.out.println("3. Cadastrar Recurso");
            System.out.println("4. Cadastrar Pesquisa");
            System.out.println("5. Listar Módulos");
            System.out.println("6. Listar Habitantes");
            System.out.println("7. Listar Recursos");
            System.out.println("8. Listar Pesquisas");
            System.out.println("9. Associar Habitante a Módulo");
            System.out.println("10. Associar Pesquisa a Módulo");
            System.out.println("11. Associar Recurso a Módulo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarModulo(scanner);
                    break;
                case 2:
                    cadastrarHabitante(scanner);
                    break;
                case 3:
                    cadastrarRecurso(scanner);
                    break;
                case 4:
                    cadastrarPesquisa(scanner);
                    break;
                case 5:
                    listarModulos();
                    break;
                case 6:
                    listarHabitantes();
                    break;
                case 7:
                    listarRecursos();
                    break;
                case 8:
                    listarPesquisas();
                    break;
                    case 9:
                    associarHabitanteAModulo(scanner);
                    break;
                case 10:
                    associarPesquisaAModulo(scanner);
                    break;
                case 11:
                    associarRecursoAModulo(scanner);
                    break;
                    
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarModulo(Scanner scanner) {
        System.out.print("ID do módulo: ");
        String id = scanner.nextLine();
        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();
        System.out.print("Capacidade: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Finalidade (Habitação, Laboratório, Armazenamento): ");
        String finalidade = scanner.nextLine();

        modulos.add(new ModuloHabitacional(id, localizacao, capacidade, finalidade));
        System.out.println("Módulo cadastrado com sucesso!");
    }

    private static void cadastrarHabitante(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Função (Cientista, Engenheiro, Técnico): ");
        String funcao = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        habitantes.add(new Habitante(nome, idade, funcao, especialidade));
        System.out.println("Habitante cadastrado com sucesso!");
    }

    private static void cadastrarRecurso(Scanner scanner) {
        System.out.print("Tipo (Oxigênio, Energia, Comida, Água): ");
        String tipo = scanner.nextLine();
        System.out.print("Nível Atual: ");
        int nivelAtual = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        recursos.add(new Recurso(tipo, nivelAtual));
        System.out.println("Recurso cadastrado com sucesso!");
    }

    private static void cadastrarPesquisa(Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Equipe: ");
        String equipe = scanner.nextLine();
        System.out.print("Duração Estimada (em dias): ");
        int duracaoEstimada = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Status (Planejada, Em andamento, Concluída): ");
        String status = scanner.nextLine();

        pesquisas.add(new Pesquisa(titulo, equipe, duracaoEstimada, status));
        System.out.println("Pesquisa cadastrada com sucesso!");
    }

    private static void listarModulos() {
        if (modulos.isEmpty()) {
            System.out.println("Nenhum módulo cadastrado.");
        } else {
            System.out.println("\n=== Lista de Módulos Habitacionais ===");
            for (ModuloHabitacional modulo : modulos) {
                System.out.println(modulo);
            }
        }
    }

    private static void listarHabitantes() {
        if (habitantes.isEmpty()) {
            System.out.println("Nenhum habitante cadastrado.");
        } else {
            System.out.println("\n=== Lista de Habitantes ===");
            for (Habitante habitante : habitantes) {
                System.out.println(habitante);
            }
        }
    }

    private static void listarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("Nenhum recurso cadastrado.");
        } else {
            System.out.println("\n=== Lista de Recursos ===");
            for (Recurso recurso : recursos) {
                System.out.println(recurso);
            }
        }
    }

    private static void listarPesquisas() {
        if (pesquisas.isEmpty()) {
            System.out.println("Nenhuma pesquisa cadastrada.");
        } else {
            System.out.println("\n=== Lista de Pesquisas ===");
            for (Pesquisa pesquisa : pesquisas) {
                System.out.println(pesquisa);
            }
        }
    }

    private static void associarHabitanteAModulo(Scanner scanner) {
        System.out.print("ID do módulo: ");
        String idModulo = scanner.nextLine();
        ModuloHabitacional modulo = encontrarModuloPorId(idModulo);
    
        if (modulo == null) {
            System.out.println("Erro: Módulo não encontrado.");
            return;
        }
    
        System.out.print("Nome do habitante: ");
        String nome = scanner.nextLine();
        Habitante habitante = encontrarHabitantePorNome(nome);
    
        if (habitante == null) {
            System.out.println("Erro: Habitante não encontrado.");
            return;
        }
    
        if (modulo.adicionarHabitante(habitante)) {
            System.out.println("Habitante associado ao módulo com sucesso!");
        }
    }
    
    private static void associarPesquisaAModulo(Scanner scanner) {
        System.out.print("ID do módulo: ");
        String idModulo = scanner.nextLine();
        ModuloHabitacional modulo = encontrarModuloPorId(idModulo);
    
        if (modulo == null) {
            System.out.println("Erro: Módulo não encontrado.");
            return;
        }
    
        System.out.print("Título da pesquisa: ");
        String titulo = scanner.nextLine();
        Pesquisa pesquisa = encontrarPesquisaPorTitulo(titulo);
    
        if (pesquisa == null) {
            System.out.println("Erro: Pesquisa não encontrada.");
            return;
        }
    
        if (modulo.adicionarPesquisa(pesquisa)) {
            System.out.println("Pesquisa associada ao módulo com sucesso!");
        }
    }
    
    private static void associarRecursoAModulo(Scanner scanner) {
        System.out.print("ID do módulo: ");
        String idModulo = scanner.nextLine();
        ModuloHabitacional modulo = encontrarModuloPorId(idModulo);
    
        if (modulo == null) {
            System.out.println("Erro: Módulo não encontrado.");
            return;
        }
    
        System.out.print("Tipo do recurso: ");
        String tipo = scanner.nextLine();
        Recurso recurso = encontrarRecursoPorTipo(tipo);
    
        if (recurso == null) {
            System.out.println("Erro: Recurso não encontrado.");
            return;
        }
    
        if (modulo.adicionarRecurso(recurso)) {
            System.out.println("Recurso associado ao módulo com sucesso!");
        }
    }
    
    private static ModuloHabitacional encontrarModuloPorId(String id) {
        for (ModuloHabitacional modulo : modulos) {
            if (modulo.getId().equalsIgnoreCase(id)) {
                return modulo;
            }
        }
        return null;
    }
    
    private static Habitante encontrarHabitantePorNome(String nome) {
        for (Habitante habitante : habitantes) {
            if (habitante.toString().contains(nome)) {
                return habitante;
            }
        }
        return null;
    }
    
    private static Pesquisa encontrarPesquisaPorTitulo(String titulo) {
        for (Pesquisa pesquisa : pesquisas) {
            if (pesquisa.getTitulo().equalsIgnoreCase(titulo)) {
                return pesquisa;
            }
        }
        return null;
    }
    
    private static Recurso encontrarRecursoPorTipo(String tipo) {
        for (Recurso recurso : recursos) {
            if (recurso.getTipo().equalsIgnoreCase(tipo)) {
                return recurso;
            }
        }
        return null;
    }
    
}

