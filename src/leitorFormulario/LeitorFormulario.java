package leitorFormulario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeitorFormulario {
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
}
