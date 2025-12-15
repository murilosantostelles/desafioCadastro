# 🐾 Sistema de Gerenciamento de Pets (Java CLI)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-green?style=for-the-badge)

## 💻 Sobre o projeto

Este é um sistema completo de cadastro e gerenciamento de animais (CRUD), desenvolvido puramente em **Java**, rodando via terminal (Console).

O diferencial técnico deste projeto é a **persistência de dados manual**: ao invés de usar um banco de dados tradicional, o sistema gerencia a criação, leitura, atualização e exclusão de arquivos de texto (`.txt`), simulando um banco de dados real através da manipulação de arquivos (File I/O).

## 🛠 Tecnologias e Conceitos Aplicados

- **Java:** Linguagem base.
- **Java I/O:** Manipulação avançada de arquivos (`FileWriter`, `BufferedReader`, `File`) para persistência de dados.
- **Regex (Expressões Regulares):** Utilizado para validação forte de dados (ex: impedir números no nome, formatar entradas decimais).
- **POO (Programação Orientada a Objetos):**
  - **Encapsulamento** (Getters/Setters e proteção de dados).
  - **Enums** (Para tipagem forte de `PetType` e `PetGender`).
  - **Composição** (Separação da classe `PetAddress`).

## ✨ Funcionalidades Principais

### 1. Cadastro Dinâmico (Create)
- O sistema lê um template de perguntas (`formulario.txt`) para guiar o usuário.
- **Validações:** O sistema impede entradas inválidas (ex: idades negativas, caracteres especiais em nomes) utilizando tratamento de exceções.
- **Geração de Arquivos:** Cada pet gera um arquivo único. O nome do arquivo utiliza um **Timestamp** (`yyyyMMdd-THHmm`) para garantir que nunca haja conflito de nomes duplicados.

### 2. Motor de Busca e Filtros (Read)
O sistema carrega os arquivos em memória e permite filtrar os resultados por:
- [x] Nome ou Sobrenome
- [x] Sexo (Macho/Fêmea)
- [x] Faixa de Idade ou Peso
- [x] Raça e Localização (Cidade/Rua)
- [x] **Filtros Combinados:** Busca simultânea (ex: "Nome" + "Idade").

### 3. Atualização e Remoção (Update/Delete)
- **Edição:** Permite alterar campos específicos (como peso ou endereço) e reescreve o arquivo original mantendo a integridade.
- **Exclusão:** Remove permanentemente o registro do diretório.

## 📂 Estrutura do Código

O projeto segue uma arquitetura organizada em pacotes:

| Pacote | Responsabilidade |
|:--- |:--- |
| `main` | Ponto de entrada e loop principal do sistema. |
| `pet` | Classes de modelo (`Pet`, `Address`) e Enums. |
| `services` | Regras de negócio, lógica de CRUD (`PetStorage`) e menus. |
| `formreader` | Utilitário responsável por ler o template de perguntas. |

## 🚀 Como executar

1. Certifique-se de ter o **Java (JDK)** instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone (https://github.com/murilosantostelles/desafioCadastro.git)
