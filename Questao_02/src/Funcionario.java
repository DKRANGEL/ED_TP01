public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void aplicarAumento() {
        if (salario >= 1 && salario <= 1000) {
            salario *= 1.15;
        } else if (salario >= 1001 && salario <= 1500) {
            salario *= 1.10;
        } else if (salario >= 1501 && salario <= 2000) {
            salario *= 1.05;
        }
    }
}