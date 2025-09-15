package pet;

public enum PetGender {
    MACHO('M'),
    FEMEA('F');


    private final char sigla;

    PetGender(char sigla) {
        this.sigla = sigla;
    }

    public char getSigla() {
        return sigla;
    }

    public static PetGender fromChar(char letra){
        for(PetGender genero : PetGender.values()){
            if(genero.sigla == Character.toUpperCase(letra)){
                return genero;
            }
        }
        throw new IllegalArgumentException("Genêro Inválido. Digite apenas 'M' (para MACHO) ou 'F' (para FÊMEA).");
    }
}
