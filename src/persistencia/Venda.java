package persistencia;

import java.util.Date;

public class Venda {
    // Atributos
    private int id;
    private int itensVendidos;
    private float valorTotal;
    private Date dataVenda;
    
    // Construtor
    public Venda(int _id, int _itensVendidos, float _valorTotal, Date _dataVenda) {
        this.id = _id;
        this.itensVendidos = _itensVendidos;
        this.valorTotal = _valorTotal;
        this.dataVenda = _dataVenda;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    public int getItensVendidos() {
        return itensVendidos;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public Date getDataVenda() {
        return dataVenda;
    }
    
    // Setters
    public void setId(int _id) {
        this.id = _id;
    }
    public void setItensVendidos(int _itensVendidos) {
        this.itensVendidos = _itensVendidos;
    }
    public void setValorTotal(float _valorTotal) {
        this.valorTotal = _valorTotal;
    }
    public void setDataVenda(Date _dataVenda) {
        this.dataVenda = _dataVenda;
    }
    
    // Métodos
    public void registrarVenda() { }
    //public float calcularTotal() {  }
    public void gerarRecibo() { }
}
