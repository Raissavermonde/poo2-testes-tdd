import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    // Tolerância para comparar valores double (evita erros de arredondamento).
    private static final double DELTA = 0.0001;

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // ---------- somar() ----------

    @Test
    void somarDoisPositivos() {
        assertEquals(5.0, calculadora.somar(2.0, 3.0), DELTA);
    }

    @Test
    void somarDoisNegativos() {
        assertEquals(-5.0, calculadora.somar(-2.0, -3.0), DELTA);
    }

    @Test
    void somarComZero() {
        assertEquals(7.0, calculadora.somar(7.0, 0.0), DELTA);
    }

    @Test
    void somarPositivoComNegativo() {
        assertEquals(-3.0, calculadora.somar(5.0, -8.0), DELTA);
    }

    // ---------- dividir() ----------

    @Test
    void dividirComResultadoExato() {
        assertEquals(5.0, calculadora.dividir(10.0, 2.0), DELTA);
    }

    @Test
    void dividirComResultadoDecimal() {
        assertEquals(3.3333, calculadora.dividir(10.0, 3.0), DELTA);
    }

    @Test
    void dividirZeroPorNumero() {
        assertEquals(0.0, calculadora.dividir(0.0, 5.0), DELTA);
    }

    @Test
    void dividirPorZeroLancaExcecao() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10.0, 0.0));
    }    @Test
    void dividirZeroPorZeroLancaExcecao() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(0.0, 0.0));
    }
}