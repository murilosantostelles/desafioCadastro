package services;

import pet.Pet;
import pet.PetAddress;

import javax.swing.text.DateFormatter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetStorage {
    public void salvarPet(Pet pet01 , PetAddress adress){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String timestamp = localDateTime.format(dtf);
        String nomeFileFormatado = pet01.getNomeCompleto().toUpperCase().replaceAll("\\s+","");
        String nomeCompletoFile = timestamp+"-"+nomeFileFormatado+".txt";
        File fileFinal = new File("/home/usuario/IdeaProjects/desafioCadastro/src/petsCadastrados", nomeCompletoFile);

        try(FileWriter fw = new FileWriter(fileFinal);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(pet01.getNomeCompleto());
            bw.newLine();
            bw.write(pet01.getPetType().toString());
            bw.newLine();
            bw.write(pet01.getPetGender().toString());
            bw.newLine();
            bw.write(adress.getRua() +", "+ adress.getNumeroCasa()+" - "+adress.getCidade());
            bw.newLine();
            bw.write(pet01.getIdade() + " anos");
            bw.newLine();
            bw.write(pet01.getPeso()+"Kg");
            bw.newLine();
            bw.write(pet01.getRaca());
            bw.newLine();

            System.out.println("Pet salvo no arquivo "+fileFinal);
        } catch (IOException e){
            throw new RuntimeException("Erro ao salvar pet no arquivo."+ e);
        }
    }
}

