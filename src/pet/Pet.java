package pet;

public class Pet {
    private String nomeCompleto; // somente caracteres de A-Z. Obrigatorio ter nome e sobrenome.
    private PetType petType;
    private PetGender petGender;
    private String enderecoPet; // numero da casa + cidade + rua
    private double idade; // permitir digitação de vírgula e ponto + tranformar idade em meses em idade em 0.x anos.
    private double peso; //exceção + permitir digitação de vírgula e ponto
    private String raca; // não permitir digitação de número e nem de caracteres epeciais


    public Pet(String nomeCompleto, PetType petType, PetGender petGender) {
        this.nomeCompleto = nomeCompleto;
        this.petType = petType;
        this.petGender = petGender;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public String getEnderecoPet() {
        return enderecoPet;
    }

    public void setEnderecoPet(String enderecoPet) {
        this.enderecoPet = enderecoPet;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
