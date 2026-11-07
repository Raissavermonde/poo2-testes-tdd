import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CompraTest {

    // Abaixo de R$ 100,00 não há desconto: o esperado é zero.
    @Test
    void compraDe80NaoTemDesconto() {
        Compra compra = new Compra();
        BigDecimal desconto = compra.calcularDesconto(new BigDecimal("80.00"));
        assertEquals(new BigDecimal("0.00"), desconto);
    }

    // Valor-limite: exatamente R$ 100,00 já ganha 10% (R$ 10,00).
    @Test
    void compraDe100TemDescontoDe10Porcento() {
        Compra compra = new Compra();
        BigDecimal desconto = compra.calcularDesconto(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("10.00"), desconto);
    }

    // Acima do limite: 10% de R$ 150,00 = R$ 15,00.
    @Test
    void compraDe150TemDescontoDe10Porcento() {
        Compra compra = new Compra();
        BigDecimal desconto = compra.calcularDesconto(new BigDecimal("150.00"));
        assertEquals(new BigDecimal("15.00"), desconto);
    }

    // Valor negativo não é uma compra válida: deve lançar exceção.
    @Test
    void valorNegativoLancaExcecao() {
        Compra compra = new Compra();
        assertThrows(IllegalArgumentException.class,
            () -> compra.calcularDesconto(new BigDecimal("-10.00")));
    }
}