public class Recurso {
    private String tipo; // Oxigênio, Energia, Comida, Água
    private int nivelAtual;

    public Recurso(String tipo, int nivelAtual) {
        this.tipo = tipo;
        this.nivelAtual = nivelAtual;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void consumir(int quantidade) {
        this.nivelAtual = Math.max(0, nivelAtual - quantidade);
    }

    public void reabastecer(int quantidade) {
        this.nivelAtual += quantidade;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nível Atual: " + nivelAtual;
    }
}
