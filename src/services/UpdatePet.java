package services;

import pet.Pet;
import pet.PetAddress;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePet {
    SearchPet searchPet = new SearchPet();
    Scanner input = new Scanner(System.in);
    PetStorage petStorage = new PetStorage();

    public void iniciarUpdtatePet(){
        System.out.println("Iniciando Update Pet...");
        System.out.println("Encontre o Pet que Deseja Alterar");
        List<Pet> petsEncontrados = searchPet.retornarListaFiltrada();
        if(petsEncontrados.isEmpty()){
            return;
        }
        searchPet.exibirResultadosBusca(petsEncontrados);

        int escolhaUsuario = lerEscolhaUsuario(petsEncontrados.size());

        Pet petParaAlterar = petsEncontrados.get(escolhaUsuario - 1); // lista começa no zero
        PetAddress enderecoParaAlterar = petParaAlterar.getEndereco();
        String nomeArquivoAntigo = petParaAlterar.getFileName();

        System.out.println("Pet '"+petParaAlterar.getNomeCompleto()+"' selecionado com sucesso para alterar.");
        System.out.println("Arquivo original: "+ nomeArquivoAntigo);
        menuDeAlteracao(petParaAlterar , enderecoParaAlterar);
    }

    public int lerEscolhaUsuario(int tamanhoMaximoDaLista){
        int opcao;
        while (true){
            try{
                System.out.println("Digite o número do pet que deseja alterar algum dado:");
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
    public void menuDeAlteracao(Pet petParaAlterar , PetAddress enderecoParaAlterar){
        while (true){
            System.out.println("Qual informação de "+petParaAlterar.getNomeCompleto()+" você deseja alterar? ");
            System.out.println("[1] - Nome Completo");
            System.out.println("[2] - Idade");
            System.out.println("[3] - Peso");
            System.out.println("[4] - Raça");
            System.out.println("[5] - Endereço");
            System.out.println("[6] - SALVAR E SAIR");

            int opcao;
            while (true){
                try {
                    String linha = input.nextLine();
                    opcao = Integer.parseInt(linha);
                    if(opcao >= 1 && opcao <= 6){
                        break;
                    }else {
                        System.out.println("Opção inválida. Informe apenas um número de 1 a 6.");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Erro: Entrada de dados inválida. Apenas números de 1 a 6 podem ser inseridos.");
                }
            }
            switch (opcao){
                case 1:
                    while (true){
                        try {
                            System.out.println("Digite o novo Nome Completo: ");
                            String novoNomeCompleto = input.nextLine();
                            petParaAlterar.setNomeCompleto(novoNomeCompleto);
                            System.out.println("Nome Completo alterado com sucesso.");
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case 2:
                    while (true){
                        try{
                            System.out.println("Digite a nova Idade do pet: ");
                            String novaIdade = input.nextLine();
                            petParaAlterar.setIdade(novaIdade);
                            System.out.println("Idade alterada com sucesso.");
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case 3:
                    while (true){
                        try{
                            System.out.println("Digite o novo Peso do pet: ");
                            String novoPeso = input.nextLine();
                            petParaAlterar.setPeso(novoPeso);
                            System.out.println("Peso alterado com sucesso.");
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case 4:
                    while (true){
                        try{
                            System.out.println("Digite a nova Raça do pet: ");
                            String novaRaca = input.nextLine();
                            petParaAlterar.setRaca(novaRaca);
                            System.out.println("Raça alterada com sucesso.");
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case 5:
                    while (true){
                        try {
                            System.out.println("Digite a nova rua do pet: ");
                            String novaRua = input.nextLine();
                            System.out.println("Digite o novo numero da casa do pet: ");
                            String novoNumeroCasa = input.nextLine();
                            System.out.println("Digite a nova cidade do pet: ");
                            String novaCidade = input.nextLine();
                            enderecoParaAlterar.setRua(novaRua);
                            enderecoParaAlterar.setNumeroCasa(novoNumeroCasa);
                            enderecoParaAlterar.setCidade(novaCidade);
                            System.out.println("Endereço alterado com sucesso.");
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Erro: "+e.getMessage());
                        }
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Salvando alterações...");
                        petStorage.atualizarPet(petParaAlterar);
                        System.out.println("Alterações salvas com sucesso.");
                        return;
                    } catch (IOException e){
                        System.out.println("Não foi possível salvar.");
                    }
                    break;
                default:
                    System.out.println("Opção Inválida. Tente novamente.");
            }
        }
    }
}
