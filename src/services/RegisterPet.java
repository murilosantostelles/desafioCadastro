package services;

import formreader.LeitorFormulario;
import pet.Pet;
import pet.PetGender;
import pet.PetType;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class RegisterPet {
    public void registerPet(){
        Scanner input = new Scanner(System.in);
        File file = new File("src/resources/formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){

            String nomeCompletoColetado = lerNome(br, input);
            //PetType petType = PetType.valueOf(lerPetType(br,input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String lerNome(BufferedReader br, Scanner input)throws IOException{
        String pergunta = br.readLine();
        if (pergunta != null){
            System.out.println(pergunta);
        }
        return input.nextLine();
    }

    private String lerPetType(BufferedReader br, Scanner input)throws IOException{
        PetType pergunta = PetType.valueOf(br.readLine());
        if(pergunta != null){
            System.out.println(pergunta);
        }
        return input.nextLine();
    }


}
