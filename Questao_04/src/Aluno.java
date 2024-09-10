public class Aluno {
    private String nome;
    private double[] notas;

    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new double[3];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNota(int trimestre, double nota) {
        this.notas[trimestre] = nota;
    }

    public double calcularNotaFinal() {
        return notas[0] + notas[1] + notas[2];
    }

    public boolean isAprovado() {
        return calcularNotaFinal() >= 70;
    }

    public double pontosParaAprovacao() {
        return 70 - calcularNotaFinal();
    }
}