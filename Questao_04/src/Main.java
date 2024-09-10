import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        Aluno aluno = new Aluno(nome);

        double nota;
        for (int i = 0; i < 3; i++) {
            do {
                System.out.printf("Digite a nota do %dº trimestre: ", i + 1);
                nota = scanner.nextDouble();
                if ((i == 0 && (nota < 0 || nota > 30)) || (i > 0 && (nota < 0 || nota > 35))) {
                    System.out.println("Nota inválida. Tente novamente.");
                }
            } while ((i == 0 && (nota < 0 || nota > 30)) || (i > 0 && (nota < 0 || nota > 35)));
            aluno.setNota(i, nota);
        }

        double notaFinal = aluno.calcularNotaFinal();

        if (aluno.isAprovado()) {
            System.out.printf("Nota final: %.2f\n", notaFinal);
            System.out.println("Aluno aprovado.");
        } else {
            System.out.printf("Nota final: %.2f\n", notaFinal);
            System.out.printf("Aluno reprovado. Faltaram %.2f pontos para aprovação.\n", aluno.pontosParaAprovacao());
        }

        scanner.close();
    }
}