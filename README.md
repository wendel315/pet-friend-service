# Pet Friends Project - CQRS/Event Sourcing

Projeto implementando CQRS e Event Sourcing usando Axon Framework para gerenciamento de Pedidos no contexto do Pet Friends.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.0
- Axon Framework 4.9.1
- Spring Data JPA
- H2 Database
- SpringDoc OpenAPI (Swagger)
- Maven

## Estrutura do Projeto

### Command Side
- `BaseCommand`: Classe base para todos os commands
- `CriarPedidoCommand`: Command específico para criação de pedidos
- `PedidoCommandService`: Serviço que utiliza CommandGateway
- `PedidoAggregate`: Agregado que processa commands e eventos

### Event Side
- `BaseEvent`: Classe base para todos os eventos
- `PedidoCriadoEvent`: Evento específico de criação de pedido
- `PedidoProjection`: Projection que persiste eventos no banco de dados

### Query Side
- `PedidoRepository`: JpaRepository para persistência
- `PedidoQueryService`: Serviço de consultas
- `PedidoEntity`: Entidade JPA para read model

### Controllers
- `PedidoCommandController`: Endpoints para executar commands
- `PedidoQueryController`: Endpoints para executar queries

## Como Executar

1. Clone o repositório
2. Execute o comando Maven:
```bash
mvn clean install
mvn spring-boot:run
```

## Endpoints Disponíveis

### Command
- `POST /api/pedidos` - Criar novo pedido

### Query
- `GET /api/pedidos` - Listar todos os pedidos
- `GET /api/pedidos/{pedidoId}` - Buscar pedido por ID

## Swagger UI

Acesse a documentação interativa da API em:
```
http://localhost:8080/swagger-ui.html
```

## H2 Console

Acesse o console do banco de dados H2 em:
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:petfriendsdb
Username: sa
Password: (deixe em branco)
```

## Exemplo de Requisição

```json
POST /api/pedidos
{
  "clienteId": "cliente-123",
  "petId": "pet-456",
  "descricao": "Banho e tosa",
  "valor": 150.00
}
```

