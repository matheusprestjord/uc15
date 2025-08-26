package persistencia;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteCaixaJUnit {
    
    @Test
    public void testCalcularDescontoPix_ComPix_DeveAplicarDesconto() {
        Caixa caixa = new Caixa();
        double resultado = caixa.calcularDescontoPix(100.0, true);
        assertEquals(95.0, resultado, 0.001);
    }
    
    @Test
    public void testCalcularDescontoPix_SemPix_NaoDeveAplicarDesconto() {
        Caixa caixa = new Caixa();
        double resultado = caixa.calcularDescontoPix(100.0, false);
        assertEquals(100.0, resultado, 0.001);
    }
    
    @Test
    public void testCalcularDescontoPix_ValorZero_ComPix() {
        Caixa caixa = new Caixa();
        double resultado = caixa.calcularDescontoPix(0.0, true);
        assertEquals(0.0, resultado, 0.001);
    }
}