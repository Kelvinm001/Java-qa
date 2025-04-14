## Descrição do erro
Este erro ocorre quando a aplicação Java não consegue estabelecer uma conexão com o banco de dados MySQL via JDBC. Isso pode ocorrer por vários motivos, como servidor MySQL inativo, endereço incorreto, porta bloqueada, entre outros.

---

##  Testes de Caixa Preta

**Objetivo:** Validar o comportamento do sistema sem analisar o código-fonte.

### Teste 1: Servidor MySQL desligado
- **Pré-condição:** MySQL desligado.
- **Ação:** Iniciar a aplicação e tentar uma operação que envolva o banco.
- **Resultado esperado:** Erro de comunicação exibido corretamente ao usuário/log.

### Teste 2: URL de conexão inválida
- **Pré-condição:** URL configurada incorretamente (ex: IP errado).
- **Ação:** Rodar a aplicação.
- **Resultado esperado:** Sistema retorna erro de falha na conexão.

### Teste 3: Porta do banco bloqueada por firewall
- **Pré-condição:** Bloqueio da porta 3306.
- **Ação:** Tentar conectar ao banco.
- **Resultado esperado:** Mesma exceção deve ser lançada, registrada e tratada.

---

##  Testes de Caixa Branca

**Objetivo:** Validar o fluxo interno do código, incluindo o uso da biblioteca JDBC.

### Teste 4: Verificação da construção da URL de conexão
- **Código a testar:**
  ```java
  String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
