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
├── model/                                # Entidades e modelos
│   ├── Medico.java                       # Entidade médico
│   ├── Paciente.java                     # Entidade paciente
│   ├── Consulta.java                     # Entidade consulta
│   ├── Especialidade.java                # Enum de especialidades médicas
│   └── Usuario.java                      # Entidade usuário para autenticação
├── repository/                           # Interfaces de repositório
│   ├── MedicoRepository.java             # Repositório de médicos
│   ├── PacienteRepository.java           # Repositório de pacientes
│   └── ConsultaRepository.java           # Repositório de consultas
└── service/                              # Camada de serviço
    ├── MedicoService.java                # Serviço de médicos
    ├── PacienteService.java              # Serviço de pacientes
    └── ConsultaService.java              # Serviço de consultas
```

### 📄 Views Thymeleaf (HTML)

```
src/main/resources/
├── application.properties                # Configurações da aplicação
├── static/                               # Recursos estáticos
│   ├── css/                              # Estilos CSS
│   │   ├── bootstrap.min.css             # Framework Bootstrap
│   │   └── style.css                     # Estilos personalizados
│   ├── js/                               # JavaScript
│   │   ├── bootstrap.min.js              # Scripts Bootstrap
│   │   └── scripts.js                    # Scripts personalizados
│   └── img/                              # Imagens do sistema
└── templates/                            # Templates Thymeleaf
    ├── fragments/                        # Fragmentos reutilizáveis
    │   ├── header.html                   # Cabeçalho comum
    │   ├── footer.html                   # Rodapé comum
    │   ├── sidebar.html                  # Barra lateral
    │   └── alert.html                    # Mensagens de alerta
    ├── home.html                         # Página inicial
    ├── login.html                        # Página de login
    ├── medico/                           # Views de médicos
    │   ├── form.html                     # Formulário de cadastro/edição
    │   └── lista.html                    # Listagem de médicos
    ├── paciente/                         # Views de pacientes
    │   ├── form.html                     # Formulário de cadastro/edição
    │   └── lista.html                    # Listagem de pacientes
    └── consulta/                         # Views de consultas
        ├── form.html                     # Formulário de agendamento
        ├── lista.html                    # Listagem de consultas
        └── detalhes.html                 # Detalhes da consulta
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

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir um Pull Request com melhorias ou correções.
