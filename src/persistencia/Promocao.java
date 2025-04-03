package persistencia;

import java.time.LocalDate;
import java.util.Date;

public class Promocao {
    // Atributos
    private int id;
    private String descricao;
    private Produto produtoRelacionado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    
    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int _id) {
        this.id = _id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String _descricao) {
        this.descricao = _descricao;
    }

    public Produto getProdutoRelacionado() {
        return produtoRelacionado;
    }
    public void setProdutoRelacionado(Produto _produtoRelacionado) {
        this.produtoRelacionado = _produtoRelacionado;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate _dataInicio) {
        this.dataInicio = _dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate _dataFim) {
        this.dataFim = _dataFim;
    }
    
    
    // Métodos
    public void gerarPromocao() { }
    public void aplicarDesconto() { }
    public void consultarPromocoes() { }
}
