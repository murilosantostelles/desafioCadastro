package services;

import formreader.LeitorFormulario;
import pet.Pet;
import pet.PetGender;
import pet.PetType;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class RegisterPet {
    Scanner input = new Scanner(System.in);
    public void registerPet() {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        Pet pet01 = new Pet();
        LeitorFormulario leitorPergunta = new LeitorFormulario();
        String[] todasAsPerguntas = leitorPergunta.lerPerguntaForm(1);

        while ((true)){ //Entrada de dados e Validação do nome
            System.out.println(todasAsPerguntas[0]);
            String nomeDigitado = input.nextLine();
            try{
                pet01.setNomeCompleto(nomeDigitado);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("O Pet deve ter um NOME e um SOBRENOME obrigatóriamente. ");
            }
        }
    }
}
