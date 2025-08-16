# 📘 Documentação – Iniflex

## Estrutura do Projeto

### O projeto foi desenvolvido em Java puro, utilizando programação orientada a objetos.
A estrutura de pacotes ficou organizada da seguinte forma:

src
└── br.com.iniflex
├── model
│ ├── Pessoa.java
│ └── Funcionario.java
└── main
└── Principal.java

* Pessoa: classe base com atributos nome e dataNascimento.

* Funcionario: herda de Pessoa, adicionando salario e funcao.

* Principal: contém o método main com toda a lógica pedida no enunciado.

## Funcionalidades Implementadas

### Inserção de funcionários  
Todos os funcionários foram adicionados conforme a tabela do enunciado.

### Remoção do João  
Remoção do funcionário “João” utilizando `removeIf`.

### Impressão formatada  
- Datas exibidas no formato "dd/mm/yyyy"  
- Salário exibido no padrão brasileiro, com separador de milhar e vírgula decimal.

### Aumento de 10% no salário  
Reajuste aplicado em todos os salários com **BigDecimal**.  
A lista é reimpressa mostrando os novos valores.

### Agrupamento por função  
Funcionários agrupados em um `Map`, onde a chave é a função e o valor é a lista de funcionários.

### Aniversariantes  
Listagem de funcionários que fazem aniversário em **outubro (10)** e **dezembro (12)**.

### Funcionário mais velho  
Identificação do funcionário mais velho, exibindo **nome e idade** em anos.

### Ordenação alfabética  
Listagem de funcionários em ordem alfabética pelo nome.

### Total de salários  
Exibição da soma de todos os salários reajustados, com formatação monetária.

### Comparação com salário mínimo  
Considerando salário mínimo de **R$ 1212,00**, o cálculo é feito pela fórmula: qtdSalarios = salarioFuncionario ÷ salarioMinimo


## Tecnologias Utilizadas
- **Java 8+**  
- **BigDecimal** para cálculos financeiros  

---

## Observações
- O projeto foi desenvolvido sem frameworks externos.  

