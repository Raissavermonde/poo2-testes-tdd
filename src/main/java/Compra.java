import java.math.BigDecimal;

public class Compra {
    public BigDecimal calcularDesconto(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor da compra não pode ser negativo");
        }
        if (valor.compareTo(new BigDecimal("100.00")) >= 0) {
            return valor.multiply(new BigDecimal("0.10"));
        }
        return new BigDecimal("0.00");
    }
}