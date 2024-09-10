public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValorTotal() {
        return preco * estoque;
    }

    public void entradaEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public void saidaEstoque(int quantidade) {
        if (quantidade > estoque) {
            System.out.println("Quantidade informada excede a quantidade disponível no estoque para o produto: " + nome);
        } else {
            this.estoque -= quantidade;
        }
    }

    public void mostrarDados() {
        System.out.println("Produto: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Estoque: " + estoque);
        System.out.println("Valor Total: " + getValorTotal());
    }
}