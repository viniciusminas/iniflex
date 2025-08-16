package br.com.iniflex.main;

import br.com.iniflex.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat formatoSalario = new DecimalFormat("#,##0.00");

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        System.out.println("\n--- Lista de Funcionários ---");
        funcionarios.forEach(f -> {
            String data = f.getDataNascimento().format(formatoData);
            String salario = formatoSalario.format(f.getSalario());
            System.out.printf("%s | %s | R$ %s | %s%n", f.getNome(), data, salario, f.getFuncao());
        });

        funcionarios.forEach(f ->
                f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1.10)).setScale(2, RoundingMode.HALF_UP))
        );

        System.out.println("\n--- Lista de Funcionários após aumento de 10% ---");
        funcionarios.forEach(f -> {
            String data = f.getDataNascimento().format(formatoData);
            String salario = formatoSalario.format(f.getSalario());
            System.out.printf("%s | %s | R$ %s | %s%n", f.getNome(), data, salario, f.getFuncao());
        });

        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\n--- Funcionários agrupados por função ---");
        porFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });

        System.out.println("\n--- Aniversariantes de Outubro e Dezembro ---");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimento().format(formatoData)));

        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\n--- Funcionário mais velho ---");
            System.out.println(maisVelho.getNome() + " - " + idade + " anos");
        }

        System.out.println("\n--- Funcionários em ordem alfabética ---");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));

        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: R$ " + formatoSalario.format(totalSalarios));

        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n--- Salários mínimos por funcionário ---");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " - " + qtd + " salários mínimos");
        });
    }
}
