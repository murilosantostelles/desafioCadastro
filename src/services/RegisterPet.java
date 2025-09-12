package services;

import formreader.LeitorFormulario;
import pet.Pet;
import pet.PetGender;
import pet.PetType;

import java.util.List;
import java.util.Scanner;

public class RegisterPet {
    public void registerPet(){
        Scanner leitor = new Scanner(System.in);
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        List<String> perguntas = leitorFormulario.lerFormulario();

        System.out.println(perguntas.get(0));
    }
}
