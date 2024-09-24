public class Quarto {
    private int numero;
    private String tipo;
    private double preco;
    private boolean disponivel;

    public Quarto() {
        this.disponivel = true;
    }

    public Quarto(int numero, String tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean reservar(Hospede[] hospedes) {
        if (!disponivel) {
            System.out.println("O quarto " + numero + " já está reservado.");
            return false;
        }

        for (Hospede hospede : hospedes) {
            if (!hospede.verificarMaioridade()) {
                System.out.println("Hóspede " + hospede.getNome() + " não tem mais de 18 anos. Reserva não permitida.");
                return false;
            }
        }

        this.disponivel = false;
        System.out.println("Quarto " + numero + " reservado com sucesso.");
        return true;
    }

    public void cancelarReserva() {
        if (disponivel) {
            System.out.println("O quarto " + numero + " não está reservado.");
        } else {
            //cancela a reserva e define o quarto como disponível
            this.disponivel = true;
            System.out.println("Reserva do quarto " + numero + " foi cancelada.");
        }
    }
}
