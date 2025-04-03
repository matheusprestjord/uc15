package persistencia;

public class Cliente {
    // Atributos
    private int id;
    private String cpf;
    private String nome;
    private int pontos;
    
    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    
    // Métodos
    public void acumularPontos() { }
    public void consultarPontos() { }
    public void trocarPontos() { }
}
