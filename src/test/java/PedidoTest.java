import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    // STUB: implementação falsa e fixa do serviço de frete.
    // Só fornece uma resposta pronta; o teste verifica o ESTADO (o resultado).
    @Test
    void calculaTotalUsandoStubDeFrete() {
        ServicoFrete freteStub = cep -> new BigDecimal("20.00");
        Pedido pedido = new Pedido(freteStub);

        BigDecimal total = pedido.calcularTotal(new BigDecimal("100.00"), "85950-000");

        assertEquals(new BigDecimal("120.00"), total);
    }

    // MOCK (Mockito): além de devolver uma resposta programada,
    // permite verificar o COMPORTAMENTO (se o serviço foi chamado e com qual CEP).
    @Test
    void consultaServicoDeFreteComOCepInformado() {
        ServicoFrete freteMock = mock(ServicoFrete.class);
        when(freteMock.calcularFrete("85950-000")).thenReturn(new BigDecimal("20.00"));
        Pedido pedido = new Pedido(freteMock);

        BigDecimal total = pedido.calcularTotal(new BigDecimal("100.00"), "85950-000");

        assertEquals(new BigDecimal("120.00"), total);
        verify(freteMock).calcularFrete("85950-000");
    }
}