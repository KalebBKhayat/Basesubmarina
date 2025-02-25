import java.util.ArrayList;
import java.util.List;

public class ModuloHabitacional {
    private String id;
    private String localizacao;
    private int capacidade;
    private String finalidade; // Habitação, Laboratório, Armazenamento

    private List<Habitante> habitantes = new ArrayList<>();
    private List<Pesquisa> pesquisas = new ArrayList<>();
    private List<Recurso> recursos = new ArrayList<>();

    public ModuloHabitacional(String id, String localizacao, int capacidade, String finalidade) {
        this.id = id;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.finalidade = finalidade;
    }

    public String getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public boolean adicionarHabitante(Habitante habitante) {
        if (!finalidade.equalsIgnoreCase("Habitação")) {
            System.out.println("Erro: Este módulo não permite habitantes.");
            return false;
        }
        if (habitantes.size() >= capacidade) {
            System.out.println("Erro: Capacidade máxima do módulo atingida.");
            return false;
        }
        habitantes.add(habitante);
        return true;
    }

    public boolean adicionarPesquisa(Pesquisa pesquisa) {
        if (!finalidade.equalsIgnoreCase("Laboratório")) {
            System.out.println("Erro: Este módulo não permite pesquisas.");
            return false;
        }
        pesquisas.add(pesquisa);
        return true;
    }

    public boolean adicionarRecurso(Recurso recurso) {
        if (!finalidade.equalsIgnoreCase("Armazenamento")) {
            System.out.println("Erro: Este módulo não permite recursos.");
            return false;
        }
        recursos.add(recurso);
        return true;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Localização: " + localizacao + ", Capacidade: " + capacidade + ", Finalidade: " + finalidade +
               "\nHabitantes: " + habitantes.size() + "/" + capacidade +
               ", Pesquisas: " + pesquisas.size() + ", Recursos: " + recursos.size();
    }
}

