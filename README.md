# 📋 API de Tarefas - Spring Boot

## 📖 Descrição

API RESTful para gerenciamento de tarefas desenvolvida em Java com Spring Boot. Permite criar, listar, atualizar e remover tarefas com informações como nome, data de entrega e responsável.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## 📋 Funcionalidades

- ✅ Criar nova tarefa
- ✅ Listar todas as tarefas
- ✅ Buscar tarefa por ID
- ✅ Atualizar tarefa existente
- ✅ Remover tarefa específica
- ✅ Remover todas as tarefas

## 🛠️ Configuração e Execução

### Pré-requisitos

- Java 17 ou superior
- MySQL 8.0 ou superior
- Maven 3.6 ou superior

### Passos para execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/Guilhermemury/tarefas-api
   cd tarefas-api
   ```

2. **Configure o banco de dados**
   - Certifique-se que o MySQL está rodando
   - Crie o database (será criado automaticamente se não existir):
   ```sql
   CREATE DATABASE tarefas_db;
   ```

3. **Configure as credenciais** (se necessário)
   - Edite `src/main/resources/application.properties`
   - Ajuste username e password do MySQL

4. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a API**
   - URL base: `http://localhost:8080/api/tarefas`

## 📚 Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/tarefas` | Lista todas as tarefas |
| `GET` | `/api/tarefas/{id}` | Busca tarefa por ID |
| `POST` | `/api/tarefas` | Cria nova tarefa |
| `PUT` | `/api/tarefas/{id}` | Atualiza tarefa existente |
| `DELETE` | `/api/tarefas/{id}` | Remove tarefa específica |
| `DELETE` | `/api/tarefas` | Remove todas as tarefas |

## 📄 Estrutura da Tarefa

```json
{
  "id": 1,
  "nome": "Desenvolvimento da API",
  "responsavel": "Guilherme F. Mury - RU: 4551362",
  "dataEntrega": "2025-12-12"
}
```

## 🧪 Testando com Postman

### Criar Tarefa
```http
POST http://localhost:8080/api/tarefas
Content-Type: application/json

{
  "nome": "Desenvolvimento da API",
  "responsavel": "Guilherme F. Mury - RU: 4551362",
  "dataEntrega": "2025-12-12"
}
```

### Listar Tarefas
```http
GET http://localhost:8080/api/tarefas
```

### Atualizar Tarefa
```http
PUT http://localhost:8080/api/tarefas/1
Content-Type: application/json

{
  "nome": "Desenvolvimento da API - Atualizada",
  "responsavel": "Guilherme F. Mury - RU: 4551362",
  "dataEntrega": "2025-12-25"
}
```

### Remover Tarefa
```http
DELETE http://localhost:8080/api/tarefas/1
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── tarefas/
│   │               ├── TarefasApplication.java
│   │               ├── controller/
│   │               │   └── TarefaController.java
│   │               ├── model/
│   │               │   └── Tarefa.java
│   │               └── repository/
│   │                   └── TarefaRepository.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

## ⚙️ Configurações do Banco

O arquivo `application.properties` contém as configurações do banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefas_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

## 🎯 Trabalho Acadêmico

Este projeto foi desenvolvido para a disciplina de **Desenvolvimento Web Back End** da **UNINTER**.

### Testes Obrigatórios:
1. ✅ Inserir 3 tarefas (uma com nome do aluno e RU)
2. ✅ Listar todas as tarefas cadastradas
3. ✅ Atualizar a tarefa com nome do aluno
4. ✅ Excluir a tarefa com nome do aluno

## 📝 Licença

Este projeto é de uso acadêmico.

---

**Desenvolvido por:** Guilherme F. Mury  
**RU:** 4551362  
**Disciplina:** Desenvolvimento Web Back End - UNINTER