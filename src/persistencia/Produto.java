package persistencia;

import java.time.LocalDate;

public class Produto {
    // Atribtutos
    private int id;
    private String nome;
    private double quantidade;
    private double preco;
    private LocalDate dataValidade;
    
    // Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    // Setters
    public void setId(int _id) {
        this.id = _id;
    }
    public void setNome(String _nome) {
        this.nome = _nome;
    }
    public void setQuantidade(double _quantidade) {
        this.quantidade = _quantidade;
    }
    public void setPreco(double _preco) {
        this.preco = _preco;
    }
    public void setDataValidade(LocalDate _dataValidade) {
        this.dataValidade = _dataValidade;
    }
    
    // Métodos
    public void atualizarEstoque() { }
    public void registrarEstoque() { }
    public void consultarInformacoes() { }
    public void consultarQuantidade() { }
}
