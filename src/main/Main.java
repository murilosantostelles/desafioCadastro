package main;


import formreader.LeitorFormulario;
import services.PrintMainMenu;
import services.RegisterPet;

public class Main {
    public static void main(String[] args) {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        leitorFormulario.lerFormulario(); // chamar isso para a OPÇÃO 1.


        RegisterPet cadastrar = new RegisterPet();

        PrintMainMenu printMainMenu = new PrintMainMenu();
        int opcao_selecionada;


        do {
            printMainMenu.imprimirMenuPrincipal();
            opcao_selecionada = printMainMenu.lerOpcao();

            switch (opcao_selecionada){
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
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
