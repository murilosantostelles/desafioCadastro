package pet;

public enum PetGender {
    MACHO,
    FEMEA;


    public static PetGender fromString(String texto){
        for(PetGender genero : PetGender.values()){
            if(genero.name().equalsIgnoreCase(texto)){
                return genero;
            }
        }
        throw new IllegalArgumentException("Genêro Inválido. Digite apenas 'Macho' ou 'Fêmea'.");
    }
}
