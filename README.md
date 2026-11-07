# POO II — Atividade avaliativa 03: Testes Automatizados e TDD

Raissa de Andrade Ribeiro — Licenciatura em Computação, UFPR Setor Palotina
Disciplina: Programação Orientada a Objetos II — Prof. José Lucas Errera Gomes

## Requisitos
- Java 17 ou superior
- Maven 3.8 ou superior

## Como executar os testes
Na pasta raiz do projeto:
```
mvn test
```
Resultado esperado: `Tests run: 14, Failures: 0` e `BUILD SUCCESS`.

## Estrutura
| Arquivo | Exercício | Conteúdo |
|---|---|---|
| `src/main/java/Calculadora.java` | 3 | somar e dividir, com exceção na divisão por zero |
| `src/test/java/CalculadoraTest.java` | 3 | 8 testes (JUnit 5, assertEquals com delta, assertThrows) |
| `src/main/java/Compra.java` | 4 | calcularDesconto, desenvolvido com TDD |
| `src/test/java/CompraTest.java` | 4 | 4 testes (R$ 80, R$ 100, R$ 150 e valor negativo) |
| `src/main/java/ServicoFrete.java`, `Pedido.java` | 5b | Pedido dependente de serviço externo de frete |
| `src/test/java/PedidoTest.java` | 5b | teste com stub e com mock (Mockito) |

## Ciclo TDD (Exercício 4)
O histórico de commits registra as etapas: `RED` → `GREEN (tentativa 1)` → `GREEN` → `REFACTOR`.
Para visualizar: `git log --oneline`