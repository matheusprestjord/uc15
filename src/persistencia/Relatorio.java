package persistencia;

import java.time.LocalDate;

public class Relatorio {
    // Atributos
    private int id;
    private String tipoRelatorio;
    private LocalDate dataGeracao;
    private String descricao;

    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int _id) {
        this.id = _id;
    }

    public String getTipoRelatorio() {
        return tipoRelatorio;
    }
    public void setTipoRelatorio(String _tipoRelatorio) {
        this.tipoRelatorio = _tipoRelatorio;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }
    public void setDataGeracao(LocalDate _dataGeracao) {
        this.dataGeracao = _dataGeracao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String _descricao) {
        this.descricao = _descricao;
    }
}
