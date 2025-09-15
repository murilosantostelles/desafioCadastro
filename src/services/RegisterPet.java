package services;

import formreader.LeitorFormulario;
import pet.Pet;
import pet.PetAddress;
import pet.PetGender;
import pet.PetType;
import java.util.Scanner;

public class RegisterPet {
    Scanner input = new Scanner(System.in);
    public void registerPet() {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        Pet pet01 = new Pet();
        PetAddress adress01 = new PetAddress();
        LeitorFormulario leitorPergunta = new LeitorFormulario();
        String[] todasAsPerguntas = leitorPergunta.lerPerguntaForm(1);

        while ((true)){ //Entrada de dados e Validação do nome
            System.out.println(todasAsPerguntas[0]);
            String nomeDigitado = input.nextLine();
            try{
                pet01.setNomeCompleto(nomeDigitado);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)){ //Entrada de dados e Validação do tipo
            System.out.println(todasAsPerguntas[2]);
            String tipoDigitado = input.nextLine();
            try{
                PetType tipoConvertido = PetType.fromString(tipoDigitado);
                pet01.setPetType(tipoConvertido);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)){ //Entrada de dados e Validação do genero
            System.out.println(todasAsPerguntas[4]);
            String generoDigitado = input.nextLine();
            if(generoDigitado != null && generoDigitado.length() == 1){
                char letra = generoDigitado.charAt(0);
                try{
                    PetGender generoConvertido = PetGender.fromChar(letra);
                    pet01.setPetGender(generoConvertido);
                    break;
                } catch (IllegalArgumentException e){
                    System.out.println("Erro: "+ e.getMessage());
                }
            }else{
                System.out.println("Digite apenas 'M' ou 'F'.");
            }
        }
        while ((true)){ //Entrada de dados e Validação do endereço. cidade.
            System.out.println(todasAsPerguntas[6]);
            System.out.println("Cidade: ");
            String cidadeDigitada = input.nextLine();
            try{
                adress01.setCidade(cidadeDigitada);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)) { //Entrada de dados e Validação do endereço. rua.
            System.out.println("Rua: ");
            String ruaDigitada = input.nextLine();
            try{
                adress01.setRua(ruaDigitada);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)) { //Entrada de dados e Validação do endereço. numero da casa.
            System.out.println("Número da Casa: ");
            String numeroCasaDigitado = input.nextLine();
            try{
                adress01.setNumeroCasa(numeroCasaDigitado);
                pet01.setEndereco(adress01);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)){ //Entrada de dados e Validação da idade.
            System.out.println(todasAsPerguntas[8]);
            String idadeDigitada = input.nextLine();
            try{
                pet01.setIdade(idadeDigitada);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)){ //Entrada de dados e Validação do peso.
            System.out.println(todasAsPerguntas[10]);
            String pesoDigitado = input.nextLine();
            try{
                pet01.setPeso(pesoDigitado);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }
        while ((true)){ //Entrada de dados e Validação da raça.
            System.out.println(todasAsPerguntas[12]);
            String racaDigitada = input.nextLine();
            try{
                pet01.setRaca(racaDigitada);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: "+ e.getMessage());
            }
        }

        System.out.println(pet01.toString());
    }
}
