
# 🏥 Projeto Clínica Médica

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-0000FF?style=for-the-badge&logo=h2&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## 📋 Descrição

O **Clínica Médica** é um sistema web desenvolvido com Spring Boot para gerenciar atendimentos em uma clínica médica. A aplicação permite o cadastro de médicos, pacientes, agendamentos e consultas de forma prática e eficiente.

## 🔧 Tecnologias Utilizadas

- **Spring Boot** – Framework Java para construção de aplicações robustas
- **Spring MVC** – Arquitetura baseada em Model-View-Controller
- **Spring Data JPA** – Abstração de persistência com JPA e Hibernate
- **Thymeleaf** – Template engine para renderização de páginas HTML
- **H2 Database** – Banco de dados em memória para testes e desenvolvimento
- **Maven** – Gerenciador de dependências e build

## 🗂️ Estrutura do Projeto

### 📁 Pacotes Java

```
com.ifto.clinicamedica/
├── ClinicamedicaApplication.java         # Classe principal
├── ConfiguracaoSpringMvc.java            # Configuração de rotas (WebMvcConfigurer)
├── controller/                           # Controladores da aplicação
│   ├── MedicoController.java             
│   ├── PacienteController.java           
│   ├── ConsultaController.java           
│   ├── AgendaController.java             
│   ├── AgendamentoController.java        
│   └── LoginController.java              
├── model/
│   ├── entity/                           # Entidades JPA
│   │   ├── Agenda.java                   
│   │   ├── Agendamento.java              
│   │   ├── Consulta.java                 
│   │   ├── Medico.java                   
│   │   ├── Paciente.java                 
│   │   ├── Perfil.java                   
│   │   ├── Pessoa.java                   
│   │   └── Usuario.java                  
│   ├── repository/                       # Interfaces de repositório
│   │   ├── AgendamentoRepository.java    
│   │   ├── AgendaRepository.java         
│   │   ├── ConsultaRepository.java       
│   │   ├── MedicoRepository.java         
│   │   ├── PacienteRepository.java       
│   │   └── UsuarioRepository.java        
│   └── security/                         # Configurações de segurança
│       ├── SecurityConfiguration.java    
│       └── UsuarioDetailsConfig.java     
└── utils/                                # Utilitários
    └── GeradorSenha.java                 
```

### 📄 Templates Thymeleaf (HTML)

```
src/main/resources/
├── application.properties                
├── static/                               
│   ├── css/                              
│   │   ├── login.css                    
│   │   └── style.css                     
│   ├── js/                              
│   │   └── script.js                     
│   └── img/                              
└── templates/                           
    ├── agenda/ 
    │   ├── form.html 
    │   └── list.html 
    ├── agendamento/
    │   ├── detalhe.html
    │   ├── form.html
    │   ├── list.html  
    │   └── medicos.html     
    ├── consulta/
    │   ├── detalhe.html
    │   ├── form.html
    │   └── list.html                             
    ├── fragments/
    │   ├── footer.html
    │   ├── head.html
    │   ├── header.html
    │   └── layout.html     
    ├── medico/
    │   ├── consulta.html
    │   ├── form.html
    │   └── list.html  
    ├── paciente/
    │   ├── consulta.html
    │   ├── form.html
    │   └── list.html    
    ├── home.html
    └── login.html 
```

## 📦 Dependências (`pom.xml`)

### Principais Dependências

| Dependência                              | Descrição |
|------------------------------------------|-----------|
| `spring-boot-starter-parent`             | Gerenciador padrão de versões do Spring Boot (**v3.1.3**) |
| `spring-boot-starter-data-jpa`           | Integração com JPA e Hibernate |
| `spring-boot-starter-security`           | Segurança e controle de acesso |
| `spring-boot-starter-thymeleaf`          | Template engine HTML |
| `spring-boot-starter-validation`         | Validação de dados com Hibernate Validator |
| `thymeleaf-extras-springsecurity6`       | Controle de acesso nas views |
| `spring-boot-starter-web`                | Suporte ao desenvolvimento web |
| `spring-boot-devtools`                   | Ferramentas para facilitar o desenvolvimento (runtime only) |
| `h2`                                     | Banco de dados em memória (**v2.1.214**) |
| `spring-boot-starter-test`               | Testes com JUnit e Mockito (escopo de teste) |

### Plugin Maven

| Plugin                         | Descrição |
|--------------------------------|-----------|
| `spring-boot-maven-plugin`     | Geração e execução da aplicação Spring Boot via Maven |

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/clinicamedica.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd clinicamedica
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse no navegador:
   ```
   http://localhost:8080
   ```

## 📝 Funcionalidades

- ✅ Cadastro, edição e listagem de **médicos** e suas especialidades  
- ✅ Cadastro, edição e listagem de **pacientes**  
- ✅ Agendamento de **consultas médicas** com vínculo de médico, paciente, data e horário  
- ✅ Sistema de **autenticação com perfis de usuário** (admin, médico, recepcionista)  

## 🔒 Segurança

A aplicação utiliza **Spring Security** para autenticação e autorização, com perfis distintos:

- **ADMIN** – Acesso total ao sistema  
- **MÉDICO** – Visualização de consultas e informações de pacientes  
- **RECEPCIONISTA** – Cadastro de pacientes e agendamento de consultas  

## 🗃️ Modelo de Dados

### Relacionamentos Principais:

- Um **médico** pode realizar várias **consultas**
- Um **paciente** pode participar de várias **consultas**
- Cada **consulta** está associada a um **médico** e um **paciente**
- Cada **médico** possui uma **especialidade**
