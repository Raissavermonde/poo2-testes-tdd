import java.math.BigDecimal;
import java.math.RoundingMode;

public class Compra {
    private static final BigDecimal VALOR_MINIMO_PARA_DESCONTO = new BigDecimal("100.00");
    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.10");
    private static final BigDecimal SEM_DESCONTO = new BigDecimal("0.00");

    public BigDecimal calcularDesconto(BigDecimal valor) {
        validarValor(valor);
        if (temDireitoADesconto(valor)) {
            return valor.multiply(PERCENTUAL_DESCONTO).setScale(2, RoundingMode.HALF_UP);
        }
        return SEM_DESCONTO;
    }

    private void validarValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor da compra não pode ser negativo");
        }
    }

    private boolean temDireitoADesconto(BigDecimal valor) {
        return valor.compareTo(VALOR_MINIMO_PARA_DESCONTO) >= 0;
    }
}