package services;

import pet.Pet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeletePet {
    SearchPet searchPet = new SearchPet();
    Scanner input = new Scanner(System.in);
    PetStorage petStorage = new PetStorage();

    public void iniciarDelete() throws IOException {
        System.out.println("Iniciando 'Delete Pet'...");
        System.out.println("Encontre o Pet que deseja deletar: ");
        List<Pet> petsEncontrados = searchPet.retornarListaFiltrada();
        if(petsEncontrados.isEmpty()){
            return;
        }
        searchPet.exibirResultadosBusca(petsEncontrados);

        int escolhaUsuario = lerEscolhaUsuario(petsEncontrados.size());

        Pet petParaDeletar = petsEncontrados.get(escolhaUsuario - 1);

        System.out.println("Tem certeza que deseja deletar "+ petParaDeletar.getNomeCompleto()+"? (SIM/NAO)");
        String confirm = input.nextLine();
        if(confirm.trim().toUpperCase().equalsIgnoreCase("SIM")|| confirm.trim().toUpperCase().equalsIgnoreCase("S")){
            petStorage.deletarPet(petParaDeletar);
            System.out.println("Pet deletado com sucesso.");
        }else{
            System.out.println("Delete cancelado.");
        }
    }

    public int lerEscolhaUsuario(int tamanhoMaximoDaLista){
        int opcao;
        while (true){
            try{
                System.out.println("Digite o número do pet que deseja deletar:");
                String linha = input.nextLine();
                opcao = Integer.parseInt(linha);
                if(opcao >=1 && opcao <=tamanhoMaximoDaLista){
                    return opcao;
                }else{
                    System.out.println("Número inválido. Digite novamente um número entre 1 e "+ tamanhoMaximoDaLista+":");
                }
            } catch (NumberFormatException e){
                System.out.println("Erro. Entrada de dados inválida. Por favor, digite um número de 1 a "+tamanhoMaximoDaLista+".");
            }
        }
    }
}
