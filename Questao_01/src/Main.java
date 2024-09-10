import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade no estoque: ");
        int estoque = scanner.nextInt();

        Produto produto = new Produto(nome, preco, estoque);

        produto.mostrarDados();

        System.out.print("Digite a quantidade para entrada no estoque: ");
        int entrada = scanner.nextInt();
        produto.entradaEstoque(entrada);
        produto.mostrarDados();

        System.out.print("Digite a quantidade para saída no estoque: ");
        int saida = scanner.nextInt();
        produto.saidaEstoque(saida);
        produto.mostrarDados();

        scanner.close();
    }
}