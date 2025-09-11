package main;


import formReader.LeitorFormulario;
import services.PrintMainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeitorFormulario leitorFormulario = new LeitorFormulario();
        leitorFormulario.lerFormulario(); // chamar isso para a OPÇÃO 1.


        PrintMainMenu printMainMenu = new PrintMainMenu();
        printMainMenu.imprimirMenuPrincipal();
        int opcao_selecionada = printMainMenu.lerOpcao();
        while(true){
            if (opcao_selecionada == 1){
                
            }
        }
    }
}
