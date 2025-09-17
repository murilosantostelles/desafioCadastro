package main;


import formreader.LeitorFormulario;
import services.PrintMainMenu;
import services.RegisterPet;
import services.SearchPet;

public class Main {
    public static void main(String[] args) {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        leitorFormulario.lerFormulario(); // chamar isso para a OPÇÃO 1.


        PrintMainMenu printMainMenu = new PrintMainMenu();
        RegisterPet cadastrar = new RegisterPet(); // opcao 1
        SearchPet searchPet = new SearchPet(); // opcao 5
        int opcao_selecionada;


        do {
            printMainMenu.imprimirMenuPrincipal();
            opcao_selecionada = printMainMenu.lerOpcao();

            switch (opcao_selecionada){
                case 1:
                    cadastrar.registerPet();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    searchPet.listarTodosOsPets();
                    break;
                case 5:
                    searchPet.iniciarBusca();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao_selecionada != 6);
    }
}
