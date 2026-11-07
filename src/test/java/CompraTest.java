import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompraTest {

    private Compra compra;

    // Fixture: executado antes de cada teste, garante uma Compra nova e independente.
    @BeforeEach
    void setUp() {
        compra = new Compra();
    }

    @Test
    void compraDe80NaoTemDesconto() {
        assertEquals(new BigDecimal("0.00"), compra.calcularDesconto(new BigDecimal("80.00")));
    }

    @Test
    void compraDe100TemDescontoDe10Porcento() {
        assertEquals(new BigDecimal("10.00"), compra.calcularDesconto(new BigDecimal("100.00")));
    }

    @Test
    void compraDe150TemDescontoDe10Porcento() {
        assertEquals(new BigDecimal("15.00"), compra.calcularDesconto(new BigDecimal("150.00")));
    }

    @Test
    void valorNegativoLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
            () -> compra.calcularDesconto(new BigDecimal("-10.00")));
    }
}