# 📚 Sistema de Catálogo de Livros – Prova Prática

Este projeto foi desenvolvido para a Prova Prática de Desenvolvimento de Sistemas.  
A proposta consistia em criar um sistema web simples para cadastro e gerenciamento de livros e bibliotecários de uma biblioteca pública.

---

## ✅ Funcionalidades

- Cadastrar bibliotecários (nome e e-mail)
- Cadastrar livros (título, autor, gênero e status)
- Relacionar cada livro com um bibliotecário
- Listar, editar e excluir livros
- Alterar status do livro (Disponível, Emprestado, Reservado)
- Visual moderno com Tailwind CSS

---

## 🛠 Tecnologias Utilizadas

- Java 17 + Spring Boot
- MySQL
- HTML + Tailwind CSS
- JavaScript puro (Vanilla)
- Visual Studio Code

---

## 📁 Estrutura do Projeto

```plaintext
CatalogoLivros/
├── Diagrama biblioteca do BD/
│   ├── Diagrama Biblioteca BD.png
│   └── BibliotecaPROVACRUD.sql
├── Diagrama de uso/
│   └── Caso de uso Diagrama.png
├── Objetivo/
│   └── Prova Prática.pdf
├── src/
│   ├── main/
│   │   ├── database/banco.sql
│   │   ├── Interface/
│   │   │   ├── cadastro.html
│   │   │   ├── gerenciamento.html
│   │   │   └── assets/js/
│   │   │       ├── cadastro.js
│   │   │       └── gerenciamento.js
│   │   ├── java/com/example/CatalogoLivros/
│   │   │   ├── Controller/
│   │   │   ├── Model/
│   │   │   ├── Repository/
│   │   │   ├── Service/
│   │   │   └── CatalogoLivrosApplication.java
│   │   └── resources/application.properties
