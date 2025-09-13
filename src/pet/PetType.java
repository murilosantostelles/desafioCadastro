package pet;

public enum PetType {
    CACHORRO ,GATO;

    public static PetType fromString(String texto){
        for(PetType tipo : PetType.values()){
            if(tipo.name().equalsIgnoreCase(texto)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Pet inválido. Digite apenas 'Cachorro' ou 'Gato'");
    }
}
