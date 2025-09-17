package services;

import pet.Pet;
import pet.PetAddress;
import pet.PetGender;
import pet.PetType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPet {
    Scanner input = new Scanner(System.in);
    PetStorage petStorage = new PetStorage();
    public void iniciarBusca(){
        System.out.println("Escolha o tipo de Pet que deseja Buscar:");
        int tipoPetEscolhido = lerBuscaCachorroOuGato();
        imprimirMenuTipoDeBusca();
        int tipoBuscaEspecifica = lerTipoDeBuscaEspecifica();

        List<Pet> todosOsPets = petStorage.carregarTodosOsPets();
        System.out.println(todosOsPets);
        int contador = 1;
        for (Pet pet : todosOsPets) {
            System.out.println(contador+". "+pet.exibirDadosDoPetEmLinha());
            contador ++;
        }


    }

    public void listarTodosOsPets(){
        List<Pet> todosOsPets = petStorage.carregarTodosOsPets();
        if(todosOsPets.isEmpty()){
            System.out.println("Não há pets cadastrados no momento.");
            return;
        }
        System.out.println("Lista de Pets");

    }
    /*
    private List<Pet> buscaRefinada(List<Pet> todosOsPets , int tipoPetEscolhido, int tipoBuscaEspecifica){

        System.out.println("Buscando...");
        if(tipoPetEscolhido == 1){
            switch (tipoBuscaEspecifica){
                case 1:
                    String nomeDigitado = input.nextLine();
                    if(todosOsPets.contains(nomeDigitado)){

                    }
            }
        }
    }
    */



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
}
