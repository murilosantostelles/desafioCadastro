package services;

import pet.Pet;
import pet.PetType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SearchPet {
    Scanner input = new Scanner(System.in);
    PetStorage petStorage = new PetStorage();

    public void iniciarBusca(){ // opcao 5 do menu principal (pega o return do metodo abaixo e exibe os pets)
        List<Pet> resultadosBusca = retornarListaFiltrada();
        exibirResultadosBusca(resultadosBusca);
    }

    public List<Pet> retornarListaFiltrada(){
        List<Pet> todosOsPets = petStorage.carregarTodosOsPets();
        if(todosOsPets.isEmpty()){
            System.out.println("Nenhum pet encontrado.");
            return new ArrayList<>();
        }
        System.out.println("Escolha o tipo de Pet que deseja Buscar:");
        int tipoPetEscolhido = lerBuscaCachorroOuGato();
        imprimirMenuTipoDeBusca();
        int tipoBuscaEspecifica = lerTipoDeBuscaEspecifica();

        List<Pet> carregaTodosOsPets = petStorage.carregarTodosOsPets();

        List<Pet> petsFiltrados = buscaRefinada(carregaTodosOsPets,tipoPetEscolhido,tipoBuscaEspecifica);
        return petsFiltrados;
    }

    private List<Pet> buscaRefinada(List<Pet> todosOsPets , int tipoPetEscolhido, int tipoBuscaEspecifica){ //aplicação dos filtros na busca
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
            case 2:
                System.out.println("Digite o Sexo (M/F) para buscar: ");
                String sexoBusca = input.nextLine();
                List<Pet> petsFiltradosPorSexo = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getPetGender().toString().toLowerCase().contains(sexoBusca.toLowerCase())){
                        petsFiltradosPorSexo.add(pet);
                    }
                }
                return petsFiltradosPorSexo;
            case 3:
                System.out.println("Digite a Idade do pet para buscar: ");
                String idadeBusca = input.nextLine();
                List<Pet> petsFiltradosPorIdade = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getIdade().toLowerCase().contains(idadeBusca.toLowerCase())){
                        petsFiltradosPorIdade.add(pet);
                    }
                }
                return petsFiltradosPorIdade;
            case 4:
                System.out.println("Digite o Peso do pet para buscar: ");
                String pesoBusca = input.nextLine();
                List<Pet> petsFiltradosPorPeso = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getPeso().toLowerCase().contains(pesoBusca.toLowerCase())){
                        petsFiltradosPorPeso.add(pet);
                    }
                }
                return petsFiltradosPorPeso;
            case 5:
                System.out.println("Digite a Raça do pet para buscar: ");
                String racaBusca = input.nextLine();
                List<Pet> petsFiltradosPorRaca = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getRaca().toLowerCase().contains(racaBusca.toLowerCase())){
                        petsFiltradosPorRaca.add(pet);
                    }
                }
                return petsFiltradosPorRaca;
            case 6:
                System.out.println("Digite o Endereço do Pet para Buscar: ");
                String enderecoBusca = input.nextLine();
                List<Pet> petsFiltradosPorEndereco = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getEndereco().getCidade().toLowerCase().contains(enderecoBusca) || pet.getEndereco().getRua().toLowerCase().contains(enderecoBusca) ||
                            pet.getEndereco().getNumeroCasa().toLowerCase().contains(enderecoBusca)){
                        petsFiltradosPorEndereco.add(pet);
                    }
                }
                return petsFiltradosPorEndereco;
            case 7:
                System.out.println("Digite o nome para buscar: ");
                String nomeBuscaCombinada = input.nextLine();
                System.out.println("Agora digite a Idade do pet para buscar: ");
                String idadeBuscaCombinada = input.nextLine();
                List<Pet> petsFiltradosPorNomeEIdade = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getNomeCompleto().toLowerCase().contains(nomeBuscaCombinada) && pet.getIdade().contains(idadeBuscaCombinada)){
                        petsFiltradosPorNomeEIdade.add(pet);
                    }
                }
                return petsFiltradosPorNomeEIdade;
            case 8:
                System.out.println("Digite a Idade do Pet para Buscar: ");
                String idadeBuscaCOmbinada2 = input.nextLine();
                System.out.println("Agora digite o Peso do pet para Buscar: ");
                String pesoBuscaCombinada = input.nextLine();
                List<Pet> petsFiltradosPorIdadeEPeso = new ArrayList<>();
                for (Pet pet : petsFiltrados) {
                    if(pet.getIdade().contains(idadeBuscaCOmbinada2) && pet.getPeso().contains(pesoBuscaCombinada)){
                        petsFiltradosPorIdadeEPeso.add(pet);
                    }
                }
                return petsFiltradosPorIdadeEPeso;
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
    public int lerBuscaCachorroOuGato(){ //verifica o tipo escolhido (se é cachorro ou gato)
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

    public void exibirResultadosBusca(List<Pet> todosOsPets){ // exibe o resultado de foma organizada (sem ser no formato do ToString)
        int contador = 1;
        for (Pet pet : todosOsPets) {
            System.out.println(contador+". "+pet.exibirDadosDoPetEmLinha());
            contador++;
        }
    }
}
