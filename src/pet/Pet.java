package pet;

public class Pet {
    private String nomeCompleto; // somente caracteres de A-Z. Obrigatorio ter nome e sobrenome.
    private PetType petType;
    private PetGender petGender;
    private PetAdress endereco;
    private String idade; // permitir digitação de vírgula e ponto + tranformar idade em meses em idade em 0.x anos.
    private String peso; //exceção + permitir digitação de vírgula e ponto
    private String raca; // não permitir digitação de número e nem de caracteres epeciais

    public static final String NAO_INFORMADO = "NÃO INFORMADO";



    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty() || !nomeCompleto.trim().contains(" "))
            throw new IllegalArgumentException("Por favor, informe NOME e SOBRENOME");
        if(!nomeCompleto.matches("[a-zA-Z\\s]+")){
            throw new IllegalArgumentException("O nome deve conter apenas Letras e Espaços");
        }
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if(idade == null || idade.trim().isEmpty()){
            this.idade = NAO_INFORMADO;
            return;
        }
        try{
            String entradaNormalizada = idade.trim().replace("," , ".");
            double idadeDouble = Double.parseDouble(entradaNormalizada);
            if(idadeDouble > 20 || idadeDouble <= 0){
                throw new IllegalArgumentException("Idade fora do limite estabelecido.");
            }
            this.idade = entradaNormalizada;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Formato inválido. Use apenas números, ou números com ponto ou vírgula.");
        }


    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        if(peso == null || peso.trim().isEmpty()){
            this.peso = NAO_INFORMADO;
            return;
        }
        try {
            String entradaNormalizada = peso.trim().replace("," , ".");
            double pesoDouble = Double.parseDouble(entradaNormalizada);
            if(pesoDouble > 60 || pesoDouble < 0.5){
                throw new IllegalArgumentException("Peso fora do limite estabelecido.");
            }
            this.peso = entradaNormalizada; //testar depois recebendo peso ao invés de entradaNormalizada.
        } catch(NumberFormatException){
            throw new IllegalArgumentException("Formato inválido. Use apenas números, ou números com ponto ou vírgula.");
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if(raca == null || raca.trim().isEmpty()){
            this.raca = NAO_INFORMADO;
            return;
        }
        if(!raca.matches("[a-zA-Z\\s]+")){
            throw new IllegalArgumentException("A raça deve conter apenas Letras e Espaços");
        }
        this.raca = raca;
    }
}
