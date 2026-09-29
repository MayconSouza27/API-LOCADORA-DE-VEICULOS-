# 🚗 API Locadora de Veículos

API RESTful desenvolvida para gestão e checklist de uma locadora de veículos, permitindo o controlo de carros, clientes, gestão de alugueres e devoluções.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 3
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Base de Dados:** H2 Database / PostgreSQL
- **Migrações:** Flyway
- **Build Tool:** Maven
- **Documentação:** Swagger / OpenAPI

---

## 📋 Funcionalidades Principalmente Mapeadas

- [x] Cadastro e gestão de veículos.
- [x] Controle de disponibilidade e estado dos veículos (DISPONÍVEL, ALUGADO, EM MANUTENÇÃO).
- [ ] Regras de negócio de reservas e devoluções com checklists de vistoria.
- [ ] Autenticação e segurança com Spring Security e JWT.

---

## 📑 Exemplo de Payload (JSON)

```json
{
  "id": 1,
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2023,
  "placa": "XYZ-5678",
  "categoria": "SEDAN",
  "valorDiaria": 180.00,
  "status": "DISPONIVEL"
}
