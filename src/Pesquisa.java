public class Pesquisa {
    private String titulo;
    private String equipe;
    private int duracaoEstimada; // em dias
    private String status; // Planejada, Em andamento, Concluída

    public Pesquisa(String titulo, String equipe, int duracaoEstimada, String status) {
        this.titulo = titulo;
        this.equipe = equipe;
        this.duracaoEstimada = duracaoEstimada;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Equipe: " + equipe + ", Duração Estimada: " + duracaoEstimada + " dias, Status: " + status;
    }
}
