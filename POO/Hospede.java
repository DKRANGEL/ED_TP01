import java.util.Calendar;
import java.util.Date;

public class Hospede {
    private String nome;
    private String cpf;
    private Date dataNascimento;

    public Hospede() {}

    public Hospede(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Se o mês ou dia de nascimento ainda não passou neste ano, reduz a idade em 1
    public boolean verificarMaioridade() {
        Calendar hoje = Calendar.getInstance();
        Calendar nascimento = Calendar.getInstance();
        nascimento.setTime(this.dataNascimento);

        int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < nascimento.get(Calendar.MONTH) || (hoje.get(Calendar.MONTH) == nascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < nascimento.get(Calendar.DAY_OF_MONTH))) {
            idade--;
        }

        return idade >= 18;
    }
}
