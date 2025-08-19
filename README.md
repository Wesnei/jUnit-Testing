
## 📦 Java-Teste

Este é um projeto Java utilizando Maven, com foco em conceitos de orientação a objetos, herança e testes unitários com JUnit.

### 🧠 Objetivo

Demonstrar a modelagem de uma hierarquia de classes de funcionários (`CommissionEmployee`, `BasePlusCommissionEmployee`) e como realizar testes unitários para garantir o funcionamento correto das classes.

---

### 📁 Estrutura do Projeto

```bash
Java-Teste/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           ├── Main.java
│   │           ├── CommissionEmployee.java
│   │           └── BasePlusCommissionEmployee.java
│   │
│   └── test/
│       └── java/
│           └── org/example/
│               ├── CommissionEmployeeTest.java
│               └── BasePlusCommissionEmployeeTest.java
│
├── .gitignore
├── pom.xml
└── README.md
```

---

### 🚀 Como executar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/Java-Teste.git
   cd Java-Teste
   ```

2. **Compile o projeto**:

   ```bash
   mvn compile
   ```

3. **Execute a aplicação (classe Main)**:

   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

4. **Execute os testes**:

   ```bash
   mvn test
   ```

---

### 🧪 Testes

Os testes unitários estão localizados em `src/test/java/org/example/`. Eles cobrem as funcionalidades principais das classes de empregados:

* `CommissionEmployeeTest`
* `BasePlusCommissionEmployeeTest`

---

### 🛠 Tecnologias

* Java
* Maven
* JUnit 5
* IntelliJ IDEA / VS Code

---

### 📄 Licença

Este projeto está sob a licença MIT.


