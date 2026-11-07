import java.math.BigDecimal;

// Representa o serviço externo (ex.: API dos Correios).
// Por ser uma interface, o Pedido não depende da implementação real.
public interface ServicoFrete {
    BigDecimal calcularFrete(String cep);
}