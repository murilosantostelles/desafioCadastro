package formreader;

import pet.PetType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LeitorFormulario {
    Scanner leitor = new Scanner(System.in);
    public void lerFormulario(){
        File file = new File("src/resources/formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void lerPergunta1(){
        File file = new File("src/resources/formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha = br.readLine();
            if(linha != null){
                System.out.println(linha);
            }
            String nome = leitor.nextLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
   /*public void lerPergunta2(){
        File file = new File("src/resources/formulario.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha = br.readLine();
            if(linha != null){
                System.out.println(linha);
            }
            PetType petType = PetType.valueOf(leitor.next());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    */
}
