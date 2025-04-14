# 🏥 Projeto Clínica Médica

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-0000FF?style=for-the-badge&logo=h2&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## 📋 Descrição

O projeto **Clínica Médica** é uma aplicação web desenvolvida com Spring MVC para gerenciamento de uma clínica médica. Este sistema permite o cadastro de médicos, pacientes, agendamento de consultas e agendamento de consultas.

## 🔧 Tecnologias Utilizadas

- **Spring Boot** - Framework Java para desenvolvimento de aplicações
- **Spring MVC** - Padrão MVC para desenvolvimento web
- **Spring Data JPA** - Persistência de dados
- **Thymeleaf** - Template engine para views HTML
- **H2 Database** - Banco de dados em memória
- **Maven** - Gerenciamento de dependências

## 🗂️ Estrutura do Projeto

### 📁 Pacotes Java

```
com.ifto.clinicamedica/
├── ClinicamedicaApplication.java         # Classe principal de inicialização
├── ConfiguracaoSpringMvc                 # Classe de Configuracao WebMvcConfigurer com rotas
├── controller/                           # Controladores MVC
│   ├── MedicoController.java             # Controller de médicos
│   ├── PacienteController.java           # Controller de pacientes
│   ├── ConsultaController.java           # Controller de consultas
│   ├── AgendaController.java             # Controller da Agenda
│   ├── AgendamentoController.java        # Controller de Agendamento
│   └── LoginController.java              # Controller da Login
├── model/                                # Modelo da Aplicação (Regra de Negócio)
│   ├── entity/                           # Entidades
│   │   ├── Agenda.java                   # Entidade Agenda
│   │   ├── Agendamento.java              # Entidade Agendamento
│   │   ├── Consulta.java                 # Entidade Consulta
│   │   ├── Medico.java                   # Entidade Medico
│   │   ├── Paciente.java                 # Entidade Paciente
│   │   ├── Perfil.java                   # Entidade Perfil
│   │   ├── Pessoa.java                   # Entidade Pessoa
│   │   └── Usuario.java                  # Entidade Usuario
│   ├── repository/                       # Repositórios
│   │   ├── AgendamentoRepository.java    # Repositório Agendamento
│   │   ├── AgendaRepository.java         # Repositório Agenda
│   │   ├── ConsultaRepository.java       # Repositório Consulta
│   │   ├── MedicoRepository.java         # Repositório Medico
│   │   ├── PacienteRepository.java       # Repositório Paciente
│   │   └── UsuarioRepository.java        # Repositório Usuario
│   └── security/                         # Segurança
│       ├── AgendamentoRepository.java    # Configuração de Segurança
│       └── AgendamentoRepository.java    # Tratamento de Segurança
└── utils/                                # Arquivos úteis
    └── GeradorSenha.java                 # Classe de utilidade para Senha em ambiente dev
```

### 📄 Views Thymeleaf (HTML)

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
    │    ├── form.html 
    │    └── list.html 
    ├── agendamento/
    │    ├── detalhe.html
    |    ├── form.html
    |    ├── list.html  
    │    └── medicos.html     
    ├── consulta/
    │    ├── detalhe.html
    |    ├── form.html
    |    └── list.html                             
    ├── fragments/
    │    ├── footer.html
    |    ├── head.html
    |    ├── header.html
    |    └── layout.html     
    ├── medico/
    │    ├── consulta.html
    |    ├── form.html
    |    └── list.html  
    ├── paciente/
    │    ├── consulta.html
    |    ├── form.html
    |    └── list.html    
    ├── home.html
    └── login.html 
```

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/clinicamedica.git
   ```

2. Entre na pasta do projeto:
   ```bash
   cd clinicamedica
   ```

3. Execute o projeto usando Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação:
   ```
   http://localhost:8080
   ```

## 📝 Funcionalidades Principais

- **Gerenciamento de Médicos**: Cadastro, edição e listagem de médicos e suas especialidades
- **Gerenciamento de Pacientes**: Cadastro, edição e listagem de pacientes
- **Agendamento de Consultas**: Marcação de consultas associando médicos, pacientes, data e horário
- **Sistema de Autenticação**: Controle de acesso com diferentes perfis (admin, médico, recepcionista)

## 🔒 Segurança

O sistema utiliza Spring Security para autenticação e autorização, com diferentes níveis de acesso:

- **ADMIN**: Acesso total ao sistema
- **MEDICO**: Acesso às consultas e prontuários
- **RECEPCIONISTA**: Agendamento de consultas e cadastro de pacientes

## 📊 Modelo de Dados

### Relacionamentos Principais:

- Um médico pode atender **muitas consultas**
- Um paciente pode ter **muitas consultas**
- Uma consulta pertence a **um médico** e **um paciente**
- Cada médico possui **uma especialidade**
