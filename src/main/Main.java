package main;


import formreader.LeitorFormulario;
import services.*;

import java.io.IOException;

public class  Main {
    public static void main(String[] args) throws IOException {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        leitorFormulario.lerFormulario(); // chamar isso para a OPÇÃO 1.


        PrintMainMenu printMainMenu = new PrintMainMenu();
        RegisterPet cadastrar = new RegisterPet(); // opcao 1
        UpdatePet updatePet = new UpdatePet();
        SearchPet searchPet = new SearchPet(); // opcao 5
        DeletePet deletePet = new DeletePet();
        int opcao_selecionada;


        do {
            printMainMenu.imprimirMenuPrincipal();
            opcao_selecionada = printMainMenu.lerOpcao();

            switch (opcao_selecionada){
                case 1:
                    cadastrar.registerPet();
                    break;
                case 2:
                    updatePet.iniciarUpdtatePet();
                    break;
                case 3:
                    deletePet.iniciarDelete();
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
