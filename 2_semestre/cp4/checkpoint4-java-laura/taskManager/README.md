# 📋 Task Manager - Sistema de Gerenciamento de Tarefas

## 📖 Sobre o Projeto

O **Task Manager** é uma aplicação web desenvolvida em **Spring Boot** para gerenciamento de tarefas e usuários. O sistema permite realizar operações CRUD completas tanto para tarefas quanto para usuários, oferecendo uma interface web intuitiva e moderna.

### 🎯 Objetivos

- Implementar um sistema robusto de gerenciamento de tarefas
- Aplicar conceitos avançados de Spring Boot e JPA/Hibernate
- Desenvolver uma interface web responsiva e user-friendly
- Demonstrar boas práticas de desenvolvimento Java

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17** - Linguagem de programação
- **Spring Boot 3.x** - Framework principal
- **Spring MVC** - Controladores web
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - ORM com cache L2
- **H2 Database** - Banco de dados em memória
- **Lombok** - Redução de boilerplate
- **Bean Validation** - Validação de dados

### Frontend
- **Thymeleaf** - Template engine
- **HTML5** - Estrutura das páginas
- **CSS3** - Estilização com gradientes e animações
- **JavaScript** - Interatividade básica

### Ferramentas
- **Maven** - Gerenciamento de dependências
- **Spring Boot DevTools** - Desenvolvimento ágil

---

## 🏗️ Arquitetura do Sistema

### Estrutura de Pacotes

```
br.com.fiap.tds.twotdspj.javaadv.taskManager
├── controllers/         # Controladores MVC
├── domainmodel/        # Entidades e DTOs
├── service/            # Lógica de negócio
├── datasource/         # Repositórios JPA
├── infrastructure/     # Configurações e runners
└── mapper/            # Mapeamento de dados
```

### Padrões Implementados

- **MVC (Model-View-Controller)** - Separação de responsabilidades
- **Repository Pattern** - Abstração da camada de dados
- **Service Layer** - Lógica de negócio centralizada
- **DTO Pattern** - Transferência segura de dados
- **Builder Pattern** - Construção de objetos complexos

---

## 📊 Funcionalidades

### 👥 Gerenciamento de Usuários
- ✅ Listagem de usuários cadastrados
- ✅ Visualização detalhada de usuário
- ✅ Cadastro de novos usuários
- ✅ Edição de dados do usuário
- ✅ Exclusão de usuários
- ✅ Validação de dados com Bean Validation

### 📋 Gerenciamento de Tarefas
- ✅ Listagem de tarefas por status
- ✅ Visualização detalhada de tarefa
- ✅ Criação de novas tarefas
- ✅ Edição de tarefas existentes
- ✅ Exclusão de tarefas
- ✅ Sistema de prioridades e status

### 🎨 Interface Web
- ✅ Design responsivo para desktop e mobile
- ✅ Navegação intuitiva entre módulos
- ✅ Feedback visual para ações do usuário
- ✅ Formulários com validação em tempo real
- ✅ Botões de ação com ícones e estados hover

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Passos para Execução

1. **Clone o repositório**
   ```bash
   git clone <url-do-repositorio>
   cd taskManager
   ```

2. **Compile o projeto**
   ```bash
   mvn clean compile
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação**
   - URL: http://localhost:8080
   - A aplicação iniciará com 10 usuários pré-cadastrados

### Banco de Dados

O sistema utiliza **H2 Database** em memória, configurado para:
- Console H2: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

---

## 📁 Estrutura de Dados

### Entidade User
```java
@Entity
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    // métodos utilitários...
}
```

### Entidade Task
```java
@Entity
public class Task {
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private User assignedUser;
    // relacionamentos e métodos...
}
```

---

## 🎨 Características da Interface

### Design System
- **Cores Primárias:** Tons de azul (#0d47a1, #1976d2, #2196f3)
- **Tipografia:** Segoe UI, Roboto (modernas e legíveis)
- **Componentes:** Cards, botões com gradientes, tabelas responsivas
- **Animações:** Transições suaves e efeitos hover

### Botões de Ação
- 👁️ **Ver** - Azul (#2563eb)
- ✏️ **Editar** - Laranja (#f59e0b)  
- 🗑️ **Remover** - Vermelho (#dc2626)

---

## ⚙️ Configurações Importantes

### Cache de Segundo Nível
```java
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
```

### Transações Configuradas
```java
@Transactional(isolation = Isolation.READ_COMMITTED, 
               propagation = Propagation.REQUIRES_NEW)
```

### Validações Bean Validation
```java
@NotBlank(message = "O nome do usuário é obrigatório")
@Size(max = 100, message = "O nome deve conter no máximo 100 caracteres")
@Email(message = "Informe um email válido")
```

---

## 📋 Dados de Teste

O sistema inicia automaticamente com 10 usuários cadastrados:

1. Amanda Costa (amanda.costa@empresa.com)
2. Rafael Sousa (rafael.sousa@tech.com)
3. Carla Mendes (carla.mendes@gmail.com)
4. Diego Barbosa (diego.barbosa@outlook.com)
5. Fernanda Lima (fernanda.lima@hotmail.com)
6. Ana Carolina Silva (ana.carolina@example.com)
7. Felipe Rodrigues (felipe.rodrigues@example.com)
8. Camila Ferreira (camila.ferreira@example.com)
9. Gabriel Costa (gabriel.costa@example.com)
10. Larissa Nunes (larissa.nunes@example.com)

---

## 🔧 Próximas Implementações

- [ ] Sistema de autenticação e autorização
- [ ] API REST completa para integração
- [ ] Relatórios de produtividade
- [ ] Notificações em tempo real
- [ ] Dashboard analítico
- [ ] Integração com calendário

---

**Vinicius Saes de Souza**  
**RM:** 554456  
**FIAP - Java Advanced**