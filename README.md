# OdontoVision API

API RESTful desenvolvida em **Java Spring Boot** para gestão de **gamificação odontológica**, permitindo o controle de **usuários, planos odontológicos, consultas, diagnósticos, pontuações, conquistas, recompensas** e mais.

#### link do vídeo: https://youtu.be/zl-xSMVa724

---
## 👥 Equipe Integrantes

- **553568** Sabrina da Motta Café
- **552692** Luís Henrique Oliveira Da Silva
- **554199** Matheus Duarte Oliveira

---

## 📉 Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Spring Validation (Jakarta Bean Validation)
- Spring HATEOAS (Nível 3 de maturidade)
- OpenAPI 3.0 (Swagger)
- Banco de Dados: compatível com Oracle
- Maven
- Rabbitmq

---

## 🚀 Como Rodar o Projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/odontovision-api.git

# Acesse a pasta do projeto
cd odontovision-api

# Rode o projeto
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

---

## 🔖 Documentação Swagger

Depois de rodar o projeto, acesse:

```
http://localhost:8080/swagger-ui.html
```

Explore todos os endpoints de maneira visual!

---

## 📆 Estrutura do Projeto

```
com.odontovision.Java_API
├── controller
├── service
│   ├── impl
├── dto
├── entity
├── repository
├── mapper
├── config
├── exception
```

---

## 🔥 Endpoints Disponíveis

### Usuários

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/usuarios` | Criar novo usuário |
| PUT | `/api/usuarios/{id}` | Atualizar usuário existente |
| DELETE | `/api/usuarios/{id}` | Deletar usuário |
| GET | `/api/usuarios/{id}` | Buscar usuário por ID |
| GET | `/api/usuarios` | Listar todos os usuários cadastrados |

### Planos Odontológicos

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/planos` | Criar um novo plano odontológico |
| PUT | `/api/planos/{id}` | Atualizar um plano odontológico |
| DELETE | `/api/planos/{id}` | Deletar um plano odontológico |
| GET | `/api/planos/{id}` | Buscar um plano odontológico por ID |
| GET | `/api/planos` | Listar todos os planos odontológicos |

### Consultas

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/consultas` | Criar nova consulta |
| PUT | `/api/consultas/{id}` | Atualizar dados da consulta |
| DELETE | `/api/consultas/{id}` | Deletar consulta |
| GET | `/api/consultas/{id}` | Buscar consulta por ID |
| GET | `/api/consultas` | Listar todas as consultas agendadas |

### Diagnósticos

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/diagnosticos` | Criar novo diagnóstico |
| PUT | `/api/diagnosticos/{id}` | Atualizar diagnóstico existente |
| DELETE | `/api/diagnosticos/{id}` | Deletar diagnóstico |
| GET | `/api/diagnosticos/{id}` | Buscar diagnóstico por ID |
| GET | `/api/diagnosticos` | Listar todos os diagnósticos |

### Checklist Diário

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/checklists` | Criar novo checklist diário |
| PUT | `/api/checklists/{id}` | Atualizar checklist diário |
| DELETE | `/api/checklists/{id}` | Deletar checklist diário |
| GET | `/api/checklists/{id}` | Buscar checklist diário por ID |
| GET | `/api/checklists` | Listar todos os checklists diários |

### Pontuações

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/pontuacoes/usuario/{id}` | Listar pontuações de um usuário |
| GET | `/api/pontuacoes` | Listar todas as pontuações do sistema |

### Conquistas

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/conquistas` | Listar todas as conquistas |

### Recompensas

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/recompensas` | Listar todas as recompensas |

### Níveis

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/niveis` | Listar todos os níveis |

### Status das Consultas

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/status-consultas` | Listar todos os status de consultas |

### Tipos de Consultas

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| GET | `/api/tipos-consulta` | Listar todos os tipos de consulta |

### Resgate de Recompensas (UsuarioRecompensa)

| Método HTTP | Caminho | Ação |
| --- | --- | --- |
| POST | `/api/usuario-recompensas` | Criar novo resgate de recompensa |
| DELETE | `/api/usuario-recompensas/{id}` | Deletar resgate de recompensa |
| GET | `/api/usuario-recompensas/{id}` | Buscar resgate de recompensa por ID |
| GET | `/api/usuario-recompensas` | Listar todos os resgates |

---

## 🚧 Tratamento de Erros

| Código | Significado | Descrição |
| --- | --- | --- |
| 400 | Bad Request | Erro de validação ou requisição inválida |
| 404 | Not Found | Recurso não encontrado |
| 500 | Internal Server Error | Erro inesperado no servidor |

---

# 🚀 OdontoVision API - **Transformando a Odontologia através da Tecnologia!**

