package pet;

public class PetAddress {
    private String numeroCasa;
    private String cidade;
    private String rua;

    public static final String NAO_INFORMADO = "NÃO INFORMADO";


    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        if(numeroCasa == null || numeroCasa.trim().isEmpty() || numeroCasa.trim().equalsIgnoreCase(NAO_INFORMADO)){
            this.numeroCasa = NAO_INFORMADO;
            return;
        }
        if(!numeroCasa.trim().matches("\\d+")){
            throw new IllegalArgumentException("Digite apenas números.");
        }
        this.numeroCasa = numeroCasa.trim();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty()){
            this.cidade = NAO_INFORMADO;
            return;
        }
        if(!cidade.matches("[\\p{L}\\s]+")){
            throw new IllegalArgumentException("A cidade deve conter apenas Letras e Espaços");
        }
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty()){
            this.rua = NAO_INFORMADO;
            return;
        }
        this.rua = rua;
    }
}
