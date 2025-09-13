package services;

import formreader.LeitorFormulario;
import pet.Pet;
import pet.PetGender;
import pet.PetType;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class RegisterPet {
    Scanner leitorUsuario = new Scanner(System.in);
    public void registerPet() {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        Pet pet01 = new Pet();

        try (BufferedReader br = leitorFormulario.lerFormulario2();) {
            String nome = lerNome(br,leitorUsuario);
            pet01.setNomeCompleto(nome);

        }catch (IOException e){
            System.out.println("Erro na leitura do formulário.");
            return;
        }
        System.out.println("Cadastro Concluído.");
        System.out.println("Pet "+pet01.getNomeCompleto()+" registrado.");
    }

    public String lerNome(BufferedReader br, Scanner leitorUsuario) throws IOException{
        String pergunta = br.readLine();
        if (pergunta == null) throw new IOException("Arquivo de formulário Inválido");

        String nomeValidado = null;
        Pet petValidador = new Pet();

        while (nomeValidado == null){
            System.out.println(pergunta);
            String input = leitorUsuario.nextLine();
            try {
                petValidador.setNomeCompleto(input);
                nomeValidado = input;
            }catch (IllegalArgumentException e){
                System.out.println("Erro, tente novamente");
            }
        }
        return nomeValidado;
    }
}
