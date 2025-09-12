package formreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeitorFormulario {
    public List<String> lerFormulario(){
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
        return null;
    }
}
