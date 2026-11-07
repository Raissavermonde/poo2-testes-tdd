import java.math.BigDecimal;

public class Pedido {
    private final ServicoFrete servicoFrete;

    // O serviço de frete é recebido pelo construtor (injeção de dependência).
    // Assim, no teste, podemos passar um serviço falso no lugar do real.
    public Pedido(ServicoFrete servicoFrete) {
        this.servicoFrete = servicoFrete;
    }

    public BigDecimal calcularTotal(BigDecimal valorProdutos, String cep) {
        BigDecimal frete = servicoFrete.calcularFrete(cep);
        return valorProdutos.add(frete);
    }
}