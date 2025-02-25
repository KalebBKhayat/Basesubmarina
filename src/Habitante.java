public class Habitante {
    private String nome;
    private int idade;
    private String funcao; // Cientista, Engenheiro, Técnico
    private String especialidade;

    public Habitante(String nome, int idade, String funcao, String especialidade) {
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Função: " + funcao + ", Especialidade: " + especialidade;
    }
}

