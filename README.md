<h1 align="center">📚 BookClub API</h1>

<p align="center">
  <em>API RESTful para gestão de membros e livros em um clube de leitura.</em><br>
  <strong>Projeto em desenvolvimento</strong> — criado com foco em estudo e preparação para desafios técnicos práticos em Java + Spring Boot.
</p>

---

## 🎯 Objetivo do Projeto

O **BookClub API** tem como objetivo simular o funcionamento de um clube de leitura digital, onde é possível gerenciar **membros** (usuários cadastrados) e **livros** disponíveis para empréstimo.

A aplicação permite que cada membro possua um **tipo de associação** (`REGULAR` ou `PREMIUM`) e que cada livro tenha um **status de disponibilidade** (`AVAILABLE` ou `BORROWED`).  
O projeto serve como laboratório prático para consolidar conceitos de **APIs RESTful**, **JPA/Hibernate**, **validações**, **autenticações**, **relacionamentos entre entidades**, **boas práticas de código** e **estruturação de camadas** no Spring Boot.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** - Web, Data JPA, Validation
- **H2 Database** - Banco em memória para testes
- **Jakarta Validation** - Validação de dados de entrada nas requisições
- **Gradle** - Gerenciador de dependências e build automation
- **Postman / Insomnia** - Testes das requisições

---

## 🧠 Principais Funcionalidades (em andamento)

- Cadastro, listagem e gerenciamento de **membros**
- Cadastro, listagem e gerenciamento de **livros**
- Relacionamento entre membros e livros (`OneToMany` / `ManyToOne`)
- Validações personalizadas com **Jakarta Validation**
- Integração com **banco de dados H2**
- Estrutura modular de projeto (`model`, `dto`, `repository`, `service`, `controller`)
- Controle de status de livros (disponível / emprestado)

---

## 📂 Estrutura do Projeto
- src
    - main
        - java
            - com
                - example
                    - bookclub
                        - controller
                        - dto
                        - exception
                        - model
                        - repository
                        - service
                        - BookclubApplication.java
    - test
        - java
            - com
                - example
                    - bookclub
                        - controller
                            - BookControllerTest.java
                            - MemberControllerTest.java
                        - service
                            - BookServiceTest.java
                            - MemberServiceTest.java

---


---

## 🚧 Status do Projeto

> 🧩 **Em desenvolvimento ativo**

O projeto está em construção e novas funcionalidades estão sendo implementadas gradualmente conforme o roteiro de estudos e práticas do hackathon.

---

## 🔮 Implementações Futuras

- 🔐 Autenticação e autorização de usuários (Spring Security + JWT)
- 📘 Documentação completa com **Swagger/OpenAPI**
- 🧪 Testes unitários e de integração (JUnit + Mockito)
- 🧾 Tratamento global de exceções (Exception Handler)
- ⚙️ Logs e monitoramento
- 💾 Migração para banco de dados PostgreSQL
- 👤 Criação de perfis de acesso (Admin / Membro)

---

## 🚀 Como Executar o Projeto Localmente

```bash
# Clone este repositório
git clone https://github.com/<seu-usuario>/bookclub.git

# Acesse o diretório do projeto
cd bookclub

# Execute o projeto com Gradle
./gradlew bootRun

# Acesse o H2 Database (console)
http://localhost:8080/h2-console
```

--- 
## 🧑‍💻 Autor

**Desenvolvido por Bernardo Sá. Conecte-se comigo!**

- [LinkedIn](https://www.linkedin.com/in/bernardosa01/)