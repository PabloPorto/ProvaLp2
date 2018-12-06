import java.util.Objects;

public class Ecom {
    private String nomeFantasia;
    private String cnpj;
    private String proprietario;
    private int tipo;
    private double valorArrecadado;

    public Ecom() {
    }

    public Ecom(String nomeFantasia, String cnpj, String proprietario, int tipo) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.proprietario = proprietario;
        this.tipo = tipo;
    }

    private boolean verificaTipoValido(int idTipo){
        boolean validaTipo = false; 
        if (idTipo == 1 || idTipo == 2 || idTipo == 3){
            validaTipo = true;
        }
        return validaTipo;
    }

    public void setTipo(int tipo) {
        if (verificaTipoValido(tipo)) {
            this.tipo = tipo;
        }
    }

    public void setValorArrecadado(double valorArrecadado) {
        this.valorArrecadado += valorArrecadado;
    }

    public int getTipo() {
        return tipo;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ecom)) return false;
        Ecom ecom = (Ecom) o;
        return Objects.equals(cnpj, ecom.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        String representacao = "";
        if (this.tipo == 1){
            representacao = this.nomeFantasia + " * " +
                            this.cnpj + " * " +
                            this.proprietario + " * " + "QUIOSQUE";
        }
        else if(this.tipo == 2) {
            representacao = this.nomeFantasia + " * " +
                            this.cnpj + " * " +
                            this.proprietario + " * " + "BARRACA";
        }
        else if(this.tipo == 3) {
            representacao = this.nomeFantasia + " * " +
                            this.cnpj + " * " +
                            this.proprietario + " * " + "RESTAURANTE";
        }
        else{
            throw new RuntimeException("Tipo inválido!");
        }
        return representacao;
    }
}
