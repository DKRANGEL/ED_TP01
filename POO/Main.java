import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Quarto quarto1 = new Quarto(101, "Suite", 250.0);
        Quarto quarto2 = new Quarto(102, "Standard", 150.0);

        System.out.println("Quartos disponíveis:");
        System.out.println("Quarto 1 - Número: " + quarto1.getNumero() + ", Tipo: " + quarto1.getTipo() + ", Preço: R$" + quarto1.getPreco());
        System.out.println("Quarto 2 - Número: " + quarto2.getNumero() + ", Tipo: " + quarto2.getTipo() + ", Preço: R$" + quarto2.getPreco());

        System.out.println("\nInsira o nome do hóspede:");
        String nomeHospede1 = scanner.nextLine();

        System.out.println("Insira o CPF do hóspede:");
        String cpfHospede1 = scanner.nextLine();

        System.out.println("Insira o ano de nascimento do hóspede:");
        int anoNascimento1 = scanner.nextInt();

        System.out.println("Insira o mês de nascimento do hóspede (1-12):");
        int mesNascimento1 = scanner.nextInt() - 1;

        System.out.println("Insira o dia de nascimento do hóspede:");
        int diaNascimento1 = scanner.nextInt();

        Calendar cal1 = Calendar.getInstance();
        cal1.set(anoNascimento1, mesNascimento1, diaNascimento1);
        Date dataNascimento1 = cal1.getTime();

        Hospede hospede1 = new Hospede(nomeHospede1, cpfHospede1, dataNascimento1);

        scanner.nextLine();

        System.out.println("\nEscolha um quarto para reservar (1 ou 2):");
        int escolhaQuarto = scanner.nextInt();
        Quarto quartoEscolhido = (escolhaQuarto == 1) ? quarto1 : quarto2;

        System.out.println("\nTentando reservar o quarto " + quartoEscolhido.getNumero() + " para " + hospede1.getNome() + "...");
        Hospede[] hospedes = { hospede1 };
        boolean reservaFalhou = !quartoEscolhido.reservar(hospedes);

        if (reservaFalhou) {
            System.out.println("Reserva falhou porque o hóspede não tem mais de 18 anos.");
        } else {
            System.out.println("Reserva realizada com sucesso para " + hospede1.getNome() + ".");

            System.out.println("\nDeseja cancelar a reserva? (sim/nao):");
            scanner.nextLine();
            String cancelarReserva = scanner.nextLine();
            if (cancelarReserva.equalsIgnoreCase("sim")) {
                System.out.println("Cancelando reserva do quarto " + quartoEscolhido.getNumero() + "...");
                quartoEscolhido.cancelarReserva();
                System.out.println("Reserva cancelada.");
            } else {
                System.out.println("Reserva mantida.");
            }
        }

        scanner.close();
    }
}
