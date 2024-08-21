import java.util.Scanner;

import javax.swing.JOptionPane;

public class ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.println("Digite um número: "); 
            int numero = sc.nextInt(); //Type Integer

        sc.nextLine();

            System.out.println("Digite um nome: ");
            String nome = sc.next(); //Type String

        sc.nextLine();

            System.out.println("Digite um peso: ");
            double peso = sc.nextDouble(); //Type Double

            System.out.printf("%nNúmero digitado: %d%n Nome digitado: %s%n Peso digitado: %.2f Kg%n", numero, nome, peso);
        sc.close();
    }

    public static void main_02(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite um nome: ");
        
        JOptionPane.showMessageDialog(null, "Nome digitado: " + nome);

        String entrada1 = JOptionPane.showInputDialog("Digite o número 1: ");
        String entrada2 = JOptionPane.showInputDialog("Digite o número 2: ");

        int numero1 = Integer.parseInt(entrada1);
        int numero2 = Integer.parseInt(entrada2);

        int soma = numero1 + numero2;

        JOptionPane.showMessageDialog(null, "Soma: " + soma);
    }
}