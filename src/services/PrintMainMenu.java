package services;

import java.util.Scanner;

public class PrintMainMenu {
    public void imprimirMenuPrincipal(){
        System.out.println("-=-=-=SEJA BEM VINDO(A) AO SISTEMA DE CADASTRO DE PETS=-=-=-");
        System.out.println("MENU PRINCIPAL");
        System.out.println("[1] - Cadastrar um novo pet\n" +
                "[2] - Alterar os dados do pet cadastrado\n" +
                "[3] - Deletar um pet cadastrado\n" +
                "[4] - Listar todos os pets cadastrados\n" +
                "[5] - Listar pets por algum critério (idade, nome, raça)\n" +
                "[6] - Sair");
        System.out.println("Selecione uma das opções acima: ");
    }
    public int lerOpcao(){
        Scanner leitor = new Scanner(System.in);
        int opcao;
        while (true){
            try {
                String linha = leitor.nextLine();
                opcao = Integer.parseInt(linha);
                return opcao;
            } catch (NumberFormatException e){
                System.out.println("Erro: Entrada de dados inválida. Apenas números de 1 a 6 podem ser inseridos.");
                imprimirMenuPrincipal();
            }
        }
    }
}
