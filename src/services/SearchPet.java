package services;

import pet.Pet;
import pet.PetAddress;
import pet.PetGender;
import pet.PetType;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchPet {
    Scanner input = new Scanner(System.in);
    PetStorage petStorage = new PetStorage();
    public void iniciarBusca(){
        System.out.println("Escolha o tipo de Pet que deseja Buscar:");
        int tipoPetEscolhido = lerBuscaCachorroOuGato();
        imprimirMenuTipoDeBusca();
        int tipoBuscaEspecifica = lerTipoDeBuscaEspecifica();

        List<Pet> todosOsPets = petStorage.carregarTodosOsPets();
        exibirResultadosBusca(buscaRefinada(todosOsPets, tipoPetEscolhido,tipoBuscaEspecifica));
    }

    public void listarTodosOsPets(){ // Exibido quando o usuário aperta 4 no menu (listar todos os pets)
        List<Pet> todosOsPets = petStorage.carregarTodosOsPets();
        if(todosOsPets.isEmpty()){
            System.out.println("Não há pets cadastrados no momento.");
            return;
        }
        System.out.println("-=-=-=-=-LISTA DE PETS-==-=-=-=-");
        int contador = 1;
        for (Pet pet : todosOsPets) {
            System.out.println(contador+". "+pet.exibirDadosDoPetEmLinha());
            contador ++;
        }
        System.out.println(" ");
    }

    private List<Pet> buscaRefinada(List<Pet> todosOsPets , int tipoPetEscolhido, int tipoBuscaEspecifica){
        PetType tipoEscolhido = (tipoPetEscolhido == 1) ? PetType.CACHORRO : PetType.GATO;
        List<Pet> petsFiltrados = new ArrayList<>();

        for (Pet pet : todosOsPets) {
            if(pet.getPetType() == tipoEscolhido){
                petsFiltrados.add(pet);
            }
        }
        switch (tipoBuscaEspecifica){
            case 1:
                System.out.println("Digite o nome para buscar: ");
                String nomeBusca = input.nextLine();
                List<Pet> petsFiltradosPorNome = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getNomeCompleto().toLowerCase().contains(nomeBusca.toLowerCase())){
                        petsFiltradosPorNome.add(pet);
                    }
                }
                return petsFiltradosPorNome;
            default:
                System.out.println("Opção de busca inválida");
                return new ArrayList<>();
        }
    }


    public void imprimirMenuTipoDeBusca(){
        System.out.println("Digite o número abaixo para o respectivo tipo de busca: ");
        System.out.println("[1] - Nome/Sobrenome \n" +
                "[2] - Sexo \n" +
                "[3] - Idade \n" +
                "[4] - Peso \n" +
                "[5] - Raça \n" +
                "[6] - Endereço \n" +
                "[7] - Nome/Sobrenome + Idade \n" +
                "[8] - Idade + Peso" );
    }
    public int lerTipoDeBuscaEspecifica(){
        int opcao;
        while (true){
            try{
                System.out.println("Tipo de busca (1/8): ");
                String linha = input.nextLine();
                opcao = Integer.parseInt(linha);
                if(opcao >=1 && opcao <=8){
                    return opcao;
                }else{
                    System.out.println("Número inválido. Digite novamente um número entre 1 e 8:");
                }
            } catch (NumberFormatException e){
                System.out.println("Erro. Entrada de dados inválida. Por favor, digite um número de 1 a 8.");
            }
        }
    }
    public int lerBuscaCachorroOuGato(){
        int opcao;
        while (true){
            try{
                System.out.println("[1] - Cachorro | [2] - Gato");
                String linha = input.nextLine();
                opcao = Integer.parseInt(linha);
                if(opcao == 1 || opcao == 2){
                    if (opcao ==1){
                        System.out.println("Iniciando busca pelos Pets do tipo: CACHORRO");
                    }else {
                        System.out.println("Iniciando busca pelos Pets do tipo: GATO");
                    }
                    return opcao;
                } else{
                    System.out.println("Número inválido digitado. Digite novamente um número de 1 até 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro. Entrada de dados inválida. Por favor, digite um número de 1 até 2.");
            }
        }
    }
    public void exibirResultadosBusca(List<Pet> todosOsPets){
        int contador = 1;
        for (Pet pet : todosOsPets) {
            System.out.println(contador+". "+pet.exibirDadosDoPetEmLinha());
            contador++;
        }

    }
}
