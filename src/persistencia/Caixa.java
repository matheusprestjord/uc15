package persistencia;

import java.util.List;

public class Caixa {
    // Atributos
    private float saldoAtual;
    private List<Venda> historicoTransacoes;
    
    // Desconto de 5% na venda total se estiver usando pix
    public double calcularDescontoPix(double _valor, boolean _pix) {
        if (_pix == true) {
            return _valor * 0.95;
        } else {
            return _valor;
        }
    }
}
