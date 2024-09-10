import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();

        Funcionario funcionario = new Funcionario(nome, salario);

        double salarioAntigo = funcionario.getSalario();

        funcionario.aplicarAumento();

        double salarioNovo = funcionario.getSalario();

        System.out.println("Salário antigo: " + salarioAntigo);
        System.out.println("Salário novo: " + salarioNovo);

        scanner.close();
    }
}